package p000;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/* JADX INFO: renamed from: bj */
/* JADX INFO: compiled from: DescendantOffsetUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0768bj {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<Matrix> f5186a = new ThreadLocal<>();

    /* JADX INFO: renamed from: b */
    private static final ThreadLocal<RectF> f5187b = new ThreadLocal<>();

    /* JADX INFO: renamed from: a */
    public static void m5576a(ViewGroup viewGroup, View view, Rect rect) {
        Matrix matrix = f5186a.get();
        if (matrix == null) {
            matrix = new Matrix();
            f5186a.set(matrix);
        } else {
            matrix.reset();
        }
        m5577a(viewGroup, view, matrix);
        RectF rectF = f5187b.get();
        if (rectF == null) {
            rectF = new RectF();
            f5187b.set(rectF);
        }
        rectF.set(rect);
        matrix.mapRect(rectF);
        rect.set((int) (rectF.left + 0.5f), (int) (rectF.top + 0.5f), (int) (rectF.right + 0.5f), (int) (rectF.bottom + 0.5f));
    }

    /* JADX INFO: renamed from: b */
    public static void m5578b(ViewGroup viewGroup, View view, Rect rect) {
        rect.set(0, 0, view.getWidth(), view.getHeight());
        m5576a(viewGroup, view, rect);
    }

    /* JADX INFO: renamed from: a */
    private static void m5577a(ViewParent viewParent, View view, Matrix matrix) {
        Object parent = view.getParent();
        if ((parent instanceof View) && parent != viewParent) {
            m5577a(viewParent, (View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        if (view.getMatrix().isIdentity()) {
            return;
        }
        matrix.preConcat(view.getMatrix());
    }
}
