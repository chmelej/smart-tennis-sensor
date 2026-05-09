package p000;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: renamed from: cl */
/* JADX INFO: compiled from: GhostViewUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C0797cl {
    /* JADX INFO: renamed from: a */
    public static InterfaceC0796ck m5796a(View view, ViewGroup viewGroup, Matrix matrix) {
        if (Build.VERSION.SDK_INT >= 21) {
            return C0795cj.m5791a(view, viewGroup, matrix);
        }
        return C0794ci.m5786a(view, viewGroup);
    }

    /* JADX INFO: renamed from: a */
    public static void m5797a(View view) {
        if (Build.VERSION.SDK_INT >= 21) {
            C0795cj.m5793a(view);
        } else {
            C0794ci.m5787a(view);
        }
    }
}
