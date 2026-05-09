package p000;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;
import p000.aoq;

/* JADX INFO: compiled from: Http2Reader.java */
/* JADX INFO: loaded from: classes.dex */
final class aou implements Closeable {

    /* JADX INFO: renamed from: a */
    static final Logger f4504a = Logger.getLogger(aor.class.getName());

    /* JADX INFO: renamed from: b */
    final aoq.C0689a f4505b;

    /* JADX INFO: renamed from: c */
    private final BufferedSource f4506c;

    /* JADX INFO: renamed from: d */
    private final C0702a f4507d;

    /* JADX INFO: renamed from: e */
    private final boolean f4508e;

    /* JADX INFO: renamed from: aou$b */
    /* JADX INFO: compiled from: Http2Reader.java */
    interface InterfaceC0703b {
        /* JADX INFO: renamed from: a */
        void mo4727a();

        /* JADX INFO: renamed from: a */
        void mo4728a(int i, int i2, int i3, boolean z);

        /* JADX INFO: renamed from: a */
        void mo4729a(int i, int i2, List<aop> list);

        /* JADX INFO: renamed from: a */
        void mo4730a(int i, long j);

        /* JADX INFO: renamed from: a */
        void mo4731a(int i, aoo aooVar);

        /* JADX INFO: renamed from: a */
        void mo4732a(int i, aoo aooVar, ByteString byteString);

        /* JADX INFO: renamed from: a */
        void mo4733a(boolean z, int i, int i2);

        /* JADX INFO: renamed from: a */
        void mo4734a(boolean z, int i, int i2, List<aop> list);

        /* JADX INFO: renamed from: a */
        void mo4735a(boolean z, int i, BufferedSource bufferedSource, int i2);

        /* JADX INFO: renamed from: a */
        void mo4736a(boolean z, aoz aozVar);
    }

    aou(BufferedSource bufferedSource, boolean z) {
        this.f4506c = bufferedSource;
        this.f4508e = z;
        this.f4507d = new C0702a(this.f4506c);
        this.f4505b = new aoq.C0689a(4096, this.f4507d);
    }

    /* JADX INFO: renamed from: a */
    public void m4750a(InterfaceC0703b interfaceC0703b) throws IOException {
        if (this.f4508e) {
            if (!m4751a(true, interfaceC0703b)) {
                throw aor.m4690b("Required SETTINGS preface not received", new Object[0]);
            }
            return;
        }
        ByteString byteString = this.f4506c.readByteString(aor.f4419a.size());
        if (f4504a.isLoggable(Level.FINE)) {
            f4504a.fine(anm.m4498a("<< CONNECTION %s", byteString.hex()));
        }
        if (!aor.f4419a.equals(byteString)) {
            throw aor.m4690b("Expected a connection header but was %s", byteString.utf8());
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4751a(boolean z, InterfaceC0703b interfaceC0703b) throws IOException {
        try {
            this.f4506c.require(9L);
            int iM4738a = m4738a(this.f4506c);
            if (iM4738a < 0 || iM4738a > 16384) {
                throw aor.m4690b("FRAME_SIZE_ERROR: %s", Integer.valueOf(iM4738a));
            }
            byte b = (byte) (this.f4506c.readByte() & 255);
            if (z && b != 4) {
                throw aor.m4690b("Expected a SETTINGS frame but was %s", Byte.valueOf(b));
            }
            byte b2 = (byte) (this.f4506c.readByte() & 255);
            int i = this.f4506c.readInt() & Integer.MAX_VALUE;
            if (f4504a.isLoggable(Level.FINE)) {
                f4504a.fine(aor.m4689a(true, i, iM4738a, b, b2));
            }
            switch (b) {
                case 0:
                    m4742b(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 1:
                    m4741a(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 2:
                    m4743c(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 3:
                    m4744d(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 4:
                    m4745e(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 5:
                    m4746f(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 6:
                    m4747g(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 7:
                    m4748h(interfaceC0703b, iM4738a, b2, i);
                    return true;
                case 8:
                    m4749i(interfaceC0703b, iM4738a, b2, i);
                    return true;
                default:
                    this.f4506c.skip(iM4738a);
                    return true;
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4741a(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw aor.m4690b("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        short s = (b & 8) != 0 ? (short) (this.f4506c.readByte() & 255) : (short) 0;
        if ((b & 32) != 0) {
            m4740a(interfaceC0703b, i2);
            i -= 5;
        }
        interfaceC0703b.mo4734a(z, i2, -1, m4739a(m4737a(i, b, s), s, b, i2));
    }

    /* JADX INFO: renamed from: a */
    private List<aop> m4739a(int i, short s, byte b, int i2) throws IOException {
        C0702a c0702a = this.f4507d;
        this.f4507d.f4512d = i;
        c0702a.f4509a = i;
        this.f4507d.f4513e = s;
        this.f4507d.f4510b = b;
        this.f4507d.f4511c = i2;
        this.f4505b.m4676a();
        return this.f4505b.m4677b();
    }

    /* JADX INFO: renamed from: b */
    private void m4742b(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw aor.m4690b("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
        }
        boolean z = (b & 1) != 0;
        if ((b & 32) != 0) {
            throw aor.m4690b("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        short s = (b & 8) != 0 ? (short) (this.f4506c.readByte() & 255) : (short) 0;
        interfaceC0703b.mo4735a(z, i2, this.f4506c, m4737a(i, b, s));
        this.f4506c.skip(s);
    }

    /* JADX INFO: renamed from: c */
    private void m4743c(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i != 5) {
            throw aor.m4690b("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw aor.m4690b("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
        m4740a(interfaceC0703b, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m4740a(InterfaceC0703b interfaceC0703b, int i) {
        int i2 = this.f4506c.readInt();
        interfaceC0703b.mo4728a(i, i2 & Integer.MAX_VALUE, (this.f4506c.readByte() & 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }

    /* JADX INFO: renamed from: d */
    private void m4744d(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw aor.m4690b("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        }
        if (i2 == 0) {
            throw aor.m4690b("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
        int i3 = this.f4506c.readInt();
        aoo aooVarM4659a = aoo.m4659a(i3);
        if (aooVarM4659a == null) {
            throw aor.m4690b("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(i3));
        }
        interfaceC0703b.mo4731a(i2, aooVarM4659a);
    }

    /* JADX INFO: renamed from: e */
    private void m4745e(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i2 != 0) {
            throw aor.m4690b("TYPE_SETTINGS streamId != 0", new Object[0]);
        }
        if ((b & 1) != 0) {
            if (i != 0) {
                throw aor.m4690b("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
            }
            interfaceC0703b.mo4727a();
            return;
        }
        if (i % 6 != 0) {
            throw aor.m4690b("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
        aoz aozVar = new aoz();
        for (int i3 = 0; i3 < i; i3 += 6) {
            int i4 = this.f4506c.readShort() & 65535;
            int i5 = this.f4506c.readInt();
            switch (i4) {
                case 2:
                    if (i5 != 0 && i5 != 1) {
                        throw aor.m4690b("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                    }
                    break;
                    break;
                case 3:
                    i4 = 4;
                    break;
                case 4:
                    i4 = 7;
                    if (i5 < 0) {
                        throw aor.m4690b("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                    }
                    break;
                    break;
                case 5:
                    if (i5 < 16384 || i5 > 16777215) {
                        throw aor.m4690b("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(i5));
                    }
                    break;
                    break;
            }
            aozVar.m4804a(i4, i5);
        }
        interfaceC0703b.mo4736a(false, aozVar);
    }

    /* JADX INFO: renamed from: f */
    private void m4746f(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i2 == 0) {
            throw aor.m4690b("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
        }
        short s = (b & 8) != 0 ? (short) (this.f4506c.readByte() & 255) : (short) 0;
        interfaceC0703b.mo4729a(i2, this.f4506c.readInt() & Integer.MAX_VALUE, m4739a(m4737a(i - 4, b, s), s, b, i2));
    }

    /* JADX INFO: renamed from: g */
    private void m4747g(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i != 8) {
            throw aor.m4690b("TYPE_PING length != 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw aor.m4690b("TYPE_PING streamId != 0", new Object[0]);
        }
        interfaceC0703b.mo4733a((b & 1) != 0, this.f4506c.readInt(), this.f4506c.readInt());
    }

    /* JADX INFO: renamed from: h */
    private void m4748h(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i < 8) {
            throw aor.m4690b("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        }
        if (i2 != 0) {
            throw aor.m4690b("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
        int i3 = this.f4506c.readInt();
        int i4 = this.f4506c.readInt();
        int i5 = i - 8;
        aoo aooVarM4659a = aoo.m4659a(i4);
        if (aooVarM4659a == null) {
            throw aor.m4690b("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(i4));
        }
        ByteString byteString = ByteString.EMPTY;
        if (i5 > 0) {
            byteString = this.f4506c.readByteString(i5);
        }
        interfaceC0703b.mo4732a(i3, aooVarM4659a, byteString);
    }

    /* JADX INFO: renamed from: i */
    private void m4749i(InterfaceC0703b interfaceC0703b, int i, byte b, int i2) throws IOException {
        if (i != 4) {
            throw aor.m4690b("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
        long j = ((long) this.f4506c.readInt()) & 2147483647L;
        if (j == 0) {
            throw aor.m4690b("windowSizeIncrement was 0", Long.valueOf(j));
        }
        interfaceC0703b.mo4730a(i2, j);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f4506c.close();
    }

    /* JADX INFO: renamed from: aou$a */
    /* JADX INFO: compiled from: Http2Reader.java */
    static final class C0702a implements Source {

        /* JADX INFO: renamed from: a */
        int f4509a;

        /* JADX INFO: renamed from: b */
        byte f4510b;

        /* JADX INFO: renamed from: c */
        int f4511c;

        /* JADX INFO: renamed from: d */
        int f4512d;

        /* JADX INFO: renamed from: e */
        short f4513e;

        /* JADX INFO: renamed from: f */
        private final BufferedSource f4514f;

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        C0702a(BufferedSource bufferedSource) {
            this.f4514f = bufferedSource;
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            while (this.f4512d == 0) {
                this.f4514f.skip(this.f4513e);
                this.f4513e = (short) 0;
                if ((this.f4510b & 4) != 0) {
                    return -1L;
                }
                m4752a();
            }
            long j2 = this.f4514f.read(buffer, Math.min(j, this.f4512d));
            if (j2 == -1) {
                return -1L;
            }
            this.f4512d = (int) (((long) this.f4512d) - j2);
            return j2;
        }

        @Override // okio.Source
        public Timeout timeout() {
            return this.f4514f.timeout();
        }

        /* JADX INFO: renamed from: a */
        private void m4752a() throws IOException {
            int i = this.f4511c;
            int iM4738a = aou.m4738a(this.f4514f);
            this.f4512d = iM4738a;
            this.f4509a = iM4738a;
            byte b = (byte) (this.f4514f.readByte() & 255);
            this.f4510b = (byte) (this.f4514f.readByte() & 255);
            if (aou.f4504a.isLoggable(Level.FINE)) {
                aou.f4504a.fine(aor.m4689a(true, this.f4511c, this.f4509a, b, this.f4510b));
            }
            this.f4511c = this.f4514f.readInt() & Integer.MAX_VALUE;
            if (b != 9) {
                throw aor.m4690b("%s != TYPE_CONTINUATION", Byte.valueOf(b));
            }
            if (this.f4511c != i) {
                throw aor.m4690b("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static int m4738a(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << 16) | ((bufferedSource.readByte() & 255) << 8);
    }

    /* JADX INFO: renamed from: a */
    static int m4737a(int i, byte b, short s) throws IOException {
        if ((b & 8) != 0) {
            i--;
        }
        if (s > i) {
            throw aor.m4690b("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
        }
        return (short) (i - s);
    }
}
