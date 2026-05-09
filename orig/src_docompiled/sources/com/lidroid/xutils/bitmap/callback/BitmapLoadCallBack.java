package com.lidroid.xutils.bitmap.callback;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.lidroid.xutils.bitmap.BitmapDisplayConfig;

/* JADX INFO: loaded from: classes.dex */
public abstract class BitmapLoadCallBack<T extends View> {
    private BitmapSetter<T> bitmapSetter;

    public abstract void onLoadCompleted(T t, String str, Bitmap bitmap, BitmapDisplayConfig bitmapDisplayConfig, BitmapLoadFrom bitmapLoadFrom);

    public abstract void onLoadFailed(T t, String str, Drawable drawable);

    public void onLoadStarted(T t, String str, BitmapDisplayConfig bitmapDisplayConfig) {
    }

    public void onLoading(T t, String str, BitmapDisplayConfig bitmapDisplayConfig, long j, long j2) {
    }

    public void onPreLoad(T t, String str, BitmapDisplayConfig bitmapDisplayConfig) {
    }

    public void setBitmapSetter(BitmapSetter<T> bitmapSetter) {
        this.bitmapSetter = bitmapSetter;
    }

    public void setBitmap(T t, Bitmap bitmap) {
        if (this.bitmapSetter != null) {
            this.bitmapSetter.setBitmap(t, bitmap);
        } else if (t instanceof ImageView) {
            ((ImageView) t).setImageBitmap(bitmap);
        } else {
            t.setBackgroundDrawable(new BitmapDrawable(t.getResources(), bitmap));
        }
    }

    public void setDrawable(T t, Drawable drawable) {
        if (this.bitmapSetter != null) {
            this.bitmapSetter.setDrawable(t, drawable);
        } else if (t instanceof ImageView) {
            ((ImageView) t).setImageDrawable(drawable);
        } else {
            t.setBackgroundDrawable(drawable);
        }
    }

    public Drawable getDrawable(T t) {
        if (this.bitmapSetter != null) {
            return this.bitmapSetter.getDrawable(t);
        }
        if (t instanceof ImageView) {
            return ((ImageView) t).getDrawable();
        }
        return t.getBackground();
    }
}
