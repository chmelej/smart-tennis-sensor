package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class HandView extends View {

    /* JADX INFO: renamed from: a */
    private Paint f8346a;

    /* JADX INFO: renamed from: b */
    private Paint f8347b;

    /* JADX INFO: renamed from: c */
    private Paint f8348c;

    /* JADX INFO: renamed from: d */
    private Paint f8349d;

    /* JADX INFO: renamed from: e */
    private int f8350e;

    /* JADX INFO: renamed from: f */
    private int f8351f;

    /* JADX INFO: renamed from: g */
    private int f8352g;

    /* JADX INFO: renamed from: h */
    private int f8353h;

    /* JADX INFO: renamed from: i */
    private int f8354i;

    /* JADX INFO: renamed from: j */
    private int f8355j;

    /* JADX INFO: renamed from: k */
    private String f8356k;

    /* JADX INFO: renamed from: l */
    private String f8357l;

    public HandView(Context context) {
        super(context);
        this.f8352g = 50;
        this.f8353h = C1895ly.m10460a(getContext(), 18.0f);
        this.f8354i = C1895ly.m10460a(getContext(), 14.0f);
        this.f8355j = C1895ly.m10460a(getContext(), 6.0f);
        this.f8356k = getContext().getString(R.string.Real_new_text11);
        this.f8357l = getContext().getString(R.string.Real_new_text12);
        m8149a();
    }

    public HandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8352g = 50;
        this.f8353h = C1895ly.m10460a(getContext(), 18.0f);
        this.f8354i = C1895ly.m10460a(getContext(), 14.0f);
        this.f8355j = C1895ly.m10460a(getContext(), 6.0f);
        this.f8356k = getContext().getString(R.string.Real_new_text11);
        this.f8357l = getContext().getString(R.string.Real_new_text12);
        m8149a();
    }

    public HandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8352g = 50;
        this.f8353h = C1895ly.m10460a(getContext(), 18.0f);
        this.f8354i = C1895ly.m10460a(getContext(), 14.0f);
        this.f8355j = C1895ly.m10460a(getContext(), 6.0f);
        this.f8356k = getContext().getString(R.string.Real_new_text11);
        this.f8357l = getContext().getString(R.string.Real_new_text12);
        m8149a();
    }

    @TargetApi(21)
    public HandView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8352g = 50;
        this.f8353h = C1895ly.m10460a(getContext(), 18.0f);
        this.f8354i = C1895ly.m10460a(getContext(), 14.0f);
        this.f8355j = C1895ly.m10460a(getContext(), 6.0f);
        this.f8356k = getContext().getString(R.string.Real_new_text11);
        this.f8357l = getContext().getString(R.string.Real_new_text12);
        m8149a();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8350e = View.MeasureSpec.getSize(i);
        this.f8351f = View.MeasureSpec.getSize(i2);
        if (this.f8351f < 200) {
            this.f8351f = 200;
        }
        setMeasuredDimension(this.f8350e, this.f8351f);
    }

    /* JADX INFO: renamed from: a */
    private void m8149a() {
        this.f8346a = new Paint();
        this.f8346a.setColor(getResources().getColor(R.color.text_menu));
        this.f8346a.setTextSize(this.f8353h);
        this.f8346a.setAntiAlias(true);
        this.f8347b = new Paint();
        this.f8347b.setColor(getResources().getColor(R.color.text_menu));
        this.f8347b.setTextSize(this.f8354i);
        this.f8347b.setAntiAlias(true);
        this.f8348c = new Paint();
        this.f8348c.setColor(getResources().getColor(R.color.text_menu_checked));
        this.f8348c.setAntiAlias(true);
        this.f8349d = new Paint();
        this.f8349d.setColor(getResources().getColor(R.color.sport_text_number));
        this.f8349d.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        String str = this.f8352g + "%";
        float fM10460a = ((this.f8351f / 2) - (this.f8355j / 2)) - C1895ly.m10460a(getContext(), 9.0f);
        float fMeasureText = ((this.f8350e * this.f8352g) / 200) - (this.f8346a.measureText(str) / 2.0f);
        if (fMeasureText < 0.0f) {
            fMeasureText = 0.0f;
        }
        String str2 = (100 - this.f8352g) + "%";
        float fMeasureText2 = ((this.f8350e * (this.f8352g + 100)) / 200) - (this.f8346a.measureText(str2) / 2.0f);
        if (this.f8346a.measureText(str2) + fMeasureText2 > this.f8350e) {
            fMeasureText2 = this.f8350e - this.f8346a.measureText(str2);
        }
        canvas.drawText(str, fMeasureText, fM10460a, this.f8346a);
        canvas.drawText(str2, fMeasureText2, fM10460a, this.f8346a);
        float fM10460a2 = (this.f8351f / 2) + (this.f8355j / 2) + C1895ly.m10460a(getContext(), 19.0f) + this.f8354i;
        float fMeasureText3 = ((this.f8350e * this.f8352g) / 200) - (this.f8347b.measureText(this.f8356k) / 2.0f);
        if (fMeasureText3 < 0.0f) {
            fMeasureText3 = 0.0f;
        }
        float fMeasureText4 = ((this.f8350e * (this.f8352g + 100)) / 200) - (this.f8347b.measureText(this.f8357l) / 2.0f);
        if (this.f8347b.measureText(this.f8357l) + fMeasureText4 > this.f8350e) {
            fMeasureText4 = this.f8350e - this.f8347b.measureText(this.f8357l);
        }
        canvas.drawText(this.f8356k, fMeasureText3, fM10460a2, this.f8347b);
        canvas.drawText(this.f8357l, fMeasureText4, fM10460a2, this.f8347b);
        float f = (this.f8351f / 2) - (this.f8355j / 2);
        canvas.drawRect(new RectF(0.0f, f, this.f8350e, this.f8355j + f), this.f8349d);
        canvas.drawRect(new RectF(0.0f, f, (this.f8350e * this.f8352g) / 100, this.f8355j + f), this.f8348c);
    }

    public void setFontPercent(int i) {
        this.f8352g = i;
        invalidate();
    }
}
