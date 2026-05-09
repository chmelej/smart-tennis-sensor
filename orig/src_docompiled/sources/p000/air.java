package p000;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import java.util.List;

/* JADX INFO: compiled from: ServiceUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class air {
    /* JADX INFO: renamed from: a */
    public static final void m1375a(Context context, String str) {
        aiv.m1418c("ServiceUtil", "command --->[" + context.getPackageName() + ".service]:[start]");
        Intent intent = new Intent();
        intent.setAction(aqc.m4991c(context));
        intent.putExtra("method", "start");
        intent.putExtra("eventId", str);
        intent.setPackage(context.getPackageName());
        context.startService(intent);
    }

    /* JADX INFO: renamed from: a */
    public static final void m1374a(Context context) {
        try {
            aiv.m1418c("ServiceUtil", "command --->[" + context.getPackageName() + ".service]:[stop]");
            String strM4991c = aqc.m4991c(context);
            Intent intent = new Intent();
            intent.setAction(strM4991c);
            intent.putExtra("method", "stop");
            intent.setPackage(context.getPackageName());
            context.startService(intent);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1376b(Context context) {
        try {
            List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
            int iMyPid = Process.myPid();
            int i = 0;
            for (ActivityManager.RunningServiceInfo runningServiceInfo : runningServices) {
                if (runningServiceInfo.pid == iMyPid) {
                    aiv.m1418c("ServiceUtil", "runningService --->[" + runningServiceInfo.process + "]");
                    i++;
                }
            }
            if (i < 1) {
                aiv.m1418c("ServiceUtil", "killRunningService --->[" + iMyPid + "]");
                Process.killProcess(iMyPid);
            }
        } catch (Throwable unused) {
        }
    }
}
