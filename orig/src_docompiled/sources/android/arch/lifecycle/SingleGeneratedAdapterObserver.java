package android.arch.lifecycle;

import p000.AbstractC1762h;
import p000.InterfaceC1735g;
import p000.InterfaceC1816j;

/* JADX INFO: loaded from: classes.dex */
public class SingleGeneratedAdapterObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final InterfaceC1735g f2033a;

    public SingleGeneratedAdapterObserver(InterfaceC1735g interfaceC1735g) {
        this.f2033a = interfaceC1735g;
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo2185a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar) {
        this.f2033a.m9350a(interfaceC1816j, aVar, false, null);
        this.f2033a.m9350a(interfaceC1816j, aVar, true, null);
    }
}
