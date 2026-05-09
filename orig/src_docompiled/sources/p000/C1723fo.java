package p000;

import android.support.v4.util.Pools;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import p000.C1751gp;

/* JADX INFO: renamed from: fo */
/* JADX INFO: compiled from: AdapterHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1723fo implements C1751gp.a {

    /* JADX INFO: renamed from: a */
    final ArrayList<b> f9830a;

    /* JADX INFO: renamed from: b */
    final ArrayList<b> f9831b;

    /* JADX INFO: renamed from: c */
    final a f9832c;

    /* JADX INFO: renamed from: d */
    Runnable f9833d;

    /* JADX INFO: renamed from: e */
    final boolean f9834e;

    /* JADX INFO: renamed from: f */
    final C1751gp f9835f;

    /* JADX INFO: renamed from: g */
    private Pools.Pool<b> f9836g;

    /* JADX INFO: renamed from: h */
    private int f9837h;

    /* JADX INFO: renamed from: fo$a */
    /* JADX INFO: compiled from: AdapterHelper.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        RecyclerView.AbstractC0624v mo3846a(int i);

        /* JADX INFO: renamed from: a */
        void mo3847a(int i, int i2);

        /* JADX INFO: renamed from: a */
        void mo3848a(int i, int i2, Object obj);

        /* JADX INFO: renamed from: a */
        void mo3849a(b bVar);

        /* JADX INFO: renamed from: b */
        void mo3850b(int i, int i2);

        /* JADX INFO: renamed from: b */
        void mo3851b(b bVar);

        /* JADX INFO: renamed from: c */
        void mo3852c(int i, int i2);

        /* JADX INFO: renamed from: d */
        void mo3854d(int i, int i2);
    }

    public C1723fo(a aVar) {
        this(aVar, false);
    }

    C1723fo(a aVar, boolean z) {
        this.f9836g = new Pools.SimplePool(30);
        this.f9830a = new ArrayList<>();
        this.f9831b = new ArrayList<>();
        this.f9837h = 0;
        this.f9832c = aVar;
        this.f9834e = z;
        this.f9835f = new C1751gp(this);
    }

    /* JADX INFO: renamed from: a */
    public void m9199a() {
        m9202a(this.f9830a);
        m9202a(this.f9831b);
        this.f9837h = 0;
    }

    /* JADX INFO: renamed from: b */
    public void m9205b() {
        this.f9835f.m9490a(this.f9830a);
        int size = this.f9830a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f9830a.get(i);
            int i2 = bVar.f9838a;
            if (i2 == 4) {
                m9192d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        m9195f(bVar);
                        break;
                    case 2:
                        m9191c(bVar);
                        break;
                }
            } else {
                m9190b(bVar);
            }
            if (this.f9833d != null) {
                this.f9833d.run();
            }
        }
        this.f9830a.clear();
    }

    /* JADX INFO: renamed from: c */
    public void m9207c() {
        int size = this.f9831b.size();
        for (int i = 0; i < size; i++) {
            this.f9832c.mo3851b(this.f9831b.get(i));
        }
        m9202a(this.f9831b);
        this.f9837h = 0;
    }

    /* JADX INFO: renamed from: b */
    private void m9190b(b bVar) {
        m9196g(bVar);
    }

    /* JADX INFO: renamed from: c */
    private void m9191c(b bVar) {
        boolean z;
        byte b2;
        int i = bVar.f9839b;
        int i2 = bVar.f9839b + bVar.f9841d;
        int i3 = bVar.f9839b;
        int i4 = 0;
        byte b3 = -1;
        while (i3 < i2) {
            if (this.f9832c.mo3846a(i3) != null || m9193d(i3)) {
                if (b3 == 0) {
                    m9194e(mo9198a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 1;
            } else {
                if (b3 == 1) {
                    m9196g(mo9198a(2, i, i4, null));
                    z = true;
                } else {
                    z = false;
                }
                b2 = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            b3 = b2;
        }
        if (i4 != bVar.f9841d) {
            mo9200a(bVar);
            bVar = mo9198a(2, i, i4, null);
        }
        if (b3 == 0) {
            m9194e(bVar);
        } else {
            m9196g(bVar);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m9192d(b bVar) {
        int i = bVar.f9839b;
        int i2 = bVar.f9839b + bVar.f9841d;
        byte b2 = -1;
        int i3 = i;
        int i4 = 0;
        for (int i5 = bVar.f9839b; i5 < i2; i5++) {
            if (this.f9832c.mo3846a(i5) != null || m9193d(i5)) {
                if (b2 == 0) {
                    m9194e(mo9198a(4, i3, i4, bVar.f9840c));
                    i3 = i5;
                    i4 = 0;
                }
                b2 = 1;
            } else {
                if (b2 == 1) {
                    m9196g(mo9198a(4, i3, i4, bVar.f9840c));
                    i3 = i5;
                    i4 = 0;
                }
                b2 = 0;
            }
            i4++;
        }
        if (i4 != bVar.f9841d) {
            Object obj = bVar.f9840c;
            mo9200a(bVar);
            bVar = mo9198a(4, i3, i4, obj);
        }
        if (b2 == 0) {
            m9194e(bVar);
        } else {
            m9196g(bVar);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m9194e(b bVar) {
        int i;
        if (bVar.f9838a == 1 || bVar.f9838a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int iM9189b = m9189b(bVar.f9839b, bVar.f9838a);
        int i2 = bVar.f9839b;
        int i3 = bVar.f9838a;
        if (i3 == 2) {
            i = 0;
        } else {
            if (i3 != 4) {
                throw new IllegalArgumentException("op should be remove or update." + bVar);
            }
            i = 1;
        }
        int i4 = iM9189b;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f9841d; i7++) {
            int iM9189b2 = m9189b(bVar.f9839b + (i * i7), bVar.f9838a);
            int i8 = bVar.f9838a;
            if (i8 == 2 ? iM9189b2 == i4 : i8 == 4 && iM9189b2 == i4 + 1) {
                i6++;
            } else {
                b bVarMo9198a = mo9198a(bVar.f9838a, i4, i6, bVar.f9840c);
                m9201a(bVarMo9198a, i5);
                mo9200a(bVarMo9198a);
                if (bVar.f9838a == 4) {
                    i5 += i6;
                }
                i4 = iM9189b2;
                i6 = 1;
            }
        }
        Object obj = bVar.f9840c;
        mo9200a(bVar);
        if (i6 > 0) {
            b bVarMo9198a2 = mo9198a(bVar.f9838a, i4, i6, obj);
            m9201a(bVarMo9198a2, i5);
            mo9200a(bVarMo9198a2);
        }
    }

    /* JADX INFO: renamed from: a */
    void m9201a(b bVar, int i) {
        this.f9832c.mo3849a(bVar);
        int i2 = bVar.f9838a;
        if (i2 == 2) {
            this.f9832c.mo3847a(i, bVar.f9841d);
        } else {
            if (i2 == 4) {
                this.f9832c.mo3848a(i, bVar.f9841d, bVar.f9840c);
                return;
            }
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* JADX INFO: renamed from: b */
    private int m9189b(int i, int i2) {
        int i3;
        int i4;
        for (int size = this.f9831b.size() - 1; size >= 0; size--) {
            b bVar = this.f9831b.get(size);
            if (bVar.f9838a == 8) {
                if (bVar.f9839b < bVar.f9841d) {
                    i3 = bVar.f9839b;
                    i4 = bVar.f9841d;
                } else {
                    i3 = bVar.f9841d;
                    i4 = bVar.f9839b;
                }
                if (i >= i3 && i <= i4) {
                    if (i3 == bVar.f9839b) {
                        if (i2 == 1) {
                            bVar.f9841d++;
                        } else if (i2 == 2) {
                            bVar.f9841d--;
                        }
                        i++;
                    } else {
                        if (i2 == 1) {
                            bVar.f9839b++;
                        } else if (i2 == 2) {
                            bVar.f9839b--;
                        }
                        i--;
                    }
                } else if (i < bVar.f9839b) {
                    if (i2 == 1) {
                        bVar.f9839b++;
                        bVar.f9841d++;
                    } else if (i2 == 2) {
                        bVar.f9839b--;
                        bVar.f9841d--;
                    }
                }
            } else if (bVar.f9839b <= i) {
                if (bVar.f9838a == 1) {
                    i -= bVar.f9841d;
                } else if (bVar.f9838a == 2) {
                    i += bVar.f9841d;
                }
            } else if (i2 == 1) {
                bVar.f9839b++;
            } else if (i2 == 2) {
                bVar.f9839b--;
            }
        }
        for (int size2 = this.f9831b.size() - 1; size2 >= 0; size2--) {
            b bVar2 = this.f9831b.get(size2);
            if (bVar2.f9838a == 8) {
                if (bVar2.f9841d == bVar2.f9839b || bVar2.f9841d < 0) {
                    this.f9831b.remove(size2);
                    mo9200a(bVar2);
                }
            } else if (bVar2.f9841d <= 0) {
                this.f9831b.remove(size2);
                mo9200a(bVar2);
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: d */
    private boolean m9193d(int i) {
        int size = this.f9831b.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = this.f9831b.get(i2);
            if (bVar.f9838a == 8) {
                if (m9197a(bVar.f9841d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f9838a == 1) {
                int i3 = bVar.f9839b + bVar.f9841d;
                for (int i4 = bVar.f9839b; i4 < i3; i4++) {
                    if (m9197a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
            } else {
                continue;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    private void m9195f(b bVar) {
        m9196g(bVar);
    }

    /* JADX INFO: renamed from: g */
    private void m9196g(b bVar) {
        this.f9831b.add(bVar);
        int i = bVar.f9838a;
        if (i == 4) {
            this.f9832c.mo3848a(bVar.f9839b, bVar.f9841d, bVar.f9840c);
            return;
        }
        if (i != 8) {
            switch (i) {
                case 1:
                    this.f9832c.mo3852c(bVar.f9839b, bVar.f9841d);
                    return;
                case 2:
                    this.f9832c.mo3850b(bVar.f9839b, bVar.f9841d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        }
        this.f9832c.mo3854d(bVar.f9839b, bVar.f9841d);
    }

    /* JADX INFO: renamed from: d */
    public boolean m9208d() {
        return this.f9830a.size() > 0;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9203a(int i) {
        return (i & this.f9837h) != 0;
    }

    /* JADX INFO: renamed from: b */
    public int m9204b(int i) {
        return m9197a(i, 0);
    }

    /* JADX INFO: renamed from: a */
    int m9197a(int i, int i2) {
        int size = this.f9831b.size();
        while (i2 < size) {
            b bVar = this.f9831b.get(i2);
            if (bVar.f9838a == 8) {
                if (bVar.f9839b == i) {
                    i = bVar.f9841d;
                } else {
                    if (bVar.f9839b < i) {
                        i--;
                    }
                    if (bVar.f9841d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f9839b > i) {
                continue;
            } else if (bVar.f9838a == 2) {
                if (i < bVar.f9839b + bVar.f9841d) {
                    return -1;
                }
                i -= bVar.f9841d;
            } else if (bVar.f9838a == 1) {
                i += bVar.f9841d;
            }
            i2++;
        }
        return i;
    }

    /* JADX INFO: renamed from: e */
    public void m9209e() {
        m9207c();
        int size = this.f9830a.size();
        for (int i = 0; i < size; i++) {
            b bVar = this.f9830a.get(i);
            int i2 = bVar.f9838a;
            if (i2 == 4) {
                this.f9832c.mo3851b(bVar);
                this.f9832c.mo3848a(bVar.f9839b, bVar.f9841d, bVar.f9840c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.f9832c.mo3851b(bVar);
                        this.f9832c.mo3852c(bVar.f9839b, bVar.f9841d);
                        break;
                    case 2:
                        this.f9832c.mo3851b(bVar);
                        this.f9832c.mo3847a(bVar.f9839b, bVar.f9841d);
                        break;
                }
            } else {
                this.f9832c.mo3851b(bVar);
                this.f9832c.mo3854d(bVar.f9839b, bVar.f9841d);
            }
            if (this.f9833d != null) {
                this.f9833d.run();
            }
        }
        m9202a(this.f9830a);
        this.f9837h = 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0047, code lost:
    
        continue;
     */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int m9206c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<fo$b> r0 = r5.f9830a
            int r0 = r0.size()
            r1 = 0
        L7:
            if (r1 >= r0) goto L4a
            java.util.ArrayList<fo$b> r2 = r5.f9830a
            java.lang.Object r2 = r2.get(r1)
            fo$b r2 = (p000.C1723fo.b) r2
            int r3 = r2.f9838a
            r4 = 8
            if (r3 == r4) goto L34
            switch(r3) {
                case 1: goto L2c;
                case 2: goto L1b;
                default: goto L1a;
            }
        L1a:
            goto L47
        L1b:
            int r3 = r2.f9839b
            if (r3 > r6) goto L47
            int r3 = r2.f9839b
            int r4 = r2.f9841d
            int r3 = r3 + r4
            if (r3 <= r6) goto L28
            r6 = -1
            return r6
        L28:
            int r2 = r2.f9841d
            int r6 = r6 - r2
            goto L47
        L2c:
            int r3 = r2.f9839b
            if (r3 > r6) goto L47
            int r2 = r2.f9841d
            int r6 = r6 + r2
            goto L47
        L34:
            int r3 = r2.f9839b
            if (r3 != r6) goto L3b
            int r6 = r2.f9841d
            goto L47
        L3b:
            int r3 = r2.f9839b
            if (r3 >= r6) goto L41
            int r6 = r6 + (-1)
        L41:
            int r2 = r2.f9841d
            if (r2 > r6) goto L47
            int r6 = r6 + 1
        L47:
            int r1 = r1 + 1
            goto L7
        L4a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1723fo.m9206c(int):int");
    }

    /* JADX INFO: renamed from: f */
    public boolean m9210f() {
        return (this.f9831b.isEmpty() || this.f9830a.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: fo$b */
    /* JADX INFO: compiled from: AdapterHelper.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public int f9838a;

        /* JADX INFO: renamed from: b */
        public int f9839b;

        /* JADX INFO: renamed from: c */
        public Object f9840c;

        /* JADX INFO: renamed from: d */
        public int f9841d;

        b(int i, int i2, int i3, Object obj) {
            this.f9838a = i;
            this.f9839b = i2;
            this.f9841d = i3;
            this.f9840c = obj;
        }

        /* JADX INFO: renamed from: a */
        String m9211a() {
            int i = this.f9838a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + m9211a() + ",s:" + this.f9839b + "c:" + this.f9841d + ",p:" + this.f9840c + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.f9838a != bVar.f9838a) {
                return false;
            }
            if (this.f9838a == 8 && Math.abs(this.f9841d - this.f9839b) == 1 && this.f9841d == bVar.f9839b && this.f9839b == bVar.f9841d) {
                return true;
            }
            if (this.f9841d != bVar.f9841d || this.f9839b != bVar.f9839b) {
                return false;
            }
            if (this.f9840c != null) {
                if (!this.f9840c.equals(bVar.f9840c)) {
                    return false;
                }
            } else if (bVar.f9840c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f9838a * 31) + this.f9839b) * 31) + this.f9841d;
        }
    }

    @Override // p000.C1751gp.a
    /* JADX INFO: renamed from: a */
    public b mo9198a(int i, int i2, int i3, Object obj) {
        b bVarAcquire = this.f9836g.acquire();
        if (bVarAcquire == null) {
            return new b(i, i2, i3, obj);
        }
        bVarAcquire.f9838a = i;
        bVarAcquire.f9839b = i2;
        bVarAcquire.f9841d = i3;
        bVarAcquire.f9840c = obj;
        return bVarAcquire;
    }

    @Override // p000.C1751gp.a
    /* JADX INFO: renamed from: a */
    public void mo9200a(b bVar) {
        if (this.f9834e) {
            return;
        }
        bVar.f9840c = null;
        this.f9836g.release(bVar);
    }

    /* JADX INFO: renamed from: a */
    void m9202a(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo9200a(list.get(i));
        }
        list.clear();
    }
}
