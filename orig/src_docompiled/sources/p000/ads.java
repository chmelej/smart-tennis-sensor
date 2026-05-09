package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import com.umeng.message.MsgConstant;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.adk;
import p000.aez;

/* JADX INFO: compiled from: CacheImpl.java */
/* JADX INFO: loaded from: classes.dex */
public final class ads implements adw, aea {

    /* JADX INFO: renamed from: j */
    private static Context f453j;

    /* JADX INFO: renamed from: a */
    String f454a;

    /* JADX INFO: renamed from: b */
    private afc f455b;

    /* JADX INFO: renamed from: c */
    private aef f456c;

    /* JADX INFO: renamed from: d */
    private aei f457d;

    /* JADX INFO: renamed from: e */
    private aeh f458e;

    /* JADX INFO: renamed from: f */
    private aej f459f;

    /* JADX INFO: renamed from: g */
    private C0017a f460g;

    /* JADX INFO: renamed from: h */
    private adk.C0013a f461h;

    /* JADX INFO: renamed from: n */
    private int f466n;

    /* JADX INFO: renamed from: o */
    private int f467o;

    /* JADX INFO: renamed from: p */
    private long f468p;

    /* JADX INFO: renamed from: i */
    private long f462i = 0;

    /* JADX INFO: renamed from: k */
    private int f463k = 10;

    /* JADX INFO: renamed from: l */
    private JSONArray f464l = new JSONArray();

    /* JADX INFO: renamed from: m */
    private final int f465m = 5000;

    /* JADX INFO: renamed from: q */
    private final long f469q = 28800000;

    public ads(Context context) {
        this.f455b = null;
        this.f456c = null;
        this.f457d = null;
        this.f458e = null;
        this.f459f = null;
        this.f460g = null;
        this.f461h = null;
        this.f454a = null;
        this.f466n = 0;
        this.f467o = 0;
        this.f468p = 0L;
        f453j = context;
        this.f456c = new aef(context);
        this.f455b = afc.m806a(context);
        this.f461h = adk.m357a(context).m366b();
        this.f460g = new C0017a();
        this.f458e = aeh.m499a(f453j);
        this.f457d = aei.m509a(f453j);
        this.f459f = aej.m515a(f453j, this.f456c);
        SharedPreferences sharedPreferencesM454a = aeb.m454a(f453j);
        this.f468p = sharedPreferencesM454a.getLong("thtstart", 0L);
        this.f466n = sharedPreferencesM454a.getInt("gkvc", 0);
        this.f467o = sharedPreferencesM454a.getInt("ekvc", 0);
        this.f454a = this.f461h.m374a((String) null);
    }

    @Override // p000.adw
    /* JADX INFO: renamed from: a */
    public void mo424a() throws Throwable {
        if (aeu.m738j(f453j)) {
            m418d();
        } else {
            aex.m768a("network is unavailable");
        }
    }

    @Override // p000.adw
    /* JADX INFO: renamed from: a */
    public void mo427a(Object obj) {
        if (this.f456c.m487e()) {
            this.f462i = this.f456c.m493k();
        }
        boolean z = true;
        if (obj instanceof JSONObject) {
            z = false;
            try {
                m412b((JSONObject) obj);
            } catch (Throwable unused) {
            }
        }
        if (m409a(z)) {
            m418d();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m412b(JSONObject jSONObject) {
        try {
            if (2050 == jSONObject.getInt("__t")) {
                if (!m416c(this.f466n)) {
                    return;
                } else {
                    this.f466n++;
                }
            } else if (2049 == jSONObject.getInt("__t")) {
                if (!m416c(this.f467o)) {
                    return;
                } else {
                    this.f467o++;
                }
            }
            if (this.f464l.length() > this.f463k) {
                agy.m991a(f453j).m999a(this.f464l);
                this.f464l = new JSONArray();
            }
            if (this.f468p == 0) {
                this.f468p = System.currentTimeMillis();
            }
            this.f464l.put(jSONObject);
        } catch (Throwable unused) {
        }
    }

    @Override // p000.adw
    /* JADX INFO: renamed from: b */
    public void mo429b() {
        m415c(m423a(new int[0]));
    }

    /* JADX INFO: renamed from: a */
    private void m407a(int i) {
        m415c(m423a(i, (int) (System.currentTimeMillis() - this.f456c.m494l())));
        aey.m780a(new afa() { // from class: ads.1
            @Override // p000.afa
            /* JADX INFO: renamed from: a */
            public void mo314a() throws Throwable {
                ads.this.mo424a();
            }
        }, i);
    }

    /* JADX INFO: renamed from: c */
    private void m415c(JSONObject jSONObject) {
        adf adfVarM329a;
        if (jSONObject == null) {
            return;
        }
        try {
            adi adiVarM343a = adi.m343a(f453j);
            adiVarM343a.m347a();
            try {
                String strEncodeToString = Base64.encodeToString(new afj().m842a(adiVarM343a.m349b()), 0);
                if (!TextUtils.isEmpty(strEncodeToString)) {
                    JSONObject jSONObject2 = jSONObject.getJSONObject(MsgConstant.KEY_HEADER);
                    jSONObject2.put("id_tracking", strEncodeToString);
                    jSONObject.put(MsgConstant.KEY_HEADER, jSONObject2);
                }
            } catch (Exception unused) {
            }
            byte[] bytes = String.valueOf(jSONObject).getBytes();
            if (bytes == null || aes.m706a(f453j, bytes)) {
                return;
            }
            if (m421e()) {
                adfVarM329a = adf.m332b(f453j, acz.m287a(f453j), bytes);
            } else {
                adfVarM329a = adf.m329a(f453j, acz.m287a(f453j), bytes);
            }
            byte[] bArrM341c = adfVarM329a.m341c();
            afc afcVarM806a = afc.m806a(f453j);
            afcVarM806a.m816e();
            afcVarM806a.m811a(bArrM341c);
            adiVarM343a.m350c();
        } catch (Exception unused2) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x01b0 A[Catch: Throwable -> 0x01ea, TryCatch #0 {Throwable -> 0x01ea, blocks: (B:62:0x01a7, B:64:0x01b0, B:66:0x01be, B:67:0x01cf), top: B:138:0x01a7, outer: #6 }] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected org.json.JSONObject m423a(int... r11) {
        /*
            Method dump skipped, instruction units count: 1127
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ads.m423a(int[]):org.json.JSONObject");
    }

    /* JADX INFO: renamed from: d */
    private void m419d(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(aeh.m499a(f453j).m508d(), aeh.m499a(f453j).m507c());
        jSONObject.put("group_info", jSONObject2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m428a(JSONObject jSONObject) {
        return (TextUtils.isEmpty("device_id") || TextUtils.isEmpty("mc") || TextUtils.isEmpty("resolution") || TextUtils.isEmpty("appkey") || TextUtils.isEmpty("channel") || TextUtils.isEmpty("app_signature") || TextUtils.isEmpty("package_name") || TextUtils.isEmpty("app_version")) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m409a(boolean z) throws Throwable {
        if (!aeu.m738j(f453j)) {
            aex.m776c("network is unavailable");
            return false;
        }
        if (this.f456c.m487e()) {
            return true;
        }
        return this.f460g.m433b(z).mo784a(z);
    }

    /* JADX INFO: renamed from: d */
    private void m418d() {
        try {
            if (this.f455b.m817f()) {
                aed aedVar = new aed(f453j, this.f456c);
                aedVar.m468a(this);
                if (this.f457d.m514c()) {
                    aedVar.m471b(true);
                }
                aedVar.m467a();
                return;
            }
            JSONObject jSONObjectM423a = m423a(new int[0]);
            if (jSONObjectM423a != null && jSONObjectM423a.length() > 0) {
                aed aedVar2 = new aed(f453j, this.f456c);
                aedVar2.m468a(this);
                if (this.f457d.m514c()) {
                    aedVar2.m471b(true);
                }
                aedVar2.m469a(jSONObjectM423a);
                aedVar2.m470a(m421e());
                aedVar2.m467a();
            }
        } catch (Throwable th) {
            if (th != null) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m421e() {
        switch (this.f461h.m381c(-1)) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m411b(int i) {
        m407a(i);
    }

    @Override // p000.aea
    /* JADX INFO: renamed from: a */
    public void mo425a(adk.C0013a c0013a) throws Throwable {
        this.f458e.mo425a(c0013a);
        this.f457d.mo425a(c0013a);
        this.f459f.mo425a(c0013a);
        this.f460g.m431a(c0013a);
        this.f454a = adk.m357a(f453j).m366b().m374a((String) null);
    }

    /* JADX INFO: renamed from: ads$a */
    /* JADX INFO: compiled from: CacheImpl.java */
    public class C0017a {

        /* JADX INFO: renamed from: b */
        private aez.C0076h f472b;

        /* JADX INFO: renamed from: c */
        private int f473c;

        /* JADX INFO: renamed from: d */
        private int f474d;

        /* JADX INFO: renamed from: e */
        private int f475e = -1;

        /* JADX INFO: renamed from: f */
        private int f476f = -1;

        public C0017a() {
            this.f473c = -1;
            this.f474d = -1;
            int[] iArrM377a = ads.this.f461h.m377a(-1, -1);
            this.f473c = iArrM377a[0];
            this.f474d = iArrM377a[1];
        }

        /* JADX INFO: renamed from: a */
        protected void m432a(boolean z) {
            aez.C0076h c0070b;
            int iM383d = 0;
            if (ads.this.f457d.m514c()) {
                if (!((this.f472b instanceof aez.C0070b) && this.f472b.mo785a())) {
                    c0070b = new aez.C0070b(ads.this.f456c, ads.this.f457d);
                } else {
                    c0070b = this.f472b;
                }
                this.f472b = c0070b;
                return;
            }
            if ((this.f472b instanceof aez.C0071c) && this.f472b.mo785a()) {
                return;
            }
            if (z && ads.this.f459f.m516a()) {
                this.f472b = new aez.C0071c((int) ads.this.f459f.m517b());
                ads.this.m411b((int) ads.this.f459f.m517b());
                return;
            }
            if (!aex.f711a || !ads.this.f461h.m380b()) {
                if (ads.this.f458e.m505a() && "RPT".equals(ads.this.f458e.m508d())) {
                    if (ads.this.f458e.m506b() == 6) {
                        if (ads.this.f461h.m376a()) {
                            iM383d = ads.this.f461h.m383d(90000);
                        } else if (this.f474d > 0) {
                            iM383d = this.f474d;
                        } else {
                            iM383d = this.f476f;
                        }
                    }
                    this.f472b = m430a(ads.this.f458e.m506b(), iM383d);
                    return;
                }
                int i = this.f475e;
                int i2 = this.f476f;
                if (this.f473c != -1) {
                    i = this.f473c;
                    i2 = this.f474d;
                }
                this.f472b = m430a(i, i2);
                return;
            }
            this.f472b = new aez.C0069a(ads.this.f456c);
        }

        /* JADX INFO: renamed from: b */
        public aez.C0076h m433b(boolean z) {
            m432a(z);
            return this.f472b;
        }

        /* JADX INFO: renamed from: a */
        private aez.C0076h m430a(int i, int i2) {
            switch (i) {
                case 0:
                    return this.f472b instanceof aez.C0075g ? this.f472b : new aez.C0075g();
                case 1:
                    return this.f472b instanceof aez.C0072d ? this.f472b : new aez.C0072d();
                case 2:
                case 3:
                case 7:
                default:
                    return this.f472b instanceof aez.C0072d ? this.f472b : new aez.C0072d();
                case 4:
                    return this.f472b instanceof aez.C0074f ? this.f472b : new aez.C0074f(ads.this.f456c);
                case 5:
                    return this.f472b instanceof aez.C0077i ? this.f472b : new aez.C0077i(ads.f453j);
                case 6:
                    if (this.f472b instanceof aez.C0073e) {
                        aez.C0076h c0076h = this.f472b;
                        ((aez.C0073e) c0076h).m786a(i2);
                        return c0076h;
                    }
                    return new aez.C0073e(ads.this.f456c, i2);
                case 8:
                    return this.f472b instanceof aez.C0078j ? this.f472b : new aez.C0078j(ads.this.f456c);
            }
        }

        /* JADX INFO: renamed from: a */
        public void m431a(adk.C0013a c0013a) {
            int[] iArrM377a = c0013a.m377a(-1, -1);
            this.f473c = iArrM377a[0];
            this.f474d = iArrM377a[1];
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m416c(int i) {
        if (this.f468p == 0) {
            return true;
        }
        if (System.currentTimeMillis() - this.f468p <= 28800000) {
            return i <= 5000;
        }
        m422f();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m426a(Context context) {
        try {
            if (f453j == null) {
                f453j = context;
            }
            if (this.f464l.length() > 0) {
                agy.m991a(f453j).m999a(this.f464l);
                this.f464l = new JSONArray();
            }
            aeb.m454a(f453j).edit().putLong("thtstart", this.f468p).putInt("gkvc", this.f466n).putInt("ekvc", this.f467o).commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: f */
    private void m422f() {
        this.f466n = 0;
        this.f467o = 0;
        this.f468p = System.currentTimeMillis();
    }
}
