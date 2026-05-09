package p000;

import android.animation.TimeInterpolator;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v4.view.animation.LinearOutSlowInInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

/* JADX INFO: renamed from: v */
/* JADX INFO: compiled from: AnimationUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2178v {

    /* JADX INFO: renamed from: a */
    public static final TimeInterpolator f12999a = new LinearInterpolator();

    /* JADX INFO: renamed from: b */
    public static final TimeInterpolator f13000b = new FastOutSlowInInterpolator();

    /* JADX INFO: renamed from: c */
    public static final TimeInterpolator f13001c = new FastOutLinearInInterpolator();

    /* JADX INFO: renamed from: d */
    public static final TimeInterpolator f13002d = new LinearOutSlowInInterpolator();

    /* JADX INFO: renamed from: e */
    public static final TimeInterpolator f13003e = new DecelerateInterpolator();

    /* JADX INFO: renamed from: a */
    public static float m11881a(float f, float f2, float f3) {
        return f + (f3 * (f2 - f));
    }

    /* JADX INFO: renamed from: a */
    public static int m11882a(int i, int i2, float f) {
        return i + Math.round(f * (i2 - i));
    }
}
