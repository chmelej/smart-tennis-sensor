package p000;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: vo */
/* JADX INFO: compiled from: EncoderBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2193vo extends AbstractRunnableC2206wa {

    /* JADX INFO: renamed from: b */
    protected volatile int f13170b;

    /* JADX INFO: renamed from: c */
    protected volatile int f13171c;

    /* JADX INFO: renamed from: d */
    protected a f13172d;

    /* JADX INFO: renamed from: e */
    private volatile boolean f13173e;

    /* JADX INFO: renamed from: f */
    private volatile long f13174f;

    /* JADX INFO: renamed from: g */
    private volatile long f13175g = -1;

    /* JADX INFO: renamed from: a */
    protected double f13169a = 1.0d;

    /* JADX INFO: renamed from: h */
    private final Object f13176h = new Object();

    /* JADX INFO: renamed from: vo$a */
    /* JADX INFO: compiled from: EncoderBase.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo11962a();

        /* JADX INFO: renamed from: a */
        void mo11963a(MediaFormat mediaFormat);

        /* JADX INFO: renamed from: a */
        void mo11964a(Surface surface);

        /* JADX INFO: renamed from: a */
        void mo11965a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo);

        /* JADX INFO: renamed from: a */
        void mo11966a(boolean z);
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo12008a(long j);

    /* JADX INFO: renamed from: a */
    public abstract boolean mo12009a(ByteBuffer byteBuffer, int i, long j);

    /* JADX INFO: renamed from: a */
    public void m12006a(double d) {
        this.f13169a = d;
    }

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b_ */
    public boolean mo12002b_() {
        this.f13173e = false;
        this.f13174f = 0L;
        this.f13175g = -1L;
        return super.mo12002b_();
    }

    /* JADX INFO: renamed from: c */
    public long mo8630c() {
        return this.f13174f;
    }

    /* JADX INFO: renamed from: b */
    protected long m12010b(long j) {
        if (!this.f13173e) {
            this.f13173e = true;
            this.f13174f = j;
        }
        long j2 = j - this.f13174f;
        if (j2 <= this.f13175g) {
            C2201vw.f13219h.m12054d(mo8629b(), "timestamp fall back, ignore this frame.");
            return -1L;
        }
        this.f13175g = j2;
        return j2;
    }

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: h */
    public boolean mo12011h() {
        boolean zMo12011h = super.mo12011h();
        synchronized (this.f13176h) {
            C2201vw.f13219h.m12053c(mo8629b(), "stopping encoder, input frame count: " + this.f13170b + " output frame count: " + this.f13171c + " flush remaining frames: " + (this.f13170b - this.f13171c));
        }
        return zMo12011h;
    }

    /* JADX INFO: renamed from: i */
    protected void m12012i() {
        synchronized (this.f13176h) {
            this.f13170b++;
        }
    }

    /* JADX INFO: renamed from: j */
    protected void m12013j() {
        synchronized (this.f13176h) {
            this.f13171c++;
        }
    }

    /* JADX INFO: renamed from: k */
    protected boolean m12014k() {
        boolean z;
        synchronized (this.f13176h) {
            z = this.f13170b > this.f13171c;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public void mo12007a(a aVar) {
        this.f13172d = aVar;
    }
}
