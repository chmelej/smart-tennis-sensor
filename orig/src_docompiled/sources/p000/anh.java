package p000;

import java.io.Closeable;
import java.io.IOException;
import javax.annotation.Nullable;
import okio.Buffer;
import okio.BufferedSource;

/* JADX INFO: compiled from: ResponseBody.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class anh implements Closeable {
    @Nullable
    /* JADX INFO: renamed from: a */
    public abstract ana mo4479a();

    /* JADX INFO: renamed from: b */
    public abstract long mo4480b();

    /* JADX INFO: renamed from: c */
    public abstract BufferedSource mo4481c();

    /* JADX INFO: renamed from: d */
    public final byte[] m4482d() throws IOException {
        long jMo4480b = mo4480b();
        if (jMo4480b > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jMo4480b);
        }
        BufferedSource bufferedSourceMo4481c = mo4481c();
        try {
            byte[] byteArray = bufferedSourceMo4481c.readByteArray();
            anm.m4506a(bufferedSourceMo4481c);
            if (jMo4480b == -1 || jMo4480b == byteArray.length) {
                return byteArray;
            }
            throw new IOException("Content-Length (" + jMo4480b + ") and stream length (" + byteArray.length + ") disagree");
        } catch (Throwable th) {
            anm.m4506a(bufferedSourceMo4481c);
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        anm.m4506a(mo4481c());
    }

    /* JADX INFO: renamed from: a */
    public static anh m4478a(@Nullable ana anaVar, byte[] bArr) {
        return m4477a(anaVar, bArr.length, new Buffer().write(bArr));
    }

    /* JADX INFO: renamed from: a */
    public static anh m4477a(@Nullable final ana anaVar, final long j, final BufferedSource bufferedSource) {
        if (bufferedSource == null) {
            throw new NullPointerException("source == null");
        }
        return new anh() { // from class: anh.1
            @Override // p000.anh
            @Nullable
            /* JADX INFO: renamed from: a */
            public ana mo4479a() {
                return anaVar;
            }

            @Override // p000.anh
            /* JADX INFO: renamed from: b */
            public long mo4480b() {
                return j;
            }

            @Override // p000.anh
            /* JADX INFO: renamed from: c */
            public BufferedSource mo4481c() {
                return bufferedSource;
            }
        };
    }
}
