package android.support.design.shape;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import p000.C0757az;
import p000.C0759ba;
import p000.C0760bb;
import p000.C0761bc;

/* JADX INFO: loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable {

    /* JADX INFO: renamed from: a */
    private final Paint f2241a;

    /* JADX INFO: renamed from: b */
    private final Matrix[] f2242b;

    /* JADX INFO: renamed from: c */
    private final Matrix[] f2243c;

    /* JADX INFO: renamed from: d */
    private final C0760bb[] f2244d;

    /* JADX INFO: renamed from: e */
    private final Matrix f2245e;

    /* JADX INFO: renamed from: f */
    private final Path f2246f;

    /* JADX INFO: renamed from: g */
    private final PointF f2247g;

    /* JADX INFO: renamed from: h */
    private final C0760bb f2248h;

    /* JADX INFO: renamed from: i */
    private final Region f2249i;

    /* JADX INFO: renamed from: j */
    private final Region f2250j;

    /* JADX INFO: renamed from: k */
    private final float[] f2251k;

    /* JADX INFO: renamed from: l */
    private final float[] f2252l;

    /* JADX INFO: renamed from: m */
    private C0761bc f2253m;

    /* JADX INFO: renamed from: n */
    private boolean f2254n;

    /* JADX INFO: renamed from: o */
    private boolean f2255o;

    /* JADX INFO: renamed from: p */
    private float f2256p;

    /* JADX INFO: renamed from: q */
    private int f2257q;

    /* JADX INFO: renamed from: r */
    private int f2258r;

    /* JADX INFO: renamed from: s */
    private int f2259s;

    /* JADX INFO: renamed from: t */
    private int f2260t;

    /* JADX INFO: renamed from: u */
    private float f2261u;

    /* JADX INFO: renamed from: v */
    private float f2262v;

    /* JADX INFO: renamed from: w */
    private Paint.Style f2263w;

    /* JADX INFO: renamed from: x */
    private PorterDuffColorFilter f2264x;

    /* JADX INFO: renamed from: y */
    private PorterDuff.Mode f2265y;

    /* JADX INFO: renamed from: z */
    private ColorStateList f2266z;

    /* JADX INFO: renamed from: a */
    private static int m2463a(int i, int i2) {
        return (i * (i2 + (i2 >>> 7))) >>> 8;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public MaterialShapeDrawable() {
        this(null);
    }

    public MaterialShapeDrawable(C0761bc c0761bc) {
        this.f2241a = new Paint();
        this.f2242b = new Matrix[4];
        this.f2243c = new Matrix[4];
        this.f2244d = new C0760bb[4];
        this.f2245e = new Matrix();
        this.f2246f = new Path();
        this.f2247g = new PointF();
        this.f2248h = new C0760bb();
        this.f2249i = new Region();
        this.f2250j = new Region();
        this.f2251k = new float[2];
        this.f2252l = new float[2];
        this.f2253m = null;
        this.f2254n = false;
        this.f2255o = false;
        this.f2256p = 1.0f;
        this.f2257q = -16777216;
        this.f2258r = 5;
        this.f2259s = 10;
        this.f2260t = 255;
        this.f2261u = 1.0f;
        this.f2262v = 0.0f;
        this.f2263w = Paint.Style.FILL_AND_STROKE;
        this.f2265y = PorterDuff.Mode.SRC_IN;
        this.f2266z = null;
        this.f2253m = c0761bc;
        for (int i = 0; i < 4; i++) {
            this.f2242b[i] = new Matrix();
            this.f2243c[i] = new Matrix();
            this.f2244d[i] = new C0760bb();
        }
    }

    /* JADX INFO: renamed from: a */
    public ColorStateList m2475a() {
        return this.f2266z;
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.f2266z = colorStateList;
        m2473c();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f2265y = mode;
        m2473c();
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f2260t = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f2241a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        Rect bounds = getBounds();
        this.f2249i.set(bounds);
        m2470b(bounds.width(), bounds.height(), this.f2246f);
        this.f2250j.setPath(this.f2246f, this.f2249i);
        this.f2249i.op(this.f2250j, Region.Op.DIFFERENCE);
        return this.f2249i;
    }

    /* JADX INFO: renamed from: a */
    public void m2479a(boolean z) {
        this.f2254n = z;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: b */
    public float m2480b() {
        return this.f2256p;
    }

    /* JADX INFO: renamed from: a */
    public void m2476a(float f) {
        this.f2256p = f;
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m2478a(Paint.Style style) {
        this.f2263w = style;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f2241a.setColorFilter(this.f2264x);
        int alpha = this.f2241a.getAlpha();
        this.f2241a.setAlpha(m2463a(alpha, this.f2260t));
        this.f2241a.setStrokeWidth(this.f2262v);
        this.f2241a.setStyle(this.f2263w);
        if (this.f2258r > 0 && this.f2254n) {
            this.f2241a.setShadowLayer(this.f2259s, 0.0f, this.f2258r, this.f2257q);
        }
        if (this.f2253m != null) {
            m2470b(canvas.getWidth(), canvas.getHeight(), this.f2246f);
            canvas.drawPath(this.f2246f, this.f2241a);
        } else {
            canvas.drawRect(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f2241a);
        }
        this.f2241a.setAlpha(alpha);
    }

    /* JADX INFO: renamed from: a */
    public void m2477a(int i, int i2, Path path) {
        path.rewind();
        if (this.f2253m == null) {
            return;
        }
        for (int i3 = 0; i3 < 4; i3++) {
            m2465a(i3, i, i2);
            m2469b(i3, i, i2);
        }
        for (int i4 = 0; i4 < 4; i4++) {
            m2467a(i4, path);
            m2471b(i4, path);
        }
        path.close();
    }

    /* JADX INFO: renamed from: a */
    private void m2465a(int i, int i2, int i3) {
        m2466a(i, i2, i3, this.f2247g);
        m2464a(i).m5494a(m2472c(i, i2, i3), this.f2256p, this.f2244d[i]);
        float fM2474d = m2474d(((i - 1) + 4) % 4, i2, i3) + 1.5707964f;
        this.f2242b[i].reset();
        this.f2242b[i].setTranslate(this.f2247g.x, this.f2247g.y);
        this.f2242b[i].preRotate((float) Math.toDegrees(fM2474d));
    }

    /* JADX INFO: renamed from: b */
    private void m2469b(int i, int i2, int i3) {
        this.f2251k[0] = this.f2244d[i].f5090c;
        this.f2251k[1] = this.f2244d[i].f5091d;
        this.f2242b[i].mapPoints(this.f2251k);
        float fM2474d = m2474d(i, i2, i3);
        this.f2243c[i].reset();
        this.f2243c[i].setTranslate(this.f2251k[0], this.f2251k[1]);
        this.f2243c[i].preRotate((float) Math.toDegrees(fM2474d));
    }

    /* JADX INFO: renamed from: a */
    private void m2467a(int i, Path path) {
        this.f2251k[0] = this.f2244d[i].f5088a;
        this.f2251k[1] = this.f2244d[i].f5089b;
        this.f2242b[i].mapPoints(this.f2251k);
        if (i == 0) {
            path.moveTo(this.f2251k[0], this.f2251k[1]);
        } else {
            path.lineTo(this.f2251k[0], this.f2251k[1]);
        }
        this.f2244d[i].m5497a(this.f2242b[i], path);
    }

    /* JADX INFO: renamed from: b */
    private void m2471b(int i, Path path) {
        int i2 = (i + 1) % 4;
        this.f2251k[0] = this.f2244d[i].f5090c;
        this.f2251k[1] = this.f2244d[i].f5091d;
        this.f2242b[i].mapPoints(this.f2251k);
        this.f2252l[0] = this.f2244d[i2].f5088a;
        this.f2252l[1] = this.f2244d[i2].f5089b;
        this.f2242b[i2].mapPoints(this.f2252l);
        float fHypot = (float) Math.hypot(this.f2251k[0] - this.f2252l[0], this.f2251k[1] - this.f2252l[1]);
        this.f2248h.m5495a(0.0f, 0.0f);
        m2468b(i).mo789a(fHypot, this.f2256p, this.f2248h);
        this.f2248h.m5497a(this.f2243c[i], path);
    }

    /* JADX INFO: renamed from: a */
    private C0757az m2464a(int i) {
        switch (i) {
            case 1:
                return this.f2253m.m5504b();
            case 2:
                return this.f2253m.m5505c();
            case 3:
                return this.f2253m.m5506d();
            default:
                return this.f2253m.m5502a();
        }
    }

    /* JADX INFO: renamed from: b */
    private C0759ba m2468b(int i) {
        switch (i) {
            case 1:
                return this.f2253m.m5508f();
            case 2:
                return this.f2253m.m5509g();
            case 3:
                return this.f2253m.m5510h();
            default:
                return this.f2253m.m5507e();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2466a(int i, int i2, int i3, PointF pointF) {
        switch (i) {
            case 1:
                pointF.set(i2, 0.0f);
                break;
            case 2:
                pointF.set(i2, i3);
                break;
            case 3:
                pointF.set(0.0f, i3);
                break;
            default:
                pointF.set(0.0f, 0.0f);
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    private float m2472c(int i, int i2, int i3) {
        m2466a(((i - 1) + 4) % 4, i2, i3, this.f2247g);
        float f = this.f2247g.x;
        float f2 = this.f2247g.y;
        m2466a((i + 1) % 4, i2, i3, this.f2247g);
        float f3 = this.f2247g.x;
        float f4 = this.f2247g.y;
        m2466a(i, i2, i3, this.f2247g);
        float f5 = this.f2247g.x;
        float f6 = this.f2247g.y;
        float fAtan2 = ((float) Math.atan2(f2 - f6, f - f5)) - ((float) Math.atan2(f4 - f6, f3 - f5));
        return fAtan2 < 0.0f ? (float) (((double) fAtan2) + 6.283185307179586d) : fAtan2;
    }

    /* JADX INFO: renamed from: d */
    private float m2474d(int i, int i2, int i3) {
        int i4 = (i + 1) % 4;
        m2466a(i, i2, i3, this.f2247g);
        float f = this.f2247g.x;
        float f2 = this.f2247g.y;
        m2466a(i4, i2, i3, this.f2247g);
        return (float) Math.atan2(this.f2247g.y - f2, this.f2247g.x - f);
    }

    /* JADX INFO: renamed from: b */
    private void m2470b(int i, int i2, Path path) {
        m2477a(i, i2, path);
        if (this.f2261u == 1.0f) {
            return;
        }
        this.f2245e.reset();
        this.f2245e.setScale(this.f2261u, this.f2261u, i / 2, i2 / 2);
        path.transform(this.f2245e);
    }

    /* JADX INFO: renamed from: c */
    private void m2473c() {
        if (this.f2266z == null || this.f2265y == null) {
            this.f2264x = null;
            return;
        }
        int colorForState = this.f2266z.getColorForState(getState(), 0);
        this.f2264x = new PorterDuffColorFilter(colorForState, this.f2265y);
        if (this.f2255o) {
            this.f2257q = colorForState;
        }
    }
}
