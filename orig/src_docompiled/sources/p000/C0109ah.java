package p000;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.support.design.R;
import android.support.design.button.MaterialButton;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;

/* JADX INFO: renamed from: ah */
/* JADX INFO: compiled from: MaterialButtonHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0109ah {

    /* JADX INFO: renamed from: a */
    private static final boolean f885a;

    /* JADX INFO: renamed from: b */
    private final MaterialButton f886b;

    /* JADX INFO: renamed from: c */
    private int f887c;

    /* JADX INFO: renamed from: d */
    private int f888d;

    /* JADX INFO: renamed from: e */
    private int f889e;

    /* JADX INFO: renamed from: f */
    private int f890f;

    /* JADX INFO: renamed from: g */
    private int f891g;

    /* JADX INFO: renamed from: h */
    private int f892h;

    /* JADX INFO: renamed from: i */
    private PorterDuff.Mode f893i;

    /* JADX INFO: renamed from: j */
    private ColorStateList f894j;

    /* JADX INFO: renamed from: k */
    private ColorStateList f895k;

    /* JADX INFO: renamed from: l */
    private ColorStateList f896l;

    /* JADX INFO: renamed from: p */
    private GradientDrawable f900p;

    /* JADX INFO: renamed from: q */
    private Drawable f901q;

    /* JADX INFO: renamed from: r */
    private GradientDrawable f902r;

    /* JADX INFO: renamed from: s */
    private Drawable f903s;

    /* JADX INFO: renamed from: t */
    private GradientDrawable f904t;

    /* JADX INFO: renamed from: u */
    private GradientDrawable f905u;

    /* JADX INFO: renamed from: v */
    private GradientDrawable f906v;

    /* JADX INFO: renamed from: m */
    private final Paint f897m = new Paint(1);

    /* JADX INFO: renamed from: n */
    private final Rect f898n = new Rect();

    /* JADX INFO: renamed from: o */
    private final RectF f899o = new RectF();

    /* JADX INFO: renamed from: w */
    private boolean f907w = false;

    static {
        f885a = Build.VERSION.SDK_INT >= 21;
    }

    public C0109ah(MaterialButton materialButton) {
        this.f886b = materialButton;
    }

    /* JADX INFO: renamed from: a */
    public void m1025a(TypedArray typedArray) {
        this.f887c = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
        this.f888d = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
        this.f889e = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
        this.f890f = typedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
        this.f891g = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
        this.f892h = typedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
        this.f893i = C0752au.m5475a(typedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.f894j = C0753av.m5478a(this.f886b.getContext(), typedArray, R.styleable.MaterialButton_backgroundTint);
        this.f895k = C0753av.m5478a(this.f886b.getContext(), typedArray, R.styleable.MaterialButton_strokeColor);
        this.f896l = C0753av.m5478a(this.f886b.getContext(), typedArray, R.styleable.MaterialButton_rippleColor);
        this.f897m.setStyle(Paint.Style.STROKE);
        this.f897m.setStrokeWidth(this.f892h);
        this.f897m.setColor(this.f895k != null ? this.f895k.getColorForState(this.f886b.getDrawableState(), 0) : 0);
        int paddingStart = ViewCompat.getPaddingStart(this.f886b);
        int paddingTop = this.f886b.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(this.f886b);
        int paddingBottom = this.f886b.getPaddingBottom();
        this.f886b.setInternalBackground(f885a ? m1017k() : m1015i());
        ViewCompat.setPaddingRelative(this.f886b, paddingStart + this.f887c, paddingTop + this.f889e, paddingEnd + this.f888d, paddingBottom + this.f890f);
    }

    /* JADX INFO: renamed from: a */
    public void m1021a() {
        this.f907w = true;
        this.f886b.setSupportBackgroundTintList(this.f894j);
        this.f886b.setSupportBackgroundTintMode(this.f893i);
    }

    /* JADX INFO: renamed from: b */
    public boolean m1030b() {
        return this.f907w;
    }

    /* JADX INFO: renamed from: a */
    public void m1026a(Canvas canvas) {
        if (canvas == null || this.f895k == null || this.f892h <= 0) {
            return;
        }
        this.f898n.set(this.f886b.getBackground().getBounds());
        this.f899o.set(this.f898n.left + (this.f892h / 2.0f) + this.f887c, this.f898n.top + (this.f892h / 2.0f) + this.f889e, (this.f898n.right - (this.f892h / 2.0f)) - this.f888d, (this.f898n.bottom - (this.f892h / 2.0f)) - this.f890f);
        float f = this.f891g - (this.f892h / 2.0f);
        canvas.drawRoundRect(this.f899o, f, f, this.f897m);
    }

    /* JADX INFO: renamed from: i */
    private Drawable m1015i() {
        this.f900p = new GradientDrawable();
        this.f900p.setCornerRadius(this.f891g + 1.0E-5f);
        this.f900p.setColor(-1);
        this.f901q = DrawableCompat.wrap(this.f900p);
        DrawableCompat.setTintList(this.f901q, this.f894j);
        if (this.f893i != null) {
            DrawableCompat.setTintMode(this.f901q, this.f893i);
        }
        this.f902r = new GradientDrawable();
        this.f902r.setCornerRadius(this.f891g + 1.0E-5f);
        this.f902r.setColor(-1);
        this.f903s = DrawableCompat.wrap(this.f902r);
        DrawableCompat.setTintList(this.f903s, this.f896l);
        return m1014a(new LayerDrawable(new Drawable[]{this.f901q, this.f903s}));
    }

    /* JADX INFO: renamed from: a */
    private InsetDrawable m1014a(Drawable drawable) {
        return new InsetDrawable(drawable, this.f887c, this.f889e, this.f888d, this.f890f);
    }

    /* JADX INFO: renamed from: a */
    public void m1024a(ColorStateList colorStateList) {
        if (this.f894j != colorStateList) {
            this.f894j = colorStateList;
            if (f885a) {
                m1016j();
            } else if (this.f901q != null) {
                DrawableCompat.setTintList(this.f901q, this.f894j);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public ColorStateList m1031c() {
        return this.f894j;
    }

    /* JADX INFO: renamed from: a */
    public void m1027a(PorterDuff.Mode mode) {
        if (this.f893i != mode) {
            this.f893i = mode;
            if (f885a) {
                m1016j();
            } else {
                if (this.f901q == null || this.f893i == null) {
                    return;
                }
                DrawableCompat.setTintMode(this.f901q, this.f893i);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public PorterDuff.Mode m1034d() {
        return this.f893i;
    }

    /* JADX INFO: renamed from: j */
    private void m1016j() {
        if (this.f904t != null) {
            DrawableCompat.setTintList(this.f904t, this.f894j);
            if (this.f893i != null) {
                DrawableCompat.setTintMode(this.f904t, this.f893i);
            }
        }
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: k */
    private Drawable m1017k() {
        this.f904t = new GradientDrawable();
        this.f904t.setCornerRadius(this.f891g + 1.0E-5f);
        this.f904t.setColor(-1);
        m1016j();
        this.f905u = new GradientDrawable();
        this.f905u.setCornerRadius(this.f891g + 1.0E-5f);
        this.f905u.setColor(0);
        this.f905u.setStroke(this.f892h, this.f895k);
        InsetDrawable insetDrawableM1014a = m1014a(new LayerDrawable(new Drawable[]{this.f904t, this.f905u}));
        this.f906v = new GradientDrawable();
        this.f906v.setCornerRadius(this.f891g + 1.0E-5f);
        this.f906v.setColor(-1);
        return new C0089ag(C0756ay.m5493a(this.f896l), insetDrawableM1014a, this.f906v);
    }

    /* JADX INFO: renamed from: a */
    public void m1023a(int i, int i2) {
        if (this.f906v != null) {
            this.f906v.setBounds(this.f887c, this.f889e, i2 - this.f888d, i - this.f890f);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1022a(int i) {
        if (f885a && this.f904t != null) {
            this.f904t.setColor(i);
        } else {
            if (f885a || this.f900p == null) {
                return;
            }
            this.f900p.setColor(i);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1029b(ColorStateList colorStateList) {
        if (this.f896l != colorStateList) {
            this.f896l = colorStateList;
            if (f885a && (this.f886b.getBackground() instanceof RippleDrawable)) {
                ((RippleDrawable) this.f886b.getBackground()).setColor(colorStateList);
            } else {
                if (f885a || this.f903s == null) {
                    return;
                }
                DrawableCompat.setTintList(this.f903s, colorStateList);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    public ColorStateList m1035e() {
        return this.f896l;
    }

    /* JADX INFO: renamed from: c */
    public void m1033c(ColorStateList colorStateList) {
        if (this.f895k != colorStateList) {
            this.f895k = colorStateList;
            this.f897m.setColor(colorStateList != null ? colorStateList.getColorForState(this.f886b.getDrawableState(), 0) : 0);
            m1018l();
        }
    }

    /* JADX INFO: renamed from: f */
    public ColorStateList m1036f() {
        return this.f895k;
    }

    /* JADX INFO: renamed from: b */
    public void m1028b(int i) {
        if (this.f892h != i) {
            this.f892h = i;
            this.f897m.setStrokeWidth(i);
            m1018l();
        }
    }

    /* JADX INFO: renamed from: g */
    public int m1037g() {
        return this.f892h;
    }

    /* JADX INFO: renamed from: l */
    private void m1018l() {
        if (f885a && this.f905u != null) {
            this.f886b.setInternalBackground(m1017k());
        } else {
            if (f885a) {
                return;
            }
            this.f886b.invalidate();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1032c(int i) {
        if (this.f891g != i) {
            this.f891g = i;
            if (f885a && this.f904t != null && this.f905u != null && this.f906v != null) {
                if (Build.VERSION.SDK_INT == 21) {
                    float f = i + 1.0E-5f;
                    m1020n().setCornerRadius(f);
                    m1019m().setCornerRadius(f);
                }
                float f2 = i + 1.0E-5f;
                this.f904t.setCornerRadius(f2);
                this.f905u.setCornerRadius(f2);
                this.f906v.setCornerRadius(f2);
                return;
            }
            if (f885a || this.f900p == null || this.f902r == null) {
                return;
            }
            float f3 = i + 1.0E-5f;
            this.f900p.setCornerRadius(f3);
            this.f902r.setCornerRadius(f3);
            this.f886b.invalidate();
        }
    }

    /* JADX INFO: renamed from: h */
    public int m1038h() {
        return this.f891g;
    }

    /* JADX INFO: renamed from: m */
    private GradientDrawable m1019m() {
        if (!f885a || this.f886b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f886b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    }

    /* JADX INFO: renamed from: n */
    private GradientDrawable m1020n() {
        if (!f885a || this.f886b.getBackground() == null) {
            return null;
        }
        return (GradientDrawable) ((LayerDrawable) ((InsetDrawable) ((RippleDrawable) this.f886b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    }
}
