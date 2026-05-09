package com.coollang.tennis.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.WeekDataBean;
import java.util.ArrayList;
import java.util.List;
import p000.C1895ly;
import p000.C1900mc;

/* JADX INFO: loaded from: classes.dex */
public class MyBarView extends View {

    /* JADX INFO: renamed from: a */
    private Context f8421a;

    /* JADX INFO: renamed from: b */
    private List<WeekDataBean> f8422b;

    /* JADX INFO: renamed from: c */
    private Paint f8423c;

    /* JADX INFO: renamed from: d */
    private Paint f8424d;

    /* JADX INFO: renamed from: e */
    private Paint f8425e;

    /* JADX INFO: renamed from: f */
    private Paint f8426f;

    /* JADX INFO: renamed from: g */
    private Paint f8427g;

    /* JADX INFO: renamed from: h */
    private Shader f8428h;

    /* JADX INFO: renamed from: i */
    private Shader f8429i;

    /* JADX INFO: renamed from: j */
    private int[] f8430j;

    /* JADX INFO: renamed from: k */
    private int[] f8431k;

    /* JADX INFO: renamed from: l */
    private int f8432l;

    /* JADX INFO: renamed from: m */
    private float f8433m;

    /* JADX INFO: renamed from: n */
    private int f8434n;

    /* JADX INFO: renamed from: o */
    private int f8435o;

    /* JADX INFO: renamed from: p */
    private float f8436p;

    /* JADX INFO: renamed from: q */
    private float f8437q;

    /* JADX INFO: renamed from: r */
    private float f8438r;

    /* JADX INFO: renamed from: s */
    private float f8439s;

    /* JADX INFO: renamed from: t */
    private float f8440t;

    /* JADX INFO: renamed from: u */
    private float f8441u;

    /* JADX INFO: renamed from: v */
    private Rect f8442v;

    /* JADX INFO: renamed from: w */
    private Rect f8443w;

    public float getBarSpace() {
        return this.f8433m;
    }

    public MyBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8422b = new ArrayList();
        this.f8423c = new Paint(1);
        this.f8424d = new Paint(1);
        this.f8425e = new Paint(1);
        this.f8426f = new Paint(1);
        this.f8427g = new Paint();
        this.f8430j = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8431k = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8432l = 5;
        this.f8433m = 10.0f;
        this.f8434n = 0;
        this.f8441u = 30.0f;
        this.f8421a = context;
        m8170a(context, attributeSet);
    }

    public MyBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8422b = new ArrayList();
        this.f8423c = new Paint(1);
        this.f8424d = new Paint(1);
        this.f8425e = new Paint(1);
        this.f8426f = new Paint(1);
        this.f8427g = new Paint();
        this.f8430j = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8431k = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8432l = 5;
        this.f8433m = 10.0f;
        this.f8434n = 0;
        this.f8441u = 30.0f;
        this.f8421a = context;
        m8170a(context, attributeSet);
    }

    public MyBarView(Context context) {
        super(context);
        this.f8422b = new ArrayList();
        this.f8423c = new Paint(1);
        this.f8424d = new Paint(1);
        this.f8425e = new Paint(1);
        this.f8426f = new Paint(1);
        this.f8427g = new Paint();
        this.f8430j = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8431k = new int[]{Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad"), Color.parseColor("#25c9ad")};
        this.f8432l = 5;
        this.f8433m = 10.0f;
        this.f8434n = 0;
        this.f8441u = 30.0f;
        this.f8421a = context;
        m8170a(context, null);
    }

    /* JADX INFO: renamed from: a */
    private void m8170a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.BarChart, 0, 0);
        this.f8433m = typedArrayObtainStyledAttributes.getDimension(1, 12.0f);
        this.f8438r = typedArrayObtainStyledAttributes.getDimension(2, 30.0f);
        this.f8441u = typedArrayObtainStyledAttributes.getDimension(3, 30.0f);
        this.f8435o = context.getResources().getDisplayMetrics().widthPixels;
        this.f8424d.setColor(Color.parseColor("#19FFFFFF"));
        this.f8427g.setColor(Color.parseColor("#ff6900"));
        this.f8426f.setColor(Color.parseColor("#ff6900"));
        this.f8426f.setTextSize(this.f8441u);
        this.f8427g.setTextSize(this.f8441u);
    }

    public void setData(List<WeekDataBean> list, int i) {
        this.f8422b = list;
        this.f8432l = i;
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8439s = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(((int) ((this.f8435o / this.f8432l) + this.f8433m)) * 3000, (int) this.f8439s);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8440t = m8169a(this.f8422b);
        this.f8436p = (this.f8435o - ((this.f8432l - 1) * this.f8433m)) / this.f8432l;
        this.f8437q = this.f8439s - this.f8438r;
        this.f8429i = new LinearGradient(this.f8435o / 10, 0.0f, this.f8435o / 10, this.f8437q, this.f8430j, (float[]) null, Shader.TileMode.CLAMP);
        this.f8423c.setShader(this.f8429i);
        this.f8428h = new LinearGradient(this.f8435o / 10, 0.0f, this.f8435o / 10, this.f8437q, this.f8431k, (float[]) null, Shader.TileMode.CLAMP);
        this.f8425e.setShader(this.f8428h);
        for (int i = 0; i < (this.f8432l - 1) / 2; i++) {
            float f = i;
            canvas.drawRect((this.f8436p + this.f8433m) * f, 0.0f, this.f8436p + ((this.f8436p + this.f8433m) * f), this.f8437q, this.f8424d);
        }
        for (int i2 = 0; i2 < this.f8422b.size(); i2++) {
            C1900mc.m10476d("MyBarView", this.f8422b.get(i2).weekSportTime + "=====================" + this.f8440t);
            float f2 = (float) (((double) (((float) this.f8422b.get(i2).weekSportTime) / this.f8440t)) * 0.8d);
            String str = this.f8422b.get(i2).duration;
            if (!MyApplication.m7738a().m7747g()) {
                String strReplace = str.replace("第", "").replace("周", "");
                str = !MyApplication.m7738a().m7748h() ? "week" + strReplace : "Semaine" + strReplace;
            }
            String str2 = String.format("%.02fh", Float.valueOf(this.f8422b.get(i2).weekSportTime / 60.0f));
            this.f8443w = new Rect();
            canvas.drawRect((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2), 0.0f, this.f8436p + ((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2)), this.f8437q, this.f8424d);
            this.f8426f.getTextBounds(str, 0, str2.length(), this.f8443w);
            canvas.drawText(str, ((((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2)) + (this.f8436p / 2.0f)) - (this.f8443w.width() / 2)) - C1895ly.m10460a(this.f8421a, 10.0f), this.f8437q + (this.f8438r / 2.0f) + (this.f8443w.height() / 2), this.f8426f);
            if (i2 == this.f8434n) {
                this.f8442v = new Rect();
                this.f8427g.getTextBounds(str2, 0, str2.length(), this.f8442v);
                float f3 = 1.0f - f2;
                canvas.drawText(str2, (((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2)) + (this.f8436p / 2.0f)) - (this.f8442v.width() / 2), ((this.f8437q * f3) - this.f8433m) - this.f8442v.height(), this.f8426f);
                canvas.drawRect((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2), f3 * this.f8437q, this.f8436p + ((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2)), this.f8437q, this.f8425e);
            } else {
                canvas.drawRect((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2), (1.0f - f2) * this.f8437q, this.f8436p + ((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + i2)), this.f8437q, this.f8423c);
            }
        }
        for (int i3 = 0; i3 < (this.f8432l - 1) / 2; i3++) {
            canvas.drawRect((this.f8436p + this.f8433m) * (((this.f8432l - 1) / 2) + this.f8422b.size() + i3), 0.0f, this.f8436p + ((this.f8436p + this.f8433m) * (this.f8422b.size() + ((this.f8432l - 1) / 2) + i3)), this.f8437q, this.f8424d);
        }
    }

    /* JADX INFO: renamed from: a */
    private float m8169a(List<WeekDataBean> list) {
        if (list == null || list.size() == 0) {
            return 60.0f;
        }
        float f = 0.0f;
        if (this.f8422b.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                if (this.f8422b.get(i).weekSportTime >= f) {
                    f = this.f8422b.get(i).weekSportTime;
                }
            }
        }
        return f;
    }

    public void setMiddleBar(int i) {
        this.f8434n = i;
        invalidate();
    }
}
