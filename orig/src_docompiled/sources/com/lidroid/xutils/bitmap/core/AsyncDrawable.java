package com.lidroid.xutils.bitmap.core;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.lidroid.xutils.BitmapUtils;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes.dex */
public class AsyncDrawable<T extends View> extends Drawable {
    private final Drawable baseDrawable;
    private final WeakReference<BitmapUtils.BitmapLoadTask<T>> bitmapLoadTaskReference;

    public AsyncDrawable(Drawable drawable, BitmapUtils.BitmapLoadTask<T> bitmapLoadTask) {
        if (bitmapLoadTask == null) {
            throw new IllegalArgumentException("bitmapWorkerTask may not be null");
        }
        this.baseDrawable = drawable;
        this.bitmapLoadTaskReference = new WeakReference<>(bitmapLoadTask);
    }

    public BitmapUtils.BitmapLoadTask<T> getBitmapWorkerTask() {
        return this.bitmapLoadTaskReference.get();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.baseDrawable != null) {
            this.baseDrawable.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.baseDrawable == null) {
            return 127;
        }
        return this.baseDrawable.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setBounds(i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setChangingConfigurations(int i) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setChangingConfigurations(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setDither(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setFilterBitmap(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.baseDrawable != null) {
            this.baseDrawable.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.baseDrawable != null) {
            this.baseDrawable.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.baseDrawable != null) {
            this.baseDrawable.unscheduleSelf(runnable);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(int i, PorterDuff.Mode mode) {
        if (this.baseDrawable != null) {
            this.baseDrawable.setColorFilter(i, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void clearColorFilter() {
        if (this.baseDrawable != null) {
            this.baseDrawable.clearColorFilter();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.baseDrawable != null && this.baseDrawable.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setState(int[] iArr) {
        return this.baseDrawable != null && this.baseDrawable.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable
    public int[] getState() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return this.baseDrawable != null && this.baseDrawable.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getTransparentRegion();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.baseDrawable == null) {
            return 0;
        }
        return this.baseDrawable.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.baseDrawable != null && this.baseDrawable.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.mutate();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.baseDrawable == null) {
            return null;
        }
        return this.baseDrawable.getConstantState();
    }
}
