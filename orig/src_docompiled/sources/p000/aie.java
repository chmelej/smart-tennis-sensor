package p000;

import java.nio.charset.Charset;

/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class aie {

    /* JADX INFO: renamed from: a */
    public static Charset f1127a;

    static {
        try {
            f1127a = Charset.forName("UTF-8");
        } catch (RuntimeException unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final String m1308a(Object[] objArr) {
        StringBuilder sb = new StringBuilder();
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                sb.append(obj);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m1309a(String str) {
        return str == null || str.length() == 0;
    }
}
