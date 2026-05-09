package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.util.AttributeSet;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ControlRippleView extends View {

    /* JADX INFO: renamed from: a */
    private final int f8214a;

    /* JADX INFO: renamed from: b */
    private final int f8215b;

    /* JADX INFO: renamed from: c */
    private final int f8216c;

    /* JADX INFO: renamed from: d */
    private int f8217d;

    /* JADX INFO: renamed from: e */
    private int f8218e;

    /* JADX INFO: renamed from: f */
    private String f8219f;

    /* JADX INFO: renamed from: g */
    private String f8220g;

    /* JADX INFO: renamed from: h */
    private String f8221h;

    /* JADX INFO: renamed from: i */
    private String f8222i;

    /* JADX INFO: renamed from: j */
    private int f8223j;

    /* JADX INFO: renamed from: k */
    private Paint f8224k;

    /* JADX INFO: renamed from: l */
    private boolean f8225l;

    /* JADX INFO: renamed from: m */
    private int f8226m;

    /* JADX INFO: renamed from: n */
    private float f8227n;

    /* JADX INFO: renamed from: o */
    private float f8228o;

    /* JADX INFO: renamed from: p */
    private RectF f8229p;

    /* JADX INFO: renamed from: q */
    private int f8230q;

    /* JADX INFO: renamed from: r */
    private Handler f8231r;

    /* JADX INFO: renamed from: c */
    static /* synthetic */ int m8100c(ControlRippleView controlRippleView) {
        int i = controlRippleView.f8230q;
        controlRippleView.f8230q = i + 1;
        return i;
    }

    public ControlRippleView(Context context) {
        super(context);
        this.f8214a = PointerIconCompat.TYPE_HAND;
        this.f8215b = PointerIconCompat.TYPE_CONTEXT_MENU;
        this.f8216c = 2001;
        this.f8219f = "#ffffff";
        this.f8220g = "#25c9ad";
        this.f8221h = "#4425c9ad";
        this.f8222i = "#9925c9ad";
        this.f8223j = 3000;
        this.f8225l = false;
        this.f8230q = 0;
        this.f8231r = new Handler() { // from class: com.coollang.tennis.widget.ControlRippleView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1001) {
                    if (ControlRippleView.this.f8225l) {
                        ControlRippleView.this.f8231r.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CONTEXT_MENU, 16L);
                    }
                    ControlRippleView.m8100c(ControlRippleView.this);
                    ControlRippleView.this.invalidate();
                    return;
                }
                if (i != 2001) {
                    return;
                }
                ControlRippleView.this.f8225l = false;
                ControlRippleView.this.f8231r.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
                ControlRippleView.this.f8226m = 2001;
                ControlRippleView.this.invalidate();
            }
        };
        m8101d();
    }

    public ControlRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8214a = PointerIconCompat.TYPE_HAND;
        this.f8215b = PointerIconCompat.TYPE_CONTEXT_MENU;
        this.f8216c = 2001;
        this.f8219f = "#ffffff";
        this.f8220g = "#25c9ad";
        this.f8221h = "#4425c9ad";
        this.f8222i = "#9925c9ad";
        this.f8223j = 3000;
        this.f8225l = false;
        this.f8230q = 0;
        this.f8231r = new Handler() { // from class: com.coollang.tennis.widget.ControlRippleView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i = message.what;
                if (i == 1001) {
                    if (ControlRippleView.this.f8225l) {
                        ControlRippleView.this.f8231r.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CONTEXT_MENU, 16L);
                    }
                    ControlRippleView.m8100c(ControlRippleView.this);
                    ControlRippleView.this.invalidate();
                    return;
                }
                if (i != 2001) {
                    return;
                }
                ControlRippleView.this.f8225l = false;
                ControlRippleView.this.f8231r.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
                ControlRippleView.this.f8226m = 2001;
                ControlRippleView.this.invalidate();
            }
        };
        m8101d();
    }

    public ControlRippleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8214a = PointerIconCompat.TYPE_HAND;
        this.f8215b = PointerIconCompat.TYPE_CONTEXT_MENU;
        this.f8216c = 2001;
        this.f8219f = "#ffffff";
        this.f8220g = "#25c9ad";
        this.f8221h = "#4425c9ad";
        this.f8222i = "#9925c9ad";
        this.f8223j = 3000;
        this.f8225l = false;
        this.f8230q = 0;
        this.f8231r = new Handler() { // from class: com.coollang.tennis.widget.ControlRippleView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i2 = message.what;
                if (i2 == 1001) {
                    if (ControlRippleView.this.f8225l) {
                        ControlRippleView.this.f8231r.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CONTEXT_MENU, 16L);
                    }
                    ControlRippleView.m8100c(ControlRippleView.this);
                    ControlRippleView.this.invalidate();
                    return;
                }
                if (i2 != 2001) {
                    return;
                }
                ControlRippleView.this.f8225l = false;
                ControlRippleView.this.f8231r.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
                ControlRippleView.this.f8226m = 2001;
                ControlRippleView.this.invalidate();
            }
        };
        m8101d();
    }

    @TargetApi(21)
    public ControlRippleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8214a = PointerIconCompat.TYPE_HAND;
        this.f8215b = PointerIconCompat.TYPE_CONTEXT_MENU;
        this.f8216c = 2001;
        this.f8219f = "#ffffff";
        this.f8220g = "#25c9ad";
        this.f8221h = "#4425c9ad";
        this.f8222i = "#9925c9ad";
        this.f8223j = 3000;
        this.f8225l = false;
        this.f8230q = 0;
        this.f8231r = new Handler() { // from class: com.coollang.tennis.widget.ControlRippleView.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
                int i22 = message.what;
                if (i22 == 1001) {
                    if (ControlRippleView.this.f8225l) {
                        ControlRippleView.this.f8231r.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CONTEXT_MENU, 16L);
                    }
                    ControlRippleView.m8100c(ControlRippleView.this);
                    ControlRippleView.this.invalidate();
                    return;
                }
                if (i22 != 2001) {
                    return;
                }
                ControlRippleView.this.f8225l = false;
                ControlRippleView.this.f8231r.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
                ControlRippleView.this.f8226m = 2001;
                ControlRippleView.this.invalidate();
            }
        };
        m8101d();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f8217d = View.MeasureSpec.getSize(i);
        this.f8218e = View.MeasureSpec.getSize(i2);
        if (this.f8218e < 200) {
            this.f8218e = 200;
        }
        setMeasuredDimension(this.f8217d, this.f8218e);
    }

    /* JADX INFO: renamed from: d */
    private void m8101d() {
        this.f8224k = new Paint();
        this.f8224k.setColor(Color.parseColor(this.f8220g));
        this.f8224k.setAntiAlias(true);
        this.f8226m = 0;
        this.f8230q = 0;
        this.f8229p = new RectF(0.0f, 0.0f, this.f8217d, this.f8218e);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f8227n = this.f8217d / 2.0f;
        this.f8228o = this.f8218e / 2.0f;
        int i = this.f8226m;
        if (i != 2001) {
            switch (i) {
                case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                    this.f8224k.setColor(Color.parseColor(this.f8221h));
                    canvas.drawCircle(this.f8227n, this.f8228o, (this.f8217d * (this.f8230q + 10)) / 100.0f, this.f8224k);
                    this.f8224k.setColor(Color.parseColor(this.f8222i));
                    canvas.drawCircle(this.f8227n, this.f8228o, (this.f8217d * this.f8230q) / 100.0f, this.f8224k);
                    this.f8224k.setColor(Color.parseColor(this.f8220g));
                    canvas.drawCircle(this.f8227n, this.f8228o, (this.f8217d * (this.f8230q - 10)) / 100.0f, this.f8224k);
                    break;
                case PointerIconCompat.TYPE_HAND /* 1002 */:
                    canvas.drawColor(0, PorterDuff.Mode.CLEAR);
                    break;
            }
        }
        setBackgroundColor(Color.parseColor(this.f8220g));
    }

    /* JADX INFO: renamed from: a */
    public void m8102a() {
        this.f8230q = 0;
        this.f8225l = true;
        this.f8226m = PointerIconCompat.TYPE_CONTEXT_MENU;
        setBackgroundColor(Color.parseColor(this.f8219f));
        this.f8231r.sendEmptyMessage(PointerIconCompat.TYPE_CONTEXT_MENU);
    }

    /* JADX INFO: renamed from: b */
    public void m8103b() {
        this.f8225l = false;
        this.f8231r.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
        this.f8226m = 0;
        invalidate();
    }

    /* JADX INFO: renamed from: c */
    public void m8104c() {
        this.f8225l = false;
        this.f8231r.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
        this.f8226m = 0;
        invalidate();
    }
}
