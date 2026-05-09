package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.widget.TintableCompoundButton;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.CheckBox;
import p000.C1684ee;
import p000.C1725fq;
import p000.C1763ha;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatCheckBox extends CheckBox implements TintableCompoundButton {

    /* JADX INFO: renamed from: a */
    private final C1725fq f3453a;

    public AppCompatCheckBox(Context context) {
        this(context, null);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.checkboxStyle);
    }

    public AppCompatCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        this.f3453a = new C1725fq(this);
        this.f3453a.m9227a(attributeSet, i);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f3453a != null) {
            this.f3453a.m9229c();
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i) {
        setButtonDrawable(C1684ee.m8975b(getContext(), i));
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f3453a != null ? this.f3453a.m9223a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f3453a != null) {
            this.f3453a.m9225a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    public ColorStateList getSupportButtonTintList() {
        if (this.f3453a != null) {
            return this.f3453a.m9224a();
        }
        return null;
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        if (this.f3453a != null) {
            this.f3453a.m9226a(mode);
        }
    }

    @Override // android.support.v4.widget.TintableCompoundButton
    public PorterDuff.Mode getSupportButtonTintMode() {
        if (this.f3453a != null) {
            return this.f3453a.m9228b();
        }
        return null;
    }
}
