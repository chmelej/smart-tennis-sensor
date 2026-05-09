package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class MyPregview extends View {

    /* JADX INFO: renamed from: d */
    private static final int[] f8453d = {R.color.sport_text_number, R.color.sport_text_number, R.color.sport_text_number};

    /* JADX INFO: renamed from: a */
    public int f8454a;

    /* JADX INFO: renamed from: b */
    public int f8455b;

    /* JADX INFO: renamed from: c */
    public int f8456c;

    /* JADX INFO: renamed from: e */
    private float f8457e;

    /* JADX INFO: renamed from: f */
    private float f8458f;

    /* JADX INFO: renamed from: g */
    private Paint f8459g;

    /* JADX INFO: renamed from: h */
    private int f8460h;

    /* JADX INFO: renamed from: i */
    private int f8461i;

    /* JADX INFO: renamed from: j */
    private int f8462j;

    /* JADX INFO: renamed from: k */
    private ValueAnimator f8463k;

    /* JADX INFO: renamed from: l */
    private Float f8464l;

    /* JADX INFO: renamed from: m */
    private Float f8465m;

    public MyPregview(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8465m = Float.valueOf(0.0f);
        m8180a(context);
    }

    public MyPregview(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8465m = Float.valueOf(0.0f);
        m8180a(context);
    }

    public MyPregview(Context context) {
        super(context);
        this.f8465m = Float.valueOf(0.0f);
        m8180a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m8180a(Context context) {
        this.f8455b = getResources().getColor(R.color.sport_progrress);
        this.f8454a = getResources().getColor(R.color.sport_progrress);
        this.f8456c = getResources().getColor(R.color.sport_text_number);
        this.f8464l = Float.valueOf((this.f8461i - 2) * (this.f8458f / this.f8457e));
        this.f8465m = Float.valueOf(0.0f);
    }

    @Override // android.view.View
    @SuppressLint({"ResourceAsColor"})
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        this.f8459g = new Paint();
        this.f8459g.setAntiAlias(true);
        int i = this.f8462j / 2;
        this.f8459g.setColor(this.f8454a);
        float f2 = i;
        canvas.drawRoundRect(new RectF(0.0f, 0.0f, this.f8461i, this.f8462j), f2, f2, this.f8459g);
        this.f8459g.setColor(this.f8455b);
        canvas.drawRoundRect(new RectF(2.0f, 2.0f, this.f8461i - 2, this.f8462j - 2), f2, f2, this.f8459g);
        float f3 = this.f8458f / this.f8457e;
        Log.d("2015-12-14", "section=" + f3);
        if (f3 > 1.0f) {
            f = (float) (((double) (this.f8461i - this.f8460h)) + (((double) this.f8460h) * (((double) (f3 - 1.0f)) / 0.2d)));
            Log.d("2015-12-14", "if.pregressnum=" + f);
        } else {
            f = (this.f8461i * f3) - this.f8460h;
            Log.d("2015-12-14", "else.pregressnum=" + f);
        }
        RectF rectF = new RectF(2.0f, 2.0f, f, this.f8462j - 2);
        this.f8465m = this.f8464l;
        this.f8459g.setColor(this.f8456c);
        canvas.drawRoundRect(rectF, f2, f2, this.f8459g);
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    private void m8179a(float f, float f2) {
        this.f8463k = ValueAnimator.ofFloat(f, f2);
        this.f8463k.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.MyPregview.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                MyPregview.this.f8464l = (Float) valueAnimator.getAnimatedValue();
                MyPregview.this.postInvalidate();
            }
        });
        this.f8463k.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f8463k.setDuration(2000L);
        this.f8463k.start();
    }

    public void setGrade(int i) {
        Log.d("2015-12-7", "currentCountd" + i);
        float f = (float) i;
        this.f8458f = f > this.f8457e ? this.f8457e : f;
        m8179a(this.f8465m.floatValue(), (this.f8461i - 2) * (f / this.f8457e));
    }

    /* JADX INFO: renamed from: a */
    private int m8177a(int i) {
        return (int) ((i * getContext().getResources().getDisplayMetrics().density) + ((i >= 0 ? 1 : -1) * 0.5f));
    }

    public void setMaxCount(float f, int i) {
        this.f8457e = f;
        this.f8460h = i;
    }

    public void setCurrentCount(float f) {
        double d = f;
        if (d > ((double) this.f8457e) + (((double) this.f8457e) * 0.2d)) {
            d = ((double) this.f8457e) + (((double) this.f8457e) * 0.2d);
        }
        this.f8458f = (float) d;
        this.f8464l = Float.valueOf((this.f8461i - 2) * (f / this.f8457e));
        Log.d("2015-12-7", "scoreint=" + this.f8464l);
        invalidate();
    }

    public float getMaxCount() {
        return this.f8457e;
    }

    public float getCurrentCount() {
        return this.f8458f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 || mode == Integer.MIN_VALUE) {
            this.f8461i = size;
        } else {
            this.f8461i = 0;
        }
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            this.f8462j = m8177a(15);
        } else {
            this.f8462j = size2;
        }
        Log.d("2015-12-14", "mWidth=" + this.f8461i);
        setMeasuredDimension(this.f8461i, this.f8462j);
    }
}
