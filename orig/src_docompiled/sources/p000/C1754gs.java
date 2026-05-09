package p000;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* JADX INFO: renamed from: gs */
/* JADX INFO: compiled from: RoundRectDrawable.java */
/* JADX INFO: loaded from: classes.dex */
class C1754gs extends Drawable {

    /* JADX INFO: renamed from: a */
    private float f10060a;

    /* JADX INFO: renamed from: c */
    private final RectF f10062c;

    /* JADX INFO: renamed from: d */
    private final Rect f10063d;

    /* JADX INFO: renamed from: e */
    private float f10064e;

    /* JADX INFO: renamed from: h */
    private ColorStateList f10067h;

    /* JADX INFO: renamed from: i */
    private PorterDuffColorFilter f10068i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f10069j;

    /* JADX INFO: renamed from: f */
    private boolean f10065f = false;

    /* JADX INFO: renamed from: g */
    private boolean f10066g = true;

    /* JADX INFO: renamed from: k */
    private PorterDuff.Mode f10070k = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b */
    private final Paint f10061b = new Paint(5);

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    C1754gs(ColorStateList colorStateList, float f) {
        this.f10060a = f;
        m9514b(colorStateList);
        this.f10062c = new RectF();
        this.f10063d = new Rect();
    }

    /* JADX INFO: renamed from: b */
    private void m9514b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(0);
        }
        this.f10067h = colorStateList;
        this.f10061b.setColor(this.f10067h.getColorForState(getState(), this.f10067h.getDefaultColor()));
    }

    /* JADX INFO: renamed from: a */
    void m9517a(float f, boolean z, boolean z2) {
        if (f == this.f10064e && this.f10065f == z && this.f10066g == z2) {
            return;
        }
        this.f10064e = f;
        this.f10065f = z;
        this.f10066g = z2;
        m9513a((Rect) null);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    float m9515a() {
        return this.f10064e;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        boolean z;
        Paint paint = this.f10061b;
        if (this.f10068i == null || paint.getColorFilter() != null) {
            z = false;
        } else {
            paint.setColorFilter(this.f10068i);
            z = true;
        }
        canvas.drawRoundRect(this.f10062c, this.f10060a, this.f10060a, paint);
        if (z) {
            paint.setColorFilter(null);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9513a(Rect rect) {
        if (rect == null) {
            rect = getBounds();
        }
        this.f10062c.set(rect.left, rect.top, rect.right, rect.bottom);
        this.f10063d.set(rect);
        if (this.f10065f) {
            this.f10063d.inset((int) Math.ceil(C1755gt.m9524b(this.f10064e, this.f10060a, this.f10066g)), (int) Math.ceil(C1755gt.m9521a(this.f10064e, this.f10060a, this.f10066g)));
            this.f10062c.set(this.f10063d);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        m9513a(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        outline.setRoundRect(this.f10063d, this.f10060a);
    }

    /* JADX INFO: renamed from: a */
    void m9516a(float f) {
        if (f == this.f10060a) {
            return;
        }
        this.f10060a = f;
        m9513a((Rect) null);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f10061b.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f10061b.setColorFilter(colorFilter);
    }

    /* JADX INFO: renamed from: b */
    public float m9519b() {
        return this.f10060a;
    }

    /* JADX INFO: renamed from: a */
    public void m9518a(ColorStateList colorStateList) {
        m9514b(colorStateList);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: c */
    public ColorStateList m9520c() {
        return this.f10067h;
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f10069j = colorStateList;
        this.f10068i = m9512a(this.f10069j, this.f10070k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f10070k = mode;
        this.f10068i = m9512a(this.f10069j, this.f10070k);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int colorForState = this.f10067h.getColorForState(iArr, this.f10067h.getDefaultColor());
        boolean z = colorForState != this.f10061b.getColor();
        if (z) {
            this.f10061b.setColor(colorForState);
        }
        if (this.f10069j == null || this.f10070k == null) {
            return z;
        }
        this.f10068i = m9512a(this.f10069j, this.f10070k);
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return (this.f10069j != null && this.f10069j.isStateful()) || (this.f10067h != null && this.f10067h.isStateful()) || super.isStateful();
    }

    /* JADX INFO: renamed from: a */
    private PorterDuffColorFilter m9512a(ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }
}
