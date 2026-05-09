package com.coollang.tennis.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.beans.WeekDataBean;
import java.util.ArrayList;
import java.util.List;
import p000.C1895ly;
import p000.C1912mk;

/* JADX INFO: loaded from: classes.dex */
public class CheckBarView extends View {

    /* JADX INFO: renamed from: a */
    List<WeekDataBean> f8011a;

    /* JADX INFO: renamed from: b */
    Context f8012b;

    /* JADX INFO: renamed from: c */
    private int f8013c;

    /* JADX INFO: renamed from: d */
    private Paint f8014d;

    /* JADX INFO: renamed from: e */
    private Paint f8015e;

    /* JADX INFO: renamed from: f */
    private Paint f8016f;

    /* JADX INFO: renamed from: g */
    private Paint f8017g;

    /* JADX INFO: renamed from: h */
    private Paint f8018h;

    /* JADX INFO: renamed from: i */
    private int f8019i;

    /* JADX INFO: renamed from: j */
    private int f8020j;

    /* JADX INFO: renamed from: k */
    private Shader f8021k;

    /* JADX INFO: renamed from: l */
    private int[] f8022l;

    /* JADX INFO: renamed from: m */
    private Shader f8023m;

    /* JADX INFO: renamed from: n */
    private int[] f8024n;

    public CheckBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8020j = 0;
        this.f8022l = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8024n = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8012b = context;
        m8033a();
    }

    public CheckBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8020j = 0;
        this.f8022l = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8024n = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8012b = context;
        m8033a();
    }

    public CheckBarView(Context context) {
        super(context);
        this.f8020j = 0;
        this.f8022l = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8024n = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8012b = context;
        m8033a();
    }

    /* JADX INFO: renamed from: a */
    private void m8033a() {
        this.f8014d = m8032a(Color.parseColor("#0ab5df"));
        this.f8015e = m8032a(Color.parseColor("#19FFFFFF"));
        this.f8016f = m8032a(Color.parseColor("#ff6900"));
        this.f8018h = m8032a(Color.parseColor("#ff6900"));
        this.f8017g = m8032a(Color.parseColor("#7c7b80"));
        this.f8013c = this.f8012b.getResources().getDisplayMetrics().widthPixels;
        this.f8011a = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    private Paint m8032a(int i) {
        Paint paint = new Paint(1);
        paint.setColor(i);
        return paint;
    }

    public void setData(List<WeekDataBean> list) {
        this.f8011a = list;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8019i = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(((int) ((this.f8013c / 5) + 10.0f)) * 3000, this.f8019i);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    @SuppressLint({"DrawAllocation"})
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        this.f8014d.setStyle(Paint.Style.FILL);
        if (this.f8011a.size() > 0) {
            float fM8031a = m8031a(this.f8011a);
            this.f8017g.setTextSize(C1895ly.m10462c(this.f8012b, 11.0f));
            if (fM8031a != 0.0f) {
                for (int i = -1; i >= -2; i--) {
                    canvas.drawRect((this.f8013c / 2) + ((this.f8013c * i) / 5) + 12.0f, 0.0f, (((i + 1) * this.f8013c) / 5) + (this.f8013c / 2), this.f8019i - C1895ly.m10460a(getContext(), 22.0f), this.f8015e);
                }
                int i2 = 0;
                while (true) {
                    if (i2 >= this.f8011a.size()) {
                        break;
                    }
                    float f3 = Float.parseFloat(C1912mk.m10536a(this.f8011a.get(i2).weekSportTime * 60, true));
                    canvas.drawText(this.f8011a.get(i2).duration, ((this.f8013c * i2) / 5) + C1895ly.m10460a(getContext(), 18.0f) + (this.f8013c / 2), this.f8019i - 20, this.f8017g);
                    int i3 = i2 + 1;
                    canvas.drawRect((this.f8013c / 2) + ((this.f8013c * i2) / 5) + 12.0f, 0.0f, ((this.f8013c * i3) / 5) + (this.f8013c / 2), this.f8019i - C1895ly.m10460a(getContext(), 22.0f), this.f8015e);
                    f2 = f3 != fM8031a ? (f3 * 0.8f) / fM8031a : 0.8f;
                    if (f2 >= 0.1f) {
                        f = f2;
                    }
                    this.f8021k = new LinearGradient(this.f8013c / 10, 0.0f, this.f8013c / 10, this.f8019i, this.f8022l, (float[]) null, Shader.TileMode.CLAMP);
                    this.f8014d.setShader(this.f8021k);
                    canvas.drawRect((this.f8013c / 2) + ((i2 * this.f8013c) / 5) + 12.0f, this.f8019i - (f * this.f8019i), ((this.f8013c * i3) / 5) + (this.f8013c / 2), this.f8019i - C1895ly.m10460a(getContext(), 22.0f), this.f8014d);
                    i2 = i3;
                }
                for (int size = this.f8011a.size(); size <= this.f8011a.size() + 1; size++) {
                    canvas.drawRect(((this.f8013c * size) / 5) + 12.0f + (this.f8013c / 2), 0.0f, ((this.f8013c * r9) / 5) + (this.f8013c / 2), this.f8019i - C1895ly.m10460a(getContext(), 22.0f), this.f8015e);
                }
                this.f8018h.setTextSize(C1895ly.m10462c(this.f8012b, 20.0f));
                float f4 = Float.parseFloat(C1912mk.m10536a(this.f8011a.get(this.f8020j).weekSportTime * 60, true));
                f2 = f4 != fM8031a ? (0.8f * f4) / fM8031a : 0.8f;
                f = f2 >= 0.1f ? f2 : 0.1f;
                String str = f4 + "h";
                this.f8023m = new LinearGradient(this.f8013c / 10, 0.0f, this.f8013c / 10, this.f8019i, this.f8024n, (float[]) null, Shader.TileMode.CLAMP);
                this.f8016f.setShader(this.f8023m);
                int iM10462c = C1895ly.m10462c(this.f8012b, 23.0f);
                if (str.length() >= 3) {
                    iM10462c = C1895ly.m10462c(this.f8012b, 17.0f);
                }
                canvas.drawRect((this.f8013c / 2) + ((this.f8020j * this.f8013c) / 5) + 12.0f, this.f8019i - (this.f8019i * f), (((this.f8020j + 1) * this.f8013c) / 5) + (this.f8013c / 2), this.f8019i - C1895ly.m10460a(getContext(), 22.0f), this.f8016f);
                canvas.drawText(str, ((this.f8020j * this.f8013c) / 5) + iM10462c + (this.f8013c / 2), (this.f8019i - (f * this.f8019i)) - C1895ly.m10460a(this.f8012b, 10.0f), this.f8018h);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private float m8031a(List<WeekDataBean> list) {
        float f = 0.0f;
        if (this.f8011a.size() != 0) {
            for (int i = 0; i < this.f8011a.size(); i++) {
                if (this.f8011a.get(i).weekSportTime >= f) {
                    f = this.f8011a.get(i).weekSportTime;
                }
            }
        }
        return f / 60.0f;
    }

    public void setMiddleBar(int i) {
        this.f8020j = i;
        invalidate();
    }
}
