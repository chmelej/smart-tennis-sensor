package p000;

import android.annotation.TargetApi;
import android.opengl.GLES20;

/* JADX INFO: renamed from: wn */
/* JADX INFO: compiled from: TextureProcessor.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(18)
public class C2219wn extends C2218wm {

    /* JADX INFO: renamed from: h */
    protected int f13352h;

    /* JADX INFO: renamed from: i */
    protected int f13353i;

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: b */
    public boolean mo11988b() {
        m12146l();
        return super.mo11988b();
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: a */
    public boolean mo12140a(int i, int i2) {
        super.mo12140a(i, i2);
        m12145k();
        return m12144b(i, i2);
    }

    /* JADX INFO: renamed from: b */
    public int m12149b(int i, float[] fArr) {
        return m12147a(i, fArr, this.f13353i);
    }

    /* JADX INFO: renamed from: a */
    public int m12147a(int i, float[] fArr, int i2) {
        GLES20.glBindFramebuffer(36160, this.f13352h);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, i2, 0);
        GLES20.glClear(16384);
        m12139a(i, fArr);
        GLES20.glBindFramebuffer(36160, 0);
        return i2;
    }

    /* JADX INFO: renamed from: b */
    public int m12148b(int i) {
        return m12149b(i, (float[]) null);
    }

    /* JADX INFO: renamed from: k */
    private void m12145k() {
        if (this.f13353i != 0) {
            GLES20.glDeleteTextures(1, new int[]{this.f13353i}, 0);
            this.f13353i = 0;
        }
    }

    @Override // p000.C2218wm
    /* JADX INFO: renamed from: f */
    public void mo11992f() {
        super.mo11992f();
        if (this.f13352h != 0) {
            GLES20.glDeleteFramebuffers(1, new int[]{this.f13352h}, 0);
            this.f13352h = 0;
        }
        m12145k();
    }

    /* JADX INFO: renamed from: b */
    private boolean m12144b(int i, int i2) {
        this.f13353i = C2200vv.m12038a(null, i, i2, 6408);
        return true;
    }

    /* JADX INFO: renamed from: l */
    private void m12146l() {
        this.f13352h = C2200vv.m12046e();
    }
}
