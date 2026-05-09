package p000;

import android.content.Context;
import android.os.Build;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes.dex */
public class ahd {

    /* JADX INFO: renamed from: A */
    private static final String f911A = "ahd";

    /* JADX INFO: renamed from: a */
    public String f937a;

    /* JADX INFO: renamed from: b */
    public String f939b;

    /* JADX INFO: renamed from: c */
    public String f940c;

    /* JADX INFO: renamed from: d */
    public String f941d;

    /* JADX INFO: renamed from: e */
    public String f942e;

    /* JADX INFO: renamed from: f */
    public long f943f;

    /* JADX INFO: renamed from: g */
    public String f944g;

    /* JADX INFO: renamed from: h */
    public String f945h;

    /* JADX INFO: renamed from: i */
    public String f946i;

    /* JADX INFO: renamed from: j */
    public String f947j;

    /* JADX INFO: renamed from: k */
    public String f948k;

    /* JADX INFO: renamed from: l */
    public String f949l;

    /* JADX INFO: renamed from: m */
    public String f950m;

    /* JADX INFO: renamed from: n */
    public String f951n;

    /* JADX INFO: renamed from: o */
    public String f952o;

    /* JADX INFO: renamed from: p */
    public String f953p;

    /* JADX INFO: renamed from: q */
    public String f954q;

    /* JADX INFO: renamed from: r */
    public String f955r;

    /* JADX INFO: renamed from: s */
    public int f956s;

    /* JADX INFO: renamed from: t */
    public String f957t;

    /* JADX INFO: renamed from: u */
    public String f958u;

    /* JADX INFO: renamed from: v */
    public String f959v;

    /* JADX INFO: renamed from: w */
    public String f960w;

    /* JADX INFO: renamed from: x */
    public String f961x;

    /* JADX INFO: renamed from: y */
    public String f962y;

    /* JADX INFO: renamed from: z */
    public String f963z;

    /* JADX INFO: renamed from: B */
    private final String f912B = "appkey";

    /* JADX INFO: renamed from: C */
    private final String f913C = "channel";

    /* JADX INFO: renamed from: D */
    private final String f914D = "device_id";

    /* JADX INFO: renamed from: E */
    private final String f915E = "idmd5";

    /* JADX INFO: renamed from: F */
    private final String f916F = "mc";

    /* JADX INFO: renamed from: G */
    private final String f917G = "req_time";

    /* JADX INFO: renamed from: H */
    private final String f918H = "device_model";

    /* JADX INFO: renamed from: I */
    private final String f919I = "os";

    /* JADX INFO: renamed from: J */
    private final String f920J = "os_version";

    /* JADX INFO: renamed from: K */
    private final String f921K = "resolution";

    /* JADX INFO: renamed from: L */
    private final String f922L = "cpu";

    /* JADX INFO: renamed from: M */
    private final String f923M = "gpu_vender";

    /* JADX INFO: renamed from: N */
    private final String f924N = "gpu_renderer";

    /* JADX INFO: renamed from: O */
    private final String f925O = "app_version";

    /* JADX INFO: renamed from: P */
    private final String f926P = "version_code";

    /* JADX INFO: renamed from: Q */
    private final String f927Q = "package_name";

    /* JADX INFO: renamed from: R */
    private final String f928R = "sdk_type";

    /* JADX INFO: renamed from: S */
    private final String f929S = "sdk_version";

    /* JADX INFO: renamed from: T */
    private final String f930T = "timezone";

    /* JADX INFO: renamed from: U */
    private final String f931U = "country";

    /* JADX INFO: renamed from: V */
    private final String f932V = "language";

    /* JADX INFO: renamed from: W */
    private final String f933W = "access";

    /* JADX INFO: renamed from: X */
    private final String f934X = "access_subtype";

    /* JADX INFO: renamed from: Y */
    private final String f935Y = "carrier";

    /* JADX INFO: renamed from: Z */
    private final String f936Z = "wrapper_type";

    /* JADX INFO: renamed from: aa */
    private final String f938aa = "wrapper_version";

    /* JADX INFO: renamed from: c */
    private void m1066c(JSONObject jSONObject) throws JSONException {
        jSONObject.put("appkey", this.f937a);
        if (this.f937a == null || 24 != this.f937a.length()) {
            this.f940c = aii.m1317a(this.f940c, "utf-8");
        } else {
            this.f940c = aii.m1317a(this.f940c, "utf-8", this.f937a.substring(0, 16));
        }
        jSONObject.put("device_id", this.f940c);
        jSONObject.put("idmd5", this.f941d);
        if (this.f939b != null) {
            jSONObject.put("channel", this.f939b);
        }
        if (this.f942e != null) {
            jSONObject.put("mc", this.f942e);
        }
        if (this.f943f > 0) {
            jSONObject.put("req_time", this.f943f);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m1067d(JSONObject jSONObject) throws JSONException {
        jSONObject.put("appkey", this.f937a);
        if (this.f939b != null) {
            jSONObject.put("channel", this.f939b);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m1068e(JSONObject jSONObject) throws JSONException {
        if (this.f944g != null) {
            jSONObject.put("device_model", this.f944g);
        }
        if (this.f945h != null) {
            jSONObject.put("os", this.f945h);
        }
        if (this.f946i != null) {
            jSONObject.put("os_version", this.f946i);
        }
        if (this.f947j != null) {
            jSONObject.put("resolution", this.f947j);
        }
        if (this.f948k != null) {
            jSONObject.put("cpu", this.f948k);
        }
        if (this.f949l != null) {
            jSONObject.put("gpu_vender", this.f949l);
        }
        if (this.f950m != null) {
            jSONObject.put("gpu_vender", this.f950m);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m1069f(JSONObject jSONObject) throws JSONException {
        if (this.f944g != null) {
            jSONObject.put("device_model", this.f944g);
        }
        if (this.f945h != null) {
            jSONObject.put("os", this.f945h);
        }
        if (this.f946i != null) {
            jSONObject.put("os_version", this.f946i);
        }
    }

    /* JADX INFO: renamed from: g */
    private void m1070g(JSONObject jSONObject) throws JSONException {
        if (this.f951n != null) {
            jSONObject.put("app_version", this.f951n);
        }
        if (this.f952o != null) {
            jSONObject.put("version_code", this.f952o);
        }
        if (this.f953p != null) {
            jSONObject.put("package_name", this.f953p);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m1071h(JSONObject jSONObject) throws JSONException {
        if (this.f951n != null) {
            jSONObject.put("app_version", this.f951n);
        }
        if (this.f952o != null) {
            jSONObject.put("version_code", this.f952o);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m1072i(JSONObject jSONObject) throws JSONException {
        jSONObject.put("sdk_type", this.f954q);
        jSONObject.put("sdk_version", this.f955r);
    }

    /* JADX INFO: renamed from: j */
    private void m1073j(JSONObject jSONObject) throws JSONException {
        jSONObject.put("timezone", this.f956s);
        if (this.f957t != null) {
            jSONObject.put("country", this.f957t);
        }
        if (this.f958u != null) {
            jSONObject.put("language", this.f958u);
        }
    }

    /* JADX INFO: renamed from: k */
    private void m1074k(JSONObject jSONObject) throws JSONException {
        if (this.f959v != null) {
            jSONObject.put("access", this.f959v);
        }
        if (this.f960w != null) {
            jSONObject.put("access_subtype", this.f960w);
        }
        if (this.f961x != null) {
            jSONObject.put("carrier", this.f961x);
        }
    }

    /* JADX INFO: renamed from: l */
    private void m1075l(JSONObject jSONObject) throws JSONException {
        if (this.f962y != null) {
            jSONObject.put("wrapper_type", this.f962y);
        }
        if (this.f963z != null) {
            jSONObject.put("wrapper_version", this.f963z);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1078a(JSONObject jSONObject) {
        m1066c(jSONObject);
        m1068e(jSONObject);
        m1070g(jSONObject);
        m1072i(jSONObject);
        m1073j(jSONObject);
        m1074k(jSONObject);
        m1075l(jSONObject);
    }

    /* JADX INFO: renamed from: b */
    public void m1081b(JSONObject jSONObject) {
        m1067d(jSONObject);
        m1069f(jSONObject);
        m1071h(jSONObject);
        m1072i(jSONObject);
        m1074k(jSONObject);
    }

    /* JADX INFO: renamed from: a */
    public void m1077a(Context context, String... strArr) {
        if (strArr != null && strArr.length == 2) {
            this.f937a = strArr[0];
            this.f939b = strArr[1];
        }
        if (this.f937a == null) {
            this.f937a = PushAgent.getInstance(context).getMessageAppkey();
        }
        if (this.f939b == null) {
            this.f939b = PushAgent.getInstance(context).getMessageChannel();
        }
        this.f940c = ahc.m1052c(context);
        this.f941d = ahc.m1053d(context);
        this.f942e = ahc.m1058i(context);
    }

    /* JADX INFO: renamed from: a */
    public void m1076a(Context context) {
        this.f944g = Build.MODEL;
        this.f945h = "Android";
        this.f946i = Build.VERSION.RELEASE;
        this.f947j = ahc.m1059j(context);
        this.f948k = ahc.m1047a();
    }

    /* JADX INFO: renamed from: b */
    public void m1079b(Context context) {
        this.f951n = ahc.m1050b(context);
        this.f952o = ahc.m1048a(context);
        this.f953p = ahc.m1062m(context);
    }

    /* JADX INFO: renamed from: c */
    public void m1082c(Context context) {
        this.f954q = "Android";
        this.f955r = MsgConstant.SDK_VERSION;
    }

    /* JADX INFO: renamed from: d */
    public void m1084d(Context context) {
        this.f956s = ahc.m1055f(context);
        String[] strArrM1056g = ahc.m1056g(context);
        this.f957t = strArrM1056g[0];
        this.f958u = strArrM1056g[1];
    }

    /* JADX INFO: renamed from: e */
    public void m1085e(Context context) {
        String[] strArrM1054e = ahc.m1054e(context);
        this.f959v = strArrM1054e[0];
        this.f960w = strArrM1054e[1];
        this.f961x = ahc.m1060k(context);
    }

    /* JADX INFO: renamed from: b */
    public void m1080b(Context context, String... strArr) {
        m1077a(context, strArr);
        m1076a(context);
        m1079b(context);
        m1082c(context);
        m1084d(context);
        m1085e(context);
    }

    /* JADX INFO: renamed from: c */
    public void m1083c(Context context, String... strArr) {
        m1077a(context, strArr);
        m1076a(context);
        m1079b(context);
        m1082c(context);
        m1085e(context);
    }
}
