package p000;

import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.litepal.util.Const;
import p000.ark;

/* JADX INFO: renamed from: nr */
/* JADX INFO: compiled from: HandlerBox.java */
/* JADX INFO: loaded from: classes.dex */
public class C1950nr extends AbstractC1985oo {

    /* JADX INFO: renamed from: a */
    public static final Map<String, String> f11761a;

    /* JADX INFO: renamed from: p */
    private static final /* synthetic */ ark.InterfaceC0740a f11762p = null;

    /* JADX INFO: renamed from: q */
    private static final /* synthetic */ ark.InterfaceC0740a f11763q = null;

    /* JADX INFO: renamed from: r */
    private static final /* synthetic */ ark.InterfaceC0740a f11764r = null;

    /* JADX INFO: renamed from: s */
    private static final /* synthetic */ ark.InterfaceC0740a f11765s = null;

    /* JADX INFO: renamed from: t */
    private static final /* synthetic */ ark.InterfaceC0740a f11766t = null;

    /* JADX INFO: renamed from: u */
    private static final /* synthetic */ ark.InterfaceC0740a f11767u = null;

    /* JADX INFO: renamed from: b */
    private String f11768b;

    /* JADX INFO: renamed from: c */
    private String f11769c;

    /* JADX INFO: renamed from: k */
    private long f11770k;

    /* JADX INFO: renamed from: l */
    private long f11771l;

    /* JADX INFO: renamed from: m */
    private long f11772m;

    /* JADX INFO: renamed from: n */
    private boolean f11773n;

    /* JADX INFO: renamed from: o */
    private long f11774o;

    /* JADX INFO: renamed from: e */
    private static /* synthetic */ void m10795e() {
        aru aruVar = new aru("HandlerBox.java", C1950nr.class);
        f11762p = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getHandlerType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 78);
        f11763q = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setName", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", Const.TableSchema.COLUMN_NAME, "", "void"), 87);
        f11764r = aruVar.m5287a("method-execution", aruVar.m5288a("1", "setHandlerType", "com.coremedia.iso.boxes.HandlerBox", "java.lang.String", "handlerType", "", "void"), 91);
        f11765s = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getName", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 95);
        f11766t = aruVar.m5287a("method-execution", aruVar.m5288a("1", "getHumanReadableTrackType", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 99);
        f11767u = aruVar.m5287a("method-execution", aruVar.m5288a("1", "toString", "com.coremedia.iso.boxes.HandlerBox", "", "", "", "java.lang.String"), 149);
    }

    static {
        m10795e();
        HashMap map = new HashMap();
        map.put("odsm", "ObjectDescriptorStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("crsm", "ClockReferenceStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("sdsm", "SceneDescriptionStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("m7sm", "MPEG7Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ocsm", "ObjectContentInfoStream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("ipsm", "IPMP Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mjsm", "MPEG-J Stream - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        map.put("mdir", "Apple Meta Data iTunes Reader");
        map.put("mp7b", "MPEG-7 binary XML");
        map.put("mp7t", "MPEG-7 XML");
        map.put("vide", "Video Track");
        map.put("soun", "Sound Track");
        map.put("hint", "Hint Track");
        map.put("appl", "Apple specific");
        map.put("meta", "Timed Metadata track - defined in ISO/IEC JTC1/SC29/WG11 - CODING OF MOVING PICTURES AND AUDIO");
        f11761a = Collections.unmodifiableMap(map);
    }

    public C1950nr() {
        super("hdlr");
        this.f11769c = null;
        this.f11773n = true;
    }

    /* JADX INFO: renamed from: c */
    public String m10798c() {
        C1988or.m10919a().m10921a(aru.m5283a(f11762p, this, this));
        return this.f11768b;
    }

    /* JADX INFO: renamed from: a */
    public void m10796a(String str) {
        C1988or.m10919a().m10921a(aru.m5284a(f11763q, this, this, str));
        this.f11769c = str;
    }

    /* JADX INFO: renamed from: b */
    public void m10797b(String str) {
        C1988or.m10919a().m10921a(aru.m5284a(f11764r, this, this, str));
        this.f11768b = str;
    }

    /* JADX INFO: renamed from: d */
    public String m10799d() {
        C1988or.m10919a().m10921a(aru.m5283a(f11765s, this, this));
        return this.f11769c;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a_ */
    protected long mo10761a_() {
        if (this.f11773n) {
            return C1936nh.m10756b(this.f11769c) + 25;
        }
        return C1936nh.m10756b(this.f11769c) + 24;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: a */
    public void mo10760a(ByteBuffer byteBuffer) {
        m10904c(byteBuffer);
        this.f11774o = C1934nf.m10733a(byteBuffer);
        this.f11768b = C1934nf.m10743j(byteBuffer);
        this.f11770k = C1934nf.m10733a(byteBuffer);
        this.f11771l = C1934nf.m10733a(byteBuffer);
        this.f11772m = C1934nf.m10733a(byteBuffer);
        if (byteBuffer.remaining() > 0) {
            this.f11769c = C1934nf.m10734a(byteBuffer, byteBuffer.remaining());
            if (this.f11769c.endsWith("\u0000")) {
                this.f11769c = this.f11769c.substring(0, this.f11769c.length() - 1);
                this.f11773n = true;
                return;
            } else {
                this.f11773n = false;
                return;
            }
        }
        this.f11773n = false;
    }

    @Override // p000.AbstractC1983om
    /* JADX INFO: renamed from: b */
    protected void mo10762b(ByteBuffer byteBuffer) {
        m10907d(byteBuffer);
        C1935ng.m10750b(byteBuffer, this.f11774o);
        byteBuffer.put(C1933ne.m10731a(this.f11768b));
        C1935ng.m10750b(byteBuffer, this.f11770k);
        C1935ng.m10750b(byteBuffer, this.f11771l);
        C1935ng.m10750b(byteBuffer, this.f11772m);
        if (this.f11769c != null) {
            byteBuffer.put(C1936nh.m10755a(this.f11769c));
        }
        if (this.f11773n) {
            byteBuffer.put((byte) 0);
        }
    }

    public String toString() {
        C1988or.m10919a().m10921a(aru.m5283a(f11767u, this, this));
        return "HandlerBox[handlerType=" + m10798c() + ";name=" + m10799d() + "]";
    }
}
