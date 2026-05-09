package p000;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;

/* JADX INFO: compiled from: OldUMIDTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adn extends agz {

    /* JADX INFO: renamed from: a */
    private Context f438a;

    /* JADX INFO: renamed from: b */
    private String f439b;

    /* JADX INFO: renamed from: c */
    private String f440c;

    public adn(Context context) {
        super("oldumid");
        this.f439b = null;
        this.f440c = null;
        this.f438a = context;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        return this.f439b;
    }

    /* JADX INFO: renamed from: b */
    public boolean m390b() {
        return m391c();
    }

    /* JADX INFO: renamed from: c */
    public boolean m391c() throws Throwable {
        this.f440c = adk.m357a(this.f438a).m366b().m385e(null);
        if (TextUtils.isEmpty(this.f440c)) {
            return false;
        }
        this.f440c = aes.m712c(this.f440c);
        String strM755a = aev.m755a(new File("/sdcard/Android/data/.um/sysid.dat"));
        String strM755a2 = aev.m755a(new File("/sdcard/Android/obj/.um/sysid.dat"));
        String strM755a3 = aev.m755a(new File("/data/local/tmp/.um/sysid.dat"));
        if (TextUtils.isEmpty(strM755a)) {
            m389l();
        } else if (!this.f440c.equals(strM755a)) {
            this.f439b = strM755a;
            return true;
        }
        if (TextUtils.isEmpty(strM755a2)) {
            m388k();
        } else if (!this.f440c.equals(strM755a2)) {
            this.f439b = strM755a2;
            return true;
        }
        if (TextUtils.isEmpty(strM755a3)) {
            m387j();
            return false;
        }
        if (this.f440c.equals(strM755a3)) {
            return false;
        }
        this.f439b = strM755a3;
        return true;
    }

    /* JADX INFO: renamed from: d */
    public void m392d() {
        try {
            m389l();
            m388k();
            m387j();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: j */
    private void m387j() {
        try {
            m386b("/data/local/tmp/.um");
            aev.m759a(new File("/data/local/tmp/.um/sysid.dat"), this.f440c);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: k */
    private void m388k() {
        try {
            m386b("/sdcard/Android/obj/.um");
            aev.m759a(new File("/sdcard/Android/obj/.um/sysid.dat"), this.f440c);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: l */
    private void m389l() {
        try {
            m386b("/sdcard/Android/data/.um");
            aev.m759a(new File("/sdcard/Android/data/.um/sysid.dat"), this.f440c);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private void m386b(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }
}
