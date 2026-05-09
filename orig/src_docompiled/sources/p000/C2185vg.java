package p000;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Stack;

/* JADX INFO: renamed from: vg */
/* JADX INFO: compiled from: SectionManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C2185vg {

    /* JADX INFO: renamed from: a */
    private C2226wu f13052a;

    /* JADX INFO: renamed from: b */
    private Context f13053b;

    /* JADX INFO: renamed from: c */
    private Stack<C2184vf> f13054c;

    /* JADX INFO: renamed from: d */
    private C2184vf f13055d;

    /* JADX INFO: renamed from: e */
    private File f13056e;

    /* JADX INFO: renamed from: f */
    private MediaFormat f13057f;

    /* JADX INFO: renamed from: g */
    private MediaFormat f13058g;

    /* JADX INFO: renamed from: h */
    private volatile boolean f13059h;

    /* JADX INFO: renamed from: i */
    private C2162uk f13060i;

    /* JADX INFO: renamed from: j */
    private C2169ur f13061j;

    /* JADX INFO: renamed from: k */
    private C2150tz f13062k;

    /* JADX INFO: renamed from: l */
    private long f13063l;

    /* JADX INFO: renamed from: m */
    private int f13064m;

    /* JADX INFO: renamed from: n */
    private int f13065n;

    /* JADX INFO: renamed from: o */
    private long f13066o;

    /* JADX INFO: renamed from: p */
    private long f13067p;

    /* JADX INFO: renamed from: q */
    private a f13068q;

    /* JADX INFO: renamed from: r */
    private InterfaceC2172uu f13069r;

    /* JADX INFO: renamed from: s */
    private volatile boolean f13070s;

    /* JADX INFO: renamed from: t */
    private String f13071t;

    /* JADX INFO: renamed from: u */
    private C2183ve f13072u;

    /* JADX INFO: renamed from: v */
    private double f13073v;

    /* JADX INFO: renamed from: vg$a */
    /* JADX INFO: compiled from: SectionManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo11940a();

        /* JADX INFO: renamed from: a */
        void mo11941a(long j, long j2, int i);
    }

    public C2185vg(Context context, C2162uk c2162uk, C2150tz c2150tz) {
        this.f13054c = new Stack<>();
        this.f13059h = false;
        this.f13063l = 0L;
        this.f13066o = -1L;
        this.f13067p = -1L;
        this.f13071t = null;
        this.f13053b = context.getApplicationContext();
        this.f13072u = C2183ve.m11912a(this.f13053b);
        this.f13060i = c2162uk;
        this.f13062k = c2150tz;
        this.f13056e = this.f13060i.m11793b();
        if (this.f13056e == null || (!this.f13056e.exists() && !this.f13056e.mkdirs())) {
            this.f13056e = context.getFilesDir();
        }
        if (this.f13060i.m11795c() == null) {
            this.f13060i.m11794b(new File(this.f13056e, "pl-concated-" + System.currentTimeMillis() + ".mp4").getAbsolutePath());
            return;
        }
        this.f13060i.m11794b(C2187vi.m11967a(context, this.f13060i.m11795c()));
    }

    public C2185vg(Context context, C2162uk c2162uk, C2150tz c2150tz, C2169ur c2169ur) {
        this(context, c2162uk, c2150tz);
        this.f13061j = c2169ur;
    }

    /* JADX INFO: renamed from: e */
    private long m11927e() {
        int i;
        int iM11744b;
        if (m11928f()) {
            i = 1000;
            iM11744b = this.f13061j.m11830c();
        } else {
            i = 1024000;
            iM11744b = this.f13062k.m11744b();
        }
        return i / iM11744b;
    }

    /* JADX INFO: renamed from: a */
    public void m11929a(MediaFormat mediaFormat) {
        this.f13058g = mediaFormat;
    }

    /* JADX INFO: renamed from: b */
    public void m11935b(MediaFormat mediaFormat) {
        this.f13057f = mediaFormat;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11933a() {
        return (this.f13057f == null || (this.f13058g == null && m11928f())) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    private boolean m11928f() {
        return this.f13061j != null;
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m11934a(String str) {
        if (this.f13059h) {
            C2201vw.f13225n.m12055e("SectionManager", "begin section failed, in working state");
            return false;
        }
        C2201vw.f13225n.m12053c("SectionManager", "begin section +");
        if (!m11933a()) {
            C2201vw.f13225n.m12055e("SectionManager", "beginSection failed, format not set !");
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        File file = this.f13056e;
        if (str == null) {
            str = "pl-section-" + jCurrentTimeMillis + ".mp4";
        }
        File file2 = new File(file, str);
        this.f13052a = new C2226wu();
        if (!this.f13052a.m12168a(file2.getAbsolutePath(), this.f13058g, this.f13057f)) {
            C2201vw.f13225n.m12055e("SectionManager", "beginSection failed, start failed !");
            return false;
        }
        this.f13055d = new C2184vf();
        this.f13055d.f13045a = file2;
        this.f13055d.f13047c = this.f13052a.m12170b();
        this.f13055d.f13046b = this.f13052a.m12172c();
        this.f13059h = true;
        C2201vw.f13225n.m12053c("SectionManager", "begin section - " + file2);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m11937b() {
        if (this.f13059h && this.f13055d != null) {
            boolean z = this.f13055d.f13050f > 0 && (this.f13055d.f13051g > 0 || !m11928f());
            if (this.f13052a.m12167a() && z) {
                C2201vw.f13225n.m12053c("SectionManager", "end section +");
                this.f13055d.f13048d = this.f13066o;
                this.f13055d.f13049e = (this.f13067p - this.f13066o) + m11927e();
                this.f13066o = -1L;
                this.f13067p = -1L;
                this.f13063l += this.f13055d.f13049e;
                this.f13054c.push(this.f13055d);
                C2201vw.f13225n.m12053c("SectionManager", "end section - " + this.f13055d.f13045a + ", " + this.f13055d.f13049e + "Ms");
                if (this.f13068q != null) {
                    this.f13068q.mo11941a(this.f13055d.f13049e, this.f13063l, this.f13054c.size());
                }
            } else {
                C2201vw.f13225n.m12054d("SectionManager", "end section failed, so no data saved !!!");
                if (this.f13068q != null) {
                    this.f13068q.mo11940a();
                }
            }
            this.f13059h = false;
            return true;
        }
        C2201vw.f13225n.m12055e("SectionManager", "end section failed, not in working state");
        return false;
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m11938c() {
        if (this.f13059h) {
            C2201vw.f13225n.m12054d("SectionManager", "mIsWorking, cannot delete !!!");
            return false;
        }
        Stack<C2184vf> stack = this.f13071t == null ? new Stack<>() : C2199vu.m12032a(this.f13053b).m12035a(this.f13071t).m12031b();
        C2201vw.f13225n.m12053c("SectionManager", "clear sections +");
        for (C2184vf c2184vf : this.f13054c) {
            if (!stack.contains(c2184vf)) {
                if (c2184vf.f13045a.delete()) {
                    C2201vw.f13225n.m12053c("SectionManager", "deleted section:" + c2184vf.f13045a);
                } else {
                    C2201vw.f13225n.m12055e("SectionManager", "deleted section failed:" + c2184vf.f13045a);
                }
            }
        }
        this.f13054c.clear();
        this.f13063l = 0L;
        C2201vw.f13225n.m12053c("SectionManager", "clear sections -");
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m11932a(a aVar) {
        this.f13068q = aVar;
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11930a(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f13059h) {
            C2201vw.f13225n.m12051b("SectionManager", "video write to muxer size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
            m11926a(bufferInfo.presentationTimeUs / 1000);
            this.f13052a.m12166a(byteBuffer, bufferInfo);
            C2184vf c2184vf = this.f13055d;
            c2184vf.f13051g = c2184vf.f13051g + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized void m11936b(ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        if (this.f13059h) {
            C2201vw.f13225n.m12051b("SectionManager", "audio write to muxer size:" + bufferInfo.size + " ts:" + bufferInfo.presentationTimeUs);
            m11926a(bufferInfo.presentationTimeUs / 1000);
            this.f13052a.m12171b(byteBuffer, bufferInfo);
            C2184vf c2184vf = this.f13055d;
            c2184vf.f13050f = c2184vf.f13050f + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11926a(long j) {
        long j2 = (long) (j * this.f13073v);
        if (this.f13066o == -1) {
            this.f13066o = j2;
        }
        if (j2 > this.f13067p) {
            this.f13067p = j2;
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11931a(InterfaceC2172uu interfaceC2172uu) {
        this.f13070s = false;
        this.f13069r = interfaceC2172uu;
        new Thread(new Runnable() { // from class: vg.1
            @Override // java.lang.Runnable
            public void run() {
                C2185vg.this.m11939d();
            }
        }).start();
    }

    /* JADX INFO: renamed from: d */
    public synchronized void m11939d() {
        String str;
        long j;
        StringBuilder sb;
        if (this.f13054c.isEmpty()) {
            C2201vw.f13225n.m12054d("SectionManager", "no section exist to concat");
            if (this.f13069r != null) {
                this.f13069r.mo7646b(2);
                this.f13072u.m11923a(2);
            }
            return;
        }
        String strM11795c = this.f13060i.m11795c();
        C2201vw.f13225n.m12053c("SectionManager", "concat sections + to: " + strM11795c);
        C2226wu c2226wu = new C2226wu();
        c2226wu.m12168a(strM11795c, this.f13058g, this.f13057f);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(2097152);
        int i = 0;
        this.f13064m = 0;
        this.f13065n = 0;
        long j2 = 0;
        int i2 = 0;
        while (i2 < this.f13054c.size()) {
            C2184vf c2184vf = this.f13054c.get(i2);
            C2201vw.f13225n.m12053c("SectionManager", "concating section:" + c2184vf.f13045a);
            MediaExtractor mediaExtractor = new MediaExtractor();
            try {
                mediaExtractor.setDataSource(c2184vf.f13045a.getAbsolutePath());
                mediaExtractor.selectTrack(c2184vf.f13046b);
                if (c2184vf.f13047c >= 0) {
                    mediaExtractor.selectTrack(c2184vf.f13047c);
                }
                j = -1;
            } catch (IOException e) {
                str = strM11795c;
                C2201vw.f13225n.m12055e("SectionManager", e.getMessage());
            }
            while (!this.f13070s) {
                int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, i);
                C2201vw c2201vw = C2201vw.f13225n;
                StringBuilder sb2 = new StringBuilder();
                str = strM11795c;
                sb2.append("read sample size:");
                sb2.append(sampleData);
                c2201vw.m12051b("SectionManager", sb2.toString());
                if (sampleData < 0) {
                    C2201vw.f13225n.m12053c("SectionManager", "EOF, no more encoded samples.");
                    long jM11927e = j + (m11927e() * 1000);
                    mediaExtractor.release();
                    j2 = jM11927e;
                    i2++;
                    strM11795c = str;
                    i = 0;
                } else {
                    MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
                    bufferInfo.presentationTimeUs = mediaExtractor.getSampleTime() + j2;
                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                    bufferInfo.offset = 0;
                    bufferInfo.size = sampleData;
                    if (Build.VERSION.SDK_INT >= 21) {
                        byteBufferAllocateDirect.position(0);
                    }
                    j = bufferInfo.presentationTimeUs;
                    boolean z = mediaExtractor.getSampleTrackIndex() == c2184vf.f13047c;
                    c2226wu.m12165a(z ? c2226wu.m12170b() : c2226wu.m12172c(), byteBufferAllocateDirect, bufferInfo);
                    if (this.f13069r != null && (z || !m11928f())) {
                        this.f13069r.mo7642a((bufferInfo.presentationTimeUs / 1000.0f) / this.f13063l);
                    }
                    mediaExtractor.advance();
                    C2201vw c2201vw2 = C2201vw.f13225n;
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append("transferred ");
                    if (z) {
                        sb = new StringBuilder();
                        int i3 = this.f13065n + 1;
                        this.f13065n = i3;
                        sb.append(i3);
                        sb.append("th video");
                    } else {
                        sb = new StringBuilder();
                        int i4 = this.f13064m + 1;
                        this.f13064m = i4;
                        sb.append(i4);
                        sb.append("th audio");
                    }
                    sb3.append(sb.toString());
                    c2201vw2.m12051b("SectionManager", sb3.toString());
                    strM11795c = str;
                    i = 0;
                }
            }
            C2201vw.f13225n.m12053c("SectionManager", "concat canceled");
            mediaExtractor.release();
            c2226wu.m12167a();
            new File(strM11795c).delete();
            if (this.f13069r != null) {
                this.f13069r.mo7653i();
            }
            return;
        }
        String str2 = strM11795c;
        if (this.f13069r != null) {
            this.f13069r.mo7642a(1.0f);
        }
        if (c2226wu.m12167a()) {
            if (this.f13069r != null) {
                this.f13069r.mo7645a(str2);
            }
        } else if (this.f13069r != null) {
            this.f13069r.mo7646b(0);
            this.f13072u.m11923a(0);
        }
        C2201vw.f13225n.m12053c("SectionManager", "concat sections - total transferred audio frames: " + this.f13064m + " video frames: " + this.f13065n);
    }
}
