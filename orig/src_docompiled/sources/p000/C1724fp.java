package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: renamed from: fp */
/* JADX INFO: compiled from: AppCompatBackgroundHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1724fp {

    /* JADX INFO: renamed from: a */
    private final View f9842a;

    /* JADX INFO: renamed from: d */
    private C1764hb f9845d;

    /* JADX INFO: renamed from: e */
    private C1764hb f9846e;

    /* JADX INFO: renamed from: f */
    private C1764hb f9847f;

    /* JADX INFO: renamed from: c */
    private int f9844c = -1;

    /* JADX INFO: renamed from: b */
    private final C1726fr f9843b = C1726fr.m9237a();

    public C1724fp(View view) {
        this.f9842a = view;
    }

    /* JADX INFO: renamed from: a */
    public void m9219a(AttributeSet attributeSet, int i) {
        C1766hd c1766hdM9601a = C1766hd.m9601a(this.f9842a.getContext(), attributeSet, R.styleable.ViewBackgroundHelper, i, 0);
        try {
            if (c1766hdM9601a.m9620g(R.styleable.ViewBackgroundHelper_android_background)) {
                this.f9844c = c1766hdM9601a.m9619g(R.styleable.ViewBackgroundHelper_android_background, -1);
                ColorStateList colorStateListM9260b = this.f9843b.m9260b(this.f9842a.getContext(), this.f9844c);
                if (colorStateListM9260b != null) {
                    m9221b(colorStateListM9260b);
                }
            }
            if (c1766hdM9601a.m9620g(R.styleable.ViewBackgroundHelper_backgroundTint)) {
                ViewCompat.setBackgroundTintList(this.f9842a, c1766hdM9601a.m9616e(R.styleable.ViewBackgroundHelper_backgroundTint));
            }
            if (c1766hdM9601a.m9620g(R.styleable.ViewBackgroundHelper_backgroundTintMode)) {
                ViewCompat.setBackgroundTintMode(this.f9842a, C1743gh.m9425a(c1766hdM9601a.m9603a(R.styleable.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
        } finally {
            c1766hdM9601a.m9606a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9215a(int i) {
        this.f9844c = i;
        m9221b(this.f9843b != null ? this.f9843b.m9260b(this.f9842a.getContext(), i) : null);
        m9222c();
    }

    /* JADX INFO: renamed from: a */
    public void m9218a(Drawable drawable) {
        this.f9844c = -1;
        m9221b((ColorStateList) null);
        m9222c();
    }

    /* JADX INFO: renamed from: a */
    public void m9216a(ColorStateList colorStateList) {
        if (this.f9846e == null) {
            this.f9846e = new C1764hb();
        }
        this.f9846e.f10138a = colorStateList;
        this.f9846e.f10141d = true;
        m9222c();
    }

    /* JADX INFO: renamed from: a */
    public ColorStateList m9214a() {
        if (this.f9846e != null) {
            return this.f9846e.f10138a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m9217a(PorterDuff.Mode mode) {
        if (this.f9846e == null) {
            this.f9846e = new C1764hb();
        }
        this.f9846e.f10139b = mode;
        this.f9846e.f10140c = true;
        m9222c();
    }

    /* JADX INFO: renamed from: b */
    public PorterDuff.Mode m9220b() {
        if (this.f9846e != null) {
            return this.f9846e.f10139b;
        }
        return null;
    }

    /* JADX INFO: renamed from: c */
    public void m9222c() {
        Drawable background = this.f9842a.getBackground();
        if (background != null) {
            if (m9213d() && m9212b(background)) {
                return;
            }
            if (this.f9846e != null) {
                C1726fr.m9240a(background, this.f9846e, this.f9842a.getDrawableState());
            } else if (this.f9845d != null) {
                C1726fr.m9240a(background, this.f9845d, this.f9842a.getDrawableState());
            }
        }
    }

    /* JADX INFO: renamed from: b */
    void m9221b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f9845d == null) {
                this.f9845d = new C1764hb();
            }
            this.f9845d.f10138a = colorStateList;
            this.f9845d.f10141d = true;
        } else {
            this.f9845d = null;
        }
        m9222c();
    }

    /* JADX INFO: renamed from: d */
    private boolean m9213d() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f9845d != null : i == 21;
    }

    /* JADX INFO: renamed from: b */
    private boolean m9212b(Drawable drawable) {
        if (this.f9847f == null) {
            this.f9847f = new C1764hb();
        }
        C1764hb c1764hb = this.f9847f;
        c1764hb.m9598a();
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(this.f9842a);
        if (backgroundTintList != null) {
            c1764hb.f10141d = true;
            c1764hb.f10138a = backgroundTintList;
        }
        PorterDuff.Mode backgroundTintMode = ViewCompat.getBackgroundTintMode(this.f9842a);
        if (backgroundTintMode != null) {
            c1764hb.f10140c = true;
            c1764hb.f10139b = backgroundTintMode;
        }
        if (!c1764hb.f10141d && !c1764hb.f10140c) {
            return false;
        }
        C1726fr.m9240a(drawable, c1764hb, this.f9842a.getDrawableState());
        return true;
    }
}
