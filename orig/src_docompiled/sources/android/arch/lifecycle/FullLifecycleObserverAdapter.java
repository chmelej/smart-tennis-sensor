package android.arch.lifecycle;

import p000.AbstractC1762h;
import p000.InterfaceC1816j;

/* JADX INFO: loaded from: classes.dex */
public class FullLifecycleObserverAdapter implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final FullLifecycleObserver f2020a;

    public FullLifecycleObserverAdapter(FullLifecycleObserver fullLifecycleObserver) {
        this.f2020a = fullLifecycleObserver;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo2185a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar) {
        switch (aVar) {
            case ON_CREATE:
                this.f2020a.m2186a(interfaceC1816j);
                return;
            case ON_START:
                this.f2020a.m2187b(interfaceC1816j);
                return;
            case ON_RESUME:
                this.f2020a.m2188c(interfaceC1816j);
                return;
            case ON_PAUSE:
                this.f2020a.m2189d(interfaceC1816j);
                return;
            case ON_STOP:
                this.f2020a.m2190e(interfaceC1816j);
                return;
            case ON_DESTROY:
                this.f2020a.m2191f(interfaceC1816j);
                return;
            case ON_ANY:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
            default:
                return;
        }
    }
}
