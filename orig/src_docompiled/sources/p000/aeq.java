package p000;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: UMEnvelope.java */
/* JADX INFO: loaded from: classes.dex */
public class aeq implements aff<aeq, EnumC0064e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: k */
    public static final Map<EnumC0064e, afk> f663k;

    /* JADX INFO: renamed from: l */
    private static final aga f664l = new aga("UMEnvelope");

    /* JADX INFO: renamed from: m */
    private static final afr f665m = new afr("version", (byte) 11, 1);

    /* JADX INFO: renamed from: n */
    private static final afr f666n = new afr("address", (byte) 11, 2);

    /* JADX INFO: renamed from: o */
    private static final afr f667o = new afr("signature", (byte) 11, 3);

    /* JADX INFO: renamed from: p */
    private static final afr f668p = new afr("serial_num", (byte) 8, 4);

    /* JADX INFO: renamed from: q */
    private static final afr f669q = new afr("ts_secs", (byte) 8, 5);

    /* JADX INFO: renamed from: r */
    private static final afr f670r = new afr("length", (byte) 8, 6);

    /* JADX INFO: renamed from: s */
    private static final afr f671s = new afr("entity", (byte) 11, 7);

    /* JADX INFO: renamed from: t */
    private static final afr f672t = new afr("guid", (byte) 11, 8);

    /* JADX INFO: renamed from: u */
    private static final afr f673u = new afr("checksum", (byte) 11, 9);

    /* JADX INFO: renamed from: v */
    private static final afr f674v = new afr("codex", (byte) 8, 10);

    /* JADX INFO: renamed from: w */
    private static final Map<Class<? extends agc>, agd> f675w = new HashMap();

    /* JADX INFO: renamed from: a */
    public String f676a;

    /* JADX INFO: renamed from: b */
    public String f677b;

    /* JADX INFO: renamed from: c */
    public String f678c;

    /* JADX INFO: renamed from: d */
    public int f679d;

    /* JADX INFO: renamed from: e */
    public int f680e;

    /* JADX INFO: renamed from: f */
    public int f681f;

    /* JADX INFO: renamed from: g */
    public ByteBuffer f682g;

    /* JADX INFO: renamed from: h */
    public String f683h;

    /* JADX INFO: renamed from: i */
    public String f684i;

    /* JADX INFO: renamed from: j */
    public int f685j;

    /* JADX INFO: renamed from: x */
    private byte f686x = 0;

    /* JADX INFO: renamed from: y */
    private EnumC0064e[] f687y = {EnumC0064e.CODEX};

    static {
        f675w.put(age.class, new C0061b());
        f675w.put(agf.class, new C0063d());
        EnumMap enumMap = new EnumMap(EnumC0064e.class);
        enumMap.put(EnumC0064e.VERSION, new afk("version", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0064e.ADDRESS, new afk("address", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0064e.SIGNATURE, new afk("signature", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0064e.SERIAL_NUM, new afk("serial_num", (byte) 1, new afl((byte) 8)));
        enumMap.put(EnumC0064e.TS_SECS, new afk("ts_secs", (byte) 1, new afl((byte) 8)));
        enumMap.put(EnumC0064e.LENGTH, new afk("length", (byte) 1, new afl((byte) 8)));
        enumMap.put(EnumC0064e.ENTITY, new afk("entity", (byte) 1, new afl((byte) 11, true)));
        enumMap.put(EnumC0064e.GUID, new afk("guid", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0064e.CHECKSUM, new afk("checksum", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0064e.CODEX, new afk("codex", (byte) 2, new afl((byte) 8)));
        f663k = Collections.unmodifiableMap(enumMap);
        afk.m843a(aeq.class, f663k);
    }

    /* JADX INFO: renamed from: aeq$e */
    /* JADX INFO: compiled from: UMEnvelope.java */
    public enum EnumC0064e {
        VERSION(1, "version"),
        ADDRESS(2, "address"),
        SIGNATURE(3, "signature"),
        SERIAL_NUM(4, "serial_num"),
        TS_SECS(5, "ts_secs"),
        LENGTH(6, "length"),
        ENTITY(7, "entity"),
        GUID(8, "guid"),
        CHECKSUM(9, "checksum"),
        CODEX(10, "codex");


        /* JADX INFO: renamed from: k */
        private static final Map<String, EnumC0064e> f698k = new HashMap();

        /* JADX INFO: renamed from: l */
        private final short f700l;

        /* JADX INFO: renamed from: m */
        private final String f701m;

        static {
            for (EnumC0064e enumC0064e : EnumSet.allOf(EnumC0064e.class)) {
                f698k.put(enumC0064e.m695a(), enumC0064e);
            }
        }

        EnumC0064e(short s, String str) {
            this.f700l = s;
            this.f701m = str;
        }

        /* JADX INFO: renamed from: a */
        public String m695a() {
            return this.f701m;
        }
    }

    /* JADX INFO: renamed from: a */
    public aeq m664a(String str) {
        this.f676a = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m667a(boolean z) {
        if (z) {
            return;
        }
        this.f676a = null;
    }

    /* JADX INFO: renamed from: b */
    public aeq m670b(String str) {
        this.f677b = str;
        return this;
    }

    /* JADX INFO: renamed from: b */
    public void m671b(boolean z) {
        if (z) {
            return;
        }
        this.f677b = null;
    }

    /* JADX INFO: renamed from: c */
    public aeq m674c(String str) {
        this.f678c = str;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m675c(boolean z) {
        if (z) {
            return;
        }
        this.f678c = null;
    }

    /* JADX INFO: renamed from: a */
    public aeq m663a(int i) {
        this.f679d = i;
        m679d(true);
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m668a() {
        return afd.m825a(this.f686x, 0);
    }

    /* JADX INFO: renamed from: d */
    public void m679d(boolean z) {
        this.f686x = afd.m823a(this.f686x, 0, z);
    }

    /* JADX INFO: renamed from: b */
    public aeq m669b(int i) {
        this.f680e = i;
        m683e(true);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public boolean m672b() {
        return afd.m825a(this.f686x, 1);
    }

    /* JADX INFO: renamed from: e */
    public void m683e(boolean z) {
        this.f686x = afd.m823a(this.f686x, 1, z);
    }

    /* JADX INFO: renamed from: c */
    public aeq m673c(int i) {
        this.f681f = i;
        m684f(true);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public boolean m676c() {
        return afd.m825a(this.f686x, 2);
    }

    /* JADX INFO: renamed from: f */
    public void m684f(boolean z) {
        this.f686x = afd.m823a(this.f686x, 2, z);
    }

    /* JADX INFO: renamed from: a */
    public aeq m666a(byte[] bArr) {
        m665a(bArr == null ? (ByteBuffer) null : ByteBuffer.wrap(bArr));
        return this;
    }

    /* JADX INFO: renamed from: a */
    public aeq m665a(ByteBuffer byteBuffer) {
        this.f682g = byteBuffer;
        return this;
    }

    /* JADX INFO: renamed from: g */
    public void m685g(boolean z) {
        if (z) {
            return;
        }
        this.f682g = null;
    }

    /* JADX INFO: renamed from: d */
    public aeq m678d(String str) {
        this.f683h = str;
        return this;
    }

    /* JADX INFO: renamed from: h */
    public void m686h(boolean z) {
        if (z) {
            return;
        }
        this.f683h = null;
    }

    /* JADX INFO: renamed from: e */
    public aeq m681e(String str) {
        this.f684i = str;
        return this;
    }

    /* JADX INFO: renamed from: i */
    public void m687i(boolean z) {
        if (z) {
            return;
        }
        this.f684i = null;
    }

    /* JADX INFO: renamed from: d */
    public aeq m677d(int i) {
        this.f685j = i;
        m688j(true);
        return this;
    }

    /* JADX INFO: renamed from: d */
    public boolean m680d() {
        return afd.m825a(this.f686x, 3);
    }

    /* JADX INFO: renamed from: j */
    public void m688j(boolean z) {
        this.f686x = afd.m823a(this.f686x, 3, z);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f675w.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f675w.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("UMEnvelope(");
        sb.append("version:");
        if (this.f676a == null) {
            sb.append("null");
        } else {
            sb.append(this.f676a);
        }
        sb.append(", ");
        sb.append("address:");
        if (this.f677b == null) {
            sb.append("null");
        } else {
            sb.append(this.f677b);
        }
        sb.append(", ");
        sb.append("signature:");
        if (this.f678c == null) {
            sb.append("null");
        } else {
            sb.append(this.f678c);
        }
        sb.append(", ");
        sb.append("serial_num:");
        sb.append(this.f679d);
        sb.append(", ");
        sb.append("ts_secs:");
        sb.append(this.f680e);
        sb.append(", ");
        sb.append("length:");
        sb.append(this.f681f);
        sb.append(", ");
        sb.append("entity:");
        if (this.f682g == null) {
            sb.append("null");
        } else {
            afg.m840a(this.f682g, sb);
        }
        sb.append(", ");
        sb.append("guid:");
        if (this.f683h == null) {
            sb.append("null");
        } else {
            sb.append(this.f683h);
        }
        sb.append(", ");
        sb.append("checksum:");
        if (this.f684i == null) {
            sb.append("null");
        } else {
            sb.append(this.f684i);
        }
        if (m680d()) {
            sb.append(", ");
            sb.append("codex:");
            sb.append(this.f685j);
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: e */
    public void m682e() throws afw {
        if (this.f676a == null) {
            throw new afw("Required field 'version' was not present! Struct: " + toString());
        }
        if (this.f677b == null) {
            throw new afw("Required field 'address' was not present! Struct: " + toString());
        }
        if (this.f678c == null) {
            throw new afw("Required field 'signature' was not present! Struct: " + toString());
        }
        if (this.f682g == null) {
            throw new afw("Required field 'entity' was not present! Struct: " + toString());
        }
        if (this.f683h == null) {
            throw new afw("Required field 'guid' was not present! Struct: " + toString());
        }
        if (this.f684i == null) {
            throw new afw("Required field 'checksum' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: aeq$b */
    /* JADX INFO: compiled from: UMEnvelope.java */
    static class C0061b implements agd {
        private C0061b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0060a mo541b() {
            return new C0060a();
        }
    }

    /* JADX INFO: renamed from: aeq$a */
    /* JADX INFO: compiled from: UMEnvelope.java */
    static class C0060a extends age<aeq> {
        private C0060a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aeq aeqVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 11) {
                                aeqVar.f676a = afvVar.mo879v();
                                aeqVar.m667a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 11) {
                                aeqVar.f677b = afvVar.mo879v();
                                aeqVar.m671b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 11) {
                                aeqVar.f678c = afvVar.mo879v();
                                aeqVar.m675c(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 4:
                            if (afrVarMo865h.f802b == 8) {
                                aeqVar.f679d = afvVar.mo876s();
                                aeqVar.m679d(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 5:
                            if (afrVarMo865h.f802b == 8) {
                                aeqVar.f680e = afvVar.mo876s();
                                aeqVar.m683e(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 6:
                            if (afrVarMo865h.f802b == 8) {
                                aeqVar.f681f = afvVar.mo876s();
                                aeqVar.m684f(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 7:
                            if (afrVarMo865h.f802b == 11) {
                                aeqVar.f682g = afvVar.mo880w();
                                aeqVar.m685g(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 8:
                            if (afrVarMo865h.f802b == 11) {
                                aeqVar.f683h = afvVar.mo879v();
                                aeqVar.m686h(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 9:
                            if (afrVarMo865h.f802b == 11) {
                                aeqVar.f684i = afvVar.mo879v();
                                aeqVar.m687i(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 10:
                            if (afrVarMo865h.f802b == 8) {
                                aeqVar.f685j = afvVar.mo876s();
                                aeqVar.m688j(true);
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
                    if (!aeqVar.m668a()) {
                        throw new afw("Required field 'serial_num' was not found in serialized data! Struct: " + toString());
                    }
                    if (!aeqVar.m672b()) {
                        throw new afw("Required field 'ts_secs' was not found in serialized data! Struct: " + toString());
                    }
                    if (!aeqVar.m676c()) {
                        throw new afw("Required field 'length' was not found in serialized data! Struct: " + toString());
                    }
                    aeqVar.m682e();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aeq aeqVar) throws afw {
            aeqVar.m682e();
            afvVar.mo852a(aeq.f664l);
            if (aeqVar.f676a != null) {
                afvVar.mo849a(aeq.f665m);
                afvVar.mo853a(aeqVar.f676a);
                afvVar.mo857b();
            }
            if (aeqVar.f677b != null) {
                afvVar.mo849a(aeq.f666n);
                afvVar.mo853a(aeqVar.f677b);
                afvVar.mo857b();
            }
            if (aeqVar.f678c != null) {
                afvVar.mo849a(aeq.f667o);
                afvVar.mo853a(aeqVar.f678c);
                afvVar.mo857b();
            }
            afvVar.mo849a(aeq.f668p);
            afvVar.mo847a(aeqVar.f679d);
            afvVar.mo857b();
            afvVar.mo849a(aeq.f669q);
            afvVar.mo847a(aeqVar.f680e);
            afvVar.mo857b();
            afvVar.mo849a(aeq.f670r);
            afvVar.mo847a(aeqVar.f681f);
            afvVar.mo857b();
            if (aeqVar.f682g != null) {
                afvVar.mo849a(aeq.f671s);
                afvVar.mo854a(aeqVar.f682g);
                afvVar.mo857b();
            }
            if (aeqVar.f683h != null) {
                afvVar.mo849a(aeq.f672t);
                afvVar.mo853a(aeqVar.f683h);
                afvVar.mo857b();
            }
            if (aeqVar.f684i != null) {
                afvVar.mo849a(aeq.f673u);
                afvVar.mo853a(aeqVar.f684i);
                afvVar.mo857b();
            }
            if (aeqVar.m680d()) {
                afvVar.mo849a(aeq.f674v);
                afvVar.mo847a(aeqVar.f685j);
                afvVar.mo857b();
            }
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: aeq$d */
    /* JADX INFO: compiled from: UMEnvelope.java */
    static class C0063d implements agd {
        private C0063d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0062c mo541b() {
            return new C0062c();
        }
    }

    /* JADX INFO: renamed from: aeq$c */
    /* JADX INFO: compiled from: UMEnvelope.java */
    static class C0062c extends agf<aeq> {
        private C0062c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aeq aeqVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo853a(aeqVar.f676a);
            agbVar.mo853a(aeqVar.f677b);
            agbVar.mo853a(aeqVar.f678c);
            agbVar.mo847a(aeqVar.f679d);
            agbVar.mo847a(aeqVar.f680e);
            agbVar.mo847a(aeqVar.f681f);
            agbVar.mo854a(aeqVar.f682g);
            agbVar.mo853a(aeqVar.f683h);
            agbVar.mo853a(aeqVar.f684i);
            BitSet bitSet = new BitSet();
            if (aeqVar.m680d()) {
                bitSet.set(0);
            }
            agbVar.m912a(bitSet, 1);
            if (aeqVar.m680d()) {
                agbVar.mo847a(aeqVar.f685j);
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aeq aeqVar) {
            agb agbVar = (agb) afvVar;
            aeqVar.f676a = agbVar.mo879v();
            aeqVar.m667a(true);
            aeqVar.f677b = agbVar.mo879v();
            aeqVar.m671b(true);
            aeqVar.f678c = agbVar.mo879v();
            aeqVar.m675c(true);
            aeqVar.f679d = agbVar.mo876s();
            aeqVar.m679d(true);
            aeqVar.f680e = agbVar.mo876s();
            aeqVar.m683e(true);
            aeqVar.f681f = agbVar.mo876s();
            aeqVar.m684f(true);
            aeqVar.f682g = agbVar.mo880w();
            aeqVar.m685g(true);
            aeqVar.f683h = agbVar.mo879v();
            aeqVar.m686h(true);
            aeqVar.f684i = agbVar.mo879v();
            aeqVar.m687i(true);
            if (agbVar.m913b(1).get(0)) {
                aeqVar.f685j = agbVar.mo876s();
                aeqVar.m688j(true);
            }
        }
    }
}
