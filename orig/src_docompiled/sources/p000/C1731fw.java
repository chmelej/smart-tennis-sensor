package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: fw */
/* JADX INFO: compiled from: AppCompatTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1731fw {

    /* JADX INFO: renamed from: a */
    private final TextView f9882a;

    /* JADX INFO: renamed from: b */
    private C1764hb f9883b;

    /* JADX INFO: renamed from: c */
    private C1764hb f9884c;

    /* JADX INFO: renamed from: d */
    private C1764hb f9885d;

    /* JADX INFO: renamed from: e */
    private C1764hb f9886e;

    /* JADX INFO: renamed from: f */
    private C1764hb f9887f;

    /* JADX INFO: renamed from: g */
    private C1764hb f9888g;

    /* JADX INFO: renamed from: h */
    private final C1732fx f9889h;

    /* JADX INFO: renamed from: i */
    private int f9890i = 0;

    /* JADX INFO: renamed from: j */
    private Typeface f9891j;

    /* JADX INFO: renamed from: k */
    private boolean f9892k;

    public C1731fw(TextView textView) {
        this.f9882a = textView;
        this.f9889h = new C1732fx(this.f9882a);
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public void m9295a(AttributeSet attributeSet, int i) {
        ColorStateList colorStateListM9616e;
        ColorStateList colorStateListM9616e2;
        boolean z;
        boolean zM9607a;
        Context context = this.f9882a.getContext();
        C1726fr c1726frM9237a = C1726fr.m9237a();
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, R.styleable.AppCompatTextHelper, i, 0);
        int iM9619g = c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (c1766hdM9601a.m9620g(R.styleable.AppCompatTextHelper_android_drawableLeft)) {
            this.f9883b = m9286a(context, c1726frM9237a, c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
        }
        if (c1766hdM9601a.m9620g(R.styleable.AppCompatTextHelper_android_drawableTop)) {
            this.f9884c = m9286a(context, c1726frM9237a, c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
        }
        if (c1766hdM9601a.m9620g(R.styleable.AppCompatTextHelper_android_drawableRight)) {
            this.f9885d = m9286a(context, c1726frM9237a, c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
        }
        if (c1766hdM9601a.m9620g(R.styleable.AppCompatTextHelper_android_drawableBottom)) {
            this.f9886e = m9286a(context, c1726frM9237a, c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (c1766hdM9601a.m9620g(R.styleable.AppCompatTextHelper_android_drawableStart)) {
                this.f9887f = m9286a(context, c1726frM9237a, c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
            }
            if (c1766hdM9601a.m9620g(R.styleable.AppCompatTextHelper_android_drawableEnd)) {
                this.f9888g = m9286a(context, c1726frM9237a, c1766hdM9601a.m9619g(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
            }
        }
        c1766hdM9601a.m9606a();
        boolean z2 = this.f9882a.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (iM9619g != -1) {
            C1766hd c1766hdM9599a = C1766hd.m9599a(context, iM9619g, R.styleable.TextAppearance);
            if (z2 || !c1766hdM9599a.m9620g(R.styleable.TextAppearance_textAllCaps)) {
                z = false;
                zM9607a = false;
            } else {
                zM9607a = c1766hdM9599a.m9607a(R.styleable.TextAppearance_textAllCaps, false);
                z = true;
            }
            m9287a(context, c1766hdM9599a);
            if (Build.VERSION.SDK_INT < 23) {
                ColorStateList colorStateListM9616e3 = c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textColor) ? c1766hdM9599a.m9616e(R.styleable.TextAppearance_android_textColor) : null;
                colorStateListM9616e2 = c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textColorHint) ? c1766hdM9599a.m9616e(R.styleable.TextAppearance_android_textColorHint) : null;
                ColorStateList colorStateList = colorStateListM9616e3;
                colorStateListM9616e = c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textColorLink) ? c1766hdM9599a.m9616e(R.styleable.TextAppearance_android_textColorLink) : null;
                colorStateListM9616e = colorStateList;
            } else {
                colorStateListM9616e = null;
                colorStateListM9616e2 = null;
            }
            c1766hdM9599a.m9606a();
        } else {
            colorStateListM9616e = null;
            colorStateListM9616e2 = null;
            z = false;
            zM9607a = false;
        }
        C1766hd c1766hdM9601a2 = C1766hd.m9601a(context, attributeSet, R.styleable.TextAppearance, i, 0);
        if (!z2 && c1766hdM9601a2.m9620g(R.styleable.TextAppearance_textAllCaps)) {
            zM9607a = c1766hdM9601a2.m9607a(R.styleable.TextAppearance_textAllCaps, false);
            z = true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (c1766hdM9601a2.m9620g(R.styleable.TextAppearance_android_textColor)) {
                colorStateListM9616e = c1766hdM9601a2.m9616e(R.styleable.TextAppearance_android_textColor);
            }
            if (c1766hdM9601a2.m9620g(R.styleable.TextAppearance_android_textColorHint)) {
                colorStateListM9616e2 = c1766hdM9601a2.m9616e(R.styleable.TextAppearance_android_textColorHint);
            }
            if (c1766hdM9601a2.m9620g(R.styleable.TextAppearance_android_textColorLink)) {
                colorStateListM9616e = c1766hdM9601a2.m9616e(R.styleable.TextAppearance_android_textColorLink);
            }
        }
        if (Build.VERSION.SDK_INT >= 28 && c1766hdM9601a2.m9620g(R.styleable.TextAppearance_android_textSize) && c1766hdM9601a2.m9615e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f9882a.setTextSize(0, 0.0f);
        }
        m9287a(context, c1766hdM9601a2);
        c1766hdM9601a2.m9606a();
        if (colorStateListM9616e != null) {
            this.f9882a.setTextColor(colorStateListM9616e);
        }
        if (colorStateListM9616e2 != null) {
            this.f9882a.setHintTextColor(colorStateListM9616e2);
        }
        if (colorStateListM9616e != null) {
            this.f9882a.setLinkTextColor(colorStateListM9616e);
        }
        if (!z2 && z) {
            m9297a(zM9607a);
        }
        if (this.f9891j != null) {
            this.f9882a.setTypeface(this.f9891j, this.f9890i);
        }
        this.f9889h.m9325a(attributeSet, i);
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE && this.f9889h.m9321a() != 0) {
            int[] iArrM9330e = this.f9889h.m9330e();
            if (iArrM9330e.length > 0) {
                if (this.f9882a.getAutoSizeStepGranularity() != -1.0f) {
                    this.f9882a.setAutoSizeTextTypeUniformWithConfiguration(this.f9889h.m9328c(), this.f9889h.m9329d(), this.f9889h.m9327b(), 0);
                } else {
                    this.f9882a.setAutoSizeTextTypeUniformWithPresetSizes(iArrM9330e, 0);
                }
            }
        }
        C1766hd c1766hdM9600a = C1766hd.m9600a(context, attributeSet, R.styleable.AppCompatTextView);
        int iM9615e = c1766hdM9600a.m9615e(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int iM9615e2 = c1766hdM9600a.m9615e(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int iM9615e3 = c1766hdM9600a.m9615e(R.styleable.AppCompatTextView_lineHeight, -1);
        c1766hdM9600a.m9606a();
        if (iM9615e != -1) {
            TextViewCompat.setFirstBaselineToTopHeight(this.f9882a, iM9615e);
        }
        if (iM9615e2 != -1) {
            TextViewCompat.setLastBaselineToBottomHeight(this.f9882a, iM9615e2);
        }
        if (iM9615e3 != -1) {
            TextViewCompat.setLineHeight(this.f9882a, iM9615e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9287a(Context context, C1766hd c1766hd) {
        String strM9614d;
        this.f9890i = c1766hd.m9603a(R.styleable.TextAppearance_android_textStyle, this.f9890i);
        boolean z = true;
        if (c1766hd.m9620g(R.styleable.TextAppearance_android_fontFamily) || c1766hd.m9620g(R.styleable.TextAppearance_fontFamily)) {
            this.f9891j = null;
            int i = c1766hd.m9620g(R.styleable.TextAppearance_fontFamily) ? R.styleable.TextAppearance_fontFamily : R.styleable.TextAppearance_android_fontFamily;
            if (!context.isRestricted()) {
                final WeakReference weakReference = new WeakReference(this.f9882a);
                try {
                    this.f9891j = c1766hd.m9604a(i, this.f9890i, new ResourcesCompat.FontCallback() { // from class: fw.1
                        @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                        public void onFontRetrievalFailed(int i2) {
                        }

                        @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
                        public void onFontRetrieved(Typeface typeface) {
                            C1731fw.this.m9296a(weakReference, typeface);
                        }
                    });
                    if (this.f9891j != null) {
                        z = false;
                    }
                    this.f9892k = z;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f9891j != null || (strM9614d = c1766hd.m9614d(i)) == null) {
                return;
            }
            this.f9891j = Typeface.create(strM9614d, this.f9890i);
            return;
        }
        if (c1766hd.m9620g(R.styleable.TextAppearance_android_typeface)) {
            this.f9892k = false;
            switch (c1766hd.m9603a(R.styleable.TextAppearance_android_typeface, 1)) {
                case 1:
                    this.f9891j = Typeface.SANS_SERIF;
                    break;
                case 2:
                    this.f9891j = Typeface.SERIF;
                    break;
                case 3:
                    this.f9891j = Typeface.MONOSPACE;
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    void m9296a(WeakReference<TextView> weakReference, Typeface typeface) {
        if (this.f9892k) {
            this.f9891j = typeface;
            TextView textView = weakReference.get();
            if (textView != null) {
                textView.setTypeface(typeface, this.f9890i);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9294a(Context context, int i) {
        ColorStateList colorStateListM9616e;
        C1766hd c1766hdM9599a = C1766hd.m9599a(context, i, R.styleable.TextAppearance);
        if (c1766hdM9599a.m9620g(R.styleable.TextAppearance_textAllCaps)) {
            m9297a(c1766hdM9599a.m9607a(R.styleable.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textColor) && (colorStateListM9616e = c1766hdM9599a.m9616e(R.styleable.TextAppearance_android_textColor)) != null) {
            this.f9882a.setTextColor(colorStateListM9616e);
        }
        if (c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textSize) && c1766hdM9599a.m9615e(R.styleable.TextAppearance_android_textSize, -1) == 0) {
            this.f9882a.setTextSize(0, 0.0f);
        }
        m9287a(context, c1766hdM9599a);
        c1766hdM9599a.m9606a();
        if (this.f9891j != null) {
            this.f9882a.setTypeface(this.f9891j, this.f9890i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9297a(boolean z) {
        this.f9882a.setAllCaps(z);
    }

    /* JADX INFO: renamed from: a */
    public void m9290a() {
        if (this.f9883b != null || this.f9884c != null || this.f9885d != null || this.f9886e != null) {
            Drawable[] compoundDrawables = this.f9882a.getCompoundDrawables();
            m9288a(compoundDrawables[0], this.f9883b);
            m9288a(compoundDrawables[1], this.f9884c);
            m9288a(compoundDrawables[2], this.f9885d);
            m9288a(compoundDrawables[3], this.f9886e);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            if (this.f9887f == null && this.f9888g == null) {
                return;
            }
            Drawable[] compoundDrawablesRelative = this.f9882a.getCompoundDrawablesRelative();
            m9288a(compoundDrawablesRelative[0], this.f9887f);
            m9288a(compoundDrawablesRelative[2], this.f9888g);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9288a(Drawable drawable, C1764hb c1764hb) {
        if (drawable == null || c1764hb == null) {
            return;
        }
        C1726fr.m9240a(drawable, c1764hb, this.f9882a.getDrawableState());
    }

    /* JADX INFO: renamed from: a */
    private static C1764hb m9286a(Context context, C1726fr c1726fr, int i) {
        ColorStateList colorStateListM9260b = c1726fr.m9260b(context, i);
        if (colorStateListM9260b == null) {
            return null;
        }
        C1764hb c1764hb = new C1764hb();
        c1764hb.f10141d = true;
        c1764hb.f10138a = colorStateListM9260b;
        return c1764hb;
    }

    /* JADX INFO: renamed from: a */
    public void m9298a(boolean z, int i, int i2, int i3, int i4) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE) {
            return;
        }
        m9300b();
    }

    /* JADX INFO: renamed from: a */
    public void m9292a(int i, float f) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE || m9301c()) {
            return;
        }
        m9289b(i, f);
    }

    /* JADX INFO: renamed from: b */
    public void m9300b() {
        this.f9889h.m9331f();
    }

    /* JADX INFO: renamed from: c */
    public boolean m9301c() {
        return this.f9889h.m9332g();
    }

    /* JADX INFO: renamed from: b */
    private void m9289b(int i, float f) {
        this.f9889h.m9323a(i, f);
    }

    /* JADX INFO: renamed from: a */
    public void m9291a(int i) {
        this.f9889h.m9322a(i);
    }

    /* JADX INFO: renamed from: a */
    public void m9293a(int i, int i2, int i3, int i4) {
        this.f9889h.m9324a(i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    public void m9299a(int[] iArr, int i) {
        this.f9889h.m9326a(iArr, i);
    }

    /* JADX INFO: renamed from: d */
    public int m9302d() {
        return this.f9889h.m9321a();
    }

    /* JADX INFO: renamed from: e */
    public int m9303e() {
        return this.f9889h.m9327b();
    }

    /* JADX INFO: renamed from: f */
    public int m9304f() {
        return this.f9889h.m9328c();
    }

    /* JADX INFO: renamed from: g */
    public int m9305g() {
        return this.f9889h.m9329d();
    }

    /* JADX INFO: renamed from: h */
    public int[] m9306h() {
        return this.f9889h.m9330e();
    }
}
