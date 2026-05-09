package cn.jeesoft.widget.pickerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;
import java.util.Timer;
import p000.C1794ie;
import p000.C1795if;
import p000.C1796ig;
import p000.HandlerC1798ii;
import p000.InterfaceC1792ic;
import p000.RunnableC1793id;

/* JADX INFO: loaded from: classes.dex */
public class LoopView extends View {

    /* JADX INFO: renamed from: A */
    int f5351A;

    /* JADX INFO: renamed from: B */
    float f5352B;

    /* JADX INFO: renamed from: C */
    float f5353C;

    /* JADX INFO: renamed from: D */
    float f5354D;

    /* JADX INFO: renamed from: E */
    private GestureDetector f5355E;

    /* JADX INFO: renamed from: F */
    private int f5356F;

    /* JADX INFO: renamed from: G */
    private GestureDetector.SimpleOnGestureListener f5357G;

    /* JADX INFO: renamed from: H */
    private int f5358H;

    /* JADX INFO: renamed from: I */
    private boolean f5359I;

    /* JADX INFO: renamed from: a */
    public Timer f5360a;

    /* JADX INFO: renamed from: b */
    public int f5361b;

    /* JADX INFO: renamed from: c */
    public Handler f5362c;

    /* JADX INFO: renamed from: d */
    public InterfaceC1792ic f5363d;

    /* JADX INFO: renamed from: e */
    Context f5364e;

    /* JADX INFO: renamed from: f */
    Paint f5365f;

    /* JADX INFO: renamed from: g */
    Paint f5366g;

    /* JADX INFO: renamed from: h */
    Paint f5367h;

    /* JADX INFO: renamed from: i */
    public List f5368i;

    /* JADX INFO: renamed from: j */
    int f5369j;

    /* JADX INFO: renamed from: k */
    int f5370k;

    /* JADX INFO: renamed from: l */
    public int f5371l;

    /* JADX INFO: renamed from: m */
    int f5372m;

    /* JADX INFO: renamed from: n */
    int f5373n;

    /* JADX INFO: renamed from: o */
    int f5374o;

    /* JADX INFO: renamed from: p */
    public float f5375p;

    /* JADX INFO: renamed from: q */
    public boolean f5376q;

    /* JADX INFO: renamed from: r */
    int f5377r;

    /* JADX INFO: renamed from: s */
    int f5378s;

    /* JADX INFO: renamed from: t */
    int f5379t;

    /* JADX INFO: renamed from: u */
    public int f5380u;

    /* JADX INFO: renamed from: v */
    int f5381v;

    /* JADX INFO: renamed from: w */
    int f5382w;

    /* JADX INFO: renamed from: x */
    int f5383x;

    /* JADX INFO: renamed from: y */
    int f5384y;

    /* JADX INFO: renamed from: z */
    int f5385z;

    public LoopView(Context context) {
        super(context);
        this.f5358H = 10;
        this.f5359I = true;
        m5806a(context);
    }

    public LoopView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5358H = 10;
        this.f5359I = true;
        m5806a(context);
    }

    public LoopView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5358H = 10;
        this.f5359I = true;
        m5806a(context);
    }

    /* JADX INFO: renamed from: a */
    private void m5806a(Context context) {
        this.f5369j = 0;
        this.f5372m = 2138864512;
        this.f5373n = -8619136;
        this.f5374o = 2138864512;
        this.f5375p = 2.0f;
        this.f5376q = true;
        this.f5380u = -1;
        this.f5381v = 9;
        this.f5352B = 0.0f;
        this.f5353C = 0.0f;
        this.f5354D = 0.0f;
        this.f5361b = 0;
        this.f5357G = new C1795if(this);
        this.f5362c = new HandlerC1798ii(this);
        this.f5364e = context;
        setTextSize(16.0f);
    }

    public void setMiddleRed() {
        this.f5372m = -1;
        this.f5373n = -3473148;
        this.f5374o = -1;
    }

    public void setMiddleAppleColor() {
        this.f5372m = 2138864512;
        this.f5373n = -15395563;
        this.f5374o = 2138864512;
    }

    public void setMiddleLineVisible(boolean z) {
        this.f5359I = z;
    }

    /* JADX INFO: renamed from: a */
    public static int m5805a(LoopView loopView) {
        return loopView.getCurrentItem();
    }

    /* JADX INFO: renamed from: b */
    public static void m5808b(LoopView loopView) {
        loopView.m5810d();
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: b */
    private void m5807b() {
        if (this.f5368i == null) {
            return;
        }
        this.f5365f = new Paint();
        this.f5365f.setColor(this.f5372m);
        this.f5365f.setAntiAlias(true);
        this.f5365f.setTypeface(Typeface.MONOSPACE);
        this.f5365f.setTextSize(this.f5369j);
        this.f5366g = new Paint();
        this.f5366g.setColor(this.f5373n);
        this.f5366g.setAntiAlias(true);
        this.f5366g.setTextScaleX(1.05f);
        this.f5366g.setTypeface(Typeface.MONOSPACE);
        this.f5366g.setTextSize(this.f5369j);
        this.f5367h = new Paint();
        this.f5367h.setColor(this.f5374o);
        this.f5367h.setAntiAlias(true);
        this.f5367h.setTypeface(Typeface.MONOSPACE);
        this.f5367h.setTextSize(this.f5369j);
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f5355E = new GestureDetector(this.f5364e, this.f5357G);
        this.f5355E.setIsLongpressEnabled(false);
        m5809c();
        this.f5383x = (int) (this.f5371l * this.f5375p * (this.f5381v - 1));
        this.f5382w = (int) (((double) (this.f5383x * 2)) / 3.141592653589793d);
        this.f5384y = (int) (((double) this.f5383x) / 3.141592653589793d);
        this.f5385z = this.f5370k + this.f5369j;
        this.f5377r = (int) ((this.f5382w - (this.f5375p * this.f5371l)) / 2.0f);
        this.f5378s = (int) ((this.f5382w + (this.f5375p * this.f5371l)) / 2.0f);
        if (this.f5380u == -1) {
            if (this.f5376q) {
                this.f5380u = (this.f5368i.size() + 1) / 2;
            } else {
                this.f5380u = 0;
            }
        }
        this.f5379t = this.f5380u;
    }

    /* JADX INFO: renamed from: c */
    private void m5809c() {
        Rect rect = new Rect();
        for (int i = 0; i < this.f5368i.size(); i++) {
            String str = (String) this.f5368i.get(i);
            this.f5366g.getTextBounds(str, 0, str.length(), rect);
            int iWidth = rect.width();
            if (iWidth > this.f5370k) {
                this.f5370k = iWidth;
            }
            this.f5366g.getTextBounds("星期", 0, 2, rect);
            int iHeight = rect.height();
            if (iHeight > this.f5371l) {
                this.f5371l = iHeight;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private void m5810d() {
        int i = (int) (this.f5361b % (this.f5375p * this.f5371l));
        Timer timer = new Timer();
        this.f5360a = timer;
        timer.schedule(new C1796ig(this, i, timer), 0L, 10L);
    }

    public final void setNotLoop() {
        this.f5376q = false;
    }

    public final void setCyclic(boolean z) {
        this.f5376q = z;
    }

    public final void setTextSize(float f) {
        if (f > 0.0f) {
            this.f5369j = (int) (this.f5364e.getResources().getDisplayMetrics().density * f);
        }
    }

    public final void setCurrentItem(int i) {
        this.f5380u = i;
        this.f5361b = 0;
        m5810d();
        invalidate();
    }

    public final void setListener(InterfaceC1792ic interfaceC1792ic) {
        this.f5363d = interfaceC1792ic;
    }

    public final void setArrayList(List list) {
        this.f5368i = list;
        m5807b();
        invalidate();
    }

    public final int getCurrentItem() {
        if (this.f5379t <= 0) {
            return 0;
        }
        return this.f5379t;
    }

    /* JADX INFO: renamed from: a */
    public final void m5812a(float f) {
        Timer timer = new Timer();
        this.f5360a = timer;
        timer.schedule(new C1794ie(this, f, timer), 0L, 20L);
    }

    /* JADX INFO: renamed from: a */
    public final void m5811a() {
        if (this.f5363d != null) {
            new Handler().postDelayed(new RunnableC1793id(this), 200L);
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        if (this.f5368i == null) {
            super.onDraw(canvas);
            return;
        }
        String[] strArr = new String[this.f5381v];
        this.f5351A = (int) (this.f5361b / (this.f5375p * this.f5371l));
        this.f5379t = this.f5380u + (this.f5351A % this.f5368i.size());
        int i2 = 0;
        if (!this.f5376q) {
            if (this.f5379t < 0) {
                this.f5379t = 0;
            }
            if (this.f5379t > this.f5368i.size() - 1) {
                this.f5379t = this.f5368i.size() - 1;
            }
        } else {
            if (this.f5379t < 0) {
                this.f5379t = this.f5368i.size() + this.f5379t;
            }
            if (this.f5379t > this.f5368i.size() - 1) {
                this.f5379t -= this.f5368i.size();
            }
        }
        int i3 = (int) (this.f5361b % (this.f5375p * this.f5371l));
        for (int i4 = 0; i4 < this.f5381v; i4++) {
            int size = this.f5379t - (4 - i4);
            if (this.f5376q) {
                if (size < 0) {
                    size += this.f5368i.size();
                }
                if (size > this.f5368i.size() - 1) {
                    size -= this.f5368i.size();
                }
                strArr[i4] = (String) this.f5368i.get(size);
            } else if (size < 0) {
                strArr[i4] = "";
            } else if (size > this.f5368i.size() - 1) {
                strArr[i4] = "";
            } else {
                strArr[i4] = (String) this.f5368i.get(size);
            }
        }
        int i5 = (this.f5385z - this.f5370k) / 2;
        if (this.f5359I) {
            canvas.drawLine(0.0f, this.f5377r, this.f5385z, this.f5377r, this.f5367h);
            canvas.drawLine(0.0f, this.f5378s, this.f5385z, this.f5378s, this.f5367h);
        }
        int i6 = 0;
        while (i6 < this.f5381v) {
            canvas.save();
            double d = (((double) (((this.f5371l * i6) * this.f5375p) - i3)) * 3.141592653589793d) / ((double) this.f5383x);
            float f = (float) (90.0d - ((d / 3.141592653589793d) * 180.0d));
            if (f >= 90.0f || f <= -90.0f) {
                i = i3;
                canvas.restore();
            } else {
                int iCos = (int) ((((double) this.f5384y) - (Math.cos(d) * ((double) this.f5384y))) - ((Math.sin(d) * ((double) this.f5371l)) / 2.0d));
                canvas.translate(0.0f, iCos);
                canvas.scale(1.0f, (float) Math.sin(d));
                String str = strArr[i6];
                int i7 = this.f5369j;
                int length = (int) (((double) this.f5369j) * ((((double) this.f5369j) - ((double) (str.length() * 2))) / ((double) this.f5369j)) * 1.2d);
                if (length < this.f5358H) {
                    length = this.f5358H;
                }
                float f2 = length;
                this.f5365f.setTextSize(f2);
                this.f5366g.setTextSize(f2);
                int left = (int) (((double) this.f5377r) + (((double) getLeft()) * 0.5d));
                Rect rect = new Rect();
                this.f5366g.getTextBounds(str, i2, str.length(), rect);
                int iWidth = rect.width();
                int width = getWidth();
                if (getId() == R.id.j_options3) {
                    i = i3;
                    left = (int) (((double) this.f5377r) - (((double) getLeft()) * 0.5d));
                } else {
                    i = i3;
                }
                int i8 = width - (left * 2);
                if (iWidth > 0) {
                    left = (int) (((double) left) + (((double) (i8 - iWidth)) * 0.5d));
                }
                if (iCos <= this.f5377r && this.f5371l + iCos >= this.f5377r) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.f5385z, this.f5377r - iCos);
                    float f3 = left;
                    canvas.drawText(strArr[i6], f3, this.f5371l, this.f5365f);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.f5377r - iCos, this.f5385z, (int) (this.f5371l * this.f5375p));
                    canvas.drawText(strArr[i6], f3, this.f5371l, this.f5366g);
                    canvas.restore();
                } else if (iCos <= this.f5378s && this.f5371l + iCos >= this.f5378s) {
                    canvas.save();
                    canvas.clipRect(0, 0, this.f5385z, this.f5378s - iCos);
                    float f4 = left;
                    canvas.drawText(strArr[i6], f4, this.f5371l, this.f5366g);
                    canvas.restore();
                    canvas.save();
                    canvas.clipRect(0, this.f5378s - iCos, this.f5385z, (int) (this.f5371l * this.f5375p));
                    canvas.drawText(strArr[i6], f4, this.f5371l, this.f5365f);
                    canvas.restore();
                } else if (iCos >= this.f5377r && this.f5371l + iCos <= this.f5378s) {
                    canvas.clipRect(0, 0, this.f5385z, (int) (this.f5371l * this.f5375p));
                    canvas.drawText(strArr[i6], left, this.f5371l, this.f5366g);
                    this.f5356F = this.f5368i.indexOf(strArr[i6]);
                } else {
                    canvas.clipRect(0, 0, this.f5385z, (int) (this.f5371l * this.f5375p));
                    canvas.drawText(strArr[i6], left, this.f5371l, this.f5365f);
                    canvas.restore();
                }
                canvas.restore();
            }
            i6++;
            i3 = i;
            i2 = 0;
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        m5807b();
        setMeasuredDimension(this.f5385z, this.f5382w);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f5352B = motionEvent.getRawY();
        } else if (action == 2) {
            this.f5353C = motionEvent.getRawY();
            this.f5354D = this.f5352B - this.f5353C;
            this.f5352B = this.f5353C;
            this.f5361b = (int) (this.f5361b + this.f5354D);
            if (!this.f5376q && this.f5361b <= ((int) ((-this.f5380u) * this.f5375p * this.f5371l))) {
                this.f5361b = (int) ((-this.f5380u) * this.f5375p * this.f5371l);
            }
        } else {
            if (!this.f5355E.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
                m5810d();
            }
            return true;
        }
        if (this.f5361b < ((int) (((this.f5368i.size() - 1) - this.f5380u) * this.f5375p * this.f5371l))) {
            invalidate();
        } else {
            this.f5361b = (int) (((this.f5368i.size() - 1) - this.f5380u) * this.f5375p * this.f5371l);
            invalidate();
        }
        if (!this.f5355E.onTouchEvent(motionEvent) && motionEvent.getAction() == 1) {
            m5810d();
        }
        return true;
    }

    public void setMinTextSize(int i) {
        this.f5358H = i;
    }
}
