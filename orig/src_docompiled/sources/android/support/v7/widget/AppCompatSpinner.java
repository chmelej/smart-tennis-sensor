package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.DataSetObserver;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import p000.AbstractViewOnAttachStateChangeListenerC1747gl;
import p000.C1684ee;
import p000.C1724fp;
import p000.C1774hl;
import p000.InterfaceC1761gz;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatSpinner extends Spinner implements TintableBackgroundView {

    /* JADX INFO: renamed from: d */
    private static final int[] f3471d = {R.attr.spinnerMode};

    /* JADX INFO: renamed from: a */
    C0580b f3472a;

    /* JADX INFO: renamed from: b */
    int f3473b;

    /* JADX INFO: renamed from: c */
    final Rect f3474c;

    /* JADX INFO: renamed from: e */
    private final C1724fp f3475e;

    /* JADX INFO: renamed from: f */
    private final Context f3476f;

    /* JADX INFO: renamed from: g */
    private AbstractViewOnAttachStateChangeListenerC1747gl f3477g;

    /* JADX INFO: renamed from: h */
    private SpinnerAdapter f3478h;

    /* JADX INFO: renamed from: i */
    private final boolean f3479i;

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.spinnerStyle);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, -1);
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet, int i, int i2) {
        this(context, attributeSet, i, i2, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0059 A[PHI: r11 r12
      0x0059: PHI (r11v3 int) = (r11v0 int), (r11v4 int) binds: [B:31:0x006b, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE]
      0x0059: PHI (r12v15 android.content.res.TypedArray) = (r12v14 android.content.res.TypedArray), (r12v17 android.content.res.TypedArray) binds: [B:31:0x006b, B:22:0x0057] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0071  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r8, android.util.AttributeSet r9, int r10, int r11, android.content.res.Resources.Theme r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 219
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int, int, android.content.res.Resources$Theme):void");
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        if (this.f3472a != null) {
            return this.f3476f;
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return super.getPopupContext();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        if (this.f3472a != null) {
            this.f3472a.m3680a(drawable);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i) {
        setPopupBackgroundDrawable(C1684ee.m8975b(getPopupContext(), i));
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        if (this.f3472a != null) {
            return this.f3472a.m3696h();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getPopupBackground();
        }
        return null;
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i) {
        if (this.f3472a != null) {
            this.f3472a.m3689d(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownVerticalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        if (this.f3472a != null) {
            return this.f3472a.m3701k();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownVerticalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i) {
        if (this.f3472a != null) {
            this.f3472a.m3687c(i);
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownHorizontalOffset(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        if (this.f3472a != null) {
            return this.f3472a.m3700j();
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownHorizontalOffset();
        }
        return 0;
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i) {
        if (this.f3472a != null) {
            this.f3473b = i;
        } else if (Build.VERSION.SDK_INT >= 16) {
            super.setDropDownWidth(i);
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        if (this.f3472a != null) {
            return this.f3473b;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return super.getDropDownWidth();
        }
        return 0;
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.f3479i) {
            this.f3478h = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        if (this.f3472a != null) {
            this.f3472a.mo3506a(new C0579a(spinnerAdapter, (this.f3476f == null ? getContext() : this.f3476f).getTheme()));
        }
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3472a == null || !this.f3472a.mo3693f()) {
            return;
        }
        this.f3472a.mo3690e();
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3477g == null || !this.f3477g.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f3472a == null || View.MeasureSpec.getMode(i) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), m3503a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.view.View
    public boolean performClick() {
        if (this.f3472a != null) {
            if (this.f3472a.mo3693f()) {
                return true;
            }
            this.f3472a.mo3510d();
            return true;
        }
        return super.performClick();
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        if (this.f3472a != null) {
            this.f3472a.m3507a(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        return this.f3472a != null ? this.f3472a.m3505a() : super.getPrompt();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3475e != null) {
            this.f3475e.m9215a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3475e != null) {
            this.f3475e.m9218a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3475e != null) {
            this.f3475e.m9216a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3475e != null) {
            return this.f3475e.m9214a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3475e != null) {
            this.f3475e.m9217a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3475e != null) {
            return this.f3475e.m9220b();
        }
        return null;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3475e != null) {
            this.f3475e.m9222c();
        }
    }

    /* JADX INFO: renamed from: a */
    int m3503a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int iMax = Math.max(0, getSelectedItemPosition());
        int iMin = Math.min(spinnerAdapter.getCount(), iMax + 15);
        View view = null;
        int iMax2 = 0;
        for (int iMax3 = Math.max(0, iMax - (15 - (iMin - iMax))); iMax3 < iMin; iMax3++) {
            int itemViewType = spinnerAdapter.getItemViewType(iMax3);
            if (itemViewType != i) {
                view = null;
                i = itemViewType;
            }
            view = spinnerAdapter.getView(iMax3, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
            iMax2 = Math.max(iMax2, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return iMax2;
        }
        drawable.getPadding(this.f3474c);
        return iMax2 + this.f3474c.left + this.f3474c.right;
    }

    /* JADX INFO: renamed from: android.support.v7.widget.AppCompatSpinner$a */
    static class C0579a implements ListAdapter, SpinnerAdapter {

        /* JADX INFO: renamed from: a */
        private SpinnerAdapter f3482a;

        /* JADX INFO: renamed from: b */
        private ListAdapter f3483b;

        @Override // android.widget.Adapter
        public int getItemViewType(int i) {
            return 0;
        }

        @Override // android.widget.Adapter
        public int getViewTypeCount() {
            return 1;
        }

        public C0579a(SpinnerAdapter spinnerAdapter, Resources.Theme theme) {
            this.f3482a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                this.f3483b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null) {
                if (Build.VERSION.SDK_INT >= 23 && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                    ThemedSpinnerAdapter themedSpinnerAdapter = (ThemedSpinnerAdapter) spinnerAdapter;
                    if (themedSpinnerAdapter.getDropDownViewTheme() != theme) {
                        themedSpinnerAdapter.setDropDownViewTheme(theme);
                        return;
                    }
                    return;
                }
                if (spinnerAdapter instanceof InterfaceC1761gz) {
                    InterfaceC1761gz interfaceC1761gz = (InterfaceC1761gz) spinnerAdapter;
                    if (interfaceC1761gz.m9590a() == null) {
                        interfaceC1761gz.m9591a(theme);
                    }
                }
            }
        }

        @Override // android.widget.Adapter
        public int getCount() {
            if (this.f3482a == null) {
                return 0;
            }
            return this.f3482a.getCount();
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            if (this.f3482a == null) {
                return null;
            }
            return this.f3482a.getItem(i);
        }

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            if (this.f3482a == null) {
                return -1L;
            }
            return this.f3482a.getItemId(i);
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view, ViewGroup viewGroup) {
            return getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.SpinnerAdapter
        public View getDropDownView(int i, View view, ViewGroup viewGroup) {
            if (this.f3482a == null) {
                return null;
            }
            return this.f3482a.getDropDownView(i, view, viewGroup);
        }

        @Override // android.widget.Adapter
        public boolean hasStableIds() {
            return this.f3482a != null && this.f3482a.hasStableIds();
        }

        @Override // android.widget.Adapter
        public void registerDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f3482a != null) {
                this.f3482a.registerDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.Adapter
        public void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
            if (this.f3482a != null) {
                this.f3482a.unregisterDataSetObserver(dataSetObserver);
            }
        }

        @Override // android.widget.ListAdapter
        public boolean areAllItemsEnabled() {
            ListAdapter listAdapter = this.f3483b;
            if (listAdapter != null) {
                return listAdapter.areAllItemsEnabled();
            }
            return true;
        }

        @Override // android.widget.ListAdapter
        public boolean isEnabled(int i) {
            ListAdapter listAdapter = this.f3483b;
            if (listAdapter != null) {
                return listAdapter.isEnabled(i);
            }
            return true;
        }

        @Override // android.widget.Adapter
        public boolean isEmpty() {
            return getCount() == 0;
        }
    }

    /* JADX INFO: renamed from: android.support.v7.widget.AppCompatSpinner$b */
    class C0580b extends ListPopupWindow {

        /* JADX INFO: renamed from: a */
        ListAdapter f3484a;

        /* JADX INFO: renamed from: h */
        private CharSequence f3486h;

        /* JADX INFO: renamed from: i */
        private final Rect f3487i;

        public C0580b(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            this.f3487i = new Rect();
            m3685b(AppCompatSpinner.this);
            m3683a(true);
            m3678a(0);
            m3681a(new AdapterView.OnItemClickListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
                    AppCompatSpinner.this.setSelection(i2);
                    if (AppCompatSpinner.this.getOnItemClickListener() != null) {
                        AppCompatSpinner.this.performItemClick(view, i2, C0580b.this.f3484a.getItemId(i2));
                    }
                    C0580b.this.mo3690e();
                }
            });
        }

        @Override // android.support.v7.widget.ListPopupWindow
        /* JADX INFO: renamed from: a */
        public void mo3506a(ListAdapter listAdapter) {
            super.mo3506a(listAdapter);
            this.f3484a = listAdapter;
        }

        /* JADX INFO: renamed from: a */
        public CharSequence m3505a() {
            return this.f3486h;
        }

        /* JADX INFO: renamed from: a */
        public void m3507a(CharSequence charSequence) {
            this.f3486h = charSequence;
        }

        /* JADX INFO: renamed from: b */
        void m3509b() {
            Drawable drawableH = m3696h();
            int i = 0;
            if (drawableH != null) {
                drawableH.getPadding(AppCompatSpinner.this.f3474c);
                i = C1774hl.m9679a(AppCompatSpinner.this) ? AppCompatSpinner.this.f3474c.right : -AppCompatSpinner.this.f3474c.left;
            } else {
                Rect rect = AppCompatSpinner.this.f3474c;
                AppCompatSpinner.this.f3474c.right = 0;
                rect.left = 0;
            }
            int paddingLeft = AppCompatSpinner.this.getPaddingLeft();
            int paddingRight = AppCompatSpinner.this.getPaddingRight();
            int width = AppCompatSpinner.this.getWidth();
            if (AppCompatSpinner.this.f3473b == -2) {
                int iM3503a = AppCompatSpinner.this.m3503a((SpinnerAdapter) this.f3484a, m3696h());
                int i2 = (AppCompatSpinner.this.getContext().getResources().getDisplayMetrics().widthPixels - AppCompatSpinner.this.f3474c.left) - AppCompatSpinner.this.f3474c.right;
                if (iM3503a > i2) {
                    iM3503a = i2;
                }
                m3695g(Math.max(iM3503a, (width - paddingLeft) - paddingRight));
            } else if (AppCompatSpinner.this.f3473b == -1) {
                m3695g((width - paddingLeft) - paddingRight);
            } else {
                m3695g(AppCompatSpinner.this.f3473b);
            }
            m3687c(C1774hl.m9679a(AppCompatSpinner.this) ? i + ((width - paddingRight) - m3702l()) : i + paddingLeft);
        }

        @Override // android.support.v7.widget.ListPopupWindow, p000.InterfaceC1718fj
        /* JADX INFO: renamed from: d */
        public void mo3510d() {
            ViewTreeObserver viewTreeObserver;
            boolean zF = mo3693f();
            m3509b();
            m3697h(2);
            super.mo3510d();
            mo3694g().setChoiceMode(1);
            m3699i(AppCompatSpinner.this.getSelectedItemPosition());
            if (zF || (viewTreeObserver = AppCompatSpinner.this.getViewTreeObserver()) == null) {
                return;
            }
            final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.2
                @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                public void onGlobalLayout() {
                    if (!C0580b.this.m3508a(AppCompatSpinner.this)) {
                        C0580b.this.mo3690e();
                    } else {
                        C0580b.this.m3509b();
                        C0580b.super.mo3510d();
                    }
                }
            };
            viewTreeObserver.addOnGlobalLayoutListener(onGlobalLayoutListener);
            m3682a(new PopupWindow.OnDismissListener() { // from class: android.support.v7.widget.AppCompatSpinner.b.3
                @Override // android.widget.PopupWindow.OnDismissListener
                public void onDismiss() {
                    ViewTreeObserver viewTreeObserver2 = AppCompatSpinner.this.getViewTreeObserver();
                    if (viewTreeObserver2 != null) {
                        viewTreeObserver2.removeGlobalOnLayoutListener(onGlobalLayoutListener);
                    }
                }
            });
        }

        /* JADX INFO: renamed from: a */
        boolean m3508a(View view) {
            return ViewCompat.isAttachedToWindow(view) && view.getGlobalVisibleRect(this.f3487i);
        }
    }
}
