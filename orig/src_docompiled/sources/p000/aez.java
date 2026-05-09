package p000;

import android.content.Context;

/* JADX INFO: compiled from: ReportPolicy.java */
/* JADX INFO: loaded from: classes.dex */
public class aez {

    /* JADX INFO: renamed from: aez$d */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0072d extends C0076h {
        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return z;
        }
    }

    /* JADX INFO: renamed from: aez$g */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0075g extends C0076h {
        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return true;
        }
    }

    /* JADX INFO: renamed from: aez$h */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0076h {
        /* JADX INFO: renamed from: a */
        public boolean mo785a() {
            return true;
        }

        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m783a(int i) {
        switch (i) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 8:
                return true;
            case 7:
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: aez$e */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0073e extends C0076h {

        /* JADX INFO: renamed from: a */
        private static long f724a = 90000;

        /* JADX INFO: renamed from: b */
        private static long f725b = 86400000;

        /* JADX INFO: renamed from: c */
        private long f726c;

        /* JADX INFO: renamed from: d */
        private aef f727d;

        public C0073e(aef aefVar, long j) {
            this.f727d = aefVar;
            m786a(j);
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return System.currentTimeMillis() - this.f727d.f523c >= this.f726c;
        }

        /* JADX INFO: renamed from: a */
        public void m786a(long j) {
            if (j >= f724a && j <= f725b) {
                this.f726c = j;
            } else {
                this.f726c = f724a;
            }
        }
    }

    /* JADX INFO: renamed from: aez$f */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0074f extends C0076h {

        /* JADX INFO: renamed from: a */
        private long f728a = 86400000;

        /* JADX INFO: renamed from: b */
        private aef f729b;

        public C0074f(aef aefVar) {
            this.f729b = aefVar;
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return System.currentTimeMillis() - this.f729b.f523c >= this.f728a;
        }
    }

    /* JADX INFO: renamed from: aez$i */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0077i extends C0076h {

        /* JADX INFO: renamed from: a */
        private Context f730a;

        public C0077i(Context context) {
            this.f730a = null;
            this.f730a = context;
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return aeu.m737i(this.f730a);
        }
    }

    /* JADX INFO: renamed from: aez$b */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0070b extends C0076h {

        /* JADX INFO: renamed from: a */
        private aei f720a;

        /* JADX INFO: renamed from: b */
        private aef f721b;

        public C0070b(aef aefVar, aei aeiVar) {
            this.f721b = aefVar;
            this.f720a = aeiVar;
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return System.currentTimeMillis() - this.f721b.f523c >= this.f720a.m513b();
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo785a() {
            return this.f720a.m514c();
        }
    }

    /* JADX INFO: renamed from: aez$c */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0071c extends C0076h {

        /* JADX INFO: renamed from: a */
        private long f722a;

        /* JADX INFO: renamed from: b */
        private long f723b;

        public C0071c(int i) {
            this.f723b = 0L;
            this.f722a = i;
            this.f723b = System.currentTimeMillis();
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return System.currentTimeMillis() - this.f723b >= this.f722a;
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo785a() {
            return System.currentTimeMillis() - this.f723b < this.f722a;
        }
    }

    /* JADX INFO: renamed from: aez$j */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0078j extends C0076h {

        /* JADX INFO: renamed from: a */
        private final long f731a = 10800000;

        /* JADX INFO: renamed from: b */
        private aef f732b;

        public C0078j(aef aefVar) {
            this.f732b = aefVar;
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return System.currentTimeMillis() - this.f732b.f523c >= 10800000;
        }
    }

    /* JADX INFO: renamed from: aez$a */
    /* JADX INFO: compiled from: ReportPolicy.java */
    public static class C0069a extends C0076h {

        /* JADX INFO: renamed from: a */
        private final long f718a = 15000;

        /* JADX INFO: renamed from: b */
        private aef f719b;

        public C0069a(aef aefVar) {
            this.f719b = aefVar;
        }

        @Override // p000.aez.C0076h
        /* JADX INFO: renamed from: a */
        public boolean mo784a(boolean z) {
            return System.currentTimeMillis() - this.f719b.f523c >= 15000;
        }
    }
}
