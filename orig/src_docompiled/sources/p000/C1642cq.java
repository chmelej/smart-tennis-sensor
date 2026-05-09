package p000;

import android.animation.PropertyValuesHolder;
import android.animation.TypeConverter;
import android.graphics.Path;
import android.graphics.PointF;
import android.os.Build;
import android.util.Property;

/* JADX INFO: renamed from: cq */
/* JADX INFO: compiled from: PropertyValuesHolderUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1642cq {
    /* JADX INFO: renamed from: a */
    public static PropertyValuesHolder m8811a(Property<?, PointF> property, Path path) {
        if (Build.VERSION.SDK_INT >= 21) {
            return PropertyValuesHolder.ofObject(property, (TypeConverter) null, path);
        }
        return PropertyValuesHolder.ofFloat(new C1641cp(property, path), 0.0f, 1.0f);
    }
}
