package com.coollang.tennis.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import p000.C1895ly;
import p000.C1914mm;

/* JADX INFO: loaded from: classes.dex */
public class SportChart2 extends View {

    /* JADX INFO: renamed from: a */
    private Paint f8692a;

    /* JADX INFO: renamed from: b */
    private Paint f8693b;

    /* JADX INFO: renamed from: c */
    private int f8694c;

    /* JADX INFO: renamed from: d */
    private int f8695d;

    /* JADX INFO: renamed from: e */
    private float f8696e;

    /* JADX INFO: renamed from: f */
    private TreeSet<C1370a> f8697f;

    /* JADX INFO: renamed from: g */
    private int f8698g;

    /* JADX INFO: renamed from: h */
    private int[] f8699h;

    /* JADX INFO: renamed from: i */
    private String[] f8700i;

    /* JADX INFO: renamed from: j */
    private Bitmap[] f8701j;

    public SportChart2(Context context) {
        super(context);
        this.f8696e = 0.0f;
        this.f8698g = 0;
        this.f8699h = new int[]{Color.parseColor("#7abeea"), Color.parseColor("#72deae"), Color.parseColor("#f8c353"), Color.parseColor("#f88360"), Color.parseColor("#f06fa4"), Color.parseColor("#a489d6")};
        this.f8700i = new String[]{C1914mm.m10557b(R.string.faqiu), C1914mm.m10557b(R.string.kousha), C1914mm.m10557b(R.string.jieqiu), C1914mm.m10557b(R.string.xiaoqiu), C1914mm.m10557b(R.string.xuanqiu), C1914mm.m10557b(R.string.pingji)};
        this.f8701j = new Bitmap[]{BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_faqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_kousha), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_jieji), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_xiaoqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_xuanqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_pingji)};
        m8265a();
    }

    public SportChart2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8696e = 0.0f;
        this.f8698g = 0;
        this.f8699h = new int[]{Color.parseColor("#7abeea"), Color.parseColor("#72deae"), Color.parseColor("#f8c353"), Color.parseColor("#f88360"), Color.parseColor("#f06fa4"), Color.parseColor("#a489d6")};
        this.f8700i = new String[]{C1914mm.m10557b(R.string.faqiu), C1914mm.m10557b(R.string.kousha), C1914mm.m10557b(R.string.jieqiu), C1914mm.m10557b(R.string.xiaoqiu), C1914mm.m10557b(R.string.xuanqiu), C1914mm.m10557b(R.string.pingji)};
        this.f8701j = new Bitmap[]{BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_faqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_kousha), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_jieji), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_xiaoqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_xuanqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_pingji)};
        m8265a();
    }

    public SportChart2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8696e = 0.0f;
        this.f8698g = 0;
        this.f8699h = new int[]{Color.parseColor("#7abeea"), Color.parseColor("#72deae"), Color.parseColor("#f8c353"), Color.parseColor("#f88360"), Color.parseColor("#f06fa4"), Color.parseColor("#a489d6")};
        this.f8700i = new String[]{C1914mm.m10557b(R.string.faqiu), C1914mm.m10557b(R.string.kousha), C1914mm.m10557b(R.string.jieqiu), C1914mm.m10557b(R.string.xiaoqiu), C1914mm.m10557b(R.string.xuanqiu), C1914mm.m10557b(R.string.pingji)};
        this.f8701j = new Bitmap[]{BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_faqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_kousha), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_jieji), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_xiaoqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_xuanqiu), BitmapFactory.decodeResource(C1914mm.m10556b(), R.drawable.ic_pingji)};
        m8265a();
    }

    /* JADX INFO: renamed from: a */
    private void m8265a() {
        this.f8692a = new Paint();
        this.f8692a.setColor(Color.parseColor("#7c7b80"));
        this.f8692a.setAntiAlias(true);
        this.f8692a.setTextSize(C1895ly.m10460a(getContext(), 10.0f));
        this.f8693b = new Paint();
        this.f8693b.setStyle(Paint.Style.FILL);
        this.f8693b.setAntiAlias(true);
        this.f8697f = new TreeSet<>(new C1371b());
    }

    public void setData(List<Integer> list) {
        if (list.size() > 0) {
            this.f8698g = 1;
            this.f8697f.clear();
            for (int i = 0; i < 6; i++) {
                C1370a c1370a = new C1370a();
                c1370a.f8703b = list.get(i).intValue();
                c1370a.f8702a = this.f8700i[i];
                c1370a.f8704c = this.f8699h[i];
                c1370a.f8705d = this.f8701j[i];
                this.f8697f.add(c1370a);
                if (list.get(i).intValue() > this.f8698g) {
                    this.f8698g = list.get(i).intValue();
                }
            }
        }
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8694c = View.MeasureSpec.getSize(i);
        this.f8695d = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8694c, this.f8695d);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = 0;
        float width = this.f8701j[0].getWidth();
        this.f8696e = (float) (((double) (this.f8694c - (this.f8701j[0].getWidth() * 6))) / 7.0d);
        float f = 2.0f;
        int height = (int) (((this.f8695d - this.f8701j[0].getHeight()) - C1895ly.m10460a(C1914mm.m10554a(), 10.0f)) - (this.f8692a.getTextSize() * 2.0f));
        int i2 = (this.f8697f.first().f8703b * 8) / 5;
        if (i2 > this.f8698g) {
            this.f8698g = i2;
        }
        for (C1370a c1370a : this.f8697f) {
            float f2 = (float) ((((double) c1370a.f8703b) * 1.0d) / ((double) this.f8698g));
            float f3 = i * width;
            float f4 = (width / f) + f3;
            int i3 = i + 1;
            float f5 = i3;
            float f6 = height * f2;
            canvas.drawText(c1370a.f8702a, ((this.f8696e * f5) + f4) - (this.f8692a.measureText(c1370a.f8702a) / f), (((this.f8695d - f6) - c1370a.f8705d.getHeight()) - C1895ly.m10460a(C1914mm.m10554a(), 5.0f)) - this.f8692a.getTextSize(), this.f8692a);
            String strValueOf = String.valueOf(c1370a.f8703b);
            canvas.drawText(strValueOf, (f4 + (this.f8696e * f5)) - (this.f8692a.measureText(strValueOf) / 2.0f), ((this.f8695d - f6) - c1370a.f8705d.getHeight()) - C1895ly.m10460a(C1914mm.m10554a(), 5.0f), this.f8692a);
            this.f8693b.setColor(c1370a.f8704c);
            canvas.drawBitmap(c1370a.f8705d, (this.f8696e * f5) + f3, (this.f8695d - f6) - c1370a.f8705d.getHeight(), (Paint) null);
            canvas.drawRect((this.f8696e * f5) + f3, this.f8695d - f6, (this.f8696e * f5) + (f5 * width), this.f8695d, this.f8693b);
            i = i3;
            f = 2.0f;
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.SportChart2$a */
    class C1370a {

        /* JADX INFO: renamed from: a */
        public String f8702a;

        /* JADX INFO: renamed from: b */
        public int f8703b;

        /* JADX INFO: renamed from: c */
        public int f8704c;

        /* JADX INFO: renamed from: d */
        public Bitmap f8705d;

        private C1370a() {
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.SportChart2$b */
    public class C1371b implements Comparator<C1370a> {
        public C1371b() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(C1370a c1370a, C1370a c1370a2) {
            return c1370a.f8703b > c1370a2.f8703b ? 1 : -1;
        }
    }
}
