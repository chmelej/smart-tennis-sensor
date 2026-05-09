package p000;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v4.util.LongSparseArray;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.util.StateSet;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import p000.C1686eg;
import p000.C1691ej;

/* JADX INFO: renamed from: ef */
/* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C1685ef extends C1691ej {

    /* JADX INFO: renamed from: a */
    private static final String f9521a = "ef";

    /* JADX INFO: renamed from: b */
    private b f9522b;

    /* JADX INFO: renamed from: c */
    private f f9523c;

    /* JADX INFO: renamed from: d */
    private int f9524d;

    /* JADX INFO: renamed from: e */
    private int f9525e;

    /* JADX INFO: renamed from: f */
    private boolean f9526f;

    @Override // p000.C1691ej, p000.C1686eg, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return true;
    }

    @Override // p000.C1691ej, p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable.Callback
    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }

    public C1685ef() {
        this(null, null);
    }

    C1685ef(b bVar, Resources resources) {
        super(null);
        this.f9524d = -1;
        this.f9525e = -1;
        mo8987a(new b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* JADX INFO: renamed from: a */
    public static C1685ef m8979a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (!name.equals("animated-selector")) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
        }
        C1685ef c1685ef = new C1685ef();
        c1685ef.mo8989b(context, resources, xmlPullParser, attributeSet, theme);
        return c1685ef;
    }

    @Override // p000.C1691ej
    /* JADX INFO: renamed from: b */
    public void mo8989b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableCompat);
        setVisible(typedArrayObtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        m8980a(typedArrayObtainAttributes);
        m9009a(resources);
        typedArrayObtainAttributes.recycle();
        m8982c(context, resources, xmlPullParser, attributeSet, theme);
        m8985e();
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f9523c != null && (visible || z2)) {
            if (z) {
                this.f9523c.mo8991a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    @Override // p000.C1686eg, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.f9523c != null) {
            this.f9523c.mo8992b();
            this.f9523c = null;
            m9011a(this.f9524d);
            this.f9524d = -1;
            this.f9525e = -1;
        }
    }

    @Override // p000.C1691ej, p000.C1686eg, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        int iM8997a = this.f9522b.m8997a(iArr);
        boolean z = iM8997a != m9012d() && (m8981b(iM8997a) || m9011a(iM8997a));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    /* JADX INFO: renamed from: b */
    private boolean m8981b(int i) {
        int iD;
        int iM8995a;
        f aVar;
        f fVar = this.f9523c;
        if (fVar != null) {
            if (i == this.f9524d) {
                return true;
            }
            if (i == this.f9525e && fVar.mo9002c()) {
                fVar.mo9003d();
                this.f9524d = this.f9525e;
                this.f9525e = i;
                return true;
            }
            iD = this.f9524d;
            fVar.mo8992b();
        } else {
            iD = m9012d();
        }
        this.f9523c = null;
        this.f9525e = -1;
        this.f9524d = -1;
        b bVar = this.f9522b;
        int iM8994a = bVar.m8994a(iD);
        int iM8994a2 = bVar.m8994a(i);
        if (iM8994a2 == 0 || iM8994a == 0 || (iM8995a = bVar.m8995a(iM8994a, iM8994a2)) < 0) {
            return false;
        }
        boolean zM9001c = bVar.m9001c(iM8994a, iM8994a2);
        m9011a(iM8995a);
        Object current = getCurrent();
        if (current instanceof AnimationDrawable) {
            aVar = new d((AnimationDrawable) current, bVar.m9000b(iM8994a, iM8994a2), zM9001c);
        } else if (current instanceof AnimatedVectorDrawableCompat) {
            aVar = new c((AnimatedVectorDrawableCompat) current);
        } else {
            if (!(current instanceof Animatable)) {
                return false;
            }
            aVar = new a((Animatable) current);
        }
        aVar.mo8991a();
        this.f9523c = aVar;
        this.f9525e = iD;
        this.f9524d = i;
        return true;
    }

    /* JADX INFO: renamed from: ef$f */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static abstract class f {
        /* JADX INFO: renamed from: a */
        public abstract void mo8991a();

        /* JADX INFO: renamed from: b */
        public abstract void mo8992b();

        /* JADX INFO: renamed from: c */
        public boolean mo9002c() {
            return false;
        }

        /* JADX INFO: renamed from: d */
        public void mo9003d() {
        }

        private f() {
        }
    }

    /* JADX INFO: renamed from: ef$a */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class a extends f {

        /* JADX INFO: renamed from: a */
        private final Animatable f9527a;

        a(Animatable animatable) {
            super();
            this.f9527a = animatable;
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: a */
        public void mo8991a() {
            this.f9527a.start();
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: b */
        public void mo8992b() {
            this.f9527a.stop();
        }
    }

    /* JADX INFO: renamed from: ef$d */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class d extends f {

        /* JADX INFO: renamed from: a */
        private final ObjectAnimator f9531a;

        /* JADX INFO: renamed from: b */
        private final boolean f9532b;

        d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            e eVar = new e(animationDrawable, z);
            ObjectAnimator objectAnimatorOfInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", i, i2);
            if (Build.VERSION.SDK_INT >= 18) {
                objectAnimatorOfInt.setAutoCancel(true);
            }
            objectAnimatorOfInt.setDuration(eVar.m9004a());
            objectAnimatorOfInt.setInterpolator(eVar);
            this.f9532b = z2;
            this.f9531a = objectAnimatorOfInt;
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: c */
        public boolean mo9002c() {
            return this.f9532b;
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: a */
        public void mo8991a() {
            this.f9531a.start();
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: d */
        public void mo9003d() {
            this.f9531a.reverse();
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: b */
        public void mo8992b() {
            this.f9531a.cancel();
        }
    }

    /* JADX INFO: renamed from: ef$c */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class c extends f {

        /* JADX INFO: renamed from: a */
        private final AnimatedVectorDrawableCompat f9530a;

        c(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
            super();
            this.f9530a = animatedVectorDrawableCompat;
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: a */
        public void mo8991a() {
            this.f9530a.start();
        }

        @Override // p000.C1685ef.f
        /* JADX INFO: renamed from: b */
        public void mo8992b() {
            this.f9530a.stop();
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8980a(TypedArray typedArray) {
        b bVar = this.f9522b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f9565f |= typedArray.getChangingConfigurations();
        }
        bVar.m9020a(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_variablePadding, bVar.f9570k));
        bVar.m9023b(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_constantSize, bVar.f9573n));
        bVar.m9025c(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.f9553C));
        bVar.m9027d(typedArray.getInt(R.styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.f9554D));
        setDither(typedArray.getBoolean(R.styleable.AnimatedStateListDrawableCompat_android_dither, bVar.f9585z));
    }

    /* JADX INFO: renamed from: e */
    private void m8985e() {
        onStateChange(getState());
    }

    /* JADX INFO: renamed from: c */
    private void m8982c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1) {
                return;
            }
            int depth2 = xmlPullParser.getDepth();
            if (depth2 < depth && next == 3) {
                return;
            }
            if (next == 2 && depth2 <= depth) {
                if (xmlPullParser.getName().equals("item")) {
                    m8984e(context, resources, xmlPullParser, attributeSet, theme);
                } else if (xmlPullParser.getName().equals("transition")) {
                    m8983d(context, resources, xmlPullParser, attributeSet, theme);
                }
            }
        }
    }

    /* JADX INFO: renamed from: d */
    private int m8983d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableTransition);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = typedArrayObtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = typedArrayObtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable drawableM8975b = resourceId3 > 0 ? C1684ee.m8975b(context, resourceId3) : null;
        boolean z = typedArrayObtainAttributes.getBoolean(R.styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        typedArrayObtainAttributes.recycle();
        if (drawableM8975b == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("animated-vector")) {
                drawableM8975b = AnimatedVectorDrawableCompat.m2928a(context, resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableM8975b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableM8975b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableM8975b == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        if (resourceId == -1 || resourceId2 == -1) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
        return this.f9522b.m8996a(resourceId, resourceId2, drawableM8975b, z);
    }

    /* JADX INFO: renamed from: e */
    private int m8984e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        int next;
        TypedArray typedArrayObtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, R.styleable.AnimatedStateListDrawableItem);
        int resourceId = typedArrayObtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = typedArrayObtainAttributes.getResourceId(R.styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable drawableM8975b = resourceId2 > 0 ? C1684ee.m8975b(context, resourceId2) : null;
        typedArrayObtainAttributes.recycle();
        int[] iArrA = m9056a(attributeSet);
        if (drawableM8975b == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next != 2) {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
            if (xmlPullParser.getName().equals("vector")) {
                drawableM8975b = VectorDrawableCompat.m2935a(resources, xmlPullParser, attributeSet, theme);
            } else if (Build.VERSION.SDK_INT >= 21) {
                drawableM8975b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            } else {
                drawableM8975b = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            }
        }
        if (drawableM8975b == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
        }
        return this.f9522b.m8998a(iArrA, drawableM8975b, resourceId);
    }

    @Override // p000.C1691ej, p000.C1686eg, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.f9526f && super.mutate() == this) {
            this.f9522b.mo8999a();
            this.f9526f = true;
        }
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // p000.C1691ej, p000.C1686eg
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public b mo8990c() {
        return new b(this.f9522b, this, null);
    }

    /* JADX INFO: renamed from: ef$b */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class b extends C1691ej.a {

        /* JADX INFO: renamed from: a */
        LongSparseArray<Long> f9528a;

        /* JADX INFO: renamed from: b */
        SparseArrayCompat<Integer> f9529b;

        /* JADX INFO: renamed from: f */
        private static long m8993f(int i, int i2) {
            return (((long) i) << 32) | ((long) i2);
        }

        b(b bVar, C1685ef c1685ef, Resources resources) {
            super(bVar, c1685ef, resources);
            if (bVar != null) {
                this.f9528a = bVar.f9528a;
                this.f9529b = bVar.f9529b;
            } else {
                this.f9528a = new LongSparseArray<>();
                this.f9529b = new SparseArrayCompat<>();
            }
        }

        @Override // p000.C1691ej.a, p000.C1686eg.b
        /* JADX INFO: renamed from: a */
        void mo8999a() {
            this.f9528a = this.f9528a.m12572clone();
            this.f9529b = this.f9529b.m12573clone();
        }

        /* JADX INFO: renamed from: a */
        int m8996a(int i, int i2, Drawable drawable, boolean z) {
            int iA = super.m9017a(drawable);
            long jM8993f = m8993f(i, i2);
            long j = z ? 8589934592L : 0L;
            long j2 = iA;
            this.f9528a.append(jM8993f, Long.valueOf(j2 | j));
            if (z) {
                this.f9528a.append(m8993f(i2, i), Long.valueOf(j2 | 4294967296L | j));
            }
            return iA;
        }

        /* JADX INFO: renamed from: a */
        int m8998a(int[] iArr, Drawable drawable, int i) {
            int iM9057a = super.m9057a(iArr, drawable);
            this.f9529b.put(iM9057a, Integer.valueOf(i));
            return iM9057a;
        }

        /* JADX INFO: renamed from: a */
        int m8997a(int[] iArr) {
            int iM9058b = super.m9058b(iArr);
            return iM9058b >= 0 ? iM9058b : super.m9058b(StateSet.WILD_CARD);
        }

        /* JADX INFO: renamed from: a */
        int m8994a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f9529b.get(i, 0).intValue();
        }

        /* JADX INFO: renamed from: a */
        int m8995a(int i, int i2) {
            return (int) this.f9528a.get(m8993f(i, i2), -1L).longValue();
        }

        /* JADX INFO: renamed from: b */
        boolean m9000b(int i, int i2) {
            return (this.f9528a.get(m8993f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        /* JADX INFO: renamed from: c */
        boolean m9001c(int i, int i2) {
            return (this.f9528a.get(m8993f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        @Override // p000.C1691ej.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new C1685ef(this, null);
        }

        @Override // p000.C1691ej.a, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new C1685ef(this, resources);
        }
    }

    @Override // p000.C1691ej, p000.C1686eg
    /* JADX INFO: renamed from: a */
    protected void mo8987a(C1686eg.b bVar) {
        super.mo8987a(bVar);
        if (bVar instanceof b) {
            this.f9522b = (b) bVar;
        }
    }

    /* JADX INFO: renamed from: ef$e */
    /* JADX INFO: compiled from: AnimatedStateListDrawableCompat.java */
    static class e implements TimeInterpolator {

        /* JADX INFO: renamed from: a */
        private int[] f9533a;

        /* JADX INFO: renamed from: b */
        private int f9534b;

        /* JADX INFO: renamed from: c */
        private int f9535c;

        e(AnimationDrawable animationDrawable, boolean z) {
            m9005a(animationDrawable, z);
        }

        /* JADX INFO: renamed from: a */
        int m9005a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f9534b = numberOfFrames;
            if (this.f9533a == null || this.f9533a.length < numberOfFrames) {
                this.f9533a = new int[numberOfFrames];
            }
            int[] iArr = this.f9533a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr[i2] = duration;
                i += duration;
            }
            this.f9535c = i;
            return i;
        }

        /* JADX INFO: renamed from: a */
        int m9004a() {
            return this.f9535c;
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f) {
            int i = (int) ((f * this.f9535c) + 0.5f);
            int i2 = this.f9534b;
            int[] iArr = this.f9533a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (i3 / i2) + (i3 < i2 ? i / this.f9535c : 0.0f);
        }
    }
}
