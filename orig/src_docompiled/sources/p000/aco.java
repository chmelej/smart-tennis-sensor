package p000;

import android.content.Context;

/* JADX INFO: loaded from: classes.dex */
final class aco {

    /* JADX INFO: renamed from: f */
    private static volatile long f296f;

    /* JADX INFO: renamed from: a */
    private aai f297a;

    /* JADX INFO: renamed from: b */
    private acc f298b;

    /* JADX INFO: renamed from: c */
    private boolean f299c;

    /* JADX INFO: renamed from: d */
    private Context f300d;

    /* JADX INFO: renamed from: e */
    private long f301e = System.currentTimeMillis();

    public aco(aai aaiVar) {
        this.f298b = null;
        this.f299c = false;
        this.f300d = null;
        this.f297a = aaiVar;
        this.f298b = acb.m151a();
        this.f299c = aaiVar.m25f();
        this.f300d = aaiVar.m24e();
    }

    /* JADX INFO: renamed from: a */
    private void m250a(aax aaxVar) {
        aay.m38b(acd.f267t).m39a(this.f297a, aaxVar);
    }

    /* JADX INFO: renamed from: b */
    private void m252b() {
        if (acs.m266b().f308a <= 0 || !acb.f225m) {
            m250a(new acr(this));
        } else {
            acs.m266b().m281a(this.f297a, (aax) null, this.f299c, true);
            acs.m266b().m280a(-1);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m254a() {
        boolean z;
        if (acb.f220h <= 0) {
            z = false;
        } else {
            if (this.f301e > acd.f255h) {
                acd.f254g.clear();
                long unused = acd.f255h = this.f301e + acb.f221i;
                if (acb.m166b()) {
                    acd.f264q.m51a("clear methodsCalledLimitMap, nextLimitCallClearTime=" + acd.f255h);
                }
            }
            Integer numValueOf = Integer.valueOf(this.f297a.mo19b().m27a());
            Integer num = (Integer) acd.f254g.get(numValueOf);
            if (num != null) {
                acd.f254g.put(numValueOf, Integer.valueOf(num.intValue() + 1));
                if (num.intValue() > acb.f220h) {
                    if (acb.m166b()) {
                        acd.f264q.m57e("event " + this.f297a.m26g() + " was discard, cause of called limit, current:" + num + ", limit:" + acb.f220h + ", period:" + acb.f221i + " ms");
                    }
                    z = true;
                }
            } else {
                acd.f254g.put(numValueOf, 1);
            }
            z = false;
        }
        if (z) {
        }
        if (acb.f226n > 0 && this.f301e >= f296f) {
            acd.m215e(this.f300d);
            f296f = this.f301e + acb.f227o;
            if (acb.m166b()) {
                acd.f264q.m51a("nextFlushTime=" + f296f);
            }
        }
        if (!acf.m234a(this.f300d).m244f()) {
            acs.m255a(this.f300d).m281a(this.f297a, (aax) null, this.f299c, false);
            return;
        }
        if (acb.m166b()) {
            acd.f264q.m51a("sendFailedCount=" + acd.f248a);
        }
        if (acd.m203a()) {
            acs.m255a(this.f300d).m281a(this.f297a, (aax) null, this.f299c, false);
            if (this.f301e - acd.f249b > 1800000) {
                acd.m211c(this.f300d);
                return;
            }
            return;
        }
        if (this.f297a.m23d() != null && this.f297a.m23d().m228a()) {
            this.f298b = acc.INSTANT;
        }
        if (acb.f222j && acf.m234a(acd.f267t).m243e()) {
            this.f298b = acc.INSTANT;
        }
        if (acb.m166b()) {
            acd.f264q.m51a("strategy=" + this.f298b.name());
        }
        switch (aci.f285a[this.f298b.ordinal()]) {
            case 1:
                m252b();
                break;
            case 2:
                acs.m255a(this.f300d).m281a(this.f297a, (aax) null, this.f299c, false);
                if (acb.m166b()) {
                    acd.f264q.m51a("PERIOD currTime=" + this.f301e + ",nextPeriodSendTs=" + acd.f250c + ",difftime=" + (acd.f250c - this.f301e));
                }
                if (acd.f250c == 0) {
                    acd.f250c = aby.m126a(this.f300d, "last_period_ts");
                    if (this.f301e > acd.f250c) {
                        acd.m217f(this.f300d);
                    }
                    long jM181l = this.f301e + ((long) (acb.m181l() * 60 * 1000));
                    if (acd.f250c > jM181l) {
                        acd.f250c = jM181l;
                    }
                    aat.m33a(this.f300d).m35a();
                }
                if (acb.m166b()) {
                    acd.f264q.m51a("PERIOD currTime=" + this.f301e + ",nextPeriodSendTs=" + acd.f250c + ",difftime=" + (acd.f250c - this.f301e));
                }
                if (this.f301e > acd.f250c) {
                    acd.m217f(this.f300d);
                }
                break;
            case 3:
            case 4:
                acs.m255a(this.f300d).m281a(this.f297a, (aax) null, this.f299c, false);
                break;
            case 5:
                acs.m255a(this.f300d).m281a(this.f297a, (aax) new acp(this), this.f299c, true);
                break;
            case 6:
                if (acf.m234a(acd.f267t).m241c() != 1) {
                    acs.m255a(this.f300d).m281a(this.f297a, (aax) null, this.f299c, false);
                } else {
                    m252b();
                }
                break;
            case 7:
                if (abt.m95e(this.f300d)) {
                    m250a(new acq(this));
                }
                break;
            default:
                acd.f264q.m56d("Invalid stat strategy:" + acb.m151a());
                break;
        }
    }
}
