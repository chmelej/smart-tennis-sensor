package android.support.v7.widget;

import android.content.Context;
import android.os.Build;
import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import p000.C1766hd;

/* JADX INFO: loaded from: classes.dex */
class AppCompatPopupWindow extends PopupWindow {

    /* JADX INFO: renamed from: a */
    private static final boolean f3465a;

    /* JADX INFO: renamed from: b */
    private boolean f3466b;

    static {
        f3465a = Build.VERSION.SDK_INT < 21;
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m3501a(context, attributeSet, i, 0);
    }

    public AppCompatPopupWindow(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m3501a(context, attributeSet, i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m3501a(Context context, AttributeSet attributeSet, int i, int i2) {
        C1766hd c1766hdM9601a = C1766hd.m9601a(context, attributeSet, R.styleable.PopupWindow, i, i2);
        if (c1766hdM9601a.m9620g(R.styleable.PopupWindow_overlapAnchor)) {
            m3502a(c1766hdM9601a.m9607a(R.styleable.PopupWindow_overlapAnchor, false));
        }
        setBackgroundDrawable(c1766hdM9601a.m9605a(R.styleable.PopupWindow_android_popupBackground));
        c1766hdM9601a.m9606a();
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2) {
        if (f3465a && this.f3466b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2);
    }

    @Override // android.widget.PopupWindow
    public void showAsDropDown(View view, int i, int i2, int i3) {
        if (f3465a && this.f3466b) {
            i2 -= view.getHeight();
        }
        super.showAsDropDown(view, i, i2, i3);
    }

    @Override // android.widget.PopupWindow
    public void update(View view, int i, int i2, int i3, int i4) {
        if (f3465a && this.f3466b) {
            i2 -= view.getHeight();
        }
        super.update(view, i, i2, i3, i4);
    }

    /* JADX INFO: renamed from: a */
    private void m3502a(boolean z) {
        if (f3465a) {
            this.f3466b = z;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z);
        }
    }
}
