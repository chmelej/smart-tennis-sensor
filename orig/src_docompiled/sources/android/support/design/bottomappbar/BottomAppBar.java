package android.support.design.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.behavior.HideBottomViewOnScrollBehavior;
import android.support.design.shape.MaterialShapeDrawable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.Toolbar;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import p000.C0079af;
import p000.C0751at;
import p000.C0753av;
import p000.C0761bc;
import p000.C2178v;

/* JADX INFO: loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.InterfaceC0287a {

    /* JADX INFO: renamed from: a */
    AnimatorListenerAdapter f2041a;

    /* JADX INFO: renamed from: f */
    private final int f2042f;

    /* JADX INFO: renamed from: g */
    private final MaterialShapeDrawable f2043g;

    /* JADX INFO: renamed from: h */
    private final C0079af f2044h;

    /* JADX INFO: renamed from: i */
    private Animator f2045i;

    /* JADX INFO: renamed from: j */
    private Animator f2046j;

    /* JADX INFO: renamed from: k */
    private Animator f2047k;

    /* JADX INFO: renamed from: l */
    private int f2048l;

    /* JADX INFO: renamed from: m */
    private boolean f2049m;

    /* JADX INFO: renamed from: n */
    private boolean f2050n;

    @Override // android.support.v7.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // android.support.v7.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(Context context) {
        this(context, null, 0);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2050n = true;
        this.f2041a = new AnimatorListenerAdapter() { // from class: android.support.design.bottomappbar.BottomAppBar.7
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                BottomAppBar.this.m2223a(BottomAppBar.this.f2050n);
                BottomAppBar.this.m2215a(BottomAppBar.this.f2048l, BottomAppBar.this.f2050n);
            }
        };
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.BottomAppBar, i, R.style.Widget_MaterialComponents_BottomAppBar, new int[0]);
        ColorStateList colorStateListM5478a = C0753av.m5478a(context, typedArrayM5390a, R.styleable.BottomAppBar_backgroundTint);
        float dimensionPixelOffset = typedArrayM5390a.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = typedArrayM5390a.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = typedArrayM5390a.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.f2048l = typedArrayM5390a.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.f2049m = typedArrayM5390a.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        typedArrayM5390a.recycle();
        this.f2042f = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.f2044h = new C0079af(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        C0761bc c0761bc = new C0761bc();
        c0761bc.m5503a(this.f2044h);
        this.f2043g = new MaterialShapeDrawable(c0761bc);
        this.f2043g.m2479a(true);
        this.f2043g.m2478a(Paint.Style.FILL);
        DrawableCompat.setTintList(this.f2043g, colorStateListM5478a);
        ViewCompat.setBackground(this, this.f2043g);
    }

    public int getFabAlignmentMode() {
        return this.f2048l;
    }

    public void setFabAlignmentMode(int i) {
        m2213a(i);
        m2215a(i, this.f2050n);
        this.f2048l = i;
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.f2043g, colorStateList);
    }

    public ColorStateList getBackgroundTint() {
        return this.f2043g.m2475a();
    }

    public float getFabCradleMargin() {
        return this.f2044h.m794d();
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            this.f2044h.m795d(f);
            this.f2043g.invalidateSelf();
        }
    }

    public float getFabCradleRoundedCornerRadius() {
        return this.f2044h.m796e();
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            this.f2044h.m797e(f);
            this.f2043g.invalidateSelf();
        }
    }

    public float getCradleVerticalOffset() {
        return this.f2044h.m790b();
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            this.f2044h.m791b(f);
            this.f2043g.invalidateSelf();
        }
    }

    public boolean getHideOnScroll() {
        return this.f2049m;
    }

    public void setHideOnScroll(boolean z) {
        this.f2049m = z;
    }

    void setFabDiameter(int i) {
        float f = i;
        if (f != this.f2044h.m792c()) {
            this.f2044h.m793c(f);
            this.f2043g.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2213a(int i) {
        if (this.f2048l == i || !ViewCompat.isLaidOut(this)) {
            return;
        }
        if (this.f2046j != null) {
            this.f2046j.cancel();
        }
        ArrayList arrayList = new ArrayList();
        m2214a(i, arrayList);
        m2229b(i, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f2046j = animatorSet;
        this.f2046j.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.bottomappbar.BottomAppBar.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                BottomAppBar.this.f2046j = null;
            }
        });
        this.f2046j.start();
    }

    /* JADX INFO: renamed from: a */
    private void m2214a(int i, List<Animator> list) {
        if (this.f2050n) {
            ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.f2044h.m787a(), m2226b(i));
            valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.bottomappbar.BottomAppBar.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BottomAppBar.this.f2044h.m788a(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    BottomAppBar.this.f2043g.invalidateSelf();
                }
            });
            valueAnimatorOfFloat.setDuration(300L);
            list.add(valueAnimatorOfFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public FloatingActionButton m2239m() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).m2708d(this)) {
            if (view instanceof FloatingActionButton) {
                return (FloatingActionButton) view;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: n */
    private boolean m2240n() {
        FloatingActionButton floatingActionButtonM2239m = m2239m();
        return floatingActionButtonM2239m != null && floatingActionButtonM2239m.m2765b();
    }

    /* JADX INFO: renamed from: b */
    private void m2229b(int i, List<Animator> list) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(m2239m(), "translationX", m2226b(i));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2215a(int i, boolean z) {
        if (ViewCompat.isLaidOut(this)) {
            if (this.f2047k != null) {
                this.f2047k.cancel();
            }
            ArrayList arrayList = new ArrayList();
            if (!m2240n()) {
                i = 0;
                z = false;
            }
            m2216a(i, z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f2047k = animatorSet;
            this.f2047k.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.bottomappbar.BottomAppBar.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.f2047k = null;
                }
            });
            this.f2047k.start();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2216a(final int i, final boolean z, List<Animator> list) {
        final ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator animatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if ((!this.f2050n && (!z || !m2240n())) || (this.f2048l != 1 && i != 1)) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(animatorOfFloat);
            }
        } else {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            objectAnimatorOfFloat.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.bottomappbar.BottomAppBar.4

                /* JADX INFO: renamed from: a */
                public boolean f2054a;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f2054a = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    if (this.f2054a) {
                        return;
                    }
                    BottomAppBar.this.m2222a(actionMenuView, i, z);
                }
            });
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(objectAnimatorOfFloat, animatorOfFloat);
            list.add(animatorSet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2223a(boolean z) {
        if (ViewCompat.isLaidOut(this)) {
            if (this.f2045i != null) {
                this.f2045i.cancel();
            }
            ArrayList arrayList = new ArrayList();
            m2224a(z && m2240n(), arrayList);
            m2231b(z, arrayList);
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(arrayList);
            this.f2045i = animatorSet;
            this.f2045i.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.bottomappbar.BottomAppBar.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    BottomAppBar.this.f2045i = null;
                }
            });
            this.f2045i.start();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2224a(boolean z, List<Animator> list) {
        if (z) {
            this.f2044h.m788a(getFabTranslationX());
        }
        float[] fArr = new float[2];
        fArr[0] = this.f2043g.m2480b();
        fArr[1] = z ? 1.0f : 0.0f;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(fArr);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.bottomappbar.BottomAppBar.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                BottomAppBar.this.f2043g.m2476a(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        valueAnimatorOfFloat.setDuration(300L);
        list.add(valueAnimatorOfFloat);
    }

    /* JADX INFO: renamed from: b */
    private void m2231b(boolean z, List<Animator> list) {
        FloatingActionButton floatingActionButtonM2239m = m2239m();
        if (floatingActionButtonM2239m == null) {
            return;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(floatingActionButtonM2239m, "translationY", m2225b(z));
        objectAnimatorOfFloat.setDuration(300L);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX INFO: renamed from: b */
    private float m2225b(boolean z) {
        FloatingActionButton floatingActionButtonM2239m = m2239m();
        if (floatingActionButtonM2239m == null) {
            return 0.0f;
        }
        Rect rect = new Rect();
        floatingActionButtonM2239m.m2761a(rect);
        float fHeight = rect.height();
        if (fHeight == 0.0f) {
            fHeight = floatingActionButtonM2239m.getMeasuredHeight();
        }
        float height = floatingActionButtonM2239m.getHeight() - rect.bottom;
        float height2 = floatingActionButtonM2239m.getHeight() - rect.height();
        float f = (-getCradleVerticalOffset()) + (fHeight / 2.0f) + height;
        float paddingBottom = height2 - floatingActionButtonM2239m.getPaddingBottom();
        float f2 = -getMeasuredHeight();
        if (z) {
            paddingBottom = f;
        }
        return f2 + paddingBottom;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationY() {
        return m2225b(this.f2050n);
    }

    /* JADX INFO: renamed from: b */
    private int m2226b(int i) {
        boolean z = ViewCompat.getLayoutDirection(this) == 1;
        if (i == 1) {
            return ((getMeasuredWidth() / 2) - this.f2042f) * (z ? -1 : 1);
        }
        return 0;
    }

    private float getFabTranslationX() {
        return m2226b(this.f2048l);
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2222a(ActionMenuView actionMenuView, int i, boolean z) {
        boolean z2 = ViewCompat.getLayoutDirection(this) == 1;
        int iMax = 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).f2966a & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                iMax = Math.max(iMax, z2 ? childAt.getLeft() : childAt.getRight());
            }
        }
        actionMenuView.setTranslationX((i == 1 && z) ? iMax - (z2 ? actionMenuView.getRight() : actionMenuView.getLeft()) : 0.0f);
    }

    /* JADX INFO: renamed from: o */
    private void m2241o() {
        if (this.f2045i != null) {
            this.f2045i.cancel();
        }
        if (this.f2047k != null) {
            this.f2047k.cancel();
        }
        if (this.f2046j != null) {
            this.f2046j.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p */
    public boolean m2242p() {
        return (this.f2045i != null && this.f2045i.isRunning()) || (this.f2047k != null && this.f2047k.isRunning()) || (this.f2046j != null && this.f2046j.isRunning());
    }

    @Override // android.support.v7.widget.Toolbar, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m2241o();
        m2243q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m2243q() {
        this.f2044h.m788a(getFabTranslationX());
        FloatingActionButton floatingActionButtonM2239m = m2239m();
        this.f2043g.m2476a((this.f2050n && m2240n()) ? 1.0f : 0.0f);
        if (floatingActionButtonM2239m != null) {
            floatingActionButtonM2239m.setTranslationY(getFabTranslationY());
            floatingActionButtonM2239m.setTranslationX(getFabTranslationX());
        }
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView != null) {
            actionMenuView.setAlpha(1.0f);
            if (!m2240n()) {
                m2222a(actionMenuView, 0, false);
            } else {
                m2222a(actionMenuView, this.f2048l, this.f2050n);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m2221a(FloatingActionButton floatingActionButton) {
        m2230b(floatingActionButton);
        floatingActionButton.m2766c(this.f2041a);
        floatingActionButton.m2758a(this.f2041a);
    }

    /* JADX INFO: renamed from: b */
    private void m2230b(FloatingActionButton floatingActionButton) {
        floatingActionButton.m2767d(this.f2041a);
        floatingActionButton.m2762b(this.f2041a);
    }

    @Override // android.support.design.widget.CoordinatorLayout.InterfaceC0287a
    public CoordinatorLayout.Behavior<BottomAppBar> getBehavior() {
        return new Behavior();
    }

    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {

        /* JADX INFO: renamed from: a */
        private final Rect f2062a;

        public Behavior() {
            this.f2062a = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2062a = new Rect();
        }

        /* JADX INFO: renamed from: a */
        private boolean m2244a(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
            ((CoordinatorLayout.C0290d) floatingActionButton.getLayoutParams()).f2459d = 17;
            bottomAppBar.m2221a(floatingActionButton);
            return true;
        }

        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2208a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            FloatingActionButton floatingActionButtonM2239m = bottomAppBar.m2239m();
            if (floatingActionButtonM2239m != null) {
                m2244a(floatingActionButtonM2239m, bottomAppBar);
                floatingActionButtonM2239m.m2763b(this.f2062a);
                bottomAppBar.setFabDiameter(this.f2062a.height());
            }
            if (!bottomAppBar.m2242p()) {
                bottomAppBar.m2243q();
            }
            coordinatorLayout.m2697a(bottomAppBar, i);
            return super.mo2208a(coordinatorLayout, bottomAppBar, i);
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2248a(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.mo2248a(coordinatorLayout, bottomAppBar, view, view2, i, i2);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void mo2207a(BottomAppBar bottomAppBar) {
            super.mo2207a(bottomAppBar);
            FloatingActionButton floatingActionButtonM2239m = bottomAppBar.m2239m();
            if (floatingActionButtonM2239m != null) {
                floatingActionButtonM2239m.clearAnimation();
                floatingActionButtonM2239m.animate().translationY(bottomAppBar.getFabTranslationY()).setInterpolator(C2178v.f13002d).setDuration(225L);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.design.behavior.HideBottomViewOnScrollBehavior
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void mo2210b(BottomAppBar bottomAppBar) {
            super.mo2210b(bottomAppBar);
            FloatingActionButton floatingActionButtonM2239m = bottomAppBar.m2239m();
            if (floatingActionButtonM2239m != null) {
                floatingActionButtonM2239m.m2761a(this.f2062a);
                float measuredHeight = floatingActionButtonM2239m.getMeasuredHeight() - this.f2062a.height();
                floatingActionButtonM2239m.clearAnimation();
                floatingActionButtonM2239m.animate().translationY((-floatingActionButtonM2239m.getPaddingBottom()) + measuredHeight).setInterpolator(C2178v.f13001c).setDuration(175L);
            }
        }
    }

    @Override // android.support.v7.widget.Toolbar, android.view.View
    protected Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f2063a = this.f2048l;
        savedState.f2064b = this.f2050n;
        return savedState;
    }

    @Override // android.support.v7.widget.Toolbar, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2048l = savedState.f2063a;
        this.f2050n = savedState.f2064b;
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.bottomappbar.BottomAppBar.SavedState.1
            @Override // android.os.Parcelable.ClassLoaderCreator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        int f2063a;

        /* JADX INFO: renamed from: b */
        boolean f2064b;

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2063a = parcel.readInt();
            this.f2064b = parcel.readInt() != 0;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f2063a);
            parcel.writeInt(this.f2064b ? 1 : 0);
        }
    }
}
