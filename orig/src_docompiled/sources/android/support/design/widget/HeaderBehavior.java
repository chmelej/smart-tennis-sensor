package android.support.design.widget;

import android.content.Context;
import android.support.v4.math.MathUtils;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;

/* JADX INFO: loaded from: classes.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: a */
    OverScroller f2497a;

    /* JADX INFO: renamed from: b */
    private Runnable f2498b;

    /* JADX INFO: renamed from: c */
    private boolean f2499c;

    /* JADX INFO: renamed from: d */
    private int f2500d;

    /* JADX INFO: renamed from: e */
    private int f2501e;

    /* JADX INFO: renamed from: f */
    private int f2502f;

    /* JADX INFO: renamed from: g */
    private VelocityTracker f2503g;

    /* JADX INFO: renamed from: a */
    void mo2555a(CoordinatorLayout coordinatorLayout, V v) {
    }

    /* JADX INFO: renamed from: c */
    boolean mo2570c(V v) {
        return false;
    }

    public HeaderBehavior() {
        this.f2500d = -1;
        this.f2502f = -1;
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2500d = -1;
        this.f2502f = -1;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public boolean mo2610b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        int iFindPointerIndex;
        if (this.f2502f < 0) {
            this.f2502f = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.f2499c) {
            return true;
        }
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.f2499c = false;
                int x = (int) motionEvent.getX();
                int y = (int) motionEvent.getY();
                if (mo2570c(v) && coordinatorLayout.m2702a(v, x, y)) {
                    this.f2501e = y;
                    this.f2500d = motionEvent.getPointerId(0);
                    m2784d();
                }
                break;
            case 1:
            case 3:
                this.f2499c = false;
                this.f2500d = -1;
                if (this.f2503g != null) {
                    this.f2503g.recycle();
                    this.f2503g = null;
                }
                break;
            case 2:
                int i = this.f2500d;
                if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                    int y2 = (int) motionEvent.getY(iFindPointerIndex);
                    if (Math.abs(y2 - this.f2501e) > this.f2502f) {
                        this.f2499c = true;
                        this.f2501e = y2;
                    }
                }
                break;
        }
        if (this.f2503g != null) {
            this.f2503g.addMovement(motionEvent);
        }
        return this.f2499c;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b5  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo2513a(android.support.design.widget.CoordinatorLayout r12, V r13, android.view.MotionEvent r14) {
        /*
            r11 = this;
            int r0 = r11.f2502f
            if (r0 >= 0) goto L12
            android.content.Context r0 = r12.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r11.f2502f = r0
        L12:
            int r0 = r14.getActionMasked()
            r1 = 1
            r2 = -1
            r3 = 0
            switch(r0) {
                case 0: goto L8e;
                case 1: goto L59;
                case 2: goto L1e;
                case 3: goto L7d;
                default: goto L1c;
            }
        L1c:
            goto Lb1
        L1e:
            int r0 = r11.f2500d
            int r0 = r14.findPointerIndex(r0)
            if (r0 != r2) goto L27
            return r3
        L27:
            float r0 = r14.getY(r0)
            int r0 = (int) r0
            int r2 = r11.f2501e
            int r2 = r2 - r0
            boolean r3 = r11.f2499c
            if (r3 != 0) goto L46
            int r3 = java.lang.Math.abs(r2)
            int r4 = r11.f2502f
            if (r3 <= r4) goto L46
            r11.f2499c = r1
            if (r2 <= 0) goto L43
            int r3 = r11.f2502f
            int r2 = r2 - r3
            goto L46
        L43:
            int r3 = r11.f2502f
            int r2 = r2 + r3
        L46:
            r6 = r2
            boolean r2 = r11.f2499c
            if (r2 == 0) goto Lb1
            r11.f2501e = r0
            int r7 = r11.mo2566b(r13)
            r8 = 0
            r3 = r11
            r4 = r12
            r5 = r13
            r3.m2787b(r4, r5, r6, r7, r8)
            goto Lb1
        L59:
            android.view.VelocityTracker r0 = r11.f2503g
            if (r0 == 0) goto L7d
            android.view.VelocityTracker r0 = r11.f2503g
            r0.addMovement(r14)
            android.view.VelocityTracker r0 = r11.f2503g
            r4 = 1000(0x3e8, float:1.401E-42)
            r0.computeCurrentVelocity(r4)
            android.view.VelocityTracker r0 = r11.f2503g
            int r4 = r11.f2500d
            float r10 = r0.getYVelocity(r4)
            int r0 = r11.mo2549a(r13)
            int r8 = -r0
            r9 = 0
            r5 = r11
            r6 = r12
            r7 = r13
            r5.m2785a(r6, r7, r8, r9, r10)
        L7d:
            r11.f2499c = r3
            r11.f2500d = r2
            android.view.VelocityTracker r12 = r11.f2503g
            if (r12 == 0) goto Lb1
            android.view.VelocityTracker r12 = r11.f2503g
            r12.recycle()
            r12 = 0
            r11.f2503g = r12
            goto Lb1
        L8e:
            float r0 = r14.getX()
            int r0 = (int) r0
            float r2 = r14.getY()
            int r2 = (int) r2
            boolean r12 = r12.m2702a(r13, r0, r2)
            if (r12 == 0) goto Lb0
            boolean r12 = r11.mo2570c(r13)
            if (r12 == 0) goto Lb0
            r11.f2501e = r2
            int r12 = r14.getPointerId(r3)
            r11.f2500d = r12
            r11.m2784d()
            goto Lb1
        Lb0:
            return r3
        Lb1:
            android.view.VelocityTracker r12 = r11.f2503g
            if (r12 == 0) goto Lba
            android.view.VelocityTracker r12 = r11.f2503g
            r12.addMovement(r14)
        Lba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.HeaderBehavior.mo2513a(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    /* JADX INFO: renamed from: a_ */
    int m2786a_(CoordinatorLayout coordinatorLayout, V v, int i) {
        return mo2548a(coordinatorLayout, (View) v, i, ExploreByTouchHelper.INVALID_ID, Integer.MAX_VALUE);
    }

    /* JADX INFO: renamed from: a */
    int mo2548a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int iClamp;
        int iB = mo2576b();
        if (i2 == 0 || iB < i2 || iB > i3 || iB == (iClamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        mo2575a(iClamp);
        return iB - iClamp;
    }

    /* JADX INFO: renamed from: a */
    int mo2546a() {
        return mo2576b();
    }

    /* JADX INFO: renamed from: b */
    final int m2787b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return mo2548a(coordinatorLayout, (View) v, mo2546a() - i, i2, i3);
    }

    /* JADX INFO: renamed from: a */
    final boolean m2785a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f) {
        if (this.f2498b != null) {
            v.removeCallbacks(this.f2498b);
            this.f2498b = null;
        }
        if (this.f2497a == null) {
            this.f2497a = new OverScroller(v.getContext());
        }
        this.f2497a.fling(0, mo2576b(), 0, Math.round(f), 0, 0, i, i2);
        if (this.f2497a.computeScrollOffset()) {
            this.f2498b = new RunnableC0296a(coordinatorLayout, v);
            ViewCompat.postOnAnimation(v, this.f2498b);
            return true;
        }
        mo2555a(coordinatorLayout, v);
        return false;
    }

    /* JADX INFO: renamed from: b */
    int mo2566b(V v) {
        return -v.getHeight();
    }

    /* JADX INFO: renamed from: a */
    int mo2549a(V v) {
        return v.getHeight();
    }

    /* JADX INFO: renamed from: d */
    private void m2784d() {
        if (this.f2503g == null) {
            this.f2503g = VelocityTracker.obtain();
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.HeaderBehavior$a */
    class RunnableC0296a implements Runnable {

        /* JADX INFO: renamed from: b */
        private final CoordinatorLayout f2505b;

        /* JADX INFO: renamed from: c */
        private final V f2506c;

        RunnableC0296a(CoordinatorLayout coordinatorLayout, V v) {
            this.f2505b = coordinatorLayout;
            this.f2506c = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f2506c == null || HeaderBehavior.this.f2497a == null) {
                return;
            }
            if (HeaderBehavior.this.f2497a.computeScrollOffset()) {
                HeaderBehavior.this.m2786a_(this.f2505b, this.f2506c, HeaderBehavior.this.f2497a.getCurrY());
                ViewCompat.postOnAnimation(this.f2506c, this);
            } else {
                HeaderBehavior.this.mo2555a(this.f2505b, this.f2506c);
            }
        }
    }
}
