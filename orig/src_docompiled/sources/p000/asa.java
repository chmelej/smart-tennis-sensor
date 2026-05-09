package p000;

import java.lang.reflect.Modifier;

/* JADX INFO: compiled from: StringMaker.java */
/* JADX INFO: loaded from: classes.dex */
class asa {

    /* JADX INFO: renamed from: j */
    static asa f4896j = new asa();

    /* JADX INFO: renamed from: k */
    static asa f4897k;

    /* JADX INFO: renamed from: l */
    static asa f4898l;

    /* JADX INFO: renamed from: a */
    boolean f4899a = true;

    /* JADX INFO: renamed from: b */
    boolean f4900b = true;

    /* JADX INFO: renamed from: c */
    boolean f4901c = false;

    /* JADX INFO: renamed from: d */
    boolean f4902d = false;

    /* JADX INFO: renamed from: e */
    boolean f4903e = false;

    /* JADX INFO: renamed from: f */
    boolean f4904f = true;

    /* JADX INFO: renamed from: g */
    boolean f4905g = true;

    /* JADX INFO: renamed from: h */
    boolean f4906h = true;

    /* JADX INFO: renamed from: i */
    int f4907i;

    asa() {
    }

    static {
        f4896j.f4899a = true;
        f4896j.f4900b = false;
        f4896j.f4901c = false;
        f4896j.f4902d = false;
        f4896j.f4903e = true;
        f4896j.f4904f = false;
        f4896j.f4905g = false;
        f4896j.f4907i = 0;
        f4897k = new asa();
        f4897k.f4899a = true;
        f4897k.f4900b = true;
        f4897k.f4901c = false;
        f4897k.f4902d = false;
        f4897k.f4903e = false;
        f4896j.f4907i = 1;
        f4898l = new asa();
        f4898l.f4899a = false;
        f4898l.f4900b = true;
        f4898l.f4901c = false;
        f4898l.f4902d = true;
        f4898l.f4903e = false;
        f4898l.f4906h = false;
        f4898l.f4907i = 2;
    }

    /* JADX INFO: renamed from: a */
    String m5316a(String str) {
        int iLastIndexOf = str.lastIndexOf(45);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    /* JADX INFO: renamed from: a */
    String m5312a(int i) {
        if (!this.f4902d) {
            return "";
        }
        String string = Modifier.toString(i);
        if (string.length() == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(string);
        stringBuffer.append(" ");
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    String m5318b(String str) {
        int iLastIndexOf = str.lastIndexOf(46);
        return iLastIndexOf == -1 ? str : str.substring(iLastIndexOf + 1);
    }

    /* JADX INFO: renamed from: a */
    String m5315a(Class cls, String str, boolean z) {
        if (cls == null) {
            return "ANONYMOUS";
        }
        if (!cls.isArray()) {
            if (z) {
                return m5318b(str).replace('$', '.');
            }
            return str.replace('$', '.');
        }
        Class<?> componentType = cls.getComponentType();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(m5315a(componentType, componentType.getName(), z));
        stringBuffer.append("[]");
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public String m5313a(Class cls) {
        return m5315a(cls, cls.getName(), this.f4899a);
    }

    /* JADX INFO: renamed from: a */
    public String m5314a(Class cls, String str) {
        return m5315a(cls, str, this.f4903e);
    }

    /* JADX INFO: renamed from: a */
    public void m5317a(StringBuffer stringBuffer, Class[] clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(m5313a(clsArr[i]));
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5319b(StringBuffer stringBuffer, Class[] clsArr) {
        if (clsArr == null) {
            return;
        }
        if (!this.f4900b) {
            if (clsArr.length == 0) {
                stringBuffer.append("()");
                return;
            } else {
                stringBuffer.append("(..)");
                return;
            }
        }
        stringBuffer.append("(");
        m5317a(stringBuffer, clsArr);
        stringBuffer.append(")");
    }

    /* JADX INFO: renamed from: c */
    public void m5320c(StringBuffer stringBuffer, Class[] clsArr) {
        if (!this.f4901c || clsArr == null || clsArr.length == 0) {
            return;
        }
        stringBuffer.append(" throws ");
        m5317a(stringBuffer, clsArr);
    }
}
