package p000;

import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMessage.java */
/* JADX INFO: loaded from: classes.dex */
public class ahf {

    /* JADX INFO: renamed from: a */
    public String f975a;

    /* JADX INFO: renamed from: b */
    public String f976b;

    /* JADX INFO: renamed from: c */
    public String f977c;

    /* JADX INFO: renamed from: d */
    public String f978d;

    /* JADX INFO: renamed from: e */
    public String f979e;

    /* JADX INFO: renamed from: f */
    public String f980f;

    /* JADX INFO: renamed from: g */
    public String f981g;

    /* JADX INFO: renamed from: h */
    public String f982h;

    /* JADX INFO: renamed from: i */
    public boolean f983i;

    /* JADX INFO: renamed from: j */
    public boolean f984j;

    /* JADX INFO: renamed from: k */
    public boolean f985k;

    /* JADX INFO: renamed from: l */
    public boolean f986l;

    /* JADX INFO: renamed from: m */
    public String f987m;

    /* JADX INFO: renamed from: n */
    public String f988n;

    /* JADX INFO: renamed from: o */
    public String f989o;

    /* JADX INFO: renamed from: p */
    public String f990p;

    /* JADX INFO: renamed from: q */
    public String f991q;

    /* JADX INFO: renamed from: r */
    public String f992r;

    /* JADX INFO: renamed from: s */
    public String f993s;

    /* JADX INFO: renamed from: t */
    public int f994t;

    /* JADX INFO: renamed from: u */
    public Map<String, String> f995u;

    /* JADX INFO: renamed from: v */
    public String f996v;

    /* JADX INFO: renamed from: w */
    public long f997w;

    /* JADX INFO: renamed from: x */
    public boolean f998x;

    /* JADX INFO: renamed from: y */
    private JSONObject f999y;

    public ahf(JSONObject jSONObject) throws JSONException {
        this.f999y = jSONObject;
        this.f975a = jSONObject.getString(MsgConstant.KEY_MSG_ID);
        this.f978d = jSONObject.getString("display_type");
        this.f979e = jSONObject.optString(MsgConstant.KEY_ALIAS);
        this.f997w = jSONObject.optLong("random_min");
        JSONObject jSONObject2 = jSONObject.getJSONObject("body");
        this.f980f = jSONObject2.optString("ticker");
        this.f981g = jSONObject2.optString("title");
        this.f982h = jSONObject2.optString("text");
        this.f983i = jSONObject2.optBoolean("play_vibrate", true);
        this.f984j = jSONObject2.optBoolean("play_lights", true);
        this.f985k = jSONObject2.optBoolean("play_sound", true);
        this.f986l = jSONObject2.optBoolean("screen_on", false);
        this.f989o = jSONObject2.optString("url");
        this.f991q = jSONObject2.optString("img");
        this.f990p = jSONObject2.optString("sound");
        this.f992r = jSONObject2.optString("icon");
        this.f987m = jSONObject2.optString("after_open");
        this.f996v = jSONObject2.optString("largeIcon");
        this.f993s = jSONObject2.optString("activity");
        this.f988n = jSONObject2.optString("custom");
        this.f994t = jSONObject2.optInt("builder_id", 0);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extra");
        if (jSONObjectOptJSONObject == null || jSONObjectOptJSONObject.keys() == null) {
            return;
        }
        this.f995u = new HashMap();
        Iterator<String> itKeys = jSONObjectOptJSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            this.f995u.put(next, jSONObjectOptJSONObject.getString(next));
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m1090a() {
        return this.f999y;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1091b() {
        return m1092c() || m1093d();
    }

    /* JADX INFO: renamed from: c */
    public boolean m1092c() {
        return !TextUtils.isEmpty(this.f991q);
    }

    /* JADX INFO: renamed from: d */
    public boolean m1093d() {
        return !TextUtils.isEmpty(this.f990p) && (this.f990p.startsWith("http://") || this.f990p.startsWith("https://"));
    }
}
