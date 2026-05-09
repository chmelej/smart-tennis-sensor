package android.support.design.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import p000.InterfaceC0762bd;

/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout implements InterfaceC0762bd {

    /* JADX INFO: renamed from: a */
    private TextView f2521a;

    /* JADX INFO: renamed from: b */
    private Button f2522b;

    /* JADX INFO: renamed from: c */
    private int f2523c;

    /* JADX INFO: renamed from: d */
    private int f2524d;

    public SnackbarContentLayout(Context context) {
        this(context, null);
    }

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SnackbarLayout);
        this.f2523c = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_android_maxWidth, -1);
        this.f2524d = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        this.f2521a = (TextView) findViewById(R.id.snackbar_text);
        this.f2522b = (Button) findViewById(R.id.snackbar_action);
    }

    public TextView getMessageView() {
        return this.f2521a;
    }

    public Button getActionView() {
        return this.f2522b;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0063  */
    @Override // android.widget.LinearLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            super.onMeasure(r8, r9)
            int r0 = r7.f2523c
            if (r0 <= 0) goto L1a
            int r0 = r7.getMeasuredWidth()
            int r1 = r7.f2523c
            if (r0 <= r1) goto L1a
            int r8 = r7.f2523c
            r0 = 1073741824(0x40000000, float:2.0)
            int r8 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r0)
            super.onMeasure(r8, r9)
        L1a:
            android.content.res.Resources r0 = r7.getResources()
            int r1 = android.support.design.R.dimen.design_snackbar_padding_vertical_2lines
            int r0 = r0.getDimensionPixelSize(r1)
            android.content.res.Resources r1 = r7.getResources()
            int r2 = android.support.design.R.dimen.design_snackbar_padding_vertical
            int r1 = r1.getDimensionPixelSize(r2)
            android.widget.TextView r2 = r7.f2521a
            android.text.Layout r2 = r2.getLayout()
            int r2 = r2.getLineCount()
            r3 = 0
            r4 = 1
            if (r2 <= r4) goto L3e
            r2 = 1
            goto L3f
        L3e:
            r2 = 0
        L3f:
            if (r2 == 0) goto L58
            int r5 = r7.f2524d
            if (r5 <= 0) goto L58
            android.widget.Button r5 = r7.f2522b
            int r5 = r5.getMeasuredWidth()
            int r6 = r7.f2524d
            if (r5 <= r6) goto L58
            int r1 = r0 - r1
            boolean r0 = r7.m2802a(r4, r0, r1)
            if (r0 == 0) goto L63
            goto L64
        L58:
            if (r2 == 0) goto L5b
            goto L5c
        L5b:
            r0 = r1
        L5c:
            boolean r0 = r7.m2802a(r3, r0, r0)
            if (r0 == 0) goto L63
            goto L64
        L63:
            r4 = 0
        L64:
            if (r4 == 0) goto L69
            super.onMeasure(r8, r9)
        L69:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.design.widget.SnackbarContentLayout.onMeasure(int, int):void");
    }

    /* JADX INFO: renamed from: a */
    private boolean m2802a(int i, int i2, int i3) {
        boolean z;
        if (i != getOrientation()) {
            setOrientation(i);
            z = true;
        } else {
            z = false;
        }
        if (this.f2521a.getPaddingTop() == i2 && this.f2521a.getPaddingBottom() == i3) {
            return z;
        }
        m2801a(this.f2521a, i2, i3);
        return true;
    }

    /* JADX INFO: renamed from: a */
    private static void m2801a(View view, int i, int i2) {
        if (ViewCompat.isPaddingRelative(view)) {
            ViewCompat.setPaddingRelative(view, ViewCompat.getPaddingStart(view), i, ViewCompat.getPaddingEnd(view), i2);
        } else {
            view.setPadding(view.getPaddingLeft(), i, view.getPaddingRight(), i2);
        }
    }

    @Override // p000.InterfaceC0762bd
    /* JADX INFO: renamed from: a */
    public void mo2803a(int i, int i2) {
        this.f2521a.setAlpha(0.0f);
        long j = i2;
        long j2 = i;
        this.f2521a.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f2522b.getVisibility() == 0) {
            this.f2522b.setAlpha(0.0f);
            this.f2522b.animate().alpha(1.0f).setDuration(j).setStartDelay(j2).start();
        }
    }

    @Override // p000.InterfaceC0762bd
    /* JADX INFO: renamed from: b */
    public void mo2804b(int i, int i2) {
        this.f2521a.setAlpha(1.0f);
        long j = i2;
        long j2 = i;
        this.f2521a.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        if (this.f2522b.getVisibility() == 0) {
            this.f2522b.setAlpha(1.0f);
            this.f2522b.animate().alpha(0.0f).setDuration(j).setStartDelay(j2).start();
        }
    }
}
