package p000;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import p000.C1960oa;
import p000.C1964oe;

/* JADX INFO: compiled from: MP4Builder.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class ajt {

    /* JADX INFO: renamed from: a */
    private C0172a f1356a = null;

    /* JADX INFO: renamed from: b */
    private aju f1357b = null;

    /* JADX INFO: renamed from: c */
    private FileOutputStream f1358c = null;

    /* JADX INFO: renamed from: d */
    private FileChannel f1359d = null;

    /* JADX INFO: renamed from: e */
    private long f1360e = 0;

    /* JADX INFO: renamed from: f */
    private long f1361f = 0;

    /* JADX INFO: renamed from: g */
    private boolean f1362g = true;

    /* JADX INFO: renamed from: h */
    private HashMap<ajy, long[]> f1363h = new HashMap<>();

    /* JADX INFO: renamed from: i */
    private ByteBuffer f1364i = null;

    /* JADX INFO: renamed from: a */
    public ajt m1622a(aju ajuVar) {
        this.f1357b = ajuVar;
        this.f1358c = new FileOutputStream(ajuVar.m1651c());
        this.f1359d = this.f1358c.getChannel();
        C1948np c1948npM1624a = m1624a();
        c1948npM1624a.mo1639a(this.f1359d);
        this.f1360e += c1948npM1624a.mo1637a();
        this.f1361f += this.f1360e;
        this.f1356a = new C0172a();
        this.f1364i = ByteBuffer.allocateDirect(4);
        return this;
    }

    /* JADX INFO: renamed from: b */
    private void m1620b() throws IOException {
        long jPosition = this.f1359d.position();
        this.f1359d.position(this.f1356a.m1641b());
        this.f1356a.mo1639a(this.f1359d);
        this.f1359d.position(jPosition);
        this.f1356a.m1638a(0L);
        this.f1356a.m1642b(0L);
        this.f1358c.flush();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1628a(int i, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo, boolean z) throws IOException {
        if (this.f1362g) {
            this.f1356a.m1642b(0L);
            this.f1356a.mo1639a(this.f1359d);
            this.f1356a.m1638a(this.f1360e);
            this.f1360e += 16;
            this.f1361f += 16;
            this.f1362g = false;
        }
        this.f1356a.m1642b(this.f1356a.m1643c() + ((long) bufferInfo.size));
        this.f1361f += (long) bufferInfo.size;
        boolean z2 = true;
        if (this.f1361f >= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) {
            m1620b();
            this.f1362g = true;
            this.f1361f -= PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
        } else {
            z2 = false;
        }
        this.f1357b.m1648a(i, this.f1360e, bufferInfo);
        byteBuffer.position(bufferInfo.offset + (z ? 0 : 4));
        byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
        if (!z) {
            this.f1364i.position(0);
            this.f1364i.putInt(bufferInfo.size - 4);
            this.f1364i.position(0);
            this.f1359d.write(this.f1364i);
        }
        this.f1359d.write(byteBuffer);
        this.f1360e += (long) bufferInfo.size;
        if (z2) {
            this.f1358c.flush();
        }
        return z2;
    }

    /* JADX INFO: renamed from: a */
    public int m1621a(MediaFormat mediaFormat, boolean z) {
        return this.f1357b.m1644a(mediaFormat, z);
    }

    /* JADX INFO: renamed from: a */
    public void m1627a(boolean z) throws IOException {
        if (this.f1356a.m1643c() != 0) {
            m1620b();
        }
        for (ajy ajyVar : this.f1357b.m1650b()) {
            ArrayList<ajw> arrayListM1671b = ajyVar.m1671b();
            long[] jArr = new long[arrayListM1671b.size()];
            for (int i = 0; i < jArr.length; i++) {
                jArr[i] = arrayListM1671b.get(i).m1662b();
            }
            this.f1363h.put(ajyVar, jArr);
        }
        m1631c(this.f1357b).mo1639a(this.f1359d);
        this.f1358c.flush();
        this.f1359d.close();
        this.f1358c.close();
    }

    /* JADX INFO: renamed from: a */
    protected C1948np m1624a() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("isom");
        linkedList.add("3gp4");
        return new C1948np("isom", 0L, linkedList);
    }

    /* JADX INFO: renamed from: ajt$a */
    /* JADX INFO: compiled from: MP4Builder.java */
    class C0172a implements InterfaceC1938nj {

        /* JADX INFO: renamed from: b */
        private InterfaceC1940nl f1366b;

        /* JADX INFO: renamed from: c */
        private long f1367c;

        /* JADX INFO: renamed from: d */
        private long f1368d;

        /* JADX INFO: renamed from: c */
        private boolean m1636c(long j) {
            return j + 8 < 4294967296L;
        }

        private C0172a() {
            this.f1367c = 1073741824L;
            this.f1368d = 0L;
        }

        /* JADX INFO: renamed from: b */
        public long m1641b() {
            return this.f1368d;
        }

        /* JADX INFO: renamed from: a */
        public void m1638a(long j) {
            this.f1368d = j;
        }

        @Override // p000.InterfaceC1938nj
        /* JADX INFO: renamed from: a */
        public void mo1640a(InterfaceC1940nl interfaceC1940nl) {
            this.f1366b = interfaceC1940nl;
        }

        /* JADX INFO: renamed from: b */
        public void m1642b(long j) {
            this.f1367c = j;
        }

        /* JADX INFO: renamed from: c */
        public long m1643c() {
            return this.f1367c;
        }

        @Override // p000.InterfaceC1938nj
        /* JADX INFO: renamed from: a */
        public long mo1637a() {
            return this.f1367c + 16;
        }

        @Override // p000.InterfaceC1938nj
        /* JADX INFO: renamed from: a */
        public void mo1639a(WritableByteChannel writableByteChannel) throws IOException {
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
            long jMo1637a = mo1637a();
            if (m1636c(jMo1637a)) {
                C1935ng.m10750b(byteBufferAllocate, jMo1637a);
            } else {
                C1935ng.m10750b(byteBufferAllocate, 1L);
            }
            byteBufferAllocate.put(C1933ne.m10731a("mdat"));
            if (m1636c(jMo1637a)) {
                byteBufferAllocate.put(new byte[8]);
            } else {
                C1935ng.m10746a(byteBufferAllocate, jMo1637a);
            }
            byteBufferAllocate.rewind();
            writableByteChannel.write(byteBufferAllocate);
        }
    }

    /* JADX INFO: renamed from: a */
    public static long m1619a(long j, long j2) {
        return j2 == 0 ? j : m1619a(j2, j % j2);
    }

    /* JADX INFO: renamed from: b */
    public long m1629b(aju ajuVar) {
        long jM1677h = !ajuVar.m1650b().isEmpty() ? ajuVar.m1650b().iterator().next().m1677h() : 0L;
        Iterator<ajy> it = ajuVar.m1650b().iterator();
        while (it.hasNext()) {
            jM1677h = m1619a(it.next().m1677h(), jM1677h);
        }
        return jM1677h;
    }

    /* JADX INFO: renamed from: c */
    protected C1954nv m1631c(aju ajuVar) {
        C1954nv c1954nv = new C1954nv();
        C1955nw c1955nw = new C1955nw();
        c1955nw.m10812a(new Date());
        c1955nw.m10815b(new Date());
        c1955nw.m10813a(C2030pp.f12194j);
        long jM1629b = m1629b(ajuVar);
        long j = 0;
        for (ajy ajyVar : ajuVar.m1650b()) {
            long jM1672c = (ajyVar.m1672c() * jM1629b) / ((long) ajyVar.m1677h());
            if (jM1672c > j) {
                j = jM1672c;
            }
        }
        c1955nw.m10814b(j);
        c1955nw.m10811a(jM1629b);
        c1955nw.m10817c(ajuVar.m1650b().size() + 1);
        c1954nv.m10910a(c1955nw);
        Iterator<ajy> it = ajuVar.m1650b().iterator();
        while (it.hasNext()) {
            c1954nv.m10910a((InterfaceC1938nj) m1625a(it.next(), ajuVar));
        }
        return c1954nv;
    }

    /* JADX INFO: renamed from: a */
    protected C1965of m1625a(ajy ajyVar, aju ajuVar) {
        C1965of c1965of = new C1965of();
        C1966og c1966og = new C1966og();
        c1966og.m10852a(true);
        c1966og.m10857b(true);
        c1966og.m10859c(true);
        if (ajyVar.m1683n()) {
            c1966og.m10851a(C2030pp.f12194j);
        } else {
            c1966og.m10851a(ajuVar.m1645a());
        }
        c1966og.m10854b(0);
        c1966og.m10850a(ajyVar.m1678i());
        c1966og.m10855b((ajyVar.m1672c() * m1629b(ajuVar)) / ((long) ajyVar.m1677h()));
        c1966og.m10853b(ajyVar.m1680k());
        c1966og.m10846a(ajyVar.m1679j());
        c1966og.m10848a(0);
        c1966og.m10856b(new Date());
        c1966og.m10849a(ajyVar.m1669a() + 1);
        c1966og.m10847a(ajyVar.m1681l());
        c1965of.m10910a(c1966og);
        C1951ns c1951ns = new C1951ns();
        c1965of.m10910a((InterfaceC1938nj) c1951ns);
        C1952nt c1952nt = new C1952nt();
        c1952nt.m10803a(ajyVar.m1678i());
        c1952nt.m10804b(ajyVar.m1672c());
        c1952nt.m10801a(ajyVar.m1677h());
        c1952nt.m10802a("eng");
        c1951ns.m10910a(c1952nt);
        C1950nr c1950nr = new C1950nr();
        c1950nr.m10796a(ajyVar.m1683n() ? "SoundHandle" : "VideoHandle");
        c1950nr.m10797b(ajyVar.m1673d());
        c1951ns.m10910a(c1950nr);
        C1953nu c1953nu = new C1953nu();
        c1953nu.m10910a(ajyVar.m1674e());
        C1942nn c1942nn = new C1942nn();
        C1943no c1943no = new C1943no();
        c1942nn.m10910a((InterfaceC1938nj) c1943no);
        C1941nm c1941nm = new C1941nm();
        c1941nm.m10906d(1);
        c1943no.m10910a(c1941nm);
        c1953nu.m10910a((InterfaceC1938nj) c1942nn);
        c1953nu.m10910a(m1623a(ajyVar));
        c1951ns.m10910a((InterfaceC1938nj) c1953nu);
        return c1965of;
    }

    /* JADX INFO: renamed from: a */
    protected InterfaceC1938nj m1623a(ajy ajyVar) {
        C1958nz c1958nz = new C1958nz();
        m1626a(ajyVar, c1958nz);
        m1630b(ajyVar, c1958nz);
        m1632c(ajyVar, c1958nz);
        m1633d(ajyVar, c1958nz);
        m1634e(ajyVar, c1958nz);
        m1635f(ajyVar, c1958nz);
        return c1958nz;
    }

    /* JADX INFO: renamed from: a */
    protected void m1626a(ajy ajyVar, C1958nz c1958nz) {
        c1958nz.m10910a((InterfaceC1938nj) ajyVar.m1675f());
    }

    /* JADX INFO: renamed from: b */
    protected void m1630b(ajy ajyVar, C1958nz c1958nz) {
        ArrayList arrayList = new ArrayList();
        Iterator<Long> it = ajyVar.m1682m().iterator();
        C1964oe.a aVar = null;
        while (it.hasNext()) {
            long jLongValue = it.next().longValue();
            if (aVar != null && aVar.m10844b() == jLongValue) {
                aVar.m10843a(aVar.m10842a() + 1);
            } else {
                aVar = new C1964oe.a(1L, jLongValue);
                arrayList.add(aVar);
            }
        }
        C1964oe c1964oe = new C1964oe();
        c1964oe.m10841a(arrayList);
        c1958nz.m10910a(c1964oe);
    }

    /* JADX INFO: renamed from: c */
    protected void m1632c(ajy ajyVar, C1958nz c1958nz) {
        long[] jArrM1676g = ajyVar.m1676g();
        if (jArrM1676g == null || jArrM1676g.length <= 0) {
            return;
        }
        C1963od c1963od = new C1963od();
        c1963od.m10839a(jArrM1676g);
        c1958nz.m10910a(c1963od);
    }

    /* JADX INFO: renamed from: d */
    protected void m1633d(ajy ajyVar, C1958nz c1958nz) {
        C1960oa c1960oa = new C1960oa();
        c1960oa.m10829a(new LinkedList());
        int size = ajyVar.m1671b().size();
        int i = 0;
        int i2 = 0;
        int i3 = -1;
        int i4 = 1;
        while (i < size) {
            ajw ajwVar = ajyVar.m1671b().get(i);
            i2++;
            if (i == size + (-1) || ajwVar.m1661a() + ajwVar.m1662b() != ajyVar.m1671b().get(i + 1).m1661a()) {
                if (i3 != i2) {
                    c1960oa.m10830c().add(new C1960oa.a(i4, i2, 1L));
                } else {
                    i2 = i3;
                }
                i4++;
                i3 = i2;
                i2 = 0;
            }
            i++;
        }
        c1958nz.m10910a(c1960oa);
    }

    /* JADX INFO: renamed from: e */
    protected void m1634e(ajy ajyVar, C1958nz c1958nz) {
        C1957ny c1957ny = new C1957ny();
        c1957ny.m10825a(this.f1363h.get(ajyVar));
        c1958nz.m10910a(c1957ny);
    }

    /* JADX INFO: renamed from: f */
    protected void m1635f(ajy ajyVar, C1958nz c1958nz) {
        ArrayList arrayList = new ArrayList();
        long jM1662b = -1;
        for (ajw ajwVar : ajyVar.m1671b()) {
            long jM1661a = ajwVar.m1661a();
            if (jM1662b != -1 && jM1662b != jM1661a) {
                jM1662b = -1;
            }
            if (jM1662b == -1) {
                arrayList.add(Long.valueOf(jM1661a));
            }
            jM1662b = jM1661a + ajwVar.m1662b();
        }
        long[] jArr = new long[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            jArr[i] = ((Long) arrayList.get(i)).longValue();
        }
        C1962oc c1962oc = new C1962oc();
        c1962oc.m10837a(jArr);
        c1958nz.m10910a(c1962oc);
    }
}
