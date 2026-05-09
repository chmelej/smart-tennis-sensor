package p000;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.v4.widget.ImageViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX INFO: renamed from: ft */
/* JADX INFO: compiled from: AppCompatImageHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1728ft {

    /* JADX INFO: renamed from: a */
    private final ImageView f9869a;

    /* JADX INFO: renamed from: b */
    private C1764hb f9870b;

    /* JADX INFO: renamed from: c */
    private C1764hb f9871c;

    /* JADX INFO: renamed from: d */
    private C1764hb f9872d;

    public C1728ft(ImageView imageView) {
        this.f9869a = imageView;
    }

    /* JADX INFO: renamed from: a */
    public void m9271a(AttributeSet attributeSet, int i) {
        int iM9619g;
        C1766hd c1766hdM9601a = C1766hd.m9601a(this.f9869a.getContext(), attributeSet, R.styleable.AppCompatImageView, i, 0);
        try {
            Drawable drawable = this.f9869a.getDrawable();
            if (drawable == null && (iM9619g = c1766hdM9601a.m9619g(R.styleable.AppCompatImageView_srcCompat, -1)) != -1 && (drawable = C1684ee.m8975b(this.f9869a.getContext(), iM9619g)) != null) {
                this.f9869a.setImageDrawable(drawable);
            }
            if (drawable != null) {
                C1743gh.m9427b(drawable);
            }
            if (c1766hdM9601a.m9620g(R.styleable.AppCompatImageView_tint)) {
                ImageViewCompat.setImageTintList(this.f9869a, c1766hdM9601a.m9616e(R.styleable.AppCompatImageView_tint));
            }
            if (c1766hdM9601a.m9620g(R.styleable.AppCompatImageView_tintMode)) {
                ImageViewCompat.setImageTintMode(this.f9869a, C1743gh.m9425a(c1766hdM9601a.m9603a(R.styleable.AppCompatImageView_tintMode, -1), null));
            }
        } finally {
            c1766hdM9601a.m9606a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9268a(int i) {
        if (i != 0) {
            Drawable drawableM8975b = C1684ee.m8975b(this.f9869a.getContext(), i);
            if (drawableM8975b != null) {
                C1743gh.m9427b(drawableM8975b);
            }
            this.f9869a.setImageDrawable(drawableM8975b);
        } else {
            this.f9869a.setImageDrawable(null);
        }
        m9275d();
    }

    /* JADX INFO: renamed from: a */
    public boolean m9272a() {
        return Build.VERSION.SDK_INT < 21 || !(this.f9869a.getBackground() instanceof RippleDrawable);
    }

    /* JADX INFO: renamed from: a */
    public void m9269a(ColorStateList colorStateList) {
        if (this.f9871c == null) {
            this.f9871c = new C1764hb();
        }
        this.f9871c.f10138a = colorStateList;
        this.f9871c.f10141d = true;
        m9275d();
    }

    /* JADX INFO: renamed from: b */
    public ColorStateList m9273b() {
        if (this.f9871c != null) {
            return this.f9871c.f10138a;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m9270a(PorterDuff.Mode mode) {
        if (this.f9871c == null) {
            this.f9871c = new C1764hb();
        }
        this.f9871c.f10139b = mode;
        this.f9871c.f10140c = true;
        m9275d();
    }

    /* JADX INFO: renamed from: c */
    public PorterDuff.Mode m9274c() {
        if (this.f9871c != null) {
            return this.f9871c.f10139b;
        }
        return null;
    }

    /* JADX INFO: renamed from: d */
    public void m9275d() {
        Drawable drawable = this.f9869a.getDrawable();
        if (drawable != null) {
            C1743gh.m9427b(drawable);
        }
        if (drawable != null) {
            if (m9267e() && m9266a(drawable)) {
                return;
            }
            if (this.f9871c != null) {
                C1726fr.m9240a(drawable, this.f9871c, this.f9869a.getDrawableState());
            } else if (this.f9870b != null) {
                C1726fr.m9240a(drawable, this.f9870b, this.f9869a.getDrawableState());
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m9267e() {
        int i = Build.VERSION.SDK_INT;
        return i > 21 ? this.f9870b != null : i == 21;
    }

    /* JADX INFO: renamed from: a */
    private boolean m9266a(Drawable drawable) {
        if (this.f9872d == null) {
            this.f9872d = new C1764hb();
        }
        C1764hb c1764hb = this.f9872d;
        c1764hb.m9598a();
        ColorStateList imageTintList = ImageViewCompat.getImageTintList(this.f9869a);
        if (imageTintList != null) {
            c1764hb.f10141d = true;
            c1764hb.f10138a = imageTintList;
        }
        PorterDuff.Mode imageTintMode = ImageViewCompat.getImageTintMode(this.f9869a);
        if (imageTintMode != null) {
            c1764hb.f10140c = true;
            c1764hb.f10139b = imageTintMode;
        }
        if (!c1764hb.f10141d && !c1764hb.f10140c) {
            return false;
        }
        C1726fr.m9240a(drawable, c1764hb, this.f9869a.getDrawableState());
        return true;
    }
}
