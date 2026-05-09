package p000;

import com.umeng.message.MsgConstant;
import java.io.Serializable;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: IdSnapshot.java */
/* JADX INFO: loaded from: classes.dex */
public class ael implements aff<ael, EnumC0034e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC0034e, afk> f576d;

    /* JADX INFO: renamed from: e */
    private static final aga f577e = new aga("IdSnapshot");

    /* JADX INFO: renamed from: f */
    private static final afr f578f = new afr("identity", (byte) 11, 1);

    /* JADX INFO: renamed from: g */
    private static final afr f579g = new afr(MsgConstant.KEY_TS, (byte) 10, 2);

    /* JADX INFO: renamed from: h */
    private static final afr f580h = new afr("version", (byte) 8, 3);

    /* JADX INFO: renamed from: i */
    private static final Map<Class<? extends agc>, agd> f581i = new HashMap();

    /* JADX INFO: renamed from: a */
    public String f582a;

    /* JADX INFO: renamed from: b */
    public long f583b;

    /* JADX INFO: renamed from: c */
    public int f584c;

    /* JADX INFO: renamed from: j */
    private byte f585j = 0;

    static {
        f581i.put(age.class, new C0031b());
        f581i.put(agf.class, new C0033d());
        EnumMap enumMap = new EnumMap(EnumC0034e.class);
        enumMap.put(EnumC0034e.IDENTITY, new afk("identity", (byte) 1, new afl((byte) 11)));
        enumMap.put(EnumC0034e.TS, new afk(MsgConstant.KEY_TS, (byte) 1, new afl((byte) 10)));
        enumMap.put(EnumC0034e.VERSION, new afk("version", (byte) 1, new afl((byte) 8)));
        f576d = Collections.unmodifiableMap(enumMap);
        afk.m843a(ael.class, f576d);
    }

    /* JADX INFO: renamed from: ael$e */
    /* JADX INFO: compiled from: IdSnapshot.java */
    public enum EnumC0034e {
        IDENTITY(1, "identity"),
        TS(2, MsgConstant.KEY_TS),
        VERSION(3, "version");


        /* JADX INFO: renamed from: d */
        private static final Map<String, EnumC0034e> f589d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f591e;

        /* JADX INFO: renamed from: f */
        private final String f592f;

        static {
            for (EnumC0034e enumC0034e : EnumSet.allOf(EnumC0034e.class)) {
                f589d.put(enumC0034e.m568a(), enumC0034e);
            }
        }

        EnumC0034e(short s, String str) {
            this.f591e = s;
            this.f592f = str;
        }

        /* JADX INFO: renamed from: a */
        public String m568a() {
            return this.f592f;
        }
    }

    /* JADX INFO: renamed from: a */
    public String m553a() {
        return this.f582a;
    }

    /* JADX INFO: renamed from: a */
    public ael m552a(String str) {
        this.f582a = str;
        return this;
    }

    /* JADX INFO: renamed from: a */
    public void m554a(boolean z) {
        if (z) {
            return;
        }
        this.f582a = null;
    }

    /* JADX INFO: renamed from: b */
    public long m555b() {
        return this.f583b;
    }

    /* JADX INFO: renamed from: a */
    public ael m551a(long j) {
        this.f583b = j;
        m556b(true);
        return this;
    }

    /* JADX INFO: renamed from: c */
    public boolean m558c() {
        return afd.m825a(this.f585j, 0);
    }

    /* JADX INFO: renamed from: b */
    public void m556b(boolean z) {
        this.f585j = afd.m823a(this.f585j, 0, z);
    }

    /* JADX INFO: renamed from: d */
    public int m559d() {
        return this.f584c;
    }

    /* JADX INFO: renamed from: a */
    public ael m550a(int i) {
        this.f584c = i;
        m557c(true);
        return this;
    }

    /* JADX INFO: renamed from: e */
    public boolean m560e() {
        return afd.m825a(this.f585j, 1);
    }

    /* JADX INFO: renamed from: c */
    public void m557c(boolean z) {
        this.f585j = afd.m823a(this.f585j, 1, z);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f581i.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f581i.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("IdSnapshot(");
        sb.append("identity:");
        if (this.f582a == null) {
            sb.append("null");
        } else {
            sb.append(this.f582a);
        }
        sb.append(", ");
        sb.append("ts:");
        sb.append(this.f583b);
        sb.append(", ");
        sb.append("version:");
        sb.append(this.f584c);
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    public void m561f() throws afw {
        if (this.f582a == null) {
            throw new afw("Required field 'identity' was not present! Struct: " + toString());
        }
    }

    /* JADX INFO: renamed from: ael$b */
    /* JADX INFO: compiled from: IdSnapshot.java */
    static class C0031b implements agd {
        private C0031b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0030a mo541b() {
            return new C0030a();
        }
    }

    /* JADX INFO: renamed from: ael$a */
    /* JADX INFO: compiled from: IdSnapshot.java */
    static class C0030a extends age<ael> {
        private C0030a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, ael aelVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 11) {
                                aelVar.f582a = afvVar.mo879v();
                                aelVar.m554a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 10) {
                                aelVar.f583b = afvVar.mo877t();
                                aelVar.m556b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 8) {
                                aelVar.f584c = afvVar.mo876s();
                                aelVar.m557c(true);
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
                    if (!aelVar.m558c()) {
                        throw new afw("Required field 'ts' was not found in serialized data! Struct: " + toString());
                    }
                    if (!aelVar.m560e()) {
                        throw new afw("Required field 'version' was not found in serialized data! Struct: " + toString());
                    }
                    aelVar.m561f();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, ael aelVar) throws afw {
            aelVar.m561f();
            afvVar.mo852a(ael.f577e);
            if (aelVar.f582a != null) {
                afvVar.mo849a(ael.f578f);
                afvVar.mo853a(aelVar.f582a);
                afvVar.mo857b();
            }
            afvVar.mo849a(ael.f579g);
            afvVar.mo848a(aelVar.f583b);
            afvVar.mo857b();
            afvVar.mo849a(ael.f580h);
            afvVar.mo847a(aelVar.f584c);
            afvVar.mo857b();
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: ael$d */
    /* JADX INFO: compiled from: IdSnapshot.java */
    static class C0033d implements agd {
        private C0033d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0032c mo541b() {
            return new C0032c();
        }
    }

    /* JADX INFO: renamed from: ael$c */
    /* JADX INFO: compiled from: IdSnapshot.java */
    static class C0032c extends agf<ael> {
        private C0032c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, ael aelVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo853a(aelVar.f582a);
            agbVar.mo848a(aelVar.f583b);
            agbVar.mo847a(aelVar.f584c);
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, ael aelVar) {
            agb agbVar = (agb) afvVar;
            aelVar.f582a = agbVar.mo879v();
            aelVar.m554a(true);
            aelVar.f583b = agbVar.mo877t();
            aelVar.m556b(true);
            aelVar.f584c = agbVar.mo876s();
            aelVar.m557c(true);
        }
    }
}
