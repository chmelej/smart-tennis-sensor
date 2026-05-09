package p000;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.support.v4.media.session.PlaybackStateCompat;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: compiled from: Track.java */
/* JADX INFO: loaded from: classes.dex */
@TargetApi(16)
public class ajy {

    /* JADX INFO: renamed from: o */
    private static Map<Integer, Integer> f1400o = new HashMap();

    /* JADX INFO: renamed from: a */
    private long f1401a;

    /* JADX INFO: renamed from: c */
    private long f1403c;

    /* JADX INFO: renamed from: d */
    private String f1404d;

    /* JADX INFO: renamed from: e */
    private AbstractC1937ni f1405e;

    /* JADX INFO: renamed from: f */
    private C1956nx f1406f;

    /* JADX INFO: renamed from: g */
    private LinkedList<Integer> f1407g;

    /* JADX INFO: renamed from: h */
    private int f1408h;

    /* JADX INFO: renamed from: j */
    private int f1410j;

    /* JADX INFO: renamed from: k */
    private int f1411k;

    /* JADX INFO: renamed from: l */
    private float f1412l;

    /* JADX INFO: renamed from: b */
    private ArrayList<ajw> f1402b = new ArrayList<>();

    /* JADX INFO: renamed from: i */
    private Date f1409i = new Date();

    /* JADX INFO: renamed from: m */
    private ArrayList<Long> f1413m = new ArrayList<>();

    /* JADX INFO: renamed from: n */
    private boolean f1414n = false;

    /* JADX INFO: renamed from: p */
    private long f1415p = 0;

    /* JADX INFO: renamed from: q */
    private boolean f1416q = true;

    static {
        f1400o.put(96000, 0);
        f1400o.put(88200, 1);
        f1400o.put(64000, 2);
        f1400o.put(48000, 3);
        f1400o.put(44100, 4);
        f1400o.put(32000, 5);
        f1400o.put(24000, 6);
        f1400o.put(22050, 7);
        f1400o.put(16000, 8);
        f1400o.put(12000, 9);
        f1400o.put(11025, 10);
        f1400o.put(8000, 11);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public ajy(int i, MediaFormat mediaFormat, boolean z) {
        this.f1401a = 0L;
        this.f1403c = 0L;
        this.f1405e = null;
        this.f1406f = null;
        this.f1407g = null;
        this.f1412l = 0.0f;
        this.f1401a = i;
        if (!z) {
            this.f1413m.add(3015L);
            this.f1403c = 3015L;
            this.f1411k = mediaFormat.getInteger("width");
            this.f1410j = mediaFormat.getInteger("height");
            this.f1408h = 90000;
            this.f1407g = new LinkedList<>();
            this.f1404d = "vide";
            this.f1405e = new C1967oh();
            this.f1406f = new C1956nx();
            String string = mediaFormat.getString("mime");
            if (string.equals("video/avc")) {
                C1982ol c1982ol = new C1982ol("avc1");
                c1982ol.m10871a(1);
                c1982ol.m10890e(24);
                c1982ol.m10888d(1);
                c1982ol.m10881a(72.0d);
                c1982ol.m10883b(72.0d);
                c1982ol.m10884b(this.f1411k);
                c1982ol.m10886c(this.f1410j);
                C2047qd c2047qd = new C2047qd();
                if (mediaFormat.getByteBuffer("csd-0") != null) {
                    ArrayList arrayList = new ArrayList();
                    ByteBuffer byteBuffer = mediaFormat.getByteBuffer("csd-0");
                    byteBuffer.position(4);
                    byte[] bArr = new byte[byteBuffer.remaining()];
                    byteBuffer.get(bArr);
                    arrayList.add(bArr);
                    ArrayList arrayList2 = new ArrayList();
                    ByteBuffer byteBuffer2 = mediaFormat.getByteBuffer("csd-1");
                    byteBuffer2.position(4);
                    byte[] bArr2 = new byte[byteBuffer2.remaining()];
                    byteBuffer2.get(bArr2);
                    arrayList2.add(bArr2);
                    c2047qd.m11171a(arrayList);
                    c2047qd.m11173b(arrayList2);
                }
                c2047qd.m11175d(13);
                c2047qd.m11172b(100);
                c2047qd.m11178g(-1);
                c2047qd.m11179h(-1);
                c2047qd.m11177f(-1);
                c2047qd.m11170a(1);
                c2047qd.m11176e(3);
                c2047qd.m11174c(0);
                c1982ol.m10910a(c2047qd);
                this.f1406f.m10910a((InterfaceC1938nj) c1982ol);
                return;
            }
            if (string.equals("video/mp4v")) {
                C1982ol c1982ol2 = new C1982ol("mp4v");
                c1982ol2.m10871a(1);
                c1982ol2.m10890e(24);
                c1982ol2.m10888d(1);
                c1982ol2.m10881a(72.0d);
                c1982ol2.m10883b(72.0d);
                c1982ol2.m10884b(this.f1411k);
                c1982ol2.m10886c(this.f1410j);
                this.f1406f.m10910a((InterfaceC1938nj) c1982ol2);
                return;
            }
            return;
        }
        this.f1413m.add(Long.valueOf(PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID));
        this.f1403c = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID;
        this.f1412l = 1.0f;
        this.f1408h = mediaFormat.getInteger("sample-rate");
        this.f1404d = "soun";
        this.f1405e = new C1961ob();
        this.f1406f = new C1956nx();
        C1969oj c1969oj = new C1969oj("mp4a");
        c1969oj.m10874b(mediaFormat.getInteger("channel-count"));
        c1969oj.m10872a(mediaFormat.getInteger("sample-rate"));
        c1969oj.m10871a(1);
        c1969oj.m10876c(16);
        C2007ot c2007ot = new C2007ot();
        C2016pb c2016pb = new C2016pb();
        c2016pb.m11083a(0);
        C2022ph c2022ph = new C2022ph();
        c2022ph.m11089a(2);
        c2016pb.m11085a(c2022ph);
        C2012oy c2012oy = new C2012oy();
        c2012oy.m11073a(64);
        c2012oy.m11077b(5);
        c2012oy.m11079c(1536);
        c2012oy.m11074a(96000L);
        c2012oy.m11078b(96000L);
        C2008ou c2008ou = new C2008ou();
        c2008ou.m11058a(2);
        c2008ou.m11061b(f1400o.get(Integer.valueOf((int) c1969oj.m10875c())).intValue());
        c2008ou.m11062c(c1969oj.m10873b());
        c2012oy.m11075a(c2008ou);
        c2016pb.m11084a(c2012oy);
        ByteBuffer byteBufferM11086b = c2016pb.m11086b();
        c2007ot.m11048a(c2016pb);
        c2007ot.m11046e(byteBufferM11086b);
        c1969oj.m10910a(c2007ot);
        this.f1406f.m10910a((InterfaceC1938nj) c1969oj);
    }

    /* JADX INFO: renamed from: a */
    public long m1669a() {
        return this.f1401a;
    }

    /* JADX INFO: renamed from: a */
    public void m1670a(long j, MediaCodec.BufferInfo bufferInfo) {
        boolean z = (this.f1414n || (bufferInfo.flags & 1) == 0) ? false : true;
        this.f1402b.add(new ajw(j, bufferInfo.size));
        if (this.f1407g != null && z) {
            this.f1407g.add(Integer.valueOf(this.f1402b.size()));
        }
        long j2 = bufferInfo.presentationTimeUs - this.f1415p;
        this.f1415p = bufferInfo.presentationTimeUs;
        long j3 = ((j2 * ((long) this.f1408h)) + 500000) / 1000000;
        if (!this.f1416q) {
            this.f1413m.add(this.f1413m.size() - 1, Long.valueOf(j3));
            this.f1403c += j3;
        }
        this.f1416q = false;
    }

    /* JADX INFO: renamed from: b */
    public ArrayList<ajw> m1671b() {
        return this.f1402b;
    }

    /* JADX INFO: renamed from: c */
    public long m1672c() {
        return this.f1403c;
    }

    /* JADX INFO: renamed from: d */
    public String m1673d() {
        return this.f1404d;
    }

    /* JADX INFO: renamed from: e */
    public AbstractC1937ni m1674e() {
        return this.f1405e;
    }

    /* JADX INFO: renamed from: f */
    public C1956nx m1675f() {
        return this.f1406f;
    }

    /* JADX INFO: renamed from: g */
    public long[] m1676g() {
        if (this.f1407g == null || this.f1407g.isEmpty()) {
            return null;
        }
        long[] jArr = new long[this.f1407g.size()];
        for (int i = 0; i < this.f1407g.size(); i++) {
            jArr[i] = this.f1407g.get(i).intValue();
        }
        return jArr;
    }

    /* JADX INFO: renamed from: h */
    public int m1677h() {
        return this.f1408h;
    }

    /* JADX INFO: renamed from: i */
    public Date m1678i() {
        return this.f1409i;
    }

    /* JADX INFO: renamed from: j */
    public int m1679j() {
        return this.f1411k;
    }

    /* JADX INFO: renamed from: k */
    public int m1680k() {
        return this.f1410j;
    }

    /* JADX INFO: renamed from: l */
    public float m1681l() {
        return this.f1412l;
    }

    /* JADX INFO: renamed from: m */
    public ArrayList<Long> m1682m() {
        return this.f1413m;
    }

    /* JADX INFO: renamed from: n */
    public boolean m1683n() {
        return this.f1414n;
    }
}
