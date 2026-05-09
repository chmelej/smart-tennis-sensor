package com.zhy.view.flowlayout;

import android.content.Context;
import android.view.View;
import android.widget.Checkable;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class TagView extends FrameLayout implements Checkable {

    /* JADX INFO: renamed from: b */
    private static final int[] f9319b = {android.R.attr.state_checked};

    /* JADX INFO: renamed from: a */
    private boolean f9320a;

    public TagView(Context context) {
        super(context);
    }

    public View getTagView() {
        return getChildAt(0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (isChecked()) {
            mergeDrawableStates(iArrOnCreateDrawableState, f9319b);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        if (this.f9320a != z) {
            this.f9320a = z;
            refreshDrawableState();
        }
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.f9320a;
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.f9320a);
    }
}
