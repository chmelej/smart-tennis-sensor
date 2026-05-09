package p000;

import android.content.Context;
import android.util.Log;

/* JADX INFO: compiled from: ProxyFactroy.java */
/* JADX INFO: loaded from: classes.dex */
public class arh {
    /* JADX INFO: renamed from: a */
    public static final <T> T m5265a(Context context, String str) {
        try {
            return (T) m5266a(context, str, null);
        } catch (Throwable th) {
            Log.w("ProxyFactroy", "instance_update", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static <T> T m5266a(Context context, String str, T t) {
        try {
            Log.v("ProxyFactroy", "getInstance[base] successfully");
            return (T) Class.forName(str).newInstance();
        } catch (Throwable th) {
            Log.w("ProxyFactroy", "instance_base", th);
            return t;
        }
    }
}
