package p000;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Matrix;
import android.os.Build;
import android.support.transition.R;
import android.util.Log;
import android.widget.ImageView;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: renamed from: cm */
/* JADX INFO: compiled from: ImageViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0798cm {

    /* JADX INFO: renamed from: a */
    private static Method f5346a;

    /* JADX INFO: renamed from: b */
    private static boolean f5347b;

    /* JADX INFO: renamed from: a */
    public static void m5799a(ImageView imageView) {
        if (Build.VERSION.SDK_INT < 21) {
            ImageView.ScaleType scaleType = imageView.getScaleType();
            imageView.setTag(R.id.save_scale_type, scaleType);
            if (scaleType == ImageView.ScaleType.MATRIX) {
                imageView.setTag(R.id.save_image_matrix, imageView.getImageMatrix());
            } else {
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
            }
            imageView.setImageMatrix(C0799cn.f5349a);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m5801a(ImageView imageView, Matrix matrix) {
        if (Build.VERSION.SDK_INT < 21) {
            imageView.setImageMatrix(matrix);
            return;
        }
        m5798a();
        if (f5346a != null) {
            try {
                f5346a.invoke(imageView, matrix);
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e.getCause());
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m5798a() {
        if (f5347b) {
            return;
        }
        try {
            f5346a = ImageView.class.getDeclaredMethod("animateTransform", Matrix.class);
            f5346a.setAccessible(true);
        } catch (NoSuchMethodException e) {
            Log.i("ImageViewUtils", "Failed to retrieve animateTransform method", e);
        }
        f5347b = true;
    }

    /* JADX INFO: renamed from: a */
    public static void m5800a(final ImageView imageView, Animator animator) {
        if (Build.VERSION.SDK_INT < 21) {
            animator.addListener(new AnimatorListenerAdapter() { // from class: cm.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator2) {
                    ImageView.ScaleType scaleType = (ImageView.ScaleType) imageView.getTag(R.id.save_scale_type);
                    imageView.setScaleType(scaleType);
                    imageView.setTag(R.id.save_scale_type, null);
                    if (scaleType == ImageView.ScaleType.MATRIX) {
                        imageView.setImageMatrix((Matrix) imageView.getTag(R.id.save_image_matrix));
                        imageView.setTag(R.id.save_image_matrix, null);
                    }
                    animator2.removeListener(this);
                }
            });
        }
    }
}
