package p000;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.encode.SWVideoEncoder;
import java.nio.ByteBuffer;
import p000.AbstractC2193vo;
import p000.C2171ut;
import p000.C2175ux;
import p000.C2185vg;

/* JADX INFO: renamed from: vj */
/* JADX INFO: compiled from: ShortVideoRecorderCore.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2188vj extends C2186vh implements InterfaceC2170us, C2175ux.a, C2185vg.a {

    /* JADX INFO: renamed from: A */
    private C2213wh f13109A;

    /* JADX INFO: renamed from: B */
    private C2177uz f13110B;

    /* JADX INFO: renamed from: C */
    private C2228ww f13111C;

    /* JADX INFO: renamed from: D */
    private InterfaceC2170us f13112D;

    /* JADX INFO: renamed from: E */
    private InterfaceC2159uh f13113E;

    /* JADX INFO: renamed from: F */
    private InterfaceC2156ue f13114F;

    /* JADX INFO: renamed from: G */
    private Object f13115G;

    /* JADX INFO: renamed from: H */
    private C2169ur f13116H;

    /* JADX INFO: renamed from: I */
    private C2158ug f13117I;

    /* JADX INFO: renamed from: J */
    private C2155ud f13118J;

    /* JADX INFO: renamed from: K */
    private volatile boolean f13119K;

    /* JADX INFO: renamed from: L */
    private int f13120L;

    /* JADX INFO: renamed from: M */
    private final Object f13121M = new Object();

    /* JADX INFO: renamed from: N */
    private AbstractC2193vo.a f13122N = new AbstractC2193vo.a() { // from class: vj.1
        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11966a(boolean z) {
            C2201vw.f13219h.m12053c("ShortVideoRecorderCore", "video encoder started: " + z);
            C2188vj.this.f13125t = z;
            if (z || C2188vj.this.f13093m == null) {
                return;
            }
            C2188vj.this.f13083c = false;
            C2188vj.this.f13093m.mo7643a(6);
            C2188vj.this.f13094n.m11923a(6);
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11962a() {
            C2201vw.f13219h.m12053c("ShortVideoRecorderCore", "video encoder stopped.");
            if (C2188vj.this.f13129x != null) {
                C2188vj.this.f13129x.m12124b();
            }
            C2188vj.this.f13125t = false;
            C2188vj.this.f13126u = false;
            C2188vj.this.m11960o();
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11964a(Surface surface) {
            synchronized (C2188vj.this.f13121M) {
                C2188vj.this.f13129x = new RunnableC2214wi(C2188vj.this.f13115G, surface, C2188vj.this.f13116H.m11822a(), C2188vj.this.f13116H.m11828b(), C2188vj.this.f13088h.m11796d());
            }
            C2188vj.this.f13129x.m12122a(C2188vj.this.f13120L);
            C2188vj.this.f13129x.m12121a();
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11963a(MediaFormat mediaFormat) {
            C2201vw.f13225n.m12053c("ShortVideoRecorderCore", "got video format:" + mediaFormat.toString());
            C2188vj.this.f13092l.m11929a(mediaFormat);
            C2188vj.this.f13126u = true;
            C2188vj.this.m11959n();
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11965a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (C2188vj.this.f13086f) {
                C2201vw.f13219h.m12051b("ShortVideoRecorderCore", "video encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                C2188vj.this.f13092l.m11930a(byteBuffer, bufferInfo);
            }
        }
    };

    /* JADX INFO: renamed from: r */
    private volatile boolean f13123r;

    /* JADX INFO: renamed from: s */
    private volatile boolean f13124s;

    /* JADX INFO: renamed from: t */
    private volatile boolean f13125t;

    /* JADX INFO: renamed from: u */
    private volatile boolean f13126u;

    /* JADX INFO: renamed from: v */
    private C2175ux f13127v;

    /* JADX INFO: renamed from: w */
    private AbstractC2193vo f13128w;

    /* JADX INFO: renamed from: x */
    private RunnableC2214wi f13129x;

    /* JADX INFO: renamed from: y */
    private C2224ws f13130y;

    /* JADX INFO: renamed from: z */
    private C2219wn f13131z;

    public C2188vj() {
        C2201vw.f13215d.m12053c("ShortVideoRecorderCore", "init");
    }

    /* JADX INFO: renamed from: a */
    public void m11977a(GLSurfaceView gLSurfaceView, C2155ud c2155ud, C2161uj c2161uj, C2169ur c2169ur, C2150tz c2150tz, C2158ug c2158ug, C2162uk c2162uk) {
        Context applicationContext = gLSurfaceView.getContext().getApplicationContext();
        this.f13116H = c2169ur;
        this.f13117I = c2158ug;
        this.f13118J = c2155ud;
        super.m11944a(applicationContext, c2161uj, c2150tz, c2162uk);
        this.f13127v = new C2175ux(applicationContext, c2155ud);
        this.f13109A = new C2213wh(gLSurfaceView, c2158ug, c2162uk.m11796d());
        this.f13110B = new C2177uz();
        this.f13111C = new C2228ww(applicationContext);
        if (c2169ur.m11835g()) {
            this.f13128w = new C2196vr(c2169ur);
        } else {
            this.f13128w = new SWVideoEncoder(c2169ur);
        }
        this.f13128w.mo12007a(this.f13122N);
        this.f13127v.m11869a(this);
        this.f13127v.m11868a(this.f13113E);
        this.f13109A.m12116a(this);
        this.f13110B.m11879a(c2169ur.m11830c());
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: b */
    public void mo11949b() {
        super.mo11949b();
        this.f13109A.m12114a();
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: e */
    public void mo11950e() {
        super.mo11950e();
        this.f13124s = false;
        this.f13126u = false;
        if (this.f13129x != null) {
            this.f13129x.m12125c();
        }
        this.f13109A.m12117b();
        this.f13127v.m11866a();
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: a */
    public void mo11947a(boolean z) {
        super.mo11947a(z);
        this.f13127v.m11871b();
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: g */
    protected boolean mo11952g() {
        return this.f13124s && this.f13082b;
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: h */
    protected boolean mo11953h() {
        return this.f13125t && this.f13084d;
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: i */
    protected boolean mo11954i() {
        return this.f13126u && this.f13085e;
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: j */
    protected boolean mo11955j() {
        return (this.f13126u || this.f13085e) ? false : true;
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: f */
    protected String mo11951f() {
        return this.f13117I != null ? "camera_recorder_beauty" : "camera_recorder";
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: k */
    protected C2185vg mo11956k() {
        return new C2185vg(this.f13087g, this.f13088h, this.f13090j, this.f13116H);
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: a */
    public synchronized boolean mo11948a(String str) {
        boolean zMo11948a;
        zMo11948a = super.mo11948a(str);
        if (zMo11948a) {
            if (!this.f13096p) {
                this.f13096p = true;
                this.f13128w.m12006a(this.f13095o);
            }
            this.f13128w.mo12002b_();
        }
        return zMo11948a;
    }

    @Override // p000.C2186vh
    /* JADX INFO: renamed from: l */
    public synchronized boolean mo11957l() {
        boolean zMo11957l;
        zMo11957l = super.mo11957l();
        if (zMo11957l) {
            this.f13125t = false;
            this.f13128w.mo12011h();
        }
        return zMo11957l;
    }

    /* JADX INFO: renamed from: q */
    public void m11978q() {
        C2201vw.f13215d.m12053c("ShortVideoRecorderCore", "switching camera +");
        mo11950e();
        this.f13127v.m11872c();
        mo11949b();
        C2201vw.f13215d.m12053c("ShortVideoRecorderCore", "switching camera -");
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: c */
    public void mo11730c() {
        if (this.f13127v.m11870a(this.f13109A.m12118c())) {
            this.f13115G = C2210we.m12098b();
        } else if (this.f13093m != null) {
            this.f13093m.mo7643a(4);
            this.f13094n.m11923a(4);
        }
        if (this.f13112D != null) {
            this.f13112D.mo11730c();
        }
        this.f13123r = true;
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: a */
    public void mo11726a(int i, int i2) {
        this.f13127v.m11867a(i, i2);
        if (this.f13112D != null) {
            this.f13112D.mo11726a(i, i2);
        }
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: d */
    public void mo11731d() {
        this.f13111C.m12181b();
        if (this.f13112D != null) {
            this.f13112D.mo11731d();
        }
        this.f13123r = false;
        if (this.f13130y != null) {
            this.f13130y.m12163a();
            this.f13130y = null;
        }
        if (this.f13131z != null) {
            this.f13131z.mo11992f();
            this.f13131z = null;
        }
    }

    @Override // p000.InterfaceC2170us
    /* JADX INFO: renamed from: a */
    public int mo11725a(int i, int i2, int i3, long j, float[] fArr) {
        int iM12178a;
        int iMo11725a;
        synchronized (C2200vv.f13206a) {
            if (this.f13112D != null && (iMo11725a = this.f13112D.mo11725a(i, i2, i3, j, fArr)) > 0) {
                i = iMo11725a;
            }
            if (!this.f13111C.m12180a()) {
                this.f13111C.m12179a(i2, i3);
            }
            iM12178a = this.f13111C.m12178a(i);
            GLES20.glFinish();
        }
        if (this.f13119K) {
            C2220wo c2220wo = new C2220wo();
            c2220wo.mo12140a(i2, i3);
            c2220wo.mo11988b();
            c2220wo.m12148b(iM12178a);
            C2171ut c2171ut = new C2171ut();
            c2171ut.m11836a(i2);
            c2171ut.m11840b(i3);
            c2171ut.m11837a(j);
            c2171ut.m11839a(c2220wo.m12150k());
            c2171ut.m11838a(C2171ut.a.ARGB_8888);
            if (this.f13114F != null) {
                this.f13114F.m11764a(c2171ut);
            }
            c2220wo.mo11992f();
            this.f13119K = false;
        }
        if (this.f13125t && this.f13084d && !this.f13110B.m11880a()) {
            long j2 = (long) (j / this.f13095o);
            C2201vw.f13217f.m12049a("ShortVideoRecorderCore", "video frame captured texId:" + iM12178a + " width:" + i2 + " height:" + i3 + " ts:" + j2);
            if (this.f13116H.m11835g()) {
                if (this.f13128w.mo12008a(j2)) {
                    long jMo8630c = j2 - this.f13128w.mo8630c();
                    this.f13129x.m12123a(iM12178a, i2, i3, jMo8630c);
                    C2201vw.f13219h.m12051b("HWVideoEncoder", "input frame texId: " + iM12178a + " width: " + i2 + " height: " + i3 + " timestampNs:" + jMo8630c);
                }
            } else {
                if (this.f13131z == null) {
                    this.f13131z = new C2219wn();
                    this.f13131z.mo12140a(this.f13116H.m11822a(), this.f13116H.m11828b());
                    this.f13131z.m12141a(i2, i3, this.f13088h.m11796d());
                }
                int iM12148b = this.f13131z.m12148b(iM12178a);
                if (this.f13130y == null) {
                    this.f13130y = new C2224ws(this.f13116H.m11822a(), this.f13116H.m11828b());
                }
                ByteBuffer byteBufferM12162a = this.f13130y.m12162a(iM12148b);
                this.f13128w.mo12009a(byteBufferM12162a, byteBufferM12162a.capacity(), j2);
            }
        }
        return iM12178a;
    }

    @Override // p000.C2175ux.a
    /* JADX INFO: renamed from: a */
    public void mo11874a(int i, int i2, int i3, int i4) {
        if (this.f13081a && !this.f13124s && this.f13123r) {
            this.f13124s = true;
            m11958m();
        }
        this.f13109A.m12115a(i, i2, i3, i4);
    }
}
