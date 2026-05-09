package p000;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: vq */
/* JADX INFO: compiled from: HWEncoderBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2195vq extends AbstractC2193vo {

    /* JADX INFO: renamed from: e */
    protected MediaCodec f13178e;

    /* JADX INFO: renamed from: vq$a */
    /* JADX INFO: compiled from: HWEncoderBase.java */
    public enum a {
        VIDEO_ENCODER,
        AUDIO_ENCODER
    }

    /* JADX INFO: renamed from: d */
    protected abstract MediaFormat mo12015d();

    /* JADX INFO: renamed from: e */
    protected abstract String mo12016e();

    /* JADX INFO: renamed from: f */
    protected abstract a mo12017f();

    @Override // p000.AbstractC2193vo
    /* JADX INFO: renamed from: a */
    public boolean mo12008a(long j) {
        C2201vw.f13219h.m12054d(mo8629b(), "unimplemented !");
        return false;
    }

    @Override // p000.AbstractC2193vo
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo12009a(ByteBuffer byteBuffer, int i, long j) {
        if (m12085l()) {
            C2201vw.f13219h.m12054d(mo8629b(), "stop is marked, not accepting anymore frames.");
            return false;
        }
        if (this.f13178e == null) {
            C2201vw.f13219h.m12054d(mo8629b(), "encoder is null.");
            return false;
        }
        long jB = m12010b(j);
        if (jB < 0) {
            return false;
        }
        try {
            int iDequeueInputBuffer = this.f13178e.dequeueInputBuffer(-1L);
            if (iDequeueInputBuffer < 0) {
                C2201vw.f13219h.m12055e(mo8629b(), "dequeueInputBuffer failed: " + iDequeueInputBuffer);
                return false;
            }
            ByteBuffer byteBuffer2 = this.f13178e.getInputBuffers()[iDequeueInputBuffer];
            if (byteBuffer != null) {
                byteBuffer2.put(byteBuffer);
            }
            this.f13178e.queueInputBuffer(iDequeueInputBuffer, 0, i, jB, 0);
            m12012i();
            C2201vw.f13219h.m12051b(mo8629b(), "input frame: " + this.f13170b + " buffer:" + byteBuffer + " size:" + i + " timestampUs:" + jB);
            return true;
        } catch (Exception e) {
            C2201vw.f13219h.m12055e(mo8629b(), "dequeueInputBuffer failed: " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: m */
    private synchronized boolean m12018m() {
        C2201vw.f13219h.m12053c(mo8629b(), "startEncode +");
        this.f13170b = 0;
        this.f13171c = 0;
        MediaFormat mediaFormatMo12015d = mo12015d();
        try {
            this.f13178e = MediaCodec.createEncoderByType(mo12016e());
            this.f13178e.configure(mediaFormatMo12015d, (Surface) null, (MediaCrypto) null, 1);
            if (mo12017f() == a.VIDEO_ENCODER) {
                Surface surfaceCreateInputSurface = this.f13178e.createInputSurface();
                if (this.f13172d != null) {
                    this.f13172d.mo11964a(surfaceCreateInputSurface);
                }
            }
            this.f13178e.start();
            if (this.f13172d != null) {
                this.f13172d.mo11966a(true);
            }
        } catch (Exception e) {
            this.f13178e = null;
            C2201vw.f13219h.m12055e(mo8629b(), "start encoder failed: " + e.getMessage());
            if (this.f13172d != null) {
                this.f13172d.mo11966a(false);
            }
            return false;
        } finally {
            C2201vw.f13219h.m12053c(mo8629b(), "startEncode -");
        }
        return true;
    }

    /* JADX INFO: renamed from: n */
    private synchronized void m12019n() {
        C2201vw.f13219h.m12053c(mo8629b(), "stopEncode +");
        if (this.f13178e == null) {
            C2201vw.f13219h.m12054d(mo8629b(), "encoder is null.");
            return;
        }
        try {
            this.f13178e.stop();
            this.f13178e.release();
            this.f13178e = null;
        } catch (Exception e) {
            C2201vw.f13219h.m12055e(mo8629b(), "encoder stop, release failed: " + e.getMessage());
        }
        if (this.f13172d != null) {
            this.f13172d.mo11962a();
        }
        C2201vw.f13219h.m12053c(mo8629b(), "stopEncode -");
    }

    /* JADX INFO: renamed from: g */
    protected void m12020g() {
        if (this.f13178e == null) {
            C2201vw.f13219h.m12054d(mo8629b(), "encoder is null.");
            return;
        }
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        try {
            int iDequeueOutputBuffer = this.f13178e.dequeueOutputBuffer(bufferInfo, 1000L);
            if (iDequeueOutputBuffer == -3) {
                C2201vw.f13219h.m12053c(mo8629b(), "output buffers changed !");
            } else if (iDequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.f13178e.getOutputFormat();
                if (this.f13172d != null) {
                    this.f13172d.mo11963a(outputFormat);
                }
            } else if (iDequeueOutputBuffer >= 0) {
                if ((bufferInfo.flags & 2) != 0) {
                    C2201vw.f13219h.m12053c(mo8629b(), "ignoring BUFFER_FLAG_CODEC_CONFIG");
                } else {
                    ByteBuffer byteBuffer = this.f13178e.getOutputBuffers()[iDequeueOutputBuffer];
                    byteBuffer.position(bufferInfo.offset);
                    byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
                    if (this.f13172d != null) {
                        this.f13172d.mo11965a(byteBuffer, bufferInfo);
                    }
                    byteBuffer.clear();
                    m12013j();
                }
                try {
                    this.f13178e.releaseOutputBuffer(iDequeueOutputBuffer, false);
                } catch (Exception e) {
                    C2201vw.f13219h.m12055e(mo8629b(), "releaseOutputBuffer failed: " + e.getMessage());
                    return;
                }
            }
            if (iDequeueOutputBuffer != -1) {
                C2201vw c2201vw = C2201vw.f13219h;
                String strB = mo8629b();
                StringBuilder sb = new StringBuilder();
                sb.append("output frame: ");
                sb.append(this.f13171c);
                sb.append(" index:");
                sb.append(iDequeueOutputBuffer);
                sb.append(" key frame:");
                sb.append((bufferInfo.flags & 1) != 0);
                sb.append(" eos:");
                sb.append((bufferInfo.flags & 4) != 0);
                sb.append(" config:");
                sb.append((bufferInfo.flags & 2) != 0);
                sb.append(" sync:");
                sb.append((bufferInfo.flags & 1) != 0);
                sb.append(" time:");
                sb.append(bufferInfo.presentationTimeUs);
                sb.append(" size:");
                sb.append(bufferInfo.size);
                c2201vw.m12051b(strB, sb.toString());
            }
        } catch (Exception e2) {
            C2201vw.f13219h.m12055e(mo8629b(), "dequeueOutputBuffer failed: " + e2.getMessage());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        if (!m12018m()) {
            C2201vw.f13219h.m12055e(mo8629b(), "encoder start failed");
            return;
        }
        while (true) {
            if (!m12085l() || m12014k()) {
                m12020g();
            } else {
                m12019n();
                return;
            }
        }
    }
}
