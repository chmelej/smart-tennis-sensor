package p000;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.support.transition.R;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;

/* JADX INFO: renamed from: ci */
/* JADX INFO: compiled from: GhostViewApi14.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"ViewConstructor"})
class C0794ci extends View implements InterfaceC0796ck {

    /* JADX INFO: renamed from: a */
    final View f5329a;

    /* JADX INFO: renamed from: b */
    ViewGroup f5330b;

    /* JADX INFO: renamed from: c */
    View f5331c;

    /* JADX INFO: renamed from: d */
    int f5332d;

    /* JADX INFO: renamed from: e */
    Matrix f5333e;

    /* JADX INFO: renamed from: f */
    private int f5334f;

    /* JADX INFO: renamed from: g */
    private int f5335g;

    /* JADX INFO: renamed from: h */
    private final Matrix f5336h;

    /* JADX INFO: renamed from: i */
    private final ViewTreeObserver.OnPreDrawListener f5337i;

    /* JADX INFO: renamed from: a */
    static InterfaceC0796ck m5786a(View view, ViewGroup viewGroup) {
        C0794ci c0794ciM5789b = m5789b(view);
        if (c0794ciM5789b == null) {
            FrameLayout frameLayoutM5785a = m5785a(viewGroup);
            if (frameLayoutM5785a == null) {
                return null;
            }
            c0794ciM5789b = new C0794ci(view);
            frameLayoutM5785a.addView(c0794ciM5789b);
        }
        c0794ciM5789b.f5332d++;
        return c0794ciM5789b;
    }

    /* JADX INFO: renamed from: a */
    static void m5787a(View view) {
        C0794ci c0794ciM5789b = m5789b(view);
        if (c0794ciM5789b != null) {
            c0794ciM5789b.f5332d--;
            if (c0794ciM5789b.f5332d <= 0) {
                ViewParent parent = c0794ciM5789b.getParent();
                if (parent instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) parent;
                    viewGroup.endViewTransition(c0794ciM5789b);
                    viewGroup.removeView(c0794ciM5789b);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static FrameLayout m5785a(ViewGroup viewGroup) {
        while (!(viewGroup instanceof FrameLayout)) {
            ViewParent parent = viewGroup.getParent();
            if (!(parent instanceof ViewGroup)) {
                return null;
            }
            viewGroup = (ViewGroup) parent;
        }
        return (FrameLayout) viewGroup;
    }

    C0794ci(View view) {
        super(view.getContext());
        this.f5336h = new Matrix();
        this.f5337i = new ViewTreeObserver.OnPreDrawListener() { // from class: ci.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                C0794ci.this.f5333e = C0794ci.this.f5329a.getMatrix();
                ViewCompat.postInvalidateOnAnimation(C0794ci.this);
                if (C0794ci.this.f5330b == null || C0794ci.this.f5331c == null) {
                    return true;
                }
                C0794ci.this.f5330b.endViewTransition(C0794ci.this.f5331c);
                ViewCompat.postInvalidateOnAnimation(C0794ci.this.f5330b);
                C0794ci.this.f5330b = null;
                C0794ci.this.f5331c = null;
                return true;
            }
        };
        this.f5329a = view;
        setLayerType(2, null);
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m5788a(this.f5329a, this);
        int[] iArr = new int[2];
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr);
        this.f5329a.getLocationOnScreen(iArr2);
        iArr2[0] = (int) (iArr2[0] - this.f5329a.getTranslationX());
        iArr2[1] = (int) (iArr2[1] - this.f5329a.getTranslationY());
        this.f5334f = iArr2[0] - iArr[0];
        this.f5335g = iArr2[1] - iArr[1];
        this.f5329a.getViewTreeObserver().addOnPreDrawListener(this.f5337i);
        this.f5329a.setVisibility(4);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        this.f5329a.getViewTreeObserver().removeOnPreDrawListener(this.f5337i);
        this.f5329a.setVisibility(0);
        m5788a(this.f5329a, (C0794ci) null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f5336h.set(this.f5333e);
        this.f5336h.postTranslate(this.f5334f, this.f5335g);
        canvas.setMatrix(this.f5336h);
        this.f5329a.draw(canvas);
    }

    @Override // android.view.View, p000.InterfaceC0796ck
    public void setVisibility(int i) {
        super.setVisibility(i);
        this.f5329a.setVisibility(i == 0 ? 4 : 0);
    }

    @Override // p000.InterfaceC0796ck
    /* JADX INFO: renamed from: a */
    public void mo5790a(ViewGroup viewGroup, View view) {
        this.f5330b = viewGroup;
        this.f5331c = view;
    }

    /* JADX INFO: renamed from: a */
    private static void m5788a(View view, C0794ci c0794ci) {
        view.setTag(R.id.ghost_view, c0794ci);
    }

    /* JADX INFO: renamed from: b */
    static C0794ci m5789b(View view) {
        return (C0794ci) view.getTag(R.id.ghost_view);
    }
}
