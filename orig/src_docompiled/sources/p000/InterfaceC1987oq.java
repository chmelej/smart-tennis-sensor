package p000;

import java.io.Closeable;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;

/* JADX INFO: renamed from: oq */
/* JADX INFO: compiled from: DataSource.java */
/* JADX INFO: loaded from: classes.dex */
public interface InterfaceC1987oq extends Closeable {
    /* JADX INFO: renamed from: a */
    long m10915a();

    /* JADX INFO: renamed from: a */
    long m10916a(long j, long j2, WritableByteChannel writableByteChannel);

    /* JADX INFO: renamed from: a */
    ByteBuffer m10917a(long j, long j2);

    /* JADX INFO: renamed from: a */
    void m10918a(long j);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    void close();
}
