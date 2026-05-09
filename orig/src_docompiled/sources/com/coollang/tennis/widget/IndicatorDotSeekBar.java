package com.coollang.tennis.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class IndicatorDotSeekBar extends View {

    /* JADX INFO: renamed from: a */
    private int f8358a;

    /* JADX INFO: renamed from: b */
    private int f8359b;

    /* JADX INFO: renamed from: c */
    private int f8360c;

    /* JADX INFO: renamed from: d */
    private int f8361d;

    /* JADX INFO: renamed from: e */
    private int f8362e;

    /* JADX INFO: renamed from: f */
    private int f8363f;

    /* JADX INFO: renamed from: g */
    private int f8364g;

    /* JADX INFO: renamed from: h */
    private int f8365h;

    /* JADX INFO: renamed from: i */
    private float f8366i;

    /* JADX INFO: renamed from: j */
    private int f8367j;

    /* JADX INFO: renamed from: k */
    private Paint f8368k;

    /* JADX INFO: renamed from: l */
    private Paint f8369l;

    /* JADX INFO: renamed from: m */
    private Paint f8370m;

    /* JADX INFO: renamed from: n */
    private Bitmap f8371n;

    /* JADX INFO: renamed from: o */
    private int f8372o;

    /* JADX INFO: renamed from: p */
    private InterfaceC1337a f8373p;

    /* JADX INFO: renamed from: q */
    private int f8374q;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.IndicatorDotSeekBar$a */
    public interface InterfaceC1337a {
        /* JADX INFO: renamed from: a */
        void mo8151a(int i);
    }

    public void setOnSeekbarChangedListener(InterfaceC1337a interfaceC1337a) {
        this.f8373p = interfaceC1337a;
    }

    public IndicatorDotSeekBar(Context context) {
        super(context);
        this.f8362e = 20;
        this.f8363f = 2000;
        this.f8364g = 20;
        this.f8365h = 1000;
        this.f8366i = 0.0f;
        this.f8367j = 1;
        this.f8374q = 0;
        m8150a();
    }

    public IndicatorDotSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8362e = 20;
        this.f8363f = 2000;
        this.f8364g = 20;
        this.f8365h = 1000;
        this.f8366i = 0.0f;
        this.f8367j = 1;
        this.f8374q = 0;
        m8150a();
    }

    public IndicatorDotSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8362e = 20;
        this.f8363f = 2000;
        this.f8364g = 20;
        this.f8365h = 1000;
        this.f8366i = 0.0f;
        this.f8367j = 1;
        this.f8374q = 0;
        m8150a();
    }

    /* JADX INFO: renamed from: a */
    private void m8150a() {
        this.f8360c = C1895ly.m10460a(getContext(), 5.0f);
        this.f8361d = C1895ly.m10460a(getContext(), 6.0f);
        this.f8371n = BitmapFactory.decodeResource(getResources(), R.drawable.img_idc_bg);
        this.f8372o = Color.parseColor("#4296fe");
        this.f8368k = new Paint();
        this.f8368k.setStyle(Paint.Style.FILL);
        this.f8368k.setAntiAlias(true);
        this.f8368k.setStrokeWidth(this.f8360c);
        this.f8368k.setStrokeCap(Paint.Cap.ROUND);
        this.f8369l = new Paint();
        this.f8369l.setTextSize(C1895ly.m10460a(getContext(), 10.0f));
        this.f8369l.setColor(Color.parseColor("#7c7b80"));
        this.f8369l.setAntiAlias(true);
        this.f8370m = new Paint();
        this.f8370m.setAntiAlias(true);
        this.f8370m.setColor(Color.parseColor("#ec6941"));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8358a = View.MeasureSpec.getSize(i);
        this.f8359b = View.MeasureSpec.getSize(i2);
        if (this.f8359b < (this.f8361d * 2) + this.f8371n.getHeight() + this.f8362e) {
            this.f8359b = (this.f8361d * 2) + this.f8371n.getHeight() + this.f8362e;
        }
        setMeasuredDimension(this.f8358a, this.f8359b);
    }

    public void setMax(int i) {
        this.f8363f = i;
    }

    public void setProgress(int i) {
        this.f8365h = i;
        this.f8366i = (((i - this.f8364g) * ((this.f8358a - this.f8371n.getWidth()) - ((this.f8371n.getWidth() / 3.0f) * 2.0f))) / (this.f8363f - this.f8364g)) + ((this.f8371n.getWidth() / 3.0f) * 2.0f);
        invalidate();
    }

    public void setColor(int i) {
        this.f8372o = i;
    }

    public void setMin(int i) {
        this.f8364g = i;
    }

    public void setDivider(int i) {
        this.f8367j = i;
    }

    public int getData() {
        return this.f8365h;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = this.f8362e + this.f8361d + this.f8371n.getHeight();
        float width = (this.f8371n.getWidth() / 3.0f) * 2.0f;
        float width2 = this.f8366i;
        if (width2 < width) {
            width2 = width;
        }
        if (width2 > this.f8358a - this.f8371n.getWidth()) {
            width2 = this.f8358a - this.f8371n.getWidth();
        }
        this.f8365h = (((int) ((((width2 - width) * (this.f8363f - this.f8364g)) / ((this.f8358a - this.f8371n.getWidth()) - width)) / this.f8367j)) * this.f8367j) + this.f8364g;
        float width3 = ((((this.f8358a - this.f8371n.getWidth()) - width) * (this.f8365h - this.f8364g)) / (this.f8363f - this.f8364g)) + width + ((((this.f8358a - this.f8371n.getWidth()) - width) / 10.0f) / this.f8367j);
        if (this.f8373p != null) {
            this.f8373p.mo8151a(this.f8365h);
        }
        String strValueOf = String.valueOf(this.f8365h);
        this.f8368k.setColor(Color.parseColor("#d4d4d4"));
        canvas.drawLine(width, height, this.f8358a - this.f8371n.getWidth(), height, this.f8368k);
        this.f8368k.setColor(this.f8372o);
        canvas.drawLine(width, height, width3, height, this.f8368k);
        this.f8370m.setColor(this.f8372o);
        canvas.drawCircle(width3 - (this.f8361d / 2), height, this.f8361d, this.f8370m);
        this.f8370m.setColor(Color.parseColor("#d4d4d4"));
        canvas.drawCircle(width3 - (this.f8361d / 2), height, this.f8360c / 2, this.f8370m);
        canvas.drawBitmap(this.f8371n, (width3 - ((float) (((double) this.f8371n.getWidth()) / 2.0d))) - (this.f8361d / 2), this.f8362e, (Paint) null);
        canvas.drawText(strValueOf, (width3 - (this.f8369l.measureText(strValueOf) / 2.0f)) - (this.f8361d / 2), this.f8362e + ((float) (((double) (this.f8371n.getHeight() * 2)) / 3.0d)), this.f8369l);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f8366i = motionEvent.getX();
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                invalidate();
                return true;
            case 1:
                invalidate();
                return true;
            case 2:
                invalidate();
                return true;
            default:
                return true;
        }
    }
}
