package android.support.design.chip;

import android.R;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.graphics.ColorUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.graphics.drawable.TintAwareDrawable;
import android.support.v4.internal.view.SupportMenu;
import android.support.v4.text.BidiFormatter;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import p000.C0005ac;
import p000.C0116ai;
import p000.C0212an;
import p000.C0751at;
import p000.C0753av;
import p000.C0754aw;
import p000.C0756ay;
import p000.C1684ee;

/* JADX INFO: loaded from: classes.dex */
public class ChipDrawable extends Drawable implements Drawable.Callback, TintAwareDrawable {

    /* JADX INFO: renamed from: a */
    private static final int[] f2092a = {R.attr.state_enabled};

    /* JADX INFO: renamed from: A */
    private float f2093A;

    /* JADX INFO: renamed from: B */
    private float f2094B;

    /* JADX INFO: renamed from: C */
    private float f2095C;

    /* JADX INFO: renamed from: D */
    private float f2096D;

    /* JADX INFO: renamed from: E */
    private float f2097E;

    /* JADX INFO: renamed from: F */
    private float f2098F;

    /* JADX INFO: renamed from: G */
    private float f2099G;

    /* JADX INFO: renamed from: H */
    private final Context f2100H;

    /* JADX INFO: renamed from: K */
    private final Paint f2103K;

    /* JADX INFO: renamed from: O */
    private int f2107O;

    /* JADX INFO: renamed from: P */
    private int f2108P;

    /* JADX INFO: renamed from: Q */
    private int f2109Q;

    /* JADX INFO: renamed from: R */
    private int f2110R;

    /* JADX INFO: renamed from: S */
    private boolean f2111S;

    /* JADX INFO: renamed from: T */
    private int f2112T;

    /* JADX INFO: renamed from: V */
    private ColorFilter f2114V;

    /* JADX INFO: renamed from: W */
    private PorterDuffColorFilter f2115W;

    /* JADX INFO: renamed from: X */
    private ColorStateList f2116X;

    /* JADX INFO: renamed from: Z */
    private int[] f2118Z;

    /* JADX INFO: renamed from: aa */
    private boolean f2119aa;

    /* JADX INFO: renamed from: ab */
    private ColorStateList f2120ab;

    /* JADX INFO: renamed from: ae */
    private float f2123ae;

    /* JADX INFO: renamed from: af */
    private TextUtils.TruncateAt f2124af;

    /* JADX INFO: renamed from: ag */
    private boolean f2125ag;

    /* JADX INFO: renamed from: ah */
    private int f2126ah;

    /* JADX INFO: renamed from: b */
    private ColorStateList f2127b;

    /* JADX INFO: renamed from: c */
    private float f2128c;

    /* JADX INFO: renamed from: d */
    private float f2129d;

    /* JADX INFO: renamed from: e */
    private ColorStateList f2130e;

    /* JADX INFO: renamed from: f */
    private float f2131f;

    /* JADX INFO: renamed from: g */
    private ColorStateList f2132g;

    /* JADX INFO: renamed from: i */
    private CharSequence f2134i;

    /* JADX INFO: renamed from: j */
    private C0754aw f2135j;

    /* JADX INFO: renamed from: l */
    private boolean f2137l;

    /* JADX INFO: renamed from: m */
    private Drawable f2138m;

    /* JADX INFO: renamed from: n */
    private ColorStateList f2139n;

    /* JADX INFO: renamed from: o */
    private float f2140o;

    /* JADX INFO: renamed from: p */
    private boolean f2141p;

    /* JADX INFO: renamed from: q */
    private Drawable f2142q;

    /* JADX INFO: renamed from: r */
    private ColorStateList f2143r;

    /* JADX INFO: renamed from: s */
    private float f2144s;

    /* JADX INFO: renamed from: t */
    private CharSequence f2145t;

    /* JADX INFO: renamed from: u */
    private boolean f2146u;

    /* JADX INFO: renamed from: v */
    private boolean f2147v;

    /* JADX INFO: renamed from: w */
    private Drawable f2148w;

    /* JADX INFO: renamed from: x */
    private C0005ac f2149x;

    /* JADX INFO: renamed from: y */
    private C0005ac f2150y;

    /* JADX INFO: renamed from: z */
    private float f2151z;

    /* JADX INFO: renamed from: k */
    private final ResourcesCompat.FontCallback f2136k = new ResourcesCompat.FontCallback() { // from class: android.support.design.chip.ChipDrawable.1
        @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
        public void onFontRetrievalFailed(int i) {
        }

        @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
        public void onFontRetrieved(Typeface typeface) {
            ChipDrawable.this.f2122ad = true;
            ChipDrawable.this.m2322a();
            ChipDrawable.this.invalidateSelf();
        }
    };

    /* JADX INFO: renamed from: I */
    private final TextPaint f2101I = new TextPaint(1);

    /* JADX INFO: renamed from: J */
    private final Paint f2102J = new Paint(1);

    /* JADX INFO: renamed from: L */
    private final Paint.FontMetrics f2104L = new Paint.FontMetrics();

    /* JADX INFO: renamed from: M */
    private final RectF f2105M = new RectF();

    /* JADX INFO: renamed from: N */
    private final PointF f2106N = new PointF();

    /* JADX INFO: renamed from: U */
    private int f2113U = 255;

    /* JADX INFO: renamed from: Y */
    private PorterDuff.Mode f2117Y = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: ac */
    private WeakReference<InterfaceC0234a> f2121ac = new WeakReference<>(null);

    /* JADX INFO: renamed from: ad */
    private boolean f2122ad = true;

    /* JADX INFO: renamed from: h */
    private CharSequence f2133h = "";

    /* JADX INFO: renamed from: android.support.design.chip.ChipDrawable$a */
    public interface InterfaceC0234a {
        /* JADX INFO: renamed from: a */
        void mo2273a();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: renamed from: a */
    public static ChipDrawable m2284a(Context context, AttributeSet attributeSet, int i, int i2) {
        ChipDrawable chipDrawable = new ChipDrawable(context);
        chipDrawable.m2287a(attributeSet, i, i2);
        return chipDrawable;
    }

    private ChipDrawable(Context context) {
        this.f2100H = context;
        this.f2101I.density = context.getResources().getDisplayMetrics().density;
        this.f2103K = null;
        if (this.f2103K != null) {
            this.f2103K.setStyle(Paint.Style.STROKE);
        }
        setState(f2092a);
        m2334a(f2092a);
        this.f2125ag = true;
    }

    /* JADX INFO: renamed from: a */
    private void m2287a(AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayM5390a = C0751at.m5390a(this.f2100H, attributeSet, android.support.design.R.styleable.Chip, i, i2, new int[0]);
        m2326a(C0753av.m5478a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_chipBackgroundColor));
        m2323a(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_chipMinHeight, 0.0f));
        m2336b(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_chipCornerRadius, 0.0f));
        m2339b(C0753av.m5478a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_chipStrokeColor));
        m2343c(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_chipStrokeWidth, 0.0f));
        m2345c(C0753av.m5478a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_rippleColor));
        m2332a(typedArrayM5390a.getText(android.support.design.R.styleable.Chip_android_text));
        m2331a(C0753av.m5480c(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_android_textAppearance));
        switch (typedArrayM5390a.getInt(android.support.design.R.styleable.Chip_android_ellipsize, 0)) {
            case 1:
                m2330a(TextUtils.TruncateAt.START);
                break;
            case 2:
                m2330a(TextUtils.TruncateAt.MIDDLE);
                break;
            case 3:
                m2330a(TextUtils.TruncateAt.END);
                break;
        }
        m2342b(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            m2342b(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_chipIconEnabled, false));
        }
        m2328a(C0753av.m5479b(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_chipIcon));
        m2351d(C0753av.m5478a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_chipIconTint));
        m2349d(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_chipIconSize, 0.0f));
        m2347c(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            m2347c(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_closeIconEnabled, false));
        }
        m2340b(C0753av.m5479b(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_closeIcon));
        m2357e(C0753av.m5478a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_closeIconTint));
        m2355e(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_closeIconSize, 0.0f));
        m2352d(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_android_checkable, false));
        m2358e(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            m2358e(typedArrayM5390a.getBoolean(android.support.design.R.styleable.Chip_checkedIconEnabled, false));
        }
        m2346c(C0753av.m5479b(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_checkedIcon));
        m2325a(C0005ac.m144a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_showMotionSpec));
        m2338b(C0005ac.m144a(this.f2100H, typedArrayM5390a, android.support.design.R.styleable.Chip_hideMotionSpec));
        m2360f(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_chipStartPadding, 0.0f));
        m2364g(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_iconStartPadding, 0.0f));
        m2367h(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_iconEndPadding, 0.0f));
        m2370i(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_textStartPadding, 0.0f));
        m2373j(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_textEndPadding, 0.0f));
        m2376k(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_closeIconStartPadding, 0.0f));
        m2379l(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_closeIconEndPadding, 0.0f));
        m2382m(typedArrayM5390a.getDimension(android.support.design.R.styleable.Chip_chipEndPadding, 0.0f));
        m2313C(typedArrayM5390a.getDimensionPixelSize(android.support.design.R.styleable.Chip_android_maxWidth, Integer.MAX_VALUE));
        typedArrayM5390a.recycle();
    }

    /* JADX INFO: renamed from: a */
    public void m2333a(boolean z) {
        if (this.f2119aa != z) {
            this.f2119aa = z;
            m2283S();
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2329a(InterfaceC0234a interfaceC0234a) {
        this.f2121ac = new WeakReference<>(interfaceC0234a);
    }

    /* JADX INFO: renamed from: a */
    protected void m2322a() {
        InterfaceC0234a interfaceC0234a = this.f2121ac.get();
        if (interfaceC0234a != null) {
            interfaceC0234a.mo2273a();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m2327a(RectF rectF) {
        m2301e(getBounds(), rectF);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.f2151z + m2335b() + this.f2095C + m2279O() + this.f2096D + m2280P() + this.f2099G), this.f2126ah);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return (int) this.f2128c;
    }

    /* JADX INFO: renamed from: K */
    private boolean m2275K() {
        return this.f2137l && this.f2138m != null;
    }

    /* JADX INFO: renamed from: L */
    private boolean m2276L() {
        return this.f2147v && this.f2148w != null && this.f2111S;
    }

    /* JADX INFO: renamed from: M */
    private boolean m2277M() {
        return this.f2141p && this.f2142q != null;
    }

    /* JADX INFO: renamed from: N */
    private boolean m2278N() {
        return this.f2147v && this.f2148w != null && this.f2146u;
    }

    /* JADX INFO: renamed from: b */
    float m2335b() {
        if (m2275K() || m2276L()) {
            return this.f2093A + this.f2140o + this.f2094B;
        }
        return 0.0f;
    }

    /* JADX INFO: renamed from: O */
    private float m2279O() {
        if (!this.f2122ad) {
            return this.f2123ae;
        }
        this.f2123ae = m2294c(this.f2134i);
        this.f2122ad = false;
        return this.f2123ae;
    }

    /* JADX INFO: renamed from: c */
    private float m2294c(CharSequence charSequence) {
        if (charSequence == null) {
            return 0.0f;
        }
        return this.f2101I.measureText(charSequence, 0, charSequence.length());
    }

    /* JADX INFO: renamed from: P */
    private float m2280P() {
        if (m2277M()) {
            return this.f2097E + this.f2144s + this.f2098F;
        }
        return 0.0f;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Rect bounds = getBounds();
        if (bounds.isEmpty() || getAlpha() == 0) {
            return;
        }
        int iM1292a = this.f2113U < 255 ? C0116ai.m1292a(canvas, bounds.left, bounds.top, bounds.right, bounds.bottom, this.f2113U) : 0;
        m2285a(canvas, bounds);
        m2291b(canvas, bounds);
        m2295c(canvas, bounds);
        m2297d(canvas, bounds);
        m2300e(canvas, bounds);
        if (this.f2125ag) {
            m2303f(canvas, bounds);
        }
        m2306g(canvas, bounds);
        m2307h(canvas, bounds);
        if (this.f2113U < 255) {
            canvas.restoreToCount(iM1292a);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2285a(Canvas canvas, Rect rect) {
        this.f2102J.setColor(this.f2107O);
        this.f2102J.setStyle(Paint.Style.FILL);
        this.f2102J.setColorFilter(m2282R());
        this.f2105M.set(rect);
        canvas.drawRoundRect(this.f2105M, this.f2129d, this.f2129d, this.f2102J);
    }

    /* JADX INFO: renamed from: b */
    private void m2291b(Canvas canvas, Rect rect) {
        if (this.f2131f > 0.0f) {
            this.f2102J.setColor(this.f2108P);
            this.f2102J.setStyle(Paint.Style.STROKE);
            this.f2102J.setColorFilter(m2282R());
            this.f2105M.set(rect.left + (this.f2131f / 2.0f), rect.top + (this.f2131f / 2.0f), rect.right - (this.f2131f / 2.0f), rect.bottom - (this.f2131f / 2.0f));
            float f = this.f2129d - (this.f2131f / 2.0f);
            canvas.drawRoundRect(this.f2105M, f, f, this.f2102J);
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2295c(Canvas canvas, Rect rect) {
        this.f2102J.setColor(this.f2109Q);
        this.f2102J.setStyle(Paint.Style.FILL);
        this.f2105M.set(rect);
        canvas.drawRoundRect(this.f2105M, this.f2129d, this.f2129d, this.f2102J);
    }

    /* JADX INFO: renamed from: d */
    private void m2297d(Canvas canvas, Rect rect) {
        if (m2275K()) {
            m2286a(rect, this.f2105M);
            float f = this.f2105M.left;
            float f2 = this.f2105M.top;
            canvas.translate(f, f2);
            this.f2138m.setBounds(0, 0, (int) this.f2105M.width(), (int) this.f2105M.height());
            this.f2138m.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2300e(Canvas canvas, Rect rect) {
        if (m2276L()) {
            m2286a(rect, this.f2105M);
            float f = this.f2105M.left;
            float f2 = this.f2105M.top;
            canvas.translate(f, f2);
            this.f2148w.setBounds(0, 0, (int) this.f2105M.width(), (int) this.f2105M.height());
            this.f2148w.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m2303f(Canvas canvas, Rect rect) {
        if (this.f2134i != null) {
            Paint.Align alignM2321a = m2321a(rect, this.f2106N);
            m2292b(rect, this.f2105M);
            if (this.f2135j != null) {
                this.f2101I.drawableState = getState();
                this.f2135j.m5488b(this.f2100H, this.f2101I, this.f2136k);
            }
            this.f2101I.setTextAlign(alignM2321a);
            int iSave = 0;
            boolean z = Math.round(m2279O()) > Math.round(this.f2105M.width());
            if (z) {
                iSave = canvas.save();
                canvas.clipRect(this.f2105M);
            }
            CharSequence charSequenceEllipsize = this.f2134i;
            if (z && this.f2124af != null) {
                charSequenceEllipsize = TextUtils.ellipsize(this.f2134i, this.f2101I, this.f2105M.width(), this.f2124af);
            }
            CharSequence charSequence = charSequenceEllipsize;
            canvas.drawText(charSequence, 0, charSequence.length(), this.f2106N.x, this.f2106N.y, this.f2101I);
            if (z) {
                canvas.restoreToCount(iSave);
            }
        }
    }

    /* JADX INFO: renamed from: g */
    private void m2306g(Canvas canvas, Rect rect) {
        if (m2277M()) {
            m2296c(rect, this.f2105M);
            float f = this.f2105M.left;
            float f2 = this.f2105M.top;
            canvas.translate(f, f2);
            this.f2142q.setBounds(0, 0, (int) this.f2105M.width(), (int) this.f2105M.height());
            this.f2142q.draw(canvas);
            canvas.translate(-f, -f2);
        }
    }

    /* JADX INFO: renamed from: h */
    private void m2307h(Canvas canvas, Rect rect) {
        if (this.f2103K != null) {
            this.f2103K.setColor(ColorUtils.setAlphaComponent(-16777216, 127));
            canvas.drawRect(rect, this.f2103K);
            if (m2275K() || m2276L()) {
                m2286a(rect, this.f2105M);
                canvas.drawRect(this.f2105M, this.f2103K);
            }
            if (this.f2134i != null) {
                canvas.drawLine(rect.left, rect.exactCenterY(), rect.right, rect.exactCenterY(), this.f2103K);
            }
            if (m2277M()) {
                m2296c(rect, this.f2105M);
                canvas.drawRect(this.f2105M, this.f2103K);
            }
            this.f2103K.setColor(ColorUtils.setAlphaComponent(SupportMenu.CATEGORY_MASK, 127));
            m2298d(rect, this.f2105M);
            canvas.drawRect(this.f2105M, this.f2103K);
            this.f2103K.setColor(ColorUtils.setAlphaComponent(-16711936, 127));
            m2301e(rect, this.f2105M);
            canvas.drawRect(this.f2105M, this.f2103K);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2286a(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m2275K() || m2276L()) {
            float f = this.f2151z + this.f2093A;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.f2140o;
            } else {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.f2140o;
            }
            rectF.top = rect.exactCenterY() - (this.f2140o / 2.0f);
            rectF.bottom = rectF.top + this.f2140o;
        }
    }

    /* JADX INFO: renamed from: a */
    Paint.Align m2321a(Rect rect, PointF pointF) {
        pointF.set(0.0f, 0.0f);
        Paint.Align align = Paint.Align.LEFT;
        if (this.f2134i != null) {
            float fM2335b = this.f2151z + m2335b() + this.f2095C;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                pointF.x = rect.left + fM2335b;
                align = Paint.Align.LEFT;
            } else {
                pointF.x = rect.right - fM2335b;
                align = Paint.Align.RIGHT;
            }
            pointF.y = rect.centerY() - m2281Q();
        }
        return align;
    }

    /* JADX INFO: renamed from: Q */
    private float m2281Q() {
        this.f2101I.getFontMetrics(this.f2104L);
        return (this.f2104L.descent + this.f2104L.ascent) / 2.0f;
    }

    /* JADX INFO: renamed from: b */
    private void m2292b(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (this.f2134i != null) {
            float fM2335b = this.f2151z + m2335b() + this.f2095C;
            float fM2280P = this.f2099G + m2280P() + this.f2096D;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.left = rect.left + fM2335b;
                rectF.right = rect.right - fM2280P;
            } else {
                rectF.left = rect.left + fM2280P;
                rectF.right = rect.right - fM2335b;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m2296c(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m2277M()) {
            float f = this.f2099G + this.f2098F;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f;
                rectF.left = rectF.right - this.f2144s;
            } else {
                rectF.left = rect.left + f;
                rectF.right = rectF.left + this.f2144s;
            }
            rectF.top = rect.exactCenterY() - (this.f2144s / 2.0f);
            rectF.bottom = rectF.top + this.f2144s;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m2298d(Rect rect, RectF rectF) {
        rectF.set(rect);
        if (m2277M()) {
            float f = this.f2099G + this.f2098F + this.f2144s + this.f2097E + this.f2096D;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right - f;
            } else {
                rectF.left = rect.left + f;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2301e(Rect rect, RectF rectF) {
        rectF.setEmpty();
        if (m2277M()) {
            float f = this.f2099G + this.f2098F + this.f2144s + this.f2097E + this.f2096D;
            if (DrawableCompat.getLayoutDirection(this) == 0) {
                rectF.right = rect.right;
                rectF.left = rectF.right - f;
            } else {
                rectF.left = rect.left;
                rectF.right = rect.left + f;
            }
            rectF.top = rect.top;
            rectF.bottom = rect.bottom;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return m2305f(this.f2127b) || m2305f(this.f2130e) || (this.f2119aa && m2305f(this.f2120ab)) || m2293b(this.f2135j) || m2278N() || m2299d(this.f2138m) || m2299d(this.f2148w) || m2305f(this.f2116X);
    }

    /* JADX INFO: renamed from: c */
    public boolean m2348c() {
        return m2299d(this.f2142q);
    }

    /* JADX INFO: renamed from: a */
    public boolean m2334a(int[] iArr) {
        if (Arrays.equals(this.f2118Z, iArr)) {
            return false;
        }
        this.f2118Z = iArr;
        if (m2277M()) {
            return m2290a(getState(), iArr);
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    public int[] m2353d() {
        return this.f2118Z;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        return m2290a(iArr, m2353d());
    }

    /* JADX INFO: renamed from: a */
    private boolean m2290a(int[] iArr, int[] iArr2) {
        boolean z;
        boolean zOnStateChange = super.onStateChange(iArr);
        int colorForState = this.f2127b != null ? this.f2127b.getColorForState(iArr, this.f2107O) : 0;
        if (this.f2107O != colorForState) {
            this.f2107O = colorForState;
            zOnStateChange = true;
        }
        int colorForState2 = this.f2130e != null ? this.f2130e.getColorForState(iArr, this.f2108P) : 0;
        if (this.f2108P != colorForState2) {
            this.f2108P = colorForState2;
            zOnStateChange = true;
        }
        int colorForState3 = this.f2120ab != null ? this.f2120ab.getColorForState(iArr, this.f2109Q) : 0;
        if (this.f2109Q != colorForState3) {
            this.f2109Q = colorForState3;
            if (this.f2119aa) {
                zOnStateChange = true;
            }
        }
        int colorForState4 = (this.f2135j == null || this.f2135j.f5057b == null) ? 0 : this.f2135j.f5057b.getColorForState(iArr, this.f2110R);
        if (this.f2110R != colorForState4) {
            this.f2110R = colorForState4;
            zOnStateChange = true;
        }
        boolean z2 = m2289a(getState(), R.attr.state_checked) && this.f2146u;
        if (this.f2111S == z2 || this.f2148w == null) {
            z = false;
        } else {
            float fM2335b = m2335b();
            this.f2111S = z2;
            if (fM2335b != m2335b()) {
                zOnStateChange = true;
                z = true;
            } else {
                zOnStateChange = true;
                z = false;
            }
        }
        int colorForState5 = this.f2116X != null ? this.f2116X.getColorForState(iArr, this.f2112T) : 0;
        if (this.f2112T != colorForState5) {
            this.f2112T = colorForState5;
            this.f2115W = C0212an.m2121a(this, this.f2116X, this.f2117Y);
            zOnStateChange = true;
        }
        if (m2299d(this.f2138m)) {
            zOnStateChange |= this.f2138m.setState(iArr);
        }
        if (m2299d(this.f2148w)) {
            zOnStateChange |= this.f2148w.setState(iArr);
        }
        if (m2299d(this.f2142q)) {
            zOnStateChange |= this.f2142q.setState(iArr2);
        }
        if (zOnStateChange) {
            invalidateSelf();
        }
        if (z) {
            m2322a();
        }
        return zOnStateChange;
    }

    /* JADX INFO: renamed from: f */
    private static boolean m2305f(ColorStateList colorStateList) {
        return colorStateList != null && colorStateList.isStateful();
    }

    /* JADX INFO: renamed from: d */
    private static boolean m2299d(Drawable drawable) {
        return drawable != null && drawable.isStateful();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m2293b(C0754aw c0754aw) {
        return (c0754aw == null || c0754aw.f5057b == null || !c0754aw.f5057b.isStateful()) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(23)
    public boolean onLayoutDirectionChanged(int i) {
        boolean zOnLayoutDirectionChanged = super.onLayoutDirectionChanged(i);
        if (m2275K()) {
            zOnLayoutDirectionChanged |= this.f2138m.setLayoutDirection(i);
        }
        if (m2276L()) {
            zOnLayoutDirectionChanged |= this.f2148w.setLayoutDirection(i);
        }
        if (m2277M()) {
            zOnLayoutDirectionChanged |= this.f2142q.setLayoutDirection(i);
        }
        if (!zOnLayoutDirectionChanged) {
            return true;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        boolean zOnLevelChange = super.onLevelChange(i);
        if (m2275K()) {
            zOnLevelChange |= this.f2138m.setLevel(i);
        }
        if (m2276L()) {
            zOnLevelChange |= this.f2148w.setLevel(i);
        }
        if (m2277M()) {
            zOnLevelChange |= this.f2142q.setLevel(i);
        }
        if (zOnLevelChange) {
            invalidateSelf();
        }
        return zOnLevelChange;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (m2275K()) {
            visible |= this.f2138m.setVisible(z, z2);
        }
        if (m2276L()) {
            visible |= this.f2148w.setVisible(z, z2);
        }
        if (m2277M()) {
            visible |= this.f2142q.setVisible(z, z2);
        }
        if (visible) {
            invalidateSelf();
        }
        return visible;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f2113U != i) {
            this.f2113U = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f2113U;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2114V != colorFilter) {
            this.f2114V = colorFilter;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f2114V;
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f2116X != colorStateList) {
            this.f2116X = colorStateList;
            onStateChange(getState());
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2117Y != mode) {
            this.f2117Y = mode;
            this.f2115W = C0212an.m2121a(this, this.f2116X, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    @TargetApi(21)
    public void getOutline(Outline outline) {
        Rect bounds = getBounds();
        if (!bounds.isEmpty()) {
            outline.setRoundRect(bounds, this.f2129d);
        } else {
            outline.setRoundRect(0, 0, getIntrinsicWidth(), getIntrinsicHeight(), this.f2129d);
        }
        outline.setAlpha(getAlpha() / 255.0f);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.invalidateDrawable(this);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.scheduleDrawable(this, runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        Drawable.Callback callback = getCallback();
        if (callback != null) {
            callback.unscheduleDrawable(this, runnable);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2302e(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m2304f(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(this);
            DrawableCompat.setLayoutDirection(drawable, DrawableCompat.getLayoutDirection(this));
            drawable.setLevel(getLevel());
            drawable.setVisible(isVisible(), false);
            if (drawable == this.f2142q) {
                if (drawable.isStateful()) {
                    drawable.setState(m2353d());
                }
                DrawableCompat.setTintList(drawable, this.f2143r);
            } else if (drawable.isStateful()) {
                drawable.setState(getState());
            }
        }
    }

    /* JADX INFO: renamed from: R */
    private ColorFilter m2282R() {
        return this.f2114V != null ? this.f2114V : this.f2115W;
    }

    /* JADX INFO: renamed from: S */
    private void m2283S() {
        this.f2120ab = this.f2119aa ? C0756ay.m5493a(this.f2132g) : null;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m2289a(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: e */
    public ColorStateList m2354e() {
        return this.f2127b;
    }

    /* JADX INFO: renamed from: a */
    public void m2324a(int i) {
        m2326a(C1684ee.m8972a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: a */
    public void m2326a(ColorStateList colorStateList) {
        if (this.f2127b != colorStateList) {
            this.f2127b = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: f */
    public float m2359f() {
        return this.f2128c;
    }

    /* JADX INFO: renamed from: b */
    public void m2337b(int i) {
        m2323a(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: a */
    public void m2323a(float f) {
        if (this.f2128c != f) {
            this.f2128c = f;
            invalidateSelf();
            m2322a();
        }
    }

    /* JADX INFO: renamed from: g */
    public float m2363g() {
        return this.f2129d;
    }

    /* JADX INFO: renamed from: c */
    public void m2344c(int i) {
        m2336b(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: b */
    public void m2336b(float f) {
        if (this.f2129d != f) {
            this.f2129d = f;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: h */
    public ColorStateList m2366h() {
        return this.f2130e;
    }

    /* JADX INFO: renamed from: d */
    public void m2350d(int i) {
        m2339b(C1684ee.m8972a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: b */
    public void m2339b(ColorStateList colorStateList) {
        if (this.f2130e != colorStateList) {
            this.f2130e = colorStateList;
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: i */
    public float m2369i() {
        return this.f2131f;
    }

    /* JADX INFO: renamed from: e */
    public void m2356e(int i) {
        m2343c(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: c */
    public void m2343c(float f) {
        if (this.f2131f != f) {
            this.f2131f = f;
            this.f2102J.setStrokeWidth(f);
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: j */
    public ColorStateList m2372j() {
        return this.f2132g;
    }

    /* JADX INFO: renamed from: f */
    public void m2361f(int i) {
        m2345c(C1684ee.m8972a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: c */
    public void m2345c(ColorStateList colorStateList) {
        if (this.f2132g != colorStateList) {
            this.f2132g = colorStateList;
            m2283S();
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: k */
    public CharSequence m2375k() {
        return this.f2133h;
    }

    /* JADX INFO: renamed from: a */
    public void m2332a(CharSequence charSequence) {
        if (charSequence == null) {
            charSequence = "";
        }
        if (this.f2133h != charSequence) {
            this.f2133h = charSequence;
            this.f2134i = BidiFormatter.getInstance().unicodeWrap(charSequence);
            this.f2122ad = true;
            invalidateSelf();
            m2322a();
        }
    }

    /* JADX INFO: renamed from: l */
    public C0754aw m2378l() {
        return this.f2135j;
    }

    /* JADX INFO: renamed from: g */
    public void m2365g(int i) {
        m2331a(new C0754aw(this.f2100H, i));
    }

    /* JADX INFO: renamed from: a */
    public void m2331a(C0754aw c0754aw) {
        if (this.f2135j != c0754aw) {
            this.f2135j = c0754aw;
            if (c0754aw != null) {
                c0754aw.m5489c(this.f2100H, this.f2101I, this.f2136k);
                this.f2122ad = true;
            }
            onStateChange(getState());
            m2322a();
        }
    }

    /* JADX INFO: renamed from: m */
    public TextUtils.TruncateAt m2381m() {
        return this.f2124af;
    }

    /* JADX INFO: renamed from: a */
    public void m2330a(TextUtils.TruncateAt truncateAt) {
        this.f2124af = truncateAt;
    }

    /* JADX INFO: renamed from: n */
    public boolean m2385n() {
        return this.f2137l;
    }

    /* JADX INFO: renamed from: h */
    public void m2368h(int i) {
        m2342b(this.f2100H.getResources().getBoolean(i));
    }

    /* JADX INFO: renamed from: b */
    public void m2342b(boolean z) {
        if (this.f2137l != z) {
            boolean zM2275K = m2275K();
            this.f2137l = z;
            boolean zM2275K2 = m2275K();
            if (zM2275K != zM2275K2) {
                if (zM2275K2) {
                    m2304f(this.f2138m);
                } else {
                    m2302e(this.f2138m);
                }
                invalidateSelf();
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public Drawable m2386o() {
        if (this.f2138m != null) {
            return DrawableCompat.unwrap(this.f2138m);
        }
        return null;
    }

    /* JADX INFO: renamed from: i */
    public void m2371i(int i) {
        m2328a(C1684ee.m8975b(this.f2100H, i));
    }

    /* JADX INFO: renamed from: a */
    public void m2328a(Drawable drawable) {
        Drawable drawableM2386o = m2386o();
        if (drawableM2386o != drawable) {
            float fM2335b = m2335b();
            this.f2138m = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fM2335b2 = m2335b();
            m2302e(drawableM2386o);
            if (m2275K()) {
                m2304f(this.f2138m);
            }
            invalidateSelf();
            if (fM2335b != fM2335b2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: p */
    public ColorStateList m2388p() {
        return this.f2139n;
    }

    /* JADX INFO: renamed from: j */
    public void m2374j(int i) {
        m2351d(C1684ee.m8972a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: d */
    public void m2351d(ColorStateList colorStateList) {
        if (this.f2139n != colorStateList) {
            this.f2139n = colorStateList;
            if (m2275K()) {
                DrawableCompat.setTintList(this.f2138m, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: q */
    public float m2390q() {
        return this.f2140o;
    }

    /* JADX INFO: renamed from: k */
    public void m2377k(int i) {
        m2349d(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: d */
    public void m2349d(float f) {
        if (this.f2140o != f) {
            float fM2335b = m2335b();
            this.f2140o = f;
            float fM2335b2 = m2335b();
            invalidateSelf();
            if (fM2335b != fM2335b2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: r */
    public boolean m2393r() {
        return this.f2141p;
    }

    /* JADX INFO: renamed from: l */
    public void m2380l(int i) {
        m2347c(this.f2100H.getResources().getBoolean(i));
    }

    /* JADX INFO: renamed from: c */
    public void m2347c(boolean z) {
        if (this.f2141p != z) {
            boolean zM2277M = m2277M();
            this.f2141p = z;
            boolean zM2277M2 = m2277M();
            if (zM2277M != zM2277M2) {
                if (zM2277M2) {
                    m2304f(this.f2142q);
                } else {
                    m2302e(this.f2142q);
                }
                invalidateSelf();
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: s */
    public Drawable m2394s() {
        if (this.f2142q != null) {
            return DrawableCompat.unwrap(this.f2142q);
        }
        return null;
    }

    /* JADX INFO: renamed from: m */
    public void m2383m(int i) {
        m2340b(C1684ee.m8975b(this.f2100H, i));
    }

    /* JADX INFO: renamed from: b */
    public void m2340b(Drawable drawable) {
        Drawable drawableM2394s = m2394s();
        if (drawableM2394s != drawable) {
            float fM2280P = m2280P();
            this.f2142q = drawable != null ? DrawableCompat.wrap(drawable).mutate() : null;
            float fM2280P2 = m2280P();
            m2302e(drawableM2394s);
            if (m2277M()) {
                m2304f(this.f2142q);
            }
            invalidateSelf();
            if (fM2280P != fM2280P2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: t */
    public ColorStateList m2396t() {
        return this.f2143r;
    }

    /* JADX INFO: renamed from: n */
    public void m2384n(int i) {
        m2357e(C1684ee.m8972a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: e */
    public void m2357e(ColorStateList colorStateList) {
        if (this.f2143r != colorStateList) {
            this.f2143r = colorStateList;
            if (m2277M()) {
                DrawableCompat.setTintList(this.f2142q, colorStateList);
            }
            onStateChange(getState());
        }
    }

    /* JADX INFO: renamed from: u */
    public float m2398u() {
        return this.f2144s;
    }

    /* JADX INFO: renamed from: o */
    public void m2387o(int i) {
        m2355e(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: e */
    public void m2355e(float f) {
        if (this.f2144s != f) {
            this.f2144s = f;
            invalidateSelf();
            if (m2277M()) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m2341b(CharSequence charSequence) {
        if (this.f2145t != charSequence) {
            this.f2145t = BidiFormatter.getInstance().unicodeWrap(charSequence);
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: v */
    public CharSequence m2400v() {
        return this.f2145t;
    }

    /* JADX INFO: renamed from: w */
    public boolean m2403w() {
        return this.f2146u;
    }

    /* JADX INFO: renamed from: p */
    public void m2389p(int i) {
        m2352d(this.f2100H.getResources().getBoolean(i));
    }

    /* JADX INFO: renamed from: d */
    public void m2352d(boolean z) {
        if (this.f2146u != z) {
            this.f2146u = z;
            float fM2335b = m2335b();
            if (!z && this.f2111S) {
                this.f2111S = false;
            }
            float fM2335b2 = m2335b();
            invalidateSelf();
            if (fM2335b != fM2335b2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: x */
    public boolean m2405x() {
        return this.f2147v;
    }

    /* JADX INFO: renamed from: q */
    public void m2391q(int i) {
        m2358e(this.f2100H.getResources().getBoolean(i));
    }

    /* JADX INFO: renamed from: e */
    public void m2358e(boolean z) {
        if (this.f2147v != z) {
            boolean zM2276L = m2276L();
            this.f2147v = z;
            boolean zM2276L2 = m2276L();
            if (zM2276L != zM2276L2) {
                if (zM2276L2) {
                    m2304f(this.f2148w);
                } else {
                    m2302e(this.f2148w);
                }
                invalidateSelf();
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: y */
    public Drawable m2406y() {
        return this.f2148w;
    }

    /* JADX INFO: renamed from: r */
    public void m2392r(int i) {
        m2346c(C1684ee.m8975b(this.f2100H, i));
    }

    /* JADX INFO: renamed from: c */
    public void m2346c(Drawable drawable) {
        if (this.f2148w != drawable) {
            float fM2335b = m2335b();
            this.f2148w = drawable;
            float fM2335b2 = m2335b();
            m2302e(this.f2148w);
            m2304f(this.f2148w);
            invalidateSelf();
            if (fM2335b != fM2335b2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: z */
    public C0005ac m2408z() {
        return this.f2149x;
    }

    /* JADX INFO: renamed from: s */
    public void m2395s(int i) {
        m2325a(C0005ac.m143a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: a */
    public void m2325a(C0005ac c0005ac) {
        this.f2149x = c0005ac;
    }

    /* JADX INFO: renamed from: A */
    public C0005ac m2308A() {
        return this.f2150y;
    }

    /* JADX INFO: renamed from: t */
    public void m2397t(int i) {
        m2338b(C0005ac.m143a(this.f2100H, i));
    }

    /* JADX INFO: renamed from: b */
    public void m2338b(C0005ac c0005ac) {
        this.f2150y = c0005ac;
    }

    /* JADX INFO: renamed from: B */
    public float m2310B() {
        return this.f2151z;
    }

    /* JADX INFO: renamed from: u */
    public void m2399u(int i) {
        m2360f(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: f */
    public void m2360f(float f) {
        if (this.f2151z != f) {
            this.f2151z = f;
            invalidateSelf();
            m2322a();
        }
    }

    /* JADX INFO: renamed from: C */
    public float m2312C() {
        return this.f2093A;
    }

    /* JADX INFO: renamed from: v */
    public void m2401v(int i) {
        m2364g(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: g */
    public void m2364g(float f) {
        if (this.f2093A != f) {
            float fM2335b = m2335b();
            this.f2093A = f;
            float fM2335b2 = m2335b();
            invalidateSelf();
            if (fM2335b != fM2335b2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: D */
    public float m2314D() {
        return this.f2094B;
    }

    /* JADX INFO: renamed from: w */
    public void m2402w(int i) {
        m2367h(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: h */
    public void m2367h(float f) {
        if (this.f2094B != f) {
            float fM2335b = m2335b();
            this.f2094B = f;
            float fM2335b2 = m2335b();
            invalidateSelf();
            if (fM2335b != fM2335b2) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: E */
    public float m2315E() {
        return this.f2095C;
    }

    /* JADX INFO: renamed from: x */
    public void m2404x(int i) {
        m2370i(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: i */
    public void m2370i(float f) {
        if (this.f2095C != f) {
            this.f2095C = f;
            invalidateSelf();
            m2322a();
        }
    }

    /* JADX INFO: renamed from: F */
    public float m2316F() {
        return this.f2096D;
    }

    /* JADX INFO: renamed from: y */
    public void m2407y(int i) {
        m2373j(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: j */
    public void m2373j(float f) {
        if (this.f2096D != f) {
            this.f2096D = f;
            invalidateSelf();
            m2322a();
        }
    }

    /* JADX INFO: renamed from: G */
    public float m2317G() {
        return this.f2097E;
    }

    /* JADX INFO: renamed from: z */
    public void m2409z(int i) {
        m2376k(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: k */
    public void m2376k(float f) {
        if (this.f2097E != f) {
            this.f2097E = f;
            invalidateSelf();
            if (m2277M()) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: H */
    public float m2318H() {
        return this.f2098F;
    }

    /* JADX INFO: renamed from: A */
    public void m2309A(int i) {
        m2379l(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: l */
    public void m2379l(float f) {
        if (this.f2098F != f) {
            this.f2098F = f;
            invalidateSelf();
            if (m2277M()) {
                m2322a();
            }
        }
    }

    /* JADX INFO: renamed from: I */
    public float m2319I() {
        return this.f2099G;
    }

    /* JADX INFO: renamed from: B */
    public void m2311B(int i) {
        m2382m(this.f2100H.getResources().getDimension(i));
    }

    /* JADX INFO: renamed from: m */
    public void m2382m(float f) {
        if (this.f2099G != f) {
            this.f2099G = f;
            invalidateSelf();
            m2322a();
        }
    }

    /* JADX INFO: renamed from: C */
    public void m2313C(int i) {
        this.f2126ah = i;
    }

    /* JADX INFO: renamed from: J */
    boolean m2320J() {
        return this.f2125ag;
    }

    /* JADX INFO: renamed from: f */
    void m2362f(boolean z) {
        this.f2125ag = z;
    }
}
