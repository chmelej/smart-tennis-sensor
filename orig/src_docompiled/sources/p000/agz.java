package p000;

import android.support.v4.os.EnvironmentCompat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: AbstractIdTracker.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class agz {

    /* JADX INFO: renamed from: a */
    private final int f880a = 10;

    /* JADX INFO: renamed from: b */
    private final int f881b = 20;

    /* JADX INFO: renamed from: c */
    private final String f882c;

    /* JADX INFO: renamed from: d */
    private List<aek> f883d;

    /* JADX INFO: renamed from: e */
    private ael f884e;

    /* JADX INFO: renamed from: a */
    public abstract String mo342a();

    public agz(String str) {
        this.f882c = str;
    }

    /* JADX INFO: renamed from: e */
    public boolean m1009e() {
        return m1005b();
    }

    /* JADX INFO: renamed from: f */
    public String m1010f() {
        return this.f882c;
    }

    /* JADX INFO: renamed from: g */
    public boolean m1011g() {
        return this.f884e == null || this.f884e.m559d() <= 20;
    }

    /* JADX INFO: renamed from: b */
    private boolean m1005b() {
        ael aelVar = this.f884e;
        String strM553a = aelVar == null ? null : aelVar.m553a();
        int iM559d = aelVar == null ? 0 : aelVar.m559d();
        String strM1006a = m1006a(mo342a());
        if (strM1006a == null || strM1006a.equals(strM553a)) {
            return false;
        }
        if (aelVar == null) {
            aelVar = new ael();
        }
        aelVar.m552a(strM1006a);
        aelVar.m551a(System.currentTimeMillis());
        aelVar.m550a(iM559d + 1);
        aek aekVar = new aek();
        aekVar.m524a(this.f882c);
        aekVar.m532c(strM1006a);
        aekVar.m528b(strM553a);
        aekVar.m523a(aelVar.m555b());
        if (this.f883d == null) {
            this.f883d = new ArrayList(2);
        }
        this.f883d.add(aekVar);
        if (this.f883d.size() > 10) {
            this.f883d.remove(0);
        }
        this.f884e = aelVar;
        return true;
    }

    /* JADX INFO: renamed from: h */
    public ael m1012h() {
        return this.f884e;
    }

    /* JADX INFO: renamed from: i */
    public List<aek> m1013i() {
        return this.f883d;
    }

    /* JADX INFO: renamed from: a */
    public void m1008a(List<aek> list) {
        this.f883d = list;
    }

    /* JADX INFO: renamed from: a */
    public String m1006a(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0 || "0".equals(strTrim) || EnvironmentCompat.MEDIA_UNKNOWN.equals(strTrim.toLowerCase(Locale.US))) {
            return null;
        }
        return strTrim;
    }

    /* JADX INFO: renamed from: a */
    public void m1007a(aem aemVar) {
        this.f884e = aemVar.m575a().get(this.f882c);
        List<aek> listM577b = aemVar.m577b();
        if (listM577b == null || listM577b.size() <= 0) {
            return;
        }
        if (this.f883d == null) {
            this.f883d = new ArrayList();
        }
        for (aek aekVar : listM577b) {
            if (this.f882c.equals(aekVar.f562a)) {
                this.f883d.add(aekVar);
            }
        }
    }
}
