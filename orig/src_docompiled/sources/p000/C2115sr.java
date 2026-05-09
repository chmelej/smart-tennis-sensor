package p000;

import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.IOException;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;
import p000.C2120sw;
import p000.C2145tu;
import p000.InterfaceC2114sq;
import p000.amz;
import p000.anb;
import p000.ane;

/* JADX INFO: renamed from: sr */
/* JADX INFO: compiled from: Client.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2115sr {

    /* JADX INFO: renamed from: a */
    private final InterfaceC2126tb f12674a;

    /* JADX INFO: renamed from: b */
    private anb f12675b;

    public C2115sr() {
        this(null, 10, 30, null, null);
    }

    public C2115sr(C2123sz c2123sz, int i, int i2, InterfaceC2126tb interfaceC2126tb, final InterfaceC2118su interfaceC2118su) {
        this.f12674a = interfaceC2126tb;
        anb.C0214a c0214a = new anb.C0214a();
        if (c2123sz != null) {
            c0214a.m2168a(c2123sz.m11604a());
            if (c2123sz.f12725c != null && c2123sz.f12726d != null) {
                c0214a.m2166a(c2123sz.m11605b());
            }
        }
        if (interfaceC2118su != null) {
            c0214a.m2167a(new amu() { // from class: sr.1
                @Override // p000.amu
                /* JADX INFO: renamed from: a */
                public List<InetAddress> mo2025a(String str) {
                    try {
                        return interfaceC2118su.m11586a(str);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return amu.f1914c.mo2025a(str);
                    }
                }
            });
        }
        c0214a.m2169a().add(new amz() { // from class: sr.2
            @Override // p000.amz
            /* JADX INFO: renamed from: a */
            public ang mo2114a(amz.InterfaceC0211a interfaceC0211a) {
                String string;
                ane aneVarMo2115a = interfaceC0211a.mo2115a();
                long jCurrentTimeMillis = System.currentTimeMillis();
                ang angVarMo2116a = interfaceC0211a.mo2116a(aneVarMo2115a);
                long jCurrentTimeMillis2 = System.currentTimeMillis();
                a aVar = (a) aneVarMo2115a.m4425e();
                try {
                    string = interfaceC0211a.mo2117b().mo1981a().getRemoteSocketAddress().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                    string = "";
                }
                aVar.f12690a = string;
                aVar.f12691b = jCurrentTimeMillis2 - jCurrentTimeMillis;
                return angVarMo2116a;
            }
        });
        c0214a.m2165a(i, TimeUnit.SECONDS);
        c0214a.m2170b(i2, TimeUnit.SECONDS);
        c0214a.m2172c(0L, TimeUnit.SECONDS);
        this.f12675b = c0214a.m2171b();
    }

    /* JADX INFO: renamed from: a */
    private static String m11569a(ang angVar) {
        String strM4450a = angVar.m4450a("X-Via", "");
        if (!strM4450a.equals("")) {
            return strM4450a;
        }
        String strM4450a2 = angVar.m4450a("X-Px", "");
        if (!strM4450a2.equals("")) {
            return strM4450a2;
        }
        String strM4450a3 = angVar.m4450a("Fw-Via", "");
        return !strM4450a3.equals("") ? strM4450a3 : strM4450a3;
    }

    /* JADX INFO: renamed from: b */
    private static String m11574b(ang angVar) {
        ana anaVarMo4479a = angVar.m4455f().mo4479a();
        if (anaVarMo4479a == null) {
            return "";
        }
        return anaVarMo4479a.m2124a() + "/" + anaVarMo4479a.m2126b();
    }

    /* JADX INFO: renamed from: a */
    private static JSONObject m11570a(byte[] bArr) {
        String str = new String(bArr, "utf-8");
        if (C2146tv.m11719a(str)) {
            return new JSONObject();
        }
        return new JSONObject(str);
    }

    /* JADX INFO: renamed from: a */
    private static C2125ta m11571a(ang angVar, String str, long j, C2137tm c2137tm, long j2) {
        String message;
        byte[] bArrM4482d;
        JSONObject jSONObjectM11570a;
        String str2;
        int iM4451b = angVar.m4451b();
        String strM4449a = angVar.m4449a("X-Reqid");
        String str3 = strM4449a == null ? null : strM4449a.trim().split(",")[0];
        try {
            bArrM4482d = angVar.m4455f().m4482d();
            message = null;
        } catch (IOException e) {
            message = e.getMessage();
            bArrM4482d = null;
        }
        if (m11574b(angVar).equals("application/json") && bArrM4482d != null) {
            try {
                jSONObjectM11570a = m11570a(bArrM4482d);
            } catch (Exception e2) {
                e = e2;
                jSONObjectM11570a = null;
            }
            try {
                str2 = angVar.m4451b() != 200 ? jSONObjectM11570a.optString("error", new String(bArrM4482d, "utf-8")) : message;
            } catch (Exception e3) {
                e = e3;
                Exception exc = e;
                if (angVar.m4451b() < 300) {
                    message = exc.getMessage();
                }
                str2 = message;
            }
        } else {
            jSONObjectM11570a = null;
            str2 = bArrM4482d == null ? "null body" : new String(bArrM4482d);
        }
        amy amyVarM4419a = angVar.m4448a().m4419a();
        return C2125ta.m11613a(jSONObjectM11570a, iM4451b, str3, angVar.m4449a("X-Log"), m11569a(angVar), amyVarM4419a.m2085f(), amyVarM4419a.m2087h(), str, amyVarM4419a.m2086g(), j, m11576c(angVar), str2, c2137tm, j2);
    }

    /* JADX INFO: renamed from: c */
    private static long m11576c(ang angVar) {
        try {
            anf anfVarM4424d = angVar.m4448a().m4424d();
            if (anfVarM4424d == null) {
                return 0L;
            }
            return anfVarM4424d.mo4445a();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static void m11575b(ang angVar, String str, long j, C2137tm c2137tm, long j2, final InterfaceC2116ss interfaceC2116ss) {
        final C2125ta c2125taM11571a = m11571a(angVar, str, j, c2137tm, j2);
        C2142tr.m11707a(new Runnable() { // from class: sr.3
            @Override // java.lang.Runnable
            public void run() {
                interfaceC2116ss.mo11561a(c2125taM11571a, c2125taM11571a.f12745p);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m11577a(final ane.C0666a c0666a, C2145tu c2145tu, final C2137tm c2137tm, final long j, final InterfaceC2116ss interfaceC2116ss) {
        if (c2145tu != null) {
            c2145tu.m11716a(new C2145tu.a() { // from class: sr.4
                @Override // p000.C2145tu.a
                /* JADX INFO: renamed from: a */
                public void mo11581a(String str, Object obj) {
                    c0666a.m4437a(str, obj.toString());
                }
            });
        }
        if (c2137tm != null) {
            c0666a.m4437a("User-Agent", C2127tc.m11630a().m11634b(c2137tm.f12829c));
        } else {
            c0666a.m4437a("User-Agent", C2127tc.m11630a().m11634b("pandora"));
        }
        final a aVar = new a();
        this.f12675b.m2130a(c0666a.m4434a(aVar).m4440b()).mo1965a(new amk() { // from class: sr.5
            @Override // p000.amk
            /* JADX INFO: renamed from: a */
            public void mo1968a(amj amjVar, IOException iOException) {
                int i;
                iOException.printStackTrace();
                String message = iOException.getMessage();
                if (iOException instanceof InterfaceC2114sq.a) {
                    i = -2;
                } else if (iOException instanceof UnknownHostException) {
                    i = -1003;
                } else if (message != null && message.indexOf("Broken pipe") == 0) {
                    i = -1005;
                } else if (iOException instanceof SocketTimeoutException) {
                    i = -1001;
                } else {
                    i = iOException instanceof ConnectException ? -1004 : -1;
                }
                amy amyVarM4419a = amjVar.mo1964a().m4419a();
                interfaceC2116ss.mo11561a(C2125ta.m11613a(null, i, "", "", "", amyVarM4419a.m2085f(), amyVarM4419a.m2087h(), "", amyVarM4419a.m2086g(), aVar.f12691b, -1L, iOException.getMessage(), c2137tm, j), null);
            }

            @Override // p000.amk
            /* JADX INFO: renamed from: a */
            public void mo1967a(amj amjVar, ang angVar) {
                a aVar2 = (a) angVar.m4448a().m4425e();
                C2115sr.m11575b(angVar, aVar2.f12690a, aVar2.f12691b, c2137tm, j, interfaceC2116ss);
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m11580a(String str, byte[] bArr, int i, int i2, C2145tu c2145tu, C2137tm c2137tm, long j, InterfaceC2122sy interfaceC2122sy, InterfaceC2116ss interfaceC2116ss, InterfaceC2114sq interfaceC2114sq) {
        anf anfVarM4443a;
        Object objM11713a;
        String strM11627a = this.f12674a != null ? this.f12674a.m11627a(str) : str;
        if (bArr != null && bArr.length > 0) {
            ana anaVarM2123b = ana.m2123b("application/octet-stream");
            if (c2145tu != null && (objM11713a = c2145tu.m11713a(MIME.CONTENT_TYPE)) != null) {
                anaVarM2123b = ana.m2123b(objM11713a.toString());
            }
            anfVarM4443a = anf.m4444a(anaVarM2123b, bArr, i, i2);
        } else {
            anfVarM4443a = anf.m4443a((ana) null, new byte[0]);
        }
        anf anfVar = anfVarM4443a;
        m11577a(new ane.C0666a().m4435a(strM11627a).m4432a((interfaceC2122sy == null && interfaceC2114sq == null) ? anfVar : new C2117st(anfVar, interfaceC2122sy, j, interfaceC2114sq)), c2145tu, c2137tm, j, interfaceC2116ss);
    }

    /* JADX INFO: renamed from: a */
    public void m11578a(String str, C2121sx c2121sx, C2137tm c2137tm, InterfaceC2122sy interfaceC2122sy, InterfaceC2116ss interfaceC2116ss, InterfaceC2114sq interfaceC2114sq) {
        anf anfVarM4443a;
        long length;
        if (c2121sx.f12719b != null) {
            anfVarM4443a = anf.m4441a(ana.m2123b(c2121sx.f12722e), c2121sx.f12719b);
            length = c2121sx.f12719b.length();
        } else {
            anfVarM4443a = anf.m4443a(ana.m2123b(c2121sx.f12722e), c2121sx.f12718a);
            length = c2121sx.f12718a.length;
        }
        m11573a(str, c2121sx.f12720c, c2137tm, length, interfaceC2122sy, c2121sx.f12721d, anfVarM4443a, interfaceC2116ss, interfaceC2114sq);
    }

    /* JADX INFO: renamed from: a */
    private void m11573a(String str, C2145tu c2145tu, C2137tm c2137tm, long j, InterfaceC2122sy interfaceC2122sy, String str2, anf anfVar, InterfaceC2116ss interfaceC2116ss, InterfaceC2114sq interfaceC2114sq) {
        String strM11627a = this.f12674a != null ? this.f12674a.m11627a(str) : str;
        final C2120sw.a aVar = new C2120sw.a();
        aVar.m11597a("file", str2, anfVar);
        c2145tu.m11716a(new C2145tu.a() { // from class: sr.6
            @Override // p000.C2145tu.a
            /* JADX INFO: renamed from: a */
            public void mo11581a(String str3, Object obj) {
                aVar.m11596a(str3, obj.toString());
            }
        });
        aVar.m11595a(ana.m2123b("multipart/form-data"));
        C2120sw c2120swM11599a = aVar.m11599a();
        m11577a(new ane.C0666a().m4435a(strM11627a).m4432a((interfaceC2122sy == null && interfaceC2114sq == null) ? c2120swM11599a : new C2117st(c2120swM11599a, interfaceC2122sy, j, interfaceC2114sq)), (C2145tu) null, c2137tm, j, interfaceC2116ss);
    }

    /* JADX INFO: renamed from: a */
    public void m11579a(String str, C2145tu c2145tu, C2137tm c2137tm, InterfaceC2116ss interfaceC2116ss) {
        m11577a(new ane.C0666a().m4429a().m4435a(str), c2145tu, c2137tm, 0L, interfaceC2116ss);
    }

    /* JADX INFO: renamed from: sr$a */
    /* JADX INFO: compiled from: Client.java */
    static class a {

        /* JADX INFO: renamed from: a */
        public String f12690a;

        /* JADX INFO: renamed from: b */
        public long f12691b;

        private a() {
            this.f12690a = "";
            this.f12691b = -1L;
        }
    }
}
