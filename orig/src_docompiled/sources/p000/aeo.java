package p000;

import com.umeng.message.MsgConstant;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: ImprintValue.java */
/* JADX INFO: loaded from: classes.dex */
public class aeo implements aff<aeo, EnumC0052e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC0052e, afk> f627d;

    /* JADX INFO: renamed from: e */
    private static final aga f628e = new aga("ImprintValue");

    /* JADX INFO: renamed from: f */
    private static final afr f629f = new afr("value", (byte) 11, 1);

    /* JADX INFO: renamed from: g */
    private static final afr f630g = new afr(MsgConstant.KEY_TS, (byte) 10, 2);

    /* JADX INFO: renamed from: h */
    private static final afr f631h = new afr("guid", (byte) 11, 3);

    /* JADX INFO: renamed from: i */
    private static final Map<Class<? extends agc>, agd> f632i = new HashMap();

    /* JADX INFO: renamed from: a */
    public String f633a;

    /* JADX INFO: renamed from: b */
    public long f634b;

    /* JADX INFO: renamed from: c */
    public String f635c;

    /* JADX INFO: renamed from: j */
    private byte f636j = 0;

    /* JADX INFO: renamed from: k */
    private EnumC0052e[] f637k = {EnumC0052e.VALUE};

    static {
        f632i.put(age.class, new C0049b());
        f632i.put(agf.class, new C0051d());
        EnumMap enumMap = new EnumMap(EnumC0052e.class);
        enumMap.put(EnumC0052e.VALUE, new afk("value", (byte) 2, new afl((byte) 11)));
        enumMap.put(EnumC0052e.TS, new afk(MsgConstant.KEY_TS, (byte) 1, new afl((byte) 10)));
        enumMap.put(EnumC0052e.GUID, new afk("guid", (byte) 1, new afl((byte) 11)));
        f627d = Collections.unmodifiableMap(enumMap);
        afk.m843a(aeo.class, f627d);
    }

    /* JADX INFO: renamed from: aeo$e */
    /* JADX INFO: compiled from: ImprintValue.java */
    public enum EnumC0052e {
        VALUE(1, "value"),
        TS(2, MsgConstant.KEY_TS),
        GUID(3, "guid");


        /* JADX INFO: renamed from: d */
        private static final Map<String, EnumC0052e> f641d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f643e;

        /* JADX INFO: renamed from: f */
        private final String f644f;

        static {
            for (EnumC0052e enumC0052e : EnumSet.allOf(EnumC0052e.class)) {
                f641d.put(enumC0052e.m631a(), enumC0052e);
            }
        }

        EnumC0052e(short s, String str) {
            this.f643e = s;
            this.f644f = str;
        }

        /* JADX INFO: renamed from: a */
        public String m631a() {
            return this.f644f;
        }
    }

    /* JADX INFO: renamed from: a */
    public String m616a() {
        return this.f633a;
    }

    /* JADX INFO: renamed from: b */
    public boolean m619b() {
        return this.f633a != null;
    }

    /* JADX INFO: renamed from: a */
    public void m617a(boolean z) {
        if (z) {
            return;
        }
        this.f633a = null;
    }

    /* JADX INFO: renamed from: c */
    public long m620c() {
        return this.f634b;
    }

    /* JADX INFO: renamed from: d */
    public boolean m622d() {
        return afd.m825a(this.f636j, 0);
    }

    /* JADX INFO: renamed from: b */
    public void m618b(boolean z) {
        this.f636j = afd.m823a(this.f636j, 0, z);
    }

    /* JADX INFO: renamed from: e */
    public String m623e() {
        return this.f635c;
    }

    /* JADX INFO: renamed from: c */
    public void m621c(boolean z) {
        if (z) {
            return;
        }
        this.f635c = null;
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f632i.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f632i.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("ImprintValue(");
        if (m619b()) {
            sb.append("value:");
            if (this.f633a == null) {
                sb.append("null");
            } else {
                sb.append(this.f633a);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(", ");
        }
        sb.append("ts:");
        sb.append(this.f634b);
        sb.append(", ");
        sb.append("guid:");
        if (this.f635c == null) {
            sb.append("null");
        } else {
            sb.append(this.f635c);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    public void m624f() throws afw {
        if (this.f635c == null) {
            throw new afw("Required field 'guid' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: aeo$b */
    /* JADX INFO: compiled from: ImprintValue.java */
    static class C0049b implements agd {
        private C0049b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0048a mo541b() {
            return new C0048a();
        }
    }

    /* JADX INFO: renamed from: aeo$a */
    /* JADX INFO: compiled from: ImprintValue.java */
    static class C0048a extends age<aeo> {
        private C0048a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aeo aeoVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 11) {
                                aeoVar.f633a = afvVar.mo879v();
                                aeoVar.m617a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 10) {
                                aeoVar.f634b = afvVar.mo877t();
                                aeoVar.m618b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 11) {
                                aeoVar.f635c = afvVar.mo879v();
                                aeoVar.m621c(true);
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
                    if (!aeoVar.m622d()) {
                        throw new afw("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                    aeoVar.m624f();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aeo aeoVar) throws afw {
            aeoVar.m624f();
            afvVar.mo852a(aeo.f628e);
            if (aeoVar.f633a != null && aeoVar.m619b()) {
                afvVar.mo849a(aeo.f629f);
                afvVar.mo853a(aeoVar.f633a);
                afvVar.mo857b();
            }
            afvVar.mo849a(aeo.f630g);
            afvVar.mo848a(aeoVar.f634b);
            afvVar.mo857b();
            if (aeoVar.f635c != null) {
                afvVar.mo849a(aeo.f631h);
                afvVar.mo853a(aeoVar.f635c);
                afvVar.mo857b();
            }
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: aeo$d */
    /* JADX INFO: compiled from: ImprintValue.java */
    static class C0051d implements agd {
        private C0051d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0050c mo541b() {
            return new C0050c();
        }
    }

    /* JADX INFO: renamed from: aeo$c */
    /* JADX INFO: compiled from: ImprintValue.java */
    static class C0050c extends agf<aeo> {
        private C0050c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aeo aeoVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo848a(aeoVar.f634b);
            agbVar.mo853a(aeoVar.f635c);
            BitSet bitSet = new BitSet();
            if (aeoVar.m619b()) {
                bitSet.set(0);
            }
            agbVar.m912a(bitSet, 1);
            if (aeoVar.m619b()) {
                agbVar.mo853a(aeoVar.f633a);
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aeo aeoVar) {
            agb agbVar = (agb) afvVar;
            aeoVar.f634b = agbVar.mo877t();
            aeoVar.m618b(true);
            aeoVar.f635c = agbVar.mo879v();
            aeoVar.m621c(true);
            if (agbVar.m913b(1).get(0)) {
                aeoVar.f633a = agbVar.mo879v();
                aeoVar.m617a(true);
            }
        }
    }
}
