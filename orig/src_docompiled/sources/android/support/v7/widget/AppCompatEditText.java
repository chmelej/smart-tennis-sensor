package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import p000.C1724fp;
import p000.C1727fs;
import p000.C1731fw;
import p000.C1763ha;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatEditText extends EditText implements TintableBackgroundView {

    /* JADX INFO: renamed from: a */
    private final C1724fp f3456a;

    /* JADX INFO: renamed from: b */
    private final C1731fw f3457b;

    public AppCompatEditText(Context context) {
        this(context, null);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public AppCompatEditText(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        this.f3456a = new C1724fp(this);
        this.f3456a.m9219a(attributeSet, i);
        this.f3457b = new C1731fw(this);
        this.f3457b.m9295a(attributeSet, i);
        this.f3457b.m9290a();
    }

    @Override // android.widget.EditText, android.widget.TextView
    public Editable getText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return super.getText();
        }
        return super.getEditableText();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3456a != null) {
            this.f3456a.m9215a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3456a != null) {
            this.f3456a.m9218a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3456a != null) {
            this.f3456a.m9216a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3456a != null) {
            return this.f3456a.m9214a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3456a != null) {
            this.f3456a.m9217a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3456a != null) {
            return this.f3456a.m9220b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3456a != null) {
            this.f3456a.m9222c();
        }
        if (this.f3457b != null) {
            this.f3457b.m9290a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3457b != null) {
            this.f3457b.m9294a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C1727fs.m9265a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }
}
