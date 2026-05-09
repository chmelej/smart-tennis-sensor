package p000;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: IdTracking.java */
/* JADX INFO: loaded from: classes.dex */
public class aem implements aff<aem, EnumC0040e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC0040e, afk> f593d;

    /* JADX INFO: renamed from: e */
    private static final aga f594e = new aga("IdTracking");

    /* JADX INFO: renamed from: f */
    private static final afr f595f = new afr("snapshots", (byte) 13, 1);

    /* JADX INFO: renamed from: g */
    private static final afr f596g = new afr("journals", (byte) 15, 2);

    /* JADX INFO: renamed from: h */
    private static final afr f597h = new afr("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: i */
    private static final Map<Class<? extends agc>, agd> f598i = new HashMap();

    /* JADX INFO: renamed from: a */
    public Map<String, ael> f599a;

    /* JADX INFO: renamed from: b */
    public List<aek> f600b;

    /* JADX INFO: renamed from: c */
    public String f601c;

    /* JADX INFO: renamed from: j */
    private EnumC0040e[] f602j = {EnumC0040e.JOURNALS, EnumC0040e.CHECKSUM};

    static {
        f598i.put(age.class, new C0037b());
        f598i.put(agf.class, new C0039d());
        EnumMap enumMap = new EnumMap(EnumC0040e.class);
        enumMap.put(EnumC0040e.SNAPSHOTS, new afk("snapshots", (byte) 1, new afn((byte) 13, new afl((byte) 11), new afo((byte) 12, ael.class))));
        enumMap.put(EnumC0040e.JOURNALS, new afk("journals", (byte) 2, new afm((byte) 15, new afo((byte) 12, aek.class))));
        enumMap.put(EnumC0040e.CHECKSUM, new afk("checksum", (byte) 2, new afl((byte) 11)));
        f593d = Collections.unmodifiableMap(enumMap);
        afk.m843a(aem.class, f593d);
    }

    /* JADX INFO: renamed from: aem$e */
    /* JADX INFO: compiled from: IdTracking.java */
    public enum EnumC0040e {
        SNAPSHOTS(1, "snapshots"),
        JOURNALS(2, "journals"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d */
        private static final Map<String, EnumC0040e> f606d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f608e;

        /* JADX INFO: renamed from: f */
        private final String f609f;

        static {
            for (EnumC0040e enumC0040e : EnumSet.allOf(EnumC0040e.class)) {
                f606d.put(enumC0040e.m589a(), enumC0040e);
            }
        }

        EnumC0040e(short s, String str) {
            this.f608e = s;
            this.f609f = str;
        }

        /* JADX INFO: renamed from: a */
        public String m589a() {
            return this.f609f;
        }
    }

    /* JADX INFO: renamed from: a */
    public Map<String, ael> m575a() {
        return this.f599a;
    }

    /* JADX INFO: renamed from: a */
    public aem m574a(Map<String, ael> map) {
        this.f599a = map;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m576a(boolean z) {
        if (z) {
            return;
        }
        this.f599a = null;
    }

    /* JADX INFO: renamed from: b */
    public List<aek> m577b() {
        return this.f600b;
    }

    /* JADX INFO: renamed from: a */
    public aem m573a(List<aek> list) {
        this.f600b = list;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public boolean m580c() {
        return this.f600b != null;
    }

    /* JADX INFO: renamed from: b */
    public void m578b(boolean z) {
        if (z) {
            return;
        }
        this.f600b = null;
    }

    /* JADX INFO: renamed from: d */
    public boolean m581d() {
        return this.f601c != null;
    }

    /* JADX INFO: renamed from: c */
    public void m579c(boolean z) {
        if (z) {
            return;
        }
        this.f601c = null;
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f598i.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f598i.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdTracking(");
        sb.append("snapshots:");
        if (this.f599a == null) {
            sb.append("null");
        } else {
            sb.append(this.f599a);
        }
        if (m580c()) {
            sb.append(", ");
            sb.append("journals:");
            if (this.f600b == null) {
                sb.append("null");
            } else {
                sb.append(this.f600b);
            }
        }
        if (m581d()) {
            sb.append(", ");
            sb.append("checksum:");
            if (this.f601c == null) {
                sb.append("null");
            } else {
                sb.append(this.f601c);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public void m582e() throws afw {
        if (this.f599a == null) {
            throw new afw("Required field 'snapshots' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: aem$b */
    /* JADX INFO: compiled from: IdTracking.java */
    static class C0037b implements agd {
        private C0037b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0036a mo541b() {
            return new C0036a();
        }
    }

    /* JADX INFO: renamed from: aem$a */
    /* JADX INFO: compiled from: IdTracking.java */
    static class C0036a extends age<aem> {
        private C0036a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aem aemVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    int i = 0;
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 13) {
                                afu afuVarMo867j = afvVar.mo867j();
                                aemVar.f599a = new HashMap(afuVarMo867j.f808c * 2);
                                while (i < afuVarMo867j.f808c) {
                                    String strMo879v = afvVar.mo879v();
                                    ael aelVar = new ael();
                                    aelVar.mo525a(afvVar);
                                    aemVar.f599a.put(strMo879v, aelVar);
                                    i++;
                                }
                                afvVar.mo868k();
                                aemVar.m576a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 15) {
                                afs afsVarMo869l = afvVar.mo869l();
                                aemVar.f600b = new ArrayList(afsVarMo869l.f805b);
                                while (i < afsVarMo869l.f805b) {
                                    aek aekVar = new aek();
                                    aekVar.mo525a(afvVar);
                                    aemVar.f600b.add(aekVar);
                                    i++;
                                }
                                afvVar.mo870m();
                                aemVar.m578b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 11) {
                                aemVar.f601c = afvVar.mo879v();
                                aemVar.m579c(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        default:
                            afy.m908a(afvVar, afrVarMo865h.f802b);
                            break;
                    }
                    afvVar.mo866i();
                } else {
                    afvVar.mo864g();
                    aemVar.m582e();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aem aemVar) throws afw {
            aemVar.m582e();
            afvVar.mo852a(aem.f594e);
            if (aemVar.f599a != null) {
                afvVar.mo849a(aem.f595f);
                afvVar.mo851a(new afu((byte) 11, (byte) 12, aemVar.f599a.size()));
                for (Map.Entry<String, ael> entry : aemVar.f599a.entrySet()) {
                    afvVar.mo853a(entry.getKey());
                    entry.getValue().mo529b(afvVar);
                }
                afvVar.mo860d();
                afvVar.mo857b();
            }
            if (aemVar.f600b != null && aemVar.m580c()) {
                afvVar.mo849a(aem.f596g);
                afvVar.mo850a(new afs((byte) 12, aemVar.f600b.size()));
                Iterator<aek> it = aemVar.f600b.iterator();
                while (it.hasNext()) {
                    it.next().mo529b(afvVar);
                }
                afvVar.mo862e();
                afvVar.mo857b();
            }
            if (aemVar.f601c != null && aemVar.m581d()) {
                afvVar.mo849a(aem.f597h);
                afvVar.mo853a(aemVar.f601c);
                afvVar.mo857b();
            }
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: aem$d */
    /* JADX INFO: compiled from: IdTracking.java */
    static class C0039d implements agd {
        private C0039d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0038c mo541b() {
            return new C0038c();
        }
    }

    /* JADX INFO: renamed from: aem$c */
    /* JADX INFO: compiled from: IdTracking.java */
    static class C0038c extends agf<aem> {
        private C0038c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aem aemVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo847a(aemVar.f599a.size());
            for (Map.Entry<String, ael> entry : aemVar.f599a.entrySet()) {
                agbVar.mo853a(entry.getKey());
                entry.getValue().mo529b(agbVar);
            }
            BitSet bitSet = new BitSet();
            if (aemVar.m580c()) {
                bitSet.set(0);
            }
            if (aemVar.m581d()) {
                bitSet.set(1);
            }
            agbVar.m912a(bitSet, 2);
            if (aemVar.m580c()) {
                agbVar.mo847a(aemVar.f600b.size());
                Iterator<aek> it = aemVar.f600b.iterator();
                while (it.hasNext()) {
                    it.next().mo529b(agbVar);
                }
            }
            if (aemVar.m581d()) {
                agbVar.mo853a(aemVar.f601c);
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aem aemVar) {
            agb agbVar = (agb) afvVar;
            afu afuVar = new afu((byte) 11, (byte) 12, agbVar.mo876s());
            aemVar.f599a = new HashMap(afuVar.f808c * 2);
            for (int i = 0; i < afuVar.f808c; i++) {
                String strV = agbVar.mo879v();
                ael aelVar = new ael();
                aelVar.mo525a(agbVar);
                aemVar.f599a.put(strV, aelVar);
            }
            aemVar.m576a(true);
            BitSet bitSetM913b = agbVar.m913b(2);
            if (bitSetM913b.get(0)) {
                afs afsVar = new afs((byte) 12, agbVar.mo876s());
                aemVar.f600b = new ArrayList(afsVar.f805b);
                for (int i2 = 0; i2 < afsVar.f805b; i2++) {
                    aek aekVar = new aek();
                    aekVar.mo525a(agbVar);
                    aemVar.f600b.add(aekVar);
                }
                aemVar.m578b(true);
            }
            if (bitSetM913b.get(1)) {
                aemVar.f601c = agbVar.mo879v();
                aemVar.m579c(true);
            }
        }
    }
}
