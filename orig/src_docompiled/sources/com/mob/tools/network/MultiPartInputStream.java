package com.mob.tools.network;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class MultiPartInputStream extends InputStream {
    private int curIs;
    private ArrayList<InputStream> isList = new ArrayList<>();

    MultiPartInputStream() {
    }

    public void addInputStream(InputStream inputStream) {
        this.isList.add(inputStream);
    }

    private boolean isEmpty() {
        return this.isList == null || this.isList.size() <= 0;
    }

    @Override // java.io.InputStream
    public int available() {
        if (isEmpty()) {
            return 0;
        }
        return this.isList.get(this.curIs).available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        Iterator<InputStream> it = this.isList.iterator();
        while (it.hasNext()) {
            it.next().close();
        }
    }

    @Override // java.io.InputStream
    public long skip(long j) throws IOException {
        throw new IOException();
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        if (isEmpty()) {
            return -1;
        }
        int i = this.isList.get(this.curIs).read();
        while (i < 0) {
            this.curIs++;
            if (this.curIs >= this.isList.size()) {
                break;
            }
            i = this.isList.get(this.curIs).read();
        }
        return i;
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (isEmpty()) {
            return -1;
        }
        int i3 = this.isList.get(this.curIs).read(bArr, i, i2);
        while (i3 < 0) {
            this.curIs++;
            if (this.curIs >= this.isList.size()) {
                break;
            }
            i3 = this.isList.get(this.curIs).read(bArr, i, i2);
        }
        return i3;
    }
}
