package p000;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aan extends aai {

    /* JADX INFO: renamed from: a */
    private abl f58a;

    /* JADX INFO: renamed from: m */
    private JSONObject f59m;

    public aan(Context context, int i, JSONObject jSONObject, ace aceVar) {
        super(context, i, aceVar);
        this.f59m = null;
        this.f58a = new abl(context);
        this.f59m = jSONObject;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: a */
    public final boolean mo18a(JSONObject jSONObject) throws JSONException {
        if (this.f33e != null) {
            jSONObject.put("ut", this.f33e.m64d());
        }
        if (this.f59m != null) {
            jSONObject.put("cfg", this.f59m);
        }
        if (abt.m117v(this.f39l)) {
            jSONObject.put("ncts", 1);
        }
        this.f58a.m66a(jSONObject, null);
        return true;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: b */
    public final aaj mo19b() {
        return aaj.SESSION_ENV;
    }
}
