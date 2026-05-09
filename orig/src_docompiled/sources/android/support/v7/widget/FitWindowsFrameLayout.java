package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import p000.InterfaceC1746gk;

/* JADX INFO: loaded from: classes.dex */
public class FitWindowsFrameLayout extends FrameLayout implements InterfaceC1746gk {

    /* JADX INFO: renamed from: a */
    private InterfaceC1746gk.a f3518a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // p000.InterfaceC1746gk
    public void setOnFitSystemWindowsListener(InterfaceC1746gk.a aVar) {
        this.f3518a = aVar;
    }

    @Override // android.view.View
    protected boolean fitSystemWindows(Rect rect) {
        if (this.f3518a != null) {
            this.f3518a.mo3267a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
