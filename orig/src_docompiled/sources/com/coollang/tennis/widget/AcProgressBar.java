package com.coollang.tennis.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class AcProgressBar extends View {

    /* JADX INFO: renamed from: a */
    float f7931a;

    /* JADX INFO: renamed from: b */
    int f7932b;

    /* JADX INFO: renamed from: c */
    float f7933c;

    /* JADX INFO: renamed from: d */
    float f7934d;

    /* JADX INFO: renamed from: e */
    float f7935e;

    /* JADX INFO: renamed from: f */
    float f7936f;

    /* JADX INFO: renamed from: g */
    boolean f7937g;

    /* JADX INFO: renamed from: h */
    public Point f7938h;

    /* JADX INFO: renamed from: i */
    public float f7939i;

    /* JADX INFO: renamed from: j */
    public float f7940j;

    /* JADX INFO: renamed from: k */
    boolean f7941k;

    /* JADX INFO: renamed from: l */
    int f7942l;

    /* JADX INFO: renamed from: m */
    private Paint f7943m;

    /* JADX INFO: renamed from: n */
    private float f7944n;

    /* JADX INFO: renamed from: o */
    private RectF f7945o;

    /* JADX INFO: renamed from: p */
    private float f7946p;

    /* JADX INFO: renamed from: q */
    private float f7947q;

    /* JADX INFO: renamed from: r */
    private TextPaint f7948r;

    /* JADX INFO: renamed from: s */
    private Bitmap f7949s;

    /* JADX INFO: renamed from: t */
    private Paint f7950t;

    /* JADX INFO: renamed from: u */
    private Bitmap f7951u;

    public AcProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7944n = 37.0f;
        this.f7931a = 20.0f;
        this.f7932b = 0;
        this.f7933c = 20.0f;
        this.f7934d = 285.0f;
        this.f7935e = 20.0f;
        this.f7936f = 285.0f;
        this.f7937g = false;
        this.f7938h = null;
        this.f7939i = 0.0f;
        this.f7940j = 0.0f;
        this.f7941k = false;
        m8014a();
    }

    public AcProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7944n = 37.0f;
        this.f7931a = 20.0f;
        this.f7932b = 0;
        this.f7933c = 20.0f;
        this.f7934d = 285.0f;
        this.f7935e = 20.0f;
        this.f7936f = 285.0f;
        this.f7937g = false;
        this.f7938h = null;
        this.f7939i = 0.0f;
        this.f7940j = 0.0f;
        this.f7941k = false;
        m8014a();
    }

    public AcProgressBar(Context context) {
        super(context);
        this.f7944n = 37.0f;
        this.f7931a = 20.0f;
        this.f7932b = 0;
        this.f7933c = 20.0f;
        this.f7934d = 285.0f;
        this.f7935e = 20.0f;
        this.f7936f = 285.0f;
        this.f7937g = false;
        this.f7938h = null;
        this.f7939i = 0.0f;
        this.f7940j = 0.0f;
        this.f7941k = false;
        m8014a();
    }

    /* JADX INFO: renamed from: a */
    private void m8014a() {
        this.f7950t = new Paint();
        this.f7949s = BitmapFactory.decodeResource(getResources(), R.drawable.ring_new);
        this.f7951u = BitmapFactory.decodeResource(getResources(), R.drawable.pointer);
        this.f7943m = new Paint(1);
        this.f7943m.setStyle(Paint.Style.STROKE);
        this.f7943m.setColor(Color.parseColor("#ff8560"));
        this.f7948r = new TextPaint();
        this.f7948r.setColor(Color.parseColor("#7c7b80"));
        this.f7948r.setTextAlign(Paint.Align.CENTER);
        this.f7948r.setTextSize(C1895ly.m10462c(getContext(), 25.0f));
        this.f7948r.setAntiAlias(true);
        this.f7944n = (this.f7949s.getWidth() * 20) / 275;
        this.f7943m.setStrokeWidth(this.f7944n);
        this.f7939i = (this.f7949s.getWidth() - this.f7944n) / 2.0f;
        this.f7938h = new Point(this.f7949s.getWidth() / 2, this.f7949s.getHeight() / 2);
        this.f7945o = m8013a(this.f7938h.x - this.f7939i, this.f7938h.y - this.f7939i, this.f7938h.x + this.f7939i, this.f7938h.y + this.f7939i);
        this.f7947q = 0.0f;
    }

    /* JADX INFO: renamed from: a */
    private RectF m8013a(float f, float f2, float f3, float f4) {
        return new RectF(f, f2, f3, f4);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(this.f7949s.getWidth(), this.f7949s.getHeight());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(this.f7949s, 0.0f, 0.0f, this.f7950t);
        m8015a(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m8015a(Canvas canvas) {
        if (Math.abs(this.f7947q - this.f7940j) > this.f7946p) {
            if (this.f7947q > this.f7940j) {
                this.f7947q -= this.f7946p;
            } else {
                this.f7947q += this.f7946p;
            }
            invalidate();
            canvas.drawArc(this.f7945o, 135.0f, this.f7947q, false, this.f7943m);
            canvas.drawText(Integer.toString((((int) this.f7947q) * 300) / 270), this.f7938h.x, this.f7938h.y + C1895ly.m10460a(getContext(), 8.0f), this.f7948r);
            return;
        }
        canvas.drawArc(this.f7945o, 135.0f, this.f7940j, false, this.f7943m);
        if (this.f7941k) {
            canvas.drawText(Integer.toString(this.f7942l), this.f7938h.x, this.f7938h.y + C1895ly.m10460a(getContext(), 8.0f), this.f7948r);
        } else {
            canvas.drawText(Integer.toString(this.f7942l), this.f7938h.x, this.f7938h.y + C1895ly.m10460a(getContext(), 8.0f), this.f7948r);
        }
    }

    public void setDegree(double d, boolean z, int i) {
        if (this.f7937g) {
            this.f7947q = 0.0f;
        }
        this.f7942l = i;
        this.f7941k = z;
        this.f7940j = (float) d;
        this.f7946p = Math.abs(this.f7940j - this.f7947q) / 20.0f;
        invalidate();
    }
}
