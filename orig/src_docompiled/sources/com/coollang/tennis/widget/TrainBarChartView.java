package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class TrainBarChartView extends View {

    /* JADX INFO: renamed from: a */
    private final int f8803a;

    /* JADX INFO: renamed from: b */
    private int f8804b;

    /* JADX INFO: renamed from: c */
    private int f8805c;

    /* JADX INFO: renamed from: d */
    private String[] f8806d;

    /* JADX INFO: renamed from: e */
    private int[] f8807e;

    /* JADX INFO: renamed from: f */
    private Paint f8808f;

    /* JADX INFO: renamed from: g */
    private Paint f8809g;

    public TrainBarChartView(Context context) {
        super(context);
        this.f8803a = 10;
        this.f8806d = new String[]{"<100", "100-110", "110-120", "120-130", "130-140", "≥140"};
        this.f8807e = new int[]{20, 10, 18, 30, 8, 27};
        m8325a(context);
    }

    public TrainBarChartView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8803a = 10;
        this.f8806d = new String[]{"<100", "100-110", "110-120", "120-130", "130-140", "≥140"};
        this.f8807e = new int[]{20, 10, 18, 30, 8, 27};
        m8325a(context);
    }

    public TrainBarChartView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8803a = 10;
        this.f8806d = new String[]{"<100", "100-110", "110-120", "120-130", "130-140", "≥140"};
        this.f8807e = new int[]{20, 10, 18, 30, 8, 27};
        m8325a(context);
    }

    @TargetApi(21)
    public TrainBarChartView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8803a = 10;
        this.f8806d = new String[]{"<100", "100-110", "110-120", "120-130", "130-140", "≥140"};
        this.f8807e = new int[]{20, 10, 18, 30, 8, 27};
        m8325a(context);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8804b = View.MeasureSpec.getSize(i);
        this.f8805c = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8804b, this.f8805c);
    }

    /* JADX INFO: renamed from: a */
    private void m8325a(Context context) {
        this.f8808f = new Paint();
        this.f8808f.setAntiAlias(true);
        this.f8808f.setTextSize(C1895ly.m10460a(context, 10.0f));
        this.f8809g = new Paint();
        this.f8809g.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int i2 = this.f8805c - 10;
        int maxValue = getMaxValue();
        float length = (this.f8804b - 20) / this.f8806d.length;
        float f = 10.0f;
        int iM10460a = C1895ly.m10460a(getContext(), 10.0f);
        int iM10460a2 = C1895ly.m10460a(getContext(), 30.0f);
        float f2 = iM10460a2;
        if (f2 >= length) {
            iM10460a2 = ((int) length) - 10;
            i = 5;
        } else {
            i = ((int) (length - f2)) / 2;
        }
        int textSize = ((i2 - (((int) this.f8808f.getTextSize()) * 2)) - iM10460a) - 10;
        int i3 = 0;
        while (i3 < this.f8807e.length) {
            this.f8808f.setColor(-7829368);
            String str = this.f8806d[i3];
            int i4 = i3 + 1;
            float fMeasureText = (((length / 2.0f) * ((i4 * 2) - 1)) + f) - (this.f8808f.measureText(this.f8806d[i3]) / 2.0f);
            float f3 = i2;
            canvas.drawText(str, fMeasureText, f3, this.f8808f);
            float f4 = i + (i3 * length) + 10.0f;
            float f5 = (textSize - ((this.f8807e[i3] * textSize) / maxValue)) + iM10460a;
            float f6 = iM10460a2 + f4;
            int i5 = i2;
            this.f8809g.setShader(new LinearGradient(f4, f5 + this.f8808f.getTextSize(), f6, (f3 - this.f8808f.getTextSize()) - 10.0f, Color.parseColor("#83f09f"), Color.parseColor("#25c9ad"), Shader.TileMode.CLAMP));
            int i6 = maxValue;
            canvas.drawRoundRect(new RectF(f4, this.f8808f.getTextSize() + f5, f6, (f3 - this.f8808f.getTextSize()) - 10.0f), C1895ly.m10460a(getContext(), 2.0f), C1895ly.m10460a(getContext(), 2.0f), this.f8809g);
            if (this.f8807e[i3] != 0) {
                this.f8808f.setColor(getResources().getColor(R.color.text_menu_checked));
                canvas.drawText(String.valueOf(this.f8807e[i3]), (f4 + (iM10460a2 / 2)) - (this.f8808f.measureText(String.valueOf(this.f8807e[i3])) / 2.0f), (f5 + this.f8808f.getTextSize()) - 5.0f, this.f8808f);
            }
            i3 = i4;
            i2 = i5;
            maxValue = i6;
            f = 10.0f;
        }
    }

    private int getMaxValue() {
        int i = 0;
        for (int i2 = 0; i2 < this.f8807e.length; i2++) {
            if (i < this.f8807e[i2]) {
                i = this.f8807e[i2];
            }
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }

    public void setData(int[] iArr) {
        this.f8807e = iArr;
        invalidate();
    }
}
