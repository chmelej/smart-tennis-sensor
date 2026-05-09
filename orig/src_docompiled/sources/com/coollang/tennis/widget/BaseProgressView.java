package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.PointerIconCompat;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;
import p000.C1900mc;

/* JADX INFO: loaded from: classes.dex */
public class BaseProgressView extends View {

    /* JADX INFO: renamed from: a */
    private final int f8000a;

    /* JADX INFO: renamed from: b */
    private Paint f8001b;

    /* JADX INFO: renamed from: c */
    private Paint f8002c;

    /* JADX INFO: renamed from: d */
    private int f8003d;

    /* JADX INFO: renamed from: e */
    private int f8004e;

    /* JADX INFO: renamed from: f */
    private int f8005f;

    /* JADX INFO: renamed from: g */
    private int f8006g;

    /* JADX INFO: renamed from: h */
    private int f8007h;

    /* JADX INFO: renamed from: i */
    private int f8008i;

    /* JADX INFO: renamed from: j */
    private Handler f8009j;

    public BaseProgressView(Context context) {
        super(context);
        this.f8000a = PointerIconCompat.TYPE_WAIT;
        this.f8005f = 0;
        this.f8006g = C1895ly.m10460a(getContext(), 6.0f);
        this.f8007h = 0;
        this.f8009j = new Handler() { // from class: com.coollang.tennis.widget.BaseProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1004) {
                    return;
                }
                BaseProgressView.this.f8005f = BaseProgressView.this.m8024a(BaseProgressView.this.f8005f, BaseProgressView.this.f8008i);
                C1900mc.m10474b(NotificationCompat.CATEGORY_PROGRESS, "== " + BaseProgressView.this.f8005f);
                BaseProgressView.this.invalidate();
                if (BaseProgressView.this.f8005f != BaseProgressView.this.f8008i) {
                    BaseProgressView.this.f8009j.sendEmptyMessageDelayed(PointerIconCompat.TYPE_WAIT, 16L);
                }
            }
        };
        m8028a();
    }

    public BaseProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8000a = PointerIconCompat.TYPE_WAIT;
        this.f8005f = 0;
        this.f8006g = C1895ly.m10460a(getContext(), 6.0f);
        this.f8007h = 0;
        this.f8009j = new Handler() { // from class: com.coollang.tennis.widget.BaseProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1004) {
                    return;
                }
                BaseProgressView.this.f8005f = BaseProgressView.this.m8024a(BaseProgressView.this.f8005f, BaseProgressView.this.f8008i);
                C1900mc.m10474b(NotificationCompat.CATEGORY_PROGRESS, "== " + BaseProgressView.this.f8005f);
                BaseProgressView.this.invalidate();
                if (BaseProgressView.this.f8005f != BaseProgressView.this.f8008i) {
                    BaseProgressView.this.f8009j.sendEmptyMessageDelayed(PointerIconCompat.TYPE_WAIT, 16L);
                }
            }
        };
        m8028a();
    }

    public BaseProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8000a = PointerIconCompat.TYPE_WAIT;
        this.f8005f = 0;
        this.f8006g = C1895ly.m10460a(getContext(), 6.0f);
        this.f8007h = 0;
        this.f8009j = new Handler() { // from class: com.coollang.tennis.widget.BaseProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1004) {
                    return;
                }
                BaseProgressView.this.f8005f = BaseProgressView.this.m8024a(BaseProgressView.this.f8005f, BaseProgressView.this.f8008i);
                C1900mc.m10474b(NotificationCompat.CATEGORY_PROGRESS, "== " + BaseProgressView.this.f8005f);
                BaseProgressView.this.invalidate();
                if (BaseProgressView.this.f8005f != BaseProgressView.this.f8008i) {
                    BaseProgressView.this.f8009j.sendEmptyMessageDelayed(PointerIconCompat.TYPE_WAIT, 16L);
                }
            }
        };
        m8028a();
    }

    @TargetApi(21)
    public BaseProgressView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8000a = PointerIconCompat.TYPE_WAIT;
        this.f8005f = 0;
        this.f8006g = C1895ly.m10460a(getContext(), 6.0f);
        this.f8007h = 0;
        this.f8009j = new Handler() { // from class: com.coollang.tennis.widget.BaseProgressView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what != 1004) {
                    return;
                }
                BaseProgressView.this.f8005f = BaseProgressView.this.m8024a(BaseProgressView.this.f8005f, BaseProgressView.this.f8008i);
                C1900mc.m10474b(NotificationCompat.CATEGORY_PROGRESS, "== " + BaseProgressView.this.f8005f);
                BaseProgressView.this.invalidate();
                if (BaseProgressView.this.f8005f != BaseProgressView.this.f8008i) {
                    BaseProgressView.this.f8009j.sendEmptyMessageDelayed(PointerIconCompat.TYPE_WAIT, 16L);
                }
            }
        };
        m8028a();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8003d = View.MeasureSpec.getSize(i);
        this.f8004e = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8003d, this.f8004e);
    }

    /* JADX INFO: renamed from: a */
    private void m8028a() {
        this.f8001b = new Paint();
        this.f8001b.setColor(getResources().getColor(R.color.text_menu_checked));
        this.f8001b.setAntiAlias(true);
        this.f8002c = new Paint();
        this.f8002c.setColor(Color.parseColor("#eaeaea"));
        this.f8002c.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.f8004e / 2) - (this.f8006g / 2);
        canvas.drawRect(new RectF(0.0f, f, this.f8003d, this.f8006g + f), this.f8002c);
        RectF rectF = new RectF(0.0f, f, (this.f8003d * this.f8005f) / 100.0f, this.f8006g + f);
        new SweepGradient(rectF.centerX(), rectF.centerY(), getStartColor(), getCurColor());
        this.f8001b.setShader(new LinearGradient(0.0f, f, this.f8003d, f, getStartColor(), getCurColor(), Shader.TileMode.CLAMP));
        canvas.drawRect(rectF, this.f8001b);
    }

    public void setFontPercent(int i) {
        this.f8008i = i;
        this.f8009j.sendEmptyMessage(PointerIconCompat.TYPE_WAIT);
    }

    public void setCurColor(int i) {
        this.f8007h = i;
    }

    private int getStartColor() {
        int color = Color.parseColor("#51ff7e");
        switch (this.f8007h) {
            case 1:
                return Color.parseColor("#25c9ad");
            case 2:
                return Color.parseColor("#f78608");
            case 3:
                return Color.parseColor("#44f8c353");
            default:
                return color;
        }
    }

    private int getCurColor() {
        int color = Color.parseColor("#51ff7e");
        switch (this.f8007h) {
            case 1:
                return Color.parseColor("#83f09f");
            case 2:
                return Color.parseColor("#ffc730");
            case 3:
                return Color.parseColor("#f8c353");
            default:
                return color;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public int m8024a(int i, int i2) {
        int i3 = Math.abs(i - i2) <= 3 ? 1 : 3;
        return i > i2 ? i - i3 : i + i3;
    }
}
