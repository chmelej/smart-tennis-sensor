package p000;

import android.util.Log;

/* JADX INFO: renamed from: wf */
/* JADX INFO: compiled from: EglSurfaceBase.java */
/* JADX INFO: loaded from: classes.dex */
public class C2211wf {

    /* JADX INFO: renamed from: e */
    private static int f13261e = 12375;

    /* JADX INFO: renamed from: f */
    private static int f13262f = 12374;

    /* JADX INFO: renamed from: a */
    protected C2210we f13263a;

    /* JADX INFO: renamed from: b */
    private Object f13264b = null;

    /* JADX INFO: renamed from: c */
    private int f13265c = -1;

    /* JADX INFO: renamed from: d */
    private int f13266d = -1;

    protected C2211wf(C2210we c2210we) {
        this.f13263a = c2210we;
    }

    /* JADX INFO: renamed from: a */
    public void m12107a(Object obj) {
        if (this.f13264b != null) {
            throw new IllegalStateException("surface already created");
        }
        this.f13264b = this.f13263a.m12102b(obj);
    }

    /* JADX INFO: renamed from: a */
    public void m12105a() {
        this.f13263a.m12100a(this.f13264b);
        this.f13264b = null;
        this.f13266d = -1;
        this.f13265c = -1;
    }

    /* JADX INFO: renamed from: b */
    public void m12108b() {
        this.f13263a.m12103c(this.f13264b);
    }

    /* JADX INFO: renamed from: c */
    public boolean m12109c() {
        boolean zM12104d = this.f13263a.m12104d(this.f13264b);
        if (!zM12104d) {
            Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return zM12104d;
    }

    /* JADX INFO: renamed from: a */
    public void m12106a(long j) {
        this.f13263a.m12101a(this.f13264b, j);
    }
}
