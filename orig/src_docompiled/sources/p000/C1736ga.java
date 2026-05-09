package p000;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import p000.C1755gt;

/* JADX INFO: renamed from: ga */
/* JADX INFO: compiled from: CardViewBaseImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C1736ga implements InterfaceC1738gc {

    /* JADX INFO: renamed from: a */
    final RectF f9908a = new RectF();

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: g */
    public void mo9347g(InterfaceC1737gb interfaceC1737gb) {
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9333a() {
        C1755gt.f10071a = new C1755gt.a() { // from class: ga.1
            @Override // p000.C1755gt.a
            /* JADX INFO: renamed from: a */
            public void mo9334a(Canvas canvas, RectF rectF, float f, Paint paint) {
                float f2 = 2.0f * f;
                float fWidth = (rectF.width() - f2) - 1.0f;
                float fHeight = (rectF.height() - f2) - 1.0f;
                if (f >= 1.0f) {
                    float f3 = f + 0.5f;
                    float f4 = -f3;
                    C1736ga.this.f9908a.set(f4, f4, f3, f3);
                    int iSave = canvas.save();
                    canvas.translate(rectF.left + f3, rectF.top + f3);
                    canvas.drawArc(C1736ga.this.f9908a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(C1736ga.this.f9908a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fHeight, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(C1736ga.this.f9908a, 180.0f, 90.0f, true, paint);
                    canvas.translate(fWidth, 0.0f);
                    canvas.rotate(90.0f);
                    canvas.drawArc(C1736ga.this.f9908a, 180.0f, 90.0f, true, paint);
                    canvas.restoreToCount(iSave);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.top, (rectF.right - f3) + 1.0f, rectF.top + f3, paint);
                    canvas.drawRect((rectF.left + f3) - 1.0f, rectF.bottom - f3, (rectF.right - f3) + 1.0f, rectF.bottom, paint);
                }
                canvas.drawRect(rectF.left, rectF.top + f, rectF.right, rectF.bottom - f, paint);
            }
        };
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9338a(InterfaceC1737gb interfaceC1737gb, Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        C1755gt c1755gtM9351a = m9351a(context, colorStateList, f, f2, f3);
        c1755gtM9351a.m9533a(interfaceC1737gb.mo3521b());
        interfaceC1737gb.mo3519a(c1755gtM9351a);
        mo9346f(interfaceC1737gb);
    }

    /* JADX INFO: renamed from: a */
    private C1755gt m9351a(Context context, ColorStateList colorStateList, float f, float f2, float f3) {
        return new C1755gt(context.getResources(), colorStateList, f, f2, f3);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: f */
    public void mo9346f(InterfaceC1737gb interfaceC1737gb) {
        Rect rect = new Rect();
        m9352j(interfaceC1737gb).m9532a(rect);
        interfaceC1737gb.mo3517a((int) Math.ceil(mo9340b(interfaceC1737gb)), (int) Math.ceil(mo9342c(interfaceC1737gb)));
        interfaceC1737gb.mo3518a(rect.left, rect.top, rect.right, rect.bottom);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: h */
    public void mo9348h(InterfaceC1737gb interfaceC1737gb) {
        m9352j(interfaceC1737gb).m9533a(interfaceC1737gb.mo3521b());
        mo9346f(interfaceC1737gb);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9339a(InterfaceC1737gb interfaceC1737gb, ColorStateList colorStateList) {
        m9352j(interfaceC1737gb).m9531a(colorStateList);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: i */
    public ColorStateList mo9349i(InterfaceC1737gb interfaceC1737gb) {
        return m9352j(interfaceC1737gb).m9540f();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public void mo9337a(InterfaceC1737gb interfaceC1737gb, float f) {
        m9352j(interfaceC1737gb).m9530a(f);
        mo9346f(interfaceC1737gb);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: d */
    public float mo9344d(InterfaceC1737gb interfaceC1737gb) {
        return m9352j(interfaceC1737gb).m9529a();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: c */
    public void mo9343c(InterfaceC1737gb interfaceC1737gb, float f) {
        m9352j(interfaceC1737gb).m9535b(f);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: e */
    public float mo9345e(InterfaceC1737gb interfaceC1737gb) {
        return m9352j(interfaceC1737gb).m9534b();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: b */
    public void mo9341b(InterfaceC1737gb interfaceC1737gb, float f) {
        m9352j(interfaceC1737gb).m9537c(f);
        mo9346f(interfaceC1737gb);
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: a */
    public float mo9336a(InterfaceC1737gb interfaceC1737gb) {
        return m9352j(interfaceC1737gb).m9536c();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: b */
    public float mo9340b(InterfaceC1737gb interfaceC1737gb) {
        return m9352j(interfaceC1737gb).m9538d();
    }

    @Override // p000.InterfaceC1738gc
    /* JADX INFO: renamed from: c */
    public float mo9342c(InterfaceC1737gb interfaceC1737gb) {
        return m9352j(interfaceC1737gb).m9539e();
    }

    /* JADX INFO: renamed from: j */
    private C1755gt m9352j(InterfaceC1737gb interfaceC1737gb) {
        return (C1755gt) interfaceC1737gb.mo3522c();
    }
}
