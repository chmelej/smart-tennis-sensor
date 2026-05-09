package com.coollang.tennis.Custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class CompletedView extends View {

    /* JADX INFO: renamed from: a */
    private Paint f6209a;

    /* JADX INFO: renamed from: b */
    private Paint f6210b;

    /* JADX INFO: renamed from: c */
    private Paint f6211c;

    /* JADX INFO: renamed from: d */
    private Paint f6212d;

    /* JADX INFO: renamed from: e */
    private int f6213e;

    /* JADX INFO: renamed from: f */
    private int f6214f;

    /* JADX INFO: renamed from: g */
    private int f6215g;

    /* JADX INFO: renamed from: h */
    private float f6216h;

    /* JADX INFO: renamed from: i */
    private float f6217i;

    /* JADX INFO: renamed from: j */
    private float f6218j;

    /* JADX INFO: renamed from: k */
    private int f6219k;

    /* JADX INFO: renamed from: l */
    private int f6220l;

    /* JADX INFO: renamed from: m */
    private float f6221m;

    /* JADX INFO: renamed from: n */
    private int f6222n;

    /* JADX INFO: renamed from: o */
    private int f6223o;

    public CompletedView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f6222n = 20;
        m6859a(context, attributeSet);
        m6858a();
    }

    /* JADX INFO: renamed from: a */
    private void m6859a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.TasksCompletedView, 0, 0);
        this.f6216h = typedArrayObtainStyledAttributes.getDimension(1, 80.0f);
        this.f6218j = typedArrayObtainStyledAttributes.getDimension(4, 10.0f);
        this.f6213e = typedArrayObtainStyledAttributes.getColor(0, -1);
        this.f6214f = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.f6215g = typedArrayObtainStyledAttributes.getColor(2, -1);
        this.f6217i = this.f6216h + (this.f6218j / 2.0f);
    }

    /* JADX INFO: renamed from: a */
    private void m6858a() {
        this.f6209a = new Paint();
        this.f6209a.setAntiAlias(true);
        this.f6209a.setColor(this.f6213e);
        this.f6209a.setStyle(Paint.Style.FILL);
        this.f6211c = new Paint();
        this.f6211c.setAntiAlias(true);
        this.f6211c.setColor(this.f6215g);
        this.f6211c.setStyle(Paint.Style.STROKE);
        this.f6211c.setStrokeWidth(this.f6218j);
        this.f6210b = new Paint();
        this.f6210b.setAntiAlias(true);
        this.f6210b.setColor(this.f6214f);
        this.f6210b.setStyle(Paint.Style.STROKE);
        this.f6210b.setStrokeWidth(this.f6218j);
        this.f6212d = new Paint();
        this.f6212d.setAntiAlias(true);
        this.f6212d.setStyle(Paint.Style.FILL);
        this.f6212d.setColor(this.f6214f);
        this.f6212d.setTextSize(this.f6216h / 2.0f);
        Paint.FontMetrics fontMetrics = this.f6212d.getFontMetrics();
        this.f6221m = (int) Math.ceil(fontMetrics.descent - fontMetrics.ascent);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        this.f6219k = getWidth() / 2;
        this.f6220l = getHeight() / 2;
        RectF rectF = new RectF();
        rectF.left = this.f6219k - this.f6217i;
        rectF.top = this.f6220l - this.f6217i;
        rectF.right = (this.f6217i * 2.0f) + (this.f6219k - this.f6217i);
        rectF.bottom = (this.f6217i * 2.0f) + (this.f6220l - this.f6217i);
        canvas.drawArc(rectF, 0.0f, 360.0f, false, this.f6211c);
        if (this.f6223o > 0) {
            RectF rectF2 = new RectF();
            rectF2.left = this.f6219k - this.f6217i;
            rectF2.top = this.f6220l - this.f6217i;
            rectF2.right = (this.f6217i * 2.0f) + (this.f6219k - this.f6217i);
            rectF2.bottom = (this.f6217i * 2.0f) + (this.f6220l - this.f6217i);
            canvas.drawArc(rectF2, -90.0f, (this.f6223o / this.f6222n) * 360.0f, false, this.f6210b);
        }
    }

    public void setProgress(int i) {
        this.f6223o = i;
        postInvalidate();
    }
}
