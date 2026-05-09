package p000;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes.dex */
public class afp extends afv {

    /* JADX INFO: renamed from: f */
    private static final aga f772f = new aga();

    /* JADX INFO: renamed from: a */
    protected boolean f773a;

    /* JADX INFO: renamed from: b */
    protected boolean f774b;

    /* JADX INFO: renamed from: c */
    protected int f775c;

    /* JADX INFO: renamed from: d */
    protected boolean f776d;

    /* JADX INFO: renamed from: g */
    private byte[] f777g;

    /* JADX INFO: renamed from: h */
    private byte[] f778h;

    /* JADX INFO: renamed from: i */
    private byte[] f779i;

    /* JADX INFO: renamed from: j */
    private byte[] f780j;

    /* JADX INFO: renamed from: k */
    private byte[] f781k;

    /* JADX INFO: renamed from: l */
    private byte[] f782l;

    /* JADX INFO: renamed from: m */
    private byte[] f783m;

    /* JADX INFO: renamed from: n */
    private byte[] f784n;

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo845a() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo852a(aga agaVar) {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: b */
    public void mo857b() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: d */
    public void mo860d() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: e */
    public void mo862e() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: g */
    public void mo864g() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: i */
    public void mo866i() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: k */
    public void mo868k() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: m */
    public void mo870m() {
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: o */
    public void mo872o() {
    }

    /* JADX INFO: renamed from: afp$a */
    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class C0087a implements afx {

        /* JADX INFO: renamed from: a */
        protected boolean f785a;

        /* JADX INFO: renamed from: b */
        protected boolean f786b;

        /* JADX INFO: renamed from: c */
        protected int f787c;

        public C0087a() {
            this(false, true);
        }

        public C0087a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public C0087a(boolean z, boolean z2, int i) {
            this.f785a = false;
            this.f786b = true;
            this.f785a = z;
            this.f786b = z2;
            this.f787c = i;
        }

        @Override // p000.afx
        /* JADX INFO: renamed from: a */
        public afv mo881a(agi agiVar) {
            afp afpVar = new afp(agiVar, this.f785a, this.f786b);
            if (this.f787c != 0) {
                afpVar.m859c(this.f787c);
            }
            return afpVar;
        }
    }

    public afp(agi agiVar, boolean z, boolean z2) {
        super(agiVar);
        this.f773a = false;
        this.f774b = true;
        this.f776d = false;
        this.f777g = new byte[1];
        this.f778h = new byte[2];
        this.f779i = new byte[4];
        this.f780j = new byte[8];
        this.f781k = new byte[1];
        this.f782l = new byte[2];
        this.f783m = new byte[4];
        this.f784n = new byte[8];
        this.f773a = z;
        this.f774b = z2;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo849a(afr afrVar) {
        m846a(afrVar.f802b);
        m855a(afrVar.f803c);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: c */
    public void mo858c() {
        m846a((byte) 0);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo851a(afu afuVar) {
        m846a(afuVar.f806a);
        m846a(afuVar.f807b);
        mo847a(afuVar.f808c);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo850a(afs afsVar) {
        m846a(afsVar.f804a);
        mo847a(afsVar.f805b);
    }

    /* JADX INFO: renamed from: a */
    public void m846a(byte b) {
        this.f777g[0] = b;
        this.f809e.mo915b(this.f777g, 0, 1);
    }

    /* JADX INFO: renamed from: a */
    public void m855a(short s) {
        this.f778h[0] = (byte) ((s >> 8) & 255);
        this.f778h[1] = (byte) (s & 255);
        this.f809e.mo915b(this.f778h, 0, 2);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo847a(int i) {
        this.f779i[0] = (byte) ((i >> 24) & 255);
        this.f779i[1] = (byte) ((i >> 16) & 255);
        this.f779i[2] = (byte) ((i >> 8) & 255);
        this.f779i[3] = (byte) (i & 255);
        this.f809e.mo915b(this.f779i, 0, 4);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo848a(long j) {
        this.f780j[0] = (byte) ((j >> 56) & 255);
        this.f780j[1] = (byte) ((j >> 48) & 255);
        this.f780j[2] = (byte) ((j >> 40) & 255);
        this.f780j[3] = (byte) ((j >> 32) & 255);
        this.f780j[4] = (byte) ((j >> 24) & 255);
        this.f780j[5] = (byte) ((j >> 16) & 255);
        this.f780j[6] = (byte) ((j >> 8) & 255);
        this.f780j[7] = (byte) (j & 255);
        this.f809e.mo915b(this.f780j, 0, 8);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo853a(String str) throws afi {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            mo847a(bytes.length);
            this.f809e.mo915b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new afi("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo854a(ByteBuffer byteBuffer) {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        mo847a(iLimit);
        this.f809e.mo915b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: f */
    public aga mo863f() {
        return f772f;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: h */
    public afr mo865h() throws afw {
        byte bMo874q = mo874q();
        return new afr("", bMo874q, bMo874q == 0 ? (short) 0 : mo875r());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: j */
    public afu mo867j() {
        return new afu(mo874q(), mo874q(), mo876s());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: l */
    public afs mo869l() {
        return new afs(mo874q(), mo876s());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: n */
    public afz mo871n() {
        return new afz(mo874q(), mo876s());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: p */
    public boolean mo873p() {
        return mo874q() == 1;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: q */
    public byte mo874q() throws afw {
        if (this.f809e.mo922d() >= 1) {
            byte b = this.f809e.mo919b()[this.f809e.mo920c()];
            this.f809e.mo917a(1);
            return b;
        }
        m844a(this.f781k, 0, 1);
        return this.f781k[0];
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: r */
    public short mo875r() throws afw {
        byte[] bArrMo919b = this.f782l;
        int iMo920c = 0;
        if (this.f809e.mo922d() >= 2) {
            bArrMo919b = this.f809e.mo919b();
            iMo920c = this.f809e.mo920c();
            this.f809e.mo917a(2);
        } else {
            m844a(this.f782l, 0, 2);
        }
        return (short) ((bArrMo919b[iMo920c + 1] & 255) | ((bArrMo919b[iMo920c] & 255) << 8));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: s */
    public int mo876s() throws afw {
        byte[] bArrMo919b = this.f783m;
        int iMo920c = 0;
        if (this.f809e.mo922d() >= 4) {
            bArrMo919b = this.f809e.mo919b();
            iMo920c = this.f809e.mo920c();
            this.f809e.mo917a(4);
        } else {
            m844a(this.f783m, 0, 4);
        }
        return (bArrMo919b[iMo920c + 3] & 255) | ((bArrMo919b[iMo920c] & 255) << 24) | ((bArrMo919b[iMo920c + 1] & 255) << 16) | ((bArrMo919b[iMo920c + 2] & 255) << 8);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: t */
    public long mo877t() throws afw {
        byte[] bArrMo919b = this.f784n;
        int iMo920c = 0;
        if (this.f809e.mo922d() >= 8) {
            bArrMo919b = this.f809e.mo919b();
            iMo920c = this.f809e.mo920c();
            this.f809e.mo917a(8);
        } else {
            m844a(this.f784n, 0, 8);
        }
        return (((long) (bArrMo919b[iMo920c] & 255)) << 56) | (((long) (bArrMo919b[iMo920c + 1] & 255)) << 48) | (((long) (bArrMo919b[iMo920c + 2] & 255)) << 40) | (((long) (bArrMo919b[iMo920c + 3] & 255)) << 32) | (((long) (bArrMo919b[iMo920c + 4] & 255)) << 24) | (((long) (bArrMo919b[iMo920c + 5] & 255)) << 16) | (((long) (bArrMo919b[iMo920c + 6] & 255)) << 8) | ((long) (bArrMo919b[iMo920c + 7] & 255));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: u */
    public double mo878u() {
        return Double.longBitsToDouble(mo877t());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: v */
    public String mo879v() throws afi {
        int iMo876s = mo876s();
        if (this.f809e.mo922d() >= iMo876s) {
            try {
                String str = new String(this.f809e.mo919b(), this.f809e.mo920c(), iMo876s, "UTF-8");
                this.f809e.mo917a(iMo876s);
                return str;
            } catch (UnsupportedEncodingException unused) {
                throw new afi("JVM DOES NOT SUPPORT UTF-8");
            }
        }
        return m856b(iMo876s);
    }

    /* JADX INFO: renamed from: b */
    public String m856b(int i) throws afi {
        try {
            m861d(i);
            byte[] bArr = new byte[i];
            this.f809e.m924d(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new afi("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: w */
    public ByteBuffer mo880w() throws afw, agj {
        int iMo876s = mo876s();
        m861d(iMo876s);
        if (this.f809e.mo922d() >= iMo876s) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f809e.mo919b(), this.f809e.mo920c(), iMo876s);
            this.f809e.mo917a(iMo876s);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iMo876s];
        this.f809e.m924d(bArr, 0, iMo876s);
        return ByteBuffer.wrap(bArr);
    }

    /* JADX INFO: renamed from: a */
    private int m844a(byte[] bArr, int i, int i2) throws afw {
        m861d(i2);
        return this.f809e.m924d(bArr, i, i2);
    }

    /* JADX INFO: renamed from: c */
    public void m859c(int i) {
        this.f775c = i;
        this.f776d = true;
    }

    /* JADX INFO: renamed from: d */
    protected void m861d(int i) throws afw {
        if (i < 0) {
            throw new afw("Negative length: " + i);
        }
        if (this.f776d) {
            this.f775c -= i;
            if (this.f775c < 0) {
                throw new afw("Message length exceeded: " + i);
            }
        }
    }
}
