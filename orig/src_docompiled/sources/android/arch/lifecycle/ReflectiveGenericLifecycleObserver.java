package android.arch.lifecycle;

import p000.AbstractC1762h;
import p000.C1708f;
import p000.InterfaceC1816j;

/* JADX INFO: loaded from: classes.dex */
public class ReflectiveGenericLifecycleObserver implements GenericLifecycleObserver {

    /* JADX INFO: renamed from: a */
    private final Object f2030a;

    /* JADX INFO: renamed from: b */
    private final C1708f.a f2031b;

    public ReflectiveGenericLifecycleObserver(Object obj) {
        this.f2030a = obj;
        this.f2031b = C1708f.f9750a.m9137b(this.f2030a.getClass());
    }

    @Override // android.arch.lifecycle.GenericLifecycleObserver
    /* JADX INFO: renamed from: a */
    public void mo2185a(InterfaceC1816j interfaceC1816j, AbstractC1762h.a aVar) {
        this.f2031b.m9139a(interfaceC1816j, aVar, this.f2030a);
    }
}
