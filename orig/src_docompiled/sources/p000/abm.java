package p000;

import android.content.Context;
import android.os.Build;
import android.util.DisplayMetrics;
import com.umeng.message.MsgConstant;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
final class abm {

    /* JADX INFO: renamed from: a */
    String f127a;

    /* JADX INFO: renamed from: b */
    String f128b;

    /* JADX INFO: renamed from: c */
    DisplayMetrics f129c;

    /* JADX INFO: renamed from: d */
    int f130d;

    /* JADX INFO: renamed from: e */
    String f131e;

    /* JADX INFO: renamed from: f */
    String f132f;

    /* JADX INFO: renamed from: g */
    String f133g;

    /* JADX INFO: renamed from: h */
    String f134h;

    /* JADX INFO: renamed from: i */
    String f135i;

    /* JADX INFO: renamed from: j */
    String f136j;

    /* JADX INFO: renamed from: k */
    String f137k;

    /* JADX INFO: renamed from: l */
    int f138l;

    /* JADX INFO: renamed from: m */
    String f139m;

    /* JADX INFO: renamed from: n */
    String f140n;

    /* JADX INFO: renamed from: o */
    Context f141o;

    /* JADX INFO: renamed from: p */
    private String f142p;

    /* JADX INFO: renamed from: q */
    private String f143q;

    /* JADX INFO: renamed from: r */
    private String f144r;

    /* JADX INFO: renamed from: s */
    private String f145s;

    private abm(Context context) {
        this.f128b = "2.0.3";
        this.f130d = Build.VERSION.SDK_INT;
        this.f131e = Build.MODEL;
        this.f132f = Build.MANUFACTURER;
        this.f133g = Locale.getDefault().getLanguage();
        this.f138l = 0;
        this.f139m = null;
        this.f140n = null;
        this.f141o = null;
        this.f142p = null;
        this.f143q = null;
        this.f144r = null;
        this.f145s = null;
        this.f141o = context.getApplicationContext();
        this.f129c = abt.m93d(this.f141o);
        this.f127a = abt.m105j(this.f141o);
        this.f134h = acb.m163b(this.f141o);
        this.f135i = abt.m102i(this.f141o);
        this.f136j = TimeZone.getDefault().getID();
        Context context2 = this.f141o;
        this.f138l = abt.m86b();
        this.f137k = abt.m109n(this.f141o);
        this.f139m = this.f141o.getPackageName();
        if (this.f130d >= 14) {
            this.f142p = abt.m114s(this.f141o);
        }
        Context context3 = this.f141o;
        this.f143q = abt.m99g().toString();
        this.f144r = abt.m113r(this.f141o);
        this.f145s = abt.m96f();
        this.f140n = abt.m119x(this.f141o);
    }

    /* synthetic */ abm(Context context, byte b) {
        this(context);
    }

    /* JADX INFO: renamed from: a */
    final void m67a(JSONObject jSONObject, Thread thread) throws JSONException {
        String str;
        String strM174e;
        if (thread == null) {
            if (this.f129c != null) {
                jSONObject.put("sr", this.f129c.widthPixels + "*" + this.f129c.heightPixels);
                jSONObject.put("dpi", this.f129c.xdpi + "*" + this.f129c.ydpi);
            }
            if (acf.m234a(this.f141o).m243e()) {
                JSONObject jSONObject2 = new JSONObject();
                abz.m134a(jSONObject2, "bs", abz.m138c(this.f141o));
                abz.m134a(jSONObject2, "ss", abz.m139d(this.f141o));
                if (jSONObject2.length() > 0) {
                    abz.m134a(jSONObject, "wf", jSONObject2.toString());
                }
            }
            JSONArray jSONArrayM141f = abz.m141f(this.f141o);
            if (jSONArrayM141f != null && jSONArrayM141f.length() > 0) {
                abz.m134a(jSONObject, "wflist", jSONArrayM141f.toString());
            }
            str = "sen";
            strM174e = this.f142p;
        } else {
            abz.m134a(jSONObject, "thn", thread.getName());
            abz.m134a(jSONObject, "qq", acb.m167c(this.f141o));
            abz.m134a(jSONObject, "cui", acb.m171d(this.f141o));
            if (abt.m91c(this.f144r) && this.f144r.split("/").length == 2) {
                abz.m134a(jSONObject, "fram", this.f144r.split("/")[0]);
            }
            if (abt.m91c(this.f145s) && this.f145s.split("/").length == 2) {
                abz.m134a(jSONObject, "from", this.f145s.split("/")[0]);
            }
            if (acs.m255a(this.f141o).m284b(this.f141o) != null) {
                jSONObject.put("ui", acs.m255a(this.f141o).m284b(this.f141o).m61a());
            }
            str = "mid";
            strM174e = acb.m174e(this.f141o);
        }
        abz.m134a(jSONObject, str, strM174e);
        abz.m134a(jSONObject, "pcn", abt.m110o(this.f141o));
        abz.m134a(jSONObject, "osn", Build.VERSION.RELEASE);
        abz.m134a(jSONObject, "av", this.f127a);
        abz.m134a(jSONObject, "ch", this.f134h);
        abz.m134a(jSONObject, "mf", this.f132f);
        abz.m134a(jSONObject, "sv", this.f128b);
        abz.m134a(jSONObject, "osd", Build.DISPLAY);
        abz.m134a(jSONObject, "prod", Build.PRODUCT);
        abz.m134a(jSONObject, MsgConstant.KEY_TAGS, Build.TAGS);
        abz.m134a(jSONObject, "id", Build.ID);
        abz.m134a(jSONObject, "fng", Build.FINGERPRINT);
        abz.m134a(jSONObject, "lch", this.f140n);
        abz.m134a(jSONObject, "ov", Integer.toString(this.f130d));
        jSONObject.put("os", 1);
        abz.m134a(jSONObject, "op", this.f135i);
        abz.m134a(jSONObject, "lg", this.f133g);
        abz.m134a(jSONObject, "md", this.f131e);
        abz.m134a(jSONObject, "tz", this.f136j);
        if (this.f138l != 0) {
            jSONObject.put("jb", this.f138l);
        }
        abz.m134a(jSONObject, "sd", this.f137k);
        abz.m134a(jSONObject, "apn", this.f139m);
        abz.m134a(jSONObject, "cpu", this.f143q);
        abz.m134a(jSONObject, "abi", Build.CPU_ABI);
        abz.m134a(jSONObject, "abi2", Build.CPU_ABI2);
        abz.m134a(jSONObject, "ram", this.f144r);
        abz.m134a(jSONObject, "rom", this.f145s);
    }
}
