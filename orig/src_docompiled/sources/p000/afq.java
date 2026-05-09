package p000;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes.dex */
public class afq extends afv {

    /* JADX INFO: renamed from: d */
    private static final aga f788d = new aga("");

    /* JADX INFO: renamed from: f */
    private static final afr f789f = new afr("", (byte) 0, 0);

    /* JADX INFO: renamed from: g */
    private static final byte[] f790g = new byte[16];

    /* JADX INFO: renamed from: a */
    byte[] f791a;

    /* JADX INFO: renamed from: b */
    byte[] f792b;

    /* JADX INFO: renamed from: c */
    byte[] f793c;

    /* JADX INFO: renamed from: h */
    private afe f794h;

    /* JADX INFO: renamed from: i */
    private short f795i;

    /* JADX INFO: renamed from: j */
    private afr f796j;

    /* JADX INFO: renamed from: k */
    private Boolean f797k;

    /* JADX INFO: renamed from: l */
    private final long f798l;

    /* JADX INFO: renamed from: m */
    private byte[] f799m;

    /* JADX INFO: renamed from: c */
    private int m889c(int i) {
        return (i >> 31) ^ (i << 1);
    }

    /* JADX INFO: renamed from: c */
    private long m890c(long j) {
        return (j << 1) ^ (j >> 63);
    }

    /* JADX INFO: renamed from: c */
    private boolean m891c(byte b) {
        int i = b & 15;
        return i == 1 || i == 2;
    }

    /* JADX INFO: renamed from: d */
    private long m893d(long j) {
        return (j >>> 1) ^ (-(j & 1));
    }

    /* JADX INFO: renamed from: g */
    private int m898g(int i) {
        return (-(i & 1)) ^ (i >>> 1);
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

    static {
        f790g[0] = 0;
        f790g[2] = 1;
        f790g[3] = 3;
        f790g[6] = 4;
        f790g[8] = 5;
        f790g[10] = 6;
        f790g[4] = 7;
        f790g[11] = 8;
        f790g[15] = 9;
        f790g[14] = 10;
        f790g[13] = 11;
        f790g[12] = 12;
    }

    /* JADX INFO: renamed from: afq$a */
    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class C0088a implements afx {

        /* JADX INFO: renamed from: a */
        private final long f800a = -1;

        @Override // p000.afx
        /* JADX INFO: renamed from: a */
        public afv mo881a(agi agiVar) {
            return new afq(agiVar, this.f800a);
        }
    }

    public afq(agi agiVar, long j) {
        super(agiVar);
        this.f794h = new afe(15);
        this.f795i = (short) 0;
        this.f796j = null;
        this.f797k = null;
        this.f791a = new byte[5];
        this.f792b = new byte[10];
        this.f799m = new byte[1];
        this.f793c = new byte[1];
        this.f798l = j;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: x */
    public void mo903x() {
        this.f794h.m831b();
        this.f795i = (short) 0;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo852a(aga agaVar) {
        this.f794h.m830a(this.f795i);
        this.f795i = (short) 0;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo845a() {
        this.f795i = this.f794h.m829a();
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo849a(afr afrVar) {
        if (afrVar.f802b == 2) {
            this.f796j = afrVar;
        } else {
            m884a(afrVar, (byte) -1);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m884a(afr afrVar, byte b) {
        if (b == -1) {
            b = m895e(afrVar.f802b);
        }
        if (afrVar.f803c > this.f795i && afrVar.f803c - this.f795i <= 15) {
            m894d(b | ((afrVar.f803c - this.f795i) << 4));
        } else {
            m886b(b);
            m902a(afrVar.f803c);
        }
        this.f795i = afrVar.f803c;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: c */
    public void mo858c() {
        m886b((byte) 0);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo851a(afu afuVar) {
        if (afuVar.f808c == 0) {
            m894d(0);
            return;
        }
        m887b(afuVar.f808c);
        m894d(m895e(afuVar.f807b) | (m895e(afuVar.f806a) << 4));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo850a(afs afsVar) {
        m901a(afsVar.f804a, afsVar.f805b);
    }

    /* JADX INFO: renamed from: a */
    public void m900a(byte b) {
        m886b(b);
    }

    /* JADX INFO: renamed from: a */
    public void m902a(short s) {
        m887b(m889c((int) s));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo847a(int i) {
        m887b(m889c(i));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo848a(long j) {
        m888b(m890c(j));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo853a(String str) throws afi {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            m885a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new afi("UTF-8 not supported!");
        }
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: a */
    public void mo854a(ByteBuffer byteBuffer) {
        m885a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    /* JADX INFO: renamed from: a */
    private void m885a(byte[] bArr, int i, int i2) {
        m887b(i2);
        this.f809e.mo915b(bArr, i, i2);
    }

    /* JADX INFO: renamed from: a */
    protected void m901a(byte b, int i) {
        if (i <= 14) {
            m894d(m895e(b) | (i << 4));
        } else {
            m894d(m895e(b) | 240);
            m887b(i);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m887b(int i) {
        int i2 = 0;
        while ((i & (-128)) != 0) {
            this.f791a[i2] = (byte) ((i & 127) | 128);
            i >>>= 7;
            i2++;
        }
        this.f791a[i2] = (byte) i;
        this.f809e.mo915b(this.f791a, 0, i2 + 1);
    }

    /* JADX INFO: renamed from: b */
    private void m888b(long j) {
        int i = 0;
        while ((j & (-128)) != 0) {
            this.f792b[i] = (byte) ((j & 127) | 128);
            j >>>= 7;
            i++;
        }
        this.f792b[i] = (byte) j;
        this.f809e.mo915b(this.f792b, 0, i + 1);
    }

    /* JADX INFO: renamed from: b */
    private void m886b(byte b) {
        this.f799m[0] = b;
        this.f809e.m923b(this.f799m);
    }

    /* JADX INFO: renamed from: d */
    private void m894d(int i) {
        m886b((byte) i);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: f */
    public aga mo863f() {
        this.f794h.m830a(this.f795i);
        this.f795i = (short) 0;
        return f788d;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: g */
    public void mo864g() {
        this.f795i = this.f794h.m829a();
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: h */
    public afr mo865h() throws agj {
        short sMo875r;
        byte bMo874q = mo874q();
        if (bMo874q == 0) {
            return f789f;
        }
        short s = (short) ((bMo874q & 240) >> 4);
        if (s == 0) {
            sMo875r = mo875r();
        } else {
            sMo875r = (short) (this.f795i + s);
        }
        byte b = (byte) (bMo874q & 15);
        afr afrVar = new afr("", m892d(b), sMo875r);
        if (m891c(bMo874q)) {
            this.f797k = b == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f795i = afrVar.f803c;
        return afrVar;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: j */
    public afu mo867j() throws agj {
        int iM899z = m899z();
        byte bMo874q = iM899z == 0 ? (byte) 0 : mo874q();
        return new afu(m892d((byte) (bMo874q >> 4)), m892d((byte) (bMo874q & 15)), iM899z);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: l */
    public afs mo869l() throws agj {
        byte bMo874q = mo874q();
        int iM899z = (bMo874q >> 4) & 15;
        if (iM899z == 15) {
            iM899z = m899z();
        }
        return new afs(m892d(bMo874q), iM899z);
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: n */
    public afz mo871n() {
        return new afz(mo869l());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: p */
    public boolean mo873p() {
        if (this.f797k == null) {
            return mo874q() == 1;
        }
        boolean zBooleanValue = this.f797k.booleanValue();
        this.f797k = null;
        return zBooleanValue;
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: q */
    public byte mo874q() throws agj {
        if (this.f809e.mo922d() > 0) {
            byte b = this.f809e.mo919b()[this.f809e.mo920c()];
            this.f809e.mo917a(1);
            return b;
        }
        this.f809e.m924d(this.f793c, 0, 1);
        return this.f793c[0];
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: r */
    public short mo875r() {
        return (short) m898g(m899z());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: s */
    public int mo876s() {
        return m898g(m899z());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: t */
    public long mo877t() {
        return m893d(m882A());
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: u */
    public double mo878u() throws agj {
        byte[] bArr = new byte[8];
        this.f809e.m924d(bArr, 0, 8);
        return Double.longBitsToDouble(m883a(bArr));
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: v */
    public String mo879v() throws afi {
        int iM899z = m899z();
        m897f(iM899z);
        if (iM899z == 0) {
            return "";
        }
        try {
            if (this.f809e.mo922d() >= iM899z) {
                String str = new String(this.f809e.mo919b(), this.f809e.mo920c(), iM899z, "UTF-8");
                this.f809e.mo917a(iM899z);
                return str;
            }
            return new String(m896e(iM899z), "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new afi("UTF-8 not supported!");
        }
    }

    @Override // p000.afv
    /* JADX INFO: renamed from: w */
    public ByteBuffer mo880w() throws afw, agj {
        int iM899z = m899z();
        m897f(iM899z);
        if (iM899z == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iM899z];
        this.f809e.m924d(bArr, 0, iM899z);
        return ByteBuffer.wrap(bArr);
    }

    /* JADX INFO: renamed from: e */
    private byte[] m896e(int i) throws agj {
        if (i == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i];
        this.f809e.m924d(bArr, 0, i);
        return bArr;
    }

    /* JADX INFO: renamed from: f */
    private void m897f(int i) throws afw {
        if (i < 0) {
            throw new afw("Negative length: " + i);
        }
        if (this.f798l == -1 || i <= this.f798l) {
            return;
        }
        throw new afw("Length exceeded max allowed: " + i);
    }

    /* JADX INFO: renamed from: z */
    private int m899z() throws agj {
        int i = 0;
        if (this.f809e.mo922d() >= 5) {
            byte[] bArrMo919b = this.f809e.mo919b();
            int iMo920c = this.f809e.mo920c();
            int i2 = 0;
            int i3 = 0;
            while (true) {
                byte b = bArrMo919b[iMo920c + i];
                i2 |= (b & 127) << i3;
                if ((b & 128) != 128) {
                    this.f809e.mo917a(i + 1);
                    return i2;
                }
                i3 += 7;
                i++;
            }
        } else {
            int i4 = 0;
            while (true) {
                byte bMo874q = mo874q();
                i |= (bMo874q & 127) << i4;
                if ((bMo874q & 128) != 128) {
                    return i;
                }
                i4 += 7;
            }
        }
    }

    /* JADX INFO: renamed from: A */
    private long m882A() throws agj {
        int i = 0;
        long j = 0;
        if (this.f809e.mo922d() >= 10) {
            byte[] bArrMo919b = this.f809e.mo919b();
            int iMo920c = this.f809e.mo920c();
            int i2 = 0;
            while (true) {
                byte b = bArrMo919b[iMo920c + i];
                long j2 = j | (((long) (b & 127)) << i2);
                if ((b & 128) != 128) {
                    this.f809e.mo917a(i + 1);
                    return j2;
                }
                i2 += 7;
                i++;
                j = j2;
            }
        } else {
            while (true) {
                byte bMo874q = mo874q();
                long j3 = j | (((long) (bMo874q & 127)) << i);
                if ((bMo874q & 128) != 128) {
                    return j3;
                }
                i += 7;
                j = j3;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private long m883a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (((long) bArr[0]) & 255);
    }

    /* JADX INFO: renamed from: d */
    private byte m892d(byte b) throws afw {
        byte b2 = (byte) (b & 15);
        switch (b2) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return (byte) 15;
            case 10:
                return (byte) 14;
            case 11:
                return (byte) 13;
            case 12:
                return (byte) 12;
            default:
                throw new afw("don't know what type: " + ((int) b2));
        }
    }

    /* JADX INFO: renamed from: e */
    private byte m895e(byte b) {
        return f790g[b];
    }
}
