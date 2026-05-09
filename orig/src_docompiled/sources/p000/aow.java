package p000;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSink;
import p000.aoq;

/* JADX INFO: compiled from: Http2Writer.java */
/* JADX INFO: loaded from: classes.dex */
final class aow implements Closeable {

    /* JADX INFO: renamed from: b */
    private static final Logger f4541b = Logger.getLogger(aor.class.getName());

    /* JADX INFO: renamed from: c */
    private final BufferedSink f4543c;

    /* JADX INFO: renamed from: d */
    private final boolean f4544d;

    /* JADX INFO: renamed from: g */
    private boolean f4547g;

    /* JADX INFO: renamed from: e */
    private final Buffer f4545e = new Buffer();

    /* JADX INFO: renamed from: a */
    final aoq.C0690b f4542a = new aoq.C0690b(this.f4545e);

    /* JADX INFO: renamed from: f */
    private int f4546f = 16384;

    aow(BufferedSink bufferedSink, boolean z) {
        this.f4543c = bufferedSink;
        this.f4544d = z;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4779a() {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        if (this.f4544d) {
            if (f4541b.isLoggable(Level.FINE)) {
                f4541b.fine(anm.m4498a(">> CONNECTION %s", aor.f4419a.hex()));
            }
            this.f4543c.write(aor.f4419a.toByteArray());
            this.f4543c.flush();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4786a(aoz aozVar) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        this.f4546f = aozVar.m4813d(this.f4546f);
        if (aozVar.m4810c() != -1) {
            this.f4542a.m4683a(aozVar.m4810c());
        }
        m4781a(0, 0, (byte) 4, (byte) 1);
        this.f4543c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4782a(int i, int i2, List<aop> list) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        this.f4542a.m4685a(list);
        long size = this.f4545e.size();
        int iMin = (int) Math.min(this.f4546f - 4, size);
        long j = iMin;
        m4781a(i, iMin + 4, (byte) 5, size == j ? (byte) 4 : (byte) 0);
        this.f4543c.writeInt(i2 & Integer.MAX_VALUE);
        this.f4543c.write(this.f4545e, j);
        if (size > j) {
            m4778b(i, size - j);
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m4791b() {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        this.f4543c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4788a(boolean z, int i, int i2, List<aop> list) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        m4789a(z, i, list);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4784a(int i, aoo aooVar) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        if (aooVar.f4389l == -1) {
            throw new IllegalArgumentException();
        }
        m4781a(i, 4, (byte) 3, (byte) 0);
        this.f4543c.writeInt(aooVar.f4389l);
        this.f4543c.flush();
    }

    /* JADX INFO: renamed from: c */
    public int m4793c() {
        return this.f4546f;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4790a(boolean z, int i, Buffer buffer, int i2) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        m4780a(i, z ? (byte) 1 : (byte) 0, buffer, i2);
    }

    /* JADX INFO: renamed from: a */
    void m4780a(int i, byte b, Buffer buffer, int i2) {
        m4781a(i, i2, (byte) 0, b);
        if (i2 > 0) {
            this.f4543c.write(buffer, i2);
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m4792b(aoz aozVar) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        int i = 0;
        m4781a(0, aozVar.m4808b() * 6, (byte) 4, (byte) 0);
        while (i < 10) {
            if (aozVar.m4807a(i)) {
                this.f4543c.writeShort(i == 4 ? 3 : i == 7 ? 4 : i);
                this.f4543c.writeInt(aozVar.m4809b(i));
            }
            i++;
        }
        this.f4543c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4787a(boolean z, int i, int i2) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        m4781a(0, 8, (byte) 6, z ? (byte) 1 : (byte) 0);
        this.f4543c.writeInt(i);
        this.f4543c.writeInt(i2);
        this.f4543c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4785a(int i, aoo aooVar, byte[] bArr) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        if (aooVar.f4389l == -1) {
            throw aor.m4687a("errorCode.httpCode == -1", new Object[0]);
        }
        m4781a(0, bArr.length + 8, (byte) 7, (byte) 0);
        this.f4543c.writeInt(i);
        this.f4543c.writeInt(aooVar.f4389l);
        if (bArr.length > 0) {
            this.f4543c.write(bArr);
        }
        this.f4543c.flush();
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m4783a(int i, long j) {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        if (j != 0 && j <= 2147483647L) {
            m4781a(i, 4, (byte) 8, (byte) 0);
            this.f4543c.writeInt((int) j);
            this.f4543c.flush();
        }
        throw aor.m4687a("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", Long.valueOf(j));
    }

    /* JADX INFO: renamed from: a */
    public void m4781a(int i, int i2, byte b, byte b2) {
        if (f4541b.isLoggable(Level.FINE)) {
            f4541b.fine(aor.m4689a(false, i, i2, b, b2));
        }
        if (i2 > this.f4546f) {
            throw aor.m4687a("FRAME_SIZE_ERROR length > %d: %d", Integer.valueOf(this.f4546f), Integer.valueOf(i2));
        }
        if ((Integer.MIN_VALUE & i) != 0) {
            throw aor.m4687a("reserved bit set: %s", Integer.valueOf(i));
        }
        m4777a(this.f4543c, i2);
        this.f4543c.writeByte(b & 255);
        this.f4543c.writeByte(b2 & 255);
        this.f4543c.writeInt(i & Integer.MAX_VALUE);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() {
        this.f4547g = true;
        this.f4543c.close();
    }

    /* JADX INFO: renamed from: a */
    private static void m4777a(BufferedSink bufferedSink, int i) {
        bufferedSink.writeByte((i >>> 16) & 255);
        bufferedSink.writeByte((i >>> 8) & 255);
        bufferedSink.writeByte(i & 255);
    }

    /* JADX INFO: renamed from: b */
    private void m4778b(int i, long j) {
        while (j > 0) {
            int iMin = (int) Math.min(this.f4546f, j);
            long j2 = iMin;
            long j3 = j - j2;
            m4781a(i, iMin, (byte) 9, j3 == 0 ? (byte) 4 : (byte) 0);
            this.f4543c.write(this.f4545e, j2);
            j = j3;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4789a(boolean z, int i, List<aop> list) throws IOException {
        if (this.f4547g) {
            throw new IOException("closed");
        }
        this.f4542a.m4685a(list);
        long size = this.f4545e.size();
        int iMin = (int) Math.min(this.f4546f, size);
        long j = iMin;
        byte b = size == j ? (byte) 4 : (byte) 0;
        if (z) {
            b = (byte) (b | 1);
        }
        m4781a(i, iMin, (byte) 1, b);
        this.f4543c.write(this.f4545e, j);
        if (size > j) {
            m4778b(i, size - j);
        }
    }
}
