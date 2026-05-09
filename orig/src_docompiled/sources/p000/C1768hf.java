package p000;

import android.os.Build;
import android.view.View;

/* JADX INFO: renamed from: hf */
/* JADX INFO: compiled from: TooltipCompat.java */
/* JADX INFO: loaded from: classes.dex */
public class C1768hf {
    /* JADX INFO: renamed from: a */
    public static void m9634a(View view, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            view.setTooltipText(charSequence);
        } else {
            ViewOnAttachStateChangeListenerC1769hg.m9635a(view, charSequence);
        }
    }
}
