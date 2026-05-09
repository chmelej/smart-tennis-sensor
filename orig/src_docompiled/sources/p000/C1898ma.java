package p000;

import java.text.DecimalFormat;

/* JADX INFO: renamed from: ma */
/* JADX INFO: compiled from: FormatUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1898ma {
    /* JADX INFO: renamed from: a */
    public static String m10472a(long j) {
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 % 3600) / 60;
        String strSubstring = ("00" + j3).substring(("00" + j3).length() - 2);
        String strSubstring2 = ("00" + j4).substring(("00" + j4).length() - 2);
        return ("00" + (j2 / 3600)).substring(("00" + r8).length() - 2) + ":" + strSubstring2 + ":" + strSubstring;
    }

    /* JADX INFO: renamed from: a */
    public static String m10471a(double d) {
        return new DecimalFormat("0").format(d);
    }
}
