package p000;

import java.text.SimpleDateFormat;

/* JADX INFO: compiled from: DataUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class ahx {
    /* JADX INFO: renamed from: a */
    public static final String m1279a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Long.valueOf(j));
        } catch (Throwable unused) {
            return "none";
        }
    }
}
