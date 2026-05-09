package p000;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.view.View;
import android.view.ViewParent;

/* JADX INFO: renamed from: aq */
/* JADX INFO: compiled from: ExpandableWidgetHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0717aq {

    /* JADX INFO: renamed from: a */
    private final View f4620a;

    /* JADX INFO: renamed from: b */
    private boolean f4621b = false;

    /* JADX INFO: renamed from: c */
    private int f4622c = 0;

    /* JADX WARN: Multi-variable type inference failed */
    public C0717aq(InterfaceC0709ap interfaceC0709ap) {
        this.f4620a = (View) interfaceC0709ap;
    }

    /* JADX INFO: renamed from: a */
    public boolean m4977a() {
        return this.f4621b;
    }

    /* JADX INFO: renamed from: b */
    public Bundle m4978b() {
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", this.f4621b);
        bundle.putInt("expandedComponentIdHint", this.f4622c);
        return bundle;
    }

    /* JADX INFO: renamed from: a */
    public void m4976a(Bundle bundle) {
        this.f4621b = bundle.getBoolean("expanded", false);
        this.f4622c = bundle.getInt("expandedComponentIdHint", 0);
        if (this.f4621b) {
            m4974d();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m4975a(int i) {
        this.f4622c = i;
    }

    /* JADX INFO: renamed from: c */
    public int m4979c() {
        return this.f4622c;
    }

    /* JADX INFO: renamed from: d */
    private void m4974d() {
        ViewParent parent = this.f4620a.getParent();
        if (parent instanceof CoordinatorLayout) {
            ((CoordinatorLayout) parent).m2703b(this.f4620a);
        }
    }
}
