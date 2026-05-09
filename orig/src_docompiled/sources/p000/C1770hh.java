package p000;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.appcompat.R;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

/* JADX INFO: renamed from: hh */
/* JADX INFO: compiled from: TooltipPopup.java */
/* JADX INFO: loaded from: classes.dex */
class C1770hh {

    /* JADX INFO: renamed from: a */
    private final Context f10181a;

    /* JADX INFO: renamed from: b */
    private final View f10182b;

    /* JADX INFO: renamed from: c */
    private final TextView f10183c;

    /* JADX INFO: renamed from: d */
    private final WindowManager.LayoutParams f10184d = new WindowManager.LayoutParams();

    /* JADX INFO: renamed from: e */
    private final Rect f10185e = new Rect();

    /* JADX INFO: renamed from: f */
    private final int[] f10186f = new int[2];

    /* JADX INFO: renamed from: g */
    private final int[] f10187g = new int[2];

    C1770hh(Context context) {
        this.f10181a = context;
        this.f10182b = LayoutInflater.from(this.f10181a).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f10183c = (TextView) this.f10182b.findViewById(R.id.message);
        this.f10184d.setTitle(getClass().getSimpleName());
        this.f10184d.packageName = this.f10181a.getPackageName();
        this.f10184d.type = PointerIconCompat.TYPE_HAND;
        this.f10184d.width = -2;
        this.f10184d.height = -2;
        this.f10184d.format = -3;
        this.f10184d.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        this.f10184d.flags = 24;
    }

    /* JADX INFO: renamed from: a */
    void m9646a(View view, int i, int i2, boolean z, CharSequence charSequence) {
        if (m9647b()) {
            m9645a();
        }
        this.f10183c.setText(charSequence);
        m9644a(view, i, i2, z, this.f10184d);
        ((WindowManager) this.f10181a.getSystemService("window")).addView(this.f10182b, this.f10184d);
    }

    /* JADX INFO: renamed from: a */
    void m9645a() {
        if (m9647b()) {
            ((WindowManager) this.f10181a.getSystemService("window")).removeView(this.f10182b);
        }
    }

    /* JADX INFO: renamed from: b */
    boolean m9647b() {
        return this.f10182b.getParent() != null;
    }

    /* JADX INFO: renamed from: a */
    private void m9644a(View view, int i, int i2, boolean z, WindowManager.LayoutParams layoutParams) {
        int height;
        int i3;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.f10181a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.f10181a.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            height = i2 + dimensionPixelOffset2;
            i3 = i2 - dimensionPixelOffset2;
        } else {
            height = view.getHeight();
            i3 = 0;
        }
        layoutParams.gravity = 49;
        int dimensionPixelOffset3 = this.f10181a.getResources().getDimensionPixelOffset(z ? R.dimen.tooltip_y_offset_touch : R.dimen.tooltip_y_offset_non_touch);
        View viewM9643a = m9643a(view);
        if (viewM9643a == null) {
            Log.e("TooltipPopup", "Cannot find app view");
            return;
        }
        viewM9643a.getWindowVisibleDisplayFrame(this.f10185e);
        if (this.f10185e.left < 0 && this.f10185e.top < 0) {
            Resources resources = this.f10181a.getResources();
            int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
            int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            this.f10185e.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        viewM9643a.getLocationOnScreen(this.f10187g);
        view.getLocationOnScreen(this.f10186f);
        int[] iArr = this.f10186f;
        iArr[0] = iArr[0] - this.f10187g[0];
        int[] iArr2 = this.f10186f;
        iArr2[1] = iArr2[1] - this.f10187g[1];
        layoutParams.x = (this.f10186f[0] + i) - (viewM9643a.getWidth() / 2);
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.f10182b.measure(iMakeMeasureSpec, iMakeMeasureSpec);
        int measuredHeight = this.f10182b.getMeasuredHeight();
        int i4 = ((this.f10186f[1] + i3) - dimensionPixelOffset3) - measuredHeight;
        int i5 = this.f10186f[1] + height + dimensionPixelOffset3;
        if (z) {
            if (i4 >= 0) {
                layoutParams.y = i4;
                return;
            } else {
                layoutParams.y = i5;
                return;
            }
        }
        if (measuredHeight + i5 <= this.f10185e.height()) {
            layoutParams.y = i5;
        } else {
            layoutParams.y = i4;
        }
    }

    /* JADX INFO: renamed from: a */
    private static View m9643a(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }
}
