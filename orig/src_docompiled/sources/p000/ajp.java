package p000;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.umeng.update.net.DownloadingService;

/* JADX INFO: compiled from: NotificationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class ajp {
    /* JADX INFO: renamed from: a */
    public static String m1596a(int i, String str) {
        if (i == 0) {
            return null;
        }
        return (i + "") + ":" + str;
    }

    /* JADX INFO: renamed from: a */
    public static PendingIntent m1595a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) DownloadingService.class);
        intent.putExtra("com.umeng.broadcast.download.msg", str);
        return PendingIntent.getService(context, str.hashCode(), intent, 134217728);
    }
}
