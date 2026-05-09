package p000;

import android.content.Context;
import com.umeng.update.util.DeltaUpdate;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdateRequest.java */
/* JADX INFO: loaded from: classes.dex */
public class ajj extends atm {

    /* JADX INFO: renamed from: d */
    private final String f1287d;

    /* JADX INFO: renamed from: e */
    private final String f1288e;

    /* JADX INFO: renamed from: f */
    private JSONObject f1289f;

    public ajj(Context context) {
        super(null);
        this.f1287d = ajj.class.getName();
        this.f1288e = "update";
        this.f1289f = m1533a(context);
    }

    /* JADX INFO: renamed from: a */
    private JSONObject m1533a(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("type", "update");
            jSONObject.put("appkey", ajf.m1500a(context));
            jSONObject.put("version_code", ati.m5411a(context));
            jSONObject.put("package", ati.m5421i(context));
            jSONObject.put("idmd5", ats.m5472b(ati.m5414b(context)));
            jSONObject.put("channel", ajf.m1504b(context));
            jSONObject.put("proto_ver", "1.4");
            jSONObject.put("sdk_version", "2.6.0.1.20150312");
            jSONObject.put("old_md5", DeltaUpdate.m8792b(context));
            jSONObject.put("delta", DeltaUpdate.m8791a() && ajf.m1509d());
            return jSONObject;
        } catch (Exception e) {
            atj.m5426b(this.f1287d, "exception in updateInternal", e);
            return null;
        }
    }

    @Override // p000.atm
    /* JADX INFO: renamed from: a */
    public JSONObject mo1534a() {
        return this.f1289f;
    }

    @Override // p000.atm
    /* JADX INFO: renamed from: b */
    public String mo1535b() {
        return this.f5053c;
    }
}
