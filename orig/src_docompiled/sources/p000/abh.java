package p000;

import com.umeng.message.MsgConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class abh {

    /* JADX INFO: renamed from: a */
    private long f105a = 0;

    /* JADX INFO: renamed from: b */
    private int f106b = 0;

    /* JADX INFO: renamed from: c */
    private String f107c = "";

    /* JADX INFO: renamed from: d */
    private int f108d = 0;

    /* JADX INFO: renamed from: e */
    private String f109e = "";

    /* JADX INFO: renamed from: a */
    public final JSONObject m43a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tm", this.f105a);
            jSONObject.put("st", this.f106b);
            if (this.f107c != null) {
                jSONObject.put("dm", this.f107c);
            }
            jSONObject.put("pt", this.f108d);
            if (this.f109e != null) {
                jSONObject.put("rip", this.f109e);
            }
            jSONObject.put(MsgConstant.KEY_TS, System.currentTimeMillis() / 1000);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: a */
    public final void m44a(int i) {
        this.f106b = i;
    }

    /* JADX INFO: renamed from: a */
    public final void m45a(long j) {
        this.f105a = j;
    }

    /* JADX INFO: renamed from: a */
    public final void m46a(String str) {
        this.f107c = str;
    }

    /* JADX INFO: renamed from: b */
    public final void m47b(int i) {
        this.f108d = i;
    }

    /* JADX INFO: renamed from: b */
    public final void m48b(String str) {
        this.f109e = str;
    }
}
