package p000;

import android.util.Log;
import java.util.Map;

/* JADX INFO: compiled from: ExceptionToResourceMapping.java */
/* JADX INFO: loaded from: classes.dex */
public class asu {

    /* JADX INFO: renamed from: a */
    public final Map<Class<? extends Throwable>, Integer> f5005a;

    /* JADX INFO: renamed from: a */
    public Integer m5372a(Throwable th) {
        Throwable cause = th;
        int i = 20;
        do {
            Integer numM5373b = m5373b(cause);
            if (numM5373b != null) {
                return numM5373b;
            }
            cause = cause.getCause();
            i--;
            if (i <= 0 || cause == th) {
                break;
            }
        } while (cause != null);
        Log.d(asd.f4913a, "No specific message ressource ID found for " + th);
        return null;
    }

    /* JADX INFO: renamed from: b */
    protected Integer m5373b(Throwable th) {
        Class<?> cls = th.getClass();
        Integer value = this.f5005a.get(cls);
        if (value == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.f5005a.entrySet()) {
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
