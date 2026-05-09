package p000;

import java.util.Locale;
import org.json.JSONObject;
import p000.C2110sm;

/* JADX INFO: renamed from: ta */
/* JADX INFO: compiled from: ResponseInfo.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2125ta {

    /* JADX INFO: renamed from: a */
    public final int f12730a;

    /* JADX INFO: renamed from: b */
    public final String f12731b;

    /* JADX INFO: renamed from: c */
    public final String f12732c;

    /* JADX INFO: renamed from: d */
    public final String f12733d;

    /* JADX INFO: renamed from: e */
    public final String f12734e;

    /* JADX INFO: renamed from: f */
    public final long f12735f;

    /* JADX INFO: renamed from: g */
    public final String f12736g;

    /* JADX INFO: renamed from: h */
    public final String f12737h;

    /* JADX INFO: renamed from: i */
    public final int f12738i;

    /* JADX INFO: renamed from: j */
    public final String f12739j;

    /* JADX INFO: renamed from: k */
    public final String f12740k = C2127tc.m11630a().f12757a;

    /* JADX INFO: renamed from: l */
    public final long f12741l = System.currentTimeMillis() / 1000;

    /* JADX INFO: renamed from: m */
    public final long f12742m;

    /* JADX INFO: renamed from: n */
    public final C2137tm f12743n;

    /* JADX INFO: renamed from: o */
    public final long f12744o;

    /* JADX INFO: renamed from: p */
    public final JSONObject f12745p;

    /* JADX INFO: renamed from: a */
    public static boolean m11615a(int i) {
        return i == -1 || i == -1003 || i == -1004 || i == -1001 || i == -1005;
    }

    private C2125ta(JSONObject jSONObject, int i, String str, String str2, String str3, String str4, String str5, String str6, int i2, long j, long j2, String str7, C2137tm c2137tm, long j3) {
        this.f12745p = jSONObject;
        this.f12730a = i;
        this.f12731b = str;
        this.f12732c = str2;
        this.f12733d = str3;
        this.f12736g = str4;
        this.f12739j = str5;
        this.f12735f = j;
        this.f12734e = str7;
        this.f12737h = str6;
        this.f12738i = i2;
        this.f12742m = j2;
        this.f12743n = c2137tm;
        this.f12744o = j3;
    }

    /* JADX INFO: renamed from: a */
    public static C2125ta m11613a(JSONObject jSONObject, final int i, final String str, String str2, String str3, final String str4, final String str5, String str6, final int i2, final long j, final long j2, String str7, C2137tm c2137tm, final long j3) {
        C2137tm c2137tm2;
        String str8 = (str6 + "").split(":")[0];
        final String strSubstring = str8.substring(Math.max(0, str8.indexOf("/") + 1));
        C2125ta c2125ta = new C2125ta(jSONObject, i, str, str2, str3, str4, str5, strSubstring, i2, j, j2, str7, c2137tm, j3);
        if (C2109sl.f12644a) {
            c2137tm2 = c2137tm;
        } else {
            c2137tm2 = c2137tm;
            if (c2137tm2 == null) {
                return c2125ta;
            }
        }
        final String str9 = c2125ta.f12741l + "";
        C2110sm.m11545a(c2137tm2, new C2110sm.a() { // from class: ta.1
            @Override // p000.C2110sm.a
            /* JADX INFO: renamed from: a */
            public String mo11552a() {
                return C2146tv.m11718a(new String[]{i + "", str, str4, strSubstring, i2 + "", j + "", str9, j2 + "", C2125ta.m11618c(str5), j3 + ""}, ",");
            }
        });
        return c2125ta;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String m11618c(java.lang.String r4) {
        /*
            if (r4 == 0) goto L7b
            java.lang.String r0 = "/"
            boolean r0 = r4.startsWith(r0)
            if (r0 != 0) goto Lc
            goto L7b
        Lc:
            java.lang.String r0 = "/"
            boolean r0 = r0.equals(r4)
            if (r0 == 0) goto L17
            java.lang.String r4 = "form"
            return r4
        L17:
            r0 = 47
            r1 = 1
            int r0 = r4.indexOf(r0, r1)
            if (r0 >= r1) goto L23
            java.lang.String r4 = ""
            return r4
        L23:
            java.lang.String r4 = r4.substring(r1, r0)
            r0 = -1
            int r2 = r4.hashCode()
            r3 = -1072430054(0xffffffffc014041a, float:-2.3127503)
            if (r2 == r3) goto L5e
            r3 = 111375(0x1b30f, float:1.5607E-40)
            if (r2 == r3) goto L54
            r3 = 3030893(0x2e3f6d, float:4.247186E-39)
            if (r2 == r3) goto L4b
            r1 = 103949059(0x6322303, float:3.3503802E-35)
            if (r2 == r1) goto L41
            goto L68
        L41:
            java.lang.String r1 = "mkblk"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L68
            r1 = 0
            goto L69
        L4b:
            java.lang.String r2 = "bput"
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L68
            goto L69
        L54:
            java.lang.String r1 = "put"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L68
            r1 = 3
            goto L69
        L5e:
            java.lang.String r1 = "mkfile"
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L68
            r1 = 2
            goto L69
        L68:
            r1 = -1
        L69:
            switch(r1) {
                case 0: goto L78;
                case 1: goto L75;
                case 2: goto L72;
                case 3: goto L6f;
                default: goto L6c;
            }
        L6c:
            java.lang.String r4 = ""
            return r4
        L6f:
            java.lang.String r4 = "put"
            return r4
        L72:
            java.lang.String r4 = "mkfile"
            return r4
        L75:
            java.lang.String r4 = "bput"
            return r4
        L78:
            java.lang.String r4 = "mkblk"
            return r4
        L7b:
            java.lang.String r4 = ""
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2125ta.m11618c(java.lang.String):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    public static C2125ta m11614a(C2137tm c2137tm) {
        return m11613a(null, -6, "", "", "", "", "", "", 80, 0L, 0L, "file or data size is zero", c2137tm, 0L);
    }

    /* JADX INFO: renamed from: b */
    public static C2125ta m11617b(C2137tm c2137tm) {
        return m11613a(null, -2, "", "", "", "", "", "", 80, -1L, -1L, "cancelled by user", c2137tm, 0L);
    }

    /* JADX INFO: renamed from: a */
    public static C2125ta m11612a(String str, C2137tm c2137tm) {
        return m11613a(null, -4, "", "", "", "", "", "", 80, 0L, 0L, str, c2137tm, 0L);
    }

    /* JADX INFO: renamed from: a */
    public static C2125ta m11611a(String str) {
        return m11613a(null, -5, "", "", "", "", "", "", 80, 0L, 0L, str, null, 0L);
    }

    /* JADX INFO: renamed from: a */
    public static C2125ta m11610a(Exception exc, C2137tm c2137tm) {
        return m11613a(null, -3, "", "", "", "", "", "", 80, 0L, 0L, exc.getMessage(), c2137tm, 0L);
    }

    /* JADX INFO: renamed from: a */
    public static C2125ta m11609a(int i, C2137tm c2137tm) {
        return m11613a(null, i, "", "", "", "", "", "", 80, 0L, 0L, "Network error during preQuery", c2137tm, 0L);
    }

    /* JADX INFO: renamed from: a */
    public boolean m11619a() {
        return this.f12730a == -2;
    }

    /* JADX INFO: renamed from: b */
    public boolean m11620b() {
        return this.f12730a == 200 && this.f12734e == null && (m11626h() || this.f12745p != null);
    }

    /* JADX INFO: renamed from: c */
    public boolean m11621c() {
        return this.f12730a == -1 || this.f12730a == -1003 || this.f12730a == -1004 || this.f12730a == -1001 || this.f12730a == -1005;
    }

    /* JADX INFO: renamed from: d */
    public boolean m11622d() {
        return (this.f12730a >= 500 && this.f12730a < 600 && this.f12730a != 579) || this.f12730a == 996;
    }

    /* JADX INFO: renamed from: e */
    public boolean m11623e() {
        return m11621c() || m11622d();
    }

    /* JADX INFO: renamed from: f */
    public boolean m11624f() {
        return !m11619a() && (m11623e() || this.f12730a == 406 || ((this.f12730a == 200 && this.f12734e != null) || (m11625g() && !this.f12743n.m11693a())));
    }

    /* JADX INFO: renamed from: g */
    public boolean m11625g() {
        return this.f12730a < 500 && this.f12730a >= 200 && !m11626h() && this.f12745p == null;
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "{ver:%s,ResponseInfo:%s,status:%d, reqId:%s, xlog:%s, xvia:%s, host:%s, path:%s, ip:%s, port:%d, duration:%d s, time:%d, sent:%d,error:%s}", "7.3.15", this.f12740k, Integer.valueOf(this.f12730a), this.f12731b, this.f12732c, this.f12733d, this.f12736g, this.f12739j, this.f12737h, Integer.valueOf(this.f12738i), Long.valueOf(this.f12735f), Long.valueOf(this.f12741l), Long.valueOf(this.f12742m), this.f12734e);
    }

    /* JADX INFO: renamed from: h */
    public boolean m11626h() {
        return this.f12731b != null;
    }
}
