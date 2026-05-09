package p000;

import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: ExceptionToResourceMapping.java */
/* JADX INFO: loaded from: classes.dex */
public class akr {

    /* JADX INFO: renamed from: a */
    public final Map<Class<? extends Throwable>, Integer> f1507a;

    /* JADX INFO: renamed from: a */
    public Integer m1740a(Throwable th) {
        Throwable cause = th;
        int i = 20;
        do {
            Integer numM1741b = m1741b(cause);
            if (numM1741b != null) {
                return numM1741b;
            }
            cause = cause.getCause();
            i--;
            if (i <= 0 || cause == th) {
                break;
            }
        } while (cause != null);
        Log.d(akd.f1430a, "No specific message ressource ID found for " + th);
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected Integer m1741b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer value = this.f1507a.get(cls);
        if (value == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.f1507a.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    value = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return value;
    }
}
