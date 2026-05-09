package p000;

import android.content.Context;
import p000.adk;

/* JADX INFO: compiled from: ImLatent.java */
/* JADX INFO: loaded from: classes.dex */
public class aej implements aea {

    /* JADX INFO: renamed from: l */
    private static aej f543l;

    /* JADX INFO: renamed from: e */
    private afc f548e;

    /* JADX INFO: renamed from: f */
    private aef f549f;

    /* JADX INFO: renamed from: k */
    private Context f554k;

    /* JADX INFO: renamed from: a */
    private final long f544a = 1296000000;

    /* JADX INFO: renamed from: b */
    private final long f545b = 129600000;

    /* JADX INFO: renamed from: c */
    private final int f546c = 1800000;

    /* JADX INFO: renamed from: d */
    private final int f547d = 10000;

    /* JADX INFO: renamed from: g */
    private long f550g = 1296000000;

    /* JADX INFO: renamed from: h */
    private int f551h = 10000;

    /* JADX INFO: renamed from: i */
    private long f552i = 0;

    /* JADX INFO: renamed from: j */
    private long f553j = 0;

    /* JADX INFO: renamed from: a */
    public static synchronized aej m515a(Context context, aef aefVar) {
        if (f543l == null) {
            f543l = new aej(context, aefVar);
            f543l.mo425a(adk.m357a(context).m366b());
        }
        return f543l;
    }

    private aej(Context context, aef aefVar) {
        this.f554k = context;
        this.f548e = afc.m806a(context);
        this.f549f = aefVar;
    }

    /* JADX INFO: renamed from: a */
    public boolean m516a() {
        if (this.f548e.m817f() || this.f549f.m487e()) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.f549f.m494l();
        if (jCurrentTimeMillis > this.f550g) {
            this.f552i = aes.m703a(this.f551h, adf.m330a(this.f554k));
            this.f553j = jCurrentTimeMillis;
            return true;
        }
        if (jCurrentTimeMillis <= 129600000) {
            return false;
        }
        this.f552i = 0L;
        this.f553j = jCurrentTimeMillis;
        return true;
    }

    /* JADX INFO: renamed from: b */
    public long m517b() {
        return this.f552i;
    }

    @Override // p000.aea
    /* JADX INFO: renamed from: a */
    public void mo425a(adk.C0013a c0013a) {
        this.f550g = c0013a.m373a(1296000000L);
        int iM378b = c0013a.m378b(0);
        if (iM378b == 0) {
            if (acz.f345i <= 0 || acz.f345i > 1800000) {
                this.f551h = 10000;
                return;
            } else {
                this.f551h = acz.f345i;
                return;
            }
        }
        this.f551h = iM378b;
    }
}
