package p000;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: renamed from: pb */
/* JADX INFO: compiled from: ESDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {3})
public class C2016pb extends AbstractC2009ov {

    /* JADX INFO: renamed from: n */
    private static Logger f12164n = Logger.getLogger(C2016pb.class.getName());

    /* JADX INFO: renamed from: a */
    int f12165a;

    /* JADX INFO: renamed from: b */
    int f12166b;

    /* JADX INFO: renamed from: c */
    int f12167c;

    /* JADX INFO: renamed from: d */
    int f12168d;

    /* JADX INFO: renamed from: e */
    int f12169e;

    /* JADX INFO: renamed from: g */
    String f12171g;

    /* JADX INFO: renamed from: h */
    int f12172h;

    /* JADX INFO: renamed from: i */
    int f12173i;

    /* JADX INFO: renamed from: j */
    int f12174j;

    /* JADX INFO: renamed from: k */
    C2012oy f12175k;

    /* JADX INFO: renamed from: l */
    C2022ph f12176l;

    /* JADX INFO: renamed from: f */
    int f12170f = 0;

    /* JADX INFO: renamed from: m */
    List<AbstractC2009ov> f12177m = new ArrayList();

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        this.f12165a = C1934nf.m10736c(byteBuffer);
        int iM10737d = C1934nf.m10737d(byteBuffer);
        this.f12166b = iM10737d >>> 7;
        this.f12167c = (iM10737d >>> 6) & 1;
        this.f12168d = (iM10737d >>> 5) & 1;
        this.f12169e = iM10737d & 31;
        if (this.f12166b == 1) {
            this.f12173i = C1934nf.m10736c(byteBuffer);
        }
        if (this.f12167c == 1) {
            this.f12170f = C1934nf.m10737d(byteBuffer);
            this.f12171g = C1934nf.m10734a(byteBuffer, this.f12170f);
        }
        if (this.f12168d == 1) {
            this.f12174j = C1934nf.m10736c(byteBuffer);
        }
        int iE = m11067e() + 1 + 2 + 1 + (this.f12166b == 1 ? 2 : 0) + (this.f12167c == 1 ? this.f12170f + 1 : 0) + (this.f12168d == 1 ? 2 : 0);
        int iPosition = byteBuffer.position();
        if (m11065c() > iE + 2) {
            AbstractC2009ov abstractC2009ovM11087a = C2020pf.m11087a(-1, byteBuffer);
            long jPosition = byteBuffer.position() - iPosition;
            Logger logger = f12164n;
            StringBuilder sb = new StringBuilder();
            sb.append(abstractC2009ovM11087a);
            sb.append(" - ESDescriptor1 read: ");
            sb.append(jPosition);
            sb.append(", size: ");
            sb.append(abstractC2009ovM11087a != null ? Integer.valueOf(abstractC2009ovM11087a.m11065c()) : null);
            logger.finer(sb.toString());
            if (abstractC2009ovM11087a != null) {
                int iM11065c = abstractC2009ovM11087a.m11065c();
                byteBuffer.position(iPosition + iM11065c);
                iE += iM11065c;
            } else {
                iE = (int) (((long) iE) + jPosition);
            }
            if (abstractC2009ovM11087a instanceof C2012oy) {
                this.f12175k = (C2012oy) abstractC2009ovM11087a;
            }
        }
        int iPosition2 = byteBuffer.position();
        if (m11065c() > iE + 2) {
            AbstractC2009ov abstractC2009ovM11087a2 = C2020pf.m11087a(-1, byteBuffer);
            long jPosition2 = byteBuffer.position() - iPosition2;
            Logger logger2 = f12164n;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(abstractC2009ovM11087a2);
            sb2.append(" - ESDescriptor2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(abstractC2009ovM11087a2 != null ? Integer.valueOf(abstractC2009ovM11087a2.m11065c()) : null);
            logger2.finer(sb2.toString());
            if (abstractC2009ovM11087a2 != null) {
                int iM11065c2 = abstractC2009ovM11087a2.m11065c();
                byteBuffer.position(iPosition2 + iM11065c2);
                iE += iM11065c2;
            } else {
                iE = (int) (((long) iE) + jPosition2);
            }
            if (abstractC2009ovM11087a2 instanceof C2022ph) {
                this.f12176l = (C2022ph) abstractC2009ovM11087a2;
            }
        } else {
            f12164n.warning("SLConfigDescriptor is missing!");
        }
        while (m11065c() - iE > 2) {
            int iPosition3 = byteBuffer.position();
            AbstractC2009ov abstractC2009ovM11087a3 = C2020pf.m11087a(-1, byteBuffer);
            long jPosition3 = byteBuffer.position() - iPosition3;
            Logger logger3 = f12164n;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(abstractC2009ovM11087a3);
            sb3.append(" - ESDescriptor3 read: ");
            sb3.append(jPosition3);
            sb3.append(", size: ");
            sb3.append(abstractC2009ovM11087a3 != null ? Integer.valueOf(abstractC2009ovM11087a3.m11065c()) : null);
            logger3.finer(sb3.toString());
            if (abstractC2009ovM11087a3 != null) {
                int iM11065c3 = abstractC2009ovM11087a3.m11065c();
                byteBuffer.position(iPosition3 + iM11065c3);
                iE += iM11065c3;
            } else {
                iE = (int) (((long) iE) + jPosition3);
            }
            this.f12177m.add(abstractC2009ovM11087a3);
        }
    }

    /* JADX INFO: renamed from: a */
    public int m11082a() {
        int i = this.f12166b > 0 ? 7 : 5;
        if (this.f12167c > 0) {
            i += this.f12170f + 1;
        }
        if (this.f12168d > 0) {
            i += 2;
        }
        return i + this.f12175k.m11072a() + this.f12176l.m11088a();
    }

    /* JADX INFO: renamed from: b */
    public ByteBuffer m11086b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m11082a());
        C1935ng.m10753c(byteBufferAllocate, 3);
        C1935ng.m10753c(byteBufferAllocate, m11082a() - 2);
        C1935ng.m10749b(byteBufferAllocate, this.f12165a);
        C1935ng.m10753c(byteBufferAllocate, (this.f12166b << 7) | (this.f12167c << 6) | (this.f12168d << 5) | (this.f12169e & 31));
        if (this.f12166b > 0) {
            C1935ng.m10749b(byteBufferAllocate, this.f12173i);
        }
        if (this.f12167c > 0) {
            C1935ng.m10753c(byteBufferAllocate, this.f12170f);
            C1935ng.m10751b(byteBufferAllocate, this.f12171g);
        }
        if (this.f12168d > 0) {
            C1935ng.m10749b(byteBufferAllocate, this.f12174j);
        }
        ByteBuffer byteBufferM11076b = this.f12175k.m11076b();
        ByteBuffer byteBufferM11090b = this.f12176l.m11090b();
        byteBufferAllocate.put(byteBufferM11076b.array());
        byteBufferAllocate.put(byteBufferM11090b.array());
        return byteBufferAllocate;
    }

    /* JADX INFO: renamed from: a */
    public void m11084a(C2012oy c2012oy) {
        this.f12175k = c2012oy;
    }

    /* JADX INFO: renamed from: a */
    public void m11085a(C2022ph c2022ph) {
        this.f12176l = c2022ph;
    }

    /* JADX INFO: renamed from: a */
    public void m11083a(int i) {
        this.f12165a = i;
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        return "ESDescriptor{esId=" + this.f12165a + ", streamDependenceFlag=" + this.f12166b + ", URLFlag=" + this.f12167c + ", oCRstreamFlag=" + this.f12168d + ", streamPriority=" + this.f12169e + ", URLLength=" + this.f12170f + ", URLString='" + this.f12171g + "', remoteODFlag=" + this.f12172h + ", dependsOnEsId=" + this.f12173i + ", oCREsId=" + this.f12174j + ", decoderConfigDescriptor=" + this.f12175k + ", slConfigDescriptor=" + this.f12176l + '}';
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C2016pb c2016pb = (C2016pb) obj;
        if (this.f12167c != c2016pb.f12167c || this.f12170f != c2016pb.f12170f || this.f12173i != c2016pb.f12173i || this.f12165a != c2016pb.f12165a || this.f12174j != c2016pb.f12174j || this.f12168d != c2016pb.f12168d || this.f12172h != c2016pb.f12172h || this.f12166b != c2016pb.f12166b || this.f12169e != c2016pb.f12169e) {
            return false;
        }
        if (this.f12171g == null ? c2016pb.f12171g != null : !this.f12171g.equals(c2016pb.f12171g)) {
            return false;
        }
        if (this.f12175k == null ? c2016pb.f12175k != null : !this.f12175k.equals(c2016pb.f12175k)) {
            return false;
        }
        if (this.f12177m == null ? c2016pb.f12177m == null : this.f12177m.equals(c2016pb.f12177m)) {
            return this.f12176l == null ? c2016pb.f12176l == null : this.f12176l.equals(c2016pb.f12176l);
        }
        return false;
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.f12165a * 31) + this.f12166b) * 31) + this.f12167c) * 31) + this.f12168d) * 31) + this.f12169e) * 31) + this.f12170f) * 31) + (this.f12171g != null ? this.f12171g.hashCode() : 0)) * 31) + this.f12172h) * 31) + this.f12173i) * 31) + this.f12174j) * 31) + (this.f12175k != null ? this.f12175k.hashCode() : 0)) * 31) + (this.f12176l != null ? this.f12176l.hashCode() : 0)) * 31) + (this.f12177m != null ? this.f12177m.hashCode() : 0);
    }
}
