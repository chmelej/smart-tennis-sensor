package cn.smssdk.contact.p010a;

import android.text.TextUtils;

/* JADX INFO: renamed from: cn.smssdk.contact.a.l */
/* JADX INFO: compiled from: Phone.java */
/* JADX INFO: loaded from: classes.dex */
public class C0930l extends AbstractC0920b {
    /* JADX INFO: renamed from: a */
    protected int m6690a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            case 9:
                return 9;
            case 10:
                return 10;
            case 11:
                return 11;
            case 12:
                return 12;
            case 13:
                return 13;
            case 14:
                return 14;
            case 15:
                return 15;
            case 16:
                return 16;
            case 17:
                return 17;
            case 18:
                return 18;
            case 19:
                return 19;
            case 20:
                return 20;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6691b() {
        String strB = m6663b("data1");
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        return strB.replace(" ", "").replace("-", "");
    }

    /* JADX INFO: renamed from: c */
    public int m6692c() {
        return m6690a(m6660a("data2", -1));
    }

    /* JADX INFO: renamed from: d */
    public String m6693d() {
        if (m6660a("data2", -1) == 0) {
            return m6663b("data3");
        }
        return null;
    }
}
