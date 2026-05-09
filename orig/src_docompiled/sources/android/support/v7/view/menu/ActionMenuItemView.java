package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.appcompat.R;
import android.support.v7.view.menu.MenuBuilder;
import android.support.v7.widget.ActionMenuView;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import p000.AbstractViewOnAttachStateChangeListenerC1747gl;
import p000.C1768hf;
import p000.InterfaceC1715fg;
import p000.InterfaceC1718fj;

/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends AppCompatTextView implements ActionMenuView.InterfaceC0567a, View.OnClickListener, InterfaceC1715fg.a {

    /* JADX INFO: renamed from: a */
    MenuItemImpl f3207a;

    /* JADX INFO: renamed from: b */
    MenuBuilder.InterfaceC0553b f3208b;

    /* JADX INFO: renamed from: c */
    AbstractC0551b f3209c;

    /* JADX INFO: renamed from: d */
    private CharSequence f3210d;

    /* JADX INFO: renamed from: e */
    private Drawable f3211e;

    /* JADX INFO: renamed from: f */
    private AbstractViewOnAttachStateChangeListenerC1747gl f3212f;

    /* JADX INFO: renamed from: g */
    private boolean f3213g;

    /* JADX INFO: renamed from: h */
    private boolean f3214h;

    /* JADX INFO: renamed from: i */
    private int f3215i;

    /* JADX INFO: renamed from: j */
    private int f3216j;

    /* JADX INFO: renamed from: k */
    private int f3217k;

    /* JADX INFO: renamed from: android.support.v7.view.menu.ActionMenuItemView$b */
    public static abstract class AbstractC0551b {
        /* JADX INFO: renamed from: a */
        public abstract InterfaceC1718fj mo3302a();
    }

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public boolean mo2424a() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setShortcut(boolean z, char c) {
    }

    public ActionMenuItemView(Context context) {
        this(context, null);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f3213g = m3295e();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionMenuItemView, i, 0);
        this.f3215i = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.f3217k = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f3216j = -1;
        setSaveEnabled(false);
    }

    @Override // android.widget.TextView, android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f3213g = m3295e();
        m3296f();
    }

    /* JADX INFO: renamed from: e */
    private boolean m3295e() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        this.f3216j = i;
        super.setPadding(i, i2, i3, i4);
    }

    @Override // p000.InterfaceC1715fg.a
    public MenuItemImpl getItemData() {
        return this.f3207a;
    }

    @Override // p000.InterfaceC1715fg.a
    /* JADX INFO: renamed from: a */
    public void mo2423a(MenuItemImpl menuItemImpl, int i) {
        this.f3207a = menuItemImpl;
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.m3371a((InterfaceC1715fg.a) this));
        setId(menuItemImpl.getItemId());
        setVisibility(menuItemImpl.isVisible() ? 0 : 8);
        setEnabled(menuItemImpl.isEnabled());
        if (menuItemImpl.hasSubMenu() && this.f3212f == null) {
            this.f3212f = new C0550a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f3207a.hasSubMenu() && this.f3212f != null && this.f3212f.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f3208b != null) {
            this.f3208b.mo3303a(this.f3207a);
        }
    }

    public void setItemInvoker(MenuBuilder.InterfaceC0553b interfaceC0553b) {
        this.f3208b = interfaceC0553b;
    }

    public void setPopupCallback(AbstractC0551b abstractC0551b) {
        this.f3209c = abstractC0551b;
    }

    public void setExpandedFormat(boolean z) {
        if (this.f3214h != z) {
            this.f3214h = z;
            if (this.f3207a != null) {
                this.f3207a.m3386g();
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private void m3296f() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f3210d);
        if (this.f3211e != null && (!this.f3207a.m3391l() || (!this.f3213g && !this.f3214h))) {
            z = false;
        }
        boolean z3 = z2 & z;
        setText(z3 ? this.f3210d : null);
        CharSequence contentDescription = this.f3207a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            setContentDescription(z3 ? null : this.f3207a.getTitle());
        } else {
            setContentDescription(contentDescription);
        }
        CharSequence tooltipText = this.f3207a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            C1768hf.m9634a(this, z3 ? null : this.f3207a.getTitle());
        } else {
            C1768hf.m9634a(this, tooltipText);
        }
    }

    public void setIcon(Drawable drawable) {
        this.f3211e = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > this.f3217k) {
                float f = this.f3217k / intrinsicWidth;
                intrinsicWidth = this.f3217k;
                intrinsicHeight = (int) (intrinsicHeight * f);
            }
            if (intrinsicHeight > this.f3217k) {
                float f2 = this.f3217k / intrinsicHeight;
                intrinsicHeight = this.f3217k;
                intrinsicWidth = (int) (intrinsicWidth * f2);
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, null, null, null);
        m3296f();
    }

    /* JADX INFO: renamed from: b */
    public boolean m3297b() {
        return !TextUtils.isEmpty(getText());
    }

    public void setTitle(CharSequence charSequence) {
        this.f3210d = charSequence;
        m3296f();
    }

    @Override // android.support.v7.widget.ActionMenuView.InterfaceC0567a
    /* JADX INFO: renamed from: c */
    public boolean mo3298c() {
        return m3297b() && this.f3207a.getIcon() == null;
    }

    @Override // android.support.v7.widget.ActionMenuView.InterfaceC0567a
    /* JADX INFO: renamed from: d */
    public boolean mo3299d() {
        return m3297b();
    }

    @Override // android.support.v7.widget.AppCompatTextView, android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        boolean zM3297b = m3297b();
        if (zM3297b && this.f3216j >= 0) {
            super.setPadding(this.f3216j, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, this.f3215i) : this.f3215i;
        if (mode != 1073741824 && this.f3215i > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i2);
        }
        if (zM3297b || this.f3211e == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.f3211e.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    /* JADX INFO: renamed from: android.support.v7.view.menu.ActionMenuItemView$a */
    class C0550a extends AbstractViewOnAttachStateChangeListenerC1747gl {
        public C0550a() {
            super(ActionMenuItemView.this);
        }

        @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
        /* JADX INFO: renamed from: a */
        public InterfaceC1718fj mo3300a() {
            if (ActionMenuItemView.this.f3209c != null) {
                return ActionMenuItemView.this.f3209c.mo3302a();
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // p000.AbstractViewOnAttachStateChangeListenerC1747gl
        /* JADX INFO: renamed from: b */
        public boolean mo3301b() {
            InterfaceC1718fj interfaceC1718fjMo3300a;
            return ActionMenuItemView.this.f3208b != null && ActionMenuItemView.this.f3208b.mo3303a(ActionMenuItemView.this.f3207a) && (interfaceC1718fjMo3300a = mo3300a()) != null && interfaceC1718fjMo3300a.mo3693f();
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }
}
