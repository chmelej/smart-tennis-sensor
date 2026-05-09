package p000;

import java.io.File;
import java.io.IOException;
import org.json.JSONObject;
import p000.AbstractC2112so;
import p000.C2110sm;
import p000.C2128td;

/* JADX INFO: renamed from: tn */
/* JADX INFO: compiled from: UploadManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2138tn {

    /* JADX INFO: renamed from: a */
    private final C2128td f12831a;

    /* JADX INFO: renamed from: b */
    private final C2115sr f12832b;

    public C2138tn() {
        this(new C2128td.a().m11653a());
    }

    public C2138tn(C2128td c2128td) {
        this.f12831a = c2128td;
        this.f12832b = new C2115sr(c2128td.f12761c, c2128td.f12764f, c2128td.f12765g, c2128td.f12767i, c2128td.f12768j);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m11696a(String str, byte[] bArr, File file, String str2, C2137tm c2137tm, InterfaceC2135tk interfaceC2135tk) {
        String str3;
        C2125ta c2125taM11611a;
        if (interfaceC2135tk == null) {
            throw new IllegalArgumentException("no UpCompletionHandler");
        }
        if (file == null && bArr == null) {
            str3 = "no input data";
        } else {
            str3 = (str2 == null || str2.equals("")) ? "no token" : null;
        }
        if (str3 != null) {
            c2125taM11611a = C2125ta.m11612a(str3, c2137tm);
        } else if (c2137tm == C2137tm.f12827a || c2137tm == null) {
            c2125taM11611a = C2125ta.m11611a("invalid token");
        } else {
            c2125taM11611a = ((file == null || file.length() != 0) && (bArr == null || bArr.length != 0)) ? null : C2125ta.m11614a(c2137tm);
        }
        if (c2125taM11611a == null) {
            return false;
        }
        interfaceC2135tk.mo11690a(str, c2125taM11611a, null);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public static a m11698b(InterfaceC2135tk interfaceC2135tk, long j) {
        return new a(interfaceC2135tk, j);
    }

    /* JADX INFO: renamed from: a */
    public void m11700a(String str, String str2, String str3, InterfaceC2135tk interfaceC2135tk, C2139to c2139to) {
        m11699a(new File(str), str2, str3, interfaceC2135tk, c2139to);
    }

    /* JADX INFO: renamed from: a */
    public void m11699a(final File file, final String str, String str2, final InterfaceC2135tk interfaceC2135tk, final C2139to c2139to) {
        final C2137tm c2137tmM11692a = C2137tm.m11692a(str2);
        if (m11696a(str, null, file, str2, c2137tmM11692a, interfaceC2135tk)) {
            return;
        }
        this.f12831a.f12769k.mo11558a(str2, new AbstractC2112so.a() { // from class: tn.1
            @Override // p000.AbstractC2112so.a
            /* JADX INFO: renamed from: a */
            public void mo11564a() throws IOException {
                if (file.length() <= C2138tn.this.f12831a.f12763e) {
                    C2129te.m11657a(C2138tn.this.f12832b, C2138tn.this.f12831a, file, str, c2137tmM11692a, interfaceC2135tk, c2139to);
                } else {
                    C2142tr.m11707a(new RunnableC2133ti(C2138tn.this.f12832b, C2138tn.this.f12831a, file, str, c2137tmM11692a, C2138tn.m11698b(interfaceC2135tk, file != null ? file.length() : 0L), c2139to, C2138tn.this.f12831a.f12760b.mo11636a(str, file)));
                }
            }

            @Override // p000.AbstractC2112so.a
            /* JADX INFO: renamed from: a */
            public void mo11565a(int i) {
                C2125ta c2125taM11611a;
                if (C2125ta.m11615a(i)) {
                    c2125taM11611a = C2125ta.m11609a(i, c2137tmM11692a);
                } else {
                    c2125taM11611a = C2125ta.m11611a("invalid token");
                }
                interfaceC2135tk.mo11690a(str, c2125taM11611a, null);
            }
        });
    }

    /* JADX INFO: renamed from: tn$a */
    /* JADX INFO: compiled from: UploadManager.java */
    static class a implements InterfaceC2135tk {

        /* JADX INFO: renamed from: a */
        final InterfaceC2135tk f12839a;

        /* JADX INFO: renamed from: b */
        final long f12840b = System.currentTimeMillis();

        /* JADX INFO: renamed from: c */
        final long f12841c;

        a(InterfaceC2135tk interfaceC2135tk, long j) {
            this.f12839a = interfaceC2135tk;
            this.f12841c = j;
        }

        @Override // p000.InterfaceC2135tk
        /* JADX INFO: renamed from: a */
        public void mo11690a(final String str, final C2125ta c2125ta, final JSONObject jSONObject) {
            if (C2109sl.f12644a) {
                final long jCurrentTimeMillis = System.currentTimeMillis();
                C2110sm.m11548b(c2125ta.f12743n, new C2110sm.a() { // from class: tn.a.1
                    @Override // p000.C2110sm.a
                    /* JADX INFO: renamed from: a */
                    public String mo11552a() {
                        return C2146tv.m11718a(new String[]{c2125ta.f12730a + "", c2125ta.f12731b, c2125ta.f12736g, c2125ta.f12737h, c2125ta.f12738i + "", (jCurrentTimeMillis - a.this.f12840b) + "", c2125ta.f12741l + "", a.this.f12841c + "", "block", a.this.f12841c + ""}, ",");
                    }
                });
            }
            C2142tr.m11707a(new Runnable() { // from class: tn.a.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        a.this.f12839a.mo11690a(str, c2125ta, jSONObject);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
            });
        }
    }
}
