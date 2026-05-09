package p000;

import java.nio.ByteBuffer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: vs */
/* JADX INFO: compiled from: SWEncoderBase.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2197vs extends AbstractC2193vo {

    /* JADX INFO: renamed from: f */
    private static final boolean f13184f = C2202vx.m12056a().m12061c();

    /* JADX INFO: renamed from: e */
    protected ByteBuffer f13185e;

    /* JADX INFO: renamed from: i */
    private int f13188i;

    /* JADX INFO: renamed from: g */
    private LinkedBlockingQueue f13186g = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: h */
    private LinkedBlockingQueue f13187h = new LinkedBlockingQueue();

    /* JADX INFO: renamed from: j */
    private Object f13189j = new Object();

    /* JADX INFO: renamed from: k */
    private C2203vy f13190k = new C2203vy();

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo8628a(ByteBuffer byteBuffer, byte[] bArr, int i, long j);

    /* JADX INFO: renamed from: d */
    protected abstract boolean mo8631d();

    /* JADX INFO: renamed from: e */
    protected abstract boolean mo8632e();

    /* JADX INFO: renamed from: f */
    protected abstract boolean mo8633f();

    /* JADX INFO: renamed from: g */
    protected abstract boolean mo8634g();

    /* JADX INFO: renamed from: vs$a */
    /* JADX INFO: compiled from: SWEncoderBase.java */
    class a {

        /* JADX INFO: renamed from: a */
        public ByteBuffer f13191a;

        /* JADX INFO: renamed from: b */
        public int f13192b;

        /* JADX INFO: renamed from: c */
        public long f13193c;

        public a(ByteBuffer byteBuffer, int i, long j) {
            this.f13191a = byteBuffer;
            this.f13192b = i;
            this.f13193c = j;
        }
    }

    @Override // p000.AbstractC2193vo
    /* JADX INFO: renamed from: a */
    public boolean mo12008a(long j) {
        C2201vw.f13219h.m12054d(mo8629b(), "unimplemented !");
        return false;
    }

    @Override // p000.AbstractC2193vo
    /* JADX INFO: renamed from: a */
    public boolean mo12009a(ByteBuffer byteBuffer, int i, long j) {
        int iM12065b;
        if (!f13184f || m12085l()) {
            C2201vw.f13219h.m12054d(mo8629b(), "stop is marked, not accepting anymore frames.");
            return false;
        }
        long jB = m12010b(j);
        if (jB < 0) {
            return false;
        }
        ByteBuffer byteBufferAllocate = null;
        synchronized (this.f13189j) {
            if (this.f13188i != i) {
                C2201vw.f13219h.m12053c(mo8629b(), "buffer size changed from " + this.f13188i + " to " + i + ", reallocate now.");
                this.f13188i = i;
                this.f13190k.m12063a();
                this.f13190k.m12064a(this.f13188i, 6);
            }
            iM12065b = this.f13190k.m12065b();
            if (iM12065b >= 0) {
                byteBufferAllocate = this.f13190k.m12062a(iM12065b);
                C2201vw.f13219h.m12051b(mo8629b(), "found a buffer to reuse, index: " + iM12065b);
            }
        }
        if (byteBufferAllocate == null) {
            byteBufferAllocate = ByteBuffer.allocate(byteBuffer.capacity());
            C2201vw.f13219h.m12054d(mo8629b(), "cannot find a buffer to reuse, allocate a tmp one.");
        }
        ByteBuffer byteBuffer2 = byteBufferAllocate;
        byteBuffer2.put(byteBuffer);
        C2201vw.f13219h.m12051b(mo8629b(), "input frame, size =  " + i + ", ts = " + jB);
        this.f13187h.add(Integer.valueOf(iM12065b));
        this.f13186g.add(new a(byteBuffer2, i, jB));
        m12012i();
        C2201vw.f13219h.m12051b(mo8629b(), "input frame done, num = " + this.f13186g.size());
        return true;
    }

    @Override // p000.AbstractC2193vo, p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: b_ */
    public boolean mo12002b_() {
        C2201vw.f13219h.m12053c(mo8629b(), "start +");
        if (!f13184f) {
            C2201vw.f13219h.m12055e(mo8629b(), "start failed !");
            return false;
        }
        this.f13188i = 0;
        C2201vw.f13219h.m12053c(mo8629b(), "start -");
        return super.mo12002b_();
    }

    @Override // p000.AbstractC2193vo, p000.AbstractRunnableC2206wa
    /* JADX INFO: renamed from: h */
    public boolean mo12011h() {
        C2201vw.f13219h.m12053c(mo8629b(), "stop +");
        if (!f13184f) {
            C2201vw.f13219h.m12055e(mo8629b(), "encode thread not started !");
            return false;
        }
        C2201vw.f13219h.m12053c(mo8629b(), "stop -");
        return super.mo12011h();
    }

    @Override // java.lang.Runnable
    public void run() {
        C2201vw.f13219h.m12053c(mo8629b(), "run +");
        if (!mo8631d() || !mo8633f()) {
            C2201vw.f13219h.m12055e(mo8629b(), "start failed !");
            if (this.f13172d != null) {
                this.f13172d.mo11966a(false);
                return;
            }
            return;
        }
        if (this.f13172d != null) {
            this.f13172d.mo11966a(true);
        }
        while (true) {
            if (m12085l() && !m12014k()) {
                break;
            } else {
                m12021m();
            }
        }
        mo8634g();
        mo8632e();
        if (this.f13172d != null) {
            this.f13172d.mo11962a();
        }
        C2201vw.f13219h.m12053c(mo8629b(), "run -");
    }

    /* JADX INFO: renamed from: m */
    private void m12021m() {
        a aVar;
        C2201vw.f13219h.m12051b(mo8629b(), "wait for frames");
        try {
            aVar = (a) this.f13186g.poll(1000L, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            aVar = null;
        }
        if (aVar == null || aVar.f13191a == null) {
            return;
        }
        C2201vw.f13219h.m12051b(mo8629b(), "do encode frames, size = " + aVar.f13192b + ", ts = " + aVar.f13193c);
        if (this.f13185e == null) {
            this.f13185e = ByteBuffer.allocateDirect(aVar.f13192b);
        }
        this.f13185e.rewind();
        mo8628a(this.f13185e, aVar.f13191a.array(), aVar.f13192b, aVar.f13193c);
        synchronized (this.f13189j) {
            int iIntValue = ((Integer) this.f13187h.poll()).intValue();
            if (iIntValue >= 0) {
                this.f13190k.m12066b(iIntValue);
                C2201vw.f13219h.m12051b(mo8629b(), "buffer use done, return back " + iIntValue);
            } else {
                C2201vw.f13219h.m12054d(mo8629b(), "leave the tmp buffer to gc");
            }
        }
    }
}
