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
import p000.C1914mm;

/* JADX INFO: loaded from: classes.dex */
public class MultiColorSeekBar extends View {

    /* JADX INFO: renamed from: a */
    private int f8405a;

    /* JADX INFO: renamed from: b */
    private int f8406b;

    /* JADX INFO: renamed from: c */
    private int f8407c;

    /* JADX INFO: renamed from: d */
    private int[] f8408d;

    /* JADX INFO: renamed from: e */
    private Bitmap f8409e;

    /* JADX INFO: renamed from: f */
    private int f8410f;

    /* JADX INFO: renamed from: g */
    private int f8411g;

    /* JADX INFO: renamed from: h */
    private int f8412h;

    /* JADX INFO: renamed from: i */
    private int f8413i;

    /* JADX INFO: renamed from: j */
    private Paint f8414j;

    /* JADX INFO: renamed from: k */
    private Paint f8415k;

    /* JADX INFO: renamed from: l */
    private float f8416l;

    /* JADX INFO: renamed from: m */
    private InterfaceC1342a f8417m;

    /* JADX INFO: renamed from: n */
    private Paint f8418n;

    /* JADX INFO: renamed from: o */
    private Paint f8419o;

    /* JADX INFO: renamed from: p */
    private int f8420p;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.MultiColorSeekBar$a */
    public interface InterfaceC1342a {
        /* JADX INFO: renamed from: a */
        void mo7343a(int i);
    }

    /* JADX INFO: renamed from: a */
    private int m8167a(float f) {
        return 0;
    }

    public void setOnSeekbarChangedListener(InterfaceC1342a interfaceC1342a) {
        this.f8417m = interfaceC1342a;
    }

    public MultiColorSeekBar(Context context) {
        super(context);
        this.f8410f = 2000;
        this.f8411g = 1000;
        this.f8416l = 0.0f;
        this.f8420p = 0;
        m8168a();
    }

    public MultiColorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8410f = 2000;
        this.f8411g = 1000;
        this.f8416l = 0.0f;
        this.f8420p = 0;
        m8168a();
    }

    public MultiColorSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8410f = 2000;
        this.f8411g = 1000;
        this.f8416l = 0.0f;
        this.f8420p = 0;
        m8168a();
    }

    /* JADX INFO: renamed from: a */
    private void m8168a() {
        this.f8407c = C1895ly.m10460a(C1914mm.m10554a(), 5.0f);
        this.f8408d = new int[]{Color.parseColor("#4296fe"), Color.parseColor("#25c9ad"), Color.parseColor("#ec6941"), Color.parseColor("#e60012")};
        this.f8409e = BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_target_sb_thumb);
        this.f8414j = new Paint();
        this.f8414j.setStyle(Paint.Style.FILL);
        this.f8414j.setAntiAlias(true);
        this.f8414j.setStrokeWidth(this.f8407c);
        this.f8414j.setColor(Color.parseColor("#dededf"));
        this.f8414j.setStrokeCap(Paint.Cap.ROUND);
        this.f8415k = new Paint();
        this.f8415k.setStyle(Paint.Style.FILL);
        this.f8415k.setAntiAlias(true);
        this.f8415k.setStrokeWidth(this.f8407c);
        this.f8415k.setColor(this.f8408d[0]);
        this.f8415k.setStrokeCap(Paint.Cap.ROUND);
        this.f8418n = new Paint();
        this.f8418n.setStyle(Paint.Style.FILL);
        this.f8418n.setAntiAlias(true);
        this.f8418n.setTextSize(C1895ly.m10460a(C1914mm.m10554a(), 14.0f));
        this.f8418n.setColor(C1914mm.m10559d(R.color.text_menu));
        this.f8419o = new Paint();
        this.f8419o.setStyle(Paint.Style.FILL);
        this.f8419o.setAntiAlias(true);
        this.f8419o.setStrokeWidth(C1895ly.m10460a(C1914mm.m10554a(), 1.0f));
        this.f8419o.setColor(C1914mm.m10559d(R.color.text_menu_checked));
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8405a = View.MeasureSpec.getSize(i);
        this.f8406b = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8405a, this.f8406b);
    }

    public void setMax(int i) {
        this.f8410f = i;
    }

    public void setProgress(int i, int i2, int i3) {
        this.f8411g = i;
        this.f8412h = i2;
        this.f8413i = i3;
        this.f8416l = (float) ((((double) (i * this.f8405a)) * 1.0d) / ((double) this.f8410f));
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (float) ((((double) this.f8412h) * 1.0d) / ((double) this.f8410f));
        float f2 = (float) ((((double) this.f8413i) * 1.0d) / ((double) this.f8410f));
        float fM10460a = C1895ly.m10460a(C1914mm.m10554a(), 50.0f);
        int textSize = (int) ((this.f8418n.getTextSize() / 2.0f) + fM10460a);
        int iM10460a = C1895ly.m10460a(C1914mm.m10554a(), 30.0f) + textSize;
        int iM8167a = (int) (f * (this.f8405a + m8167a(f)));
        if (iM8167a == 0) {
            iM8167a = this.f8409e.getWidth() / 2;
        }
        int iM8167a2 = (int) (f2 * (this.f8405a + m8167a(f2)));
        if (iM8167a2 == 0) {
            iM8167a2 = this.f8409e.getWidth() / 2;
        }
        int textSize2 = (int) ((this.f8418n.getTextSize() * 2.0f) + C1895ly.m10460a(C1914mm.m10554a(), 3.0f));
        if (Math.abs(iM8167a2 - iM8167a) < textSize2) {
            if (iM8167a2 >= iM8167a) {
                iM8167a2 = iM8167a + textSize2;
            } else {
                iM8167a = iM8167a2 + textSize2;
            }
        }
        int i = iM8167a2;
        float f3 = iM8167a;
        float f4 = textSize;
        float f5 = iM10460a;
        canvas.drawLine(f3, f4, f3, f5, this.f8419o);
        String strM10557b = C1914mm.m10557b(R.string.average);
        canvas.drawText(strM10557b, f3 - ((strM10557b.length() > 2 ? strM10557b.length() / 3 : 1) * this.f8418n.getTextSize()), fM10460a, this.f8418n);
        float f6 = i;
        canvas.drawLine(f6, f4, f6, f5, this.f8419o);
        String strM10557b2 = C1914mm.m10557b(R.string.recommend);
        canvas.drawText(strM10557b2, f6 - ((strM10557b2.length() > 2 ? strM10557b2.length() / 4 : 1) * this.f8418n.getTextSize()), fM10460a, this.f8418n);
        float height = ((float) (((double) this.f8409e.getHeight()) / 2.0d)) + f5;
        float width = (float) (((double) this.f8409e.getWidth()) / 2.0d);
        float f7 = this.f8416l - width;
        float f8 = this.f8416l + width;
        float width2 = f7 >= 0.0f ? f7 : 0.0f;
        if (f8 > this.f8405a) {
            width2 = this.f8405a - this.f8409e.getWidth();
        }
        float f9 = width2;
        this.f8411g = (int) (((double) f9) * ((((double) this.f8410f) * 1.0d) / ((double) (this.f8405a - this.f8409e.getWidth()))));
        if (this.f8411g % 50 != 0) {
            if (this.f8411g % 50 >= 25) {
                this.f8411g = (this.f8411g - (this.f8411g % 50)) + 50;
            } else {
                this.f8411g -= this.f8411g % 50;
            }
        }
        if (this.f8417m != null && this.f8420p > 2) {
            this.f8417m.mo7343a(this.f8411g);
        } else {
            this.f8420p++;
        }
        double d = (float) ((((double) this.f8411g) * 1.0d) / ((double) this.f8410f));
        if (d <= 0.16d) {
            this.f8415k.setColor(this.f8408d[0]);
        } else if (d <= 0.5d) {
            this.f8415k.setColor(this.f8408d[1]);
        } else if (d <= 0.84d) {
            this.f8415k.setColor(this.f8408d[2]);
        } else {
            this.f8415k.setColor(this.f8408d[3]);
        }
        canvas.drawLine(0.0f, height, this.f8405a, height, this.f8414j);
        canvas.drawLine(0.0f, height, f9, height, this.f8415k);
        canvas.drawBitmap(this.f8409e, f9, f5, (Paint) null);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f8416l = motionEvent.getX();
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
