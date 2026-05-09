package p000;

import android.content.Context;
import android.media.ExifInterface;
import android.net.Uri;
import p000.AbstractC2258xz;
import p000.C2253xu;

/* JADX INFO: renamed from: xl */
/* JADX INFO: compiled from: FileRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2244xl extends C2240xh {
    C2244xl(Context context) {
        super(context);
    }

    @Override // p000.C2240xh, p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        return "file".equals(c2256xx.f13609d.getScheme());
    }

    @Override // p000.C2240xh, p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) {
        return new AbstractC2258xz.a(null, m12258b(c2256xx), C2253xu.d.DISK, m12288a(c2256xx.f13609d));
    }

    /* JADX INFO: renamed from: a */
    static int m12288a(Uri uri) {
        int attributeInt = new ExifInterface(uri.getPath()).getAttributeInt("Orientation", 1);
        if (attributeInt == 3) {
            return 180;
        }
        if (attributeInt != 6) {
            return attributeInt != 8 ? 0 : 270;
        }
        return 90;
    }
}
