package android.support.design.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.AbsSavedState;
import android.support.v4.view.AccessibilityDelegateCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.view.accessibility.AccessibilityEvent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import p000.C0751at;
import p000.C0752au;
import p000.C0766bh;
import p000.C0767bi;
import p000.C0768bj;
import p000.C0769bk;
import p000.C0772bn;
import p000.C1684ee;
import p000.C1726fr;
import p000.C1743gh;
import p000.C1766hd;
import p000.C2178v;

/* JADX INFO: loaded from: classes.dex */
public class TextInputLayout extends LinearLayout {

    /* JADX INFO: renamed from: A */
    private int f2627A;

    /* JADX INFO: renamed from: B */
    private int f2628B;

    /* JADX INFO: renamed from: C */
    private Drawable f2629C;

    /* JADX INFO: renamed from: D */
    private final Rect f2630D;

    /* JADX INFO: renamed from: E */
    private final RectF f2631E;

    /* JADX INFO: renamed from: F */
    private Typeface f2632F;

    /* JADX INFO: renamed from: G */
    private boolean f2633G;

    /* JADX INFO: renamed from: H */
    private Drawable f2634H;

    /* JADX INFO: renamed from: I */
    private CharSequence f2635I;

    /* JADX INFO: renamed from: J */
    private CheckableImageButton f2636J;

    /* JADX INFO: renamed from: K */
    private boolean f2637K;

    /* JADX INFO: renamed from: L */
    private Drawable f2638L;

    /* JADX INFO: renamed from: M */
    private Drawable f2639M;

    /* JADX INFO: renamed from: N */
    private ColorStateList f2640N;

    /* JADX INFO: renamed from: O */
    private boolean f2641O;

    /* JADX INFO: renamed from: P */
    private PorterDuff.Mode f2642P;

    /* JADX INFO: renamed from: Q */
    private boolean f2643Q;

    /* JADX INFO: renamed from: R */
    private ColorStateList f2644R;

    /* JADX INFO: renamed from: S */
    private ColorStateList f2645S;

    /* JADX INFO: renamed from: T */
    private final int f2646T;

    /* JADX INFO: renamed from: U */
    private final int f2647U;

    /* JADX INFO: renamed from: V */
    private int f2648V;

    /* JADX INFO: renamed from: W */
    private final int f2649W;

    /* JADX INFO: renamed from: a */
    EditText f2650a;

    /* JADX INFO: renamed from: aa */
    private boolean f2651aa;

    /* JADX INFO: renamed from: ab */
    private boolean f2652ab;

    /* JADX INFO: renamed from: ac */
    private ValueAnimator f2653ac;

    /* JADX INFO: renamed from: ad */
    private boolean f2654ad;

    /* JADX INFO: renamed from: ae */
    private boolean f2655ae;

    /* JADX INFO: renamed from: af */
    private boolean f2656af;

    /* JADX INFO: renamed from: b */
    boolean f2657b;

    /* JADX INFO: renamed from: c */
    final C0766bh f2658c;

    /* JADX INFO: renamed from: d */
    private final FrameLayout f2659d;

    /* JADX INFO: renamed from: e */
    private CharSequence f2660e;

    /* JADX INFO: renamed from: f */
    private final C0772bn f2661f;

    /* JADX INFO: renamed from: g */
    private int f2662g;

    /* JADX INFO: renamed from: h */
    private boolean f2663h;

    /* JADX INFO: renamed from: i */
    private TextView f2664i;

    /* JADX INFO: renamed from: j */
    private final int f2665j;

    /* JADX INFO: renamed from: k */
    private final int f2666k;

    /* JADX INFO: renamed from: l */
    private boolean f2667l;

    /* JADX INFO: renamed from: m */
    private CharSequence f2668m;

    /* JADX INFO: renamed from: n */
    private boolean f2669n;

    /* JADX INFO: renamed from: o */
    private GradientDrawable f2670o;

    /* JADX INFO: renamed from: p */
    private final int f2671p;

    /* JADX INFO: renamed from: q */
    private final int f2672q;

    /* JADX INFO: renamed from: r */
    private int f2673r;

    /* JADX INFO: renamed from: s */
    private final int f2674s;

    /* JADX INFO: renamed from: t */
    private float f2675t;

    /* JADX INFO: renamed from: u */
    private float f2676u;

    /* JADX INFO: renamed from: v */
    private float f2677v;

    /* JADX INFO: renamed from: w */
    private float f2678w;

    /* JADX INFO: renamed from: x */
    private int f2679x;

    /* JADX INFO: renamed from: y */
    private final int f2680y;

    /* JADX INFO: renamed from: z */
    private final int f2681z;

    public TextInputLayout(Context context) {
        this(context, null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2661f = new C0772bn(this);
        this.f2630D = new Rect();
        this.f2631E = new RectF();
        this.f2658c = new C0766bh(this);
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        this.f2659d = new FrameLayout(context);
        this.f2659d.setAddStatesFromChildren(true);
        addView(this.f2659d);
        this.f2658c.m5539a(C2178v.f12999a);
        this.f2658c.m5550b(C2178v.f12999a);
        this.f2658c.m5548b(8388659);
        C1766hd c1766hdM5395b = C0751at.m5395b(context, attributeSet, R.styleable.TextInputLayout, i, R.style.Widget_Design_TextInputLayout, new int[0]);
        this.f2667l = c1766hdM5395b.m9607a(R.styleable.TextInputLayout_hintEnabled, true);
        setHint(c1766hdM5395b.m9612c(R.styleable.TextInputLayout_android_hint));
        this.f2652ab = c1766hdM5395b.m9607a(R.styleable.TextInputLayout_hintAnimationEnabled, true);
        this.f2671p = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_bottom_offset);
        this.f2672q = context.getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        this.f2674s = c1766hdM5395b.m9613d(R.styleable.TextInputLayout_boxCollapsedPaddingTop, 0);
        this.f2675t = c1766hdM5395b.m9608b(R.styleable.TextInputLayout_boxCornerRadiusTopStart, 0.0f);
        this.f2676u = c1766hdM5395b.m9608b(R.styleable.TextInputLayout_boxCornerRadiusTopEnd, 0.0f);
        this.f2677v = c1766hdM5395b.m9608b(R.styleable.TextInputLayout_boxCornerRadiusBottomEnd, 0.0f);
        this.f2678w = c1766hdM5395b.m9608b(R.styleable.TextInputLayout_boxCornerRadiusBottomStart, 0.0f);
        this.f2628B = c1766hdM5395b.m9609b(R.styleable.TextInputLayout_boxBackgroundColor, 0);
        this.f2648V = c1766hdM5395b.m9609b(R.styleable.TextInputLayout_boxStrokeColor, 0);
        this.f2680y = context.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_default);
        this.f2681z = context.getResources().getDimensionPixelSize(R.dimen.mtrl_textinput_box_stroke_width_focused);
        this.f2679x = this.f2680y;
        setBoxBackgroundMode(c1766hdM5395b.m9603a(R.styleable.TextInputLayout_boxBackgroundMode, 0));
        if (c1766hdM5395b.m9620g(R.styleable.TextInputLayout_android_textColorHint)) {
            ColorStateList colorStateListM9616e = c1766hdM5395b.m9616e(R.styleable.TextInputLayout_android_textColorHint);
            this.f2645S = colorStateListM9616e;
            this.f2644R = colorStateListM9616e;
        }
        this.f2646T = ContextCompat.getColor(context, R.color.mtrl_textinput_default_box_stroke_color);
        this.f2649W = ContextCompat.getColor(context, R.color.mtrl_textinput_disabled_color);
        this.f2647U = ContextCompat.getColor(context, R.color.mtrl_textinput_hovered_box_stroke_color);
        if (c1766hdM5395b.m9619g(R.styleable.TextInputLayout_hintTextAppearance, -1) != -1) {
            setHintTextAppearance(c1766hdM5395b.m9619g(R.styleable.TextInputLayout_hintTextAppearance, 0));
        }
        int iM9619g = c1766hdM5395b.m9619g(R.styleable.TextInputLayout_errorTextAppearance, 0);
        boolean zM9607a = c1766hdM5395b.m9607a(R.styleable.TextInputLayout_errorEnabled, false);
        int iM9619g2 = c1766hdM5395b.m9619g(R.styleable.TextInputLayout_helperTextTextAppearance, 0);
        boolean zM9607a2 = c1766hdM5395b.m9607a(R.styleable.TextInputLayout_helperTextEnabled, false);
        CharSequence charSequenceM9612c = c1766hdM5395b.m9612c(R.styleable.TextInputLayout_helperText);
        boolean zM9607a3 = c1766hdM5395b.m9607a(R.styleable.TextInputLayout_counterEnabled, false);
        setCounterMaxLength(c1766hdM5395b.m9603a(R.styleable.TextInputLayout_counterMaxLength, -1));
        this.f2666k = c1766hdM5395b.m9619g(R.styleable.TextInputLayout_counterTextAppearance, 0);
        this.f2665j = c1766hdM5395b.m9619g(R.styleable.TextInputLayout_counterOverflowTextAppearance, 0);
        this.f2633G = c1766hdM5395b.m9607a(R.styleable.TextInputLayout_passwordToggleEnabled, false);
        this.f2634H = c1766hdM5395b.m9605a(R.styleable.TextInputLayout_passwordToggleDrawable);
        this.f2635I = c1766hdM5395b.m9612c(R.styleable.TextInputLayout_passwordToggleContentDescription);
        if (c1766hdM5395b.m9620g(R.styleable.TextInputLayout_passwordToggleTint)) {
            this.f2641O = true;
            this.f2640N = c1766hdM5395b.m9616e(R.styleable.TextInputLayout_passwordToggleTint);
        }
        if (c1766hdM5395b.m9620g(R.styleable.TextInputLayout_passwordToggleTintMode)) {
            this.f2643Q = true;
            this.f2642P = C0752au.m5475a(c1766hdM5395b.m9603a(R.styleable.TextInputLayout_passwordToggleTintMode, -1), null);
        }
        c1766hdM5395b.m9606a();
        setHelperTextEnabled(zM9607a2);
        setHelperText(charSequenceM9612c);
        setHelperTextTextAppearance(iM9619g2);
        setErrorEnabled(zM9607a);
        setErrorTextAppearance(iM9619g);
        setCounterEnabled(zM9607a3);
        m2911s();
        ViewCompat.setImportantForAccessibility(this, 2);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & (-113)) | 16;
            this.f2659d.addView(view, layoutParams2);
            this.f2659d.setLayoutParams(layoutParams);
            m2899g();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    private Drawable getBoxBackground() {
        if (this.f2673r == 1 || this.f2673r == 2) {
            return this.f2670o;
        }
        throw new IllegalStateException();
    }

    public void setBoxBackgroundMode(int i) {
        if (i == this.f2673r) {
            return;
        }
        this.f2673r = i;
        m2897e();
    }

    /* JADX INFO: renamed from: e */
    private void m2897e() {
        m2898f();
        if (this.f2673r != 0) {
            m2899g();
        }
        m2900h();
    }

    /* JADX INFO: renamed from: f */
    private void m2898f() {
        if (this.f2673r == 0) {
            this.f2670o = null;
            return;
        }
        if (this.f2673r == 2 && this.f2667l && !(this.f2670o instanceof C0767bi)) {
            this.f2670o = new C0767bi();
        } else {
            if (this.f2670o instanceof GradientDrawable) {
                return;
            }
            this.f2670o = new GradientDrawable();
        }
    }

    public void setBoxStrokeColor(int i) {
        if (this.f2648V != i) {
            this.f2648V = i;
            m2923d();
        }
    }

    public int getBoxStrokeColor() {
        return this.f2648V;
    }

    public void setBoxBackgroundColorResource(int i) {
        setBoxBackgroundColor(ContextCompat.getColor(getContext(), i));
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f2628B != i) {
            this.f2628B = i;
            m2906n();
        }
    }

    public int getBoxBackgroundColor() {
        return this.f2628B;
    }

    public void setBoxCornerRadiiResources(int i, int i2, int i3, int i4) {
        setBoxCornerRadii(getContext().getResources().getDimension(i), getContext().getResources().getDimension(i2), getContext().getResources().getDimension(i3), getContext().getResources().getDimension(i4));
    }

    public void setBoxCornerRadii(float f, float f2, float f3, float f4) {
        if (this.f2675t == f && this.f2676u == f2 && this.f2677v == f4 && this.f2678w == f3) {
            return;
        }
        this.f2675t = f;
        this.f2676u = f2;
        this.f2677v = f4;
        this.f2678w = f3;
        m2906n();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.f2675t;
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.f2676u;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.f2677v;
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.f2678w;
    }

    private float[] getCornerRadiiAsArray() {
        if (!C0752au.m5476a(this)) {
            return new float[]{this.f2675t, this.f2675t, this.f2676u, this.f2676u, this.f2677v, this.f2677v, this.f2678w, this.f2678w};
        }
        return new float[]{this.f2676u, this.f2676u, this.f2675t, this.f2675t, this.f2678w, this.f2678w, this.f2677v, this.f2677v};
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.f2632F) {
            this.f2632F = typeface;
            this.f2658c.m5555c(typeface);
            this.f2661f.m5648a(typeface);
            if (this.f2664i != null) {
                this.f2664i.setTypeface(typeface);
            }
        }
    }

    public Typeface getTypeface() {
        return this.f2632F;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i) {
        if (this.f2660e == null || this.f2650a == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i);
            return;
        }
        boolean z = this.f2669n;
        this.f2669n = false;
        CharSequence hint = this.f2650a.getHint();
        this.f2650a.setHint(this.f2660e);
        try {
            super.dispatchProvideAutofillStructure(viewStructure, i);
        } finally {
            this.f2650a.setHint(hint);
            this.f2669n = z;
        }
    }

    private void setEditText(EditText editText) {
        if (this.f2650a != null) {
            throw new IllegalArgumentException("We already have an EditText, can only have one");
        }
        if (!(editText instanceof TextInputEditText)) {
            Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
        }
        this.f2650a = editText;
        m2897e();
        setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
        if (!m2909q()) {
            this.f2658c.m5555c(this.f2650a.getTypeface());
        }
        this.f2658c.m5536a(this.f2650a.getTextSize());
        int gravity = this.f2650a.getGravity();
        this.f2658c.m5548b((gravity & (-113)) | 48);
        this.f2658c.m5537a(gravity);
        this.f2650a.addTextChangedListener(new TextWatcher() { // from class: android.support.design.widget.TextInputLayout.1
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
                TextInputLayout.this.m2918a(!TextInputLayout.this.f2656af);
                if (TextInputLayout.this.f2657b) {
                    TextInputLayout.this.m2916a(editable.length());
                }
            }
        });
        if (this.f2644R == null) {
            this.f2644R = this.f2650a.getHintTextColors();
        }
        if (this.f2667l) {
            if (TextUtils.isEmpty(this.f2668m)) {
                this.f2660e = this.f2650a.getHint();
                setHint(this.f2660e);
                this.f2650a.setHint((CharSequence) null);
            }
            this.f2669n = true;
        }
        if (this.f2664i != null) {
            m2916a(this.f2650a.getText().length());
        }
        this.f2661f.m5661d();
        m2908p();
        m2893a(false, true);
    }

    /* JADX INFO: renamed from: g */
    private void m2899g() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f2659d.getLayoutParams();
        int iM2902j = m2902j();
        if (iM2902j != layoutParams.topMargin) {
            layoutParams.topMargin = iM2902j;
            this.f2659d.requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2918a(boolean z) {
        m2893a(z, false);
    }

    /* JADX INFO: renamed from: a */
    private void m2893a(boolean z, boolean z2) {
        boolean zIsEnabled = isEnabled();
        boolean z3 = false;
        boolean z4 = (this.f2650a == null || TextUtils.isEmpty(this.f2650a.getText())) ? false : true;
        if (this.f2650a != null && this.f2650a.hasFocus()) {
            z3 = true;
        }
        boolean zM5664g = this.f2661f.m5664g();
        if (this.f2644R != null) {
            this.f2658c.m5540a(this.f2644R);
            this.f2658c.m5551b(this.f2644R);
        }
        if (!zIsEnabled) {
            this.f2658c.m5540a(ColorStateList.valueOf(this.f2649W));
            this.f2658c.m5551b(ColorStateList.valueOf(this.f2649W));
        } else if (zM5664g) {
            this.f2658c.m5540a(this.f2661f.m5668k());
        } else if (this.f2663h && this.f2664i != null) {
            this.f2658c.m5540a(this.f2664i.getTextColors());
        } else if (z3 && this.f2645S != null) {
            this.f2658c.m5540a(this.f2645S);
        }
        if (z4 || (isEnabled() && (z3 || zM5664g))) {
            if (z2 || this.f2651aa) {
                m2895c(z);
                return;
            }
            return;
        }
        if (z2 || !this.f2651aa) {
            m2896d(z);
        }
    }

    public EditText getEditText() {
        return this.f2650a;
    }

    public void setHint(CharSequence charSequence) {
        if (this.f2667l) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (TextUtils.equals(charSequence, this.f2668m)) {
            return;
        }
        this.f2668m = charSequence;
        this.f2658c.m5544a(charSequence);
        if (this.f2651aa) {
            return;
        }
        m2913u();
    }

    public CharSequence getHint() {
        if (this.f2667l) {
            return this.f2668m;
        }
        return null;
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f2667l) {
            this.f2667l = z;
            if (!this.f2667l) {
                this.f2669n = false;
                if (!TextUtils.isEmpty(this.f2668m) && TextUtils.isEmpty(this.f2650a.getHint())) {
                    this.f2650a.setHint(this.f2668m);
                }
                setHintInternal(null);
            } else {
                CharSequence hint = this.f2650a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f2668m)) {
                        setHint(hint);
                    }
                    this.f2650a.setHint((CharSequence) null);
                }
                this.f2669n = true;
            }
            if (this.f2650a != null) {
                m2899g();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    boolean m2919a() {
        return this.f2669n;
    }

    public void setHintTextAppearance(int i) {
        this.f2658c.m5554c(i);
        this.f2645S = this.f2658c.m5566m();
        if (this.f2650a != null) {
            m2918a(false);
            m2899g();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f2644R = colorStateList;
        this.f2645S = colorStateList;
        if (this.f2650a != null) {
            m2918a(false);
        }
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f2644R;
    }

    public void setErrorEnabled(boolean z) {
        this.f2661f.m5651a(z);
    }

    public void setErrorTextAppearance(int i) {
        this.f2661f.m5654b(i);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f2661f.m5647a(colorStateList);
    }

    public int getErrorCurrentTextColors() {
        return this.f2661f.m5667j();
    }

    public void setHelperTextTextAppearance(int i) {
        this.f2661f.m5660c(i);
    }

    public void setHelperTextEnabled(boolean z) {
        this.f2661f.m5658b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            if (m2921b()) {
                setHelperTextEnabled(false);
            }
        } else {
            if (!m2921b()) {
                setHelperTextEnabled(true);
            }
            this.f2661f.m5650a(charSequence);
        }
    }

    /* JADX INFO: renamed from: b */
    public boolean m2921b() {
        return this.f2661f.m5663f();
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f2661f.m5655b(colorStateList);
    }

    public int getHelperTextCurrentTextColor() {
        return this.f2661f.m5669l();
    }

    public void setError(CharSequence charSequence) {
        if (!this.f2661f.m5662e()) {
            if (TextUtils.isEmpty(charSequence)) {
                return;
            } else {
                setErrorEnabled(true);
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f2661f.m5657b(charSequence);
        } else {
            this.f2661f.m5653b();
        }
    }

    public void setCounterEnabled(boolean z) {
        if (this.f2657b != z) {
            if (z) {
                this.f2664i = new AppCompatTextView(getContext());
                this.f2664i.setId(R.id.textinput_counter);
                if (this.f2632F != null) {
                    this.f2664i.setTypeface(this.f2632F);
                }
                this.f2664i.setMaxLines(1);
                m2917a(this.f2664i, this.f2666k);
                this.f2661f.m5649a(this.f2664i, 2);
                if (this.f2650a == null) {
                    m2916a(0);
                } else {
                    m2916a(this.f2650a.getText().length());
                }
            } else {
                this.f2661f.m5656b(this.f2664i, 2);
                this.f2664i = null;
            }
            this.f2657b = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f2662g != i) {
            if (i > 0) {
                this.f2662g = i;
            } else {
                this.f2662g = -1;
            }
            if (this.f2657b) {
                m2916a(this.f2650a == null ? 0 : this.f2650a.getText().length());
            }
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        m2892a(this, z);
        super.setEnabled(z);
    }

    /* JADX INFO: renamed from: a */
    private static void m2892a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m2892a((ViewGroup) childAt, z);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f2662g;
    }

    CharSequence getCounterOverflowDescription() {
        if (this.f2657b && this.f2663h && this.f2664i != null) {
            return this.f2664i.getContentDescription();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    void m2916a(int i) {
        boolean z = this.f2663h;
        if (this.f2662g == -1) {
            this.f2664i.setText(String.valueOf(i));
            this.f2664i.setContentDescription(null);
            this.f2663h = false;
        } else {
            if (ViewCompat.getAccessibilityLiveRegion(this.f2664i) == 1) {
                ViewCompat.setAccessibilityLiveRegion(this.f2664i, 0);
            }
            this.f2663h = i > this.f2662g;
            if (z != this.f2663h) {
                m2917a(this.f2664i, this.f2663h ? this.f2665j : this.f2666k);
                if (this.f2663h) {
                    ViewCompat.setAccessibilityLiveRegion(this.f2664i, 1);
                }
            }
            this.f2664i.setText(getContext().getString(R.string.character_counter_pattern, Integer.valueOf(i), Integer.valueOf(this.f2662g)));
            this.f2664i.setContentDescription(getContext().getString(R.string.character_counter_content_description, Integer.valueOf(i), Integer.valueOf(this.f2662g)));
        }
        if (this.f2650a == null || z == this.f2663h) {
            return;
        }
        m2918a(false);
        m2923d();
        m2922c();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0018  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m2917a(android.widget.TextView r3, int r4) {
        /*
            r2 = this;
            r0 = 1
            android.support.v4.widget.TextViewCompat.setTextAppearance(r3, r4)     // Catch: java.lang.Exception -> L19
            int r4 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Exception -> L19
            r1 = 23
            if (r4 < r1) goto L18
            android.content.res.ColorStateList r4 = r3.getTextColors()     // Catch: java.lang.Exception -> L19
            int r4 = r4.getDefaultColor()     // Catch: java.lang.Exception -> L19
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            if (r4 != r1) goto L18
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto L2d
            int r4 = android.support.design.R.style.TextAppearance_AppCompat_Caption
            android.support.v4.widget.TextViewCompat.setTextAppearance(r3, r4)
            android.content.Context r4 = r2.getContext()
            int r0 = android.support.design.R.color.design_error
            int r4 = android.support.v4.content.ContextCompat.getColor(r4, r0)
            r3.setTextColor(r4)
        L2d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.TextInputLayout.m2917a(android.widget.TextView, int):void");
    }

    /* JADX INFO: renamed from: h */
    private void m2900h() {
        if (this.f2673r == 0 || this.f2670o == null || this.f2650a == null || getRight() == 0) {
            return;
        }
        int left = this.f2650a.getLeft();
        int iM2901i = m2901i();
        int right = this.f2650a.getRight();
        int bottom = this.f2650a.getBottom() + this.f2671p;
        if (this.f2673r == 2) {
            left += this.f2681z / 2;
            iM2901i -= this.f2681z / 2;
            right -= this.f2681z / 2;
            bottom += this.f2681z / 2;
        }
        this.f2670o.setBounds(left, iM2901i, right, bottom);
        m2906n();
        m2904l();
    }

    /* JADX INFO: renamed from: i */
    private int m2901i() {
        if (this.f2650a == null) {
            return 0;
        }
        switch (this.f2673r) {
        }
        return 0;
    }

    /* JADX INFO: renamed from: j */
    private int m2902j() {
        if (!this.f2667l) {
            return 0;
        }
        switch (this.f2673r) {
        }
        return 0;
    }

    /* JADX INFO: renamed from: k */
    private int m2903k() {
        switch (this.f2673r) {
            case 1:
                return getBoxBackground().getBounds().top + this.f2674s;
            case 2:
                return getBoxBackground().getBounds().top - m2902j();
            default:
                return getPaddingTop();
        }
    }

    /* JADX INFO: renamed from: l */
    private void m2904l() {
        Drawable background;
        if (this.f2650a == null || (background = this.f2650a.getBackground()) == null) {
            return;
        }
        if (C1743gh.m9428c(background)) {
            background = background.mutate();
        }
        C0768bj.m5578b(this, this.f2650a, new Rect());
        Rect bounds = background.getBounds();
        if (bounds.left != bounds.right) {
            Rect rect = new Rect();
            background.getPadding(rect);
            background.setBounds(bounds.left - rect.left, bounds.top, bounds.right + (rect.right * 2), this.f2650a.getBottom());
        }
    }

    /* JADX INFO: renamed from: m */
    private void m2905m() {
        switch (this.f2673r) {
            case 1:
                this.f2679x = 0;
                break;
            case 2:
                if (this.f2648V == 0) {
                    this.f2648V = this.f2645S.getColorForState(getDrawableState(), this.f2645S.getDefaultColor());
                }
                break;
        }
    }

    /* JADX INFO: renamed from: n */
    private void m2906n() {
        if (this.f2670o == null) {
            return;
        }
        m2905m();
        if (this.f2650a != null && this.f2673r == 2) {
            if (this.f2650a.getBackground() != null) {
                this.f2629C = this.f2650a.getBackground();
            }
            ViewCompat.setBackground(this.f2650a, null);
        }
        if (this.f2650a != null && this.f2673r == 1 && this.f2629C != null) {
            ViewCompat.setBackground(this.f2650a, this.f2629C);
        }
        if (this.f2679x > -1 && this.f2627A != 0) {
            this.f2670o.setStroke(this.f2679x, this.f2627A);
        }
        this.f2670o.setCornerRadii(getCornerRadiiAsArray());
        this.f2670o.setColor(this.f2628B);
        invalidate();
    }

    /* JADX INFO: renamed from: c */
    public void m2922c() {
        Drawable background;
        if (this.f2650a == null || (background = this.f2650a.getBackground()) == null) {
            return;
        }
        m2907o();
        if (C1743gh.m9428c(background)) {
            background = background.mutate();
        }
        if (this.f2661f.m5664g()) {
            background.setColorFilter(C1726fr.m9233a(this.f2661f.m5667j(), PorterDuff.Mode.SRC_IN));
        } else if (this.f2663h && this.f2664i != null) {
            background.setColorFilter(C1726fr.m9233a(this.f2664i.getCurrentTextColor(), PorterDuff.Mode.SRC_IN));
        } else {
            DrawableCompat.clearColorFilter(background);
            this.f2650a.refreshDrawableState();
        }
    }

    /* JADX INFO: renamed from: o */
    private void m2907o() {
        Drawable background;
        int i = Build.VERSION.SDK_INT;
        if ((i != 21 && i != 22) || (background = this.f2650a.getBackground()) == null || this.f2654ad) {
            return;
        }
        Drawable drawableNewDrawable = background.getConstantState().newDrawable();
        if (background instanceof DrawableContainer) {
            this.f2654ad = C0769bk.m5579a((DrawableContainer) background, drawableNewDrawable.getConstantState());
        }
        if (this.f2654ad) {
            return;
        }
        ViewCompat.setBackground(this.f2650a, drawableNewDrawable);
        this.f2654ad = true;
        m2897e();
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: android.support.design.widget.TextInputLayout.SavedState.1
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
        CharSequence f2686a;

        /* JADX INFO: renamed from: b */
        boolean f2687b;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f2686a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f2687b = parcel.readInt() == 1;
        }

        @Override // android.support.v4.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.f2686a, parcel, i);
            parcel.writeInt(this.f2687b ? 1 : 0);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + ((Object) this.f2686a) + "}";
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f2661f.m5664g()) {
            savedState.f2686a = getError();
        }
        savedState.f2687b = this.f2637K;
        return savedState;
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.f2686a);
        if (savedState.f2687b) {
            m2920b(true);
        }
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f2656af = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f2656af = false;
    }

    public CharSequence getError() {
        if (this.f2661f.m5662e()) {
            return this.f2661f.m5665h();
        }
        return null;
    }

    public CharSequence getHelperText() {
        if (this.f2661f.m5663f()) {
            return this.f2661f.m5666i();
        }
        return null;
    }

    public void setHintAnimationEnabled(boolean z) {
        this.f2652ab = z;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f2670o != null) {
            this.f2670o.draw(canvas);
        }
        super.draw(canvas);
        if (this.f2667l) {
            this.f2658c.m5541a(canvas);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        m2908p();
        super.onMeasure(i, i2);
    }

    /* JADX INFO: renamed from: p */
    private void m2908p() {
        if (this.f2650a == null) {
            return;
        }
        if (m2910r()) {
            if (this.f2636J == null) {
                this.f2636J = (CheckableImageButton) LayoutInflater.from(getContext()).inflate(R.layout.design_text_input_password_icon, (ViewGroup) this.f2659d, false);
                this.f2636J.setImageDrawable(this.f2634H);
                this.f2636J.setContentDescription(this.f2635I);
                this.f2659d.addView(this.f2636J);
                this.f2636J.setOnClickListener(new View.OnClickListener() { // from class: android.support.design.widget.TextInputLayout.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        TextInputLayout.this.m2920b(false);
                    }
                });
            }
            if (this.f2650a != null && ViewCompat.getMinimumHeight(this.f2650a) <= 0) {
                this.f2650a.setMinimumHeight(ViewCompat.getMinimumHeight(this.f2636J));
            }
            this.f2636J.setVisibility(0);
            this.f2636J.setChecked(this.f2637K);
            if (this.f2638L == null) {
                this.f2638L = new ColorDrawable();
            }
            this.f2638L.setBounds(0, 0, this.f2636J.getMeasuredWidth(), 1);
            Drawable[] compoundDrawablesRelative = TextViewCompat.getCompoundDrawablesRelative(this.f2650a);
            if (compoundDrawablesRelative[2] != this.f2638L) {
                this.f2639M = compoundDrawablesRelative[2];
            }
            TextViewCompat.setCompoundDrawablesRelative(this.f2650a, compoundDrawablesRelative[0], compoundDrawablesRelative[1], this.f2638L, compoundDrawablesRelative[3]);
            this.f2636J.setPadding(this.f2650a.getPaddingLeft(), this.f2650a.getPaddingTop(), this.f2650a.getPaddingRight(), this.f2650a.getPaddingBottom());
            return;
        }
        if (this.f2636J != null && this.f2636J.getVisibility() == 0) {
            this.f2636J.setVisibility(8);
        }
        if (this.f2638L != null) {
            Drawable[] compoundDrawablesRelative2 = TextViewCompat.getCompoundDrawablesRelative(this.f2650a);
            if (compoundDrawablesRelative2[2] == this.f2638L) {
                TextViewCompat.setCompoundDrawablesRelative(this.f2650a, compoundDrawablesRelative2[0], compoundDrawablesRelative2[1], this.f2639M, compoundDrawablesRelative2[3]);
                this.f2638L = null;
            }
        }
    }

    public void setPasswordVisibilityToggleDrawable(int i) {
        setPasswordVisibilityToggleDrawable(i != 0 ? C1684ee.m8975b(getContext(), i) : null);
    }

    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f2634H = drawable;
        if (this.f2636J != null) {
            this.f2636J.setImageDrawable(drawable);
        }
    }

    public void setPasswordVisibilityToggleContentDescription(int i) {
        setPasswordVisibilityToggleContentDescription(i != 0 ? getResources().getText(i) : null);
    }

    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f2635I = charSequence;
        if (this.f2636J != null) {
            this.f2636J.setContentDescription(charSequence);
        }
    }

    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f2634H;
    }

    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f2635I;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (this.f2633G != z) {
            this.f2633G = z;
            if (!z && this.f2637K && this.f2650a != null) {
                this.f2650a.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
            this.f2637K = false;
            m2908p();
        }
    }

    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f2640N = colorStateList;
        this.f2641O = true;
        m2911s();
    }

    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f2642P = mode;
        this.f2643Q = true;
        m2911s();
    }

    /* JADX INFO: renamed from: b */
    public void m2920b(boolean z) {
        if (this.f2633G) {
            int selectionEnd = this.f2650a.getSelectionEnd();
            if (m2909q()) {
                this.f2650a.setTransformationMethod(null);
                this.f2637K = true;
            } else {
                this.f2650a.setTransformationMethod(PasswordTransformationMethod.getInstance());
                this.f2637K = false;
            }
            this.f2636J.setChecked(this.f2637K);
            if (z) {
                this.f2636J.jumpDrawablesToCurrentState();
            }
            this.f2650a.setSelection(selectionEnd);
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        if (this.f2650a != null) {
            ViewCompat.setAccessibilityDelegate(this.f2650a, accessibilityDelegate);
        }
    }

    /* JADX INFO: renamed from: q */
    private boolean m2909q() {
        return this.f2650a != null && (this.f2650a.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* JADX INFO: renamed from: r */
    private boolean m2910r() {
        return this.f2633G && (m2909q() || this.f2637K);
    }

    /* JADX INFO: renamed from: s */
    private void m2911s() {
        if (this.f2634H != null) {
            if (this.f2641O || this.f2643Q) {
                this.f2634H = DrawableCompat.wrap(this.f2634H).mutate();
                if (this.f2641O) {
                    DrawableCompat.setTintList(this.f2634H, this.f2640N);
                }
                if (this.f2643Q) {
                    DrawableCompat.setTintMode(this.f2634H, this.f2642P);
                }
                if (this.f2636J == null || this.f2636J.getDrawable() == this.f2634H) {
                    return;
                }
                this.f2636J.setImageDrawable(this.f2634H);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f2670o != null) {
            m2900h();
        }
        if (!this.f2667l || this.f2650a == null) {
            return;
        }
        Rect rect = this.f2630D;
        C0768bj.m5578b(this, this.f2650a, rect);
        int compoundPaddingLeft = rect.left + this.f2650a.getCompoundPaddingLeft();
        int compoundPaddingRight = rect.right - this.f2650a.getCompoundPaddingRight();
        int iM2903k = m2903k();
        this.f2658c.m5538a(compoundPaddingLeft, rect.top + this.f2650a.getCompoundPaddingTop(), compoundPaddingRight, rect.bottom - this.f2650a.getCompoundPaddingBottom());
        this.f2658c.m5549b(compoundPaddingLeft, iM2903k, compoundPaddingRight, (i4 - i2) - getPaddingBottom());
        this.f2658c.m5564k();
        if (!m2912t() || this.f2651aa) {
            return;
        }
        m2913u();
    }

    /* JADX INFO: renamed from: c */
    private void m2895c(boolean z) {
        if (this.f2653ac != null && this.f2653ac.isRunning()) {
            this.f2653ac.cancel();
        }
        if (z && this.f2652ab) {
            m2915a(1.0f);
        } else {
            this.f2658c.m5547b(1.0f);
        }
        this.f2651aa = false;
        if (m2912t()) {
            m2913u();
        }
    }

    /* JADX INFO: renamed from: t */
    private boolean m2912t() {
        return this.f2667l && !TextUtils.isEmpty(this.f2668m) && (this.f2670o instanceof C0767bi);
    }

    /* JADX INFO: renamed from: u */
    private void m2913u() {
        if (m2912t()) {
            RectF rectF = this.f2631E;
            this.f2658c.m5542a(rectF);
            m2891a(rectF);
            ((C0767bi) this.f2670o).m5573a(rectF);
        }
    }

    /* JADX INFO: renamed from: v */
    private void m2914v() {
        if (m2912t()) {
            ((C0767bi) this.f2670o).m5575b();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2891a(RectF rectF) {
        rectF.left -= this.f2672q;
        rectF.top -= this.f2672q;
        rectF.right += this.f2672q;
        rectF.bottom += this.f2672q;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void drawableStateChanged() {
        if (this.f2655ae) {
            return;
        }
        this.f2655ae = true;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        m2918a(ViewCompat.isLaidOut(this) && isEnabled());
        m2922c();
        m2900h();
        m2923d();
        if (this.f2658c != null ? this.f2658c.m5545a(drawableState) | false : false) {
            invalidate();
        }
        this.f2655ae = false;
    }

    /* JADX INFO: renamed from: d */
    public void m2923d() {
        if (this.f2670o == null || this.f2673r == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = this.f2650a != null && this.f2650a.hasFocus();
        if (this.f2650a != null && this.f2650a.isHovered()) {
            z = true;
        }
        if (this.f2673r == 2) {
            if (!isEnabled()) {
                this.f2627A = this.f2649W;
            } else if (this.f2661f.m5664g()) {
                this.f2627A = this.f2661f.m5667j();
            } else if (this.f2663h && this.f2664i != null) {
                this.f2627A = this.f2664i.getCurrentTextColor();
            } else if (z2) {
                this.f2627A = this.f2648V;
            } else if (z) {
                this.f2627A = this.f2647U;
            } else {
                this.f2627A = this.f2646T;
            }
            if ((z || z2) && isEnabled()) {
                this.f2679x = this.f2681z;
            } else {
                this.f2679x = this.f2680y;
            }
            m2906n();
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2896d(boolean z) {
        if (this.f2653ac != null && this.f2653ac.isRunning()) {
            this.f2653ac.cancel();
        }
        if (z && this.f2652ab) {
            m2915a(0.0f);
        } else {
            this.f2658c.m5547b(0.0f);
        }
        if (m2912t() && ((C0767bi) this.f2670o).m5574a()) {
            m2914v();
        }
        this.f2651aa = true;
    }

    /* JADX INFO: renamed from: a */
    void m2915a(float f) {
        if (this.f2658c.m5562i() == f) {
            return;
        }
        if (this.f2653ac == null) {
            this.f2653ac = new ValueAnimator();
            this.f2653ac.setInterpolator(C2178v.f13000b);
            this.f2653ac.setDuration(167L);
            this.f2653ac.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.widget.TextInputLayout.3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    TextInputLayout.this.f2658c.m5547b(((Float) valueAnimator.getAnimatedValue()).floatValue());
                }
            });
        }
        this.f2653ac.setFloatValues(this.f2658c.m5562i(), f);
        this.f2653ac.start();
    }

    final int getHintCurrentCollapsedTextColor() {
        return this.f2658c.m5563j();
    }

    final float getHintCollapsedTextHeight() {
        return this.f2658c.m5546b();
    }

    final int getErrorTextCurrentColor() {
        return this.f2661f.m5667j();
    }

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {

        /* JADX INFO: renamed from: a */
        private final TextInputLayout f2685a;

        public AccessibilityDelegate(TextInputLayout textInputLayout) {
            this.f2685a = textInputLayout;
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.f2685a.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.f2685a.getHint();
            CharSequence error = this.f2685a.getError();
            CharSequence counterOverflowDescription = this.f2685a.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !TextUtils.isEmpty(error);
            boolean z4 = false;
            boolean z5 = z3 || !TextUtils.isEmpty(counterOverflowDescription);
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (z2) {
                accessibilityNodeInfoCompat.setText(hint);
            }
            if (z2) {
                accessibilityNodeInfoCompat.setHintText(hint);
                if (!z && z2) {
                    z4 = true;
                }
                accessibilityNodeInfoCompat.setShowingHintText(z4);
            }
            if (z5) {
                if (!z3) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
                accessibilityNodeInfoCompat.setContentInvalid(true);
            }
        }

        @Override // android.support.v4.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            EditText editText = this.f2685a.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            if (TextUtils.isEmpty(text)) {
                text = this.f2685a.getHint();
            }
            if (TextUtils.isEmpty(text)) {
                return;
            }
            accessibilityEvent.getText().add(text);
        }
    }
}
