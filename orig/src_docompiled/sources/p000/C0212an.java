package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: an */
/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0212an {
    /* JADX INFO: renamed from: a */
    public static PorterDuffColorFilter m2121a(Drawable drawable, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(drawable.getState(), 0), mode);
    }
}
