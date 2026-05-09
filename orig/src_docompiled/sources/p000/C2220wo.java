package p000;

import android.opengl.GLES20;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: wo */
/* JADX INFO: compiled from: TextureReader.java */
/* JADX INFO: loaded from: classes.dex */
public class C2220wo extends C2219wn {
    @Override // p000.C2218wm
    /* JADX INFO: renamed from: i */
    protected float[] mo12132i() {
        return C2200vv.f13209d;
    }

    /* JADX INFO: renamed from: k */
    public byte[] m12150k() {
        GLES20.glBindFramebuffer(36160, this.f13352h);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.f13353i, 0);
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(this.f13335c * 4 * this.f13336d);
        GLES20.glReadPixels(0, 0, this.f13335c, this.f13336d, 6408, 5121, byteBufferAllocate);
        GLES20.glBindFramebuffer(36160, 0);
        return byteBufferAllocate.array();
    }
}
