package p000;

import android.support.p002v8.renderscript.RenderScript;

/* JADX INFO: renamed from: hy */
/* JADX INFO: compiled from: Type.java */
/* JADX INFO: loaded from: classes.dex */
public class C1787hy extends C1777ho {

    /* JADX INFO: renamed from: a */
    int f10280a;

    /* JADX INFO: renamed from: b */
    int f10281b;

    /* JADX INFO: renamed from: c */
    int f10282c;

    /* JADX INFO: renamed from: d */
    boolean f10283d;

    /* JADX INFO: renamed from: e */
    boolean f10284e;

    /* JADX INFO: renamed from: f */
    int f10285f;

    /* JADX INFO: renamed from: g */
    int f10286g;

    /* JADX INFO: renamed from: h */
    C1778hp f10287h;

    /* JADX INFO: renamed from: hy$b */
    /* JADX INFO: compiled from: Type.java */
    public enum b {
        POSITIVE_X(0),
        NEGATIVE_X(1),
        POSITIVE_Y(2),
        NEGATIVE_Y(3),
        POSITIVE_Z(4),
        NEGATIVE_Z(5);


        /* JADX INFO: renamed from: g */
        int f10303g;

        b(int i) {
            this.f10303g = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public C1778hp m9724a() {
        return this.f10287h;
    }

    /* JADX INFO: renamed from: e */
    public int m9725e() {
        return this.f10280a;
    }

    /* JADX INFO: renamed from: f */
    public int m9726f() {
        return this.f10281b;
    }

    /* JADX INFO: renamed from: g */
    public int m9727g() {
        return this.f10282c;
    }

    /* JADX INFO: renamed from: h */
    public boolean m9728h() {
        return this.f10283d;
    }

    /* JADX INFO: renamed from: i */
    public boolean m9729i() {
        return this.f10284e;
    }

    /* JADX INFO: renamed from: j */
    public int m9730j() {
        return this.f10286g;
    }

    /* JADX INFO: renamed from: k */
    void m9731k() {
        boolean zM9728h = m9728h();
        int iM9725e = m9725e();
        int iM9726f = m9726f();
        int iM9727g = m9727g();
        int i = m9729i() ? 6 : 1;
        if (iM9725e == 0) {
            iM9725e = 1;
        }
        if (iM9726f == 0) {
            iM9726f = 1;
        }
        if (iM9727g == 0) {
            iM9727g = 1;
        }
        int i2 = iM9725e * iM9726f * iM9727g * i;
        while (zM9728h && (iM9725e > 1 || iM9726f > 1 || iM9727g > 1)) {
            if (iM9725e > 1) {
                iM9725e >>= 1;
            }
            if (iM9726f > 1) {
                iM9726f >>= 1;
            }
            if (iM9727g > 1) {
                iM9727g >>= 1;
            }
            i2 += iM9725e * iM9726f * iM9727g * i;
        }
        this.f10286g = i2;
    }

    C1787hy(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    /* JADX INFO: renamed from: a */
    public long m9723a(RenderScript renderScript, long j) {
        return renderScript.m4405b(j, this.f10280a, this.f10281b, this.f10282c, this.f10283d, this.f10284e, this.f10285f);
    }

    /* JADX INFO: renamed from: hy$a */
    /* JADX INFO: compiled from: Type.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        RenderScript f10288a;

        /* JADX INFO: renamed from: b */
        int f10289b = 1;

        /* JADX INFO: renamed from: c */
        int f10290c;

        /* JADX INFO: renamed from: d */
        int f10291d;

        /* JADX INFO: renamed from: e */
        boolean f10292e;

        /* JADX INFO: renamed from: f */
        boolean f10293f;

        /* JADX INFO: renamed from: g */
        int f10294g;

        /* JADX INFO: renamed from: h */
        C1778hp f10295h;

        public a(RenderScript renderScript, C1778hp c1778hp) {
            c1778hp.m9700d();
            this.f10288a = renderScript;
            this.f10295h = c1778hp;
        }

        /* JADX INFO: renamed from: a */
        public a m9732a(int i) {
            if (i < 1) {
                throw new C1781hs("Values of less than 1 for Dimension X are not valid.");
            }
            this.f10289b = i;
            return this;
        }

        /* JADX INFO: renamed from: b */
        public a m9735b(int i) {
            if (i < 1) {
                throw new C1781hs("Values of less than 1 for Dimension Y are not valid.");
            }
            this.f10290c = i;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public a m9733a(boolean z) {
            this.f10292e = z;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C1787hy m9734a() {
            if (this.f10291d > 0) {
                if (this.f10289b < 1 || this.f10290c < 1) {
                    throw new C1782ht("Both X and Y dimension required when Z is present.");
                }
                if (this.f10293f) {
                    throw new C1782ht("Cube maps not supported with 3D types.");
                }
            }
            if (this.f10290c > 0 && this.f10289b < 1) {
                throw new C1782ht("X dimension required when Y is present.");
            }
            if (this.f10293f && this.f10290c < 1) {
                throw new C1782ht("Cube maps require 2D Types.");
            }
            if (this.f10294g != 0 && (this.f10291d != 0 || this.f10293f || this.f10292e)) {
                throw new C1782ht("YUV only supports basic 2D.");
            }
            C1787hy c1787hy = new C1787hy(this.f10288a.m4393a(this.f10295h.m9698a(this.f10288a), this.f10289b, this.f10290c, this.f10291d, this.f10292e, this.f10293f, this.f10294g), this.f10288a);
            c1787hy.f10287h = this.f10295h;
            c1787hy.f10280a = this.f10289b;
            c1787hy.f10281b = this.f10290c;
            c1787hy.f10282c = this.f10291d;
            c1787hy.f10283d = this.f10292e;
            c1787hy.f10284e = this.f10293f;
            c1787hy.f10285f = this.f10294g;
            c1787hy.m9731k();
            return c1787hy;
        }
    }
}
