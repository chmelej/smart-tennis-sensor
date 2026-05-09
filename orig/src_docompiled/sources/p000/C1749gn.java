package p000;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/* JADX INFO: renamed from: gn */
/* JADX INFO: compiled from: LayoutState.java */
/* JADX INFO: loaded from: classes.dex */
public class C1749gn {

    /* JADX INFO: renamed from: b */
    public int f10047b;

    /* JADX INFO: renamed from: c */
    public int f10048c;

    /* JADX INFO: renamed from: d */
    public int f10049d;

    /* JADX INFO: renamed from: e */
    public int f10050e;

    /* JADX INFO: renamed from: h */
    public boolean f10053h;

    /* JADX INFO: renamed from: i */
    public boolean f10054i;

    /* JADX INFO: renamed from: a */
    public boolean f10046a = true;

    /* JADX INFO: renamed from: f */
    public int f10051f = 0;

    /* JADX INFO: renamed from: g */
    public int f10052g = 0;

    /* JADX INFO: renamed from: a */
    public boolean m9486a(RecyclerView.C0621s c0621s) {
        return this.f10048c >= 0 && this.f10048c < c0621s.m4105e();
    }

    /* JADX INFO: renamed from: a */
    public View m9485a(RecyclerView.C0617o c0617o) {
        View viewM4066c = c0617o.m4066c(this.f10048c);
        this.f10048c += this.f10049d;
        return viewM4066c;
    }

    public String toString() {
        return "LayoutState{mAvailable=" + this.f10047b + ", mCurrentPosition=" + this.f10048c + ", mItemDirection=" + this.f10049d + ", mLayoutDirection=" + this.f10050e + ", mStartLine=" + this.f10051f + ", mEndLine=" + this.f10052g + '}';
    }
}
