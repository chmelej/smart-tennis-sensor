package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Base64;
import com.umeng.message.MsgConstant;
import java.io.IOException;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.android.spdy.SpdyRequest;

/* JADX INFO: renamed from: vk */
/* JADX INFO: compiled from: ZeusManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C2189vk {

    /* JADX INFO: renamed from: d */
    private static boolean f13133d = true;

    /* JADX INFO: renamed from: a */
    private Context f13134a;

    /* JADX INFO: renamed from: b */
    private b f13135b = b.UnCheck;

    /* JADX INFO: renamed from: c */
    private long f13136c = 0;

    /* JADX INFO: renamed from: e */
    private Runnable f13137e = new Runnable() { // from class: vk.1
        @Override // java.lang.Runnable
        public void run() {
            C2189vk.this.m11984d();
        }
    };

    /* JADX INFO: renamed from: vk$a */
    /* JADX INFO: compiled from: ZeusManager.java */
    static class a {

        /* JADX INFO: renamed from: a */
        public static final C2189vk f13139a = new C2189vk();
    }

    /* JADX INFO: renamed from: vk$b */
    /* JADX INFO: compiled from: ZeusManager.java */
    enum b {
        UnCheck,
        Authorized,
        UnAuthorized
    }

    /* JADX INFO: renamed from: a */
    public static C2189vk m11979a() {
        return a.f13139a;
    }

    /* JADX INFO: renamed from: a */
    public void m11985a(Context context) {
        if (this.f13134a != null || context == null) {
            return;
        }
        this.f13134a = context.getApplicationContext();
        String string = this.f13134a.getSharedPreferences("ShortVideo", 0).getString(MsgConstant.KEY_TS, "");
        if (!"".equals(string)) {
            this.f13136c = Long.valueOf(new String(Base64.decode(string, 0))).longValue();
        }
        for (String str : C2182vd.f13037a) {
            if (m11979a().m11982b(context).contains(str)) {
                m11979a().m11981a(false);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m11986b() {
        if (!f13133d) {
            this.f13135b = b.Authorized;
            return true;
        }
        m11983c();
        return this.f13135b != b.UnAuthorized;
    }

    /* JADX INFO: renamed from: c */
    private void m11983c() {
        if (this.f13134a == null) {
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f13136c;
        if (jCurrentTimeMillis < 0 || jCurrentTimeMillis >= 3600000) {
            this.f13136c = System.currentTimeMillis();
            if (this.f13134a != null) {
                SharedPreferences.Editor editorEdit = this.f13134a.getSharedPreferences("ShortVideo", 0).edit();
                editorEdit.putString(MsgConstant.KEY_TS, Base64.encodeToString(String.valueOf(this.f13136c).getBytes(), 0));
                editorEdit.apply();
            }
            new Thread(this.f13137e).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m11984d() {
        String strM11982b = m11982b(this.f13134a);
        if ("".equals(strM11982b)) {
            return;
        }
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://shortvideo.qiniuapi.com/v1/zeus?appid=" + strM11982b).openConnection();
            httpsURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            int responseCode = httpsURLConnection.getResponseCode();
            if (responseCode == 200) {
                this.f13135b = b.Authorized;
            } else if (responseCode == 401) {
                this.f13135b = b.UnAuthorized;
            } else {
                this.f13135b = b.UnCheck;
            }
        } catch (IOException unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private String m11982b(Context context) {
        return context != null ? C2204vz.m12079g(context) : "";
    }

    /* JADX INFO: renamed from: a */
    private void m11981a(boolean z) {
        f13133d = z;
    }
}
