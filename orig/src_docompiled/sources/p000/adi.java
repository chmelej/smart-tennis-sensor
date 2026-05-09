package p000;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: IdTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adi {

    /* JADX INFO: renamed from: a */
    public static adi f404a;

    /* JADX INFO: renamed from: c */
    private File f406c;

    /* JADX INFO: renamed from: e */
    private long f408e;

    /* JADX INFO: renamed from: h */
    private C0012a f411h;

    /* JADX INFO: renamed from: b */
    private final String f405b = "umeng_it.cache";

    /* JADX INFO: renamed from: d */
    private aem f407d = null;

    /* JADX INFO: renamed from: g */
    private Set<agz> f410g = new HashSet();

    /* JADX INFO: renamed from: f */
    private long f409f = 86400000;

    adi(Context context) {
        this.f411h = null;
        this.f406c = new File(context.getFilesDir(), "umeng_it.cache");
        this.f411h = new C0012a(context);
        this.f411h.m355b();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized adi m343a(Context context) {
        if (f404a == null) {
            f404a = new adi(context);
            f404a.m348a(new adj(context));
            f404a.m348a(new aha(context));
            f404a.m348a(new adp(context));
            f404a.m348a(new adh(context));
            f404a.m348a(new adg(context));
            f404a.m348a(new adl(context));
            f404a.m348a(new ado());
            f404a.m348a(new adq(context));
            adn adnVar = new adn(context);
            if (adnVar.m390b()) {
                f404a.m348a(adnVar);
                f404a.m348a(new adm(context));
                adnVar.m392d();
            }
            f404a.m351d();
        }
        return f404a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m348a(agz agzVar) {
        if (this.f411h.m354a(agzVar.m1010f())) {
            return this.f410g.add(agzVar);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m347a() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - this.f408e >= this.f409f) {
            boolean z = false;
            for (agz agzVar : this.f410g) {
                if (agzVar.m1011g() && agzVar.m1009e()) {
                    z = true;
                    if (!agzVar.m1011g()) {
                        this.f411h.m356b(agzVar.m1010f());
                    }
                }
            }
            if (z) {
                m345f();
                this.f411h.m353a();
                m352e();
            }
            this.f408e = jCurrentTimeMillis;
        }
    }

    /* JADX INFO: renamed from: b */
    public aem m349b() {
        return this.f407d;
    }

    /* JADX INFO: renamed from: f */
    private void m345f() {
        aem aemVar = new aem();
        HashMap map = new HashMap();
        ArrayList arrayList = new ArrayList();
        for (agz agzVar : this.f410g) {
            if (agzVar.m1011g()) {
                if (agzVar.m1012h() != null) {
                    map.put(agzVar.m1010f(), agzVar.m1012h());
                }
                if (agzVar.m1013i() != null && !agzVar.m1013i().isEmpty()) {
                    arrayList.addAll(agzVar.m1013i());
                }
            }
        }
        aemVar.m573a(arrayList);
        aemVar.m574a(map);
        synchronized (this) {
            this.f407d = aemVar;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m350c() {
        boolean z = false;
        for (agz agzVar : this.f410g) {
            if (agzVar.m1011g() && agzVar.m1013i() != null && !agzVar.m1013i().isEmpty()) {
                agzVar.m1008a((List<aek>) null);
                z = true;
            }
        }
        if (z) {
            this.f407d.m578b(false);
            m352e();
        }
    }

    /* JADX INFO: renamed from: d */
    public void m351d() throws Throwable {
        aem aemVarM346g = m346g();
        if (aemVarM346g == null) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.f410g.size());
        synchronized (this) {
            this.f407d = aemVarM346g;
            for (agz agzVar : this.f410g) {
                agzVar.m1007a(this.f407d);
                if (!agzVar.m1011g()) {
                    arrayList.add(agzVar);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f410g.remove((agz) it.next());
            }
        }
        m345f();
    }

    /* JADX INFO: renamed from: e */
    public void m352e() {
        if (this.f407d != null) {
            m344a(this.f407d);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX INFO: renamed from: g */
    private aem m346g() throws Throwable {
        FileInputStream fileInputStream;
        ?? Exists = this.f406c.exists();
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                fileInputStream = new FileInputStream(this.f406c);
                try {
                    byte[] bArrM763b = aev.m763b(fileInputStream);
                    aem aemVar = new aem();
                    new afh().m841a(aemVar, bArrM763b);
                    aev.m764c(fileInputStream);
                    return aemVar;
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    aev.m764c(fileInputStream);
                    return null;
                }
            } catch (Exception e2) {
                e = e2;
                fileInputStream = null;
            } catch (Throwable th) {
                th = th;
                Exists = 0;
                aev.m764c(Exists);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m344a(aem aemVar) {
        byte[] bArrM842a;
        if (aemVar != null) {
            try {
                synchronized (this) {
                    bArrM842a = new afj().m842a(aemVar);
                }
                if (bArrM842a != null) {
                    aev.m760a(this.f406c, bArrM842a);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: adi$a */
    /* JADX INFO: compiled from: IdTracker.java */
    public static class C0012a {

        /* JADX INFO: renamed from: a */
        private Context f412a;

        /* JADX INFO: renamed from: b */
        private Set<String> f413b = new HashSet();

        public C0012a(Context context) {
            this.f412a = context;
        }

        /* JADX INFO: renamed from: a */
        public boolean m354a(String str) {
            return !this.f413b.contains(str);
        }

        /* JADX INFO: renamed from: b */
        public void m356b(String str) {
            this.f413b.add(str);
        }

        /* JADX INFO: renamed from: a */
        public void m353a() {
            if (this.f413b.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            Iterator<String> it = this.f413b.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
                sb.append(',');
            }
            sb.deleteCharAt(sb.length() - 1);
            aeb.m454a(this.f412a).edit().putString("invld_id", sb.toString()).commit();
        }

        /* JADX INFO: renamed from: b */
        public void m355b() {
            String[] strArrSplit;
            String string = aeb.m454a(this.f412a).getString("invld_id", null);
            if (TextUtils.isEmpty(string) || (strArrSplit = string.split(",")) == null) {
                return;
            }
            for (String str : strArrSplit) {
                if (!TextUtils.isEmpty(str)) {
                    this.f413b.add(str);
                }
            }
        }
    }
}
