package p000;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: renamed from: re */
/* JADX INFO: compiled from: ContentLengthInputStream.java */
/* JADX INFO: loaded from: classes.dex */
public class C2075re extends InputStream {

    /* JADX INFO: renamed from: a */
    private final InputStream f12555a;

    /* JADX INFO: renamed from: b */
    private final int f12556b;

    public C2075re(InputStream inputStream, int i) {
        this.f12555a = inputStream;
        this.f12556b = i;
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f12556b;
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f12555a.close();
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f12555a.mark(i);
    }

    @Override // java.io.InputStream
    public int read() {
        return this.f12555a.read();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        return this.f12555a.read(bArr);
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) {
        return this.f12555a.read(bArr, i, i2);
    }

    @Override // java.io.InputStream
    public void reset() throws IOException {
        this.f12555a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f12555a.skip(j);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f12555a.markSupported();
    }
}
