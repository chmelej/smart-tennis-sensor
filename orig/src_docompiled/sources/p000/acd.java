package p000;

import android.content.Context;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class acd {

    /* JADX INFO: renamed from: a */
    static volatile int f248a = 0;

    /* JADX INFO: renamed from: b */
    static volatile long f249b = 0;

    /* JADX INFO: renamed from: c */
    static volatile long f250c = 0;

    /* JADX INFO: renamed from: d */
    private static abn f251d = null;

    /* JADX INFO: renamed from: h */
    private static volatile long f255h = 0;

    /* JADX INFO: renamed from: i */
    private static volatile long f256i = 0;

    /* JADX INFO: renamed from: j */
    private static volatile long f257j = 0;

    /* JADX INFO: renamed from: k */
    private static String f258k = "";

    /* JADX INFO: renamed from: l */
    private static volatile int f259l = 0;

    /* JADX INFO: renamed from: m */
    private static volatile String f260m = "";

    /* JADX INFO: renamed from: n */
    private static volatile String f261n = "";

    /* JADX INFO: renamed from: r */
    private static Thread.UncaughtExceptionHandler f265r = null;

    /* JADX INFO: renamed from: s */
    private static volatile boolean f266s = true;

    /* JADX INFO: renamed from: t */
    private static Context f267t;

    /* JADX INFO: renamed from: e */
    private static volatile Map<aag, Long> f252e = new ConcurrentHashMap();

    /* JADX INFO: renamed from: f */
    private static volatile Map<String, Properties> f253f = new ConcurrentHashMap();

    /* JADX INFO: renamed from: g */
    private static volatile Map<Integer, Integer> f254g = new ConcurrentHashMap(10);

    /* JADX INFO: renamed from: o */
    private static Map<String, Long> f262o = new ConcurrentHashMap();

    /* JADX INFO: renamed from: p */
    private static Map<String, Long> f263p = new ConcurrentHashMap();

    /* JADX INFO: renamed from: q */
    private static abj f264q = abt.m89c();

    /* JADX INFO: renamed from: a */
    static int m194a(Context context, boolean z, ace aceVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        boolean z2 = z && jCurrentTimeMillis - f256i >= ((long) acb.m170d());
        f256i = jCurrentTimeMillis;
        if (f257j == 0) {
            f257j = abt.m92d();
        }
        if (jCurrentTimeMillis >= f257j) {
            f257j = abt.m92d();
            if (acs.m255a(context).m284b(context).m64d() != 1) {
                acs.m255a(context).m284b(context).m63c();
            }
            acb.m189t();
            f248a = 0;
            f258k = abt.m94e();
            z2 = true;
        }
        String str = f258k;
        if (abt.m84a(aceVar)) {
            str = aceVar.m230c() + f258k;
        }
        if (!f263p.containsKey(str)) {
            z2 = true;
        }
        if (z2) {
            if (abt.m84a(aceVar)) {
                m199a(context, aceVar);
            } else if (acb.m190u() < acb.m187r()) {
                abt.m116u(context);
                m199a(context, (ace) null);
            } else {
                f264q.m57e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
            f263p.put(str, 1L);
        }
        if (f266s) {
            if (acb.m169c()) {
                Context contextM218g = m218g(context);
                if (contextM218g == null) {
                    f264q.m56d("The Context of StatService.testSpeed() can not be null!");
                } else if (m222i(contextM218g) != null) {
                    f251d.m68a(new ach(contextM218g));
                }
            }
            f266s = false;
        }
        return f259l;
    }

    /* JADX INFO: renamed from: a */
    public static Properties m197a(String str) {
        return f253f.get(str);
    }

    /* JADX INFO: renamed from: a */
    public static void m198a(Context context) {
        if (acb.m169c() && m222i(context) != null) {
            f251d.m68a(new ack(context));
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m199a(Context context, ace aceVar) {
        if (m222i(context) != null) {
            if (acb.m166b()) {
                f264q.m59g("start new session.");
            }
            if (aceVar == null || f259l == 0) {
                f259l = abt.m76a();
            }
            acb.m186q();
            acb.m188s();
            new aco(new aan(context, f259l, m226l(), aceVar)).m254a();
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m200a(Context context, String str) {
        abj abjVar;
        String str2;
        if (acb.m169c()) {
            Context contextM218g = m218g(context);
            if (contextM218g == null) {
                abjVar = f264q;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else {
                if (!(str == null || str.length() == 0)) {
                    aag aagVar = new aag(str);
                    if (m222i(contextM218g) != null) {
                        f251d.m68a(new abf(contextM218g, aagVar));
                        return;
                    }
                    return;
                }
                abjVar = f264q;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            abjVar.m56d(str2);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m201a(Context context, String str, ace aceVar) {
        if (acb.m169c()) {
            Context contextM218g = m218g(context);
            if (contextM218g == null || str == null || str.length() == 0) {
                f264q.m56d("The Context or pageName of StatService.trackBeginPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (m222i(contextM218g) != null) {
                f251d.m68a(new abg(str2, contextM218g, aceVar));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static void m202a(Context context, Throwable th) {
        if (acb.m169c()) {
            Context contextM218g = m218g(context);
            if (contextM218g == null) {
                f264q.m56d("The Context of StatService.reportSdkSelfException() can not be null!");
            } else if (m222i(contextM218g) != null) {
                f251d.m68a(new abd(contextM218g, th));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static boolean m203a() {
        if (f248a < 2) {
            return false;
        }
        f249b = System.currentTimeMillis();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m204a(Context context, String str, String str2) {
        try {
            if (!acb.m169c()) {
                f264q.m56d("MTA StatService is disable.");
                return false;
            }
            if (acb.m166b()) {
                f264q.m59g("MTA SDK version, current: 2.0.3 ,required: " + str2);
            }
            if (context != null && str2 != null) {
                if (abt.m87b("2.0.3") >= abt.m87b(str2)) {
                    String strM163b = acb.m163b(context);
                    if (strM163b == null || strM163b.length() == 0) {
                        acb.m165b("-");
                    }
                    if (str != null) {
                        acb.m158a(context, str);
                    }
                    if (m222i(context) == null) {
                        return true;
                    }
                    f251d.m68a(new acl(context));
                    return true;
                }
                f264q.m56d(("MTA SDK version conflicted, current: 2.0.3,required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/");
                acb.m161a(false);
                return false;
            }
            f264q.m56d("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            acb.m161a(false);
            return false;
        } catch (Throwable th) {
            f264q.m54b(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    static void m206b() {
        f248a = 0;
        f249b = 0L;
    }

    /* JADX INFO: renamed from: b */
    public static void m207b(Context context) {
        if (acb.m169c() && m222i(context) != null) {
            f251d.m68a(new abc(context));
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m208b(Context context, String str, ace aceVar) {
        if (acb.m169c()) {
            Context contextM218g = m218g(context);
            if (contextM218g == null || str == null || str.length() == 0) {
                f264q.m56d("The Context or pageName of StatService.trackEndPage() can not be null or empty!");
                return;
            }
            String str2 = new String(str);
            if (m222i(contextM218g) != null) {
                f251d.m68a(new acj(contextM218g, str2, aceVar));
            }
        }
    }

    /* JADX INFO: renamed from: c */
    static void m210c() {
        f248a++;
        f249b = System.currentTimeMillis();
        m215e(f267t);
    }

    /* JADX INFO: renamed from: c */
    static void m211c(Context context) {
        if (acb.m169c()) {
            Context contextM218g = m218g(context);
            if (contextM218g == null) {
                f264q.m56d("The Context of StatService.sendNetworkDetector() can not be null!");
                return;
            }
            try {
                aay.m38b(contextM218g).m39a(new aak(contextM218g), new abe());
            } catch (Throwable th) {
                f264q.m54b(th);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m213d(Context context) {
        if (acb.m169c()) {
            if (acb.m166b()) {
                f264q.m51a("commitEvents, maxNumber=-1");
            }
            Context contextM218g = m218g(context);
            if (contextM218g == null) {
                f264q.m56d("The Context of StatService.commitEvents() can not be null!");
            } else if (acf.m234a(f267t).m244f() && m222i(contextM218g) != null) {
                f251d.m68a(new acg(contextM218g));
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public static void m215e(Context context) {
        if (acb.m169c() && acb.f226n > 0) {
            Context contextM218g = m218g(context);
            if (contextM218g == null) {
                f264q.m56d("The Context of StatService.testSpeed() can not be null!");
            } else {
                acs.m255a(contextM218g).m286c();
            }
        }
    }

    /* JADX INFO: renamed from: f */
    static void m217f(Context context) {
        f250c = System.currentTimeMillis() + ((long) (acb.m181l() * 60000));
        aby.m129a(context, "last_period_ts", f250c);
        m213d(context);
    }

    /* JADX INFO: renamed from: g */
    private static Context m218g(Context context) {
        return context != null ? context : f267t;
    }

    /* JADX INFO: renamed from: h */
    private static synchronized void m221h(Context context) {
        if (context == null) {
            return;
        }
        if (f251d == null) {
            long jM126a = aby.m126a(context, acb.f215c);
            long jM87b = abt.m87b("2.0.3");
            boolean z = true;
            if (jM87b <= jM126a) {
                f264q.m56d("MTA is disable for current version:" + jM87b + ",wakeup version:" + jM126a);
                z = false;
            }
            long jM126a2 = aby.m126a(context, acb.f216d);
            if (jM126a2 > System.currentTimeMillis()) {
                f264q.m56d("MTA is disable for current time:" + System.currentTimeMillis() + ",wakeup time:" + jM126a2);
                z = false;
            }
            acb.m161a(z);
            if (!z) {
                return;
            }
            Context applicationContext = context.getApplicationContext();
            f267t = applicationContext;
            f251d = new abn();
            f258k = abt.m94e();
            f255h = System.currentTimeMillis() + acb.f221i;
            f251d.m68a(new abb(applicationContext));
        }
    }

    /* JADX INFO: renamed from: i */
    private static abn m222i(Context context) {
        if (f251d == null) {
            synchronized (acd.class) {
                if (f251d == null) {
                    try {
                        m221h(context);
                    } catch (Throwable th) {
                        f264q.m52a(th);
                        acb.m161a(false);
                    }
                }
            }
        }
        return f251d;
    }

    /* JADX INFO: renamed from: l */
    private static JSONObject m226l() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (acb.f214b.f79d != 0) {
                jSONObject2.put("v", acb.f214b.f79d);
            }
            jSONObject.put(Integer.toString(acb.f214b.f76a), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            if (acb.f213a.f79d != 0) {
                jSONObject3.put("v", acb.f213a.f79d);
            }
            jSONObject.put(Integer.toString(acb.f213a.f76a), jSONObject3);
            return jSONObject;
        } catch (JSONException e) {
            f264q.m54b((Throwable) e);
            return jSONObject;
        }
    }
}
