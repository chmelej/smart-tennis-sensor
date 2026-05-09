package p000;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v7.cardview.R;

/* JADX INFO: renamed from: gt */
/* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
/* JADX INFO: loaded from: classes.dex */
class C1755gt extends Drawable {

    /* JADX INFO: renamed from: a */
    static a f10071a;

    /* JADX INFO: renamed from: b */
    private static final double f10072b = Math.cos(Math.toRadians(45.0d));

    /* JADX INFO: renamed from: c */
    private final int f10073c;

    /* JADX INFO: renamed from: e */
    private Paint f10075e;

    /* JADX INFO: renamed from: f */
    private Paint f10076f;

    /* JADX INFO: renamed from: g */
    private final RectF f10077g;

    /* JADX INFO: renamed from: h */
    private float f10078h;

    /* JADX INFO: renamed from: i */
    private Path f10079i;

    /* JADX INFO: renamed from: j */
    private float f10080j;

    /* JADX INFO: renamed from: k */
    private float f10081k;

    /* JADX INFO: renamed from: l */
    private float f10082l;

    /* JADX INFO: renamed from: m */
    private ColorStateList f10083m;

    /* JADX INFO: renamed from: o */
    private final int f10085o;

    /* JADX INFO: renamed from: p */
    private final int f10086p;

    /* JADX INFO: renamed from: n */
    private boolean f10084n = true;

    /* JADX INFO: renamed from: q */
    private boolean f10087q = true;

    /* JADX INFO: renamed from: r */
    private boolean f10088r = false;

    /* JADX INFO: renamed from: d */
    private Paint f10074d = new Paint(5);

    /* JADX INFO: renamed from: gt$a */
    /* JADX INFO: compiled from: RoundRectDrawableWithShadow.java */
    interface a {
        /* JADX INFO: renamed from: a */
        void mo9334a(Canvas canvas, RectF rectF, float f, Paint paint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    C1755gt(Resources resources, ColorStateList colorStateList, float f, float f2, float f3) {
        this.f10085o = resources.getColor(R.color.cardview_shadow_start_color);
        this.f10086p = resources.getColor(R.color.cardview_shadow_end_color);
        this.f10073c = resources.getDimensionPixelSize(R.dimen.cardview_compat_inset_shadow);
        m9525b(colorStateList);
        this.f10075e = new Paint(5);
        this.f10075e.setStyle(Paint.Style.FILL);
        this.f10078h = (int) (f + 0.5f);
        this.f10077g = new RectF();
        this.f10076f = new Paint(this.f10075e);
        this.f10076f.setAntiAlias(false);
        m9522a(f2, f3);
    }

    /* JADX INFO: renamed from: b */
    private void m9525b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f10083m = colorStateList;
        this.f10074d.setColor(this.f10083m.getColorForState(getState(), this.f10083m.getDefaultColor()));
    }

    /* JADX INFO: renamed from: d */
    private int m9527d(float f) {
        int i = (int) (f + 0.5f);
        return i % 2 == 1 ? i - 1 : i;
    }

    /* JADX INFO: renamed from: a */
    void m9533a(boolean z) {
        this.f10087q = z;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f10074d.setAlpha(i);
        this.f10075e.setAlpha(i);
        this.f10076f.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.f10084n = true;
    }

    /* JADX INFO: renamed from: a */
    private void m9522a(float f, float f2) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid shadow size " + f + ". Must be >= 0");
        }
        if (f2 < 0.0f) {
            throw new IllegalArgumentException("Invalid max shadow size " + f2 + ". Must be >= 0");
        }
        float fM9527d = m9527d(f);
        float fM9527d2 = m9527d(f2);
        if (fM9527d > fM9527d2) {
            if (!this.f10088r) {
                this.f10088r = true;
            }
            fM9527d = fM9527d2;
        }
        if (this.f10082l == fM9527d && this.f10080j == fM9527d2) {
            return;
        }
        this.f10082l = fM9527d;
        this.f10080j = fM9527d2;
        this.f10081k = (int) ((fM9527d * 1.5f) + this.f10073c + 0.5f);
        this.f10084n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iCeil = (int) Math.ceil(m9521a(this.f10080j, this.f10078h, this.f10087q));
        int iCeil2 = (int) Math.ceil(m9524b(this.f10080j, this.f10078h, this.f10087q));
        rect.set(iCeil2, iCeil, iCeil2, iCeil);
        return true;
    }

    /* JADX INFO: renamed from: a */
    static float m9521a(float f, float f2, boolean z) {
        return z ? (float) (((double) (f * 1.5f)) + ((1.0d - f10072b) * ((double) f2))) : f * 1.5f;
    }

    /* JADX INFO: renamed from: b */
    static float m9524b(float f, float f2, boolean z) {
        return z ? (float) (((double) f) + ((1.0d - f10072b) * ((double) f2))) : f;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f10083m.getColorForState(iArr, this.f10083m.getDefaultColor());
        if (this.f10074d.getColor() == colorForState) {
            return false;
        }
        this.f10074d.setColor(colorForState);
        this.f10084n = true;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.f10083m != null && this.f10083m.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10074d.setColorFilter(colorFilter);
    }

    /* JADX INFO: renamed from: a */
    void m9530a(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("Invalid radius " + f + ". Must be >= 0");
        }
        float f2 = (int) (f + 0.5f);
        if (this.f10078h == f2) {
            return;
        }
        this.f10078h = f2;
        this.f10084n = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f10084n) {
            m9526b(getBounds());
            this.f10084n = false;
        }
        canvas.translate(0.0f, this.f10082l / 2.0f);
        m9523a(canvas);
        canvas.translate(0.0f, (-this.f10082l) / 2.0f);
        f10071a.mo9334a(canvas, this.f10077g, this.f10078h, this.f10074d);
    }

    /* JADX INFO: renamed from: a */
    private void m9523a(Canvas canvas) {
        float f = (-this.f10078h) - this.f10081k;
        float f2 = this.f10078h + this.f10073c + (this.f10082l / 2.0f);
        float f3 = f2 * 2.0f;
        boolean z = this.f10077g.width() - f3 > 0.0f;
        boolean z2 = this.f10077g.height() - f3 > 0.0f;
        int iSave = canvas.save();
        canvas.translate(this.f10077g.left + f2, this.f10077g.top + f2);
        canvas.drawPath(this.f10079i, this.f10075e);
        if (z) {
            canvas.drawRect(0.0f, f, this.f10077g.width() - f3, -this.f10078h, this.f10076f);
        }
        canvas.restoreToCount(iSave);
        int iSave2 = canvas.save();
        canvas.translate(this.f10077g.right - f2, this.f10077g.bottom - f2);
        canvas.rotate(180.0f);
        canvas.drawPath(this.f10079i, this.f10075e);
        if (z) {
            canvas.drawRect(0.0f, f, this.f10077g.width() - f3, (-this.f10078h) + this.f10081k, this.f10076f);
        }
        canvas.restoreToCount(iSave2);
        int iSave3 = canvas.save();
        canvas.translate(this.f10077g.left + f2, this.f10077g.bottom - f2);
        canvas.rotate(270.0f);
        canvas.drawPath(this.f10079i, this.f10075e);
        if (z2) {
            canvas.drawRect(0.0f, f, this.f10077g.height() - f3, -this.f10078h, this.f10076f);
        }
        canvas.restoreToCount(iSave3);
        int iSave4 = canvas.save();
        canvas.translate(this.f10077g.right - f2, this.f10077g.top + f2);
        canvas.rotate(90.0f);
        canvas.drawPath(this.f10079i, this.f10075e);
        if (z2) {
            canvas.drawRect(0.0f, f, this.f10077g.height() - f3, -this.f10078h, this.f10076f);
        }
        canvas.restoreToCount(iSave4);
    }

    /* JADX INFO: renamed from: g */
    private void m9528g() {
        RectF rectF = new RectF(-this.f10078h, -this.f10078h, this.f10078h, this.f10078h);
        RectF rectF2 = new RectF(rectF);
        rectF2.inset(-this.f10081k, -this.f10081k);
        if (this.f10079i == null) {
            this.f10079i = new Path();
        } else {
            this.f10079i.reset();
        }
        this.f10079i.setFillType(Path.FillType.EVEN_ODD);
        this.f10079i.moveTo(-this.f10078h, 0.0f);
        this.f10079i.rLineTo(-this.f10081k, 0.0f);
        this.f10079i.arcTo(rectF2, 180.0f, 90.0f, false);
        this.f10079i.arcTo(rectF, 270.0f, -90.0f, false);
        this.f10079i.close();
        this.f10075e.setShader(new RadialGradient(0.0f, 0.0f, this.f10078h + this.f10081k, new int[]{this.f10085o, this.f10085o, this.f10086p}, new float[]{0.0f, this.f10078h / (this.f10078h + this.f10081k), 1.0f}, Shader.TileMode.CLAMP));
        this.f10076f.setShader(new LinearGradient(0.0f, (-this.f10078h) + this.f10081k, 0.0f, (-this.f10078h) - this.f10081k, new int[]{this.f10085o, this.f10085o, this.f10086p}, new float[]{0.0f, 0.5f, 1.0f}, Shader.TileMode.CLAMP));
        this.f10076f.setAntiAlias(false);
    }

    /* JADX INFO: renamed from: b */
    private void m9526b(Rect rect) {
        float f = this.f10080j * 1.5f;
        this.f10077g.set(rect.left + this.f10080j, rect.top + f, rect.right - this.f10080j, rect.bottom - f);
        m9528g();
    }

    /* JADX INFO: renamed from: a */
    float m9529a() {
        return this.f10078h;
    }

    /* JADX INFO: renamed from: a */
    void m9532a(Rect rect) {
        getPadding(rect);
    }

    /* JADX INFO: renamed from: b */
    void m9535b(float f) {
        m9522a(f, this.f10080j);
    }

    /* JADX INFO: renamed from: c */
    void m9537c(float f) {
        m9522a(this.f10082l, f);
    }

    /* JADX INFO: renamed from: b */
    float m9534b() {
        return this.f10082l;
    }

    /* JADX INFO: renamed from: c */
    float m9536c() {
        return this.f10080j;
    }

    /* JADX INFO: renamed from: d */
    float m9538d() {
        return (Math.max(this.f10080j, this.f10078h + this.f10073c + (this.f10080j / 2.0f)) * 2.0f) + ((this.f10080j + this.f10073c) * 2.0f);
    }

    /* JADX INFO: renamed from: e */
    float m9539e() {
        return (Math.max(this.f10080j, this.f10078h + this.f10073c + ((this.f10080j * 1.5f) / 2.0f)) * 2.0f) + (((this.f10080j * 1.5f) + this.f10073c) * 2.0f);
    }

    /* JADX INFO: renamed from: a */
    void m9531a(ColorStateList colorStateList) {
        m9525b(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: f */
    ColorStateList m9540f() {
        return this.f10083m;
    }
}
