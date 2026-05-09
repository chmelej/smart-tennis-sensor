package android.support.design.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import p000.C0778bt;

/* JADX INFO: loaded from: classes.dex */
class ViewOffsetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {

    /* JADX INFO: renamed from: a */
    private C0778bt f2688a;

    /* JADX INFO: renamed from: b */
    private int f2689b;

    /* JADX INFO: renamed from: c */
    private int f2690c;

    public ViewOffsetBehavior() {
        this.f2689b = 0;
        this.f2690c = 0;
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2689b = 0;
        this.f2690c = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2208a(CoordinatorLayout coordinatorLayout, V v, int i) {
        mo2791b(coordinatorLayout, v, i);
        if (this.f2688a == null) {
            this.f2688a = new C0778bt(v);
        }
        this.f2688a.m5708a();
        if (this.f2689b != 0) {
            this.f2688a.m5709a(this.f2689b);
            this.f2689b = 0;
        }
        if (this.f2690c == 0) {
            return true;
        }
        this.f2688a.m5711b(this.f2690c);
        this.f2690c = 0;
        return true;
    }

    /* JADX INFO: renamed from: b */
    protected void mo2791b(CoordinatorLayout coordinatorLayout, V v, int i) {
        coordinatorLayout.m2697a(v, i);
    }

    /* JADX INFO: renamed from: a */
    public boolean mo2575a(int i) {
        if (this.f2688a != null) {
            return this.f2688a.m5709a(i);
        }
        this.f2689b = i;
        return false;
    }

    /* JADX INFO: renamed from: b */
    public int mo2576b() {
        if (this.f2688a != null) {
            return this.f2688a.m5710b();
        }
        return 0;
    }
}
