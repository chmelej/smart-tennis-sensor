package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import p000.C1724fp;
import p000.C1731fw;
import p000.C1763ha;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatButton extends Button implements TintableBackgroundView, AutoSizeableTextView {

    /* JADX INFO: renamed from: a */
    private final C1724fp f3451a;

    /* JADX INFO: renamed from: b */
    private final C1731fw f3452b;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.buttonStyle);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        this.f3451a = new C1724fp(this);
        this.f3451a.m9219a(attributeSet, i);
        this.f3452b = new C1731fw(this);
        this.f3452b.m9295a(attributeSet, i);
        this.f3452b.m9290a();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3451a != null) {
            this.f3451a.m9215a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3451a != null) {
            this.f3451a.m9218a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3451a != null) {
            this.f3451a.m9216a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3451a != null) {
            return this.f3451a.m9214a();
        }
        return null;
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3451a != null) {
            this.f3451a.m9217a(mode);
        }
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3451a != null) {
            return this.f3451a.m9220b();
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3451a != null) {
            this.f3451a.m9222c();
        }
        if (this.f3452b != null) {
            this.f3452b.m9290a();
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3452b != null) {
            this.f3452b.m9294a(context, i);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3452b != null) {
            this.f3452b.m9298a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setTextSize(i, f);
        } else if (this.f3452b != null) {
            this.f3452b.m9292a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f3452b == null || PLATFORM_SUPPORTS_AUTOSIZE || !this.f3452b.m9301c()) {
            return;
        }
        this.f3452b.m9300b();
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f3452b != null) {
            this.f3452b.m9291a(i);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f3452b != null) {
            this.f3452b.m9293a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f3452b != null) {
            this.f3452b.m9299a(iArr, i);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeTextType() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f3452b != null) {
            return this.f3452b.m9302d();
        }
        return 0;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeStepGranularity() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f3452b != null) {
            return this.f3452b.m9303e();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeMinTextSize() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f3452b != null) {
            return this.f3452b.m9304f();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeMaxTextSize() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f3452b != null) {
            return this.f3452b.m9305g();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f3452b != null) {
            return this.f3452b.m9306h();
        }
        return new int[0];
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f3452b != null) {
            this.f3452b.m9297a(z);
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }
}
