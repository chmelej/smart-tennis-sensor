package p000;

import android.graphics.Rect;
import android.support.transition.Transition;
import android.view.ViewGroup;

/* JADX INFO: renamed from: ct */
/* JADX INFO: compiled from: SidePropagation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1645ct extends AbstractC1669dq {

    /* JADX INFO: renamed from: a */
    private float f9330a = 3.0f;

    /* JADX INFO: renamed from: b */
    private int f9331b = 80;

    /* JADX INFO: renamed from: a */
    public void m8818a(int i) {
        this.f9331b = i;
    }

    @Override // p000.AbstractC1649cx
    /* JADX INFO: renamed from: a */
    public long mo5783a(ViewGroup viewGroup, Transition transition, C1651cz c1651cz, C1651cz c1651cz2) {
        int i;
        int iCenterX;
        int iCenterY;
        C1651cz c1651cz3 = c1651cz;
        if (c1651cz3 == null && c1651cz2 == null) {
            return 0L;
        }
        Rect rectM3098n = transition.m3098n();
        if (c1651cz2 == null || m8891b(c1651cz3) == 0) {
            i = -1;
        } else {
            c1651cz3 = c1651cz2;
            i = 1;
        }
        int iC = m8892c(c1651cz3);
        int iD = m8893d(c1651cz3);
        int[] iArr = new int[2];
        viewGroup.getLocationOnScreen(iArr);
        int iRound = iArr[0] + Math.round(viewGroup.getTranslationX());
        int iRound2 = iArr[1] + Math.round(viewGroup.getTranslationY());
        int width = iRound + viewGroup.getWidth();
        int height = iRound2 + viewGroup.getHeight();
        if (rectM3098n != null) {
            iCenterX = rectM3098n.centerX();
            iCenterY = rectM3098n.centerY();
        } else {
            iCenterX = (iRound + width) / 2;
            iCenterY = (iRound2 + height) / 2;
        }
        float fM8816a = m8816a(viewGroup, iC, iD, iCenterX, iCenterY, iRound, iRound2, width, height) / m8817a(viewGroup);
        long jM3076b = transition.m3076b();
        if (jM3076b < 0) {
            jM3076b = 300;
        }
        return Math.round(((jM3076b * ((long) i)) / this.f9330a) * fM8816a);
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0015  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private int m8816a(android.view.View r7, int r8, int r9, int r10, int r11, int r12, int r13, int r14, int r15) {
        /*
            r6 = this;
            int r0 = r6.f9331b
            r1 = 3
            r2 = 5
            r3 = 0
            r4 = 1
            r5 = 8388611(0x800003, float:1.1754948E-38)
            if (r0 != r5) goto L19
            int r7 = android.support.v4.view.ViewCompat.getLayoutDirection(r7)
            if (r7 != r4) goto L12
            goto L13
        L12:
            r4 = 0
        L13:
            if (r4 == 0) goto L17
        L15:
            r7 = 5
            goto L2d
        L17:
            r7 = 3
            goto L2d
        L19:
            int r0 = r6.f9331b
            r5 = 8388613(0x800005, float:1.175495E-38)
            if (r0 != r5) goto L2b
            int r7 = android.support.v4.view.ViewCompat.getLayoutDirection(r7)
            if (r7 != r4) goto L27
            goto L28
        L27:
            r4 = 0
        L28:
            if (r4 == 0) goto L15
            goto L17
        L2b:
            int r7 = r6.f9331b
        L2d:
            if (r7 == r1) goto L55
            if (r7 == r2) goto L4c
            r11 = 48
            if (r7 == r11) goto L43
            r11 = 80
            if (r7 == r11) goto L3a
            goto L5d
        L3a:
            int r9 = r9 - r13
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r9 + r7
            goto L5d
        L43:
            int r15 = r15 - r9
            int r10 = r10 - r8
            int r7 = java.lang.Math.abs(r10)
            int r3 = r15 + r7
            goto L5d
        L4c:
            int r8 = r8 - r12
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r8 + r7
            goto L5d
        L55:
            int r14 = r14 - r8
            int r11 = r11 - r9
            int r7 = java.lang.Math.abs(r11)
            int r3 = r14 + r7
        L5d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1645ct.m8816a(android.view.View, int, int, int, int, int, int, int, int):int");
    }

    /* JADX INFO: renamed from: a */
    private int m8817a(ViewGroup viewGroup) {
        int i = this.f9331b;
        if (i == 3 || i == 5 || i == 8388611 || i == 8388613) {
            return viewGroup.getWidth();
        }
        return viewGroup.getHeight();
    }
}
