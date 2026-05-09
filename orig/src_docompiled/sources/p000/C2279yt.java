package p000;

import android.content.Context;
import android.provider.Settings;
import com.umeng.message.MsgConstant;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Pattern;
import java.util.zip.Adler32;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: yt */
/* JADX INFO: compiled from: UTUtdid.java */
/* JADX INFO: loaded from: classes.dex */
public class C2279yt {

    /* JADX INFO: renamed from: c */
    private static C2279yt f13756c;

    /* JADX INFO: renamed from: a */
    private Context f13758a;

    /* JADX INFO: renamed from: e */
    private C2280yu f13760e;

    /* JADX INFO: renamed from: f */
    private String f13761f;

    /* JADX INFO: renamed from: g */
    private String f13762g;

    /* JADX INFO: renamed from: h */
    private C2272ym f13763h;

    /* JADX INFO: renamed from: i */
    private C2272ym f13764i;

    /* JADX INFO: renamed from: b */
    private static final Object f13755b = new Object();

    /* JADX INFO: renamed from: j */
    private static final String f13757j = ".UTSystemConfig" + File.separator + "Global";

    /* JADX INFO: renamed from: d */
    private String f13759d = null;

    /* JADX INFO: renamed from: k */
    private Pattern f13765k = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public C2279yt(Context context) {
        this.f13758a = null;
        this.f13760e = null;
        this.f13761f = "xx_utdid_key";
        this.f13762g = "xx_utdid_domain";
        this.f13763h = null;
        this.f13764i = null;
        this.f13758a = context;
        this.f13764i = new C2272ym(context, f13757j, "Alvin2", false, true);
        this.f13763h = new C2272ym(context, ".DataStorage", "ContextData", false, true);
        this.f13760e = new C2280yu();
        this.f13761f = String.format("K_%d", Integer.valueOf(C2270yk.m12427b(this.f13761f)));
        this.f13762g = String.format("D_%d", Integer.valueOf(C2270yk.m12427b(this.f13762g)));
    }

    /* JADX INFO: renamed from: a */
    public static C2279yt m12502a(Context context) {
        if (context != null && f13756c == null) {
            synchronized (f13755b) {
                if (f13756c == null) {
                    f13756c = new C2279yt(context);
                }
            }
        }
        return f13756c;
    }

    /* JADX INFO: renamed from: a */
    static long m12500a(C2276yq c2276yq) {
        if (c2276yq == null) {
            return 0L;
        }
        String str = String.format("%s%s%s%s%s", c2276yq.m12495e(), c2276yq.m12493d(), Long.valueOf(c2276yq.m12485a()), c2276yq.m12491c(), c2276yq.m12488b());
        if (C2270yk.m12426a(str)) {
            return 0L;
        }
        Adler32 adler32 = new Adler32();
        adler32.reset();
        adler32.update(str.getBytes());
        return adler32.getValue();
    }

    /* JADX INFO: renamed from: a */
    private void m12503a(String str) {
        if (m12510f(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || this.f13764i == null) {
                return;
            }
            String strM12447a = this.f13764i.m12447a("UTDID");
            String strM12447a2 = this.f13764i.m12447a("EI");
            if (C2270yk.m12426a(strM12447a2)) {
                strM12447a2 = C2269yj.m12424a(this.f13758a);
            }
            String strM12447a3 = this.f13764i.m12447a("SI");
            if (C2270yk.m12426a(strM12447a3)) {
                strM12447a3 = C2269yj.m12425b(this.f13758a);
            }
            String strM12447a4 = this.f13764i.m12447a("DID");
            if (C2270yk.m12426a(strM12447a4)) {
                strM12447a4 = strM12447a2;
            }
            if (strM12447a == null || !strM12447a.equals(str)) {
                C2276yq c2276yq = new C2276yq();
                c2276yq.m12487a(strM12447a2);
                c2276yq.m12490b(strM12447a3);
                c2276yq.m12494d(str);
                c2276yq.m12492c(strM12447a4);
                c2276yq.m12489b(System.currentTimeMillis());
                this.f13764i.m12449a("UTDID", str);
                this.f13764i.m12449a("EI", c2276yq.m12488b());
                this.f13764i.m12449a("SI", c2276yq.m12491c());
                this.f13764i.m12449a("DID", c2276yq.m12493d());
                this.f13764i.m12448a("timestamp", c2276yq.m12485a());
                this.f13764i.m12448a("S", m12500a(c2276yq));
                this.f13764i.m12450a();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m12505b(String str) {
        if (str == null || this.f13763h == null || str.equals(this.f13763h.m12447a(this.f13761f))) {
            return;
        }
        this.f13763h.m12449a(this.f13761f, str);
        this.f13763h.m12450a();
    }

    /* JADX INFO: renamed from: c */
    private void m12506c(String str) {
        if (this.f13758a.checkCallingOrSelfPermission(MsgConstant.PERMISSION_WRITE_SETTINGS) == 0 && m12510f(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 != str.length() || m12510f(Settings.System.getString(this.f13758a.getContentResolver(), "mqBRboGZkQPcAkyk"))) {
                return;
            }
            Settings.System.putString(this.f13758a.getContentResolver(), "mqBRboGZkQPcAkyk", str);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m12508d(String str) {
        if (str.equals(Settings.System.getString(this.f13758a.getContentResolver(), "dxCRMxhQkdGePGnp"))) {
            return;
        }
        Settings.System.putString(this.f13758a.getContentResolver(), "dxCRMxhQkdGePGnp", str);
    }

    /* JADX INFO: renamed from: e */
    private void m12509e(String str) {
        if (this.f13758a.checkCallingOrSelfPermission(MsgConstant.PERMISSION_WRITE_SETTINGS) != 0 || str == null) {
            return;
        }
        m12508d(str);
    }

    /* JADX INFO: renamed from: b */
    private String m12504b() {
        if (this.f13764i == null) {
            return null;
        }
        String strM12447a = this.f13764i.m12447a("UTDID");
        if (C2270yk.m12426a(strM12447a) || this.f13760e.m12512a(strM12447a) == null) {
            return null;
        }
        return strM12447a;
    }

    /* JADX INFO: renamed from: f */
    private boolean m12510f(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.f13765k.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public synchronized String m12511a() {
        if (this.f13759d != null) {
            return this.f13759d;
        }
        String string = Settings.System.getString(this.f13758a.getContentResolver(), "mqBRboGZkQPcAkyk");
        if (m12510f(string)) {
            return string;
        }
        C2281yv c2281yv = new C2281yv();
        boolean z = false;
        String string2 = Settings.System.getString(this.f13758a.getContentResolver(), "dxCRMxhQkdGePGnp");
        if (C2270yk.m12426a(string2)) {
            z = true;
        } else {
            String strM12516b = c2281yv.m12516b(string2);
            if (m12510f(strM12516b)) {
                m12506c(strM12516b);
                return strM12516b;
            }
            String strM12515a = c2281yv.m12515a(string2);
            if (m12510f(strM12515a)) {
                String strM12512a = this.f13760e.m12512a(strM12515a);
                if (!C2270yk.m12426a(strM12512a)) {
                    m12509e(strM12512a);
                    string2 = Settings.System.getString(this.f13758a.getContentResolver(), "dxCRMxhQkdGePGnp");
                }
            }
            String strM12514b = this.f13760e.m12514b(string2);
            if (m12510f(strM12514b)) {
                this.f13759d = strM12514b;
                m12503a(strM12514b);
                m12505b(string2);
                m12506c(this.f13759d);
                return this.f13759d;
            }
        }
        String strM12504b = m12504b();
        if (m12510f(strM12504b)) {
            String strM12512a2 = this.f13760e.m12512a(strM12504b);
            if (z) {
                m12509e(strM12512a2);
            }
            m12506c(strM12504b);
            m12505b(strM12512a2);
            this.f13759d = strM12504b;
            return strM12504b;
        }
        String strM12447a = this.f13763h.m12447a(this.f13761f);
        if (!C2270yk.m12426a(strM12447a)) {
            String strM12515a2 = c2281yv.m12515a(strM12447a);
            if (!m12510f(strM12515a2)) {
                strM12515a2 = this.f13760e.m12514b(strM12447a);
            }
            if (m12510f(strM12515a2)) {
                String strM12512a3 = this.f13760e.m12512a(strM12515a2);
                if (!C2270yk.m12426a(strM12515a2)) {
                    this.f13759d = strM12515a2;
                    if (z) {
                        m12509e(strM12512a3);
                    }
                    m12503a(this.f13759d);
                    return this.f13759d;
                }
            }
        }
        try {
            byte[] bArrM12507c = m12507c();
            if (bArrM12507c != null) {
                this.f13759d = C2267yh.m12417b(bArrM12507c, 2);
                m12503a(this.f13759d);
                String strM12513a = this.f13760e.m12513a(bArrM12507c);
                if (strM12513a != null) {
                    if (z) {
                        m12509e(strM12513a);
                    }
                    m12505b(strM12513a);
                }
                return this.f13759d;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private final byte[] m12507c() {
        String strM12424a;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrM12422a = C2268yi.m12422a(iCurrentTimeMillis);
        byte[] bArrM12422a2 = C2268yi.m12422a(iNextInt);
        byteArrayOutputStream.write(bArrM12422a, 0, 4);
        byteArrayOutputStream.write(bArrM12422a2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        try {
            strM12424a = C2269yj.m12424a(this.f13758a);
        } catch (Exception unused) {
            strM12424a = "" + new Random().nextInt();
        }
        byteArrayOutputStream.write(C2268yi.m12422a(C2270yk.m12427b(strM12424a)), 0, 4);
        byteArrayOutputStream.write(C2268yi.m12422a(C2270yk.m12427b(m12501a(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX INFO: renamed from: a */
    private static String m12501a(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return C2267yh.m12417b(mac.doFinal(bArr), 2);
    }
}
