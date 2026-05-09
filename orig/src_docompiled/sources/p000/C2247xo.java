package p000;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: xo */
/* JADX INFO: compiled from: MarkableInputStream.java */
/* JADX INFO: loaded from: classes.dex */
final class C2247xo extends InputStream {

    /* JADX INFO: renamed from: a */
    private final InputStream f13530a;

    /* JADX INFO: renamed from: b */
    private long f13531b;

    /* JADX INFO: renamed from: c */
    private long f13532c;

    /* JADX INFO: renamed from: d */
    private long f13533d;

    /* JADX INFO: renamed from: e */
    private long f13534e;

    public C2247xo(InputStream inputStream) {
        this(inputStream, 4096);
    }

    public C2247xo(InputStream inputStream, int i) {
        this.f13534e = -1L;
        this.f13530a = inputStream.markSupported() ? inputStream : new BufferedInputStream(inputStream, i);
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f13534e = m12292a(i);
    }

    /* JADX INFO: renamed from: a */
    public long m12292a(int i) {
        long j = this.f13531b + ((long) i);
        if (this.f13533d < j) {
            m12291b(j);
        }
        return this.f13531b;
    }

    /* JADX INFO: renamed from: b */
    private void m12291b(long j) {
        try {
            if (this.f13532c < this.f13531b && this.f13531b <= this.f13533d) {
                this.f13530a.reset();
                this.f13530a.mark((int) (j - this.f13532c));
                m12290a(this.f13532c, this.f13531b);
            } else {
                this.f13532c = this.f13531b;
                this.f13530a.mark((int) (j - this.f13531b));
            }
            this.f13533d = j;
        } catch (IOException e) {
            throw new IllegalStateException("Unable to mark: " + e);
        }
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        m12293a(this.f13534e);
    }

    /* JADX INFO: renamed from: a */
    public void m12293a(long j) throws IOException {
        if (this.f13531b > this.f13533d || j < this.f13532c) {
            throw new IOException("Cannot reset");
        }
        this.f13530a.reset();
        m12290a(this.f13532c, j);
        this.f13531b = j;
    }

    /* JADX INFO: renamed from: a */
    private void m12290a(long j, long j2) throws IOException {
        while (j < j2) {
            long jSkip = this.f13530a.skip(j2 - j);
            if (jSkip == 0) {
                if (read() == -1) {
                    return;
                } else {
                    jSkip = 1;
                }
            }
            j += jSkip;
        }
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f13530a.read();
        if (i != -1) {
            this.f13531b++;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) throws IOException {
        int i = this.f13530a.read(bArr);
        if (i != -1) {
            this.f13531b += (long) i;
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f13530a.read(bArr, i, i2);
        if (i3 != -1) {
            this.f13531b += (long) i3;
        }
        return i3;
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        long jSkip = this.f13530a.skip(j);
        this.f13531b += jSkip;
        return jSkip;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f13530a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f13530a.close();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f13530a.markSupported();
    }
}
