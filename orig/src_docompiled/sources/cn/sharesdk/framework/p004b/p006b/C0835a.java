package cn.sharesdk.framework.p004b.p006b;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.a */
/* JADX INFO: compiled from: ApiEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C0835a extends AbstractC0837c {

    /* JADX INFO: renamed from: c */
    private static int f5585c;

    /* JADX INFO: renamed from: d */
    private static long f5586d;

    /* JADX INFO: renamed from: a */
    public int f5587a;

    /* JADX INFO: renamed from: b */
    public String f5588b;

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected String mo6051a() {
        return "[API]";
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    protected int mo6053b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: c */
    protected int mo6054c() {
        return 50;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    public String toString() {
        return super.toString() + '|' + this.f5587a + '|' + this.f5588b;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: d */
    protected long mo6055d() {
        return f5585c;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: e */
    protected long mo6056e() {
        return f5586d;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: f */
    protected void mo6057f() {
        f5585c++;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected void mo6052a(long j) {
        f5586d = j;
    }
}
