package p000;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.os.Build;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: qg */
/* JADX INFO: compiled from: AnimatorProxy.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2050qg extends Animation {

    /* JADX INFO: renamed from: a */
    public static final boolean f12319a;

    /* JADX INFO: renamed from: b */
    private static final WeakHashMap<View, C2050qg> f12320b;

    /* JADX INFO: renamed from: c */
    private final WeakReference<View> f12321c;

    /* JADX INFO: renamed from: e */
    private boolean f12323e;

    /* JADX INFO: renamed from: g */
    private float f12325g;

    /* JADX INFO: renamed from: h */
    private float f12326h;

    /* JADX INFO: renamed from: i */
    private float f12327i;

    /* JADX INFO: renamed from: j */
    private float f12328j;

    /* JADX INFO: renamed from: k */
    private float f12329k;

    /* JADX INFO: renamed from: n */
    private float f12332n;

    /* JADX INFO: renamed from: o */
    private float f12333o;

    /* JADX INFO: renamed from: d */
    private final Camera f12322d = new Camera();

    /* JADX INFO: renamed from: f */
    private float f12324f = 1.0f;

    /* JADX INFO: renamed from: l */
    private float f12330l = 1.0f;

    /* JADX INFO: renamed from: m */
    private float f12331m = 1.0f;

    /* JADX INFO: renamed from: p */
    private final RectF f12334p = new RectF();

    /* JADX INFO: renamed from: q */
    private final RectF f12335q = new RectF();

    /* JADX INFO: renamed from: r */
    private final Matrix f12336r = new Matrix();

    static {
        f12319a = Integer.valueOf(Build.VERSION.SDK).intValue() < 11;
        f12320b = new WeakHashMap<>();
    }

    /* JADX INFO: renamed from: a */
    public static C2050qg m11192a(View view) {
        C2050qg c2050qg = f12320b.get(view);
        if (c2050qg != null && c2050qg == view.getAnimation()) {
            return c2050qg;
        }
        C2050qg c2050qg2 = new C2050qg(view);
        f12320b.put(view, c2050qg2);
        return c2050qg2;
    }

    private C2050qg(View view) {
        setDuration(0L);
        setFillAfter(true);
        view.setAnimation(this);
        this.f12321c = new WeakReference<>(view);
    }

    /* JADX INFO: renamed from: a */
    public void m11198a(float f) {
        if (this.f12324f != f) {
            this.f12324f = f;
            View view = this.f12321c.get();
            if (view != null) {
                view.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m11199b(float f) {
        if (this.f12330l != f) {
            m11195b();
            this.f12330l = f;
            m11196c();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m11200c(float f) {
        if (this.f12331m != f) {
            m11195b();
            this.f12331m = f;
            m11196c();
        }
    }

    /* JADX INFO: renamed from: a */
    public float m11197a() {
        return this.f12333o;
    }

    /* JADX INFO: renamed from: d */
    public void m11201d(float f) {
        if (this.f12333o != f) {
            m11195b();
            this.f12333o = f;
            m11196c();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m11195b() {
        View view = this.f12321c.get();
        if (view != null) {
            m11194a(this.f12334p, view);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m11196c() {
        View view = this.f12321c.get();
        if (view == null || view.getParent() == null) {
            return;
        }
        RectF rectF = this.f12335q;
        m11194a(rectF, view);
        rectF.union(this.f12334p);
        ((View) view.getParent()).invalidate((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
    }

    /* JADX INFO: renamed from: a */
    private void m11194a(RectF rectF, View view) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        Matrix matrix = this.f12336r;
        matrix.reset();
        m11193a(matrix, view);
        this.f12336r.mapRect(rectF);
        rectF.offset(view.getLeft(), view.getTop());
        if (rectF.right < rectF.left) {
            float f = rectF.right;
            rectF.right = rectF.left;
            rectF.left = f;
        }
        if (rectF.bottom < rectF.top) {
            float f2 = rectF.top;
            rectF.top = rectF.bottom;
            rectF.bottom = f2;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m11193a(Matrix matrix, View view) {
        float width = view.getWidth();
        float height = view.getHeight();
        boolean z = this.f12323e;
        float f = z ? this.f12325g : width / 2.0f;
        float f2 = z ? this.f12326h : height / 2.0f;
        float f3 = this.f12327i;
        float f4 = this.f12328j;
        float f5 = this.f12329k;
        if (f3 != 0.0f || f4 != 0.0f || f5 != 0.0f) {
            Camera camera = this.f12322d;
            camera.save();
            camera.rotateX(f3);
            camera.rotateY(f4);
            camera.rotateZ(-f5);
            camera.getMatrix(matrix);
            camera.restore();
            matrix.preTranslate(-f, -f2);
            matrix.postTranslate(f, f2);
        }
        float f6 = this.f12330l;
        float f7 = this.f12331m;
        if (f6 != 1.0f || f7 != 1.0f) {
            matrix.postScale(f6, f7);
            matrix.postTranslate((-(f / width)) * ((f6 * width) - width), (-(f2 / height)) * ((f7 * height) - height));
        }
        matrix.postTranslate(this.f12332n, this.f12333o);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        View view = this.f12321c.get();
        if (view != null) {
            transformation.setAlpha(this.f12324f);
            m11193a(transformation.getMatrix(), view);
        }
    }
}
