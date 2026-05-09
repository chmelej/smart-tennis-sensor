package cn.sharesdk.framework.p004b.p006b;

import android.content.Context;
import android.text.TextUtils;
import cn.sharesdk.framework.p004b.p005a.C0833e;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.g */
/* JADX INFO: compiled from: StartEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C0841g extends AbstractC0837c {

    /* JADX INFO: renamed from: a */
    private static int f5627a;

    /* JADX INFO: renamed from: b */
    private static long f5628b;

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected String mo6051a() {
        return "[RUN]";
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
        f5627a = c0833eM6025a.m6046g("insertRunEventCount");
        f5628b = c0833eM6025a.m6044f("lastInsertRunEventTime");
        return super.mo6058a(context);
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    public void mo6059b(Context context) {
        super.mo6059b(context);
        C0833e c0833eM6025a = C0833e.m6025a(context);
        c0833eM6025a.m6030a("lastInsertRunEventTime", Long.valueOf(f5628b));
        c0833eM6025a.m6029a("insertRunEventCount", f5627a);
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: d */
    protected long mo6055d() {
        return f5627a;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: e */
    protected long mo6056e() {
        return f5628b;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: f */
    protected void mo6057f() {
        f5627a++;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected void mo6052a(long j) {
        f5628b = j;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        if (!TextUtils.isEmpty(this.f5603m)) {
            sb.append(this.f5603m);
        }
        return sb.toString();
    }
}
