package p000;

import android.content.Context;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: compiled from: UpdateResponse.java */
/* JADX INFO: loaded from: classes.dex */
public class ajg extends atn implements Serializable {

    /* JADX INFO: renamed from: a */
    public boolean f1259a;

    /* JADX INFO: renamed from: b */
    public String f1260b;

    /* JADX INFO: renamed from: c */
    public String f1261c;

    /* JADX INFO: renamed from: d */
    public String f1262d;

    /* JADX INFO: renamed from: e */
    public String f1263e;

    /* JADX INFO: renamed from: f */
    public String f1264f;

    /* JADX INFO: renamed from: g */
    public String f1265g;

    /* JADX INFO: renamed from: h */
    public String f1266h;

    /* JADX INFO: renamed from: i */
    public boolean f1267i;

    /* JADX INFO: renamed from: j */
    public String f1268j;

    /* JADX INFO: renamed from: k */
    public boolean f1269k;

    public ajg(JSONObject jSONObject) {
        super(jSONObject);
        this.f1259a = false;
        this.f1260b = null;
        this.f1261c = null;
        this.f1267i = false;
        m1514a(jSONObject);
    }

    /* JADX INFO: renamed from: a */
    private void m1514a(JSONObject jSONObject) {
        try {
            this.f1259a = "Yes".equalsIgnoreCase(jSONObject.optString("update"));
            if (this.f1259a) {
                this.f1260b = jSONObject.getString("update_log");
                this.f1261c = jSONObject.getString("version");
                this.f1262d = jSONObject.getString("path");
                this.f1266h = jSONObject.optString("target_size");
                this.f1264f = jSONObject.optString("new_md5");
                this.f1267i = jSONObject.optBoolean("delta");
                this.f1269k = jSONObject.optBoolean("display_ads", false);
                if (this.f1267i) {
                    this.f1268j = jSONObject.optString("patch_md5");
                    this.f1265g = jSONObject.optString("size");
                    this.f1263e = jSONObject.optString("origin");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    public String m1515a(Context context, boolean z) {
        String string = context.getString(atk.m5432a(context).m5436d("UMNewVersion"));
        String string2 = context.getString(atk.m5432a(context).m5436d("UMTargetSize"));
        String string3 = context.getString(atk.m5432a(context).m5436d("UMUpdateSize"));
        String string4 = context.getString(atk.m5432a(context).m5436d("UMUpdateContent"));
        String string5 = context.getString(atk.m5432a(context).m5436d("UMDialog_InstallAPK"));
        if (z) {
            return String.format("%s %s\n%s\n\n%s\n%s\n", string, this.f1261c, string5, string4, this.f1260b);
        }
        return String.format("%s %s\n%s %s%s\n\n%s\n%s\n", string, this.f1261c, string2, ats.m5473c(this.f1266h), this.f1267i ? String.format("\n%s %s", string3, ats.m5473c(this.f1265g)) : "", string4, this.f1260b);
    }
}
