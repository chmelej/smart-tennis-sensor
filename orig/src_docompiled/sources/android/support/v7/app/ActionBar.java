package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import p000.AbstractC1694em;

/* JADX INFO: loaded from: classes.dex */
public abstract class ActionBar {

    /* JADX INFO: renamed from: android.support.v7.app.ActionBar$a */
    public interface InterfaceC0524a {
        /* JADX INFO: renamed from: a */
        void m3148a(boolean z);
    }

    /* JADX INFO: renamed from: android.support.v7.app.ActionBar$b */
    @Deprecated
    public static abstract class AbstractC0525b {
        /* JADX INFO: renamed from: a */
        public abstract Drawable m3149a();

        /* JADX INFO: renamed from: b */
        public abstract CharSequence m3150b();

        /* JADX INFO: renamed from: c */
        public abstract View m3151c();

        /* JADX INFO: renamed from: d */
        public abstract void m3152d();

        /* JADX INFO: renamed from: e */
        public abstract CharSequence m3153e();
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo3128a();

    /* JADX INFO: renamed from: a */
    public AbstractC1694em mo3129a(AbstractC1694em.a aVar) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo3131a(Configuration configuration) {
    }

    /* JADX INFO: renamed from: a */
    public void mo3132a(CharSequence charSequence) {
    }

    /* JADX INFO: renamed from: a */
    public void mo3133a(boolean z) {
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3134a(int i, KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean mo3135a(KeyEvent keyEvent) {
        return false;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo3136b();

    /* JADX INFO: renamed from: c */
    public abstract void mo3138c();

    /* JADX INFO: renamed from: c */
    public void mo3139c(boolean z) {
    }

    /* JADX INFO: renamed from: d */
    public Context mo3140d() {
        return null;
    }

    /* JADX INFO: renamed from: d */
    public void mo3141d(boolean z) {
    }

    /* JADX INFO: renamed from: e */
    public void mo3142e(boolean z) {
    }

    /* JADX INFO: renamed from: e */
    public boolean mo3143e() {
        return false;
    }

    /* JADX INFO: renamed from: f */
    public boolean mo3144f() {
        return false;
    }

    /* JADX INFO: renamed from: g */
    public boolean mo3145g() {
        return false;
    }

    /* JADX INFO: renamed from: h */
    public boolean mo3146h() {
        return false;
    }

    /* JADX INFO: renamed from: i */
    public void mo3147i() {
    }

    /* JADX INFO: renamed from: b */
    public void mo3137b(boolean z) {
        if (z) {
            throw new UnsupportedOperationException("Hide on content scroll is not supported in this action bar configuration.");
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo3130a(float f) {
        if (f != 0.0f) {
            throw new UnsupportedOperationException("Setting a non-zero elevation is not supported in this action bar configuration.");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a */
        public int f2966a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2966a = 0;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ActionBarLayout);
            this.f2966a = typedArrayObtainStyledAttributes.getInt(R.styleable.ActionBarLayout_android_layout_gravity, 0);
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f2966a = 0;
            this.f2966a = 8388627;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((ViewGroup.MarginLayoutParams) layoutParams);
            this.f2966a = 0;
            this.f2966a = layoutParams.f2966a;
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.f2966a = 0;
        }
    }
}
