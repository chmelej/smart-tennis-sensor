package p000;

import android.util.Log;
import com.umeng.message.MsgConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: yy */
/* JADX INFO: loaded from: classes.dex */
public final class C2284yy {

    /* JADX INFO: renamed from: a */
    String f13769a = null;

    /* JADX INFO: renamed from: b */
    String f13770b = null;

    /* JADX INFO: renamed from: c */
    String f13771c = "0";

    /* JADX INFO: renamed from: d */
    long f13772d = 0;

    /* JADX INFO: renamed from: a */
    static C2284yy m12522a(String str) {
        C2284yy c2284yy = new C2284yy();
        if (C2290zd.m12537a(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                if (!jSONObject.isNull("ui")) {
                    c2284yy.f13769a = jSONObject.getString("ui");
                }
                if (!jSONObject.isNull("mc")) {
                    c2284yy.f13770b = jSONObject.getString("mc");
                }
                if (!jSONObject.isNull("mid")) {
                    c2284yy.f13771c = jSONObject.getString("mid");
                }
                if (!jSONObject.isNull(MsgConstant.KEY_TS)) {
                    c2284yy.f13772d = jSONObject.getLong(MsgConstant.KEY_TS);
                    return c2284yy;
                }
            } catch (JSONException e) {
                Log.w("MID", e);
            }
        }
        return c2284yy;
    }

    /* JADX INFO: renamed from: b */
    private JSONObject m12523b() {
        JSONObject jSONObject = new JSONObject();
        try {
            C2290zd.m12535a(jSONObject, "ui", this.f13769a);
            C2290zd.m12535a(jSONObject, "mc", this.f13770b);
            C2290zd.m12535a(jSONObject, "mid", this.f13771c);
            jSONObject.put(MsgConstant.KEY_TS, this.f13772d);
            return jSONObject;
        } catch (JSONException e) {
            Log.w("MID", e);
            return jSONObject;
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m12524a() {
        return this.f13771c;
    }

    public final String toString() {
        return m12523b().toString();
    }
}
