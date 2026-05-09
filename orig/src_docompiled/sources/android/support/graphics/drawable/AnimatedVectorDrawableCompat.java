package android.support.graphics.drawable;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import java.io.IOException;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.AbstractC0787cb;
import p000.C0780bv;
import p000.C0783by;
import p000.InterfaceC0781bw;

/* JADX INFO: loaded from: classes.dex */
public class AnimatedVectorDrawableCompat extends AbstractC0787cb implements InterfaceC0781bw {

    /* JADX INFO: renamed from: a */
    ArrayList<Object> f2692a;

    /* JADX INFO: renamed from: b */
    final Drawable.Callback f2693b;

    /* JADX INFO: renamed from: d */
    private C0317a f2694d;

    /* JADX INFO: renamed from: e */
    private Context f2695e;

    /* JADX INFO: renamed from: f */
    private ArgbEvaluator f2696f;

    /* JADX INFO: renamed from: g */
    private Animator.AnimatorListener f2697g;

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

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context) {
        this(context, null, null);
    }

    private AnimatedVectorDrawableCompat(Context context, C0317a c0317a, Resources resources) {
        this.f2696f = null;
        this.f2697g = null;
        this.f2692a = null;
        this.f2693b = new Drawable.Callback() { // from class: android.support.graphics.drawable.AnimatedVectorDrawableCompat.1
            @Override // android.graphics.drawable.Drawable.Callback
            public void invalidateDrawable(Drawable drawable) {
                AnimatedVectorDrawableCompat.this.invalidateSelf();
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                AnimatedVectorDrawableCompat.this.scheduleSelf(runnable, j);
            }

            @Override // android.graphics.drawable.Drawable.Callback
            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                AnimatedVectorDrawableCompat.this.unscheduleSelf(runnable);
            }
        };
        this.f2695e = context;
        if (c0317a != null) {
            this.f2694d = c0317a;
        } else {
            this.f2694d = new C0317a(context, c0317a, this.f2693b, resources);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (this.f5320c != null) {
            this.f5320c.mutate();
        }
        return this;
    }

    /* JADX INFO: renamed from: a */
    public static AnimatedVectorDrawableCompat m2928a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat(context);
        animatedVectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return animatedVectorDrawableCompat;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f5320c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0318b(this.f5320c.getConstantState());
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        if (this.f5320c != null) {
            return this.f5320c.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.f2694d.f2699a;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f5320c != null) {
            this.f5320c.draw(canvas);
            return;
        }
        this.f2694d.f2700b.draw(canvas);
        if (this.f2694d.f2701c.isStarted()) {
            invalidateSelf();
        }
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        if (this.f5320c != null) {
            this.f5320c.setBounds(rect);
        } else {
            this.f2694d.f2700b.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (this.f5320c != null) {
            return this.f5320c.setState(iArr);
        }
        return this.f2694d.f2700b.setState(iArr);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        if (this.f5320c != null) {
            return this.f5320c.setLevel(i);
        }
        return this.f2694d.f2700b.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        if (this.f5320c != null) {
            return DrawableCompat.getAlpha(this.f5320c);
        }
        return this.f2694d.f2700b.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.f5320c != null) {
            this.f5320c.setAlpha(i);
        } else {
            this.f2694d.f2700b.setAlpha(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f5320c != null) {
            this.f5320c.setColorFilter(colorFilter);
        } else {
            this.f2694d.f2700b.setColorFilter(colorFilter);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        if (this.f5320c != null) {
            DrawableCompat.setTint(this.f5320c, i);
        } else {
            this.f2694d.f2700b.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        if (this.f5320c != null) {
            DrawableCompat.setTintList(this.f5320c, colorStateList);
        } else {
            this.f2694d.f2700b.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, android.support.v4.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f5320c != null) {
            DrawableCompat.setTintMode(this.f5320c, mode);
        } else {
            this.f2694d.f2700b.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        if (this.f5320c != null) {
            return this.f5320c.setVisible(z, z2);
        }
        this.f2694d.f2700b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        if (this.f5320c != null) {
            return this.f5320c.isStateful();
        }
        return this.f2694d.f2700b.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        if (this.f5320c != null) {
            return this.f5320c.getOpacity();
        }
        return this.f2694d.f2700b.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f5320c != null) {
            return this.f5320c.getIntrinsicWidth();
        }
        return this.f2694d.f2700b.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f5320c != null) {
            return this.f5320c.getIntrinsicHeight();
        }
        return this.f2694d.f2700b.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        if (this.f5320c != null) {
            return DrawableCompat.isAutoMirrored(this.f5320c);
        }
        return this.f2694d.f2700b.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        if (this.f5320c != null) {
            DrawableCompat.setAutoMirrored(this.f5320c, z);
        } else {
            this.f2694d.f2700b.setAutoMirrored(z);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        if (this.f5320c != null) {
            DrawableCompat.inflate(this.f5320c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, C0780bv.f5308e);
                    int resourceId = typedArrayObtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        VectorDrawableCompat vectorDrawableCompatM2934a = VectorDrawableCompat.m2934a(resources, resourceId, theme);
                        vectorDrawableCompatM2934a.m2941a(false);
                        vectorDrawableCompatM2934a.setCallback(this.f2693b);
                        if (this.f2694d.f2700b != null) {
                            this.f2694d.f2700b.setCallback(null);
                        }
                        this.f2694d.f2700b = vectorDrawableCompatM2934a;
                    }
                    typedArrayObtainAttributes.recycle();
                } else if ("target".equals(name)) {
                    TypedArray typedArrayObtainAttributes2 = resources.obtainAttributes(attributeSet, C0780bv.f5309f);
                    String string = typedArrayObtainAttributes2.getString(0);
                    int resourceId2 = typedArrayObtainAttributes2.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        if (this.f2695e != null) {
                            m2930a(string, C0783by.m5720a(this.f2695e, resourceId2));
                        } else {
                            typedArrayObtainAttributes2.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                    typedArrayObtainAttributes2.recycle();
                } else {
                    continue;
                }
            }
            eventType = xmlPullParser.next();
        }
        this.f2694d.m2931a();
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // p000.AbstractC0787cb, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        if (this.f5320c != null) {
            DrawableCompat.applyTheme(this.f5320c, theme);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        if (this.f5320c != null) {
            return DrawableCompat.canApplyTheme(this.f5320c);
        }
        return false;
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.AnimatedVectorDrawableCompat$b */
    static class C0318b extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        private final Drawable.ConstantState f2704a;

        public C0318b(Drawable.ConstantState constantState) {
            this.f2704a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f5320c = this.f2704a.newDrawable();
            animatedVectorDrawableCompat.f5320c.setCallback(animatedVectorDrawableCompat.f2693b);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f5320c = this.f2704a.newDrawable(resources);
            animatedVectorDrawableCompat.f5320c.setCallback(animatedVectorDrawableCompat.f2693b);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            AnimatedVectorDrawableCompat animatedVectorDrawableCompat = new AnimatedVectorDrawableCompat();
            animatedVectorDrawableCompat.f5320c = this.f2704a.newDrawable(resources, theme);
            animatedVectorDrawableCompat.f5320c.setCallback(animatedVectorDrawableCompat.f2693b);
            return animatedVectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f2704a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2704a.getChangingConfigurations();
        }
    }

    /* JADX INFO: renamed from: android.support.graphics.drawable.AnimatedVectorDrawableCompat$a */
    static class C0317a extends Drawable.ConstantState {

        /* JADX INFO: renamed from: a */
        int f2699a;

        /* JADX INFO: renamed from: b */
        VectorDrawableCompat f2700b;

        /* JADX INFO: renamed from: c */
        AnimatorSet f2701c;

        /* JADX INFO: renamed from: d */
        ArrayList<Animator> f2702d;

        /* JADX INFO: renamed from: e */
        ArrayMap<Animator, String> f2703e;

        public C0317a(Context context, C0317a c0317a, Drawable.Callback callback, Resources resources) {
            if (c0317a != null) {
                this.f2699a = c0317a.f2699a;
                if (c0317a.f2700b != null) {
                    Drawable.ConstantState constantState = c0317a.f2700b.getConstantState();
                    if (resources != null) {
                        this.f2700b = (VectorDrawableCompat) constantState.newDrawable(resources);
                    } else {
                        this.f2700b = (VectorDrawableCompat) constantState.newDrawable();
                    }
                    this.f2700b = (VectorDrawableCompat) this.f2700b.mutate();
                    this.f2700b.setCallback(callback);
                    this.f2700b.setBounds(c0317a.f2700b.getBounds());
                    this.f2700b.m2941a(false);
                }
                if (c0317a.f2702d != null) {
                    int size = c0317a.f2702d.size();
                    this.f2702d = new ArrayList<>(size);
                    this.f2703e = new ArrayMap<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = c0317a.f2702d.get(i);
                        Animator animatorClone = animator.clone();
                        String str = c0317a.f2703e.get(animator);
                        animatorClone.setTarget(this.f2700b.m2940a(str));
                        this.f2702d.add(animatorClone);
                        this.f2703e.put(animatorClone, str);
                    }
                    m2931a();
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f2699a;
        }

        /* JADX INFO: renamed from: a */
        public void m2931a() {
            if (this.f2701c == null) {
                this.f2701c = new AnimatorSet();
            }
            this.f2701c.playTogether(this.f2702d);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2929a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                m2929a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2696f == null) {
                    this.f2696f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2696f);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m2930a(String str, Animator animator) {
        animator.setTarget(this.f2694d.f2700b.m2940a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m2929a(animator);
        }
        if (this.f2694d.f2702d == null) {
            this.f2694d.f2702d = new ArrayList<>();
            this.f2694d.f2703e = new ArrayMap<>();
        }
        this.f2694d.f2702d.add(animator);
        this.f2694d.f2703e.put(animator, str);
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        if (this.f5320c != null) {
            return ((AnimatedVectorDrawable) this.f5320c).isRunning();
        }
        return this.f2694d.f2701c.isRunning();
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        if (this.f5320c != null) {
            ((AnimatedVectorDrawable) this.f5320c).start();
        } else {
            if (this.f2694d.f2701c.isStarted()) {
                return;
            }
            this.f2694d.f2701c.start();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        if (this.f5320c != null) {
            ((AnimatedVectorDrawable) this.f5320c).stop();
        } else {
            this.f2694d.f2701c.end();
        }
    }
}
