package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicBoolean;
import org.apache.http.HttpException;

/* JADX INFO: compiled from: AbsChunkedChannel.java */
/* JADX INFO: loaded from: classes.dex */
abstract class aqw implements aqq {

    /* JADX INFO: renamed from: q */
    private static final char[] f4760q = {' '};

    /* JADX INFO: renamed from: f */
    protected volatile Context f4766f;

    /* JADX INFO: renamed from: h */
    private volatile aqs f4768h;

    /* JADX INFO: renamed from: k */
    private volatile String f4771k;

    /* JADX INFO: renamed from: l */
    private volatile int f4772l;

    /* JADX INFO: renamed from: m */
    private volatile String f4773m;

    /* JADX INFO: renamed from: i */
    private volatile Future<?> f4769i = null;

    /* JADX INFO: renamed from: j */
    private volatile Future<?> f4770j = null;

    /* JADX INFO: renamed from: a */
    protected volatile aqn f4761a = aqn.DISCONNECTED;

    /* JADX INFO: renamed from: b */
    protected volatile InputStream f4762b = null;

    /* JADX INFO: renamed from: c */
    protected volatile int f4763c = -1;

    /* JADX INFO: renamed from: d */
    protected volatile boolean f4764d = true;

    /* JADX INFO: renamed from: e */
    protected volatile long f4765e = -1;

    /* JADX INFO: renamed from: n */
    private volatile int f4774n = -1;

    /* JADX INFO: renamed from: o */
    private volatile Object f4775o = null;

    /* JADX INFO: renamed from: g */
    private volatile ThreadPoolExecutor f4767g = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    /* JADX INFO: renamed from: p */
    private AtomicBoolean f4776p = new AtomicBoolean(false);

    @Override // p000.aqq
    @Deprecated
    /* JADX INFO: renamed from: a */
    public final int mo5114a(String str, byte[] bArr, aqr aqrVar) {
        return -1;
    }

    /* JADX INFO: renamed from: a */
    protected abstract void mo5134a(String str, Map<String, String> map);

    @Override // p000.aqq
    @Deprecated
    /* JADX INFO: renamed from: b */
    public final long mo5117b() {
        return -1L;
    }

    /* JADX INFO: renamed from: f */
    protected abstract void mo5135f();

    /* JADX INFO: renamed from: g */
    protected abstract void mo5136g();

    /* JADX INFO: renamed from: a */
    public final void m5145a(boolean z) {
        this.f4776p.set(z);
    }

    /* JADX INFO: renamed from: h */
    public final boolean m5147h() {
        return this.f4776p.get();
    }

    /* JADX INFO: renamed from: i */
    protected final void m5148i() {
        m5145a(false);
        this.f4774n = new Random().nextInt(10000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public final void m5139s() {
        this.f4774n = -1;
    }

    /* JADX INFO: renamed from: j */
    protected final int m5149j() {
        return this.f4774n;
    }

    /* JADX INFO: renamed from: a */
    private final void m5137a(Context context) {
        try {
            ahp ahpVar = new ahp(context);
            if (ahpVar.m1239a()) {
                this.f4771k = ahpVar.m1242d();
                this.f4772l = ahpVar.m1243e();
            } else {
                this.f4771k = null;
                this.f4772l = -1;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: a */
    public final void mo5116a(Object obj, Context context, final String str, final Map<String, String> map, final long j, aqs aqsVar, String str2) {
        this.f4766f = this.f4766f;
        try {
            SharedPreferences.Editor editorEdit = this.f4766f.getSharedPreferences("AppStore", 4).edit();
            editorEdit.putString("agoo_connect_type", "httpchunk");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
        if (aqsVar == null) {
            aiv.m1418c("HttpChunked", "eventHandler == null ");
            return;
        }
        if (this.f4761a == aqn.OPEN || this.f4761a == aqn.CONNECTING) {
            aiv.m1418c("HttpChunked", "http chunked connect url: [" + str + "] connectId:[" + m5149j() + "] connecting......");
            return;
        }
        this.f4775o = obj;
        m5137a(context);
        this.f4768h = aqsVar;
        this.f4761a = aqn.CONNECTING;
        this.f4769i = this.f4767g.submit(new Runnable() { // from class: aqw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aqw.this.m5148i();
                    aqw.this.mo5134a(str, map);
                } catch (Throwable unused2) {
                }
            }
        });
        this.f4770j = this.f4767g.submit(new Runnable() { // from class: aqw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    SystemClock.sleep(j);
                } catch (Throwable unused2) {
                }
                if (aqw.this.f4761a != aqn.CONNECTING || aqw.this.m5147h()) {
                    return;
                }
                aqw.this.m5145a(true);
                aqw.this.m5142a(aql.HTTP_CONNECT_TIMEOUT, new HttpException("connectId:[" + aqw.this.m5149j() + "] http Status code==" + aql.HTTP_CONNECT_TIMEOUT.m5028b()));
                aqw.this.m5139s();
                aqw.this.m5153n();
            }
        });
    }

    @Deprecated
    /* JADX INFO: renamed from: k */
    public final void m5150k() {
        aiv.m1418c("HttpChunked", "http chunked disconnect(" + m5149j() + ")");
        if (m5140t()) {
            aiv.m1418c("HttpChunked", "http chunked connect[" + m5149j() + "] connection has been closed");
            return;
        }
        this.f4761a = aqn.DISCONNECTING;
        try {
            m5152m();
            m5153n();
            aiv.m1418c("HttpChunked", "http chunked connect[" + m5149j() + "] connection disconnecting");
            mo5136g();
            aiv.m1418c("HttpChunked", "http chunked connect[" + m5149j() + "] connection disconnected");
            m5154o();
        } catch (Throwable unused) {
        }
        this.f4761a = aqn.DISCONNECTED;
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: a */
    public final void mo5115a() {
        aiv.m1418c("HttpChunked", "http chunked disconnect(" + m5149j() + ")");
        if (m5140t()) {
            aiv.m1418c("HttpChunked", "http chunked connect[" + m5149j() + "] connection has been closed");
            return;
        }
        this.f4761a = aqn.DISCONNECTING;
        this.f4767g.submit(new Runnable() { // from class: aqw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    aqw.this.m5152m();
                    aqw.this.m5153n();
                    aiv.m1418c("HttpChunked", "http chunked connect[" + aqw.this.m5149j() + "] connection disconnecting");
                    aqw.this.mo5136g();
                    aiv.m1418c("HttpChunked", "http chunked connect[" + aqw.this.m5149j() + "] connection disconnected");
                    aqw.this.m5154o();
                } catch (Throwable unused) {
                }
            }
        });
        this.f4761a = aqn.DISCONNECTED;
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: e */
    public final aqn mo5120e() {
        return this.f4761a;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0095 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0016 A[SYNTHETIC] */
    /* JADX INFO: renamed from: l */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected final void m5151l() {
        /*
            Method dump skipped, instruction units count: 320
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.aqw.m5151l():void");
    }

    /* JADX INFO: renamed from: m */
    protected final void m5152m() {
        if (this.f4770j != null) {
            this.f4770j.cancel(true);
        }
    }

    /* JADX INFO: renamed from: n */
    protected final void m5153n() {
        if (this.f4769i != null) {
            this.f4769i.cancel(true);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m5146a(char[] cArr) {
        if (this.f4768h == null || cArr.length != 1) {
            return;
        }
        this.f4768h.mo1229a(this.f4775o, 2L);
    }

    /* JADX INFO: renamed from: a */
    protected final void m5144a(String str) {
        this.f4768h.mo1232a(this.f4775o, this.f4774n, this.f4773m, str.getBytes());
    }

    /* JADX INFO: renamed from: a */
    protected final void m5141a(long j, Map<String, String> map) {
        if (this.f4768h != null) {
            this.f4761a = aqn.OPEN;
            this.f4768h.mo1230a(this.f4775o, this.f4774n, j, map);
        }
    }

    /* JADX INFO: renamed from: t */
    private final boolean m5140t() {
        return this.f4761a == aqn.DISCONNECTING || this.f4761a == aqn.DISCONNECTED;
    }

    /* JADX INFO: renamed from: o */
    protected final void m5154o() {
        if (!(this.f4768h == null && m5140t()) && this.f4761a == aqn.OPEN) {
            this.f4768h.mo1233b(this.f4775o, this.f4774n);
        }
    }

    /* JADX INFO: renamed from: a */
    protected final void m5142a(aql aqlVar, Throwable th) {
        m5150k();
        m5143a(aqlVar, new HashMap(), th);
    }

    /* JADX INFO: renamed from: a */
    protected final void m5143a(aql aqlVar, Map<String, String> map, Throwable th) {
        m5150k();
        if (this.f4768h != null) {
            this.f4768h.mo1231a(this.f4775o, this.f4774n, aqlVar, map, th);
        }
    }

    /* JADX INFO: renamed from: p */
    protected final String m5155p() {
        return this.f4771k;
    }

    /* JADX INFO: renamed from: q */
    protected final int m5156q() {
        return this.f4772l;
    }

    /* JADX INFO: renamed from: r */
    protected final boolean m5157r() {
        return (this.f4771k == null || this.f4772l == -1) ? false : true;
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: d */
    public final void mo5119d() {
        try {
            this.f4767g.submit(new Runnable() { // from class: aqw.4
                @Override // java.lang.Runnable
                public void run() {
                    aqw.this.mo5118c();
                }
            });
            if (this.f4767g == null || !this.f4767g.isShutdown()) {
                return;
            }
            this.f4767g.shutdownNow();
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aqq
    /* JADX INFO: renamed from: c */
    public final void mo5118c() {
        try {
            m5150k();
            aiv.m1418c("HttpChunked", "http chunked closing");
            mo5135f();
            aiv.m1418c("HttpChunked", "http chunked closed");
            m5139s();
        } catch (Throwable unused) {
        }
    }
}
