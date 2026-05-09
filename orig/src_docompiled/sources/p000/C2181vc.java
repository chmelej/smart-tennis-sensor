package p000;

import java.nio.ByteBuffer;

/* JADX INFO: renamed from: vc */
/* JADX INFO: compiled from: AudioSpeedAdjustor.java */
/* JADX INFO: loaded from: classes.dex */
public class C2181vc {

    /* JADX INFO: renamed from: a */
    private ByteBuffer f13032a;

    /* JADX INFO: renamed from: b */
    private long f13033b = 0;

    /* JADX INFO: renamed from: c */
    private int f13034c = 0;

    /* JADX INFO: renamed from: d */
    private double f13035d = 1.0d;

    /* JADX INFO: renamed from: e */
    private a f13036e;

    /* JADX INFO: renamed from: vc$a */
    /* JADX INFO: compiled from: AudioSpeedAdjustor.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo11911a(ByteBuffer byteBuffer, int i, long j);
    }

    /* JADX INFO: renamed from: a */
    public void m11910a(a aVar) {
        this.f13036e = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m11908a() {
        this.f13032a = null;
        this.f13033b = 0L;
        this.f13034c = 0;
    }

    /* JADX INFO: renamed from: a */
    public void m11909a(ByteBuffer byteBuffer, int i, long j) {
        long j2;
        if (this.f13035d >= 1.0d) {
            int i2 = this.f13034c;
            this.f13034c = i2 + 1;
            if (((double) i2) % this.f13035d != 0.0d || this.f13036e == null) {
                return;
            }
            this.f13036e.mo11911a(byteBuffer, i, (long) (j / this.f13035d));
            return;
        }
        if (this.f13032a == null) {
            this.f13032a = ByteBuffer.allocateDirect(byteBuffer.capacity());
        }
        if (this.f13033b > 0 && j > this.f13033b) {
            int i3 = (int) (1.0d / this.f13035d);
            long j3 = (j - this.f13033b) / ((long) i3);
            int i4 = 0;
            while (i4 < i3) {
                this.f13032a.clear();
                if (this.f13036e != null) {
                    j2 = j3;
                    this.f13036e.mo11911a(this.f13032a, this.f13032a.remaining(), (long) ((this.f13033b + (((long) i4) * j3)) / this.f13035d));
                } else {
                    j2 = j3;
                }
                i4++;
                j3 = j2;
            }
        }
        this.f13033b = j;
        this.f13032a.clear();
        this.f13032a.put(byteBuffer);
    }
}
