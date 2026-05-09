package p000;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import p000.amx;
import p000.ang;

/* JADX INFO: compiled from: CacheStrategy.java */
/* JADX INFO: loaded from: classes.dex */
public final class anq {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final ane f4234a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final ang f4235b;

    anq(ane aneVar, ang angVar) {
        this.f4234a = aneVar;
        this.f4235b = angVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002e, code lost:
    
        if (r3.m4458i().m1953d() == false) goto L19;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean m4532a(p000.ang r3, p000.ane r4) {
        /*
            int r0 = r3.m4451b()
            r1 = 0
            switch(r0) {
                case 200: goto L30;
                case 203: goto L30;
                case 204: goto L30;
                case 300: goto L30;
                case 301: goto L30;
                case 302: goto L9;
                case 307: goto L9;
                case 308: goto L30;
                case 404: goto L30;
                case 405: goto L30;
                case 410: goto L30;
                case 414: goto L30;
                case 501: goto L30;
                default: goto L8;
            }
        L8:
            goto L46
        L9:
            java.lang.String r0 = "Expires"
            java.lang.String r0 = r3.m4449a(r0)
            if (r0 != 0) goto L30
            ami r0 = r3.m4458i()
            int r0 = r0.m1952c()
            r2 = -1
            if (r0 != r2) goto L30
            ami r0 = r3.m4458i()
            boolean r0 = r0.m1954e()
            if (r0 != 0) goto L30
            ami r0 = r3.m4458i()
            boolean r0 = r0.m1953d()
            if (r0 == 0) goto L46
        L30:
            ami r3 = r3.m4458i()
            boolean r3 = r3.m1951b()
            if (r3 != 0) goto L45
            ami r3 = r4.m4427g()
            boolean r3 = r3.m1951b()
            if (r3 != 0) goto L45
            r1 = 1
        L45:
            return r1
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.anq.m4532a(ang, ane):boolean");
    }

    /* JADX INFO: renamed from: anq$a */
    /* JADX INFO: compiled from: CacheStrategy.java */
    public static class C0674a {

        /* JADX INFO: renamed from: a */
        final long f4236a;

        /* JADX INFO: renamed from: b */
        final ane f4237b;

        /* JADX INFO: renamed from: c */
        final ang f4238c;

        /* JADX INFO: renamed from: d */
        private Date f4239d;

        /* JADX INFO: renamed from: e */
        private String f4240e;

        /* JADX INFO: renamed from: f */
        private Date f4241f;

        /* JADX INFO: renamed from: g */
        private String f4242g;

        /* JADX INFO: renamed from: h */
        private Date f4243h;

        /* JADX INFO: renamed from: i */
        private long f4244i;

        /* JADX INFO: renamed from: j */
        private long f4245j;

        /* JADX INFO: renamed from: k */
        private String f4246k;

        /* JADX INFO: renamed from: l */
        private int f4247l;

        public C0674a(long j, ane aneVar, ang angVar) {
            this.f4247l = -1;
            this.f4236a = j;
            this.f4237b = aneVar;
            this.f4238c = angVar;
            if (angVar != null) {
                this.f4244i = angVar.m4459j();
                this.f4245j = angVar.m4460k();
                amx amxVarM4454e = angVar.m4454e();
                int iM2052a = amxVarM4454e.m2052a();
                for (int i = 0; i < iM2052a; i++) {
                    String strM2053a = amxVarM4454e.m2053a(i);
                    String strM2056b = amxVarM4454e.m2056b(i);
                    if ("Date".equalsIgnoreCase(strM2053a)) {
                        this.f4239d = aod.m4616a(strM2056b);
                        this.f4240e = strM2056b;
                    } else if ("Expires".equalsIgnoreCase(strM2053a)) {
                        this.f4243h = aod.m4616a(strM2056b);
                    } else if ("Last-Modified".equalsIgnoreCase(strM2053a)) {
                        this.f4241f = aod.m4616a(strM2056b);
                        this.f4242g = strM2056b;
                    } else if ("ETag".equalsIgnoreCase(strM2053a)) {
                        this.f4246k = strM2056b;
                    } else if ("Age".equalsIgnoreCase(strM2053a)) {
                        this.f4247l = aoe.m4624b(strM2056b, -1);
                    }
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public anq m4538a() {
            anq anqVarM4534b = m4534b();
            return (anqVarM4534b.f4234a == null || !this.f4237b.m4427g().m1958i()) ? anqVarM4534b : new anq(null, null);
        }

        /* JADX INFO: renamed from: b */
        private anq m4534b() {
            String str;
            String str2;
            if (this.f4238c == null) {
                return new anq(this.f4237b, null);
            }
            if (this.f4237b.m4428h() && this.f4238c.m4453d() == null) {
                return new anq(this.f4237b, null);
            }
            if (!anq.m4532a(this.f4238c, this.f4237b)) {
                return new anq(this.f4237b, null);
            }
            ami amiVarM4427g = this.f4237b.m4427g();
            if (amiVarM4427g.m1950a() || m4533a(this.f4237b)) {
                return new anq(this.f4237b, null);
            }
            ami amiVarM4458i = this.f4238c.m4458i();
            if (amiVarM4458i.m1959j()) {
                return new anq(null, this.f4238c);
            }
            long jM4536d = m4536d();
            long jM4535c = m4535c();
            if (amiVarM4427g.m1952c() != -1) {
                jM4535c = Math.min(jM4535c, TimeUnit.SECONDS.toMillis(amiVarM4427g.m1952c()));
            }
            long millis = 0;
            long millis2 = amiVarM4427g.m1957h() != -1 ? TimeUnit.SECONDS.toMillis(amiVarM4427g.m1957h()) : 0L;
            if (!amiVarM4458i.m1955f() && amiVarM4427g.m1956g() != -1) {
                millis = TimeUnit.SECONDS.toMillis(amiVarM4427g.m1956g());
            }
            if (!amiVarM4458i.m1950a()) {
                long j = jM4536d + millis2;
                if (j < jM4535c + millis) {
                    ang.C0669a c0669aM4456g = this.f4238c.m4456g();
                    if (j >= jM4535c) {
                        c0669aM4456g.m4472a("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (jM4536d > 86400000 && m4537e()) {
                        c0669aM4456g.m4472a("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new anq(null, c0669aM4456g.m4473a());
                }
            }
            if (this.f4246k != null) {
                str = "If-None-Match";
                str2 = this.f4246k;
            } else if (this.f4241f != null) {
                str = "If-Modified-Since";
                str2 = this.f4242g;
            } else if (this.f4239d != null) {
                str = "If-Modified-Since";
                str2 = this.f4240e;
            } else {
                return new anq(this.f4237b, null);
            }
            amx.C0209a c0209aM2055b = this.f4237b.m4423c().m2055b();
            ank.f4205a.mo2161a(c0209aM2055b, str, str2);
            return new anq(this.f4237b.m4426f().m4430a(c0209aM2055b.m2061a()).m4440b(), this.f4238c);
        }

        /* JADX INFO: renamed from: c */
        private long m4535c() {
            long time;
            long time2;
            if (this.f4238c.m4458i().m1952c() != -1) {
                return TimeUnit.SECONDS.toMillis(r0.m1952c());
            }
            if (this.f4243h != null) {
                if (this.f4239d != null) {
                    time2 = this.f4239d.getTime();
                } else {
                    time2 = this.f4245j;
                }
                long time3 = this.f4243h.getTime() - time2;
                if (time3 > 0) {
                    return time3;
                }
                return 0L;
            }
            if (this.f4241f == null || this.f4238c.m4448a().m4419a().m2090k() != null) {
                return 0L;
            }
            if (this.f4239d != null) {
                time = this.f4239d.getTime();
            } else {
                time = this.f4244i;
            }
            long time4 = time - this.f4241f.getTime();
            if (time4 > 0) {
                return time4 / 10;
            }
            return 0L;
        }

        /* JADX INFO: renamed from: d */
        private long m4536d() {
            long jMax = this.f4239d != null ? Math.max(0L, this.f4245j - this.f4239d.getTime()) : 0L;
            if (this.f4247l != -1) {
                jMax = Math.max(jMax, TimeUnit.SECONDS.toMillis(this.f4247l));
            }
            return jMax + (this.f4245j - this.f4244i) + (this.f4236a - this.f4245j);
        }

        /* JADX INFO: renamed from: e */
        private boolean m4537e() {
            return this.f4238c.m4458i().m1952c() == -1 && this.f4243h == null;
        }

        /* JADX INFO: renamed from: a */
        private static boolean m4533a(ane aneVar) {
            return (aneVar.m4421a("If-Modified-Since") == null && aneVar.m4421a("If-None-Match") == null) ? false : true;
        }
    }
}
