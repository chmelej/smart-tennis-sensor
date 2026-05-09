package p000;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.view.ViewGroup;

/* JADX INFO: renamed from: cg */
/* JADX INFO: compiled from: CircularPropagation.java */
/* JADX INFO: loaded from: classes.dex */
public class C0792cg extends AbstractC1669dq {

    /* JADX INFO: renamed from: a */
    private float f5327a = 3.0f;

    @Override // p000.AbstractC1649cx
    /* JADX INFO: renamed from: a */
    public long mo5783a(ViewGroup viewGroup, Transition transition, C1651cz c1651cz, C1651cz c1651cz2) {
        int i;
        int iRound;
        int iCenterX;
        if (c1651cz == null && c1651cz2 == null) {
            return 0L;
        }
        if (c1651cz2 == null || m8891b(c1651cz) == 0) {
            i = -1;
        } else {
            c1651cz = c1651cz2;
            i = 1;
        }
        int iC = m8892c(c1651cz);
        int iD = m8893d(c1651cz);
        Rect rectM3098n = transition.m3098n();
        if (rectM3098n != null) {
            iCenterX = rectM3098n.centerX();
            iRound = rectM3098n.centerY();
        } else {
            viewGroup.getLocationOnScreen(new int[2]);
            int iRound2 = Math.round(r5[0] + (viewGroup.getWidth() / 2) + viewGroup.getTranslationX());
            iRound = Math.round(r5[1] + (viewGroup.getHeight() / 2) + viewGroup.getTranslationY());
            iCenterX = iRound2;
        }
        float fM5782a = m5782a(iC, iD, iCenterX, iRound) / m5782a(0.0f, 0.0f, viewGroup.getWidth(), viewGroup.getHeight());
        long jM3076b = transition.m3076b();
        if (jM3076b < 0) {
            jM3076b = 300;
        }
        return Math.round(((jM3076b * ((long) i)) / this.f5327a) * fM5782a);
    }

    /* JADX INFO: renamed from: a */
    private static float m5782a(float f, float f2, float f3, float f4) {
        float f5 = f3 - f;
        float f6 = f4 - f2;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }
}
