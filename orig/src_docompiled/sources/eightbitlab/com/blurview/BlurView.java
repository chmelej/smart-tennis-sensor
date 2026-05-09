package eightbitlab.com.blurview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import p000.akt;
import p000.aku;
import p000.akv;

/* JADX INFO: loaded from: classes.dex */
public class BlurView extends FrameLayout {

    /* JADX INFO: renamed from: a */
    private static final String f9600a = "BlurView";

    /* JADX INFO: renamed from: b */
    private aku f9601b;

    /* JADX INFO: renamed from: c */
    private int f9602c;

    public BlurView(Context context) {
        super(context);
        m9046a(null, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9046a(attributeSet, 0);
    }

    public BlurView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9046a(attributeSet, i);
    }

    /* JADX INFO: renamed from: a */
    private void m9046a(AttributeSet attributeSet, int i) {
        m9047c();
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.BlurView, i, 0);
        this.f9602c = typedArrayObtainStyledAttributes.getColor(R.styleable.BlurView_blurOverlayColor, 0);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(false);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.f9601b.mo1751a(canvas)) {
            return;
        }
        this.f9601b.mo1753b(canvas);
        m9045a(canvas);
        super.draw(canvas);
    }

    /* JADX INFO: renamed from: a */
    public void m9049a() {
        this.f9601b.mo1752b();
    }

    /* JADX INFO: renamed from: b */
    public void m9050b() {
        this.f9601b.mo1754c();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f9601b.mo1747a();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f9601b.mo1755c(canvas);
    }

    /* JADX INFO: renamed from: a */
    private void m9045a(Canvas canvas) {
        canvas.drawColor(this.f9602c);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m9049a();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        m9050b();
    }

    private void setBlurController(aku akuVar) {
        this.f9601b.mo1756d();
        this.f9601b = akuVar;
    }

    public void setOverlayColor(int i) {
        this.f9602c = i;
        invalidate();
    }

    /* JADX INFO: renamed from: a */
    public C1690a m9048a(View view) {
        akv akvVar = new akv(this, view);
        setBlurController(akvVar);
        return new C1690a(akvVar);
    }

    /* JADX INFO: renamed from: eightbitlab.com.blurview.BlurView$a */
    public static class C1690a {

        /* JADX INFO: renamed from: a */
        aku f9604a;

        private C1690a(aku akuVar) {
            this.f9604a = akuVar;
        }

        /* JADX INFO: renamed from: a */
        public C1690a m9051a(float f) {
            this.f9604a.mo1748a(f);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C1690a m9052a(akt aktVar) {
            this.f9604a.mo1749a(aktVar);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C1690a m9053a(Drawable drawable) {
            this.f9604a.mo1750a(drawable);
            return this;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m9047c() {
        this.f9601b = new aku() { // from class: eightbitlab.com.blurview.BlurView.1
            @Override // p000.aku
            /* JADX INFO: renamed from: a */
            public void mo1747a() {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: a */
            public void mo1748a(float f) {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: a */
            public void mo1749a(akt aktVar) {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: a */
            public void mo1750a(Drawable drawable) {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: a */
            public boolean mo1751a(Canvas canvas) {
                return false;
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: b */
            public void mo1752b() {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: b */
            public void mo1753b(Canvas canvas) {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: c */
            public void mo1754c() {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: c */
            public void mo1755c(Canvas canvas) {
            }

            @Override // p000.aku
            /* JADX INFO: renamed from: d */
            public void mo1756d() {
            }
        };
    }
}
