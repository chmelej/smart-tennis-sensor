package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import java.util.ArrayList;
import java.util.List;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class ScatterChartView extends View {

    /* JADX INFO: renamed from: a */
    private final int f8632a;

    /* JADX INFO: renamed from: b */
    private final int f8633b;

    /* JADX INFO: renamed from: c */
    private final int f8634c;

    /* JADX INFO: renamed from: d */
    private int f8635d;

    /* JADX INFO: renamed from: e */
    private int f8636e;

    /* JADX INFO: renamed from: f */
    private final int f8637f;

    /* JADX INFO: renamed from: g */
    private final int f8638g;

    /* JADX INFO: renamed from: h */
    private int f8639h;

    /* JADX INFO: renamed from: i */
    private int f8640i;

    /* JADX INFO: renamed from: j */
    private int f8641j;

    /* JADX INFO: renamed from: k */
    private Paint f8642k;

    /* JADX INFO: renamed from: l */
    private Paint f8643l;

    /* JADX INFO: renamed from: m */
    private Paint f8644m;

    /* JADX INFO: renamed from: n */
    private Paint f8645n;

    /* JADX INFO: renamed from: o */
    private Paint f8646o;

    /* JADX INFO: renamed from: p */
    private Context f8647p;

    /* JADX INFO: renamed from: q */
    private List<Integer> f8648q;

    /* JADX INFO: renamed from: r */
    private float f8649r;

    /* JADX INFO: renamed from: s */
    private float f8650s;

    /* JADX INFO: renamed from: t */
    private List<Integer> f8651t;

    /* JADX INFO: renamed from: u */
    private int f8652u;

    /* JADX INFO: renamed from: v */
    private boolean f8653v;

    /* JADX INFO: renamed from: w */
    private boolean f8654w;

    /* JADX INFO: renamed from: x */
    private int f8655x;

    /* JADX INFO: renamed from: y */
    private String f8656y;

    public ScatterChartView(Context context) {
        super(context);
        this.f8632a = 10;
        this.f8633b = 7;
        this.f8634c = 5;
        this.f8635d = 10;
        this.f8636e = 200;
        this.f8637f = 10;
        this.f8638g = 20;
        this.f8641j = 10;
        this.f8652u = 70;
        this.f8653v = false;
        this.f8654w = false;
        this.f8655x = -1;
        this.f8656y = getContext().getString(R.string.target_speed_scatter);
        m8248a(context);
    }

    public ScatterChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8632a = 10;
        this.f8633b = 7;
        this.f8634c = 5;
        this.f8635d = 10;
        this.f8636e = 200;
        this.f8637f = 10;
        this.f8638g = 20;
        this.f8641j = 10;
        this.f8652u = 70;
        this.f8653v = false;
        this.f8654w = false;
        this.f8655x = -1;
        this.f8656y = getContext().getString(R.string.target_speed_scatter);
        m8248a(context);
    }

    public ScatterChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8632a = 10;
        this.f8633b = 7;
        this.f8634c = 5;
        this.f8635d = 10;
        this.f8636e = 200;
        this.f8637f = 10;
        this.f8638g = 20;
        this.f8641j = 10;
        this.f8652u = 70;
        this.f8653v = false;
        this.f8654w = false;
        this.f8655x = -1;
        this.f8656y = getContext().getString(R.string.target_speed_scatter);
        m8248a(context);
    }

    @TargetApi(21)
    public ScatterChartView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8632a = 10;
        this.f8633b = 7;
        this.f8634c = 5;
        this.f8635d = 10;
        this.f8636e = 200;
        this.f8637f = 10;
        this.f8638g = 20;
        this.f8641j = 10;
        this.f8652u = 70;
        this.f8653v = false;
        this.f8654w = false;
        this.f8655x = -1;
        this.f8656y = getContext().getString(R.string.target_speed_scatter);
        m8248a(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8639h = View.MeasureSpec.getSize(i);
        this.f8640i = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8639h, this.f8640i);
    }

    /* JADX INFO: renamed from: a */
    private void m8248a(Context context) {
        this.f8647p = context;
        this.f8642k = new Paint();
        this.f8642k.setAntiAlias(true);
        this.f8642k.setStrokeWidth(1.0f);
        this.f8642k.setColor(-7829368);
        this.f8644m = new Paint();
        this.f8644m.setStyle(Paint.Style.STROKE);
        this.f8644m.setColor(SupportMenu.CATEGORY_MASK);
        this.f8643l = new Paint();
        this.f8643l.setAntiAlias(true);
        this.f8643l.setColor(-7829368);
        this.f8643l.setTextSize(C1895ly.m10460a(this.f8647p, 10.0f));
        this.f8645n = new Paint();
        this.f8645n.setAntiAlias(true);
        this.f8646o = new Paint();
        this.f8646o.setAntiAlias(true);
        this.f8646o.setTextSize(C1895ly.m10460a(this.f8647p, 10.0f));
        this.f8646o.setColor(this.f8647p.getResources().getColor(R.color.yellow_re_start_ble));
        this.f8648q = new ArrayList();
        int i = this.f8636e / this.f8635d;
        for (int i2 = 0; i2 <= this.f8635d; i2++) {
            this.f8648q.add(Integer.valueOf(i2 * i));
        }
        this.f8651t = new ArrayList();
        this.f8650s = Math.max(this.f8643l.measureText(this.f8656y), this.f8643l.measureText("200km/h"));
        this.f8649r = C1895ly.m10460a(this.f8647p, 10.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        super.onDraw(canvas);
        float f2 = 10.0f;
        float fMeasureText = this.f8643l.measureText(String.valueOf(this.f8636e)) + 10.0f + 5.0f;
        float f3 = this.f8649r + 7.0f;
        float f4 = this.f8640i - this.f8649r;
        float f5 = (this.f8639h - 20) - this.f8650s;
        int i = ((((float) this.f8640i) - this.f8649r) - f3) / 10.0f < this.f8649r ? 2 : 1;
        float size = ((this.f8640i - this.f8649r) - f3) / (this.f8648q.size() - 1);
        int size2 = this.f8648q.size() - 1;
        while (size2 >= 0) {
            canvas.drawText(String.valueOf(this.f8648q.get(size2)), (this.f8643l.measureText(String.valueOf(this.f8636e)) + f2) - this.f8643l.measureText(String.valueOf(this.f8648q.get(size2))), ((this.f8649r * 3.0f) / 2.0f) + (((this.f8648q.size() - 1) - size2) * size) + 2.0f, this.f8643l);
            size2 -= i;
            f2 = 10.0f;
        }
        canvas.drawLine(fMeasureText, f3, fMeasureText, f4, this.f8642k);
        canvas.drawLine(fMeasureText, f4, f5, f4, this.f8642k);
        float f6 = f4 - f3;
        float f7 = f4 - ((this.f8652u * f6) / this.f8636e);
        Path path = new Path();
        path.moveTo(fMeasureText, f7);
        path.lineTo(f5, f7);
        this.f8644m.setPathEffect(new DashPathEffect(new float[]{5.0f, 5.0f, 5.0f, 5.0f}, 1.0f));
        canvas.drawPath(path, this.f8644m);
        int i2 = 0;
        String str = String.format("%skm/h", String.valueOf(this.f8652u));
        float f8 = f5 + 4.0f;
        canvas.drawText(this.f8656y, f8, f7 - 4.0f, this.f8643l);
        canvas.drawText(str, f8, (f7 + this.f8649r) - 4.0f, this.f8643l);
        if (this.f8651t.size() > 0) {
            float size3 = ((f5 - fMeasureText) - this.f8641j) / (this.f8651t.size() + 1);
            this.f8654w = false;
            while (i2 < this.f8651t.size()) {
                float fIntValue = this.f8651t.get(i2).intValue() > this.f8636e ? f3 : f4 - ((this.f8651t.get(i2).intValue() * f6) / this.f8636e);
                if (this.f8651t.get(i2).intValue() < this.f8652u) {
                    this.f8645n.setColor(Color.parseColor("#c4c4c4"));
                } else {
                    this.f8645n.setColor(getResources().getColor(R.color.text_menu_checked));
                }
                int i3 = i2 + 1;
                float f9 = i3 * size3;
                canvas.drawCircle(f9 + fMeasureText, fIntValue, this.f8641j, this.f8645n);
                if (this.f8653v && this.f8651t.get(i2).intValue() == this.f8655x && !this.f8654w) {
                    String strValueOf = String.valueOf(this.f8651t.get(i2));
                    float fMeasureText2 = (f9 - (this.f8646o.measureText(strValueOf) / 2.0f)) + fMeasureText;
                    if (fMeasureText2 < fMeasureText) {
                        f = 5.0f;
                        fMeasureText2 = fMeasureText + 5.0f;
                    } else {
                        f = 5.0f;
                    }
                    if (fMeasureText2 > f5) {
                        fMeasureText2 = f5 - f;
                    }
                    canvas.drawText(strValueOf, fMeasureText2, (fIntValue - this.f8641j) - f, this.f8646o);
                    this.f8654w = true;
                }
                i2 = i3;
            }
        }
    }

    public void setLimitData(int i) {
        this.f8652u = i;
        invalidate();
    }

    public void setSpeedList(List<Integer> list) {
        this.f8651t = list;
        if (this.f8653v) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).intValue() > this.f8655x) {
                    this.f8655x = list.get(i).intValue();
                }
            }
        }
        m8249b();
        invalidate();
    }

    /* JADX INFO: renamed from: a */
    public void m8251a(int i) {
        if (this.f8651t == null) {
            this.f8651t = new ArrayList();
        }
        this.f8651t.add(Integer.valueOf(i));
        if (this.f8653v && this.f8655x < i) {
            this.f8655x = i;
        }
        m8249b();
        invalidate();
    }

    /* JADX INFO: renamed from: b */
    private void m8249b() {
        if (this.f8651t.size() < 40) {
            this.f8641j = 7;
        } else {
            this.f8641j = 5;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8250a() {
        if (this.f8651t != null) {
            this.f8651t.clear();
        }
        invalidate();
    }

    public void setLeftMax(int i, int i2) {
        this.f8636e = i;
        this.f8648q.clear();
        int i3 = this.f8636e / i2;
        for (int i4 = 0; i4 <= i3; i4++) {
            this.f8648q.add(Integer.valueOf(i4 * i2));
        }
    }

    public void setShowMaxDataValue(boolean z) {
        this.f8653v = z;
        invalidate();
    }

    public void setLimitDescribt(String str) {
        this.f8656y = str;
    }
}
