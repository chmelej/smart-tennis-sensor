package p000;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.Nullable;
import org.android.spdy.SpdyRequest;
import p000.amx;

/* JADX INFO: compiled from: Request.java */
/* JADX INFO: loaded from: classes.dex */
public final class ane {

    /* JADX INFO: renamed from: a */
    final amy f4150a;

    /* JADX INFO: renamed from: b */
    final String f4151b;

    /* JADX INFO: renamed from: c */
    final amx f4152c;

    /* JADX INFO: renamed from: d */
    @Nullable
    final anf f4153d;

    /* JADX INFO: renamed from: e */
    final Map<Class<?>, Object> f4154e;

    /* JADX INFO: renamed from: f */
    private volatile ami f4155f;

    ane(C0666a c0666a) {
        this.f4150a = c0666a.f4156a;
        this.f4151b = c0666a.f4157b;
        this.f4152c = c0666a.f4158c.m2061a();
        this.f4153d = c0666a.f4159d;
        this.f4154e = anm.m4502a(c0666a.f4160e);
    }

    /* JADX INFO: renamed from: a */
    public amy m4419a() {
        return this.f4150a;
    }

    /* JADX INFO: renamed from: b */
    public String m4422b() {
        return this.f4151b;
    }

    /* JADX INFO: renamed from: c */
    public amx m4423c() {
        return this.f4152c;
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public String m4421a(String str) {
        return this.f4152c.m2054a(str);
    }

    @Nullable
    /* JADX INFO: renamed from: d */
    public anf m4424d() {
        return this.f4153d;
    }

    @Nullable
    /* JADX INFO: renamed from: e */
    public Object m4425e() {
        return m4420a(Object.class);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public <T> T m4420a(Class<? extends T> cls) {
        return cls.cast(this.f4154e.get(cls));
    }

    /* JADX INFO: renamed from: f */
    public C0666a m4426f() {
        return new C0666a(this);
    }

    /* JADX INFO: renamed from: g */
    public ami m4427g() {
        ami amiVar = this.f4155f;
        if (amiVar != null) {
            return amiVar;
        }
        ami amiVarM1948a = ami.m1948a(this.f4152c);
        this.f4155f = amiVarM1948a;
        return amiVarM1948a;
    }

    /* JADX INFO: renamed from: h */
    public boolean m4428h() {
        return this.f4150a.m2081c();
    }

    public String toString() {
        return "Request{method=" + this.f4151b + ", url=" + this.f4150a + ", tags=" + this.f4154e + '}';
    }

    /* JADX INFO: renamed from: ane$a */
    /* JADX INFO: compiled from: Request.java */
    public static class C0666a {

        /* JADX INFO: renamed from: a */
        amy f4156a;

        /* JADX INFO: renamed from: b */
        String f4157b;

        /* JADX INFO: renamed from: c */
        amx.C0209a f4158c;

        /* JADX INFO: renamed from: d */
        anf f4159d;

        /* JADX INFO: renamed from: e */
        Map<Class<?>, Object> f4160e;

        public C0666a() {
            this.f4160e = Collections.emptyMap();
            this.f4157b = SpdyRequest.GET_METHOD;
            this.f4158c = new amx.C0209a();
        }

        C0666a(ane aneVar) {
            Map<Class<?>, Object> linkedHashMap;
            this.f4160e = Collections.emptyMap();
            this.f4156a = aneVar.f4150a;
            this.f4157b = aneVar.f4151b;
            this.f4159d = aneVar.f4153d;
            if (aneVar.f4154e.isEmpty()) {
                linkedHashMap = Collections.emptyMap();
            } else {
                linkedHashMap = new LinkedHashMap<>(aneVar.f4154e);
            }
            this.f4160e = linkedHashMap;
            this.f4158c = aneVar.f4152c.m2055b();
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4431a(amy amyVar) {
            if (amyVar == null) {
                throw new NullPointerException("url == null");
            }
            this.f4156a = amyVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4435a(String str) {
            if (str == null) {
                throw new NullPointerException("url == null");
            }
            if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                str = "http:" + str.substring(3);
            } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                str = "https:" + str.substring(4);
            }
            return m4431a(amy.m2077e(str));
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4437a(String str, String str2) {
            this.f4158c.m2064c(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0666a m4439b(String str, String str2) {
            this.f4158c.m2060a(str, str2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0666a m4438b(String str) {
            this.f4158c.m2062b(str);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4430a(amx amxVar) {
            this.f4158c = amxVar.m2055b();
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4429a() {
            return m4436a(SpdyRequest.GET_METHOD, (anf) null);
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4432a(anf anfVar) {
            return m4436a(SpdyRequest.POST_METHOD, anfVar);
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4436a(String str, @Nullable anf anfVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            }
            if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            }
            if (anfVar != null && !aof.m4628c(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            }
            if (anfVar == null && aof.m4627b(str)) {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
            this.f4157b = str;
            this.f4159d = anfVar;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0666a m4434a(@Nullable Object obj) {
            return m4433a((Class<? super Object>) Object.class, obj);
        }

        /* JADX INFO: renamed from: a */
        public <T> C0666a m4433a(Class<? super T> cls, @Nullable T t) {
            if (cls == null) {
                throw new NullPointerException("type == null");
            }
            if (t == null) {
                this.f4160e.remove(cls);
            } else {
                if (this.f4160e.isEmpty()) {
                    this.f4160e = new LinkedHashMap();
                }
                this.f4160e.put(cls, cls.cast(t));
            }
            return this;
        }

        /* JADX INFO: renamed from: b */
        public ane m4440b() {
            if (this.f4156a == null) {
                throw new IllegalStateException("url == null");
            }
            return new ane(this);
        }
    }
}
