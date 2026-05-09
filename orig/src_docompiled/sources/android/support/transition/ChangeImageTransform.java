package android.support.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.Map;
import p000.C0798cm;
import p000.C0799cn;
import p000.C1650cy;
import p000.C1651cz;

/* JADX INFO: loaded from: classes.dex */
public class ChangeImageTransform extends Transition {

    /* JADX INFO: renamed from: a */
    private static final String[] f2821a = {"android:changeImageTransform:matrix", "android:changeImageTransform:bounds"};

    /* JADX INFO: renamed from: i */
    private static final TypeEvaluator<Matrix> f2822i = new TypeEvaluator<Matrix>() { // from class: android.support.transition.ChangeImageTransform.1
        @Override // android.animation.TypeEvaluator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return null;
        }
    };

    /* JADX INFO: renamed from: j */
    private static final Property<ImageView, Matrix> f2823j = new Property<ImageView, Matrix>(Matrix.class, "animatedTransform") { // from class: android.support.transition.ChangeImageTransform.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Matrix get(ImageView imageView) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(ImageView imageView, Matrix matrix) {
            C0798cm.m5801a(imageView, matrix);
        }
    };

    public ChangeImageTransform() {
    }

    public ChangeImageTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* JADX INFO: renamed from: d */
    private void m3009d(C1651cz c1651cz) {
        View view = c1651cz.f9357b;
        if ((view instanceof ImageView) && view.getVisibility() == 0) {
            ImageView imageView = (ImageView) view;
            if (imageView.getDrawable() == null) {
                return;
            }
            Map<String, Object> map = c1651cz.f9356a;
            map.put("android:changeImageTransform:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
            map.put("android:changeImageTransform:matrix", m3006b(imageView));
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m3009d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m3009d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return f2821a;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        ObjectAnimator objectAnimatorM3004a;
        if (c1651cz == null || c1651cz2 == null) {
            return null;
        }
        Rect rect = (Rect) c1651cz.f9356a.get("android:changeImageTransform:bounds");
        Rect rect2 = (Rect) c1651cz2.f9356a.get("android:changeImageTransform:bounds");
        if (rect == null || rect2 == null) {
            return null;
        }
        Matrix matrix = (Matrix) c1651cz.f9356a.get("android:changeImageTransform:matrix");
        Matrix matrix2 = (Matrix) c1651cz2.f9356a.get("android:changeImageTransform:matrix");
        boolean z = (matrix == null && matrix2 == null) || (matrix != null && matrix.equals(matrix2));
        if (rect.equals(rect2) && z) {
            return null;
        }
        ImageView imageView = (ImageView) c1651cz2.f9357b;
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        C0798cm.m5799a(imageView);
        if (intrinsicWidth == 0 || intrinsicHeight == 0) {
            objectAnimatorM3004a = m3004a(imageView);
        } else {
            if (matrix == null) {
                matrix = C0799cn.f5349a;
            }
            if (matrix2 == null) {
                matrix2 = C0799cn.f5349a;
            }
            f2823j.set(imageView, matrix);
            objectAnimatorM3004a = m3005a(imageView, matrix, matrix2);
        }
        C0798cm.m5800a(imageView, objectAnimatorM3004a);
        return objectAnimatorM3004a;
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m3004a(ImageView imageView) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f2823j, (TypeEvaluator) f2822i, (Object[]) new Matrix[]{null, null});
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m3005a(ImageView imageView, Matrix matrix, Matrix matrix2) {
        return ObjectAnimator.ofObject(imageView, (Property<ImageView, V>) f2823j, (TypeEvaluator) new C1650cy.a(), (Object[]) new Matrix[]{matrix, matrix2});
    }

    /* JADX INFO: renamed from: android.support.transition.ChangeImageTransform$3 */
    static /* synthetic */ class C03423 {

        /* JADX INFO: renamed from: a */
        static final /* synthetic */ int[] f2824a = new int[ImageView.ScaleType.values().length];

        static {
            try {
                f2824a[ImageView.ScaleType.FIT_XY.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2824a[ImageView.ScaleType.CENTER_CROP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private static Matrix m3006b(ImageView imageView) {
        switch (C03423.f2824a[imageView.getScaleType().ordinal()]) {
            case 1:
                return m3007c(imageView);
            case 2:
                return m3008d(imageView);
            default:
                return new Matrix(imageView.getImageMatrix());
        }
    }

    /* JADX INFO: renamed from: c */
    private static Matrix m3007c(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        Matrix matrix = new Matrix();
        matrix.postScale(imageView.getWidth() / drawable.getIntrinsicWidth(), imageView.getHeight() / drawable.getIntrinsicHeight());
        return matrix;
    }

    /* JADX INFO: renamed from: d */
    private static Matrix m3008d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        int intrinsicWidth = drawable.getIntrinsicWidth();
        float width = imageView.getWidth();
        float f = intrinsicWidth;
        int intrinsicHeight = drawable.getIntrinsicHeight();
        float height = imageView.getHeight();
        float f2 = intrinsicHeight;
        float fMax = Math.max(width / f, height / f2);
        int iRound = Math.round((width - (f * fMax)) / 2.0f);
        int iRound2 = Math.round((height - (f2 * fMax)) / 2.0f);
        Matrix matrix = new Matrix();
        matrix.postScale(fMax, fMax);
        matrix.postTranslate(iRound, iRound2);
        return matrix;
    }
}
