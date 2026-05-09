package p000;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.widget.CompoundButtonCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.CompoundButton;

/* JADX INFO: renamed from: fq */
/* JADX INFO: compiled from: AppCompatCompoundButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1725fq {

    /* JADX INFO: renamed from: a */
    private final CompoundButton f9848a;

    /* JADX INFO: renamed from: b */
    private ColorStateList f9849b = null;

    /* JADX INFO: renamed from: c */
    private PorterDuff.Mode f9850c = null;

    /* JADX INFO: renamed from: d */
    private boolean f9851d = false;

    /* JADX INFO: renamed from: e */
    private boolean f9852e = false;

    /* JADX INFO: renamed from: f */
    private boolean f9853f;

    public C1725fq(CompoundButton compoundButton) {
        this.f9848a = compoundButton;
    }

    /* JADX INFO: renamed from: a */
    public void m9227a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray typedArrayObtainStyledAttributes = this.f9848a.getContext().obtainStyledAttributes(attributeSet, R.styleable.CompoundButton, i, 0);
        try {
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_android_button) && (resourceId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.CompoundButton_android_button, 0)) != 0) {
                this.f9848a.setButtonDrawable(C1684ee.m8975b(this.f9848a.getContext(), resourceId));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTint)) {
                CompoundButtonCompat.setButtonTintList(this.f9848a, typedArrayObtainStyledAttributes.getColorStateList(R.styleable.CompoundButton_buttonTint));
            }
            if (typedArrayObtainStyledAttributes.hasValue(R.styleable.CompoundButton_buttonTintMode)) {
                CompoundButtonCompat.setButtonTintMode(this.f9848a, C1743gh.m9425a(typedArrayObtainStyledAttributes.getInt(R.styleable.CompoundButton_buttonTintMode, -1), null));
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9225a(ColorStateList colorStateList) {
        this.f9849b = colorStateList;
        this.f9851d = true;
        m9230d();
    }

    /* JADX INFO: renamed from: a */
    public ColorStateList m9224a() {
        return this.f9849b;
    }

    /* JADX INFO: renamed from: a */
    public void m9226a(PorterDuff.Mode mode) {
        this.f9850c = mode;
        this.f9852e = true;
        m9230d();
    }

    /* JADX INFO: renamed from: b */
    public PorterDuff.Mode m9228b() {
        return this.f9850c;
    }

    /* JADX INFO: renamed from: c */
    public void m9229c() {
        if (this.f9853f) {
            this.f9853f = false;
        } else {
            this.f9853f = true;
            m9230d();
        }
    }

    /* JADX INFO: renamed from: d */
    void m9230d() {
        Drawable buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f9848a);
        if (buttonDrawable != null) {
            if (this.f9851d || this.f9852e) {
                Drawable drawableMutate = DrawableCompat.wrap(buttonDrawable).mutate();
                if (this.f9851d) {
                    DrawableCompat.setTintList(drawableMutate, this.f9849b);
                }
                if (this.f9852e) {
                    DrawableCompat.setTintMode(drawableMutate, this.f9850c);
                }
                if (drawableMutate.isStateful()) {
                    drawableMutate.setState(this.f9848a.getDrawableState());
                }
                this.f9848a.setButtonDrawable(drawableMutate);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m9223a(int i) {
        Drawable buttonDrawable;
        return (Build.VERSION.SDK_INT >= 17 || (buttonDrawable = CompoundButtonCompat.getButtonDrawable(this.f9848a)) == null) ? i : i + buttonDrawable.getIntrinsicWidth();
    }
}
