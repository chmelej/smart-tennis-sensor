package p000;

import android.util.Log;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* JADX INFO: renamed from: te */
/* JADX INFO: compiled from: FormUploader.java */
/* JADX INFO: loaded from: classes.dex */
final class C2129te {
    /* JADX INFO: renamed from: a */
    static void m11657a(C2115sr c2115sr, C2128td c2128td, File file, String str, C2137tm c2137tm, InterfaceC2135tk interfaceC2135tk, C2139to c2139to) throws IOException {
        m11658a(null, file, str, c2137tm, interfaceC2135tk, c2139to, c2115sr, c2128td);
    }

    /* JADX INFO: renamed from: a */
    private static void m11658a(byte[] bArr, File file, final String str, C2137tm c2137tm, InterfaceC2135tk interfaceC2135tk, C2139to c2139to, C2115sr c2115sr, C2128td c2128td) throws IOException {
        C2145tu c2145tu = new C2145tu();
        C2121sx c2121sx = new C2121sx();
        if (str != null) {
            c2145tu.m11714a("key", str);
            c2121sx.f12721d = str;
        } else {
            c2121sx.f12721d = "?";
        }
        if (file != null) {
            c2121sx.f12721d = file.getName();
        }
        c2145tu.m11714a("token", c2137tm.f12828b);
        final C2139to c2139toM11703a = c2139to != null ? c2139to : C2139to.m11703a();
        c2145tu.m11715a(c2139toM11703a.f12849a);
        long jM11710a = 0;
        if (file != null) {
            try {
                jM11710a = C2144tt.m11710a(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            jM11710a = C2144tt.m11711a(bArr);
        }
        c2145tu.m11714a("crc32", "" + jM11710a);
        InterfaceC2122sy interfaceC2122sy = new InterfaceC2122sy() { // from class: te.1
            @Override // p000.InterfaceC2122sy
            /* JADX INFO: renamed from: a */
            public void mo11603a(long j, long j2) {
                double d = j / j2;
                if (d > 0.95d) {
                    d = 0.95d;
                }
                c2139toM11703a.f12852d.mo11691a(str, d);
            }
        };
        c2121sx.f12718a = bArr;
        c2121sx.f12719b = file;
        c2121sx.f12722e = c2139toM11703a.f12850b;
        c2121sx.f12720c = c2145tu;
        String strMo11555a = c2128td.f12769k.mo11555a(c2137tm.f12828b, c2128td.f12770l, (String) null);
        Log.d("Qiniu.FormUploader", "upload use up host " + strMo11555a);
        c2115sr.m11578a(strMo11555a, c2121sx, c2137tm, interfaceC2122sy, new AnonymousClass2(c2139toM11703a, interfaceC2135tk, str, c2128td, c2137tm, strMo11555a, c2115sr, c2121sx, interfaceC2122sy), c2139toM11703a.f12853e);
    }

    /* JADX INFO: renamed from: te$2, reason: invalid class name */
    /* JADX INFO: compiled from: FormUploader.java */
    static class AnonymousClass2 implements InterfaceC2116ss {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ C2139to f12786a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ InterfaceC2135tk f12787b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ String f12788c;

        /* JADX INFO: renamed from: d */
        final /* synthetic */ C2128td f12789d;

        /* JADX INFO: renamed from: e */
        final /* synthetic */ C2137tm f12790e;

        /* JADX INFO: renamed from: f */
        final /* synthetic */ String f12791f;

        /* JADX INFO: renamed from: g */
        final /* synthetic */ C2115sr f12792g;

        /* JADX INFO: renamed from: h */
        final /* synthetic */ C2121sx f12793h;

        /* JADX INFO: renamed from: i */
        final /* synthetic */ InterfaceC2122sy f12794i;

        AnonymousClass2(C2139to c2139to, InterfaceC2135tk interfaceC2135tk, String str, C2128td c2128td, C2137tm c2137tm, String str2, C2115sr c2115sr, C2121sx c2121sx, InterfaceC2122sy interfaceC2122sy) {
            this.f12786a = c2139to;
            this.f12787b = interfaceC2135tk;
            this.f12788c = str;
            this.f12789d = c2128td;
            this.f12790e = c2137tm;
            this.f12791f = str2;
            this.f12792g = c2115sr;
            this.f12793h = c2121sx;
            this.f12794i = interfaceC2122sy;
        }

        @Override // p000.InterfaceC2116ss
        /* JADX INFO: renamed from: a */
        public void mo11561a(C2125ta c2125ta, JSONObject jSONObject) {
            if (c2125ta.m11621c() && !C2141tq.m11706a()) {
                this.f12786a.f12854f.mo11659a();
                if (!C2141tq.m11706a()) {
                    this.f12787b.mo11690a(this.f12788c, c2125ta, jSONObject);
                    return;
                }
            }
            if (c2125ta.m11620b()) {
                this.f12786a.f12852d.mo11691a(this.f12788c, 1.0d);
                this.f12787b.mo11690a(this.f12788c, c2125ta, jSONObject);
            } else {
                if (c2125ta.m11624f()) {
                    final String strMo11555a = this.f12789d.f12769k.mo11555a(this.f12790e.f12828b, this.f12789d.f12770l, this.f12791f);
                    Log.d("Qiniu.FormUploader", "retry upload first time use up host " + strMo11555a);
                    this.f12792g.m11578a(strMo11555a, this.f12793h, this.f12790e, this.f12794i, new InterfaceC2116ss() { // from class: te.2.1
                        @Override // p000.InterfaceC2116ss
                        /* JADX INFO: renamed from: a */
                        public void mo11561a(C2125ta c2125ta2, JSONObject jSONObject2) {
                            if (c2125ta2.m11620b()) {
                                AnonymousClass2.this.f12786a.f12852d.mo11691a(AnonymousClass2.this.f12788c, 1.0d);
                                AnonymousClass2.this.f12787b.mo11690a(AnonymousClass2.this.f12788c, c2125ta2, jSONObject2);
                            } else {
                                if (c2125ta2.m11624f()) {
                                    final String strMo11555a2 = AnonymousClass2.this.f12789d.f12769k.mo11555a(AnonymousClass2.this.f12790e.f12828b, AnonymousClass2.this.f12789d.f12770l, strMo11555a);
                                    Log.d("Qiniu.FormUploader", "retry upload second time use up host " + strMo11555a2);
                                    AnonymousClass2.this.f12792g.m11578a(strMo11555a2, AnonymousClass2.this.f12793h, AnonymousClass2.this.f12790e, AnonymousClass2.this.f12794i, new InterfaceC2116ss() { // from class: te.2.1.1
                                        @Override // p000.InterfaceC2116ss
                                        /* JADX INFO: renamed from: a */
                                        public void mo11561a(C2125ta c2125ta3, JSONObject jSONObject3) {
                                            if (c2125ta3.m11620b()) {
                                                AnonymousClass2.this.f12786a.f12852d.mo11691a(AnonymousClass2.this.f12788c, 1.0d);
                                            } else if (c2125ta3.m11624f()) {
                                                AnonymousClass2.this.f12789d.f12769k.mo11560b(strMo11555a2);
                                            }
                                            AnonymousClass2.this.f12787b.mo11690a(AnonymousClass2.this.f12788c, c2125ta3, jSONObject3);
                                        }
                                    }, AnonymousClass2.this.f12786a.f12853e);
                                    return;
                                }
                                AnonymousClass2.this.f12787b.mo11690a(AnonymousClass2.this.f12788c, c2125ta2, jSONObject2);
                            }
                        }
                    }, this.f12786a.f12853e);
                    return;
                }
                this.f12787b.mo11690a(this.f12788c, c2125ta, jSONObject);
            }
        }
    }
}
