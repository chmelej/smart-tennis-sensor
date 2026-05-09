package p000;

import com.umeng.message.MsgConstant;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdJournal.java */
/* JADX INFO: loaded from: classes.dex */
public class aek implements aff<aek, EnumC0028e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: e */
    public static final Map<EnumC0028e, afk> f555e;

    /* JADX INFO: renamed from: f */
    private static final aga f556f = new aga("IdJournal");

    /* JADX INFO: renamed from: g */
    private static final afr f557g = new afr("domain", (byte) 11, 1);

    /* JADX INFO: renamed from: h */
    private static final afr f558h = new afr("old_id", (byte) 11, 2);

    /* JADX INFO: renamed from: i */
    private static final afr f559i = new afr("new_id", (byte) 11, 3);

    /* JADX INFO: renamed from: j */
    private static final afr f560j = new afr(MsgConstant.KEY_TS, (byte) 10, 4);

    /* JADX INFO: renamed from: k */
    private static final Map<Class<? extends agc>, agd> f561k = new HashMap();

    /* JADX INFO: renamed from: a */
    public String f562a;

    /* JADX INFO: renamed from: b */
    public String f563b;

    /* JADX INFO: renamed from: c */
    public String f564c;

    /* JADX INFO: renamed from: d */
    public long f565d;

    /* JADX INFO: renamed from: l */
    private byte f566l = 0;

    /* JADX INFO: renamed from: m */
    private EnumC0028e[] f567m = {EnumC0028e.OLD_ID};

    static {
        f561k.put(age.class, new C0025b());
        f561k.put(agf.class, new C0027d());
        EnumMap enumMap = new EnumMap(EnumC0028e.class);
        enumMap.put(EnumC0028e.DOMAIN, new afk("domain", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0028e.OLD_ID, new afk("old_id", (byte) 2, new afl((byte) 11)));
        enumMap.put(EnumC0028e.NEW_ID, new afk("new_id", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0028e.TS, new afk(MsgConstant.KEY_TS, (byte) 1, new afl((byte) 10)));
        f555e = Collections.unmodifiableMap(enumMap);
        afk.m843a(aek.class, f555e);
    }

    /* JADX INFO: renamed from: aek$e */
    /* JADX INFO: compiled from: IdJournal.java */
    public enum EnumC0028e {
        DOMAIN(1, "domain"),
        OLD_ID(2, "old_id"),
        NEW_ID(3, "new_id"),
        TS(4, MsgConstant.KEY_TS);


        /* JADX INFO: renamed from: e */
        private static final Map<String, EnumC0028e> f572e = new HashMap();

        /* JADX INFO: renamed from: f */
        private final short f574f;

        /* JADX INFO: renamed from: g */
        private final String f575g;

        static {
            for (EnumC0028e enumC0028e : EnumSet.allOf(EnumC0028e.class)) {
                f572e.put(enumC0028e.m545a(), enumC0028e);
            }
        }

        EnumC0028e(short s, String str) {
            this.f574f = s;
            this.f575g = str;
        }

        /* JADX INFO: renamed from: a */
        public String m545a() {
            return this.f575g;
        }
    }

    /* JADX INFO: renamed from: a */
    public aek m524a(String str) {
        this.f562a = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m526a(boolean z) {
        if (z) {
            return;
        }
        this.f562a = null;
    }

    /* JADX INFO: renamed from: b */
    public aek m528b(String str) {
        this.f563b = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public boolean m527a() {
        return this.f563b != null;
    }

    /* JADX INFO: renamed from: b */
    public void m530b(boolean z) {
        if (z) {
            return;
        }
        this.f563b = null;
    }

    /* JADX INFO: renamed from: c */
    public aek m532c(String str) {
        this.f564c = str;
        return this;
    }

    /* JADX INFO: renamed from: c */
    public void m534c(boolean z) {
        if (z) {
            return;
        }
        this.f564c = null;
    }

    /* JADX INFO: renamed from: a */
    public aek m523a(long j) {
        this.f565d = j;
        m535d(true);
        return this;
    }

    /* JADX INFO: renamed from: b */
    public boolean m531b() {
        return afd.m825a(this.f566l, 0);
    }

    /* JADX INFO: renamed from: d */
    public void m535d(boolean z) {
        this.f566l = afd.m823a(this.f566l, 0, z);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f561k.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f561k.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdJournal(");
        sb.append("domain:");
        if (this.f562a == null) {
            sb.append("null");
        } else {
            sb.append(this.f562a);
        }
        if (m527a()) {
            sb.append(", ");
            sb.append("old_id:");
            if (this.f563b == null) {
                sb.append("null");
            } else {
                sb.append(this.f563b);
            }
        }
        sb.append(", ");
        sb.append("new_id:");
        if (this.f564c == null) {
            sb.append("null");
        } else {
            sb.append(this.f564c);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f565d);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: c */
    public void m533c() throws afw {
        if (this.f562a == null) {
            throw new afw("Required field 'domain' was not present! Struct: " + toString());
        }
        if (this.f564c == null) {
            throw new afw("Required field 'new_id' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: aek$b */
    /* JADX INFO: compiled from: IdJournal.java */
    static class C0025b implements agd {
        private C0025b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0024a mo541b() {
            return new C0024a();
        }
    }

    /* JADX INFO: renamed from: aek$a */
    /* JADX INFO: compiled from: IdJournal.java */
    static class C0024a extends age<aek> {
        private C0024a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aek aekVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 11) {
                                aekVar.f562a = afvVar.mo879v();
                                aekVar.m526a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 11) {
                                aekVar.f563b = afvVar.mo879v();
                                aekVar.m530b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 11) {
                                aekVar.f564c = afvVar.mo879v();
                                aekVar.m534c(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 4:
                            if (afrVarMo865h.f802b == 10) {
                                aekVar.f565d = afvVar.mo877t();
                                aekVar.m535d(true);
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
                    if (!aekVar.m531b()) {
                        throw new afw("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                    aekVar.m533c();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aek aekVar) throws afw {
            aekVar.m533c();
            afvVar.mo852a(aek.f556f);
            if (aekVar.f562a != null) {
                afvVar.mo849a(aek.f557g);
                afvVar.mo853a(aekVar.f562a);
                afvVar.mo857b();
            }
            if (aekVar.f563b != null && aekVar.m527a()) {
                afvVar.mo849a(aek.f558h);
                afvVar.mo853a(aekVar.f563b);
                afvVar.mo857b();
            }
            if (aekVar.f564c != null) {
                afvVar.mo849a(aek.f559i);
                afvVar.mo853a(aekVar.f564c);
                afvVar.mo857b();
            }
            afvVar.mo849a(aek.f560j);
            afvVar.mo848a(aekVar.f565d);
            afvVar.mo857b();
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: aek$d */
    /* JADX INFO: compiled from: IdJournal.java */
    static class C0027d implements agd {
        private C0027d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0026c mo541b() {
            return new C0026c();
        }
    }

    /* JADX INFO: renamed from: aek$c */
    /* JADX INFO: compiled from: IdJournal.java */
    static class C0026c extends agf<aek> {
        private C0026c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aek aekVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo853a(aekVar.f562a);
            agbVar.mo853a(aekVar.f564c);
            agbVar.mo848a(aekVar.f565d);
            BitSet bitSet = new BitSet();
            if (aekVar.m527a()) {
                bitSet.set(0);
            }
            agbVar.m912a(bitSet, 1);
            if (aekVar.m527a()) {
                agbVar.mo853a(aekVar.f563b);
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aek aekVar) {
            agb agbVar = (agb) afvVar;
            aekVar.f562a = agbVar.mo879v();
            aekVar.m526a(true);
            aekVar.f564c = agbVar.mo879v();
            aekVar.m534c(true);
            aekVar.f565d = agbVar.mo877t();
            aekVar.m535d(true);
            if (agbVar.m913b(1).get(0)) {
                aekVar.f563b = agbVar.mo879v();
                aekVar.m530b(true);
            }
        }
    }
}
