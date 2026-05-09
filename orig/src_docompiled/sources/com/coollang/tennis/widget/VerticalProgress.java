package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class VerticalProgress extends View {

    /* JADX INFO: renamed from: a */
    private int f8810a;

    /* JADX INFO: renamed from: b */
    private int f8811b;

    /* JADX INFO: renamed from: c */
    private int f8812c;

    /* JADX INFO: renamed from: d */
    private Paint f8813d;

    /* JADX INFO: renamed from: e */
    private Paint f8814e;

    /* JADX INFO: renamed from: f */
    private Paint f8815f;

    /* JADX INFO: renamed from: g */
    private Bitmap f8816g;

    /* JADX INFO: renamed from: h */
    private Context f8817h;

    /* JADX INFO: renamed from: i */
    private int f8818i;

    /* JADX INFO: renamed from: j */
    private float f8819j;

    /* JADX INFO: renamed from: k */
    private int f8820k;

    /* JADX INFO: renamed from: l */
    private InterfaceC1385a f8821l;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.VerticalProgress$a */
    public interface InterfaceC1385a {
        /* JADX INFO: renamed from: a */
        void mo8327a(int i);
    }

    public VerticalProgress(Context context) {
        super(context);
        this.f8810a = 200;
        m8326a(context);
    }

    public VerticalProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8810a = 200;
        m8326a(context);
    }

    public VerticalProgress(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8810a = 200;
        m8326a(context);
    }

    @TargetApi(21)
    public VerticalProgress(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8810a = 200;
        m8326a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m8326a(Context context) {
        this.f8817h = context;
        this.f8820k = C1895ly.m10460a(this.f8817h, 3.0f);
        this.f8816g = BitmapFactory.decodeResource(getResources(), R.drawable.img_indicator_vertial);
        this.f8813d = new Paint();
        this.f8813d.setAntiAlias(true);
        this.f8813d.setColor(Color.parseColor("#f2f2f2"));
        this.f8813d.setStrokeWidth(this.f8820k);
        this.f8813d.setStyle(Paint.Style.STROKE);
        this.f8814e = new Paint();
        this.f8814e.setAntiAlias(true);
        this.f8815f = new Paint();
        this.f8815f.setAntiAlias(true);
        this.f8821l = new InterfaceC1385a() { // from class: com.coollang.tennis.widget.VerticalProgress.1
            @Override // com.coollang.tennis.widget.VerticalProgress.InterfaceC1385a
            /* JADX INFO: renamed from: a */
            public void mo8327a(int i) {
            }
        };
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8811b = View.MeasureSpec.getSize(i);
        this.f8812c = View.MeasureSpec.getSize(i2);
        if (this.f8811b < C1895ly.m10460a(this.f8817h, 40.0f)) {
            this.f8811b = C1895ly.m10460a(this.f8817h, 40.0f);
        }
        setMeasuredDimension(this.f8811b, this.f8812c);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int height = (this.f8816g.getHeight() - (this.f8820k * 4)) / 2;
        if (this.f8819j < this.f8816g.getHeight() / 2) {
            this.f8819j = this.f8816g.getHeight() / 2;
        }
        if (this.f8819j > this.f8812c - (this.f8816g.getHeight() / 2)) {
            this.f8819j = this.f8812c - (this.f8816g.getHeight() / 2);
        }
        this.f8818i = this.f8810a - ((((int) (((this.f8819j - (this.f8816g.getHeight() / 2)) * this.f8810a) / (this.f8812c - this.f8816g.getHeight()))) / 5) * 5);
        canvas.drawRect(this.f8820k / 2, (this.f8820k / 2) + height, this.f8811b - (this.f8820k / 2), (this.f8812c - height) - (this.f8820k / 2), this.f8813d);
        this.f8814e.setShader(new LinearGradient(this.f8820k * 2, (this.f8820k * 2) + (this.f8816g.getHeight() / 2), this.f8811b - (this.f8820k * 2), (this.f8812c - (this.f8820k * 2)) - (this.f8816g.getHeight() / 2), getResources().getColor(R.color.text_menu), getResources().getColor(R.color.text_menu_60), Shader.TileMode.CLAMP));
        canvas.drawRect(this.f8820k * 2, this.f8816g.getHeight() / 2, this.f8811b - (this.f8820k * 2), this.f8812c - (this.f8816g.getHeight() / 2), this.f8814e);
        this.f8815f.setShader(new LinearGradient(this.f8820k * 2, (this.f8820k * 2) + (this.f8816g.getHeight() / 2), this.f8811b - (this.f8820k * 2), (this.f8812c - (this.f8820k * 2)) - (this.f8816g.getHeight() / 2), getResources().getColor(R.color.yellow_re_start_ble), Color.parseColor("#edc474"), Shader.TileMode.CLAMP));
        canvas.drawRect(this.f8820k * 2, this.f8819j, this.f8811b - (this.f8820k * 2), this.f8812c - (this.f8816g.getHeight() / 2), this.f8815f);
        canvas.drawBitmap(this.f8816g, (this.f8811b / 2) - (this.f8816g.getWidth() / 2), this.f8819j - (this.f8816g.getHeight() / 2), (Paint) null);
        this.f8821l.mo8327a(this.f8818i);
    }

    public void setProgress(int i) {
        if (i > this.f8810a) {
            this.f8818i = this.f8810a;
        } else {
            this.f8818i = i;
        }
        this.f8819j = (((this.f8812c - this.f8816g.getHeight()) * (this.f8810a - this.f8818i)) / this.f8810a) + (this.f8816g.getHeight() / 2) + ((this.f8812c - this.f8816g.getHeight()) / 200);
        invalidate();
    }

    public void setOnProgressChangeListener(InterfaceC1385a interfaceC1385a) {
        this.f8821l = interfaceC1385a;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.f8819j = motionEvent.getY();
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
