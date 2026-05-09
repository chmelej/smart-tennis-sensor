package p000;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: qe */
/* JADX INFO: compiled from: AvcDecoderConfigurationRecord.java */
/* JADX INFO: loaded from: classes.dex */
public class C2048qe {

    /* JADX INFO: renamed from: a */
    public int f12302a;

    /* JADX INFO: renamed from: b */
    public int f12303b;

    /* JADX INFO: renamed from: c */
    public int f12304c;

    /* JADX INFO: renamed from: d */
    public int f12305d;

    /* JADX INFO: renamed from: e */
    public int f12306e;

    /* JADX INFO: renamed from: f */
    public List<byte[]> f12307f;

    /* JADX INFO: renamed from: g */
    public List<byte[]> f12308g;

    /* JADX INFO: renamed from: h */
    public boolean f12309h;

    /* JADX INFO: renamed from: i */
    public int f12310i;

    /* JADX INFO: renamed from: j */
    public int f12311j;

    /* JADX INFO: renamed from: k */
    public int f12312k;

    /* JADX INFO: renamed from: l */
    public List<byte[]> f12313l;

    /* JADX INFO: renamed from: m */
    public int f12314m;

    /* JADX INFO: renamed from: n */
    public int f12315n;

    /* JADX INFO: renamed from: o */
    public int f12316o;

    /* JADX INFO: renamed from: p */
    public int f12317p;

    /* JADX INFO: renamed from: q */
    public int f12318q;

    public C2048qe() {
        this.f12307f = new ArrayList();
        this.f12308g = new ArrayList();
        this.f12309h = true;
        this.f12310i = 1;
        this.f12311j = 0;
        this.f12312k = 0;
        this.f12313l = new ArrayList();
        this.f12314m = 63;
        this.f12315n = 7;
        this.f12316o = 31;
        this.f12317p = 31;
        this.f12318q = 31;
    }

    public C2048qe(ByteBuffer byteBuffer) {
        this.f12307f = new ArrayList();
        this.f12308g = new ArrayList();
        this.f12309h = true;
        this.f12310i = 1;
        this.f12311j = 0;
        this.f12312k = 0;
        this.f12313l = new ArrayList();
        this.f12314m = 63;
        this.f12315n = 7;
        this.f12316o = 31;
        this.f12317p = 31;
        this.f12318q = 31;
        this.f12302a = C1934nf.m10737d(byteBuffer);
        this.f12303b = C1934nf.m10737d(byteBuffer);
        this.f12304c = C1934nf.m10737d(byteBuffer);
        this.f12305d = C1934nf.m10737d(byteBuffer);
        C2010ow c2010ow = new C2010ow(byteBuffer);
        this.f12314m = c2010ow.m11068a(6);
        this.f12306e = c2010ow.m11068a(2);
        this.f12315n = c2010ow.m11068a(3);
        int iM11068a = c2010ow.m11068a(5);
        for (int i = 0; i < iM11068a; i++) {
            byte[] bArr = new byte[C1934nf.m10736c(byteBuffer)];
            byteBuffer.get(bArr);
            this.f12307f.add(bArr);
        }
        long jM10737d = C1934nf.m10737d(byteBuffer);
        for (int i2 = 0; i2 < jM10737d; i2++) {
            byte[] bArr2 = new byte[C1934nf.m10736c(byteBuffer)];
            byteBuffer.get(bArr2);
            this.f12308g.add(bArr2);
        }
        if (byteBuffer.remaining() < 4) {
            this.f12309h = false;
        }
        if (this.f12309h && (this.f12303b == 100 || this.f12303b == 110 || this.f12303b == 122 || this.f12303b == 144)) {
            C2010ow c2010ow2 = new C2010ow(byteBuffer);
            this.f12316o = c2010ow2.m11068a(6);
            this.f12310i = c2010ow2.m11068a(2);
            this.f12317p = c2010ow2.m11068a(5);
            this.f12311j = c2010ow2.m11068a(3);
            this.f12318q = c2010ow2.m11068a(5);
            this.f12312k = c2010ow2.m11068a(3);
            long jM10737d2 = C1934nf.m10737d(byteBuffer);
            for (int i3 = 0; i3 < jM10737d2; i3++) {
                byte[] bArr3 = new byte[C1934nf.m10736c(byteBuffer)];
                byteBuffer.get(bArr3);
                this.f12313l.add(bArr3);
            }
            return;
        }
        this.f12310i = -1;
        this.f12311j = -1;
        this.f12312k = -1;
    }

    /* JADX INFO: renamed from: a */
    public void m11181a(ByteBuffer byteBuffer) {
        C1935ng.m10753c(byteBuffer, this.f12302a);
        C1935ng.m10753c(byteBuffer, this.f12303b);
        C1935ng.m10753c(byteBuffer, this.f12304c);
        C1935ng.m10753c(byteBuffer, this.f12305d);
        C2011ox c2011ox = new C2011ox(byteBuffer);
        c2011ox.m11071a(this.f12314m, 6);
        c2011ox.m11071a(this.f12306e, 2);
        c2011ox.m11071a(this.f12315n, 3);
        c2011ox.m11071a(this.f12308g.size(), 5);
        for (byte[] bArr : this.f12307f) {
            C1935ng.m10749b(byteBuffer, bArr.length);
            byteBuffer.put(bArr);
        }
        C1935ng.m10753c(byteBuffer, this.f12308g.size());
        for (byte[] bArr2 : this.f12308g) {
            C1935ng.m10749b(byteBuffer, bArr2.length);
            byteBuffer.put(bArr2);
        }
        if (this.f12309h) {
            if (this.f12303b == 100 || this.f12303b == 110 || this.f12303b == 122 || this.f12303b == 144) {
                C2011ox c2011ox2 = new C2011ox(byteBuffer);
                c2011ox2.m11071a(this.f12316o, 6);
                c2011ox2.m11071a(this.f12310i, 2);
                c2011ox2.m11071a(this.f12317p, 5);
                c2011ox2.m11071a(this.f12311j, 3);
                c2011ox2.m11071a(this.f12318q, 5);
                c2011ox2.m11071a(this.f12312k, 3);
                for (byte[] bArr3 : this.f12313l) {
                    C1935ng.m10749b(byteBuffer, bArr3.length);
                    byteBuffer.put(bArr3);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public long m11180a() {
        Iterator<byte[]> it = this.f12307f.iterator();
        long length = 6;
        while (it.hasNext()) {
            length = length + 2 + ((long) it.next().length);
        }
        long length2 = length + 1;
        Iterator<byte[]> it2 = this.f12308g.iterator();
        while (it2.hasNext()) {
            length2 = length2 + 2 + ((long) it2.next().length);
        }
        if (this.f12309h && (this.f12303b == 100 || this.f12303b == 110 || this.f12303b == 122 || this.f12303b == 144)) {
            Iterator<byte[]> it3 = this.f12313l.iterator();
            length2 += 4;
            while (it3.hasNext()) {
                length2 = length2 + 2 + ((long) it3.next().length);
            }
        }
        return length2;
    }

    public String toString() {
        return "AvcDecoderConfigurationRecord{configurationVersion=" + this.f12302a + ", avcProfileIndication=" + this.f12303b + ", profileCompatibility=" + this.f12304c + ", avcLevelIndication=" + this.f12305d + ", lengthSizeMinusOne=" + this.f12306e + ", hasExts=" + this.f12309h + ", chromaFormat=" + this.f12310i + ", bitDepthLumaMinus8=" + this.f12311j + ", bitDepthChromaMinus8=" + this.f12312k + ", lengthSizeMinusOnePaddingBits=" + this.f12314m + ", numberOfSequenceParameterSetsPaddingBits=" + this.f12315n + ", chromaFormatPaddingBits=" + this.f12316o + ", bitDepthLumaMinus8PaddingBits=" + this.f12317p + ", bitDepthChromaMinus8PaddingBits=" + this.f12318q + '}';
    }
}
