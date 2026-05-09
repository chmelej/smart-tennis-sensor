package cn.sharesdk.framework.p004b.p006b;

import android.content.Context;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.c */
/* JADX INFO: compiled from: BaseEvent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0837c {

    /* JADX INFO: renamed from: e */
    public long f5595e;

    /* JADX INFO: renamed from: f */
    public String f5596f;

    /* JADX INFO: renamed from: g */
    public String f5597g;

    /* JADX INFO: renamed from: h */
    public String f5598h;

    /* JADX INFO: renamed from: i */
    public int f5599i;

    /* JADX INFO: renamed from: j */
    public String f5600j;

    /* JADX INFO: renamed from: k */
    public int f5601k;

    /* JADX INFO: renamed from: l */
    public String f5602l;

    /* JADX INFO: renamed from: m */
    public String f5603m;

    /* JADX INFO: renamed from: a */
    protected abstract String mo6051a();

    /* JADX INFO: renamed from: a */
    protected abstract void mo6052a(long j);

    /* JADX INFO: renamed from: b */
    protected abstract int mo6053b();

    /* JADX INFO: renamed from: c */
    protected abstract int mo6054c();

    /* JADX INFO: renamed from: d */
    protected abstract long mo6055d();

    /* JADX INFO: renamed from: e */
    protected abstract long mo6056e();

    /* JADX INFO: renamed from: f */
    protected abstract void mo6057f();

    /* JADX INFO: renamed from: a */
    public boolean mo6058a(Context context) {
        int iMo6053b = mo6053b();
        int iMo6054c = mo6054c();
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (jCurrentTimeMillis - mo6056e() < iMo6053b) {
            return mo6055d() < ((long) iMo6054c);
        }
        mo6052a(jCurrentTimeMillis);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void mo6059b(Context context) {
        mo6057f();
    }

    public String toString() {
        return mo6051a() + ':' + this.f5595e + '|' + this.f5596f + '|' + this.f5597g + '|' + this.f5598h + '|' + this.f5599i + '|' + this.f5600j + '|' + this.f5601k + '|' + this.f5602l;
    }
}
