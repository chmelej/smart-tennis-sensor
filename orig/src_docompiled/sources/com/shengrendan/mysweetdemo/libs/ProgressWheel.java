package com.shengrendan.mysweetdemo.libs;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import com.coollang.tennis.R;

/* JADX INFO: loaded from: classes.dex */
public class ProgressWheel extends View {

    /* JADX INFO: renamed from: a */
    private static final String f9045a = "ProgressWheel";

    /* JADX INFO: renamed from: b */
    private final int f9046b;

    /* JADX INFO: renamed from: c */
    private final int f9047c;

    /* JADX INFO: renamed from: d */
    private final long f9048d;

    /* JADX INFO: renamed from: e */
    private int f9049e;

    /* JADX INFO: renamed from: f */
    private int f9050f;

    /* JADX INFO: renamed from: g */
    private int f9051g;

    /* JADX INFO: renamed from: h */
    private boolean f9052h;

    /* JADX INFO: renamed from: i */
    private double f9053i;

    /* JADX INFO: renamed from: j */
    private double f9054j;

    /* JADX INFO: renamed from: k */
    private float f9055k;

    /* JADX INFO: renamed from: l */
    private boolean f9056l;

    /* JADX INFO: renamed from: m */
    private long f9057m;

    /* JADX INFO: renamed from: n */
    private int f9058n;

    /* JADX INFO: renamed from: o */
    private int f9059o;

    /* JADX INFO: renamed from: p */
    private Paint f9060p;

    /* JADX INFO: renamed from: q */
    private Paint f9061q;

    /* JADX INFO: renamed from: r */
    private RectF f9062r;

    /* JADX INFO: renamed from: s */
    private float f9063s;

    /* JADX INFO: renamed from: t */
    private long f9064t;

    /* JADX INFO: renamed from: u */
    private boolean f9065u;

    /* JADX INFO: renamed from: v */
    private float f9066v;

    /* JADX INFO: renamed from: w */
    private float f9067w;

    /* JADX INFO: renamed from: x */
    private boolean f9068x;

    /* JADX INFO: renamed from: y */
    private InterfaceC1591a f9069y;

    /* JADX INFO: renamed from: z */
    private boolean f9070z;

    /* JADX INFO: renamed from: com.shengrendan.mysweetdemo.libs.ProgressWheel$a */
    public interface InterfaceC1591a {
        /* JADX INFO: renamed from: a */
        void m8656a(float f);
    }

    public ProgressWheel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9046b = 16;
        this.f9047c = 270;
        this.f9048d = 200L;
        this.f9049e = 28;
        this.f9050f = 4;
        this.f9051g = 4;
        this.f9052h = false;
        this.f9053i = 0.0d;
        this.f9054j = 460.0d;
        this.f9055k = 0.0f;
        this.f9056l = true;
        this.f9057m = 0L;
        this.f9058n = -1442840576;
        this.f9059o = 1978690;
        this.f9060p = new Paint();
        this.f9061q = new Paint();
        this.f9062r = new RectF();
        this.f9063s = 230.0f;
        this.f9064t = 0L;
        this.f9066v = 0.0f;
        this.f9067w = 0.0f;
        this.f9068x = false;
        m8647a(context.obtainStyledAttributes(attributeSet, R.styleable.ProgressWheel));
        m8648d();
    }

    public ProgressWheel(Context context) {
        super(context);
        this.f9046b = 16;
        this.f9047c = 270;
        this.f9048d = 200L;
        this.f9049e = 28;
        this.f9050f = 4;
        this.f9051g = 4;
        this.f9052h = false;
        this.f9053i = 0.0d;
        this.f9054j = 460.0d;
        this.f9055k = 0.0f;
        this.f9056l = true;
        this.f9057m = 0L;
        this.f9058n = -1442840576;
        this.f9059o = 1978690;
        this.f9060p = new Paint();
        this.f9061q = new Paint();
        this.f9062r = new RectF();
        this.f9063s = 230.0f;
        this.f9064t = 0L;
        this.f9066v = 0.0f;
        this.f9067w = 0.0f;
        this.f9068x = false;
        m8648d();
    }

    @TargetApi(17)
    /* JADX INFO: renamed from: d */
    private void m8648d() {
        float f;
        if (Build.VERSION.SDK_INT >= 17) {
            f = Settings.Global.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        } else {
            f = Settings.System.getFloat(getContext().getContentResolver(), "animator_duration_scale", 1.0f);
        }
        this.f9070z = f != 0.0f;
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int paddingLeft = this.f9049e + getPaddingLeft() + getPaddingRight();
        int paddingTop = this.f9049e + getPaddingTop() + getPaddingBottom();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            paddingLeft = size;
        } else if (mode == Integer.MIN_VALUE) {
            paddingLeft = Math.min(paddingLeft, size);
        }
        if (mode2 == 1073741824 || mode == 1073741824) {
            paddingTop = size2;
        } else if (mode2 == Integer.MIN_VALUE) {
            paddingTop = Math.min(paddingTop, size2);
        }
        setMeasuredDimension(paddingLeft, paddingTop);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        m8645a(i, i2);
        m8649e();
        invalidate();
    }

    /* JADX INFO: renamed from: e */
    private void m8649e() {
        this.f9060p.setColor(this.f9058n);
        this.f9060p.setAntiAlias(true);
        this.f9060p.setStyle(Paint.Style.STROKE);
        this.f9060p.setStrokeWidth(this.f9050f);
        this.f9061q.setColor(this.f9059o);
        this.f9061q.setAntiAlias(true);
        this.f9061q.setStyle(Paint.Style.STROKE);
        this.f9061q.setStrokeWidth(this.f9051g);
    }

    /* JADX INFO: renamed from: a */
    private void m8645a(int i, int i2) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        if (!this.f9052h) {
            int i3 = (i - paddingLeft) - paddingRight;
            int iMin = Math.min(Math.min(i3, (i2 - paddingBottom) - paddingTop), (this.f9049e * 2) - (this.f9050f * 2));
            int i4 = ((i3 - iMin) / 2) + paddingLeft;
            int i5 = ((((i2 - paddingTop) - paddingBottom) - iMin) / 2) + paddingTop;
            this.f9062r = new RectF(this.f9050f + i4, this.f9050f + i5, (i4 + iMin) - this.f9050f, (i5 + iMin) - this.f9050f);
            return;
        }
        this.f9062r = new RectF(paddingLeft + this.f9050f, paddingTop + this.f9050f, (i - paddingRight) - this.f9050f, (i2 - paddingBottom) - this.f9050f);
    }

    /* JADX INFO: renamed from: a */
    private void m8647a(TypedArray typedArray) {
        DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
        this.f9050f = (int) TypedValue.applyDimension(1, this.f9050f, displayMetrics);
        this.f9051g = (int) TypedValue.applyDimension(1, this.f9051g, displayMetrics);
        this.f9049e = (int) TypedValue.applyDimension(1, this.f9049e, displayMetrics);
        this.f9049e = (int) typedArray.getDimension(3, this.f9049e);
        this.f9052h = typedArray.getBoolean(4, false);
        this.f9050f = (int) typedArray.getDimension(2, this.f9050f);
        this.f9051g = (int) typedArray.getDimension(8, this.f9051g);
        this.f9063s = typedArray.getFloat(9, this.f9063s / 360.0f) * 360.0f;
        this.f9054j = typedArray.getInt(1, (int) this.f9054j);
        this.f9058n = typedArray.getColor(0, this.f9058n);
        this.f9059o = typedArray.getColor(7, this.f9059o);
        this.f9065u = typedArray.getBoolean(5, false);
        if (typedArray.getBoolean(6, false)) {
            m8653c();
        }
        typedArray.recycle();
    }

    public void setCallback(InterfaceC1591a interfaceC1591a) {
        this.f9069y = interfaceC1591a;
        if (this.f9068x) {
            return;
        }
        m8650f();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        float f;
        float f2;
        super.onDraw(canvas);
        canvas.drawArc(this.f9062r, 360.0f, 360.0f, false, this.f9061q);
        if (this.f9070z) {
            float fPow = 0.0f;
            boolean z = true;
            if (this.f9068x) {
                long jUptimeMillis = SystemClock.uptimeMillis() - this.f9064t;
                float f3 = (jUptimeMillis * this.f9063s) / 1000.0f;
                m8646a(jUptimeMillis);
                this.f9066v += f3;
                if (this.f9066v > 360.0f) {
                    this.f9066v -= 360.0f;
                    m8644a(-1.0f);
                }
                this.f9064t = SystemClock.uptimeMillis();
                float f4 = this.f9066v - 90.0f;
                float f5 = this.f9055k + 16.0f;
                if (isInEditMode()) {
                    f = 0.0f;
                    f2 = 135.0f;
                } else {
                    f = f4;
                    f2 = f5;
                }
                canvas.drawArc(this.f9062r, f, f2, false, this.f9060p);
            } else {
                float f6 = this.f9066v;
                if (this.f9066v != this.f9067w) {
                    this.f9066v = Math.min(this.f9066v + (((SystemClock.uptimeMillis() - this.f9064t) / 1000.0f) * this.f9063s), this.f9067w);
                    this.f9064t = SystemClock.uptimeMillis();
                } else {
                    z = false;
                }
                if (f6 != this.f9066v) {
                    m8650f();
                }
                float fPow2 = this.f9066v;
                if (!this.f9065u) {
                    fPow = ((float) (1.0d - Math.pow(1.0f - (this.f9066v / 360.0f), 4.0f))) * 360.0f;
                    fPow2 = ((float) (1.0d - Math.pow(1.0f - (this.f9066v / 360.0f), 2.0f))) * 360.0f;
                }
                canvas.drawArc(this.f9062r, fPow - 90.0f, isInEditMode() ? 360.0f : fPow2, false, this.f9060p);
            }
            if (z) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (i == 0) {
            this.f9064t = SystemClock.uptimeMillis();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8646a(long j) {
        if (this.f9057m >= 200) {
            this.f9053i += j;
            if (this.f9053i > this.f9054j) {
                this.f9053i -= this.f9054j;
                this.f9057m = 0L;
                this.f9056l = !this.f9056l;
            }
            float fCos = (((float) Math.cos(((this.f9053i / this.f9054j) + 1.0d) * 3.141592653589793d)) / 2.0f) + 0.5f;
            if (this.f9056l) {
                this.f9055k = fCos * 254.0f;
                return;
            }
            float f = (1.0f - fCos) * 254.0f;
            this.f9066v += this.f9055k - f;
            this.f9055k = f;
            return;
        }
        this.f9057m += j;
    }

    /* JADX INFO: renamed from: a */
    public boolean m8651a() {
        return this.f9068x;
    }

    /* JADX INFO: renamed from: b */
    public void m8652b() {
        this.f9068x = false;
        this.f9066v = 0.0f;
        this.f9067w = 0.0f;
        invalidate();
    }

    /* JADX INFO: renamed from: c */
    public void m8653c() {
        this.f9064t = SystemClock.uptimeMillis();
        this.f9068x = true;
        invalidate();
    }

    /* JADX INFO: renamed from: a */
    private void m8644a(float f) {
        if (this.f9069y != null) {
            this.f9069y.m8656a(f);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m8650f() {
        if (this.f9069y != null) {
            this.f9069y.m8656a(Math.round((this.f9066v * 100.0f) / 360.0f) / 100.0f);
        }
    }

    public void setInstantProgress(float f) {
        if (this.f9068x) {
            this.f9066v = 0.0f;
            this.f9068x = false;
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f == this.f9067w) {
            return;
        }
        this.f9067w = Math.min(f * 360.0f, 360.0f);
        this.f9066v = this.f9067w;
        this.f9064t = SystemClock.uptimeMillis();
        invalidate();
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        WheelSavedState wheelSavedState = new WheelSavedState(super.onSaveInstanceState());
        wheelSavedState.f9071a = this.f9066v;
        wheelSavedState.f9072b = this.f9067w;
        wheelSavedState.f9073c = this.f9068x;
        wheelSavedState.f9074d = this.f9063s;
        wheelSavedState.f9075e = this.f9050f;
        wheelSavedState.f9076f = this.f9058n;
        wheelSavedState.f9077g = this.f9051g;
        wheelSavedState.f9078h = this.f9059o;
        wheelSavedState.f9079i = this.f9049e;
        wheelSavedState.f9080j = this.f9065u;
        wheelSavedState.f9081k = this.f9052h;
        return wheelSavedState;
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof WheelSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        WheelSavedState wheelSavedState = (WheelSavedState) parcelable;
        super.onRestoreInstanceState(wheelSavedState.getSuperState());
        this.f9066v = wheelSavedState.f9071a;
        this.f9067w = wheelSavedState.f9072b;
        this.f9068x = wheelSavedState.f9073c;
        this.f9063s = wheelSavedState.f9074d;
        this.f9050f = wheelSavedState.f9075e;
        this.f9058n = wheelSavedState.f9076f;
        this.f9051g = wheelSavedState.f9077g;
        this.f9059o = wheelSavedState.f9078h;
        this.f9049e = wheelSavedState.f9079i;
        this.f9065u = wheelSavedState.f9080j;
        this.f9052h = wheelSavedState.f9081k;
        this.f9064t = SystemClock.uptimeMillis();
    }

    public float getProgress() {
        if (this.f9068x) {
            return -1.0f;
        }
        return this.f9066v / 360.0f;
    }

    public void setProgress(float f) {
        if (this.f9068x) {
            this.f9066v = 0.0f;
            this.f9068x = false;
            m8650f();
        }
        if (f > 1.0f) {
            f -= 1.0f;
        } else if (f < 0.0f) {
            f = 0.0f;
        }
        if (f == this.f9067w) {
            return;
        }
        if (this.f9066v == this.f9067w) {
            this.f9064t = SystemClock.uptimeMillis();
        }
        this.f9067w = Math.min(f * 360.0f, 360.0f);
        invalidate();
    }

    public void setLinearProgress(boolean z) {
        this.f9065u = z;
        if (this.f9068x) {
            return;
        }
        invalidate();
    }

    public int getCircleRadius() {
        return this.f9049e;
    }

    public void setCircleRadius(int i) {
        this.f9049e = i;
        if (this.f9068x) {
            return;
        }
        invalidate();
    }

    public int getBarWidth() {
        return this.f9050f;
    }

    public void setBarWidth(int i) {
        this.f9050f = i;
        if (this.f9068x) {
            return;
        }
        invalidate();
    }

    public int getBarColor() {
        return this.f9058n;
    }

    public void setBarColor(int i) {
        this.f9058n = i;
        m8649e();
        if (this.f9068x) {
            return;
        }
        invalidate();
    }

    public int getRimColor() {
        return this.f9059o;
    }

    public void setRimColor(int i) {
        this.f9059o = i;
        m8649e();
        if (this.f9068x) {
            return;
        }
        invalidate();
    }

    public float getSpinSpeed() {
        return this.f9063s / 360.0f;
    }

    public void setSpinSpeed(float f) {
        this.f9063s = f * 360.0f;
    }

    public int getRimWidth() {
        return this.f9051g;
    }

    public void setRimWidth(int i) {
        this.f9051g = i;
        if (this.f9068x) {
            return;
        }
        invalidate();
    }

    static class WheelSavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<WheelSavedState> CREATOR = new Parcelable.Creator<WheelSavedState>() { // from class: com.shengrendan.mysweetdemo.libs.ProgressWheel.WheelSavedState.1
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WheelSavedState createFromParcel(Parcel parcel) {
                return new WheelSavedState(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public WheelSavedState[] newArray(int i) {
                return new WheelSavedState[i];
            }
        };

        /* JADX INFO: renamed from: a */
        float f9071a;

        /* JADX INFO: renamed from: b */
        float f9072b;

        /* JADX INFO: renamed from: c */
        boolean f9073c;

        /* JADX INFO: renamed from: d */
        float f9074d;

        /* JADX INFO: renamed from: e */
        int f9075e;

        /* JADX INFO: renamed from: f */
        int f9076f;

        /* JADX INFO: renamed from: g */
        int f9077g;

        /* JADX INFO: renamed from: h */
        int f9078h;

        /* JADX INFO: renamed from: i */
        int f9079i;

        /* JADX INFO: renamed from: j */
        boolean f9080j;

        /* JADX INFO: renamed from: k */
        boolean f9081k;

        WheelSavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private WheelSavedState(Parcel parcel) {
            super(parcel);
            this.f9071a = parcel.readFloat();
            this.f9072b = parcel.readFloat();
            this.f9073c = parcel.readByte() != 0;
            this.f9074d = parcel.readFloat();
            this.f9075e = parcel.readInt();
            this.f9076f = parcel.readInt();
            this.f9077g = parcel.readInt();
            this.f9078h = parcel.readInt();
            this.f9079i = parcel.readInt();
            this.f9080j = parcel.readByte() != 0;
            this.f9081k = parcel.readByte() != 0;
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.f9071a);
            parcel.writeFloat(this.f9072b);
            parcel.writeByte(this.f9073c ? (byte) 1 : (byte) 0);
            parcel.writeFloat(this.f9074d);
            parcel.writeInt(this.f9075e);
            parcel.writeInt(this.f9076f);
            parcel.writeInt(this.f9077g);
            parcel.writeInt(this.f9078h);
            parcel.writeInt(this.f9079i);
            parcel.writeByte(this.f9080j ? (byte) 1 : (byte) 0);
            parcel.writeByte(this.f9081k ? (byte) 1 : (byte) 0);
        }
    }
}
