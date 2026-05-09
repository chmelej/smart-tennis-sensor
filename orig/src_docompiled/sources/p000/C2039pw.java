package p000;

/* JADX INFO: renamed from: pw */
/* JADX INFO: compiled from: PredefinedCaptureConfigurations.java */
/* JADX INFO: loaded from: classes.dex */
public class C2039pw {

    /* JADX INFO: renamed from: pw$a */
    /* JADX INFO: compiled from: PredefinedCaptureConfigurations.java */
    public enum a {
        LOW,
        MEDIUM,
        HIGH
    }

    /* JADX INFO: renamed from: pw$b */
    /* JADX INFO: compiled from: PredefinedCaptureConfigurations.java */
    public enum b {
        RES_360P(640, 360, 1000000, 700000, 300000),
        RES_480P(640, 480, 2500000, 1750000, 750000),
        RES_720P(1280, 720, 5000000, 3500000, 1500000),
        RES_1080P(1920, 1080, 8000000, 5600000, 2400000),
        RES_1440P(2560, 1440, 10000000, 7000000, 3000000),
        RES_2160P(3840, 2160, 40000000, 28000000, 12000000);


        /* JADX INFO: renamed from: g */
        public int f12246g;

        /* JADX INFO: renamed from: h */
        public int f12247h;

        /* JADX INFO: renamed from: i */
        private final int f12248i;

        /* JADX INFO: renamed from: j */
        private final int f12249j;

        /* JADX INFO: renamed from: k */
        private final int f12250k;

        b(int i, int i2, int i3, int i4, int i5) {
            this.f12246g = i;
            this.f12247h = i2;
            this.f12250k = i3;
            this.f12249j = i4;
            this.f12248i = i5;
        }

        /* JADX INFO: renamed from: a */
        public int m11146a(a aVar) {
            switch (aVar) {
                case HIGH:
                    return this.f12250k;
                case MEDIUM:
                    return this.f12249j;
                case LOW:
                    return this.f12248i;
                default:
                    return this.f12250k;
            }
        }
    }
}
