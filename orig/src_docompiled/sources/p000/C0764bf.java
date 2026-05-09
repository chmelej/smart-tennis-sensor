package p000;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.ColorUtils;

/* JADX INFO: renamed from: bf */
/* JADX INFO: compiled from: CircularBorderDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C0764bf extends Drawable {

    /* JADX INFO: renamed from: e */
    float f5126e;

    /* JADX INFO: renamed from: f */
    private int f5127f;

    /* JADX INFO: renamed from: g */
    private int f5128g;

    /* JADX INFO: renamed from: h */
    private int f5129h;

    /* JADX INFO: renamed from: i */
    private int f5130i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f5131j;

    /* JADX INFO: renamed from: k */
    private int f5132k;

    /* JADX INFO: renamed from: m */
    private float f5134m;

    /* JADX INFO: renamed from: b */
    final Rect f5123b = new Rect();

    /* JADX INFO: renamed from: c */
    final RectF f5124c = new RectF();

    /* JADX INFO: renamed from: d */
    final a f5125d = new a();

    /* JADX INFO: renamed from: l */
    private boolean f5133l = true;

    /* JADX INFO: renamed from: a */
    final Paint f5122a = new Paint(1);

    public C0764bf() {
        this.f5122a.setStyle(Paint.Style.STROKE);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f5125d;
    }

    /* JADX INFO: renamed from: a */
    public void m5516a(int i, int i2, int i3, int i4) {
        this.f5127f = i;
        this.f5128g = i2;
        this.f5129h = i3;
        this.f5130i = i4;
    }

    /* JADX INFO: renamed from: a */
    public void m5515a(float f) {
        if (this.f5126e != f) {
            this.f5126e = f;
            this.f5122a.setStrokeWidth(f * 1.3333f);
            this.f5133l = true;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5133l) {
            this.f5122a.setShader(m5514a());
            this.f5133l = false;
        }
        float strokeWidth = this.f5122a.getStrokeWidth() / 2.0f;
        RectF rectF = this.f5124c;
        copyBounds(this.f5123b);
        rectF.set(this.f5123b);
        rectF.left += strokeWidth;
        rectF.top += strokeWidth;
        rectF.right -= strokeWidth;
        rectF.bottom -= strokeWidth;
        canvas.save();
        canvas.rotate(this.f5134m, rectF.centerX(), rectF.centerY());
        canvas.drawOval(rectF, this.f5122a);
        canvas.restore();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int iRound = Math.round(this.f5126e);
        rect.set(iRound, iRound, iRound, iRound);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f5122a.setAlpha(i);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m5517a(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f5132k = colorStateList.getColorForState(getState(), this.f5132k);
        }
        this.f5131j = colorStateList;
        this.f5133l = true;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f5122a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f5126e > 0.0f ? -3 : -2;
    }

    /* JADX INFO: renamed from: b */
    public final void m5518b(float f) {
        if (f != this.f5134m) {
            this.f5134m = f;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        this.f5133l = true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.f5131j != null && this.f5131j.isStateful()) || super.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState;
        if (this.f5131j != null && (colorForState = this.f5131j.getColorForState(iArr, this.f5132k)) != this.f5132k) {
            this.f5133l = true;
            this.f5132k = colorForState;
        }
        if (this.f5133l) {
            invalidateSelf();
        }
        return this.f5133l;
    }

    /* JADX INFO: renamed from: a */
    private Shader m5514a() {
        copyBounds(this.f5123b);
        float fHeight = this.f5126e / r0.height();
        return new LinearGradient(0.0f, r0.top, 0.0f, r0.bottom, new int[]{ColorUtils.compositeColors(this.f5127f, this.f5132k), ColorUtils.compositeColors(this.f5128g, this.f5132k), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f5128g, 0), this.f5132k), ColorUtils.compositeColors(ColorUtils.setAlphaComponent(this.f5130i, 0), this.f5132k), ColorUtils.compositeColors(this.f5130i, this.f5132k), ColorUtils.compositeColors(this.f5129h, this.f5132k)}, new float[]{0.0f, fHeight, 0.5f, 0.5f, 1.0f - fHeight, 1.0f}, Shader.TileMode.CLAMP);
    }

    /* JADX INFO: renamed from: bf$a */
    /* JADX INFO: compiled from: CircularBorderDrawable.java */
    class a extends Drawable.ConstantState {
        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        private a() {
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return C0764bf.this;
        }
    }
}
