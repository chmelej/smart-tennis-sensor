package android.support.design.circularreveal.cardview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import p000.C0185al;
import p000.InterfaceC0194am;

/* JADX INFO: loaded from: classes.dex */
public class CircularRevealCardView extends CardView implements InterfaceC0194am {

    /* JADX INFO: renamed from: e */
    private final C0185al f2168e;

    public CircularRevealCardView(Context context) {
        this(context, null);
    }

    public CircularRevealCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2168e = new C0185al(this);
    }

    @Override // p000.InterfaceC0194am
    /* JADX INFO: renamed from: a */
    public void mo1912a() {
        this.f2168e.m1798a();
    }

    @Override // p000.InterfaceC0194am
    /* JADX INFO: renamed from: b */
    public void mo1913b() {
        this.f2168e.m1803b();
    }

    @Override // p000.InterfaceC0194am
    public void setRevealInfo(InterfaceC0194am.d dVar) {
        this.f2168e.m1800a(dVar);
    }

    @Override // p000.InterfaceC0194am
    public InterfaceC0194am.d getRevealInfo() {
        return this.f2168e.m1804c();
    }

    @Override // p000.InterfaceC0194am
    public void setCircularRevealScrimColor(int i) {
        this.f2168e.m1799a(i);
    }

    @Override // p000.InterfaceC0194am
    public int getCircularRevealScrimColor() {
        return this.f2168e.m1805d();
    }

    public Drawable getCircularRevealOverlayDrawable() {
        return this.f2168e.m1806e();
    }

    @Override // p000.InterfaceC0194am
    public void setCircularRevealOverlayDrawable(Drawable drawable) {
        this.f2168e.m1802a(drawable);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f2168e != null) {
            this.f2168e.m1801a(canvas);
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
        if (this.f2168e != null) {
            return this.f2168e.m1807f();
        }
        return super.isOpaque();
    }

    @Override // p000.C0185al.a
    /* JADX INFO: renamed from: c */
    public boolean mo1809c() {
        return super.isOpaque();
    }
}
