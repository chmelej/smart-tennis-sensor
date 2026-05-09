package p000;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: bi */
/* JADX INFO: compiled from: CutoutDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class C0767bi extends GradientDrawable {

    /* JADX INFO: renamed from: a */
    private final Paint f5183a = new Paint(1);

    /* JADX INFO: renamed from: b */
    private final RectF f5184b;

    /* JADX INFO: renamed from: c */
    private int f5185c;

    public C0767bi() {
        m5570c();
        this.f5184b = new RectF();
    }

    /* JADX INFO: renamed from: c */
    private void m5570c() {
        this.f5183a.setStyle(Paint.Style.FILL_AND_STROKE);
        this.f5183a.setColor(-1);
        this.f5183a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    }

    /* JADX INFO: renamed from: a */
    public boolean m5574a() {
        return !this.f5184b.isEmpty();
    }

    /* JADX INFO: renamed from: a */
    void m5572a(float f, float f2, float f3, float f4) {
        if (f == this.f5184b.left && f2 == this.f5184b.top && f3 == this.f5184b.right && f4 == this.f5184b.bottom) {
            return;
        }
        this.f5184b.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* JADX INFO: renamed from: a */
    public void m5573a(RectF rectF) {
        m5572a(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX INFO: renamed from: b */
    public void m5575b() {
        m5572a(0.0f, 0.0f, 0.0f, 0.0f);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        m5567a(canvas);
        super.draw(canvas);
        canvas.drawRect(this.f5184b, this.f5183a);
        m5571c(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m5567a(Canvas canvas) {
        Drawable.Callback callback = getCallback();
        if (m5568a(callback)) {
            ((View) callback).setLayerType(2, null);
        } else {
            m5569b(canvas);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m5569b(Canvas canvas) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f5185c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null);
        } else {
            this.f5185c = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), null, 31);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m5571c(Canvas canvas) {
        if (m5568a(getCallback())) {
            return;
        }
        canvas.restoreToCount(this.f5185c);
    }

    /* JADX INFO: renamed from: a */
    private boolean m5568a(Drawable.Callback callback) {
        return callback instanceof View;
    }
}
