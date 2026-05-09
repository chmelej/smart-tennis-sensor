package p000;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* JADX INFO: renamed from: qn */
/* JADX INFO: compiled from: StrictLineReader.java */
/* JADX INFO: loaded from: classes.dex */
class C2057qn implements Closeable {

    /* JADX INFO: renamed from: a */
    private final InputStream f12388a;

    /* JADX INFO: renamed from: b */
    private final Charset f12389b;

    /* JADX INFO: renamed from: c */
    private byte[] f12390c;

    /* JADX INFO: renamed from: d */
    private int f12391d;

    /* JADX INFO: renamed from: e */
    private int f12392e;

    public C2057qn(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public C2057qn(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        }
        if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        }
        if (!charset.equals(C2058qo.f12394a)) {
            throw new IllegalArgumentException("Unsupported encoding");
        }
        this.f12388a = inputStream;
        this.f12389b = charset;
        this.f12390c = new byte[i];
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this.f12388a) {
            if (this.f12390c != null) {
                this.f12390c = null;
                this.f12388a.close();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0035  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String m11260a() {
        /*
            r7 = this;
            java.io.InputStream r0 = r7.f12388a
            monitor-enter(r0)
            byte[] r1 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            if (r1 != 0) goto Lf
            java.io.IOException r1 = new java.io.IOException     // Catch: java.lang.Throwable -> L97
            java.lang.String r2 = "LineReader is closed"
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L97
            throw r1     // Catch: java.lang.Throwable -> L97
        Lf:
            int r1 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r2 = r7.f12392e     // Catch: java.lang.Throwable -> L97
            if (r1 < r2) goto L18
            r7.m11259b()     // Catch: java.lang.Throwable -> L97
        L18:
            int r1 = r7.f12391d     // Catch: java.lang.Throwable -> L97
        L1a:
            int r2 = r7.f12392e     // Catch: java.lang.Throwable -> L97
            r3 = 10
            if (r1 == r2) goto L51
            byte[] r2 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            r2 = r2[r1]     // Catch: java.lang.Throwable -> L97
            if (r2 != r3) goto L4e
            int r2 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            if (r1 == r2) goto L35
            byte[] r2 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            int r3 = r1 + (-1)
            r2 = r2[r3]     // Catch: java.lang.Throwable -> L97
            r4 = 13
            if (r2 != r4) goto L35
            goto L36
        L35:
            r3 = r1
        L36:
            java.lang.String r2 = new java.lang.String     // Catch: java.lang.Throwable -> L97
            byte[] r4 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            int r5 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r6 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r3 = r3 - r6
            java.nio.charset.Charset r6 = r7.f12389b     // Catch: java.lang.Throwable -> L97
            java.lang.String r6 = r6.name()     // Catch: java.lang.Throwable -> L97
            r2.<init>(r4, r5, r3, r6)     // Catch: java.lang.Throwable -> L97
            int r1 = r1 + 1
            r7.f12391d = r1     // Catch: java.lang.Throwable -> L97
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L97
            return r2
        L4e:
            int r1 = r1 + 1
            goto L1a
        L51:
            qn$1 r1 = new qn$1     // Catch: java.lang.Throwable -> L97
            int r2 = r7.f12392e     // Catch: java.lang.Throwable -> L97
            int r4 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r2 = r2 - r4
            int r2 = r2 + 80
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L97
        L5d:
            byte[] r2 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            int r4 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r5 = r7.f12392e     // Catch: java.lang.Throwable -> L97
            int r6 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r5 = r5 - r6
            r1.write(r2, r4, r5)     // Catch: java.lang.Throwable -> L97
            r2 = -1
            r7.f12392e = r2     // Catch: java.lang.Throwable -> L97
            r7.m11259b()     // Catch: java.lang.Throwable -> L97
            int r2 = r7.f12391d     // Catch: java.lang.Throwable -> L97
        L71:
            int r4 = r7.f12392e     // Catch: java.lang.Throwable -> L97
            if (r2 == r4) goto L5d
            byte[] r4 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            r4 = r4[r2]     // Catch: java.lang.Throwable -> L97
            if (r4 != r3) goto L94
            int r3 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            if (r2 == r3) goto L8a
            byte[] r3 = r7.f12390c     // Catch: java.lang.Throwable -> L97
            int r4 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r5 = r7.f12391d     // Catch: java.lang.Throwable -> L97
            int r5 = r2 - r5
            r1.write(r3, r4, r5)     // Catch: java.lang.Throwable -> L97
        L8a:
            int r2 = r2 + 1
            r7.f12391d = r2     // Catch: java.lang.Throwable -> L97
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L97
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L97
            return r1
        L94:
            int r2 = r2 + 1
            goto L71
        L97:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L97
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2057qn.m11260a():java.lang.String");
    }

    /* JADX INFO: renamed from: b */
    private void m11259b() throws IOException {
        int i = this.f12388a.read(this.f12390c, 0, this.f12390c.length);
        if (i == -1) {
            throw new EOFException();
        }
        this.f12391d = 0;
        this.f12392e = i;
    }
}
