package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: av */
/* JADX INFO: compiled from: MaterialResources.java */
/* JADX INFO: loaded from: classes.dex */
public class C0753av {
    /* JADX INFO: renamed from: a */
    public static ColorStateList m5478a(Context context, TypedArray typedArray, int i) {
        int resourceId;
        ColorStateList colorStateListM8972a;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (colorStateListM8972a = C1684ee.m8972a(context, resourceId)) == null) ? typedArray.getColorStateList(i) : colorStateListM8972a;
    }

    /* JADX INFO: renamed from: b */
    public static Drawable m5479b(Context context, TypedArray typedArray, int i) {
        int resourceId;
        Drawable drawableM8975b;
        return (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0 || (drawableM8975b = C1684ee.m8975b(context, resourceId)) == null) ? typedArray.getDrawable(i) : drawableM8975b;
    }

    /* JADX INFO: renamed from: c */
    public static C0754aw m5480c(Context context, TypedArray typedArray, int i) {
        int resourceId;
        if (!typedArray.hasValue(i) || (resourceId = typedArray.getResourceId(i, 0)) == 0) {
            return null;
        }
        return new C0754aw(context, resourceId);
    }

    /* JADX INFO: renamed from: a */
    static int m5477a(TypedArray typedArray, int i, int i2) {
        return typedArray.hasValue(i) ? i : i2;
    }
}
