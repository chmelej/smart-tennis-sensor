package android.arch.lifecycle;

import java.util.Map;
import p000.AbstractC1762h;
import p000.C0000a;
import p000.C1679e;
import p000.InterfaceC1816j;
import p000.InterfaceC2014p;

/* JADX INFO: loaded from: classes.dex */
public abstract class LiveData<T> {
    private static final Object NOT_SET = new Object();
    static final int START_VERSION = -1;
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private final Object mDataLock = new Object();
    private C1679e<InterfaceC2014p<T>, LiveData<T>.AbstractC0219b> mObservers = new C1679e<>();
    private int mActiveCount = 0;
    private volatile Object mData = NOT_SET;
    private volatile Object mPendingData = NOT_SET;
    private int mVersion = -1;
    private final Runnable mPostValueRunnable = new Runnable() { // from class: android.arch.lifecycle.LiveData.1
        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.lang.Runnable
        public void run() {
            Object obj;
            synchronized (LiveData.this.mDataLock) {
                obj = LiveData.this.mPendingData;
                LiveData.this.mPendingData = LiveData.NOT_SET;
            }
            LiveData.this.setValue(obj);
        }
    };

    public void onActive() {
    }

    public void onInactive() {
    }

    private void considerNotify(LiveData<T>.AbstractC0219b abstractC0219b) {
        if (abstractC0219b.f2027d) {
            if (!abstractC0219b.mo2192a()) {
                abstractC0219b.m2195a(false);
            } else {
                if (abstractC0219b.f2028e >= this.mVersion) {
                    return;
                }
                abstractC0219b.f2028e = this.mVersion;
                abstractC0219b.f2026c.onChanged((T) this.mData);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchingValue(LiveData<T>.AbstractC0219b abstractC0219b) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (abstractC0219b != null) {
                considerNotify(abstractC0219b);
                abstractC0219b = null;
            } else {
                C1679e<InterfaceC2014p<T>, LiveData<T>.AbstractC0219b>.d dVarM8924c = this.mObservers.m8924c();
                while (dVarM8924c.hasNext()) {
                    considerNotify((AbstractC0219b) dVarM8924c.next().getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public void observe(InterfaceC1816j interfaceC1816j, InterfaceC2014p<T> interfaceC2014p) {
        if (interfaceC1816j.getLifecycle().mo9592a() == AbstractC1762h.b.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(interfaceC1816j, interfaceC2014p);
        LiveData<T>.AbstractC0219b abstractC0219bMo8831a = this.mObservers.mo8831a(interfaceC2014p, lifecycleBoundObserver);
        if (abstractC0219bMo8831a != null && !abstractC0219bMo8831a.mo2193a(interfaceC1816j)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0219bMo8831a != null) {
            return;
        }
        interfaceC1816j.getLifecycle().mo9593a(lifecycleBoundObserver);
    }

    public void observeForever(InterfaceC2014p<T> interfaceC2014p) {
        C0218a c0218a = new C0218a(interfaceC2014p);
        LiveData<T>.AbstractC0219b abstractC0219bMo8831a = this.mObservers.mo8831a(interfaceC2014p, c0218a);
        if (abstractC0219bMo8831a != null && (abstractC0219bMo8831a instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (abstractC0219bMo8831a != null) {
            return;
        }
        c0218a.m2195a(true);
    }

    public void removeObserver(InterfaceC2014p<T> interfaceC2014p) {
        assertMainThread("removeObserver");
        LiveData<T>.AbstractC0219b abstractC0219bMo8832b = this.mObservers.mo8832b(interfaceC2014p);
        if (abstractC0219bMo8832b == null) {
            return;
        }
        abstractC0219bMo8832b.mo2194b();
        abstractC0219bMo8832b.m2195a(false);
    }

    public void removeObservers(InterfaceC1816j interfaceC1816j) {
        assertMainThread("removeObservers");
        for (Map.Entry<InterfaceC2014p<T>, LiveData<T>.AbstractC0219b> entry : this.mObservers) {
            if (entry.getValue().mo2193a(interfaceC1816j)) {
                removeObserver(entry.getKey());
            }
        }
    }

    protected void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            C0000a.m0a().mo2b(this.mPostValueRunnable);
        }
    }

    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    public T getValue() {
        T t = (T) this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    int getVersion() {
        return this.mVersion;
    }

    public boolean hasObservers() {
        return this.mObservers.m8921a() > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.AbstractC0219b implements GenericLifecycleObserver {

        /* JADX INFO: renamed from: a */
        final InterfaceC1816j f2023a;

        LifecycleBoundObserver(InterfaceC1816j interfaceC1816j, InterfaceC2014p<T> interfaceC2014p) {
            super(interfaceC2014p);
            this.f2023a = interfaceC1816j;
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0219b
        /* JADX INFO: renamed from: a */
        boolean mo2192a() {
            return this.f2023a.getLifecycle().mo9592a().m9595a(AbstractC1762h.b.STARTED);
        }

        @Override // android.arch.lifecycle.GenericLifecycleObserver
        /* JADX INFO: renamed from: a */
        public void mo2185a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar) {
            if (this.f2023a.getLifecycle().mo9592a() == AbstractC1762h.b.DESTROYED) {
                LiveData.this.removeObserver(this.f2026c);
            } else {
                m2195a(mo2192a());
            }
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0219b
        /* JADX INFO: renamed from: a */
        boolean mo2193a(InterfaceC1816j interfaceC1816j) {
            return this.f2023a == interfaceC1816j;
        }

        @Override // android.arch.lifecycle.LiveData.AbstractC0219b
        /* JADX INFO: renamed from: b */
        void mo2194b() {
            this.f2023a.getLifecycle().mo9594b(this);
        }
    }

    /* JADX INFO: renamed from: android.arch.lifecycle.LiveData$b */
    abstract class AbstractC0219b {

        /* JADX INFO: renamed from: c */
        final InterfaceC2014p<T> f2026c;

        /* JADX INFO: renamed from: d */
        boolean f2027d;

        /* JADX INFO: renamed from: e */
        int f2028e = -1;

        /* JADX INFO: renamed from: a */
        abstract boolean mo2192a();

        /* JADX INFO: renamed from: a */
        boolean mo2193a(InterfaceC1816j interfaceC1816j) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        void mo2194b() {
        }

        AbstractC0219b(InterfaceC2014p<T> interfaceC2014p) {
            this.f2026c = interfaceC2014p;
        }

        /* JADX INFO: renamed from: a */
        void m2195a(boolean z) {
            if (z == this.f2027d) {
                return;
            }
            this.f2027d = z;
            boolean z2 = LiveData.this.mActiveCount == 0;
            LiveData.this.mActiveCount += this.f2027d ? 1 : -1;
            if (z2 && this.f2027d) {
                LiveData.this.onActive();
            }
            if (LiveData.this.mActiveCount == 0 && !this.f2027d) {
                LiveData.this.onInactive();
            }
            if (this.f2027d) {
                LiveData.this.dispatchingValue(this);
            }
        }
    }

    /* JADX INFO: renamed from: android.arch.lifecycle.LiveData$a */
    class C0218a extends LiveData<T>.AbstractC0219b {
        @Override // android.arch.lifecycle.LiveData.AbstractC0219b
        /* JADX INFO: renamed from: a */
        boolean mo2192a() {
            return true;
        }

        C0218a(InterfaceC2014p<T> interfaceC2014p) {
            super(interfaceC2014p);
        }
    }

    private static void assertMainThread(String str) {
        if (C0000a.m0a().mo3b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }
}
