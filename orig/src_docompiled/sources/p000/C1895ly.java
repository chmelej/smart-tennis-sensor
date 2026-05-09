package p000;

import android.content.Context;

/* JADX INFO: renamed from: ly */
/* JADX INFO: compiled from: DisplayUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1895ly {
    /* JADX INFO: renamed from: a */
    public static int m10460a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: renamed from: b */
    public static int m10461b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* JADX INFO: renamed from: c */
    public static int m10462c(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
