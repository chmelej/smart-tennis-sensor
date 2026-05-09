package com.coollang.tennis.Custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.v4.internal.view.SupportMenu;
import android.util.AttributeSet;
import android.view.View;
import com.coollang.tennis.R;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class BreakPointProgressBar extends View {

    /* JADX INFO: renamed from: i */
    private static final String f6177i = "BreakPointProgressBar";

    /* JADX INFO: renamed from: a */
    private Paint f6178a;

    /* JADX INFO: renamed from: b */
    private int f6179b;

    /* JADX INFO: renamed from: c */
    private int f6180c;

    /* JADX INFO: renamed from: d */
    private int f6181d;

    /* JADX INFO: renamed from: e */
    private int f6182e;

    /* JADX INFO: renamed from: f */
    private int f6183f;

    /* JADX INFO: renamed from: g */
    private RectF f6184g;

    /* JADX INFO: renamed from: h */
    private float f6185h;

    /* JADX INFO: renamed from: j */
    private LinkedList<C0987a> f6186j;

    /* JADX INFO: renamed from: k */
    private float f6187k;

    /* JADX INFO: renamed from: l */
    private float f6188l;

    /* JADX INFO: renamed from: m */
    private float f6189m;

    /* JADX INFO: renamed from: n */
    private boolean f6190n;

    /* JADX INFO: renamed from: o */
    private Paint f6191o;

    /* JADX INFO: renamed from: p */
    private long f6192p;

    /* JADX INFO: renamed from: q */
    private Paint f6193q;

    /* JADX INFO: renamed from: r */
    private Paint f6194r;

    /* JADX INFO: renamed from: s */
    private float f6195s;

    /* JADX INFO: renamed from: t */
    private boolean f6196t;

    /* JADX INFO: renamed from: u */
    private float f6197u;

    /* JADX INFO: renamed from: v */
    private InterfaceC0988b f6198v;

    /* JADX INFO: renamed from: w */
    private float f6199w;

    /* JADX INFO: renamed from: x */
    private float f6200x;

    /* JADX INFO: renamed from: com.coollang.tennis.Custom.BreakPointProgressBar$b */
    public interface InterfaceC0988b {
        /* JADX INFO: renamed from: a */
        void mo6853a();

        /* JADX INFO: renamed from: a */
        void mo6854a(float f);

        /* JADX INFO: renamed from: b */
        void mo6855b();
    }

    public BreakPointProgressBar(Context context) {
        this(context, null);
    }

    public BreakPointProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BreakPointProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6186j = new LinkedList<>();
        this.f6199w = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BreakPointProgressBar, 0, 0);
        this.f6179b = typedArrayObtainStyledAttributes.getColor(0, -1);
        this.f6180c = typedArrayObtainStyledAttributes.getColor(4, -16776961);
        this.f6181d = typedArrayObtainStyledAttributes.getColor(2, 20);
        this.f6182e = typedArrayObtainStyledAttributes.getColor(3, -1);
        this.f6183f = typedArrayObtainStyledAttributes.getColor(1, -1);
        typedArrayObtainStyledAttributes.recycle();
        this.f6178a = m6847a(-16711936, this.f6181d);
        this.f6191o = m6847a(-1, this.f6181d);
        this.f6193q = m6847a(-1, this.f6181d);
        this.f6194r = m6847a(SupportMenu.CATEGORY_MASK, this.f6181d);
        this.f6184g = new RectF();
    }

    /* JADX INFO: renamed from: a */
    private Paint m6847a(int i, int i2) {
        Paint paint = new Paint(1);
        paint.setColor(i);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(i2);
        return paint;
    }

    public void setTotalTime(long j) {
        this.f6187k = j;
        this.f6188l = 360.0f / this.f6187k;
        this.f6189m = this.f6187k / 360.0f;
    }

    /* JADX INFO: renamed from: a */
    public void m6848a() {
        this.f6199w = this.f6195s;
        this.f6190n = true;
        this.f6196t = false;
    }

    /* JADX INFO: renamed from: b */
    public void m6849b() {
        this.f6190n = false;
        this.f6200x = this.f6195s;
    }

    /* JADX INFO: renamed from: c */
    public synchronized void m6850c() {
        this.f6186j.add(new C0987a(this.f6200x - this.f6199w, this.f6194r.getColor()));
    }

    /* JADX INFO: renamed from: d */
    public synchronized void m6851d() {
        if (this.f6186j.size() > 0) {
            this.f6186j.removeLast();
            this.f6196t = true;
        }
    }

    public void setProgress(float f) {
        this.f6195s = f;
    }

    public void setOnVideoRecorderProgressListener(InterfaceC0988b interfaceC0988b) {
        this.f6198v = interfaceC0988b;
    }

    public void setMinDuration(long j) {
        this.f6185h = j * this.f6188l;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f6184g.set((this.f6181d / 2) + 0, (this.f6181d / 2) + 0, width - (this.f6181d / 2), height - (this.f6181d / 2));
        float f = -90;
        canvas.drawArc(this.f6184g, f, 360.0f, false, this.f6193q);
        float fM6852a = 0.0f;
        if (this.f6190n && this.f6192p != 0) {
            this.f6195s += this.f6188l * (jCurrentTimeMillis - this.f6192p);
        } else if (this.f6196t) {
            if (this.f6186j.size() == 0) {
                this.f6195s = 0.0f;
            } else {
                this.f6195s -= this.f6197u;
            }
            this.f6196t = false;
        }
        if (this.f6195s <= 360.0f) {
            canvas.drawArc(this.f6184g, f, this.f6195s, false, this.f6194r);
        } else {
            this.f6195s = 360.0f;
            canvas.drawArc(this.f6184g, f, 360.0f, false, this.f6194r);
        }
        canvas.drawArc(this.f6184g, f + (this.f6185h - 1.0f), 2.0f, false, this.f6178a);
        if (this.f6198v != null) {
            if (this.f6195s >= this.f6185h) {
                this.f6198v.mo6853a();
            } else if (this.f6195s == 360.0f) {
                this.f6198v.mo6855b();
            }
            this.f6198v.mo6854a((this.f6195s * this.f6189m) / 1000.0f);
        }
        synchronized (this) {
            if (!this.f6186j.isEmpty()) {
                for (int i = 0; i < this.f6186j.size(); i++) {
                    C0987a c0987a = this.f6186j.get(i);
                    fM6852a += c0987a.m6852a();
                    if (i == this.f6186j.size() - 1) {
                        this.f6197u = c0987a.m6852a();
                    }
                    canvas.drawArc(this.f6184g, f + fM6852a, 2.0f, false, this.f6191o);
                }
            }
        }
        this.f6192p = System.currentTimeMillis();
        invalidate();
    }

    /* JADX INFO: renamed from: com.coollang.tennis.Custom.BreakPointProgressBar$a */
    class C0987a {

        /* JADX INFO: renamed from: b */
        private float f6202b;

        /* JADX INFO: renamed from: c */
        private int f6203c;

        public C0987a(float f, int i) {
            this.f6202b = f;
            this.f6203c = i;
        }

        /* JADX INFO: renamed from: a */
        public float m6852a() {
            return this.f6202b;
        }
    }
}
