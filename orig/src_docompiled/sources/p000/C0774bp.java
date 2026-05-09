package p000;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.content.ContextCompat;

/* JADX INFO: renamed from: bp */
/* JADX INFO: compiled from: ShadowDrawableWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0774bp extends C1687eh {

    /* JADX INFO: renamed from: a */
    static final double f5265a = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: b */
    final Paint f5266b;

    /* JADX INFO: renamed from: c */
    final Paint f5267c;

    /* JADX INFO: renamed from: d */
    final RectF f5268d;

    /* JADX INFO: renamed from: e */
    float f5269e;

    /* JADX INFO: renamed from: f */
    Path f5270f;

    /* JADX INFO: renamed from: g */
    float f5271g;

    /* JADX INFO: renamed from: h */
    float f5272h;

    /* JADX INFO: renamed from: i */
    float f5273i;

    /* JADX INFO: renamed from: j */
    float f5274j;

    /* JADX INFO: renamed from: k */
    private boolean f5275k;

    /* JADX INFO: renamed from: l */
    private final int f5276l;

    /* JADX INFO: renamed from: m */
    private final int f5277m;

    /* JADX INFO: renamed from: n */
    private final int f5278n;

    /* JADX INFO: renamed from: o */
    private boolean f5279o;

    /* JADX INFO: renamed from: p */
    private float f5280p;

    /* JADX INFO: renamed from: q */
    private boolean f5281q;

    @Override // p000.C1687eh, android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public C0774bp(Context context, Drawable drawable, float f, float f2, float f3) {
        super(drawable);
        this.f5275k = true;
        this.f5279o = true;
        this.f5281q = false;
        this.f5276l = ContextCompat.getColor(context, R.color.design_fab_shadow_start_color);
        this.f5277m = ContextCompat.getColor(context, R.color.design_fab_shadow_mid_color);
        this.f5278n = ContextCompat.getColor(context, R.color.design_fab_shadow_end_color);
        this.f5266b = new Paint(5);
        this.f5266b.setStyle(Paint.Style.FILL);
        this.f5269e = Math.round(f);
        this.f5268d = new RectF();
        this.f5267c = new Paint(this.f5266b);
        this.f5267c.setAntiAlias(false);
        m5683a(f2, f3);
    }

    /* JADX INFO: renamed from: c */
    private static int m5679c(float f) {
        int iRound = Math.round(f);
        return iRound % 2 == 1 ? iRound - 1 : iRound;
    }

    /* JADX INFO: renamed from: a */
    public void m5684a(boolean z) {
        this.f5279o = z;
        invalidateSelf();
    }

    @Override // p000.C1687eh, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        super.setAlpha(i);
        this.f5266b.setAlpha(i);
        this.f5267c.setAlpha(i);
    }

    @Override // p000.C1687eh, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f5275k = true;
    }

    /* JADX INFO: renamed from: a */
    public void m5683a(float f, float f2) {
        if (f < 0.0f || f2 < 0.0f) {
            throw new IllegalArgumentException("invalid shadow size");
        }
        float fM5679c = m5679c(f);
        float fM5679c2 = m5679c(f2);
        if (fM5679c > fM5679c2) {
            if (!this.f5281q) {
                this.f5281q = true;
            }
            fM5679c = fM5679c2;
        }
        if (this.f5274j == fM5679c && this.f5272h == fM5679c2) {
            return;
        }
        this.f5274j = fM5679c;
        this.f5272h = fM5679c2;
        this.f5273i = Math.round(fM5679c * 1.5f);
        this.f5271g = fM5679c2;
        this.f5275k = true;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m5682a(float f) {
        m5683a(f, this.f5272h);
    }

    /* JADX INFO: renamed from: a */
    public float m5681a() {
        return this.f5274j;
    }

    @Override // p000.C1687eh, android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(m5675a(this.f5272h, this.f5269e, this.f5279o));
        int iCeil2 = (int) Math.ceil(m5678b(this.f5272h, this.f5269e, this.f5279o));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static float m5675a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f5265a) * ((double) f2))) : f * 1.5f;
    }

    /* JADX INFO: renamed from: b */
    public static float m5678b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f5265a) * ((double) f2))) : f;
    }

    @Override // p000.C1687eh, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5275k) {
            m5677a(getBounds());
            this.f5275k = false;
        }
        m5676a(canvas);
        super.draw(canvas);
    }

    /* JADX INFO: renamed from: b */
    public final void m5685b(float f) {
        if (this.f5280p != f) {
            this.f5280p = f;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m5676a(Canvas canvas) {
        int i;
        float f;
        int i2;
        float f2;
        float f3;
        float f4;
        int iSave = canvas.save();
        canvas.rotate(this.f5280p, this.f5268d.centerX(), this.f5268d.centerY());
        float f5 = (-this.f5269e) - this.f5273i;
        float f6 = this.f5269e;
        float f7 = f6 * 2.0f;
        boolean z = this.f5268d.width() - f7 > 0.0f;
        boolean z2 = this.f5268d.height() - f7 > 0.0f;
        float f8 = this.f5274j - (this.f5274j * 0.25f);
        float f9 = f6 / ((this.f5274j - (this.f5274j * 0.5f)) + f6);
        float f10 = f6 / (f8 + f6);
        float f11 = f6 / ((this.f5274j - (this.f5274j * 1.0f)) + f6);
        int iSave2 = canvas.save();
        canvas.translate(this.f5268d.left + f6, this.f5268d.top + f6);
        canvas.scale(f9, f10);
        canvas.drawPath(this.f5270f, this.f5266b);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            i = iSave2;
            f = f11;
            i2 = iSave;
            f2 = f10;
            canvas.drawRect(0.0f, f5, this.f5268d.width() - f7, -this.f5269e, this.f5267c);
        } else {
            i = iSave2;
            f = f11;
            i2 = iSave;
            f2 = f10;
        }
        canvas.restoreToCount(i);
        int iSave3 = canvas.save();
        canvas.translate(this.f5268d.right - f6, this.f5268d.bottom - f6);
        float f12 = f;
        canvas.scale(f9, f12);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f5270f, this.f5266b);
        if (z) {
            canvas.scale(1.0f / f9, 1.0f);
            f3 = f2;
            f4 = f12;
            canvas.drawRect(0.0f, f5, this.f5268d.width() - f7, (-this.f5269e) + this.f5273i, this.f5267c);
        } else {
            f3 = f2;
            f4 = f12;
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.f5268d.left + f6, this.f5268d.bottom - f6);
        canvas.scale(f9, f4);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f5270f, this.f5266b);
        if (z2) {
            canvas.scale(1.0f / f4, 1.0f);
            canvas.drawRect(0.0f, f5, this.f5268d.height() - f7, -this.f5269e, this.f5267c);
        }
        canvas.restoreToCount(iSave4);
        int iSave5 = canvas.save();
        canvas.translate(this.f5268d.right - f6, this.f5268d.top + f6);
        float f13 = f3;
        canvas.scale(f9, f13);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f5270f, this.f5266b);
        if (z2) {
            canvas.scale(1.0f / f13, 1.0f);
            canvas.drawRect(0.0f, f5, this.f5268d.height() - f7, -this.f5269e, this.f5267c);
        }
        canvas.restoreToCount(iSave5);
        canvas.restoreToCount(i2);
    }

    /* JADX INFO: renamed from: c */
    private void m5680c() {
        RectF rectF = new RectF(-this.f5269e, -this.f5269e, this.f5269e, this.f5269e);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f5273i, -this.f5273i);
        if (this.f5270f == null) {
            this.f5270f = new Path();
        } else {
            this.f5270f.reset();
        }
        this.f5270f.setFillType(Path.FillType.EVEN_ODD);
        this.f5270f.moveTo(-this.f5269e, 0.0f);
        this.f5270f.rLineTo(-this.f5273i, 0.0f);
        this.f5270f.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f5270f.arcTo(rectF, 270.0f, -90.0f, false);
        this.f5270f.close();
        float f = -rectF2.top;
        if (f > 0.0f) {
            float f2 = this.f5269e / f;
            this.f5266b.setShader(new RadialGradient(0.0f, 0.0f, f, new int[]{0, this.f5276l, this.f5277m, this.f5278n}, new float[]{0.0f, f2, ((1.0f - f2) / 2.0f) + f2, 1.0f}, Shader.TileMode.CLAMP));
        }
        this.f5267c.setShader(new LinearGradient(0.0f, rectF.top, 0.0f, rectF2.top, new int[]{this.f5276l, this.f5277m, this.f5278n}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f5267c.setAntiAlias(false);
    }

    /* JADX INFO: renamed from: a */
    private void m5677a(Rect rect) {
        float f = this.f5272h * 1.5f;
        this.f5268d.set(rect.left + this.f5272h, rect.top + f, rect.right - this.f5272h, rect.bottom - f);
        m9041b().setBounds((int) this.f5268d.left, (int) this.f5268d.top, (int) this.f5268d.right, (int) this.f5268d.bottom);
        m5680c();
    }
}
