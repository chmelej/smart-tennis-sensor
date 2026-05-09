package p000;

import java.io.Closeable;
import java.io.Flushable;

/* JADX INFO: compiled from: Cache.java */
/* JADX INFO: loaded from: classes.dex */
public final class amh implements Closeable, Flushable {

    /* JADX INFO: renamed from: a */
    final ans f1721a;

    /* JADX INFO: renamed from: b */
    final anr f1722b;

    @Override // java.io.Flushable
    public void flush() {
        this.f1722b.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1722b.close();
    }
}
