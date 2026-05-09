package p000;

import android.view.Surface;

/* JADX INFO: renamed from: wg */
/* JADX INFO: compiled from: WindowSurface.java */
/* JADX INFO: loaded from: classes.dex */
public class C2212wg extends C2211wf {

    /* JADX INFO: renamed from: b */
    private Surface f13267b;

    /* JADX INFO: renamed from: c */
    private boolean f13268c;

    public C2212wg(C2210we c2210we, Surface surface, boolean z) {
        super(c2210we);
        m12107a(surface);
        this.f13267b = surface;
        this.f13268c = z;
    }

    /* JADX INFO: renamed from: d */
    public void m12110d() {
        m12105a();
        if (this.f13267b != null) {
            if (this.f13268c) {
                this.f13267b.release();
            }
            this.f13267b = null;
        }
    }
}
