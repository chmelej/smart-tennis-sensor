package p000;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: mj */
/* JADX INFO: compiled from: TimeUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class C1911mj {

    /* JADX INFO: renamed from: d */
    public Thread f11498d;

    /* JADX INFO: renamed from: g */
    private a f11501g;

    /* JADX INFO: renamed from: a */
    public long f11495a = 0;

    /* JADX INFO: renamed from: b */
    public long f11496b = 0;

    /* JADX INFO: renamed from: c */
    public long f11497c = 0;

    /* JADX INFO: renamed from: e */
    public boolean f11499e = false;

    /* JADX INFO: renamed from: f */
    public Handler f11500f = new Handler() { // from class: mj.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (C1911mj.this.f11501g != null) {
                C1911mj.this.f11501g.mo7089a();
            }
        }
    };

    /* JADX INFO: renamed from: mj$a */
    /* JADX INFO: compiled from: TimeUtil.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7089a();
    }

    /* JADX INFO: renamed from: a */
    public void m10530a(a aVar) {
        this.f11501g = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m10529a() {
        if (this.f11498d == null) {
            this.f11496b = System.currentTimeMillis();
            this.f11498d = new Thread() { // from class: mj.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (C1911mj.this.f11499e) {
                            if (C1911mj.this.f11496b != System.currentTimeMillis()) {
                                C1911mj.this.f11495a = (C1911mj.this.f11497c + System.currentTimeMillis()) - C1911mj.this.f11496b;
                            }
                            C1911mj.this.f11500f.sendMessage(new Message());
                        }
                    }
                }
            };
            this.f11498d.start();
        }
        if (this.f11501g != null) {
            this.f11501g.mo7089a();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10531b() {
        this.f11499e = false;
        this.f11500f.removeCallbacks(this.f11498d);
    }

    /* JADX INFO: renamed from: a */
    public static String m10526a(long j) {
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 % 3600) / 60;
        String strSubstring = ("00" + j3).substring(("00" + j3).length() - 2);
        String strSubstring2 = ("00" + j4).substring(("00" + j4).length() - 2);
        return ("00" + (j2 / 3600)).substring(("00" + r8).length() - 2) + ":" + strSubstring2 + ":" + strSubstring;
    }

    /* JADX INFO: renamed from: b */
    public static String m10528b(long j) {
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 % 3600) / 60;
        String strSubstring = ("00" + j3).substring(("00" + j3).length() - 2);
        String strSubstring2 = ("00" + j4).substring(("00" + j4).length() - 2);
        ("00" + (j2 / 3600)).substring(("00" + r8).length() - 2);
        return strSubstring2 + ":" + strSubstring;
    }
}
