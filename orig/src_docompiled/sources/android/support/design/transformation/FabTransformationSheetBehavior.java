package android.support.design.transformation;

import android.content.Context;
import android.os.Build;
import android.support.design.R;
import android.support.design.transformation.FabTransformationBehavior;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import java.util.HashMap;
import java.util.Map;
import p000.C0005ac;
import p000.C0021ae;

/* JADX INFO: loaded from: classes.dex */
public class FabTransformationSheetBehavior extends FabTransformationBehavior {

    /* JADX INFO: renamed from: a */
    private Map<View, Integer> f2297a;

    public FabTransformationSheetBehavior() {
    }

    public FabTransformationSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.support.design.transformation.FabTransformationBehavior
    /* JADX INFO: renamed from: a */
    protected FabTransformationBehavior.C0251a mo2510a(Context context, boolean z) {
        int i;
        if (z) {
            i = R.animator.mtrl_fab_transformation_sheet_expand_spec;
        } else {
            i = R.animator.mtrl_fab_transformation_sheet_collapse_spec;
        }
        FabTransformationBehavior.C0251a c0251a = new FabTransformationBehavior.C0251a();
        c0251a.f2290a = C0005ac.m143a(context, i);
        c0251a.f2291b = new C0021ae(17, 0.0f, 0.0f);
        return c0251a;
    }

    @Override // android.support.design.transformation.ExpandableTransformationBehavior, android.support.design.transformation.ExpandableBehavior
    /* JADX INFO: renamed from: a */
    protected boolean mo2488a(View view, View view2, boolean z, boolean z2) {
        m2514a(view2, z);
        return super.mo2488a(view, view2, z, z2);
    }

    /* JADX INFO: renamed from: a */
    private void m2514a(View view, boolean z) {
        ViewParent parent = view.getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (Build.VERSION.SDK_INT >= 16 && z) {
                this.f2297a = new HashMap(childCount);
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                boolean z2 = (childAt.getLayoutParams() instanceof CoordinatorLayout.C0290d) && (((CoordinatorLayout.C0290d) childAt.getLayoutParams()).m2740b() instanceof FabTransformationScrimBehavior);
                if (childAt != view && !z2) {
                    if (!z) {
                        if (this.f2297a != null && this.f2297a.containsKey(childAt)) {
                            ViewCompat.setImportantForAccessibility(childAt, this.f2297a.get(childAt).intValue());
                        }
                    } else {
                        if (Build.VERSION.SDK_INT >= 16) {
                            this.f2297a.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        }
                        ViewCompat.setImportantForAccessibility(childAt, 4);
                    }
                }
            }
            if (z) {
                return;
            }
            this.f2297a = null;
        }
    }
}
