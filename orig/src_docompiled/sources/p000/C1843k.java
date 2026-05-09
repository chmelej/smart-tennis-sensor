package p000;

import android.arch.lifecycle.GenericLifecycleObserver;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import p000.AbstractC1762h;

/* JADX INFO: renamed from: k */
/* JADX INFO: compiled from: LifecycleRegistry.java */
/* JADX INFO: loaded from: classes.dex */
public class C1843k extends AbstractC1762h {

    /* JADX INFO: renamed from: c */
    private final WeakReference<InterfaceC1816j> f10854c;

    /* JADX INFO: renamed from: a */
    private C1652d<InterfaceC1789i, a> f10852a = new C1652d<>();

    /* JADX INFO: renamed from: d */
    private int f10855d = 0;

    /* JADX INFO: renamed from: e */
    private boolean f10856e = false;

    /* JADX INFO: renamed from: f */
    private boolean f10857f = false;

    /* JADX INFO: renamed from: g */
    private ArrayList<AbstractC1762h.b> f10858g = new ArrayList<>();

    /* JADX INFO: renamed from: b */
    private AbstractC1762h.b f10853b = AbstractC1762h.b.INITIALIZED;

    public C1843k(InterfaceC1816j interfaceC1816j) {
        this.f10854c = new WeakReference<>(interfaceC1816j);
    }

    /* JADX INFO: renamed from: a */
    public void m10071a(AbstractC1762h.b bVar) {
        m10061b(bVar);
    }

    /* JADX INFO: renamed from: a */
    public void m10070a(AbstractC1762h.a aVar) {
        m10061b(m10060b(aVar));
    }

    /* JADX INFO: renamed from: b */
    private void m10061b(AbstractC1762h.b bVar) {
        if (this.f10853b == bVar) {
            return;
        }
        this.f10853b = bVar;
        if (this.f10856e || this.f10855d != 0) {
            this.f10857f = true;
            return;
        }
        this.f10856e = true;
        m10068d();
        this.f10856e = false;
    }

    /* JADX INFO: renamed from: b */
    private boolean m10063b() {
        if (this.f10852a.m8921a() == 0) {
            return true;
        }
        AbstractC1762h.b bVar = this.f10852a.m8925d().getValue().f10861a;
        AbstractC1762h.b bVar2 = this.f10852a.m8926e().getValue().f10861a;
        return bVar == bVar2 && this.f10853b == bVar2;
    }

    /* JADX INFO: renamed from: c */
    private AbstractC1762h.b m10064c(InterfaceC1789i interfaceC1789i) {
        Map.Entry<InterfaceC1789i, a> entryM8834d = this.f10852a.m8834d(interfaceC1789i);
        return m10058a(m10058a(this.f10853b, entryM8834d != null ? entryM8834d.getValue().f10861a : null), this.f10858g.isEmpty() ? null : this.f10858g.get(this.f10858g.size() - 1));
    }

    @Override // p000.AbstractC1762h
    /* JADX INFO: renamed from: a */
    public void mo9593a(InterfaceC1789i interfaceC1789i) {
        InterfaceC1816j interfaceC1816j;
        a aVar = new a(interfaceC1789i, this.f10853b == AbstractC1762h.b.DESTROYED ? AbstractC1762h.b.DESTROYED : AbstractC1762h.b.INITIALIZED);
        if (this.f10852a.mo8831a(interfaceC1789i, aVar) == null && (interfaceC1816j = this.f10854c.get()) != null) {
            boolean z = this.f10855d != 0 || this.f10856e;
            AbstractC1762h.b bVarM10064c = m10064c(interfaceC1789i);
            this.f10855d++;
            while (aVar.f10861a.compareTo(bVarM10064c) < 0 && this.f10852a.m8833c(interfaceC1789i)) {
                m10066c(aVar.f10861a);
                aVar.m10072a(interfaceC1816j, m10069e(aVar.f10861a));
                m10065c();
                bVarM10064c = m10064c(interfaceC1789i);
            }
            if (!z) {
                m10068d();
            }
            this.f10855d--;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m10065c() {
        this.f10858g.remove(this.f10858g.size() - 1);
    }

    /* JADX INFO: renamed from: c */
    private void m10066c(AbstractC1762h.b bVar) {
        this.f10858g.add(bVar);
    }

    @Override // p000.AbstractC1762h
    /* JADX INFO: renamed from: b */
    public void mo9594b(InterfaceC1789i interfaceC1789i) {
        this.f10852a.mo8832b(interfaceC1789i);
    }

    @Override // p000.AbstractC1762h
    /* JADX INFO: renamed from: a */
    public AbstractC1762h.b mo9592a() {
        return this.f10853b;
    }

    /* JADX INFO: renamed from: b */
    static AbstractC1762h.b m10060b(AbstractC1762h.a aVar) {
        switch (aVar) {
            case ON_CREATE:
            case ON_STOP:
                return AbstractC1762h.b.CREATED;
            case ON_START:
            case ON_PAUSE:
                return AbstractC1762h.b.STARTED;
            case ON_RESUME:
                return AbstractC1762h.b.RESUMED;
            case ON_DESTROY:
                return AbstractC1762h.b.DESTROYED;
            default:
                throw new IllegalArgumentException("Unexpected event value " + aVar);
        }
    }

    /* JADX INFO: renamed from: d */
    private static AbstractC1762h.a m10067d(AbstractC1762h.b bVar) {
        switch (bVar) {
            case INITIALIZED:
                throw new IllegalArgumentException();
            case CREATED:
                return AbstractC1762h.a.ON_DESTROY;
            case STARTED:
                return AbstractC1762h.a.ON_STOP;
            case RESUMED:
                return AbstractC1762h.a.ON_PAUSE;
            case DESTROYED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    /* JADX INFO: renamed from: e */
    private static AbstractC1762h.a m10069e(AbstractC1762h.b bVar) {
        switch (bVar) {
            case INITIALIZED:
            case DESTROYED:
                return AbstractC1762h.a.ON_CREATE;
            case CREATED:
                return AbstractC1762h.a.ON_START;
            case STARTED:
                return AbstractC1762h.a.ON_RESUME;
            case RESUMED:
                throw new IllegalArgumentException();
            default:
                throw new IllegalArgumentException("Unexpected state value " + bVar);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10059a(InterfaceC1816j interfaceC1816j) {
        C1679e<InterfaceC1789i, a>.d dVarC = this.f10852a.m8924c();
        while (dVarC.hasNext() && !this.f10857f) {
            Map.Entry next = dVarC.next();
            a aVar = (a) next.getValue();
            while (aVar.f10861a.compareTo(this.f10853b) < 0 && !this.f10857f && this.f10852a.m8833c((InterfaceC1789i) next.getKey())) {
                m10066c(aVar.f10861a);
                aVar.m10072a(interfaceC1816j, m10069e(aVar.f10861a));
                m10065c();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10062b(InterfaceC1816j interfaceC1816j) {
        Iterator<Map.Entry<InterfaceC1789i, a>> itB = this.f10852a.m8923b();
        while (itB.hasNext() && !this.f10857f) {
            Map.Entry<InterfaceC1789i, a> next = itB.next();
            a value = next.getValue();
            while (value.f10861a.compareTo(this.f10853b) > 0 && !this.f10857f && this.f10852a.m8833c(next.getKey())) {
                AbstractC1762h.a aVarM10067d = m10067d(value.f10861a);
                m10066c(m10060b(aVarM10067d));
                value.m10072a(interfaceC1816j, aVarM10067d);
                m10065c();
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m10068d() {
        InterfaceC1816j interfaceC1816j = this.f10854c.get();
        if (interfaceC1816j == null) {
            Log.w("LifecycleRegistry", "LifecycleOwner is garbage collected, you shouldn't try dispatch new events from it.");
            return;
        }
        while (!m10063b()) {
            this.f10857f = false;
            if (this.f10853b.compareTo(this.f10852a.m8925d().getValue().f10861a) < 0) {
                m10062b(interfaceC1816j);
            }
            Map.Entry<InterfaceC1789i, a> entryE = this.f10852a.m8926e();
            if (!this.f10857f && entryE != null && this.f10853b.compareTo(entryE.getValue().f10861a) > 0) {
                m10059a(interfaceC1816j);
            }
        }
        this.f10857f = false;
    }

    /* JADX INFO: renamed from: a */
    static AbstractC1762h.b m10058a(AbstractC1762h.b bVar, AbstractC1762h.b bVar2) {
        return (bVar2 == null || bVar2.compareTo(bVar) >= 0) ? bVar : bVar2;
    }

    /* JADX INFO: renamed from: k$a */
    /* JADX INFO: compiled from: LifecycleRegistry.java */
    static class a {

        /* JADX INFO: renamed from: a */
        AbstractC1762h.b f10861a;

        /* JADX INFO: renamed from: b */
        GenericLifecycleObserver f10862b;

        a(InterfaceC1789i interfaceC1789i, AbstractC1762h.b bVar) {
            this.f10862b = C1897m.m10464a(interfaceC1789i);
            this.f10861a = bVar;
        }

        /* JADX INFO: renamed from: a */
        void m10072a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar) {
            AbstractC1762h.b bVarM10060b = C1843k.m10060b(aVar);
            this.f10861a = C1843k.m10058a(this.f10861a, bVarM10060b);
            this.f10862b.mo2185a(interfaceC1816j, aVar);
            this.f10861a = bVarM10060b;
        }
    }
}
