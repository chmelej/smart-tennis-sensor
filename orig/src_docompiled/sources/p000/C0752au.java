package p000;

import android.graphics.PorterDuff;
import android.support.v4.view.ViewCompat;
import android.view.View;

/* JADX INFO: renamed from: au */
/* JADX INFO: compiled from: ViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0752au {
    /* JADX INFO: renamed from: a */
    public static PorterDuff.Mode m5475a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m5476a(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }
}
