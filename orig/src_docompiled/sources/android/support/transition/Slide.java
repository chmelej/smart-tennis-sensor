package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import org.xmlpull.v1.XmlPullParser;
import p000.C1645ct;
import p000.C1646cu;
import p000.C1651cz;
import p000.C1654db;

/* JADX INFO: loaded from: classes.dex */
public class Slide extends Visibility {

    /* JADX INFO: renamed from: a */
    private static final TimeInterpolator f2880a = new DecelerateInterpolator();

    /* JADX INFO: renamed from: i */
    private static final TimeInterpolator f2881i = new AccelerateInterpolator();

    /* JADX INFO: renamed from: l */
    private static final InterfaceC0361a f2882l = new AbstractC0362b() { // from class: android.support.transition.Slide.1
        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: a */
        public float mo3046a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: m */
    private static final InterfaceC0361a f2883m = new AbstractC0362b() { // from class: android.support.transition.Slide.2
        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: a */
        public float mo3046a(ViewGroup viewGroup, View view) {
            if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                return view.getTranslationX() + viewGroup.getWidth();
            }
            return view.getTranslationX() - viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: n */
    private static final InterfaceC0361a f2884n = new AbstractC0363c() { // from class: android.support.transition.Slide.3
        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: b */
        public float mo3047b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() - viewGroup.getHeight();
        }
    };

    /* JADX INFO: renamed from: o */
    private static final InterfaceC0361a f2885o = new AbstractC0362b() { // from class: android.support.transition.Slide.4
        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: a */
        public float mo3046a(ViewGroup viewGroup, View view) {
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: p */
    private static final InterfaceC0361a f2886p = new AbstractC0362b() { // from class: android.support.transition.Slide.5
        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: a */
        public float mo3046a(ViewGroup viewGroup, View view) {
            if (ViewCompat.getLayoutDirection(viewGroup) == 1) {
                return view.getTranslationX() - viewGroup.getWidth();
            }
            return view.getTranslationX() + viewGroup.getWidth();
        }
    };

    /* JADX INFO: renamed from: q */
    private static final InterfaceC0361a f2887q = new AbstractC0363c() { // from class: android.support.transition.Slide.6
        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: b */
        public float mo3047b(ViewGroup viewGroup, View view) {
            return view.getTranslationY() + viewGroup.getHeight();
        }
    };

    /* JADX INFO: renamed from: j */
    private InterfaceC0361a f2888j;

    /* JADX INFO: renamed from: k */
    private int f2889k;

    /* JADX INFO: renamed from: android.support.transition.Slide$a */
    interface InterfaceC0361a {
        /* JADX INFO: renamed from: a */
        float mo3046a(ViewGroup viewGroup, View view);

        /* JADX INFO: renamed from: b */
        float mo3047b(ViewGroup viewGroup, View view);
    }

    /* JADX INFO: renamed from: android.support.transition.Slide$b */
    static abstract class AbstractC0362b implements InterfaceC0361a {
        private AbstractC0362b() {
        }

        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: b */
        public float mo3047b(ViewGroup viewGroup, View view) {
            return view.getTranslationY();
        }
    }

    /* JADX INFO: renamed from: android.support.transition.Slide$c */
    static abstract class AbstractC0363c implements InterfaceC0361a {
        private AbstractC0363c() {
        }

        @Override // android.support.transition.Slide.InterfaceC0361a
        /* JADX INFO: renamed from: a */
        public float mo3046a(ViewGroup viewGroup, View view) {
            return view.getTranslationX();
        }
    }

    public Slide() {
        this.f2888j = f2887q;
        this.f2889k = 80;
        m3045a(80);
    }

    public Slide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2888j = f2887q;
        this.f2889k = 80;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1646cu.f9339h);
        int namedInt = TypedArrayUtils.getNamedInt(typedArrayObtainStyledAttributes, (XmlPullParser) attributeSet, "slideEdge", 0, 80);
        typedArrayObtainStyledAttributes.recycle();
        m3045a(namedInt);
    }

    /* JADX INFO: renamed from: d */
    private void m3044d(C1651cz c1651cz) {
        int[] iArr = new int[2];
        c1651cz.f9357b.getLocationOnScreen(iArr);
        c1651cz.f9356a.put("android:slide:screenPosition", iArr);
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        super.mo2981a(c1651cz);
        m3044d(c1651cz);
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        super.mo2984b(c1651cz);
        m3044d(c1651cz);
    }

    /* JADX INFO: renamed from: a */
    public void m3045a(int i) {
        if (i == 3) {
            this.f2888j = f2882l;
        } else if (i == 5) {
            this.f2888j = f2885o;
        } else if (i == 48) {
            this.f2888j = f2884n;
        } else if (i == 80) {
            this.f2888j = f2887q;
        } else if (i == 8388611) {
            this.f2888j = f2883m;
        } else if (i == 8388613) {
            this.f2888j = f2886p;
        } else {
            throw new IllegalArgumentException("Invalid slide direction");
        }
        this.f2889k = i;
        C1645ct c1645ct = new C1645ct();
        c1645ct.m8818a(i);
        mo3073a(c1645ct);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: a */
    public Animator mo3035a(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz2 == null) {
            return null;
        }
        int[] iArr = (int[]) c1651cz2.f9356a.get("android:slide:screenPosition");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        return C1654db.m8835a(view, c1651cz2, iArr[0], iArr[1], this.f2888j.mo3046a(viewGroup, view), this.f2888j.mo3047b(viewGroup, view), translationX, translationY, f2880a);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: b */
    public Animator mo3036b(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz == null) {
            return null;
        }
        int[] iArr = (int[]) c1651cz.f9356a.get("android:slide:screenPosition");
        return C1654db.m8835a(view, c1651cz, iArr[0], iArr[1], view.getTranslationX(), view.getTranslationY(), this.f2888j.mo3046a(viewGroup, view), this.f2888j.mo3047b(viewGroup, view), f2881i);
    }
}
