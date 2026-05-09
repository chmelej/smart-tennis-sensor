package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import p000.InterfaceC1746gk;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsLinearLayout extends LinearLayout implements InterfaceC1746gk {

    /* JADX INFO: renamed from: a */
    private InterfaceC1746gk.a f3519a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // p000.InterfaceC1746gk
    public void setOnFitSystemWindowsListener(InterfaceC1746gk.a aVar) {
        this.f3519a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f3519a != null) {
            this.f3519a.mo3267a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
