package com.coollang.tennis.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import p000.C1900mc;

/* JADX INFO: loaded from: classes.dex */
public class AnimationView extends View {

    /* JADX INFO: renamed from: m */
    private static long f7952m = 500;

    /* JADX INFO: renamed from: a */
    private int f7953a;

    /* JADX INFO: renamed from: b */
    private int f7954b;

    /* JADX INFO: renamed from: c */
    private float f7955c;

    /* JADX INFO: renamed from: d */
    private EnumC1306a f7956d;

    /* JADX INFO: renamed from: e */
    private Paint f7957e;

    /* JADX INFO: renamed from: f */
    private Paint f7958f;

    /* JADX INFO: renamed from: g */
    private Paint f7959g;

    /* JADX INFO: renamed from: h */
    private Path f7960h;

    /* JADX INFO: renamed from: i */
    private int f7961i;

    /* JADX INFO: renamed from: j */
    private int f7962j;

    /* JADX INFO: renamed from: k */
    private boolean f7963k;

    /* JADX INFO: renamed from: l */
    private int f7964l;

    /* JADX INFO: renamed from: n */
    private long f7965n;

    /* JADX INFO: renamed from: o */
    private long f7966o;

    /* JADX INFO: renamed from: p */
    private int f7967p;

    /* JADX INFO: renamed from: q */
    private InterfaceC1307b f7968q;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.AnimationView$b */
    interface InterfaceC1307b {
    }

    /* JADX INFO: renamed from: com.coollang.tennis.widget.AnimationView$a */
    enum EnumC1306a {
        PULL_DOWN,
        DRAG_DOWN,
        REL_DRAG,
        SPRING_UP,
        POP_BALL,
        OUTER_CIR,
        REFRESHING,
        DONE,
        STOP;

        @Override // java.lang.Enum
        public String toString() {
            switch (this) {
                case PULL_DOWN:
                    return "pull down";
                case DRAG_DOWN:
                    return "drag down";
                case REL_DRAG:
                    return "release drag";
                case SPRING_UP:
                    return "spring up";
                case POP_BALL:
                    return "pop ball";
                case OUTER_CIR:
                    return "outer circle";
                case REFRESHING:
                    return "refreshing...";
                case DONE:
                    return "done!";
                case STOP:
                    return "stop";
                default:
                    return "unknown state";
            }
        }
    }

    public AnimationView(Context context) {
        this(context, null, 0);
    }

    public AnimationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AnimationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f7956d = EnumC1306a.PULL_DOWN;
        this.f7963k = true;
        m8016a(context, attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    private void m8016a(Context context, AttributeSet attributeSet, int i) {
        this.f7953a = (int) TypedValue.applyDimension(1, 0.0f, context.getResources().getDisplayMetrics());
        this.f7954b = (int) TypedValue.applyDimension(1, 100.0f, context.getResources().getDisplayMetrics());
        this.f7955c = 0.5f;
        this.f7957e = new Paint();
        this.f7957e.setAntiAlias(true);
        this.f7957e.setStyle(Paint.Style.FILL);
        this.f7957e.setColor(-7630673);
        this.f7958f = new Paint();
        this.f7958f.setAntiAlias(true);
        this.f7958f.setColor(Color.parseColor("#02182b"));
        this.f7958f.setStyle(Paint.Style.FILL);
        this.f7959g = new Paint();
        this.f7959g.setAntiAlias(true);
        this.f7959g.setColor(-1);
        this.f7959g.setStyle(Paint.Style.STROKE);
        this.f7959g.setStrokeWidth(5.0f);
        this.f7960h = new Path();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        if (View.MeasureSpec.getSize(i2) > this.f7954b + this.f7953a) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.f7954b + this.f7953a, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            this.f7961i = getWidth();
            this.f7962j = getHeight();
            if (this.f7962j < this.f7953a) {
                this.f7956d = EnumC1306a.PULL_DOWN;
            }
            if (C13051.f7969a[this.f7956d.ordinal()] == 1 && this.f7962j >= this.f7953a) {
                this.f7956d = EnumC1306a.DRAG_DOWN;
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        switch (this.f7956d) {
            case PULL_DOWN:
                canvas.drawRect(0.0f, 0.0f, this.f7961i, this.f7962j, this.f7957e);
                break;
            case DRAG_DOWN:
            case REL_DRAG:
                m8017a(canvas);
                break;
        }
        if (this.f7956d == EnumC1306a.REL_DRAG) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            do {
                int relHeight = getRelHeight();
                if (relHeight == this.f7964l) {
                }
                this.f7964l = relHeight;
                layoutParams.height = this.f7953a + relHeight;
                requestLayout();
            } while (getRelRatio() != 1.0f);
            this.f7964l = relHeight;
            layoutParams.height = this.f7953a + relHeight;
            requestLayout();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8017a(Canvas canvas) {
        canvas.drawRect(0.0f, 0.0f, this.f7961i, this.f7953a, this.f7957e);
        C1900mc.m10474b("drawDrag", "drawDrag");
        this.f7960h.reset();
        this.f7960h.moveTo(0.0f, this.f7953a);
        C1900mc.m10474b("drawDrag", " " + this.f7962j);
        this.f7960h.quadTo(this.f7955c * ((float) this.f7961i), (float) (this.f7953a + ((this.f7962j - this.f7953a) * 2)), (float) this.f7961i, (float) this.f7953a);
        canvas.drawPath(this.f7960h, this.f7957e);
    }

    public void setRefreshing(boolean z) {
        this.f7963k = z;
    }

    private int getRelHeight() {
        return (int) (this.f7967p * (1.0f - getRelRatio()));
    }

    /* JADX INFO: renamed from: a */
    public void m8018a() {
        this.f7965n = System.currentTimeMillis();
        this.f7966o = this.f7965n + f7952m;
        this.f7956d = EnumC1306a.REL_DRAG;
        this.f7967p = this.f7962j - this.f7953a;
        requestLayout();
    }

    private float getRelRatio() {
        if (System.currentTimeMillis() >= this.f7966o) {
            return 1.0f;
        }
        return Math.min((System.currentTimeMillis() - this.f7965n) / f7952m, 1.0f);
    }

    public void setOnViewAniDone(InterfaceC1307b interfaceC1307b) {
        this.f7968q = interfaceC1307b;
    }

    public void setAniBackColor(int i) {
        this.f7957e.setColor(i);
    }

    public void setAniForeColor(int i) {
        this.f7958f.setColor(i);
        this.f7959g.setColor(i);
        setBackgroundColor(i);
    }
}
