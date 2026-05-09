package p000;

import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: ou */
/* JADX INFO: compiled from: AudioSpecificConfig.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {5}, m11081b = 64)
public class C2008ou extends AbstractC2009ov {

    /* JADX INFO: renamed from: c */
    public static Map<Integer, Integer> f12072c = new HashMap();

    /* JADX INFO: renamed from: d */
    public static Map<Integer, String> f12073d = new HashMap();

    /* JADX INFO: renamed from: A */
    public boolean f12074A;

    /* JADX INFO: renamed from: B */
    public boolean f12075B;

    /* JADX INFO: renamed from: C */
    public boolean f12076C;

    /* JADX INFO: renamed from: D */
    public int f12077D;

    /* JADX INFO: renamed from: E */
    public boolean f12078E;

    /* JADX INFO: renamed from: F */
    public int f12079F;

    /* JADX INFO: renamed from: G */
    public int f12080G;

    /* JADX INFO: renamed from: H */
    public int f12081H;

    /* JADX INFO: renamed from: I */
    public int f12082I;

    /* JADX INFO: renamed from: J */
    public int f12083J;

    /* JADX INFO: renamed from: K */
    public int f12084K;

    /* JADX INFO: renamed from: L */
    public int f12085L;

    /* JADX INFO: renamed from: M */
    public int f12086M;

    /* JADX INFO: renamed from: N */
    public int f12087N;

    /* JADX INFO: renamed from: O */
    public int f12088O;

    /* JADX INFO: renamed from: P */
    public int f12089P;

    /* JADX INFO: renamed from: Q */
    public int f12090Q;

    /* JADX INFO: renamed from: R */
    public int f12091R;

    /* JADX INFO: renamed from: S */
    public int f12092S;

    /* JADX INFO: renamed from: T */
    public boolean f12093T;

    /* JADX INFO: renamed from: a */
    byte[] f12094a;

    /* JADX INFO: renamed from: b */
    public a f12095b;

    /* JADX INFO: renamed from: e */
    public int f12096e;

    /* JADX INFO: renamed from: f */
    public int f12097f;

    /* JADX INFO: renamed from: g */
    public int f12098g;

    /* JADX INFO: renamed from: h */
    public int f12099h;

    /* JADX INFO: renamed from: i */
    public int f12100i;

    /* JADX INFO: renamed from: j */
    public boolean f12101j;

    /* JADX INFO: renamed from: k */
    public boolean f12102k;

    /* JADX INFO: renamed from: l */
    public int f12103l;

    /* JADX INFO: renamed from: m */
    public int f12104m;

    /* JADX INFO: renamed from: n */
    public int f12105n;

    /* JADX INFO: renamed from: o */
    public int f12106o;

    /* JADX INFO: renamed from: p */
    public int f12107p;

    /* JADX INFO: renamed from: q */
    public int f12108q;

    /* JADX INFO: renamed from: r */
    public int f12109r;

    /* JADX INFO: renamed from: s */
    public int f12110s;

    /* JADX INFO: renamed from: t */
    public int f12111t;

    /* JADX INFO: renamed from: u */
    public int f12112u;

    /* JADX INFO: renamed from: v */
    public int f12113v;

    /* JADX INFO: renamed from: w */
    public int f12114w;

    /* JADX INFO: renamed from: x */
    public int f12115x;

    /* JADX INFO: renamed from: y */
    public int f12116y;

    /* JADX INFO: renamed from: z */
    public int f12117z;

    /* JADX INFO: renamed from: f */
    private int m11055f() {
        return 0;
    }

    static {
        f12072c.put(0, 96000);
        f12072c.put(1, 88200);
        f12072c.put(2, 64000);
        f12072c.put(3, 48000);
        f12072c.put(4, 44100);
        f12072c.put(5, 32000);
        f12072c.put(6, 24000);
        f12072c.put(7, 22050);
        f12072c.put(8, 16000);
        f12072c.put(9, 12000);
        f12072c.put(10, 11025);
        f12072c.put(11, 8000);
        f12073d.put(1, "AAC main");
        f12073d.put(2, "AAC LC");
        f12073d.put(3, "AAC SSR");
        f12073d.put(4, "AAC LTP");
        f12073d.put(5, "SBR");
        f12073d.put(6, "AAC Scalable");
        f12073d.put(7, "TwinVQ");
        f12073d.put(8, "CELP");
        f12073d.put(9, "HVXC");
        f12073d.put(10, "(reserved)");
        f12073d.put(11, "(reserved)");
        f12073d.put(12, "TTSI");
        f12073d.put(13, "Main synthetic");
        f12073d.put(14, "Wavetable synthesis");
        f12073d.put(15, "General MIDI");
        f12073d.put(16, "Algorithmic Synthesis and Audio FX");
        f12073d.put(17, "ER AAC LC");
        f12073d.put(18, "(reserved)");
        f12073d.put(19, "ER AAC LTP");
        f12073d.put(20, "ER AAC Scalable");
        f12073d.put(21, "ER TwinVQ");
        f12073d.put(22, "ER BSAC");
        f12073d.put(23, "ER AAC LD");
        f12073d.put(24, "ER CELP");
        f12073d.put(25, "ER HVXC");
        f12073d.put(26, "ER HILN");
        f12073d.put(27, "ER Parametric");
        f12073d.put(28, "SSC");
        f12073d.put(29, "PS");
        f12073d.put(30, "MPEG Surround");
        f12073d.put(31, "(escape)");
        f12073d.put(32, "Layer-1");
        f12073d.put(33, "Layer-2");
        f12073d.put(34, "Layer-3");
        f12073d.put(35, "DST");
        f12073d.put(36, "ALS");
        f12073d.put(37, "SLS");
        f12073d.put(38, "SLS non-core");
        f12073d.put(39, "ER AAC ELD");
        f12073d.put(40, "SMR Simple");
        f12073d.put(41, "SMR Main");
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x012b  */
    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo11059a(java.nio.ByteBuffer r10) {
        /*
            Method dump skipped, instruction units count: 580
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2008ou.mo11059a(java.nio.ByteBuffer):void");
    }

    /* JADX INFO: renamed from: ou$a */
    /* JADX INFO: compiled from: AudioSpecificConfig.java */
    public class a {

        /* JADX INFO: renamed from: a */
        public boolean f12118a;

        /* JADX INFO: renamed from: b */
        public boolean f12119b;

        /* JADX INFO: renamed from: c */
        public boolean f12120c;

        /* JADX INFO: renamed from: d */
        public boolean f12121d;

        /* JADX INFO: renamed from: e */
        public boolean f12122e;

        /* JADX INFO: renamed from: f */
        public boolean f12123f;

        /* JADX INFO: renamed from: g */
        public boolean f12124g;

        public a(int i, C2010ow c2010ow) {
            int iM11068a;
            this.f12118a = c2010ow.m11069a();
            this.f12119b = c2010ow.m11069a();
            this.f12120c = c2010ow.m11069a();
            this.f12121d = c2010ow.m11069a();
            this.f12122e = c2010ow.m11069a();
            if (this.f12122e) {
                this.f12123f = c2010ow.m11069a();
                this.f12124g = c2010ow.m11069a();
                m11063a(i, c2010ow);
            }
            while (c2010ow.m11068a(4) != 0) {
                int iM11068a2 = c2010ow.m11068a(4);
                if (iM11068a2 == 15) {
                    iM11068a = c2010ow.m11068a(8);
                    iM11068a2 += iM11068a;
                } else {
                    iM11068a = 0;
                }
                if (iM11068a == 255) {
                    iM11068a2 += c2010ow.m11068a(16);
                }
                for (int i2 = 0; i2 < iM11068a2; i2++) {
                    c2010ow.m11068a(8);
                }
            }
        }

        /* JADX INFO: renamed from: a */
        public void m11063a(int i, C2010ow c2010ow) {
            int i2;
            switch (i) {
                case 1:
                case 2:
                    i2 = 1;
                    break;
                case 3:
                    i2 = 2;
                    break;
                case 4:
                case 5:
                case 6:
                    i2 = 3;
                    break;
                case 7:
                    i2 = 4;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                C2008ou.this.new b(c2010ow);
            }
        }
    }

    /* JADX INFO: renamed from: ou$b */
    /* JADX INFO: compiled from: AudioSpecificConfig.java */
    public class b {

        /* JADX INFO: renamed from: a */
        public boolean f12126a;

        /* JADX INFO: renamed from: b */
        public int f12127b;

        /* JADX INFO: renamed from: c */
        public int f12128c;

        /* JADX INFO: renamed from: d */
        public int f12129d;

        /* JADX INFO: renamed from: e */
        public int f12130e;

        /* JADX INFO: renamed from: f */
        public boolean f12131f;

        /* JADX INFO: renamed from: g */
        public boolean f12132g;

        /* JADX INFO: renamed from: h */
        public int f12133h;

        /* JADX INFO: renamed from: i */
        public boolean f12134i;

        /* JADX INFO: renamed from: j */
        public int f12135j;

        /* JADX INFO: renamed from: k */
        public int f12136k;

        /* JADX INFO: renamed from: l */
        public int f12137l;

        /* JADX INFO: renamed from: m */
        public boolean f12138m;

        /* JADX INFO: renamed from: n */
        public boolean f12139n;

        public b(C2010ow c2010ow) {
            this.f12126a = c2010ow.m11069a();
            this.f12127b = c2010ow.m11068a(4);
            this.f12128c = c2010ow.m11068a(4);
            this.f12129d = c2010ow.m11068a(3);
            this.f12130e = c2010ow.m11068a(2);
            this.f12131f = c2010ow.m11069a();
            this.f12132g = c2010ow.m11069a();
            if (this.f12131f) {
                this.f12133h = c2010ow.m11068a(2);
                this.f12134i = c2010ow.m11069a();
                this.f12135j = c2010ow.m11068a(2);
            }
            if (this.f12132g) {
                this.f12136k = c2010ow.m11068a(2);
                this.f12137l = c2010ow.m11068a(2);
                this.f12138m = c2010ow.m11069a();
            }
            this.f12139n = c2010ow.m11069a();
        }
    }

    /* JADX INFO: renamed from: a */
    public int m11057a() {
        if (this.f12096e == 2) {
            return m11055f() + 4;
        }
        throw new UnsupportedOperationException("can't serialize that yet");
    }

    /* JADX INFO: renamed from: b */
    public ByteBuffer m11060b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m11057a());
        C1935ng.m10753c(byteBufferAllocate, 5);
        C1935ng.m10753c(byteBufferAllocate, m11057a() - 2);
        C2011ox c2011ox = new C2011ox(byteBufferAllocate);
        c2011ox.m11071a(this.f12096e, 5);
        c2011ox.m11071a(this.f12097f, 4);
        if (this.f12097f == 15) {
            throw new UnsupportedOperationException("can't serialize that yet");
        }
        c2011ox.m11071a(this.f12099h, 4);
        return byteBufferAllocate;
    }

    /* JADX INFO: renamed from: a */
    private int m11049a(C2010ow c2010ow) {
        int iM11068a = c2010ow.m11068a(5);
        return iM11068a == 31 ? c2010ow.m11068a(6) + 32 : iM11068a;
    }

    /* JADX INFO: renamed from: a */
    private void m11050a(int i, int i2, int i3, C2010ow c2010ow) {
        this.f12111t = c2010ow.m11068a(1);
        this.f12112u = c2010ow.m11068a(1);
        if (this.f12112u == 1) {
            this.f12113v = c2010ow.m11068a(14);
        }
        this.f12114w = c2010ow.m11068a(1);
        if (i2 == 0) {
            throw new UnsupportedOperationException("can't parse program_config_element yet");
        }
        if (i3 == 6 || i3 == 20) {
            this.f12115x = c2010ow.m11068a(3);
        }
        if (this.f12114w == 1) {
            if (i3 == 22) {
                this.f12116y = c2010ow.m11068a(5);
                this.f12117z = c2010ow.m11068a(11);
            }
            if (i3 == 17 || i3 == 19 || i3 == 20 || i3 == 23) {
                this.f12074A = c2010ow.m11069a();
                this.f12075B = c2010ow.m11069a();
                this.f12076C = c2010ow.m11069a();
            }
            this.f12077D = c2010ow.m11068a(1);
        }
        this.f12078E = true;
    }

    /* JADX INFO: renamed from: b */
    private void m11051b(int i, int i2, int i3, C2010ow c2010ow) {
        this.f12079F = c2010ow.m11068a(1);
        if (this.f12079F == 1) {
            m11052c(i, i2, i3, c2010ow);
        } else {
            m11056f(i, i2, i3, c2010ow);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m11052c(int i, int i2, int i3, C2010ow c2010ow) {
        this.f12080G = c2010ow.m11068a(2);
        if (this.f12080G != 1) {
            m11053d(i, i2, i3, c2010ow);
        }
        if (this.f12080G != 0) {
            m11054e(i, i2, i3, c2010ow);
        }
        this.f12081H = c2010ow.m11068a(1);
        this.f12093T = true;
    }

    /* JADX INFO: renamed from: d */
    private void m11053d(int i, int i2, int i3, C2010ow c2010ow) {
        this.f12082I = c2010ow.m11068a(1);
        this.f12083J = c2010ow.m11068a(2);
        this.f12084K = c2010ow.m11068a(1);
        if (this.f12084K == 1) {
            this.f12085L = c2010ow.m11068a(1);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m11054e(int i, int i2, int i3, C2010ow c2010ow) {
        this.f12086M = c2010ow.m11068a(1);
        this.f12087N = c2010ow.m11068a(8);
        this.f12088O = c2010ow.m11068a(4);
        this.f12089P = c2010ow.m11068a(12);
        this.f12090Q = c2010ow.m11068a(2);
    }

    /* JADX INFO: renamed from: f */
    private void m11056f(int i, int i2, int i3, C2010ow c2010ow) {
        this.f12091R = c2010ow.m11068a(1);
        if (this.f12091R == 1) {
            this.f12092S = c2010ow.m11068a(2);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m11058a(int i) {
        this.f12096e = i;
    }

    /* JADX INFO: renamed from: b */
    public void m11061b(int i) {
        this.f12097f = i;
    }

    /* JADX INFO: renamed from: c */
    public void m11062c(int i) {
        this.f12099h = i;
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AudioSpecificConfig");
        sb.append("{configBytes=");
        sb.append(C1932nd.m10729a(this.f12094a));
        sb.append(", audioObjectType=");
        sb.append(this.f12096e);
        sb.append(" (");
        sb.append(f12073d.get(Integer.valueOf(this.f12096e)));
        sb.append(")");
        sb.append(", samplingFrequencyIndex=");
        sb.append(this.f12097f);
        sb.append(" (");
        sb.append(f12072c.get(Integer.valueOf(this.f12097f)));
        sb.append(")");
        sb.append(", samplingFrequency=");
        sb.append(this.f12098g);
        sb.append(", channelConfiguration=");
        sb.append(this.f12099h);
        if (this.f12100i > 0) {
            sb.append(", extensionAudioObjectType=");
            sb.append(this.f12100i);
            sb.append(" (");
            sb.append(f12073d.get(Integer.valueOf(this.f12100i)));
            sb.append(")");
            sb.append(", sbrPresentFlag=");
            sb.append(this.f12101j);
            sb.append(", psPresentFlag=");
            sb.append(this.f12102k);
            sb.append(", extensionSamplingFrequencyIndex=");
            sb.append(this.f12103l);
            sb.append(" (");
            sb.append(f12072c.get(Integer.valueOf(this.f12103l)));
            sb.append(")");
            sb.append(", extensionSamplingFrequency=");
            sb.append(this.f12104m);
            sb.append(", extensionChannelConfiguration=");
            sb.append(this.f12105n);
        }
        sb.append(", syncExtensionType=");
        sb.append(this.f12110s);
        if (this.f12078E) {
            sb.append(", frameLengthFlag=");
            sb.append(this.f12111t);
            sb.append(", dependsOnCoreCoder=");
            sb.append(this.f12112u);
            sb.append(", coreCoderDelay=");
            sb.append(this.f12113v);
            sb.append(", extensionFlag=");
            sb.append(this.f12114w);
            sb.append(", layerNr=");
            sb.append(this.f12115x);
            sb.append(", numOfSubFrame=");
            sb.append(this.f12116y);
            sb.append(", layer_length=");
            sb.append(this.f12117z);
            sb.append(", aacSectionDataResilienceFlag=");
            sb.append(this.f12074A);
            sb.append(", aacScalefactorDataResilienceFlag=");
            sb.append(this.f12075B);
            sb.append(", aacSpectralDataResilienceFlag=");
            sb.append(this.f12076C);
            sb.append(", extensionFlag3=");
            sb.append(this.f12077D);
        }
        if (this.f12093T) {
            sb.append(", isBaseLayer=");
            sb.append(this.f12079F);
            sb.append(", paraMode=");
            sb.append(this.f12080G);
            sb.append(", paraExtensionFlag=");
            sb.append(this.f12081H);
            sb.append(", hvxcVarMode=");
            sb.append(this.f12082I);
            sb.append(", hvxcRateMode=");
            sb.append(this.f12083J);
            sb.append(", erHvxcExtensionFlag=");
            sb.append(this.f12084K);
            sb.append(", var_ScalableFlag=");
            sb.append(this.f12085L);
            sb.append(", hilnQuantMode=");
            sb.append(this.f12086M);
            sb.append(", hilnMaxNumLine=");
            sb.append(this.f12087N);
            sb.append(", hilnSampleRateCode=");
            sb.append(this.f12088O);
            sb.append(", hilnFrameLength=");
            sb.append(this.f12089P);
            sb.append(", hilnContMode=");
            sb.append(this.f12090Q);
            sb.append(", hilnEnhaLayer=");
            sb.append(this.f12091R);
            sb.append(", hilnEnhaQuantMode=");
            sb.append(this.f12092S);
        }
        sb.append('}');
        return sb.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2008ou c2008ou = (C2008ou) obj;
        return this.f12075B == c2008ou.f12075B && this.f12074A == c2008ou.f12074A && this.f12076C == c2008ou.f12076C && this.f12096e == c2008ou.f12096e && this.f12099h == c2008ou.f12099h && this.f12113v == c2008ou.f12113v && this.f12112u == c2008ou.f12112u && this.f12109r == c2008ou.f12109r && this.f12108q == c2008ou.f12108q && this.f12084K == c2008ou.f12084K && this.f12100i == c2008ou.f12100i && this.f12105n == c2008ou.f12105n && this.f12114w == c2008ou.f12114w && this.f12077D == c2008ou.f12077D && this.f12104m == c2008ou.f12104m && this.f12103l == c2008ou.f12103l && this.f12107p == c2008ou.f12107p && this.f12111t == c2008ou.f12111t && this.f12078E == c2008ou.f12078E && this.f12090Q == c2008ou.f12090Q && this.f12091R == c2008ou.f12091R && this.f12092S == c2008ou.f12092S && this.f12089P == c2008ou.f12089P && this.f12087N == c2008ou.f12087N && this.f12086M == c2008ou.f12086M && this.f12088O == c2008ou.f12088O && this.f12083J == c2008ou.f12083J && this.f12082I == c2008ou.f12082I && this.f12079F == c2008ou.f12079F && this.f12115x == c2008ou.f12115x && this.f12117z == c2008ou.f12117z && this.f12116y == c2008ou.f12116y && this.f12081H == c2008ou.f12081H && this.f12080G == c2008ou.f12080G && this.f12093T == c2008ou.f12093T && this.f12102k == c2008ou.f12102k && this.f12106o == c2008ou.f12106o && this.f12098g == c2008ou.f12098g && this.f12097f == c2008ou.f12097f && this.f12101j == c2008ou.f12101j && this.f12110s == c2008ou.f12110s && this.f12085L == c2008ou.f12085L && Arrays.equals(this.f12094a, c2008ou.f12094a);
    }

    public int hashCode() {
        return ((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((((this.f12094a != null ? Arrays.hashCode(this.f12094a) : 0) * 31) + this.f12096e) * 31) + this.f12097f) * 31) + this.f12098g) * 31) + this.f12099h) * 31) + this.f12100i) * 31) + (this.f12101j ? 1 : 0)) * 31) + (this.f12102k ? 1 : 0)) * 31) + this.f12103l) * 31) + this.f12104m) * 31) + this.f12105n) * 31) + this.f12106o) * 31) + this.f12107p) * 31) + this.f12108q) * 31) + this.f12109r) * 31) + this.f12110s) * 31) + this.f12111t) * 31) + this.f12112u) * 31) + this.f12113v) * 31) + this.f12114w) * 31) + this.f12115x) * 31) + this.f12116y) * 31) + this.f12117z) * 31) + (this.f12074A ? 1 : 0)) * 31) + (this.f12075B ? 1 : 0)) * 31) + (this.f12076C ? 1 : 0)) * 31) + this.f12077D) * 31) + (this.f12078E ? 1 : 0)) * 31) + this.f12079F) * 31) + this.f12080G) * 31) + this.f12081H) * 31) + this.f12082I) * 31) + this.f12083J) * 31) + this.f12084K) * 31) + this.f12085L) * 31) + this.f12086M) * 31) + this.f12087N) * 31) + this.f12088O) * 31) + this.f12089P) * 31) + this.f12090Q) * 31) + this.f12091R) * 31) + this.f12092S) * 31) + (this.f12093T ? 1 : 0);
    }
}
