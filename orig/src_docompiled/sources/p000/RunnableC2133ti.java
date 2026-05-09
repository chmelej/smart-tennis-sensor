package p000;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: ti */
/* JADX INFO: compiled from: ResumeUploader.java */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC2133ti implements Runnable {

    /* JADX INFO: renamed from: a */
    private final long f12799a;

    /* JADX INFO: renamed from: b */
    private final String f12800b;

    /* JADX INFO: renamed from: c */
    private final InterfaceC2135tk f12801c;

    /* JADX INFO: renamed from: d */
    private final C2139to f12802d;

    /* JADX INFO: renamed from: e */
    private final C2115sr f12803e;

    /* JADX INFO: renamed from: f */
    private final C2128td f12804f;

    /* JADX INFO: renamed from: g */
    private final byte[] f12805g;

    /* JADX INFO: renamed from: h */
    private final String[] f12806h;

    /* JADX INFO: renamed from: i */
    private final C2145tu f12807i;

    /* JADX INFO: renamed from: j */
    private final long f12808j;

    /* JADX INFO: renamed from: k */
    private final String f12809k;

    /* JADX INFO: renamed from: l */
    private RandomAccessFile f12810l = null;

    /* JADX INFO: renamed from: m */
    private File f12811m;

    /* JADX INFO: renamed from: n */
    private long f12812n;

    /* JADX INFO: renamed from: o */
    private C2137tm f12813o;

    RunnableC2133ti(C2115sr c2115sr, C2128td c2128td, File file, String str, C2137tm c2137tm, final InterfaceC2135tk interfaceC2135tk, C2139to c2139to, String str2) {
        this.f12803e = c2115sr;
        this.f12804f = c2128td;
        this.f12811m = file;
        this.f12809k = str2;
        this.f12799a = file.length();
        this.f12800b = str;
        this.f12807i = new C2145tu().m11714a("Authorization", "UpToken " + c2137tm.f12828b);
        this.f12801c = new InterfaceC2135tk() { // from class: ti.1
            @Override // p000.InterfaceC2135tk
            /* JADX INFO: renamed from: a */
            public void mo11690a(String str3, C2125ta c2125ta, JSONObject jSONObject) {
                if (RunnableC2133ti.this.f12810l != null) {
                    try {
                        RunnableC2133ti.this.f12810l.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                interfaceC2135tk.mo11690a(str3, c2125ta, jSONObject);
            }
        };
        this.f12802d = c2139to == null ? C2139to.m11703a() : c2139to;
        this.f12805g = new byte[c2128td.f12762d];
        this.f12806h = new String[(int) (((this.f12799a + 4194304) - 1) / 4194304)];
        this.f12808j = file.lastModified();
        this.f12813o = c2137tm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public static boolean m11682c(C2125ta c2125ta, JSONObject jSONObject) {
        return c2125ta.f12730a == 200 && c2125ta.f12734e == null && (c2125ta.m11626h() || m11673a(jSONObject));
    }

    /* JADX INFO: renamed from: a */
    private static boolean m11673a(JSONObject jSONObject) {
        try {
            jSONObject.getString("ctx");
            jSONObject.getLong("crc32");
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public static boolean m11684d(C2125ta c2125ta, JSONObject jSONObject) {
        return c2125ta.f12730a < 500 && c2125ta.f12730a >= 200 && !c2125ta.m11626h() && !m11673a(jSONObject);
    }

    @Override // java.lang.Runnable
    public void run() {
        long jM11675b = m11675b();
        try {
            this.f12810l = new RandomAccessFile(this.f12811m, "r");
            m11665a(jM11675b, 0, this.f12804f.f12769k.mo11555a(this.f12813o.f12828b, this.f12804f.f12770l, (String) null));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            this.f12801c.mo11690a(this.f12800b, C2125ta.m11610a(e, this.f12813o), null);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11666a(String str, long j, int i, int i2, InterfaceC2122sy interfaceC2122sy, InterfaceC2116ss interfaceC2116ss, InterfaceC2134tj interfaceC2134tj) {
        String str2 = String.format(Locale.ENGLISH, "/mkblk/%d", Integer.valueOf(i));
        try {
            this.f12810l.seek(j);
            this.f12810l.read(this.f12805g, 0, i2);
            this.f12812n = C2144tt.m11712a(this.f12805g, 0, i2);
            m11669a(String.format("%s%s", str, str2), this.f12805g, 0, i2, interfaceC2122sy, interfaceC2116ss, interfaceC2134tj);
        } catch (IOException e) {
            this.f12801c.mo11690a(this.f12800b, C2125ta.m11610a(e, this.f12813o), null);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11667a(String str, long j, int i, String str2, InterfaceC2122sy interfaceC2122sy, InterfaceC2116ss interfaceC2116ss, InterfaceC2134tj interfaceC2134tj) {
        String str3 = String.format(Locale.ENGLISH, "/bput/%s/%d", str2, Integer.valueOf((int) (j % 4194304)));
        try {
            this.f12810l.seek(j);
            this.f12810l.read(this.f12805g, 0, i);
            this.f12812n = C2144tt.m11712a(this.f12805g, 0, i);
            m11669a(String.format("%s%s", str, str3), this.f12805g, 0, i, interfaceC2122sy, interfaceC2116ss, interfaceC2134tj);
        } catch (IOException e) {
            this.f12801c.mo11690a(this.f12800b, C2125ta.m11610a(e, this.f12813o), null);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11668a(String str, InterfaceC2116ss interfaceC2116ss, InterfaceC2134tj interfaceC2134tj) {
        String str2 = String.format(Locale.ENGLISH, "/mimeType/%s/fname/%s", C2147tw.m11721a(this.f12802d.f12850b), C2147tw.m11721a(this.f12811m.getName()));
        String str3 = this.f12800b != null ? String.format("/key/%s", C2147tw.m11721a(this.f12800b)) : "";
        String str4 = "";
        if (this.f12802d.f12849a.size() != 0) {
            String[] strArr = new String[this.f12802d.f12849a.size()];
            int i = 0;
            for (Map.Entry<String, String> entry : this.f12802d.f12849a.entrySet()) {
                strArr[i] = String.format(Locale.ENGLISH, "%s/%s", entry.getKey(), C2147tw.m11721a(entry.getValue()));
                i++;
            }
            str4 = "/" + C2146tv.m11718a(strArr, "/");
        }
        String str5 = String.format(Locale.ENGLISH, "/mkfile/%d%s%s%s", Long.valueOf(this.f12799a), str2, str3, str4);
        byte[] bytes = C2146tv.m11718a(this.f12806h, ",").getBytes();
        m11669a(String.format("%s%s", str, str5), bytes, 0, bytes.length, (InterfaceC2122sy) null, interfaceC2116ss, interfaceC2134tj);
    }

    /* JADX INFO: renamed from: a */
    private void m11669a(String str, byte[] bArr, int i, int i2, InterfaceC2122sy interfaceC2122sy, InterfaceC2116ss interfaceC2116ss, InterfaceC2134tj interfaceC2134tj) {
        this.f12803e.m11580a(str, bArr, i, i2, this.f12807i, this.f12813o, this.f12799a, interfaceC2122sy, interfaceC2116ss, interfaceC2134tj);
    }

    /* JADX INFO: renamed from: a */
    private long m11663a(long j) {
        long j2 = this.f12799a - j;
        return j2 < ((long) this.f12804f.f12762d) ? j2 : this.f12804f.f12762d;
    }

    /* JADX INFO: renamed from: b */
    private long m11676b(long j) {
        long j2 = this.f12799a - j;
        if (j2 < 4194304) {
            return j2;
        }
        return 4194304L;
    }

    /* JADX INFO: renamed from: a */
    private boolean m11672a() {
        return this.f12802d.f12853e.mo11568a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11665a(final long j, final int i, final String str) {
        if (m11672a()) {
            this.f12801c.mo11690a(this.f12800b, C2125ta.m11617b(this.f12813o), null);
        } else {
            if (j == this.f12799a) {
                m11668a(str, new InterfaceC2116ss() { // from class: ti.2
                    @Override // p000.InterfaceC2116ss
                    /* JADX INFO: renamed from: a */
                    public void mo11561a(C2125ta c2125ta, JSONObject jSONObject) {
                        String strMo11555a;
                        if (c2125ta.m11621c() && !C2141tq.m11706a()) {
                            RunnableC2133ti.this.f12802d.f12854f.mo11659a();
                            if (!C2141tq.m11706a()) {
                                RunnableC2133ti.this.f12801c.mo11690a(RunnableC2133ti.this.f12800b, c2125ta, jSONObject);
                                return;
                            }
                        }
                        if (c2125ta.m11620b()) {
                            RunnableC2133ti.this.m11680c();
                            RunnableC2133ti.this.f12802d.f12852d.mo11691a(RunnableC2133ti.this.f12800b, 1.0d);
                            RunnableC2133ti.this.f12801c.mo11690a(RunnableC2133ti.this.f12800b, c2125ta, jSONObject);
                        } else if (!c2125ta.m11624f() || i >= RunnableC2133ti.this.f12804f.f12766h + 1 || (strMo11555a = RunnableC2133ti.this.f12804f.f12769k.mo11555a(RunnableC2133ti.this.f12813o.f12828b, RunnableC2133ti.this.f12804f.f12770l, str)) == null) {
                            RunnableC2133ti.this.f12801c.mo11690a(RunnableC2133ti.this.f12800b, c2125ta, jSONObject);
                        } else {
                            RunnableC2133ti.this.m11665a(j, i + 1, strMo11555a);
                        }
                    }
                }, this.f12802d.f12853e);
                return;
            }
            final int iM11663a = (int) m11663a(j);
            InterfaceC2122sy interfaceC2122sy = new InterfaceC2122sy() { // from class: ti.3
                @Override // p000.InterfaceC2122sy
                /* JADX INFO: renamed from: a */
                public void mo11603a(long j2, long j3) {
                    double d = (j + j2) / j3;
                    if (d > 0.95d) {
                        d = 0.95d;
                    }
                    RunnableC2133ti.this.f12802d.f12852d.mo11691a(RunnableC2133ti.this.f12800b, d);
                }
            };
            InterfaceC2116ss interfaceC2116ss = new InterfaceC2116ss() { // from class: ti.4
                @Override // p000.InterfaceC2116ss
                /* JADX INFO: renamed from: a */
                public void mo11561a(C2125ta c2125ta, JSONObject jSONObject) {
                    String string;
                    Exception e;
                    long j2;
                    if (c2125ta.m11621c() && !C2141tq.m11706a()) {
                        RunnableC2133ti.this.f12802d.f12854f.mo11659a();
                        if (!C2141tq.m11706a()) {
                            RunnableC2133ti.this.f12801c.mo11690a(RunnableC2133ti.this.f12800b, c2125ta, jSONObject);
                            return;
                        }
                    }
                    if (c2125ta.m11619a()) {
                        RunnableC2133ti.this.f12801c.mo11690a(RunnableC2133ti.this.f12800b, c2125ta, jSONObject);
                        return;
                    }
                    if (!RunnableC2133ti.m11682c(c2125ta, jSONObject)) {
                        String strMo11555a = RunnableC2133ti.this.f12804f.f12769k.mo11555a(RunnableC2133ti.this.f12813o.f12828b, RunnableC2133ti.this.f12804f.f12770l, str);
                        if (c2125ta.f12730a != 701 || i >= RunnableC2133ti.this.f12804f.f12766h) {
                            if (strMo11555a == null || ((!RunnableC2133ti.m11684d(c2125ta, jSONObject) && !c2125ta.m11624f()) || i >= RunnableC2133ti.this.f12804f.f12766h)) {
                                RunnableC2133ti.this.f12801c.mo11690a(RunnableC2133ti.this.f12800b, c2125ta, jSONObject);
                                return;
                            } else {
                                RunnableC2133ti.this.m11665a(j, i + 1, strMo11555a);
                                return;
                            }
                        }
                        RunnableC2133ti.this.m11665a((j / 4194304) * 4194304, i + 1, str);
                        return;
                    }
                    if (jSONObject == null && i < RunnableC2133ti.this.f12804f.f12766h) {
                        RunnableC2133ti.this.m11665a(j, i + 1, RunnableC2133ti.this.f12804f.f12769k.mo11555a(RunnableC2133ti.this.f12813o.f12828b, RunnableC2133ti.this.f12804f.f12770l, str));
                        return;
                    }
                    try {
                        string = jSONObject.getString("ctx");
                    } catch (Exception e2) {
                        string = null;
                        e = e2;
                    }
                    try {
                        j2 = jSONObject.getLong("crc32");
                    } catch (Exception e3) {
                        e = e3;
                        e.printStackTrace();
                        j2 = 0;
                    }
                    if ((string == null || j2 != RunnableC2133ti.this.f12812n) && i < RunnableC2133ti.this.f12804f.f12766h) {
                        RunnableC2133ti.this.m11665a(j, i + 1, RunnableC2133ti.this.f12804f.f12769k.mo11555a(RunnableC2133ti.this.f12813o.f12828b, RunnableC2133ti.this.f12804f.f12770l, str));
                    } else {
                        RunnableC2133ti.this.f12806h[(int) (j / 4194304)] = string;
                        RunnableC2133ti.this.m11681c(j + ((long) iM11663a));
                        RunnableC2133ti.this.m11665a(j + ((long) iM11663a), i, str);
                    }
                }
            };
            if (j % 4194304 == 0) {
                m11666a(str, j, (int) m11676b(j), iM11663a, interfaceC2122sy, interfaceC2116ss, this.f12802d.f12853e);
            } else {
                m11667a(str, j, iM11663a, this.f12806h[(int) (j / 4194304)], interfaceC2122sy, interfaceC2116ss, this.f12802d.f12853e);
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private long m11675b() {
        byte[] bArrMo11661a;
        if (this.f12804f.f12759a == null || (bArrMo11661a = this.f12804f.f12759a.mo11661a(this.f12809k)) == null) {
            return 0L;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArrMo11661a));
            long jOptLong = jSONObject.optLong("offset", 0L);
            long jOptLong2 = jSONObject.optLong("modify_time", 0L);
            long jOptLong3 = jSONObject.optLong("size", 0L);
            JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("contexts");
            if (jOptLong == 0 || jOptLong2 != this.f12808j || jOptLong3 != this.f12799a || jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() == 0) {
                return 0L;
            }
            for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                this.f12806h[i] = jSONArrayOptJSONArray.optString(i);
            }
            return jOptLong;
        } catch (JSONException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m11680c() {
        if (this.f12804f.f12759a != null) {
            this.f12804f.f12759a.mo11662b(this.f12809k);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m11681c(long j) {
        if (this.f12804f.f12759a == null || j == 0) {
            return;
        }
        this.f12804f.f12759a.mo11660a(this.f12809k, String.format(Locale.ENGLISH, "{\"size\":%d,\"offset\":%d, \"modify_time\":%d, \"contexts\":[%s]}", Long.valueOf(this.f12799a), Long.valueOf(j), Long.valueOf(this.f12808j), C2146tv.m11717a(this.f12806h)).getBytes());
    }
}
