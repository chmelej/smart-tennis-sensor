package android.support.v7.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.text.PrecomputedTextCompat;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.AutoSizeableTextView;
import android.support.v4.widget.TextViewCompat;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import p000.C1724fp;
import p000.C1727fs;
import p000.C1731fw;
import p000.C1763ha;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatTextView extends TextView implements TintableBackgroundView, AutoSizeableTextView {

    /* JADX INFO: renamed from: a */
    private final C1724fp f3493a;

    /* JADX INFO: renamed from: b */
    private final C1731fw f3494b;

    /* JADX INFO: renamed from: c */
    private Future<PrecomputedTextCompat> f3495c;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        this.f3493a = new C1724fp(this);
        this.f3493a.m9219a(attributeSet, i);
        this.f3494b = new C1731fw(this);
        this.f3494b.m9295a(attributeSet, i);
        this.f3494b.m9290a();
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3493a != null) {
            this.f3493a.m9215a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3493a != null) {
            this.f3493a.m9218a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3493a != null) {
            this.f3493a.m9216a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3493a != null) {
            return this.f3493a.m9214a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3493a != null) {
            this.f3493a.m9217a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3493a != null) {
            return this.f3493a.m9220b();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f3494b != null) {
            this.f3494b.m9294a(context, i);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3493a != null) {
            this.f3493a.m9222c();
        }
        if (this.f3494b != null) {
            this.f3494b.m9290a();
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f3494b != null) {
            this.f3494b.m9298a(z, i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView
    public void setTextSize(int i, float f) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setTextSize(i, f);
        } else if (this.f3494b != null) {
            this.f3494b.m9292a(i, f);
        }
    }

    @Override // android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (this.f3494b == null || PLATFORM_SUPPORTS_AUTOSIZE || !this.f3494b.m9301c()) {
            return;
        }
        this.f3494b.m9300b();
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeWithDefaults(int i) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeWithDefaults(i);
        } else if (this.f3494b != null) {
            this.f3494b.m9291a(i);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithConfiguration(int i, int i2, int i3, int i4) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i, i2, i3, i4);
        } else if (this.f3494b != null) {
            this.f3494b.m9293a(i, i2, i3, i4);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i) {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i);
        } else if (this.f3494b != null) {
            this.f3494b.m9299a(iArr, i);
        }
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeTextType() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        if (this.f3494b != null) {
            return this.f3494b.m9302d();
        }
        return 0;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeStepGranularity() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeStepGranularity();
        }
        if (this.f3494b != null) {
            return this.f3494b.m9303e();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeMinTextSize() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMinTextSize();
        }
        if (this.f3494b != null) {
            return this.f3494b.m9304f();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int getAutoSizeMaxTextSize() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeMaxTextSize();
        }
        if (this.f3494b != null) {
            return this.f3494b.m9305g();
        }
        return -1;
    }

    @Override // android.widget.TextView, android.support.v4.widget.AutoSizeableTextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (PLATFORM_SUPPORTS_AUTOSIZE) {
            return super.getAutoSizeTextAvailableSizes();
        }
        if (this.f3494b != null) {
            return this.f3494b.m9306h();
        }
        return new int[0];
    }

    @Override // android.widget.TextView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return C1727fs.m9265a(super.onCreateInputConnection(editorInfo), editorInfo, this);
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setFirstBaselineToTopHeight(i);
        } else {
            TextViewCompat.setFirstBaselineToTopHeight(this, i);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            super.setLastBaselineToBottomHeight(i);
        } else {
            TextViewCompat.setLastBaselineToBottomHeight(this, i);
        }
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return TextViewCompat.getFirstBaselineToTopHeight(this);
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return TextViewCompat.getLastBaselineToBottomHeight(this);
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i) {
        TextViewCompat.setLineHeight(this, i);
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(TextViewCompat.wrapCustomSelectionActionModeCallback(this, callback));
    }

    public PrecomputedTextCompat.Params getTextMetricsParamsCompat() {
        return TextViewCompat.getTextMetricsParams(this);
    }

    public void setTextMetricsParamsCompat(PrecomputedTextCompat.Params params) {
        TextViewCompat.setTextMetricsParams(this, params);
    }

    public void setPrecomputedText(PrecomputedTextCompat precomputedTextCompat) {
        TextViewCompat.setPrecomputedText(this, precomputedTextCompat);
    }

    /* JADX INFO: renamed from: a */
    private void m3511a() {
        if (this.f3495c != null) {
            try {
                Future<PrecomputedTextCompat> future = this.f3495c;
                this.f3495c = null;
                TextViewCompat.setPrecomputedText(this, future.get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        m3511a();
        return super.getText();
    }

    public void setTextFuture(Future<PrecomputedTextCompat> future) {
        this.f3495c = future;
        requestLayout();
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        m3511a();
        super.onMeasure(i, i2);
    }
}
