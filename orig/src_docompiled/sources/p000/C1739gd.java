package p000;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: gd */
/* JADX INFO: compiled from: ChildHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1739gd {

    /* JADX INFO: renamed from: a */
    final b f9910a;

    /* JADX INFO: renamed from: b */
    final a f9911b = new a();

    /* JADX INFO: renamed from: c */
    final List<View> f9912c = new ArrayList();

    /* JADX INFO: renamed from: gd$b */
    /* JADX INFO: compiled from: ChildHelper.java */
    public interface b {
        /* JADX INFO: renamed from: a */
        int mo3835a();

        /* JADX INFO: renamed from: a */
        int mo3836a(View view);

        /* JADX INFO: renamed from: a */
        void mo3837a(int i);

        /* JADX INFO: renamed from: a */
        void mo3838a(View view, int i);

        /* JADX INFO: renamed from: a */
        void mo3839a(View view, int i, ViewGroup.LayoutParams layoutParams);

        /* JADX INFO: renamed from: b */
        RecyclerView.AbstractC0624v mo3840b(View view);

        /* JADX INFO: renamed from: b */
        View mo3841b(int i);

        /* JADX INFO: renamed from: b */
        void mo3842b();

        /* JADX INFO: renamed from: c */
        void mo3843c(int i);

        /* JADX INFO: renamed from: c */
        void mo3844c(View view);

        /* JADX INFO: renamed from: d */
        void mo3845d(View view);
    }

    public C1739gd(b bVar) {
        this.f9910a = bVar;
    }

    /* JADX INFO: renamed from: g */
    private void m9354g(View view) {
        this.f9912c.add(view);
        this.f9910a.mo3844c(view);
    }

    /* JADX INFO: renamed from: h */
    private boolean m9355h(View view) {
        if (!this.f9912c.remove(view)) {
            return false;
        }
        this.f9910a.mo3845d(view);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m9361a(View view, boolean z) {
        m9360a(view, -1, z);
    }

    /* JADX INFO: renamed from: a */
    public void m9360a(View view, int i, boolean z) {
        int iM9353f;
        if (i < 0) {
            iM9353f = this.f9910a.mo3835a();
        } else {
            iM9353f = m9353f(i);
        }
        this.f9911b.m9376a(iM9353f, z);
        if (z) {
            m9354g(view);
        }
        this.f9910a.mo3838a(view, iM9353f);
    }

    /* JADX INFO: renamed from: f */
    private int m9353f(int i) {
        if (i < 0) {
            return -1;
        }
        int iMo3835a = this.f9910a.mo3835a();
        int i2 = i;
        while (i2 < iMo3835a) {
            int iM9380e = i - (i2 - this.f9911b.m9380e(i2));
            if (iM9380e == 0) {
                while (this.f9911b.m9378c(i2)) {
                    i2++;
                }
                return i2;
            }
            i2 += iM9380e;
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public void m9358a(View view) {
        int iMo3836a = this.f9910a.mo3836a(view);
        if (iMo3836a < 0) {
            return;
        }
        if (this.f9911b.m9379d(iMo3836a)) {
            m9355h(view);
        }
        this.f9910a.mo3837a(iMo3836a);
    }

    /* JADX INFO: renamed from: a */
    public void m9357a(int i) {
        int iM9353f = m9353f(i);
        View viewMo3841b = this.f9910a.mo3841b(iM9353f);
        if (viewMo3841b == null) {
            return;
        }
        if (this.f9911b.m9379d(iM9353f)) {
            m9355h(viewMo3841b);
        }
        this.f9910a.mo3837a(iM9353f);
    }

    /* JADX INFO: renamed from: b */
    public View m9364b(int i) {
        return this.f9910a.mo3841b(m9353f(i));
    }

    /* JADX INFO: renamed from: a */
    public void m9356a() {
        this.f9911b.m9374a();
        for (int size = this.f9912c.size() - 1; size >= 0; size--) {
            this.f9910a.mo3845d(this.f9912c.get(size));
            this.f9912c.remove(size);
        }
        this.f9910a.mo3842b();
    }

    /* JADX INFO: renamed from: c */
    public View m9366c(int i) {
        int size = this.f9912c.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = this.f9912c.get(i2);
            RecyclerView.AbstractC0624v abstractC0624vMo3840b = this.f9910a.mo3840b(view);
            if (abstractC0624vMo3840b.m4133d() == i && !abstractC0624vMo3840b.m4143n() && !abstractC0624vMo3840b.m4146q()) {
                return view;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m9359a(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        int iM9353f;
        if (i < 0) {
            iM9353f = this.f9910a.mo3835a();
        } else {
            iM9353f = m9353f(i);
        }
        this.f9911b.m9376a(iM9353f, z);
        if (z) {
            m9354g(view);
        }
        this.f9910a.mo3839a(view, iM9353f, layoutParams);
    }

    /* JADX INFO: renamed from: b */
    public int m9362b() {
        return this.f9910a.mo3835a() - this.f9912c.size();
    }

    /* JADX INFO: renamed from: c */
    public int m9365c() {
        return this.f9910a.mo3835a();
    }

    /* JADX INFO: renamed from: d */
    public View m9368d(int i) {
        return this.f9910a.mo3841b(i);
    }

    /* JADX INFO: renamed from: e */
    public void m9370e(int i) {
        int iM9353f = m9353f(i);
        this.f9911b.m9379d(iM9353f);
        this.f9910a.mo3843c(iM9353f);
    }

    /* JADX INFO: renamed from: b */
    public int m9363b(View view) {
        int iMo3836a = this.f9910a.mo3836a(view);
        if (iMo3836a == -1 || this.f9911b.m9378c(iMo3836a)) {
            return -1;
        }
        return iMo3836a - this.f9911b.m9380e(iMo3836a);
    }

    /* JADX INFO: renamed from: c */
    public boolean m9367c(View view) {
        return this.f9912c.contains(view);
    }

    /* JADX INFO: renamed from: d */
    public void m9369d(View view) {
        int iMo3836a = this.f9910a.mo3836a(view);
        if (iMo3836a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        this.f9911b.m9375a(iMo3836a);
        m9354g(view);
    }

    /* JADX INFO: renamed from: e */
    public void m9371e(View view) {
        int iMo3836a = this.f9910a.mo3836a(view);
        if (iMo3836a < 0) {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
        if (!this.f9911b.m9378c(iMo3836a)) {
            throw new RuntimeException("trying to unhide a view that was not hidden" + view);
        }
        this.f9911b.m9377b(iMo3836a);
        m9355h(view);
    }

    public String toString() {
        return this.f9911b.toString() + ", hidden list:" + this.f9912c.size();
    }

    /* JADX INFO: renamed from: f */
    public boolean m9372f(View view) {
        int iMo3836a = this.f9910a.mo3836a(view);
        if (iMo3836a == -1) {
            m9355h(view);
            return true;
        }
        if (!this.f9911b.m9378c(iMo3836a)) {
            return false;
        }
        this.f9911b.m9379d(iMo3836a);
        m9355h(view);
        this.f9910a.mo3837a(iMo3836a);
        return true;
    }

    /* JADX INFO: renamed from: gd$a */
    /* JADX INFO: compiled from: ChildHelper.java */
    static class a {

        /* JADX INFO: renamed from: a */
        long f9913a = 0;

        /* JADX INFO: renamed from: b */
        a f9914b;

        a() {
        }

        /* JADX INFO: renamed from: a */
        void m9375a(int i) {
            if (i >= 64) {
                m9373b();
                this.f9914b.m9375a(i - 64);
            } else {
                this.f9913a |= 1 << i;
            }
        }

        /* JADX INFO: renamed from: b */
        private void m9373b() {
            if (this.f9914b == null) {
                this.f9914b = new a();
            }
        }

        /* JADX INFO: renamed from: b */
        void m9377b(int i) {
            if (i >= 64) {
                if (this.f9914b != null) {
                    this.f9914b.m9377b(i - 64);
                    return;
                }
                return;
            }
            this.f9913a &= (1 << i) ^ (-1);
        }

        /* JADX INFO: renamed from: c */
        boolean m9378c(int i) {
            if (i < 64) {
                return (this.f9913a & (1 << i)) != 0;
            }
            m9373b();
            return this.f9914b.m9378c(i - 64);
        }

        /* JADX INFO: renamed from: a */
        void m9374a() {
            this.f9913a = 0L;
            if (this.f9914b != null) {
                this.f9914b.m9374a();
            }
        }

        /* JADX INFO: renamed from: a */
        void m9376a(int i, boolean z) {
            if (i >= 64) {
                m9373b();
                this.f9914b.m9376a(i - 64, z);
                return;
            }
            boolean z2 = (this.f9913a & Long.MIN_VALUE) != 0;
            long j = (1 << i) - 1;
            this.f9913a = (this.f9913a & j) | ((this.f9913a & (j ^ (-1))) << 1);
            if (z) {
                m9375a(i);
            } else {
                m9377b(i);
            }
            if (z2 || this.f9914b != null) {
                m9373b();
                this.f9914b.m9376a(0, z2);
            }
        }

        /* JADX INFO: renamed from: d */
        boolean m9379d(int i) {
            if (i >= 64) {
                m9373b();
                return this.f9914b.m9379d(i - 64);
            }
            long j = 1 << i;
            boolean z = (this.f9913a & j) != 0;
            this.f9913a &= j ^ (-1);
            long j2 = j - 1;
            this.f9913a = (this.f9913a & j2) | Long.rotateRight(this.f9913a & (j2 ^ (-1)), 1);
            if (this.f9914b != null) {
                if (this.f9914b.m9378c(0)) {
                    m9375a(63);
                }
                this.f9914b.m9379d(0);
            }
            return z;
        }

        /* JADX INFO: renamed from: e */
        int m9380e(int i) {
            if (this.f9914b == null) {
                if (i >= 64) {
                    return Long.bitCount(this.f9913a);
                }
                return Long.bitCount(this.f9913a & ((1 << i) - 1));
            }
            if (i < 64) {
                return Long.bitCount(this.f9913a & ((1 << i) - 1));
            }
            return this.f9914b.m9380e(i - 64) + Long.bitCount(this.f9913a);
        }

        public String toString() {
            if (this.f9914b == null) {
                return Long.toBinaryString(this.f9913a);
            }
            return this.f9914b.toString() + "xx" + Long.toBinaryString(this.f9913a);
        }
    }
}
