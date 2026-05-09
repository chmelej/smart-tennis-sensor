package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.support.design.R;
import android.support.design.widget.TextInputLayout;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.Space;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: bn */
/* JADX INFO: compiled from: IndicatorViewController.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0772bn {

    /* JADX INFO: renamed from: a */
    private final Context f5241a;

    /* JADX INFO: renamed from: b */
    private final TextInputLayout f5242b;

    /* JADX INFO: renamed from: c */
    private LinearLayout f5243c;

    /* JADX INFO: renamed from: d */
    private int f5244d;

    /* JADX INFO: renamed from: e */
    private FrameLayout f5245e;

    /* JADX INFO: renamed from: f */
    private int f5246f;

    /* JADX INFO: renamed from: g */
    private Animator f5247g;

    /* JADX INFO: renamed from: h */
    private final float f5248h;

    /* JADX INFO: renamed from: i */
    private int f5249i;

    /* JADX INFO: renamed from: j */
    private int f5250j;

    /* JADX INFO: renamed from: k */
    private CharSequence f5251k;

    /* JADX INFO: renamed from: l */
    private boolean f5252l;

    /* JADX INFO: renamed from: m */
    private TextView f5253m;

    /* JADX INFO: renamed from: n */
    private int f5254n;

    /* JADX INFO: renamed from: o */
    private CharSequence f5255o;

    /* JADX INFO: renamed from: p */
    private boolean f5256p;

    /* JADX INFO: renamed from: q */
    private TextView f5257q;

    /* JADX INFO: renamed from: r */
    private int f5258r;

    /* JADX INFO: renamed from: s */
    private Typeface f5259s;

    /* JADX INFO: renamed from: a */
    boolean m5652a(int i) {
        return i == 0 || i == 1;
    }

    public C0772bn(TextInputLayout textInputLayout) {
        this.f5241a = textInputLayout.getContext();
        this.f5242b = textInputLayout;
        this.f5248h = this.f5241a.getResources().getDimensionPixelSize(R.dimen.design_textinput_caption_translate_y);
    }

    /* JADX INFO: renamed from: a */
    public void m5650a(CharSequence charSequence) {
        m5659c();
        this.f5255o = charSequence;
        this.f5257q.setText(charSequence);
        if (this.f5249i != 2) {
            this.f5250j = 2;
        }
        m5638a(this.f5249i, this.f5250j, m5642a(this.f5257q, charSequence));
    }

    /* JADX INFO: renamed from: a */
    void m5646a() {
        m5659c();
        if (this.f5249i == 2) {
            this.f5250j = 0;
        }
        m5638a(this.f5249i, this.f5250j, m5642a(this.f5257q, (CharSequence) null));
    }

    /* JADX INFO: renamed from: b */
    public void m5657b(CharSequence charSequence) {
        m5659c();
        this.f5251k = charSequence;
        this.f5253m.setText(charSequence);
        if (this.f5249i != 1) {
            this.f5250j = 1;
        }
        m5638a(this.f5249i, this.f5250j, m5642a(this.f5253m, charSequence));
    }

    /* JADX INFO: renamed from: b */
    public void m5653b() {
        this.f5251k = null;
        m5659c();
        if (this.f5249i == 1) {
            if (this.f5256p && !TextUtils.isEmpty(this.f5255o)) {
                this.f5250j = 2;
            } else {
                this.f5250j = 0;
            }
        }
        m5638a(this.f5249i, this.f5250j, m5642a(this.f5253m, (CharSequence) null));
    }

    /* JADX INFO: renamed from: a */
    private boolean m5642a(TextView textView, CharSequence charSequence) {
        return ViewCompat.isLaidOut(this.f5242b) && this.f5242b.isEnabled() && !(this.f5250j == this.f5249i && textView != null && TextUtils.equals(textView.getText(), charSequence));
    }

    /* JADX INFO: renamed from: a */
    private void m5638a(final int i, final int i2, boolean z) {
        if (z) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f5247g = animatorSet;
            ArrayList arrayList = new ArrayList();
            m5641a(arrayList, this.f5256p, this.f5257q, 2, i, i2);
            m5641a(arrayList, this.f5252l, this.f5253m, 1, i, i2);
            C2205w.m12083a(animatorSet, arrayList);
            final TextView textViewM5643d = m5643d(i);
            final TextView textViewM5643d2 = m5643d(i2);
            animatorSet.addListener(new AnimatorListenerAdapter() { // from class: bn.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C0772bn.this.f5249i = i2;
                    C0772bn.this.f5247g = null;
                    if (textViewM5643d != null) {
                        textViewM5643d.setVisibility(4);
                        if (i != 1 || C0772bn.this.f5253m == null) {
                            return;
                        }
                        C0772bn.this.f5253m.setText((CharSequence) null);
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    if (textViewM5643d2 != null) {
                        textViewM5643d2.setVisibility(0);
                    }
                }
            });
            animatorSet.start();
        } else {
            m5637a(i, i2);
        }
        this.f5242b.m2922c();
        this.f5242b.m2918a(z);
        this.f5242b.m2923d();
    }

    /* JADX INFO: renamed from: a */
    private void m5637a(int i, int i2) {
        TextView textViewM5643d;
        TextView textViewM5643d2;
        if (i == i2) {
            return;
        }
        if (i2 != 0 && (textViewM5643d2 = m5643d(i2)) != null) {
            textViewM5643d2.setVisibility(0);
            textViewM5643d2.setAlpha(1.0f);
        }
        if (i != 0 && (textViewM5643d = m5643d(i)) != null) {
            textViewM5643d.setVisibility(4);
            if (i == 1) {
                textViewM5643d.setText((CharSequence) null);
            }
        }
        this.f5249i = i2;
    }

    /* JADX INFO: renamed from: a */
    private void m5641a(List<Animator> list, boolean z, TextView textView, int i, int i2, int i3) {
        if (textView == null || !z) {
            return;
        }
        if (i == i3 || i == i2) {
            list.add(m5635a(textView, i3 == i));
            if (i3 == i) {
                list.add(m5634a(textView));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m5635a(TextView textView, boolean z) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.ALPHA, z ? 1.0f : 0.0f);
        objectAnimatorOfFloat.setDuration(167L);
        objectAnimatorOfFloat.setInterpolator(C2178v.f12999a);
        return objectAnimatorOfFloat;
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m5634a(TextView textView) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(textView, (Property<TextView, Float>) View.TRANSLATION_Y, -this.f5248h, 0.0f);
        objectAnimatorOfFloat.setDuration(217L);
        objectAnimatorOfFloat.setInterpolator(C2178v.f13002d);
        return objectAnimatorOfFloat;
    }

    /* JADX INFO: renamed from: c */
    void m5659c() {
        if (this.f5247g != null) {
            this.f5247g.cancel();
        }
    }

    /* JADX INFO: renamed from: d */
    private TextView m5643d(int i) {
        switch (i) {
            case 1:
                return this.f5253m;
            case 2:
                return this.f5257q;
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: d */
    public void m5661d() {
        if (m5645m()) {
            ViewCompat.setPaddingRelative(this.f5243c, ViewCompat.getPaddingStart(this.f5242b.getEditText()), 0, ViewCompat.getPaddingEnd(this.f5242b.getEditText()), 0);
        }
    }

    /* JADX INFO: renamed from: m */
    private boolean m5645m() {
        return (this.f5243c == null || this.f5242b.getEditText() == null) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public void m5649a(TextView textView, int i) {
        if (this.f5243c == null && this.f5245e == null) {
            this.f5243c = new LinearLayout(this.f5241a);
            this.f5243c.setOrientation(0);
            this.f5242b.addView(this.f5243c, -1, -2);
            this.f5245e = new FrameLayout(this.f5241a);
            this.f5243c.addView(this.f5245e, -1, new FrameLayout.LayoutParams(-2, -2));
            this.f5243c.addView(new Space(this.f5241a), new LinearLayout.LayoutParams(0, 0, 1.0f));
            if (this.f5242b.getEditText() != null) {
                m5661d();
            }
        }
        if (m5652a(i)) {
            this.f5245e.setVisibility(0);
            this.f5245e.addView(textView);
            this.f5246f++;
        } else {
            this.f5243c.addView(textView, i);
        }
        this.f5243c.setVisibility(0);
        this.f5244d++;
    }

    /* JADX INFO: renamed from: b */
    public void m5656b(TextView textView, int i) {
        if (this.f5243c == null) {
            return;
        }
        if (m5652a(i) && this.f5245e != null) {
            this.f5246f--;
            m5639a(this.f5245e, this.f5246f);
            this.f5245e.removeView(textView);
        } else {
            this.f5243c.removeView(textView);
        }
        this.f5244d--;
        m5639a(this.f5243c, this.f5244d);
    }

    /* JADX INFO: renamed from: a */
    private void m5639a(ViewGroup viewGroup, int i) {
        if (i == 0) {
            viewGroup.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5651a(boolean z) {
        if (this.f5252l == z) {
            return;
        }
        m5659c();
        if (z) {
            this.f5253m = new AppCompatTextView(this.f5241a);
            this.f5253m.setId(R.id.textinput_error);
            if (this.f5259s != null) {
                this.f5253m.setTypeface(this.f5259s);
            }
            m5654b(this.f5254n);
            this.f5253m.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f5253m, 1);
            m5649a(this.f5253m, 0);
        } else {
            m5653b();
            m5656b(this.f5253m, 0);
            this.f5253m = null;
            this.f5242b.m2922c();
            this.f5242b.m2923d();
        }
        this.f5252l = z;
    }

    /* JADX INFO: renamed from: e */
    public boolean m5662e() {
        return this.f5252l;
    }

    /* JADX INFO: renamed from: f */
    public boolean m5663f() {
        return this.f5256p;
    }

    /* JADX INFO: renamed from: b */
    public void m5658b(boolean z) {
        if (this.f5256p == z) {
            return;
        }
        m5659c();
        if (z) {
            this.f5257q = new AppCompatTextView(this.f5241a);
            this.f5257q.setId(R.id.textinput_helper_text);
            if (this.f5259s != null) {
                this.f5257q.setTypeface(this.f5259s);
            }
            this.f5257q.setVisibility(4);
            ViewCompat.setAccessibilityLiveRegion(this.f5257q, 1);
            m5660c(this.f5258r);
            m5649a(this.f5257q, 1);
        } else {
            m5646a();
            m5656b(this.f5257q, 1);
            this.f5257q = null;
            this.f5242b.m2922c();
            this.f5242b.m2923d();
        }
        this.f5256p = z;
    }

    /* JADX INFO: renamed from: g */
    public boolean m5664g() {
        return m5644e(this.f5250j);
    }

    /* JADX INFO: renamed from: e */
    private boolean m5644e(int i) {
        return (i != 1 || this.f5253m == null || TextUtils.isEmpty(this.f5251k)) ? false : true;
    }

    /* JADX INFO: renamed from: h */
    public CharSequence m5665h() {
        return this.f5251k;
    }

    /* JADX INFO: renamed from: i */
    public CharSequence m5666i() {
        return this.f5255o;
    }

    /* JADX INFO: renamed from: a */
    public void m5648a(Typeface typeface) {
        if (typeface != this.f5259s) {
            this.f5259s = typeface;
            m5640a(this.f5253m, typeface);
            m5640a(this.f5257q, typeface);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5640a(TextView textView, Typeface typeface) {
        if (textView != null) {
            textView.setTypeface(typeface);
        }
    }

    /* JADX INFO: renamed from: j */
    public int m5667j() {
        if (this.f5253m != null) {
            return this.f5253m.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: renamed from: k */
    public ColorStateList m5668k() {
        if (this.f5253m != null) {
            return this.f5253m.getTextColors();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m5647a(ColorStateList colorStateList) {
        if (this.f5253m != null) {
            this.f5253m.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5654b(int i) {
        this.f5254n = i;
        if (this.f5253m != null) {
            this.f5242b.m2917a(this.f5253m, i);
        }
    }

    /* JADX INFO: renamed from: l */
    public int m5669l() {
        if (this.f5257q != null) {
            return this.f5257q.getCurrentTextColor();
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public void m5655b(ColorStateList colorStateList) {
        if (this.f5257q != null) {
            this.f5257q.setTextColor(colorStateList);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5660c(int i) {
        this.f5258r = i;
        if (this.f5257q != null) {
            TextViewCompat.setTextAppearance(this.f5257q, i);
        }
    }
}
