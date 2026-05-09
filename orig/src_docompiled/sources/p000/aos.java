package p000;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.ByteString;
import okio.ForwardingSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import p000.amx;
import p000.amz;
import p000.ang;

/* JADX INFO: compiled from: Http2Codec.java */
/* JADX INFO: loaded from: classes.dex */
public final class aos implements aoc {

    /* JADX INFO: renamed from: b */
    private static final ByteString f4423b = ByteString.encodeUtf8("connection");

    /* JADX INFO: renamed from: c */
    private static final ByteString f4424c = ByteString.encodeUtf8("host");

    /* JADX INFO: renamed from: d */
    private static final ByteString f4425d = ByteString.encodeUtf8("keep-alive");

    /* JADX INFO: renamed from: e */
    private static final ByteString f4426e = ByteString.encodeUtf8("proxy-connection");

    /* JADX INFO: renamed from: f */
    private static final ByteString f4427f = ByteString.encodeUtf8("transfer-encoding");

    /* JADX INFO: renamed from: g */
    private static final ByteString f4428g = ByteString.encodeUtf8("te");

    /* JADX INFO: renamed from: h */
    private static final ByteString f4429h = ByteString.encodeUtf8("encoding");

    /* JADX INFO: renamed from: i */
    private static final ByteString f4430i = ByteString.encodeUtf8("upgrade");

    /* JADX INFO: renamed from: j */
    private static final List<ByteString> f4431j = anm.m4501a(f4423b, f4424c, f4425d, f4426e, f4428g, f4427f, f4429h, f4430i, aop.f4392c, aop.f4393d, aop.f4394e, aop.f4395f);

    /* JADX INFO: renamed from: k */
    private static final List<ByteString> f4432k = anm.m4501a(f4423b, f4424c, f4425d, f4426e, f4428g, f4427f, f4429h, f4430i);

    /* JADX INFO: renamed from: a */
    final anz f4433a;

    /* JADX INFO: renamed from: l */
    private final amz.InterfaceC0211a f4434l;

    /* JADX INFO: renamed from: m */
    private final aot f4435m;

    /* JADX INFO: renamed from: n */
    private aov f4436n;

    /* JADX INFO: renamed from: o */
    private final anc f4437o;

    public aos(anb anbVar, amz.InterfaceC0211a interfaceC0211a, anz anzVar, aot aotVar) {
        anc ancVar;
        this.f4434l = interfaceC0211a;
        this.f4433a = anzVar;
        this.f4435m = aotVar;
        if (anbVar.m2150u().contains(anc.H2_PRIOR_KNOWLEDGE)) {
            ancVar = anc.H2_PRIOR_KNOWLEDGE;
        } else {
            ancVar = anc.HTTP_2;
        }
        this.f4437o = ancVar;
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public Sink mo4611a(ane aneVar, long j) {
        return this.f4436n.m4767h();
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public void mo4613a(ane aneVar) {
        if (this.f4436n != null) {
            return;
        }
        this.f4436n = this.f4435m.m4703a(m4692b(aneVar), aneVar.m4424d() != null);
        this.f4436n.m4764e().timeout(this.f4434l.mo2119d(), TimeUnit.MILLISECONDS);
        this.f4436n.m4765f().timeout(this.f4434l.mo2120e(), TimeUnit.MILLISECONDS);
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public void mo4612a() {
        this.f4435m.m4716b();
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: b */
    public void mo4614b() {
        this.f4436n.m4767h().close();
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public ang.C0669a mo4609a(boolean z) throws ProtocolException {
        ang.C0669a c0669aM4691a = m4691a(this.f4436n.m4763d(), this.f4437o);
        if (z && ank.f4205a.mo2155a(c0669aM4691a) == 100) {
            return null;
        }
        return c0669aM4691a;
    }

    /* JADX INFO: renamed from: b */
    public static List<aop> m4692b(ane aneVar) {
        amx amxVarM4423c = aneVar.m4423c();
        ArrayList arrayList = new ArrayList(amxVarM4423c.m2052a() + 4);
        arrayList.add(new aop(aop.f4392c, aneVar.m4422b()));
        arrayList.add(new aop(aop.f4393d, aoi.m4636a(aneVar.m4419a())));
        String strM4421a = aneVar.m4421a("Host");
        if (strM4421a != null) {
            arrayList.add(new aop(aop.f4395f, strM4421a));
        }
        arrayList.add(new aop(aop.f4394e, aneVar.m4419a().m2079b()));
        int iM2052a = amxVarM4423c.m2052a();
        for (int i = 0; i < iM2052a; i++) {
            ByteString byteStringEncodeUtf8 = ByteString.encodeUtf8(amxVarM4423c.m2053a(i).toLowerCase(Locale.US));
            if (!f4431j.contains(byteStringEncodeUtf8)) {
                arrayList.add(new aop(byteStringEncodeUtf8, amxVarM4423c.m2056b(i)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public static ang.C0669a m4691a(List<aop> list, anc ancVar) throws ProtocolException {
        amx.C0209a c0209a = new amx.C0209a();
        int size = list.size();
        amx.C0209a c0209a2 = c0209a;
        aok aokVarM4647a = null;
        for (int i = 0; i < size; i++) {
            aop aopVar = list.get(i);
            if (aopVar == null) {
                if (aokVarM4647a != null && aokVarM4647a.f4350b == 100) {
                    c0209a2 = new amx.C0209a();
                    aokVarM4647a = null;
                }
            } else {
                ByteString byteString = aopVar.f4396g;
                String strUtf8 = aopVar.f4397h.utf8();
                if (byteString.equals(aop.f4391b)) {
                    aokVarM4647a = aok.m4647a("HTTP/1.1 " + strUtf8);
                } else if (!f4432k.contains(byteString)) {
                    ank.f4205a.mo2161a(c0209a2, byteString.utf8(), strUtf8);
                }
            }
        }
        if (aokVarM4647a == null) {
            throw new ProtocolException("Expected ':status' header not present");
        }
        return new ang.C0669a().m4467a(ancVar).m4463a(aokVarM4647a.f4350b).m4471a(aokVarM4647a.f4351c).m4466a(c0209a2.m2061a());
    }

    @Override // p000.aoc
    /* JADX INFO: renamed from: a */
    public anh mo4610a(ang angVar) {
        this.f4433a.f4309c.m2045f(this.f4433a.f4308b);
        return new aoh(angVar.m4449a(MIME.CONTENT_TYPE), aoe.m4621a(angVar), Okio.buffer(new C0691a(this.f4436n.m4766g())));
    }

    /* JADX INFO: renamed from: aos$a */
    /* JADX INFO: compiled from: Http2Codec.java */
    class C0691a extends ForwardingSource {

        /* JADX INFO: renamed from: a */
        boolean f4438a;

        /* JADX INFO: renamed from: b */
        long f4439b;

        C0691a(Source source) {
            super(source);
            this.f4438a = false;
            this.f4439b = 0L;
        }

        @Override // okio.ForwardingSource, okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            try {
                long j2 = delegate().read(buffer, j);
                if (j2 > 0) {
                    this.f4439b += j2;
                }
                return j2;
            } catch (IOException e) {
                m4693a(e);
                throw e;
            }
        }

        @Override // okio.ForwardingSource, okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            super.close();
            m4693a(null);
        }

        /* JADX INFO: renamed from: a */
        private void m4693a(IOException iOException) {
            if (this.f4438a) {
                return;
            }
            this.f4438a = true;
            aos.this.f4433a.m4602a(false, aos.this, this.f4439b, iOException);
        }
    }
}
