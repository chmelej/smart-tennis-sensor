package p000;

import java.lang.ref.SoftReference;
import java.util.StringTokenizer;

/* JADX INFO: compiled from: SignatureImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class ary implements arn {

    /* JADX INFO: renamed from: a */
    private static boolean f4880a = true;

    /* JADX INFO: renamed from: k */
    static String[] f4881k = new String[0];

    /* JADX INFO: renamed from: l */
    static Class[] f4882l = new Class[0];

    /* JADX INFO: renamed from: b */
    private String f4883b;

    /* JADX INFO: renamed from: e */
    int f4884e;

    /* JADX INFO: renamed from: f */
    String f4885f;

    /* JADX INFO: renamed from: g */
    String f4886g;

    /* JADX INFO: renamed from: h */
    Class f4887h;

    /* JADX INFO: renamed from: i */
    InterfaceC0742a f4888i;

    /* JADX INFO: renamed from: j */
    ClassLoader f4889j = null;

    /* JADX INFO: renamed from: ary$a */
    /* JADX INFO: compiled from: SignatureImpl.java */
    interface InterfaceC0742a {
        /* JADX INFO: renamed from: a */
        String mo5305a(int i);

        /* JADX INFO: renamed from: a */
        void mo5306a(int i, String str);
    }

    /* JADX INFO: renamed from: a */
    protected abstract String mo5293a(asa asaVar);

    ary(int i, String str, Class cls) {
        this.f4884e = -1;
        this.f4884e = i;
        this.f4885f = str;
        this.f4887h = cls;
    }

    /* JADX INFO: renamed from: b */
    String m5298b(asa asaVar) {
        String strMo5293a;
        if (!f4880a) {
            strMo5293a = null;
        } else if (this.f4888i == null) {
            try {
                this.f4888i = new C0743b();
            } catch (Throwable unused) {
                f4880a = false;
            }
            strMo5293a = null;
        } else {
            strMo5293a = this.f4888i.mo5305a(asaVar.f4907i);
        }
        if (strMo5293a == null) {
            strMo5293a = mo5293a(asaVar);
        }
        if (f4880a) {
            this.f4888i.mo5306a(asaVar.f4907i, strMo5293a);
        }
        return strMo5293a;
    }

    public final String toString() {
        return m5298b(asa.f4897k);
    }

    /* JADX INFO: renamed from: d */
    public int m5300d() {
        if (this.f4884e == -1) {
            this.f4884e = m5297b(0);
        }
        return this.f4884e;
    }

    /* JADX INFO: renamed from: e */
    public String m5302e() {
        if (this.f4885f == null) {
            this.f4885f = m5296a(1);
        }
        return this.f4885f;
    }

    /* JADX INFO: renamed from: f */
    public Class m5303f() {
        if (this.f4887h == null) {
            this.f4887h = m5299c(2);
        }
        return this.f4887h;
    }

    /* JADX INFO: renamed from: g */
    public String m5304g() {
        if (this.f4886g == null) {
            this.f4886g = m5303f().getName();
        }
        return this.f4886g;
    }

    /* JADX INFO: renamed from: a */
    private ClassLoader m5295a() {
        if (this.f4889j == null) {
            this.f4889j = getClass().getClassLoader();
        }
        return this.f4889j;
    }

    /* JADX INFO: renamed from: a */
    String m5296a(int i) {
        int iIndexOf = this.f4883b.indexOf(45);
        int i2 = 0;
        while (true) {
            int i3 = i - 1;
            if (i <= 0) {
                break;
            }
            i2 = iIndexOf + 1;
            iIndexOf = this.f4883b.indexOf(45, i2);
            i = i3;
        }
        if (iIndexOf == -1) {
            iIndexOf = this.f4883b.length();
        }
        return this.f4883b.substring(i2, iIndexOf);
    }

    /* JADX INFO: renamed from: b */
    int m5297b(int i) {
        return Integer.parseInt(m5296a(i), 16);
    }

    /* JADX INFO: renamed from: c */
    Class m5299c(int i) {
        return aru.m5286a(m5296a(i), m5295a());
    }

    /* JADX INFO: renamed from: d */
    Class[] m5301d(int i) {
        StringTokenizer stringTokenizer = new StringTokenizer(m5296a(i), ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            clsArr[i2] = aru.m5286a(stringTokenizer.nextToken(), m5295a());
        }
        return clsArr;
    }

    /* JADX INFO: renamed from: ary$b */
    /* JADX INFO: compiled from: SignatureImpl.java */
    static final class C0743b implements InterfaceC0742a {

        /* JADX INFO: renamed from: a */
        private SoftReference f4890a;

        public C0743b() {
            m5308b();
        }

        @Override // p000.ary.InterfaceC0742a
        /* JADX INFO: renamed from: a */
        public String mo5305a(int i) {
            String[] strArrM5307a = m5307a();
            if (strArrM5307a == null) {
                return null;
            }
            return strArrM5307a[i];
        }

        @Override // p000.ary.InterfaceC0742a
        /* JADX INFO: renamed from: a */
        public void mo5306a(int i, String str) {
            String[] strArrM5307a = m5307a();
            if (strArrM5307a == null) {
                strArrM5307a = m5308b();
            }
            strArrM5307a[i] = str;
        }

        /* JADX INFO: renamed from: a */
        private String[] m5307a() {
            return (String[]) this.f4890a.get();
        }

        /* JADX INFO: renamed from: b */
        private String[] m5308b() {
            String[] strArr = new String[3];
            this.f4890a = new SoftReference(strArr);
            return strArr;
        }
    }
}
