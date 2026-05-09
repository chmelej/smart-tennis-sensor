package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import java.lang.reflect.Method;
import org.json.JSONObject;
import p000.agy;

/* JADX INFO: compiled from: SessionTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class aee {

    /* JADX INFO: renamed from: c */
    private static String f517c;

    /* JADX INFO: renamed from: d */
    private static Context f518d;

    /* JADX INFO: renamed from: a */
    private final String f519a = "a_start_time";

    /* JADX INFO: renamed from: b */
    private final String f520b = "a_end_time";

    /* JADX INFO: renamed from: a */
    public boolean m480a(Context context) {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        String string = sharedPreferencesM454a.getString("session_id", null);
        if (string == null) {
            return false;
        }
        long j = sharedPreferencesM454a.getLong("session_start_time", 0L);
        long j2 = sharedPreferencesM454a.getLong("session_end_time", 0L);
        if (j2 != 0) {
            int i = (Math.abs(j2 - j) > 86400000L ? 1 : (Math.abs(j2 - j) == 86400000L ? 0 : -1));
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__ii", string);
            jSONObject.put("__e", j);
            jSONObject.put("__f", j2);
            double[] dArrM288a = acz.m288a();
            if (dArrM288a != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("lat", dArrM288a[0]);
                jSONObject2.put("lng", dArrM288a[1]);
                jSONObject2.put(MsgConstant.KEY_TS, System.currentTimeMillis());
                jSONObject.put("__d", jSONObject2);
            }
            Class<?> cls = Class.forName("android.net.TrafficStats");
            Method method = cls.getMethod("getUidRxBytes", Integer.TYPE);
            Method method2 = cls.getMethod("getUidTxBytes", Integer.TYPE);
            int i2 = context.getApplicationInfo().uid;
            if (i2 == -1) {
                return false;
            }
            long jLongValue = ((Long) method.invoke(null, Integer.valueOf(i2))).longValue();
            long jLongValue2 = ((Long) method2.invoke(null, Integer.valueOf(i2))).longValue();
            if (jLongValue > 0 && jLongValue2 > 0) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("download_traffic", jLongValue);
                jSONObject3.put("upload_traffic", jLongValue2);
                jSONObject.put("__c", jSONObject3);
            }
            agy.m991a(context).m1002a(string, jSONObject, agy.EnumC0107a.NEWSESSION);
            aeg.m495a(f518d);
            adr.m400a(f518d);
            try {
                m477a(sharedPreferencesM454a);
                return true;
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m477a(SharedPreferences sharedPreferences) {
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.remove("session_start_time");
        editorEdit.remove("session_end_time");
        editorEdit.remove("a_start_time");
        editorEdit.remove("a_end_time");
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public String m481b(Context context) {
        String strM728c = aeu.m728c(context);
        String strM287a = acz.m287a(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (strM287a == null) {
            throw new RuntimeException("Appkey is null or empty, Please check AndroidManifest.xml");
        }
        f517c = aev.m757a(jCurrentTimeMillis + strM287a + strM728c);
        return f517c;
    }

    /* JADX INFO: renamed from: c */
    public void m482c(Context context) throws Throwable {
        f518d = context;
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        if (sharedPreferencesM454a == null) {
            return;
        }
        SharedPreferences.Editor editorEdit = sharedPreferencesM454a.edit();
        int i = sharedPreferencesM454a.getInt("versioncode", 0);
        int i2 = Integer.parseInt(aeu.m719a(f518d));
        if (i != 0 && i2 != i) {
            try {
                editorEdit.putInt("vers_code", i);
                editorEdit.putString("vers_name", sharedPreferencesM454a.getString("versionname", ""));
                editorEdit.commit();
            } catch (Throwable unused) {
            }
            if (m479g(context) == null) {
                m476a(context, sharedPreferencesM454a);
            }
            m484e(f518d);
            adt.m435b(f518d).mo429b();
            m485f(f518d);
            adt.m435b(f518d).mo424a();
            return;
        }
        if (m478b(sharedPreferencesM454a)) {
            aex.m774b("Start new session: " + m476a(context, sharedPreferencesM454a));
            return;
        }
        String string = sharedPreferencesM454a.getString("session_id", null);
        editorEdit.putLong("a_start_time", System.currentTimeMillis());
        editorEdit.putLong("a_end_time", 0L);
        editorEdit.commit();
        aex.m774b("Extend current session: " + string);
    }

    /* JADX INFO: renamed from: d */
    public void m483d(Context context) throws Throwable {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        if (sharedPreferencesM454a == null) {
            return;
        }
        if (sharedPreferencesM454a.getLong("a_start_time", 0L) == 0 && acz.f341e) {
            aex.m776c("onPause called before onResume");
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor editorEdit = sharedPreferencesM454a.edit();
        editorEdit.putLong("a_start_time", 0L);
        editorEdit.putLong("a_end_time", jCurrentTimeMillis);
        editorEdit.putLong("session_end_time", jCurrentTimeMillis);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    private boolean m478b(SharedPreferences sharedPreferences) throws Throwable {
        long j = sharedPreferences.getLong("a_start_time", 0L);
        long j2 = sharedPreferences.getLong("a_end_time", 0L);
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (j != 0 && jCurrentTimeMillis - j < acz.f343g) {
            aex.m776c("onResume called before onPause");
            return false;
        }
        if (jCurrentTimeMillis - j2 <= acz.f343g) {
            return false;
        }
        String strM475a = m475a();
        if (TextUtils.isEmpty(strM475a)) {
            return true;
        }
        long jCurrentTimeMillis2 = sharedPreferences.getLong("session_end_time", 0L);
        if (jCurrentTimeMillis2 == 0) {
            jCurrentTimeMillis2 = System.currentTimeMillis();
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__f", jCurrentTimeMillis2);
            agy.m991a(f518d).m1002a(strM475a, jSONObject, agy.EnumC0107a.END);
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m476a(Context context, SharedPreferences sharedPreferences) {
        adt adtVarM435b = adt.m435b(context);
        String strM481b = m481b(context);
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", jCurrentTimeMillis);
            agy.m991a(f518d).m1002a(strM481b, jSONObject, agy.EnumC0107a.BEGIN);
        } catch (Throwable unused) {
        }
        m480a(context);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.putString("session_id", strM481b);
        editorEdit.putLong("session_start_time", System.currentTimeMillis());
        editorEdit.putLong("session_end_time", 0L);
        editorEdit.putLong("a_start_time", jCurrentTimeMillis);
        editorEdit.putLong("a_end_time", 0L);
        editorEdit.putInt("versioncode", Integer.parseInt(aeu.m719a(context)));
        editorEdit.putString("versionname", aeu.m725b(context));
        editorEdit.commit();
        adtVarM435b.mo427a((Object) true);
        return strM481b;
    }

    /* JADX INFO: renamed from: e */
    public boolean m484e(Context context) throws Throwable {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        boolean z = false;
        if (sharedPreferencesM454a == null || sharedPreferencesM454a.getString("session_id", null) == null) {
            return false;
        }
        long j = sharedPreferencesM454a.getLong("a_start_time", 0L);
        long j2 = sharedPreferencesM454a.getLong("a_end_time", 0L);
        if (j > 0 && j2 == 0) {
            z = true;
            m483d(context);
        }
        long jCurrentTimeMillis = sharedPreferencesM454a.getLong("session_end_time", 0L);
        try {
            JSONObject jSONObject = new JSONObject();
            if (jCurrentTimeMillis == 0) {
                jCurrentTimeMillis = System.currentTimeMillis();
            }
            jSONObject.put("__f", jCurrentTimeMillis);
            agy.m991a(f518d).m1002a(m475a(), jSONObject, agy.EnumC0107a.END);
        } catch (Throwable unused) {
        }
        m480a(context);
        return z;
    }

    /* JADX INFO: renamed from: f */
    public void m485f(Context context) {
        SharedPreferences sharedPreferencesM454a = aeb.m454a(context);
        if (sharedPreferencesM454a == null) {
            return;
        }
        String strM481b = m481b(context);
        SharedPreferences.Editor editorEdit = sharedPreferencesM454a.edit();
        long jCurrentTimeMillis = System.currentTimeMillis();
        editorEdit.putString("session_id", strM481b);
        editorEdit.putLong("session_start_time", System.currentTimeMillis());
        editorEdit.putLong("session_end_time", 0L);
        editorEdit.putLong("a_start_time", jCurrentTimeMillis);
        editorEdit.putLong("a_end_time", 0L);
        editorEdit.putInt("versioncode", Integer.parseInt(aeu.m719a(context)));
        editorEdit.putString("versionname", aeu.m725b(context));
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("__e", jCurrentTimeMillis);
            agy.m991a(f518d).m1002a(strM481b, jSONObject, agy.EnumC0107a.BEGIN);
        } catch (Throwable unused) {
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: g */
    public static String m479g(Context context) {
        if (f517c == null) {
            f517c = aeb.m454a(context).getString("session_id", null);
        }
        return f517c;
    }

    /* JADX INFO: renamed from: a */
    public static String m475a() {
        return m479g(f518d);
    }
}
