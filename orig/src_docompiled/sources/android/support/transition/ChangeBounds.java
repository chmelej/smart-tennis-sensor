package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import java.util.Map;
import p000.C0986co;
import p000.C1642cq;
import p000.C1643cr;
import p000.C1646cu;
import p000.C1647cv;
import p000.C1650cy;
import p000.C1651cz;
import p000.C1658df;
import p000.C1664dl;

/* JADX INFO: loaded from: classes.dex */
public class ChangeBounds extends Transition {

    /* JADX INFO: renamed from: a */
    private static final String[] f2781a = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};

    /* JADX INFO: renamed from: i */
    private static final Property<Drawable, PointF> f2782i = new Property<Drawable, PointF>(PointF.class, "boundsOrigin") { // from class: android.support.transition.ChangeBounds.1

        /* JADX INFO: renamed from: a */
        private Rect f2792a = new Rect();

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(Drawable drawable, PointF pointF) {
            drawable.copyBounds(this.f2792a);
            this.f2792a.offsetTo(Math.round(pointF.x), Math.round(pointF.y));
            drawable.setBounds(this.f2792a);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(Drawable drawable) {
            drawable.copyBounds(this.f2792a);
            return new PointF(this.f2792a.left, this.f2792a.top);
        }
    };

    /* JADX INFO: renamed from: j */
    private static final Property<C0338a, PointF> f2783j = new Property<C0338a, PointF>(PointF.class, "topLeft") { // from class: android.support.transition.ChangeBounds.3
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(C0338a c0338a) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(C0338a c0338a, PointF pointF) {
            c0338a.m3001a(pointF);
        }
    };

    /* JADX INFO: renamed from: k */
    private static final Property<C0338a, PointF> f2784k = new Property<C0338a, PointF>(PointF.class, "bottomRight") { // from class: android.support.transition.ChangeBounds.4
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(C0338a c0338a) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(C0338a c0338a, PointF pointF) {
            c0338a.m3002b(pointF);
        }
    };

    /* JADX INFO: renamed from: l */
    private static final Property<View, PointF> f2785l = new Property<View, PointF>(PointF.class, "bottomRight") { // from class: android.support.transition.ChangeBounds.5
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            C1664dl.m8864a(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    };

    /* JADX INFO: renamed from: m */
    private static final Property<View, PointF> f2786m = new Property<View, PointF>(PointF.class, "topLeft") { // from class: android.support.transition.ChangeBounds.6
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            C1664dl.m8864a(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    };

    /* JADX INFO: renamed from: n */
    private static final Property<View, PointF> f2787n = new Property<View, PointF>(PointF.class, "position") { // from class: android.support.transition.ChangeBounds.7
        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            C1664dl.m8864a(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    };

    /* JADX INFO: renamed from: r */
    private static C1643cr f2788r = new C1643cr();

    /* JADX INFO: renamed from: o */
    private int[] f2789o;

    /* JADX INFO: renamed from: p */
    private boolean f2790p;

    /* JADX INFO: renamed from: q */
    private boolean f2791q;

    public ChangeBounds() {
        this.f2789o = new int[2];
        this.f2790p = false;
        this.f2791q = false;
    }

    public ChangeBounds(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2789o = new int[2];
        this.f2790p = false;
        this.f2791q = false;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9335d);
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "resizeClip", 0, false);
        typedArrayObtainStyledAttributes.recycle();
        m2982a(namedBoolean);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return f2781a;
    }

    /* JADX INFO: renamed from: a */
    public void m2982a(boolean z) {
        this.f2790p = z;
    }

    /* JADX INFO: renamed from: d */
    private void m2979d(C1651cz c1651cz) {
        View view = c1651cz.f9357b;
        if (!ViewCompat.isLaidOut(view) && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        c1651cz.f9356a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        c1651cz.f9356a.put("android:changeBounds:parent", c1651cz.f9357b.getParent());
        if (this.f2791q) {
            c1651cz.f9357b.getLocationInWindow(this.f2789o);
            c1651cz.f9356a.put("android:changeBounds:windowX", Integer.valueOf(this.f2789o[0]));
            c1651cz.f9356a.put("android:changeBounds:windowY", Integer.valueOf(this.f2789o[1]));
        }
        if (this.f2790p) {
            c1651cz.f9356a.put("android:changeBounds:clip", ViewCompat.getClipBounds(view));
        }
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m2979d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m2979d(c1651cz);
    }

    /* JADX INFO: renamed from: a */
    private boolean m2978a(View view, View view2) {
        if (!this.f2791q) {
            return true;
        }
        C1651cz c1651czB = m3079b(view, true);
        if (c1651czB == null) {
            if (view == view2) {
                return true;
            }
        } else if (view2 == c1651czB.f9357b) {
            return true;
        }
        return false;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(final ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        int i;
        final View view;
        int i2;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorM8826a;
        if (c1651cz == null || c1651cz2 == null) {
            return null;
        }
        Map<String, Object> map = c1651cz.f9356a;
        Map<String, Object> map2 = c1651cz2.f9356a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        final View view2 = c1651cz2.f9357b;
        if (m2978a(viewGroup2, viewGroup3)) {
            Rect rect2 = (Rect) c1651cz.f9356a.get("android:changeBounds:bounds");
            Rect rect3 = (Rect) c1651cz2.f9356a.get("android:changeBounds:bounds");
            int i3 = rect2.left;
            final int i4 = rect3.left;
            int i5 = rect2.top;
            final int i6 = rect3.top;
            int i7 = rect2.right;
            final int i8 = rect3.right;
            int i9 = rect2.bottom;
            final int i10 = rect3.bottom;
            int i11 = i7 - i3;
            int i12 = i9 - i5;
            int i13 = i8 - i4;
            int i14 = i10 - i6;
            Rect rect4 = (Rect) c1651cz.f9356a.get("android:changeBounds:clip");
            final Rect rect5 = (Rect) c1651cz2.f9356a.get("android:changeBounds:clip");
            if ((i11 == 0 || i12 == 0) && (i13 == 0 || i14 == 0)) {
                i = 0;
            } else {
                i = (i3 == i4 && i5 == i6) ? 0 : 1;
                if (i7 != i8 || i9 != i10) {
                    i++;
                }
            }
            if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
                i++;
            }
            if (i <= 0) {
                return null;
            }
            if (!this.f2790p) {
                view = view2;
                C1664dl.m8864a(view, i3, i5, i7, i9);
                if (i == 2) {
                    if (i11 == i13 && i12 == i14) {
                        animatorM8826a = C0986co.m6846a(view, f2787n, m3096l().mo2973a(i3, i5, i4, i6));
                    } else {
                        final C0338a c0338a = new C0338a(view);
                        ObjectAnimator objectAnimatorM6846a = C0986co.m6846a(c0338a, f2783j, m3096l().mo2973a(i3, i5, i4, i6));
                        ObjectAnimator objectAnimatorM6846a2 = C0986co.m6846a(c0338a, f2784k, m3096l().mo2973a(i7, i9, i8, i10));
                        AnimatorSet animatorSet = new AnimatorSet();
                        animatorSet.playTogether(objectAnimatorM6846a, objectAnimatorM6846a2);
                        animatorSet.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.8
                            private C0338a mViewBounds;

                            {
                                this.mViewBounds = c0338a;
                            }
                        });
                        animatorM8826a = animatorSet;
                    }
                } else if (i3 != i4 || i5 != i6) {
                    animatorM8826a = C0986co.m6846a(view, f2786m, m3096l().mo2973a(i3, i5, i4, i6));
                } else {
                    animatorM8826a = C0986co.m6846a(view, f2785l, m3096l().mo2973a(i7, i9, i8, i10));
                }
            } else {
                view = view2;
                C1664dl.m8864a(view, i3, i5, Math.max(i11, i13) + i3, Math.max(i12, i14) + i5);
                ObjectAnimator objectAnimatorM6846a3 = (i3 == i4 && i5 == i6) ? null : C0986co.m6846a(view, f2787n, m3096l().mo2973a(i3, i5, i4, i6));
                if (rect4 == null) {
                    i2 = 0;
                    rect = new Rect(0, 0, i11, i12);
                } else {
                    i2 = 0;
                    rect = rect4;
                }
                Rect rect6 = rect5 == null ? new Rect(i2, i2, i13, i14) : rect5;
                if (rect.equals(rect6)) {
                    objectAnimatorOfObject = null;
                } else {
                    ViewCompat.setClipBounds(view, rect);
                    C1643cr c1643cr = f2788r;
                    Object[] objArr = new Object[2];
                    objArr[i2] = rect;
                    objArr[1] = rect6;
                    objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", c1643cr, objArr);
                    objectAnimatorOfObject.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.9

                        /* JADX INFO: renamed from: h */
                        private boolean f2810h;

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationCancel(Animator animator) {
                            this.f2810h = true;
                        }

                        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                        public void onAnimationEnd(Animator animator) {
                            if (this.f2810h) {
                                return;
                            }
                            ViewCompat.setClipBounds(view, rect5);
                            C1664dl.m8864a(view, i4, i6, i8, i10);
                        }
                    });
                }
                animatorM8826a = C1650cy.m8826a(objectAnimatorM6846a3, objectAnimatorOfObject);
            }
            if (view.getParent() instanceof ViewGroup) {
                final ViewGroup viewGroup4 = (ViewGroup) view.getParent();
                C1658df.m8847a(viewGroup4, true);
                mo3064a(new C1647cv() { // from class: android.support.transition.ChangeBounds.10

                    /* JADX INFO: renamed from: a */
                    boolean f2793a = false;

                    @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
                    /* JADX INFO: renamed from: a */
                    public void mo2987a(Transition transition) {
                        if (!this.f2793a) {
                            C1658df.m8847a(viewGroup4, false);
                        }
                        transition.mo3078b(this);
                    }

                    @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
                    /* JADX INFO: renamed from: b */
                    public void mo2988b(Transition transition) {
                        C1658df.m8847a(viewGroup4, false);
                    }

                    @Override // p000.C1647cv, android.support.transition.Transition.InterfaceC0369c
                    /* JADX INFO: renamed from: c */
                    public void mo2989c(Transition transition) {
                        C1658df.m8847a(viewGroup4, true);
                    }
                });
            }
            return animatorM8826a;
        }
        int iIntValue = ((Integer) c1651cz.f9356a.get("android:changeBounds:windowX")).intValue();
        int iIntValue2 = ((Integer) c1651cz.f9356a.get("android:changeBounds:windowY")).intValue();
        int iIntValue3 = ((Integer) c1651cz2.f9356a.get("android:changeBounds:windowX")).intValue();
        int iIntValue4 = ((Integer) c1651cz2.f9356a.get("android:changeBounds:windowY")).intValue();
        if (iIntValue == iIntValue3 && iIntValue2 == iIntValue4) {
            return null;
        }
        viewGroup.getLocationInWindow(this.f2789o);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
        view2.draw(new Canvas(bitmapCreateBitmap));
        final BitmapDrawable bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
        final float fM8868c = C1664dl.m8868c(view2);
        C1664dl.m8862a(view2, 0.0f);
        C1664dl.m8860a(viewGroup).mo8839a(bitmapDrawable);
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(bitmapDrawable, C1642cq.m8811a(f2782i, m3096l().mo2973a(iIntValue - this.f2789o[0], iIntValue2 - this.f2789o[1], iIntValue3 - this.f2789o[0], iIntValue4 - this.f2789o[1])));
        objectAnimatorOfPropertyValuesHolder.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.ChangeBounds.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                C1664dl.m8860a(viewGroup).mo8840b(bitmapDrawable);
                C1664dl.m8862a(view2, fM8868c);
            }
        });
        return objectAnimatorOfPropertyValuesHolder;
    }

    /* JADX INFO: renamed from: android.support.transition.ChangeBounds$a */
    static class C0338a {

        /* JADX INFO: renamed from: a */
        private int f2811a;

        /* JADX INFO: renamed from: b */
        private int f2812b;

        /* JADX INFO: renamed from: c */
        private int f2813c;

        /* JADX INFO: renamed from: d */
        private int f2814d;

        /* JADX INFO: renamed from: e */
        private View f2815e;

        /* JADX INFO: renamed from: f */
        private int f2816f;

        /* JADX INFO: renamed from: g */
        private int f2817g;

        C0338a(View view) {
            this.f2815e = view;
        }

        /* JADX INFO: renamed from: a */
        void m3001a(PointF pointF) {
            this.f2811a = Math.round(pointF.x);
            this.f2812b = Math.round(pointF.y);
            this.f2816f++;
            if (this.f2816f == this.f2817g) {
                m3000a();
            }
        }

        /* JADX INFO: renamed from: b */
        void m3002b(PointF pointF) {
            this.f2813c = Math.round(pointF.x);
            this.f2814d = Math.round(pointF.y);
            this.f2817g++;
            if (this.f2816f == this.f2817g) {
                m3000a();
            }
        }

        /* JADX INFO: renamed from: a */
        private void m3000a() {
            C1664dl.m8864a(this.f2815e, this.f2811a, this.f2812b, this.f2813c, this.f2814d);
            this.f2816f = 0;
            this.f2817g = 0;
        }
    }
}
