package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class ByteCounterInputStream extends InputStream {

    /* JADX INFO: renamed from: is */
    private InputStream f9020is;
    private OnReadListener listener;
    private long readBytes;

    public ByteCounterInputStream(InputStream inputStream) {
        this.f9020is = inputStream;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        int i = this.f9020is.read();
        if (i >= 0) {
            this.readBytes++;
            if (this.listener != null) {
                this.listener.onRead(this.readBytes);
            }
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        int i3 = this.f9020is.read(bArr, i, i2);
        if (i3 > 0) {
            this.readBytes += (long) i3;
            if (this.listener != null) {
                this.listener.onRead(this.readBytes);
            }
        }
        return i3;
    }

    @Override // java.io.InputStream
    public void mark(int i) {
        this.f9020is.mark(i);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f9020is.markSupported();
    }

    @Override // java.io.InputStream
    public synchronized void reset() {
        this.f9020is.reset();
        this.readBytes = 0L;
    }

    @Override // java.io.InputStream
    public long skip(long j) {
        return this.f9020is.skip(j);
    }

    @Override // java.io.InputStream
    public int available() {
        return this.f9020is.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f9020is.close();
    }

    public void setOnInputStreamReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }
}
