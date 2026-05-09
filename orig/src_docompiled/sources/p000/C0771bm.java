package p000;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.widget.VisibilityAwareImageButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.Property;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: renamed from: bm */
/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes.dex */
public class C0771bm extends C0770bl {

    /* JADX INFO: renamed from: x */
    private InsetDrawable f5240x;

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C0770bl
    /* JADX INFO: renamed from: g */
    public void mo5617g() {
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: m */
    boolean mo5623m() {
        return false;
    }

    public C0771bm(VisibilityAwareImageButton visibilityAwareImageButton, InterfaceC0775bq interfaceC0775bq) {
        super(visibilityAwareImageButton, interfaceC0775bq);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C0770bl
    /* JADX INFO: renamed from: a */
    public void mo5597a(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        this.f5210g = DrawableCompat.wrap(m5626p());
        DrawableCompat.setTintList(this.f5210g, colorStateList);
        if (mode != null) {
            DrawableCompat.setTintMode(this.f5210g, mode);
        }
        if (i > 0) {
            this.f5212i = m5590a(i, colorStateList);
            layerDrawable = new LayerDrawable(new Drawable[]{this.f5212i, this.f5210g});
        } else {
            this.f5212i = null;
            layerDrawable = this.f5210g;
        }
        this.f5211h = new RippleDrawable(C0756ay.m5493a(colorStateList2), layerDrawable, null);
        this.f5213j = this.f5211h;
        this.f5220w.mo2782a(this.f5211h);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C0770bl
    /* JADX INFO: renamed from: b */
    public void mo5606b(ColorStateList colorStateList) {
        if (this.f5211h instanceof RippleDrawable) {
            ((RippleDrawable) this.f5211h).setColor(C0756ay.m5493a(colorStateList));
        } else {
            super.mo5606b(colorStateList);
        }
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: a */
    void mo5592a(float f, float f2, float f3) {
        if (Build.VERSION.SDK_INT == 21) {
            this.f5219v.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(f5191p, m5631a(f, f3));
            stateListAnimator.addState(f5192q, m5631a(f, f2));
            stateListAnimator.addState(f5193r, m5631a(f, f2));
            stateListAnimator.addState(f5194s, m5631a(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f5219v, "elevation", f).setDuration(0L));
            if (Build.VERSION.SDK_INT >= 22 && Build.VERSION.SDK_INT <= 24) {
                arrayList.add(ObjectAnimator.ofFloat(this.f5219v, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, this.f5219v.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f5219v, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(f5190a);
            stateListAnimator.addState(f5195t, animatorSet);
            stateListAnimator.addState(f5196u, m5631a(0.0f, 0.0f));
            this.f5219v.setStateListAnimator(stateListAnimator);
        }
        if (this.f5220w.mo2783b()) {
            m5620j();
        }
    }

    /* JADX INFO: renamed from: a */
    private Animator m5631a(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f5219v, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f5219v, (Property<VisibilityAwareImageButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(f5190a);
        return animatorSet;
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: a */
    public float mo5589a() {
        return this.f5219v.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C0770bl
    /* JADX INFO: renamed from: i */
    public void mo5619i() {
        m5620j();
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: b */
    void mo5607b(Rect rect) {
        if (this.f5220w.mo2783b()) {
            this.f5240x = new InsetDrawable(this.f5211h, rect.left, rect.top, rect.right, rect.bottom);
            this.f5220w.mo2782a(this.f5240x);
        } else {
            this.f5220w.mo2782a(this.f5211h);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C0770bl
    /* JADX INFO: renamed from: a */
    public void mo5601a(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.f5219v.isEnabled()) {
                this.f5219v.setElevation(this.f5214k);
                if (this.f5219v.isPressed()) {
                    this.f5219v.setTranslationZ(this.f5216m);
                    return;
                } else if (this.f5219v.isFocused() || this.f5219v.isHovered()) {
                    this.f5219v.setTranslationZ(this.f5215l);
                    return;
                } else {
                    this.f5219v.setTranslationZ(0.0f);
                    return;
                }
            }
            this.f5219v.setElevation(0.0f);
            this.f5219v.setTranslationZ(0.0f);
        }
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: n */
    C0764bf mo5624n() {
        return new C0765bg();
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: q */
    GradientDrawable mo5627q() {
        return new a();
    }

    @Override // p000.C0770bl
    /* JADX INFO: renamed from: a */
    void mo5599a(Rect rect) {
        if (this.f5220w.mo2783b()) {
            float fMo2780a = this.f5220w.mo2780a();
            float fMo5589a = mo5589a() + this.f5216m;
            int iCeil = (int) Math.ceil(C0774bp.m5678b(fMo5589a, fMo2780a, false));
            int iCeil2 = (int) Math.ceil(C0774bp.m5675a(fMo5589a, fMo2780a, false));
            rect.set(iCeil, iCeil2, iCeil, iCeil2);
            return;
        }
        rect.set(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: bm$a */
    /* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
    static class a extends GradientDrawable {
        @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }

        a() {
        }
    }
}
