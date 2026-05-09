package p000;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.util.Log;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: bk */
/* JADX INFO: compiled from: DrawableUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0769bk {

    /* JADX INFO: renamed from: a */
    private static Method f5188a;

    /* JADX INFO: renamed from: b */
    private static boolean f5189b;

    /* JADX INFO: renamed from: a */
    public static boolean m5579a(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        return m5580b(drawableContainer, constantState);
    }

    /* JADX INFO: renamed from: b */
    private static boolean m5580b(DrawableContainer drawableContainer, Drawable.ConstantState constantState) {
        if (!f5189b) {
            try {
                f5188a = DrawableContainer.class.getDeclaredMethod("setConstantState", DrawableContainer.DrawableContainerState.class);
                f5188a.setAccessible(true);
            } catch (NoSuchMethodException unused) {
                Log.e("DrawableUtils", "Could not fetch setConstantState(). Oh well.");
            }
            f5189b = true;
        }
        if (f5188a != null) {
            try {
                f5188a.invoke(drawableContainer, constantState);
                return true;
            } catch (Exception unused2) {
                Log.e("DrawableUtils", "Could not invoke setConstantState(). Oh well.");
            }
        }
        return false;
    }
}
