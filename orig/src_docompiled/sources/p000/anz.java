package p000;

import java.io.IOException;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.net.Socket;
import java.util.List;
import p000.amz;
import p000.any;

/* JADX INFO: compiled from: StreamAllocation.java */
/* JADX INFO: loaded from: classes.dex */
public final class anz {

    /* JADX INFO: renamed from: d */
    static final /* synthetic */ boolean f4306d = true;

    /* JADX INFO: renamed from: a */
    public final amf f4307a;

    /* JADX INFO: renamed from: b */
    public final amj f4308b;

    /* JADX INFO: renamed from: c */
    public final amv f4309c;

    /* JADX INFO: renamed from: e */
    private any.C0677a f4310e;

    /* JADX INFO: renamed from: f */
    private ani f4311f;

    /* JADX INFO: renamed from: g */
    private final amo f4312g;

    /* JADX INFO: renamed from: h */
    private final Object f4313h;

    /* JADX INFO: renamed from: i */
    private final any f4314i;

    /* JADX INFO: renamed from: j */
    private int f4315j;

    /* JADX INFO: renamed from: k */
    private anv f4316k;

    /* JADX INFO: renamed from: l */
    private boolean f4317l;

    /* JADX INFO: renamed from: m */
    private boolean f4318m;

    /* JADX INFO: renamed from: n */
    private boolean f4319n;

    /* JADX INFO: renamed from: o */
    private aoc f4320o;

    public anz(amo amoVar, amf amfVar, amj amjVar, amv amvVar, Object obj) {
        this.f4312g = amoVar;
        this.f4307a = amfVar;
        this.f4308b = amjVar;
        this.f4309c = amvVar;
        this.f4314i = new any(amfVar, m4596h(), amjVar, amvVar);
        this.f4313h = obj;
    }

    /* JADX INFO: renamed from: a */
    public aoc m4598a(anb anbVar, amz.InterfaceC0211a interfaceC0211a, boolean z) {
        try {
            aoc aocVarM4564a = m4592a(interfaceC0211a.mo2118c(), interfaceC0211a.mo2119d(), interfaceC0211a.mo2120e(), anbVar.m2133d(), anbVar.m2148s(), z).m4564a(anbVar, interfaceC0211a, this);
            synchronized (this.f4312g) {
                this.f4320o = aocVarM4564a;
            }
            return aocVarM4564a;
        } catch (IOException e) {
            throw new anx(e);
        }
    }

    /* JADX INFO: renamed from: a */
    private anv m4592a(int i, int i2, int i3, int i4, boolean z, boolean z2) throws Throwable {
        while (true) {
            anv anvVarM4591a = m4591a(i, i2, i3, i4, z);
            synchronized (this.f4312g) {
                if (anvVarM4591a.f4280b == 0) {
                    return anvVarM4591a;
                }
                if (anvVarM4591a.m4570a(z2)) {
                    return anvVarM4591a;
                }
                m4606e();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private anv m4591a(int i, int i2, int i3, int i4, boolean z) throws Throwable {
        Socket socketM4595g;
        Socket socketMo2158a;
        anv anvVar;
        anv anvVar2;
        anv anvVar3;
        ani aniVarM4589b;
        boolean z2;
        boolean z3;
        synchronized (this.f4312g) {
            if (this.f4318m) {
                throw new IllegalStateException("released");
            }
            if (this.f4320o != null) {
                throw new IllegalStateException("codec != null");
            }
            if (this.f4319n) {
                throw new IOException("Canceled");
            }
            anv anvVar4 = this.f4316k;
            socketM4595g = m4595g();
            socketMo2158a = null;
            if (this.f4316k != null) {
                anvVar2 = this.f4316k;
                anvVar = null;
            } else {
                anvVar = anvVar4;
                anvVar2 = null;
            }
            if (!this.f4317l) {
                anvVar = null;
            }
            if (anvVar2 == null) {
                ank.f4205a.mo2156a(this.f4312g, this.f4307a, this, null);
                if (this.f4316k != null) {
                    anvVar3 = this.f4316k;
                    aniVarM4589b = null;
                    z2 = true;
                } else {
                    aniVarM4589b = this.f4311f;
                    anvVar3 = anvVar2;
                }
            } else {
                anvVar3 = anvVar2;
                aniVarM4589b = null;
            }
            z2 = false;
        }
        anm.m4508a(socketM4595g);
        if (anvVar != null) {
            this.f4309c.m2041b(this.f4308b, anvVar);
        }
        if (z2) {
            this.f4309c.m2029a(this.f4308b, anvVar3);
        }
        if (anvVar3 != null) {
            return anvVar3;
        }
        if (aniVarM4589b != null || (this.f4310e != null && this.f4310e.m4588a())) {
            z3 = false;
        } else {
            this.f4310e = this.f4314i.m4587b();
            z3 = true;
        }
        synchronized (this.f4312g) {
            if (this.f4319n) {
                throw new IOException("Canceled");
            }
            if (z3) {
                List<ani> listM4590c = this.f4310e.m4590c();
                int size = listM4590c.size();
                int i5 = 0;
                while (true) {
                    if (i5 >= size) {
                        break;
                    }
                    ani aniVar = listM4590c.get(i5);
                    ank.f4205a.mo2156a(this.f4312g, this.f4307a, this, aniVar);
                    if (this.f4316k != null) {
                        anvVar3 = this.f4316k;
                        this.f4311f = aniVar;
                        z2 = true;
                        break;
                    }
                    i5++;
                }
            }
            if (!z2) {
                if (aniVarM4589b == null) {
                    aniVarM4589b = this.f4310e.m4589b();
                }
                this.f4311f = aniVarM4589b;
                this.f4315j = 0;
                anvVar3 = new anv(this.f4312g, aniVarM4589b);
                m4600a(anvVar3, false);
            }
        }
        if (z2) {
            this.f4309c.m2029a(this.f4308b, anvVar3);
            return anvVar3;
        }
        anvVar3.m4565a(i, i2, i3, i4, z, this.f4308b, this.f4309c);
        m4596h().m4575b(anvVar3.m4571b());
        synchronized (this.f4312g) {
            this.f4317l = true;
            ank.f4205a.mo2164b(this.f4312g, anvVar3);
            if (anvVar3.m4573d()) {
                socketMo2158a = ank.f4205a.mo2158a(this.f4312g, this.f4307a, this);
                anvVar3 = this.f4316k;
            }
        }
        anm.m4508a(socketMo2158a);
        this.f4309c.m2029a(this.f4308b, anvVar3);
        return anvVar3;
    }

    /* JADX INFO: renamed from: g */
    private Socket m4595g() {
        if (!f4306d && !Thread.holdsLock(this.f4312g)) {
            throw new AssertionError();
        }
        anv anvVar = this.f4316k;
        if (anvVar == null || !anvVar.f4279a) {
            return null;
        }
        return m4593a(false, false, true);
    }

    /* JADX INFO: renamed from: a */
    public void m4602a(boolean z, aoc aocVar, long j, IOException iOException) {
        anv anvVar;
        Socket socketM4593a;
        boolean z2;
        this.f4309c.m2040b(this.f4308b, j);
        synchronized (this.f4312g) {
            if (aocVar != null) {
                if (aocVar == this.f4320o) {
                    if (!z) {
                        this.f4316k.f4280b++;
                    }
                    anvVar = this.f4316k;
                    socketM4593a = m4593a(z, false, true);
                    if (this.f4316k != null) {
                        anvVar = null;
                    }
                    z2 = this.f4318m;
                }
            }
            throw new IllegalStateException("expected " + this.f4320o + " but was " + aocVar);
        }
        anm.m4508a(socketM4593a);
        if (anvVar != null) {
            this.f4309c.m2041b(this.f4308b, anvVar);
        }
        if (iOException != null) {
            this.f4309c.m2033a(this.f4308b, iOException);
        } else if (z2) {
            this.f4309c.m2046g(this.f4308b);
        }
    }

    /* JADX INFO: renamed from: a */
    public aoc m4597a() {
        aoc aocVar;
        synchronized (this.f4312g) {
            aocVar = this.f4320o;
        }
        return aocVar;
    }

    /* JADX INFO: renamed from: h */
    private anw m4596h() {
        return ank.f4205a.mo2157a(this.f4312g);
    }

    /* JADX INFO: renamed from: b */
    public ani m4603b() {
        return this.f4311f;
    }

    /* JADX INFO: renamed from: c */
    public synchronized anv m4604c() {
        return this.f4316k;
    }

    /* JADX INFO: renamed from: d */
    public void m4605d() {
        anv anvVar;
        Socket socketM4593a;
        synchronized (this.f4312g) {
            anvVar = this.f4316k;
            socketM4593a = m4593a(false, true, false);
            if (this.f4316k != null) {
                anvVar = null;
            }
        }
        anm.m4508a(socketM4593a);
        if (anvVar != null) {
            this.f4309c.m2041b(this.f4308b, anvVar);
            this.f4309c.m2046g(this.f4308b);
        }
    }

    /* JADX INFO: renamed from: e */
    public void m4606e() {
        anv anvVar;
        Socket socketM4593a;
        synchronized (this.f4312g) {
            anvVar = this.f4316k;
            socketM4593a = m4593a(true, false, false);
            if (this.f4316k != null) {
                anvVar = null;
            }
        }
        anm.m4508a(socketM4593a);
        if (anvVar != null) {
            this.f4309c.m2041b(this.f4308b, anvVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x005e  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.net.Socket m4593a(boolean r2, boolean r3, boolean r4) {
        /*
            r1 = this;
            boolean r0 = p000.anz.f4306d
            if (r0 != 0) goto L12
            amo r0 = r1.f4312g
            boolean r0 = java.lang.Thread.holdsLock(r0)
            if (r0 != 0) goto L12
            java.lang.AssertionError r2 = new java.lang.AssertionError
            r2.<init>()
            throw r2
        L12:
            r0 = 0
            if (r4 == 0) goto L17
            r1.f4320o = r0
        L17:
            r4 = 1
            if (r3 == 0) goto L1c
            r1.f4318m = r4
        L1c:
            anv r3 = r1.f4316k
            if (r3 == 0) goto L62
            if (r2 == 0) goto L26
            anv r2 = r1.f4316k
            r2.f4279a = r4
        L26:
            aoc r2 = r1.f4320o
            if (r2 != 0) goto L62
            boolean r2 = r1.f4318m
            if (r2 != 0) goto L34
            anv r2 = r1.f4316k
            boolean r2 = r2.f4279a
            if (r2 == 0) goto L62
        L34:
            anv r2 = r1.f4316k
            r1.m4594b(r2)
            anv r2 = r1.f4316k
            java.util.List<java.lang.ref.Reference<anz>> r2 = r2.f4282d
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L5e
            anv r2 = r1.f4316k
            long r3 = java.lang.System.nanoTime()
            r2.f4283e = r3
            ank r2 = p000.ank.f4205a
            amo r3 = r1.f4312g
            anv r4 = r1.f4316k
            boolean r2 = r2.mo2163a(r3, r4)
            if (r2 == 0) goto L5e
            anv r2 = r1.f4316k
            java.net.Socket r2 = r2.mo1981a()
            goto L5f
        L5e:
            r2 = r0
        L5f:
            r1.f4316k = r0
            goto L63
        L62:
            r2 = r0
        L63:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.anz.m4593a(boolean, boolean, boolean):java.net.Socket");
    }

    /* JADX INFO: renamed from: a */
    public void m4601a(IOException iOException) {
        boolean z;
        anv anvVar;
        Socket socketM4593a;
        synchronized (this.f4312g) {
            if (iOException instanceof apa) {
                aoo aooVar = ((apa) iOException).f4558a;
                if (aooVar == aoo.REFUSED_STREAM) {
                    this.f4315j++;
                    if (this.f4315j > 1) {
                        this.f4311f = null;
                        z = true;
                    }
                    z = false;
                } else {
                    if (aooVar != aoo.CANCEL) {
                        this.f4311f = null;
                        z = true;
                    }
                    z = false;
                }
            } else {
                if (this.f4316k != null && (!this.f4316k.m4573d() || (iOException instanceof aon))) {
                    if (this.f4316k.f4280b == 0) {
                        if (this.f4311f != null && iOException != null) {
                            this.f4314i.m4585a(this.f4311f, iOException);
                        }
                        this.f4311f = null;
                    }
                    z = true;
                }
                z = false;
            }
            anvVar = this.f4316k;
            socketM4593a = m4593a(z, false, true);
            if (this.f4316k != null || !this.f4317l) {
                anvVar = null;
            }
        }
        anm.m4508a(socketM4593a);
        if (anvVar != null) {
            this.f4309c.m2041b(this.f4308b, anvVar);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4600a(anv anvVar, boolean z) {
        if (!f4306d && !Thread.holdsLock(this.f4312g)) {
            throw new AssertionError();
        }
        if (this.f4316k != null) {
            throw new IllegalStateException();
        }
        this.f4316k = anvVar;
        this.f4317l = z;
        anvVar.f4282d.add(new C0678a(this, this.f4313h));
    }

    /* JADX INFO: renamed from: b */
    private void m4594b(anv anvVar) {
        int size = anvVar.f4282d.size();
        for (int i = 0; i < size; i++) {
            if (anvVar.f4282d.get(i).get() == this) {
                anvVar.f4282d.remove(i);
                return;
            }
        }
        throw new IllegalStateException();
    }

    /* JADX INFO: renamed from: a */
    public Socket m4599a(anv anvVar) {
        if (!f4306d && !Thread.holdsLock(this.f4312g)) {
            throw new AssertionError();
        }
        if (this.f4320o != null || this.f4316k.f4282d.size() != 1) {
            throw new IllegalStateException();
        }
        Reference<anz> reference = this.f4316k.f4282d.get(0);
        Socket socketM4593a = m4593a(true, false, false);
        this.f4316k = anvVar;
        anvVar.f4282d.add(reference);
        return socketM4593a;
    }

    /* JADX INFO: renamed from: f */
    public boolean m4607f() {
        return this.f4311f != null || (this.f4310e != null && this.f4310e.m4588a()) || this.f4314i.m4586a();
    }

    public String toString() {
        anv anvVarM4604c = m4604c();
        return anvVarM4604c != null ? anvVarM4604c.toString() : this.f4307a.toString();
    }

    /* JADX INFO: renamed from: anz$a */
    /* JADX INFO: compiled from: StreamAllocation.java */
    public static final class C0678a extends WeakReference<anz> {

        /* JADX INFO: renamed from: a */
        public final Object f4321a;

        C0678a(anz anzVar, Object obj) {
            super(anzVar);
            this.f4321a = obj;
        }
    }
}
