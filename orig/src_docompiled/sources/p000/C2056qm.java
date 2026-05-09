package p000;

import android.graphics.Bitmap;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import p000.C2055ql;
import p000.C2105sh;

/* JADX INFO: renamed from: qm */
/* JADX INFO: compiled from: LruDiscCache.java */
/* JADX INFO: loaded from: classes.dex */
public class C2056qm implements InterfaceC2052qi {

    /* JADX INFO: renamed from: a */
    public static final Bitmap.CompressFormat f12381a = Bitmap.CompressFormat.PNG;

    /* JADX INFO: renamed from: b */
    protected C2055ql f12382b;

    /* JADX INFO: renamed from: c */
    protected final InterfaceC2059qp f12383c;

    /* JADX INFO: renamed from: d */
    protected int f12384d = 32768;

    /* JADX INFO: renamed from: e */
    protected Bitmap.CompressFormat f12385e = f12381a;

    /* JADX INFO: renamed from: f */
    protected int f12386f = 100;

    /* JADX INFO: renamed from: g */
    private File f12387g;

    public C2056qm(File file, File file2, InterfaceC2059qp interfaceC2059qp, long j, int i) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("cacheDir argument must be not null");
        }
        if (j < 0) {
            throw new IllegalArgumentException("cacheMaxSize argument must be positive number");
        }
        if (i < 0) {
            throw new IllegalArgumentException("cacheMaxFileCount argument must be positive number");
        }
        if (interfaceC2059qp == null) {
            throw new IllegalArgumentException("fileNameGenerator argument must be not null");
        }
        long j2 = j == 0 ? Long.MAX_VALUE : j;
        int i2 = i == 0 ? Integer.MAX_VALUE : i;
        this.f12387g = file2;
        this.f12383c = interfaceC2059qp;
        m11256a(file, file2, j2, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m11256a(File file, File file2, long j, int i) throws IOException {
        try {
            this.f12382b = C2055ql.m11209a(file, 1, 1, j, i);
        } catch (IOException e) {
            C2106si.m11523a(e);
            if (file2 != null) {
                m11256a(file2, null, j, i);
            }
            if (this.f12382b == null) {
                throw e;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x002f  */
    @Override // p000.InterfaceC2051qh
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.io.File mo11202a(java.lang.String r4) throws java.lang.Throwable {
        /*
            r3 = this;
            r0 = 0
            ql r1 = r3.f12382b     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e
            java.lang.String r4 = r3.m11257b(r4)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e
            ql$c r4 = r1.m11230a(r4)     // Catch: java.lang.Throwable -> L1c java.io.IOException -> L1e
            if (r4 != 0) goto Le
            goto L14
        Le:
            r1 = 0
            java.io.File r1 = r4.m11255a(r1)     // Catch: java.io.IOException -> L1a java.lang.Throwable -> L29
            r0 = r1
        L14:
            if (r4 == 0) goto L19
            r4.close()
        L19:
            return r0
        L1a:
            r1 = move-exception
            goto L20
        L1c:
            r4 = move-exception
            goto L2d
        L1e:
            r1 = move-exception
            r4 = r0
        L20:
            p000.C2106si.m11523a(r1)     // Catch: java.lang.Throwable -> L29
            if (r4 == 0) goto L28
            r4.close()
        L28:
            return r0
        L29:
            r0 = move-exception
            r2 = r0
            r0 = r4
            r4 = r2
        L2d:
            if (r0 == 0) goto L32
            r0.close()
        L32:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2056qm.mo11202a(java.lang.String):java.io.File");
    }

    @Override // p000.InterfaceC2051qh
    /* JADX INFO: renamed from: a */
    public boolean mo11204a(String str, InputStream inputStream, C2105sh.a aVar) {
        C2055ql.a aVarM11232b = this.f12382b.m11232b(m11257b(str));
        if (aVarM11232b == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(aVarM11232b.m11238a(0), this.f12384d);
        try {
            boolean zM11519a = C2105sh.m11519a(inputStream, bufferedOutputStream, aVar, this.f12384d);
            C2105sh.m11517a(bufferedOutputStream);
            if (zM11519a) {
                aVarM11232b.m11239a();
            } else {
                aVarM11232b.m11240b();
            }
            return zM11519a;
        } catch (Throwable th) {
            C2105sh.m11517a(bufferedOutputStream);
            aVarM11232b.m11240b();
            throw th;
        }
    }

    @Override // p000.InterfaceC2051qh
    /* JADX INFO: renamed from: a */
    public boolean mo11203a(String str, Bitmap bitmap) {
        C2055ql.a aVarM11232b = this.f12382b.m11232b(m11257b(str));
        if (aVarM11232b == null) {
            return false;
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(aVarM11232b.m11238a(0), this.f12384d);
        try {
            boolean zCompress = bitmap.compress(this.f12385e, this.f12386f, bufferedOutputStream);
            if (zCompress) {
                aVarM11232b.m11239a();
            } else {
                aVarM11232b.m11240b();
            }
            return zCompress;
        } finally {
            C2105sh.m11517a(bufferedOutputStream);
        }
    }

    /* JADX INFO: renamed from: b */
    private String m11257b(String str) {
        return this.f12383c.mo11263a(str);
    }
}
