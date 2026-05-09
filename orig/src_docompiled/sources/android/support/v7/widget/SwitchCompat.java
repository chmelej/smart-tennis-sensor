package android.support.v7.widget;

import android.R;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.Property;
import android.view.ActionMode;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import p000.C1684ee;
import p000.C1692ek;
import p000.C1743gh;
import p000.C1766hd;
import p000.C1774hl;

/* JADX INFO: loaded from: classes.dex */
public class SwitchCompat extends CompoundButton {

    /* JADX INFO: renamed from: A */
    private int f4008A;

    /* JADX INFO: renamed from: B */
    private int f4009B;

    /* JADX INFO: renamed from: C */
    private int f4010C;

    /* JADX INFO: renamed from: D */
    private int f4011D;

    /* JADX INFO: renamed from: E */
    private int f4012E;

    /* JADX INFO: renamed from: F */
    private int f4013F;

    /* JADX INFO: renamed from: G */
    private int f4014G;

    /* JADX INFO: renamed from: H */
    private final TextPaint f4015H;

    /* JADX INFO: renamed from: I */
    private ColorStateList f4016I;

    /* JADX INFO: renamed from: J */
    private Layout f4017J;

    /* JADX INFO: renamed from: K */
    private Layout f4018K;

    /* JADX INFO: renamed from: L */
    private TransformationMethod f4019L;

    /* JADX INFO: renamed from: M */
    private final Rect f4020M;

    /* JADX INFO: renamed from: a */
    float f4021a;

    /* JADX INFO: renamed from: b */
    ObjectAnimator f4022b;

    /* JADX INFO: renamed from: d */
    private Drawable f4023d;

    /* JADX INFO: renamed from: e */
    private ColorStateList f4024e;

    /* JADX INFO: renamed from: f */
    private PorterDuff.Mode f4025f;

    /* JADX INFO: renamed from: g */
    private boolean f4026g;

    /* JADX INFO: renamed from: h */
    private boolean f4027h;

    /* JADX INFO: renamed from: i */
    private Drawable f4028i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f4029j;

    /* JADX INFO: renamed from: k */
    private PorterDuff.Mode f4030k;

    /* JADX INFO: renamed from: l */
    private boolean f4031l;

    /* JADX INFO: renamed from: m */
    private boolean f4032m;

    /* JADX INFO: renamed from: n */
    private int f4033n;

    /* JADX INFO: renamed from: o */
    private int f4034o;

    /* JADX INFO: renamed from: p */
    private int f4035p;

    /* JADX INFO: renamed from: q */
    private boolean f4036q;

    /* JADX INFO: renamed from: r */
    private CharSequence f4037r;

    /* JADX INFO: renamed from: s */
    private CharSequence f4038s;

    /* JADX INFO: renamed from: t */
    private boolean f4039t;

    /* JADX INFO: renamed from: u */
    private int f4040u;

    /* JADX INFO: renamed from: v */
    private int f4041v;

    /* JADX INFO: renamed from: w */
    private float f4042w;

    /* JADX INFO: renamed from: x */
    private float f4043x;

    /* JADX INFO: renamed from: y */
    private VelocityTracker f4044y;

    /* JADX INFO: renamed from: z */
    private int f4045z;

    /* JADX INFO: renamed from: c */
    private static final Property<SwitchCompat, Float> f4007c = new Property<SwitchCompat, Float>(Float.class, "thumbPos") { // from class: android.support.v7.widget.SwitchCompat.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(SwitchCompat switchCompat) {
            return Float.valueOf(switchCompat.f4021a);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(SwitchCompat switchCompat, Float f) {
            switchCompat.setThumbPosition(f.floatValue());
        }
    };

    /* JADX INFO: renamed from: N */
    private static final int[] f4006N = {R.attr.state_checked};

    /* JADX INFO: renamed from: a */
    private static float m4329a(float f, float f2, float f3) {
        return f < f2 ? f2 : f > f3 ? f3 : f;
    }

    public SwitchCompat(Context context) {
        this(context, null);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.switchStyle);
    }

    public SwitchCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f4024e = null;
        this.f4025f = null;
        this.f4026g = false;
        this.f4027h = false;
        this.f4029j = null;
        this.f4030k = null;
        this.f4031l = false;
        this.f4032m = false;
        this.f4044y = VelocityTracker.obtain();
        this.f4020M = new Rect();
        this.f4015H = new TextPaint(1);
        Resources resources = getResources();
        this.f4015H.density = resources.getDisplayMetrics().density;
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, android.support.v7.appcompat.R.styleable.SwitchCompat, i, 0);
        this.f4023d = c1766hdM9601a.m9605a(android.support.v7.appcompat.R.styleable.SwitchCompat_android_thumb);
        if (this.f4023d != null) {
            this.f4023d.setCallback(this);
        }
        this.f4028i = c1766hdM9601a.m9605a(android.support.v7.appcompat.R.styleable.SwitchCompat_track);
        if (this.f4028i != null) {
            this.f4028i.setCallback(this);
        }
        this.f4037r = c1766hdM9601a.m9612c(android.support.v7.appcompat.R.styleable.SwitchCompat_android_textOn);
        this.f4038s = c1766hdM9601a.m9612c(android.support.v7.appcompat.R.styleable.SwitchCompat_android_textOff);
        this.f4039t = c1766hdM9601a.m9607a(android.support.v7.appcompat.R.styleable.SwitchCompat_showText, true);
        this.f4033n = c1766hdM9601a.m9615e(android.support.v7.appcompat.R.styleable.SwitchCompat_thumbTextPadding, 0);
        this.f4034o = c1766hdM9601a.m9615e(android.support.v7.appcompat.R.styleable.SwitchCompat_switchMinWidth, 0);
        this.f4035p = c1766hdM9601a.m9615e(android.support.v7.appcompat.R.styleable.SwitchCompat_switchPadding, 0);
        this.f4036q = c1766hdM9601a.m9607a(android.support.v7.appcompat.R.styleable.SwitchCompat_splitTrack, false);
        ColorStateList colorStateListM9616e = c1766hdM9601a.m9616e(android.support.v7.appcompat.R.styleable.SwitchCompat_thumbTint);
        if (colorStateListM9616e != null) {
            this.f4024e = colorStateListM9616e;
            this.f4026g = true;
        }
        PorterDuff.Mode modeM9425a = C1743gh.m9425a(c1766hdM9601a.m9603a(android.support.v7.appcompat.R.styleable.SwitchCompat_thumbTintMode, -1), null);
        if (this.f4025f != modeM9425a) {
            this.f4025f = modeM9425a;
            this.f4027h = true;
        }
        if (this.f4026g || this.f4027h) {
            m4336b();
        }
        ColorStateList colorStateListM9616e2 = c1766hdM9601a.m9616e(android.support.v7.appcompat.R.styleable.SwitchCompat_trackTint);
        if (colorStateListM9616e2 != null) {
            this.f4029j = colorStateListM9616e2;
            this.f4031l = true;
        }
        PorterDuff.Mode modeM9425a2 = C1743gh.m9425a(c1766hdM9601a.m9603a(android.support.v7.appcompat.R.styleable.SwitchCompat_trackTintMode, -1), null);
        if (this.f4030k != modeM9425a2) {
            this.f4030k = modeM9425a2;
            this.f4032m = true;
        }
        if (this.f4031l || this.f4032m) {
            m4331a();
        }
        int iM9619g = c1766hdM9601a.m9619g(android.support.v7.appcompat.R.styleable.SwitchCompat_switchTextAppearance, 0);
        if (iM9619g != 0) {
            setSwitchTextAppearance(context, iM9619g);
        }
        c1766hdM9601a.m9606a();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f4041v = viewConfiguration.getScaledTouchSlop();
        this.f4045z = viewConfiguration.getScaledMinimumFlingVelocity();
        refreshDrawableState();
        setChecked(isChecked());
    }

    public void setSwitchTextAppearance(Context context, int i) {
        C1766hd c1766hdM9599a = C1766hd.m9599a(context, i, android.support.v7.appcompat.R.styleable.TextAppearance);
        ColorStateList colorStateListM9616e = c1766hdM9599a.m9616e(android.support.v7.appcompat.R.styleable.TextAppearance_android_textColor);
        if (colorStateListM9616e != null) {
            this.f4016I = colorStateListM9616e;
        } else {
            this.f4016I = getTextColors();
        }
        int iM9615e = c1766hdM9599a.m9615e(android.support.v7.appcompat.R.styleable.TextAppearance_android_textSize, 0);
        if (iM9615e != 0) {
            float f = iM9615e;
            if (f != this.f4015H.getTextSize()) {
                this.f4015H.setTextSize(f);
                requestLayout();
            }
        }
        m4332a(c1766hdM9599a.m9603a(android.support.v7.appcompat.R.styleable.TextAppearance_android_typeface, -1), c1766hdM9599a.m9603a(android.support.v7.appcompat.R.styleable.TextAppearance_android_textStyle, -1));
        if (c1766hdM9599a.m9607a(android.support.v7.appcompat.R.styleable.TextAppearance_textAllCaps, false)) {
            this.f4019L = new C1692ek(getContext());
        } else {
            this.f4019L = null;
        }
        c1766hdM9599a.m9606a();
    }

    /* JADX INFO: renamed from: a */
    private void m4332a(int i, int i2) {
        Typeface typeface;
        switch (i) {
            case 1:
                typeface = Typeface.SANS_SERIF;
                break;
            case 2:
                typeface = Typeface.SERIF;
                break;
            case 3:
                typeface = Typeface.MONOSPACE;
                break;
            default:
                typeface = null;
                break;
        }
        setSwitchTypeface(typeface, i2);
    }

    public void setSwitchTypeface(Typeface typeface, int i) {
        Typeface typefaceCreate;
        if (i > 0) {
            if (typeface == null) {
                typefaceCreate = Typeface.defaultFromStyle(i);
            } else {
                typefaceCreate = Typeface.create(typeface, i);
            }
            setSwitchTypeface(typefaceCreate);
            int style = ((typefaceCreate != null ? typefaceCreate.getStyle() : 0) ^ (-1)) & i;
            this.f4015H.setFakeBoldText((style & 1) != 0);
            this.f4015H.setTextSkewX((style & 2) != 0 ? -0.25f : 0.0f);
            return;
        }
        this.f4015H.setFakeBoldText(false);
        this.f4015H.setTextSkewX(0.0f);
        setSwitchTypeface(typeface);
    }

    public void setSwitchTypeface(Typeface typeface) {
        if ((this.f4015H.getTypeface() == null || this.f4015H.getTypeface().equals(typeface)) && (this.f4015H.getTypeface() != null || typeface == null)) {
            return;
        }
        this.f4015H.setTypeface(typeface);
        requestLayout();
        invalidate();
    }

    public void setSwitchPadding(int i) {
        this.f4035p = i;
        requestLayout();
    }

    public int getSwitchPadding() {
        return this.f4035p;
    }

    public void setSwitchMinWidth(int i) {
        this.f4034o = i;
        requestLayout();
    }

    public int getSwitchMinWidth() {
        return this.f4034o;
    }

    public void setThumbTextPadding(int i) {
        this.f4033n = i;
        requestLayout();
    }

    public int getThumbTextPadding() {
        return this.f4033n;
    }

    public void setTrackDrawable(Drawable drawable) {
        if (this.f4028i != null) {
            this.f4028i.setCallback(null);
        }
        this.f4028i = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setTrackResource(int i) {
        setTrackDrawable(C1684ee.m8975b(getContext(), i));
    }

    public Drawable getTrackDrawable() {
        return this.f4028i;
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        this.f4029j = colorStateList;
        this.f4031l = true;
        m4331a();
    }

    public ColorStateList getTrackTintList() {
        return this.f4029j;
    }

    public void setTrackTintMode(PorterDuff.Mode mode) {
        this.f4030k = mode;
        this.f4032m = true;
        m4331a();
    }

    public PorterDuff.Mode getTrackTintMode() {
        return this.f4030k;
    }

    /* JADX INFO: renamed from: a */
    private void m4331a() {
        if (this.f4028i != null) {
            if (this.f4031l || this.f4032m) {
                this.f4028i = this.f4028i.mutate();
                if (this.f4031l) {
                    DrawableCompat.setTintList(this.f4028i, this.f4029j);
                }
                if (this.f4032m) {
                    DrawableCompat.setTintMode(this.f4028i, this.f4030k);
                }
                if (this.f4028i.isStateful()) {
                    this.f4028i.setState(getDrawableState());
                }
            }
        }
    }

    public void setThumbDrawable(Drawable drawable) {
        if (this.f4023d != null) {
            this.f4023d.setCallback(null);
        }
        this.f4023d = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
        }
        requestLayout();
    }

    public void setThumbResource(int i) {
        setThumbDrawable(C1684ee.m8975b(getContext(), i));
    }

    public Drawable getThumbDrawable() {
        return this.f4023d;
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        this.f4024e = colorStateList;
        this.f4026g = true;
        m4336b();
    }

    public ColorStateList getThumbTintList() {
        return this.f4024e;
    }

    public void setThumbTintMode(PorterDuff.Mode mode) {
        this.f4025f = mode;
        this.f4027h = true;
        m4336b();
    }

    public PorterDuff.Mode getThumbTintMode() {
        return this.f4025f;
    }

    /* JADX INFO: renamed from: b */
    private void m4336b() {
        if (this.f4023d != null) {
            if (this.f4026g || this.f4027h) {
                this.f4023d = this.f4023d.mutate();
                if (this.f4026g) {
                    DrawableCompat.setTintList(this.f4023d, this.f4024e);
                }
                if (this.f4027h) {
                    DrawableCompat.setTintMode(this.f4023d, this.f4025f);
                }
                if (this.f4023d.isStateful()) {
                    this.f4023d.setState(getDrawableState());
                }
            }
        }
    }

    public void setSplitTrack(boolean z) {
        this.f4036q = z;
        invalidate();
    }

    public boolean getSplitTrack() {
        return this.f4036q;
    }

    public CharSequence getTextOn() {
        return this.f4037r;
    }

    public void setTextOn(CharSequence charSequence) {
        this.f4037r = charSequence;
        requestLayout();
    }

    public CharSequence getTextOff() {
        return this.f4038s;
    }

    public void setTextOff(CharSequence charSequence) {
        this.f4038s = charSequence;
        requestLayout();
    }

    public void setShowText(boolean z) {
        if (this.f4039t != z) {
            this.f4039t = z;
            requestLayout();
        }
    }

    public boolean getShowText() {
        return this.f4039t;
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i, int i2) {
        int intrinsicWidth;
        int intrinsicHeight;
        if (this.f4039t) {
            if (this.f4017J == null) {
                this.f4017J = m4330a(this.f4037r);
            }
            if (this.f4018K == null) {
                this.f4018K = m4330a(this.f4038s);
            }
        }
        Rect rect = this.f4020M;
        int intrinsicHeight2 = 0;
        if (this.f4023d != null) {
            this.f4023d.getPadding(rect);
            intrinsicWidth = (this.f4023d.getIntrinsicWidth() - rect.left) - rect.right;
            intrinsicHeight = this.f4023d.getIntrinsicHeight();
        } else {
            intrinsicWidth = 0;
            intrinsicHeight = 0;
        }
        this.f4010C = Math.max(this.f4039t ? Math.max(this.f4017J.getWidth(), this.f4018K.getWidth()) + (this.f4033n * 2) : 0, intrinsicWidth);
        if (this.f4028i != null) {
            this.f4028i.getPadding(rect);
            intrinsicHeight2 = this.f4028i.getIntrinsicHeight();
        } else {
            rect.setEmpty();
        }
        int iMax = rect.left;
        int iMax2 = rect.right;
        if (this.f4023d != null) {
            Rect rectM9426a = C1743gh.m9426a(this.f4023d);
            iMax = Math.max(iMax, rectM9426a.left);
            iMax2 = Math.max(iMax2, rectM9426a.right);
        }
        int iMax3 = Math.max(this.f4034o, (this.f4010C * 2) + iMax + iMax2);
        int iMax4 = Math.max(intrinsicHeight2, intrinsicHeight);
        this.f4008A = iMax3;
        this.f4009B = iMax4;
        super.onMeasure(i, i2);
        if (getMeasuredHeight() < iMax4) {
            setMeasuredDimension(getMeasuredWidthAndState(), iMax4);
        }
    }

    @Override // android.view.View
    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        CharSequence charSequence = isChecked() ? this.f4037r : this.f4038s;
        if (charSequence != null) {
            accessibilityEvent.getText().add(charSequence);
        }
    }

    /* JADX INFO: renamed from: a */
    private Layout m4330a(CharSequence charSequence) {
        if (this.f4019L != null) {
            charSequence = this.f4019L.getTransformation(charSequence, this);
        }
        CharSequence charSequence2 = charSequence;
        return new StaticLayout(charSequence2, this.f4015H, charSequence2 != null ? (int) Math.ceil(Layout.getDesiredWidth(charSequence2, this.f4015H)) : 0, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
    }

    /* JADX INFO: renamed from: a */
    private boolean m4335a(float f, float f2) {
        if (this.f4023d == null) {
            return false;
        }
        int thumbOffset = getThumbOffset();
        this.f4023d.getPadding(this.f4020M);
        int i = this.f4012E - this.f4041v;
        int i2 = (this.f4011D + thumbOffset) - this.f4041v;
        return f > ((float) i2) && f < ((float) ((((this.f4010C + i2) + this.f4020M.left) + this.f4020M.right) + this.f4041v)) && f2 > ((float) i) && f2 < ((float) (this.f4014G + this.f4041v));
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f4044y.addMovement(motionEvent);
        switch (motionEvent.getActionMasked()) {
            case 0:
                float x = motionEvent.getX();
                float y = motionEvent.getY();
                if (isEnabled() && m4335a(x, y)) {
                    this.f4040u = 1;
                    this.f4042w = x;
                    this.f4043x = y;
                }
                break;
            case 1:
            case 3:
                if (this.f4040u == 2) {
                    m4337b(motionEvent);
                    super.onTouchEvent(motionEvent);
                    return true;
                }
                this.f4040u = 0;
                this.f4044y.clear();
                break;
                break;
            case 2:
                switch (this.f4040u) {
                    case 1:
                        float x2 = motionEvent.getX();
                        float y2 = motionEvent.getY();
                        if (Math.abs(x2 - this.f4042w) > this.f4041v || Math.abs(y2 - this.f4043x) > this.f4041v) {
                            this.f4040u = 2;
                            getParent().requestDisallowInterceptTouchEvent(true);
                            this.f4042w = x2;
                            this.f4043x = y2;
                            return true;
                        }
                        break;
                    case 2:
                        float x3 = motionEvent.getX();
                        int thumbScrollRange = getThumbScrollRange();
                        float f = x3 - this.f4042w;
                        float f2 = thumbScrollRange != 0 ? f / thumbScrollRange : f > 0.0f ? 1.0f : -1.0f;
                        if (C1774hl.m9679a(this)) {
                            f2 = -f2;
                        }
                        float fM4329a = m4329a(this.f4021a + f2, 0.0f, 1.0f);
                        if (fM4329a != this.f4021a) {
                            this.f4042w = x3;
                            setThumbPosition(fM4329a);
                        }
                        return true;
                }
                break;
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private void m4333a(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        motionEventObtain.setAction(3);
        super.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    /* JADX INFO: renamed from: b */
    private void m4337b(MotionEvent motionEvent) {
        boolean targetCheckedState;
        this.f4040u = 0;
        boolean z = true;
        boolean z2 = motionEvent.getAction() == 1 && isEnabled();
        boolean zIsChecked = isChecked();
        if (z2) {
            this.f4044y.computeCurrentVelocity(1000);
            float xVelocity = this.f4044y.getXVelocity();
            if (Math.abs(xVelocity) > this.f4045z) {
                if (!C1774hl.m9679a(this) ? xVelocity <= 0.0f : xVelocity >= 0.0f) {
                    z = false;
                }
                targetCheckedState = z;
            } else {
                targetCheckedState = getTargetCheckedState();
            }
        } else {
            targetCheckedState = zIsChecked;
        }
        if (targetCheckedState != zIsChecked) {
            playSoundEffect(0);
        }
        setChecked(targetCheckedState);
        m4333a(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private void m4334a(boolean z) {
        this.f4022b = ObjectAnimator.ofFloat(this, f4007c, z ? 1.0f : 0.0f);
        this.f4022b.setDuration(250L);
        if (Build.VERSION.SDK_INT >= 18) {
            this.f4022b.setAutoCancel(true);
        }
        this.f4022b.start();
    }

    /* JADX INFO: renamed from: c */
    private void m4338c() {
        if (this.f4022b != null) {
            this.f4022b.cancel();
        }
    }

    private boolean getTargetCheckedState() {
        return this.f4021a > 0.5f;
    }

    void setThumbPosition(float f) {
        this.f4021a = f;
        invalidate();
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void toggle() {
        setChecked(!isChecked());
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        super.setChecked(z);
        boolean zIsChecked = isChecked();
        if (getWindowToken() != null && ViewCompat.isLaidOut(this)) {
            m4334a(zIsChecked);
        } else {
            m4338c();
            setThumbPosition(zIsChecked ? 1.0f : 0.0f);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iMax;
        int width;
        int paddingLeft;
        int paddingTop;
        int height;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = 0;
        if (this.f4023d != null) {
            Rect rect = this.f4020M;
            if (this.f4028i != null) {
                this.f4028i.getPadding(rect);
            } else {
                rect.setEmpty();
            }
            Rect rectM9426a = C1743gh.m9426a(this.f4023d);
            int iMax2 = Math.max(0, rectM9426a.left - rect.left);
            iMax = Math.max(0, rectM9426a.right - rect.right);
            i5 = iMax2;
        } else {
            iMax = 0;
        }
        if (C1774hl.m9679a(this)) {
            paddingLeft = getPaddingLeft() + i5;
            width = ((this.f4008A + paddingLeft) - i5) - iMax;
        } else {
            width = (getWidth() - getPaddingRight()) - iMax;
            paddingLeft = (width - this.f4008A) + i5 + iMax;
        }
        int gravity = getGravity() & 112;
        if (gravity == 16) {
            paddingTop = (((getPaddingTop() + getHeight()) - getPaddingBottom()) / 2) - (this.f4009B / 2);
            height = this.f4009B + paddingTop;
        } else if (gravity != 80) {
            paddingTop = getPaddingTop();
            height = this.f4009B + paddingTop;
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = height - this.f4009B;
        }
        this.f4011D = paddingLeft;
        this.f4012E = paddingTop;
        this.f4014G = height;
        this.f4013F = width;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Rect rectM9426a;
        int i;
        int i2;
        Rect rect = this.f4020M;
        int i3 = this.f4011D;
        int i4 = this.f4012E;
        int i5 = this.f4013F;
        int i6 = this.f4014G;
        int thumbOffset = getThumbOffset() + i3;
        if (this.f4023d != null) {
            rectM9426a = C1743gh.m9426a(this.f4023d);
        } else {
            rectM9426a = C1743gh.f9966a;
        }
        if (this.f4028i != null) {
            this.f4028i.getPadding(rect);
            thumbOffset += rect.left;
            if (rectM9426a != null) {
                if (rectM9426a.left > rect.left) {
                    i3 += rectM9426a.left - rect.left;
                }
                i = rectM9426a.top > rect.top ? (rectM9426a.top - rect.top) + i4 : i4;
                if (rectM9426a.right > rect.right) {
                    i5 -= rectM9426a.right - rect.right;
                }
                if (rectM9426a.bottom > rect.bottom) {
                    i2 = i6 - (rectM9426a.bottom - rect.bottom);
                }
                this.f4028i.setBounds(i3, i, i5, i2);
            } else {
                i = i4;
            }
            i2 = i6;
            this.f4028i.setBounds(i3, i, i5, i2);
        }
        if (this.f4023d != null) {
            this.f4023d.getPadding(rect);
            int i7 = thumbOffset - rect.left;
            int i8 = thumbOffset + this.f4010C + rect.right;
            this.f4023d.setBounds(i7, i4, i8, i6);
            Drawable background = getBackground();
            if (background != null) {
                DrawableCompat.setHotspotBounds(background, i7, i4, i8, i6);
            }
        }
        super.draw(canvas);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        int width;
        super.onDraw(canvas);
        Rect rect = this.f4020M;
        Drawable drawable = this.f4028i;
        if (drawable != null) {
            drawable.getPadding(rect);
        } else {
            rect.setEmpty();
        }
        int i = this.f4012E;
        int i2 = this.f4014G;
        int i3 = i + rect.top;
        int i4 = i2 - rect.bottom;
        Drawable drawable2 = this.f4023d;
        if (drawable != null) {
            if (this.f4036q && drawable2 != null) {
                Rect rectM9426a = C1743gh.m9426a(drawable2);
                drawable2.copyBounds(rect);
                rect.left += rectM9426a.left;
                rect.right -= rectM9426a.right;
                int iSave = canvas.save();
                canvas.clipRect(rect, Region.Op.DIFFERENCE);
                drawable.draw(canvas);
                canvas.restoreToCount(iSave);
            } else {
                drawable.draw(canvas);
            }
        }
        int iSave2 = canvas.save();
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        Layout layout = getTargetCheckedState() ? this.f4017J : this.f4018K;
        if (layout != null) {
            int[] drawableState = getDrawableState();
            if (this.f4016I != null) {
                this.f4015H.setColor(this.f4016I.getColorForState(drawableState, 0));
            }
            this.f4015H.drawableState = drawableState;
            if (drawable2 != null) {
                Rect bounds = drawable2.getBounds();
                width = bounds.left + bounds.right;
            } else {
                width = getWidth();
            }
            canvas.translate((width / 2) - (layout.getWidth() / 2), ((i3 + i4) / 2) - (layout.getHeight() / 2));
            layout.draw(canvas);
        }
        canvas.restoreToCount(iSave2);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        if (!C1774hl.m9679a(this)) {
            return super.getCompoundPaddingLeft();
        }
        int compoundPaddingLeft = super.getCompoundPaddingLeft() + this.f4008A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingLeft + this.f4035p : compoundPaddingLeft;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingRight() {
        if (C1774hl.m9679a(this)) {
            return super.getCompoundPaddingRight();
        }
        int compoundPaddingRight = super.getCompoundPaddingRight() + this.f4008A;
        return !TextUtils.isEmpty(getText()) ? compoundPaddingRight + this.f4035p : compoundPaddingRight;
    }

    private int getThumbOffset() {
        float f;
        if (C1774hl.m9679a(this)) {
            f = 1.0f - this.f4021a;
        } else {
            f = this.f4021a;
        }
        return (int) ((f * getThumbScrollRange()) + 0.5f);
    }

    private int getThumbScrollRange() {
        Rect rectM9426a;
        if (this.f4028i == null) {
            return 0;
        }
        Rect rect = this.f4020M;
        this.f4028i.getPadding(rect);
        if (this.f4023d != null) {
            rectM9426a = C1743gh.m9426a(this.f4023d);
        } else {
            rectM9426a = C1743gh.f9966a;
        }
        return ((((this.f4008A - this.f4010C) - rect.left) - rect.right) - rectM9426a.left) - rectM9426a.right;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f4006N);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f4023d;
        boolean state = false;
        if (drawable != null && drawable.isStateful()) {
            state = false | drawable.setState(drawableState);
        }
        Drawable drawable2 = this.f4028i;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        if (state) {
            invalidate();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void drawableHotspotChanged(float f, float f2) {
        if (Build.VERSION.SDK_INT >= 21) {
            super.drawableHotspotChanged(f, f2);
        }
        if (this.f4023d != null) {
            DrawableCompat.setHotspot(this.f4023d, f, f2);
        }
        if (this.f4028i != null) {
            DrawableCompat.setHotspot(this.f4028i, f, f2);
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4023d || drawable == this.f4028i;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        if (this.f4023d != null) {
            this.f4023d.jumpToCurrentState();
        }
        if (this.f4028i != null) {
            this.f4028i.jumpToCurrentState();
        }
        if (this.f4022b == null || !this.f4022b.isStarted()) {
            return;
        }
        this.f4022b.end();
        this.f4022b = null;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName("android.widget.Switch");
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.Switch");
        CharSequence charSequence = isChecked() ? this.f4037r : this.f4038s;
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        CharSequence text = accessibilityNodeInfo.getText();
        if (TextUtils.isEmpty(text)) {
            accessibilityNodeInfo.setText(charSequence);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.append(' ');
        sb.append(charSequence);
        accessibilityNodeInfo.setText(sb);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }
}
