package p000;

import android.view.View;

/* JADX INFO: renamed from: dq */
/* JADX INFO: compiled from: VisibilityPropagation.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1669dq extends AbstractC1649cx {

    /* JADX INFO: renamed from: a */
    private static final String[] f9419a = {"android:visibilityPropagation:visibility", "android:visibilityPropagation:center"};

    @Override // p000.AbstractC1649cx
    /* JADX INFO: renamed from: a */
    public void mo8824a(C1651cz c1651cz) {
        View view = c1651cz.f9357b;
        Integer numValueOf = (Integer) c1651cz.f9356a.get("android:visibility:visibility");
        if (numValueOf == null) {
            numValueOf = Integer.valueOf(view.getVisibility());
        }
        c1651cz.f9356a.put("android:visibilityPropagation:visibility", numValueOf);
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        iArr[0] = iArr[0] + Math.round(view.getTranslationX());
        iArr[0] = iArr[0] + (view.getWidth() / 2);
        iArr[1] = iArr[1] + Math.round(view.getTranslationY());
        iArr[1] = iArr[1] + (view.getHeight() / 2);
        c1651cz.f9356a.put("android:visibilityPropagation:center", iArr);
    }

    @Override // p000.AbstractC1649cx
    /* JADX INFO: renamed from: a */
    public String[] mo8825a() {
        return f9419a;
    }

    /* JADX INFO: renamed from: b */
    public int m8891b(C1651cz c1651cz) {
        Integer num;
        if (c1651cz == null || (num = (Integer) c1651cz.f9356a.get("android:visibilityPropagation:visibility")) == null) {
            return 8;
        }
        return num.intValue();
    }

    /* JADX INFO: renamed from: c */
    public int m8892c(C1651cz c1651cz) {
        return m8890a(c1651cz, 0);
    }

    /* JADX INFO: renamed from: d */
    public int m8893d(C1651cz c1651cz) {
        return m8890a(c1651cz, 1);
    }

    /* JADX INFO: renamed from: a */
    private static int m8890a(C1651cz c1651cz, int i) {
        int[] iArr;
        if (c1651cz == null || (iArr = (int[]) c1651cz.f9356a.get("android:visibilityPropagation:center")) == null) {
            return -1;
        }
        return iArr[i];
    }
}
