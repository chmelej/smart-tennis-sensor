package p000;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.support.v4.math.MathUtils;
import android.support.v4.text.TextDirectionHeuristicsCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.View;

/* JADX INFO: renamed from: bh */
/* JADX INFO: compiled from: CollapsingTextHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0766bh {

    /* JADX INFO: renamed from: a */
    private static final boolean f5136a;

    /* JADX INFO: renamed from: b */
    private static final Paint f5137b = null;

    /* JADX INFO: renamed from: A */
    private boolean f5138A;

    /* JADX INFO: renamed from: B */
    private Bitmap f5139B;

    /* JADX INFO: renamed from: C */
    private Paint f5140C;

    /* JADX INFO: renamed from: D */
    private float f5141D;

    /* JADX INFO: renamed from: E */
    private float f5142E;

    /* JADX INFO: renamed from: F */
    private float f5143F;

    /* JADX INFO: renamed from: G */
    private float f5144G;

    /* JADX INFO: renamed from: H */
    private int[] f5145H;

    /* JADX INFO: renamed from: I */
    private boolean f5146I;

    /* JADX INFO: renamed from: L */
    private TimeInterpolator f5149L;

    /* JADX INFO: renamed from: M */
    private TimeInterpolator f5150M;

    /* JADX INFO: renamed from: N */
    private float f5151N;

    /* JADX INFO: renamed from: O */
    private float f5152O;

    /* JADX INFO: renamed from: P */
    private float f5153P;

    /* JADX INFO: renamed from: Q */
    private int f5154Q;

    /* JADX INFO: renamed from: R */
    private float f5155R;

    /* JADX INFO: renamed from: S */
    private float f5156S;

    /* JADX INFO: renamed from: T */
    private float f5157T;

    /* JADX INFO: renamed from: U */
    private int f5158U;

    /* JADX INFO: renamed from: c */
    private final View f5159c;

    /* JADX INFO: renamed from: d */
    private boolean f5160d;

    /* JADX INFO: renamed from: e */
    private float f5161e;

    /* JADX INFO: renamed from: m */
    private ColorStateList f5169m;

    /* JADX INFO: renamed from: n */
    private ColorStateList f5170n;

    /* JADX INFO: renamed from: o */
    private float f5171o;

    /* JADX INFO: renamed from: p */
    private float f5172p;

    /* JADX INFO: renamed from: q */
    private float f5173q;

    /* JADX INFO: renamed from: r */
    private float f5174r;

    /* JADX INFO: renamed from: s */
    private float f5175s;

    /* JADX INFO: renamed from: t */
    private float f5176t;

    /* JADX INFO: renamed from: u */
    private Typeface f5177u;

    /* JADX INFO: renamed from: v */
    private Typeface f5178v;

    /* JADX INFO: renamed from: w */
    private Typeface f5179w;

    /* JADX INFO: renamed from: x */
    private CharSequence f5180x;

    /* JADX INFO: renamed from: y */
    private CharSequence f5181y;

    /* JADX INFO: renamed from: z */
    private boolean f5182z;

    /* JADX INFO: renamed from: i */
    private int f5165i = 16;

    /* JADX INFO: renamed from: j */
    private int f5166j = 16;

    /* JADX INFO: renamed from: k */
    private float f5167k = 15.0f;

    /* JADX INFO: renamed from: l */
    private float f5168l = 15.0f;

    /* JADX INFO: renamed from: J */
    private final TextPaint f5147J = new TextPaint(129);

    /* JADX INFO: renamed from: K */
    private final TextPaint f5148K = new TextPaint(this.f5147J);

    /* JADX INFO: renamed from: g */
    private final Rect f5163g = new Rect();

    /* JADX INFO: renamed from: f */
    private final Rect f5162f = new Rect();

    /* JADX INFO: renamed from: h */
    private final RectF f5164h = new RectF();

    static {
        f5136a = Build.VERSION.SDK_INT < 18;
        if (f5137b != null) {
            f5137b.setAntiAlias(true);
            f5137b.setColor(-65281);
        }
    }

    public C0766bh(View view) {
        this.f5159c = view;
    }

    /* JADX INFO: renamed from: a */
    public void m5539a(TimeInterpolator timeInterpolator) {
        this.f5150M = timeInterpolator;
        m5564k();
    }

    /* JADX INFO: renamed from: b */
    public void m5550b(TimeInterpolator timeInterpolator) {
        this.f5149L = timeInterpolator;
        m5564k();
    }

    /* JADX INFO: renamed from: a */
    public void m5536a(float f) {
        if (this.f5167k != f) {
            this.f5167k = f;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5540a(ColorStateList colorStateList) {
        if (this.f5170n != colorStateList) {
            this.f5170n = colorStateList;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5551b(ColorStateList colorStateList) {
        if (this.f5169m != colorStateList) {
            this.f5169m = colorStateList;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5538a(int i, int i2, int i3, int i4) {
        if (m5523a(this.f5162f, i, i2, i3, i4)) {
            return;
        }
        this.f5162f.set(i, i2, i3, i4);
        this.f5146I = true;
        m5553c();
    }

    /* JADX INFO: renamed from: b */
    public void m5549b(int i, int i2, int i3, int i4) {
        if (m5523a(this.f5163g, i, i2, i3, i4)) {
            return;
        }
        this.f5163g.set(i, i2, i3, i4);
        this.f5146I = true;
        m5553c();
    }

    /* JADX INFO: renamed from: a */
    public float m5535a() {
        if (this.f5180x == null) {
            return 0.0f;
        }
        m5521a(this.f5148K);
        return this.f5148K.measureText(this.f5180x, 0, this.f5180x.length());
    }

    /* JADX INFO: renamed from: b */
    public float m5546b() {
        m5521a(this.f5148K);
        return -this.f5148K.ascent();
    }

    /* JADX INFO: renamed from: a */
    public void m5542a(RectF rectF) {
        float fM5535a;
        boolean zM5524b = m5524b(this.f5180x);
        if (!zM5524b) {
            fM5535a = this.f5163g.left;
        } else {
            fM5535a = this.f5163g.right - m5535a();
        }
        rectF.left = fM5535a;
        rectF.top = this.f5163g.top;
        rectF.right = !zM5524b ? rectF.left + m5535a() : this.f5163g.right;
        rectF.bottom = this.f5163g.top + m5546b();
    }

    /* JADX INFO: renamed from: a */
    private void m5521a(TextPaint textPaint) {
        textPaint.setTextSize(this.f5168l);
        textPaint.setTypeface(this.f5177u);
    }

    /* JADX INFO: renamed from: c */
    void m5553c() {
        this.f5160d = this.f5163g.width() > 0 && this.f5163g.height() > 0 && this.f5162f.width() > 0 && this.f5162f.height() > 0;
    }

    /* JADX INFO: renamed from: a */
    public void m5537a(int i) {
        if (this.f5165i != i) {
            this.f5165i = i;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: d */
    public int m5556d() {
        return this.f5165i;
    }

    /* JADX INFO: renamed from: b */
    public void m5548b(int i) {
        if (this.f5166j != i) {
            this.f5166j = i;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: e */
    public int m5558e() {
        return this.f5166j;
    }

    /* JADX INFO: renamed from: c */
    public void m5554c(int i) {
        C1766hd c1766hdM9599a = C1766hd.m9599a(this.f5159c.getContext(), i, R.styleable.TextAppearance);
        if (c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textColor)) {
            this.f5170n = c1766hdM9599a.m9616e(R.styleable.TextAppearance_android_textColor);
        }
        if (c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textSize)) {
            this.f5168l = c1766hdM9599a.m9615e(R.styleable.TextAppearance_android_textSize, (int) this.f5168l);
        }
        this.f5154Q = c1766hdM9599a.m9603a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.f5152O = c1766hdM9599a.m9602a(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f5153P = c1766hdM9599a.m9602a(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f5151N = c1766hdM9599a.m9602a(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        c1766hdM9599a.m9606a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f5177u = m5527e(i);
        }
        m5564k();
    }

    /* JADX INFO: renamed from: d */
    public void m5557d(int i) {
        C1766hd c1766hdM9599a = C1766hd.m9599a(this.f5159c.getContext(), i, R.styleable.TextAppearance);
        if (c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textColor)) {
            this.f5169m = c1766hdM9599a.m9616e(R.styleable.TextAppearance_android_textColor);
        }
        if (c1766hdM9599a.m9620g(R.styleable.TextAppearance_android_textSize)) {
            this.f5167k = c1766hdM9599a.m9615e(R.styleable.TextAppearance_android_textSize, (int) this.f5167k);
        }
        this.f5158U = c1766hdM9599a.m9603a(R.styleable.TextAppearance_android_shadowColor, 0);
        this.f5156S = c1766hdM9599a.m9602a(R.styleable.TextAppearance_android_shadowDx, 0.0f);
        this.f5157T = c1766hdM9599a.m9602a(R.styleable.TextAppearance_android_shadowDy, 0.0f);
        this.f5155R = c1766hdM9599a.m9602a(R.styleable.TextAppearance_android_shadowRadius, 0.0f);
        c1766hdM9599a.m9606a();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f5178v = m5527e(i);
        }
        m5564k();
    }

    /* JADX INFO: renamed from: e */
    private Typeface m5527e(int i) {
        TypedArray typedArrayObtainStyledAttributes = this.f5159c.getContext().obtainStyledAttributes(i, new int[]{android.R.attr.fontFamily});
        try {
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                return Typeface.create(string, 0);
            }
            typedArrayObtainStyledAttributes.recycle();
            return null;
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m5543a(Typeface typeface) {
        if (this.f5177u != typeface) {
            this.f5177u = typeface;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m5552b(Typeface typeface) {
        if (this.f5178v != typeface) {
            this.f5178v = typeface;
            m5564k();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m5555c(Typeface typeface) {
        this.f5178v = typeface;
        this.f5177u = typeface;
        m5564k();
    }

    /* JADX INFO: renamed from: f */
    public Typeface m5559f() {
        return this.f5177u != null ? this.f5177u : Typeface.DEFAULT;
    }

    /* JADX INFO: renamed from: g */
    public Typeface m5560g() {
        return this.f5178v != null ? this.f5178v : Typeface.DEFAULT;
    }

    /* JADX INFO: renamed from: b */
    public void m5547b(float f) {
        float fClamp = MathUtils.clamp(f, 0.0f, 1.0f);
        if (fClamp != this.f5161e) {
            this.f5161e = fClamp;
            m5530n();
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m5545a(int[] iArr) {
        this.f5145H = iArr;
        if (!m5561h()) {
            return false;
        }
        m5564k();
        return true;
    }

    /* JADX INFO: renamed from: h */
    public final boolean m5561h() {
        return (this.f5170n != null && this.f5170n.isStateful()) || (this.f5169m != null && this.f5169m.isStateful());
    }

    /* JADX INFO: renamed from: i */
    public float m5562i() {
        return this.f5161e;
    }

    /* JADX INFO: renamed from: n */
    private void m5530n() {
        m5525c(this.f5161e);
    }

    /* JADX INFO: renamed from: c */
    private void m5525c(float f) {
        m5526d(f);
        this.f5175s = m5519a(this.f5173q, this.f5174r, f, this.f5149L);
        this.f5176t = m5519a(this.f5171o, this.f5172p, f, this.f5149L);
        m5528e(m5519a(this.f5167k, this.f5168l, f, this.f5150M));
        if (this.f5170n != this.f5169m) {
            this.f5147J.setColor(m5520a(m5531o(), m5563j(), f));
        } else {
            this.f5147J.setColor(m5563j());
        }
        this.f5147J.setShadowLayer(m5519a(this.f5155R, this.f5151N, f, (TimeInterpolator) null), m5519a(this.f5156S, this.f5152O, f, (TimeInterpolator) null), m5519a(this.f5157T, this.f5153P, f, (TimeInterpolator) null), m5520a(this.f5158U, this.f5154Q, f));
        ViewCompat.postInvalidateOnAnimation(this.f5159c);
    }

    /* JADX INFO: renamed from: o */
    private int m5531o() {
        if (this.f5145H != null) {
            return this.f5169m.getColorForState(this.f5145H, 0);
        }
        return this.f5169m.getDefaultColor();
    }

    /* JADX INFO: renamed from: j */
    public int m5563j() {
        if (this.f5145H != null) {
            return this.f5170n.getColorForState(this.f5145H, 0);
        }
        return this.f5170n.getDefaultColor();
    }

    /* JADX INFO: renamed from: p */
    private void m5532p() {
        float f = this.f5144G;
        m5529f(this.f5168l);
        float fMeasureText = this.f5181y != null ? this.f5147J.measureText(this.f5181y, 0, this.f5181y.length()) : 0.0f;
        int absoluteGravity = GravityCompat.getAbsoluteGravity(this.f5166j, this.f5182z ? 1 : 0);
        int i = absoluteGravity & 112;
        if (i == 48) {
            this.f5172p = this.f5163g.top - this.f5147J.ascent();
        } else if (i == 80) {
            this.f5172p = this.f5163g.bottom;
        } else {
            this.f5172p = this.f5163g.centerY() + (((this.f5147J.descent() - this.f5147J.ascent()) / 2.0f) - this.f5147J.descent());
        }
        int i2 = absoluteGravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i2 == 1) {
            this.f5174r = this.f5163g.centerX() - (fMeasureText / 2.0f);
        } else if (i2 == 5) {
            this.f5174r = this.f5163g.right - fMeasureText;
        } else {
            this.f5174r = this.f5163g.left;
        }
        m5529f(this.f5167k);
        float fMeasureText2 = this.f5181y != null ? this.f5147J.measureText(this.f5181y, 0, this.f5181y.length()) : 0.0f;
        int absoluteGravity2 = GravityCompat.getAbsoluteGravity(this.f5165i, this.f5182z ? 1 : 0);
        int i3 = absoluteGravity2 & 112;
        if (i3 == 48) {
            this.f5171o = this.f5162f.top - this.f5147J.ascent();
        } else if (i3 == 80) {
            this.f5171o = this.f5162f.bottom;
        } else {
            this.f5171o = this.f5162f.centerY() + (((this.f5147J.descent() - this.f5147J.ascent()) / 2.0f) - this.f5147J.descent());
        }
        int i4 = absoluteGravity2 & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        if (i4 == 1) {
            this.f5173q = this.f5162f.centerX() - (fMeasureText2 / 2.0f);
        } else if (i4 == 5) {
            this.f5173q = this.f5162f.right - fMeasureText2;
        } else {
            this.f5173q = this.f5162f.left;
        }
        m5534r();
        m5528e(f);
    }

    /* JADX INFO: renamed from: d */
    private void m5526d(float f) {
        this.f5164h.left = m5519a(this.f5162f.left, this.f5163g.left, f, this.f5149L);
        this.f5164h.top = m5519a(this.f5171o, this.f5172p, f, this.f5149L);
        this.f5164h.right = m5519a(this.f5162f.right, this.f5163g.right, f, this.f5149L);
        this.f5164h.bottom = m5519a(this.f5162f.bottom, this.f5163g.bottom, f, this.f5149L);
    }

    /* JADX INFO: renamed from: a */
    public void m5541a(Canvas canvas) {
        float fAscent;
        int iSave = canvas.save();
        if (this.f5181y != null && this.f5160d) {
            float f = this.f5175s;
            float f2 = this.f5176t;
            boolean z = this.f5138A && this.f5139B != null;
            if (z) {
                fAscent = this.f5141D * this.f5143F;
                float f3 = this.f5142E;
                float f4 = this.f5143F;
            } else {
                fAscent = this.f5147J.ascent() * this.f5143F;
                this.f5147J.descent();
                float f5 = this.f5143F;
            }
            if (z) {
                f2 += fAscent;
            }
            float f6 = f2;
            if (this.f5143F != 1.0f) {
                canvas.scale(this.f5143F, this.f5143F, f, f6);
            }
            if (z) {
                canvas.drawBitmap(this.f5139B, f, f6, this.f5140C);
            } else {
                canvas.drawText(this.f5181y, 0, this.f5181y.length(), f, f6, this.f5147J);
            }
        }
        canvas.restoreToCount(iSave);
    }

    /* JADX INFO: renamed from: b */
    private boolean m5524b(CharSequence charSequence) {
        return (ViewCompat.getLayoutDirection(this.f5159c) == 1 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR).isRtl(charSequence, 0, charSequence.length());
    }

    /* JADX INFO: renamed from: e */
    private void m5528e(float f) {
        m5529f(f);
        this.f5138A = f5136a && this.f5143F != 1.0f;
        if (this.f5138A) {
            m5533q();
        }
        ViewCompat.postInvalidateOnAnimation(this.f5159c);
    }

    /* JADX INFO: renamed from: f */
    private void m5529f(float f) {
        float f2;
        boolean z;
        boolean z2;
        if (this.f5180x == null) {
            return;
        }
        float fWidth = this.f5163g.width();
        float fWidth2 = this.f5162f.width();
        if (m5522a(f, this.f5168l)) {
            float f3 = this.f5168l;
            this.f5143F = 1.0f;
            if (this.f5179w != this.f5177u) {
                this.f5179w = this.f5177u;
                z2 = true;
            } else {
                z2 = false;
            }
            f2 = f3;
            z = z2;
        } else {
            f2 = this.f5167k;
            if (this.f5179w != this.f5178v) {
                this.f5179w = this.f5178v;
                z = true;
            } else {
                z = false;
            }
            if (m5522a(f, this.f5167k)) {
                this.f5143F = 1.0f;
            } else {
                this.f5143F = f / this.f5167k;
            }
            float f4 = this.f5168l / this.f5167k;
            fWidth = fWidth2 * f4 > fWidth ? Math.min(fWidth / f4, fWidth2) : fWidth2;
        }
        if (fWidth > 0.0f) {
            z = this.f5144G != f2 || this.f5146I || z;
            this.f5144G = f2;
            this.f5146I = false;
        }
        if (this.f5181y == null || z) {
            this.f5147J.setTextSize(this.f5144G);
            this.f5147J.setTypeface(this.f5179w);
            this.f5147J.setLinearText(this.f5143F != 1.0f);
            CharSequence charSequenceEllipsize = TextUtils.ellipsize(this.f5180x, this.f5147J, fWidth, TextUtils.TruncateAt.END);
            if (TextUtils.equals(charSequenceEllipsize, this.f5181y)) {
                return;
            }
            this.f5181y = charSequenceEllipsize;
            this.f5182z = m5524b(this.f5181y);
        }
    }

    /* JADX INFO: renamed from: q */
    private void m5533q() {
        if (this.f5139B != null || this.f5162f.isEmpty() || TextUtils.isEmpty(this.f5181y)) {
            return;
        }
        m5525c(0.0f);
        this.f5141D = this.f5147J.ascent();
        this.f5142E = this.f5147J.descent();
        int iRound = Math.round(this.f5147J.measureText(this.f5181y, 0, this.f5181y.length()));
        int iRound2 = Math.round(this.f5142E - this.f5141D);
        if (iRound <= 0 || iRound2 <= 0) {
            return;
        }
        this.f5139B = Bitmap.createBitmap(iRound, iRound2, Bitmap.Config.ARGB_8888);
        new Canvas(this.f5139B).drawText(this.f5181y, 0, this.f5181y.length(), 0.0f, iRound2 - this.f5147J.descent(), this.f5147J);
        if (this.f5140C == null) {
            this.f5140C = new Paint(3);
        }
    }

    /* JADX INFO: renamed from: k */
    public void m5564k() {
        if (this.f5159c.getHeight() <= 0 || this.f5159c.getWidth() <= 0) {
            return;
        }
        m5532p();
        m5530n();
    }

    /* JADX INFO: renamed from: a */
    public void m5544a(CharSequence charSequence) {
        if (charSequence == null || !charSequence.equals(this.f5180x)) {
            this.f5180x = charSequence;
            this.f5181y = null;
            m5534r();
            m5564k();
        }
    }

    /* JADX INFO: renamed from: l */
    public CharSequence m5565l() {
        return this.f5180x;
    }

    /* JADX INFO: renamed from: r */
    private void m5534r() {
        if (this.f5139B != null) {
            this.f5139B.recycle();
            this.f5139B = null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5522a(float f, float f2) {
        return Math.abs(f - f2) < 0.001f;
    }

    /* JADX INFO: renamed from: m */
    public ColorStateList m5566m() {
        return this.f5170n;
    }

    /* JADX INFO: renamed from: a */
    private static int m5520a(int i, int i2, float f) {
        float f2 = 1.0f - f;
        return Color.argb((int) ((Color.alpha(i) * f2) + (Color.alpha(i2) * f)), (int) ((Color.red(i) * f2) + (Color.red(i2) * f)), (int) ((Color.green(i) * f2) + (Color.green(i2) * f)), (int) ((Color.blue(i) * f2) + (Color.blue(i2) * f)));
    }

    /* JADX INFO: renamed from: a */
    private static float m5519a(float f, float f2, float f3, TimeInterpolator timeInterpolator) {
        if (timeInterpolator != null) {
            f3 = timeInterpolator.getInterpolation(f3);
        }
        return C2178v.m11881a(f, f2, f3);
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5523a(Rect rect, int i, int i2, int i3, int i4) {
        return rect.left == i && rect.top == i2 && rect.right == i3 && rect.bottom == i4;
    }
}
