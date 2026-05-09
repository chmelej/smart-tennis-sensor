package p000;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aam extends aai {

    /* JADX INFO: renamed from: a */
    Long f55a;

    /* JADX INFO: renamed from: m */
    String f56m;

    /* JADX INFO: renamed from: n */
    String f57n;

    public aam(Context context, String str, String str2, int i, Long l, ace aceVar) {
        super(context, i, aceVar);
        this.f55a = null;
        this.f57n = str;
        this.f56m = str2;
        this.f55a = l;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: a */
    public final boolean mo18a(JSONObject jSONObject) throws JSONException {
        abz.m134a(jSONObject, "pi", this.f56m);
        abz.m134a(jSONObject, "rf", this.f57n);
        if (this.f55a == null) {
            return true;
        }
        jSONObject.put("du", this.f55a);
        return true;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: b */
    public final aaj mo19b() {
        return aaj.PAGE_VIEW;
    }
}
