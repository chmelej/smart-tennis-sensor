package p000;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: bl */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0770bl {

    /* JADX INFO: renamed from: a */
    static final TimeInterpolator f5190a = C2178v.f13001c;

    /* JADX INFO: renamed from: p */
    static final int[] f5191p = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: q */
    static final int[] f5192q = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: r */
    static final int[] f5193r = {R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: s */
    static final int[] f5194s = {R.attr.state_hovered, R.attr.state_enabled};

    /* JADX INFO: renamed from: t */
    static final int[] f5195t = {R.attr.state_enabled};

    /* JADX INFO: renamed from: u */
    static final int[] f5196u = new int[0];

    /* JADX INFO: renamed from: A */
    private float f5197A;

    /* JADX INFO: renamed from: B */
    private ArrayList<Animator.AnimatorListener> f5198B;

    /* JADX INFO: renamed from: C */
    private ArrayList<Animator.AnimatorListener> f5199C;

    /* JADX INFO: renamed from: H */
    private ViewTreeObserver.OnPreDrawListener f5204H;

    /* JADX INFO: renamed from: c */
    Animator f5206c;

    /* JADX INFO: renamed from: d */
    C0005ac f5207d;

    /* JADX INFO: renamed from: e */
    C0005ac f5208e;

    /* JADX INFO: renamed from: f */
    C0774bp f5209f;

    /* JADX INFO: renamed from: g */
    Drawable f5210g;

    /* JADX INFO: renamed from: h */
    Drawable f5211h;

    /* JADX INFO: renamed from: i */
    C0764bf f5212i;

    /* JADX INFO: renamed from: j */
    Drawable f5213j;

    /* JADX INFO: renamed from: k */
    float f5214k;

    /* JADX INFO: renamed from: l */
    float f5215l;

    /* JADX INFO: renamed from: m */
    float f5216m;

    /* JADX INFO: renamed from: n */
    int f5217n;

    /* JADX INFO: renamed from: v */
    final VisibilityAwareImageButton f5219v;

    /* JADX INFO: renamed from: w */
    final InterfaceC0775bq f5220w;

    /* JADX INFO: renamed from: x */
    private C0005ac f5221x;

    /* JADX INFO: renamed from: y */
    private C0005ac f5222y;

    /* JADX INFO: renamed from: b */
    int f5205b = 0;

    /* JADX INFO: renamed from: o */
    float f5218o = 1.0f;

    /* JADX INFO: renamed from: D */
    private final Rect f5200D = new Rect();

    /* JADX INFO: renamed from: E */
    private final RectF f5201E = new RectF();

    /* JADX INFO: renamed from: F */
    private final RectF f5202F = new RectF();

    /* JADX INFO: renamed from: G */
    private final Matrix f5203G = new Matrix();

    /* JADX INFO: renamed from: z */
    private final C0777bs f5223z = new C0777bs();

    /* JADX INFO: renamed from: bl$d */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public interface d {
        /* JADX INFO: renamed from: a */
        void mo2768a();

        /* JADX INFO: renamed from: b */
        void mo2769b();
    }

    /* JADX INFO: renamed from: b */
    void mo5607b(Rect rect) {
    }

    /* JADX INFO: renamed from: i */
    public void mo5619i() {
    }

    /* JADX INFO: renamed from: m */
    boolean mo5623m() {
        return true;
    }

    public C0770bl(VisibilityAwareImageButton visibilityAwareImageButton, InterfaceC0775bq interfaceC0775bq) {
        this.f5219v = visibilityAwareImageButton;
        this.f5220w = interfaceC0775bq;
        this.f5223z.m5706a(f5191p, m5582a((f) new c()));
        this.f5223z.m5706a(f5192q, m5582a((f) new b()));
        this.f5223z.m5706a(f5193r, m5582a((f) new b()));
        this.f5223z.m5706a(f5194s, m5582a((f) new b()));
        this.f5223z.m5706a(f5195t, m5582a((f) new e()));
        this.f5223z.m5706a(f5196u, m5582a((f) new a()));
        this.f5197A = this.f5219v.getRotation();
    }

    /* JADX INFO: renamed from: a */
    public void mo5597a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable[] drawableArr;
        this.f5210g = DrawableCompat.wrap(m5626p());
        DrawableCompat.setTintList(this.f5210g, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.f5210g, mode);
        }
        this.f5211h = DrawableCompat.wrap(m5626p());
        DrawableCompat.setTintList(this.f5211h, C0756ay.m5493a(colorStateList2));
        if (i > 0) {
            this.f5212i = m5590a(i, colorStateList);
            drawableArr = new Drawable[]{this.f5212i, this.f5210g, this.f5211h};
        } else {
            this.f5212i = null;
            drawableArr = new Drawable[]{this.f5210g, this.f5211h};
        }
        this.f5213j = new LayerDrawable(drawableArr);
        this.f5209f = new C0774bp(this.f5219v.getContext(), this.f5213j, this.f5220w.mo2780a(), this.f5214k, this.f5214k + this.f5216m);
        this.f5209f.m5684a(false);
        this.f5220w.mo2782a(this.f5209f);
    }

    /* JADX INFO: renamed from: a */
    public void m5596a(ColorStateList colorStateList) {
        if (this.f5210g != null) {
            DrawableCompat.setTintList(this.f5210g, colorStateList);
        }
        if (this.f5212i != null) {
            this.f5212i.m5517a(colorStateList);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5598a(PorterDuff.Mode mode) {
        if (this.f5210g != null) {
            DrawableCompat.setTintMode(this.f5210g, mode);
        }
    }

    /* JADX INFO: renamed from: b */
    public void mo5606b(ColorStateList colorStateList) {
        if (this.f5211h != null) {
            DrawableCompat.setTintList(this.f5211h, C0756ay.m5493a(colorStateList));
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m5591a(float f2) {
        if (this.f5214k != f2) {
            this.f5214k = f2;
            mo5592a(this.f5214k, this.f5215l, this.f5216m);
        }
    }

    /* JADX INFO: renamed from: a */
    public float mo5589a() {
        return this.f5214k;
    }

    /* JADX INFO: renamed from: b */
    public float m5602b() {
        return this.f5215l;
    }

    /* JADX INFO: renamed from: c */
    public float m5609c() {
        return this.f5216m;
    }

    /* JADX INFO: renamed from: b */
    public final void m5603b(float f2) {
        if (this.f5215l != f2) {
            this.f5215l = f2;
            mo5592a(this.f5214k, this.f5215l, this.f5216m);
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m5610c(float f2) {
        if (this.f5216m != f2) {
            this.f5216m = f2;
            mo5592a(this.f5214k, this.f5215l, this.f5216m);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m5593a(int i) {
        if (this.f5217n != i) {
            this.f5217n = i;
            m5612d();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m5612d() {
        m5613d(this.f5218o);
    }

    /* JADX INFO: renamed from: d */
    final void m5613d(float f2) {
        this.f5218o = f2;
        Matrix matrix = this.f5203G;
        m5583a(f2, matrix);
        this.f5219v.setImageMatrix(matrix);
    }

    /* JADX INFO: renamed from: a */
    private void m5583a(float f2, Matrix matrix) {
        matrix.reset();
        if (this.f5219v.getDrawable() == null || this.f5217n == 0) {
            return;
        }
        RectF rectF = this.f5201E;
        RectF rectF2 = this.f5202F;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        rectF2.set(0.0f, 0.0f, this.f5217n, this.f5217n);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        matrix.postScale(f2, f2, this.f5217n / 2.0f, this.f5217n / 2.0f);
    }

    /* JADX INFO: renamed from: e */
    public final C0005ac m5615e() {
        return this.f5207d;
    }

    /* JADX INFO: renamed from: a */
    public final void m5594a(C0005ac c0005ac) {
        this.f5207d = c0005ac;
    }

    /* JADX INFO: renamed from: f */
    public final C0005ac m5616f() {
        return this.f5208e;
    }

    /* JADX INFO: renamed from: b */
    public final void m5604b(C0005ac c0005ac) {
        this.f5208e = c0005ac;
    }

    /* JADX INFO: renamed from: a */
    void mo5592a(float f2, float f3, float f4) {
        if (this.f5209f != null) {
            this.f5209f.m5683a(f2, this.f5216m + f2);
            m5620j();
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo5601a(int[] iArr) {
        this.f5223z.m5705a(iArr);
    }

    /* JADX INFO: renamed from: g */
    public void mo5617g() {
        this.f5223z.m5704a();
    }

    /* JADX INFO: renamed from: a */
    public void m5595a(Animator.AnimatorListener animatorListener) {
        if (this.f5198B == null) {
            this.f5198B = new ArrayList<>();
        }
        this.f5198B.add(animatorListener);
    }

    /* JADX INFO: renamed from: b */
    public void m5605b(Animator.AnimatorListener animatorListener) {
        if (this.f5198B == null) {
            return;
        }
        this.f5198B.remove(animatorListener);
    }

    /* JADX INFO: renamed from: c */
    public void m5611c(Animator.AnimatorListener animatorListener) {
        if (this.f5199C == null) {
            this.f5199C = new ArrayList<>();
        }
        this.f5199C.add(animatorListener);
    }

    /* JADX INFO: renamed from: d */
    public void m5614d(Animator.AnimatorListener animatorListener) {
        if (this.f5199C == null) {
            return;
        }
        this.f5199C.remove(animatorListener);
    }

    /* JADX INFO: renamed from: a */
    public void m5600a(final d dVar, final boolean z) {
        if (m5629s()) {
            return;
        }
        if (this.f5206c != null) {
            this.f5206c.cancel();
        }
        if (m5587w()) {
            AnimatorSet animatorSetM5581a = m5581a(this.f5208e != null ? this.f5208e : m5585u(), 0.0f, 0.0f, 0.0f);
            animatorSetM5581a.addListener(new AnimatorListenerAdapter() { // from class: bl.1

                /* JADX INFO: renamed from: d */
                private boolean f5227d;

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    C0770bl.this.f5219v.m2927a(0, z);
                    C0770bl.this.f5205b = 1;
                    C0770bl.this.f5206c = animator;
                    this.f5227d = false;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animator) {
                    this.f5227d = true;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C0770bl.this.f5205b = 0;
                    C0770bl.this.f5206c = null;
                    if (this.f5227d) {
                        return;
                    }
                    C0770bl.this.f5219v.m2927a(z ? 8 : 4, z);
                    if (dVar != null) {
                        dVar.mo2769b();
                    }
                }
            });
            if (this.f5199C != null) {
                Iterator<Animator.AnimatorListener> it = this.f5199C.iterator();
                while (it.hasNext()) {
                    animatorSetM5581a.addListener(it.next());
                }
            }
            animatorSetM5581a.start();
            return;
        }
        this.f5219v.m2927a(z ? 8 : 4, z);
        if (dVar != null) {
            dVar.mo2769b();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5608b(final d dVar, final boolean z) {
        if (m5628r()) {
            return;
        }
        if (this.f5206c != null) {
            this.f5206c.cancel();
        }
        if (m5587w()) {
            if (this.f5219v.getVisibility() != 0) {
                this.f5219v.setAlpha(0.0f);
                this.f5219v.setScaleY(0.0f);
                this.f5219v.setScaleX(0.0f);
                m5613d(0.0f);
            }
            AnimatorSet animatorSetM5581a = m5581a(this.f5207d != null ? this.f5207d : m5584t(), 1.0f, 1.0f, 1.0f);
            animatorSetM5581a.addListener(new AnimatorListenerAdapter() { // from class: bl.2
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    C0770bl.this.f5219v.m2927a(0, z);
                    C0770bl.this.f5205b = 2;
                    C0770bl.this.f5206c = animator;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    C0770bl.this.f5205b = 0;
                    C0770bl.this.f5206c = null;
                    if (dVar != null) {
                        dVar.mo2768a();
                    }
                }
            });
            if (this.f5198B != null) {
                Iterator<Animator.AnimatorListener> it = this.f5198B.iterator();
                while (it.hasNext()) {
                    animatorSetM5581a.addListener(it.next());
                }
            }
            animatorSetM5581a.start();
            return;
        }
        this.f5219v.m2927a(0, z);
        this.f5219v.setAlpha(1.0f);
        this.f5219v.setScaleY(1.0f);
        this.f5219v.setScaleX(1.0f);
        m5613d(1.0f);
        if (dVar != null) {
            dVar.mo2768a();
        }
    }

    /* JADX INFO: renamed from: t */
    private C0005ac m5584t() {
        if (this.f5221x == null) {
            this.f5221x = C0005ac.m143a(this.f5219v.getContext(), android.support.design.R.animator.design_fab_show_motion_spec);
        }
        return this.f5221x;
    }

    /* JADX INFO: renamed from: u */
    private C0005ac m5585u() {
        if (this.f5222y == null) {
            this.f5222y = C0005ac.m143a(this.f5219v.getContext(), android.support.design.R.animator.design_fab_hide_motion_spec);
        }
        return this.f5222y;
    }

    /* JADX INFO: renamed from: a */
    private AnimatorSet m5581a(C0005ac c0005ac, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f5219v, (Property<VisibilityAwareImageButton, Float>) View.ALPHA, f2);
        c0005ac.m150b("opacity").m296a((Animator) objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f5219v, (Property<VisibilityAwareImageButton, Float>) View.SCALE_X, f3);
        c0005ac.m150b("scale").m296a((Animator) objectAnimatorOfFloat2);
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f5219v, (Property<VisibilityAwareImageButton, Float>) View.SCALE_Y, f3);
        c0005ac.m150b("scale").m296a((Animator) objectAnimatorOfFloat3);
        arrayList.add(objectAnimatorOfFloat3);
        m5583a(f4, this.f5203G);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f5219v, new C0001aa(), new C0004ab(), new Matrix(this.f5203G));
        c0005ac.m150b("iconScale").m296a((Animator) objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        C2205w.m12083a(animatorSet, arrayList);
        return animatorSet;
    }

    /* JADX INFO: renamed from: h */
    public final Drawable m5618h() {
        return this.f5213j;
    }

    /* JADX INFO: renamed from: j */
    public final void m5620j() {
        Rect rect = this.f5200D;
        mo5599a(rect);
        mo5607b(rect);
        this.f5220w.mo2781a(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: renamed from: a */
    void mo5599a(Rect rect) {
        this.f5209f.getPadding(rect);
    }

    /* JADX INFO: renamed from: k */
    public void m5621k() {
        if (mo5623m()) {
            m5586v();
            this.f5219v.getViewTreeObserver().addOnPreDrawListener(this.f5204H);
        }
    }

    /* JADX INFO: renamed from: l */
    public void m5622l() {
        if (this.f5204H != null) {
            this.f5219v.getViewTreeObserver().removeOnPreDrawListener(this.f5204H);
            this.f5204H = null;
        }
    }

    /* JADX INFO: renamed from: a */
    C0764bf m5590a(int i, ColorStateList colorStateList) {
        Context context = this.f5219v.getContext();
        C0764bf c0764bfMo5624n = mo5624n();
        c0764bfMo5624n.m5516a(ContextCompat.getColor(context, android.support.design.R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, android.support.design.R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, android.support.design.R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, android.support.design.R.color.design_fab_stroke_end_outer_color));
        c0764bfMo5624n.m5515a(i);
        c0764bfMo5624n.m5517a(colorStateList);
        return c0764bfMo5624n;
    }

    /* JADX INFO: renamed from: n */
    C0764bf mo5624n() {
        return new C0764bf();
    }

    /* JADX INFO: renamed from: o */
    void m5625o() {
        float rotation = this.f5219v.getRotation();
        if (this.f5197A != rotation) {
            this.f5197A = rotation;
            m5588x();
        }
    }

    /* JADX INFO: renamed from: v */
    private void m5586v() {
        if (this.f5204H == null) {
            this.f5204H = new ViewTreeObserver.OnPreDrawListener() { // from class: bl.3
                @Override // android.view.ViewTreeObserver.OnPreDrawListener
                public boolean onPreDraw() {
                    C0770bl.this.m5625o();
                    return true;
                }
            };
        }
    }

    /* JADX INFO: renamed from: p */
    GradientDrawable m5626p() {
        GradientDrawable gradientDrawableMo5627q = mo5627q();
        gradientDrawableMo5627q.setShape(1);
        gradientDrawableMo5627q.setColor(-1);
        return gradientDrawableMo5627q;
    }

    /* JADX INFO: renamed from: q */
    GradientDrawable mo5627q() {
        return new GradientDrawable();
    }

    /* JADX INFO: renamed from: r */
    public boolean m5628r() {
        return this.f5219v.getVisibility() != 0 ? this.f5205b == 2 : this.f5205b != 1;
    }

    /* JADX INFO: renamed from: s */
    boolean m5629s() {
        return this.f5219v.getVisibility() == 0 ? this.f5205b == 1 : this.f5205b != 2;
    }

    /* JADX INFO: renamed from: a */
    private ValueAnimator m5582a(f fVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f5190a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(fVar);
        valueAnimator.addUpdateListener(fVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* JADX INFO: renamed from: bl$f */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    abstract class f extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        private boolean f5236a;

        /* JADX INFO: renamed from: c */
        private float f5238c;

        /* JADX INFO: renamed from: d */
        private float f5239d;

        /* JADX INFO: renamed from: a */
        protected abstract float mo5630a();

        private f() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            if (!this.f5236a) {
                this.f5238c = C0770bl.this.f5209f.m5681a();
                this.f5239d = mo5630a();
                this.f5236a = true;
            }
            C0770bl.this.f5209f.m5682a(this.f5238c + ((this.f5239d - this.f5238c) * valueAnimator.getAnimatedFraction()));
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C0770bl.this.f5209f.m5682a(this.f5239d);
            this.f5236a = false;
        }
    }

    /* JADX INFO: renamed from: bl$e */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class e extends f {
        e() {
            super();
        }

        @Override // p000.C0770bl.f
        /* JADX INFO: renamed from: a */
        protected float mo5630a() {
            return C0770bl.this.f5214k;
        }
    }

    /* JADX INFO: renamed from: bl$b */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class b extends f {
        b() {
            super();
        }

        @Override // p000.C0770bl.f
        /* JADX INFO: renamed from: a */
        protected float mo5630a() {
            return C0770bl.this.f5214k + C0770bl.this.f5215l;
        }
    }

    /* JADX INFO: renamed from: bl$c */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class c extends f {
        c() {
            super();
        }

        @Override // p000.C0770bl.f
        /* JADX INFO: renamed from: a */
        protected float mo5630a() {
            return C0770bl.this.f5214k + C0770bl.this.f5216m;
        }
    }

    /* JADX INFO: renamed from: bl$a */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    class a extends f {
        @Override // p000.C0770bl.f
        /* JADX INFO: renamed from: a */
        protected float mo5630a() {
            return 0.0f;
        }

        a() {
            super();
        }
    }

    /* JADX INFO: renamed from: w */
    private boolean m5587w() {
        return ViewCompat.isLaidOut(this.f5219v) && !this.f5219v.isInEditMode();
    }

    /* JADX INFO: renamed from: x */
    private void m5588x() {
        if (Build.VERSION.SDK_INT == 19) {
            if (this.f5197A % 90.0f != 0.0f) {
                if (this.f5219v.getLayerType() != 1) {
                    this.f5219v.setLayerType(1, null);
                }
            } else if (this.f5219v.getLayerType() != 0) {
                this.f5219v.setLayerType(0, null);
            }
        }
        if (this.f5209f != null) {
            this.f5209f.m5685b(-this.f5197A);
        }
        if (this.f5212i != null) {
            this.f5212i.m5518b(-this.f5197A);
        }
    }
}
