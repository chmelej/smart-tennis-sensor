package android.support.design.widget;

import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    ViewDragHelper f2525a;

    /* JADX INFO: renamed from: b */
    InterfaceC0301a f2526b;

    /* JADX INFO: renamed from: g */
    private boolean f2531g;

    /* JADX INFO: renamed from: i */
    private boolean f2533i;

    /* JADX INFO: renamed from: h */
    private float f2532h = 0.0f;

    /* JADX INFO: renamed from: c */
    int f2527c = 2;

    /* JADX INFO: renamed from: d */
    float f2528d = 0.5f;

    /* JADX INFO: renamed from: e */
    float f2529e = 0.0f;

    /* JADX INFO: renamed from: f */
    float f2530f = 0.5f;

    /* JADX INFO: renamed from: j */
    private final ViewDragHelper.Callback f2534j = new ViewDragHelper.Callback() { // from class: android.support.design.widget.SwipeDismissBehavior.1

        /* JADX INFO: renamed from: b */
        private int f2536b;

        /* JADX INFO: renamed from: c */
        private int f2537c = -1;

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return this.f2537c == -1 && SwipeDismissBehavior.this.mo2609a(view);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewCaptured(View view, int i) {
            this.f2537c = i;
            this.f2536b = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (SwipeDismissBehavior.this.f2526b != null) {
                SwipeDismissBehavior.this.f2526b.mo2602a(i);
            }
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            boolean z;
            this.f2537c = -1;
            int width = view.getWidth();
            if (m2813a(view, f)) {
                i = view.getLeft() < this.f2536b ? this.f2536b - width : this.f2536b + width;
                z = true;
            } else {
                i = this.f2536b;
                z = false;
            }
            if (SwipeDismissBehavior.this.f2525a.settleCapturedViewAt(i, view.getTop())) {
                ViewCompat.postOnAnimation(view, new RunnableC0302b(view, z));
            } else {
                if (!z || SwipeDismissBehavior.this.f2526b == null) {
                    return;
                }
                SwipeDismissBehavior.this.f2526b.mo2603a(view);
            }
        }

        /* JADX INFO: renamed from: a */
        private boolean m2813a(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.f2536b) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.f2528d);
            }
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.this.f2527c == 2) {
                return true;
            }
            if (SwipeDismissBehavior.this.f2527c == 0) {
                if (z) {
                    if (f >= 0.0f) {
                        return false;
                    }
                } else if (f <= 0.0f) {
                    return false;
                }
                return true;
            }
            if (SwipeDismissBehavior.this.f2527c != 1) {
                return false;
            }
            if (z) {
                if (f <= 0.0f) {
                    return false;
                }
            } else if (f >= 0.0f) {
                return false;
            }
            return true;
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return view.getWidth();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            int width;
            int width2;
            boolean z = ViewCompat.getLayoutDirection(view) == 1;
            if (SwipeDismissBehavior.this.f2527c == 0) {
                if (z) {
                    width = this.f2536b - view.getWidth();
                    width2 = this.f2536b;
                } else {
                    width = this.f2536b;
                    width2 = view.getWidth() + this.f2536b;
                }
            } else if (SwipeDismissBehavior.this.f2527c != 1) {
                width = this.f2536b - view.getWidth();
                width2 = view.getWidth() + this.f2536b;
            } else if (z) {
                width = this.f2536b;
                width2 = view.getWidth() + this.f2536b;
            } else {
                width = this.f2536b - view.getWidth();
                width2 = this.f2536b;
            }
            return SwipeDismissBehavior.m2806a(width, i, width2);
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // android.support.v4.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            float width = this.f2536b + (view.getWidth() * SwipeDismissBehavior.this.f2529e);
            float width2 = this.f2536b + (view.getWidth() * SwipeDismissBehavior.this.f2530f);
            float f = i;
            if (f <= width) {
                view.setAlpha(1.0f);
            } else if (f >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.m2805a(0.0f, 1.0f - SwipeDismissBehavior.m2808b(width, width2, f), 1.0f));
            }
        }
    };

    /* JADX INFO: renamed from: android.support.design.widget.SwipeDismissBehavior$a */
    public interface InterfaceC0301a {
        /* JADX INFO: renamed from: a */
        void mo2602a(int i);

        /* JADX INFO: renamed from: a */
        void mo2603a(View view);
    }

    /* JADX INFO: renamed from: b */
    static float m2808b(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo2609a(View view) {
        return true;
    }

    /* JADX INFO: renamed from: a */
    public void m2811a(InterfaceC0301a interfaceC0301a) {
        this.f2526b = interfaceC0301a;
    }

    /* JADX INFO: renamed from: a */
    public void m2810a(int i) {
        this.f2527c = i;
    }

    /* JADX INFO: renamed from: a */
    public void m2809a(float f) {
        this.f2529e = m2805a(0.0f, f, 1.0f);
    }

    /* JADX INFO: renamed from: b */
    public void m2812b(float f) {
        this.f2530f = m2805a(0.0f, f, 1.0f);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0021  */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean mo2610b(android.support.design.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            boolean r0 = r4.f2531g
            int r1 = r7.getActionMasked()
            r2 = 3
            r3 = 0
            if (r1 == r2) goto L21
            switch(r1) {
                case 0: goto Le;
                case 1: goto L21;
                default: goto Ld;
            }
        Ld:
            goto L23
        Le:
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r6 = r5.m2702a(r6, r0, r1)
            r4.f2531g = r6
            boolean r0 = r4.f2531g
            goto L23
        L21:
            r4.f2531g = r3
        L23:
            if (r0 == 0) goto L2f
            r4.m2807a(r5)
            android.support.v4.widget.ViewDragHelper r5 = r4.f2525a
            boolean r5 = r5.shouldInterceptTouchEvent(r7)
            return r5
        L2f:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.SwipeDismissBehavior.mo2610b(android.support.design.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2513a(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.f2525a == null) {
            return false;
        }
        this.f2525a.processTouchEvent(motionEvent);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m2807a(ViewGroup viewGroup) {
        ViewDragHelper viewDragHelperCreate;
        if (this.f2525a == null) {
            if (this.f2533i) {
                viewDragHelperCreate = ViewDragHelper.create(viewGroup, this.f2532h, this.f2534j);
            } else {
                viewDragHelperCreate = ViewDragHelper.create(viewGroup, this.f2534j);
            }
            this.f2525a = viewDragHelperCreate;
        }
    }

    /* JADX INFO: renamed from: android.support.design.widget.SwipeDismissBehavior$b */
    class RunnableC0302b implements Runnable {

        /* JADX INFO: renamed from: b */
        private final View f2539b;

        /* JADX INFO: renamed from: c */
        private final boolean f2540c;

        RunnableC0302b(View view, boolean z) {
            this.f2539b = view;
            this.f2540c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (SwipeDismissBehavior.this.f2525a != null && SwipeDismissBehavior.this.f2525a.continueSettling(true)) {
                ViewCompat.postOnAnimation(this.f2539b, this);
            } else {
                if (!this.f2540c || SwipeDismissBehavior.this.f2526b == null) {
                    return;
                }
                SwipeDismissBehavior.this.f2526b.mo2603a(this.f2539b);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static float m2805a(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* JADX INFO: renamed from: a */
    static int m2806a(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }
}
