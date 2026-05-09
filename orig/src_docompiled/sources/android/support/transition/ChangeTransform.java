package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import org.xmlpull.v1.XmlPullParser;
import p000.C0791cf;
import p000.C0793ch;
import p000.C0797cl;
import p000.C0799cn;
import p000.C1642cq;
import p000.C1646cu;
import p000.C1647cv;
import p000.C1651cz;
import p000.C1664dl;
import p000.InterfaceC0796ck;

/* JADX INFO: loaded from: classes.dex */
public class ChangeTransform extends Transition {

    /* JADX INFO: renamed from: i */
    private static final String[] f2826i = {"android:changeTransform:matrix", "android:changeTransform:transforms", "android:changeTransform:parentMatrix"};

    /* JADX INFO: renamed from: j */
    private static final Property<C0347b, float[]> f2827j = new Property<C0347b, float[]>(float[].class, "nonTranslations") { // from class: android.support.transition.ChangeTransform.1
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public float[] get(C0347b c0347b) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(C0347b c0347b, float[] fArr) {
            c0347b.m3029a(fArr);
        }
    };

    /* JADX INFO: renamed from: k */
    private static final Property<C0347b, PointF> f2828k = new Property<C0347b, PointF>(PointF.class, "translations") { // from class: android.support.transition.ChangeTransform.2
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(C0347b c0347b) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(C0347b c0347b, PointF pointF) {
            c0347b.m3028a(pointF);
        }
    };

    /* JADX INFO: renamed from: l */
    private static final boolean f2829l;

    /* JADX INFO: renamed from: a */
    boolean f2830a;

    /* JADX INFO: renamed from: m */
    private boolean f2831m;

    /* JADX INFO: renamed from: n */
    private Matrix f2832n;

    static {
        f2829l = Build.VERSION.SDK_INT >= 21;
    }

    public ChangeTransform() {
        this.f2830a = true;
        this.f2831m = true;
        this.f2832n = new Matrix();
    }

    public ChangeTransform(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2830a = true;
        this.f2831m = true;
        this.f2832n = new Matrix();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9338g);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        this.f2830a = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, xmlPullParser, "reparentWithOverlay", 1, true);
        this.f2831m = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, xmlPullParser, "reparent", 0, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return f2826i;
    }

    /* JADX INFO: renamed from: d */
    private void m3020d(C1651cz c1651cz) {
        View view = c1651cz.f9357b;
        if (view.getVisibility() == 8) {
            return;
        }
        c1651cz.f9356a.put("android:changeTransform:parent", view.getParent());
        c1651cz.f9356a.put("android:changeTransform:transforms", new C0348c(view));
        Matrix matrix = view.getMatrix();
        c1651cz.f9356a.put("android:changeTransform:matrix", (matrix == null || matrix.isIdentity()) ? null : new Matrix(matrix));
        if (this.f2831m) {
            Matrix matrix2 = new Matrix();
            C1664dl.m8865a((ViewGroup) view.getParent(), matrix2);
            matrix2.preTranslate(-r2.getScrollX(), -r2.getScrollY());
            c1651cz.f9356a.put("android:changeTransform:parentMatrix", matrix2);
            c1651cz.f9356a.put("android:changeTransform:intermediateMatrix", view.getTag(R.id.transition_transform));
            c1651cz.f9356a.put("android:changeTransform:intermediateParentMatrix", view.getTag(R.id.parent_matrix));
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m3020d(c1651cz);
        if (f2829l) {
            return;
        }
        ((ViewGroup) c1651cz.f9357b.getParent()).startViewTransition(c1651cz.f9357b);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m3020d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz == null || c1651cz2 == null || !c1651cz.f9356a.containsKey("android:changeTransform:parent") || !c1651cz2.f9356a.containsKey("android:changeTransform:parent")) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) c1651cz.f9356a.get("android:changeTransform:parent");
        boolean z = this.f2831m && !m3017a(viewGroup2, (ViewGroup) c1651cz2.f9356a.get("android:changeTransform:parent"));
        Matrix matrix = (Matrix) c1651cz.f9356a.get("android:changeTransform:intermediateMatrix");
        if (matrix != null) {
            c1651cz.f9356a.put("android:changeTransform:matrix", matrix);
        }
        Matrix matrix2 = (Matrix) c1651cz.f9356a.get("android:changeTransform:intermediateParentMatrix");
        if (matrix2 != null) {
            c1651cz.f9356a.put("android:changeTransform:parentMatrix", matrix2);
        }
        if (z) {
            m3019b(c1651cz, c1651cz2);
        }
        ObjectAnimator objectAnimatorM3014a = m3014a(c1651cz, c1651cz2, z);
        if (z && objectAnimatorM3014a != null && this.f2830a) {
            m3018b(viewGroup, c1651cz, c1651cz2);
        } else if (!f2829l) {
            viewGroup2.endViewTransition(c1651cz.f9357b);
        }
        return objectAnimatorM3014a;
    }

    /* JADX INFO: renamed from: a */
    private ObjectAnimator m3014a(C1651cz c1651cz, C1651cz c1651cz2, final boolean z) {
        Matrix matrix = (Matrix) c1651cz.f9356a.get("android:changeTransform:matrix");
        Matrix matrix2 = (Matrix) c1651cz2.f9356a.get("android:changeTransform:matrix");
        if (matrix == null) {
            matrix = C0799cn.f5349a;
        }
        if (matrix2 == null) {
            matrix2 = C0799cn.f5349a;
        }
        final Matrix matrix3 = matrix2;
        if (matrix.equals(matrix3)) {
            return null;
        }
        final C0348c c0348c = (C0348c) c1651cz2.f9356a.get("android:changeTransform:transforms");
        final View view = c1651cz2.f9357b;
        m3015a(view);
        float[] fArr = new float[9];
        matrix.getValues(fArr);
        float[] fArr2 = new float[9];
        matrix3.getValues(fArr2);
        final C0347b c0347b = new C0347b(view, fArr);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(c0347b, PropertyValuesHolder.ofObject(f2827j, new C0793ch(new float[9]), fArr, fArr2), C1642cq.m8811a(f2828k, m3096l().mo2973a(fArr[2], fArr[5], fArr2[2], fArr2[5])));
        AnimatorListenerAdapter animatorListenerAdapter = new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeTransform.3

            /* JADX INFO: renamed from: g */
            private boolean f2839g;

            /* JADX INFO: renamed from: h */
            private Matrix f2840h = new Matrix();

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                this.f2839g = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!this.f2839g) {
                    if (z && ChangeTransform.this.f2830a) {
                        m3025a(matrix3);
                    } else {
                        view.setTag(R.id.transition_transform, null);
                        view.setTag(R.id.parent_matrix, null);
                    }
                }
                C1664dl.m8869c(view, null);
                c0348c.m3030a(view);
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationPause(Animator animator) {
                m3025a(c0347b.m3027a());
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
            public void onAnimationResume(Animator animator) {
                ChangeTransform.m3015a(view);
            }

            /* JADX INFO: renamed from: a */
            private void m3025a(Matrix matrix4) {
                this.f2840h.set(matrix4);
                view.setTag(R.id.transition_transform, this.f2840h);
                c0348c.m3030a(view);
            }
        };
        objectAnimatorOfPropertyValuesHolder.addListener(animatorListenerAdapter);
        C0791cf.m5780a(objectAnimatorOfPropertyValuesHolder, animatorListenerAdapter);
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: renamed from: a */
    private boolean m3017a(ViewGroup viewGroup, ViewGroup viewGroup2) {
        if (m3081b(viewGroup) && m3081b(viewGroup2)) {
            C1651cz c1651czB = m3079b((View) viewGroup, true);
            if (c1651czB == null || viewGroup2 != c1651czB.f9357b) {
                return false;
            }
        } else if (viewGroup != viewGroup2) {
            return false;
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    private void m3018b(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        View view = c1651cz2.f9357b;
        Matrix matrix = new Matrix((Matrix) c1651cz2.f9356a.get("android:changeTransform:parentMatrix"));
        C1664dl.m8867b(viewGroup, matrix);
        InterfaceC0796ck interfaceC0796ckM5796a = C0797cl.m5796a(view, viewGroup, matrix);
        if (interfaceC0796ckM5796a == null) {
            return;
        }
        interfaceC0796ckM5796a.mo5790a((ViewGroup) c1651cz.f9356a.get("android:changeTransform:parent"), c1651cz.f9357b);
        Transition transition = this;
        while (transition.f2905e != null) {
            transition = transition.f2905e;
        }
        transition.mo3064a(new C0346a(view, interfaceC0796ckM5796a));
        if (f2829l) {
            if (c1651cz.f9357b != c1651cz2.f9357b) {
                C1664dl.m8862a(c1651cz.f9357b, 0.0f);
            }
            C1664dl.m8862a(view, 1.0f);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m3019b(C1651cz c1651cz, C1651cz c1651cz2) {
        Matrix matrix = (Matrix) c1651cz2.f9356a.get("android:changeTransform:parentMatrix");
        c1651cz2.f9357b.setTag(R.id.parent_matrix, matrix);
        Matrix matrix2 = this.f2832n;
        matrix2.reset();
        matrix.invert(matrix2);
        Matrix matrix3 = (Matrix) c1651cz.f9356a.get("android:changeTransform:matrix");
        if (matrix3 == null) {
            matrix3 = new Matrix();
            c1651cz.f9356a.put("android:changeTransform:matrix", matrix3);
        }
        matrix3.postConcat((Matrix) c1651cz.f9356a.get("android:changeTransform:parentMatrix"));
        matrix3.postConcat(matrix2);
    }

    /* JADX INFO: renamed from: a */
    static void m3015a(View view) {
        m3016a(view, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX INFO: renamed from: a */
    static void m3016a(View view, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8) {
        view.setTranslationX(f);
        view.setTranslationY(f2);
        ViewCompat.setTranslationZ(view, f3);
        view.setScaleX(f4);
        view.setScaleY(f5);
        view.setRotationX(f6);
        view.setRotationY(f7);
        view.setRotation(f8);
    }

    /* JADX INFO: renamed from: android.support.transition.ChangeTransform$c */
    static class C0348c {

        /* JADX INFO: renamed from: a */
        final float f2848a;

        /* JADX INFO: renamed from: b */
        final float f2849b;

        /* JADX INFO: renamed from: c */
        final float f2850c;

        /* JADX INFO: renamed from: d */
        final float f2851d;

        /* JADX INFO: renamed from: e */
        final float f2852e;

        /* JADX INFO: renamed from: f */
        final float f2853f;

        /* JADX INFO: renamed from: g */
        final float f2854g;

        /* JADX INFO: renamed from: h */
        final float f2855h;

        C0348c(View view) {
            this.f2848a = view.getTranslationX();
            this.f2849b = view.getTranslationY();
            this.f2850c = ViewCompat.getTranslationZ(view);
            this.f2851d = view.getScaleX();
            this.f2852e = view.getScaleY();
            this.f2853f = view.getRotationX();
            this.f2854g = view.getRotationY();
            this.f2855h = view.getRotation();
        }

        /* JADX INFO: renamed from: a */
        public void m3030a(View view) {
            ChangeTransform.m3016a(view, this.f2848a, this.f2849b, this.f2850c, this.f2851d, this.f2852e, this.f2853f, this.f2854g, this.f2855h);
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof C0348c)) {
                return false;
            }
            C0348c c0348c = (C0348c) obj;
            return c0348c.f2848a == this.f2848a && c0348c.f2849b == this.f2849b && c0348c.f2850c == this.f2850c && c0348c.f2851d == this.f2851d && c0348c.f2852e == this.f2852e && c0348c.f2853f == this.f2853f && c0348c.f2854g == this.f2854g && c0348c.f2855h == this.f2855h;
        }

        public int hashCode() {
            return ((((((((((((((this.f2848a != 0.0f ? Float.floatToIntBits(this.f2848a) : 0) * 31) + (this.f2849b != 0.0f ? Float.floatToIntBits(this.f2849b) : 0)) * 31) + (this.f2850c != 0.0f ? Float.floatToIntBits(this.f2850c) : 0)) * 31) + (this.f2851d != 0.0f ? Float.floatToIntBits(this.f2851d) : 0)) * 31) + (this.f2852e != 0.0f ? Float.floatToIntBits(this.f2852e) : 0)) * 31) + (this.f2853f != 0.0f ? Float.floatToIntBits(this.f2853f) : 0)) * 31) + (this.f2854g != 0.0f ? Float.floatToIntBits(this.f2854g) : 0)) * 31) + (this.f2855h != 0.0f ? Float.floatToIntBits(this.f2855h) : 0);
        }
    }

    /* JADX INFO: renamed from: android.support.transition.ChangeTransform$a */
    static class C0346a extends C1647cv {

        /* JADX INFO: renamed from: a */
        private View f2841a;

        /* JADX INFO: renamed from: b */
        private InterfaceC0796ck f2842b;

        C0346a(View view, InterfaceC0796ck interfaceC0796ck) {
            this.f2841a = view;
            this.f2842b = interfaceC0796ck;
        }

        @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: a */
        public void mo2987a(Transition transition) {
            transition.mo3078b(this);
            C0797cl.m5797a(this.f2841a);
            this.f2841a.setTag(R.id.transition_transform, null);
            this.f2841a.setTag(R.id.parent_matrix, null);
        }

        @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: b */
        public void mo2988b(Transition transition) {
            this.f2842b.setVisibility(4);
        }

        @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: c */
        public void mo2989c(Transition transition) {
            this.f2842b.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: android.support.transition.ChangeTransform$b */
    static class C0347b {

        /* JADX INFO: renamed from: a */
        private final Matrix f2843a = new Matrix();

        /* JADX INFO: renamed from: b */
        private final View f2844b;

        /* JADX INFO: renamed from: c */
        private final float[] f2845c;

        /* JADX INFO: renamed from: d */
        private float f2846d;

        /* JADX INFO: renamed from: e */
        private float f2847e;

        C0347b(View view, float[] fArr) {
            this.f2844b = view;
            this.f2845c = (float[]) fArr.clone();
            this.f2846d = this.f2845c[2];
            this.f2847e = this.f2845c[5];
            m3026b();
        }

        /* JADX INFO: renamed from: a */
        void m3029a(float[] fArr) {
            System.arraycopy(fArr, 0, this.f2845c, 0, fArr.length);
            m3026b();
        }

        /* JADX INFO: renamed from: a */
        void m3028a(PointF pointF) {
            this.f2846d = pointF.x;
            this.f2847e = pointF.y;
            m3026b();
        }

        /* JADX INFO: renamed from: b */
        private void m3026b() {
            this.f2845c[2] = this.f2846d;
            this.f2845c[5] = this.f2847e;
            this.f2843a.setValues(this.f2845c);
            C1664dl.m8869c(this.f2844b, this.f2843a);
        }

        /* JADX INFO: renamed from: a */
        Matrix m3027a() {
            return this.f2843a;
        }
    }
}
