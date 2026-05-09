package p000;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.SystemClock;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.util.SparseArray;

/* JADX INFO: renamed from: eg */
/* JADX INFO: compiled from: DrawableContainer.java */
/* JADX INFO: loaded from: classes.dex */
class C1686eg extends Drawable implements Drawable.Callback {

    /* JADX INFO: renamed from: a */
    private b f9536a;

    /* JADX INFO: renamed from: b */
    private Rect f9537b;

    /* JADX INFO: renamed from: c */
    private Drawable f9538c;

    /* JADX INFO: renamed from: d */
    private Drawable f9539d;

    /* JADX INFO: renamed from: f */
    private boolean f9541f;

    /* JADX INFO: renamed from: i */
    private boolean f9544i;

    /* JADX INFO: renamed from: j */
    private Runnable f9545j;

    /* JADX INFO: renamed from: k */
    private long f9546k;

    /* JADX INFO: renamed from: l */
    private long f9547l;

    /* JADX INFO: renamed from: m */
    private a f9548m;

    /* JADX INFO: renamed from: e */
    private int f9540e = 255;

    /* JADX INFO: renamed from: g */
    private int f9542g = -1;

    /* JADX INFO: renamed from: h */
    private int f9543h = -1;

    C1686eg() {
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f9538c != null) {
            this.f9538c.draw(canvas);
        }
        if (this.f9539d != null) {
            this.f9539d.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f9536a.getChangingConfigurations();
    }

    @SuppressLint({"WrongConstant"})
    @TargetApi(23)
    /* JADX INFO: renamed from: a */
    private boolean m9008a() {
        return isAutoMirrored() && getLayoutDirection() == 1;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        boolean padding;
        Rect rectM9029e = this.f9536a.m9029e();
        if (rectM9029e != null) {
            rect.set(rectM9029e);
            padding = (rectM9029e.right | ((rectM9029e.left | rectM9029e.top) | rectM9029e.bottom)) != 0;
        } else if (this.f9538c != null) {
            padding = this.f9538c.getPadding(rect);
        } else {
            padding = super.getPadding(rect);
        }
        if (m9008a()) {
            int i = rect.left;
            rect.left = rect.right;
            rect.right = i;
        }
        return padding;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.f9538c != null) {
            this.f9538c.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f9541f && this.f9540e == i) {
            return;
        }
        this.f9541f = true;
        this.f9540e = i;
        if (this.f9538c != null) {
            if (this.f9546k == 0) {
                this.f9538c.setAlpha(i);
            } else {
                m9010a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f9540e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        if (this.f9536a.f9585z != z) {
            this.f9536a.f9585z = z;
            if (this.f9538c != null) {
                this.f9538c.setDither(this.f9536a.f9585z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f9536a.f9557G = true;
        if (this.f9536a.f9556F != colorFilter) {
            this.f9536a.f9556F = colorFilter;
            if (this.f9538c != null) {
                this.f9538c.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintList(ColorStateList colorStateList) {
        this.f9536a.f9560J = true;
        if (this.f9536a.f9558H != colorStateList) {
            this.f9536a.f9558H = colorStateList;
            DrawableCompat.setTintList(this.f9538c, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setTintMode(PorterDuff.Mode mode) {
        this.f9536a.f9561K = true;
        if (this.f9536a.f9559I != mode) {
            this.f9536a.f9559I = mode;
            DrawableCompat.setTintMode(this.f9538c, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f9539d != null) {
            this.f9539d.setBounds(rect);
        }
        if (this.f9538c != null) {
            this.f9538c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f9536a.m9038m();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f9536a.f9555E != z) {
            this.f9536a.f9555E = z;
            if (this.f9538c != null) {
                DrawableCompat.setAutoMirrored(this.f9538c, this.f9536a.f9555E);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f9536a.f9555E;
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        if (this.f9539d != null) {
            this.f9539d.jumpToCurrentState();
            this.f9539d = null;
            this.f9543h = -1;
            z = true;
        } else {
            z = false;
        }
        if (this.f9538c != null) {
            this.f9538c.jumpToCurrentState();
            if (this.f9541f) {
                this.f9538c.setAlpha(this.f9540e);
            }
        }
        if (this.f9547l != 0) {
            this.f9547l = 0L;
            z = true;
        }
        if (this.f9546k != 0) {
            this.f9546k = 0L;
            z = true;
        }
        if (z) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f, float f2) {
        if (this.f9538c != null) {
            DrawableCompat.setHotspot(this.f9538c, f, f2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i, int i2, int i3, int i4) {
        if (this.f9537b == null) {
            this.f9537b = new Rect(i, i2, i3, i4);
        } else {
            this.f9537b.set(i, i2, i3, i4);
        }
        if (this.f9538c != null) {
            DrawableCompat.setHotspotBounds(this.f9538c, i, i2, i3, i4);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(Rect rect) {
        if (this.f9537b != null) {
            rect.set(this.f9537b);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f9539d != null) {
            return this.f9539d.setState(iArr);
        }
        if (this.f9538c != null) {
            return this.f9538c.setState(iArr);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.f9539d != null) {
            return this.f9539d.setLevel(i);
        }
        if (this.f9538c != null) {
            return this.f9538c.setLevel(i);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i) {
        return this.f9536a.m9028d(i, m9012d());
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f9536a.m9031f()) {
            return this.f9536a.m9032g();
        }
        if (this.f9538c != null) {
            return this.f9538c.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f9536a.m9031f()) {
            return this.f9536a.m9033h();
        }
        if (this.f9538c != null) {
            return this.f9538c.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f9536a.m9031f()) {
            return this.f9536a.m9034i();
        }
        if (this.f9538c != null) {
            return this.f9538c.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f9536a.m9031f()) {
            return this.f9536a.m9035j();
        }
        if (this.f9538c != null) {
            return this.f9538c.getMinimumHeight();
        }
        return 0;
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.f9536a != null) {
            this.f9536a.m9022b();
        }
        if (drawable != this.f9538c || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        if (drawable != this.f9538c || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j);
    }

    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        if (drawable != this.f9538c || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f9539d != null) {
            this.f9539d.setVisible(z, z2);
        }
        if (this.f9538c != null) {
            this.f9538c.setVisible(z, z2);
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f9538c == null || !this.f9538c.isVisible()) {
            return -2;
        }
        return this.f9536a.m9037l();
    }

    /* JADX INFO: renamed from: d */
    int m9012d() {
        return this.f9542g;
    }

    /* JADX INFO: renamed from: a */
    boolean m9011a(int i) {
        if (i == this.f9542g) {
            return false;
        }
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.f9536a.f9554D > 0) {
            if (this.f9539d != null) {
                this.f9539d.setVisible(false, false);
            }
            if (this.f9538c != null) {
                this.f9539d = this.f9538c;
                this.f9543h = this.f9542g;
                this.f9547l = jUptimeMillis + ((long) this.f9536a.f9554D);
            } else {
                this.f9539d = null;
                this.f9543h = -1;
                this.f9547l = 0L;
            }
        } else if (this.f9538c != null) {
            this.f9538c.setVisible(false, false);
        }
        if (i >= 0 && i < this.f9536a.f9569j) {
            Drawable drawableM9021b = this.f9536a.m9021b(i);
            this.f9538c = drawableM9021b;
            this.f9542g = i;
            if (drawableM9021b != null) {
                if (this.f9536a.f9553C > 0) {
                    this.f9546k = jUptimeMillis + ((long) this.f9536a.f9553C);
                }
                m9007a(drawableM9021b);
            }
        } else {
            this.f9538c = null;
            this.f9542g = -1;
        }
        if (this.f9546k != 0 || this.f9547l != 0) {
            if (this.f9545j == null) {
                this.f9545j = new Runnable() { // from class: eg.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C1686eg.this.m9010a(true);
                        C1686eg.this.invalidateSelf();
                    }
                };
            } else {
                unscheduleSelf(this.f9545j);
            }
            m9010a(true);
        }
        invalidateSelf();
        return true;
    }

    /* JADX INFO: renamed from: a */
    private void m9007a(Drawable drawable) {
        if (this.f9548m == null) {
            this.f9548m = new a();
        }
        drawable.setCallback(this.f9548m.m9014a(drawable.getCallback()));
        try {
            if (this.f9536a.f9553C <= 0 && this.f9541f) {
                drawable.setAlpha(this.f9540e);
            }
            if (this.f9536a.f9557G) {
                drawable.setColorFilter(this.f9536a.f9556F);
            } else {
                if (this.f9536a.f9560J) {
                    DrawableCompat.setTintList(drawable, this.f9536a.f9558H);
                }
                if (this.f9536a.f9561K) {
                    DrawableCompat.setTintMode(drawable, this.f9536a.f9559I);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f9536a.f9585z);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (Build.VERSION.SDK_INT >= 19) {
                drawable.setAutoMirrored(this.f9536a.f9555E);
            }
            Rect rect = this.f9537b;
            if (Build.VERSION.SDK_INT >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.f9548m.m9013a());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x007f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:26:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    void m9010a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f9541f = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f9538c
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L41
            long r9 = r13.f9546k
            int r3 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r3 == 0) goto L43
            long r9 = r13.f9546k
            int r3 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r3 > 0) goto L26
            android.graphics.drawable.Drawable r3 = r13.f9538c
            int r9 = r13.f9540e
            r3.setAlpha(r9)
            r13.f9546k = r7
            goto L43
        L26:
            long r9 = r13.f9546k
            long r11 = r9 - r1
            long r11 = r11 * r4
            int r3 = (int) r11
            eg$b r9 = r13.f9536a
            int r9 = r9.f9553C
            int r3 = r3 / r9
            android.graphics.drawable.Drawable r9 = r13.f9538c
            int r3 = 255 - r3
            int r10 = r13.f9540e
            int r3 = r3 * r10
            int r3 = r3 / 255
            r9.setAlpha(r3)
            r3 = 1
            goto L44
        L41:
            r13.f9546k = r7
        L43:
            r3 = 0
        L44:
            android.graphics.drawable.Drawable r9 = r13.f9539d
            if (r9 == 0) goto L7a
            long r9 = r13.f9547l
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L7c
            long r9 = r13.f9547l
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L62
            android.graphics.drawable.Drawable r0 = r13.f9539d
            r0.setVisible(r6, r6)
            r0 = 0
            r13.f9539d = r0
            r0 = -1
            r13.f9543h = r0
            r13.f9547l = r7
            goto L7c
        L62:
            long r6 = r13.f9547l
            long r8 = r6 - r1
            long r8 = r8 * r4
            int r3 = (int) r8
            eg$b r4 = r13.f9536a
            int r4 = r4.f9554D
            int r3 = r3 / r4
            android.graphics.drawable.Drawable r4 = r13.f9539d
            int r5 = r13.f9540e
            int r3 = r3 * r5
            int r3 = r3 / 255
            r4.setAlpha(r3)
            goto L7d
        L7a:
            r13.f9547l = r7
        L7c:
            r0 = r3
        L7d:
            if (r14 == 0) goto L8a
            if (r0 == 0) goto L8a
            java.lang.Runnable r14 = r13.f9545j
            r3 = 16
            long r5 = r1 + r3
            r13.scheduleSelf(r14, r5)
        L8a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1686eg.m9010a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f9538c;
    }

    /* JADX INFO: renamed from: a */
    final void m9009a(Resources resources) {
        this.f9536a.m9019a(resources);
    }

    @Override // android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        this.f9536a.m9018a(theme);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return this.f9536a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f9536a.m9039n()) {
            return null;
        }
        this.f9536a.f9565f = getChangingConfigurations();
        return this.f9536a;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9544i && super.mutate() == this) {
            b bVarMo8990c = mo8990c();
            bVarMo8990c.mo8999a();
            mo8987a(bVarMo8990c);
            this.f9544i = true;
        }
        return this;
    }

    /* JADX INFO: renamed from: c */
    b mo8990c() {
        return this.f9536a;
    }

    /* JADX INFO: renamed from: eg$b */
    /* JADX INFO: compiled from: DrawableContainer.java */
    static abstract class b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: A */
        boolean f9551A;

        /* JADX INFO: renamed from: B */
        int f9552B;

        /* JADX INFO: renamed from: C */
        int f9553C;

        /* JADX INFO: renamed from: D */
        int f9554D;

        /* JADX INFO: renamed from: E */
        boolean f9555E;

        /* JADX INFO: renamed from: F */
        ColorFilter f9556F;

        /* JADX INFO: renamed from: G */
        boolean f9557G;

        /* JADX INFO: renamed from: H */
        ColorStateList f9558H;

        /* JADX INFO: renamed from: I */
        PorterDuff.Mode f9559I;

        /* JADX INFO: renamed from: J */
        boolean f9560J;

        /* JADX INFO: renamed from: K */
        boolean f9561K;

        /* JADX INFO: renamed from: c */
        final C1686eg f9562c;

        /* JADX INFO: renamed from: d */
        Resources f9563d;

        /* JADX INFO: renamed from: e */
        int f9564e;

        /* JADX INFO: renamed from: f */
        int f9565f;

        /* JADX INFO: renamed from: g */
        int f9566g;

        /* JADX INFO: renamed from: h */
        SparseArray<Drawable.ConstantState> f9567h;

        /* JADX INFO: renamed from: i */
        Drawable[] f9568i;

        /* JADX INFO: renamed from: j */
        int f9569j;

        /* JADX INFO: renamed from: k */
        boolean f9570k;

        /* JADX INFO: renamed from: l */
        boolean f9571l;

        /* JADX INFO: renamed from: m */
        Rect f9572m;

        /* JADX INFO: renamed from: n */
        boolean f9573n;

        /* JADX INFO: renamed from: o */
        boolean f9574o;

        /* JADX INFO: renamed from: p */
        int f9575p;

        /* JADX INFO: renamed from: q */
        int f9576q;

        /* JADX INFO: renamed from: r */
        int f9577r;

        /* JADX INFO: renamed from: s */
        int f9578s;

        /* JADX INFO: renamed from: t */
        boolean f9579t;

        /* JADX INFO: renamed from: u */
        int f9580u;

        /* JADX INFO: renamed from: v */
        boolean f9581v;

        /* JADX INFO: renamed from: w */
        boolean f9582w;

        /* JADX INFO: renamed from: x */
        boolean f9583x;

        /* JADX INFO: renamed from: y */
        boolean f9584y;

        /* JADX INFO: renamed from: z */
        boolean f9585z;

        b(b bVar, C1686eg c1686eg, Resources resources) {
            Resources resources2;
            this.f9564e = 160;
            this.f9570k = false;
            this.f9573n = false;
            this.f9585z = true;
            this.f9553C = 0;
            this.f9554D = 0;
            this.f9562c = c1686eg;
            if (resources != null) {
                resources2 = resources;
            } else {
                resources2 = bVar != null ? bVar.f9563d : null;
            }
            this.f9563d = resources2;
            this.f9564e = C1686eg.m9006a(resources, bVar != null ? bVar.f9564e : 0);
            if (bVar != null) {
                this.f9565f = bVar.f9565f;
                this.f9566g = bVar.f9566g;
                this.f9583x = true;
                this.f9584y = true;
                this.f9570k = bVar.f9570k;
                this.f9573n = bVar.f9573n;
                this.f9585z = bVar.f9585z;
                this.f9551A = bVar.f9551A;
                this.f9552B = bVar.f9552B;
                this.f9553C = bVar.f9553C;
                this.f9554D = bVar.f9554D;
                this.f9555E = bVar.f9555E;
                this.f9556F = bVar.f9556F;
                this.f9557G = bVar.f9557G;
                this.f9558H = bVar.f9558H;
                this.f9559I = bVar.f9559I;
                this.f9560J = bVar.f9560J;
                this.f9561K = bVar.f9561K;
                if (bVar.f9564e == this.f9564e) {
                    if (bVar.f9571l) {
                        this.f9572m = new Rect(bVar.f9572m);
                        this.f9571l = true;
                    }
                    if (bVar.f9574o) {
                        this.f9575p = bVar.f9575p;
                        this.f9576q = bVar.f9576q;
                        this.f9577r = bVar.f9577r;
                        this.f9578s = bVar.f9578s;
                        this.f9574o = true;
                    }
                }
                if (bVar.f9579t) {
                    this.f9580u = bVar.f9580u;
                    this.f9579t = true;
                }
                if (bVar.f9581v) {
                    this.f9582w = bVar.f9582w;
                    this.f9581v = true;
                }
                Drawable[] drawableArr = bVar.f9568i;
                this.f9568i = new Drawable[drawableArr.length];
                this.f9569j = bVar.f9569j;
                SparseArray<Drawable.ConstantState> sparseArray = bVar.f9567h;
                if (sparseArray != null) {
                    this.f9567h = sparseArray.clone();
                } else {
                    this.f9567h = new SparseArray<>(this.f9569j);
                }
                int i = this.f9569j;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null) {
                        Drawable.ConstantState constantState = drawableArr[i2].getConstantState();
                        if (constantState != null) {
                            this.f9567h.put(i2, constantState);
                        } else {
                            this.f9568i[i2] = drawableArr[i2];
                        }
                    }
                }
                return;
            }
            this.f9568i = new Drawable[10];
            this.f9569j = 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f9565f | this.f9566g;
        }

        /* JADX INFO: renamed from: a */
        public final int m9017a(Drawable drawable) {
            int i = this.f9569j;
            if (i >= this.f9568i.length) {
                mo9030e(i, i + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f9562c);
            this.f9568i[i] = drawable;
            this.f9569j++;
            this.f9566g = drawable.getChangingConfigurations() | this.f9566g;
            m9022b();
            this.f9572m = null;
            this.f9571l = false;
            this.f9574o = false;
            this.f9583x = false;
            return i;
        }

        /* JADX INFO: renamed from: b */
        void m9022b() {
            this.f9579t = false;
            this.f9581v = false;
        }

        /* JADX INFO: renamed from: c */
        final int m9024c() {
            return this.f9568i.length;
        }

        /* JADX INFO: renamed from: o */
        private void m9016o() {
            if (this.f9567h != null) {
                int size = this.f9567h.size();
                for (int i = 0; i < size; i++) {
                    this.f9568i[this.f9567h.keyAt(i)] = m9015b(this.f9567h.valueAt(i).newDrawable(this.f9563d));
                }
                this.f9567h = null;
            }
        }

        /* JADX INFO: renamed from: b */
        private Drawable m9015b(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.f9552B);
            }
            Drawable drawableMutate = drawable.mutate();
            drawableMutate.setCallback(this.f9562c);
            return drawableMutate;
        }

        /* JADX INFO: renamed from: d */
        public final int m9026d() {
            return this.f9569j;
        }

        /* JADX INFO: renamed from: b */
        public final Drawable m9021b(int i) {
            int iIndexOfKey;
            Drawable drawable = this.f9568i[i];
            if (drawable != null) {
                return drawable;
            }
            if (this.f9567h == null || (iIndexOfKey = this.f9567h.indexOfKey(i)) < 0) {
                return null;
            }
            Drawable drawableM9015b = m9015b(this.f9567h.valueAt(iIndexOfKey).newDrawable(this.f9563d));
            this.f9568i[i] = drawableM9015b;
            this.f9567h.removeAt(iIndexOfKey);
            if (this.f9567h.size() == 0) {
                this.f9567h = null;
            }
            return drawableM9015b;
        }

        /* JADX INFO: renamed from: d */
        final boolean m9028d(int i, int i2) {
            int i3 = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            boolean z = false;
            for (int i4 = 0; i4 < i3; i4++) {
                if (drawableArr[i4] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i4].setLayoutDirection(i) : false;
                    if (i4 == i2) {
                        z = layoutDirection;
                    }
                }
            }
            this.f9552B = i;
            return z;
        }

        /* JADX INFO: renamed from: a */
        final void m9019a(Resources resources) {
            if (resources != null) {
                this.f9563d = resources;
                int iM9006a = C1686eg.m9006a(resources, this.f9564e);
                int i = this.f9564e;
                this.f9564e = iM9006a;
                if (i != iM9006a) {
                    this.f9574o = false;
                    this.f9571l = false;
                }
            }
        }

        /* JADX INFO: renamed from: a */
        final void m9018a(Resources.Theme theme) {
            if (theme != null) {
                m9016o();
                int i = this.f9569j;
                Drawable[] drawableArr = this.f9568i;
                for (int i2 = 0; i2 < i; i2++) {
                    if (drawableArr[i2] != null && drawableArr[i2].canApplyTheme()) {
                        drawableArr[i2].applyTheme(theme);
                        this.f9566g |= drawableArr[i2].getChangingConfigurations();
                    }
                }
                m9019a(theme.getResources());
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                if (drawable != null) {
                    if (drawable.canApplyTheme()) {
                        return true;
                    }
                } else {
                    Drawable.ConstantState constantState = this.f9567h.get(i2);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                }
            }
            return false;
        }

        /* JADX INFO: renamed from: a */
        void mo8999a() {
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2] != null) {
                    drawableArr[i2].mutate();
                }
            }
            this.f9551A = true;
        }

        /* JADX INFO: renamed from: a */
        public final void m9020a(boolean z) {
            this.f9570k = z;
        }

        /* JADX INFO: renamed from: e */
        public final Rect m9029e() {
            if (this.f9570k) {
                return null;
            }
            if (this.f9572m != null || this.f9571l) {
                return this.f9572m;
            }
            m9016o();
            Rect rect = new Rect();
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            Rect rect2 = null;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getPadding(rect)) {
                    if (rect2 == null) {
                        rect2 = new Rect(0, 0, 0, 0);
                    }
                    if (rect.left > rect2.left) {
                        rect2.left = rect.left;
                    }
                    if (rect.top > rect2.top) {
                        rect2.top = rect.top;
                    }
                    if (rect.right > rect2.right) {
                        rect2.right = rect.right;
                    }
                    if (rect.bottom > rect2.bottom) {
                        rect2.bottom = rect.bottom;
                    }
                }
            }
            this.f9571l = true;
            this.f9572m = rect2;
            return rect2;
        }

        /* JADX INFO: renamed from: b */
        public final void m9023b(boolean z) {
            this.f9573n = z;
        }

        /* JADX INFO: renamed from: f */
        public final boolean m9031f() {
            return this.f9573n;
        }

        /* JADX INFO: renamed from: g */
        public final int m9032g() {
            if (!this.f9574o) {
                m9036k();
            }
            return this.f9575p;
        }

        /* JADX INFO: renamed from: h */
        public final int m9033h() {
            if (!this.f9574o) {
                m9036k();
            }
            return this.f9576q;
        }

        /* JADX INFO: renamed from: i */
        public final int m9034i() {
            if (!this.f9574o) {
                m9036k();
            }
            return this.f9577r;
        }

        /* JADX INFO: renamed from: j */
        public final int m9035j() {
            if (!this.f9574o) {
                m9036k();
            }
            return this.f9578s;
        }

        /* JADX INFO: renamed from: k */
        protected void m9036k() {
            this.f9574o = true;
            m9016o();
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            this.f9576q = -1;
            this.f9575p = -1;
            this.f9578s = 0;
            this.f9577r = 0;
            for (int i2 = 0; i2 < i; i2++) {
                Drawable drawable = drawableArr[i2];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.f9575p) {
                    this.f9575p = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.f9576q) {
                    this.f9576q = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.f9577r) {
                    this.f9577r = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.f9578s) {
                    this.f9578s = minimumHeight;
                }
            }
        }

        /* JADX INFO: renamed from: c */
        public final void m9025c(int i) {
            this.f9553C = i;
        }

        /* JADX INFO: renamed from: d */
        public final void m9027d(int i) {
            this.f9554D = i;
        }

        /* JADX INFO: renamed from: l */
        public final int m9037l() {
            if (this.f9579t) {
                return this.f9580u;
            }
            m9016o();
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            int opacity = i > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i2 = 1; i2 < i; i2++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i2].getOpacity());
            }
            this.f9580u = opacity;
            this.f9579t = true;
            return opacity;
        }

        /* JADX INFO: renamed from: m */
        public final boolean m9038m() {
            if (this.f9581v) {
                return this.f9582w;
            }
            m9016o();
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            boolean z = false;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    break;
                }
                if (drawableArr[i2].isStateful()) {
                    z = true;
                    break;
                }
                i2++;
            }
            this.f9582w = z;
            this.f9581v = true;
            return z;
        }

        /* JADX INFO: renamed from: e */
        public void mo9030e(int i, int i2) {
            Drawable[] drawableArr = new Drawable[i2];
            System.arraycopy(this.f9568i, 0, drawableArr, 0, i);
            this.f9568i = drawableArr;
        }

        /* JADX INFO: renamed from: n */
        public synchronized boolean m9039n() {
            if (this.f9583x) {
                return this.f9584y;
            }
            m9016o();
            this.f9583x = true;
            int i = this.f9569j;
            Drawable[] drawableArr = this.f9568i;
            for (int i2 = 0; i2 < i; i2++) {
                if (drawableArr[i2].getConstantState() == null) {
                    this.f9584y = false;
                    return false;
                }
            }
            this.f9584y = true;
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void mo8987a(b bVar) {
        this.f9536a = bVar;
        if (this.f9542g >= 0) {
            this.f9538c = bVar.m9021b(this.f9542g);
            if (this.f9538c != null) {
                m9007a(this.f9538c);
            }
        }
        this.f9543h = -1;
        this.f9539d = null;
    }

    /* JADX INFO: renamed from: eg$a */
    /* JADX INFO: compiled from: DrawableContainer.java */
    static class a implements Drawable.Callback {

        /* JADX INFO: renamed from: a */
        private Drawable.Callback f9550a;

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
        }

        a() {
        }

        /* JADX INFO: renamed from: a */
        public a m9014a(Drawable.Callback callback) {
            this.f9550a = callback;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public Drawable.Callback m9013a() {
            Drawable.Callback callback = this.f9550a;
            this.f9550a = null;
            return callback;
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
            if (this.f9550a != null) {
                this.f9550a.scheduleDrawable(drawable, runnable, j);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            if (this.f9550a != null) {
                this.f9550a.unscheduleDrawable(drawable, runnable);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static int m9006a(Resources resources, int i) {
        if (resources != null) {
            i = resources.getDisplayMetrics().densityDpi;
        }
        if (i == 0) {
            return 160;
        }
        return i;
    }
}
