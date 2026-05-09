package p000;

import java.io.File;

/* JADX INFO: loaded from: classes.dex */
final class abx {

    /* JADX INFO: renamed from: a */
    private static int f189a = -1;

    /* JADX INFO: renamed from: a */
    public static boolean m124a() {
        if (f189a == 1) {
            return true;
        }
        if (f189a == 0) {
            return false;
        }
        for (String str : new String[]{"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"}) {
            try {
                if (new File(str + "su").exists()) {
                    f189a = 1;
                    return true;
                }
            } catch (Exception unused) {
            }
            f189a = 0;
            return false;
        }
        f189a = 0;
        return false;
    }
}
