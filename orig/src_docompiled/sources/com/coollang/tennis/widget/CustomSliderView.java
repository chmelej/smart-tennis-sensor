package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
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
import com.coollang.tennis.base.MyApplication;
import p000.C1914mm;

/* JADX INFO: loaded from: classes.dex */
public class CustomSliderView extends View {

    /* JADX INFO: renamed from: a */
    public int f8297a;

    /* JADX INFO: renamed from: b */
    private Paint f8298b;

    /* JADX INFO: renamed from: c */
    private Paint f8299c;

    /* JADX INFO: renamed from: d */
    private Paint f8300d;

    /* JADX INFO: renamed from: e */
    private int f8301e;

    /* JADX INFO: renamed from: f */
    private int f8302f;

    /* JADX INFO: renamed from: g */
    private int f8303g;

    /* JADX INFO: renamed from: h */
    private int f8304h;

    /* JADX INFO: renamed from: i */
    private int f8305i;

    /* JADX INFO: renamed from: j */
    private Context f8306j;

    /* JADX INFO: renamed from: k */
    private Bitmap f8307k;

    /* JADX INFO: renamed from: l */
    private InterfaceC1332a f8308l;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.CustomSliderView$a */
    public interface InterfaceC1332a {
        /* JADX INFO: renamed from: a */
        void m8142a();
    }

    public void setSliderListener(InterfaceC1332a interfaceC1332a) {
        this.f8308l = interfaceC1332a;
    }

    public CustomSliderView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8297a = 0;
        this.f8306j = context;
        m8141a();
    }

    public CustomSliderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8297a = 0;
        this.f8306j = context;
        m8141a();
    }

    public CustomSliderView(Context context) {
        super(context);
        this.f8297a = 0;
        this.f8306j = context;
        m8141a();
    }

    /* JADX INFO: renamed from: a */
    private void m8141a() {
        this.f8298b = new Paint();
        this.f8298b.setAntiAlias(true);
        this.f8298b.setStyle(Paint.Style.FILL);
        this.f8298b.setColor(C1914mm.m10559d(R.color.text_menu_checked));
        this.f8299c = new Paint();
        this.f8299c.setAntiAlias(true);
        this.f8299c.setStyle(Paint.Style.FILL);
        this.f8299c.setColor(Color.parseColor("#25c9ae"));
        this.f8300d = new Paint();
        this.f8300d.setColor(Color.parseColor("#ffffff"));
        this.f8300d.setStyle(Paint.Style.FILL);
        this.f8300d.setTextSize(50.0f);
        this.f8303g = 50;
        this.f8307k = BitmapFactory.decodeResource(this.f8306j.getResources(), R.drawable.ic_slider_arrow);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8301e = View.MeasureSpec.getSize(i);
        this.f8302f = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8301e, this.f8302f);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case 0:
                getParent().requestDisallowInterceptTouchEvent(true);
                this.f8304h = (int) motionEvent.getX();
                return true;
            case 1:
                this.f8305i = (int) motionEvent.getX();
                this.f8297a = this.f8305i - this.f8304h;
                if (this.f8308l != null) {
                    this.f8308l.m8142a();
                }
                this.f8297a = 0;
                invalidate();
                return true;
            case 2:
                this.f8305i = (int) motionEvent.getX();
                this.f8297a = this.f8305i - this.f8304h;
                invalidate();
                return true;
            default:
                return true;
        }
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        int textSize;
        super.onDraw(canvas);
        this.f8299c.setShader(new LinearGradient(this.f8297a, 0.0f, this.f8301e, 0.0f, Color.parseColor("#25c9ae"), Color.parseColor("#9de7da"), Shader.TileMode.CLAMP));
        canvas.drawRect(0.0f, 0.0f, this.f8301e, this.f8302f, this.f8298b);
        canvas.drawRect(this.f8297a, 0.0f, this.f8301e, this.f8302f, this.f8299c);
        canvas.drawText(C1914mm.m10557b(R.string.slider_start_train), this.f8297a + this.f8303g, ((this.f8302f / 2) + (this.f8300d.getTextSize() / 2.0f)) - 7.0f, this.f8300d);
        if (MyApplication.m7738a().m7747g()) {
            textSize = (int) (this.f8297a + this.f8303g + (this.f8300d.getTextSize() * 6.0f) + (this.f8307k.getWidth() / 2));
        } else {
            textSize = (int) (this.f8297a + this.f8303g + (this.f8300d.getTextSize() * 10.0f) + (this.f8307k.getWidth() / 2));
        }
        canvas.drawBitmap(this.f8307k, textSize, (this.f8302f / 2) - (this.f8307k.getHeight() / 2), (Paint) null);
    }
}
