package p000;

/* JADX INFO: renamed from: tv */
/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2146tv {
    /* JADX INFO: renamed from: a */
    public static String m11718a(String[] strArr, String str) {
        if (strArr == null) {
            return null;
        }
        int length = strArr.length;
        StringBuilder sb = new StringBuilder(length == 0 ? 0 : ((strArr[0] == null ? 16 : strArr[0].length()) + ((str == null || str.equals("")) ? 0 : str.length())) * length);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(str);
            }
            if (strArr[i] != null) {
                sb.append(strArr[i]);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m11717a(String[] strArr) {
        int length = strArr.length;
        StringBuilder sb = new StringBuilder((strArr[0].length() + 3) * length);
        for (int i = 0; i < length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append('\"');
            sb.append(strArr[i]);
            sb.append('\"');
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static boolean m11719a(String str) {
        return str == null || "".equals(str);
    }

    /* JADX INFO: renamed from: b */
    public static String m11720b(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt > 31 && cCharAt < 127) {
                sb.append(cCharAt);
            }
        }
        return sb.toString();
    }
}
