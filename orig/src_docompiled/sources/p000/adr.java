package p000;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000.agy;

/* JADX INFO: compiled from: AutoViewPageTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adr {

    /* JADX INFO: renamed from: a */
    public static String f447a;

    /* JADX INFO: renamed from: d */
    private static JSONObject f448d = new JSONObject();

    /* JADX INFO: renamed from: e */
    private Application f451e;

    /* JADX INFO: renamed from: c */
    private final Map<String, Long> f450c = new HashMap();

    /* JADX INFO: renamed from: b */
    Application.ActivityLifecycleCallbacks f449b = new Application.ActivityLifecycleCallbacks() { // from class: adr.1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            adr.this.m402b(activity);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            adr.this.m403c(activity);
        }
    };

    public adr(Activity activity) {
        this.f451e = null;
        if (activity != null) {
            this.f451e = activity.getApplication();
            m399a(activity);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m399a(Activity activity) {
        this.f451e.registerActivityLifecycleCallbacks(this.f449b);
        if (f447a == null) {
            m402b(activity);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m404a() {
        if (this.f451e != null) {
            this.f451e.unregisterActivityLifecycleCallbacks(this.f449b);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m405b() {
        m403c(null);
        m404a();
    }

    /* JADX INFO: renamed from: a */
    public static void m400a(Context context) {
        JSONObject jSONObject = null;
        try {
            synchronized (f448d) {
                if (f448d.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject(f448d.toString());
                    f448d = new JSONObject();
                    jSONObject = jSONObject2;
                }
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            agy.m991a(context).m1002a(aee.m475a(), jSONObject, agy.EnumC0107a.AUTOPAGE);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m402b(Activity activity) {
        f447a = activity.getPackageName() + "." + activity.getLocalClassName();
        synchronized (this.f450c) {
            this.f450c.put(f447a, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m403c(Activity activity) {
        long j = 0;
        try {
            synchronized (this.f450c) {
                if (this.f450c.containsKey(f447a)) {
                    long jCurrentTimeMillis = System.currentTimeMillis() - this.f450c.get(f447a).longValue();
                    this.f450c.remove(f447a);
                    j = jCurrentTimeMillis;
                }
            }
            synchronized (f448d) {
                try {
                    f448d = new JSONObject();
                    f448d.put("page_name", f447a);
                    f448d.put("duration", j);
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable unused2) {
        }
    }
}
