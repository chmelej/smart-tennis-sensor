package p000;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: renamed from: yb */
/* JADX INFO: compiled from: Stats.java */
/* JADX INFO: loaded from: classes.dex */
class C2261yb {

    /* JADX INFO: renamed from: a */
    final HandlerThread f13658a = new HandlerThread("Picasso-Stats", 10);

    /* JADX INFO: renamed from: b */
    final InterfaceC2237xe f13659b;

    /* JADX INFO: renamed from: c */
    final Handler f13660c;

    /* JADX INFO: renamed from: d */
    long f13661d;

    /* JADX INFO: renamed from: e */
    long f13662e;

    /* JADX INFO: renamed from: f */
    long f13663f;

    /* JADX INFO: renamed from: g */
    long f13664g;

    /* JADX INFO: renamed from: h */
    long f13665h;

    /* JADX INFO: renamed from: i */
    long f13666i;

    /* JADX INFO: renamed from: j */
    long f13667j;

    /* JADX INFO: renamed from: k */
    long f13668k;

    /* JADX INFO: renamed from: l */
    int f13669l;

    /* JADX INFO: renamed from: m */
    int f13670m;

    /* JADX INFO: renamed from: n */
    int f13671n;

    C2261yb(InterfaceC2237xe interfaceC2237xe) {
        this.f13659b = interfaceC2237xe;
        this.f13658a.start();
        C2265yf.m12391a(this.f13658a.getLooper());
        this.f13660c = new a(this.f13658a.getLooper(), this);
    }

    /* JADX INFO: renamed from: a */
    void m12365a(Bitmap bitmap) {
        m12362a(bitmap, 2);
    }

    /* JADX INFO: renamed from: b */
    void m12369b(Bitmap bitmap) {
        m12362a(bitmap, 3);
    }

    /* JADX INFO: renamed from: a */
    void m12364a(long j) {
        this.f13660c.sendMessage(this.f13660c.obtainMessage(4, Long.valueOf(j)));
    }

    /* JADX INFO: renamed from: a */
    void m12363a() {
        this.f13660c.sendEmptyMessage(0);
    }

    /* JADX INFO: renamed from: b */
    void m12367b() {
        this.f13660c.sendEmptyMessage(1);
    }

    /* JADX INFO: renamed from: c */
    void m12370c() {
        this.f13661d++;
    }

    /* JADX INFO: renamed from: d */
    void m12372d() {
        this.f13662e++;
    }

    /* JADX INFO: renamed from: a */
    void m12366a(Long l) {
        this.f13669l++;
        this.f13663f += l.longValue();
        this.f13666i = m12361a(this.f13669l, this.f13663f);
    }

    /* JADX INFO: renamed from: b */
    void m12368b(long j) {
        this.f13670m++;
        this.f13664g += j;
        this.f13667j = m12361a(this.f13670m, this.f13664g);
    }

    /* JADX INFO: renamed from: c */
    void m12371c(long j) {
        this.f13671n++;
        this.f13665h += j;
        this.f13668k = m12361a(this.f13670m, this.f13665h);
    }

    /* JADX INFO: renamed from: e */
    C2262yc m12373e() {
        return new C2262yc(this.f13659b.mo12253b(), this.f13659b.mo12250a(), this.f13661d, this.f13662e, this.f13663f, this.f13664g, this.f13665h, this.f13666i, this.f13667j, this.f13668k, this.f13669l, this.f13670m, this.f13671n, System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: a */
    private void m12362a(Bitmap bitmap, int i) {
        this.f13660c.sendMessage(this.f13660c.obtainMessage(i, C2265yf.m12380a(bitmap), 0));
    }

    /* JADX INFO: renamed from: a */
    private static long m12361a(int i, long j) {
        return j / ((long) i);
    }

    /* JADX INFO: renamed from: yb$a */
    /* JADX INFO: compiled from: Stats.java */
    static class a extends Handler {

        /* JADX INFO: renamed from: a */
        private final C2261yb f13672a;

        public a(Looper looper, C2261yb c2261yb) {
            super(looper);
            this.f13672a = c2261yb;
        }

        @Override // android.os.Handler
        public void handleMessage(final Message message) {
            switch (message.what) {
                case 0:
                    this.f13672a.m12370c();
                    break;
                case 1:
                    this.f13672a.m12372d();
                    break;
                case 2:
                    this.f13672a.m12368b(message.arg1);
                    break;
                case 3:
                    this.f13672a.m12371c(message.arg1);
                    break;
                case 4:
                    this.f13672a.m12366a((Long) message.obj);
                    break;
                default:
                    C2253xu.f13555a.post(new Runnable() { // from class: yb.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            throw new AssertionError("Unhandled stats message." + message.what);
                        }
                    });
                    break;
            }
        }
    }
}
