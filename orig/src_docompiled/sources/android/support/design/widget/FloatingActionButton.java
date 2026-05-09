package android.support.design.widget;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcelable;
import android.support.design.R;
import android.support.design.stateful.ExtendableSavedState;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TintableImageSourceView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.List;
import p000.C0005ac;
import p000.C0717aq;
import p000.C0751at;
import p000.C0752au;
import p000.C0753av;
import p000.C0768bj;
import p000.C0770bl;
import p000.C0771bm;
import p000.C1726fr;
import p000.C1728ft;
import p000.InterfaceC0679ao;
import p000.InterfaceC0775bq;

/* JADX INFO: loaded from: classes.dex */
@CoordinatorLayout.InterfaceC0288b(m2728a = Behavior.class)
public class FloatingActionButton extends VisibilityAwareImageButton implements TintableBackgroundView, TintableImageSourceView, InterfaceC0679ao {

    /* JADX INFO: renamed from: a */
    boolean f2475a;

    /* JADX INFO: renamed from: b */
    final Rect f2476b;

    /* JADX INFO: renamed from: c */
    private ColorStateList f2477c;

    /* JADX INFO: renamed from: d */
    private PorterDuff.Mode f2478d;

    /* JADX INFO: renamed from: e */
    private ColorStateList f2479e;

    /* JADX INFO: renamed from: f */
    private PorterDuff.Mode f2480f;

    /* JADX INFO: renamed from: g */
    private int f2481g;

    /* JADX INFO: renamed from: h */
    private ColorStateList f2482h;

    /* JADX INFO: renamed from: i */
    private int f2483i;

    /* JADX INFO: renamed from: j */
    private int f2484j;

    /* JADX INFO: renamed from: k */
    private int f2485k;

    /* JADX INFO: renamed from: l */
    private int f2486l;

    /* JADX INFO: renamed from: m */
    private final Rect f2487m;

    /* JADX INFO: renamed from: n */
    private final C1728ft f2488n;

    /* JADX INFO: renamed from: o */
    private final C0717aq f2489o;

    /* JADX INFO: renamed from: p */
    private C0770bl f2490p;

    /* JADX INFO: renamed from: android.support.design.widget.FloatingActionButton$a */
    public static abstract class AbstractC0294a {
        /* JADX INFO: renamed from: a */
        public void m2778a(FloatingActionButton floatingActionButton) {
        }

        /* JADX INFO: renamed from: b */
        public void m2779b(FloatingActionButton floatingActionButton) {
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingActionButtonStyle);
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2476b = new Rect();
        this.f2487m = new Rect();
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.FloatingActionButton, i, R.style.Widget_Design_FloatingActionButton, new int[0]);
        this.f2477c = C0753av.m5478a(context, typedArrayM5390a, R.styleable.FloatingActionButton_backgroundTint);
        this.f2478d = C0752au.m5475a(typedArrayM5390a.getInt(R.styleable.FloatingActionButton_backgroundTintMode, -1), null);
        this.f2482h = C0753av.m5478a(context, typedArrayM5390a, R.styleable.FloatingActionButton_rippleColor);
        this.f2483i = typedArrayM5390a.getInt(R.styleable.FloatingActionButton_fabSize, -1);
        this.f2484j = typedArrayM5390a.getDimensionPixelSize(R.styleable.FloatingActionButton_fabCustomSize, 0);
        this.f2481g = typedArrayM5390a.getDimensionPixelSize(R.styleable.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayM5390a.getDimension(R.styleable.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayM5390a.getDimension(R.styleable.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayM5390a.getDimension(R.styleable.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.f2475a = typedArrayM5390a.getBoolean(R.styleable.FloatingActionButton_useCompatPadding, false);
        this.f2486l = typedArrayM5390a.getDimensionPixelSize(R.styleable.FloatingActionButton_maxImageSize, 0);
        C0005ac c0005acM144a = C0005ac.m144a(context, typedArrayM5390a, R.styleable.FloatingActionButton_showMotionSpec);
        C0005ac c0005acM144a2 = C0005ac.m144a(context, typedArrayM5390a, R.styleable.FloatingActionButton_hideMotionSpec);
        typedArrayM5390a.recycle();
        this.f2488n = new C1728ft(this);
        this.f2488n.m9271a(attributeSet, i);
        this.f2489o = new C0717aq(this);
        getImpl().mo5597a(this.f2477c, this.f2478d, this.f2482h, this.f2481g);
        getImpl().m5591a(dimension);
        getImpl().m5603b(dimension2);
        getImpl().m5610c(dimension3);
        getImpl().m5593a(this.f2486l);
        getImpl().m5594a(c0005acM144a);
        getImpl().m5604b(c0005acM144a2);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.f2485k = (sizeDimension - this.f2486l) / 2;
        getImpl().m5620j();
        int iMin = Math.min(m2751a(sizeDimension, i), m2751a(sizeDimension, i2));
        setMeasuredDimension(this.f2476b.left + iMin + this.f2476b.right, iMin + this.f2476b.top + this.f2476b.bottom);
    }

    @Deprecated
    public int getRippleColor() {
        if (this.f2482h != null) {
            return this.f2482h.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f2482h;
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f2482h != colorStateList) {
            this.f2482h = colorStateList;
            getImpl().mo5606b(this.f2482h);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f2477c;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2477c != colorStateList) {
            this.f2477c = colorStateList;
            getImpl().m5596a(colorStateList);
        }
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f2478d;
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f2478d != mode) {
            this.f2478d = mode;
            getImpl().m5598a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f2479e != colorStateList) {
            this.f2479e = colorStateList;
            m2755c();
        }
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        return this.f2479e;
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f2480f != mode) {
            this.f2480f = mode;
            m2755c();
        }
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        return this.f2480f;
    }

    /* JADX INFO: renamed from: c */
    private void m2755c() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        if (this.f2479e == null) {
            DrawableCompat.clearColorFilter(drawable);
            return;
        }
        int colorForState = this.f2479e.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.f2480f;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(C1726fr.m9233a(colorForState, mode));
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f2488n.m9268a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        getImpl().m5612d();
    }

    /* JADX INFO: renamed from: a */
    void m2759a(AbstractC0294a abstractC0294a, boolean z) {
        getImpl().m5608b(m2753a(abstractC0294a), z);
    }

    /* JADX INFO: renamed from: a */
    public void m2758a(Animator.AnimatorListener animatorListener) {
        getImpl().m5595a(animatorListener);
    }

    /* JADX INFO: renamed from: b */
    public void m2762b(Animator.AnimatorListener animatorListener) {
        getImpl().m5605b(animatorListener);
    }

    /* JADX INFO: renamed from: b */
    void m2764b(AbstractC0294a abstractC0294a, boolean z) {
        getImpl().m5600a(m2753a(abstractC0294a), z);
    }

    /* JADX INFO: renamed from: c */
    public void m2766c(Animator.AnimatorListener animatorListener) {
        getImpl().m5611c(animatorListener);
    }

    /* JADX INFO: renamed from: d */
    public void m2767d(Animator.AnimatorListener animatorListener) {
        getImpl().m5614d(animatorListener);
    }

    @Override // p000.InterfaceC0709ap
    /* JADX INFO: renamed from: a */
    public boolean mo2760a() {
        return this.f2489o.m4977a();
    }

    public void setExpandedComponentIdHint(int i) {
        this.f2489o.m4975a(i);
    }

    public int getExpandedComponentIdHint() {
        return this.f2489o.m4979c();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.f2475a != z) {
            this.f2475a = z;
            getImpl().mo5619i();
        }
    }

    public boolean getUseCompatPadding() {
        return this.f2475a;
    }

    public void setSize(int i) {
        this.f2484j = 0;
        if (i != this.f2483i) {
            this.f2483i = i;
            requestLayout();
        }
    }

    public int getSize() {
        return this.f2483i;
    }

    /* JADX INFO: renamed from: a */
    private C0770bl.d m2753a(final AbstractC0294a abstractC0294a) {
        if (abstractC0294a == null) {
            return null;
        }
        return new C0770bl.d() { // from class: android.support.design.widget.FloatingActionButton.1
            @Override // p000.C0770bl.d
            /* JADX INFO: renamed from: a */
            public void mo2768a() {
                abstractC0294a.m2778a(FloatingActionButton.this);
            }

            @Override // p000.C0770bl.d
            /* JADX INFO: renamed from: b */
            public void mo2769b() {
                abstractC0294a.m2779b(FloatingActionButton.this);
            }
        };
    }

    /* JADX INFO: renamed from: b */
    public boolean m2765b() {
        return getImpl().m5628r();
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        this.f2484j = i;
    }

    public int getCustomSize() {
        return this.f2484j;
    }

    int getSizeDimension() {
        return m2750a(this.f2483i);
    }

    /* JADX INFO: renamed from: a */
    private int m2750a(int i) {
        if (this.f2484j != 0) {
            return this.f2484j;
        }
        Resources resources = getResources();
        if (i != -1) {
            if (i == 1) {
                return resources.getDimensionPixelSize(R.dimen.design_fab_size_mini);
            }
            return resources.getDimensionPixelSize(R.dimen.design_fab_size_normal);
        }
        if (Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470) {
            return m2750a(1);
        }
        return m2750a(0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getImpl().m5621k();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getImpl().m5622l();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().mo5601a(getDrawableState());
    }

    @Override // android.widget.ImageView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().mo5617g();
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(super.onSaveInstanceState());
        extendableSavedState.f2267a.put("expandableWidgetHelper", this.f2489o.m4978b());
        return extendableSavedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.getSuperState());
        this.f2489o.m4976a(extendableSavedState.f2267a.get("expandableWidgetHelper"));
    }

    @Deprecated
    /* JADX INFO: renamed from: a */
    public boolean m2761a(Rect rect) {
        if (!ViewCompat.isLaidOut(this)) {
            return false;
        }
        rect.set(0, 0, getWidth(), getHeight());
        m2756c(rect);
        return true;
    }

    /* JADX INFO: renamed from: b */
    public void m2763b(Rect rect) {
        rect.set(0, 0, getMeasuredWidth(), getMeasuredHeight());
        m2756c(rect);
    }

    /* JADX INFO: renamed from: c */
    private void m2756c(Rect rect) {
        rect.left += this.f2476b.left;
        rect.top += this.f2476b.top;
        rect.right -= this.f2476b.right;
        rect.bottom -= this.f2476b.bottom;
    }

    public Drawable getContentBackground() {
        return getImpl().m5618h();
    }

    /* JADX INFO: renamed from: a */
    private static int m2751a(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == Integer.MIN_VALUE) {
            return Math.min(i, size);
        }
        if (mode == 0) {
            return i;
        }
        if (mode != 1073741824) {
            throw new IllegalArgumentException();
        }
        return size;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && m2761a(this.f2487m) && !this.f2487m.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior, android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ void mo2511a(CoordinatorLayout.C0290d c0290d) {
            super.mo2511a(c0290d);
        }

        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2208a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            return super.mo2208a(coordinatorLayout, floatingActionButton, i);
        }

        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2715a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            return super.mo2715a(coordinatorLayout, floatingActionButton, rect);
        }

        @Override // android.support.design.widget.FloatingActionButton.BaseBehavior
        /* JADX INFO: renamed from: a */
        public /* bridge */ /* synthetic */ boolean mo2489b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            return super.mo2489b(coordinatorLayout, floatingActionButton, view);
        }

        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout.Behavior<T> {

        /* JADX INFO: renamed from: a */
        private Rect f2493a;

        /* JADX INFO: renamed from: b */
        private AbstractC0294a f2494b;

        /* JADX INFO: renamed from: c */
        private boolean f2495c;

        public BaseBehavior() {
            this.f2495c = true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.FloatingActionButton_Behavior_Layout);
            this.f2495c = typedArrayObtainStyledAttributes.getBoolean(R.styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a */
        public void mo2511a(CoordinatorLayout.C0290d c0290d) {
            if (c0290d.f2463h == 0) {
                c0290d.f2463h = 80;
            }
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2489b(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                m2771a(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
                return false;
            }
            if (!m2772a(view)) {
                return false;
            }
            m2774b(view, floatingActionButton);
            return false;
        }

        /* JADX INFO: renamed from: a */
        private static boolean m2772a(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.C0290d) {
                return ((CoordinatorLayout.C0290d) layoutParams).m2740b() instanceof BottomSheetBehavior;
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        private boolean m2773a(View view, FloatingActionButton floatingActionButton) {
            return this.f2495c && ((CoordinatorLayout.C0290d) floatingActionButton.getLayoutParams()).m2732a() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
        }

        /* JADX INFO: renamed from: a */
        private boolean m2771a(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!m2773a(appBarLayout, floatingActionButton)) {
                return false;
            }
            if (this.f2493a == null) {
                this.f2493a = new Rect();
            }
            Rect rect = this.f2493a;
            C0768bj.m5578b(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.m2764b(this.f2494b, false);
                return true;
            }
            floatingActionButton.m2759a(this.f2494b, false);
            return true;
        }

        /* JADX INFO: renamed from: b */
        private boolean m2774b(View view, FloatingActionButton floatingActionButton) {
            if (!m2773a(view, floatingActionButton)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((CoordinatorLayout.C0290d) floatingActionButton.getLayoutParams()).topMargin) {
                floatingActionButton.m2764b(this.f2494b, false);
                return true;
            }
            floatingActionButton.m2759a(this.f2494b, false);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2208a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, int i) {
            List<View> listM2706c = coordinatorLayout.m2706c(floatingActionButton);
            int size = listM2706c.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = listM2706c.get(i2);
                if (view instanceof AppBarLayout) {
                    if (m2771a(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (m2772a(view) && m2774b(view, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.m2697a(floatingActionButton, i);
            m2770a(coordinatorLayout, floatingActionButton);
            return true;
        }

        @Override // android.support.design.widget.CoordinatorLayout.Behavior
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean mo2715a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton, Rect rect) {
            Rect rect2 = floatingActionButton.f2476b;
            rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        /* JADX INFO: renamed from: a */
        private void m2770a(CoordinatorLayout coordinatorLayout, FloatingActionButton floatingActionButton) {
            int i;
            Rect rect = floatingActionButton.f2476b;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return;
            }
            CoordinatorLayout.C0290d c0290d = (CoordinatorLayout.C0290d) floatingActionButton.getLayoutParams();
            int i2 = 0;
            if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - c0290d.rightMargin) {
                i = rect.right;
            } else {
                i = floatingActionButton.getLeft() <= c0290d.leftMargin ? -rect.left : 0;
            }
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - c0290d.bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= c0290d.topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
            }
            if (i != 0) {
                ViewCompat.offsetLeftAndRight(floatingActionButton, i);
            }
        }
    }

    public float getCompatElevation() {
        return getImpl().mo5589a();
    }

    public void setCompatElevation(float f) {
        getImpl().m5591a(f);
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().m5602b();
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        getImpl().m5603b(f);
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().m5609c();
    }

    public void setCompatPressedTranslationZ(float f) {
        getImpl().m5610c(f);
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public C0005ac getShowMotionSpec() {
        return getImpl().m5615e();
    }

    public void setShowMotionSpec(C0005ac c0005ac) {
        getImpl().m5594a(c0005ac);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(C0005ac.m143a(getContext(), i));
    }

    public C0005ac getHideMotionSpec() {
        return getImpl().m5616f();
    }

    public void setHideMotionSpec(C0005ac c0005ac) {
        getImpl().m5604b(c0005ac);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(C0005ac.m143a(getContext(), i));
    }

    private C0770bl getImpl() {
        if (this.f2490p == null) {
            this.f2490p = m2757d();
        }
        return this.f2490p;
    }

    /* JADX INFO: renamed from: d */
    private C0770bl m2757d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return new C0771bm(this, new C0295b());
        }
        return new C0770bl(this, new C0295b());
    }

    /* JADX INFO: renamed from: android.support.design.widget.FloatingActionButton$b */
    class C0295b implements InterfaceC0775bq {
        C0295b() {
        }

        @Override // p000.InterfaceC0775bq
        /* JADX INFO: renamed from: a */
        public float mo2780a() {
            return FloatingActionButton.this.getSizeDimension() / 2.0f;
        }

        @Override // p000.InterfaceC0775bq
        /* JADX INFO: renamed from: a */
        public void mo2781a(int i, int i2, int i3, int i4) {
            FloatingActionButton.this.f2476b.set(i, i2, i3, i4);
            FloatingActionButton.this.setPadding(i + FloatingActionButton.this.f2485k, i2 + FloatingActionButton.this.f2485k, i3 + FloatingActionButton.this.f2485k, i4 + FloatingActionButton.this.f2485k);
        }

        @Override // p000.InterfaceC0775bq
        /* JADX INFO: renamed from: a */
        public void mo2782a(Drawable drawable) {
            FloatingActionButton.super.setBackgroundDrawable(drawable);
        }

        @Override // p000.InterfaceC0775bq
        /* JADX INFO: renamed from: b */
        public boolean mo2783b() {
            return FloatingActionButton.this.f2475a;
        }
    }
}
