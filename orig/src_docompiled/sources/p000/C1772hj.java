package p000;

import android.view.View;

/* JADX INFO: renamed from: hj */
/* JADX INFO: compiled from: ViewBoundsCheck.java */
/* JADX INFO: loaded from: classes.dex */
public class C1772hj {

    /* JADX INFO: renamed from: a */
    final b f10190a;

    /* JADX INFO: renamed from: b */
    a f10191b = new a();

    /* JADX INFO: renamed from: hj$b */
    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        int mo4017a();

        /* JADX INFO: renamed from: a */
        int mo4018a(View view);

        /* JADX INFO: renamed from: a */
        View mo4019a(int i);

        /* JADX INFO: renamed from: b */
        int mo4020b();

        /* JADX INFO: renamed from: b */
        int mo4021b(View view);
    }

    public C1772hj(b bVar) {
        this.f10190a = bVar;
    }

    /* JADX INFO: renamed from: hj$a */
    /* JADX INFO: compiled from: ViewBoundsCheck.java */
    static class a {

        /* JADX INFO: renamed from: a */
        int f10192a = 0;

        /* JADX INFO: renamed from: b */
        int f10193b;

        /* JADX INFO: renamed from: c */
        int f10194c;

        /* JADX INFO: renamed from: d */
        int f10195d;

        /* JADX INFO: renamed from: e */
        int f10196e;

        /* JADX INFO: renamed from: a */
        int m9653a(int i, int i2) {
            if (i > i2) {
                return 1;
            }
            return i == i2 ? 2 : 4;
        }

        a() {
        }

        /* JADX INFO: renamed from: a */
        void m9656a(int i, int i2, int i3, int i4) {
            this.f10193b = i;
            this.f10194c = i2;
            this.f10195d = i3;
            this.f10196e = i4;
        }

        /* JADX INFO: renamed from: a */
        void m9655a(int i) {
            this.f10192a = i | this.f10192a;
        }

        /* JADX INFO: renamed from: a */
        void m9654a() {
            this.f10192a = 0;
        }

        /* JADX INFO: renamed from: b */
        boolean m9657b() {
            if ((this.f10192a & 7) != 0 && (this.f10192a & (m9653a(this.f10195d, this.f10193b) << 0)) == 0) {
                return false;
            }
            if ((this.f10192a & 112) != 0 && (this.f10192a & (m9653a(this.f10195d, this.f10194c) << 4)) == 0) {
                return false;
            }
            if ((this.f10192a & 1792) == 0 || (this.f10192a & (m9653a(this.f10196e, this.f10193b) << 8)) != 0) {
                return (this.f10192a & 28672) == 0 || (this.f10192a & (m9653a(this.f10196e, this.f10194c) << 12)) != 0;
            }
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public View m9651a(int i, int i2, int i3, int i4) {
        int iMo4017a = this.f10190a.mo4017a();
        int iMo4020b = this.f10190a.mo4020b();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View viewMo4019a = this.f10190a.mo4019a(i);
            this.f10191b.m9656a(iMo4017a, iMo4020b, this.f10190a.mo4018a(viewMo4019a), this.f10190a.mo4021b(viewMo4019a));
            if (i3 != 0) {
                this.f10191b.m9654a();
                this.f10191b.m9655a(i3);
                if (this.f10191b.m9657b()) {
                    return viewMo4019a;
                }
            }
            if (i4 != 0) {
                this.f10191b.m9654a();
                this.f10191b.m9655a(i4);
                if (this.f10191b.m9657b()) {
                    view = viewMo4019a;
                }
            }
            i += i5;
        }
        return view;
    }

    /* JADX INFO: renamed from: a */
    public boolean m9652a(View view, int i) {
        this.f10191b.m9656a(this.f10190a.mo4017a(), this.f10190a.mo4020b(), this.f10190a.mo4018a(view), this.f10190a.mo4021b(view));
        if (i == 0) {
            return false;
        }
        this.f10191b.m9654a();
        this.f10191b.m9655a(i);
        return this.f10191b.m9657b();
    }
}
