package p000;

import android.graphics.Bitmap;
import android.net.NetworkInfo;
import java.io.IOException;
import java.io.InputStream;
import p000.AbstractC2258xz;
import p000.C2253xu;
import p000.InterfaceC2243xk;

/* JADX INFO: renamed from: xs */
/* JADX INFO: compiled from: NetworkRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2251xs extends AbstractC2258xz {

    /* JADX INFO: renamed from: a */
    private final InterfaceC2243xk f13552a;

    /* JADX INFO: renamed from: b */
    private final C2261yb f13553b;

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    int mo12301a() {
        return 2;
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: b */
    boolean mo12303b() {
        return true;
    }

    public C2251xs(InterfaceC2243xk interfaceC2243xk, C2261yb c2261yb) {
        this.f13552a = interfaceC2243xk;
        this.f13553b = c2261yb;
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        String scheme = c2256xx.f13609d.getScheme();
        return "http".equals(scheme) || "https".equals(scheme);
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) throws a {
        InterfaceC2243xk.a aVarMo12284a = this.f13552a.mo12284a(c2256xx.f13609d, c2256xx.f13608c);
        if (aVarMo12284a == null) {
            return null;
        }
        C2253xu.d dVar = aVarMo12284a.f13518c ? C2253xu.d.DISK : C2253xu.d.NETWORK;
        Bitmap bitmapM12286b = aVarMo12284a.m12286b();
        if (bitmapM12286b != null) {
            return new AbstractC2258xz.a(bitmapM12286b, dVar);
        }
        InputStream inputStreamM12285a = aVarMo12284a.m12285a();
        if (inputStreamM12285a == null) {
            return null;
        }
        if (dVar == C2253xu.d.DISK && aVarMo12284a.m12287c() == 0) {
            C2265yf.m12392a(inputStreamM12285a);
            throw new a("Received response with 0 content-length header.");
        }
        if (dVar == C2253xu.d.NETWORK && aVarMo12284a.m12287c() > 0) {
            this.f13553b.m12364a(aVarMo12284a.m12287c());
        }
        return new AbstractC2258xz.a(inputStreamM12285a, dVar);
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    boolean mo12302a(boolean z, NetworkInfo networkInfo) {
        return networkInfo == null || networkInfo.isConnected();
    }

    /* JADX INFO: renamed from: xs$a */
    /* JADX INFO: compiled from: NetworkRequestHandler.java */
    static class a extends IOException {
        public a(String str) {
            super(str);
        }
    }
}
