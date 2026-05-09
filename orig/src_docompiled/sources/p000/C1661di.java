package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ViewCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* JADX INFO: renamed from: di */
/* JADX INFO: compiled from: ViewOverlayApi14.java */
/* JADX INFO: loaded from: classes.dex */
class C1661di implements InterfaceC1663dk {

    /* JADX INFO: renamed from: a */
    protected a f9394a;

    C1661di(Context context, ViewGroup viewGroup, View view) {
        this.f9394a = new a(context, viewGroup, view, this);
    }

    /* JADX INFO: renamed from: c */
    static ViewGroup m8852c(View view) {
        while (view != null) {
            if (view.getId() == 16908290 && (view instanceof ViewGroup)) {
                return (ViewGroup) view;
            }
            if (view.getParent() instanceof ViewGroup) {
                view = (ViewGroup) view.getParent();
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    static C1661di m8853d(View view) {
        ViewGroup viewGroupM8852c = m8852c(view);
        if (viewGroupM8852c == null) {
            return null;
        }
        int childCount = viewGroupM8852c.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroupM8852c.getChildAt(i);
            if (childAt instanceof a) {
                return ((a) childAt).f9399e;
            }
        }
        return new C1655dc(viewGroupM8852c.getContext(), viewGroupM8852c, view);
    }

    @Override // p000.InterfaceC1663dk
    /* JADX INFO: renamed from: a */
    public void mo8839a(Drawable drawable) {
        this.f9394a.m8855a(drawable);
    }

    @Override // p000.InterfaceC1663dk
    /* JADX INFO: renamed from: b */
    public void mo8840b(Drawable drawable) {
        this.f9394a.m8858b(drawable);
    }

    /* JADX INFO: renamed from: di$a */
    /* JADX INFO: compiled from: ViewOverlayApi14.java */
    static class a extends ViewGroup {

        /* JADX INFO: renamed from: a */
        static Method f9395a;

        /* JADX INFO: renamed from: b */
        ViewGroup f9396b;

        /* JADX INFO: renamed from: c */
        View f9397c;

        /* JADX INFO: renamed from: d */
        ArrayList<Drawable> f9398d;

        /* JADX INFO: renamed from: e */
        C1661di f9399e;

        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        static {
            try {
                f9395a = ViewGroup.class.getDeclaredMethod("invalidateChildInParentFast", Integer.TYPE, Integer.TYPE, Rect.class);
            } catch (NoSuchMethodException unused) {
            }
        }

        a(Context context, ViewGroup viewGroup, View view, C1661di c1661di) {
            super(context);
            this.f9398d = null;
            this.f9396b = viewGroup;
            this.f9397c = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.f9399e = c1661di;
        }

        /* JADX INFO: renamed from: a */
        public void m8855a(Drawable drawable) {
            if (this.f9398d == null) {
                this.f9398d = new ArrayList<>();
            }
            if (this.f9398d.contains(drawable)) {
                return;
            }
            this.f9398d.add(drawable);
            invalidate(drawable.getBounds());
            drawable.setCallback(this);
        }

        /* JADX INFO: renamed from: b */
        public void m8858b(Drawable drawable) {
            if (this.f9398d != null) {
                this.f9398d.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(null);
            }
        }

        @Override // android.view.View
        protected boolean verifyDrawable(Drawable drawable) {
            return super.verifyDrawable(drawable) || (this.f9398d != null && this.f9398d.contains(drawable));
        }

        /* JADX INFO: renamed from: a */
        public void m8856a(View view) {
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (viewGroup != this.f9396b && viewGroup.getParent() != null && ViewCompat.isAttachedToWindow(viewGroup)) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.f9396b.getLocationOnScreen(iArr2);
                    ViewCompat.offsetLeftAndRight(view, iArr[0] - iArr2[0]);
                    ViewCompat.offsetTopAndBottom(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view, getChildCount() - 1);
        }

        /* JADX INFO: renamed from: b */
        public void m8859b(View view) {
            super.removeView(view);
            if (m8857a()) {
                this.f9396b.removeView(this);
            }
        }

        /* JADX INFO: renamed from: a */
        boolean m8857a() {
            return getChildCount() == 0 && (this.f9398d == null || this.f9398d.size() == 0);
        }

        @Override // android.view.View, android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            this.f9396b.getLocationOnScreen(new int[2]);
            this.f9397c.getLocationOnScreen(new int[2]);
            canvas.translate(r0[0] - r1[0], r0[1] - r1[1]);
            canvas.clipRect(new Rect(0, 0, this.f9397c.getWidth(), this.f9397c.getHeight()));
            super.dispatchDraw(canvas);
            int size = this.f9398d == null ? 0 : this.f9398d.size();
            for (int i = 0; i < size; i++) {
                this.f9398d.get(i).draw(canvas);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m8854a(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.f9396b.getLocationOnScreen(iArr2);
            this.f9397c.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        @Override // android.view.ViewGroup, android.view.ViewParent
        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.f9396b == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.f9396b instanceof ViewGroup) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                m8854a(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }
    }
}
