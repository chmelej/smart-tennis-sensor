package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.view.TintableBackgroundView;
import android.support.v4.widget.TintableImageSourceView;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.ImageButton;
import p000.C1724fp;
import p000.C1728ft;
import p000.C1763ha;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatImageButton extends ImageButton implements TintableBackgroundView, TintableImageSourceView {

    /* JADX INFO: renamed from: a */
    private final C1724fp f3458a;

    /* JADX INFO: renamed from: b */
    private final C1728ft f3459b;

    public AppCompatImageButton(Context context) {
        this(context, null);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.imageButtonStyle);
    }

    public AppCompatImageButton(Context context, AttributeSet attributeSet, int i) {
        super(C1763ha.m9596a(context), attributeSet, i);
        this.f3458a = new C1724fp(this);
        this.f3458a.m9219a(attributeSet, i);
        this.f3459b = new C1728ft(this);
        this.f3459b.m9271a(attributeSet, i);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.f3459b.m9268a(i);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        super.setImageDrawable(drawable);
        if (this.f3459b != null) {
            this.f3459b.m9275d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        if (this.f3459b != null) {
            this.f3459b.m9275d();
        }
    }

    @Override // android.widget.ImageView
    public void setImageURI(Uri uri) {
        super.setImageURI(uri);
        if (this.f3459b != null) {
            this.f3459b.m9275d();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f3458a != null) {
            this.f3458a.m9215a(i);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f3458a != null) {
            this.f3458a.m9218a(drawable);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f3458a != null) {
            this.f3458a.m9216a(colorStateList);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        if (this.f3458a != null) {
            return this.f3458a.m9214a();
        }
        return null;
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f3458a != null) {
            this.f3458a.m9217a(mode);
        }
    }

    @Override // android.support.v4.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        if (this.f3458a != null) {
            return this.f3458a.m9220b();
        }
        return null;
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f3459b != null) {
            this.f3459b.m9269a(colorStateList);
        }
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public ColorStateList getSupportImageTintList() {
        if (this.f3459b != null) {
            return this.f3459b.m9273b();
        }
        return null;
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.f3459b != null) {
            this.f3459b.m9270a(mode);
        }
    }

    @Override // android.support.v4.widget.TintableImageSourceView
    public PorterDuff.Mode getSupportImageTintMode() {
        if (this.f3459b != null) {
            return this.f3459b.m9274c();
        }
        return null;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f3458a != null) {
            this.f3458a.m9222c();
        }
        if (this.f3459b != null) {
            this.f3459b.m9275d();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public boolean hasOverlappingRendering() {
        return this.f3459b.m9272a() && super.hasOverlappingRendering();
    }
}
