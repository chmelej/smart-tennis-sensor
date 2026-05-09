package com.coollang.tennis.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

/* JADX INFO: loaded from: classes.dex */
public class GetMoveScrollView extends ScrollView {

    /* JADX INFO: renamed from: a */
    private InterfaceC1336a f8345a;

    /* JADX INFO: renamed from: com.coollang.tennis.widget.GetMoveScrollView$a */
    public interface InterfaceC1336a {
        /* JADX INFO: renamed from: a */
        void mo7194a(int i, int i2, int i3, int i4);
    }

    public GetMoveScrollView(Context context) {
        super(context);
        this.f8345a = null;
    }

    public GetMoveScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8345a = null;
    }

    public GetMoveScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8345a = null;
    }

    @TargetApi(21)
    public GetMoveScrollView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f8345a = null;
    }

    @Override // android.view.View
    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f8345a != null) {
            this.f8345a.mo7194a(i, i2, i3, i4);
        }
    }

    public void setScrollViewListener(InterfaceC1336a interfaceC1336a) {
        this.f8345a = interfaceC1336a;
    }
}
