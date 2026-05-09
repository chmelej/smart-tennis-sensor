package p000;

import android.media.AudioRecord;
import java.util.Arrays;

/* JADX INFO: renamed from: vb */
/* JADX INFO: compiled from: AudioManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2180vb {

    /* JADX INFO: renamed from: a */
    private AudioRecord f13019a;

    /* JADX INFO: renamed from: b */
    private C2161uj f13020b;

    /* JADX INFO: renamed from: c */
    private int f13021c;

    /* JADX INFO: renamed from: d */
    private Thread f13022d;

    /* JADX INFO: renamed from: h */
    private byte[] f13026h;

    /* JADX INFO: renamed from: k */
    private InterfaceC2152ua f13029k;

    /* JADX INFO: renamed from: e */
    private boolean f13023e = false;

    /* JADX INFO: renamed from: f */
    private boolean f13024f = false;

    /* JADX INFO: renamed from: g */
    private volatile boolean f13025g = false;

    /* JADX INFO: renamed from: i */
    private long f13027i = 0;

    /* JADX INFO: renamed from: j */
    private long f13028j = 0;

    /* JADX INFO: renamed from: l */
    private final Runnable f13030l = new Runnable() { // from class: vb.1
        @Override // java.lang.Runnable
        public void run() {
            while (!C2180vb.this.f13025g) {
                if (C2180vb.this.f13026h == null) {
                    C2180vb.this.f13026h = new byte[C2180vb.this.f13021c * 1024 * 2];
                }
                int i = C2180vb.this.f13019a.read(C2180vb.this.f13026h, 0, C2180vb.this.f13026h.length);
                C2201vw.f13217f.m12049a("AudioManager", "audio frame read size:" + i);
                if (i < 0) {
                    C2180vb.this.m11896a(i);
                } else {
                    C2180vb.this.m11898a(C2180vb.this.f13026h);
                }
            }
        }
    };

    public C2180vb(C2161uj c2161uj) {
        this.f13020b = c2161uj;
    }

    /* JADX INFO: renamed from: a */
    public void m11905a(InterfaceC2152ua interfaceC2152ua) {
        this.f13029k = interfaceC2152ua;
    }

    /* JADX INFO: renamed from: a */
    public boolean m11906a() {
        C2201vw.f13217f.m12053c("AudioManager", "start audio recording +");
        if (this.f13023e) {
            C2201vw.f13217f.m12054d("AudioManager", "recording already started !");
            return false;
        }
        this.f13021c = this.f13020b.m11782c() == 12 ? 2 : 1;
        int minBufferSize = AudioRecord.getMinBufferSize(this.f13020b.m11779b(), this.f13020b.m11782c(), this.f13020b.m11784d());
        if (minBufferSize == -2) {
            C2201vw.f13217f.m12055e("AudioManager", "invalid parameter !");
            return false;
        }
        try {
            this.f13019a = new AudioRecord(this.f13020b.m11776a(), this.f13020b.m11779b(), this.f13020b.m11782c(), this.f13020b.m11784d(), minBufferSize * 4);
            if (this.f13019a.getState() == 0) {
                C2201vw.f13217f.m12055e("AudioManager", "AudioRecord initialize fail !");
                return false;
            }
            this.f13019a.startRecording();
            this.f13028j = 0L;
            this.f13027i = 0L;
            this.f13025g = false;
            this.f13022d = new Thread(this.f13030l);
            this.f13022d.setPriority(10);
            this.f13022d.start();
            this.f13023e = true;
            C2201vw.f13217f.m12053c("AudioManager", "start audio recording -");
            return true;
        } catch (IllegalArgumentException e) {
            C2201vw.f13217f.m12055e("AudioManager", "Create AudioRecord failed : " + e.getMessage());
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11907b() {
        C2201vw.f13217f.m12053c("AudioManager", "stop audio recording +");
        if (!this.f13023e) {
            C2201vw.f13217f.m12054d("AudioManager", "recording already stopped !");
            return;
        }
        this.f13025g = true;
        try {
            this.f13022d.interrupt();
            this.f13022d.join(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (this.f13019a.getRecordingState() == 3) {
            this.f13019a.stop();
        }
        this.f13019a.release();
        this.f13023e = false;
        C2201vw.f13217f.m12053c("AudioManager", "stop audio recording -");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11898a(byte[] bArr) {
        if (this.f13029k == null) {
            return;
        }
        if (this.f13024f) {
            Arrays.fill(bArr, (byte) 0);
        }
        this.f13029k.mo11750a(bArr, m11895a(System.nanoTime() / 1000, (bArr.length / this.f13021c) / 2) * 1000);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m11896a(int i) {
        C2201vw.f13217f.m12055e("AudioManager", "onAudioRecordFailed: " + i);
        if (this.f13029k != null) {
            this.f13029k.mo11749a(i);
        }
    }

    /* JADX INFO: renamed from: a */
    private long m11895a(long j, long j2) {
        if (!this.f13020b.m11786e()) {
            return j;
        }
        long jM11779b = (j2 * 1000000) / ((long) this.f13020b.m11779b());
        long j3 = j - jM11779b;
        if (this.f13028j == 0) {
            this.f13027i = j3;
            this.f13028j = 0L;
        }
        long jM11779b2 = this.f13027i + ((this.f13028j * 1000000) / ((long) this.f13020b.m11779b()));
        if (j3 - jM11779b2 >= jM11779b * 2) {
            this.f13027i = j3;
            this.f13028j = 0L;
            jM11779b2 = this.f13027i;
        }
        this.f13028j += j2;
        return jM11779b2;
    }
}
