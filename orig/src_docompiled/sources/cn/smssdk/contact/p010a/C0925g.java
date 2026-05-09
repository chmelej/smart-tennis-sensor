package cn.smssdk.contact.p010a;

/* JADX INFO: renamed from: cn.smssdk.contact.a.g */
/* JADX INFO: compiled from: Im.java */
/* JADX INFO: loaded from: classes.dex */
public class C0925g extends AbstractC0920b {
    /* JADX INFO: renamed from: a */
    protected int m6674a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            case 8:
                return 8;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6675b() {
        return m6663b("data1");
    }

    /* JADX INFO: renamed from: c */
    public int m6676c() {
        return m6674a(m6660a("data5", -1));
    }

    /* JADX INFO: renamed from: d */
    public String m6677d() {
        if (m6660a("data5", -1) == -1) {
            return m6663b("data3");
        }
        return null;
    }
}
