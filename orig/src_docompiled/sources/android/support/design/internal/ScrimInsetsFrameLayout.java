package android.support.design.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R;
import android.support.v4.view.OnApplyWindowInsetsListener;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.WindowInsetsCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p000.C0751at;

/* JADX INFO: loaded from: classes.dex */
public class ScrimInsetsFrameLayout extends FrameLayout {

    /* JADX INFO: renamed from: a */
    Drawable f2237a;

    /* JADX INFO: renamed from: b */
    Rect f2238b;

    /* JADX INFO: renamed from: c */
    private Rect f2239c;

    /* JADX INFO: renamed from: a */
    public void mo2462a(WindowInsetsCompat windowInsetsCompat) {
    }

    public ScrimInsetsFrameLayout(Context context) {
        this(context, null);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScrimInsetsFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2239c = new Rect();
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.ScrimInsetsFrameLayout, i, R.style.Widget_Design_ScrimInsetsFrameLayout, new int[0]);
        this.f2237a = typedArrayM5390a.getDrawable(R.styleable.ScrimInsetsFrameLayout_insetForeground);
        typedArrayM5390a.recycle();
        setWillNotDraw(true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: android.support.design.internal.ScrimInsetsFrameLayout.1
            @Override // android.support.v4.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                if (ScrimInsetsFrameLayout.this.f2238b == null) {
                    ScrimInsetsFrameLayout.this.f2238b = new Rect();
                }
                ScrimInsetsFrameLayout.this.f2238b.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
                ScrimInsetsFrameLayout.this.mo2462a(windowInsetsCompat);
                ScrimInsetsFrameLayout.this.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || ScrimInsetsFrameLayout.this.f2237a == null);
                ViewCompat.postInvalidateOnAnimation(ScrimInsetsFrameLayout.this);
                return windowInsetsCompat.consumeSystemWindowInsets();
            }
        });
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        super.draw(canvas);
        int width = getWidth();
        int height = getHeight();
        if (this.f2238b == null || this.f2237a == null) {
            return;
        }
        int iSave = canvas.save();
        canvas.translate(getScrollX(), getScrollY());
        this.f2239c.set(0, 0, width, this.f2238b.top);
        this.f2237a.setBounds(this.f2239c);
        this.f2237a.draw(canvas);
        this.f2239c.set(0, height - this.f2238b.bottom, width, height);
        this.f2237a.setBounds(this.f2239c);
        this.f2237a.draw(canvas);
        this.f2239c.set(0, this.f2238b.top, this.f2238b.left, height - this.f2238b.bottom);
        this.f2237a.setBounds(this.f2239c);
        this.f2237a.draw(canvas);
        this.f2239c.set(width - this.f2238b.right, this.f2238b.top, width, height - this.f2238b.bottom);
        this.f2237a.setBounds(this.f2239c);
        this.f2237a.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f2237a != null) {
            this.f2237a.setCallback(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f2237a != null) {
            this.f2237a.setCallback(null);
        }
    }
}
