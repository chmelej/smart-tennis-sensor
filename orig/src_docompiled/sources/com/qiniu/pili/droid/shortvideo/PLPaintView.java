package com.qiniu.pili.droid.shortvideo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class PLPaintView extends View {

    /* JADX INFO: renamed from: a */
    private Bitmap f9025a;

    /* JADX INFO: renamed from: b */
    private Canvas f9026b;

    /* JADX INFO: renamed from: c */
    private Paint f9027c;

    /* JADX INFO: renamed from: d */
    private Path f9028d;

    /* JADX INFO: renamed from: e */
    private boolean f9029e;

    /* JADX INFO: renamed from: f */
    private int f9030f;

    /* JADX INFO: renamed from: g */
    private int f9031g;

    /* JADX INFO: renamed from: h */
    private float f9032h;

    /* JADX INFO: renamed from: i */
    private float f9033i;

    /* JADX INFO: renamed from: j */
    private LinkedList<C1588a> f9034j;

    public PLPaintView(Context context) {
        super(context);
        this.f9027c = new Paint();
        this.f9028d = new Path();
        this.f9029e = true;
        this.f9034j = new LinkedList<>();
        m8624a();
    }

    public void setPaintColor(int i) {
        this.f9027c.setColor(i);
    }

    public void setPaintSize(int i) {
        this.f9027c.setStrokeWidth(i);
    }

    public void setPaint(Paint paint) {
        this.f9027c = paint;
    }

    public void setPaintEnable(boolean z) {
        this.f9029e = z;
    }

    /* JADX INFO: renamed from: a */
    private void m8624a() {
        this.f9027c.setAntiAlias(true);
        this.f9027c.setDither(true);
        this.f9027c.setStrokeJoin(Paint.Join.ROUND);
        this.f9027c.setStrokeCap(Paint.Cap.ROUND);
        this.f9027c.setColor(-16777216);
        this.f9027c.setStyle(Paint.Style.STROKE);
        this.f9027c.setStrokeWidth(10.0f);
    }

    /* JADX INFO: renamed from: b */
    private void m8625b() {
        int width = getWidth();
        int height = getHeight();
        boolean z = false;
        boolean z2 = this.f9030f != 0 && this.f9030f < width;
        if (this.f9031g != 0 && this.f9031g < height) {
            z = true;
        }
        if (z2) {
            width = this.f9030f;
        }
        this.f9030f = width;
        if (z) {
            height = this.f9031g;
        }
        this.f9031g = height;
        this.f9025a = Bitmap.createBitmap(this.f9030f, this.f9031g, Bitmap.Config.ARGB_8888);
        this.f9026b = new Canvas(this.f9025a);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f9025a != null) {
            canvas.drawBitmap(this.f9025a, 0.0f, 0.0f, (Paint) null);
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.f9029e) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int actionIndex = motionEvent.getActionIndex();
        switch (action) {
            case 0:
                this.f9032h = x;
                this.f9033i = y;
                this.f9028d.moveTo(x, y);
                return true;
            case 1:
                m8626c();
                this.f9028d.reset();
                return true;
            case 2:
                if (motionEvent.getPointerId(actionIndex) != 1) {
                    if (this.f9025a == null) {
                        m8625b();
                    }
                    float fAbs = Math.abs(x - this.f9032h);
                    float fAbs2 = Math.abs(this.f9033i - y);
                    if (fAbs >= 3.0f || fAbs2 >= 3.0f) {
                        this.f9028d.quadTo(this.f9032h, this.f9033i, (this.f9032h + x) / 2.0f, (this.f9033i + y) / 2.0f);
                        this.f9026b.drawPath(this.f9028d, this.f9027c);
                        invalidate();
                        this.f9032h = x;
                        this.f9033i = y;
                    }
                }
                return true;
            default:
                return true;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m8626c() {
        this.f9034j.add(new C1588a(new Paint(this.f9027c), new Path(this.f9028d)));
    }

    /* JADX INFO: renamed from: com.qiniu.pili.droid.shortvideo.PLPaintView$a */
    class C1588a {

        /* JADX INFO: renamed from: b */
        private Paint f9036b;

        /* JADX INFO: renamed from: c */
        private Path f9037c;

        public C1588a(Paint paint, Path path) {
            this.f9036b = paint;
            this.f9037c = path;
        }
    }
}
