package com.coollang.tennis.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import p000.C1895ly;
import p000.C1900mc;
import p000.C1914mm;

/* JADX INFO: loaded from: classes.dex */
public class RealBar extends View {

    /* JADX INFO: renamed from: a */
    public String f8588a;

    /* JADX INFO: renamed from: b */
    public float f8589b;

    /* JADX INFO: renamed from: c */
    private Paint f8590c;

    /* JADX INFO: renamed from: d */
    private Paint f8591d;

    /* JADX INFO: renamed from: e */
    private int f8592e;

    /* JADX INFO: renamed from: f */
    private boolean f8593f;

    /* JADX INFO: renamed from: g */
    private ValueAnimator f8594g;

    /* JADX INFO: renamed from: h */
    private int f8595h;

    /* JADX INFO: renamed from: i */
    private Bitmap[] f8596i;

    /* JADX INFO: renamed from: j */
    private Bitmap f8597j;

    public RealBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8588a = "10";
        this.f8593f = false;
        this.f8596i = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.ic_pingji), BitmapFactory.decodeResource(getResources(), R.drawable.ic_xuanqiu), BitmapFactory.decodeResource(getResources(), R.drawable.ic_xiaoqiu), BitmapFactory.decodeResource(getResources(), R.drawable.ic_jieji), BitmapFactory.decodeResource(getResources(), R.drawable.ic_kousha), BitmapFactory.decodeResource(getResources(), R.drawable.ic_faqiu)};
        this.f8597j = BitmapFactory.decodeResource(getResources(), R.drawable.real_qipao);
    }

    public RealBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8588a = "10";
        this.f8593f = false;
        this.f8596i = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.ic_pingji), BitmapFactory.decodeResource(getResources(), R.drawable.ic_xuanqiu), BitmapFactory.decodeResource(getResources(), R.drawable.ic_xiaoqiu), BitmapFactory.decodeResource(getResources(), R.drawable.ic_jieji), BitmapFactory.decodeResource(getResources(), R.drawable.ic_kousha), BitmapFactory.decodeResource(getResources(), R.drawable.ic_faqiu)};
        this.f8597j = BitmapFactory.decodeResource(getResources(), R.drawable.real_qipao);
        int attributeResourceValue = attributeSet.getAttributeResourceValue(null, "Color", 0);
        int attributeIntValue = attributeSet.getAttributeIntValue(null, "pTop", 210);
        this.f8595h = attributeSet.getAttributeIntValue(null, "TheWitch", 210);
        this.f8589b = attributeIntValue;
        this.f8592e = attributeResourceValue;
    }

    public RealBar(Context context) {
        super(context);
        this.f8588a = "10";
        this.f8593f = false;
        this.f8596i = new Bitmap[]{BitmapFactory.decodeResource(getResources(), R.drawable.ic_pingji), BitmapFactory.decodeResource(getResources(), R.drawable.ic_xuanqiu), BitmapFactory.decodeResource(getResources(), R.drawable.ic_xiaoqiu), BitmapFactory.decodeResource(getResources(), R.drawable.ic_jieji), BitmapFactory.decodeResource(getResources(), R.drawable.ic_kousha), BitmapFactory.decodeResource(getResources(), R.drawable.ic_faqiu)};
        this.f8597j = BitmapFactory.decodeResource(getResources(), R.drawable.real_qipao);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        if (size2 < 300) {
            size2 = 300;
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        if (isInEditMode()) {
            return;
        }
        C1900mc.m10474b("REALbar", "height = " + this.f8589b + " === " + getHeight());
        float width = (float) this.f8596i[0].getWidth();
        float height = (float) this.f8596i[0].getHeight();
        float height2 = (float) this.f8597j.getHeight();
        this.f8590c = new Paint();
        this.f8591d = new Paint();
        this.f8590c.setColor(getResources().getColor(this.f8592e));
        this.f8591d.setColor(getResources().getColor(R.color.white));
        this.f8591d.setTextSize(C1895ly.m10460a(getContext(), 10.0f));
        this.f8591d.setStyle(Paint.Style.FILL);
        this.f8591d.setAntiAlias(true);
        this.f8590c.setStyle(Paint.Style.FILL);
        this.f8590c.setAntiAlias(true);
        if (MyApplication.m7738a().m7747g()) {
            str = this.f8588a + C1914mm.m10557b(R.string.times);
        } else {
            str = this.f8588a;
        }
        if (this.f8593f) {
            canvas.drawBitmap(this.f8597j, 0.0f, (this.f8589b - height) + 15.0f, (Paint) null);
            canvas.drawText(str, (getWidth() - this.f8591d.measureText(str)) / 2.0f, (height2 / 3.0f) + this.f8589b, this.f8591d);
        }
        canvas.drawBitmap(this.f8596i[this.f8595h], 0.0f, (this.f8589b - height) + height2 + 25.0f, (Paint) null);
        canvas.drawRect(0.0f, this.f8589b + height2 + 25.0f, width, height2 + 210.0f + 30.0f, this.f8590c);
    }

    /* JADX INFO: renamed from: a */
    private void m8241a(float f, float f2) {
        this.f8594g = ValueAnimator.ofFloat(f, f2);
        this.f8594g.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.coollang.tennis.widget.RealBar.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RealBar.this.f8589b = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                RealBar.this.postInvalidate();
            }
        });
        this.f8594g.setInterpolator(new DecelerateInterpolator(3.0f));
        this.f8594g.setDuration(2000L);
        this.f8594g.start();
    }

    public void setpTop(float f, float f2) {
        m8241a(f, f2);
    }

    private String getTextString() {
        return this.f8588a;
    }

    public void setTextString(String str) {
        this.f8588a = str;
        this.f8593f = true;
        invalidate();
    }

    public void setVisiableV() {
        this.f8593f = false;
        invalidate();
    }
}
