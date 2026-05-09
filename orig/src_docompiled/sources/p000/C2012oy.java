package p000;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: renamed from: oy */
/* JADX INFO: compiled from: DecoderConfigDescriptor.java */
/* JADX INFO: loaded from: classes.dex */
@InterfaceC2015pa(m11080a = {4})
public class C2012oy extends AbstractC2009ov {

    /* JADX INFO: renamed from: k */
    private static Logger f12152k = Logger.getLogger(C2012oy.class.getName());

    /* JADX INFO: renamed from: a */
    int f12153a;

    /* JADX INFO: renamed from: b */
    int f12154b;

    /* JADX INFO: renamed from: c */
    int f12155c;

    /* JADX INFO: renamed from: d */
    int f12156d;

    /* JADX INFO: renamed from: e */
    long f12157e;

    /* JADX INFO: renamed from: f */
    long f12158f;

    /* JADX INFO: renamed from: g */
    C2013oz f12159g;

    /* JADX INFO: renamed from: h */
    C2008ou f12160h;

    /* JADX INFO: renamed from: i */
    List<C2021pg> f12161i = new ArrayList();

    /* JADX INFO: renamed from: j */
    byte[] f12162j;

    @Override // p000.AbstractC2009ov
    /* JADX INFO: renamed from: a */
    public void mo11059a(ByteBuffer byteBuffer) {
        int iM11065c;
        this.f12153a = C1934nf.m10737d(byteBuffer);
        int iM10737d = C1934nf.m10737d(byteBuffer);
        this.f12154b = iM10737d >>> 2;
        this.f12155c = (iM10737d >> 1) & 1;
        this.f12156d = C1934nf.m10735b(byteBuffer);
        this.f12157e = C1934nf.m10733a(byteBuffer);
        this.f12158f = C1934nf.m10733a(byteBuffer);
        if (byteBuffer.remaining() > 2) {
            int iPosition = byteBuffer.position();
            AbstractC2009ov abstractC2009ovM11087a = C2020pf.m11087a(this.f12153a, byteBuffer);
            int iPosition2 = byteBuffer.position() - iPosition;
            Logger logger = f12152k;
            StringBuilder sb = new StringBuilder();
            sb.append(abstractC2009ovM11087a);
            sb.append(" - DecoderConfigDescr1 read: ");
            sb.append(iPosition2);
            sb.append(", size: ");
            sb.append(abstractC2009ovM11087a != null ? Integer.valueOf(abstractC2009ovM11087a.m11065c()) : null);
            logger.finer(sb.toString());
            if (abstractC2009ovM11087a != null && iPosition2 < (iM11065c = abstractC2009ovM11087a.m11065c())) {
                this.f12162j = new byte[iM11065c - iPosition2];
                byteBuffer.get(this.f12162j);
            }
            if (abstractC2009ovM11087a instanceof C2013oz) {
                this.f12159g = (C2013oz) abstractC2009ovM11087a;
            }
            if (abstractC2009ovM11087a instanceof C2008ou) {
                this.f12160h = (C2008ou) abstractC2009ovM11087a;
            }
        }
        while (byteBuffer.remaining() > 2) {
            long jPosition = byteBuffer.position();
            AbstractC2009ov abstractC2009ovM11087a2 = C2020pf.m11087a(this.f12153a, byteBuffer);
            long jPosition2 = ((long) byteBuffer.position()) - jPosition;
            Logger logger2 = f12152k;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(abstractC2009ovM11087a2);
            sb2.append(" - DecoderConfigDescr2 read: ");
            sb2.append(jPosition2);
            sb2.append(", size: ");
            sb2.append(abstractC2009ovM11087a2 != null ? Integer.valueOf(abstractC2009ovM11087a2.m11065c()) : null);
            logger2.finer(sb2.toString());
            if (abstractC2009ovM11087a2 instanceof C2021pg) {
                this.f12161i.add((C2021pg) abstractC2009ovM11087a2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m11072a() {
        return (this.f12160h == null ? 0 : this.f12160h.m11057a()) + 15;
    }

    /* JADX INFO: renamed from: b */
    public ByteBuffer m11076b() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(m11072a());
        C1935ng.m10753c(byteBufferAllocate, 4);
        C1935ng.m10753c(byteBufferAllocate, m11072a() - 2);
        C1935ng.m10753c(byteBufferAllocate, this.f12153a);
        C1935ng.m10753c(byteBufferAllocate, (this.f12154b << 2) | (this.f12155c << 1) | 1);
        C1935ng.m10745a(byteBufferAllocate, this.f12156d);
        C1935ng.m10750b(byteBufferAllocate, this.f12157e);
        C1935ng.m10750b(byteBufferAllocate, this.f12158f);
        if (this.f12160h != null) {
            byteBufferAllocate.put(this.f12160h.m11060b().array());
        }
        return byteBufferAllocate;
    }

    /* JADX INFO: renamed from: a */
    public void m11075a(C2008ou c2008ou) {
        this.f12160h = c2008ou;
    }

    /* JADX INFO: renamed from: a */
    public void m11073a(int i) {
        this.f12153a = i;
    }

    /* JADX INFO: renamed from: b */
    public void m11077b(int i) {
        this.f12154b = i;
    }

    /* JADX INFO: renamed from: c */
    public void m11079c(int i) {
        this.f12156d = i;
    }

    /* JADX INFO: renamed from: a */
    public void m11074a(long j) {
        this.f12157e = j;
    }

    /* JADX INFO: renamed from: b */
    public void m11078b(long j) {
        this.f12158f = j;
    }

    @Override // p000.AbstractC2009ov
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("DecoderConfigDescriptor");
        sb.append("{objectTypeIndication=");
        sb.append(this.f12153a);
        sb.append(", streamType=");
        sb.append(this.f12154b);
        sb.append(", upStream=");
        sb.append(this.f12155c);
        sb.append(", bufferSizeDB=");
        sb.append(this.f12156d);
        sb.append(", maxBitRate=");
        sb.append(this.f12157e);
        sb.append(", avgBitRate=");
        sb.append(this.f12158f);
        sb.append(", decoderSpecificInfo=");
        sb.append(this.f12159g);
        sb.append(", audioSpecificInfo=");
        sb.append(this.f12160h);
        sb.append(", configDescriptorDeadBytes=");
        sb.append(C1932nd.m10729a(this.f12162j != null ? this.f12162j : new byte[0]));
        sb.append(", profileLevelIndicationDescriptors=");
        sb.append(this.f12161i == null ? "null" : Arrays.asList(this.f12161i).toString());
        sb.append('}');
        return sb.toString();
    }
}
