package p000;

import android.content.Context;
import android.graphics.Matrix;
import android.view.WindowManager;
import java.util.List;

/* JADX INFO: renamed from: uy */
/* JADX INFO: compiled from: CameraUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class C2176uy {
    /* JADX INFO: renamed from: a */
    public static boolean m11877a(String str, List<String> list) {
        return list != null && list.indexOf(str) >= 0;
    }

    /* JADX INFO: renamed from: a */
    public static void m11876a(Matrix matrix, boolean z, int i, int i2, int i3) {
        matrix.setScale(z ? -1.0f : 1.0f, 1.0f);
        matrix.postRotate(i);
        float f = i2;
        float f2 = i3;
        matrix.postScale(f / 2000.0f, f2 / 2000.0f);
        matrix.postTranslate(f / 2.0f, f2 / 2.0f);
    }

    /* JADX INFO: renamed from: a */
    public static int m11875a(Context context) {
        return ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRotation();
    }

    /* JADX INFO: renamed from: b */
    public static int m11878b(Context context) {
        switch (m11875a(context)) {
        }
        return 0;
    }
}
