package p000;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: ImprintHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class adk {

    /* JADX INFO: renamed from: a */
    private static final byte[] f415a = "pbl0".getBytes();

    /* JADX INFO: renamed from: e */
    private static adk f416e;

    /* JADX INFO: renamed from: b */
    private aea f417b;

    /* JADX INFO: renamed from: c */
    private C0013a f418c = new C0013a();

    /* JADX INFO: renamed from: d */
    private aen f419d = null;

    /* JADX INFO: renamed from: f */
    private Context f420f;

    adk(Context context) {
        this.f420f = context;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized adk m357a(Context context) {
        if (f416e == null) {
            f416e = new adk(context);
            f416e.m368c();
        }
        return f416e;
    }

    /* JADX INFO: renamed from: a */
    public void m364a(aea aeaVar) {
        this.f417b = aeaVar;
    }

    /* JADX INFO: renamed from: a */
    public String m363a(aen aenVar) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : new TreeMap(aenVar.m596a()).entrySet()) {
            sb.append((String) entry.getKey());
            if (((aeo) entry.getValue()).m619b()) {
                sb.append(((aeo) entry.getValue()).m616a());
            }
            sb.append(((aeo) entry.getValue()).m620c());
            sb.append(((aeo) entry.getValue()).m623e());
        }
        sb.append(aenVar.f617b);
        return aev.m757a(sb.toString()).toLowerCase(Locale.US);
    }

    /* JADX INFO: renamed from: c */
    private boolean m360c(aen aenVar) {
        if (!aenVar.m603e().equals(m363a(aenVar))) {
            return false;
        }
        for (aeo aeoVar : aenVar.m596a().values()) {
            byte[] bArrM707a = aes.m707a(aeoVar.m623e());
            byte[] bArrM365a = m365a(aeoVar);
            for (int i = 0; i < 4; i++) {
                if (bArrM707a[i] != bArrM365a[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    public byte[] m365a(aeo aeoVar) {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(8);
        byteBufferAllocate.order(null);
        byteBufferAllocate.putLong(aeoVar.m620c());
        byte[] bArrArray = byteBufferAllocate.array();
        byte[] bArr = f415a;
        byte[] bArr2 = new byte[4];
        for (int i = 0; i < 4; i++) {
            bArr2[i] = (byte) (bArrArray[i] ^ bArr[i]);
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: b */
    public void m367b(aen aenVar) {
        aen aenVarM358a;
        boolean z;
        if (aenVar != null && m360c(aenVar)) {
            synchronized (this) {
                aen aenVar2 = this.f419d;
                String strM603e = null;
                String strM603e2 = aenVar2 == null ? null : aenVar2.m603e();
                if (aenVar2 == null) {
                    aenVarM358a = m361d(aenVar);
                } else {
                    aenVarM358a = m358a(aenVar2, aenVar);
                }
                this.f419d = aenVarM358a;
                if (aenVarM358a != null) {
                    strM603e = aenVarM358a.m603e();
                }
                z = !m359a(strM603e2, strM603e);
            }
            if (this.f419d == null || !z) {
                return;
            }
            this.f418c.m375a(this.f419d);
            if (this.f417b != null) {
                this.f417b.mo425a(this.f418c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m359a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        return str.equals(str2);
    }

    /* JADX INFO: renamed from: a */
    private aen m358a(aen aenVar, aen aenVar2) {
        if (aenVar2 == null) {
            return aenVar;
        }
        Map<String, aeo> mapM596a = aenVar.m596a();
        for (Map.Entry<String, aeo> entry : aenVar2.m596a().entrySet()) {
            if (entry.getValue().m619b()) {
                mapM596a.put(entry.getKey(), entry.getValue());
            } else {
                mapM596a.remove(entry.getKey());
            }
        }
        aenVar.m594a(aenVar2.m600c());
        aenVar.m595a(m363a(aenVar));
        return aenVar;
    }

    /* JADX INFO: renamed from: d */
    private aen m361d(aen aenVar) {
        Map<String, aeo> mapM596a = aenVar.m596a();
        ArrayList arrayList = new ArrayList(mapM596a.size() / 2);
        for (Map.Entry<String, aeo> entry : mapM596a.entrySet()) {
            if (!entry.getValue().m619b()) {
                arrayList.add(entry.getKey());
            }
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            mapM596a.remove((String) it.next());
        }
        return aenVar;
    }

    /* JADX INFO: renamed from: a */
    public synchronized aen m362a() {
        return this.f419d;
    }

    /* JADX INFO: renamed from: b */
    public C0013a m366b() {
        return this.f418c;
    }

    /* JADX INFO: renamed from: c */
    public void m368c() throws Throwable {
        FileInputStream fileInputStreamOpenFileInput;
        if (new File(this.f420f.getFilesDir(), ".imprint").exists()) {
            FileInputStream fileInputStream = null;
            byte[] bArr = null;
            try {
                fileInputStreamOpenFileInput = this.f420f.openFileInput(".imprint");
                try {
                    try {
                        byte[] bArrM763b = aev.m763b(fileInputStreamOpenFileInput);
                        aev.m764c(fileInputStreamOpenFileInput);
                        bArr = bArrM763b;
                    } catch (Exception e) {
                        e = e;
                        e.printStackTrace();
                        aev.m764c(fileInputStreamOpenFileInput);
                    }
                } catch (Throwable th) {
                    FileInputStream fileInputStream2 = fileInputStreamOpenFileInput;
                    th = th;
                    fileInputStream = fileInputStream2;
                    aev.m764c(fileInputStream);
                    throw th;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStreamOpenFileInput = null;
            } catch (Throwable th2) {
                th = th2;
                aev.m764c(fileInputStream);
                throw th;
            }
            if (bArr != null) {
                try {
                    aen aenVar = new aen();
                    new afh().m841a(aenVar, bArr);
                    this.f419d = aenVar;
                    this.f418c.m375a(aenVar);
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m369d() {
        if (this.f419d == null) {
            return;
        }
        try {
            aev.m760a(new File(this.f420f.getFilesDir(), ".imprint"), new afj().m842a(this.f419d));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: adk$a */
    /* JADX INFO: compiled from: ImprintHandler.java */
    public static class C0013a {

        /* JADX INFO: renamed from: a */
        private int f421a = -1;

        /* JADX INFO: renamed from: b */
        private int f422b = -1;

        /* JADX INFO: renamed from: c */
        private int f423c = -1;

        /* JADX INFO: renamed from: d */
        private int f424d = -1;

        /* JADX INFO: renamed from: e */
        private int f425e = -1;

        /* JADX INFO: renamed from: f */
        private String f426f = null;

        /* JADX INFO: renamed from: g */
        private int f427g = -1;

        /* JADX INFO: renamed from: h */
        private String f428h = null;

        /* JADX INFO: renamed from: i */
        private int f429i = -1;

        /* JADX INFO: renamed from: j */
        private int f430j = -1;

        /* JADX INFO: renamed from: k */
        private String f431k = null;

        /* JADX INFO: renamed from: l */
        private String f432l = null;

        /* JADX INFO: renamed from: m */
        private String f433m = null;

        /* JADX INFO: renamed from: n */
        private String f434n = null;

        /* JADX INFO: renamed from: o */
        private String f435o = null;

        C0013a() {
        }

        /* JADX INFO: renamed from: a */
        public void m375a(aen aenVar) {
            if (aenVar == null) {
                return;
            }
            this.f421a = m370a(aenVar, "defcon");
            this.f422b = m370a(aenVar, "latent");
            this.f423c = m370a(aenVar, "codex");
            this.f424d = m370a(aenVar, "report_policy");
            this.f425e = m370a(aenVar, "report_interval");
            this.f426f = m371b(aenVar, "client_test");
            this.f427g = m370a(aenVar, "test_report_interval");
            this.f428h = m371b(aenVar, "umid");
            this.f429i = m370a(aenVar, "integrated_test");
            this.f430j = m370a(aenVar, "latent_hours");
            this.f431k = m371b(aenVar, "country");
            this.f432l = m371b(aenVar, "domain_p");
            this.f433m = m371b(aenVar, "domain_s");
            this.f434n = m371b(aenVar, "initial_view_time");
            this.f435o = m371b(aenVar, "track_list");
        }

        /* JADX INFO: renamed from: a */
        public String m374a(String str) {
            return this.f435o != null ? this.f435o : str;
        }

        /* JADX INFO: renamed from: b */
        public String m379b(String str) {
            return this.f433m != null ? this.f433m : str;
        }

        /* JADX INFO: renamed from: c */
        public String m382c(String str) {
            return this.f432l != null ? this.f432l : str;
        }

        /* JADX INFO: renamed from: a */
        public int m372a(int i) {
            return (this.f421a != -1 && this.f421a <= 3 && this.f421a >= 0) ? this.f421a : i;
        }

        /* JADX INFO: renamed from: b */
        public int m378b(int i) {
            return (this.f422b != -1 && this.f422b >= 0 && this.f422b <= 1800) ? this.f422b * 1000 : i;
        }

        /* JADX INFO: renamed from: c */
        public int m381c(int i) {
            return (this.f423c == 0 || this.f423c == 1 || this.f423c == -1) ? this.f423c : i;
        }

        /* JADX INFO: renamed from: a */
        public int[] m377a(int i, int i2) {
            if (this.f424d == -1 || !aez.m783a(this.f424d)) {
                return new int[]{i, i2};
            }
            if (this.f425e == -1 || this.f425e < 90 || this.f425e > 86400) {
                this.f425e = 90;
            }
            return new int[]{this.f424d, this.f425e * 1000};
        }

        /* JADX INFO: renamed from: d */
        public String m384d(String str) {
            return (this.f426f == null || !aeh.m500a(this.f426f)) ? str : this.f426f;
        }

        /* JADX INFO: renamed from: d */
        public int m383d(int i) {
            return (this.f427g == -1 || this.f427g < 90 || this.f427g > 86400) ? i : this.f427g * 1000;
        }

        /* JADX INFO: renamed from: a */
        public boolean m376a() {
            return this.f427g != -1;
        }

        /* JADX INFO: renamed from: e */
        public String m385e(String str) {
            return this.f428h;
        }

        /* JADX INFO: renamed from: b */
        public boolean m380b() {
            return this.f429i == 1;
        }

        /* JADX INFO: renamed from: a */
        public long m373a(long j) {
            return (this.f430j != -1 && this.f430j >= 48) ? ((long) this.f430j) * 3600000 : j;
        }

        /* JADX INFO: renamed from: a */
        private int m370a(aen aenVar, String str) {
            aeo aeoVar;
            if (aenVar != null) {
                try {
                    if (aenVar.m599b() && (aeoVar = aenVar.m596a().get(str)) != null) {
                        if (!TextUtils.isEmpty(aeoVar.m616a())) {
                            try {
                                return Integer.parseInt(aeoVar.m616a().trim());
                            } catch (Exception unused) {
                                return -1;
                            }
                        }
                    }
                    return -1;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return -1;
        }

        /* JADX INFO: renamed from: b */
        private String m371b(aen aenVar, String str) {
            aeo aeoVar;
            if (aenVar != null) {
                try {
                    if (aenVar.m599b() && (aeoVar = aenVar.m596a().get(str)) != null && !TextUtils.isEmpty(aeoVar.m616a())) {
                        return aeoVar.m616a();
                    }
                    return null;
                } catch (Exception e) {
                    e.printStackTrace();
                    return null;
                }
            }
            return null;
        }
    }
}
