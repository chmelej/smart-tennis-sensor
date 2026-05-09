package p000;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.FileNotFoundException;
import p000.AbstractC2258xz;
import p000.C2253xu;

/* JADX INFO: renamed from: ya */
/* JADX INFO: compiled from: ResourceRequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
class C2260ya extends AbstractC2258xz {

    /* JADX INFO: renamed from: a */
    private final Context f13657a;

    C2260ya(Context context) {
        this.f13657a = context;
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public boolean mo12224a(C2256xx c2256xx) {
        if (c2256xx.f13610e != 0) {
            return true;
        }
        return "android.resource".equals(c2256xx.f13609d.getScheme());
    }

    @Override // p000.AbstractC2258xz
    /* JADX INFO: renamed from: a */
    public AbstractC2258xz.a mo12223a(C2256xx c2256xx, int i) throws FileNotFoundException {
        Resources resourcesM12382a = C2265yf.m12382a(this.f13657a, c2256xx);
        return new AbstractC2258xz.a(m12360a(resourcesM12382a, C2265yf.m12379a(resourcesM12382a, c2256xx), c2256xx), C2253xu.d.DISK);
    }

    /* JADX INFO: renamed from: a */
    private static Bitmap m12360a(Resources resources, int i, C2256xx c2256xx) {
        BitmapFactory.Options optionsC = m12353c(c2256xx);
        if (m12352a(optionsC)) {
            BitmapFactory.decodeResource(resources, i, optionsC);
            m12351a(c2256xx.f13613h, c2256xx.f13614i, optionsC, c2256xx);
        }
        return BitmapFactory.decodeResource(resources, i, optionsC);
    }
}
