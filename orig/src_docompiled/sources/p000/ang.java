package p000;

import java.io.Closeable;
import javax.annotation.Nullable;
import p000.amx;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public final class ang implements Closeable {

    /* JADX INFO: renamed from: a */
    final ane f4167a;

    /* JADX INFO: renamed from: b */
    final anc f4168b;

    /* JADX INFO: renamed from: c */
    final int f4169c;

    /* JADX INFO: renamed from: d */
    final String f4170d;

    /* JADX INFO: renamed from: e */
    @Nullable
    final amw f4171e;

    /* JADX INFO: renamed from: f */
    final amx f4172f;

    /* JADX INFO: renamed from: g */
    @Nullable
    final anh f4173g;

    /* JADX INFO: renamed from: h */
    @Nullable
    final ang f4174h;

    /* JADX INFO: renamed from: i */
    @Nullable
    final ang f4175i;

    /* JADX INFO: renamed from: j */
    @Nullable
    final ang f4176j;

    /* JADX INFO: renamed from: k */
    final long f4177k;

    /* JADX INFO: renamed from: l */
    final long f4178l;

    /* JADX INFO: renamed from: m */
    private volatile ami f4179m;

    ang(C0669a c0669a) {
        this.f4167a = c0669a.f4180a;
        this.f4168b = c0669a.f4181b;
        this.f4169c = c0669a.f4182c;
        this.f4170d = c0669a.f4183d;
        this.f4171e = c0669a.f4184e;
        this.f4172f = c0669a.f4185f.m2061a();
        this.f4173g = c0669a.f4186g;
        this.f4174h = c0669a.f4187h;
        this.f4175i = c0669a.f4188i;
        this.f4176j = c0669a.f4189j;
        this.f4177k = c0669a.f4190k;
        this.f4178l = c0669a.f4191l;
    }

    /* JADX INFO: renamed from: a */
    public ane m4448a() {
        return this.f4167a;
    }

    /* JADX INFO: renamed from: b */
    public int m4451b() {
        return this.f4169c;
    }

    /* JADX INFO: renamed from: c */
    public boolean m4452c() {
        return this.f4169c >= 200 && this.f4169c < 300;
    }

    /* JADX INFO: renamed from: d */
    public amw m4453d() {
        return this.f4171e;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public String m4449a(String str) {
        return m4450a(str, null);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public String m4450a(String str, @Nullable String str2) {
        String strM2054a = this.f4172f.m2054a(str);
        return strM2054a != null ? strM2054a : str2;
    }

    /* JADX INFO: renamed from: e */
    public amx m4454e() {
        return this.f4172f;
    }

    @Nullable
    /* JADX INFO: renamed from: f */
    public anh m4455f() {
        return this.f4173g;
    }

    /* JADX INFO: renamed from: g */
    public C0669a m4456g() {
        return new C0669a(this);
    }

    @Nullable
    /* JADX INFO: renamed from: h */
    public ang m4457h() {
        return this.f4176j;
    }

    /* JADX INFO: renamed from: i */
    public ami m4458i() {
        ami amiVar = this.f4179m;
        if (amiVar != null) {
            return amiVar;
        }
        ami amiVarM1948a = ami.m1948a(this.f4172f);
        this.f4179m = amiVarM1948a;
        return amiVarM1948a;
    }

    /* JADX INFO: renamed from: j */
    public long m4459j() {
        return this.f4177k;
    }

    /* JADX INFO: renamed from: k */
    public long m4460k() {
        return this.f4178l;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.f4173g == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        this.f4173g.close();
    }

    public String toString() {
        return "Response{protocol=" + this.f4168b + ", code=" + this.f4169c + ", message=" + this.f4170d + ", url=" + this.f4167a.m4419a() + '}';
    }

    /* JADX INFO: renamed from: ang$a */
    /* JADX INFO: compiled from: Response.java */
    public static class C0669a {

        /* JADX INFO: renamed from: a */
        ane f4180a;

        /* JADX INFO: renamed from: b */
        anc f4181b;

        /* JADX INFO: renamed from: c */
        int f4182c;

        /* JADX INFO: renamed from: d */
        String f4183d;

        /* JADX INFO: renamed from: e */
        @Nullable
        amw f4184e;

        /* JADX INFO: renamed from: f */
        amx.C0209a f4185f;

        /* JADX INFO: renamed from: g */
        anh f4186g;

        /* JADX INFO: renamed from: h */
        ang f4187h;

        /* JADX INFO: renamed from: i */
        ang f4188i;

        /* JADX INFO: renamed from: j */
        ang f4189j;

        /* JADX INFO: renamed from: k */
        long f4190k;

        /* JADX INFO: renamed from: l */
        long f4191l;

        public C0669a() {
            this.f4182c = -1;
            this.f4185f = new amx.C0209a();
        }

        C0669a(ang angVar) {
            this.f4182c = -1;
            this.f4180a = angVar.f4167a;
            this.f4181b = angVar.f4168b;
            this.f4182c = angVar.f4169c;
            this.f4183d = angVar.f4170d;
            this.f4184e = angVar.f4171e;
            this.f4185f = angVar.f4172f.m2055b();
            this.f4186g = angVar.f4173g;
            this.f4187h = angVar.f4174h;
            this.f4188i = angVar.f4175i;
            this.f4189j = angVar.f4176j;
            this.f4190k = angVar.f4177k;
            this.f4191l = angVar.f4178l;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4468a(ane aneVar) {
            this.f4180a = aneVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4467a(anc ancVar) {
            this.f4181b = ancVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4463a(int i) {
            this.f4182c = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4471a(String str) {
            this.f4183d = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4465a(@Nullable amw amwVar) {
            this.f4184e = amwVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4472a(String str, String str2) {
            this.f4185f.m2060a(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4466a(amx amxVar) {
            this.f4185f = amxVar.m2055b();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4470a(@Nullable anh anhVar) {
            this.f4186g = anhVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4469a(@Nullable ang angVar) {
            if (angVar != null) {
                m4461a("networkResponse", angVar);
            }
            this.f4187h = angVar;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0669a m4475b(@Nullable ang angVar) {
            if (angVar != null) {
                m4461a("cacheResponse", angVar);
            }
            this.f4188i = angVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        private void m4461a(String str, ang angVar) {
            if (angVar.f4173g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            }
            if (angVar.f4174h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            }
            if (angVar.f4175i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            }
            if (angVar.f4176j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        /* JADX INFO: renamed from: c */
        public C0669a m4476c(@Nullable ang angVar) {
            if (angVar != null) {
                m4462d(angVar);
            }
            this.f4189j = angVar;
            return this;
        }

        /* JADX INFO: renamed from: d */
        private void m4462d(ang angVar) {
            if (angVar.f4173g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        /* JADX INFO: renamed from: a */
        public C0669a m4464a(long j) {
            this.f4190k = j;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0669a m4474b(long j) {
            this.f4191l = j;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public ang m4473a() {
            if (this.f4180a == null) {
                throw new IllegalStateException("request == null");
            }
            if (this.f4181b == null) {
                throw new IllegalStateException("protocol == null");
            }
            if (this.f4182c >= 0) {
                if (this.f4183d == null) {
                    throw new IllegalStateException("message == null");
                }
                return new ang(this);
            }
            throw new IllegalStateException("code < 0: " + this.f4182c);
        }
    }
}
