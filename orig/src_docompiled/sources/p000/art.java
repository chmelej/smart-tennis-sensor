package p000;

/* JADX INFO: compiled from: CodeSignatureImpl.java */
/* JADX INFO: loaded from: classes.dex */
abstract class art extends arw implements aro {

    /* JADX INFO: renamed from: a */
    Class[] f4861a;

    /* JADX INFO: renamed from: b */
    String[] f4862b;

    /* JADX INFO: renamed from: c */
    Class[] f4863c;

    art(int i, String str, Class cls, Class[] clsArr, String[] strArr, Class[] clsArr2) {
        super(i, str, cls);
        this.f4861a = clsArr;
        this.f4862b = strArr;
        this.f4863c = clsArr2;
    }

    /* JADX INFO: renamed from: a */
    public Class[] m5281a() {
        if (this.f4861a == null) {
            this.f4861a = m5301d(3);
        }
        return this.f4861a;
    }

    /* JADX INFO: renamed from: b */
    public Class[] m5282b() {
        if (this.f4863c == null) {
            this.f4863c = m5301d(5);
        }
        return this.f4863c;
    }
}
