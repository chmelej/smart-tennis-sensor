package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.FrameLayout;

/* JADX INFO: loaded from: classes.dex */
public class ContentFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private TypedValue f3510a;

    /* JADX INFO: renamed from: b */
    private TypedValue f3511b;

    /* JADX INFO: renamed from: c */
    private TypedValue f3512c;

    /* JADX INFO: renamed from: d */
    private TypedValue f3513d;

    /* JADX INFO: renamed from: e */
    private TypedValue f3514e;

    /* JADX INFO: renamed from: f */
    private TypedValue f3515f;

    /* JADX INFO: renamed from: g */
    private final Rect f3516g;

    /* JADX INFO: renamed from: h */
    private InterfaceC0582a f3517h;

    /* JADX INFO: renamed from: android.support.v7.widget.ContentFrameLayout$a */
    public interface InterfaceC0582a {
        /* JADX INFO: renamed from: a */
        void mo3268a();

        /* JADX INFO: renamed from: b */
        void mo3269b();
    }

    public ContentFrameLayout(Context context) {
        this(context, null);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ContentFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3516g = new Rect();
    }

    /* JADX INFO: renamed from: a */
    public void m3524a(Rect rect) {
        fitSystemWindows(rect);
    }

    public void setAttachListener(InterfaceC0582a interfaceC0582a) {
        this.f3517h = interfaceC0582a;
    }

    public void setDecorPadding(int i, int i2, int i3, int i4) {
        this.f3516g.set(i, i2, i3, i4);
        if (ViewCompat.isLaidOut(this)) {
            requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00f8  */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    protected void onMeasure(int r14, int r15) {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ContentFrameLayout.onMeasure(int, int):void");
    }

    public TypedValue getMinWidthMajor() {
        if (this.f3510a == null) {
            this.f3510a = new TypedValue();
        }
        return this.f3510a;
    }

    public TypedValue getMinWidthMinor() {
        if (this.f3511b == null) {
            this.f3511b = new TypedValue();
        }
        return this.f3511b;
    }

    public TypedValue getFixedWidthMajor() {
        if (this.f3512c == null) {
            this.f3512c = new TypedValue();
        }
        return this.f3512c;
    }

    public TypedValue getFixedWidthMinor() {
        if (this.f3513d == null) {
            this.f3513d = new TypedValue();
        }
        return this.f3513d;
    }

    public TypedValue getFixedHeightMajor() {
        if (this.f3514e == null) {
            this.f3514e = new TypedValue();
        }
        return this.f3514e;
    }

    public TypedValue getFixedHeightMinor() {
        if (this.f3515f == null) {
            this.f3515f = new TypedValue();
        }
        return this.f3515f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f3517h != null) {
            this.f3517h.mo3268a();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f3517h != null) {
            this.f3517h.mo3269b();
        }
    }
}
