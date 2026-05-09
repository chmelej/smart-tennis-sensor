package p000;

import android.os.Handler;
import android.os.Message;

/* JADX INFO: renamed from: qb */
/* JADX INFO: compiled from: TimeUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class C2045qb {

    /* JADX INFO: renamed from: d */
    public Thread f12265d;

    /* JADX INFO: renamed from: g */
    private a f12268g;

    /* JADX INFO: renamed from: a */
    public long f12262a = 0;

    /* JADX INFO: renamed from: b */
    public long f12263b = 0;

    /* JADX INFO: renamed from: c */
    public long f12264c = 0;

    /* JADX INFO: renamed from: e */
    public boolean f12266e = false;

    /* JADX INFO: renamed from: f */
    public Handler f12267f = new Handler() { // from class: qb.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (C2045qb.this.f12268g != null) {
                C2045qb.this.f12268g.mo8366a();
            }
        }
    };

    /* JADX INFO: renamed from: qb$a */
    /* JADX INFO: compiled from: TimeUtil.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo8366a();
    }

    /* JADX INFO: renamed from: a */
    public void m11167a(a aVar) {
        this.f12268g = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m11166a() {
        if (this.f12265d == null) {
            this.f12263b = System.currentTimeMillis();
            this.f12265d = new Thread() { // from class: qb.2
                @Override // java.lang.Thread, java.lang.Runnable
                public void run() {
                    while (true) {
                        try {
                            Thread.sleep(300L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (C2045qb.this.f12266e) {
                            if (C2045qb.this.f12263b != System.currentTimeMillis()) {
                                C2045qb.this.f12262a = (C2045qb.this.f12264c + System.currentTimeMillis()) - C2045qb.this.f12263b;
                            }
                            C2045qb.this.f12267f.sendMessage(new Message());
                        }
                    }
                }
            };
            this.f12265d.start();
        }
        if (this.f12268g != null) {
            this.f12268g.mo8366a();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11168b() {
        this.f12266e = false;
        this.f12267f.removeCallbacks(this.f12265d);
    }

    /* JADX INFO: renamed from: a */
    public String m11165a(long j) {
        long j2 = j / 1000;
        long j3 = j2 % 60;
        long j4 = (j2 % 3600) / 60;
        String strSubstring = ("00" + j3).substring(("00" + j3).length() - 2);
        String strSubstring2 = ("00" + j4).substring(("00" + j4).length() - 2);
        return ("00" + (j2 / 3600)).substring(("00" + r9).length() - 2) + ":" + strSubstring2 + ":" + strSubstring;
    }
}
