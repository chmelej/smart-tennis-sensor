package p000;

import android.content.Context;
import org.json.JSONObject;
import p000.adk;

/* JADX INFO: compiled from: Defcon.java */
/* JADX INFO: loaded from: classes.dex */
public class aei implements aea {

    /* JADX INFO: renamed from: c */
    private static aei f540c;

    /* JADX INFO: renamed from: a */
    private int f541a = 0;

    /* JADX INFO: renamed from: b */
    private final long f542b = 60000;

    /* JADX INFO: renamed from: a */
    public static synchronized aei m509a(Context context) {
        if (f540c == null) {
            f540c = new aei();
            f540c.m511a(adk.m357a(context).m366b().m372a(0));
        }
        return f540c;
    }

    private aei() {
    }

    /* JADX INFO: renamed from: a */
    public void m512a(JSONObject jSONObject, Context context) {
        if (this.f541a == 1) {
            jSONObject.remove("error");
            jSONObject.remove("ekv");
            jSONObject.remove("gkv");
            jSONObject.remove("cc");
            agy.m991a(context).m1000a(false, true);
            agp.m938a(context).m954a(new agl());
            return;
        }
        if (this.f541a == 2) {
            jSONObject.remove("sessions");
            try {
                jSONObject.put("sessions", m510a());
            } catch (Exception unused) {
            }
            jSONObject.remove("error");
            jSONObject.remove("ekv");
            jSONObject.remove("gkv");
            jSONObject.remove("cc");
            agy.m991a(context).m1000a(false, true);
            agp.m938a(context).m954a(new agl());
            return;
        }
        if (this.f541a == 3) {
            jSONObject.remove("sessions");
            jSONObject.remove("error");
            jSONObject.remove("ekv");
            jSONObject.remove("gkv");
            jSONObject.remove("cc");
            agy.m991a(context).m1000a(false, true);
            agp.m938a(context).m954a(new agl());
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m510a() {
        JSONObject jSONObject = new JSONObject();
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            jSONObject.put("id", aee.m475a());
            jSONObject.put("start_time", jCurrentTimeMillis);
            jSONObject.put("end_time", jCurrentTimeMillis + 60000);
            jSONObject.put("duration", 60000L);
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: b */
    public long m513b() {
        switch (this.f541a) {
            case 1:
                return 14400000L;
            case 2:
                return 28800000L;
            case 3:
                return 86400000L;
            default:
                return 0L;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m511a(int i) {
        if (i < 0 || i > 3) {
            return;
        }
        this.f541a = i;
    }

    /* JADX INFO: renamed from: c */
    public boolean m514c() {
        return this.f541a != 0;
    }

    @Override // p000.aea
    /* JADX INFO: renamed from: a */
    public void mo425a(adk.C0013a c0013a) {
        m511a(c0013a.m372a(0));
    }
}
