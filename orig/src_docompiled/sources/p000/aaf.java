package p000;

import android.content.Context;
import java.util.Map;
import java.util.Properties;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aaf extends aai {

    /* JADX INFO: renamed from: a */
    protected aag f19a;

    /* JADX INFO: renamed from: m */
    private long f20m;

    public aaf(Context context, int i, String str, ace aceVar) {
        super(context, i, aceVar);
        this.f19a = new aag();
        this.f20m = -1L;
        this.f19a.f21a = str;
    }

    /* JADX INFO: renamed from: a */
    public final aag m17a() {
        return this.f19a;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: a */
    public final boolean mo18a(JSONObject jSONObject) throws JSONException {
        String str;
        Object obj;
        Properties propertiesM197a;
        jSONObject.put("ei", this.f19a.f21a);
        if (this.f20m > 0) {
            jSONObject.put("du", this.f20m);
        }
        if (this.f19a.f22b == null) {
            if (this.f19a.f21a != null && (propertiesM197a = acd.m197a(this.f19a.f21a)) != null && propertiesM197a.size() > 0) {
                if (this.f19a.f23c == null || this.f19a.f23c.length() == 0) {
                    this.f19a.f23c = new JSONObject(propertiesM197a);
                } else {
                    for (Map.Entry entry : propertiesM197a.entrySet()) {
                        try {
                            this.f19a.f23c.put(entry.getKey().toString(), entry.getValue());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            str = "kv";
            obj = this.f19a.f23c;
        } else {
            str = "ar";
            obj = this.f19a.f22b;
        }
        jSONObject.put(str, obj);
        return true;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: b */
    public final aaj mo19b() {
        return aaj.CUSTOM;
    }
}
