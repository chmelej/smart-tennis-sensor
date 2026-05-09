package p000;

import java.util.Hashtable;
import java.util.StringTokenizer;
import p000.ark;
import p000.arv;

/* JADX INFO: compiled from: Factory.java */
/* JADX INFO: loaded from: classes.dex */
public final class aru {

    /* JADX INFO: renamed from: e */
    static Hashtable f4864e = new Hashtable();

    /* JADX INFO: renamed from: f */
    static Class f4865f;

    /* JADX INFO: renamed from: g */
    private static Object[] f4866g;

    /* JADX INFO: renamed from: a */
    Class f4867a;

    /* JADX INFO: renamed from: b */
    ClassLoader f4868b;

    /* JADX INFO: renamed from: c */
    String f4869c;

    /* JADX INFO: renamed from: d */
    int f4870d = 0;

    static {
        f4864e.put("void", Void.TYPE);
        f4864e.put("boolean", Boolean.TYPE);
        f4864e.put("byte", Byte.TYPE);
        f4864e.put("char", Character.TYPE);
        f4864e.put("short", Short.TYPE);
        f4864e.put("int", Integer.TYPE);
        f4864e.put("long", Long.TYPE);
        f4864e.put("float", Float.TYPE);
        f4864e.put("double", Double.TYPE);
        f4866g = new Object[0];
    }

    /* JADX INFO: renamed from: a */
    static Class m5286a(String str, ClassLoader classLoader) {
        if (str.equals("*")) {
            return null;
        }
        Class cls = (Class) f4864e.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            if (classLoader == null) {
                return Class.forName(str);
            }
            return Class.forName(str, false, classLoader);
        } catch (ClassNotFoundException unused) {
            if (f4865f != null) {
                return f4865f;
            }
            Class clsM5285a = m5285a("java.lang.ClassNotFoundException");
            f4865f = clsM5285a;
            return clsM5285a;
        }
    }

    /* JADX INFO: renamed from: a */
    static Class m5285a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public aru(String str, Class cls) {
        this.f4869c = str;
        this.f4867a = cls;
        this.f4868b = cls.getClassLoader();
    }

    /* JADX INFO: renamed from: a */
    public ark.InterfaceC0740a m5287a(String str, arn arnVar, int i) {
        int i2 = this.f4870d;
        this.f4870d = i2 + 1;
        return new arv.C0741a(i2, str, arnVar, m5289a(i, -1));
    }

    /* JADX INFO: renamed from: a */
    public static ark m5283a(ark.InterfaceC0740a interfaceC0740a, Object obj, Object obj2) {
        return new arv(interfaceC0740a, obj, obj2, f4866g);
    }

    /* JADX INFO: renamed from: a */
    public static ark m5284a(ark.InterfaceC0740a interfaceC0740a, Object obj, Object obj2, Object obj3) {
        return new arv(interfaceC0740a, obj, obj2, new Object[]{obj3});
    }

    /* JADX INFO: renamed from: a */
    public arq m5288a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int i = Integer.parseInt(str, 16);
        Class clsM5286a = m5286a(str3, this.f4868b);
        StringTokenizer stringTokenizer = new StringTokenizer(str4, ":");
        int iCountTokens = stringTokenizer.countTokens();
        Class[] clsArr = new Class[iCountTokens];
        for (int i2 = 0; i2 < iCountTokens; i2++) {
            clsArr[i2] = m5286a(stringTokenizer.nextToken(), this.f4868b);
        }
        StringTokenizer stringTokenizer2 = new StringTokenizer(str5, ":");
        int iCountTokens2 = stringTokenizer2.countTokens();
        String[] strArr = new String[iCountTokens2];
        for (int i3 = 0; i3 < iCountTokens2; i3++) {
            strArr[i3] = stringTokenizer2.nextToken();
        }
        StringTokenizer stringTokenizer3 = new StringTokenizer(str6, ":");
        int iCountTokens3 = stringTokenizer3.countTokens();
        Class[] clsArr2 = new Class[iCountTokens3];
        for (int i4 = 0; i4 < iCountTokens3; i4++) {
            clsArr2[i4] = m5286a(stringTokenizer3.nextToken(), this.f4868b);
        }
        return new arx(i, str2, clsM5286a, clsArr, strArr, clsArr2, m5286a(str7, this.f4868b));
    }

    /* JADX INFO: renamed from: a */
    public arr m5289a(int i, int i2) {
        return new arz(this.f4867a, this.f4869c, i);
    }
}
