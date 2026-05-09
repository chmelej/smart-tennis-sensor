package p000;

import android.graphics.Canvas;
import android.os.Build;

/* JADX INFO: renamed from: ai */
/* JADX INFO: compiled from: CanvasCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C0116ai {
    /* JADX INFO: renamed from: a */
    public static int m1292a(Canvas canvas, float f, float f2, float f3, float f4, int i) {
        if (Build.VERSION.SDK_INT > 21) {
            return canvas.saveLayerAlpha(f, f2, f3, f4, i);
        }
        return canvas.saveLayerAlpha(f, f2, f3, f4, i, 31);
    }
}
