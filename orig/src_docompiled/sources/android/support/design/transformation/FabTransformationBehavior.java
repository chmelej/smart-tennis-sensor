package android.support.design.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.R;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import java.util.ArrayList;
import java.util.List;
import p000.C0005ac;
import p000.C0006ad;
import p000.C0021ae;
import p000.C0175ak;
import p000.C0185al;
import p000.C0773bo;
import p000.C2178v;
import p000.C2205w;
import p000.C2232x;
import p000.C2259y;
import p000.C2286z;
import p000.InterfaceC0194am;

/* JADX INFO: loaded from: classes.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* JADX INFO: renamed from: a */
    private final Rect f2275a;

    /* JADX INFO: renamed from: b */
    private final RectF f2276b;

    /* JADX INFO: renamed from: c */
    private final RectF f2277c;

    /* JADX INFO: renamed from: d */
    private final int[] f2278d;

    /* JADX INFO: renamed from: a */
    protected abstract C0251a mo2510a(Context context, boolean z);

    public FabTransformationBehavior() {
        this.f2275a = new Rect();
        this.f2276b = new RectF();
        this.f2277c = new RectF();
        this.f2278d = new int[2];
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2275a = new Rect();
        this.f2276b = new RectF();
        this.f2277c = new RectF();
        this.f2278d = new int[2];
    }

    @Override // android.support.design.transformation.ExpandableBehavior, android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2487a(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public void mo2511a(CoordinatorLayout.C0290d c0290d) {
        if (c0290d.f2463h == 0) {
            c0290d.f2463h = 80;
        }
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior
    /* JADX INFO: renamed from: b */
    protected AnimatorSet mo2491b(final View view, final View view2, final boolean z, boolean z2) {
        C0251a c0251aMo2510a = mo2510a(view2.getContext(), z);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            m2500a(view, view2, z, z2, c0251aMo2510a, arrayList, arrayList2);
        }
        RectF rectF = this.f2276b;
        m2501a(view, view2, z, z2, c0251aMo2510a, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        m2504b(view, view2, z, z2, c0251aMo2510a, arrayList, arrayList2);
        m2499a(view, view2, z, z2, c0251aMo2510a, fWidth, fHeight, arrayList, arrayList2);
        m2507c(view, view2, z, z2, c0251aMo2510a, arrayList, arrayList2);
        m2509d(view, view2, z, z2, c0251aMo2510a, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        C2205w.m12083a(animatorSet, arrayList);
        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.transformation.FabTransformationBehavior.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                if (z) {
                    view2.setVisibility(0);
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (z) {
                    return;
                }
                view2.setVisibility(4);
                view.setAlpha(1.0f);
                view.setVisibility(0);
            }
        });
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener(arrayList2.get(i));
        }
        return animatorSet;
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: a */
    private void m2500a(View view, View view2, boolean z, boolean z2, C0251a c0251a, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        c0251a.f2290a.m150b("elevation").m296a((Animator) objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    /* JADX INFO: renamed from: a */
    private void m2501a(View view, View view2, boolean z, boolean z2, C0251a c0251a, List<Animator> list, List<Animator.AnimatorListener> list2, RectF rectF) {
        C0006ad c0006adM150b;
        C0006ad c0006adM150b2;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fM2493a = m2493a(view, view2, c0251a.f2291b);
        float fM2502b = m2502b(view, view2, c0251a.f2291b);
        if (fM2493a == 0.0f || fM2502b == 0.0f) {
            c0006adM150b = c0251a.f2290a.m150b("translationXLinear");
            c0006adM150b2 = c0251a.f2290a.m150b("translationYLinear");
        } else if ((z && fM2502b < 0.0f) || (!z && fM2502b > 0.0f)) {
            c0006adM150b = c0251a.f2290a.m150b("translationXCurveUpwards");
            c0006adM150b2 = c0251a.f2290a.m150b("translationYCurveUpwards");
        } else {
            c0006adM150b = c0251a.f2290a.m150b("translationXCurveDownwards");
            c0006adM150b2 = c0251a.f2290a.m150b("translationYCurveDownwards");
        }
        C0006ad c0006ad = c0006adM150b;
        C0006ad c0006ad2 = c0006adM150b2;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fM2493a);
                view2.setTranslationY(-fM2502b);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            m2498a(view2, c0251a, c0006ad, c0006ad2, -fM2493a, -fM2502b, 0.0f, 0.0f, rectF);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fM2493a);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fM2502b);
        }
        c0006ad.m296a((Animator) objectAnimatorOfFloat);
        c0006ad2.m296a((Animator) objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: b */
    private void m2504b(View view, final View view2, boolean z, boolean z2, C0251a c0251a, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if ((view2 instanceof InterfaceC0194am) && (view instanceof ImageView)) {
            final InterfaceC0194am interfaceC0194am = (InterfaceC0194am) view2;
            final Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, C2286z.f13773a, 0);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(drawable, C2286z.f13773a, 255);
            }
            objectAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: android.support.design.transformation.FabTransformationBehavior.2
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    view2.invalidate();
                }
            });
            c0251a.f2290a.m150b("iconFade").m296a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
            list2.add(new AnimatorListenerAdapter() { // from class: android.support.design.transformation.FabTransformationBehavior.3
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animator) {
                    interfaceC0194am.setCircularRevealOverlayDrawable(drawable);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    interfaceC0194am.setCircularRevealOverlayDrawable(null);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    private void m2499a(View view, View view2, boolean z, boolean z2, C0251a c0251a, float f, float f2, List<Animator> list, List<Animator.AnimatorListener> list2) {
        C0006ad c0006ad;
        Animator animatorM1695a;
        if (view2 instanceof InterfaceC0194am) {
            final InterfaceC0194am interfaceC0194am = (InterfaceC0194am) view2;
            float fM2505c = m2505c(view, view2, c0251a.f2291b);
            float fM2508d = m2508d(view, view2, c0251a.f2291b);
            ((FloatingActionButton) view).m2761a(this.f2275a);
            float fWidth = this.f2275a.width() / 2.0f;
            C0006ad c0006adM150b = c0251a.f2290a.m150b("expansion");
            if (z) {
                if (!z2) {
                    interfaceC0194am.setRevealInfo(new InterfaceC0194am.d(fM2505c, fM2508d, fWidth));
                }
                float f3 = z2 ? interfaceC0194am.getRevealInfo().f1696c : fWidth;
                animatorM1695a = C0175ak.m1695a(interfaceC0194am, fM2505c, fM2508d, C0773bo.m5672a(fM2505c, fM2508d, 0.0f, 0.0f, f, f2));
                animatorM1695a.addListener(new AnimatorListenerAdapter() { // from class: android.support.design.transformation.FabTransformationBehavior.4
                    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        InterfaceC0194am.d revealInfo = interfaceC0194am.getRevealInfo();
                        revealInfo.f1696c = Float.MAX_VALUE;
                        interfaceC0194am.setRevealInfo(revealInfo);
                    }
                });
                m2495a(view2, c0006adM150b.m295a(), (int) fM2505c, (int) fM2508d, f3, list);
                c0006ad = c0006adM150b;
            } else {
                float f4 = interfaceC0194am.getRevealInfo().f1696c;
                Animator animatorM1695a2 = C0175ak.m1695a(interfaceC0194am, fM2505c, fM2508d, fWidth);
                int i = (int) fM2505c;
                int i2 = (int) fM2508d;
                m2495a(view2, c0006adM150b.m295a(), i, i2, f4, list);
                c0006ad = c0006adM150b;
                m2496a(view2, c0006adM150b.m295a(), c0006adM150b.m297b(), c0251a.f2290a.m147a(), i, i2, fWidth, list);
                animatorM1695a = animatorM1695a2;
            }
            c0006ad.m296a(animatorM1695a);
            list.add(animatorM1695a);
            list2.add(C0175ak.m1694a(interfaceC0194am));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: c */
    private void m2507c(View view, View view2, boolean z, boolean z2, C0251a c0251a, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator objectAnimatorOfInt;
        if (view2 instanceof InterfaceC0194am) {
            InterfaceC0194am interfaceC0194am = (InterfaceC0194am) view2;
            int iM2506c = m2506c(view);
            int i = 16777215 & iM2506c;
            if (z) {
                if (!z2) {
                    interfaceC0194am.setCircularRevealScrimColor(iM2506c);
                }
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC0194am, InterfaceC0194am.c.f1693a, i);
            } else {
                objectAnimatorOfInt = ObjectAnimator.ofInt(interfaceC0194am, InterfaceC0194am.c.f1693a, iM2506c);
            }
            objectAnimatorOfInt.setEvaluator(C2232x.m12205a());
            c0251a.f2290a.m150b("color").m296a((Animator) objectAnimatorOfInt);
            list.add(objectAnimatorOfInt);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2509d(View view, View view2, boolean z, boolean z2, C0251a c0251a, List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup viewGroupM2494a;
        ObjectAnimator objectAnimatorOfFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof InterfaceC0194am) && C0185al.f1545a == 0) || (viewGroupM2494a = m2494a(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    C2259y.f13656a.set(viewGroupM2494a, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupM2494a, C2259y.f13656a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupM2494a, C2259y.f13656a, 0.0f);
            }
            c0251a.f2290a.m150b("contentFade").m296a((Animator) objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    /* JADX INFO: renamed from: a */
    private float m2493a(View view, View view2, C0021ae c0021ae) {
        float fCenterX;
        RectF rectF = this.f2276b;
        RectF rectF2 = this.f2277c;
        m2497a(view, rectF);
        m2497a(view2, rectF2);
        int i = c0021ae.f499a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX() - rectF.centerX();
        } else if (i == 3) {
            fCenterX = rectF2.left - rectF.left;
        } else {
            fCenterX = i != 5 ? 0.0f : rectF2.right - rectF.right;
        }
        return fCenterX + c0021ae.f500b;
    }

    /* JADX INFO: renamed from: b */
    private float m2502b(View view, View view2, C0021ae c0021ae) {
        float fCenterY;
        RectF rectF = this.f2276b;
        RectF rectF2 = this.f2277c;
        m2497a(view, rectF);
        m2497a(view2, rectF2);
        int i = c0021ae.f499a & 112;
        if (i == 16) {
            fCenterY = rectF2.centerY() - rectF.centerY();
        } else if (i == 48) {
            fCenterY = rectF2.top - rectF.top;
        } else {
            fCenterY = i != 80 ? 0.0f : rectF2.bottom - rectF.bottom;
        }
        return fCenterY + c0021ae.f501c;
    }

    /* JADX INFO: renamed from: a */
    private void m2497a(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.f2278d);
        rectF.offsetTo(r0[0], r0[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    /* JADX INFO: renamed from: c */
    private float m2505c(View view, View view2, C0021ae c0021ae) {
        RectF rectF = this.f2276b;
        RectF rectF2 = this.f2277c;
        m2497a(view, rectF);
        m2497a(view2, rectF2);
        rectF2.offset(-m2493a(view, view2, c0021ae), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    /* JADX INFO: renamed from: d */
    private float m2508d(View view, View view2, C0021ae c0021ae) {
        RectF rectF = this.f2276b;
        RectF rectF2 = this.f2277c;
        m2497a(view, rectF);
        m2497a(view2, rectF2);
        rectF2.offset(0.0f, -m2502b(view, view2, c0021ae));
        return rectF.centerY() - rectF2.top;
    }

    /* JADX INFO: renamed from: a */
    private void m2498a(View view, C0251a c0251a, C0006ad c0006ad, C0006ad c0006ad2, float f, float f2, float f3, float f4, RectF rectF) {
        float fM2492a = m2492a(c0251a, c0006ad, f, f3);
        float fM2492a2 = m2492a(c0251a, c0006ad2, f2, f4);
        Rect rect = this.f2275a;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f2276b;
        rectF2.set(rect);
        RectF rectF3 = this.f2277c;
        m2497a(view, rectF3);
        rectF3.offset(fM2492a, fM2492a2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    /* JADX INFO: renamed from: a */
    private float m2492a(C0251a c0251a, C0006ad c0006ad, float f, float f2) {
        long jM295a = c0006ad.m295a();
        long jM297b = c0006ad.m297b();
        C0006ad c0006adM150b = c0251a.f2290a.m150b("expansion");
        return C2178v.m11881a(f, f2, c0006ad.m298c().getInterpolation((((c0006adM150b.m295a() + c0006adM150b.m297b()) + 17) - jM295a) / jM297b));
    }

    /* JADX INFO: renamed from: a */
    private ViewGroup m2494a(View view) {
        View viewFindViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (viewFindViewById != null) {
            return m2503b(viewFindViewById);
        }
        if ((view instanceof TransformationChildLayout) || (view instanceof TransformationChildCard)) {
            return m2503b(((ViewGroup) view).getChildAt(0));
        }
        return m2503b(view);
    }

    /* JADX INFO: renamed from: b */
    private ViewGroup m2503b(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    private int m2506c(View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    /* JADX INFO: renamed from: a */
    private void m2495a(View view, long j, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j <= 0) {
            return;
        }
        Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
        animatorCreateCircularReveal.setStartDelay(0L);
        animatorCreateCircularReveal.setDuration(j);
        list.add(animatorCreateCircularReveal);
    }

    /* JADX INFO: renamed from: a */
    private void m2496a(View view, long j, long j2, long j3, int i, int i2, float f, List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j4 = j + j2;
            if (j4 < j3) {
                Animator animatorCreateCircularReveal = ViewAnimationUtils.createCircularReveal(view, i, i2, f, f);
                animatorCreateCircularReveal.setStartDelay(j4);
                animatorCreateCircularReveal.setDuration(j3 - j4);
                list.add(animatorCreateCircularReveal);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.design.transformation.FabTransformationBehavior$a */
    public static class C0251a {

        /* JADX INFO: renamed from: a */
        public C0005ac f2290a;

        /* JADX INFO: renamed from: b */
        public C0021ae f2291b;

        protected C0251a() {
        }
    }
}
