package p000;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

/* JADX INFO: compiled from: ChannelUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class aip {

    /* JADX INFO: renamed from: a */
    private static String f1193a = Build.BRAND;

    /* JADX INFO: renamed from: b */
    private static final String f1194b = "Huawei".toLowerCase();

    /* JADX INFO: renamed from: c */
    private static final String f1195c = "Xiaomi".toLowerCase();

    /* JADX INFO: renamed from: a */
    public static final void m1366a(final Context context) {
        if (context == null || TextUtils.isEmpty(f1193a)) {
            return;
        }
        aif.m1311a(new Runnable() { // from class: aip.1
            @Override // java.lang.Runnable
            public void run() {
                PackageInfo packageInfo;
                try {
                    PackageManager packageManager = context.getPackageManager();
                    if (TextUtils.equals(aip.f1194b, aip.f1193a.toLowerCase()) && packageManager.getPackageInfo("com.huawei.android.pushagent", 4) != null) {
                        ais.m1397f(context, "agoo_huawei");
                    }
                    if (!TextUtils.equals(aip.f1195c, aip.f1193a.toLowerCase()) || (packageInfo = packageManager.getPackageInfo("com.xiaomi.xmsf", 4)) == null || packageInfo.versionCode < 105) {
                        return;
                    }
                    ais.m1397f(context, "agoo_xiaomi");
                } catch (Throwable unused) {
                }
            }
        });
    }
}
