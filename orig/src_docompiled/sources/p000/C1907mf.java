package p000;

import android.os.Build;
import android.view.View;
import android.view.ViewTreeObserver;

/* JADX INFO: renamed from: mf */
/* JADX INFO: compiled from: ScrollUtils.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1907mf {
    /* JADX INFO: renamed from: a */
    public static float m10515a(float f, float f2, float f3) {
        return Math.min(f3, Math.max(f2, f));
    }

    /* JADX INFO: renamed from: a */
    public static void m10516a(final View view, final Runnable runnable) {
        view.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: mf.1
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                if (Build.VERSION.SDK_INT < 16) {
                    view.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                } else {
                    view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                }
                runnable.run();
            }
        });
    }
}
