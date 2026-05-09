package android.arch.lifecycle;

import p000.AbstractC1762h;
import p000.C1928n;
import p000.InterfaceC1735g;
import p000.InterfaceC1816j;

/* JADX INFO: loaded from: classes.dex */
public class CompositeGeneratedAdaptersObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final InterfaceC1735g[] f2019a;

    public CompositeGeneratedAdaptersObserver(InterfaceC1735g[] interfaceC1735gArr) {
        this.f2019a = interfaceC1735gArr;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo2185a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar) {
        C1928n c1928n = new C1928n();
        for (InterfaceC1735g interfaceC1735g : this.f2019a) {
            interfaceC1735g.m9350a(interfaceC1816j, aVar, false, c1928n);
        }
        for (InterfaceC1735g interfaceC1735g2 : this.f2019a) {
            interfaceC1735g2.m9350a(interfaceC1816j, aVar, true, c1928n);
        }
    }
}
