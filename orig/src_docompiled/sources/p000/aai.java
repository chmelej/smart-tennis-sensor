package p000;

import android.content.Context;
import com.umeng.message.MsgConstant;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public abstract class aai {

    /* JADX INFO: renamed from: j */
    protected static String f28j;

    /* JADX INFO: renamed from: a */
    private ace f29a;

    /* JADX INFO: renamed from: b */
    protected String f30b;

    /* JADX INFO: renamed from: c */
    protected long f31c = System.currentTimeMillis() / 1000;

    /* JADX INFO: renamed from: d */
    protected int f32d;

    /* JADX INFO: renamed from: e */
    protected abk f33e;

    /* JADX INFO: renamed from: f */
    protected int f34f;

    /* JADX INFO: renamed from: g */
    protected String f35g;

    /* JADX INFO: renamed from: h */
    protected String f36h;

    /* JADX INFO: renamed from: i */
    protected String f37i;

    /* JADX INFO: renamed from: k */
    protected boolean f38k;

    /* JADX INFO: renamed from: l */
    protected Context f39l;

    aai(Context context, int i, ace aceVar) {
        this.f30b = null;
        this.f33e = null;
        this.f35g = null;
        this.f36h = null;
        this.f37i = null;
        this.f38k = false;
        this.f29a = null;
        this.f39l = context;
        this.f32d = i;
        this.f36h = acb.m163b(context);
        this.f37i = abt.m105j(context);
        this.f30b = acb.m152a(context);
        if (aceVar != null) {
            this.f29a = aceVar;
            if (abt.m91c(aceVar.m230c())) {
                this.f30b = aceVar.m230c();
            }
            if (abt.m91c(aceVar.m231d())) {
                this.f36h = aceVar.m231d();
            }
            if (abt.m91c(aceVar.m229b())) {
                this.f37i = aceVar.m229b();
            }
            this.f38k = aceVar.m232e();
        }
        this.f35g = acb.m171d(context);
        this.f33e = acs.m255a(context).m284b(context);
        this.f34f = mo19b() != aaj.NETWORK_DETECTOR ? abt.m112q(context).intValue() : -aaj.NETWORK_DETECTOR.m27a();
        if (C2290zd.m12539b(f28j)) {
            return;
        }
        String strM174e = acb.m174e(context);
        f28j = strM174e;
        if (abt.m91c(strM174e)) {
            return;
        }
        f28j = "0";
    }

    /* JADX INFO: renamed from: b */
    private boolean m21b(JSONObject jSONObject) {
        try {
            abz.m134a(jSONObject, "ky", this.f30b);
            jSONObject.put("et", mo19b().m27a());
            if (this.f33e != null) {
                jSONObject.put("ui", this.f33e.m61a());
                abz.m134a(jSONObject, "mc", this.f33e.m62b());
                int iM64d = this.f33e.m64d();
                jSONObject.put("ut", iM64d);
                if (iM64d == 0 && abt.m115t(this.f39l) == 1) {
                    jSONObject.put("ia", 1);
                }
            }
            abz.m134a(jSONObject, "cui", this.f35g);
            if (mo19b() != aaj.SESSION_ENV) {
                abz.m134a(jSONObject, "av", this.f37i);
                abz.m134a(jSONObject, "ch", this.f36h);
            }
            if (this.f38k) {
                jSONObject.put("impt", 1);
            }
            abz.m134a(jSONObject, "mid", f28j);
            jSONObject.put("idx", this.f34f);
            jSONObject.put("si", this.f32d);
            jSONObject.put(MsgConstant.KEY_TS, this.f31c);
            jSONObject.put("dts", abt.m77a(this.f39l, false));
            return mo18a(jSONObject);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo18a(JSONObject jSONObject);

    /* JADX INFO: renamed from: b */
    public abstract aaj mo19b();

    /* JADX INFO: renamed from: c */
    public final long m22c() {
        return this.f31c;
    }

    /* JADX INFO: renamed from: d */
    public final ace m23d() {
        return this.f29a;
    }

    /* JADX INFO: renamed from: e */
    public final Context m24e() {
        return this.f39l;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m25f() {
        return this.f38k;
    }

    /* JADX INFO: renamed from: g */
    public final String m26g() {
        try {
            JSONObject jSONObject = new JSONObject();
            m21b(jSONObject);
            return jSONObject.toString();
        } catch (Throwable unused) {
            return "";
        }
    }
}
