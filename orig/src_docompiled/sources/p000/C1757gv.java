package p000;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: renamed from: gv */
/* JADX INFO: compiled from: ScrollbarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1757gv {
    /* JADX INFO: renamed from: a */
    public static int m9549a(RecyclerView.C0621s c0621s, AbstractC1752gq abstractC1752gq, View view, View view2, RecyclerView.AbstractC0611i abstractC0611i, boolean z, boolean z2) {
        int iMax;
        if (abstractC0611i.m4012v() == 0 || c0621s.m4105e() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMin = Math.min(abstractC0611i.m3979d(view), abstractC0611i.m3979d(view2));
        int iMax2 = Math.max(abstractC0611i.m3979d(view), abstractC0611i.m3979d(view2));
        if (z2) {
            iMax = Math.max(0, (c0621s.m4105e() - iMax2) - 1);
        } else {
            iMax = Math.max(0, iMin);
        }
        if (!z) {
            return iMax;
        }
        return Math.round((iMax * (Math.abs(abstractC1752gq.mo9500b(view2) - abstractC1752gq.mo9496a(view)) / (Math.abs(abstractC0611i.m3979d(view) - abstractC0611i.m3979d(view2)) + 1))) + (abstractC1752gq.mo9501c() - abstractC1752gq.mo9496a(view)));
    }

    /* JADX INFO: renamed from: a */
    public static int m9548a(RecyclerView.C0621s c0621s, AbstractC1752gq abstractC1752gq, View view, View view2, RecyclerView.AbstractC0611i abstractC0611i, boolean z) {
        if (abstractC0611i.m4012v() == 0 || c0621s.m4105e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return Math.abs(abstractC0611i.m3979d(view) - abstractC0611i.m3979d(view2)) + 1;
        }
        return Math.min(abstractC1752gq.mo9507f(), abstractC1752gq.mo9500b(view2) - abstractC1752gq.mo9496a(view));
    }

    /* JADX INFO: renamed from: b */
    public static int m9550b(RecyclerView.C0621s c0621s, AbstractC1752gq abstractC1752gq, View view, View view2, RecyclerView.AbstractC0611i abstractC0611i, boolean z) {
        if (abstractC0611i.m4012v() == 0 || c0621s.m4105e() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z) {
            return c0621s.m4105e();
        }
        return (int) (((abstractC1752gq.mo9500b(view2) - abstractC1752gq.mo9496a(view)) / (Math.abs(abstractC0611i.m3979d(view) - abstractC0611i.m3979d(view2)) + 1)) * c0621s.m4105e());
    }
}
