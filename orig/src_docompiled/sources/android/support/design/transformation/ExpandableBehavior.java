package android.support.design.transformation;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import java.util.List;
import p000.InterfaceC0709ap;

/* JADX INFO: loaded from: classes.dex */
public abstract class ExpandableBehavior extends CoordinatorLayout.Behavior<View> {

    /* JADX INFO: renamed from: a */
    private int f2268a;

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public abstract boolean mo2487a(CoordinatorLayout coordinatorLayout, View view, View view2);

    /* JADX INFO: renamed from: a */
    protected abstract boolean mo2488a(View view, View view2, boolean z, boolean z2);

    public ExpandableBehavior() {
        this.f2268a = 0;
    }

    public ExpandableBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2268a = 0;
    }

    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: a */
    public boolean mo2208a(CoordinatorLayout coordinatorLayout, final View view, int i) {
        final InterfaceC0709ap interfaceC0709apM2486a;
        if (ViewCompat.isLaidOut(view) || (interfaceC0709apM2486a = m2486a(coordinatorLayout, view)) == null || !m2485a(interfaceC0709apM2486a.mo2760a())) {
            return false;
        }
        this.f2268a = interfaceC0709apM2486a.mo2760a() ? 1 : 2;
        final int i2 = this.f2268a;
        view.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() { // from class: android.support.design.transformation.ExpandableBehavior.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                view.getViewTreeObserver().removeOnPreDrawListener(this);
                if (ExpandableBehavior.this.f2268a == i2) {
                    ExpandableBehavior.this.mo2488a((View) interfaceC0709apM2486a, view, interfaceC0709apM2486a.mo2760a(), false);
                }
                return false;
            }
        });
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.support.design.widget.CoordinatorLayout.Behavior
    /* JADX INFO: renamed from: b */
    public boolean mo2489b(CoordinatorLayout coordinatorLayout, View view, View view2) {
        InterfaceC0709ap interfaceC0709ap = (InterfaceC0709ap) view2;
        if (!m2485a(interfaceC0709ap.mo2760a())) {
            return false;
        }
        this.f2268a = interfaceC0709ap.mo2760a() ? 1 : 2;
        return mo2488a((View) interfaceC0709ap, view, interfaceC0709ap.mo2760a(), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    protected InterfaceC0709ap m2486a(CoordinatorLayout coordinatorLayout, View view) {
        List<View> listM2706c = coordinatorLayout.m2706c(view);
        int size = listM2706c.size();
        for (int i = 0; i < size; i++) {
            View view2 = listM2706c.get(i);
            if (mo2487a(coordinatorLayout, view, view2)) {
                return (InterfaceC0709ap) view2;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    private boolean m2485a(boolean z) {
        return z ? this.f2268a == 0 || this.f2268a == 2 : this.f2268a == 1;
    }
}
