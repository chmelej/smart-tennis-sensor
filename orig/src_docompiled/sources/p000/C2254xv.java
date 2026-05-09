package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.widget.ImageView;
import p000.C2253xu;

/* JADX INFO: renamed from: xv */
/* JADX INFO: compiled from: PicassoDrawable.java */
/* JADX INFO: loaded from: classes.dex */
final class C2254xv extends BitmapDrawable {

    /* JADX INFO: renamed from: e */
    private static final Paint f13596e = new Paint();

    /* JADX INFO: renamed from: a */
    Drawable f13597a;

    /* JADX INFO: renamed from: b */
    long f13598b;

    /* JADX INFO: renamed from: c */
    boolean f13599c;

    /* JADX INFO: renamed from: d */
    int f13600d;

    /* JADX INFO: renamed from: f */
    private final boolean f13601f;

    /* JADX INFO: renamed from: g */
    private final float f13602g;

    /* JADX INFO: renamed from: h */
    private final C2253xu.d f13603h;

    /* JADX INFO: renamed from: a */
    static void m12325a(ImageView imageView, Context context, Bitmap bitmap, C2253xu.d dVar, boolean z, boolean z2) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof AnimationDrawable) {
            ((AnimationDrawable) drawable).stop();
        }
        imageView.setImageDrawable(new C2254xv(context, bitmap, drawable, dVar, z, z2));
    }

    /* JADX INFO: renamed from: a */
    static void m12326a(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof AnimationDrawable) {
            ((AnimationDrawable) imageView.getDrawable()).start();
        }
    }

    C2254xv(Context context, Bitmap bitmap, Drawable drawable, C2253xu.d dVar, boolean z, boolean z2) {
        super(context.getResources(), bitmap);
        this.f13600d = 255;
        this.f13601f = z2;
        this.f13602g = context.getResources().getDisplayMetrics().density;
        this.f13603h = dVar;
        if ((dVar == C2253xu.d.MEMORY || z) ? false : true) {
            this.f13597a = drawable;
            this.f13599c = true;
            this.f13598b = SystemClock.uptimeMillis();
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!this.f13599c) {
            super.draw(canvas);
        } else {
            float fUptimeMillis = (SystemClock.uptimeMillis() - this.f13598b) / 200.0f;
            if (fUptimeMillis >= 1.0f) {
                this.f13599c = false;
                this.f13597a = null;
                super.draw(canvas);
            } else {
                if (this.f13597a != null) {
                    this.f13597a.draw(canvas);
                }
                super.setAlpha((int) (this.f13600d * fUptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f13600d);
                if (Build.VERSION.SDK_INT <= 10) {
                    invalidateSelf();
                }
            }
        }
        if (this.f13601f) {
            m12324a(canvas);
        }
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f13600d = i;
        if (this.f13597a != null) {
            this.f13597a.setAlpha(i);
        }
        super.setAlpha(i);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f13597a != null) {
            this.f13597a.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.BitmapDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f13597a != null) {
            this.f13597a.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    /* JADX INFO: renamed from: a */
    private void m12324a(Canvas canvas) {
        f13596e.setColor(-1);
        canvas.drawPath(m12323a(new Point(0, 0), (int) (this.f13602g * 16.0f)), f13596e);
        f13596e.setColor(this.f13603h.f13590d);
        canvas.drawPath(m12323a(new Point(0, 0), (int) (this.f13602g * 15.0f)), f13596e);
    }

    /* JADX INFO: renamed from: a */
    private static Path m12323a(Point point, int i) {
        Point point2 = new Point(point.x + i, point.y);
        Point point3 = new Point(point.x, point.y + i);
        Path path = new Path();
        path.moveTo(point.x, point.y);
        path.lineTo(point2.x, point2.y);
        path.lineTo(point3.x, point3.y);
        return path;
    }
}
