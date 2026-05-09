package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import java.io.InputStream;
import p000.C2253xu;

/* JADX INFO: renamed from: xz */
/* JADX INFO: compiled from: RequestHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2258xz {
    /* JADX INFO: renamed from: a */
    int mo12301a() {
        return 0;
    }

    /* JADX INFO: renamed from: a */
    public abstract a mo12223a(C2256xx c2256xx, int i);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo12224a(C2256xx c2256xx);

    /* JADX INFO: renamed from: a */
    boolean mo12302a(boolean z, NetworkInfo networkInfo) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    boolean mo12303b() {
        return false;
    }

    /* JADX INFO: renamed from: xz$a */
    /* JADX INFO: compiled from: RequestHandler.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        private final C2253xu.d f13652a;

        /* JADX INFO: renamed from: b */
        private final Bitmap f13653b;

        /* JADX INFO: renamed from: c */
        private final InputStream f13654c;

        /* JADX INFO: renamed from: d */
        private final int f13655d;

        public a(Bitmap bitmap, C2253xu.d dVar) {
            this((Bitmap) C2265yf.m12384a(bitmap, "bitmap == null"), null, dVar, 0);
        }

        public a(InputStream inputStream, C2253xu.d dVar) {
            this(null, (InputStream) C2265yf.m12384a(inputStream, "stream == null"), dVar, 0);
        }

        a(Bitmap bitmap, InputStream inputStream, C2253xu.d dVar, int i) {
            if (!((inputStream != null) ^ (bitmap != null))) {
                throw new AssertionError();
            }
            this.f13653b = bitmap;
            this.f13654c = inputStream;
            this.f13652a = (C2253xu.d) C2265yf.m12384a(dVar, "loadedFrom == null");
            this.f13655d = i;
        }

        /* JADX INFO: renamed from: a */
        public Bitmap m12354a() {
            return this.f13653b;
        }

        /* JADX INFO: renamed from: b */
        public InputStream m12355b() {
            return this.f13654c;
        }

        /* JADX INFO: renamed from: c */
        public C2253xu.d m12356c() {
            return this.f13652a;
        }

        /* JADX INFO: renamed from: d */
        int m12357d() {
            return this.f13655d;
        }
    }

    /* JADX INFO: renamed from: c */
    static BitmapFactory.Options m12353c(C2256xx c2256xx) {
        boolean zM12333d = c2256xx.m12333d();
        boolean z = c2256xx.f13622q != null;
        BitmapFactory.Options options = null;
        if (zM12333d || z) {
            options = new BitmapFactory.Options();
            options.inJustDecodeBounds = zM12333d;
            if (z) {
                options.inPreferredConfig = c2256xx.f13622q;
            }
        }
        return options;
    }

    /* JADX INFO: renamed from: a */
    static boolean m12352a(BitmapFactory.Options options) {
        return options != null && options.inJustDecodeBounds;
    }

    /* JADX INFO: renamed from: a */
    static void m12351a(int i, int i2, BitmapFactory.Options options, C2256xx c2256xx) {
        m12350a(i, i2, options.outWidth, options.outHeight, options, c2256xx);
    }

    /* JADX INFO: renamed from: a */
    static void m12350a(int i, int i2, int i3, int i4, BitmapFactory.Options options, C2256xx c2256xx) {
        int iMin;
        if (i4 <= i2 && i3 <= i) {
            iMin = 1;
        } else if (i2 == 0) {
            iMin = (int) Math.floor(i3 / i);
        } else if (i == 0) {
            iMin = (int) Math.floor(i4 / i2);
        } else {
            int iFloor = (int) Math.floor(i4 / i2);
            int iFloor2 = (int) Math.floor(i3 / i);
            if (c2256xx.f13616k) {
                iMin = Math.max(iFloor, iFloor2);
            } else {
                iMin = Math.min(iFloor, iFloor2);
            }
        }
        options.inSampleSize = iMin;
        options.inJustDecodeBounds = false;
    }
}
