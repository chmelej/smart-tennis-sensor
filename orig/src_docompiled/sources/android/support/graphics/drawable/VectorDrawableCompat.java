package android.support.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.content.res.ComplexColorCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.PathParser;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.AbstractC0787cb;
import p000.C0780bv;

/* JADX INFO: loaded from: classes.dex */
public class VectorDrawableCompat extends AbstractC0787cb {

    /* JADX INFO: renamed from: a */
    static final PorterDuff.Mode f2705a = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: b */
    private C0326g f2706b;

    /* JADX INFO: renamed from: d */
    private PorterDuffColorFilter f2707d;

    /* JADX INFO: renamed from: e */
    private ColorFilter f2708e;

    /* JADX INFO: renamed from: f */
    private boolean f2709f;

    /* JADX INFO: renamed from: g */
    private boolean f2710g;

    /* JADX INFO: renamed from: h */
    private Drawable.ConstantState f2711h;

    /* JADX INFO: renamed from: i */
    private final float[] f2712i;

    /* JADX INFO: renamed from: j */
    private final Matrix f2713j;

    /* JADX INFO: renamed from: k */
    private final Rect f2714k;

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ ColorFilter getColorFilter() {
        return super.getColorFilter();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    VectorDrawableCompat() {
        this.f2710g = true;
        this.f2712i = new float[9];
        this.f2713j = new Matrix();
        this.f2714k = new Rect();
        this.f2706b = new C0326g();
    }

    VectorDrawableCompat(C0326g c0326g) {
        this.f2710g = true;
        this.f2712i = new float[9];
        this.f2713j = new Matrix();
        this.f2714k = new Rect();
        this.f2706b = c0326g;
        this.f2707d = m2939a(this.f2707d, c0326g.f2763c, c0326g.f2764d);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f5320c != null) {
            this.f5320c.mutate();
            return this;
        }
        if (!this.f2709f && super.mutate() == this) {
            this.f2706b = new C0326g(this.f2706b);
            this.f2709f = true;
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    Object m2940a(String str) {
        return this.f2706b.f2762b.f2755k.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f5320c != null && Build.VERSION.SDK_INT >= 24) {
            return new C0327h(this.f5320c.getConstantState());
        }
        this.f2706b.f2761a = getChangingConfigurations();
        return this.f2706b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5320c != null) {
            this.f5320c.draw(canvas);
            return;
        }
        copyBounds(this.f2714k);
        if (this.f2714k.width() <= 0 || this.f2714k.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.f2708e == null ? this.f2707d : this.f2708e;
        canvas.getMatrix(this.f2713j);
        this.f2713j.getValues(this.f2712i);
        float fAbs = Math.abs(this.f2712i[0]);
        float fAbs2 = Math.abs(this.f2712i[4]);
        float fAbs3 = Math.abs(this.f2712i[1]);
        float fAbs4 = Math.abs(this.f2712i[3]);
        if (fAbs3 != 0.0f || fAbs4 != 0.0f) {
            fAbs = 1.0f;
            fAbs2 = 1.0f;
        }
        int iMin = Math.min(2048, (int) (this.f2714k.width() * fAbs));
        int iMin2 = Math.min(2048, (int) (this.f2714k.height() * fAbs2));
        if (iMin <= 0 || iMin2 <= 0) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(this.f2714k.left, this.f2714k.top);
        if (m2937a()) {
            canvas.translate(this.f2714k.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.f2714k.offsetTo(0, 0);
        this.f2706b.m2967b(iMin, iMin2);
        if (!this.f2710g) {
            this.f2706b.m2963a(iMin, iMin2);
        } else if (!this.f2706b.m2968b()) {
            this.f2706b.m2963a(iMin, iMin2);
            this.f2706b.m2969c();
        }
        this.f2706b.m2964a(canvas, colorFilter, this.f2714k);
        canvas.restoreToCount(iSave);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f5320c != null) {
            return DrawableCompat.getAlpha(this.f5320c);
        }
        return this.f2706b.f2762b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f5320c != null) {
            this.f5320c.setAlpha(i);
        } else if (this.f2706b.f2762b.getRootAlpha() != i) {
            this.f2706b.f2762b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f5320c != null) {
            this.f5320c.setColorFilter(colorFilter);
        } else {
            this.f2708e = colorFilter;
            invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: a */
    PorterDuffColorFilter m2939a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.f5320c != null) {
            DrawableCompat.setTint(this.f5320c, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f5320c != null) {
            DrawableCompat.setTintList(this.f5320c, colorStateList);
            return;
        }
        C0326g c0326g = this.f2706b;
        if (c0326g.f2763c != colorStateList) {
            c0326g.f2763c = colorStateList;
            this.f2707d = m2939a(this.f2707d, colorStateList, c0326g.f2764d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f5320c != null) {
            DrawableCompat.setTintMode(this.f5320c, mode);
            return;
        }
        C0326g c0326g = this.f2706b;
        if (c0326g.f2764d != mode) {
            c0326g.f2764d = mode;
            this.f2707d = m2939a(this.f2707d, c0326g.f2763c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f5320c != null) {
            return this.f5320c.isStateful();
        }
        return super.isStateful() || (this.f2706b != null && (this.f2706b.m2971d() || (this.f2706b.f2763c != null && this.f2706b.f2763c.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f5320c != null) {
            return this.f5320c.setState(iArr);
        }
        boolean z = false;
        C0326g c0326g = this.f2706b;
        if (c0326g.f2763c != null && c0326g.f2764d != null) {
            this.f2707d = m2939a(this.f2707d, c0326g.f2763c, c0326g.f2764d);
            invalidateSelf();
            z = true;
        }
        if (!c0326g.m2971d() || !c0326g.m2966a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f5320c != null) {
            return this.f5320c.getOpacity();
        }
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f5320c != null) {
            return this.f5320c.getIntrinsicWidth();
        }
        return (int) this.f2706b.f2762b.f2748d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f5320c != null) {
            return this.f5320c.getIntrinsicHeight();
        }
        return (int) this.f2706b.f2762b.f2749e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f5320c == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(this.f5320c);
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f5320c != null) {
            return DrawableCompat.isAutoMirrored(this.f5320c);
        }
        return this.f2706b.f2765e;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f5320c != null) {
            DrawableCompat.setAutoMirrored(this.f5320c, z);
        } else {
            this.f2706b.f2765e = z;
        }
    }

    /* JADX INFO: renamed from: a */
    public static VectorDrawableCompat m2934a(Resources resources, int i, Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f5320c = ResourcesCompat.getDrawable(resources, i, theme);
            vectorDrawableCompat.f2711h = new C0327h(vectorDrawableCompat.f5320c.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i);
            AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next != 2) {
                throw new XmlPullParserException("No start tag found");
            }
            return m2935a(resources, xml, attributeSetAsAttributeSet, theme);
        } catch (IOException e) {
            Log.e("VectorDrawableCompat", "parser error", e);
            return null;
        } catch (XmlPullParserException e2) {
            Log.e("VectorDrawableCompat", "parser error", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static VectorDrawableCompat m2935a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    /* JADX INFO: renamed from: a */
    static int m2932a(int i, float f) {
        return (i & ViewCompat.MEASURED_SIZE_MASK) | (((int) (Color.alpha(i) * f)) << 24);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        if (this.f5320c != null) {
            this.f5320c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f5320c != null) {
            DrawableCompat.inflate(this.f5320c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0326g c0326g = this.f2706b;
        c0326g.f2762b = new C0325f();
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5304a);
        m2936a(typedArrayObtainAttributes, xmlPullParser);
        typedArrayObtainAttributes.recycle();
        c0326g.f2761a = getChangingConfigurations();
        c0326g.f2771k = true;
        m2938b(resources, xmlPullParser, attributeSet, theme);
        this.f2707d = m2939a(this.f2707d, c0326g.f2763c, c0326g.f2764d);
    }

    /* JADX INFO: renamed from: a */
    private static PorterDuff.Mode m2933a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2936a(TypedArray typedArray, XmlPullParser xmlPullParser) throws XmlPullParserException {
        C0326g c0326g = this.f2706b;
        C0325f c0325f = c0326g.f2762b;
        c0326g.f2764d = m2933a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList colorStateList = typedArray.getColorStateList(1);
        if (colorStateList != null) {
            c0326g.f2763c = colorStateList;
        }
        c0326g.f2765e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, c0326g.f2765e);
        c0325f.f2750f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, c0325f.f2750f);
        c0325f.f2751g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, c0325f.f2751g);
        if (c0325f.f2750f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (c0325f.f2751g <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        c0325f.f2748d = typedArray.getDimension(3, c0325f.f2748d);
        c0325f.f2749e = typedArray.getDimension(2, c0325f.f2749e);
        if (c0325f.f2748d <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (c0325f.f2749e <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        c0325f.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, c0325f.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            c0325f.f2753i = string;
            c0325f.f2755k.put(string, c0325f);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2938b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        C0326g c0326g = this.f2706b;
        C0325f c0325f = c0326g.f2762b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(c0325f.f2747c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0322c c0322c = (C0322c) arrayDeque.peek();
                if ("path".equals(name)) {
                    C0321b c0321b = new C0321b();
                    c0321b.m2948a(resources, attributeSet, theme, xmlPullParser);
                    c0322c.f2729b.add(c0321b);
                    if (c0321b.getPathName() != null) {
                        c0325f.f2755k.put(c0321b.getPathName(), c0321b);
                    }
                    z = false;
                    c0326g.f2761a = c0321b.f2743o | c0326g.f2761a;
                } else if ("clip-path".equals(name)) {
                    C0320a c0320a = new C0320a();
                    c0320a.m2943a(resources, attributeSet, theme, xmlPullParser);
                    c0322c.f2729b.add(c0320a);
                    if (c0320a.getPathName() != null) {
                        c0325f.f2755k.put(c0320a.getPathName(), c0320a);
                    }
                    c0326g.f2761a = c0320a.f2743o | c0326g.f2761a;
                } else if ("group".equals(name)) {
                    C0322c c0322c2 = new C0322c();
                    c0322c2.m2953a(resources, attributeSet, theme, xmlPullParser);
                    c0322c.f2729b.add(c0322c2);
                    arrayDeque.push(c0322c2);
                    if (c0322c2.getGroupName() != null) {
                        c0325f.f2755k.put(c0322c2.getGroupName(), c0322c2);
                    }
                    c0326g.f2761a = c0322c2.f2732e | c0326g.f2761a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* JADX INFO: renamed from: a */
    void m2941a(boolean z) {
        this.f2710g = z;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2937a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1;
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f5320c != null) {
            this.f5320c.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f5320c != null) {
            return this.f5320c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2706b.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        if (this.f5320c != null) {
            this.f5320c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f5320c != null) {
            this.f5320c.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f5320c != null) {
            return this.f5320c.setVisible(z, z2);
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        if (this.f5320c != null) {
            this.f5320c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$h */
    static class C0327h extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f2773a;

        public C0327h(Drawable.ConstantState constantState) {
            this.f2773a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f5320c = (VectorDrawable) this.f2773a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f5320c = (VectorDrawable) this.f2773a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f5320c = (VectorDrawable) this.f2773a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2773a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2773a.getChangingConfigurations();
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$g */
    static class C0326g extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f2761a;

        /* JADX INFO: renamed from: b */
        C0325f f2762b;

        /* JADX INFO: renamed from: c */
        ColorStateList f2763c;

        /* JADX INFO: renamed from: d */
        PorterDuff.Mode f2764d;

        /* JADX INFO: renamed from: e */
        boolean f2765e;

        /* JADX INFO: renamed from: f */
        Bitmap f2766f;

        /* JADX INFO: renamed from: g */
        ColorStateList f2767g;

        /* JADX INFO: renamed from: h */
        PorterDuff.Mode f2768h;

        /* JADX INFO: renamed from: i */
        int f2769i;

        /* JADX INFO: renamed from: j */
        boolean f2770j;

        /* JADX INFO: renamed from: k */
        boolean f2771k;

        /* JADX INFO: renamed from: l */
        Paint f2772l;

        public C0326g(C0326g c0326g) {
            this.f2763c = null;
            this.f2764d = VectorDrawableCompat.f2705a;
            if (c0326g != null) {
                this.f2761a = c0326g.f2761a;
                this.f2762b = new C0325f(c0326g.f2762b);
                if (c0326g.f2762b.f2746b != null) {
                    this.f2762b.f2746b = new Paint(c0326g.f2762b.f2746b);
                }
                if (c0326g.f2762b.f2745a != null) {
                    this.f2762b.f2745a = new Paint(c0326g.f2762b.f2745a);
                }
                this.f2763c = c0326g.f2763c;
                this.f2764d = c0326g.f2764d;
                this.f2765e = c0326g.f2765e;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m2964a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f2766f, (Rect) null, rect, m2962a(colorFilter));
        }

        /* JADX INFO: renamed from: a */
        public boolean m2965a() {
            return this.f2762b.getRootAlpha() < 255;
        }

        /* JADX INFO: renamed from: a */
        public Paint m2962a(ColorFilter colorFilter) {
            if (!m2965a() && colorFilter == null) {
                return null;
            }
            if (this.f2772l == null) {
                this.f2772l = new Paint();
                this.f2772l.setFilterBitmap(true);
            }
            this.f2772l.setAlpha(this.f2762b.getRootAlpha());
            this.f2772l.setColorFilter(colorFilter);
            return this.f2772l;
        }

        /* JADX INFO: renamed from: a */
        public void m2963a(int i, int i2) {
            this.f2766f.eraseColor(0);
            this.f2762b.m2959a(new Canvas(this.f2766f), i, i2, (ColorFilter) null);
        }

        /* JADX INFO: renamed from: b */
        public void m2967b(int i, int i2) {
            if (this.f2766f == null || !m2970c(i, i2)) {
                this.f2766f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f2771k = true;
            }
        }

        /* JADX INFO: renamed from: c */
        public boolean m2970c(int i, int i2) {
            return i == this.f2766f.getWidth() && i2 == this.f2766f.getHeight();
        }

        /* JADX INFO: renamed from: b */
        public boolean m2968b() {
            return !this.f2771k && this.f2767g == this.f2763c && this.f2768h == this.f2764d && this.f2770j == this.f2765e && this.f2769i == this.f2762b.getRootAlpha();
        }

        /* JADX INFO: renamed from: c */
        public void m2969c() {
            this.f2767g = this.f2763c;
            this.f2768h = this.f2764d;
            this.f2769i = this.f2762b.getRootAlpha();
            this.f2770j = this.f2765e;
            this.f2771k = false;
        }

        public C0326g() {
            this.f2763c = null;
            this.f2764d = VectorDrawableCompat.f2705a;
            this.f2762b = new C0325f();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2761a;
        }

        /* JADX INFO: renamed from: d */
        public boolean m2971d() {
            return this.f2762b.m2960a();
        }

        /* JADX INFO: renamed from: a */
        public boolean m2966a(int[] iArr) {
            boolean zM2961a = this.f2762b.m2961a(iArr);
            this.f2771k |= zM2961a;
            return zM2961a;
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$f */
    static class C0325f {

        /* JADX INFO: renamed from: n */
        private static final Matrix f2744n = new Matrix();

        /* JADX INFO: renamed from: a */
        Paint f2745a;

        /* JADX INFO: renamed from: b */
        Paint f2746b;

        /* JADX INFO: renamed from: c */
        final C0322c f2747c;

        /* JADX INFO: renamed from: d */
        float f2748d;

        /* JADX INFO: renamed from: e */
        float f2749e;

        /* JADX INFO: renamed from: f */
        float f2750f;

        /* JADX INFO: renamed from: g */
        float f2751g;

        /* JADX INFO: renamed from: h */
        int f2752h;

        /* JADX INFO: renamed from: i */
        String f2753i;

        /* JADX INFO: renamed from: j */
        Boolean f2754j;

        /* JADX INFO: renamed from: k */
        final ArrayMap<String, Object> f2755k;

        /* JADX INFO: renamed from: l */
        private final Path f2756l;

        /* JADX INFO: renamed from: m */
        private final Path f2757m;

        /* JADX INFO: renamed from: o */
        private final Matrix f2758o;

        /* JADX INFO: renamed from: p */
        private PathMeasure f2759p;

        /* JADX INFO: renamed from: q */
        private int f2760q;

        /* JADX INFO: renamed from: a */
        private static float m2955a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        public C0325f() {
            this.f2758o = new Matrix();
            this.f2748d = 0.0f;
            this.f2749e = 0.0f;
            this.f2750f = 0.0f;
            this.f2751g = 0.0f;
            this.f2752h = 255;
            this.f2753i = null;
            this.f2754j = null;
            this.f2755k = new ArrayMap<>();
            this.f2747c = new C0322c();
            this.f2756l = new Path();
            this.f2757m = new Path();
        }

        public void setRootAlpha(int i) {
            this.f2752h = i;
        }

        public int getRootAlpha() {
            return this.f2752h;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public C0325f(C0325f c0325f) {
            this.f2758o = new Matrix();
            this.f2748d = 0.0f;
            this.f2749e = 0.0f;
            this.f2750f = 0.0f;
            this.f2751g = 0.0f;
            this.f2752h = 255;
            this.f2753i = null;
            this.f2754j = null;
            this.f2755k = new ArrayMap<>();
            this.f2747c = new C0322c(c0325f.f2747c, this.f2755k);
            this.f2756l = new Path(c0325f.f2756l);
            this.f2757m = new Path(c0325f.f2757m);
            this.f2748d = c0325f.f2748d;
            this.f2749e = c0325f.f2749e;
            this.f2750f = c0325f.f2750f;
            this.f2751g = c0325f.f2751g;
            this.f2760q = c0325f.f2760q;
            this.f2752h = c0325f.f2752h;
            this.f2753i = c0325f.f2753i;
            if (c0325f.f2753i != null) {
                this.f2755k.put(c0325f.f2753i, this);
            }
            this.f2754j = c0325f.f2754j;
        }

        /* JADX INFO: renamed from: a */
        private void m2957a(C0322c c0322c, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            c0322c.f2728a.set(matrix);
            c0322c.f2728a.preConcat(c0322c.f2731d);
            canvas.save();
            for (int i3 = 0; i3 < c0322c.f2729b.size(); i3++) {
                AbstractC0323d abstractC0323d = c0322c.f2729b.get(i3);
                if (abstractC0323d instanceof C0322c) {
                    m2957a((C0322c) abstractC0323d, c0322c.f2728a, canvas, i, i2, colorFilter);
                } else if (abstractC0323d instanceof AbstractC0324e) {
                    m2958a(c0322c, (AbstractC0324e) abstractC0323d, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* JADX INFO: renamed from: a */
        public void m2959a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m2957a(this.f2747c, f2744n, canvas, i, i2, colorFilter);
        }

        /* JADX INFO: renamed from: a */
        private void m2958a(C0322c c0322c, AbstractC0324e abstractC0324e, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = i / this.f2750f;
            float f2 = i2 / this.f2751g;
            float fMin = Math.min(f, f2);
            Matrix matrix = c0322c.f2728a;
            this.f2758o.set(matrix);
            this.f2758o.postScale(f, f2);
            float fM2956a = m2956a(matrix);
            if (fM2956a == 0.0f) {
                return;
            }
            abstractC0324e.m2954a(this.f2756l);
            Path path = this.f2756l;
            this.f2757m.reset();
            if (abstractC0324e.mo2944a()) {
                this.f2757m.addPath(path, this.f2758o);
                canvas.clipPath(this.f2757m);
                return;
            }
            C0321b c0321b = (C0321b) abstractC0324e;
            if (c0321b.f2721g != 0.0f || c0321b.f2722h != 1.0f) {
                float f3 = (c0321b.f2721g + c0321b.f2723i) % 1.0f;
                float f4 = (c0321b.f2722h + c0321b.f2723i) % 1.0f;
                if (this.f2759p == null) {
                    this.f2759p = new PathMeasure();
                }
                this.f2759p.setPath(this.f2756l, false);
                float length = this.f2759p.getLength();
                float f5 = f3 * length;
                float f6 = f4 * length;
                path.reset();
                if (f5 > f6) {
                    this.f2759p.getSegment(f5, length, path, true);
                    this.f2759p.getSegment(0.0f, f6, path, true);
                } else {
                    this.f2759p.getSegment(f5, f6, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f2757m.addPath(path, this.f2758o);
            if (c0321b.f2717c.willDraw()) {
                ComplexColorCompat complexColorCompat = c0321b.f2717c;
                if (this.f2746b == null) {
                    this.f2746b = new Paint(1);
                    this.f2746b.setStyle(Paint.Style.FILL);
                }
                Paint paint = this.f2746b;
                if (complexColorCompat.isGradient()) {
                    Shader shader = complexColorCompat.getShader();
                    shader.setLocalMatrix(this.f2758o);
                    paint.setShader(shader);
                    paint.setAlpha(Math.round(c0321b.f2720f * 255.0f));
                } else {
                    paint.setColor(VectorDrawableCompat.m2932a(complexColorCompat.getColor(), c0321b.f2720f));
                }
                paint.setColorFilter(colorFilter);
                this.f2757m.setFillType(c0321b.f2719e == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f2757m, paint);
            }
            if (c0321b.f2715a.willDraw()) {
                ComplexColorCompat complexColorCompat2 = c0321b.f2715a;
                if (this.f2745a == null) {
                    this.f2745a = new Paint(1);
                    this.f2745a.setStyle(Paint.Style.STROKE);
                }
                Paint paint2 = this.f2745a;
                if (c0321b.f2725k != null) {
                    paint2.setStrokeJoin(c0321b.f2725k);
                }
                if (c0321b.f2724j != null) {
                    paint2.setStrokeCap(c0321b.f2724j);
                }
                paint2.setStrokeMiter(c0321b.f2726l);
                if (complexColorCompat2.isGradient()) {
                    Shader shader2 = complexColorCompat2.getShader();
                    shader2.setLocalMatrix(this.f2758o);
                    paint2.setShader(shader2);
                    paint2.setAlpha(Math.round(c0321b.f2718d * 255.0f));
                } else {
                    paint2.setColor(VectorDrawableCompat.m2932a(complexColorCompat2.getColor(), c0321b.f2718d));
                }
                paint2.setColorFilter(colorFilter);
                paint2.setStrokeWidth(c0321b.f2716b * fMin * fM2956a);
                canvas.drawPath(this.f2757m, paint2);
            }
        }

        /* JADX INFO: renamed from: a */
        private float m2956a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float fHypot = (float) Math.hypot(fArr[0], fArr[1]);
            float fHypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float fM2955a = m2955a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float fMax = Math.max(fHypot, fHypot2);
            if (fMax > 0.0f) {
                return Math.abs(fM2955a) / fMax;
            }
            return 0.0f;
        }

        /* JADX INFO: renamed from: a */
        public boolean m2960a() {
            if (this.f2754j == null) {
                this.f2754j = Boolean.valueOf(this.f2747c.mo2950b());
            }
            return this.f2754j.booleanValue();
        }

        /* JADX INFO: renamed from: a */
        public boolean m2961a(int[] iArr) {
            return this.f2747c.mo2949a(iArr);
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$d */
    static abstract class AbstractC0323d {
        /* JADX INFO: renamed from: a */
        public boolean mo2949a(int[] iArr) {
            return false;
        }

        /* JADX INFO: renamed from: b */
        public boolean mo2950b() {
            return false;
        }

        private AbstractC0323d() {
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$c */
    static class C0322c extends AbstractC0323d {

        /* JADX INFO: renamed from: a */
        final Matrix f2728a;

        /* JADX INFO: renamed from: b */
        final ArrayList<AbstractC0323d> f2729b;

        /* JADX INFO: renamed from: c */
        float f2730c;

        /* JADX INFO: renamed from: d */
        final Matrix f2731d;

        /* JADX INFO: renamed from: e */
        int f2732e;

        /* JADX INFO: renamed from: f */
        private float f2733f;

        /* JADX INFO: renamed from: g */
        private float f2734g;

        /* JADX INFO: renamed from: h */
        private float f2735h;

        /* JADX INFO: renamed from: i */
        private float f2736i;

        /* JADX INFO: renamed from: j */
        private float f2737j;

        /* JADX INFO: renamed from: k */
        private float f2738k;

        /* JADX INFO: renamed from: l */
        private int[] f2739l;

        /* JADX INFO: renamed from: m */
        private String f2740m;

        public C0322c(C0322c c0322c, ArrayMap<String, Object> arrayMap) {
            AbstractC0324e c0320a;
            super();
            this.f2728a = new Matrix();
            this.f2729b = new ArrayList<>();
            this.f2730c = 0.0f;
            this.f2733f = 0.0f;
            this.f2734g = 0.0f;
            this.f2735h = 1.0f;
            this.f2736i = 1.0f;
            this.f2737j = 0.0f;
            this.f2738k = 0.0f;
            this.f2731d = new Matrix();
            this.f2740m = null;
            this.f2730c = c0322c.f2730c;
            this.f2733f = c0322c.f2733f;
            this.f2734g = c0322c.f2734g;
            this.f2735h = c0322c.f2735h;
            this.f2736i = c0322c.f2736i;
            this.f2737j = c0322c.f2737j;
            this.f2738k = c0322c.f2738k;
            this.f2739l = c0322c.f2739l;
            this.f2740m = c0322c.f2740m;
            this.f2732e = c0322c.f2732e;
            if (this.f2740m != null) {
                arrayMap.put(this.f2740m, this);
            }
            this.f2731d.set(c0322c.f2731d);
            ArrayList<AbstractC0323d> arrayList = c0322c.f2729b;
            for (int i = 0; i < arrayList.size(); i++) {
                AbstractC0323d abstractC0323d = arrayList.get(i);
                if (abstractC0323d instanceof C0322c) {
                    this.f2729b.add(new C0322c((C0322c) abstractC0323d, arrayMap));
                } else {
                    if (abstractC0323d instanceof C0321b) {
                        c0320a = new C0321b((C0321b) abstractC0323d);
                    } else if (abstractC0323d instanceof C0320a) {
                        c0320a = new C0320a((C0320a) abstractC0323d);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f2729b.add(c0320a);
                    if (c0320a.f2742n != null) {
                        arrayMap.put(c0320a.f2742n, c0320a);
                    }
                }
            }
        }

        public C0322c() {
            super();
            this.f2728a = new Matrix();
            this.f2729b = new ArrayList<>();
            this.f2730c = 0.0f;
            this.f2733f = 0.0f;
            this.f2734g = 0.0f;
            this.f2735h = 1.0f;
            this.f2736i = 1.0f;
            this.f2737j = 0.0f;
            this.f2738k = 0.0f;
            this.f2731d = new Matrix();
            this.f2740m = null;
        }

        public String getGroupName() {
            return this.f2740m;
        }

        public Matrix getLocalMatrix() {
            return this.f2731d;
        }

        /* JADX INFO: renamed from: a */
        public void m2953a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5305b);
            m2952a(typedArrayObtainAttributes, xmlPullParser);
            typedArrayObtainAttributes.recycle();
        }

        /* JADX INFO: renamed from: a */
        private void m2952a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2739l = null;
            this.f2730c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f2730c);
            this.f2733f = typedArray.getFloat(1, this.f2733f);
            this.f2734g = typedArray.getFloat(2, this.f2734g);
            this.f2735h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.f2735h);
            this.f2736i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.f2736i);
            this.f2737j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.f2737j);
            this.f2738k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.f2738k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2740m = string;
            }
            m2951a();
        }

        /* JADX INFO: renamed from: a */
        private void m2951a() {
            this.f2731d.reset();
            this.f2731d.postTranslate(-this.f2733f, -this.f2734g);
            this.f2731d.postScale(this.f2735h, this.f2736i);
            this.f2731d.postRotate(this.f2730c, 0.0f, 0.0f);
            this.f2731d.postTranslate(this.f2737j + this.f2733f, this.f2738k + this.f2734g);
        }

        public float getRotation() {
            return this.f2730c;
        }

        public void setRotation(float f) {
            if (f != this.f2730c) {
                this.f2730c = f;
                m2951a();
            }
        }

        public float getPivotX() {
            return this.f2733f;
        }

        public void setPivotX(float f) {
            if (f != this.f2733f) {
                this.f2733f = f;
                m2951a();
            }
        }

        public float getPivotY() {
            return this.f2734g;
        }

        public void setPivotY(float f) {
            if (f != this.f2734g) {
                this.f2734g = f;
                m2951a();
            }
        }

        public float getScaleX() {
            return this.f2735h;
        }

        public void setScaleX(float f) {
            if (f != this.f2735h) {
                this.f2735h = f;
                m2951a();
            }
        }

        public float getScaleY() {
            return this.f2736i;
        }

        public void setScaleY(float f) {
            if (f != this.f2736i) {
                this.f2736i = f;
                m2951a();
            }
        }

        public float getTranslateX() {
            return this.f2737j;
        }

        public void setTranslateX(float f) {
            if (f != this.f2737j) {
                this.f2737j = f;
                m2951a();
            }
        }

        public float getTranslateY() {
            return this.f2738k;
        }

        public void setTranslateY(float f) {
            if (f != this.f2738k) {
                this.f2738k = f;
                m2951a();
            }
        }

        @Override // android.support.graphics.drawable.VectorDrawableCompat.AbstractC0323d
        /* JADX INFO: renamed from: b */
        public boolean mo2950b() {
            for (int i = 0; i < this.f2729b.size(); i++) {
                if (this.f2729b.get(i).mo2950b()) {
                    return true;
                }
            }
            return false;
        }

        @Override // android.support.graphics.drawable.VectorDrawableCompat.AbstractC0323d
        /* JADX INFO: renamed from: a */
        public boolean mo2949a(int[] iArr) {
            boolean zMo2949a = false;
            for (int i = 0; i < this.f2729b.size(); i++) {
                zMo2949a |= this.f2729b.get(i).mo2949a(iArr);
            }
            return zMo2949a;
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$e */
    static abstract class AbstractC0324e extends AbstractC0323d {

        /* JADX INFO: renamed from: m */
        protected PathParser.PathDataNode[] f2741m;

        /* JADX INFO: renamed from: n */
        String f2742n;

        /* JADX INFO: renamed from: o */
        int f2743o;

        /* JADX INFO: renamed from: a */
        public boolean mo2944a() {
            return false;
        }

        public AbstractC0324e() {
            super();
            this.f2741m = null;
        }

        public AbstractC0324e(AbstractC0324e abstractC0324e) {
            super();
            this.f2741m = null;
            this.f2742n = abstractC0324e.f2742n;
            this.f2743o = abstractC0324e.f2743o;
            this.f2741m = PathParser.deepCopyNodes(abstractC0324e.f2741m);
        }

        /* JADX INFO: renamed from: a */
        public void m2954a(Path path) {
            path.reset();
            if (this.f2741m != null) {
                PathParser.PathDataNode.nodesToPath(this.f2741m, path);
            }
        }

        public String getPathName() {
            return this.f2742n;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f2741m;
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.f2741m, pathDataNodeArr)) {
                this.f2741m = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.f2741m, pathDataNodeArr);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$a */
    static class C0320a extends AbstractC0324e {
        @Override // android.support.graphics.drawable.VectorDrawableCompat.AbstractC0324e
        /* JADX INFO: renamed from: a */
        public boolean mo2944a() {
            return true;
        }

        public C0320a() {
        }

        public C0320a(C0320a c0320a) {
            super(c0320a);
        }

        /* JADX INFO: renamed from: a */
        public void m2943a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5307d);
                m2942a(typedArrayObtainAttributes);
                typedArrayObtainAttributes.recycle();
            }
        }

        /* JADX INFO: renamed from: a */
        private void m2942a(TypedArray typedArray) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2742n = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2741m = PathParser.createNodesFromPathData(string2);
            }
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.VectorDrawableCompat$b */
    static class C0321b extends AbstractC0324e {

        /* JADX INFO: renamed from: a */
        ComplexColorCompat f2715a;

        /* JADX INFO: renamed from: b */
        float f2716b;

        /* JADX INFO: renamed from: c */
        ComplexColorCompat f2717c;

        /* JADX INFO: renamed from: d */
        float f2718d;

        /* JADX INFO: renamed from: e */
        int f2719e;

        /* JADX INFO: renamed from: f */
        float f2720f;

        /* JADX INFO: renamed from: g */
        float f2721g;

        /* JADX INFO: renamed from: h */
        float f2722h;

        /* JADX INFO: renamed from: i */
        float f2723i;

        /* JADX INFO: renamed from: j */
        Paint.Cap f2724j;

        /* JADX INFO: renamed from: k */
        Paint.Join f2725k;

        /* JADX INFO: renamed from: l */
        float f2726l;

        /* JADX INFO: renamed from: p */
        private int[] f2727p;

        public C0321b() {
            this.f2716b = 0.0f;
            this.f2718d = 1.0f;
            this.f2719e = 0;
            this.f2720f = 1.0f;
            this.f2721g = 0.0f;
            this.f2722h = 1.0f;
            this.f2723i = 0.0f;
            this.f2724j = Paint.Cap.BUTT;
            this.f2725k = Paint.Join.MITER;
            this.f2726l = 4.0f;
        }

        public C0321b(C0321b c0321b) {
            super(c0321b);
            this.f2716b = 0.0f;
            this.f2718d = 1.0f;
            this.f2719e = 0;
            this.f2720f = 1.0f;
            this.f2721g = 0.0f;
            this.f2722h = 1.0f;
            this.f2723i = 0.0f;
            this.f2724j = Paint.Cap.BUTT;
            this.f2725k = Paint.Join.MITER;
            this.f2726l = 4.0f;
            this.f2727p = c0321b.f2727p;
            this.f2715a = c0321b.f2715a;
            this.f2716b = c0321b.f2716b;
            this.f2718d = c0321b.f2718d;
            this.f2717c = c0321b.f2717c;
            this.f2719e = c0321b.f2719e;
            this.f2720f = c0321b.f2720f;
            this.f2721g = c0321b.f2721g;
            this.f2722h = c0321b.f2722h;
            this.f2723i = c0321b.f2723i;
            this.f2724j = c0321b.f2724j;
            this.f2725k = c0321b.f2725k;
            this.f2726l = c0321b.f2726l;
        }

        /* JADX INFO: renamed from: a */
        private Paint.Cap m2945a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* JADX INFO: renamed from: a */
        private Paint.Join m2946a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        /* JADX INFO: renamed from: a */
        public void m2948a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5306c);
            m2947a(typedArrayObtainAttributes, xmlPullParser, theme);
            typedArrayObtainAttributes.recycle();
        }

        /* JADX INFO: renamed from: a */
        private void m2947a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2727p = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2742n = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2741m = PathParser.createNodesFromPathData(string2);
                }
                this.f2717c = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.f2720f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.f2720f);
                this.f2724j = m2945a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2724j);
                this.f2725k = m2946a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2725k);
                this.f2726l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2726l);
                this.f2715a = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f2718d = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2718d);
                this.f2716b = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.f2716b);
                this.f2722h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2722h);
                this.f2723i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2723i);
                this.f2721g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.f2721g);
                this.f2719e = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.f2719e);
            }
        }

        @Override // android.support.graphics.drawable.VectorDrawableCompat.AbstractC0323d
        /* JADX INFO: renamed from: b */
        public boolean mo2950b() {
            return this.f2717c.isStateful() || this.f2715a.isStateful();
        }

        @Override // android.support.graphics.drawable.VectorDrawableCompat.AbstractC0323d
        /* JADX INFO: renamed from: a */
        public boolean mo2949a(int[] iArr) {
            return this.f2715a.onStateChanged(iArr) | this.f2717c.onStateChanged(iArr);
        }

        int getStrokeColor() {
            return this.f2715a.getColor();
        }

        void setStrokeColor(int i) {
            this.f2715a.setColor(i);
        }

        float getStrokeWidth() {
            return this.f2716b;
        }

        void setStrokeWidth(float f) {
            this.f2716b = f;
        }

        float getStrokeAlpha() {
            return this.f2718d;
        }

        void setStrokeAlpha(float f) {
            this.f2718d = f;
        }

        int getFillColor() {
            return this.f2717c.getColor();
        }

        void setFillColor(int i) {
            this.f2717c.setColor(i);
        }

        float getFillAlpha() {
            return this.f2720f;
        }

        void setFillAlpha(float f) {
            this.f2720f = f;
        }

        float getTrimPathStart() {
            return this.f2721g;
        }

        void setTrimPathStart(float f) {
            this.f2721g = f;
        }

        float getTrimPathEnd() {
            return this.f2722h;
        }

        void setTrimPathEnd(float f) {
            this.f2722h = f;
        }

        float getTrimPathOffset() {
            return this.f2723i;
        }

        void setTrimPathOffset(float f) {
            this.f2723i = f;
        }
    }
}
