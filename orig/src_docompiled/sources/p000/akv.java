package p000;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: compiled from: DefaultBlurController.java */
/* JADX INFO: loaded from: classes.dex */
public class akv implements aku {

    /* JADX INFO: renamed from: a */
    private static final String f1511a = "akv";

    /* JADX INFO: renamed from: g */
    private Canvas f1517g;

    /* JADX INFO: renamed from: h */
    private Bitmap f1518h;

    /* JADX INFO: renamed from: i */
    private View f1519i;

    /* JADX INFO: renamed from: j */
    private View f1520j;

    /* JADX INFO: renamed from: l */
    private boolean f1522l;

    /* JADX INFO: renamed from: n */
    private Drawable f1524n;

    /* JADX INFO: renamed from: b */
    private final float f1512b = 8.0f;

    /* JADX INFO: renamed from: c */
    private float f1513c = 16.0f;

    /* JADX INFO: renamed from: d */
    private float f1514d = 1.0f;

    /* JADX INFO: renamed from: e */
    private float f1515e = 1.0f;

    /* JADX INFO: renamed from: k */
    private ViewTreeObserver.OnPreDrawListener f1521k = new ViewTreeObserver.OnPreDrawListener() { // from class: akv.1
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            if (akv.this.f1522l) {
                return true;
            }
            akv.this.m1768e();
            return true;
        }
    };

    /* JADX INFO: renamed from: m */
    private final Runnable f1523m = new Runnable() { // from class: akv.2
        @Override // java.lang.Runnable
        public void run() {
            akv.this.f1522l = false;
        }
    };

    /* JADX INFO: renamed from: f */
    private akt f1516f = new akx(true);

    public akv(View view, View view2) {
        this.f1520j = view2;
        this.f1519i = view;
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        if (m1764b(measuredWidth, measuredHeight)) {
            m1769f();
        } else {
            m1758a(measuredWidth, measuredHeight);
        }
    }

    /* JADX INFO: renamed from: b */
    private int m1762b(float f) {
        return (int) Math.ceil(f / 8.0f);
    }

    /* JADX INFO: renamed from: a */
    private int m1757a(int i) {
        int i2 = i % 16;
        return i2 == 0 ? i : (i - i2) + 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m1758a(int i, int i2) {
        if (m1764b(i, i2)) {
            this.f1519i.setWillNotDraw(true);
            mo1752b();
        } else {
            this.f1519i.setWillNotDraw(false);
            m1766c(i, i2);
            this.f1517g = new Canvas(this.f1518h);
            mo1754c();
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m1764b(int i, int i2) {
        return m1762b((float) i2) == 0 || m1762b((float) i) == 0;
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: b */
    public void mo1752b() {
        this.f1520j.getViewTreeObserver().removeOnPreDrawListener(this.f1521k);
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: c */
    public void mo1754c() {
        mo1752b();
        this.f1520j.getViewTreeObserver().addOnPreDrawListener(this.f1521k);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m1768e() {
        this.f1522l = true;
        this.f1519i.invalidate();
    }

    /* JADX INFO: renamed from: f */
    private void m1769f() {
        this.f1519i.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: akv.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT >= 16) {
                    akv.this.f1519i.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                } else {
                    akv.this.f1519i.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
                akv.this.m1758a(akv.this.f1519i.getMeasuredWidth(), akv.this.f1519i.getMeasuredHeight());
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m1766c(int i, int i2) {
        int iM1762b = m1762b(i);
        int iM1762b2 = m1762b(i2);
        int iM1757a = m1757a(iM1762b);
        int iM1757a2 = m1757a(iM1762b2);
        this.f1515e = iM1762b2 / iM1757a2;
        this.f1514d = iM1762b / iM1757a;
        this.f1518h = Bitmap.createBitmap(iM1757a, iM1757a2, this.f1516f.mo1746b());
    }

    /* JADX INFO: renamed from: g */
    private void m1770g() {
        float f = this.f1514d * 8.0f;
        float f2 = this.f1515e * 8.0f;
        this.f1517g.translate(((-this.f1519i.getLeft()) / f) - (this.f1519i.getTranslationX() / f), ((-this.f1519i.getTop()) / f2) - (this.f1519i.getTranslationY() / f2));
        this.f1517g.scale(1.0f / f, 1.0f / f2);
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: a */
    public boolean mo1751a(Canvas canvas) {
        return this.f1517g == canvas;
    }

    /* JADX INFO: renamed from: h */
    private void m1771h() {
        if (this.f1524n != null) {
            this.f1524n.draw(this.f1517g);
        }
        this.f1520j.draw(this.f1517g);
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: b */
    public void mo1753b(Canvas canvas) {
        this.f1522l = true;
        this.f1517g.save();
        m1770g();
        m1771h();
        this.f1517g.restore();
        m1772i();
        m1767d(canvas);
    }

    /* JADX INFO: renamed from: d */
    private void m1767d(Canvas canvas) {
        canvas.save();
        canvas.scale(this.f1514d * 8.0f, this.f1515e * 8.0f);
        canvas.drawBitmap(this.f1518h, 0.0f, 0.0f, (Paint) null);
        canvas.restore();
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: c */
    public void mo1755c(Canvas canvas) {
        this.f1519i.post(this.f1523m);
    }

    /* JADX INFO: renamed from: i */
    private void m1772i() {
        this.f1518h = this.f1516f.mo1744a(this.f1518h, this.f1513c);
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: a */
    public void mo1747a() {
        m1758a(this.f1519i.getMeasuredWidth(), this.f1519i.getMeasuredHeight());
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: d */
    public void mo1756d() {
        mo1752b();
        this.f1516f.mo1745a();
        if (this.f1518h != null) {
            this.f1518h.recycle();
        }
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: a */
    public void mo1748a(float f) {
        this.f1513c = f;
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: a */
    public void mo1749a(akt aktVar) {
        this.f1516f = aktVar;
    }

    @Override // p000.aku
    /* JADX INFO: renamed from: a */
    public void mo1750a(Drawable drawable) {
        this.f1524n = drawable;
    }
}
