package p000;

import android.R;
import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.graphics.ColorUtils;
import android.util.StateSet;

/* JADX INFO: renamed from: ay */
/* JADX INFO: compiled from: RippleUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0756ay {

    /* JADX INFO: renamed from: a */
    public static final boolean f5075a;

    /* JADX INFO: renamed from: b */
    private static final int[] f5076b;

    /* JADX INFO: renamed from: c */
    private static final int[] f5077c;

    /* JADX INFO: renamed from: d */
    private static final int[] f5078d;

    /* JADX INFO: renamed from: e */
    private static final int[] f5079e;

    /* JADX INFO: renamed from: f */
    private static final int[] f5080f;

    /* JADX INFO: renamed from: g */
    private static final int[] f5081g;

    /* JADX INFO: renamed from: h */
    private static final int[] f5082h;

    /* JADX INFO: renamed from: i */
    private static final int[] f5083i;

    /* JADX INFO: renamed from: j */
    private static final int[] f5084j;

    static {
        f5075a = Build.VERSION.SDK_INT >= 21;
        f5076b = new int[]{R.attr.state_pressed};
        f5077c = new int[]{R.attr.state_hovered, R.attr.state_focused};
        f5078d = new int[]{R.attr.state_focused};
        f5079e = new int[]{R.attr.state_hovered};
        f5080f = new int[]{R.attr.state_selected, R.attr.state_pressed};
        f5081g = new int[]{R.attr.state_selected, R.attr.state_hovered, R.attr.state_focused};
        f5082h = new int[]{R.attr.state_selected, R.attr.state_focused};
        f5083i = new int[]{R.attr.state_selected, R.attr.state_hovered};
        f5084j = new int[]{R.attr.state_selected};
    }

    /* JADX INFO: renamed from: a */
    public static ColorStateList m5493a(ColorStateList colorStateList) {
        if (f5075a) {
            return new ColorStateList(new int[][]{f5084j, StateSet.NOTHING}, new int[]{m5492a(colorStateList, f5080f), m5492a(colorStateList, f5076b)});
        }
        return new ColorStateList(new int[][]{f5080f, f5081g, f5082h, f5083i, f5084j, f5076b, f5077c, f5078d, f5079e, StateSet.NOTHING}, new int[]{m5492a(colorStateList, f5080f), m5492a(colorStateList, f5081g), m5492a(colorStateList, f5082h), m5492a(colorStateList, f5083i), 0, m5492a(colorStateList, f5076b), m5492a(colorStateList, f5077c), m5492a(colorStateList, f5078d), m5492a(colorStateList, f5079e), 0});
    }

    /* JADX INFO: renamed from: a */
    private static int m5492a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return f5075a ? m5491a(colorForState) : colorForState;
    }

    @TargetApi(21)
    /* JADX INFO: renamed from: a */
    private static int m5491a(int i) {
        return ColorUtils.setAlphaComponent(i, Math.min(Color.alpha(i) * 2, 255));
    }
}
