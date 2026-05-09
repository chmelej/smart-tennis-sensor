package p000;

import android.opengl.GLES20;
import com.qiniu.pili.droid.shortvideo.p013gl.texread.GlUtil;

/* JADX INFO: renamed from: wq */
/* JADX INFO: compiled from: GlTextureFrameBuffer.java */
/* JADX INFO: loaded from: classes.dex */
public class C2222wq {

    /* JADX INFO: renamed from: a */
    private final int f13357a;

    /* JADX INFO: renamed from: b */
    private final int f13358b;

    /* JADX INFO: renamed from: c */
    private final int f13359c;

    /* JADX INFO: renamed from: d */
    private int f13360d;

    /* JADX INFO: renamed from: e */
    private int f13361e;

    public C2222wq(int i) {
        switch (i) {
            case 6407:
            case 6408:
            case 6409:
                this.f13359c = i;
                this.f13358b = GlUtil.m8636a(3553);
                this.f13360d = 0;
                this.f13361e = 0;
                int[] iArr = new int[1];
                GLES20.glGenFramebuffers(1, iArr, 0);
                this.f13357a = iArr[0];
                GLES20.glBindFramebuffer(36160, this.f13357a);
                GlUtil.m8638a("Generate framebuffer");
                GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f13358b, 0);
                GlUtil.m8638a("Attach texture to framebuffer");
                GLES20.glBindFramebuffer(36160, 0);
                return;
            default:
                throw new IllegalArgumentException("Invalid pixel format: " + i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m12158a(int i, int i2) {
        if (i == 0 || i2 == 0) {
            throw new IllegalArgumentException("Invalid size: " + i + "x" + i2);
        }
        if (i == this.f13360d && i2 == this.f13361e) {
            return;
        }
        this.f13360d = i;
        this.f13361e = i2;
        GLES20.glBindFramebuffer(36160, this.f13357a);
        GlUtil.m8638a("glBindFramebuffer");
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, this.f13358b);
        GLES20.glTexImage2D(3553, 0, this.f13359c, i, i2, 0, this.f13359c, 5121, null);
        int iGlCheckFramebufferStatus = GLES20.glCheckFramebufferStatus(36160);
        if (iGlCheckFramebufferStatus != 36053) {
            throw new IllegalStateException("Framebuffer not complete, status: " + iGlCheckFramebufferStatus);
        }
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
    }

    /* JADX INFO: renamed from: a */
    public int m12157a() {
        return this.f13357a;
    }

    /* JADX INFO: renamed from: b */
    public void m12159b() {
        GLES20.glDeleteTextures(1, new int[]{this.f13358b}, 0);
        GLES20.glDeleteFramebuffers(1, new int[]{this.f13357a}, 0);
        this.f13360d = 0;
        this.f13361e = 0;
    }
}
