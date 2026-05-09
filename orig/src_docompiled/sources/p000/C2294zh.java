package p000;

/* JADX INFO: renamed from: zh */
/* JADX INFO: loaded from: classes.dex */
public final class C2294zh {
    /* JADX INFO: renamed from: a */
    public static byte[] m12545a(String str, int i, String str2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        stringBuffer.append(i);
        stringBuffer.append(str2);
        stringBuffer.append("mMcShCsTr");
        return C2292zf.m12543a(stringBuffer.toString().substring(1, 9).getBytes()).getBytes();
    }
}
