package p000;

import com.umeng.message.MsgConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class abk {

    /* JADX INFO: renamed from: a */
    private String f115a;

    /* JADX INFO: renamed from: b */
    private String f116b;

    /* JADX INFO: renamed from: c */
    private String f117c;

    /* JADX INFO: renamed from: d */
    private String f118d;

    /* JADX INFO: renamed from: e */
    private int f119e;

    /* JADX INFO: renamed from: f */
    private int f120f;

    /* JADX INFO: renamed from: g */
    private long f121g;

    public abk() {
        this.f115a = null;
        this.f116b = null;
        this.f117c = null;
        this.f118d = "0";
        this.f120f = 0;
        this.f121g = 0L;
    }

    public abk(String str, String str2, int i) {
        this.f115a = null;
        this.f116b = null;
        this.f117c = null;
        this.f118d = "0";
        this.f120f = 0;
        this.f121g = 0L;
        this.f115a = str;
        this.f116b = str2;
        this.f119e = i;
    }

    /* JADX INFO: renamed from: e */
    private JSONObject m60e() {
        JSONObject jSONObject = new JSONObject();
        try {
            abz.m134a(jSONObject, "ui", this.f115a);
            abz.m134a(jSONObject, "mc", this.f116b);
            abz.m134a(jSONObject, "mid", this.f118d);
            abz.m134a(jSONObject, "aid", this.f117c);
            jSONObject.put(MsgConstant.KEY_TS, this.f121g);
            jSONObject.put("ver", this.f120f);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public final String m61a() {
        return this.f115a;
    }

    /* JADX INFO: renamed from: b */
    public final String m62b() {
        return this.f116b;
    }

    /* JADX INFO: renamed from: c */
    public final void m63c() {
        this.f119e = 1;
    }

    /* JADX INFO: renamed from: d */
    public final int m64d() {
        return this.f119e;
    }

    public final String toString() {
        return m60e().toString();
    }
}
