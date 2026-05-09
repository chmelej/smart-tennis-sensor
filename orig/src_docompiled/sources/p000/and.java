package p000;

import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: compiled from: RealCall.java */
/* JADX INFO: loaded from: classes.dex */
final class and implements amj {

    /* JADX INFO: renamed from: a */
    final anb f2011a;

    /* JADX INFO: renamed from: b */
    final aoj f2012b;

    /* JADX INFO: renamed from: c */
    final ane f2013c;

    /* JADX INFO: renamed from: d */
    final boolean f2014d;

    /* JADX INFO: renamed from: e */
    private amv f2015e;

    /* JADX INFO: renamed from: f */
    private boolean f2016f;

    private and(anb anbVar, ane aneVar, boolean z) {
        this.f2011a = anbVar;
        this.f2013c = aneVar;
        this.f2014d = z;
        this.f2012b = new aoj(anbVar, z);
    }

    /* JADX INFO: renamed from: a */
    static and m2175a(anb anbVar, ane aneVar, boolean z) {
        and andVar = new and(anbVar, aneVar, z);
        andVar.f2015e = anbVar.m2154y().mo2047a(andVar);
        return andVar;
    }

    @Override // p000.amj
    /* JADX INFO: renamed from: a */
    public ane mo1964a() {
        return this.f2013c;
    }

    @Override // p000.amj
    /* JADX INFO: renamed from: b */
    public ang mo1966b() {
        synchronized (this) {
            if (this.f2016f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f2016f = true;
        }
        m2176h();
        this.f2015e.m2027a(this);
        try {
            try {
                this.f2011a.m2149t().m2021a(this);
                ang angVarM2181g = m2181g();
                if (angVarM2181g == null) {
                    throw new IOException("Canceled");
                }
                return angVarM2181g;
            } catch (IOException e) {
                this.f2015e.m2033a(this, e);
                throw e;
            }
        } finally {
            this.f2011a.m2149t().m2024b(this);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m2176h() {
        this.f2012b.m4645a(aph.m4853c().mo4823a("response.body().close()"));
    }

    @Override // p000.amj
    /* JADX INFO: renamed from: a */
    public void mo1965a(amk amkVar) {
        synchronized (this) {
            if (this.f2016f) {
                throw new IllegalStateException("Already Executed");
            }
            this.f2016f = true;
        }
        m2176h();
        this.f2015e.m2027a(this);
        this.f2011a.m2149t().m2020a(new C0215a(amkVar));
    }

    /* JADX INFO: renamed from: c */
    public boolean m2177c() {
        return this.f2012b.m4646a();
    }

    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public and clone() {
        return m2175a(this.f2011a, this.f2013c, this.f2014d);
    }

    /* JADX INFO: renamed from: and$a */
    /* JADX INFO: compiled from: RealCall.java */
    final class C0215a extends anl {

        /* JADX INFO: renamed from: c */
        private final amk f2018c;

        C0215a(amk amkVar) {
            super("OkHttp %s", and.this.m2180f());
            this.f2018c = amkVar;
        }

        /* JADX INFO: renamed from: a */
        String m2182a() {
            return and.this.f2013c.m4419a().m2085f();
        }

        /* JADX INFO: renamed from: b */
        and m2183b() {
            return and.this;
        }

        @Override // p000.anl
        /* JADX INFO: renamed from: c */
        protected void mo2184c() {
            IOException e;
            ang angVarM2181g;
            boolean z = true;
            try {
                try {
                    angVarM2181g = and.this.m2181g();
                } catch (IOException e2) {
                    e = e2;
                    z = false;
                }
                try {
                    if (and.this.f2012b.m4646a()) {
                        this.f2018c.mo1968a(and.this, new IOException("Canceled"));
                    } else {
                        this.f2018c.mo1967a(and.this, angVarM2181g);
                    }
                } catch (IOException e3) {
                    e = e3;
                    if (!z) {
                        and.this.f2015e.m2033a(and.this, e);
                        this.f2018c.mo1968a(and.this, e);
                    } else {
                        aph.m4853c().mo4825a(4, "Callback failure for " + and.this.m2179e(), e);
                    }
                }
            } finally {
                and.this.f2011a.m2149t().m2023b(this);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    String m2179e() {
        StringBuilder sb = new StringBuilder();
        sb.append(m2177c() ? "canceled " : "");
        sb.append(this.f2014d ? "web socket" : NotificationCompat.CATEGORY_CALL);
        sb.append(" to ");
        sb.append(m2180f());
        return sb.toString();
    }

    /* JADX INFO: renamed from: f */
    String m2180f() {
        return this.f2013c.m4419a().m2092m();
    }

    /* JADX INFO: renamed from: g */
    ang m2181g() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f2011a.m2152w());
        arrayList.add(this.f2012b);
        arrayList.add(new aoa(this.f2011a.m2136g()));
        arrayList.add(new ano(this.f2011a.m2137h()));
        arrayList.add(new ant(this.f2011a));
        if (!this.f2014d) {
            arrayList.addAll(this.f2011a.m2153x());
        }
        arrayList.add(new aob(this.f2014d));
        return new aog(arrayList, null, null, null, 0, this.f2013c, this, this.f2015e, this.f2011a.m2129a(), this.f2011a.m2131b(), this.f2011a.m2132c()).mo2116a(this.f2013c);
    }
}
