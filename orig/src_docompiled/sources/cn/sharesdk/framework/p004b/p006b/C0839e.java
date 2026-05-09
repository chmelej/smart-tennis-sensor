package cn.sharesdk.framework.p004b.p006b;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.p004b.p005a.C0833e;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.e */
/* JADX INFO: compiled from: ExitEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C0839e extends AbstractC0837c {

    /* JADX INFO: renamed from: b */
    private static int f5609b;

    /* JADX INFO: renamed from: c */
    private static long f5610c;

    /* JADX INFO: renamed from: a */
    public long f5611a;

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected String mo6051a() {
        return "[EXT]";
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    protected int mo6053b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: c */
    protected int mo6054c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    public boolean mo6058a(Context context) {
        C0833e c0833eM6025a = C0833e.m6025a(context);
        f5609b = c0833eM6025a.m6046g("insertExitEventCount");
        f5610c = c0833eM6025a.m6044f("lastInsertExitEventTime");
        return super.mo6058a(context);
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    public void mo6059b(Context context) {
        super.mo6059b(context);
        C0833e c0833eM6025a = C0833e.m6025a(context);
        c0833eM6025a.m6030a("lastInsertExitEventTime", Long.valueOf(f5610c));
        c0833eM6025a.m6029a("insertExitEventCount", f5609b);
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: d */
    protected long mo6055d() {
        return f5609b;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: e */
    protected long mo6056e() {
        return f5610c;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: f */
    protected void mo6057f() {
        f5609b++;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected void mo6052a(long j) {
        f5610c = j;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f5603m)) {
            sb.append(this.f5603m);
        }
        sb.append('|');
        sb.append(Math.round(this.f5611a / 1000.0f));
        return sb.toString();
    }
}
