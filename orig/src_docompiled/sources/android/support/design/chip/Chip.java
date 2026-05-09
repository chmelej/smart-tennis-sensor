package android.support.design.chip;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.design.chip.ChipDrawable;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.text.BidiFormatter;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.accessibility.AccessibilityNodeInfoCompat;
import android.support.v4.widget.ExploreByTouchHelper;
import android.support.v7.widget.AppCompatCheckBox;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.CompoundButton;
import android.widget.TextView;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import p000.C0005ac;
import p000.C0754aw;
import p000.C0756ay;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements ChipDrawable.InterfaceC0234a {

    /* JADX INFO: renamed from: a */
    private static final Rect f2074a = new Rect();

    /* JADX INFO: renamed from: b */
    private static final int[] f2075b = {R.attr.state_selected};

    /* JADX INFO: renamed from: c */
    private ChipDrawable f2076c;

    /* JADX INFO: renamed from: d */
    private RippleDrawable f2077d;

    /* JADX INFO: renamed from: e */
    private View.OnClickListener f2078e;

    /* JADX INFO: renamed from: f */
    private CompoundButton.OnCheckedChangeListener f2079f;

    /* JADX INFO: renamed from: g */
    private boolean f2080g;

    /* JADX INFO: renamed from: h */
    private int f2081h;

    /* JADX INFO: renamed from: i */
    private boolean f2082i;

    /* JADX INFO: renamed from: j */
    private boolean f2083j;

    /* JADX INFO: renamed from: k */
    private boolean f2084k;

    /* JADX INFO: renamed from: l */
    private final C0232a f2085l;

    /* JADX INFO: renamed from: m */
    private final Rect f2086m;

    /* JADX INFO: renamed from: n */
    private final RectF f2087n;

    /* JADX INFO: renamed from: o */
    private final ResourcesCompat.FontCallback f2088o;

    public Chip(Context context) {
        this(context, null);
    }

    public Chip(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, android.support.design.R.attr.chipStyle);
    }

    public Chip(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2081h = ExploreByTouchHelper.INVALID_ID;
        this.f2086m = new Rect();
        this.f2087n = new RectF();
        this.f2088o = new ResourcesCompat.FontCallback() { // from class: android.support.design.chip.Chip.1
            @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
            public void onFontRetrievalFailed(int i2) {
            }

            @Override // android.support.v4.content.res.ResourcesCompat.FontCallback
            public void onFontRetrieved(Typeface typeface) {
                Chip.this.setText(Chip.this.getText());
                Chip.this.requestLayout();
                Chip.this.invalidate();
            }
        };
        m2258a(attributeSet);
        ChipDrawable chipDrawableM2284a = ChipDrawable.m2284a(context, attributeSet, i, android.support.design.R.style.Widget_MaterialComponents_Chip_Action);
        setChipDrawable(chipDrawableM2284a);
        this.f2085l = new C0232a(this);
        ViewCompat.setAccessibilityDelegate(this, this.f2085l);
        m2269e();
        setChecked(this.f2080g);
        chipDrawableM2284a.m2362f(false);
        setText(chipDrawableM2284a.m2375k());
        setEllipsize(chipDrawableM2284a.m2381m());
        setIncludeFontPadding(false);
        if (getTextAppearance() != null) {
            m2259a(getTextAppearance());
        }
        setSingleLine();
        setGravity(8388627);
        m2268d();
    }

    /* JADX INFO: renamed from: d */
    private void m2268d() {
        if (TextUtils.isEmpty(getText()) || this.f2076c == null) {
            return;
        }
        float fM2310B = this.f2076c.m2310B() + this.f2076c.m2319I() + this.f2076c.m2315E() + this.f2076c.m2316F();
        if ((this.f2076c.m2385n() && this.f2076c.m2386o() != null) || (this.f2076c.m2406y() != null && this.f2076c.m2405x() && isChecked())) {
            fM2310B += this.f2076c.m2312C() + this.f2076c.m2314D() + this.f2076c.m2390q();
        }
        if (this.f2076c.m2393r() && this.f2076c.m2394s() != null) {
            fM2310B += this.f2076c.m2317G() + this.f2076c.m2318H() + this.f2076c.m2398u();
        }
        if (ViewCompat.getPaddingEnd(this) != fM2310B) {
            ViewCompat.setPaddingRelative(this, ViewCompat.getPaddingStart(this), getPaddingTop(), (int) fM2310B, getPaddingBottom());
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2258a(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background") != null) {
            throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        if (attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627) != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        }
    }

    /* JADX INFO: renamed from: e */
    private void m2269e() {
        if (Build.VERSION.SDK_INT >= 21) {
            setOutlineProvider(new ViewOutlineProvider() { // from class: android.support.design.chip.Chip.2
                @Override // android.view.ViewOutlineProvider
                @TargetApi(21)
                public void getOutline(View view, Outline outline) {
                    if (Chip.this.f2076c != null) {
                        Chip.this.f2076c.getOutline(outline);
                    } else {
                        outline.setAlpha(0.0f);
                    }
                }
            });
        }
    }

    public Drawable getChipDrawable() {
        return this.f2076c;
    }

    public void setChipDrawable(ChipDrawable chipDrawable) {
        if (this.f2076c != chipDrawable) {
            m2257a(this.f2076c);
            this.f2076c = chipDrawable;
            m2262b(this.f2076c);
            if (C0756ay.f5075a) {
                this.f2077d = new RippleDrawable(C0756ay.m5493a(this.f2076c.m2372j()), this.f2076c, null);
                this.f2076c.m2333a(false);
                ViewCompat.setBackground(this, this.f2077d);
            } else {
                this.f2076c.m2333a(true);
                ViewCompat.setBackground(this, this.f2076c);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2257a(ChipDrawable chipDrawable) {
        if (chipDrawable != null) {
            chipDrawable.m2329a((ChipDrawable.InterfaceC0234a) null);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m2262b(ChipDrawable chipDrawable) {
        chipDrawable.m2329a(this);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f2075b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (TextUtils.isEmpty(getText()) || this.f2076c == null || this.f2076c.m2320J()) {
            super.onDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.translate(m2264c(this.f2076c), 0.0f);
        super.onDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
        } else {
            super.setGravity(i);
        }
    }

    /* JADX INFO: renamed from: c */
    private float m2264c(ChipDrawable chipDrawable) {
        float chipStartPadding = getChipStartPadding() + chipDrawable.m2335b() + getTextStartPadding();
        return ViewCompat.getLayoutDirection(this) == 0 ? chipStartPadding : -chipStartPadding;
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        throw new UnsupportedOperationException("Do not set the background tint list; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        throw new UnsupportedOperationException("Do not set the background tint mode; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        throw new UnsupportedOperationException("Do not set the background color; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
        throw new UnsupportedOperationException("Do not set the background resource; Chip manages its own background drawable.");
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable != this.f2076c && drawable != this.f2077d) {
            throw new UnsupportedOperationException("Do not set the background; Chip manages its own background drawable.");
        }
        super.setBackground(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != this.f2076c && drawable != this.f2077d) {
            throw new UnsupportedOperationException("Do not set the background drawable; Chip manages its own background drawable.");
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        if (this.f2076c != null) {
            return this.f2076c.m2381m();
        }
        return null;
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.f2076c == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        if (this.f2076c != null) {
            this.f2076c.m2330a(truncateAt);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z) {
        if (!z) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        if (this.f2076c != null) {
            this.f2076c.m2313C(i);
        }
    }

    @Override // android.support.design.chip.ChipDrawable.InterfaceC0234a
    /* JADX INFO: renamed from: a */
    public void mo2273a() {
        m2268d();
        requestLayout();
        if (Build.VERSION.SDK_INT >= 21) {
            invalidateOutline();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f2076c == null) {
            this.f2080g = z;
            return;
        }
        if (this.f2076c.m2403w()) {
            boolean zIsChecked = isChecked();
            super.setChecked(z);
            if (zIsChecked == z || this.f2079f == null) {
                return;
            }
            this.f2079f.onCheckedChanged(this, z);
        }
    }

    void setOnCheckedChangeListenerInternal(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.f2079f = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.f2078e = onClickListener;
    }

    /* JADX INFO: renamed from: b */
    public boolean m2274b() {
        boolean z;
        playSoundEffect(0);
        if (this.f2078e != null) {
            this.f2078e.onClick(this);
            z = true;
        } else {
            z = false;
        }
        this.f2085l.sendEventForVirtualView(0, 1);
        return z;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getActionMasked()
            android.graphics.RectF r1 = r4.getCloseIconTouchBounds()
            float r2 = r5.getX()
            float r3 = r5.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            switch(r0) {
                case 0: goto L32;
                case 1: goto L24;
                case 2: goto L1a;
                case 3: goto L2d;
                default: goto L19;
            }
        L19:
            goto L39
        L1a:
            boolean r0 = r4.f2082i
            if (r0 == 0) goto L39
            if (r1 != 0) goto L37
            r4.setCloseIconPressed(r2)
            goto L37
        L24:
            boolean r0 = r4.f2082i
            if (r0 == 0) goto L2d
            r4.m2274b()
            r0 = 1
            goto L2e
        L2d:
            r0 = 0
        L2e:
            r4.setCloseIconPressed(r2)
            goto L3a
        L32:
            if (r1 == 0) goto L39
            r4.setCloseIconPressed(r3)
        L37:
            r0 = 1
            goto L3a
        L39:
            r0 = 0
        L3a:
            if (r0 != 0) goto L42
            boolean r5 = super.onTouchEvent(r5)
            if (r5 == 0) goto L43
        L42:
            r2 = 1
        L43:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @SuppressLint({"PrivateApi"})
    /* JADX INFO: renamed from: a */
    private boolean m2260a(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 10) {
            try {
                Field declaredField = ExploreByTouchHelper.class.getDeclaredField("mHoveredVirtualViewId");
                declaredField.setAccessible(true);
                if (((Integer) declaredField.get(this.f2085l)).intValue() != Integer.MIN_VALUE) {
                    Method declaredMethod = ExploreByTouchHelper.class.getDeclaredMethod("updateHoveredVirtualView", Integer.TYPE);
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke(this.f2085l, Integer.valueOf(ExploreByTouchHelper.INVALID_ID));
                    return true;
                }
            } catch (IllegalAccessException e) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e);
            } catch (NoSuchFieldException e2) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e2);
            } catch (NoSuchMethodException e3) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e3);
            } catch (InvocationTargetException e4) {
                Log.e("Chip", "Unable to send Accessibility Exit event", e4);
            }
        }
        return false;
    }

    @Override // android.view.View
    protected boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return m2260a(motionEvent) || this.f2085l.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return this.f2085l.dispatchKeyEvent(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            setFocusedVirtualView(-1);
        } else {
            setFocusedVirtualView(ExploreByTouchHelper.INVALID_ID);
        }
        invalidate();
        super.onFocusChanged(z, i, rect);
        this.f2085l.onFocusChanged(z, i, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0031  */
    @Override // android.widget.TextView, android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onKeyDown(int r7, android.view.KeyEvent r8) {
        /*
            r6 = this;
            int r0 = r8.getKeyCode()
            r1 = 61
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L3f
            r1 = 66
            if (r0 == r1) goto L31
            switch(r0) {
                case 21: goto L22;
                case 22: goto L12;
                case 23: goto L31;
                default: goto L11;
            }
        L11:
            goto L6b
        L12:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L6b
            boolean r0 = p000.C0752au.m5476a(r6)
            r0 = r0 ^ r3
            boolean r2 = r6.m2261a(r0)
            goto L6b
        L22:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L6b
            boolean r0 = p000.C0752au.m5476a(r6)
            boolean r2 = r6.m2261a(r0)
            goto L6b
        L31:
            int r0 = r6.f2081h
            switch(r0) {
                case -1: goto L3b;
                case 0: goto L37;
                default: goto L36;
            }
        L36:
            goto L6b
        L37:
            r6.m2274b()
            return r3
        L3b:
            r6.performClick()
            return r3
        L3f:
            boolean r0 = r8.hasNoModifiers()
            if (r0 == 0) goto L47
            r0 = 2
            goto L50
        L47:
            boolean r0 = r8.hasModifiers(r3)
            if (r0 == 0) goto L4f
            r0 = 1
            goto L50
        L4f:
            r0 = 0
        L50:
            if (r0 == 0) goto L6b
            android.view.ViewParent r1 = r6.getParent()
            r4 = r6
        L57:
            android.view.View r4 = r4.focusSearch(r0)
            if (r4 == 0) goto L65
            if (r4 == r6) goto L65
            android.view.ViewParent r5 = r4.getParent()
            if (r5 == r1) goto L57
        L65:
            if (r4 == 0) goto L6b
            r4.requestFocus()
            return r3
        L6b:
            if (r2 == 0) goto L71
            r6.invalidate()
            return r3
        L71:
            boolean r7 = super.onKeyDown(r7, r8)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.chip.Chip.onKeyDown(int, android.view.KeyEvent):boolean");
    }

    /* JADX INFO: renamed from: a */
    private boolean m2261a(boolean z) {
        m2270f();
        if (z) {
            if (this.f2081h == -1) {
                setFocusedVirtualView(0);
                return true;
            }
        } else if (this.f2081h == 0) {
            setFocusedVirtualView(-1);
            return true;
        }
        return false;
    }

    /* JADX INFO: renamed from: f */
    private void m2270f() {
        if (this.f2081h == Integer.MIN_VALUE) {
            setFocusedVirtualView(-1);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void getFocusedRect(Rect rect) {
        if (this.f2081h == 0) {
            rect.set(getCloseIconTouchBoundsInt());
        } else {
            super.getFocusedRect(rect);
        }
    }

    private void setFocusedVirtualView(int i) {
        if (this.f2081h != i) {
            if (this.f2081h == 0) {
                setCloseIconFocused(false);
            }
            this.f2081h = i;
            if (i == 0) {
                setCloseIconFocused(true);
            }
        }
    }

    private void setCloseIconPressed(boolean z) {
        if (this.f2082i != z) {
            this.f2082i = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconHovered(boolean z) {
        if (this.f2083j != z) {
            this.f2083j = z;
            refreshDrawableState();
        }
    }

    private void setCloseIconFocused(boolean z) {
        if (this.f2084k != z) {
            this.f2084k = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if ((this.f2076c == null || !this.f2076c.m2348c()) ? false : this.f2076c.m2334a(m2271g())) {
            invalidate();
        }
    }

    /* JADX INFO: renamed from: g */
    private int[] m2271g() {
        int i = 0;
        int i2 = isEnabled() ? 1 : 0;
        if (this.f2084k) {
            i2++;
        }
        if (this.f2083j) {
            i2++;
        }
        if (this.f2082i) {
            i2++;
        }
        if (isChecked()) {
            i2++;
        }
        int[] iArr = new int[i2];
        if (isEnabled()) {
            iArr[0] = 16842910;
            i = 1;
        }
        if (this.f2084k) {
            iArr[i] = 16842908;
            i++;
        }
        if (this.f2083j) {
            iArr[i] = 16843623;
            i++;
        }
        if (this.f2082i) {
            iArr[i] = 16842919;
            i++;
        }
        if (isChecked()) {
            iArr[i] = 16842913;
        }
        return iArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public boolean m2272h() {
        return (this.f2076c == null || this.f2076c.m2394s() == null) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        this.f2087n.setEmpty();
        if (m2272h()) {
            this.f2076c.m2327a(this.f2087n);
        }
        return this.f2087n;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        this.f2086m.set((int) closeIconTouchBounds.left, (int) closeIconTouchBounds.top, (int) closeIconTouchBounds.right, (int) closeIconTouchBounds.bottom);
        return this.f2086m;
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    @TargetApi(24)
    public PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), PointerIconCompat.TYPE_HAND);
        }
        return null;
    }

    /* JADX INFO: renamed from: android.support.design.chip.Chip$a */
    class C0232a extends ExploreByTouchHelper {
        C0232a(Chip chip) {
            super(chip);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.widget.ExploreByTouchHelper
        public int getVirtualViewAt(float f, float f2) {
            return (Chip.this.m2272h() && Chip.this.getCloseIconTouchBounds().contains(f, f2)) ? 0 : -1;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.widget.ExploreByTouchHelper
        public void getVisibleVirtualViews(List<Integer> list) {
            if (Chip.this.m2272h()) {
                list.add(0);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.widget.ExploreByTouchHelper
        public void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (Chip.this.m2272h()) {
                CharSequence closeIconContentDescription = Chip.this.getCloseIconContentDescription();
                if (closeIconContentDescription != null) {
                    accessibilityNodeInfoCompat.setContentDescription(closeIconContentDescription);
                } else {
                    CharSequence text = Chip.this.getText();
                    Context context = Chip.this.getContext();
                    int i2 = android.support.design.R.string.mtrl_chip_close_icon_content_description;
                    Object[] objArr = new Object[1];
                    if (TextUtils.isEmpty(text)) {
                        text = "";
                    }
                    objArr[0] = text;
                    accessibilityNodeInfoCompat.setContentDescription(context.getString(i2, objArr).trim());
                }
                accessibilityNodeInfoCompat.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
                accessibilityNodeInfoCompat.setEnabled(Chip.this.isEnabled());
                return;
            }
            accessibilityNodeInfoCompat.setContentDescription("");
            accessibilityNodeInfoCompat.setBoundsInParent(Chip.f2074a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.widget.ExploreByTouchHelper
        public void onPopulateNodeForHost(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.setCheckable(Chip.this.f2076c != null && Chip.this.f2076c.m2403w());
            accessibilityNodeInfoCompat.setClassName(Chip.class.getName());
            CharSequence text = Chip.this.getText();
            if (Build.VERSION.SDK_INT >= 23) {
                accessibilityNodeInfoCompat.setText(text);
            } else {
                accessibilityNodeInfoCompat.setContentDescription(text);
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.support.v4.widget.ExploreByTouchHelper
        public boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (i2 == 16 && i == 0) {
                return Chip.this.m2274b();
            }
            return false;
        }
    }

    public ColorStateList getChipBackgroundColor() {
        if (this.f2076c != null) {
            return this.f2076c.m2354e();
        }
        return null;
    }

    public void setChipBackgroundColorResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2324a(i);
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        if (this.f2076c != null) {
            this.f2076c.m2326a(colorStateList);
        }
    }

    public float getChipMinHeight() {
        if (this.f2076c != null) {
            return this.f2076c.m2359f();
        }
        return 0.0f;
    }

    public void setChipMinHeightResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2337b(i);
        }
    }

    public void setChipMinHeight(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2323a(f);
        }
    }

    public float getChipCornerRadius() {
        if (this.f2076c != null) {
            return this.f2076c.m2363g();
        }
        return 0.0f;
    }

    public void setChipCornerRadiusResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2344c(i);
        }
    }

    public void setChipCornerRadius(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2336b(f);
        }
    }

    public ColorStateList getChipStrokeColor() {
        if (this.f2076c != null) {
            return this.f2076c.m2366h();
        }
        return null;
    }

    public void setChipStrokeColorResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2350d(i);
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        if (this.f2076c != null) {
            this.f2076c.m2339b(colorStateList);
        }
    }

    public float getChipStrokeWidth() {
        if (this.f2076c != null) {
            return this.f2076c.m2369i();
        }
        return 0.0f;
    }

    public void setChipStrokeWidthResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2356e(i);
        }
    }

    public void setChipStrokeWidth(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2343c(f);
        }
    }

    public ColorStateList getRippleColor() {
        if (this.f2076c != null) {
            return this.f2076c.m2372j();
        }
        return null;
    }

    public void setRippleColorResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2361f(i);
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f2076c != null) {
            this.f2076c.m2345c(colorStateList);
        }
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        return this.f2076c != null ? this.f2076c.m2375k() : "";
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        if (this.f2076c == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        CharSequence charSequenceUnicodeWrap = BidiFormatter.getInstance().unicodeWrap(charSequence);
        if (this.f2076c.m2320J()) {
            charSequenceUnicodeWrap = null;
        }
        super.setText(charSequenceUnicodeWrap, bufferType);
        if (this.f2076c != null) {
            this.f2076c.m2332a(charSequence);
        }
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    private C0754aw getTextAppearance() {
        if (this.f2076c != null) {
            return this.f2076c.m2378l();
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private void m2259a(C0754aw c0754aw) {
        TextPaint paint = getPaint();
        paint.drawableState = this.f2076c.getState();
        c0754aw.m5488b(getContext(), paint, this.f2088o);
    }

    public void setTextAppearanceResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2365g(i);
        }
        setTextAppearance(getContext(), i);
    }

    public void setTextAppearance(C0754aw c0754aw) {
        if (this.f2076c != null) {
            this.f2076c.m2331a(c0754aw);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().m5489c(getContext(), getPaint(), this.f2088o);
            m2259a(c0754aw);
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2076c != null) {
            this.f2076c.m2365g(i);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().m5489c(context, getPaint(), this.f2088o);
            m2259a(getTextAppearance());
        }
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        if (this.f2076c != null) {
            this.f2076c.m2365g(i);
        }
        if (getTextAppearance() != null) {
            getTextAppearance().m5489c(getContext(), getPaint(), this.f2088o);
            m2259a(getTextAppearance());
        }
    }

    public void setChipIconVisible(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2368h(i);
        }
    }

    public void setChipIconVisible(boolean z) {
        if (this.f2076c != null) {
            this.f2076c.m2342b(z);
        }
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    @Deprecated
    public void setChipIconEnabled(boolean z) {
        setChipIconVisible(z);
    }

    public Drawable getChipIcon() {
        if (this.f2076c != null) {
            return this.f2076c.m2386o();
        }
        return null;
    }

    public void setChipIconResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2371i(i);
        }
    }

    public void setChipIcon(Drawable drawable) {
        if (this.f2076c != null) {
            this.f2076c.m2328a(drawable);
        }
    }

    public ColorStateList getChipIconTint() {
        if (this.f2076c != null) {
            return this.f2076c.m2388p();
        }
        return null;
    }

    public void setChipIconTintResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2374j(i);
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        if (this.f2076c != null) {
            this.f2076c.m2351d(colorStateList);
        }
    }

    public float getChipIconSize() {
        if (this.f2076c != null) {
            return this.f2076c.m2390q();
        }
        return 0.0f;
    }

    public void setChipIconSizeResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2377k(i);
        }
    }

    public void setChipIconSize(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2349d(f);
        }
    }

    public void setCloseIconVisible(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2380l(i);
        }
    }

    public void setCloseIconVisible(boolean z) {
        if (this.f2076c != null) {
            this.f2076c.m2347c(z);
        }
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z) {
        setCloseIconVisible(z);
    }

    public Drawable getCloseIcon() {
        if (this.f2076c != null) {
            return this.f2076c.m2394s();
        }
        return null;
    }

    public void setCloseIconResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2383m(i);
        }
    }

    public void setCloseIcon(Drawable drawable) {
        if (this.f2076c != null) {
            this.f2076c.m2340b(drawable);
        }
    }

    public ColorStateList getCloseIconTint() {
        if (this.f2076c != null) {
            return this.f2076c.m2396t();
        }
        return null;
    }

    public void setCloseIconTintResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2384n(i);
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        if (this.f2076c != null) {
            this.f2076c.m2357e(colorStateList);
        }
    }

    public float getCloseIconSize() {
        if (this.f2076c != null) {
            return this.f2076c.m2398u();
        }
        return 0.0f;
    }

    public void setCloseIconSizeResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2387o(i);
        }
    }

    public void setCloseIconSize(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2355e(f);
        }
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        if (this.f2076c != null) {
            this.f2076c.m2341b(charSequence);
        }
    }

    public CharSequence getCloseIconContentDescription() {
        if (this.f2076c != null) {
            return this.f2076c.m2400v();
        }
        return null;
    }

    public void setCheckableResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2389p(i);
        }
    }

    public void setCheckable(boolean z) {
        if (this.f2076c != null) {
            this.f2076c.m2352d(z);
        }
    }

    public void setCheckedIconVisible(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2391q(i);
        }
    }

    public void setCheckedIconVisible(boolean z) {
        if (this.f2076c != null) {
            this.f2076c.m2358e(z);
        }
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z) {
        setCheckedIconVisible(z);
    }

    public Drawable getCheckedIcon() {
        if (this.f2076c != null) {
            return this.f2076c.m2406y();
        }
        return null;
    }

    public void setCheckedIconResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2392r(i);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        if (this.f2076c != null) {
            this.f2076c.m2346c(drawable);
        }
    }

    public C0005ac getShowMotionSpec() {
        if (this.f2076c != null) {
            return this.f2076c.m2408z();
        }
        return null;
    }

    public void setShowMotionSpecResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2395s(i);
        }
    }

    public void setShowMotionSpec(C0005ac c0005ac) {
        if (this.f2076c != null) {
            this.f2076c.m2325a(c0005ac);
        }
    }

    public C0005ac getHideMotionSpec() {
        if (this.f2076c != null) {
            return this.f2076c.m2308A();
        }
        return null;
    }

    public void setHideMotionSpecResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2397t(i);
        }
    }

    public void setHideMotionSpec(C0005ac c0005ac) {
        if (this.f2076c != null) {
            this.f2076c.m2338b(c0005ac);
        }
    }

    public float getChipStartPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2310B();
        }
        return 0.0f;
    }

    public void setChipStartPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2399u(i);
        }
    }

    public void setChipStartPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2360f(f);
        }
    }

    public float getIconStartPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2312C();
        }
        return 0.0f;
    }

    public void setIconStartPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2401v(i);
        }
    }

    public void setIconStartPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2364g(f);
        }
    }

    public float getIconEndPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2314D();
        }
        return 0.0f;
    }

    public void setIconEndPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2402w(i);
        }
    }

    public void setIconEndPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2367h(f);
        }
    }

    public float getTextStartPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2315E();
        }
        return 0.0f;
    }

    public void setTextStartPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2404x(i);
        }
    }

    public void setTextStartPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2370i(f);
        }
    }

    public float getTextEndPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2316F();
        }
        return 0.0f;
    }

    public void setTextEndPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2407y(i);
        }
    }

    public void setTextEndPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2373j(f);
        }
    }

    public float getCloseIconStartPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2317G();
        }
        return 0.0f;
    }

    public void setCloseIconStartPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2409z(i);
        }
    }

    public void setCloseIconStartPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2376k(f);
        }
    }

    public float getCloseIconEndPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2318H();
        }
        return 0.0f;
    }

    public void setCloseIconEndPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2309A(i);
        }
    }

    public void setCloseIconEndPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2379l(f);
        }
    }

    public float getChipEndPadding() {
        if (this.f2076c != null) {
            return this.f2076c.m2319I();
        }
        return 0.0f;
    }

    public void setChipEndPaddingResource(int i) {
        if (this.f2076c != null) {
            this.f2076c.m2311B(i);
        }
    }

    public void setChipEndPadding(float f) {
        if (this.f2076c != null) {
            this.f2076c.m2382m(f);
        }
    }
}
