package p000;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import p000.C2105sh;

/* JADX INFO: renamed from: qj */
/* JADX INFO: compiled from: BaseDiscCache.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2053qj implements InterfaceC2052qi {

    /* JADX INFO: renamed from: a */
    public static final Bitmap.CompressFormat f12337a = Bitmap.CompressFormat.PNG;

    /* JADX INFO: renamed from: b */
    protected final File f12338b;

    /* JADX INFO: renamed from: c */
    protected final File f12339c;

    /* JADX INFO: renamed from: d */
    protected final InterfaceC2059qp f12340d;

    /* JADX INFO: renamed from: e */
    protected int f12341e = 32768;

    /* JADX INFO: renamed from: f */
    protected Bitmap.CompressFormat f12342f = f12337a;

    /* JADX INFO: renamed from: g */
    protected int f12343g = 100;

    public AbstractC2053qj(File file, File file2, InterfaceC2059qp interfaceC2059qp) {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (interfaceC2059qp == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        this.f12338b = file;
        this.f12339c = file2;
        this.f12340d = interfaceC2059qp;
    }

    @Override // p000.InterfaceC2051qh
    /* JADX INFO: renamed from: a */
    public File mo11202a(String str) {
        return m11205b(str);
    }

    @Override // p000.InterfaceC2051qh
    /* JADX INFO: renamed from: a */
    public boolean mo11204a(String str, InputStream inputStream, C2105sh.a aVar) throws Throwable {
        boolean zM11519a;
        File fileM11205b = m11205b(str);
        File file = new File(fileM11205b.getAbsolutePath() + ".tmp");
        try {
            try {
                zM11519a = C2105sh.m11519a(inputStream, new BufferedOutputStream(new FileOutputStream(file), this.f12341e), aVar, this.f12341e);
                try {
                    C2105sh.m11517a((Closeable) inputStream);
                    if (zM11519a && !file.renameTo(fileM11205b)) {
                        zM11519a = false;
                    }
                    if (!zM11519a) {
                        file.delete();
                    }
                    return zM11519a;
                } catch (Throwable th) {
                    th = th;
                    C2105sh.m11517a((Closeable) inputStream);
                    if (zM11519a && !file.renameTo(fileM11205b)) {
                        zM11519a = false;
                    }
                    if (!zM11519a) {
                        file.delete();
                    }
                    throw th;
                }
            } finally {
            }
        } catch (Throwable th2) {
            th = th2;
            zM11519a = false;
        }
    }

    @Override // p000.InterfaceC2051qh
    /* JADX INFO: renamed from: a */
    public boolean mo11203a(String str, Bitmap bitmap) {
        File fileM11205b = m11205b(str);
        File file = new File(fileM11205b.getAbsolutePath() + ".tmp");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.f12341e);
        try {
            boolean zCompress = bitmap.compress(this.f12342f, this.f12343g, bufferedOutputStream);
            C2105sh.m11517a(bufferedOutputStream);
            if (zCompress && !file.renameTo(fileM11205b)) {
                zCompress = false;
            }
            if (!zCompress) {
                file.delete();
            }
            bitmap.recycle();
            return zCompress;
        } catch (Throwable th) {
            C2105sh.m11517a(bufferedOutputStream);
            file.delete();
            throw th;
        }
    }

    /* JADX INFO: renamed from: b */
    protected File m11205b(String str) {
        String strMo11263a = this.f12340d.mo11263a(str);
        File file = this.f12338b;
        if (!this.f12338b.exists() && !this.f12338b.mkdirs() && this.f12339c != null && (this.f12339c.exists() || this.f12339c.mkdirs())) {
            file = this.f12339c;
        }
        return new File(file, strMo11263a);
    }
}
