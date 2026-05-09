package p000;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;
import p000.AbstractC2193vo;
import p000.AbstractC2195vq;
import p000.C2169ur;

/* JADX INFO: renamed from: vr */
/* JADX INFO: compiled from: HWVideoEncoder.java */
/* JADX INFO: loaded from: classes.dex */
public class C2196vr extends AbstractC2195vq implements AbstractC2193vo.a {

    /* JADX INFO: renamed from: f */
    private C2169ur f13182f;

    /* JADX INFO: renamed from: g */
    private AbstractC2193vo.a f13183g;

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b */
    protected String mo8629b() {
        return "HWVideoEncoder";
    }

    @Override // p000.AbstractC2195vq
    /* JADX INFO: renamed from: e */
    protected String mo12016e() {
        return "video/avc";
    }

    public C2196vr(C2169ur c2169ur) {
        this.f13182f = c2169ur;
        super.mo12007a(this);
    }

    @Override // p000.AbstractC2195vq
    /* JADX INFO: renamed from: d */
    protected MediaFormat mo12015d() {
        MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat("video/avc", this.f13182f.m11822a(), this.f13182f.m11828b());
        int iRound = Math.round((this.f13182f.m11834f() * 1.0f) / this.f13182f.m11830c());
        mediaFormatCreateVideoFormat.setInteger("color-format", 2130708361);
        mediaFormatCreateVideoFormat.setInteger("bitrate", (int) (((double) this.f13182f.m11832d()) * this.f13169a));
        mediaFormatCreateVideoFormat.setInteger("frame-rate", (int) (((double) this.f13182f.m11830c()) * this.f13169a));
        mediaFormatCreateVideoFormat.setInteger("i-frame-interval", iRound);
        mediaFormatCreateVideoFormat.setInteger("profile", 1);
        mediaFormatCreateVideoFormat.setInteger("level", 16);
        mediaFormatCreateVideoFormat.setInteger("bitrate-mode", this.f13182f.m11833e() == C2169ur.a.BITRATE_PRIORITY ? 2 : 1);
        return mediaFormatCreateVideoFormat;
    }

    @Override // p000.AbstractC2193vo
    /* JADX INFO: renamed from: a */
    public void mo12007a(AbstractC2193vo.a aVar) {
        this.f13183g = aVar;
    }

    @Override // p000.AbstractC2195vq, p000.AbstractC2193vo
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo12008a(long j) {
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
        m12012i();
        C2201vw.f13219h.m12051b(mo8629b(), "input frame: " + this.f13170b + " timestampNs:" + jB);
        return true;
    }

    @Override // p000.AbstractC2195vq
    /* JADX INFO: renamed from: f */
    protected AbstractC2195vq.a mo12017f() {
        return AbstractC2195vq.a.VIDEO_ENCODER;
    }

    @Override // p000.AbstractC2193vo.a
    /* JADX INFO: renamed from: a */
    public void mo11966a(boolean z) {
        if (this.f13183g != null) {
            this.f13183g.mo11966a(z);
        }
    }

    @Override // p000.AbstractC2193vo.a
    /* JADX INFO: renamed from: a */
    public void mo11962a() {
        if (this.f13183g != null) {
            this.f13183g.mo11962a();
        }
    }

    @Override // p000.AbstractC2193vo.a
    /* JADX INFO: renamed from: a */
    public void mo11964a(Surface surface) {
        if (this.f13183g != null) {
            this.f13183g.mo11964a(surface);
        }
    }

    @Override // p000.AbstractC2193vo.a
    /* JADX INFO: renamed from: a */
    public void mo11963a(MediaFormat mediaFormat) {
        if (this.f13183g != null) {
            this.f13183g.mo11963a(mediaFormat);
        }
    }

    @Override // p000.AbstractC2193vo.a
    /* JADX INFO: renamed from: a */
    public void mo11965a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f13183g != null) {
            this.f13183g.mo11965a(byteBuffer, bufferInfo);
        }
    }
}
