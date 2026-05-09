package cn.smssdk.contact.p010a;

/* JADX INFO: renamed from: cn.smssdk.contact.a.c */
/* JADX INFO: compiled from: Email.java */
/* JADX INFO: loaded from: classes.dex */
public class C0921c extends AbstractC0920b {
    /* JADX INFO: renamed from: a */
    protected int m6665a(int i) {
        switch (i) {
            case 0:
                return 0;
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 5;
            case 4:
                return 4;
            default:
                return -1;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6666b() {
        return m6663b("data1");
    }

    /* JADX INFO: renamed from: c */
    public int m6667c() {
        return m6665a(m6660a("data2", -1));
    }

    /* JADX INFO: renamed from: d */
    public String m6668d() {
        if (m6660a("data2", -1) == 0) {
            return m6663b("data3");
        }
        return null;
    }
}
