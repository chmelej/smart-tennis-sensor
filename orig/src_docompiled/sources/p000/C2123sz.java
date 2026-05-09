package p000;

import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: renamed from: sz */
/* JADX INFO: compiled from: ProxyConfiguration.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2123sz {

    /* JADX INFO: renamed from: a */
    public final String f12723a;

    /* JADX INFO: renamed from: b */
    public final int f12724b;

    /* JADX INFO: renamed from: c */
    public final String f12725c;

    /* JADX INFO: renamed from: d */
    public final String f12726d;

    /* JADX INFO: renamed from: e */
    public final Proxy.Type f12727e;

    /* JADX INFO: renamed from: a */
    Proxy m11604a() {
        return new Proxy(this.f12727e, new InetSocketAddress(this.f12723a, this.f12724b));
    }

    /* JADX INFO: renamed from: b */
    amg m11605b() {
        return new amg() { // from class: sz.1
            @Override // p000.amg
            /* JADX INFO: renamed from: a */
            public ane mo1947a(ani aniVar, ang angVar) {
                return angVar.m4448a().m4426f().m4437a("Proxy-Authorization", ams.m2014a(C2123sz.this.f12725c, C2123sz.this.f12726d)).m4437a("Proxy-Connection", "Keep-Alive").m4440b();
            }
        };
    }
}
