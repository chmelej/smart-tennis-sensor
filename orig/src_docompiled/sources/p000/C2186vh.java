package p000;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaPlayer;
import android.view.Surface;
import com.qiniu.pili.droid.shortvideo.encode.SWAudioEncoder;
import java.nio.ByteBuffer;
import java.util.Stack;
import p000.AbstractC2193vo;
import p000.C2181vc;
import p000.C2185vg;

/* JADX INFO: renamed from: vh */
/* JADX INFO: compiled from: ShortAudioRecorderCore.java */
/* JADX INFO: loaded from: classes.dex */
public class C2186vh implements InterfaceC2152ua, C2185vg.a {

    /* JADX INFO: renamed from: D */
    private String f13078D;

    /* JADX INFO: renamed from: E */
    private long f13079E;

    /* JADX INFO: renamed from: a */
    protected volatile boolean f13081a;

    /* JADX INFO: renamed from: b */
    protected volatile boolean f13082b;

    /* JADX INFO: renamed from: c */
    protected volatile boolean f13083c;

    /* JADX INFO: renamed from: d */
    protected volatile boolean f13084d;

    /* JADX INFO: renamed from: e */
    protected volatile boolean f13085e;

    /* JADX INFO: renamed from: f */
    protected volatile boolean f13086f;

    /* JADX INFO: renamed from: g */
    protected Context f13087g;

    /* JADX INFO: renamed from: h */
    protected C2162uk f13088h;

    /* JADX INFO: renamed from: i */
    protected C2161uj f13089i;

    /* JADX INFO: renamed from: j */
    protected C2150tz f13090j;

    /* JADX INFO: renamed from: k */
    protected C2180vb f13091k;

    /* JADX INFO: renamed from: l */
    protected C2185vg f13092l;

    /* JADX INFO: renamed from: m */
    protected InterfaceC2163ul f13093m;

    /* JADX INFO: renamed from: n */
    protected C2183ve f13094n;

    /* JADX INFO: renamed from: r */
    private AbstractC2193vo f13098r;

    /* JADX INFO: renamed from: s */
    private InterfaceC2152ua f13099s;

    /* JADX INFO: renamed from: t */
    private volatile boolean f13100t;

    /* JADX INFO: renamed from: u */
    private volatile boolean f13101u;

    /* JADX INFO: renamed from: v */
    private InterfaceC2172uu f13102v;

    /* JADX INFO: renamed from: x */
    private MediaPlayer f13104x;

    /* JADX INFO: renamed from: y */
    private Stack<Integer> f13105y;

    /* JADX INFO: renamed from: z */
    private Stack<Object> f13106z;

    /* JADX INFO: renamed from: o */
    protected double f13095o = 1.0d;

    /* JADX INFO: renamed from: p */
    protected boolean f13096p = false;

    /* JADX INFO: renamed from: w */
    private C2181vc f13103w = new C2181vc();

    /* JADX INFO: renamed from: A */
    private String f13075A = null;

    /* JADX INFO: renamed from: B */
    private AssetFileDescriptor f13076B = null;

    /* JADX INFO: renamed from: C */
    private boolean f13077C = false;

    /* JADX INFO: renamed from: F */
    private long f13080F = -1;

    /* JADX INFO: renamed from: q */
    protected AbstractC2193vo.a f13097q = new AbstractC2193vo.a() { // from class: vh.2
        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11964a(Surface surface) {
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11966a(boolean z) {
            C2201vw.f13219h.m12053c("ShortAudioRecorderCore", "audio encoder started: " + z);
            C2186vh.this.f13084d = z;
            if (z || C2186vh.this.f13093m == null) {
                return;
            }
            C2186vh.this.f13083c = false;
            C2186vh.this.f13093m.mo7643a(7);
            C2186vh.this.f13094n.m11923a(7);
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11962a() {
            C2201vw.f13219h.m12053c("ShortAudioRecorderCore", "audio encoder stopped.");
            C2186vh.this.f13084d = false;
            C2186vh.this.f13085e = false;
            C2186vh.this.f13080F = -1L;
            C2186vh.this.m11960o();
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11963a(MediaFormat mediaFormat) {
            C2201vw.f13225n.m12053c("ShortAudioRecorderCore", "got audio format:" + mediaFormat.toString());
            C2186vh.this.f13092l.m11935b(mediaFormat);
            C2186vh.this.f13085e = true;
            C2186vh.this.m11959n();
        }

        @Override // p000.AbstractC2193vo.a
        /* JADX INFO: renamed from: a */
        public void mo11965a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
            if (C2186vh.this.f13086f) {
                C2201vw.f13219h.m12051b("ShortAudioRecorderCore", "audio encoded frame size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
                C2186vh.this.f13092l.m11936b(byteBuffer, bufferInfo);
            }
        }
    };

    /* JADX INFO: renamed from: f */
    protected String mo11951f() {
        return "audio_recorder";
    }

    public C2186vh() {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "init");
    }

    /* JADX INFO: renamed from: a */
    public void m11944a(Context context, C2161uj c2161uj, C2150tz c2150tz, C2162uk c2162uk) {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "prepare +");
        C2187vi.m11968a(context);
        this.f13094n = C2183ve.m11912a(context);
        this.f13094n.m11924a(mo11951f());
        this.f13087g = context;
        this.f13088h = c2162uk;
        this.f13089i = c2161uj;
        this.f13090j = c2150tz;
        this.f13091k = new C2180vb(c2161uj);
        if (c2150tz.m11743a()) {
            this.f13098r = new C2194vp(c2150tz);
        } else {
            this.f13098r = new SWAudioEncoder(c2150tz);
        }
        this.f13092l = mo11956k();
        this.f13092l.m11932a(this);
        this.f13098r.mo12007a(this.f13097q);
        this.f13091k.m11905a(this);
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "prepare -");
    }

    /* JADX INFO: renamed from: b */
    public void mo11949b() {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "resume +");
        if (mo11952g()) {
            C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "sources already ready !!!");
            return;
        }
        if (this.f13081a) {
            C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "source readying !!!");
            return;
        }
        this.f13081a = true;
        if (!this.f13091k.m11906a() && this.f13093m != null) {
            this.f13093m.mo7643a(5);
            this.f13094n.m11923a(5);
        }
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "resume -");
    }

    /* JADX INFO: renamed from: e */
    public void mo11950e() {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "pause +");
        mo11957l();
        this.f13081a = false;
        this.f13082b = false;
        this.f13085e = false;
        this.f13091k.m11907b();
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "pause -");
    }

    /* JADX INFO: renamed from: a */
    public void mo11947a(boolean z) {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "destroy + clearSections: " + z);
        if (z) {
            this.f13092l.m11938c();
        }
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "destroy -");
    }

    /* JADX INFO: renamed from: g */
    protected boolean mo11952g() {
        return this.f13082b;
    }

    /* JADX INFO: renamed from: h */
    protected boolean mo11953h() {
        return this.f13084d;
    }

    /* JADX INFO: renamed from: i */
    protected boolean mo11954i() {
        return this.f13085e;
    }

    /* JADX INFO: renamed from: j */
    protected boolean mo11955j() {
        return !this.f13085e;
    }

    /* JADX INFO: renamed from: k */
    protected C2185vg mo11956k() {
        return new C2185vg(this.f13087g, this.f13088h, this.f13090j);
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean mo11948a(String str) {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "beginSection +");
        if (this.f13104x != null && !this.f13101u) {
            C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "player is not prepared!");
            return false;
        }
        if (!this.f13083c && !this.f13086f) {
            if (this.f13079E >= this.f13088h.m11788a()) {
                C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "reached the max record duration");
                return false;
            }
            this.f13078D = str;
            this.f13083c = true;
            this.f13103w.m11910a(new C2181vc.a() { // from class: vh.1
                @Override // p000.C2181vc.a
                /* JADX INFO: renamed from: a */
                public void mo11911a(ByteBuffer byteBuffer, int i, long j) {
                    C2186vh.this.f13098r.mo12009a(byteBuffer, i, j);
                }
            });
            this.f13098r.mo12002b_();
            if (this.f13104x != null && !this.f13077C) {
                this.f13106z.push(this.f13075A == null ? this.f13076B : this.f13075A);
                this.f13104x.start();
                this.f13105y.push(Integer.valueOf(this.f13104x.getCurrentPosition()));
            }
            C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "beginSection -");
            return true;
        }
        C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "section begin ongoing !!!");
        return false;
    }

    /* JADX INFO: renamed from: l */
    public synchronized boolean mo11957l() {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "endSection +");
        if (!this.f13083c && !this.f13086f) {
            C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "not started !!!");
            return false;
        }
        this.f13084d = false;
        this.f13098r.mo12011h();
        if (this.f13104x != null) {
            this.f13104x.pause();
        }
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "endSection -");
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m11946a(InterfaceC2172uu interfaceC2172uu) {
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "concatSections +");
        if (!C2189vk.m11979a().m11986b()) {
            C2201vw.f13213b.m12052c("unauthorized !");
            this.f13094n.m11923a(8);
            if (interfaceC2172uu != null) {
                interfaceC2172uu.mo7646b(8);
                return;
            }
            return;
        }
        if (this.f13083c) {
            C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "cannot concat sections while readying !!!");
            this.f13094n.m11923a(1);
            if (interfaceC2172uu != null) {
                interfaceC2172uu.mo7646b(1);
                return;
            }
            return;
        }
        if (this.f13086f) {
            this.f13100t = true;
            this.f13102v = interfaceC2172uu;
            mo11957l();
        } else {
            this.f13092l.m11931a(interfaceC2172uu);
        }
        C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "concatSections -");
    }

    /* JADX INFO: renamed from: a */
    public final void m11945a(InterfaceC2163ul interfaceC2163ul) {
        this.f13093m = interfaceC2163ul;
    }

    @Override // p000.InterfaceC2152ua
    /* JADX INFO: renamed from: a */
    public void mo11749a(int i) {
        if (this.f13099s != null) {
            this.f13099s.mo11749a(i);
        }
    }

    @Override // p000.InterfaceC2152ua
    /* JADX INFO: renamed from: a */
    public void mo11750a(byte[] bArr, long j) {
        if (this.f13081a && !this.f13082b) {
            this.f13082b = true;
            m11958m();
        }
        if (this.f13099s != null) {
            this.f13099s.mo11750a(bArr, j);
        }
        if (mo11953h()) {
            if (this.f13079E >= this.f13088h.m11788a()) {
                C2201vw.f13215d.m12054d("ShortAudioRecorderCore", "reached the max record duration");
                mo11957l();
                m11961p();
            } else {
                if (this.f13080F == -1) {
                    this.f13079E += (long) (1024000 / this.f13090j.m11744b());
                } else {
                    this.f13079E += (j - this.f13080F) / 1000000;
                }
                this.f13080F = j;
                ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
                this.f13103w.m11909a(byteBufferWrap, byteBufferWrap.remaining(), j / 1000);
            }
        }
    }

    /* JADX INFO: renamed from: m */
    protected synchronized void m11958m() {
        if (mo11952g()) {
            this.f13081a = false;
            C2201vw.f13215d.m12053c("ShortAudioRecorderCore", "sources are set, we are ready now.");
            if (this.f13093m != null) {
                this.f13093m.mo7647c();
            }
        }
    }

    /* JADX INFO: renamed from: n */
    protected synchronized void m11959n() {
        if (!this.f13086f && mo11954i()) {
            C2201vw.f13225n.m12053c("ShortAudioRecorderCore", "formats are set, begin section now.");
            this.f13092l.m11934a(this.f13078D);
            this.f13086f = true;
            this.f13083c = false;
            if (this.f13093m != null) {
                this.f13093m.mo7649e();
            }
        }
    }

    /* JADX INFO: renamed from: o */
    protected synchronized void m11960o() {
        this.f13083c = false;
        if (this.f13086f && mo11955j()) {
            C2201vw.f13225n.m12053c("ShortAudioRecorderCore", "formats are unset, end section now.");
            this.f13092l.m11937b();
            this.f13086f = false;
            if (this.f13093m != null) {
                this.f13093m.mo7650f();
            }
            if (this.f13100t) {
                this.f13100t = false;
                this.f13092l.m11931a(this.f13102v);
            }
            this.f13103w.m11908a();
        }
    }

    @Override // p000.C2185vg.a
    /* JADX INFO: renamed from: a */
    public void mo11940a() {
        if (this.f13093m != null) {
            this.f13093m.mo7648d();
        }
    }

    @Override // p000.C2185vg.a
    /* JADX INFO: renamed from: a */
    public void mo11941a(long j, long j2, int i) {
        if (this.f13093m != null) {
            this.f13093m.mo7644a(j, j2, i);
        }
    }

    /* JADX INFO: renamed from: p */
    public void m11961p() {
        if (this.f13093m != null) {
            this.f13093m.mo7651g();
        }
        if (this.f13104x != null) {
            this.f13104x.pause();
            this.f13077C = true;
        }
    }
}
