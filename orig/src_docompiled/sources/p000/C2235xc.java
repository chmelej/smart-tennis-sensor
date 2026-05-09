package p000;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import p000.AbstractC2258xz;
import p000.C2253xu;

/* JADX INFO: renamed from: xc */
/* JADX INFO: compiled from: AssetRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2235xc extends AbstractC2258xz {

    /* JADX INFO: renamed from: a */
    private static final int f13459a = "file:///android_asset/".length();

    /* JADX INFO: renamed from: b */
    private final AssetManager f13460b;

    public C2235xc(Context context) {
        this.f13460b = context.getAssets();
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        Uri uri = c2256xx.f13609d;
        return "file".equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) {
        return new AbstractC2258xz.a(this.f13460b.open(m12222b(c2256xx)), C2253xu.d.DISK);
    }

    /* JADX INFO: renamed from: b */
    static String m12222b(C2256xx c2256xx) {
        return c2256xx.f13609d.toString().substring(f13459a);
    }
}
