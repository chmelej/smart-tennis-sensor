package p000;

/* JADX INFO: renamed from: yk */
/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2270yk {
    /* JADX INFO: renamed from: a */
    public static boolean m12426a(String str) {
        return str == null || str.length() <= 0;
    }

    /* JADX INFO: renamed from: b */
    public static int m12427b(String str) {
        if (str.length() <= 0) {
            return 0;
        }
        int i = 0;
        for (char c : str.toCharArray()) {
            i = (i * 31) + c;
        }
        return i;
    }
}
