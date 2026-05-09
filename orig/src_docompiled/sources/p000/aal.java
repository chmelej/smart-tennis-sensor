package p000;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aal extends aai {

    /* JADX INFO: renamed from: a */
    private static String f52a;

    /* JADX INFO: renamed from: m */
    private String f53m;

    /* JADX INFO: renamed from: n */
    private String f54n;

    public aal(Context context, int i, ace aceVar) {
        super(context, i, aceVar);
        this.f53m = null;
        this.f54n = null;
        this.f53m = acf.m234a(context).m240b();
        if (f52a == null) {
            f52a = abt.m102i(context);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m28a(String str) {
        this.f54n = str;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: a */
    public final boolean mo18a(JSONObject jSONObject) throws JSONException {
        abz.m134a(jSONObject, "op", f52a);
        abz.m134a(jSONObject, "cn", this.f53m);
        jSONObject.put("sp", this.f54n);
        return true;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: b */
    public final aaj mo19b() {
        return aaj.NETWORK_MONITOR;
    }
}
