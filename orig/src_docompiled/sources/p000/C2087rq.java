package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import p000.InterfaceC2094rx;

/* JADX INFO: renamed from: rq */
/* JADX INFO: compiled from: BaseImageDecoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C2087rq implements InterfaceC2088rr {

    /* JADX INFO: renamed from: a */
    protected final boolean f12600a;

    public C2087rq(boolean z) {
        this.f12600a = z;
    }

    @Override // p000.InterfaceC2088rr
    /* JADX INFO: renamed from: a */
    public Bitmap mo11461a(C2089rs c2089rs) throws Throwable {
        InputStream inputStreamM11465b;
        InputStream inputStreamM11466b = m11466b(c2089rs);
        try {
            b bVarM11464a = m11464a(inputStreamM11466b, c2089rs);
            inputStreamM11465b = m11465b(inputStreamM11466b, c2089rs);
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamM11465b, null, m11462a(bVarM11464a.f12603a, c2089rs));
                C2105sh.m11517a((Closeable) inputStreamM11465b);
                if (bitmapDecodeStream == null) {
                    C2106si.m11527d("Image can't be decoded [%s]", c2089rs.m11470a());
                    return bitmapDecodeStream;
                }
                return m11460a(bitmapDecodeStream, c2089rs, bVarM11464a.f12604b.f12601a, bVarM11464a.f12604b.f12602b);
            } catch (Throwable th) {
                th = th;
                C2105sh.m11517a((Closeable) inputStreamM11465b);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            inputStreamM11465b = inputStreamM11466b;
        }
    }

    /* JADX INFO: renamed from: b */
    protected InputStream m11466b(C2089rs c2089rs) {
        return c2089rs.m11475f().mo11393a(c2089rs.m11471b(), c2089rs.m11476g());
    }

    /* JADX INFO: renamed from: a */
    protected b m11464a(InputStream inputStream, C2089rs c2089rs) {
        a aVar;
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(inputStream, null, options);
        String strM11471b = c2089rs.m11471b();
        if (c2089rs.m11477h() && m11459a(strM11471b, options.outMimeType)) {
            aVar = m11463a(strM11471b);
        } else {
            aVar = new a();
        }
        return new b(new C2079ri(options.outWidth, options.outHeight, aVar.f12601a), aVar);
    }

    /* JADX INFO: renamed from: a */
    private boolean m11459a(String str, String str2) {
        return "image/jpeg".equalsIgnoreCase(str2) && InterfaceC2094rx.a.m11489a(str) == InterfaceC2094rx.a.FILE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    protected a m11463a(String str) {
        int i = 0;
        boolean z = 1;
        try {
        } catch (IOException unused) {
            C2106si.m11526c("Can't read EXIF tags from file [%s]", str);
        }
        switch (new ExifInterface(InterfaceC2094rx.a.FILE.m11492c(str)).getAttributeInt("Orientation", 1)) {
            case 1:
            default:
                z = 0;
                break;
            case 2:
                break;
            case 3:
                z = i;
                i = 180;
                break;
            case 4:
                i = 1;
                z = i;
                i = 180;
                break;
            case 5:
                i = 1;
                z = i;
                i = 270;
                break;
            case 6:
                z = i;
                i = 90;
                break;
            case 7:
                i = 1;
                z = i;
                i = 90;
                break;
            case 8:
                z = i;
                i = 270;
                break;
        }
        return new a(i, z);
    }

    /* JADX INFO: renamed from: a */
    protected BitmapFactory.Options m11462a(C2079ri c2079ri, C2089rs c2089rs) {
        int iM11514a;
        EnumC2078rh enumC2078rhM11473d = c2089rs.m11473d();
        if (enumC2078rhM11473d == EnumC2078rh.NONE) {
            iM11514a = 1;
        } else if (enumC2078rhM11473d == EnumC2078rh.NONE_SAFE) {
            iM11514a = C2104sg.m11513a(c2079ri);
        } else {
            iM11514a = C2104sg.m11514a(c2079ri, c2089rs.m11472c(), c2089rs.m11474e(), enumC2078rhM11473d == EnumC2078rh.IN_SAMPLE_POWER_OF_2);
        }
        if (iM11514a > 1 && this.f12600a) {
            C2106si.m11522a("Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]", c2079ri, c2079ri.m11435a(iM11514a), Integer.valueOf(iM11514a), c2089rs.m11470a());
        }
        BitmapFactory.Options optionsM11478i = c2089rs.m11478i();
        optionsM11478i.inSampleSize = iM11514a;
        return optionsM11478i;
    }

    /* JADX INFO: renamed from: b */
    protected InputStream m11465b(InputStream inputStream, C2089rs c2089rs) {
        try {
            inputStream.reset();
            return inputStream;
        } catch (IOException unused) {
            C2105sh.m11517a((Closeable) inputStream);
            return m11466b(c2089rs);
        }
    }

    /* JADX INFO: renamed from: a */
    protected Bitmap m11460a(Bitmap bitmap, C2089rs c2089rs, int i, boolean z) {
        Matrix matrix = new Matrix();
        EnumC2078rh enumC2078rhM11473d = c2089rs.m11473d();
        if (enumC2078rhM11473d == EnumC2078rh.EXACTLY || enumC2078rhM11473d == EnumC2078rh.EXACTLY_STRETCHED) {
            C2079ri c2079ri = new C2079ri(bitmap.getWidth(), bitmap.getHeight(), i);
            float fM11516b = C2104sg.m11516b(c2079ri, c2089rs.m11472c(), c2089rs.m11474e(), enumC2078rhM11473d == EnumC2078rh.EXACTLY_STRETCHED);
            if (Float.compare(fM11516b, 1.0f) != 0) {
                matrix.setScale(fM11516b, fM11516b);
                if (this.f12600a) {
                    C2106si.m11522a("Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]", c2079ri, c2079ri.m11434a(fM11516b), Float.valueOf(fM11516b), c2089rs.m11470a());
                }
            }
        }
        if (z) {
            matrix.postScale(-1.0f, 1.0f);
            if (this.f12600a) {
                C2106si.m11522a("Flip image horizontally [%s]", c2089rs.m11470a());
            }
        }
        if (i != 0) {
            matrix.postRotate(i);
            if (this.f12600a) {
                C2106si.m11522a("Rotate image on %1$d° [%2$s]", Integer.valueOf(i), c2089rs.m11470a());
            }
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        if (bitmapCreateBitmap != bitmap) {
            bitmap.recycle();
        }
        return bitmapCreateBitmap;
    }

    /* JADX INFO: renamed from: rq$a */
    /* JADX INFO: compiled from: BaseImageDecoder.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        public final int f12601a;

        /* JADX INFO: renamed from: b */
        public final boolean f12602b;

        protected a() {
            this.f12601a = 0;
            this.f12602b = false;
        }

        protected a(int i, boolean z) {
            this.f12601a = i;
            this.f12602b = z;
        }
    }

    /* JADX INFO: renamed from: rq$b */
    /* JADX INFO: compiled from: BaseImageDecoder.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final C2079ri f12603a;

        /* JADX INFO: renamed from: b */
        public final a f12604b;

        protected b(C2079ri c2079ri, a aVar) {
            this.f12603a = c2079ri;
            this.f12604b = aVar;
        }
    }
}
