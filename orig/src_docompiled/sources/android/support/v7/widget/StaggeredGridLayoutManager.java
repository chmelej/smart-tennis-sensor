package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import p000.AbstractC1752gq;
import p000.C1749gn;
import p000.C1757gv;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView.AbstractC0611i implements RecyclerView.AbstractC0620r.b {

    /* JADX INFO: renamed from: A */
    private SavedState f3950A;

    /* JADX INFO: renamed from: B */
    private int f3951B;

    /* JADX INFO: renamed from: G */
    private int[] f3956G;

    /* JADX INFO: renamed from: a */
    C0652b[] f3958a;

    /* JADX INFO: renamed from: b */
    AbstractC1752gq f3959b;

    /* JADX INFO: renamed from: c */
    AbstractC1752gq f3960c;

    /* JADX INFO: renamed from: j */
    private int f3967j;

    /* JADX INFO: renamed from: k */
    private int f3968k;

    /* JADX INFO: renamed from: l */
    private final C1749gn f3969l;

    /* JADX INFO: renamed from: m */
    private BitSet f3970m;

    /* JADX INFO: renamed from: o */
    private boolean f3972o;

    /* JADX INFO: renamed from: z */
    private boolean f3973z;

    /* JADX INFO: renamed from: i */
    private int f3966i = -1;

    /* JADX INFO: renamed from: d */
    boolean f3961d = false;

    /* JADX INFO: renamed from: e */
    boolean f3962e = false;

    /* JADX INFO: renamed from: f */
    int f3963f = -1;

    /* JADX INFO: renamed from: g */
    int f3964g = ExploreByTouchHelper.INVALID_ID;

    /* JADX INFO: renamed from: h */
    LazySpanLookup f3965h = new LazySpanLookup();

    /* JADX INFO: renamed from: n */
    private int f3971n = 2;

    /* JADX INFO: renamed from: C */
    private final Rect f3952C = new Rect();

    /* JADX INFO: renamed from: D */
    private final C0651a f3953D = new C0651a();

    /* JADX INFO: renamed from: E */
    private boolean f3954E = false;

    /* JADX INFO: renamed from: F */
    private boolean f3955F = true;

    /* JADX INFO: renamed from: H */
    private final Runnable f3957H = new Runnable() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.1
        @Override // java.lang.Runnable
        public void run() {
            StaggeredGridLayoutManager.this.m4272g();
        }
    };

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView.AbstractC0611i.b bVarA = m3919a(context, attributeSet, i, i2);
        m4267b(bVarA.f3764a);
        m4262a(bVarA.f3765b);
        m4265a(bVarA.f3766c);
        this.f3969l = new C1749gn();
        m4221M();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public boolean mo3637c() {
        return this.f3971n != 0;
    }

    /* JADX INFO: renamed from: M */
    private void m4221M() {
        this.f3959b = AbstractC1752gq.m9494a(this, this.f3967j);
        this.f3960c = AbstractC1752gq.m9494a(this, 1 - this.f3967j);
    }

    /* JADX INFO: renamed from: g */
    boolean m4272g() {
        int iM4261L;
        int iM4260K;
        if (m4012v() == 0 || this.f3971n == 0 || !m4007q()) {
            return false;
        }
        if (this.f3962e) {
            iM4261L = m4260K();
            iM4260K = m4261L();
        } else {
            iM4261L = m4261L();
            iM4260K = m4260K();
        }
        if (iM4261L == 0 && m4273h() != null) {
            this.f3965h.m4286a();
            m3934I();
            m4005o();
            return true;
        }
        if (!this.f3954E) {
            return false;
        }
        int i = this.f3962e ? -1 : 1;
        int i2 = iM4260K + 1;
        LazySpanLookup.FullSpanItem fullSpanItemM4285a = this.f3965h.m4285a(iM4261L, i2, i, true);
        if (fullSpanItemM4285a == null) {
            this.f3954E = false;
            this.f3965h.m4284a(i2);
            return false;
        }
        LazySpanLookup.FullSpanItem fullSpanItemM4285a2 = this.f3965h.m4285a(iM4261L, fullSpanItemM4285a.f3979a, i * (-1), true);
        if (fullSpanItemM4285a2 == null) {
            this.f3965h.m4284a(fullSpanItemM4285a.f3979a);
        } else {
            this.f3965h.m4284a(fullSpanItemM4285a2.f3979a + 1);
        }
        m3934I();
        m4005o();
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: l */
    public void mo4001l(int i) {
        if (i == 0) {
            m4272g();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3627a(RecyclerView recyclerView, RecyclerView.C0617o c0617o) {
        super.mo3627a(recyclerView, c0617o);
        m3964a(this.f3957H);
        for (int i = 0; i < this.f3966i; i++) {
            this.f3958a[i].m4322e();
        }
        recyclerView.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x008a  */
    /* JADX INFO: renamed from: h */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    android.view.View m4273h() {
        /*
            r12 = this;
            int r0 = r12.m4012v()
            r1 = 1
            int r0 = r0 - r1
            java.util.BitSet r2 = new java.util.BitSet
            int r3 = r12.f3966i
            r2.<init>(r3)
            int r3 = r12.f3966i
            r4 = 0
            r2.set(r4, r3, r1)
            int r3 = r12.f3967j
            r5 = -1
            if (r3 != r1) goto L20
            boolean r3 = r12.m4275j()
            if (r3 == 0) goto L20
            r3 = 1
            goto L21
        L20:
            r3 = -1
        L21:
            boolean r6 = r12.f3962e
            if (r6 == 0) goto L27
            r6 = -1
            goto L2b
        L27:
            int r0 = r0 + 1
            r6 = r0
            r0 = 0
        L2b:
            if (r0 >= r6) goto L2e
            r5 = 1
        L2e:
            if (r0 == r6) goto Lab
            android.view.View r7 = r12.m3995i(r0)
            android.view.ViewGroup$LayoutParams r8 = r7.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams r8 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r8
            android.support.v7.widget.StaggeredGridLayoutManager$b r9 = r8.f3975a
            int r9 = r9.f4004e
            boolean r9 = r2.get(r9)
            if (r9 == 0) goto L54
            android.support.v7.widget.StaggeredGridLayoutManager$b r9 = r8.f3975a
            boolean r9 = r12.m4235a(r9)
            if (r9 == 0) goto L4d
            return r7
        L4d:
            android.support.v7.widget.StaggeredGridLayoutManager$b r9 = r8.f3975a
            int r9 = r9.f4004e
            r2.clear(r9)
        L54:
            boolean r9 = r8.f3976b
            if (r9 == 0) goto L59
            goto La9
        L59:
            int r9 = r0 + r5
            if (r9 == r6) goto La9
            android.view.View r9 = r12.m3995i(r9)
            boolean r10 = r12.f3962e
            if (r10 == 0) goto L77
            gq r10 = r12.f3959b
            int r10 = r10.mo9500b(r7)
            gq r11 = r12.f3959b
            int r11 = r11.mo9500b(r9)
            if (r10 >= r11) goto L74
            return r7
        L74:
            if (r10 != r11) goto L8a
            goto L88
        L77:
            gq r10 = r12.f3959b
            int r10 = r10.mo9496a(r7)
            gq r11 = r12.f3959b
            int r11 = r11.mo9496a(r9)
            if (r10 <= r11) goto L86
            return r7
        L86:
            if (r10 != r11) goto L8a
        L88:
            r10 = 1
            goto L8b
        L8a:
            r10 = 0
        L8b:
            if (r10 == 0) goto La9
            android.view.ViewGroup$LayoutParams r9 = r9.getLayoutParams()
            android.support.v7.widget.StaggeredGridLayoutManager$LayoutParams r9 = (android.support.v7.widget.StaggeredGridLayoutManager.LayoutParams) r9
            android.support.v7.widget.StaggeredGridLayoutManager$b r8 = r8.f3975a
            int r8 = r8.f4004e
            android.support.v7.widget.StaggeredGridLayoutManager$b r9 = r9.f3975a
            int r9 = r9.f4004e
            int r8 = r8 - r9
            if (r8 >= 0) goto La0
            r8 = 1
            goto La1
        La0:
            r8 = 0
        La1:
            if (r3 >= 0) goto La5
            r9 = 1
            goto La6
        La5:
            r9 = 0
        La6:
            if (r8 == r9) goto La9
            return r7
        La9:
            int r0 = r0 + r5
            goto L2e
        Lab:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.m4273h():android.view.View");
    }

    /* JADX INFO: renamed from: a */
    private boolean m4235a(C0652b c0652b) {
        if (this.f3962e) {
            if (c0652b.m4320d() < this.f3959b.mo9503d()) {
                return !c0652b.m4317c(c0652b.f4000a.get(c0652b.f4000a.size() - 1)).f3976b;
            }
        } else if (c0652b.m4314b() > this.f3959b.mo9501c()) {
            return !c0652b.m4317c(c0652b.f4000a.get(0)).f3976b;
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public void m4262a(int i) {
        mo3629a((String) null);
        if (i != this.f3966i) {
            m4274i();
            this.f3966i = i;
            this.f3970m = new BitSet(this.f3966i);
            this.f3958a = new C0652b[this.f3966i];
            for (int i2 = 0; i2 < this.f3966i; i2++) {
                this.f3958a[i2] = new C0652b(i2);
            }
            m4005o();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m4267b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        mo3629a((String) null);
        if (i == this.f3967j) {
            return;
        }
        this.f3967j = i;
        AbstractC1752gq abstractC1752gq = this.f3959b;
        this.f3959b = this.f3960c;
        this.f3960c = abstractC1752gq;
        m4005o();
    }

    /* JADX INFO: renamed from: a */
    public void m4265a(boolean z) {
        mo3629a((String) null);
        if (this.f3950A != null && this.f3950A.f3990h != z) {
            this.f3950A.f3990h = z;
        }
        this.f3961d = z;
        m4005o();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3629a(String str) {
        if (this.f3950A == null) {
            super.mo3629a(str);
        }
    }

    /* JADX INFO: renamed from: i */
    public void m4274i() {
        this.f3965h.m4286a();
        m4005o();
    }

    /* JADX INFO: renamed from: N */
    private void m4222N() {
        if (this.f3967j == 1 || !m4275j()) {
            this.f3962e = this.f3961d;
        } else {
            this.f3962e = !this.f3961d;
        }
    }

    /* JADX INFO: renamed from: j */
    boolean m4275j() {
        return m4010t() == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3548a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        int iA3 = m3926A() + m3928C();
        int iB = m3927B() + m3929D();
        if (this.f3967j == 1) {
            iA2 = m3917a(i2, rect.height() + iB, m3932G());
            iA = m3917a(i, (this.f3968k * this.f3966i) + iA3, m3931F());
        } else {
            iA = m3917a(i, rect.width() + iA3, m3931F());
            iA2 = m3917a(i2, (this.f3968k * this.f3966i) + iB, m3932G());
        }
        m3988f(iA, iA2);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public void mo3564c(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        m4228a(c0617o, c0621s, true);
    }

    /* JADX WARN: Removed duplicated region for block: B:89:0x0166  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4228a(android.support.v7.widget.RecyclerView.C0617o r9, android.support.v7.widget.RecyclerView.C0621s r10, boolean r11) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.m4228a(android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$s, boolean):void");
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3552a(RecyclerView.C0621s c0621s) {
        super.mo3552a(c0621s);
        this.f3963f = -1;
        this.f3964g = ExploreByTouchHelper.INVALID_ID;
        this.f3950A = null;
        this.f3953D.m4303a();
    }

    /* JADX INFO: renamed from: O */
    private void m4223O() {
        if (this.f3960c.mo9510h() == 1073741824) {
            return;
        }
        int iV = m4012v();
        float fMax = 0.0f;
        for (int i = 0; i < iV; i++) {
            View viewI = m3995i(i);
            float fMo9506e = this.f3960c.mo9506e(viewI);
            if (fMo9506e >= fMax) {
                if (((LayoutParams) viewI.getLayoutParams()).m4279a()) {
                    fMo9506e = (fMo9506e * 1.0f) / this.f3966i;
                }
                fMax = Math.max(fMax, fMo9506e);
            }
        }
        int i2 = this.f3968k;
        int iRound = Math.round(fMax * this.f3966i);
        if (this.f3960c.mo9510h() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.f3960c.mo9507f());
        }
        m4271f(iRound);
        if (this.f3968k == i2) {
            return;
        }
        for (int i3 = 0; i3 < iV; i3++) {
            View viewI2 = m3995i(i3);
            LayoutParams layoutParams = (LayoutParams) viewI2.getLayoutParams();
            if (!layoutParams.f3976b) {
                if (m4275j() && this.f3967j == 1) {
                    viewI2.offsetLeftAndRight(((-((this.f3966i - 1) - layoutParams.f3975a.f4004e)) * this.f3968k) - ((-((this.f3966i - 1) - layoutParams.f3975a.f4004e)) * i2));
                } else {
                    int i4 = layoutParams.f3975a.f4004e * this.f3968k;
                    int i5 = layoutParams.f3975a.f4004e * i2;
                    if (this.f3967j == 1) {
                        viewI2.offsetLeftAndRight(i4 - i5);
                    } else {
                        viewI2.offsetTopAndBottom(i4 - i5);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4230a(C0651a c0651a) {
        if (this.f3950A.f3985c > 0) {
            if (this.f3950A.f3985c == this.f3966i) {
                for (int i = 0; i < this.f3966i; i++) {
                    this.f3958a[i].m4322e();
                    int iMo9501c = this.f3950A.f3986d[i];
                    if (iMo9501c != Integer.MIN_VALUE) {
                        if (this.f3950A.f3991i) {
                            iMo9501c += this.f3959b.mo9503d();
                        } else {
                            iMo9501c += this.f3959b.mo9501c();
                        }
                    }
                    this.f3958a[i].m4319c(iMo9501c);
                }
            } else {
                this.f3950A.m4299a();
                this.f3950A.f3983a = this.f3950A.f3984b;
            }
        }
        this.f3973z = this.f3950A.f3992j;
        m4265a(this.f3950A.f3990h);
        m4222N();
        if (this.f3950A.f3983a != -1) {
            this.f3963f = this.f3950A.f3983a;
            c0651a.f3995c = this.f3950A.f3991i;
        } else {
            c0651a.f3995c = this.f3962e;
        }
        if (this.f3950A.f3987e > 1) {
            this.f3965h.f3977a = this.f3950A.f3988f;
            this.f3965h.f3978b = this.f3950A.f3989g;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4264a(RecyclerView.C0621s c0621s, C0651a c0651a) {
        if (m4268b(c0621s, c0651a) || m4243c(c0621s, c0651a)) {
            return;
        }
        c0651a.m4306b();
        c0651a.f3993a = 0;
    }

    /* JADX INFO: renamed from: c */
    private boolean m4243c(RecyclerView.C0621s c0621s, C0651a c0651a) {
        int iM4257v;
        if (this.f3972o) {
            iM4257v = m4258w(c0621s.m4105e());
        } else {
            iM4257v = m4257v(c0621s.m4105e());
        }
        c0651a.f3993a = iM4257v;
        c0651a.f3994b = ExploreByTouchHelper.INVALID_ID;
        return true;
    }

    /* JADX INFO: renamed from: b */
    boolean m4268b(RecyclerView.C0621s c0621s, C0651a c0651a) {
        int iMo9501c;
        if (c0621s.m4101a() || this.f3963f == -1) {
            return false;
        }
        if (this.f3963f < 0 || this.f3963f >= c0621s.m4105e()) {
            this.f3963f = -1;
            this.f3964g = ExploreByTouchHelper.INVALID_ID;
            return false;
        }
        if (this.f3950A == null || this.f3950A.f3983a == -1 || this.f3950A.f3985c < 1) {
            View viewC = mo3636c(this.f3963f);
            if (viewC != null) {
                c0651a.f3993a = this.f3962e ? m4260K() : m4261L();
                if (this.f3964g != Integer.MIN_VALUE) {
                    if (c0651a.f3995c) {
                        c0651a.f3994b = (this.f3959b.mo9503d() - this.f3964g) - this.f3959b.mo9500b(viewC);
                    } else {
                        c0651a.f3994b = (this.f3959b.mo9501c() + this.f3964g) - this.f3959b.mo9496a(viewC);
                    }
                    return true;
                }
                if (this.f3959b.mo9506e(viewC) > this.f3959b.mo9507f()) {
                    if (c0651a.f3995c) {
                        iMo9501c = this.f3959b.mo9503d();
                    } else {
                        iMo9501c = this.f3959b.mo9501c();
                    }
                    c0651a.f3994b = iMo9501c;
                    return true;
                }
                int iMo9496a = this.f3959b.mo9496a(viewC) - this.f3959b.mo9501c();
                if (iMo9496a < 0) {
                    c0651a.f3994b = -iMo9496a;
                    return true;
                }
                int iMo9503d = this.f3959b.mo9503d() - this.f3959b.mo9500b(viewC);
                if (iMo9503d < 0) {
                    c0651a.f3994b = iMo9503d;
                    return true;
                }
                c0651a.f3994b = ExploreByTouchHelper.INVALID_ID;
            } else {
                c0651a.f3993a = this.f3963f;
                if (this.f3964g == Integer.MIN_VALUE) {
                    c0651a.f3995c = m4256u(c0651a.f3993a) == 1;
                    c0651a.m4306b();
                } else {
                    c0651a.m4304a(this.f3964g);
                }
                c0651a.f3996d = true;
            }
        } else {
            c0651a.f3994b = ExploreByTouchHelper.INVALID_ID;
            c0651a.f3993a = this.f3963f;
        }
        return true;
    }

    /* JADX INFO: renamed from: f */
    void m4271f(int i) {
        this.f3968k = i / this.f3966i;
        this.f3951B = View.MeasureSpec.makeMeasureSpec(i, this.f3960c.mo9510h());
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public boolean mo3563b() {
        return this.f3950A == null;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public int mo3635c(RecyclerView.C0621s c0621s) {
        return m4237b(c0621s);
    }

    /* JADX INFO: renamed from: b */
    private int m4237b(RecyclerView.C0621s c0621s) {
        if (m4012v() == 0) {
            return 0;
        }
        return C1757gv.m9549a(c0621s, this.f3959b, m4266b(!this.f3955F), m4270c(!this.f3955F), this, this.f3955F, this.f3962e);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: d */
    public int mo3638d(RecyclerView.C0621s c0621s) {
        return m4237b(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: e */
    public int mo3641e(RecyclerView.C0621s c0621s) {
        return m4244i(c0621s);
    }

    /* JADX INFO: renamed from: i */
    private int m4244i(RecyclerView.C0621s c0621s) {
        if (m4012v() == 0) {
            return 0;
        }
        return C1757gv.m9548a(c0621s, this.f3959b, m4266b(!this.f3955F), m4270c(!this.f3955F), this, this.f3955F);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: f */
    public int mo3645f(RecyclerView.C0621s c0621s) {
        return m4244i(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: g */
    public int mo3648g(RecyclerView.C0621s c0621s) {
        return m4245j(c0621s);
    }

    /* JADX INFO: renamed from: j */
    private int m4245j(RecyclerView.C0621s c0621s) {
        if (m4012v() == 0) {
            return 0;
        }
        return C1757gv.m9550b(c0621s, this.f3959b, m4266b(!this.f3955F), m4270c(!this.f3955F), this, this.f3955F);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: h */
    public int mo3649h(RecyclerView.C0621s c0621s) {
        return m4245j(c0621s);
    }

    /* JADX INFO: renamed from: a */
    private void m4234a(View view, LayoutParams layoutParams, boolean z) {
        if (layoutParams.f3976b) {
            if (this.f3967j == 1) {
                m4232a(view, this.f3951B, m3918a(m4016z(), m4014x(), m3927B() + m3929D(), layoutParams.height, true), z);
                return;
            } else {
                m4232a(view, m3918a(m4015y(), m4013w(), m3926A() + m3928C(), layoutParams.width, true), this.f3951B, z);
                return;
            }
        }
        if (this.f3967j == 1) {
            m4232a(view, m3918a(this.f3968k, m4013w(), 0, layoutParams.width, false), m3918a(m4016z(), m4014x(), m3927B() + m3929D(), layoutParams.height, true), z);
        } else {
            m4232a(view, m3918a(m4015y(), m4013w(), m3926A() + m3928C(), layoutParams.width, true), m3918a(this.f3968k, m4014x(), 0, layoutParams.height, false), z);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4232a(View view, int i, int i2, boolean z) {
        boolean zB;
        m3970b(view, this.f3952C);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iM4236b = m4236b(i, layoutParams.leftMargin + this.f3952C.left, layoutParams.rightMargin + this.f3952C.right);
        int iM4236b2 = m4236b(i2, layoutParams.topMargin + this.f3952C.top, layoutParams.bottomMargin + this.f3952C.bottom);
        if (z) {
            zB = m3961a(view, iM4236b, iM4236b2, layoutParams);
        } else {
            zB = m3971b(view, iM4236b, iM4236b2, layoutParams);
        }
        if (zB) {
            view.measure(iM4236b, iM4236b2);
        }
    }

    /* JADX INFO: renamed from: b */
    private int m4236b(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View.MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3626a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f3950A = (SavedState) parcelable;
            m4005o();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: d */
    public Parcelable mo3640d() {
        int iM4307a;
        if (this.f3950A != null) {
            return new SavedState(this.f3950A);
        }
        SavedState savedState = new SavedState();
        savedState.f3990h = this.f3961d;
        savedState.f3991i = this.f3972o;
        savedState.f3992j = this.f3973z;
        if (this.f3965h != null && this.f3965h.f3977a != null) {
            savedState.f3988f = this.f3965h.f3977a;
            savedState.f3987e = savedState.f3988f.length;
            savedState.f3989g = this.f3965h.f3978b;
        } else {
            savedState.f3987e = 0;
        }
        if (m4012v() > 0) {
            savedState.f3983a = this.f3972o ? m4260K() : m4261L();
            savedState.f3984b = m4276k();
            savedState.f3985c = this.f3966i;
            savedState.f3986d = new int[this.f3966i];
            for (int i = 0; i < this.f3966i; i++) {
                if (this.f3972o) {
                    iM4307a = this.f3958a[i].m4315b(ExploreByTouchHelper.INVALID_ID);
                    if (iM4307a != Integer.MIN_VALUE) {
                        iM4307a -= this.f3959b.mo9503d();
                    }
                } else {
                    iM4307a = this.f3958a[i].m4307a(ExploreByTouchHelper.INVALID_ID);
                    if (iM4307a != Integer.MIN_VALUE) {
                        iM4307a -= this.f3959b.mo9501c();
                    }
                }
                savedState.f3986d[i] = iM4307a;
            }
        } else {
            savedState.f3983a = -1;
            savedState.f3984b = -1;
            savedState.f3985c = 0;
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3551a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof LayoutParams)) {
            super.m3950a(view, accessibilityNodeInfoCompat);
            return;
        }
        LayoutParams layoutParams2 = (LayoutParams) layoutParams;
        if (this.f3967j == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.m4280b(), layoutParams2.f3976b ? this.f3966i : 1, -1, -1, layoutParams2.f3976b, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(-1, -1, layoutParams2.m4280b(), layoutParams2.f3976b ? this.f3966i : 1, layoutParams2.f3976b, false));
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3628a(AccessibilityEvent accessibilityEvent) {
        super.mo3628a(accessibilityEvent);
        if (m4012v() > 0) {
            View viewM4266b = m4266b(false);
            View viewM4270c = m4270c(false);
            if (viewM4266b == null || viewM4270c == null) {
                return;
            }
            int iD = m3979d(viewM4266b);
            int iD2 = m3979d(viewM4270c);
            if (iD < iD2) {
                accessibilityEvent.setFromIndex(iD);
                accessibilityEvent.setToIndex(iD2);
            } else {
                accessibilityEvent.setFromIndex(iD2);
                accessibilityEvent.setToIndex(iD);
            }
        }
    }

    /* JADX INFO: renamed from: k */
    int m4276k() {
        View viewM4270c = this.f3962e ? m4270c(true) : m4266b(true);
        if (viewM4270c == null) {
            return -1;
        }
        return m3979d(viewM4270c);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public int mo3541a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (this.f3967j == 0) {
            return this.f3966i;
        }
        return super.mo3541a(c0617o, c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public int mo3561b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (this.f3967j == 1) {
            return this.f3966i;
        }
        return super.mo3561b(c0617o, c0621s);
    }

    /* JADX INFO: renamed from: b */
    View m4266b(boolean z) {
        int iMo9501c = this.f3959b.mo9501c();
        int iMo9503d = this.f3959b.mo9503d();
        int iV = m4012v();
        View view = null;
        for (int i = 0; i < iV; i++) {
            View viewI = m3995i(i);
            int iMo9496a = this.f3959b.mo9496a(viewI);
            if (this.f3959b.mo9500b(viewI) > iMo9501c && iMo9496a < iMo9503d) {
                if (iMo9496a >= iMo9501c || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: c */
    View m4270c(boolean z) {
        int iMo9501c = this.f3959b.mo9501c();
        int iMo9503d = this.f3959b.mo9503d();
        View view = null;
        for (int iV = m4012v() - 1; iV >= 0; iV--) {
            View viewI = m3995i(iV);
            int iMo9496a = this.f3959b.mo9496a(viewI);
            int iMo9500b = this.f3959b.mo9500b(viewI);
            if (iMo9500b > iMo9501c && iMo9496a < iMo9503d) {
                if (iMo9500b <= iMo9503d || !z) {
                    return viewI;
                }
                if (view == null) {
                    view = viewI;
                }
            }
        }
        return view;
    }

    /* JADX INFO: renamed from: b */
    private void m4240b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, boolean z) {
        int iMo9503d;
        int iM4253r = m4253r(ExploreByTouchHelper.INVALID_ID);
        if (iM4253r != Integer.MIN_VALUE && (iMo9503d = this.f3959b.mo9503d() - iM4253r) > 0) {
            int i = iMo9503d - (-m4269c(-iMo9503d, c0617o, c0621s));
            if (!z || i <= 0) {
                return;
            }
            this.f3959b.mo9498a(i);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m4242c(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, boolean z) {
        int iMo9501c;
        int iM4251q = m4251q(Integer.MAX_VALUE);
        if (iM4251q != Integer.MAX_VALUE && (iMo9501c = iM4251q - this.f3959b.mo9501c()) > 0) {
            int iM4269c = iMo9501c - m4269c(iMo9501c, c0617o, c0621s);
            if (!z || iM4269c <= 0) {
                return;
            }
            this.f3959b.mo9498a(-iM4269c);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004f  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4238b(int r5, android.support.v7.widget.RecyclerView.C0621s r6) {
        /*
            r4 = this;
            gn r0 = r4.f3969l
            r1 = 0
            r0.f10047b = r1
            gn r0 = r4.f3969l
            r0.f10048c = r5
            boolean r0 = r4.m4009s()
            r2 = 1
            if (r0 == 0) goto L30
            int r6 = r6.m4103c()
            r0 = -1
            if (r6 == r0) goto L30
            boolean r0 = r4.f3962e
            if (r6 >= r5) goto L1d
            r5 = 1
            goto L1e
        L1d:
            r5 = 0
        L1e:
            if (r0 != r5) goto L29
            gq r5 = r4.f3959b
            int r5 = r5.mo9507f()
            r6 = r5
            r5 = 0
            goto L32
        L29:
            gq r5 = r4.f3959b
            int r5 = r5.mo9507f()
            goto L31
        L30:
            r5 = 0
        L31:
            r6 = 0
        L32:
            boolean r0 = r4.m4008r()
            if (r0 == 0) goto L4f
            gn r0 = r4.f3969l
            gq r3 = r4.f3959b
            int r3 = r3.mo9501c()
            int r3 = r3 - r5
            r0.f10051f = r3
            gn r5 = r4.f3969l
            gq r0 = r4.f3959b
            int r0 = r0.mo9503d()
            int r0 = r0 + r6
            r5.f10052g = r0
            goto L5f
        L4f:
            gn r0 = r4.f3969l
            gq r3 = r4.f3959b
            int r3 = r3.mo9505e()
            int r3 = r3 + r6
            r0.f10052g = r3
            gn r6 = r4.f3969l
            int r5 = -r5
            r6.f10051f = r5
        L5f:
            gn r5 = r4.f3969l
            r5.f10053h = r1
            gn r5 = r4.f3969l
            r5.f10046a = r2
            gn r5 = r4.f3969l
            gq r6 = r4.f3959b
            int r6 = r6.mo9510h()
            if (r6 != 0) goto L7a
            gq r6 = r4.f3959b
            int r6 = r6.mo9505e()
            if (r6 != 0) goto L7a
            r1 = 1
        L7a:
            r5.f10054i = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.m4238b(int, android.support.v7.widget.RecyclerView$s):void");
    }

    /* JADX INFO: renamed from: m */
    private void m4246m(int i) {
        this.f3969l.f10050e = i;
        this.f3969l.f10049d = this.f3962e != (i == -1) ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: j */
    public void mo3997j(int i) {
        super.mo3997j(i);
        for (int i2 = 0; i2 < this.f3966i; i2++) {
            this.f3958a[i2].m4321d(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: k */
    public void mo3999k(int i) {
        super.mo3999k(i);
        for (int i2 = 0; i2 < this.f3966i; i2++) {
            this.f3958a[i2].m4321d(i);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public void mo3562b(RecyclerView recyclerView, int i, int i2) {
        m4241c(i, i2, 2);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3555a(RecyclerView recyclerView, int i, int i2) {
        m4241c(i, i2, 1);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3554a(RecyclerView recyclerView) {
        this.f3965h.m4286a();
        m4005o();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3556a(RecyclerView recyclerView, int i, int i2, int i3) {
        m4241c(i, i2, 8);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3557a(RecyclerView recyclerView, int i, int i2, Object obj) {
        m4241c(i, i2, 4);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0026  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0043 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0044  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m4241c(int r6, int r7, int r8) {
        /*
            r5 = this;
            boolean r0 = r5.f3962e
            if (r0 == 0) goto L9
            int r0 = r5.m4260K()
            goto Ld
        L9:
            int r0 = r5.m4261L()
        Ld:
            r1 = 8
            if (r8 != r1) goto L1b
            if (r6 >= r7) goto L16
            int r2 = r7 + 1
            goto L1d
        L16:
            int r2 = r6 + 1
            r3 = r2
            r2 = r7
            goto L1f
        L1b:
            int r2 = r6 + r7
        L1d:
            r3 = r2
            r2 = r6
        L1f:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r4 = r5.f3965h
            r4.m4290b(r2)
            if (r8 == r1) goto L36
            switch(r8) {
                case 1: goto L30;
                case 2: goto L2a;
                default: goto L29;
            }
        L29:
            goto L41
        L2a:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.f3965h
            r8.m4287a(r6, r7)
            goto L41
        L30:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.f3965h
            r8.m4291b(r6, r7)
            goto L41
        L36:
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r8 = r5.f3965h
            r1 = 1
            r8.m4287a(r6, r1)
            android.support.v7.widget.StaggeredGridLayoutManager$LazySpanLookup r6 = r5.f3965h
            r6.m4291b(r7, r1)
        L41:
            if (r3 > r0) goto L44
            return
        L44:
            boolean r6 = r5.f3962e
            if (r6 == 0) goto L4d
            int r6 = r5.m4261L()
            goto L51
        L4d:
            int r6 = r5.m4260K()
        L51:
            if (r2 > r6) goto L56
            r5.m4005o()
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.StaggeredGridLayoutManager.m4241c(int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX INFO: renamed from: a */
    private int m4224a(RecyclerView.C0617o c0617o, C1749gn c1749gn, RecyclerView.C0621s c0621s) {
        int i;
        int i2;
        int iMo9501c;
        int iM4253r;
        C0652b c0652bM4225a;
        int iMo9506e;
        int i3;
        int iMo9506e2;
        int iMo9506e3;
        boolean zM4278n;
        ?? r9 = 0;
        this.f3970m.set(0, this.f3966i, true);
        if (this.f3969l.f10054i) {
            i2 = c1749gn.f10050e == 1 ? Integer.MAX_VALUE : ExploreByTouchHelper.INVALID_ID;
        } else {
            if (c1749gn.f10050e == 1) {
                i = c1749gn.f10052g + c1749gn.f10047b;
            } else {
                i = c1749gn.f10051f - c1749gn.f10047b;
            }
            i2 = i;
        }
        m4226a(c1749gn.f10050e, i2);
        if (this.f3962e) {
            iMo9501c = this.f3959b.mo9503d();
        } else {
            iMo9501c = this.f3959b.mo9501c();
        }
        int i4 = iMo9501c;
        boolean z = false;
        while (c1749gn.m9486a(c0621s) && (this.f3969l.f10054i || !this.f3970m.isEmpty())) {
            View viewM9485a = c1749gn.m9485a(c0617o);
            LayoutParams layoutParams = (LayoutParams) viewM9485a.getLayoutParams();
            int iF = layoutParams.m3858f();
            int iM4292c = this.f3965h.m4292c(iF);
            boolean z2 = iM4292c == -1;
            if (z2) {
                c0652bM4225a = layoutParams.f3976b ? this.f3958a[r9] : m4225a(c1749gn);
                this.f3965h.m4288a(iF, c0652bM4225a);
            } else {
                c0652bM4225a = this.f3958a[iM4292c];
            }
            C0652b c0652b = c0652bM4225a;
            layoutParams.f3975a = c0652b;
            if (c1749gn.f10050e == 1) {
                m3968b(viewM9485a);
            } else {
                m3969b(viewM9485a, (int) r9);
            }
            m4234a(viewM9485a, layoutParams, (boolean) r9);
            if (c1749gn.f10050e == 1) {
                int iM4253r2 = layoutParams.f3976b ? m4253r(i4) : c0652b.m4315b(i4);
                int iMo9506e4 = this.f3959b.mo9506e(viewM9485a) + iM4253r2;
                if (z2 && layoutParams.f3976b) {
                    LazySpanLookup.FullSpanItem fullSpanItemM4247n = m4247n(iM4253r2);
                    fullSpanItemM4247n.f3980b = -1;
                    fullSpanItemM4247n.f3979a = iF;
                    this.f3965h.m4289a(fullSpanItemM4247n);
                }
                i3 = iMo9506e4;
                iMo9506e = iM4253r2;
            } else {
                int iM4251q = layoutParams.f3976b ? m4251q(i4) : c0652b.m4307a(i4);
                iMo9506e = iM4251q - this.f3959b.mo9506e(viewM9485a);
                if (z2 && layoutParams.f3976b) {
                    LazySpanLookup.FullSpanItem fullSpanItemM4248o = m4248o(iM4251q);
                    fullSpanItemM4248o.f3980b = 1;
                    fullSpanItemM4248o.f3979a = iF;
                    this.f3965h.m4289a(fullSpanItemM4248o);
                }
                i3 = iM4251q;
            }
            if (layoutParams.f3976b && c1749gn.f10049d == -1) {
                if (z2) {
                    this.f3954E = true;
                } else {
                    if (c1749gn.f10050e == 1) {
                        zM4278n = m4277m();
                    } else {
                        zM4278n = m4278n();
                    }
                    if (!zM4278n) {
                        LazySpanLookup.FullSpanItem fullSpanItemM4295f = this.f3965h.m4295f(iF);
                        if (fullSpanItemM4295f != null) {
                            fullSpanItemM4295f.f3982d = true;
                        }
                        this.f3954E = true;
                    }
                }
            }
            m4233a(viewM9485a, layoutParams, c1749gn);
            if (m4275j() && this.f3967j == 1) {
                int iMo9503d = layoutParams.f3976b ? this.f3960c.mo9503d() : this.f3960c.mo9503d() - (((this.f3966i - 1) - c0652b.f4004e) * this.f3968k);
                iMo9506e3 = iMo9503d;
                iMo9506e2 = iMo9503d - this.f3960c.mo9506e(viewM9485a);
            } else {
                int iMo9501c2 = layoutParams.f3976b ? this.f3960c.mo9501c() : (c0652b.f4004e * this.f3968k) + this.f3960c.mo9501c();
                iMo9506e2 = iMo9501c2;
                iMo9506e3 = this.f3960c.mo9506e(viewM9485a) + iMo9501c2;
            }
            if (this.f3967j == 1) {
                m3947a(viewM9485a, iMo9506e2, iMo9506e, iMo9506e3, i3);
            } else {
                m3947a(viewM9485a, iMo9506e, iMo9506e2, i3, iMo9506e3);
            }
            if (layoutParams.f3976b) {
                m4226a(this.f3969l.f10050e, i2);
            } else {
                m4231a(c0652b, this.f3969l.f10050e, i2);
            }
            m4229a(c0617o, this.f3969l);
            if (this.f3969l.f10053h && viewM9485a.hasFocusable()) {
                if (layoutParams.f3976b) {
                    this.f3970m.clear();
                } else {
                    this.f3970m.set(c0652b.f4004e, false);
                }
            }
            z = true;
            r9 = 0;
        }
        if (!z) {
            m4229a(c0617o, this.f3969l);
        }
        if (this.f3969l.f10050e == -1) {
            iM4253r = this.f3959b.mo9501c() - m4251q(this.f3959b.mo9501c());
        } else {
            iM4253r = m4253r(this.f3959b.mo9503d()) - this.f3959b.mo9503d();
        }
        if (iM4253r > 0) {
            return Math.min(c1749gn.f10047b, iM4253r);
        }
        return 0;
    }

    /* JADX INFO: renamed from: n */
    private LazySpanLookup.FullSpanItem m4247n(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3981c = new int[this.f3966i];
        for (int i2 = 0; i2 < this.f3966i; i2++) {
            fullSpanItem.f3981c[i2] = i - this.f3958a[i2].m4315b(i);
        }
        return fullSpanItem;
    }

    /* JADX INFO: renamed from: o */
    private LazySpanLookup.FullSpanItem m4248o(int i) {
        LazySpanLookup.FullSpanItem fullSpanItem = new LazySpanLookup.FullSpanItem();
        fullSpanItem.f3981c = new int[this.f3966i];
        for (int i2 = 0; i2 < this.f3966i; i2++) {
            fullSpanItem.f3981c[i2] = this.f3958a[i2].m4307a(i) - i;
        }
        return fullSpanItem;
    }

    /* JADX INFO: renamed from: a */
    private void m4233a(View view, LayoutParams layoutParams, C1749gn c1749gn) {
        if (c1749gn.f10050e == 1) {
            if (layoutParams.f3976b) {
                m4250p(view);
                return;
            } else {
                layoutParams.f3975a.m4316b(view);
                return;
            }
        }
        if (layoutParams.f3976b) {
            m4252q(view);
        } else {
            layoutParams.f3975a.m4312a(view);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4229a(RecyclerView.C0617o c0617o, C1749gn c1749gn) {
        int iMin;
        int iMin2;
        if (!c1749gn.f10046a || c1749gn.f10054i) {
            return;
        }
        if (c1749gn.f10047b == 0) {
            if (c1749gn.f10050e == -1) {
                m4239b(c0617o, c1749gn.f10052g);
                return;
            } else {
                m4227a(c0617o, c1749gn.f10051f);
                return;
            }
        }
        if (c1749gn.f10050e == -1) {
            int iM4249p = c1749gn.f10051f - m4249p(c1749gn.f10051f);
            if (iM4249p < 0) {
                iMin2 = c1749gn.f10052g;
            } else {
                iMin2 = c1749gn.f10052g - Math.min(iM4249p, c1749gn.f10047b);
            }
            m4239b(c0617o, iMin2);
            return;
        }
        int iM4254s = m4254s(c1749gn.f10052g) - c1749gn.f10052g;
        if (iM4254s < 0) {
            iMin = c1749gn.f10051f;
        } else {
            iMin = Math.min(iM4254s, c1749gn.f10047b) + c1749gn.f10051f;
        }
        m4227a(c0617o, iMin);
    }

    /* JADX INFO: renamed from: p */
    private void m4250p(View view) {
        for (int i = this.f3966i - 1; i >= 0; i--) {
            this.f3958a[i].m4316b(view);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m4252q(View view) {
        for (int i = this.f3966i - 1; i >= 0; i--) {
            this.f3958a[i].m4312a(view);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4226a(int i, int i2) {
        for (int i3 = 0; i3 < this.f3966i; i3++) {
            if (!this.f3958a[i3].f4000a.isEmpty()) {
                m4231a(this.f3958a[i3], i, i2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m4231a(C0652b c0652b, int i, int i2) {
        int iM4326i = c0652b.m4326i();
        if (i == -1) {
            if (c0652b.m4314b() + iM4326i <= i2) {
                this.f3970m.set(c0652b.f4004e, false);
            }
        } else if (c0652b.m4320d() - iM4326i >= i2) {
            this.f3970m.set(c0652b.f4004e, false);
        }
    }

    /* JADX INFO: renamed from: p */
    private int m4249p(int i) {
        int iM4307a = this.f3958a[0].m4307a(i);
        for (int i2 = 1; i2 < this.f3966i; i2++) {
            int iM4307a2 = this.f3958a[i2].m4307a(i);
            if (iM4307a2 > iM4307a) {
                iM4307a = iM4307a2;
            }
        }
        return iM4307a;
    }

    /* JADX INFO: renamed from: q */
    private int m4251q(int i) {
        int iM4307a = this.f3958a[0].m4307a(i);
        for (int i2 = 1; i2 < this.f3966i; i2++) {
            int iM4307a2 = this.f3958a[i2].m4307a(i);
            if (iM4307a2 < iM4307a) {
                iM4307a = iM4307a2;
            }
        }
        return iM4307a;
    }

    /* JADX INFO: renamed from: m */
    boolean m4277m() {
        int iM4315b = this.f3958a[0].m4315b(ExploreByTouchHelper.INVALID_ID);
        for (int i = 1; i < this.f3966i; i++) {
            if (this.f3958a[i].m4315b(ExploreByTouchHelper.INVALID_ID) != iM4315b) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: n */
    boolean m4278n() {
        int iM4307a = this.f3958a[0].m4307a(ExploreByTouchHelper.INVALID_ID);
        for (int i = 1; i < this.f3966i; i++) {
            if (this.f3958a[i].m4307a(ExploreByTouchHelper.INVALID_ID) != iM4307a) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: r */
    private int m4253r(int i) {
        int iM4315b = this.f3958a[0].m4315b(i);
        for (int i2 = 1; i2 < this.f3966i; i2++) {
            int iM4315b2 = this.f3958a[i2].m4315b(i);
            if (iM4315b2 > iM4315b) {
                iM4315b = iM4315b2;
            }
        }
        return iM4315b;
    }

    /* JADX INFO: renamed from: s */
    private int m4254s(int i) {
        int iM4315b = this.f3958a[0].m4315b(i);
        for (int i2 = 1; i2 < this.f3966i; i2++) {
            int iM4315b2 = this.f3958a[i2].m4315b(i);
            if (iM4315b2 < iM4315b) {
                iM4315b = iM4315b2;
            }
        }
        return iM4315b;
    }

    /* JADX INFO: renamed from: a */
    private void m4227a(RecyclerView.C0617o c0617o, int i) {
        while (m4012v() > 0) {
            View viewI = m3995i(0);
            if (this.f3959b.mo9500b(viewI) > i || this.f3959b.mo9502c(viewI) > i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewI.getLayoutParams();
            if (layoutParams.f3976b) {
                for (int i2 = 0; i2 < this.f3966i; i2++) {
                    if (this.f3958a[i2].f4000a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f3966i; i3++) {
                    this.f3958a[i3].m4325h();
                }
            } else if (layoutParams.f3975a.f4000a.size() == 1) {
                return;
            } else {
                layoutParams.f3975a.m4325h();
            }
            m3951a(viewI, c0617o);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m4239b(RecyclerView.C0617o c0617o, int i) {
        for (int iV = m4012v() - 1; iV >= 0; iV--) {
            View viewI = m3995i(iV);
            if (this.f3959b.mo9496a(viewI) < i || this.f3959b.mo9504d(viewI) < i) {
                return;
            }
            LayoutParams layoutParams = (LayoutParams) viewI.getLayoutParams();
            if (layoutParams.f3976b) {
                for (int i2 = 0; i2 < this.f3966i; i2++) {
                    if (this.f3958a[i2].f4000a.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.f3966i; i3++) {
                    this.f3958a[i3].m4324g();
                }
            } else if (layoutParams.f3975a.f4000a.size() == 1) {
                return;
            } else {
                layoutParams.f3975a.m4324g();
            }
            m3951a(viewI, c0617o);
        }
    }

    /* JADX INFO: renamed from: t */
    private boolean m4255t(int i) {
        if (this.f3967j == 0) {
            return (i == -1) != this.f3962e;
        }
        return ((i == -1) == this.f3962e) == m4275j();
    }

    /* JADX INFO: renamed from: a */
    private C0652b m4225a(C1749gn c1749gn) {
        int i;
        int i2;
        int i3 = -1;
        if (m4255t(c1749gn.f10050e)) {
            i = this.f3966i - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.f3966i;
            i2 = 1;
        }
        C0652b c0652b = null;
        if (c1749gn.f10050e == 1) {
            int i4 = Integer.MAX_VALUE;
            int iMo9501c = this.f3959b.mo9501c();
            while (i != i3) {
                C0652b c0652b2 = this.f3958a[i];
                int iM4315b = c0652b2.m4315b(iMo9501c);
                if (iM4315b < i4) {
                    c0652b = c0652b2;
                    i4 = iM4315b;
                }
                i += i2;
            }
            return c0652b;
        }
        int i5 = ExploreByTouchHelper.INVALID_ID;
        int iMo9503d = this.f3959b.mo9503d();
        while (i != i3) {
            C0652b c0652b3 = this.f3958a[i];
            int iM4307a = c0652b3.m4307a(iMo9503d);
            if (iM4307a > i5) {
                c0652b = c0652b3;
                i5 = iM4307a;
            }
            i += i2;
        }
        return c0652b;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: f */
    public boolean mo3646f() {
        return this.f3967j == 1;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: e */
    public boolean mo3643e() {
        return this.f3967j == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public int mo3540a(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return m4269c(i, c0617o, c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public int mo3560b(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return m4269c(i, c0617o, c0621s);
    }

    /* JADX INFO: renamed from: u */
    private int m4256u(int i) {
        if (m4012v() == 0) {
            return this.f3962e ? 1 : -1;
        }
        return (i < m4261L()) != this.f3962e ? -1 : 1;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0620r.b
    /* JADX INFO: renamed from: d */
    public PointF mo3639d(int i) {
        int iM4256u = m4256u(i);
        PointF pointF = new PointF();
        if (iM4256u == 0) {
            return null;
        }
        if (this.f3967j == 0) {
            pointF.x = iM4256u;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iM4256u;
        }
        return pointF;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: e */
    public void mo3642e(int i) {
        if (this.f3950A != null && this.f3950A.f3983a != i) {
            this.f3950A.m4300b();
        }
        this.f3963f = i;
        this.f3964g = ExploreByTouchHelper.INVALID_ID;
        m4005o();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3624a(int i, int i2, RecyclerView.C0621s c0621s, RecyclerView.AbstractC0611i.a aVar) {
        int iM4315b;
        if (this.f3967j != 0) {
            i = i2;
        }
        if (m4012v() == 0 || i == 0) {
            return;
        }
        m4263a(i, c0621s);
        if (this.f3956G == null || this.f3956G.length < this.f3966i) {
            this.f3956G = new int[this.f3966i];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.f3966i; i4++) {
            if (this.f3969l.f10049d == -1) {
                iM4315b = this.f3969l.f10051f - this.f3958a[i4].m4307a(this.f3969l.f10051f);
            } else {
                iM4315b = this.f3958a[i4].m4315b(this.f3969l.f10052g) - this.f3969l.f10052g;
            }
            if (iM4315b >= 0) {
                this.f3956G[i3] = iM4315b;
                i3++;
            }
        }
        Arrays.sort(this.f3956G, 0, i3);
        for (int i5 = 0; i5 < i3 && this.f3969l.m9486a(c0621s); i5++) {
            aVar.mo4022b(this.f3969l.f10048c, this.f3956G[i5]);
            this.f3969l.f10048c += this.f3969l.f10049d;
        }
    }

    /* JADX INFO: renamed from: a */
    void m4263a(int i, RecyclerView.C0621s c0621s) {
        int iM4261L;
        int i2;
        if (i > 0) {
            iM4261L = m4260K();
            i2 = 1;
        } else {
            iM4261L = m4261L();
            i2 = -1;
        }
        this.f3969l.f10046a = true;
        m4238b(iM4261L, c0621s);
        m4246m(i2);
        this.f3969l.f10048c = iM4261L + this.f3969l.f10049d;
        this.f3969l.f10047b = Math.abs(i);
    }

    /* JADX INFO: renamed from: c */
    int m4269c(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (m4012v() == 0 || i == 0) {
            return 0;
        }
        m4263a(i, c0621s);
        int iM4224a = m4224a(c0617o, this.f3969l, c0621s);
        if (this.f3969l.f10047b >= iM4224a) {
            i = i < 0 ? -iM4224a : iM4224a;
        }
        this.f3959b.mo9498a(-i);
        this.f3972o = this.f3962e;
        this.f3969l.f10047b = 0;
        m4229a(c0617o, this.f3969l);
        return i;
    }

    /* JADX INFO: renamed from: K */
    int m4260K() {
        int iV = m4012v();
        if (iV == 0) {
            return 0;
        }
        return m3979d(m3995i(iV - 1));
    }

    /* JADX INFO: renamed from: L */
    int m4261L() {
        if (m4012v() == 0) {
            return 0;
        }
        return m3979d(m3995i(0));
    }

    /* JADX INFO: renamed from: v */
    private int m4257v(int i) {
        int iV = m4012v();
        for (int i2 = 0; i2 < iV; i2++) {
            int iD = m3979d(m3995i(i2));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    /* JADX INFO: renamed from: w */
    private int m4258w(int i) {
        for (int iV = m4012v() - 1; iV >= 0; iV--) {
            int iD = m3979d(m3995i(iV));
            if (iD >= 0 && iD < i) {
                return iD;
            }
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo3542a() {
        if (this.f3967j == 0) {
            return new LayoutParams(-2, -1);
        }
        return new LayoutParams(-1, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo3543a(Context context, AttributeSet attributeSet) {
        return new LayoutParams(context, attributeSet);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo3544a(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new LayoutParams(layoutParams);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public boolean mo3559a(RecyclerView.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public View mo3546a(View view, int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        View viewE;
        int iM4261L;
        int iM4328k;
        int iM4328k2;
        int iM4328k3;
        View viewM4310a;
        if (m4012v() == 0 || (viewE = m3983e(view)) == null) {
            return null;
        }
        m4222N();
        int iM4259x = m4259x(i);
        if (iM4259x == Integer.MIN_VALUE) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) viewE.getLayoutParams();
        boolean z = layoutParams.f3976b;
        C0652b c0652b = layoutParams.f3975a;
        if (iM4259x == 1) {
            iM4261L = m4260K();
        } else {
            iM4261L = m4261L();
        }
        m4238b(iM4261L, c0621s);
        m4246m(iM4259x);
        this.f3969l.f10048c = this.f3969l.f10049d + iM4261L;
        this.f3969l.f10047b = (int) (this.f3959b.mo9507f() * 0.33333334f);
        this.f3969l.f10053h = true;
        this.f3969l.f10046a = false;
        m4224a(c0617o, this.f3969l, c0621s);
        this.f3972o = this.f3962e;
        if (!z && (viewM4310a = c0652b.m4310a(iM4261L, iM4259x)) != null && viewM4310a != viewE) {
            return viewM4310a;
        }
        if (m4255t(iM4259x)) {
            for (int i2 = this.f3966i - 1; i2 >= 0; i2--) {
                View viewM4310a2 = this.f3958a[i2].m4310a(iM4261L, iM4259x);
                if (viewM4310a2 != null && viewM4310a2 != viewE) {
                    return viewM4310a2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.f3966i; i3++) {
                View viewM4310a3 = this.f3958a[i3].m4310a(iM4261L, iM4259x);
                if (viewM4310a3 != null && viewM4310a3 != viewE) {
                    return viewM4310a3;
                }
            }
        }
        boolean z2 = (this.f3961d ^ true) == (iM4259x == -1);
        if (!z) {
            if (z2) {
                iM4328k3 = c0652b.m4327j();
            } else {
                iM4328k3 = c0652b.m4328k();
            }
            View viewC = mo3636c(iM4328k3);
            if (viewC != null && viewC != viewE) {
                return viewC;
            }
        }
        if (m4255t(iM4259x)) {
            for (int i4 = this.f3966i - 1; i4 >= 0; i4--) {
                if (i4 != c0652b.f4004e) {
                    if (z2) {
                        iM4328k2 = this.f3958a[i4].m4327j();
                    } else {
                        iM4328k2 = this.f3958a[i4].m4328k();
                    }
                    View viewC2 = mo3636c(iM4328k2);
                    if (viewC2 != null && viewC2 != viewE) {
                        return viewC2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.f3966i; i5++) {
                if (z2) {
                    iM4328k = this.f3958a[i5].m4327j();
                } else {
                    iM4328k = this.f3958a[i5].m4328k();
                }
                View viewC3 = mo3636c(iM4328k);
                if (viewC3 != null && viewC3 != viewE) {
                    return viewC3;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: x */
    private int m4259x(int i) {
        if (i == 17) {
            if (this.f3967j == 0) {
                return -1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (i == 33) {
            if (this.f3967j == 1) {
                return -1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (i == 66) {
            if (this.f3967j == 0) {
                return 1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (i == 130) {
            if (this.f3967j == 1) {
                return 1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        switch (i) {
            case 1:
                return (this.f3967j != 1 && m4275j()) ? 1 : -1;
            case 2:
                return (this.f3967j != 1 && m4275j()) ? -1 : 1;
            default:
                return ExploreByTouchHelper.INVALID_ID;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a */
        C0652b f3975a;

        /* JADX INFO: renamed from: b */
        boolean f3976b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        /* JADX INFO: renamed from: a */
        public boolean m4279a() {
            return this.f3976b;
        }

        /* JADX INFO: renamed from: b */
        public final int m4280b() {
            if (this.f3975a == null) {
                return -1;
            }
            return this.f3975a.f4004e;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.StaggeredGridLayoutManager$b */
    class C0652b {

        /* JADX INFO: renamed from: a */
        ArrayList<View> f4000a = new ArrayList<>();

        /* JADX INFO: renamed from: b */
        int f4001b = ExploreByTouchHelper.INVALID_ID;

        /* JADX INFO: renamed from: c */
        int f4002c = ExploreByTouchHelper.INVALID_ID;

        /* JADX INFO: renamed from: d */
        int f4003d = 0;

        /* JADX INFO: renamed from: e */
        final int f4004e;

        C0652b(int i) {
            this.f4004e = i;
        }

        /* JADX INFO: renamed from: a */
        int m4307a(int i) {
            if (this.f4001b != Integer.MIN_VALUE) {
                return this.f4001b;
            }
            if (this.f4000a.size() == 0) {
                return i;
            }
            m4311a();
            return this.f4001b;
        }

        /* JADX INFO: renamed from: a */
        void m4311a() {
            LazySpanLookup.FullSpanItem fullSpanItemM4295f;
            View view = this.f4000a.get(0);
            LayoutParams layoutParamsM4317c = m4317c(view);
            this.f4001b = StaggeredGridLayoutManager.this.f3959b.mo9496a(view);
            if (layoutParamsM4317c.f3976b && (fullSpanItemM4295f = StaggeredGridLayoutManager.this.f3965h.m4295f(layoutParamsM4317c.m3858f())) != null && fullSpanItemM4295f.f3980b == -1) {
                this.f4001b -= fullSpanItemM4295f.m4296a(this.f4004e);
            }
        }

        /* JADX INFO: renamed from: b */
        int m4314b() {
            if (this.f4001b != Integer.MIN_VALUE) {
                return this.f4001b;
            }
            m4311a();
            return this.f4001b;
        }

        /* JADX INFO: renamed from: b */
        int m4315b(int i) {
            if (this.f4002c != Integer.MIN_VALUE) {
                return this.f4002c;
            }
            if (this.f4000a.size() == 0) {
                return i;
            }
            m4318c();
            return this.f4002c;
        }

        /* JADX INFO: renamed from: c */
        void m4318c() {
            LazySpanLookup.FullSpanItem fullSpanItemM4295f;
            View view = this.f4000a.get(this.f4000a.size() - 1);
            LayoutParams layoutParamsM4317c = m4317c(view);
            this.f4002c = StaggeredGridLayoutManager.this.f3959b.mo9500b(view);
            if (layoutParamsM4317c.f3976b && (fullSpanItemM4295f = StaggeredGridLayoutManager.this.f3965h.m4295f(layoutParamsM4317c.m3858f())) != null && fullSpanItemM4295f.f3980b == 1) {
                this.f4002c += fullSpanItemM4295f.m4296a(this.f4004e);
            }
        }

        /* JADX INFO: renamed from: d */
        int m4320d() {
            if (this.f4002c != Integer.MIN_VALUE) {
                return this.f4002c;
            }
            m4318c();
            return this.f4002c;
        }

        /* JADX INFO: renamed from: a */
        void m4312a(View view) {
            LayoutParams layoutParamsM4317c = m4317c(view);
            layoutParamsM4317c.f3975a = this;
            this.f4000a.add(0, view);
            this.f4001b = ExploreByTouchHelper.INVALID_ID;
            if (this.f4000a.size() == 1) {
                this.f4002c = ExploreByTouchHelper.INVALID_ID;
            }
            if (layoutParamsM4317c.m3856d() || layoutParamsM4317c.m3857e()) {
                this.f4003d += StaggeredGridLayoutManager.this.f3959b.mo9506e(view);
            }
        }

        /* JADX INFO: renamed from: b */
        void m4316b(View view) {
            LayoutParams layoutParamsM4317c = m4317c(view);
            layoutParamsM4317c.f3975a = this;
            this.f4000a.add(view);
            this.f4002c = ExploreByTouchHelper.INVALID_ID;
            if (this.f4000a.size() == 1) {
                this.f4001b = ExploreByTouchHelper.INVALID_ID;
            }
            if (layoutParamsM4317c.m3856d() || layoutParamsM4317c.m3857e()) {
                this.f4003d += StaggeredGridLayoutManager.this.f3959b.mo9506e(view);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4313a(boolean z, int i) {
            int iM4307a;
            if (z) {
                iM4307a = m4315b(ExploreByTouchHelper.INVALID_ID);
            } else {
                iM4307a = m4307a(ExploreByTouchHelper.INVALID_ID);
            }
            m4322e();
            if (iM4307a == Integer.MIN_VALUE) {
                return;
            }
            if (!z || iM4307a >= StaggeredGridLayoutManager.this.f3959b.mo9503d()) {
                if (z || iM4307a <= StaggeredGridLayoutManager.this.f3959b.mo9501c()) {
                    if (i != Integer.MIN_VALUE) {
                        iM4307a += i;
                    }
                    this.f4002c = iM4307a;
                    this.f4001b = iM4307a;
                }
            }
        }

        /* JADX INFO: renamed from: e */
        void m4322e() {
            this.f4000a.clear();
            m4323f();
            this.f4003d = 0;
        }

        /* JADX INFO: renamed from: f */
        void m4323f() {
            this.f4001b = ExploreByTouchHelper.INVALID_ID;
            this.f4002c = ExploreByTouchHelper.INVALID_ID;
        }

        /* JADX INFO: renamed from: c */
        void m4319c(int i) {
            this.f4001b = i;
            this.f4002c = i;
        }

        /* JADX INFO: renamed from: g */
        void m4324g() {
            int size = this.f4000a.size();
            View viewRemove = this.f4000a.remove(size - 1);
            LayoutParams layoutParamsM4317c = m4317c(viewRemove);
            layoutParamsM4317c.f3975a = null;
            if (layoutParamsM4317c.m3856d() || layoutParamsM4317c.m3857e()) {
                this.f4003d -= StaggeredGridLayoutManager.this.f3959b.mo9506e(viewRemove);
            }
            if (size == 1) {
                this.f4001b = ExploreByTouchHelper.INVALID_ID;
            }
            this.f4002c = ExploreByTouchHelper.INVALID_ID;
        }

        /* JADX INFO: renamed from: h */
        void m4325h() {
            View viewRemove = this.f4000a.remove(0);
            LayoutParams layoutParamsM4317c = m4317c(viewRemove);
            layoutParamsM4317c.f3975a = null;
            if (this.f4000a.size() == 0) {
                this.f4002c = ExploreByTouchHelper.INVALID_ID;
            }
            if (layoutParamsM4317c.m3856d() || layoutParamsM4317c.m3857e()) {
                this.f4003d -= StaggeredGridLayoutManager.this.f3959b.mo9506e(viewRemove);
            }
            this.f4001b = ExploreByTouchHelper.INVALID_ID;
        }

        /* JADX INFO: renamed from: i */
        public int m4326i() {
            return this.f4003d;
        }

        /* JADX INFO: renamed from: c */
        LayoutParams m4317c(View view) {
            return (LayoutParams) view.getLayoutParams();
        }

        /* JADX INFO: renamed from: d */
        void m4321d(int i) {
            if (this.f4001b != Integer.MIN_VALUE) {
                this.f4001b += i;
            }
            if (this.f4002c != Integer.MIN_VALUE) {
                this.f4002c += i;
            }
        }

        /* JADX INFO: renamed from: j */
        public int m4327j() {
            if (StaggeredGridLayoutManager.this.f3961d) {
                return m4308a(this.f4000a.size() - 1, -1, true);
            }
            return m4308a(0, this.f4000a.size(), true);
        }

        /* JADX INFO: renamed from: k */
        public int m4328k() {
            if (StaggeredGridLayoutManager.this.f3961d) {
                return m4308a(0, this.f4000a.size(), true);
            }
            return m4308a(this.f4000a.size() - 1, -1, true);
        }

        /* JADX INFO: renamed from: a */
        int m4309a(int i, int i2, boolean z, boolean z2, boolean z3) {
            int iMo9501c = StaggeredGridLayoutManager.this.f3959b.mo9501c();
            int iMo9503d = StaggeredGridLayoutManager.this.f3959b.mo9503d();
            int i3 = i2 > i ? 1 : -1;
            while (i != i2) {
                View view = this.f4000a.get(i);
                int iMo9496a = StaggeredGridLayoutManager.this.f3959b.mo9496a(view);
                int iMo9500b = StaggeredGridLayoutManager.this.f3959b.mo9500b(view);
                boolean z4 = false;
                boolean z5 = !z3 ? iMo9496a >= iMo9503d : iMo9496a > iMo9503d;
                if (!z3 ? iMo9500b > iMo9501c : iMo9500b >= iMo9501c) {
                    z4 = true;
                }
                if (z5 && z4) {
                    if (z && z2) {
                        if (iMo9496a >= iMo9501c && iMo9500b <= iMo9503d) {
                            return StaggeredGridLayoutManager.this.m3979d(view);
                        }
                    } else {
                        if (z2) {
                            return StaggeredGridLayoutManager.this.m3979d(view);
                        }
                        if (iMo9496a < iMo9501c || iMo9500b > iMo9503d) {
                            return StaggeredGridLayoutManager.this.m3979d(view);
                        }
                    }
                }
                i += i3;
            }
            return -1;
        }

        /* JADX INFO: renamed from: a */
        int m4308a(int i, int i2, boolean z) {
            return m4309a(i, i2, false, false, z);
        }

        /* JADX INFO: renamed from: a */
        public View m4310a(int i, int i2) {
            View view = null;
            if (i2 == -1) {
                int size = this.f4000a.size();
                int i3 = 0;
                while (i3 < size) {
                    View view2 = this.f4000a.get(i3);
                    if ((StaggeredGridLayoutManager.this.f3961d && StaggeredGridLayoutManager.this.m3979d(view2) <= i) || ((!StaggeredGridLayoutManager.this.f3961d && StaggeredGridLayoutManager.this.m3979d(view2) >= i) || !view2.hasFocusable())) {
                        break;
                    }
                    i3++;
                    view = view2;
                }
            } else {
                int size2 = this.f4000a.size() - 1;
                while (size2 >= 0) {
                    View view3 = this.f4000a.get(size2);
                    if ((StaggeredGridLayoutManager.this.f3961d && StaggeredGridLayoutManager.this.m3979d(view3) >= i) || ((!StaggeredGridLayoutManager.this.f3961d && StaggeredGridLayoutManager.this.m3979d(view3) <= i) || !view3.hasFocusable())) {
                        break;
                    }
                    size2--;
                    view = view3;
                }
            }
            return view;
        }
    }

    static class LazySpanLookup {

        /* JADX INFO: renamed from: a */
        int[] f3977a;

        /* JADX INFO: renamed from: b */
        List<FullSpanItem> f3978b;

        LazySpanLookup() {
        }

        /* JADX INFO: renamed from: a */
        int m4284a(int i) {
            if (this.f3978b != null) {
                for (int size = this.f3978b.size() - 1; size >= 0; size--) {
                    if (this.f3978b.get(size).f3979a >= i) {
                        this.f3978b.remove(size);
                    }
                }
            }
            return m4290b(i);
        }

        /* JADX INFO: renamed from: b */
        int m4290b(int i) {
            if (this.f3977a == null || i >= this.f3977a.length) {
                return -1;
            }
            int iM4283g = m4283g(i);
            if (iM4283g == -1) {
                Arrays.fill(this.f3977a, i, this.f3977a.length, -1);
                return this.f3977a.length;
            }
            int i2 = iM4283g + 1;
            Arrays.fill(this.f3977a, i, i2, -1);
            return i2;
        }

        /* JADX INFO: renamed from: c */
        int m4292c(int i) {
            if (this.f3977a == null || i >= this.f3977a.length) {
                return -1;
            }
            return this.f3977a[i];
        }

        /* JADX INFO: renamed from: a */
        void m4288a(int i, C0652b c0652b) {
            m4294e(i);
            this.f3977a[i] = c0652b.f4004e;
        }

        /* JADX INFO: renamed from: d */
        int m4293d(int i) {
            int length = this.f3977a.length;
            while (length <= i) {
                length *= 2;
            }
            return length;
        }

        /* JADX INFO: renamed from: e */
        void m4294e(int i) {
            if (this.f3977a == null) {
                this.f3977a = new int[Math.max(i, 10) + 1];
                Arrays.fill(this.f3977a, -1);
            } else if (i >= this.f3977a.length) {
                int[] iArr = this.f3977a;
                this.f3977a = new int[m4293d(i)];
                System.arraycopy(iArr, 0, this.f3977a, 0, iArr.length);
                Arrays.fill(this.f3977a, iArr.length, this.f3977a.length, -1);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4286a() {
            if (this.f3977a != null) {
                Arrays.fill(this.f3977a, -1);
            }
            this.f3978b = null;
        }

        /* JADX INFO: renamed from: a */
        void m4287a(int i, int i2) {
            if (this.f3977a == null || i >= this.f3977a.length) {
                return;
            }
            int i3 = i + i2;
            m4294e(i3);
            System.arraycopy(this.f3977a, i3, this.f3977a, i, (this.f3977a.length - i) - i2);
            Arrays.fill(this.f3977a, this.f3977a.length - i2, this.f3977a.length, -1);
            m4281c(i, i2);
        }

        /* JADX INFO: renamed from: c */
        private void m4281c(int i, int i2) {
            if (this.f3978b == null) {
                return;
            }
            int i3 = i + i2;
            for (int size = this.f3978b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3978b.get(size);
                if (fullSpanItem.f3979a >= i) {
                    if (fullSpanItem.f3979a < i3) {
                        this.f3978b.remove(size);
                    } else {
                        fullSpanItem.f3979a -= i2;
                    }
                }
            }
        }

        /* JADX INFO: renamed from: b */
        void m4291b(int i, int i2) {
            if (this.f3977a == null || i >= this.f3977a.length) {
                return;
            }
            int i3 = i + i2;
            m4294e(i3);
            System.arraycopy(this.f3977a, i, this.f3977a, i3, (this.f3977a.length - i) - i2);
            Arrays.fill(this.f3977a, i, i3, -1);
            m4282d(i, i2);
        }

        /* JADX INFO: renamed from: d */
        private void m4282d(int i, int i2) {
            if (this.f3978b == null) {
                return;
            }
            for (int size = this.f3978b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3978b.get(size);
                if (fullSpanItem.f3979a >= i) {
                    fullSpanItem.f3979a += i2;
                }
            }
        }

        /* JADX INFO: renamed from: g */
        private int m4283g(int i) {
            if (this.f3978b == null) {
                return -1;
            }
            FullSpanItem fullSpanItemM4295f = m4295f(i);
            if (fullSpanItemM4295f != null) {
                this.f3978b.remove(fullSpanItemM4295f);
            }
            int size = this.f3978b.size();
            int i2 = 0;
            while (true) {
                if (i2 >= size) {
                    i2 = -1;
                    break;
                }
                if (this.f3978b.get(i2).f3979a >= i) {
                    break;
                }
                i2++;
            }
            if (i2 == -1) {
                return -1;
            }
            FullSpanItem fullSpanItem = this.f3978b.get(i2);
            this.f3978b.remove(i2);
            return fullSpanItem.f3979a;
        }

        /* JADX INFO: renamed from: a */
        public void m4289a(FullSpanItem fullSpanItem) {
            if (this.f3978b == null) {
                this.f3978b = new ArrayList();
            }
            int size = this.f3978b.size();
            for (int i = 0; i < size; i++) {
                FullSpanItem fullSpanItem2 = this.f3978b.get(i);
                if (fullSpanItem2.f3979a == fullSpanItem.f3979a) {
                    this.f3978b.remove(i);
                }
                if (fullSpanItem2.f3979a >= fullSpanItem.f3979a) {
                    this.f3978b.add(i, fullSpanItem);
                    return;
                }
            }
            this.f3978b.add(fullSpanItem);
        }

        /* JADX INFO: renamed from: f */
        public FullSpanItem m4295f(int i) {
            if (this.f3978b == null) {
                return null;
            }
            for (int size = this.f3978b.size() - 1; size >= 0; size--) {
                FullSpanItem fullSpanItem = this.f3978b.get(size);
                if (fullSpanItem.f3979a == i) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        public FullSpanItem m4285a(int i, int i2, int i3, boolean z) {
            if (this.f3978b == null) {
                return null;
            }
            int size = this.f3978b.size();
            for (int i4 = 0; i4 < size; i4++) {
                FullSpanItem fullSpanItem = this.f3978b.get(i4);
                if (fullSpanItem.f3979a >= i2) {
                    return null;
                }
                if (fullSpanItem.f3979a >= i && (i3 == 0 || fullSpanItem.f3980b == i3 || (z && fullSpanItem.f3982d))) {
                    return fullSpanItem;
                }
            }
            return null;
        }

        static class FullSpanItem implements Parcelable {
            public static final Parcelable.Creator<FullSpanItem> CREATOR = new Parcelable.Creator<FullSpanItem>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.LazySpanLookup.FullSpanItem.1
                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem createFromParcel(Parcel parcel) {
                    return new FullSpanItem(parcel);
                }

                @Override // android.os.Parcelable.Creator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public FullSpanItem[] newArray(int i) {
                    return new FullSpanItem[i];
                }
            };

            /* JADX INFO: renamed from: a */
            int f3979a;

            /* JADX INFO: renamed from: b */
            int f3980b;

            /* JADX INFO: renamed from: c */
            int[] f3981c;

            /* JADX INFO: renamed from: d */
            boolean f3982d;

            @Override // android.os.Parcelable
            public int describeContents() {
                return 0;
            }

            FullSpanItem(Parcel parcel) {
                this.f3979a = parcel.readInt();
                this.f3980b = parcel.readInt();
                this.f3982d = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    this.f3981c = new int[i];
                    parcel.readIntArray(this.f3981c);
                }
            }

            FullSpanItem() {
            }

            /* JADX INFO: renamed from: a */
            int m4296a(int i) {
                if (this.f3981c == null) {
                    return 0;
                }
                return this.f3981c[i];
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                parcel.writeInt(this.f3979a);
                parcel.writeInt(this.f3980b);
                parcel.writeInt(this.f3982d ? 1 : 0);
                if (this.f3981c != null && this.f3981c.length > 0) {
                    parcel.writeInt(this.f3981c.length);
                    parcel.writeIntArray(this.f3981c);
                } else {
                    parcel.writeInt(0);
                }
            }

            public String toString() {
                return "FullSpanItem{mPosition=" + this.f3979a + ", mGapDir=" + this.f3980b + ", mHasUnwantedGapAfter=" + this.f3982d + ", mGapPerSpan=" + Arrays.toString(this.f3981c) + '}';
            }
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.StaggeredGridLayoutManager.SavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        int f3983a;

        /* JADX INFO: renamed from: b */
        int f3984b;

        /* JADX INFO: renamed from: c */
        int f3985c;

        /* JADX INFO: renamed from: d */
        int[] f3986d;

        /* JADX INFO: renamed from: e */
        int f3987e;

        /* JADX INFO: renamed from: f */
        int[] f3988f;

        /* JADX INFO: renamed from: g */
        List<LazySpanLookup.FullSpanItem> f3989g;

        /* JADX INFO: renamed from: h */
        boolean f3990h;

        /* JADX INFO: renamed from: i */
        boolean f3991i;

        /* JADX INFO: renamed from: j */
        boolean f3992j;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3983a = parcel.readInt();
            this.f3984b = parcel.readInt();
            this.f3985c = parcel.readInt();
            if (this.f3985c > 0) {
                this.f3986d = new int[this.f3985c];
                parcel.readIntArray(this.f3986d);
            }
            this.f3987e = parcel.readInt();
            if (this.f3987e > 0) {
                this.f3988f = new int[this.f3987e];
                parcel.readIntArray(this.f3988f);
            }
            this.f3990h = parcel.readInt() == 1;
            this.f3991i = parcel.readInt() == 1;
            this.f3992j = parcel.readInt() == 1;
            this.f3989g = parcel.readArrayList(LazySpanLookup.FullSpanItem.class.getClassLoader());
        }

        public SavedState(SavedState savedState) {
            this.f3985c = savedState.f3985c;
            this.f3983a = savedState.f3983a;
            this.f3984b = savedState.f3984b;
            this.f3986d = savedState.f3986d;
            this.f3987e = savedState.f3987e;
            this.f3988f = savedState.f3988f;
            this.f3990h = savedState.f3990h;
            this.f3991i = savedState.f3991i;
            this.f3992j = savedState.f3992j;
            this.f3989g = savedState.f3989g;
        }

        /* JADX INFO: renamed from: a */
        void m4299a() {
            this.f3986d = null;
            this.f3985c = 0;
            this.f3987e = 0;
            this.f3988f = null;
            this.f3989g = null;
        }

        /* JADX INFO: renamed from: b */
        void m4300b() {
            this.f3986d = null;
            this.f3985c = 0;
            this.f3983a = -1;
            this.f3984b = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3983a);
            parcel.writeInt(this.f3984b);
            parcel.writeInt(this.f3985c);
            if (this.f3985c > 0) {
                parcel.writeIntArray(this.f3986d);
            }
            parcel.writeInt(this.f3987e);
            if (this.f3987e > 0) {
                parcel.writeIntArray(this.f3988f);
            }
            parcel.writeInt(this.f3990h ? 1 : 0);
            parcel.writeInt(this.f3991i ? 1 : 0);
            parcel.writeInt(this.f3992j ? 1 : 0);
            parcel.writeList(this.f3989g);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.StaggeredGridLayoutManager$a */
    class C0651a {

        /* JADX INFO: renamed from: a */
        int f3993a;

        /* JADX INFO: renamed from: b */
        int f3994b;

        /* JADX INFO: renamed from: c */
        boolean f3995c;

        /* JADX INFO: renamed from: d */
        boolean f3996d;

        /* JADX INFO: renamed from: e */
        boolean f3997e;

        /* JADX INFO: renamed from: f */
        int[] f3998f;

        C0651a() {
            m4303a();
        }

        /* JADX INFO: renamed from: a */
        void m4303a() {
            this.f3993a = -1;
            this.f3994b = ExploreByTouchHelper.INVALID_ID;
            this.f3995c = false;
            this.f3996d = false;
            this.f3997e = false;
            if (this.f3998f != null) {
                Arrays.fill(this.f3998f, -1);
            }
        }

        /* JADX INFO: renamed from: a */
        void m4305a(C0652b[] c0652bArr) {
            int length = c0652bArr.length;
            if (this.f3998f == null || this.f3998f.length < length) {
                this.f3998f = new int[StaggeredGridLayoutManager.this.f3958a.length];
            }
            for (int i = 0; i < length; i++) {
                this.f3998f[i] = c0652bArr[i].m4307a(ExploreByTouchHelper.INVALID_ID);
            }
        }

        /* JADX INFO: renamed from: b */
        void m4306b() {
            this.f3994b = this.f3995c ? StaggeredGridLayoutManager.this.f3959b.mo9503d() : StaggeredGridLayoutManager.this.f3959b.mo9501c();
        }

        /* JADX INFO: renamed from: a */
        void m4304a(int i) {
            if (this.f3995c) {
                this.f3994b = StaggeredGridLayoutManager.this.f3959b.mo9503d() - i;
            } else {
                this.f3994b = StaggeredGridLayoutManager.this.f3959b.mo9501c() + i;
            }
        }
    }
}
