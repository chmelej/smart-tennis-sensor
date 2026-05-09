package p000;

import android.content.Context;
import android.content.IntentFilter;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class acf {

    /* JADX INFO: renamed from: g */
    private static acf f273g;

    /* JADX INFO: renamed from: a */
    private List<String> f274a;

    /* JADX INFO: renamed from: e */
    private abn f278e;

    /* JADX INFO: renamed from: h */
    private Context f280h;

    /* JADX INFO: renamed from: i */
    private abj f281i;

    /* JADX INFO: renamed from: b */
    private volatile int f275b = 2;

    /* JADX INFO: renamed from: c */
    private volatile String f276c = "";

    /* JADX INFO: renamed from: d */
    private volatile HttpHost f277d = null;

    /* JADX INFO: renamed from: f */
    private int f279f = 0;

    private acf(Context context) {
        this.f274a = null;
        this.f278e = null;
        this.f280h = null;
        this.f281i = null;
        this.f280h = context.getApplicationContext();
        this.f278e = new abn();
        aay.m37a(context);
        this.f281i = abt.m89c();
        m237j();
        this.f274a = new ArrayList(10);
        this.f274a.add("117.135.169.101");
        this.f274a.add("140.207.54.125");
        this.f274a.add("180.153.8.53");
        this.f274a.add("120.198.203.175");
        this.f274a.add("14.17.43.18");
        this.f274a.add("163.177.71.186");
        this.f274a.add("111.30.131.31");
        this.f274a.add("123.126.121.167");
        this.f274a.add("123.151.152.111");
        this.f274a.add("113.142.45.79");
        this.f274a.add("123.138.162.90");
        this.f274a.add("103.7.30.94");
        m245g();
    }

    /* JADX INFO: renamed from: a */
    public static acf m234a(Context context) {
        if (f273g == null) {
            synchronized (acf.class) {
                if (f273g == null) {
                    f273g = new acf(context);
                }
            }
        }
        return f273g;
    }

    /* JADX INFO: renamed from: b */
    private static boolean m235b(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    /* JADX INFO: renamed from: i */
    private String m236i() {
        try {
            return !m235b("pingma.qq.com") ? InetAddress.getByName("pingma.qq.com").getHostAddress() : "";
        } catch (Exception e) {
            this.f281i.m54b((Throwable) e);
            return "";
        }
    }

    /* JADX INFO: renamed from: j */
    private void m237j() {
        this.f275b = 0;
        this.f277d = null;
        this.f276c = null;
    }

    /* JADX INFO: renamed from: a */
    public final HttpHost m238a() {
        return this.f277d;
    }

    /* JADX INFO: renamed from: a */
    public final void m239a(String str) {
        if (acb.m166b()) {
            this.f281i.m51a("updateIpList " + str);
        }
        try {
            if (abt.m91c(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> itKeys = jSONObject.keys();
                    while (itKeys.hasNext()) {
                        String string = jSONObject.getString(itKeys.next());
                        if (abt.m91c(string)) {
                            for (String str2 : string.split(";")) {
                                if (abt.m91c(str2)) {
                                    String[] strArrSplit = str2.split(":");
                                    if (strArrSplit.length > 1) {
                                        String str3 = strArrSplit[0];
                                        if (m235b(str3) && !this.f274a.contains(str3)) {
                                            if (acb.m166b()) {
                                                this.f281i.m51a("add new ip:" + str3);
                                            }
                                            this.f274a.add(str3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            this.f281i.m54b((Throwable) e);
        }
        this.f279f = new Random().nextInt(this.f274a.size());
    }

    /* JADX INFO: renamed from: b */
    public final String m240b() {
        return this.f276c;
    }

    /* JADX INFO: renamed from: c */
    public final int m241c() {
        return this.f275b;
    }

    /* JADX INFO: renamed from: d */
    public final void m242d() {
        this.f279f = (this.f279f + 1) % this.f274a.size();
    }

    /* JADX INFO: renamed from: e */
    public final boolean m243e() {
        return this.f275b == 1;
    }

    /* JADX INFO: renamed from: f */
    public final boolean m244f() {
        return this.f275b != 0;
    }

    /* JADX INFO: renamed from: g */
    final void m245g() {
        if (!abz.m140e(this.f280h)) {
            if (acb.m166b()) {
                this.f281i.m51a("NETWORK TYPE: network is close.");
            }
            m237j();
            return;
        }
        if (acb.f219g) {
            String strM236i = m236i();
            if (acb.m166b()) {
                this.f281i.m51a("remoteIp ip is " + strM236i);
            }
            if (abt.m91c(strM236i)) {
                if (!this.f274a.contains(strM236i)) {
                    String str = this.f274a.get(this.f279f);
                    if (acb.m166b()) {
                        this.f281i.m55c(strM236i + " not in ip list, change to:" + str);
                    }
                    strM236i = str;
                }
                acb.m168c("http://" + strM236i + ":80/mstat/report");
            }
        }
        this.f276c = abt.m106k(this.f280h);
        if (acb.m166b()) {
            this.f281i.m51a("NETWORK name:" + this.f276c);
        }
        if (abt.m91c(this.f276c)) {
            this.f275b = "WIFI".equalsIgnoreCase(this.f276c) ? 1 : 2;
            this.f277d = abt.m82a(this.f280h);
        }
        if (acd.m203a()) {
            acd.m211c(this.f280h);
        }
    }

    /* JADX INFO: renamed from: h */
    public final void m246h() {
        this.f280h.getApplicationContext().registerReceiver(new acy(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }
}
