package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.view.menu.MenuItemImpl;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import p000.C1774hl;
import p000.InterfaceC1714ff;
import p000.InterfaceC1715fg;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuView extends LinearLayoutCompat implements MenuBuilder.InterfaceC0553b, InterfaceC1715fg {

    /* JADX INFO: renamed from: a */
    MenuBuilder.InterfaceC0552a f3398a;

    /* JADX INFO: renamed from: b */
    InterfaceC0570d f3399b;

    /* JADX INFO: renamed from: c */
    private MenuBuilder f3400c;

    /* JADX INFO: renamed from: d */
    private Context f3401d;

    /* JADX INFO: renamed from: e */
    private int f3402e;

    /* JADX INFO: renamed from: f */
    private boolean f3403f;

    /* JADX INFO: renamed from: g */
    private ActionMenuPresenter f3404g;

    /* JADX INFO: renamed from: h */
    private InterfaceC1714ff.a f3405h;

    /* JADX INFO: renamed from: i */
    private boolean f3406i;

    /* JADX INFO: renamed from: j */
    private int f3407j;

    /* JADX INFO: renamed from: k */
    private int f3408k;

    /* JADX INFO: renamed from: l */
    private int f3409l;

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$a */
    public interface InterfaceC0567a {
        /* JADX INFO: renamed from: c */
        boolean mo3298c();

        /* JADX INFO: renamed from: d */
        boolean mo3299d();
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$d */
    public interface InterfaceC0570d {
        /* JADX INFO: renamed from: a */
        boolean mo3480a(MenuItem menuItem);
    }

    @Override // android.view.View
    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f3408k = (int) (56.0f * f);
        this.f3409l = (int) (f * 4.0f);
        this.f3401d = context;
        this.f3402e = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f3402e != i) {
            this.f3402e = i;
            if (i == 0) {
                this.f3401d = getContext();
            } else {
                this.f3401d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f3402e;
    }

    public void setPresenter(ActionMenuPresenter actionMenuPresenter) {
        this.f3404g = actionMenuPresenter;
        this.f3404g.m3447a(this);
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.f3404g != null) {
            this.f3404g.mo2441a(false);
            if (this.f3404g.m3457j()) {
                this.f3404g.m3454g();
                this.f3404g.m3453f();
            }
        }
    }

    public void setOnMenuItemClickListener(InterfaceC0570d interfaceC0570d) {
        this.f3399b = interfaceC0570d;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean z = this.f3406i;
        this.f3406i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f3406i) {
            this.f3407j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (this.f3406i && this.f3400c != null && size != this.f3407j) {
            this.f3407j = size;
            this.f3400c.mo2458a(true);
        }
        int childCount = getChildCount();
        if (this.f3406i && childCount > 0) {
            m3464c(i, i2);
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            LayoutParams layoutParams = (LayoutParams) getChildAt(i3).getLayoutParams();
            layoutParams.rightMargin = 0;
            layoutParams.leftMargin = 0;
        }
        super.onMeasure(i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0254  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x025d A[ADDED_TO_REGION, LOOP:5: B:137:0x025d->B:142:0x0280, LOOP_START, PHI: r3 r34
      0x025d: PHI (r3v8 int) = (r3v7 int), (r3v9 int) binds: [B:136:0x025b, B:142:0x0280] A[DONT_GENERATE, DONT_INLINE]
      0x025d: PHI (r34v2 int) = (r34v1 int), (r34v3 int) binds: [B:136:0x025b, B:142:0x0280] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0287  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x028c  */
    /* JADX WARN: Type inference failed for: r2v30 */
    /* JADX WARN: Type inference failed for: r2v31, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v45 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v21, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m3464c(int r37, int r38) {
        /*
            Method dump skipped, instruction units count: 660
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ActionMenuView.m3464c(int, int):void");
    }

    /* JADX INFO: renamed from: a */
    static int m3463a(View view, int i, int i2, int i3, int i4) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = false;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.m3297b();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, ExploreByTouchHelper.INVALID_ID), iMakeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (!layoutParams.f3410a && z2) {
            z = true;
        }
        layoutParams.f3413d = z;
        layoutParams.f3411b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), iMakeMeasureSpec);
        return i5;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int width;
        int paddingLeft;
        if (!this.f3406i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i7 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i8 = i3 - i;
        int paddingRight = (i8 - getPaddingRight()) - getPaddingLeft();
        boolean zM9679a = C1774hl.m9679a(this);
        int measuredWidth = paddingRight;
        int i9 = 0;
        int i10 = 0;
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = getChildAt(i11);
            if (childAt.getVisibility() != 8) {
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (layoutParams.f3410a) {
                    int measuredWidth2 = childAt.getMeasuredWidth();
                    if (m3468a(i11)) {
                        measuredWidth2 += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (zM9679a) {
                        paddingLeft = getPaddingLeft() + layoutParams.leftMargin;
                        width = paddingLeft + measuredWidth2;
                    } else {
                        width = (getWidth() - getPaddingRight()) - layoutParams.rightMargin;
                        paddingLeft = width - measuredWidth2;
                    }
                    int i12 = i7 - (measuredHeight / 2);
                    childAt.layout(paddingLeft, i12, width, measuredHeight + i12);
                    measuredWidth -= measuredWidth2;
                    i9 = 1;
                } else {
                    measuredWidth -= (childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin;
                    m3468a(i11);
                    i10++;
                }
            }
        }
        if (childCount == 1 && i9 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth3 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i13 = (i8 / 2) - (measuredWidth3 / 2);
            int i14 = i7 - (measuredHeight2 / 2);
            childAt2.layout(i13, i14, measuredWidth3 + i13, measuredHeight2 + i14);
            return;
        }
        int i15 = i10 - (i9 ^ 1);
        if (i15 > 0) {
            i6 = measuredWidth / i15;
            i5 = 0;
        } else {
            i5 = 0;
            i6 = 0;
        }
        int iMax = Math.max(i5, i6);
        if (zM9679a) {
            int width2 = getWidth() - getPaddingRight();
            while (i5 < childCount) {
                View childAt3 = getChildAt(i5);
                LayoutParams layoutParams2 = (LayoutParams) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !layoutParams2.f3410a) {
                    int i16 = width2 - layoutParams2.rightMargin;
                    int measuredWidth4 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i17 = i7 - (measuredHeight3 / 2);
                    childAt3.layout(i16 - measuredWidth4, i17, i16, measuredHeight3 + i17);
                    width2 = i16 - ((measuredWidth4 + layoutParams2.leftMargin) + iMax);
                }
                i5++;
            }
            return;
        }
        int paddingLeft2 = getPaddingLeft();
        while (i5 < childCount) {
            View childAt4 = getChildAt(i5);
            LayoutParams layoutParams3 = (LayoutParams) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !layoutParams3.f3410a) {
                int i18 = paddingLeft2 + layoutParams3.leftMargin;
                int measuredWidth5 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i19 = i7 - (measuredHeight4 / 2);
                childAt4.layout(i18, i19, i18 + measuredWidth5, measuredHeight4 + i19);
                paddingLeft2 = i18 + measuredWidth5 + layoutParams3.rightMargin + iMax;
            }
            i5++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3478i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f3404g.m3445a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f3404g.m3452e();
    }

    /* JADX INFO: renamed from: a */
    public boolean m3467a() {
        return this.f3403f;
    }

    public void setOverflowReserved(boolean z) {
        this.f3403f = z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateDefaultLayoutParams() {
        LayoutParams layoutParams = new LayoutParams(-2, -2);
        layoutParams.f3548h = 16;
        return layoutParams;
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams != null) {
            LayoutParams layoutParams2 = layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : new LayoutParams(layoutParams);
            if (layoutParams2.f3548h <= 0) {
                layoutParams2.f3548h = 16;
            }
            return layoutParams2;
        }
        return generateDefaultLayoutParams();
    }

    @Override // android.support.v7.widget.LinearLayoutCompat, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof LayoutParams);
    }

    /* JADX INFO: renamed from: c */
    public LayoutParams m3472c() {
        LayoutParams layoutParamsGenerateDefaultLayoutParams = generateDefaultLayoutParams();
        layoutParamsGenerateDefaultLayoutParams.f3410a = true;
        return layoutParamsGenerateDefaultLayoutParams;
    }

    @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0553b
    /* JADX INFO: renamed from: a */
    public boolean mo3303a(MenuItemImpl menuItemImpl) {
        return this.f3400c.m3334a(menuItemImpl, 0);
    }

    @Override // p000.InterfaceC1715fg
    /* JADX INFO: renamed from: a */
    public void mo2430a(MenuBuilder menuBuilder) {
        this.f3400c = menuBuilder;
    }

    public Menu getMenu() {
        if (this.f3400c == null) {
            Context context = getContext();
            this.f3400c = new MenuBuilder(context);
            this.f3400c.mo3327a(new C0569c());
            this.f3404g = new ActionMenuPresenter(context);
            this.f3404g.m3450b(true);
            this.f3404g.mo2440a(this.f3405h != null ? this.f3405h : new C0568b());
            this.f3400c.m3331a(this.f3404g, this.f3401d);
            this.f3404g.m3447a(this);
        }
        return this.f3400c;
    }

    public void setMenuCallbacks(InterfaceC1714ff.a aVar, MenuBuilder.InterfaceC0552a interfaceC0552a) {
        this.f3405h = aVar;
        this.f3398a = interfaceC0552a;
    }

    /* JADX INFO: renamed from: d */
    public MenuBuilder m3473d() {
        return this.f3400c;
    }

    /* JADX INFO: renamed from: e */
    public boolean m3474e() {
        return this.f3404g != null && this.f3404g.m3453f();
    }

    /* JADX INFO: renamed from: f */
    public boolean m3475f() {
        return this.f3404g != null && this.f3404g.m3454g();
    }

    /* JADX INFO: renamed from: g */
    public boolean m3476g() {
        return this.f3404g != null && this.f3404g.m3457j();
    }

    /* JADX INFO: renamed from: h */
    public boolean m3477h() {
        return this.f3404g != null && this.f3404g.m3458k();
    }

    /* JADX INFO: renamed from: i */
    public void m3478i() {
        if (this.f3404g != null) {
            this.f3404g.m3455h();
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean m3468a(int i) {
        boolean zMo3299d = false;
        if (i == 0) {
            return false;
        }
        KeyEvent.Callback childAt = getChildAt(i - 1);
        KeyEvent.Callback childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof InterfaceC0567a)) {
            zMo3299d = false | ((InterfaceC0567a) childAt).mo3299d();
        }
        return (i <= 0 || !(childAt2 instanceof InterfaceC0567a)) ? zMo3299d : zMo3299d | ((InterfaceC0567a) childAt2).mo3298c();
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f3404g.m3451c(z);
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$c */
    class C0569c implements MenuBuilder.InterfaceC0552a {
        C0569c() {
        }

        @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
        /* JADX INFO: renamed from: a */
        public boolean mo2622a(MenuBuilder menuBuilder, MenuItem menuItem) {
            return ActionMenuView.this.f3399b != null && ActionMenuView.this.f3399b.mo3480a(menuItem);
        }

        @Override // android.support.v7.view.menu.MenuBuilder.InterfaceC0552a
        /* JADX INFO: renamed from: a */
        public void mo2621a(MenuBuilder menuBuilder) {
            if (ActionMenuView.this.f3398a != null) {
                ActionMenuView.this.f3398a.mo2621a(menuBuilder);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.ActionMenuView$b */
    static class C0568b implements InterfaceC1714ff.a {
        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public void mo3278a(MenuBuilder menuBuilder, boolean z) {
        }

        @Override // p000.InterfaceC1714ff.a
        /* JADX INFO: renamed from: a */
        public boolean mo3279a(MenuBuilder menuBuilder) {
            return false;
        }

        C0568b() {
        }
    }

    public static class LayoutParams extends LinearLayoutCompat.LayoutParams {

        /* JADX INFO: renamed from: a */
        @ViewDebug.ExportedProperty
        public boolean f3410a;

        /* JADX INFO: renamed from: b */
        @ViewDebug.ExportedProperty
        public int f3411b;

        /* JADX INFO: renamed from: c */
        @ViewDebug.ExportedProperty
        public int f3412c;

        /* JADX INFO: renamed from: d */
        @ViewDebug.ExportedProperty
        public boolean f3413d;

        /* JADX INFO: renamed from: e */
        @ViewDebug.ExportedProperty
        public boolean f3414e;

        /* JADX INFO: renamed from: f */
        boolean f3415f;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
            this.f3410a = layoutParams.f3410a;
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f3410a = false;
        }
    }
}
