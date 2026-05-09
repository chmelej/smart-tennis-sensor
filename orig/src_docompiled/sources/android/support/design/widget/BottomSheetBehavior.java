package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.math.MathUtils;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    int f2364a;

    /* JADX INFO: renamed from: b */
    int f2365b;

    /* JADX INFO: renamed from: c */
    int f2366c;

    /* JADX INFO: renamed from: d */
    boolean f2367d;

    /* JADX INFO: renamed from: e */
    int f2368e;

    /* JADX INFO: renamed from: f */
    ViewDragHelper f2369f;

    /* JADX INFO: renamed from: g */
    int f2370g;

    /* JADX INFO: renamed from: h */
    WeakReference<V> f2371h;

    /* JADX INFO: renamed from: i */
    WeakReference<View> f2372i;

    /* JADX INFO: renamed from: j */
    int f2373j;

    /* JADX INFO: renamed from: k */
    boolean f2374k;

    /* JADX INFO: renamed from: l */
    private boolean f2375l;

    /* JADX INFO: renamed from: m */
    private float f2376m;

    /* JADX INFO: renamed from: n */
    private int f2377n;

    /* JADX INFO: renamed from: o */
    private boolean f2378o;

    /* JADX INFO: renamed from: p */
    private int f2379p;

    /* JADX INFO: renamed from: q */
    private int f2380q;

    /* JADX INFO: renamed from: r */
    private boolean f2381r;

    /* JADX INFO: renamed from: s */
    private boolean f2382s;

    /* JADX INFO: renamed from: t */
    private int f2383t;

    /* JADX INFO: renamed from: u */
    private boolean f2384u;

    /* JADX INFO: renamed from: v */
    private AbstractC0279a f2385v;

    /* JADX INFO: renamed from: w */
    private VelocityTracker f2386w;

    /* JADX INFO: renamed from: x */
    private int f2387x;

    /* JADX INFO: renamed from: y */
    private Map<View, Integer> f2388y;

    /* JADX INFO: renamed from: z */
    private final ViewDragHelper.Callback f2389z;

    /* JADX INFO: renamed from: android.support.design.widget.BottomSheetBehavior$a */
    public static abstract class AbstractC0279a {
        /* JADX INFO: renamed from: a */
        public abstract void mo2653a(View view, float f);

        /* JADX INFO: renamed from: a */
        public abstract void mo2654a(View view, int i);
    }

    public BottomSheetBehavior() {
        this.f2375l = true;
        this.f2368e = 4;
        this.f2389z = new ViewDragHelper.Callback() { // from class: android.support.design.widget.BottomSheetBehavior.2
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.f2368e == 1 || BottomSheetBehavior.this.f2374k) {
                    return false;
                }
                return ((BottomSheetBehavior.this.f2368e == 3 && BottomSheetBehavior.this.f2373j == i && (view2 = BottomSheetBehavior.this.f2372i.get()) != null && view2.canScrollVertically(-1)) || BottomSheetBehavior.this.f2371h == null || BottomSheetBehavior.this.f2371h.get() != view) ? false : true;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.m2649d(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.m2647c(1);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2;
                int i3;
                int i4 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.f2375l) {
                        i3 = BottomSheetBehavior.this.f2364a;
                        i4 = 3;
                    } else {
                        if (view.getTop() > BottomSheetBehavior.this.f2365b) {
                            i2 = BottomSheetBehavior.this.f2365b;
                            i3 = i2;
                            i4 = 6;
                        }
                        i3 = 0;
                        i4 = 3;
                    }
                } else if (BottomSheetBehavior.this.f2367d && BottomSheetBehavior.this.m2644a(view, f2) && (view.getTop() > BottomSheetBehavior.this.f2366c || Math.abs(f) < Math.abs(f2))) {
                    i3 = BottomSheetBehavior.this.f2370g;
                    i4 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.f2375l) {
                        if (Math.abs(top - BottomSheetBehavior.this.f2364a) < Math.abs(top - BottomSheetBehavior.this.f2366c)) {
                            i3 = BottomSheetBehavior.this.f2364a;
                            i4 = 3;
                        } else {
                            i = BottomSheetBehavior.this.f2366c;
                        }
                    } else {
                        if (top < BottomSheetBehavior.this.f2365b) {
                            if (top >= Math.abs(top - BottomSheetBehavior.this.f2366c)) {
                                i2 = BottomSheetBehavior.this.f2365b;
                            }
                            i3 = 0;
                            i4 = 3;
                        } else if (Math.abs(top - BottomSheetBehavior.this.f2365b) < Math.abs(top - BottomSheetBehavior.this.f2366c)) {
                            i2 = BottomSheetBehavior.this.f2365b;
                        } else {
                            i = BottomSheetBehavior.this.f2366c;
                        }
                        i3 = i2;
                        i4 = 6;
                    }
                    i3 = i;
                } else {
                    i3 = BottomSheetBehavior.this.f2366c;
                }
                if (BottomSheetBehavior.this.f2369f.settleCapturedViewAt(view.getLeft(), i3)) {
                    BottomSheetBehavior.this.m2647c(2);
                    ViewCompat.postOnAnimation(view, new RunnableC0280b(view, i4));
                } else {
                    BottomSheetBehavior.this.m2647c(i4);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.clamp(i, BottomSheetBehavior.this.m2636f(), BottomSheetBehavior.this.f2367d ? BottomSheetBehavior.this.f2370g : BottomSheetBehavior.this.f2366c);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                if (BottomSheetBehavior.this.f2367d) {
                    return BottomSheetBehavior.this.f2370g;
                }
                return BottomSheetBehavior.this.f2366c;
            }
        };
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2375l = true;
        this.f2368e = 4;
        this.f2389z = new ViewDragHelper.Callback() { // from class: android.support.design.widget.BottomSheetBehavior.2
            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public boolean tryCaptureView(View view, int i) {
                View view2;
                if (BottomSheetBehavior.this.f2368e == 1 || BottomSheetBehavior.this.f2374k) {
                    return false;
                }
                return ((BottomSheetBehavior.this.f2368e == 3 && BottomSheetBehavior.this.f2373j == i && (view2 = BottomSheetBehavior.this.f2372i.get()) != null && view2.canScrollVertically(-1)) || BottomSheetBehavior.this.f2371h == null || BottomSheetBehavior.this.f2371h.get() != view) ? false : true;
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
                BottomSheetBehavior.this.m2649d(i2);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewDragStateChanged(int i) {
                if (i == 1) {
                    BottomSheetBehavior.this.m2647c(1);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public void onViewReleased(View view, float f, float f2) {
                int i;
                int i2;
                int i3;
                int i4 = 4;
                if (f2 < 0.0f) {
                    if (BottomSheetBehavior.this.f2375l) {
                        i3 = BottomSheetBehavior.this.f2364a;
                        i4 = 3;
                    } else {
                        if (view.getTop() > BottomSheetBehavior.this.f2365b) {
                            i2 = BottomSheetBehavior.this.f2365b;
                            i3 = i2;
                            i4 = 6;
                        }
                        i3 = 0;
                        i4 = 3;
                    }
                } else if (BottomSheetBehavior.this.f2367d && BottomSheetBehavior.this.m2644a(view, f2) && (view.getTop() > BottomSheetBehavior.this.f2366c || Math.abs(f) < Math.abs(f2))) {
                    i3 = BottomSheetBehavior.this.f2370g;
                    i4 = 5;
                } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                    int top = view.getTop();
                    if (BottomSheetBehavior.this.f2375l) {
                        if (Math.abs(top - BottomSheetBehavior.this.f2364a) < Math.abs(top - BottomSheetBehavior.this.f2366c)) {
                            i3 = BottomSheetBehavior.this.f2364a;
                            i4 = 3;
                        } else {
                            i = BottomSheetBehavior.this.f2366c;
                        }
                    } else {
                        if (top < BottomSheetBehavior.this.f2365b) {
                            if (top >= Math.abs(top - BottomSheetBehavior.this.f2366c)) {
                                i2 = BottomSheetBehavior.this.f2365b;
                            }
                            i3 = 0;
                            i4 = 3;
                        } else if (Math.abs(top - BottomSheetBehavior.this.f2365b) < Math.abs(top - BottomSheetBehavior.this.f2366c)) {
                            i2 = BottomSheetBehavior.this.f2365b;
                        } else {
                            i = BottomSheetBehavior.this.f2366c;
                        }
                        i3 = i2;
                        i4 = 6;
                    }
                    i3 = i;
                } else {
                    i3 = BottomSheetBehavior.this.f2366c;
                }
                if (BottomSheetBehavior.this.f2369f.settleCapturedViewAt(view.getLeft(), i3)) {
                    BottomSheetBehavior.this.m2647c(2);
                    ViewCompat.postOnAnimation(view, new RunnableC0280b(view, i4));
                } else {
                    BottomSheetBehavior.this.m2647c(i4);
                }
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionVertical(View view, int i, int i2) {
                return MathUtils.clamp(i, BottomSheetBehavior.this.m2636f(), BottomSheetBehavior.this.f2367d ? BottomSheetBehavior.this.f2370g : BottomSheetBehavior.this.f2366c);
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int clampViewPositionHorizontal(View view, int i, int i2) {
                return view.getLeft();
            }

            @Override // android.support.v4.widget.ViewDragHelper.Callback
            public int getViewVerticalDragRange(View view) {
                if (BottomSheetBehavior.this.f2367d) {
                    return BottomSheetBehavior.this.f2370g;
                }
                return BottomSheetBehavior.this.f2366c;
            }
        };
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        TypedValue typedValuePeekValue = typedArrayObtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (typedValuePeekValue != null && typedValuePeekValue.data == -1) {
            m2639a(typedValuePeekValue.data);
        } else {
            m2639a(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        }
        m2646b(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        m2642a(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        m2648c(typedArrayObtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        typedArrayObtainStyledAttributes.recycle();
        this.f2376m = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public Parcelable mo2568b(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.mo2568b(coordinatorLayout, v), this.f2368e);
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo2556a(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.mo2556a(coordinatorLayout, v, savedState.getSuperState());
        if (savedState.f2394a == 1 || savedState.f2394a == 2) {
            this.f2368e = 4;
        } else {
            this.f2368e = savedState.f2394a;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2208a(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (ViewCompat.getFitsSystemWindows(coordinatorLayout) && !ViewCompat.getFitsSystemWindows(v)) {
            v.setFitsSystemWindows(true);
        }
        int top = v.getTop();
        coordinatorLayout.m2697a(v, i);
        this.f2370g = coordinatorLayout.getHeight();
        if (this.f2378o) {
            if (this.f2379p == 0) {
                this.f2379p = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            }
            this.f2380q = Math.max(this.f2379p, this.f2370g - ((coordinatorLayout.getWidth() * 9) / 16));
        } else {
            this.f2380q = this.f2377n;
        }
        this.f2364a = Math.max(0, this.f2370g - v.getHeight());
        this.f2365b = this.f2370g / 2;
        m2632b();
        if (this.f2368e == 3) {
            ViewCompat.offsetTopAndBottom(v, m2636f());
        } else if (this.f2368e == 6) {
            ViewCompat.offsetTopAndBottom(v, this.f2365b);
        } else if (this.f2367d && this.f2368e == 5) {
            ViewCompat.offsetTopAndBottom(v, this.f2370g);
        } else if (this.f2368e == 4) {
            ViewCompat.offsetTopAndBottom(v, this.f2366c);
        } else if (this.f2368e == 1 || this.f2368e == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        if (this.f2369f == null) {
            this.f2369f = ViewDragHelper.create(coordinatorLayout, this.f2389z);
        }
        this.f2371h = new WeakReference<>(v);
        this.f2372i = new WeakReference<>(m2638a(v));
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006e  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo2610b(android.support.design.widget.CoordinatorLayout r9, V r10, android.view.MotionEvent r11) {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.mo2610b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2513a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.f2368e == 1 && actionMasked == 0) {
            return true;
        }
        if (this.f2369f != null) {
            this.f2369f.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            m2633d();
        }
        if (this.f2386w == null) {
            this.f2386w = VelocityTracker.obtain();
        }
        this.f2386w.addMovement(motionEvent);
        if (actionMasked == 2 && !this.f2382s && Math.abs(this.f2387x - motionEvent.getY()) > this.f2369f.getTouchSlop()) {
            this.f2369f.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.f2382s;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2248a(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.f2383t = 0;
        this.f2384u = false;
        return (i & 2) != 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo2559a(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 != 1 && view == this.f2372i.get()) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (i4 < m2636f()) {
                    iArr[1] = top - m2636f();
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    m2647c(3);
                } else {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    m2647c(1);
                }
            } else if (i2 < 0 && !view.canScrollVertically(-1)) {
                if (i4 <= this.f2366c || this.f2367d) {
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    m2647c(1);
                } else {
                    iArr[1] = top - this.f2366c;
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    m2647c(4);
                }
            }
            m2649d(v.getTop());
            this.f2383t = i2;
            this.f2384u = true;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo2557a(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int iM2636f;
        int i2 = 3;
        if (v.getTop() == m2636f()) {
            m2647c(3);
            return;
        }
        if (view == this.f2372i.get() && this.f2384u) {
            if (this.f2383t > 0) {
                iM2636f = m2636f();
            } else if (this.f2367d && m2644a(v, m2635e())) {
                iM2636f = this.f2370g;
                i2 = 5;
            } else {
                if (this.f2383t == 0) {
                    int top = v.getTop();
                    if (this.f2375l) {
                        if (Math.abs(top - this.f2364a) < Math.abs(top - this.f2366c)) {
                            iM2636f = this.f2364a;
                        } else {
                            iM2636f = this.f2366c;
                        }
                    } else {
                        if (top < this.f2365b) {
                            if (top < Math.abs(top - this.f2366c)) {
                                iM2636f = 0;
                            } else {
                                iM2636f = this.f2365b;
                            }
                        } else if (Math.abs(top - this.f2365b) < Math.abs(top - this.f2366c)) {
                            iM2636f = this.f2365b;
                        } else {
                            iM2636f = this.f2366c;
                        }
                        i2 = 6;
                    }
                } else {
                    iM2636f = this.f2366c;
                }
                i2 = 4;
            }
            if (this.f2369f.smoothSlideViewTo(v, v.getLeft(), iM2636f)) {
                m2647c(2);
                ViewCompat.postOnAnimation(v, new RunnableC0280b(v, i2));
            } else {
                m2647c(i2);
            }
            this.f2384u = false;
        }
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2643a(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        return view == this.f2372i.get() && (this.f2368e != 3 || super.mo2643a(coordinatorLayout, v, view, f, f2));
    }

    /* JADX INFO: renamed from: a */
    public void m2642a(boolean z) {
        if (this.f2375l == z) {
            return;
        }
        this.f2375l = z;
        if (this.f2371h != null) {
            m2632b();
        }
        m2647c((this.f2375l && this.f2368e == 6) ? 3 : this.f2368e);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0015  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2639a(int r4) {
        /*
            r3 = this;
            r0 = 1
            r1 = 0
            r2 = -1
            if (r4 != r2) goto Lc
            boolean r4 = r3.f2378o
            if (r4 != 0) goto L15
            r3.f2378o = r0
            goto L24
        Lc:
            boolean r2 = r3.f2378o
            if (r2 != 0) goto L17
            int r2 = r3.f2377n
            if (r2 == r4) goto L15
            goto L17
        L15:
            r0 = 0
            goto L24
        L17:
            r3.f2378o = r1
            int r1 = java.lang.Math.max(r1, r4)
            r3.f2377n = r1
            int r1 = r3.f2370g
            int r1 = r1 - r4
            r3.f2366c = r1
        L24:
            if (r0 == 0) goto L3c
            int r4 = r3.f2368e
            r0 = 4
            if (r4 != r0) goto L3c
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f2371h
            if (r4 == 0) goto L3c
            java.lang.ref.WeakReference<V extends android.view.View> r4 = r3.f2371h
            java.lang.Object r4 = r4.get()
            android.view.View r4 = (android.view.View) r4
            if (r4 == 0) goto L3c
            r4.requestLayout()
        L3c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.BottomSheetBehavior.m2639a(int):void");
    }

    /* JADX INFO: renamed from: b */
    public void m2646b(boolean z) {
        this.f2367d = z;
    }

    /* JADX INFO: renamed from: c */
    public void m2648c(boolean z) {
        this.f2381r = z;
    }

    /* JADX INFO: renamed from: a */
    public void m2640a(AbstractC0279a abstractC0279a) {
        this.f2385v = abstractC0279a;
    }

    /* JADX INFO: renamed from: b */
    public final void m2645b(final int i) {
        if (i == this.f2368e) {
            return;
        }
        if (this.f2371h == null) {
            if (i == 4 || i == 3 || i == 6 || (this.f2367d && i == 5)) {
                this.f2368e = i;
                return;
            }
            return;
        }
        final V v = this.f2371h.get();
        if (v == null) {
            return;
        }
        ViewParent parent = v.getParent();
        if (parent != null && parent.isLayoutRequested() && ViewCompat.isAttachedToWindow(v)) {
            v.post(new Runnable() { // from class: android.support.design.widget.BottomSheetBehavior.1
                @Override // java.lang.Runnable
                public void run() {
                    BottomSheetBehavior.this.m2641a(v, i);
                }
            });
        } else {
            m2641a((View) v, i);
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m2637a() {
        return this.f2368e;
    }

    /* JADX INFO: renamed from: c */
    void m2647c(int i) {
        if (this.f2368e == i) {
            return;
        }
        this.f2368e = i;
        if (i == 6 || i == 3) {
            m2634d(true);
        } else if (i == 5 || i == 4) {
            m2634d(false);
        }
        V v = this.f2371h.get();
        if (v == null || this.f2385v == null) {
            return;
        }
        this.f2385v.mo2654a((View) v, i);
    }

    /* JADX INFO: renamed from: b */
    private void m2632b() {
        if (this.f2375l) {
            this.f2366c = Math.max(this.f2370g - this.f2380q, this.f2364a);
        } else {
            this.f2366c = this.f2370g - this.f2380q;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2633d() {
        this.f2373j = -1;
        if (this.f2386w != null) {
            this.f2386w.recycle();
            this.f2386w = null;
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m2644a(View view, float f) {
        if (this.f2381r) {
            return true;
        }
        return view.getTop() >= this.f2366c && Math.abs((((float) view.getTop()) + (f * 0.1f)) - ((float) this.f2366c)) / ((float) this.f2377n) > 0.5f;
    }

    /* JADX INFO: renamed from: a */
    View m2638a(View view) {
        if (ViewCompat.isNestedScrollingEnabled(view)) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View viewM2638a = m2638a(viewGroup.getChildAt(i));
            if (viewM2638a != null) {
                return viewM2638a;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: e */
    private float m2635e() {
        if (this.f2386w == null) {
            return 0.0f;
        }
        this.f2386w.computeCurrentVelocity(1000, this.f2376m);
        return this.f2386w.getYVelocity(this.f2373j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public int m2636f() {
        if (this.f2375l) {
            return this.f2364a;
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    void m2641a(View view, int i) {
        int iM2636f;
        if (i == 4) {
            iM2636f = this.f2366c;
        } else if (i == 6) {
            int i2 = this.f2365b;
            if (!this.f2375l || i2 > this.f2364a) {
                iM2636f = i2;
            } else {
                iM2636f = this.f2364a;
                i = 3;
            }
        } else if (i == 3) {
            iM2636f = m2636f();
        } else if (this.f2367d && i == 5) {
            iM2636f = this.f2370g;
        } else {
            throw new IllegalArgumentException("Illegal state argument: " + i);
        }
        if (this.f2369f.smoothSlideViewTo(view, view.getLeft(), iM2636f)) {
            m2647c(2);
            ViewCompat.postOnAnimation(view, new RunnableC0280b(view, i));
        } else {
            m2647c(i);
        }
    }

    /* JADX INFO: renamed from: d */
    void m2649d(int i) {
        V v = this.f2371h.get();
        if (v == null || this.f2385v == null) {
            return;
        }
        if (i > this.f2366c) {
            this.f2385v.mo2653a(v, (this.f2366c - i) / (this.f2370g - this.f2366c));
        } else {
            this.f2385v.mo2653a(v, (this.f2366c - i) / (this.f2366c - m2636f()));
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.BottomSheetBehavior$b */
    class RunnableC0280b implements Runnable {

        /* JADX INFO: renamed from: b */
        private final View f2396b;

        /* JADX INFO: renamed from: c */
        private final int f2397c;

        RunnableC0280b(View view, int i) {
            this.f2396b = view;
            this.f2397c = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (BottomSheetBehavior.this.f2369f != null && BottomSheetBehavior.this.f2369f.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f2396b, this);
            } else {
                BottomSheetBehavior.this.m2647c(this.f2397c);
            }
        }
    }

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.BottomSheetBehavior.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        final int f2394a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2394a = parcel.readInt();
        }

        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.f2394a = i;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2394a);
        }
    }

    /* JADX INFO: renamed from: b */
    public static <V extends View> BottomSheetBehavior<V> m2631b(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.C0290d)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behaviorM2740b = ((CoordinatorLayout.C0290d) layoutParams).m2740b();
        if (!(behaviorM2740b instanceof BottomSheetBehavior)) {
            throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
        }
        return (BottomSheetBehavior) behaviorM2740b;
    }

    /* JADX INFO: renamed from: d */
    private void m2634d(boolean z) {
        if (this.f2371h == null) {
            return;
        }
        ViewParent parent = this.f2371h.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                if (this.f2388y != null) {
                    return;
                } else {
                    this.f2388y = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.f2371h.get()) {
                    if (!z) {
                        if (this.f2388y != null && this.f2388y.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.f2388y.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f2388y.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f2388y = null;
        }
    }
}
