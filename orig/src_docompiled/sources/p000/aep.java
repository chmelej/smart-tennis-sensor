package p000;

import android.support.v4.app.NotificationCompat;
import java.io.Serializable;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: Response.java */
/* JADX INFO: loaded from: classes.dex */
public class aep implements aff<aep, EnumC0058e>, Serializable, Cloneable {

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC0058e, afk> f645d;

    /* JADX INFO: renamed from: e */
    private static final aga f646e = new aga("Response");

    /* JADX INFO: renamed from: f */
    private static final afr f647f = new afr("resp_code", (byte) 8, 1);

    /* JADX INFO: renamed from: g */
    private static final afr f648g = new afr(NotificationCompat.CATEGORY_MESSAGE, (byte) 11, 2);

    /* JADX INFO: renamed from: h */
    private static final afr f649h = new afr("imprint", (byte) 12, 3);

    /* JADX INFO: renamed from: i */
    private static final Map<Class<? extends agc>, agd> f650i = new HashMap();

    /* JADX INFO: renamed from: a */
    public int f651a;

    /* JADX INFO: renamed from: b */
    public String f652b;

    /* JADX INFO: renamed from: c */
    public aen f653c;

    /* JADX INFO: renamed from: j */
    private byte f654j = 0;

    /* JADX INFO: renamed from: k */
    private EnumC0058e[] f655k = {EnumC0058e.MSG, EnumC0058e.IMPRINT};

    static {
        f650i.put(age.class, new C0055b());
        f650i.put(agf.class, new C0057d());
        EnumMap enumMap = new EnumMap(EnumC0058e.class);
        enumMap.put(EnumC0058e.RESP_CODE, new afk("resp_code", (byte) 1, new afl((byte) 8)));
        enumMap.put(EnumC0058e.MSG, new afk(NotificationCompat.CATEGORY_MESSAGE, (byte) 2, new afl((byte) 11)));
        enumMap.put(EnumC0058e.IMPRINT, new afk("imprint", (byte) 2, new afo((byte) 12, aen.class)));
        f645d = Collections.unmodifiableMap(enumMap);
        afk.m843a(aep.class, f645d);
    }

    /* JADX INFO: renamed from: aep$e */
    /* JADX INFO: compiled from: Response.java */
    public enum EnumC0058e {
        RESP_CODE(1, "resp_code"),
        MSG(2, NotificationCompat.CATEGORY_MESSAGE),
        IMPRINT(3, "imprint");


        /* JADX INFO: renamed from: d */
        private static final Map<String, EnumC0058e> f659d = new HashMap();

        /* JADX INFO: renamed from: e */
        private final short f661e;

        /* JADX INFO: renamed from: f */
        private final String f662f;

        static {
            for (EnumC0058e enumC0058e : EnumSet.allOf(EnumC0058e.class)) {
                f659d.put(enumC0058e.m651a(), enumC0058e);
            }
        }

        EnumC0058e(short s, String str) {
            this.f661e = s;
            this.f662f = str;
        }

        /* JADX INFO: renamed from: a */
        public String m651a() {
            return this.f662f;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m637a() {
        return afd.m825a(this.f654j, 0);
    }

    /* JADX INFO: renamed from: a */
    public void m636a(boolean z) {
        this.f654j = afd.m823a(this.f654j, 0, z);
    }

    /* JADX INFO: renamed from: b */
    public String m638b() {
        return this.f652b;
    }

    /* JADX INFO: renamed from: c */
    public boolean m641c() {
        return this.f652b != null;
    }

    /* JADX INFO: renamed from: b */
    public void m639b(boolean z) {
        if (z) {
            return;
        }
        this.f652b = null;
    }

    /* JADX INFO: renamed from: d */
    public aen m642d() {
        return this.f653c;
    }

    /* JADX INFO: renamed from: e */
    public boolean m643e() {
        return this.f653c != null;
    }

    /* JADX INFO: renamed from: c */
    public void m640c(boolean z) {
        if (z) {
            return;
        }
        this.f653c = null;
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: a */
    public void mo525a(afv afvVar) {
        f650i.get(afvVar.mo907y()).mo541b().mo539b(afvVar, this);
    }

    @Override // p000.aff
    /* JADX INFO: renamed from: b */
    public void mo529b(afv afvVar) {
        f650i.get(afvVar.mo907y()).mo541b().mo537a(afvVar, this);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Response(");
        sb.append("resp_code:");
        sb.append(this.f651a);
        if (m641c()) {
            sb.append(", ");
            sb.append("msg:");
            if (this.f652b == null) {
                sb.append("null");
            } else {
                sb.append(this.f652b);
            }
        }
        if (m643e()) {
            sb.append(", ");
            sb.append("imprint:");
            if (this.f653c == null) {
                sb.append("null");
            } else {
                sb.append(this.f653c);
            }
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    public void m644f() throws afw {
        if (this.f653c != null) {
            this.f653c.m604f();
        }
    }

    /* JADX INFO: renamed from: aep$b */
    /* JADX INFO: compiled from: Response.java */
    static class C0055b implements agd {
        private C0055b() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0054a mo541b() {
            return new C0054a();
        }
    }

    /* JADX INFO: renamed from: aep$a */
    /* JADX INFO: compiled from: Response.java */
    static class C0054a extends age<aep> {
        private C0054a() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aep aepVar) throws afw {
            afvVar.mo863f();
            while (true) {
                afr afrVarMo865h = afvVar.mo865h();
                if (afrVarMo865h.f802b != 0) {
                    switch (afrVarMo865h.f803c) {
                        case 1:
                            if (afrVarMo865h.f802b == 8) {
                                aepVar.f651a = afvVar.mo876s();
                                aepVar.m636a(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 2:
                            if (afrVarMo865h.f802b == 11) {
                                aepVar.f652b = afvVar.mo879v();
                                aepVar.m639b(true);
                            } else {
                                afy.m908a(afvVar, afrVarMo865h.f802b);
                            }
                            break;
                        case 3:
                            if (afrVarMo865h.f802b == 12) {
                                aepVar.f653c = new aen();
                                aepVar.f653c.mo525a(afvVar);
                                aepVar.m640c(true);
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
                    if (!aepVar.m637a()) {
                        throw new afw("Required field 'resp_code' was not found in serialized data! Struct: " + toString());
                    }
                    aepVar.m644f();
                    return;
                }
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aep aepVar) throws afw {
            aepVar.m644f();
            afvVar.mo852a(aep.f646e);
            afvVar.mo849a(aep.f647f);
            afvVar.mo847a(aepVar.f651a);
            afvVar.mo857b();
            if (aepVar.f652b != null && aepVar.m641c()) {
                afvVar.mo849a(aep.f648g);
                afvVar.mo853a(aepVar.f652b);
                afvVar.mo857b();
            }
            if (aepVar.f653c != null && aepVar.m643e()) {
                afvVar.mo849a(aep.f649h);
                aepVar.f653c.mo529b(afvVar);
                afvVar.mo857b();
            }
            afvVar.mo858c();
            afvVar.mo845a();
        }
    }

    /* JADX INFO: renamed from: aep$d */
    /* JADX INFO: compiled from: Response.java */
    static class C0057d implements agd {
        private C0057d() {
        }

        @Override // p000.agd
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0056c mo541b() {
            return new C0056c();
        }
    }

    /* JADX INFO: renamed from: aep$c */
    /* JADX INFO: compiled from: Response.java */
    static class C0056c extends agf<aep> {
        private C0056c() {
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo537a(afv afvVar, aep aepVar) {
            agb agbVar = (agb) afvVar;
            agbVar.mo847a(aepVar.f651a);
            BitSet bitSet = new BitSet();
            if (aepVar.m641c()) {
                bitSet.set(0);
            }
            if (aepVar.m643e()) {
                bitSet.set(1);
            }
            agbVar.m912a(bitSet, 2);
            if (aepVar.m641c()) {
                agbVar.mo853a(aepVar.f652b);
            }
            if (aepVar.m643e()) {
                aepVar.f653c.mo529b(agbVar);
            }
        }

        @Override // p000.agc
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo539b(afv afvVar, aep aepVar) {
            agb agbVar = (agb) afvVar;
            aepVar.f651a = agbVar.mo876s();
            aepVar.m636a(true);
            BitSet bitSetM913b = agbVar.m913b(2);
            if (bitSetM913b.get(0)) {
                aepVar.f652b = agbVar.mo879v();
                aepVar.m639b(true);
            }
            if (bitSetM913b.get(1)) {
                aepVar.f653c = new aen();
                aepVar.f653c.mo525a(agbVar);
                aepVar.m640c(true);
            }
        }
    }
}
