package android.support.design.circularreveal;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import p000.C0185al;
import p000.InterfaceC0194am;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealLinearLayout extends LinearLayout implements InterfaceC0194am {

    /* JADX INFO: renamed from: a */
    private final C0185al f2166a;

    public CircularRevealLinearLayout(Context context) {
        this(context, null);
    }

    public CircularRevealLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2166a = new C0185al(this);
    }

    @Override // p000.InterfaceC0194am
    /* JADX INFO: renamed from: a */
    public void mo1912a() {
        this.f2166a.m1798a();
    }

    @Override // p000.InterfaceC0194am
    /* JADX INFO: renamed from: b */
    public void mo1913b() {
        this.f2166a.m1803b();
    }

    @Override // p000.InterfaceC0194am
    public InterfaceC0194am.d getRevealInfo() {
        return this.f2166a.m1804c();
    }

    @Override // p000.InterfaceC0194am
    public void setRevealInfo(InterfaceC0194am.d dVar) {
        this.f2166a.m1800a(dVar);
    }

    @Override // p000.InterfaceC0194am
    public int getCircularRevealScrimColor() {
        return this.f2166a.m1805d();
    }

    @Override // p000.InterfaceC0194am
    public void setCircularRevealScrimColor(int i) {
        this.f2166a.m1799a(i);
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2166a.m1806e();
    }

    @Override // p000.InterfaceC0194am
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f2166a.m1802a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f2166a != null) {
            this.f2166a.m1801a(canvas);
        } else {
            super.draw(canvas);
        }
    }

    @Override // p000.C0185al.a
    /* JADX INFO: renamed from: a */
    public void mo1808a(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.view.View
    public boolean isOpaque() {
        if (this.f2166a != null) {
            return this.f2166a.m1807f();
        }
        return super.isOpaque();
    }

    @Override // p000.C0185al.a
    /* JADX INFO: renamed from: c */
    public boolean mo1809c() {
        return super.isOpaque();
    }
}
