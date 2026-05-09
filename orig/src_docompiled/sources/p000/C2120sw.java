package p000;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: renamed from: sw */
/* JADX INFO: compiled from: MultipartBody.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2120sw extends anf {

    /* JADX INFO: renamed from: a */
    public static final ana f12700a = ana.m2123b("multipart/mixed");

    /* JADX INFO: renamed from: b */
    public static final ana f12701b = ana.m2123b("multipart/alternative");

    /* JADX INFO: renamed from: c */
    public static final ana f12702c = ana.m2123b("multipart/digest");

    /* JADX INFO: renamed from: d */
    public static final ana f12703d = ana.m2123b("multipart/parallel");

    /* JADX INFO: renamed from: e */
    public static final ana f12704e = ana.m2123b("multipart/form-data");

    /* JADX INFO: renamed from: f */
    private static final byte[] f12705f = {58, 32};

    /* JADX INFO: renamed from: g */
    private static final byte[] f12706g = {13, 10};

    /* JADX INFO: renamed from: h */
    private static final byte[] f12707h = {45, 45};

    /* JADX INFO: renamed from: i */
    private final ByteString f12708i;

    /* JADX INFO: renamed from: j */
    private final ana f12709j;

    /* JADX INFO: renamed from: k */
    private final ana f12710k;

    /* JADX INFO: renamed from: l */
    private final List<b> f12711l;

    /* JADX INFO: renamed from: m */
    private long f12712m = -1;

    C2120sw(ByteString byteString, ana anaVar, List<b> list) {
        this.f12708i = byteString;
        this.f12709j = anaVar;
        this.f12710k = ana.m2122a(anaVar + "; boundary=" + byteString.utf8());
        this.f12711l = anm.m4500a(list);
    }

    /* JADX INFO: renamed from: a */
    static StringBuilder m11594a(StringBuilder sb, String str) {
        sb.append('\"');
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == '\n') {
                sb.append("%0A");
            } else if (cCharAt == '\r') {
                sb.append("%0D");
            } else if (cCharAt == '\"') {
                sb.append("%22");
            } else {
                sb.append(cCharAt);
            }
        }
        sb.append('\"');
        return sb;
    }

    @Override // p000.anf
    /* JADX INFO: renamed from: b */
    public ana mo4447b() {
        return this.f12710k;
    }

    @Override // p000.anf
    /* JADX INFO: renamed from: a */
    public long mo4445a() {
        long j = this.f12712m;
        if (j != -1) {
            return j;
        }
        long jM11593a = m11593a((BufferedSink) null, true);
        this.f12712m = jM11593a;
        return jM11593a;
    }

    @Override // p000.anf
    /* JADX INFO: renamed from: a */
    public void mo4446a(BufferedSink bufferedSink) {
        m11593a(bufferedSink, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private long m11593a(BufferedSink bufferedSink, boolean z) {
        Buffer buffer;
        if (z) {
            bufferedSink = new Buffer();
            buffer = bufferedSink;
        } else {
            buffer = 0;
        }
        int size = this.f12711l.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            b bVar = this.f12711l.get(i);
            C2119sv c2119sv = bVar.f12716a;
            anf anfVar = bVar.f12717b;
            bufferedSink.write(f12707h);
            bufferedSink.write(this.f12708i);
            bufferedSink.write(f12706g);
            if (c2119sv != null) {
                int iM11589a = c2119sv.m11589a();
                for (int i2 = 0; i2 < iM11589a; i2++) {
                    bufferedSink.writeUtf8(c2119sv.m11590a(i2)).write(f12705f).writeUtf8(c2119sv.m11592b(i2)).write(f12706g);
                }
            }
            ana anaVarMo4447b = anfVar.mo4447b();
            if (anaVarMo4447b != null) {
                bufferedSink.writeUtf8("Content-Type: ").writeUtf8(anaVarMo4447b.toString()).write(f12706g);
            }
            long jMo4445a = anfVar.mo4445a();
            if (jMo4445a != -1) {
                bufferedSink.writeUtf8("Content-Length: ").writeDecimalLong(jMo4445a).write(f12706g);
            } else if (z) {
                buffer.clear();
                return -1L;
            }
            bufferedSink.write(f12706g);
            if (z) {
                j += jMo4445a;
            } else {
                anfVar.mo4446a(bufferedSink);
            }
            bufferedSink.write(f12706g);
        }
        bufferedSink.write(f12707h);
        bufferedSink.write(this.f12708i);
        bufferedSink.write(f12707h);
        bufferedSink.write(f12706g);
        if (!z) {
            return j;
        }
        long size2 = j + buffer.size();
        buffer.clear();
        return size2;
    }

    /* JADX INFO: renamed from: sw$b */
    /* JADX INFO: compiled from: MultipartBody.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        final C2119sv f12716a;

        /* JADX INFO: renamed from: b */
        final anf f12717b;

        private b(C2119sv c2119sv, anf anfVar) {
            this.f12716a = c2119sv;
            this.f12717b = anfVar;
        }

        /* JADX INFO: renamed from: a */
        public static b m11602a(C2119sv c2119sv, anf anfVar) {
            if (anfVar == null) {
                throw new NullPointerException("body == null");
            }
            if (c2119sv != null && c2119sv.m11591a(MIME.CONTENT_TYPE) != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Type");
            }
            if (c2119sv != null && c2119sv.m11591a("Content-Length") != null) {
                throw new IllegalArgumentException("Unexpected header: Content-Length");
            }
            return new b(c2119sv, anfVar);
        }

        /* JADX INFO: renamed from: a */
        public static b m11600a(String str, String str2) {
            return m11601a(str, null, anf.m4442a((ana) null, str2));
        }

        /* JADX INFO: renamed from: a */
        public static b m11601a(String str, String str2, anf anfVar) {
            if (str == null) {
                throw new NullPointerException("name == null");
            }
            StringBuilder sb = new StringBuilder("form-data; name=");
            C2120sw.m11594a(sb, str);
            if (str2 != null) {
                sb.append("; filename=");
                C2120sw.m11594a(sb, str2);
            }
            return m11602a(C2119sv.m11588a(MIME.CONTENT_DISPOSITION, sb.toString()), anfVar);
        }
    }

    /* JADX INFO: renamed from: sw$a */
    /* JADX INFO: compiled from: MultipartBody.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        private final ByteString f12713a;

        /* JADX INFO: renamed from: b */
        private final List<b> f12714b;

        /* JADX INFO: renamed from: c */
        private ana f12715c;

        public a() {
            this(UUID.randomUUID().toString());
        }

        public a(String str) {
            this.f12714b = new ArrayList();
            this.f12715c = C2120sw.f12700a;
            this.f12713a = ByteString.encodeUtf8(str);
        }

        /* JADX INFO: renamed from: a */
        public a m11595a(ana anaVar) {
            if (anaVar == null) {
                throw new NullPointerException("type == null");
            }
            if (!anaVar.m2124a().equals("multipart")) {
                throw new IllegalArgumentException("multipart != " + anaVar);
            }
            this.f12715c = anaVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m11596a(String str, String str2) {
            return m11598a(b.m11600a(str, str2));
        }

        /* JADX INFO: renamed from: a */
        public a m11597a(String str, String str2, anf anfVar) {
            return m11598a(b.m11601a(str, str2, anfVar));
        }

        /* JADX INFO: renamed from: a */
        public a m11598a(b bVar) {
            if (bVar == null) {
                throw new NullPointerException("part == null");
            }
            this.f12714b.add(bVar);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C2120sw m11599a() {
            if (this.f12714b.isEmpty()) {
                throw new IllegalStateException("Multipart body must have at least one part.");
            }
            return new C2120sw(this.f12713a, this.f12715c, this.f12714b);
        }
    }
}
