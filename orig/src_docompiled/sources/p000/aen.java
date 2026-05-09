package p000;

import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Imprint.java */
/* JADX INFO: loaded from: classes.dex */
public class aen implements aff<aen, EnumC0046e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC0046e, afk> f610d;

    /* JADX INFO: renamed from: e */
    private static final aga f611e = new aga("Imprint");

    /* JADX INFO: renamed from: f */
    private static final afr f612f = new afr("property", (byte) 13, 1);

    /* JADX INFO: renamed from: g */
    private static final afr f613g = new afr("version", (byte) 8, 2);

    /* JADX INFO: renamed from: h */
    private static final afr f614h = new afr("checksum", (byte) 11, 3);

    /* JADX INFO: renamed from: i */
    private static final Map<Class<? extends agc>, agd> f615i = new HashMap();

    /* JADX INFO: renamed from: a */
    public Map<String, aeo> f616a;

    /* JADX INFO: renamed from: b */
    public int f617b;

    /* JADX INFO: renamed from: c */
    public String f618c;

    /* JADX INFO: renamed from: j */
    private byte f619j = 0;

    static {
        f615i.put(age.class, new C0043b());
        f615i.put(agf.class, new C0045d());
        EnumMap enumMap = new EnumMap(EnumC0046e.class);
        enumMap.put(EnumC0046e.PROPERTY, new afk("property", (byte) 1, new afn((byte) 13, new afl((byte) 11), new afo((byte) 12, aeo.class))));
        enumMap.put(EnumC0046e.VERSION, new afk("version", (byte) 1, new afl((byte) 8)));
        enumMap.put(EnumC0046e.CHECKSUM, new afk("checksum", (byte) 1, new afl((byte) 11)));
        f610d = Collections.unmodifiableMap(enumMap);
        afk.m843a(aen.class, f610d);
    }

    /* JADX INFO: renamed from: aen$e */
    /* JADX INFO: compiled from: Imprint.java */
    public enum EnumC0046e {
        PROPERTY(1, "property"),
        VERSION(2, "version"),
        CHECKSUM(3, "checksum");


        /* JADX INFO: renamed from: d */
        private static final Map<String, EnumC0046e> f623d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f625e;

        /* JADX INFO: renamed from: f */
        private final String f626f;

        static {
            for (EnumC0046e enumC0046e : EnumSet.allOf(EnumC0046e.class)) {
                f623d.put(enumC0046e.m611a(), enumC0046e);
            }
        }

        EnumC0046e(short s, String str) {
            this.f625e = s;
            this.f626f = str;
        }

        /* JADX INFO: renamed from: a */
        public String m611a() {
            return this.f626f;
        }
    }

    /* JADX INFO: renamed from: a */
    public Map<String, aeo> m596a() {
        return this.f616a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m599b() {
        return this.f616a != null;
    }

    /* JADX INFO: renamed from: a */
    public void m597a(boolean z) {
        if (z) {
            return;
        }
        this.f616a = null;
    }

    /* JADX INFO: renamed from: c */
    public int m600c() {
        return this.f617b;
    }

    /* JADX INFO: renamed from: a */
    public aen m594a(int i) {
        this.f617b = i;
        m598b(true);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public boolean m602d() {
        return afd.m825a(this.f619j, 0);
    }

    /* JADX INFO: renamed from: b */
    public void m598b(boolean z) {
        this.f619j = afd.m823a(this.f619j, 0, z);
    }

    /* JADX INFO: renamed from: e */
    public String m603e() {
        return this.f618c;
    }

    /* JADX INFO: renamed from: a */
    public aen m595a(String str) {
        this.f618c = str;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m601c(boolean z) {
        if (z) {
            return;
        }
        this.f618c = null;
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f615i.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f615i.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Imprint(");
        sb.append("property:");
        if (this.f616a == null) {
            sb.append("null");
        } else {
            sb.append(this.f616a);
        }
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f617b);
        sb.append(", ");
        sb.append("checksum:");
        if (this.f618c == null) {
            sb.append("null");
        } else {
            sb.append(this.f618c);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    public void m604f() throws afw {
        if (this.f616a == null) {
            throw new afw("Required field 'property' was not present! Struct: " + toString());
        }
        if (this.f618c == null) {
            throw new afw("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: aen$b */
    /* JADX INFO: compiled from: Imprint.java */
    static class C0043b implements agd {
        private C0043b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0042a mo541b() {
            return new C0042a();
        }
    }

    /* JADX INFO: renamed from: aen$a */
    /* JADX INFO: compiled from: Imprint.java */
    static class C0042a extends age<aen> {
        private C0042a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aen aenVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 13) {
                                afu afuVarMo867j = afvVar.mo867j();
                                aenVar.f616a = new HashMap(afuVarMo867j.f808c * 2);
                                for (int i = 0; i < afuVarMo867j.f808c; i++) {
                                    String strMo879v = afvVar.mo879v();
                                    aeo aeoVar = new aeo();
                                    aeoVar.mo525a(afvVar);
                                    aenVar.f616a.put(strMo879v, aeoVar);
                                }
                                afvVar.mo868k();
                                aenVar.m597a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 8) {
                                aenVar.f617b = afvVar.mo876s();
                                aenVar.m598b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 11) {
                                aenVar.f618c = afvVar.mo879v();
                                aenVar.m601c(true);
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
                    if (!aenVar.m602d()) {
                        throw new afw("Required field 'version' was not found in serialized data! Struct: " + toString());
                    }
                    aenVar.m604f();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aen aenVar) throws afw {
            aenVar.m604f();
            afvVar.mo852a(aen.f611e);
            if (aenVar.f616a != null) {
                afvVar.mo849a(aen.f612f);
                afvVar.mo851a(new afu((byte) 11, (byte) 12, aenVar.f616a.size()));
                for (Map.Entry<String, aeo> entry : aenVar.f616a.entrySet()) {
                    afvVar.mo853a(entry.getKey());
                    entry.getValue().mo529b(afvVar);
                }
                afvVar.mo860d();
                afvVar.mo857b();
            }
            afvVar.mo849a(aen.f613g);
            afvVar.mo847a(aenVar.f617b);
            afvVar.mo857b();
            if (aenVar.f618c != null) {
                afvVar.mo849a(aen.f614h);
                afvVar.mo853a(aenVar.f618c);
                afvVar.mo857b();
            }
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: aen$d */
    /* JADX INFO: compiled from: Imprint.java */
    static class C0045d implements agd {
        private C0045d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0044c mo541b() {
            return new C0044c();
        }
    }

    /* JADX INFO: renamed from: aen$c */
    /* JADX INFO: compiled from: Imprint.java */
    static class C0044c extends agf<aen> {
        private C0044c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aen aenVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo847a(aenVar.f616a.size());
            for (Map.Entry<String, aeo> entry : aenVar.f616a.entrySet()) {
                agbVar.mo853a(entry.getKey());
                entry.getValue().mo529b(agbVar);
            }
            agbVar.mo847a(aenVar.f617b);
            agbVar.mo853a(aenVar.f618c);
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aen aenVar) {
            agb agbVar = (agb) afvVar;
            afu afuVar = new afu((byte) 11, (byte) 12, agbVar.mo876s());
            aenVar.f616a = new HashMap(afuVar.f808c * 2);
            for (int i = 0; i < afuVar.f808c; i++) {
                String strV = agbVar.mo879v();
                aeo aeoVar = new aeo();
                aeoVar.mo525a(agbVar);
                aenVar.f616a.put(strV, aeoVar);
            }
            aenVar.m597a(true);
            aenVar.f617b = agbVar.mo876s();
            aenVar.m598b(true);
            aenVar.f618c = agbVar.mo879v();
            aenVar.m601c(true);
        }
    }
}
