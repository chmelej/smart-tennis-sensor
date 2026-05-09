package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class SportCircleProgressView extends View {

    /* JADX INFO: renamed from: a */
    private int f8708a;

    /* JADX INFO: renamed from: b */
    private int f8709b;

    /* JADX INFO: renamed from: c */
    private Paint f8710c;

    /* JADX INFO: renamed from: d */
    private Paint f8711d;

    /* JADX INFO: renamed from: e */
    private float f8712e;

    /* JADX INFO: renamed from: f */
    private float f8713f;

    /* JADX INFO: renamed from: g */
    private RectF f8714g;

    /* JADX INFO: renamed from: h */
    private int f8715h;

    /* JADX INFO: renamed from: i */
    private int f8716i;

    /* JADX INFO: renamed from: j */
    private int f8717j;

    /* JADX INFO: renamed from: k */
    private boolean f8718k;

    /* JADX INFO: renamed from: l */
    private int[] f8719l;

    public SportCircleProgressView(Context context) {
        super(context);
        this.f8712e = 100.0f;
        this.f8714g = new RectF();
        this.f8715h = 60;
        this.f8716i = 10;
        this.f8718k = false;
        this.f8719l = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        m8268a(context, null, 0);
    }

    public SportCircleProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8712e = 100.0f;
        this.f8714g = new RectF();
        this.f8715h = 60;
        this.f8716i = 10;
        this.f8718k = false;
        this.f8719l = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        m8268a(context, attributeSet, 0);
    }

    public SportCircleProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8712e = 100.0f;
        this.f8714g = new RectF();
        this.f8715h = 60;
        this.f8716i = 10;
        this.f8718k = false;
        this.f8719l = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        m8268a(context, attributeSet, i);
    }

    @TargetApi(21)
    public SportCircleProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8712e = 100.0f;
        this.f8714g = new RectF();
        this.f8715h = 60;
        this.f8716i = 10;
        this.f8718k = false;
        this.f8719l = new int[]{Color.parseColor("#ffd246"), Color.parseColor("#fa5d4c"), Color.parseColor("#f8296b"), Color.parseColor("#fa5d4c"), Color.parseColor("#ffd246")};
        m8268a(context, attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    private void m8268a(Context context, AttributeSet attributeSet, int i) {
        this.f8710c = new Paint();
        this.f8710c.setAntiAlias(true);
        this.f8710c.setStyle(Paint.Style.STROKE);
        this.f8710c.setColor(Color.parseColor("#f2f2f2"));
        this.f8711d = new Paint();
        this.f8711d.setAntiAlias(true);
        this.f8711d.setStyle(Paint.Style.STROKE);
        if (attributeSet == null) {
            return;
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.sport_circle, i, 0);
        this.f8716i = typedArrayObtainStyledAttributes.getDimensionPixelSize(1, 60);
        this.f8717j = typedArrayObtainStyledAttributes.getColor(2, context.getResources().getColor(R.color.text_menu_checked));
        this.f8718k = typedArrayObtainStyledAttributes.getBoolean(0, false);
        this.f8710c.setStrokeWidth(this.f8716i);
        this.f8711d.setStrokeWidth(this.f8716i);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8708a = View.MeasureSpec.getSize(i);
        this.f8709b = View.MeasureSpec.getSize(i2);
        int iMin = Math.min(this.f8708a, this.f8709b) / 2;
        this.f8714g.set(((this.f8708a / 2) - iMin) + 10 + (this.f8716i / 2), ((this.f8709b / 2) - iMin) + 10 + (this.f8716i / 2), (((this.f8708a / 2) + iMin) - 10) - (this.f8716i / 2), (((this.f8709b / 2) + iMin) - 10) - (this.f8716i / 2));
        setMeasuredDimension(this.f8708a, this.f8709b);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = (int) ((this.f8713f * 360.0f) / this.f8712e);
        canvas.drawCircle(this.f8714g.centerX(), this.f8714g.centerY(), (Math.min(this.f8708a / 2, this.f8709b / 2) - 10) - (this.f8716i / 2), this.f8710c);
        if (this.f8718k) {
            this.f8711d.setShader(new SweepGradient(this.f8708a / 2, this.f8709b / 2, this.f8719l, (float[]) null));
            Matrix matrix = new Matrix();
            this.f8711d.getShader().getLocalMatrix(matrix);
            matrix.postTranslate(-this.f8714g.centerX(), -this.f8714g.centerY());
            matrix.postRotate(-90.0f);
            matrix.postTranslate(this.f8714g.centerX(), this.f8714g.centerY());
            this.f8711d.getShader().setLocalMatrix(matrix);
        } else {
            this.f8711d.setColor(this.f8717j);
        }
        canvas.drawArc(this.f8714g, 270.0f, i, false, this.f8711d);
    }

    public void setProgress(float f) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setFloatValues(this.f8713f, f);
        valueAnimator.setDuration(1200L);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.SportCircleProgressView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                SportCircleProgressView.this.f8713f = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                SportCircleProgressView.this.invalidate();
            }
        });
        valueAnimator.start();
    }

    public void setCurColor(int i) {
        this.f8717j = i;
    }

    public void setRingWidth(int i) {
        float f = i;
        this.f8710c.setStrokeWidth(f);
        this.f8711d.setStrokeWidth(f);
        this.f8716i = i;
        int iMin = Math.min(i, this.f8709b) / 2;
        int i2 = i / 2;
        this.f8714g.set((i2 - iMin) + 10 + (this.f8716i / 2), ((this.f8709b / 2) - iMin) + 10 + (this.f8716i / 2), ((i2 + iMin) - 10) - (this.f8716i / 2), (((this.f8709b / 2) + iMin) - 10) - (this.f8716i / 2));
    }

    public void setMultiColor(boolean z) {
        this.f8718k = z;
    }
}
