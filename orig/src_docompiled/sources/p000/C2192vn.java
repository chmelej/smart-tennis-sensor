package p000;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: renamed from: vn */
/* JADX INFO: compiled from: RawFrameExtractor.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2192vn extends AbstractRunnableC2206wa {

    /* JADX INFO: renamed from: a */
    private MediaExtractor f13149a;

    /* JADX INFO: renamed from: b */
    private MediaFormat f13150b;

    /* JADX INFO: renamed from: c */
    private Surface f13151c;

    /* JADX INFO: renamed from: d */
    private MediaCodec f13152d;

    /* JADX INFO: renamed from: e */
    private ByteBuffer[] f13153e;

    /* JADX INFO: renamed from: f */
    private ByteBuffer[] f13154f;

    /* JADX INFO: renamed from: g */
    private b f13155g;

    /* JADX INFO: renamed from: h */
    private c f13156h;

    /* JADX INFO: renamed from: i */
    private a f13157i;

    /* JADX INFO: renamed from: j */
    private int f13158j;

    /* JADX INFO: renamed from: k */
    private long f13159k;

    /* JADX INFO: renamed from: l */
    private long f13160l;

    /* JADX INFO: renamed from: m */
    private boolean f13161m;

    /* JADX INFO: renamed from: n */
    private boolean f13162n;

    /* JADX INFO: renamed from: o */
    private List<Long> f13163o;

    /* JADX INFO: renamed from: p */
    private List<Long> f13164p;

    /* JADX INFO: renamed from: q */
    private List<Integer> f13165q;

    /* JADX INFO: renamed from: r */
    private List<Integer> f13166r;

    /* JADX INFO: renamed from: s */
    private int f13167s;

    /* JADX INFO: renamed from: t */
    private int f13168t;

    /* JADX INFO: renamed from: vn$a */
    /* JADX INFO: compiled from: RawFrameExtractor.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void m12003a(int i);
    }

    /* JADX INFO: renamed from: vn$b */
    /* JADX INFO: compiled from: RawFrameExtractor.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        void m12004a(ByteBuffer byteBuffer, int i, long j, boolean z);
    }

    /* JADX INFO: renamed from: vn$c */
    /* JADX INFO: compiled from: RawFrameExtractor.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        void m12005a(int i);
    }

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b */
    protected String mo8629b() {
        return "RawFrameExtractor";
    }

    @Override // p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b_ */
    public boolean mo12002b_() {
        this.f13159k = 0L;
        this.f13160l = 0L;
        return super.mo12002b_();
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean zM11997c = m11997c();
        while (!m12085l() && zM11997c) {
            if (this.f13162n) {
                m11999e();
            } else {
                m12000f();
            }
            m12001g();
        }
        m11998d();
    }

    /* JADX INFO: renamed from: c */
    private boolean m11997c() {
        int i;
        C2201vw.f13232u.m12053c("RawFrameExtractor", "startDecoder +");
        if (this.f13150b == null) {
            C2201vw.f13232u.m12055e("RawFrameExtractor", "startDecoder failed: NULL format");
            return false;
        }
        try {
            this.f13152d = MediaCodec.createDecoderByType(this.f13150b.getString("mime"));
            try {
                this.f13152d.configure(this.f13150b, this.f13151c, (MediaCrypto) null, 0);
                this.f13152d.start();
                this.f13153e = this.f13152d.getInputBuffers();
                this.f13154f = this.f13152d.getOutputBuffers();
                C2201vw.f13232u.m12053c("RawFrameExtractor", "startDecoder success !");
                return true;
            } catch (RuntimeException e) {
                C2201vw.f13232u.m12054d("RawFrameExtractor", "startDecoder failed: error message: " + e.getMessage());
                if (e.getMessage() != null && e.getMessage().contains("0xfffffc03")) {
                    C2201vw.f13232u.m12054d("RawFrameExtractor", "not support multiple media codec!" + e.getMessage());
                    i = 16;
                } else {
                    C2201vw.f13232u.m12054d("RawFrameExtractor", "configure decoder failed! " + e.getMessage());
                    i = 17;
                }
                if (this.f13157i != null) {
                    this.f13157i.m12003a(i);
                }
                return false;
            }
        } catch (IOException e2) {
            C2201vw.f13232u.m12055e("RawFrameExtractor", "startDecoder failed: " + e2.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m11998d() {
        C2201vw.f13232u.m12053c("RawFrameExtractor", "stopDecoder +");
        if (this.f13152d != null) {
            this.f13152d.stop();
            this.f13152d.release();
            this.f13152d = null;
        }
        if (this.f13149a != null) {
            this.f13149a.release();
            this.f13149a = null;
        }
        C2201vw.f13232u.m12053c("RawFrameExtractor", "stopDecoder -");
    }

    /* JADX INFO: renamed from: e */
    private void m11999e() {
        try {
            int iDequeueInputBuffer = this.f13152d.dequeueInputBuffer(10000L);
            if (iDequeueInputBuffer == -1) {
                C2201vw.f13232u.m12051b("RawFrameExtractor", "dequeueInputBuffer INFO_TRY_AGAIN_LATER");
                return;
            }
            if (this.f13167s >= this.f13164p.size()) {
                this.f13152d.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                return;
            }
            if (this.f13168t == 0) {
                this.f13149a.seekTo(this.f13164p.get(this.f13167s).longValue(), 2);
                this.f13166r.add(this.f13165q.get(this.f13167s));
            } else {
                this.f13166r.add(0);
            }
            this.f13152d.queueInputBuffer(iDequeueInputBuffer, 0, this.f13149a.readSampleData(this.f13153e[iDequeueInputBuffer], 0), this.f13163o.remove(0).longValue(), 0);
            this.f13168t++;
            if (this.f13168t < this.f13165q.get(this.f13167s).intValue()) {
                this.f13149a.advance();
            } else {
                this.f13168t = 0;
                this.f13167s++;
            }
        } catch (IllegalStateException e) {
            C2201vw.f13232u.m12055e("RawFrameExtractor", e.toString());
        }
    }

    /* JADX INFO: renamed from: f */
    private void m12000f() {
        int i;
        try {
            int iDequeueInputBuffer = this.f13152d.dequeueInputBuffer(10000L);
            if (iDequeueInputBuffer == -1) {
                C2201vw.f13232u.m12051b("RawFrameExtractor", "dequeueInputBuffer INFO_TRY_AGAIN_LATER");
                return;
            }
            int sampleData = this.f13149a.readSampleData(this.f13153e[iDequeueInputBuffer], 0);
            if (sampleData > 0) {
                this.f13152d.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, this.f13149a.getSampleTime(), 0);
                this.f13149a.advance();
                return;
            }
            if (this.f13161m) {
                this.f13149a.seekTo(0L, 0);
                i = 0;
            } else {
                i = 4;
            }
            this.f13152d.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, i);
        } catch (IllegalStateException e) {
            C2201vw.f13232u.m12055e("RawFrameExtractor", e.toString());
        }
    }

    /* JADX INFO: renamed from: g */
    private boolean m12001g() {
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            while (!m12085l()) {
                int iDequeueOutputBuffer = this.f13152d.dequeueOutputBuffer(bufferInfo, 10000L);
                if (iDequeueOutputBuffer == -1) {
                    C2201vw.f13232u.m12051b("RawFrameExtractor", "dequeueOutputBuffer INFO_TRY_AGAIN_LATER");
                    return true;
                }
                if (iDequeueOutputBuffer == -3) {
                    this.f13154f = this.f13152d.getOutputBuffers();
                    C2201vw.f13232u.m12053c("RawFrameExtractor", "processOutputFrame: INFO_OUTPUT_BUFFERS_CHANGED !");
                } else if (iDequeueOutputBuffer == -2) {
                    MediaFormat outputFormat = this.f13152d.getOutputFormat();
                    C2201vw.f13232u.m12053c("RawFrameExtractor", "video decoder output format changed: " + outputFormat);
                } else {
                    if (iDequeueOutputBuffer < 0) {
                        throw new RuntimeException("unexpected result from video decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer);
                    }
                    if ((bufferInfo.flags & 2) != 0) {
                        C2201vw.f13220i.m12053c("RawFrameExtractor", "codec config frame ignore.");
                    } else {
                        m11996a(iDequeueOutputBuffer, bufferInfo);
                    }
                }
            }
            return true;
        } catch (IllegalStateException e) {
            C2201vw.f13232u.m12055e("RawFrameExtractor", e.toString());
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x010c  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m11996a(int r12, android.media.MediaCodec.BufferInfo r13) {
        /*
            Method dump skipped, instruction units count: 329
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2192vn.m11996a(int, android.media.MediaCodec$BufferInfo):void");
    }
}
