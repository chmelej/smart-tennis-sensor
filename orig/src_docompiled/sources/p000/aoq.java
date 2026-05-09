package p000;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Source;
import org.android.spdy.SpdyRequest;

/* JADX INFO: compiled from: Hpack.java */
/* JADX INFO: loaded from: classes.dex */
final class aoq {

    /* JADX INFO: renamed from: a */
    static final aop[] f4399a = {new aop(aop.f4395f, ""), new aop(aop.f4392c, SpdyRequest.GET_METHOD), new aop(aop.f4392c, SpdyRequest.POST_METHOD), new aop(aop.f4393d, "/"), new aop(aop.f4393d, "/index.html"), new aop(aop.f4394e, "http"), new aop(aop.f4394e, "https"), new aop(aop.f4391b, "200"), new aop(aop.f4391b, "204"), new aop(aop.f4391b, "206"), new aop(aop.f4391b, "304"), new aop(aop.f4391b, "400"), new aop(aop.f4391b, "404"), new aop(aop.f4391b, "500"), new aop("accept-charset", ""), new aop("accept-encoding", "gzip, deflate"), new aop("accept-language", ""), new aop("accept-ranges", ""), new aop("accept", ""), new aop("access-control-allow-origin", ""), new aop("age", ""), new aop("allow", ""), new aop("authorization", ""), new aop("cache-control", ""), new aop("content-disposition", ""), new aop("content-encoding", ""), new aop("content-language", ""), new aop("content-length", ""), new aop("content-location", ""), new aop("content-range", ""), new aop("content-type", ""), new aop("cookie", ""), new aop("date", ""), new aop("etag", ""), new aop("expect", ""), new aop("expires", ""), new aop("from", ""), new aop("host", ""), new aop("if-match", ""), new aop("if-modified-since", ""), new aop("if-none-match", ""), new aop("if-range", ""), new aop("if-unmodified-since", ""), new aop("last-modified", ""), new aop("link", ""), new aop("location", ""), new aop("max-forwards", ""), new aop("proxy-authenticate", ""), new aop("proxy-authorization", ""), new aop("range", ""), new aop("referer", ""), new aop("refresh", ""), new aop("retry-after", ""), new aop("server", ""), new aop("set-cookie", ""), new aop("strict-transport-security", ""), new aop("transfer-encoding", ""), new aop("user-agent", ""), new aop("vary", ""), new aop("via", ""), new aop("www-authenticate", "")};

    /* JADX INFO: renamed from: b */
    static final Map<ByteString, Integer> f4400b = m4660a();

    /* JADX INFO: renamed from: aoq$a */
    /* JADX INFO: compiled from: Hpack.java */
    static final class C0689a {

        /* JADX INFO: renamed from: a */
        aop[] f4401a;

        /* JADX INFO: renamed from: b */
        int f4402b;

        /* JADX INFO: renamed from: c */
        int f4403c;

        /* JADX INFO: renamed from: d */
        int f4404d;

        /* JADX INFO: renamed from: e */
        private final List<aop> f4405e;

        /* JADX INFO: renamed from: f */
        private final BufferedSource f4406f;

        /* JADX INFO: renamed from: g */
        private final int f4407g;

        /* JADX INFO: renamed from: h */
        private int f4408h;

        C0689a(int i, Source source) {
            this(i, i, source);
        }

        C0689a(int i, int i2, Source source) {
            this.f4405e = new ArrayList();
            this.f4401a = new aop[8];
            this.f4402b = this.f4401a.length - 1;
            this.f4403c = 0;
            this.f4404d = 0;
            this.f4407g = i;
            this.f4408h = i2;
            this.f4406f = Okio.buffer(source);
        }

        /* JADX INFO: renamed from: d */
        private void m4666d() {
            if (this.f4408h < this.f4404d) {
                if (this.f4408h == 0) {
                    m4668e();
                } else {
                    m4662a(this.f4404d - this.f4408h);
                }
            }
        }

        /* JADX INFO: renamed from: e */
        private void m4668e() {
            Arrays.fill(this.f4401a, (Object) null);
            this.f4402b = this.f4401a.length - 1;
            this.f4403c = 0;
            this.f4404d = 0;
        }

        /* JADX INFO: renamed from: a */
        private int m4662a(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f4401a.length;
                while (true) {
                    length--;
                    if (length < this.f4402b || i <= 0) {
                        break;
                    }
                    i -= this.f4401a[length].f4398i;
                    this.f4404d -= this.f4401a[length].f4398i;
                    this.f4403c--;
                    i2++;
                }
                System.arraycopy(this.f4401a, this.f4402b + 1, this.f4401a, this.f4402b + 1 + i2, this.f4403c);
                this.f4402b += i2;
            }
            return i2;
        }

        /* JADX INFO: renamed from: a */
        void m4676a() throws IOException {
            while (!this.f4406f.exhausted()) {
                int i = this.f4406f.readByte() & 255;
                if (i == 128) {
                    throw new IOException("index == 0");
                }
                if ((i & 128) == 128) {
                    m4664b(m4675a(i, 127) - 1);
                } else if (i == 64) {
                    m4672g();
                } else if ((i & 64) == 64) {
                    m4669e(m4675a(i, 63) - 1);
                } else if ((i & 32) == 32) {
                    this.f4408h = m4675a(i, 31);
                    if (this.f4408h < 0 || this.f4408h > this.f4407g) {
                        throw new IOException("Invalid dynamic table size update " + this.f4408h);
                    }
                    m4666d();
                } else if (i == 16 || i == 0) {
                    m4671f();
                } else {
                    m4667d(m4675a(i, 15) - 1);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public List<aop> m4677b() {
            ArrayList arrayList = new ArrayList(this.f4405e);
            this.f4405e.clear();
            return arrayList;
        }

        /* JADX INFO: renamed from: b */
        private void m4664b(int i) throws IOException {
            if (m4673g(i)) {
                this.f4405e.add(aoq.f4399a[i]);
                return;
            }
            int iM4665c = m4665c(i - aoq.f4399a.length);
            if (iM4665c < 0 || iM4665c >= this.f4401a.length) {
                throw new IOException("Header index too large " + (i + 1));
            }
            this.f4405e.add(this.f4401a[iM4665c]);
        }

        /* JADX INFO: renamed from: c */
        private int m4665c(int i) {
            return this.f4402b + 1 + i;
        }

        /* JADX INFO: renamed from: d */
        private void m4667d(int i) throws IOException {
            this.f4405e.add(new aop(m4670f(i), m4678c()));
        }

        /* JADX INFO: renamed from: f */
        private void m4671f() throws IOException {
            this.f4405e.add(new aop(aoq.m4661a(m4678c()), m4678c()));
        }

        /* JADX INFO: renamed from: e */
        private void m4669e(int i) {
            m4663a(-1, new aop(m4670f(i), m4678c()));
        }

        /* JADX INFO: renamed from: g */
        private void m4672g() {
            m4663a(-1, new aop(aoq.m4661a(m4678c()), m4678c()));
        }

        /* JADX INFO: renamed from: f */
        private ByteString m4670f(int i) throws IOException {
            if (m4673g(i)) {
                return aoq.f4399a[i].f4396g;
            }
            int iM4665c = m4665c(i - aoq.f4399a.length);
            if (iM4665c < 0 || iM4665c >= this.f4401a.length) {
                throw new IOException("Header index too large " + (i + 1));
            }
            return this.f4401a[iM4665c].f4396g;
        }

        /* JADX INFO: renamed from: g */
        private boolean m4673g(int i) {
            return i >= 0 && i <= aoq.f4399a.length - 1;
        }

        /* JADX INFO: renamed from: a */
        private void m4663a(int i, aop aopVar) {
            this.f4405e.add(aopVar);
            int i2 = aopVar.f4398i;
            if (i != -1) {
                i2 -= this.f4401a[m4665c(i)].f4398i;
            }
            if (i2 > this.f4408h) {
                m4668e();
                return;
            }
            int iM4662a = m4662a((this.f4404d + i2) - this.f4408h);
            if (i == -1) {
                if (this.f4403c + 1 > this.f4401a.length) {
                    aop[] aopVarArr = new aop[this.f4401a.length * 2];
                    System.arraycopy(this.f4401a, 0, aopVarArr, this.f4401a.length, this.f4401a.length);
                    this.f4402b = this.f4401a.length - 1;
                    this.f4401a = aopVarArr;
                }
                int i3 = this.f4402b;
                this.f4402b = i3 - 1;
                this.f4401a[i3] = aopVar;
                this.f4403c++;
            } else {
                this.f4401a[i + m4665c(i) + iM4662a] = aopVar;
            }
            this.f4404d += i2;
        }

        /* JADX INFO: renamed from: h */
        private int m4674h() {
            return this.f4406f.readByte() & 255;
        }

        /* JADX INFO: renamed from: a */
        int m4675a(int i, int i2) {
            int i3 = i & i2;
            if (i3 < i2) {
                return i3;
            }
            int i4 = 0;
            while (true) {
                int iM4674h = m4674h();
                if ((iM4674h & 128) == 0) {
                    return i2 + (iM4674h << i4);
                }
                i2 += (iM4674h & 127) << i4;
                i4 += 7;
            }
        }

        /* JADX INFO: renamed from: c */
        ByteString m4678c() {
            int iM4674h = m4674h();
            boolean z = (iM4674h & 128) == 128;
            int iM4675a = m4675a(iM4674h, 127);
            if (z) {
                return ByteString.m10878of(aox.m4794a().m4799a(this.f4406f.readByteArray(iM4675a)));
            }
            return this.f4406f.readByteString(iM4675a);
        }
    }

    /* JADX INFO: renamed from: a */
    private static Map<ByteString, Integer> m4660a() {
        LinkedHashMap linkedHashMap = new LinkedHashMap(f4399a.length);
        for (int i = 0; i < f4399a.length; i++) {
            if (!linkedHashMap.containsKey(f4399a[i].f4396g)) {
                linkedHashMap.put(f4399a[i].f4396g, Integer.valueOf(i));
            }
        }
        return Collections.unmodifiableMap(linkedHashMap);
    }

    /* JADX INFO: renamed from: aoq$b */
    /* JADX INFO: compiled from: Hpack.java */
    static final class C0690b {

        /* JADX INFO: renamed from: a */
        int f4409a;

        /* JADX INFO: renamed from: b */
        int f4410b;

        /* JADX INFO: renamed from: c */
        aop[] f4411c;

        /* JADX INFO: renamed from: d */
        int f4412d;

        /* JADX INFO: renamed from: e */
        int f4413e;

        /* JADX INFO: renamed from: f */
        int f4414f;

        /* JADX INFO: renamed from: g */
        private final Buffer f4415g;

        /* JADX INFO: renamed from: h */
        private final boolean f4416h;

        /* JADX INFO: renamed from: i */
        private int f4417i;

        /* JADX INFO: renamed from: j */
        private boolean f4418j;

        C0690b(Buffer buffer) {
            this(4096, true, buffer);
        }

        C0690b(int i, boolean z, Buffer buffer) {
            this.f4417i = Integer.MAX_VALUE;
            this.f4411c = new aop[8];
            this.f4412d = this.f4411c.length - 1;
            this.f4413e = 0;
            this.f4414f = 0;
            this.f4409a = i;
            this.f4410b = i;
            this.f4416h = z;
            this.f4415g = buffer;
        }

        /* JADX INFO: renamed from: a */
        private void m4679a() {
            Arrays.fill(this.f4411c, (Object) null);
            this.f4412d = this.f4411c.length - 1;
            this.f4413e = 0;
            this.f4414f = 0;
        }

        /* JADX INFO: renamed from: b */
        private int m4681b(int i) {
            int i2 = 0;
            if (i > 0) {
                int length = this.f4411c.length;
                while (true) {
                    length--;
                    if (length < this.f4412d || i <= 0) {
                        break;
                    }
                    i -= this.f4411c[length].f4398i;
                    this.f4414f -= this.f4411c[length].f4398i;
                    this.f4413e--;
                    i2++;
                }
                System.arraycopy(this.f4411c, this.f4412d + 1, this.f4411c, this.f4412d + 1 + i2, this.f4413e);
                Arrays.fill(this.f4411c, this.f4412d + 1, this.f4412d + 1 + i2, (Object) null);
                this.f4412d += i2;
            }
            return i2;
        }

        /* JADX INFO: renamed from: a */
        private void m4680a(aop aopVar) {
            int i = aopVar.f4398i;
            if (i > this.f4410b) {
                m4679a();
                return;
            }
            m4681b((this.f4414f + i) - this.f4410b);
            if (this.f4413e + 1 > this.f4411c.length) {
                aop[] aopVarArr = new aop[this.f4411c.length * 2];
                System.arraycopy(this.f4411c, 0, aopVarArr, this.f4411c.length, this.f4411c.length);
                this.f4412d = this.f4411c.length - 1;
                this.f4411c = aopVarArr;
            }
            int i2 = this.f4412d;
            this.f4412d = i2 - 1;
            this.f4411c[i2] = aopVar;
            this.f4413e++;
            this.f4414f += i;
        }

        /* JADX WARN: Removed duplicated region for block: B:22:0x006e  */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        void m4685a(java.util.List<p000.aop> r14) {
            /*
                Method dump skipped, instruction units count: 240
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.aoq.C0690b.m4685a(java.util.List):void");
        }

        /* JADX INFO: renamed from: a */
        void m4684a(int i, int i2, int i3) {
            if (i < i2) {
                this.f4415g.writeByte(i | i3);
                return;
            }
            this.f4415g.writeByte(i3 | i2);
            int i4 = i - i2;
            while (i4 >= 128) {
                this.f4415g.writeByte(128 | (i4 & 127));
                i4 >>>= 7;
            }
            this.f4415g.writeByte(i4);
        }

        /* JADX INFO: renamed from: a */
        void m4686a(ByteString byteString) {
            if (this.f4416h && aox.m4794a().m4797a(byteString) < byteString.size()) {
                Buffer buffer = new Buffer();
                aox.m4794a().m4798a(byteString, buffer);
                ByteString byteString2 = buffer.readByteString();
                m4684a(byteString2.size(), 127, 128);
                this.f4415g.write(byteString2);
                return;
            }
            m4684a(byteString.size(), 127, 0);
            this.f4415g.write(byteString);
        }

        /* JADX INFO: renamed from: a */
        void m4683a(int i) {
            this.f4409a = i;
            int iMin = Math.min(i, 16384);
            if (this.f4410b == iMin) {
                return;
            }
            if (iMin < this.f4410b) {
                this.f4417i = Math.min(this.f4417i, iMin);
            }
            this.f4418j = true;
            this.f4410b = iMin;
            m4682b();
        }

        /* JADX INFO: renamed from: b */
        private void m4682b() {
            if (this.f4410b < this.f4414f) {
                if (this.f4410b == 0) {
                    m4679a();
                } else {
                    m4681b(this.f4414f - this.f4410b);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static ByteString m4661a(ByteString byteString) throws IOException {
        int size = byteString.size();
        for (int i = 0; i < size; i++) {
            byte b = byteString.getByte(i);
            if (b >= 65 && b <= 90) {
                throw new IOException("PROTOCOL_ERROR response malformed: mixed case name: " + byteString.utf8());
            }
        }
        return byteString;
    }
}
