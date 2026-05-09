package p000;

import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;

/* JADX INFO: renamed from: cb */
/* JADX INFO: compiled from: VectorDrawableCommon.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0787cb extends Drawable implements TintAwareDrawable {

    /* JADX INFO: renamed from: c */
    public Drawable f5320c;

    protected AbstractC0787cb() {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.f5320c != null) {
            this.f5320c.setColorFilter(i, mode);
        } else {
            super.setColorFilter(i, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        if (this.f5320c != null) {
            return DrawableCompat.getColorFilter(this.f5320c);
        }
        return null;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.f5320c != null) {
            return this.f5320c.setLevel(i);
        }
        return super.onLevelChange(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f5320c != null) {
            this.f5320c.setBounds(rect);
        } else {
            super.onBoundsChange(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.f5320c != null) {
            DrawableCompat.setHotspot(this.f5320c, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f5320c != null) {
            DrawableCompat.setHotspotBounds(this.f5320c, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        if (this.f5320c != null) {
            this.f5320c.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        if (this.f5320c != null) {
            DrawableCompat.jumpToCurrentState(this.f5320c);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f5320c != null) {
            DrawableCompat.applyTheme(this.f5320c, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        if (this.f5320c != null) {
            this.f5320c.clearColorFilter();
        } else {
            super.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        if (this.f5320c != null) {
            return this.f5320c.getCurrent();
        }
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f5320c != null) {
            return this.f5320c.getMinimumWidth();
        }
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f5320c != null) {
            return this.f5320c.getMinimumHeight();
        }
        return super.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.f5320c != null) {
            return this.f5320c.getPadding(rect);
        }
        return super.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        if (this.f5320c != null) {
            return this.f5320c.getState();
        }
        return super.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        if (this.f5320c != null) {
            return this.f5320c.getTransparentRegion();
        }
        return super.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        if (this.f5320c != null) {
            this.f5320c.setChangingConfigurations(i);
        } else {
            super.setChangingConfigurations(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        if (this.f5320c != null) {
            return this.f5320c.setState(iArr);
        }
        return super.setState(iArr);
    }
}
