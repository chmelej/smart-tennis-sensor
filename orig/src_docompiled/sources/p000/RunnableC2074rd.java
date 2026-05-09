package p000;

import android.graphics.Bitmap;
import android.os.Handler;

/* JADX INFO: renamed from: rd */
/* JADX INFO: compiled from: ProcessAndDisplayImageTask.java */
/* JADX INFO: loaded from: classes.dex */
final class RunnableC2074rd implements Runnable {

    /* JADX INFO: renamed from: a */
    private final C2071ra f12551a;

    /* JADX INFO: renamed from: b */
    private final Bitmap f12552b;

    /* JADX INFO: renamed from: c */
    private final C2072rb f12553c;

    /* JADX INFO: renamed from: d */
    private final Handler f12554d;

    public RunnableC2074rd(C2071ra c2071ra, Bitmap bitmap, C2072rb c2072rb, Handler handler) {
        this.f12551a = c2071ra;
        this.f12552b = bitmap;
        this.f12553c = c2072rb;
        this.f12554d = handler;
    }

    @Override // java.lang.Runnable
    public void run() {
        C2106si.m11522a("PostProcess image before displaying [%s]", this.f12553c.f12519b);
        RunnableC2073rc.m11412a(new RunnableC2066qw(this.f12553c.f12522e.m11319p().m11511a(this.f12552b), this.f12553c, this.f12551a, EnumC2080rj.MEMORY_CACHE), this.f12553c.f12522e.m11322s(), this.f12554d, this.f12551a);
    }
}
