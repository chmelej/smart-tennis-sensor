package p000;

/* JADX INFO: renamed from: zl */
/* JADX INFO: loaded from: classes.dex */
public final class C2298zl {

    /* JADX INFO: renamed from: a */
    private final C2291ze f13797a;

    /* JADX INFO: renamed from: b */
    private C2297zk<String, String> f13798b;

    /* JADX INFO: renamed from: a */
    public final String m12562a(String str) {
        String strSubstring;
        try {
            if (!str.startsWith("!")) {
                return str;
            }
            if (this.f13798b.m12560a(str)) {
                return this.f13798b.m12561b(str);
            }
            strSubstring = str.substring(1);
            try {
                String[] strArrSplit = strSubstring.split("@");
                if (strArrSplit.length <= 1) {
                    return strSubstring;
                }
                String str2 = strArrSplit[0];
                int iIntValue = Integer.valueOf(strArrSplit[0]).intValue();
                String strSubstring2 = strSubstring.substring(str2.length() + 1, str2.length() + 1 + iIntValue);
                String str3 = this.f13797a.m12542a(strSubstring2) + strSubstring.substring(str2.length() + 1 + iIntValue);
                this.f13798b.m12559a(str, str3);
                return str3;
            } catch (Exception e) {
                e = e;
                e.printStackTrace();
                return "[td]" + strSubstring;
            }
        } catch (Exception e2) {
            e = e2;
            strSubstring = str;
        }
    }
}
