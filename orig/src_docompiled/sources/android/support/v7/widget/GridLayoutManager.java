package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {

    /* JADX INFO: renamed from: a */
    boolean f3520a;

    /* JADX INFO: renamed from: b */
    int f3521b;

    /* JADX INFO: renamed from: c */
    int[] f3522c;

    /* JADX INFO: renamed from: d */
    View[] f3523d;

    /* JADX INFO: renamed from: e */
    final SparseIntArray f3524e;

    /* JADX INFO: renamed from: f */
    final SparseIntArray f3525f;

    /* JADX INFO: renamed from: g */
    AbstractC0584b f3526g;

    /* JADX INFO: renamed from: h */
    final Rect f3527h;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f3520a = false;
        this.f3521b = -1;
        this.f3524e = new SparseIntArray();
        this.f3525f = new SparseIntArray();
        this.f3526g = new C0583a();
        this.f3527h = new Rect();
        m3547a(m3919a(context, attributeSet, i, i2).f3765b);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    public void mo3558a(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.mo3558a(false);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public int mo3541a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (this.f3557i == 0) {
            return this.f3521b;
        }
        if (c0621s.m4105e() < 1) {
            return 0;
        }
        return m3529a(c0617o, c0621s, c0621s.m4105e() - 1) + 1;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public int mo3561b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (this.f3557i == 1) {
            return this.f3521b;
        }
        if (c0621s.m4105e() < 1) {
            return 0;
        }
        return m3529a(c0617o, c0621s, c0621s.m4105e() - 1) + 1;
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
        int iM3529a = m3529a(c0617o, c0621s, layoutParams2.m3858f());
        if (this.f3557i == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(layoutParams2.m3565a(), layoutParams2.m3566b(), iM3529a, 1, this.f3521b > 1 && layoutParams2.m3566b() == this.f3521b, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(iM3529a, 1, layoutParams2.m3565a(), layoutParams2.m3566b(), this.f3521b > 1 && layoutParams2.m3566b() == this.f3521b, false));
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: c */
    public void mo3564c(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        if (c0621s.m4101a()) {
            m3526L();
        }
        super.mo3564c(c0617o, c0621s);
        m3525K();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3552a(RecyclerView.C0621s c0621s) {
        super.mo3552a(c0621s);
        this.f3520a = false;
    }

    /* JADX INFO: renamed from: K */
    private void m3525K() {
        this.f3524e.clear();
        this.f3525f.clear();
    }

    /* JADX INFO: renamed from: L */
    private void m3526L() {
        int iV = m4012v();
        for (int i = 0; i < iV; i++) {
            LayoutParams layoutParams = (LayoutParams) m3995i(i).getLayoutParams();
            int iF = layoutParams.m3858f();
            this.f3524e.put(iF, layoutParams.m3566b());
            this.f3525f.put(iF, layoutParams.m3565a());
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3555a(RecyclerView recyclerView, int i, int i2) {
        this.f3526g.m3569a();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3554a(RecyclerView recyclerView) {
        this.f3526g.m3569a();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public void mo3562b(RecyclerView recyclerView, int i, int i2) {
        this.f3526g.m3569a();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3557a(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.f3526g.m3569a();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3556a(RecyclerView recyclerView, int i, int i2, int i3) {
        this.f3526g.m3569a();
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public RecyclerView.LayoutParams mo3542a() {
        if (this.f3557i == 0) {
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

    /* JADX INFO: renamed from: M */
    private void m3527M() {
        int iZ;
        if (m3647g() == 1) {
            iZ = (m4015y() - m3928C()) - m3926A();
        } else {
            iZ = (m4016z() - m3929D()) - m3927B();
        }
        m3538m(iZ);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public void mo3548a(Rect rect, int i, int i2) {
        int iA;
        int iA2;
        if (this.f3522c == null) {
            super.mo3548a(rect, i, i2);
        }
        int iA3 = m3926A() + m3928C();
        int iB = m3927B() + m3929D();
        if (this.f3557i == 1) {
            iA2 = m3917a(i2, rect.height() + iB, m3932G());
            iA = m3917a(i, this.f3522c[this.f3522c.length - 1] + iA3, m3931F());
        } else {
            iA = m3917a(i, rect.width() + iA3, m3931F());
            iA2 = m3917a(i2, this.f3522c[this.f3522c.length - 1] + iB, m3932G());
        }
        m3988f(iA, iA2);
    }

    /* JADX INFO: renamed from: m */
    private void m3538m(int i) {
        this.f3522c = m3534a(this.f3522c, this.f3521b, i);
    }

    /* JADX INFO: renamed from: a */
    static int[] m3534a(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    int m3539a(int i, int i2) {
        if (this.f3557i == 1 && m3650h()) {
            return this.f3522c[this.f3521b - i] - this.f3522c[(this.f3521b - i) - i2];
        }
        return this.f3522c[i2 + i] - this.f3522c[i];
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    void mo3549a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, LinearLayoutManager.C0586a c0586a, int i) {
        super.mo3549a(c0617o, c0621s, c0586a, i);
        m3527M();
        if (c0621s.m4105e() > 0 && !c0621s.m4101a()) {
            m3536b(c0617o, c0621s, c0586a, i);
        }
        m3528N();
    }

    /* JADX INFO: renamed from: N */
    private void m3528N() {
        if (this.f3523d == null || this.f3523d.length != this.f3521b) {
            this.f3523d = new View[this.f3521b];
        }
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    public int mo3540a(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        m3527M();
        m3528N();
        return super.mo3540a(i, c0617o, c0621s);
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public int mo3560b(int i, RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s) {
        m3527M();
        m3528N();
        return super.mo3560b(i, c0617o, c0621s);
    }

    /* JADX INFO: renamed from: b */
    private void m3536b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, LinearLayoutManager.C0586a c0586a, int i) {
        boolean z = i == 1;
        int iM3535b = m3535b(c0617o, c0621s, c0586a.f3568b);
        if (z) {
            while (iM3535b > 0 && c0586a.f3568b > 0) {
                c0586a.f3568b--;
                iM3535b = m3535b(c0617o, c0621s, c0586a.f3568b);
            }
            return;
        }
        int iM4105e = c0621s.m4105e() - 1;
        int i2 = c0586a.f3568b;
        while (i2 < iM4105e) {
            int i3 = i2 + 1;
            int iM3535b2 = m3535b(c0617o, c0621s, i3);
            if (iM3535b2 <= iM3535b) {
                break;
            }
            i2 = i3;
            iM3535b = iM3535b2;
        }
        c0586a.f3568b = i2;
    }

    @Override // android.support.v7.widget.LinearLayoutManager
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
            if (iD >= 0 && iD < i3 && m3535b(c0617o, c0621s, iD) == 0) {
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

    /* JADX INFO: renamed from: a */
    private int m3529a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, int i) {
        if (!c0621s.m4101a()) {
            return this.f3526g.m3572c(i, this.f3521b);
        }
        int iM4060b = c0617o.m4060b(i);
        if (iM4060b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
            return 0;
        }
        return this.f3526g.m3572c(iM4060b, this.f3521b);
    }

    /* JADX INFO: renamed from: b */
    private int m3535b(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, int i) {
        if (!c0621s.m4101a()) {
            return this.f3526g.m3571b(i, this.f3521b);
        }
        int i2 = this.f3525f.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM4060b = c0617o.m4060b(i);
        if (iM4060b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 0;
        }
        return this.f3526g.m3571b(iM4060b, this.f3521b);
    }

    /* JADX INFO: renamed from: c */
    private int m3537c(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, int i) {
        if (!c0621s.m4101a()) {
            return this.f3526g.mo3567a(i);
        }
        int i2 = this.f3524e.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iM4060b = c0617o.m4060b(i);
        if (iM4060b == -1) {
            Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
            return 1;
        }
        return this.f3526g.mo3567a(iM4060b);
    }

    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    void mo3553a(RecyclerView.C0621s c0621s, LinearLayoutManager.C0588c c0588c, RecyclerView.AbstractC0611i.a aVar) {
        int iMo3567a = this.f3521b;
        for (int i = 0; i < this.f3521b && c0588c.m3671a(c0621s) && iMo3567a > 0; i++) {
            int i2 = c0588c.f3579d;
            aVar.mo4022b(i2, Math.max(0, c0588c.f3582g));
            iMo3567a -= this.f3526g.mo3567a(i2);
            c0588c.f3579d += c0588c.f3580e;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:99:0x021d  */
    @Override // android.support.v7.widget.LinearLayoutManager
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void mo3550a(android.support.v7.widget.RecyclerView.C0617o r19, android.support.v7.widget.RecyclerView.C0621s r20, android.support.v7.widget.LinearLayoutManager.C0588c r21, android.support.v7.widget.LinearLayoutManager.C0587b r22) {
        /*
            Method dump skipped, instruction units count: 568
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.mo3550a(android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$s, android.support.v7.widget.LinearLayoutManager$c, android.support.v7.widget.LinearLayoutManager$b):void");
    }

    /* JADX INFO: renamed from: a */
    private void m3533a(View view, int i, boolean z) {
        int iA;
        int iA2;
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect = layoutParams.f3727d;
        int i2 = rect.top + rect.bottom + layoutParams.topMargin + layoutParams.bottomMargin;
        int i3 = rect.left + rect.right + layoutParams.leftMargin + layoutParams.rightMargin;
        int iM3539a = m3539a(layoutParams.f3528a, layoutParams.f3529b);
        if (this.f3557i == 1) {
            iA2 = m3918a(iM3539a, i, i3, layoutParams.width, false);
            iA = m3918a(this.f3558j.mo9507f(), m4014x(), i2, layoutParams.height, true);
        } else {
            int iA3 = m3918a(iM3539a, i, i2, layoutParams.height, false);
            int iA4 = m3918a(this.f3558j.mo9507f(), m4013w(), i3, layoutParams.width, true);
            iA = iA3;
            iA2 = iA4;
        }
        m3532a(view, iA2, iA, z);
    }

    /* JADX INFO: renamed from: a */
    private void m3530a(float f, int i) {
        m3538m(Math.max(Math.round(f * this.f3521b), i));
    }

    /* JADX INFO: renamed from: a */
    private void m3532a(View view, int i, int i2, boolean z) {
        boolean zB;
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        if (z) {
            zB = m3961a(view, i, i2, layoutParams);
        } else {
            zB = m3971b(view, i, i2, layoutParams);
        }
        if (zB) {
            view.measure(i, i2);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m3531a(RecyclerView.C0617o c0617o, RecyclerView.C0621s c0621s, int i, int i2, boolean z) {
        int i3;
        int i4;
        int i5 = -1;
        int i6 = 0;
        if (z) {
            i5 = i;
            i3 = 0;
            i4 = 1;
        } else {
            i3 = i - 1;
            i4 = -1;
        }
        while (i3 != i5) {
            View view = this.f3523d[i3];
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            layoutParams.f3529b = m3537c(c0617o, c0621s, m3979d(view));
            layoutParams.f3528a = i6;
            i6 += layoutParams.f3529b;
            i3 += i4;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m3547a(int i) {
        if (i == this.f3521b) {
            return;
        }
        this.f3520a = true;
        if (i < 1) {
            throw new IllegalArgumentException("Span count should be at least 1. Provided " + i);
        }
        this.f3521b = i;
        this.f3526g.m3569a();
        m4005o();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.GridLayoutManager$b */
    public static abstract class AbstractC0584b {

        /* JADX INFO: renamed from: a */
        final SparseIntArray f3530a = new SparseIntArray();

        /* JADX INFO: renamed from: b */
        private boolean f3531b = false;

        /* JADX INFO: renamed from: a */
        public abstract int mo3567a(int i);

        /* JADX INFO: renamed from: a */
        public void m3569a() {
            this.f3530a.clear();
        }

        /* JADX INFO: renamed from: b */
        int m3571b(int i, int i2) {
            if (!this.f3531b) {
                return mo3568a(i, i2);
            }
            int i3 = this.f3530a.get(i, -1);
            if (i3 != -1) {
                return i3;
            }
            int iMo3568a = mo3568a(i, i2);
            this.f3530a.put(i, iMo3568a);
            return iMo3568a;
        }

        /* JADX INFO: renamed from: a */
        public int mo3568a(int i, int i2) {
            int i3;
            int iMo3567a;
            int iM3570b;
            int iMo3567a2 = mo3567a(i);
            if (iMo3567a2 == i2) {
                return 0;
            }
            if (!this.f3531b || this.f3530a.size() <= 0 || (iM3570b = m3570b(i)) < 0) {
                i3 = 0;
                iMo3567a = 0;
            } else {
                iMo3567a = this.f3530a.get(iM3570b) + mo3567a(iM3570b);
                i3 = iM3570b + 1;
            }
            while (i3 < i) {
                int iMo3567a3 = mo3567a(i3);
                iMo3567a += iMo3567a3;
                if (iMo3567a == i2) {
                    iMo3567a = 0;
                } else if (iMo3567a > i2) {
                    iMo3567a = iMo3567a3;
                }
                i3++;
            }
            if (iMo3567a2 + iMo3567a <= i2) {
                return iMo3567a;
            }
            return 0;
        }

        /* JADX INFO: renamed from: b */
        int m3570b(int i) {
            int size = this.f3530a.size() - 1;
            int i2 = 0;
            while (i2 <= size) {
                int i3 = (i2 + size) >>> 1;
                if (this.f3530a.keyAt(i3) < i) {
                    i2 = i3 + 1;
                } else {
                    size = i3 - 1;
                }
            }
            int i4 = i2 - 1;
            if (i4 < 0 || i4 >= this.f3530a.size()) {
                return -1;
            }
            return this.f3530a.keyAt(i4);
        }

        /* JADX INFO: renamed from: c */
        public int m3572c(int i, int i2) {
            int iMo3567a = mo3567a(i);
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int iMo3567a2 = mo3567a(i5);
                i3 += iMo3567a2;
                if (i3 == i2) {
                    i4++;
                    i3 = 0;
                } else if (i3 > i2) {
                    i4++;
                    i3 = iMo3567a2;
                }
            }
            return i3 + iMo3567a > i2 ? i4 + 1 : i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d8, code lost:
    
        if (r13 == (r2 > r8)) goto L48;
     */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0104  */
    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View mo3546a(android.view.View r27, int r28, android.support.v7.widget.RecyclerView.C0617o r29, android.support.v7.widget.RecyclerView.C0621s r30) {
        /*
            Method dump skipped, instruction units count: 333
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.GridLayoutManager.mo3546a(android.view.View, int, android.support.v7.widget.RecyclerView$o, android.support.v7.widget.RecyclerView$s):android.view.View");
    }

    @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
    /* JADX INFO: renamed from: b */
    public boolean mo3563b() {
        return this.f3562n == null && !this.f3520a;
    }

    /* JADX INFO: renamed from: android.support.v7.widget.GridLayoutManager$a */
    public static final class C0583a extends AbstractC0584b {
        @Override // android.support.v7.widget.GridLayoutManager.AbstractC0584b
        /* JADX INFO: renamed from: a */
        public int mo3567a(int i) {
            return 1;
        }

        @Override // android.support.v7.widget.GridLayoutManager.AbstractC0584b
        /* JADX INFO: renamed from: a */
        public int mo3568a(int i, int i2) {
            return i % i2;
        }
    }

    public static class LayoutParams extends RecyclerView.LayoutParams {

        /* JADX INFO: renamed from: a */
        int f3528a;

        /* JADX INFO: renamed from: b */
        int f3529b;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f3528a = -1;
            this.f3529b = 0;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3528a = -1;
            this.f3529b = 0;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.f3528a = -1;
            this.f3529b = 0;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f3528a = -1;
            this.f3529b = 0;
        }

        /* JADX INFO: renamed from: a */
        public int m3565a() {
            return this.f3528a;
        }

        /* JADX INFO: renamed from: b */
        public int m3566b() {
            return this.f3529b;
        }
    }
}
