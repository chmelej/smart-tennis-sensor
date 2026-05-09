package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import p000.InterfaceC0194am;

/* JADX INFO: renamed from: al */
/* JADX INFO: compiled from: CircularRevealHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0185al {

    /* JADX INFO: renamed from: a */
    public static final int f1545a;

    /* JADX INFO: renamed from: b */
    private final a f1546b;

    /* JADX INFO: renamed from: c */
    private final View f1547c;

    /* JADX INFO: renamed from: d */
    private final Path f1548d;

    /* JADX INFO: renamed from: e */
    private final Paint f1549e;

    /* JADX INFO: renamed from: f */
    private final Paint f1550f;

    /* JADX INFO: renamed from: g */
    private InterfaceC0194am.d f1551g;

    /* JADX INFO: renamed from: h */
    private Drawable f1552h;

    /* JADX INFO: renamed from: i */
    private boolean f1553i;

    /* JADX INFO: renamed from: j */
    private boolean f1554j;

    /* JADX INFO: renamed from: al$a */
    /* JADX INFO: compiled from: CircularRevealHelper.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo1808a(Canvas canvas);

        /* JADX INFO: renamed from: c */
        boolean mo1809c();
    }

    static {
        if (Build.VERSION.SDK_INT >= 21) {
            f1545a = 2;
        } else if (Build.VERSION.SDK_INT >= 18) {
            f1545a = 1;
        } else {
            f1545a = 0;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0185al(a aVar) {
        this.f1546b = aVar;
        this.f1547c = (View) aVar;
        this.f1547c.setWillNotDraw(false);
        this.f1548d = new Path();
        this.f1549e = new Paint(7);
        this.f1550f = new Paint(1);
        this.f1550f.setColor(0);
    }

    /* JADX INFO: renamed from: a */
    public void m1798a() {
        if (f1545a == 0) {
            this.f1553i = true;
            this.f1554j = false;
            this.f1547c.buildDrawingCache();
            Bitmap drawingCache = this.f1547c.getDrawingCache();
            if (drawingCache == null && this.f1547c.getWidth() != 0 && this.f1547c.getHeight() != 0) {
                drawingCache = Bitmap.createBitmap(this.f1547c.getWidth(), this.f1547c.getHeight(), Bitmap.Config.ARGB_8888);
                this.f1547c.draw(new Canvas(drawingCache));
            }
            if (drawingCache != null) {
                this.f1549e.setShader(new BitmapShader(drawingCache, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            }
            this.f1553i = false;
            this.f1554j = true;
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1803b() {
        if (f1545a == 0) {
            this.f1554j = false;
            this.f1547c.destroyDrawingCache();
            this.f1549e.setShader(null);
            this.f1547c.invalidate();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1800a(InterfaceC0194am.d dVar) {
        if (dVar == null) {
            this.f1551g = null;
        } else {
            if (this.f1551g == null) {
                this.f1551g = new InterfaceC0194am.d(dVar);
            } else {
                this.f1551g.m1920a(dVar);
            }
            if (C0773bo.m5674b(dVar.f1696c, m1792b(dVar), 1.0E-4f)) {
                this.f1551g.f1696c = Float.MAX_VALUE;
            }
        }
        m1794g();
    }

    /* JADX INFO: renamed from: c */
    public InterfaceC0194am.d m1804c() {
        if (this.f1551g == null) {
            return null;
        }
        InterfaceC0194am.d dVar = new InterfaceC0194am.d(this.f1551g);
        if (dVar.m1921a()) {
            dVar.f1696c = m1792b(dVar);
        }
        return dVar;
    }

    /* JADX INFO: renamed from: a */
    public void m1799a(int i) {
        this.f1550f.setColor(i);
        this.f1547c.invalidate();
    }

    /* JADX INFO: renamed from: d */
    public int m1805d() {
        return this.f1550f.getColor();
    }

    /* JADX INFO: renamed from: e */
    public Drawable m1806e() {
        return this.f1552h;
    }

    /* JADX INFO: renamed from: a */
    public void m1802a(Drawable drawable) {
        this.f1552h = drawable;
        this.f1547c.invalidate();
    }

    /* JADX INFO: renamed from: g */
    private void m1794g() {
        if (f1545a == 1) {
            this.f1548d.rewind();
            if (this.f1551g != null) {
                this.f1548d.addCircle(this.f1551g.f1694a, this.f1551g.f1695b, this.f1551g.f1696c, Path.Direction.CW);
            }
        }
        this.f1547c.invalidate();
    }

    /* JADX INFO: renamed from: b */
    private float m1792b(InterfaceC0194am.d dVar) {
        return C0773bo.m5672a(dVar.f1694a, dVar.f1695b, 0.0f, 0.0f, this.f1547c.getWidth(), this.f1547c.getHeight());
    }

    /* JADX INFO: renamed from: a */
    public void m1801a(Canvas canvas) {
        if (m1795h()) {
            switch (f1545a) {
                case 0:
                    canvas.drawCircle(this.f1551g.f1694a, this.f1551g.f1695b, this.f1551g.f1696c, this.f1549e);
                    if (m1796i()) {
                        canvas.drawCircle(this.f1551g.f1694a, this.f1551g.f1695b, this.f1551g.f1696c, this.f1550f);
                    }
                    break;
                case 1:
                    int iSave = canvas.save();
                    canvas.clipPath(this.f1548d);
                    this.f1546b.mo1808a(canvas);
                    if (m1796i()) {
                        canvas.drawRect(0.0f, 0.0f, this.f1547c.getWidth(), this.f1547c.getHeight(), this.f1550f);
                    }
                    canvas.restoreToCount(iSave);
                    break;
                case 2:
                    this.f1546b.mo1808a(canvas);
                    if (m1796i()) {
                        canvas.drawRect(0.0f, 0.0f, this.f1547c.getWidth(), this.f1547c.getHeight(), this.f1550f);
                    }
                    break;
                default:
                    throw new IllegalStateException("Unsupported strategy " + f1545a);
            }
        } else {
            this.f1546b.mo1808a(canvas);
            if (m1796i()) {
                canvas.drawRect(0.0f, 0.0f, this.f1547c.getWidth(), this.f1547c.getHeight(), this.f1550f);
            }
        }
        m1793b(canvas);
    }

    /* JADX INFO: renamed from: b */
    private void m1793b(Canvas canvas) {
        if (m1797j()) {
            Rect bounds = this.f1552h.getBounds();
            float fWidth = this.f1551g.f1694a - (bounds.width() / 2.0f);
            float fHeight = this.f1551g.f1695b - (bounds.height() / 2.0f);
            canvas.translate(fWidth, fHeight);
            this.f1552h.draw(canvas);
            canvas.translate(-fWidth, -fHeight);
        }
    }

    /* JADX INFO: renamed from: f */
    public boolean m1807f() {
        return this.f1546b.mo1809c() && !m1795h();
    }

    /* JADX INFO: renamed from: h */
    private boolean m1795h() {
        boolean z = this.f1551g == null || this.f1551g.m1921a();
        return f1545a == 0 ? !z && this.f1554j : !z;
    }

    /* JADX INFO: renamed from: i */
    private boolean m1796i() {
        return (this.f1553i || Color.alpha(this.f1550f.getColor()) == 0) ? false : true;
    }

    /* JADX INFO: renamed from: j */
    private boolean m1797j() {
        return (this.f1553i || this.f1552h == null || this.f1551g == null) ? false : true;
    }
}
