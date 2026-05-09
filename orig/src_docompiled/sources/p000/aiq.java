package p000;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.List;

/* JADX INFO: compiled from: ReceiverUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class aiq {
    /* JADX INFO: renamed from: a */
    public static final boolean m1372a(Context context, String str) {
        try {
            if (context.getPackageManager().getApplicationInfo(str, 0) != null) {
                return true;
            }
            ais.m1398g(context);
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static final void m1370a(Context context, Class<?>... clsArr) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                for (Class<?> cls : clsArr) {
                    if (cls != null) {
                        try {
                            ComponentName componentName = new ComponentName(context, cls);
                            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                                aiv.m1412a("ReceiverUtil", "rebootReceiver[" + componentName.toString() + "]--->[ENABLED]");
                                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                            }
                        } catch (Throwable unused) {
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1369a(Context context, Class<?> cls) {
        if (context == null || cls == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) > -1) {
                ComponentName componentName = new ComponentName(context, cls);
                if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                    return;
                }
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1373b(Context context, Class<?> cls) {
        ComponentName componentName;
        int componentEnabledSetting;
        if (context == null || cls == null) {
            return;
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) > -1 && (componentEnabledSetting = packageManager.getComponentEnabledSetting((componentName = new ComponentName(context, cls)))) != 1 && componentEnabledSetting != 0) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1371a(Context context) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        boolean z = false;
        if (runningServices == null || runningServices.isEmpty()) {
            return false;
        }
        int i = 0;
        while (true) {
            if (i >= runningServices.size()) {
                break;
            }
            if (runningServices.get(i).service.getClassName().equals("com.taobao.agoo.PushService")) {
                Log.d("ReceiverUtil", "PushService is running ....................");
                z = true;
                break;
            }
            i++;
        }
        if (!z) {
            Log.d("ReceiverUtil", "PushService is failed ....................");
        }
        return z;
    }
}
