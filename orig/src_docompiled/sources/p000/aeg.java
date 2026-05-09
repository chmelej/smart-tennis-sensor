package p000;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import p000.agy;

/* JADX INFO: compiled from: ViewPageTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class aeg {

    /* JADX INFO: renamed from: b */
    private static JSONObject f529b = new JSONObject();

    /* JADX INFO: renamed from: a */
    private final Map<String, Long> f530a = new HashMap();

    /* JADX INFO: renamed from: a */
    public void m497a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f530a) {
            this.f530a.put(str, Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m498b(String str) {
        Long lRemove;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        synchronized (this.f530a) {
            lRemove = this.f530a.remove(str);
        }
        if (lRemove == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - lRemove.longValue();
        synchronized (f529b) {
            try {
                f529b = new JSONObject();
                f529b.put("page_name", str);
                f529b.put("duration", jCurrentTimeMillis);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m496a() {
        String key;
        synchronized (this.f530a) {
            key = null;
            long j = 0;
            for (Map.Entry<String, Long> entry : this.f530a.entrySet()) {
                if (entry.getValue().longValue() > j) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j = jLongValue;
                }
            }
        }
        if (key != null) {
            m498b(key);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m495a(Context context) throws Throwable {
        JSONObject jSONObject = null;
        try {
            synchronized (f529b) {
                if (f529b.length() > 0) {
                    JSONObject jSONObject2 = new JSONObject(f529b.toString());
                    f529b = new JSONObject();
                    jSONObject = jSONObject2;
                }
            }
            if (jSONObject == null || jSONObject.length() <= 0) {
                return;
            }
            agy.m991a(context).m1002a(aee.m475a(), jSONObject, agy.EnumC0107a.PAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
