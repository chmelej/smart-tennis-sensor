package p000;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.util.AttributeSet;

/* JADX INFO: renamed from: at */
/* JADX INFO: compiled from: ThemeEnforcement.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0751at {

    /* JADX INFO: renamed from: a */
    private static final int[] f5033a = {R.attr.colorPrimary};

    /* JADX INFO: renamed from: b */
    private static final int[] f5034b = {R.attr.colorSecondary};

    /* JADX INFO: renamed from: a */
    public static TypedArray m5390a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m5392a(context, attributeSet, i, i2);
        m5397c(context, attributeSet, iArr, i, i2, iArr2);
        return context.obtainStyledAttributes(attributeSet, iArr, i, i2);
    }

    /* JADX INFO: renamed from: b */
    public static C1766hd m5395b(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        m5392a(context, attributeSet, i, i2);
        m5397c(context, attributeSet, iArr, i, i2, iArr2);
        return C1766hd.m9601a(context, attributeSet, iArr, i, i2);
    }

    /* JADX INFO: renamed from: a */
    private static void m5392a(Context context, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i, i2);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceMaterialTheme, false);
        typedArrayObtainStyledAttributes.recycle();
        if (z) {
            m5396b(context);
        }
        m5391a(context);
    }

    /* JADX INFO: renamed from: c */
    private static void m5397c(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        boolean zM5398d;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ThemeEnforcement, i, i2);
        if (!typedArrayObtainStyledAttributes.getBoolean(R.styleable.ThemeEnforcement_enforceTextAppearance, false)) {
            typedArrayObtainStyledAttributes.recycle();
            return;
        }
        if (iArr2 == null || iArr2.length == 0) {
            zM5398d = typedArrayObtainStyledAttributes.getResourceId(R.styleable.ThemeEnforcement_android_textAppearance, -1) != -1;
        } else {
            zM5398d = m5398d(context, attributeSet, iArr, i, i2, iArr2);
        }
        typedArrayObtainStyledAttributes.recycle();
        if (!zM5398d) {
            throw new IllegalArgumentException("This component requires that you specify a valid TextAppearance attribute. Update your app theme to inherit from Theme.MaterialComponents (or a descendant).");
        }
    }

    /* JADX INFO: renamed from: d */
    private static boolean m5398d(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2, int... iArr2) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, i2);
        for (int i3 : iArr2) {
            if (typedArrayObtainStyledAttributes.getResourceId(i3, -1) == -1) {
                typedArrayObtainStyledAttributes.recycle();
                return false;
            }
        }
        typedArrayObtainStyledAttributes.recycle();
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static void m5391a(Context context) {
        m5393a(context, f5033a, "Theme.AppCompat");
    }

    /* JADX INFO: renamed from: b */
    public static void m5396b(Context context) {
        m5393a(context, f5034b, "Theme.MaterialComponents");
    }

    /* JADX INFO: renamed from: a */
    private static boolean m5394a(Context context, int[] iArr) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(iArr);
        boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(0);
        typedArrayObtainStyledAttributes.recycle();
        return zHasValue;
    }

    /* JADX INFO: renamed from: a */
    private static void m5393a(Context context, int[] iArr, String str) {
        if (m5394a(context, iArr)) {
            return;
        }
        throw new IllegalArgumentException("The style on this component requires your app theme to be " + str + " (or a descendant).");
    }
}
