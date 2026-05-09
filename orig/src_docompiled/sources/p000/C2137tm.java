package p000;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: tm */
/* JADX INFO: compiled from: UpToken.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2137tm {

    /* JADX INFO: renamed from: a */
    public static C2137tm f12827a = new C2137tm("", "", "");

    /* JADX INFO: renamed from: b */
    public final String f12828b;

    /* JADX INFO: renamed from: c */
    public final String f12829c;

    /* JADX INFO: renamed from: d */
    private String f12830d;

    private C2137tm(String str, String str2, String str3) {
        this.f12830d = null;
        this.f12830d = str;
        this.f12828b = str2;
        this.f12829c = str3;
    }

    /* JADX INFO: renamed from: a */
    public static C2137tm m11692a(String str) {
        try {
            String[] strArrSplit = str.split(":");
            if (strArrSplit.length != 3) {
                return f12827a;
            }
            try {
                JSONObject jSONObject = new JSONObject(new String(C2147tw.m11723b(strArrSplit[2])));
                if (jSONObject.optString("scope").equals("")) {
                    return f12827a;
                }
                if (jSONObject.optInt("deadline") == 0) {
                    return f12827a;
                }
                return new C2137tm(jSONObject.optString("returnUrl"), str, strArrSplit[0]);
            } catch (JSONException unused) {
                return f12827a;
            }
        } catch (Exception unused2) {
            return f12827a;
        }
    }

    public String toString() {
        return this.f12828b;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11693a() {
        return !this.f12830d.equals("");
    }
}
