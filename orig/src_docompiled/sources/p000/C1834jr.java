package p000;

import android.app.Activity;
import java.util.Stack;

/* JADX INFO: renamed from: jr */
/* JADX INFO: compiled from: ActivityCollector.java */
/* JADX INFO: loaded from: classes.dex */
public class C1834jr {

    /* JADX INFO: renamed from: a */
    public static Stack<Activity> f10797a = new Stack<>();

    /* JADX INFO: renamed from: a */
    public static void m10011a(Activity activity) {
        f10797a.add(activity);
    }

    /* JADX INFO: renamed from: b */
    public static void m10012b(Activity activity) {
        f10797a.remove(activity);
    }

    /* JADX INFO: renamed from: a */
    public static void m10010a() {
        for (Activity activity : f10797a) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
