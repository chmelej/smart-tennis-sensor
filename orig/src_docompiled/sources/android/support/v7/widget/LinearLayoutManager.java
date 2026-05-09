package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import java.util.List;
import p000.AbstractC1752gq;
import p000.C1757gv;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView.AbstractC0611i implements RecyclerView.AbstractC0620r.b {

    /* JADX INFO: renamed from: a */
    private C0588c f3549a;

    /* JADX INFO: renamed from: b */
    private boolean f3550b;

    /* JADX INFO: renamed from: c */
    private boolean f3551c;

    /* JADX INFO: renamed from: d */
    private boolean f3552d;

    /* JADX INFO: renamed from: e */
    private boolean f3553e;

    /* JADX INFO: renamed from: f */
    private boolean f3554f;

    /* JADX INFO: renamed from: g */
    private final C0587b f3555g;

    /* JADX INFO: renamed from: h */
    private int f3556h;

    /* JADX INFO: renamed from: i */
    int f3557i;

    /* JADX INFO: renamed from: j */
    AbstractC1752gq f3558j;

    /* JADX INFO: renamed from: k */
    boolean f3559k;

    /* JADX INFO: renamed from: l */
    int f3560l;

    /* JADX INFO: renamed from: m */
    int f3561m;

    /* JADX INFO: renamed from: n */
    SavedState f3562n;

    /* JADX INFO: renamed from: o */
    final C0586a f3563o;

    /* JADX INFO: renamed from: a */
    void mo3549a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, C0586a c0586a, int i) {
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public boolean mo3637c() {
        return true;
    }

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context context, int i, boolean z) {
        this.f3557i = 1;
        this.f3551c = false;
        this.f3559k = false;
        this.f3552d = false;
        this.f3553e = true;
        this.f3560l = -1;
        this.f3561m = ExploreByTouchHelper.INVALID_ID;
        this.f3562n = null;
        this.f3563o = new C0586a();
        this.f3555g = new C0587b();
        this.f3556h = 2;
        m3632b(i);
        m3633b(z);
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f3557i = 1;
        this.f3551c = false;
        this.f3559k = false;
        this.f3552d = false;
        this.f3553e = true;
        this.f3560l = -1;
        this.f3561m = ExploreByTouchHelper.INVALID_ID;
        this.f3562n = null;
        this.f3563o = new C0586a();
        this.f3555g = new C0587b();
        this.f3556h = 2;
        RecyclerView.AbstractC0611i.b bVarA = m3919a(context, attributeSet, i, i2);
        m3632b(bVarA.f3764a);
        m3633b(bVarA.f3766c);
        mo3558a(bVarA.f3767d);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo3542a() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3627a(RecyclerView recyclerView, RecyclerView.C0617o c0617o) {
        super.mo3627a(recyclerView, c0617o);
        if (this.f3554f) {
            m3973c(c0617o);
            c0617o.m4050a();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3628a(AccessibilityEvent accessibilityEvent) {
        super.mo3628a(accessibilityEvent);
        if (m4012v() > 0) {
            accessibilityEvent.setFromIndex(m3655m());
            accessibilityEvent.setToIndex(m3656n());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: d */
    public Parcelable mo3640d() {
        if (this.f3562n != null) {
            return new SavedState(this.f3562n);
        }
        SavedState savedState = new SavedState();
        if (m4012v() > 0) {
            m3651i();
            boolean z = this.f3550b ^ this.f3559k;
            savedState.f3566c = z;
            if (z) {
                View viewM3593M = m3593M();
                savedState.f3565b = this.f3558j.mo9503d() - this.f3558j.mo9500b(viewM3593M);
                savedState.f3564a = m3979d(viewM3593M);
            } else {
                View viewM3592L = m3592L();
                savedState.f3564a = m3979d(viewM3592L);
                savedState.f3565b = this.f3558j.mo9496a(viewM3592L) - this.f3558j.mo9501c();
            }
        } else {
            savedState.m3658b();
        }
        return savedState;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3626a(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            this.f3562n = (SavedState) parcelable;
            m4005o();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: e */
    public boolean mo3643e() {
        return this.f3557i == 0;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: f */
    public boolean mo3646f() {
        return this.f3557i == 1;
    }

    /* JADX INFO: renamed from: a */
    public void mo3558a(boolean z) {
        mo3629a((String) null);
        if (this.f3552d == z) {
            return;
        }
        this.f3552d = z;
        m4005o();
    }

    /* JADX INFO: renamed from: g */
    public int m3647g() {
        return this.f3557i;
    }

    /* JADX INFO: renamed from: b */
    public void m3632b(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation:" + i);
        }
        mo3629a((String) null);
        if (i != this.f3557i || this.f3558j == null) {
            this.f3558j = AbstractC1752gq.m9494a(this, i);
            this.f3563o.f3567a = this.f3558j;
            this.f3557i = i;
            m4005o();
        }
    }

    /* JADX INFO: renamed from: K */
    private void m3591K() {
        if (this.f3557i == 1 || !m3650h()) {
            this.f3559k = this.f3551c;
        } else {
            this.f3559k = !this.f3551c;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3633b(boolean z) {
        mo3629a((String) null);
        if (z == this.f3551c) {
            return;
        }
        this.f3551c = z;
        m4005o();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public View mo3636c(int i) {
        int iV = m4012v();
        if (iV == 0) {
            return null;
        }
        int iD = i - m3979d(m3995i(0));
        if (iD >= 0 && iD < iV) {
            View viewI = m3995i(iD);
            if (m3979d(viewI) == i) {
                return viewI;
            }
        }
        return super.mo3636c(i);
    }

    /* JADX INFO: renamed from: b */
    protected int m3630b(RecyclerView.C0621s c0621s) {
        if (c0621s.m4104d()) {
            return this.f3558j.mo9507f();
        }
        return 0;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0620r.b
    /* JADX INFO: renamed from: d */
    public PointF mo3639d(int i) {
        if (m4012v() == 0) {
            return null;
        }
        int i2 = (i < m3979d(m3995i(0))) != this.f3559k ? -1 : 1;
        if (this.f3557i == 0) {
            return new PointF(i2, 0.0f);
        }
        return new PointF(0.0f, i2);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public void mo3564c(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        int i;
        int i2;
        int i3;
        View viewMo3636c;
        int iMo9496a;
        int i4 = -1;
        if ((this.f3562n != null || this.f3560l != -1) && c0621s.m4105e() == 0) {
            m3973c(c0617o);
            return;
        }
        if (this.f3562n != null && this.f3562n.m3657a()) {
            this.f3560l = this.f3562n.f3564a;
        }
        m3651i();
        this.f3549a.f3576a = false;
        m3591K();
        View viewE = m3930E();
        if (!this.f3563o.f3571e || this.f3560l != -1 || this.f3562n != null) {
            this.f3563o.m3661a();
            this.f3563o.f3570d = this.f3559k ^ this.f3552d;
            m3602a(c0617o, c0621s, this.f3563o);
            this.f3563o.f3571e = true;
        } else if (viewE != null && (this.f3558j.mo9496a(viewE) >= this.f3558j.mo9503d() || this.f3558j.mo9500b(viewE) <= this.f3558j.mo9501c())) {
            this.f3563o.m3662a(viewE, m3979d(viewE));
        }
        int iM3630b = m3630b(c0621s);
        if (this.f3549a.f3585j >= 0) {
            i = iM3630b;
            iM3630b = 0;
        } else {
            i = 0;
        }
        int iMo9501c = iM3630b + this.f3558j.mo9501c();
        int iMo9509g = i + this.f3558j.mo9509g();
        if (c0621s.m4101a() && this.f3560l != -1 && this.f3561m != Integer.MIN_VALUE && (viewMo3636c = mo3636c(this.f3560l)) != null) {
            if (this.f3559k) {
                iMo9496a = (this.f3558j.mo9503d() - this.f3558j.mo9500b(viewMo3636c)) - this.f3561m;
            } else {
                iMo9496a = this.f3561m - (this.f3558j.mo9496a(viewMo3636c) - this.f3558j.mo9501c());
            }
            if (iMo9496a > 0) {
                iMo9501c += iMo9496a;
            } else {
                iMo9509g -= iMo9496a;
            }
        }
        if (!this.f3563o.f3570d ? !this.f3559k : this.f3559k) {
            i4 = 1;
        }
        mo3549a(c0617o, c0621s, this.f3563o, i4);
        m3939a(c0617o);
        this.f3549a.f3587l = m3653k();
        this.f3549a.f3584i = c0621s.m4101a();
        if (this.f3563o.f3570d) {
            m3606b(this.f3563o);
            this.f3549a.f3583h = iMo9501c;
            m3622a(c0617o, this.f3549a, c0621s, false);
            i3 = this.f3549a.f3577b;
            int i5 = this.f3549a.f3579d;
            if (this.f3549a.f3578c > 0) {
                iMo9509g += this.f3549a.f3578c;
            }
            m3598a(this.f3563o);
            this.f3549a.f3583h = iMo9509g;
            this.f3549a.f3579d += this.f3549a.f3580e;
            m3622a(c0617o, this.f3549a, c0621s, false);
            i2 = this.f3549a.f3577b;
            if (this.f3549a.f3578c > 0) {
                int i6 = this.f3549a.f3578c;
                m3612g(i5, i3);
                this.f3549a.f3583h = i6;
                m3622a(c0617o, this.f3549a, c0621s, false);
                i3 = this.f3549a.f3577b;
            }
        } else {
            m3598a(this.f3563o);
            this.f3549a.f3583h = iMo9509g;
            m3622a(c0617o, this.f3549a, c0621s, false);
            i2 = this.f3549a.f3577b;
            int i7 = this.f3549a.f3579d;
            if (this.f3549a.f3578c > 0) {
                iMo9501c += this.f3549a.f3578c;
            }
            m3606b(this.f3563o);
            this.f3549a.f3583h = iMo9501c;
            this.f3549a.f3579d += this.f3549a.f3580e;
            m3622a(c0617o, this.f3549a, c0621s, false);
            i3 = this.f3549a.f3577b;
            if (this.f3549a.f3578c > 0) {
                int i8 = this.f3549a.f3578c;
                m3596a(i7, i2);
                this.f3549a.f3583h = i8;
                m3622a(c0617o, this.f3549a, c0621s, false);
                i2 = this.f3549a.f3577b;
            }
        }
        if (m4012v() > 0) {
            if (this.f3559k ^ this.f3552d) {
                int iM3594a = m3594a(i2, c0617o, c0621s, true);
                int i9 = i3 + iM3594a;
                int i10 = i2 + iM3594a;
                int iM3604b = m3604b(i9, c0617o, c0621s, false);
                i3 = i9 + iM3604b;
                i2 = i10 + iM3604b;
            } else {
                int iM3604b2 = m3604b(i3, c0617o, c0621s, true);
                int i11 = i3 + iM3604b2;
                int i12 = i2 + iM3604b2;
                int iM3594a2 = m3594a(i12, c0617o, c0621s, false);
                i3 = i11 + iM3594a2;
                i2 = i12 + iM3594a2;
            }
        }
        m3608b(c0617o, c0621s, i3, i2);
        if (!c0621s.m4101a()) {
            this.f3558j.m9497a();
        } else {
            this.f3563o.m3661a();
        }
        this.f3550b = this.f3552d;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3552a(RecyclerView.C0621s c0621s) {
        super.mo3552a(c0621s);
        this.f3562n = null;
        this.f3560l = -1;
        this.f3561m = ExploreByTouchHelper.INVALID_ID;
        this.f3563o.m3661a();
    }

    /* JADX INFO: renamed from: b */
    private void m3608b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, int i, int i2) {
        if (!c0621s.m4102b() || m4012v() == 0 || c0621s.m4101a() || !mo3563b()) {
            return;
        }
        List<RecyclerView.AbstractC0624v> listM4067c = c0617o.m4067c();
        int size = listM4067c.size();
        int iD = m3979d(m3995i(0));
        int iMo9506e = 0;
        int iMo9506e2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView.AbstractC0624v abstractC0624v = listM4067c.get(i3);
            if (!abstractC0624v.m4146q()) {
                if (((abstractC0624v.m4133d() < iD) != this.f3559k ? (byte) -1 : (byte) 1) == -1) {
                    iMo9506e += this.f3558j.mo9506e(abstractC0624v.f3823a);
                } else {
                    iMo9506e2 += this.f3558j.mo9506e(abstractC0624v.f3823a);
                }
            }
        }
        this.f3549a.f3586k = listM4067c;
        if (iMo9506e > 0) {
            m3612g(m3979d(m3592L()), i);
            this.f3549a.f3583h = iMo9506e;
            this.f3549a.f3578c = 0;
            this.f3549a.m3669a();
            m3622a(c0617o, this.f3549a, c0621s, false);
        }
        if (iMo9506e2 > 0) {
            m3596a(m3979d(m3593M()), i2);
            this.f3549a.f3583h = iMo9506e2;
            this.f3549a.f3578c = 0;
            this.f3549a.m3669a();
            m3622a(c0617o, this.f3549a, c0621s, false);
        }
        this.f3549a.f3586k = null;
    }

    /* JADX INFO: renamed from: a */
    private void m3602a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, C0586a c0586a) {
        if (m3603a(c0621s, c0586a) || m3609b(c0617o, c0621s, c0586a)) {
            return;
        }
        c0586a.m3664b();
        c0586a.f3568b = this.f3552d ? c0621s.m4105e() - 1 : 0;
    }

    /* JADX INFO: renamed from: b */
    private boolean m3609b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, C0586a c0586a) {
        View viewM3611g;
        int iMo9501c;
        if (m4012v() == 0) {
            return false;
        }
        View viewE = m3930E();
        if (viewE != null && c0586a.m3663a(viewE, c0621s)) {
            c0586a.m3662a(viewE, m3979d(viewE));
            return true;
        }
        if (this.f3550b != this.f3552d) {
            return false;
        }
        if (c0586a.f3570d) {
            viewM3611g = m3610f(c0617o, c0621s);
        } else {
            viewM3611g = m3611g(c0617o, c0621s);
        }
        if (viewM3611g == null) {
            return false;
        }
        c0586a.m3665b(viewM3611g, m3979d(viewM3611g));
        if (!c0621s.m4101a() && mo3563b()) {
            if (this.f3558j.mo9496a(viewM3611g) >= this.f3558j.mo9503d() || this.f3558j.mo9500b(viewM3611g) < this.f3558j.mo9501c()) {
                if (c0586a.f3570d) {
                    iMo9501c = this.f3558j.mo9503d();
                } else {
                    iMo9501c = this.f3558j.mo9501c();
                }
                c0586a.f3569c = iMo9501c;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3603a(RecyclerView.C0621s c0621s, C0586a c0586a) {
        int iMo9496a;
        if (c0621s.m4101a() || this.f3560l == -1) {
            return false;
        }
        if (this.f3560l < 0 || this.f3560l >= c0621s.m4105e()) {
            this.f3560l = -1;
            this.f3561m = ExploreByTouchHelper.INVALID_ID;
            return false;
        }
        c0586a.f3568b = this.f3560l;
        if (this.f3562n != null && this.f3562n.m3657a()) {
            c0586a.f3570d = this.f3562n.f3566c;
            if (c0586a.f3570d) {
                c0586a.f3569c = this.f3558j.mo9503d() - this.f3562n.f3565b;
            } else {
                c0586a.f3569c = this.f3558j.mo9501c() + this.f3562n.f3565b;
            }
            return true;
        }
        if (this.f3561m == Integer.MIN_VALUE) {
            View viewMo3636c = mo3636c(this.f3560l);
            if (viewMo3636c != null) {
                if (this.f3558j.mo9506e(viewMo3636c) > this.f3558j.mo9507f()) {
                    c0586a.m3664b();
                    return true;
                }
                if (this.f3558j.mo9496a(viewMo3636c) - this.f3558j.mo9501c() < 0) {
                    c0586a.f3569c = this.f3558j.mo9501c();
                    c0586a.f3570d = false;
                    return true;
                }
                if (this.f3558j.mo9503d() - this.f3558j.mo9500b(viewMo3636c) < 0) {
                    c0586a.f3569c = this.f3558j.mo9503d();
                    c0586a.f3570d = true;
                    return true;
                }
                if (c0586a.f3570d) {
                    iMo9496a = this.f3558j.mo9500b(viewMo3636c) + this.f3558j.m9499b();
                } else {
                    iMo9496a = this.f3558j.mo9496a(viewMo3636c);
                }
                c0586a.f3569c = iMo9496a;
            } else {
                if (m4012v() > 0) {
                    c0586a.f3570d = (this.f3560l < m3979d(m3995i(0))) == this.f3559k;
                }
                c0586a.m3664b();
            }
            return true;
        }
        c0586a.f3570d = this.f3559k;
        if (this.f3559k) {
            c0586a.f3569c = this.f3558j.mo9503d() - this.f3561m;
        } else {
            c0586a.f3569c = this.f3558j.mo9501c() + this.f3561m;
        }
        return true;
    }

    /* JADX INFO: renamed from: a */
    private int m3594a(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, boolean z) {
        int iMo9503d;
        int iMo9503d2 = this.f3558j.mo9503d() - i;
        if (iMo9503d2 <= 0) {
            return 0;
        }
        int i2 = -m3634c(-iMo9503d2, c0617o, c0621s);
        int i3 = i + i2;
        if (!z || (iMo9503d = this.f3558j.mo9503d() - i3) <= 0) {
            return i2;
        }
        this.f3558j.mo9498a(iMo9503d);
        return iMo9503d + i2;
    }

    /* JADX INFO: renamed from: b */
    private int m3604b(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, boolean z) {
        int iMo9501c;
        int iMo9501c2 = i - this.f3558j.mo9501c();
        if (iMo9501c2 <= 0) {
            return 0;
        }
        int i2 = -m3634c(iMo9501c2, c0617o, c0621s);
        int i3 = i + i2;
        if (!z || (iMo9501c = i3 - this.f3558j.mo9501c()) <= 0) {
            return i2;
        }
        this.f3558j.mo9498a(-iMo9501c);
        return i2 - iMo9501c;
    }

    /* JADX INFO: renamed from: a */
    private void m3598a(C0586a c0586a) {
        m3596a(c0586a.f3568b, c0586a.f3569c);
    }

    /* JADX INFO: renamed from: a */
    private void m3596a(int i, int i2) {
        this.f3549a.f3578c = this.f3558j.mo9503d() - i2;
        this.f3549a.f3580e = this.f3559k ? -1 : 1;
        this.f3549a.f3579d = i;
        this.f3549a.f3581f = 1;
        this.f3549a.f3577b = i2;
        this.f3549a.f3582g = ExploreByTouchHelper.INVALID_ID;
    }

    /* JADX INFO: renamed from: b */
    private void m3606b(C0586a c0586a) {
        m3612g(c0586a.f3568b, c0586a.f3569c);
    }

    /* JADX INFO: renamed from: g */
    private void m3612g(int i, int i2) {
        this.f3549a.f3578c = i2 - this.f3558j.mo9501c();
        this.f3549a.f3579d = i;
        this.f3549a.f3580e = this.f3559k ? 1 : -1;
        this.f3549a.f3581f = -1;
        this.f3549a.f3577b = i2;
        this.f3549a.f3582g = ExploreByTouchHelper.INVALID_ID;
    }

    /* JADX INFO: renamed from: h */
    protected boolean m3650h() {
        return m4010t() == 1;
    }

    /* JADX INFO: renamed from: i */
    void m3651i() {
        if (this.f3549a == null) {
            this.f3549a = m3652j();
        }
    }

    /* JADX INFO: renamed from: j */
    C0588c m3652j() {
        return new C0588c();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: e */
    public void mo3642e(int i) {
        this.f3560l = i;
        this.f3561m = ExploreByTouchHelper.INVALID_ID;
        if (this.f3562n != null) {
            this.f3562n.m3658b();
        }
        m4005o();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public int mo3540a(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (this.f3557i == 1) {
            return 0;
        }
        return m3634c(i, c0617o, c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public int mo3560b(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (this.f3557i == 0) {
            return 0;
        }
        return m3634c(i, c0617o, c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public int mo3635c(RecyclerView.C0621s c0621s) {
        return m3614i(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: d */
    public int mo3638d(RecyclerView.C0621s c0621s) {
        return m3614i(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: e */
    public int mo3641e(RecyclerView.C0621s c0621s) {
        return m3616j(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: f */
    public int mo3645f(RecyclerView.C0621s c0621s) {
        return m3616j(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: g */
    public int mo3648g(RecyclerView.C0621s c0621s) {
        return m3618k(c0621s);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: h */
    public int mo3649h(RecyclerView.C0621s c0621s) {
        return m3618k(c0621s);
    }

    /* JADX INFO: renamed from: i */
    private int m3614i(RecyclerView.C0621s c0621s) {
        if (m4012v() == 0) {
            return 0;
        }
        m3651i();
        return C1757gv.m9549a(c0621s, this.f3558j, m3595a(!this.f3553e, true), m3605b(!this.f3553e, true), this, this.f3553e, this.f3559k);
    }

    /* JADX INFO: renamed from: j */
    private int m3616j(RecyclerView.C0621s c0621s) {
        if (m4012v() == 0) {
            return 0;
        }
        m3651i();
        return C1757gv.m9548a(c0621s, this.f3558j, m3595a(!this.f3553e, true), m3605b(!this.f3553e, true), this, this.f3553e);
    }

    /* JADX INFO: renamed from: k */
    private int m3618k(RecyclerView.C0621s c0621s) {
        if (m4012v() == 0) {
            return 0;
        }
        m3651i();
        return C1757gv.m9550b(c0621s, this.f3558j, m3595a(!this.f3553e, true), m3605b(!this.f3553e, true), this, this.f3553e);
    }

    /* JADX INFO: renamed from: a */
    private void m3597a(int i, int i2, boolean z, RecyclerView.C0621s c0621s) {
        int iMo9501c;
        this.f3549a.f3587l = m3653k();
        this.f3549a.f3583h = m3630b(c0621s);
        this.f3549a.f3581f = i;
        if (i == 1) {
            this.f3549a.f3583h += this.f3558j.mo9509g();
            View viewM3593M = m3593M();
            this.f3549a.f3580e = this.f3559k ? -1 : 1;
            this.f3549a.f3579d = m3979d(viewM3593M) + this.f3549a.f3580e;
            this.f3549a.f3577b = this.f3558j.mo9500b(viewM3593M);
            iMo9501c = this.f3558j.mo9500b(viewM3593M) - this.f3558j.mo9503d();
        } else {
            View viewM3592L = m3592L();
            this.f3549a.f3583h += this.f3558j.mo9501c();
            this.f3549a.f3580e = this.f3559k ? 1 : -1;
            this.f3549a.f3579d = m3979d(viewM3592L) + this.f3549a.f3580e;
            this.f3549a.f3577b = this.f3558j.mo9496a(viewM3592L);
            iMo9501c = (-this.f3558j.mo9496a(viewM3592L)) + this.f3558j.mo9501c();
        }
        this.f3549a.f3578c = i2;
        if (z) {
            this.f3549a.f3578c -= iMo9501c;
        }
        this.f3549a.f3582g = iMo9501c;
    }

    /* JADX INFO: renamed from: k */
    boolean m3653k() {
        return this.f3558j.mo9510h() == 0 && this.f3558j.mo9505e() == 0;
    }

    /* JADX INFO: renamed from: a */
    void mo3553a(RecyclerView.C0621s c0621s, C0588c c0588c, RecyclerView.AbstractC0611i.a aVar) {
        int i = c0588c.f3579d;
        if (i < 0 || i >= c0621s.m4105e()) {
            return;
        }
        aVar.mo4022b(i, Math.max(0, c0588c.f3582g));
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3625a(int i, RecyclerView.AbstractC0611i.a aVar) {
        boolean z;
        int i2;
        if (this.f3562n != null && this.f3562n.m3657a()) {
            z = this.f3562n.f3566c;
            i2 = this.f3562n.f3564a;
        } else {
            m3591K();
            z = this.f3559k;
            if (this.f3560l == -1) {
                i2 = z ? i - 1 : 0;
            } else {
                i2 = this.f3560l;
            }
        }
        int i3 = z ? -1 : 1;
        for (int i4 = 0; i4 < this.f3556h && i2 >= 0 && i2 < i; i4++) {
            aVar.mo4022b(i2, 0);
            i2 += i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3624a(int i, int i2, RecyclerView.C0621s c0621s, RecyclerView.AbstractC0611i.a aVar) {
        if (this.f3557i != 0) {
            i = i2;
        }
        if (m4012v() == 0 || i == 0) {
            return;
        }
        m3651i();
        m3597a(i > 0 ? 1 : -1, Math.abs(i), true, c0621s);
        mo3553a(c0621s, this.f3549a, aVar);
    }

    /* JADX INFO: renamed from: c */
    int m3634c(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (m4012v() == 0 || i == 0) {
            return 0;
        }
        this.f3549a.f3576a = true;
        m3651i();
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        m3597a(i2, iAbs, true, c0621s);
        int iM3622a = this.f3549a.f3582g + m3622a(c0617o, this.f3549a, c0621s, false);
        if (iM3622a < 0) {
            return 0;
        }
        if (iAbs > iM3622a) {
            i = i2 * iM3622a;
        }
        this.f3558j.mo9498a(-i);
        this.f3549a.f3585j = i;
        return i;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3629a(String str) {
        if (this.f3562n == null) {
            super.mo3629a(str);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3600a(RecyclerView.C0617o c0617o, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                m3936a(i, c0617o);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                m3936a(i3, c0617o);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3599a(RecyclerView.C0617o c0617o, int i) {
        if (i < 0) {
            return;
        }
        int iV = m4012v();
        if (!this.f3559k) {
            for (int i2 = 0; i2 < iV; i2++) {
                View viewI = m3995i(i2);
                if (this.f3558j.mo9500b(viewI) > i || this.f3558j.mo9502c(viewI) > i) {
                    m3600a(c0617o, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = iV - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View viewI2 = m3995i(i4);
            if (this.f3558j.mo9500b(viewI2) > i || this.f3558j.mo9502c(viewI2) > i) {
                m3600a(c0617o, i3, i4);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3607b(RecyclerView.C0617o c0617o, int i) {
        int iV = m4012v();
        if (i < 0) {
            return;
        }
        int iMo9505e = this.f3558j.mo9505e() - i;
        if (this.f3559k) {
            for (int i2 = 0; i2 < iV; i2++) {
                View viewI = m3995i(i2);
                if (this.f3558j.mo9496a(viewI) < iMo9505e || this.f3558j.mo9504d(viewI) < iMo9505e) {
                    m3600a(c0617o, 0, i2);
                    return;
                }
            }
            return;
        }
        int i3 = iV - 1;
        for (int i4 = i3; i4 >= 0; i4--) {
            View viewI2 = m3995i(i4);
            if (this.f3558j.mo9496a(viewI2) < iMo9505e || this.f3558j.mo9504d(viewI2) < iMo9505e) {
                m3600a(c0617o, i3, i4);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3601a(RecyclerView.C0617o c0617o, C0588c c0588c) {
        if (!c0588c.f3576a || c0588c.f3587l) {
            return;
        }
        if (c0588c.f3581f == -1) {
            m3607b(c0617o, c0588c.f3582g);
        } else {
            m3599a(c0617o, c0588c.f3582g);
        }
    }

    /* JADX INFO: renamed from: a */
    int m3622a(RecyclerView.C0617o c0617o, C0588c c0588c, RecyclerView.C0621s c0621s, boolean z) {
        int i = c0588c.f3578c;
        if (c0588c.f3582g != Integer.MIN_VALUE) {
            if (c0588c.f3578c < 0) {
                c0588c.f3582g += c0588c.f3578c;
            }
            m3601a(c0617o, c0588c);
        }
        int i2 = c0588c.f3578c + c0588c.f3583h;
        C0587b c0587b = this.f3555g;
        while (true) {
            if ((!c0588c.f3587l && i2 <= 0) || !c0588c.m3671a(c0621s)) {
                break;
            }
            c0587b.m3666a();
            mo3550a(c0617o, c0621s, c0588c, c0587b);
            if (!c0587b.f3573b) {
                c0588c.f3577b += c0587b.f3572a * c0588c.f3581f;
                if (!c0587b.f3574c || this.f3549a.f3586k != null || !c0621s.m4101a()) {
                    c0588c.f3578c -= c0587b.f3572a;
                    i2 -= c0587b.f3572a;
                }
                if (c0588c.f3582g != Integer.MIN_VALUE) {
                    c0588c.f3582g += c0587b.f3572a;
                    if (c0588c.f3578c < 0) {
                        c0588c.f3582g += c0588c.f3578c;
                    }
                    m3601a(c0617o, c0588c);
                }
                if (z && c0587b.f3575d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - c0588c.f3578c;
    }

    /* JADX INFO: renamed from: a */
    void mo3550a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, C0588c c0588c, C0587b c0587b) {
        int i;
        int i2;
        int i3;
        int iA;
        int iMo9508f;
        View viewM3668a = c0588c.m3668a(c0617o);
        if (viewM3668a == null) {
            c0587b.f3573b = true;
            return;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) viewM3668a.getLayoutParams();
        if (c0588c.f3586k == null) {
            if (this.f3559k == (c0588c.f3581f == -1)) {
                m3968b(viewM3668a);
            } else {
                m3969b(viewM3668a, 0);
            }
        } else {
            if (this.f3559k == (c0588c.f3581f == -1)) {
                m3944a(viewM3668a);
            } else {
                m3945a(viewM3668a, 0);
            }
        }
        m3946a(viewM3668a, 0, 0);
        c0587b.f3572a = this.f3558j.mo9506e(viewM3668a);
        if (this.f3557i == 1) {
            if (m3650h()) {
                iMo9508f = m4015y() - m3928C();
                iA = iMo9508f - this.f3558j.mo9508f(viewM3668a);
            } else {
                iA = m3926A();
                iMo9508f = this.f3558j.mo9508f(viewM3668a) + iA;
            }
            if (c0588c.f3581f == -1) {
                int i4 = c0588c.f3577b;
                i2 = c0588c.f3577b - c0587b.f3572a;
                i = iMo9508f;
                i3 = i4;
            } else {
                int i5 = c0588c.f3577b;
                i3 = c0588c.f3577b + c0587b.f3572a;
                i = iMo9508f;
                i2 = i5;
            }
        } else {
            int iB = m3927B();
            int iMo9508f2 = this.f3558j.mo9508f(viewM3668a) + iB;
            if (c0588c.f3581f == -1) {
                i2 = iB;
                i = c0588c.f3577b;
                i3 = iMo9508f2;
                iA = c0588c.f3577b - c0587b.f3572a;
            } else {
                int i6 = c0588c.f3577b;
                i = c0588c.f3577b + c0587b.f3572a;
                i2 = iB;
                i3 = iMo9508f2;
                iA = i6;
            }
        }
        m3947a(viewM3668a, iA, i2, i, i3);
        if (layoutParams.m3856d() || layoutParams.m3857e()) {
            c0587b.f3574c = true;
        }
        c0587b.f3575d = viewM3668a.hasFocusable();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: l */
    boolean mo3654l() {
        return (m4014x() == 1073741824 || m4013w() == 1073741824 || !m3935J()) ? false : true;
    }

    /* JADX INFO: renamed from: f */
    int m3644f(int i) {
        if (i == 17) {
            if (this.f3557i == 0) {
                return -1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (i == 33) {
            if (this.f3557i == 1) {
                return -1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (i == 66) {
            if (this.f3557i == 0) {
                return 1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        if (i == 130) {
            if (this.f3557i == 1) {
                return 1;
            }
            return ExploreByTouchHelper.INVALID_ID;
        }
        switch (i) {
            case 1:
                return (this.f3557i != 1 && m3650h()) ? 1 : -1;
            case 2:
                return (this.f3557i != 1 && m3650h()) ? -1 : 1;
            default:
                return ExploreByTouchHelper.INVALID_ID;
        }
    }

    /* JADX INFO: renamed from: L */
    private View m3592L() {
        return m3995i(this.f3559k ? m4012v() - 1 : 0);
    }

    /* JADX INFO: renamed from: M */
    private View m3593M() {
        return m3995i(this.f3559k ? 0 : m4012v() - 1);
    }

    /* JADX INFO: renamed from: a */
    private View m3595a(boolean z, boolean z2) {
        if (this.f3559k) {
            return m3623a(m4012v() - 1, -1, z, z2);
        }
        return m3623a(0, m4012v(), z, z2);
    }

    /* JADX INFO: renamed from: b */
    private View m3605b(boolean z, boolean z2) {
        if (this.f3559k) {
            return m3623a(0, m4012v(), z, z2);
        }
        return m3623a(m4012v() - 1, -1, z, z2);
    }

    /* JADX INFO: renamed from: f */
    private View m3610f(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return this.f3559k ? m3613h(c0617o, c0621s) : m3615i(c0617o, c0621s);
    }

    /* JADX INFO: renamed from: g */
    private View m3611g(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return this.f3559k ? m3615i(c0617o, c0621s) : m3613h(c0617o, c0621s);
    }

    /* JADX INFO: renamed from: h */
    private View m3613h(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return mo3545a(c0617o, c0621s, 0, m4012v(), c0621s.m4105e());
    }

    /* JADX INFO: renamed from: i */
    private View m3615i(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return mo3545a(c0617o, c0621s, m4012v() - 1, -1, c0621s.m4105e());
    }

    /* JADX INFO: renamed from: a */
    View mo3545a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, int i, int i2, int i3) {
        m3651i();
        int iMo9501c = this.f3558j.mo9501c();
        int iMo9503d = this.f3558j.mo9503d();
        int i4 = i2 > i ? 1 : -1;
        View view = null;
        View view2 = null;
        while (i != i2) {
            View viewI = m3995i(i);
            int iD = m3979d(viewI);
            if (iD >= 0 && iD < i3) {
                if (((RecyclerView.LayoutParams) viewI.getLayoutParams()).m3856d()) {
                    if (view2 == null) {
                        view2 = viewI;
                    }
                } else {
                    if (this.f3558j.mo9496a(viewI) < iMo9503d && this.f3558j.mo9500b(viewI) >= iMo9501c) {
                        return viewI;
                    }
                    if (view == null) {
                        view = viewI;
                    }
                }
            }
            i += i4;
        }
        return view != null ? view : view2;
    }

    /* JADX INFO: renamed from: j */
    private View m3617j(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return this.f3559k ? m3620l(c0617o, c0621s) : m3621m(c0617o, c0621s);
    }

    /* JADX INFO: renamed from: k */
    private View m3619k(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return this.f3559k ? m3621m(c0617o, c0621s) : m3620l(c0617o, c0621s);
    }

    /* JADX INFO: renamed from: l */
    private View m3620l(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return m3631b(0, m4012v());
    }

    /* JADX INFO: renamed from: m */
    private View m3621m(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        return m3631b(m4012v() - 1, -1);
    }

    /* JADX INFO: renamed from: m */
    public int m3655m() {
        View viewM3623a = m3623a(0, m4012v(), false, true);
        if (viewM3623a == null) {
            return -1;
        }
        return m3979d(viewM3623a);
    }

    /* JADX INFO: renamed from: n */
    public int m3656n() {
        View viewM3623a = m3623a(m4012v() - 1, -1, false, true);
        if (viewM3623a == null) {
            return -1;
        }
        return m3979d(viewM3623a);
    }

    /* JADX INFO: renamed from: a */
    View m3623a(int i, int i2, boolean z, boolean z2) {
        m3651i();
        int i3 = z ? 24579 : 320;
        int i4 = z2 ? 320 : 0;
        if (this.f3557i == 0) {
            return this.f3754r.m9651a(i, i2, i3, i4);
        }
        return this.f3755s.m9651a(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: b */
    View m3631b(int i, int i2) {
        int i3;
        int i4;
        m3651i();
        if ((i2 > i ? (byte) 1 : i2 < i ? (byte) -1 : (byte) 0) == 0) {
            return m3995i(i);
        }
        if (this.f3558j.mo9496a(m3995i(i)) < this.f3558j.mo9501c()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        if (this.f3557i == 0) {
            return this.f3754r.m9651a(i, i2, i3, i4);
        }
        return this.f3755s.m9651a(i, i2, i3, i4);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public View mo3546a(View view, int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        int iM3644f;
        View viewM3617j;
        View viewM3593M;
        m3591K();
        if (m4012v() == 0 || (iM3644f = m3644f(i)) == Integer.MIN_VALUE) {
            return null;
        }
        m3651i();
        m3651i();
        m3597a(iM3644f, (int) (this.f3558j.mo9507f() * 0.33333334f), false, c0621s);
        this.f3549a.f3582g = ExploreByTouchHelper.INVALID_ID;
        this.f3549a.f3576a = false;
        m3622a(c0617o, this.f3549a, c0621s, true);
        if (iM3644f == -1) {
            viewM3617j = m3619k(c0617o, c0621s);
        } else {
            viewM3617j = m3617j(c0617o, c0621s);
        }
        if (iM3644f == -1) {
            viewM3593M = m3592L();
        } else {
            viewM3593M = m3593M();
        }
        if (!viewM3593M.hasFocusable()) {
            return viewM3617j;
        }
        if (viewM3617j == null) {
            return null;
        }
        return viewM3593M;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public boolean mo3563b() {
        return this.f3562n == null && this.f3550b == this.f3552d;
    }

    /* JADX INFO: renamed from: android.support.v7.widget.LinearLayoutManager$c */
    static class C0588c {

        /* JADX INFO: renamed from: b */
        int f3577b;

        /* JADX INFO: renamed from: c */
        int f3578c;

        /* JADX INFO: renamed from: d */
        int f3579d;

        /* JADX INFO: renamed from: e */
        int f3580e;

        /* JADX INFO: renamed from: f */
        int f3581f;

        /* JADX INFO: renamed from: g */
        int f3582g;

        /* JADX INFO: renamed from: j */
        int f3585j;

        /* JADX INFO: renamed from: l */
        boolean f3587l;

        /* JADX INFO: renamed from: a */
        boolean f3576a = true;

        /* JADX INFO: renamed from: h */
        int f3583h = 0;

        /* JADX INFO: renamed from: i */
        boolean f3584i = false;

        /* JADX INFO: renamed from: k */
        List<RecyclerView.AbstractC0624v> f3586k = null;

        C0588c() {
        }

        /* JADX INFO: renamed from: a */
        boolean m3671a(RecyclerView.C0621s c0621s) {
            return this.f3579d >= 0 && this.f3579d < c0621s.m4105e();
        }

        /* JADX INFO: renamed from: a */
        View m3668a(RecyclerView.C0617o c0617o) {
            if (this.f3586k != null) {
                return m3667b();
            }
            View viewM4066c = c0617o.m4066c(this.f3579d);
            this.f3579d += this.f3580e;
            return viewM4066c;
        }

        /* JADX INFO: renamed from: b */
        private View m3667b() {
            int size = this.f3586k.size();
            for (int i = 0; i < size; i++) {
                View view = this.f3586k.get(i).f3823a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                if (!layoutParams.m3856d() && this.f3579d == layoutParams.m3858f()) {
                    m3670a(view);
                    return view;
                }
            }
            return null;
        }

        /* JADX INFO: renamed from: a */
        public void m3669a() {
            m3670a((View) null);
        }

        /* JADX INFO: renamed from: a */
        public void m3670a(View view) {
            View viewM3672b = m3672b(view);
            if (viewM3672b == null) {
                this.f3579d = -1;
            } else {
                this.f3579d = ((RecyclerView.LayoutParams) viewM3672b.getLayoutParams()).m3858f();
            }
        }

        /* JADX INFO: renamed from: b */
        public View m3672b(View view) {
            int iM3858f;
            int size = this.f3586k.size();
            View view2 = null;
            int i = Integer.MAX_VALUE;
            for (int i2 = 0; i2 < size; i2++) {
                View view3 = this.f3586k.get(i2).f3823a;
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view3.getLayoutParams();
                if (view3 != view && !layoutParams.m3856d() && (iM3858f = (layoutParams.m3858f() - this.f3579d) * this.f3580e) >= 0 && iM3858f < i) {
                    if (iM3858f == 0) {
                        return view3;
                    }
                    view2 = view3;
                    i = iM3858f;
                }
            }
            return view2;
        }
    }

    public static class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() { // from class: android.support.v7.widget.LinearLayoutManager.SavedState.1
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
        int f3564a;

        /* JADX INFO: renamed from: b */
        int f3565b;

        /* JADX INFO: renamed from: c */
        boolean f3566c;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public SavedState() {
        }

        SavedState(Parcel parcel) {
            this.f3564a = parcel.readInt();
            this.f3565b = parcel.readInt();
            this.f3566c = parcel.readInt() == 1;
        }

        public SavedState(SavedState savedState) {
            this.f3564a = savedState.f3564a;
            this.f3565b = savedState.f3565b;
            this.f3566c = savedState.f3566c;
        }

        /* JADX INFO: renamed from: a */
        boolean m3657a() {
            return this.f3564a >= 0;
        }

        /* JADX INFO: renamed from: b */
        void m3658b() {
            this.f3564a = -1;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f3564a);
            parcel.writeInt(this.f3565b);
            parcel.writeInt(this.f3566c ? 1 : 0);
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.LinearLayoutManager$a */
    static class C0586a {

        /* JADX INFO: renamed from: a */
        AbstractC1752gq f3567a;

        /* JADX INFO: renamed from: b */
        int f3568b;

        /* JADX INFO: renamed from: c */
        int f3569c;

        /* JADX INFO: renamed from: d */
        boolean f3570d;

        /* JADX INFO: renamed from: e */
        boolean f3571e;

        C0586a() {
            m3661a();
        }

        /* JADX INFO: renamed from: a */
        void m3661a() {
            this.f3568b = -1;
            this.f3569c = ExploreByTouchHelper.INVALID_ID;
            this.f3570d = false;
            this.f3571e = false;
        }

        /* JADX INFO: renamed from: b */
        void m3664b() {
            int iMo9501c;
            if (this.f3570d) {
                iMo9501c = this.f3567a.mo9503d();
            } else {
                iMo9501c = this.f3567a.mo9501c();
            }
            this.f3569c = iMo9501c;
        }

        public String toString() {
            return "AnchorInfo{mPosition=" + this.f3568b + ", mCoordinate=" + this.f3569c + ", mLayoutFromEnd=" + this.f3570d + ", mValid=" + this.f3571e + '}';
        }

        /* JADX INFO: renamed from: a */
        boolean m3663a(View view, RecyclerView.C0621s c0621s) {
            RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
            return !layoutParams.m3856d() && layoutParams.m3858f() >= 0 && layoutParams.m3858f() < c0621s.m4105e();
        }

        /* JADX INFO: renamed from: a */
        public void m3662a(View view, int i) {
            int iM9499b = this.f3567a.m9499b();
            if (iM9499b >= 0) {
                m3665b(view, i);
                return;
            }
            this.f3568b = i;
            if (this.f3570d) {
                int iMo9503d = (this.f3567a.mo9503d() - iM9499b) - this.f3567a.mo9500b(view);
                this.f3569c = this.f3567a.mo9503d() - iMo9503d;
                if (iMo9503d > 0) {
                    int iMo9506e = this.f3569c - this.f3567a.mo9506e(view);
                    int iMo9501c = this.f3567a.mo9501c();
                    int iMin = iMo9506e - (iMo9501c + Math.min(this.f3567a.mo9496a(view) - iMo9501c, 0));
                    if (iMin < 0) {
                        this.f3569c += Math.min(iMo9503d, -iMin);
                        return;
                    }
                    return;
                }
                return;
            }
            int iMo9496a = this.f3567a.mo9496a(view);
            int iMo9501c2 = iMo9496a - this.f3567a.mo9501c();
            this.f3569c = iMo9496a;
            if (iMo9501c2 > 0) {
                int iMo9503d2 = (this.f3567a.mo9503d() - Math.min(0, (this.f3567a.mo9503d() - iM9499b) - this.f3567a.mo9500b(view))) - (iMo9496a + this.f3567a.mo9506e(view));
                if (iMo9503d2 < 0) {
                    this.f3569c -= Math.min(iMo9501c2, -iMo9503d2);
                }
            }
        }

        /* JADX INFO: renamed from: b */
        public void m3665b(View view, int i) {
            if (this.f3570d) {
                this.f3569c = this.f3567a.mo9500b(view) + this.f3567a.m9499b();
            } else {
                this.f3569c = this.f3567a.mo9496a(view);
            }
            this.f3568b = i;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.LinearLayoutManager$b */
    public static class C0587b {

        /* JADX INFO: renamed from: a */
        public int f3572a;

        /* JADX INFO: renamed from: b */
        public boolean f3573b;

        /* JADX INFO: renamed from: c */
        public boolean f3574c;

        /* JADX INFO: renamed from: d */
        public boolean f3575d;

        protected C0587b() {
        }

        /* JADX INFO: renamed from: a */
        void m3666a() {
            this.f3572a = 0;
            this.f3573b = false;
            this.f3574c = false;
            this.f3575d = false;
        }
    }
}
