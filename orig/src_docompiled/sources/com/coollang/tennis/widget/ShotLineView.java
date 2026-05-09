package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.support.v4.view.PointerIconCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p000.C1895ly;
import p000.InterfaceC1880lj;

/* JADX INFO: loaded from: classes.dex */
public class ShotLineView extends View {

    /* JADX INFO: renamed from: a */
    private final int f8664a;

    /* JADX INFO: renamed from: b */
    private final String f8665b;

    /* JADX INFO: renamed from: c */
    private final String f8666c;

    /* JADX INFO: renamed from: d */
    private final String f8667d;

    /* JADX INFO: renamed from: e */
    private int f8668e;

    /* JADX INFO: renamed from: f */
    private int f8669f;

    /* JADX INFO: renamed from: g */
    private int f8670g;

    /* JADX INFO: renamed from: h */
    private int f8671h;

    /* JADX INFO: renamed from: i */
    private int f8672i;

    /* JADX INFO: renamed from: j */
    private int f8673j;

    /* JADX INFO: renamed from: k */
    private Paint f8674k;

    /* JADX INFO: renamed from: l */
    private Paint f8675l;

    /* JADX INFO: renamed from: m */
    private boolean f8676m;

    /* JADX INFO: renamed from: n */
    private long f8677n;

    /* JADX INFO: renamed from: o */
    private long f8678o;

    /* JADX INFO: renamed from: p */
    private long f8679p;

    /* JADX INFO: renamed from: q */
    private float f8680q;

    /* JADX INFO: renamed from: r */
    private float f8681r;

    /* JADX INFO: renamed from: s */
    private float f8682s;

    /* JADX INFO: renamed from: t */
    private List<OnTimeDetailTable> f8683t;

    /* JADX INFO: renamed from: u */
    private InterfaceC1880lj f8684u;

    /* JADX INFO: renamed from: v */
    private boolean f8685v;

    /* JADX INFO: renamed from: w */
    private int f8686w;

    /* JADX INFO: renamed from: x */
    private int f8687x;

    /* JADX INFO: renamed from: y */
    private Handler f8688y;

    /* JADX INFO: renamed from: z */
    private Runnable f8689z;

    public ShotLineView(Context context) {
        super(context);
        this.f8664a = 7;
        this.f8665b = "#ff8560";
        this.f8666c = "#25c9ad";
        this.f8667d = "#8f8f8f";
        this.f8668e = 1;
        this.f8669f = 20000;
        this.f8676m = false;
        this.f8685v = false;
        this.f8688y = new Handler();
        this.f8689z = new Runnable() { // from class: com.coollang.tennis.widget.ShotLineView.1
            @Override // java.lang.Runnable
            public void run() {
                ShotLineView.this.invalidate();
                ShotLineView.this.f8688y.postDelayed(this, 15L);
            }
        };
        m8261b();
    }

    public ShotLineView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8664a = 7;
        this.f8665b = "#ff8560";
        this.f8666c = "#25c9ad";
        this.f8667d = "#8f8f8f";
        this.f8668e = 1;
        this.f8669f = 20000;
        this.f8676m = false;
        this.f8685v = false;
        this.f8688y = new Handler();
        this.f8689z = new Runnable() { // from class: com.coollang.tennis.widget.ShotLineView.1
            @Override // java.lang.Runnable
            public void run() {
                ShotLineView.this.invalidate();
                ShotLineView.this.f8688y.postDelayed(this, 15L);
            }
        };
        m8261b();
    }

    public ShotLineView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8664a = 7;
        this.f8665b = "#ff8560";
        this.f8666c = "#25c9ad";
        this.f8667d = "#8f8f8f";
        this.f8668e = 1;
        this.f8669f = 20000;
        this.f8676m = false;
        this.f8685v = false;
        this.f8688y = new Handler();
        this.f8689z = new Runnable() { // from class: com.coollang.tennis.widget.ShotLineView.1
            @Override // java.lang.Runnable
            public void run() {
                ShotLineView.this.invalidate();
                ShotLineView.this.f8688y.postDelayed(this, 15L);
            }
        };
        m8261b();
    }

    @TargetApi(21)
    public ShotLineView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8664a = 7;
        this.f8665b = "#ff8560";
        this.f8666c = "#25c9ad";
        this.f8667d = "#8f8f8f";
        this.f8668e = 1;
        this.f8669f = 20000;
        this.f8676m = false;
        this.f8685v = false;
        this.f8688y = new Handler();
        this.f8689z = new Runnable() { // from class: com.coollang.tennis.widget.ShotLineView.1
            @Override // java.lang.Runnable
            public void run() {
                ShotLineView.this.invalidate();
                ShotLineView.this.f8688y.postDelayed(this, 15L);
            }
        };
        m8261b();
    }

    /* JADX INFO: renamed from: b */
    private void m8261b() {
        this.f8674k = new Paint();
        this.f8674k.setColor(Color.parseColor("#7f7c7b80"));
        this.f8675l = new Paint();
        this.f8675l.setAntiAlias(true);
        this.f8670g = C1895ly.m10460a(getContext(), 7.0f);
        this.f8684u = new InterfaceC1880lj() { // from class: com.coollang.tennis.widget.ShotLineView.2
            @Override // p000.InterfaceC1880lj
            /* JADX INFO: renamed from: a */
            public void mo8264a(OnTimeDetailTable onTimeDetailTable) {
            }
        };
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8672i = View.MeasureSpec.getSize(i);
        this.f8673j = View.MeasureSpec.getSize(i2);
        setMeasuredDimension(this.f8672i, this.f8673j);
    }

    public void setRecordingType() {
        this.f8671h = PointerIconCompat.TYPE_CONTEXT_MENU;
    }

    public void setTargetSpeed(int i, int i2) {
        this.f8686w = i;
        this.f8687x = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m8262a() {
        this.f8677n = System.currentTimeMillis();
        this.f8678o = 0L;
        this.f8683t = new ArrayList();
        this.f8676m = true;
        this.f8688y.removeCallbacks(this.f8689z);
        this.f8688y.postDelayed(this.f8689z, 100L);
        invalidate();
    }

    public long getStartTime() {
        return this.f8677n;
    }

    public void setShotData(OnTimeDetailTable onTimeDetailTable) {
        if (this.f8676m && this.f8683t != null && this.f8678o == 0) {
            Iterator<OnTimeDetailTable> it = this.f8683t.iterator();
            while (it.hasNext()) {
                if (System.currentTimeMillis() - (it.next().getShotTimeStemp() * 1000) > this.f8669f) {
                    it.remove();
                }
            }
            this.f8683t.add(onTimeDetailTable);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8263a(long j) {
        this.f8677n = System.currentTimeMillis();
        this.f8683t = new ArrayList();
        this.f8688y.removeCallbacks(this.f8689z);
        invalidate();
        this.f8676m = false;
    }

    public void setShowType(List<OnTimeDetailTable> list, int i, long j) {
        this.f8671h = PointerIconCompat.TYPE_HAND;
        this.f8683t = list;
        this.f8677n = j;
        this.f8680q = 0.0f;
        m8259a(i);
        invalidate();
    }

    /* JADX INFO: renamed from: a */
    private void m8259a(int i) {
        if (this.f8683t != null && !this.f8683t.isEmpty()) {
            this.f8682s = ((((this.f8683t.get(this.f8683t.size() - 1).getShotTimeStemp() * 1000) - this.f8677n) * ((long) i)) / this.f8669f) + i;
        } else {
            this.f8682s = i;
        }
    }

    public void setOnDotClickListener(InterfaceC1880lj interfaceC1880lj) {
        this.f8684u = interfaceC1880lj;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f = (this.f8673j / 2) - (this.f8668e / 2);
        if (this.f8671h == 1001) {
            if (this.f8676m) {
                this.f8679p = System.currentTimeMillis();
                if (this.f8678o != 0) {
                    if (this.f8679p - this.f8677n < this.f8669f && this.f8678o < this.f8679p) {
                        canvas.drawRect(new RectF((((((long) this.f8669f) - this.f8679p) + this.f8677n) * ((long) this.f8672i)) / this.f8669f, f, this.f8672i - (((this.f8679p - this.f8678o) * ((long) this.f8672i)) / this.f8669f), this.f8668e + f), this.f8674k);
                    } else {
                        canvas.drawRect(new RectF(0.0f, f, this.f8672i - (((this.f8679p - this.f8678o) * ((long) this.f8672i)) / this.f8669f), this.f8668e + f), this.f8674k);
                    }
                    if (this.f8679p - this.f8678o >= this.f8669f) {
                        this.f8676m = false;
                        this.f8688y.removeCallbacks(this.f8689z);
                    }
                } else if (this.f8679p - this.f8677n < this.f8669f) {
                    canvas.drawRect(new RectF((((((long) this.f8669f) - this.f8679p) + this.f8677n) * ((long) this.f8672i)) / this.f8669f, f, this.f8672i, this.f8668e + f), this.f8674k);
                } else {
                    canvas.drawRect(new RectF(0.0f, f, this.f8672i, this.f8668e + f), this.f8674k);
                }
                for (OnTimeDetailTable onTimeDetailTable : this.f8683t) {
                    if (this.f8679p - (onTimeDetailTable.getShotTimeStemp() * 1000) <= this.f8669f) {
                        if (onTimeDetailTable.getHandType() == 0 && onTimeDetailTable.getHitSpeed() >= this.f8686w) {
                            this.f8675l.setColor(Color.parseColor("#ff8560"));
                        } else if (onTimeDetailTable.getHandType() == 1 && onTimeDetailTable.getHitSpeed() >= this.f8687x) {
                            this.f8675l.setColor(Color.parseColor("#25c9ad"));
                        } else if ((onTimeDetailTable.getHandType() == 0 && onTimeDetailTable.getHitSpeed() < this.f8686w) || (onTimeDetailTable.getHandType() == 1 && onTimeDetailTable.getHitSpeed() < this.f8687x)) {
                            this.f8675l.setColor(Color.parseColor("#8f8f8f"));
                        }
                        canvas.drawCircle((((((long) this.f8669f) - this.f8679p) + (onTimeDetailTable.getShotTimeStemp() * 1000)) * ((long) this.f8672i)) / this.f8669f, this.f8673j / 2, this.f8670g, this.f8675l);
                    }
                }
                return;
            }
            return;
        }
        if (this.f8671h == 1002) {
            if (this.f8680q < this.f8672i / 2) {
                canvas.drawRect(new RectF((this.f8672i / 2) - this.f8680q, f, this.f8672i, this.f8668e + f), this.f8674k);
            } else {
                canvas.drawRect(new RectF(0.0f, f, this.f8672i, this.f8668e + f), this.f8674k);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8671h == 1002) {
            switch (motionEvent.getAction()) {
                case 0:
                    this.f8681r = motionEvent.getX();
                    return true;
                case 1:
                    if (this.f8685v) {
                        float f = (((this.f8680q + this.f8681r) - (this.f8672i / 2)) * this.f8669f) / this.f8672i;
                        if (f < 0.0f) {
                            return true;
                        }
                        m8258a(f);
                    }
                    return true;
                case 2:
                    if (Math.abs(this.f8681r - motionEvent.getX()) > 50.0f) {
                        this.f8685v = false;
                        if (this.f8681r - motionEvent.getX() > 0.0f && this.f8680q >= this.f8682s - this.f8672i) {
                            this.f8680q = this.f8682s - this.f8672i;
                        } else if (this.f8681r - motionEvent.getX() < 0.0f && this.f8680q <= 0.0f) {
                            this.f8680q = 0.0f;
                        } else {
                            this.f8680q += this.f8681r - motionEvent.getX();
                            this.f8681r = motionEvent.getX();
                            if (this.f8680q < 0.0f) {
                                this.f8680q = 0.0f;
                            }
                        }
                        invalidate();
                    } else {
                        this.f8685v = true;
                    }
                    return true;
                default:
                    return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    /* JADX INFO: renamed from: a */
    private void m8258a(float f) {
        if (this.f8683t == null || this.f8683t.isEmpty()) {
            return;
        }
        m8260a(0, this.f8683t.size(), f);
    }

    /* JADX INFO: renamed from: a */
    private void m8260a(int i, int i2, float f) {
        int i3 = (i2 + i) / 2;
        if (i3 <= i) {
            while (i < i2) {
                if (Math.abs(((this.f8683t.get(i3).getShotTimeStemp() * 1000) - this.f8677n) - f) < 500.0f) {
                    this.f8684u.mo8264a(this.f8683t.get(i));
                    return;
                }
                i++;
            }
            return;
        }
        if (Math.abs(((this.f8683t.get(i3).getShotTimeStemp() * 1000) - this.f8677n) - f) < 500.0f) {
            this.f8684u.mo8264a(this.f8683t.get(i3));
        } else if ((this.f8683t.get(i3).getShotTimeStemp() * 1000) - this.f8677n > f) {
            m8260a(i, i3, f);
        } else {
            m8260a(i3, i2, f);
        }
    }
}
