package com.shengrendan.mysweetdemo.libs;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class SuccessTickView extends View {

    /* JADX INFO: renamed from: a */
    private float f9094a;

    /* JADX INFO: renamed from: b */
    private Paint f9095b;

    /* JADX INFO: renamed from: c */
    private final float f9096c;

    /* JADX INFO: renamed from: d */
    private final float f9097d;

    /* JADX INFO: renamed from: e */
    private final float f9098e;

    /* JADX INFO: renamed from: f */
    private final float f9099f;

    /* JADX INFO: renamed from: g */
    private final float f9100g;

    /* JADX INFO: renamed from: h */
    private final float f9101h;

    /* JADX INFO: renamed from: i */
    private float f9102i;

    /* JADX INFO: renamed from: j */
    private float f9103j;

    /* JADX INFO: renamed from: k */
    private float f9104k;

    /* JADX INFO: renamed from: l */
    private boolean f9105l;

    public SuccessTickView(Context context) {
        super(context);
        this.f9094a = -1.0f;
        this.f9096c = m8669a(1.2f);
        this.f9097d = m8669a(3.0f);
        this.f9098e = m8669a(15.0f);
        this.f9099f = m8669a(25.0f);
        this.f9100g = m8669a(3.3f);
        this.f9101h = this.f9099f + m8669a(6.7f);
        m8664b();
    }

    public SuccessTickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9094a = -1.0f;
        this.f9096c = m8669a(1.2f);
        this.f9097d = m8669a(3.0f);
        this.f9098e = m8669a(15.0f);
        this.f9099f = m8669a(25.0f);
        this.f9100g = m8669a(3.3f);
        this.f9101h = this.f9099f + m8669a(6.7f);
        m8664b();
    }

    /* JADX INFO: renamed from: b */
    private void m8664b() {
        this.f9095b = new Paint();
        this.f9095b.setColor(getResources().getColor(R.color.success_stroke_color));
        this.f9103j = this.f9098e;
        this.f9104k = this.f9099f;
        this.f9105l = false;
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        canvas.rotate(45.0f, width / 2, height / 2);
        int i = (int) (((double) height) / 1.4d);
        float f = (int) (((double) width) / 1.2d);
        this.f9102i = (((this.f9098e + f) / 2.0f) + this.f9097d) - 1.0f;
        RectF rectF = new RectF();
        if (this.f9105l) {
            rectF.left = 0.0f;
            rectF.right = rectF.left + this.f9103j;
            rectF.top = (i + this.f9099f) / 2.0f;
            rectF.bottom = rectF.top + this.f9097d;
        } else {
            rectF.right = (((this.f9098e + f) / 2.0f) + this.f9097d) - 1.0f;
            rectF.left = rectF.right - this.f9103j;
            rectF.top = (i + this.f9099f) / 2.0f;
            rectF.bottom = rectF.top + this.f9097d;
        }
        canvas.drawRoundRect(rectF, this.f9096c, this.f9096c, this.f9095b);
        RectF rectF2 = new RectF();
        rectF2.bottom = (((i + this.f9099f) / 2.0f) + this.f9097d) - 1.0f;
        rectF2.left = (f + this.f9098e) / 2.0f;
        rectF2.right = rectF2.left + this.f9097d;
        rectF2.top = rectF2.bottom - this.f9104k;
        canvas.drawRoundRect(rectF2, this.f9096c, this.f9096c, this.f9095b);
    }

    /* JADX INFO: renamed from: a */
    public float m8669a(float f) {
        if (this.f9094a == -1.0f) {
            this.f9094a = getResources().getDisplayMetrics().density;
        }
        return (f * this.f9094a) + 0.5f;
    }

    /* JADX INFO: renamed from: a */
    public void m8670a() {
        this.f9103j = 0.0f;
        this.f9104k = 0.0f;
        invalidate();
        Animation animation = new Animation() { // from class: com.shengrendan.mysweetdemo.libs.SuccessTickView.1
            @Override // android.view.animation.Animation
            protected void applyTransformation(float f, Transformation transformation) {
                super.applyTransformation(f, transformation);
                double d = f;
                if (0.54d < d && 0.7d >= d) {
                    SuccessTickView.this.f9105l = true;
                    SuccessTickView.this.f9103j = SuccessTickView.this.f9102i * ((f - 0.54f) / 0.16f);
                    if (0.65d < d) {
                        SuccessTickView.this.f9104k = SuccessTickView.this.f9101h * ((f - 0.65f) / 0.19f);
                    }
                    SuccessTickView.this.invalidate();
                    return;
                }
                if (0.7d < d && 0.84d >= d) {
                    SuccessTickView.this.f9105l = false;
                    SuccessTickView.this.f9103j = SuccessTickView.this.f9102i * (1.0f - ((f - 0.7f) / 0.14f));
                    SuccessTickView.this.f9103j = SuccessTickView.this.f9103j < SuccessTickView.this.f9100g ? SuccessTickView.this.f9100g : SuccessTickView.this.f9103j;
                    SuccessTickView.this.f9104k = SuccessTickView.this.f9101h * ((f - 0.65f) / 0.19f);
                    SuccessTickView.this.invalidate();
                    return;
                }
                if (0.84d >= d || 1.0f < f) {
                    return;
                }
                SuccessTickView.this.f9105l = false;
                float f2 = (f - 0.84f) / 0.16f;
                SuccessTickView.this.f9103j = SuccessTickView.this.f9100g + ((SuccessTickView.this.f9098e - SuccessTickView.this.f9100g) * f2);
                SuccessTickView.this.f9104k = SuccessTickView.this.f9099f + ((SuccessTickView.this.f9101h - SuccessTickView.this.f9099f) * (1.0f - f2));
                SuccessTickView.this.invalidate();
            }
        };
        animation.setDuration(750L);
        animation.setStartOffset(100L);
        startAnimation(animation);
    }
}
