package p000;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: compiled from: IntentUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class aqc {
    /* JADX INFO: renamed from: a */
    public static String m4989a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName() + ".intent.action.SEND";
        } catch (Throwable th) {
            Log.w("IntentUtil", "getAgooSendAction", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final Intent m4988a(Context context, String str) {
        Intent intent;
        try {
            intent = new Intent();
            try {
                intent.setAction(m4990b(context));
                intent.setPackage(context.getPackageName());
                intent.putExtra("command", str);
            } catch (Throwable th) {
                th = th;
                Log.w("IntentUtil", "createComandIntent", th);
            }
        } catch (Throwable th2) {
            th = th2;
            intent = null;
        }
        return intent;
    }

    /* JADX INFO: renamed from: b */
    public static final String m4990b(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName() + ".intent.action.COMMAND";
        } catch (Throwable th) {
            Log.w("IntentUtil", "getAgooCommand", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static final String m4991c(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName() + ".intent.action.START";
        } catch (Throwable th) {
            Log.w("IntentUtil", "getAgooStart", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public static final String m4992d(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return context.getPackageName() + ".intent.action.COCKROACH";
        } catch (Throwable th) {
            Log.w("IntentUtil", "getAgooCockroach", th);
            return null;
        }
    }
}
