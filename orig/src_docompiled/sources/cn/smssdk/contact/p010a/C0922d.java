package cn.smssdk.contact.p010a;

/* JADX INFO: renamed from: cn.smssdk.contact.a.d */
/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes.dex */
public class C0922d extends AbstractC0920b {
    /* JADX INFO: renamed from: a */
    protected int m6669a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 2;
            case 2:
                return 3;
            case 3:
                return 1;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6670b() {
        return m6663b("data1");
    }

    /* JADX INFO: renamed from: c */
    public int m6671c() {
        return m6669a(m6660a("data2", -1));
    }

    /* JADX INFO: renamed from: d */
    public String m6672d() {
        if (m6660a("data2", -1) == 0) {
            return m6663b("data3");
        }
        return null;
    }
}
