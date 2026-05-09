package p000;

import android.content.Context;
import android.text.TextUtils;
import p000.adk;

/* JADX INFO: compiled from: ABTest.java */
/* JADX INFO: loaded from: classes.dex */
public class aeh implements aea {

    /* JADX INFO: renamed from: i */
    private static aeh f531i;

    /* JADX INFO: renamed from: a */
    private boolean f532a = false;

    /* JADX INFO: renamed from: b */
    private int f533b = -1;

    /* JADX INFO: renamed from: c */
    private int f534c = -1;

    /* JADX INFO: renamed from: d */
    private int f535d = -1;

    /* JADX INFO: renamed from: e */
    private float f536e = 0.0f;

    /* JADX INFO: renamed from: f */
    private float f537f = 0.0f;

    /* JADX INFO: renamed from: g */
    private String f538g = null;

    /* JADX INFO: renamed from: h */
    private Context f539h;

    /* JADX INFO: renamed from: a */
    public static synchronized aeh m499a(Context context) {
        if (f531i == null) {
            adk.C0013a c0013aM366b = adk.m357a(context).m366b();
            f531i = new aeh(context, c0013aM366b.m384d((String) null), c0013aM366b.m383d(0));
        }
        return f531i;
    }

    private aeh(Context context, String str, int i) throws Throwable {
        this.f539h = null;
        this.f539h = context;
        m504a(str, i);
    }

    /* JADX INFO: renamed from: b */
    private float m501b(String str, int i) {
        int i2 = i * 2;
        if (str == null) {
            return 0.0f;
        }
        return Integer.valueOf(str.substring(i2, i2 + 5), 16).intValue() / 1048576.0f;
    }

    /* JADX INFO: renamed from: a */
    public void m504a(String str, int i) throws Throwable {
        this.f534c = i;
        String strM330a = adf.m330a(this.f539h);
        if (TextUtils.isEmpty(strM330a) || TextUtils.isEmpty(str)) {
            this.f532a = false;
            return;
        }
        try {
            this.f536e = m501b(strM330a, 12);
            this.f537f = m501b(strM330a, 6);
            if (str.startsWith("SIG7")) {
                m502b(str);
            } else if (str.startsWith("FIXED")) {
                m503c(str);
            }
        } catch (Exception e) {
            this.f532a = false;
            aex.m770a("v:" + str, e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m500a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArrSplit = str.split("\\|");
        if (strArrSplit.length != 6) {
            return false;
        }
        if (strArrSplit[0].startsWith("SIG7") && strArrSplit[1].split(",").length == strArrSplit[5].split(",").length) {
            return true;
        }
        if (strArrSplit[0].startsWith("FIXED")) {
            int length = strArrSplit[5].split(",").length;
            int i = Integer.parseInt(strArrSplit[1]);
            if (length >= i && i >= 1) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    private void m502b(String str) {
        float[] fArr;
        if (str == null) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        float f = 0.0f;
        if (this.f536e > (strArrSplit[2].equals("SIG13") ? Float.valueOf(strArrSplit[3]).floatValue() : 0.0f)) {
            this.f532a = false;
            return;
        }
        int[] iArr = null;
        if (strArrSplit[0].equals("SIG7")) {
            String[] strArrSplit2 = strArrSplit[1].split(",");
            fArr = new float[strArrSplit2.length];
            for (int i = 0; i < strArrSplit2.length; i++) {
                fArr[i] = Float.valueOf(strArrSplit2[i]).floatValue();
            }
        } else {
            fArr = null;
        }
        if (strArrSplit[4].equals("RPT")) {
            this.f538g = "RPT";
            String[] strArrSplit3 = strArrSplit[5].split(",");
            iArr = new int[strArrSplit3.length];
            for (int i2 = 0; i2 < strArrSplit3.length; i2++) {
                iArr[i2] = Integer.valueOf(strArrSplit3[i2]).intValue();
            }
        } else if (strArrSplit[4].equals("DOM")) {
            this.f532a = true;
            this.f538g = "DOM";
            try {
                String[] strArrSplit4 = strArrSplit[5].split(",");
                int[] iArr2 = new int[strArrSplit4.length];
                for (int i3 = 0; i3 < strArrSplit4.length; i3++) {
                    try {
                        iArr2[i3] = Integer.valueOf(strArrSplit4[i3]).intValue();
                    } catch (Exception unused) {
                    }
                }
                iArr = iArr2;
            } catch (Exception unused2) {
            }
        }
        int i4 = 0;
        while (true) {
            if (i4 >= fArr.length) {
                i4 = -1;
                break;
            }
            f += fArr[i4];
            if (this.f537f < f) {
                break;
            } else {
                i4++;
            }
        }
        if (i4 != -1) {
            this.f532a = true;
            this.f535d = i4 + 1;
            if (iArr != null) {
                this.f533b = iArr[i4];
                return;
            }
            return;
        }
        this.f532a = false;
    }

    /* JADX INFO: renamed from: c */
    private void m503c(String str) {
        if (str == null) {
            return;
        }
        String[] strArrSplit = str.split("\\|");
        if (this.f536e > (strArrSplit[2].equals("SIG13") ? Float.valueOf(strArrSplit[3]).floatValue() : 0.0f)) {
            this.f532a = false;
            return;
        }
        int iIntValue = strArrSplit[0].equals("FIXED") ? Integer.valueOf(strArrSplit[1]).intValue() : -1;
        int[] iArr = null;
        if (strArrSplit[4].equals("RPT")) {
            this.f538g = "RPT";
            String[] strArrSplit2 = strArrSplit[5].split(",");
            iArr = new int[strArrSplit2.length];
            for (int i = 0; i < strArrSplit2.length; i++) {
                iArr[i] = Integer.valueOf(strArrSplit2[i]).intValue();
            }
        } else if (strArrSplit[4].equals("DOM")) {
            this.f538g = "DOM";
            this.f532a = true;
            try {
                String[] strArrSplit3 = strArrSplit[5].split(",");
                int[] iArr2 = new int[strArrSplit3.length];
                for (int i2 = 0; i2 < strArrSplit3.length; i2++) {
                    try {
                        iArr2[i2] = Integer.valueOf(strArrSplit3[i2]).intValue();
                    } catch (Exception unused) {
                    }
                }
                iArr = iArr2;
            } catch (Exception unused2) {
            }
        }
        if (iIntValue != -1) {
            this.f532a = true;
            this.f535d = iIntValue;
            if (iArr != null) {
                this.f533b = iArr[iIntValue - 1];
                return;
            }
            return;
        }
        this.f532a = false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m505a() {
        return this.f532a;
    }

    /* JADX INFO: renamed from: b */
    public int m506b() {
        return this.f533b;
    }

    /* JADX INFO: renamed from: c */
    public String m507c() {
        return !this.f532a ? "error" : String.valueOf(this.f535d);
    }

    /* JADX INFO: renamed from: d */
    public String m508d() {
        return this.f538g;
    }

    @Override // p000.aea
    /* JADX INFO: renamed from: a */
    public void mo425a(adk.C0013a c0013a) throws Throwable {
        m504a(c0013a.m384d((String) null), c0013a.m383d(0));
    }

    public String toString() {
        return " p13:" + this.f536e + " p07:" + this.f537f + " policy:" + this.f533b + " interval:" + this.f534c;
    }
}
