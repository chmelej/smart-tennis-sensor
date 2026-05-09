package p000;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.graphics.ColorUtils;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: renamed from: gy */
/* JADX INFO: compiled from: ThemeUtils.java */
/* JADX INFO: loaded from: classes.dex */
class C1760gy {

    /* JADX INFO: renamed from: i */
    private static final ThreadLocal<TypedValue> f10126i = new ThreadLocal<>();

    /* JADX INFO: renamed from: a */
    static final int[] f10118a = {-16842910};

    /* JADX INFO: renamed from: b */
    static final int[] f10119b = {R.attr.state_focused};

    /* JADX INFO: renamed from: c */
    static final int[] f10120c = {R.attr.state_activated};

    /* JADX INFO: renamed from: d */
    static final int[] f10121d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e */
    static final int[] f10122e = {R.attr.state_checked};

    /* JADX INFO: renamed from: f */
    static final int[] f10123f = {R.attr.state_selected};

    /* JADX INFO: renamed from: g */
    static final int[] f10124g = {-16842919, -16842908};

    /* JADX INFO: renamed from: h */
    static final int[] f10125h = new int[0];

    /* JADX INFO: renamed from: j */
    private static final int[] f10127j = new int[1];

    /* JADX INFO: renamed from: a */
    public static int m9585a(Context context, int i) {
        f10127j[0] = i;
        C1766hd c1766hdM9600a = C1766hd.m9600a(context, (AttributeSet) null, f10127j);
        try {
            return c1766hdM9600a.m9609b(0, 0);
        } finally {
            c1766hdM9600a.m9606a();
        }
    }

    /* JADX INFO: renamed from: b */
    public static ColorStateList m9588b(Context context, int i) {
        f10127j[0] = i;
        C1766hd c1766hdM9600a = C1766hd.m9600a(context, (AttributeSet) null, f10127j);
        try {
            return c1766hdM9600a.m9616e(0);
        } finally {
            c1766hdM9600a.m9606a();
        }
    }

    /* JADX INFO: renamed from: c */
    public static int m9589c(Context context, int i) {
        ColorStateList colorStateListM9588b = m9588b(context, i);
        if (colorStateListM9588b != null && colorStateListM9588b.isStateful()) {
            return colorStateListM9588b.getColorForState(f10118a, colorStateListM9588b.getDefaultColor());
        }
        TypedValue typedValueM9587a = m9587a();
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValueM9587a, true);
        return m9586a(context, i, typedValueM9587a.getFloat());
    }

    /* JADX INFO: renamed from: a */
    private static TypedValue m9587a() {
        TypedValue typedValue = f10126i.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        f10126i.set(typedValue2);
        return typedValue2;
    }

    /* JADX INFO: renamed from: a */
    static int m9586a(Context context, int i, float f) {
        return ColorUtils.setAlphaComponent(m9585a(context, i), Math.round(Color.alpha(r0) * f));
    }
}
