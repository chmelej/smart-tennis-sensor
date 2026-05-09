package p000;

import android.animation.ObjectAnimator;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: renamed from: co */
/* JADX INFO: compiled from: ObjectAnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0986co {
    /* JADX INFO: renamed from: a */
    public static <T> ObjectAnimator m6846a(T t, Property<T, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return ObjectAnimator.ofObject(t, property, (TypeConverter) null, path);
        }
        return ObjectAnimator.ofFloat(t, new C1641cp(property, path), 0.0f, 1.0f);
    }
}
