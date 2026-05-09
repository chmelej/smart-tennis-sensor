package android.support.transition;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import p000.C0792cg;
import p000.C1651cz;
import p000.C1654db;

/* JADX INFO: loaded from: classes.dex */
public class Explode extends Visibility {

    /* JADX INFO: renamed from: a */
    private static final TimeInterpolator f2856a = new DecelerateInterpolator();

    /* JADX INFO: renamed from: i */
    private static final TimeInterpolator f2857i = new AccelerateInterpolator();

    /* JADX INFO: renamed from: j */
    private int[] f2858j;

    public Explode() {
        this.f2858j = new int[2];
        mo3073a(new C0792cg());
    }

    public Explode(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2858j = new int[2];
        mo3073a(new C0792cg());
    }

    /* JADX INFO: renamed from: d */
    private void m3034d(C1651cz c1651cz) {
        View view = c1651cz.f9357b;
        view.getLocationOnScreen(this.f2858j);
        int i = this.f2858j[0];
        int i2 = this.f2858j[1];
        c1651cz.f9356a.put("android:explode:screenBounds", new Rect(i, i2, view.getWidth() + i, view.getHeight() + i2));
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: a */
    public void mo2981a(C1651cz c1651cz) {
        super.mo2981a(c1651cz);
        m3034d(c1651cz);
    }

    @Override // android.support.transition.Visibility, android.support.transition.Transition
    /* JADX INFO: renamed from: b */
    public void mo2984b(C1651cz c1651cz) {
        super.mo2984b(c1651cz);
        m3034d(c1651cz);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: a */
    public Animator mo3035a(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        if (c1651cz2 == null) {
            return null;
        }
        Rect rect = (Rect) c1651cz2.f9356a.get("android:explode:screenBounds");
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        m3033a(viewGroup, rect, this.f2858j);
        return C1654db.m8835a(view, c1651cz2, rect.left, rect.top, translationX + this.f2858j[0], translationY + this.f2858j[1], translationX, translationY, f2856a);
    }

    @Override // android.support.transition.Visibility
    /* JADX INFO: renamed from: b */
    public Animator mo3036b(ViewGroup viewGroup, View view, C1651cz c1651cz, C1651cz c1651cz2) {
        float f;
        float f2;
        if (c1651cz == null) {
            return null;
        }
        Rect rect = (Rect) c1651cz.f9356a.get("android:explode:screenBounds");
        int i = rect.left;
        int i2 = rect.top;
        float translationX = view.getTranslationX();
        float translationY = view.getTranslationY();
        int[] iArr = (int[]) c1651cz.f9357b.getTag(R.id.transition_position);
        if (iArr != null) {
            f = (iArr[0] - rect.left) + translationX;
            f2 = (iArr[1] - rect.top) + translationY;
            rect.offsetTo(iArr[0], iArr[1]);
        } else {
            f = translationX;
            f2 = translationY;
        }
        m3033a(viewGroup, rect, this.f2858j);
        return C1654db.m8835a(view, c1651cz, i, i2, translationX, translationY, f + this.f2858j[0], f2 + this.f2858j[1], f2857i);
    }

    /* JADX INFO: renamed from: a */
    private void m3033a(View view, Rect rect, int[] iArr) {
        int iCenterY;
        int width;
        view.getLocationOnScreen(this.f2858j);
        int i = this.f2858j[0];
        int i2 = this.f2858j[1];
        Rect rectN = m3098n();
        if (rectN == null) {
            width = (view.getWidth() / 2) + i + Math.round(view.getTranslationX());
            iCenterY = (view.getHeight() / 2) + i2 + Math.round(view.getTranslationY());
        } else {
            int iCenterX = rectN.centerX();
            iCenterY = rectN.centerY();
            width = iCenterX;
        }
        float fCenterX = rect.centerX() - width;
        float fCenterY = rect.centerY() - iCenterY;
        if (fCenterX == 0.0f && fCenterY == 0.0f) {
            fCenterX = ((float) (Math.random() * 2.0d)) - 1.0f;
            fCenterY = ((float) (Math.random() * 2.0d)) - 1.0f;
        }
        float fM3031a = m3031a(fCenterX, fCenterY);
        float fM3032a = m3032a(view, width - i, iCenterY - i2);
        iArr[0] = Math.round((fCenterX / fM3031a) * fM3032a);
        iArr[1] = Math.round(fM3032a * (fCenterY / fM3031a));
    }

    /* JADX INFO: renamed from: a */
    private static float m3032a(View view, int i, int i2) {
        return m3031a(Math.max(i, view.getWidth() - i), Math.max(i2, view.getHeight() - i2));
    }

    /* JADX INFO: renamed from: a */
    private static float m3031a(float f, float f2) {
        return (float) Math.sqrt((f * f) + (f2 * f2));
    }
}
