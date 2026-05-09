package cn.sharesdk.framework.p004b.p006b;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.d */
/* JADX INFO: compiled from: DemoEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C0838d extends AbstractC0837c {

    /* JADX INFO: renamed from: d */
    private static int f5604d;

    /* JADX INFO: renamed from: n */
    private static long f5605n;

    /* JADX INFO: renamed from: a */
    public String f5606a;

    /* JADX INFO: renamed from: b */
    public int f5607b;

    /* JADX INFO: renamed from: c */
    public String f5608c = "";

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected String mo6051a() {
        return "[EVT]";
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    protected int mo6053b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: c */
    protected int mo6054c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    public String toString() {
        return super.toString() + '|' + this.f5606a + '|' + this.f5607b + '|' + this.f5608c;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: d */
    protected long mo6055d() {
        return f5604d;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: e */
    protected long mo6056e() {
        return f5605n;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: f */
    protected void mo6057f() {
        f5604d++;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected void mo6052a(long j) {
        f5605n = j;
    }
}
