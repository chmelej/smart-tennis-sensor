package android.support.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.transition.Transition;
import android.support.v4.content.res.TypedArrayUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import p000.C0791cf;
import p000.C1646cu;
import p000.C1650cy;
import p000.C1651cz;
import p000.C1658df;
import p000.C1664dl;
import p000.InterfaceC1657de;

/* JADX INFO: loaded from: classes.dex */
public abstract class Visibility extends Transition {

    /* JADX INFO: renamed from: a */
    private static final String[] f2942a = {"android:visibility:visibility", "android:visibility:parent"};

    /* JADX INFO: renamed from: i */
    private int f2943i;

    /* JADX INFO: renamed from: a */
    public Animator mo3035a(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        return null;
    }

    /* JADX INFO: renamed from: b */
    public Animator mo3036b(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        return null;
    }

    /* JADX INFO: renamed from: android.support.transition.Visibility$b */
    static class C0374b {

        /* JADX INFO: renamed from: a */
        boolean f2953a;

        /* JADX INFO: renamed from: b */
        boolean f2954b;

        /* JADX INFO: renamed from: c */
        int f2955c;

        /* JADX INFO: renamed from: d */
        int f2956d;

        /* JADX INFO: renamed from: e */
        ViewGroup f2957e;

        /* JADX INFO: renamed from: f */
        ViewGroup f2958f;

        C0374b() {
        }
    }

    public Visibility() {
        this.f2943i = 3;
    }

    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2943i = 3;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9336e);
        int namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        typedArrayObtainStyledAttributes.recycle();
        if (namedInt != 0) {
            m3118b(namedInt);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m3118b(int i) {
        if ((i & (-4)) != 0) {
            throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
        }
        this.f2943i = i;
    }

    /* JADX INFO: renamed from: r */
    public int m3119r() {
        return this.f2943i;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public String[] mo2983a() {
        return f2942a;
    }

    /* JADX INFO: renamed from: d */
    private void m3115d(C1651cz c1651cz) {
        c1651cz.f9356a.put("android:visibility:visibility", Integer.valueOf(c1651cz.f9357b.getVisibility()));
        c1651cz.f9356a.put("android:visibility:parent", c1651cz.f9357b.getParent());
        int[] iArr = new int[2];
        c1651cz.f9357b.getLocationOnScreen(iArr);
        c1651cz.f9356a.put("android:visibility:screenLocation", iArr);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        m3115d(c1651cz);
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        m3115d(c1651cz);
    }

    /* JADX INFO: renamed from: b */
    private C0374b m3114b(C1651cz c1651cz, C1651cz c1651cz2) {
        C0374b c0374b = new C0374b();
        c0374b.f2953a = false;
        c0374b.f2954b = false;
        if (c1651cz != null && c1651cz.f9356a.containsKey("android:visibility:visibility")) {
            c0374b.f2955c = ((Integer) c1651cz.f9356a.get("android:visibility:visibility")).intValue();
            c0374b.f2957e = (ViewGroup) c1651cz.f9356a.get("android:visibility:parent");
        } else {
            c0374b.f2955c = -1;
            c0374b.f2957e = null;
        }
        if (c1651cz2 != null && c1651cz2.f9356a.containsKey("android:visibility:visibility")) {
            c0374b.f2956d = ((Integer) c1651cz2.f9356a.get("android:visibility:visibility")).intValue();
            c0374b.f2958f = (ViewGroup) c1651cz2.f9356a.get("android:visibility:parent");
        } else {
            c0374b.f2956d = -1;
            c0374b.f2958f = null;
        }
        if (c1651cz != null && c1651cz2 != null) {
            if (c0374b.f2955c == c0374b.f2956d && c0374b.f2957e == c0374b.f2958f) {
                return c0374b;
            }
            if (c0374b.f2955c != c0374b.f2956d) {
                if (c0374b.f2955c == 0) {
                    c0374b.f2954b = false;
                    c0374b.f2953a = true;
                } else if (c0374b.f2956d == 0) {
                    c0374b.f2954b = true;
                    c0374b.f2953a = true;
                }
            } else if (c0374b.f2958f == null) {
                c0374b.f2954b = false;
                c0374b.f2953a = true;
            } else if (c0374b.f2957e == null) {
                c0374b.f2954b = true;
                c0374b.f2953a = true;
            }
        } else if (c1651cz == null && c0374b.f2956d == 0) {
            c0374b.f2954b = true;
            c0374b.f2953a = true;
        } else if (c1651cz2 == null && c0374b.f2955c == 0) {
            c0374b.f2954b = false;
            c0374b.f2953a = true;
        }
        return c0374b;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public Animator mo2980a(ViewGroup viewGroup, C1651cz c1651cz, C1651cz c1651cz2) {
        C0374b c0374bM3114b = m3114b(c1651cz, c1651cz2);
        if (!c0374bM3114b.f2953a) {
            return null;
        }
        if (c0374bM3114b.f2957e == null && c0374bM3114b.f2958f == null) {
            return null;
        }
        if (c0374bM3114b.f2954b) {
            return m3116a(viewGroup, c1651cz, c0374bM3114b.f2955c, c1651cz2, c0374bM3114b.f2956d);
        }
        return m3117b(viewGroup, c1651cz, c0374bM3114b.f2955c, c1651cz2, c0374bM3114b.f2956d);
    }

    /* JADX INFO: renamed from: a */
    public Animator m3116a(ViewGroup viewGroup, C1651cz c1651cz, int i, C1651cz c1651cz2, int i2) {
        if ((this.f2943i & 1) != 1 || c1651cz2 == null) {
            return null;
        }
        if (c1651cz == null) {
            View view = (View) c1651cz2.f9357b.getParent();
            if (m3114b(m3079b(view, false), m3065a(view, false)).f2953a) {
                return null;
            }
        }
        return mo3035a(viewGroup, c1651cz2.f9357b, c1651cz, c1651cz2);
    }

    /* JADX INFO: renamed from: b */
    public Animator m3117b(ViewGroup viewGroup, C1651cz c1651cz, int i, C1651cz c1651cz2, int i2) {
        int id;
        if ((this.f2943i & 2) != 2) {
            return null;
        }
        final View viewM8828a = c1651cz != null ? c1651cz.f9357b : null;
        View view = c1651cz2 != null ? c1651cz2.f9357b : null;
        if (view == null || view.getParent() == null) {
            if (view != null) {
                viewM8828a = view;
            } else {
                if (viewM8828a != null) {
                    if (viewM8828a.getParent() != null) {
                        if (viewM8828a.getParent() instanceof View) {
                            View view2 = (View) viewM8828a.getParent();
                            if (!m3114b(m3065a(view2, true), m3079b(view2, true)).f2953a) {
                                viewM8828a = C1650cy.m8828a(viewGroup, viewM8828a, view2);
                            } else if (view2.getParent() != null || (id = view2.getId()) == -1 || viewGroup.findViewById(id) == null || !this.f2906f) {
                                viewM8828a = null;
                            }
                        }
                    }
                }
                viewM8828a = null;
                view = null;
            }
            view = null;
        } else if (i2 == 4 || viewM8828a == view) {
            viewM8828a = null;
        } else {
            if (!this.f2906f) {
                viewM8828a = C1650cy.m8828a(viewGroup, viewM8828a, (View) viewM8828a.getParent());
            }
            view = null;
        }
        if (viewM8828a == null || c1651cz == null) {
            if (view == null) {
                return null;
            }
            int visibility = view.getVisibility();
            C1664dl.m8863a(view, 0);
            Animator animatorMo3036b = mo3036b(viewGroup, view, c1651cz, c1651cz2);
            if (animatorMo3036b != null) {
                C0373a c0373a = new C0373a(view, i2, true);
                animatorMo3036b.addListener(c0373a);
                C0791cf.m5780a(animatorMo3036b, c0373a);
                mo3064a(c0373a);
            } else {
                C1664dl.m8863a(view, visibility);
            }
            return animatorMo3036b;
        }
        int[] iArr = (int[]) c1651cz.f9356a.get("android:visibility:screenLocation");
        int i3 = iArr[0];
        int i4 = iArr[1];
        int[] iArr2 = new int[2];
        viewGroup.getLocationOnScreen(iArr2);
        viewM8828a.offsetLeftAndRight((i3 - iArr2[0]) - viewM8828a.getLeft());
        viewM8828a.offsetTopAndBottom((i4 - iArr2[1]) - viewM8828a.getTop());
        final InterfaceC1657de interfaceC1657deM8846a = C1658df.m8846a(viewGroup);
        interfaceC1657deM8846a.mo8837a(viewM8828a);
        Animator animatorMo3036b2 = mo3036b(viewGroup, viewM8828a, c1651cz, c1651cz2);
        if (animatorMo3036b2 == null) {
            interfaceC1657deM8846a.mo8838b(viewM8828a);
        } else {
            animatorMo3036b2.addListener(new AnimatorListenerAdapter() { // from class: android.support.transition.Visibility.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    interfaceC1657deM8846a.mo8838b(viewM8828a);
                }
            });
        }
        return animatorMo3036b2;
    }

    @Override // android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public boolean mo3075a(C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz == null && c1651cz2 == null) {
            return false;
        }
        if (c1651cz != null && c1651cz2 != null && c1651cz2.f9356a.containsKey("android:visibility:visibility") != c1651cz.f9356a.containsKey("android:visibility:visibility")) {
            return false;
        }
        C0374b c0374bM3114b = m3114b(c1651cz, c1651cz2);
        if (c0374bM3114b.f2953a) {
            return c0374bM3114b.f2955c == 0 || c0374bM3114b.f2956d == 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: android.support.transition.Visibility$a */
    static class C0373a extends AnimatorListenerAdapter implements Transition.InterfaceC0369c, C0791cf.a {

        /* JADX INFO: renamed from: a */
        boolean f2947a = false;

        /* JADX INFO: renamed from: b */
        private final View f2948b;

        /* JADX INFO: renamed from: c */
        private final int f2949c;

        /* JADX INFO: renamed from: d */
        private final ViewGroup f2950d;

        /* JADX INFO: renamed from: e */
        private final boolean f2951e;

        /* JADX INFO: renamed from: f */
        private boolean f2952f;

        @Override // android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: d */
        public void mo3041d(Transition transition) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }

        C0373a(View view, int i, boolean z) {
            this.f2948b = view;
            this.f2949c = i;
            this.f2950d = (ViewGroup) view.getParent();
            this.f2951e = z;
            m3121a(true);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, p000.C0791cf.a
        public void onAnimationPause(Animator animator) {
            if (this.f2947a) {
                return;
            }
            C1664dl.m8863a(this.f2948b, this.f2949c);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener, p000.C0791cf.a
        public void onAnimationResume(Animator animator) {
            if (this.f2947a) {
                return;
            }
            C1664dl.m8863a(this.f2948b, 0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f2947a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m3120a();
        }

        @Override // android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: a */
        public void mo2987a(Transition transition) {
            m3120a();
            transition.mo3078b(this);
        }

        @Override // android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: b */
        public void mo2988b(Transition transition) {
            m3121a(false);
        }

        @Override // android.support.transition.Transition.InterfaceC0369c
        /* JADX INFO: renamed from: c */
        public void mo2989c(Transition transition) {
            m3121a(true);
        }

        /* JADX INFO: renamed from: a */
        private void m3120a() {
            if (!this.f2947a) {
                C1664dl.m8863a(this.f2948b, this.f2949c);
                if (this.f2950d != null) {
                    this.f2950d.invalidate();
                }
            }
            m3121a(false);
        }

        /* JADX INFO: renamed from: a */
        private void m3121a(boolean z) {
            if (!this.f2951e || this.f2952f == z || this.f2950d == null) {
                return;
            }
            this.f2952f = z;
            C1658df.m8847a(this.f2950d, z);
        }
    }
}
