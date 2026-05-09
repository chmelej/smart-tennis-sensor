package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.MultiAutoCompleteTextView;
import p000.C1684ee;
import p000.C1724fp;
import p000.C1727fs;
import p000.C1731fw;
import p000.C1763ha;
import p000.C1766hd;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatMultiAutoCompleteTextView extends MultiAutoCompleteTextView implements TintableBackgroundView {

    /* JADX INFO: renamed from: a */
    private static final int[] f3462a = {R.attr.popupBackground};

    /* JADX INFO: renamed from: b */
    private final C1724fp f3463b;

    /* JADX INFO: renamed from: c */
    private final C1731fw f3464c;

    public AppCompatMultiAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.v7.appcompat.R.attr.autoCompleteTextViewStyle);
    }

    public AppCompatMultiAutoCompleteTextView(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        C1766hd c1766hdM9601a = C1766hd.m9601a(getContext(), attributeSet, f3462a, i, 0);
        if (c1766hdM9601a.m9620g(0)) {
            setDropDownBackgroundDrawable(c1766hdM9601a.m9605a(0));
        }
        c1766hdM9601a.m9606a();
        this.f3463b = new C1724fp(this);
        this.f3463b.m9219a(attributeSet, i);
        this.f3464c = new C1731fw(this);
        this.f3464c.m9295a(attributeSet, i);
        this.f3464c.m9290a();
    }

    @Override // android.widget.AutoCompleteTextView
    public void setDropDownBackgroundResource(int i) {
        setDropDownBackgroundDrawable(C1684ee.m8975b(getContext(), i));
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3463b != null) {
            this.f3463b.m9215a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3463b != null) {
            this.f3463b.m9218a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3463b != null) {
            this.f3463b.m9216a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3463b != null) {
            return this.f3463b.m9214a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3463b != null) {
            this.f3463b.m9217a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3463b != null) {
            return this.f3463b.m9220b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3463b != null) {
            this.f3463b.m9222c();
        }
        if (this.f3464c != null) {
            this.f3464c.m9290a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3464c != null) {
            this.f3464c.m9294a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C1727fs.m9265a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }
}
