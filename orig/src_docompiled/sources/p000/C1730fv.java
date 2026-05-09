package p000;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.widget.SeekBar;

/* JADX INFO: renamed from: fv */
/* JADX INFO: compiled from: AppCompatSeekBarHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1730fv extends C1729fu {

    /* JADX INFO: renamed from: a */
    private final SeekBar f9876a;

    /* JADX INFO: renamed from: b */
    private Drawable f9877b;

    /* JADX INFO: renamed from: c */
    private ColorStateList f9878c;

    /* JADX INFO: renamed from: d */
    private PorterDuff.Mode f9879d;

    /* JADX INFO: renamed from: e */
    private boolean f9880e;

    /* JADX INFO: renamed from: f */
    private boolean f9881f;

    public C1730fv(SeekBar seekBar) {
        super(seekBar);
        this.f9878c = null;
        this.f9879d = null;
        this.f9880e = false;
        this.f9881f = false;
        this.f9876a = seekBar;
    }

    @Override // p000.C1729fu
    /* JADX INFO: renamed from: a */
    public void mo9280a(AttributeSet attributeSet, int i) {
        super.mo9280a(attributeSet, i);
        C1766hd c1766hdM9601a = C1766hd.m9601a(this.f9876a.getContext(), attributeSet, R.styleable.AppCompatSeekBar, i, 0);
        Drawable drawableM9610b = c1766hdM9601a.m9610b(R.styleable.AppCompatSeekBar_android_thumb);
        if (drawableM9610b != null) {
            this.f9876a.setThumb(drawableM9610b);
        }
        m9283a(c1766hdM9601a.m9605a(R.styleable.AppCompatSeekBar_tickMark));
        if (c1766hdM9601a.m9620g(R.styleable.AppCompatSeekBar_tickMarkTintMode)) {
            this.f9879d = C1743gh.m9425a(c1766hdM9601a.m9603a(R.styleable.AppCompatSeekBar_tickMarkTintMode, -1), this.f9879d);
            this.f9881f = true;
        }
        if (c1766hdM9601a.m9620g(R.styleable.AppCompatSeekBar_tickMarkTint)) {
            this.f9878c = c1766hdM9601a.m9616e(R.styleable.AppCompatSeekBar_tickMarkTint);
            this.f9880e = true;
        }
        c1766hdM9601a.m9606a();
        m9281d();
    }

    /* JADX INFO: renamed from: a */
    void m9283a(Drawable drawable) {
        if (this.f9877b != null) {
            this.f9877b.setCallback(null);
        }
        this.f9877b = drawable;
        if (drawable != null) {
            drawable.setCallback(this.f9876a);
            DrawableCompat.setLayoutDirection(drawable, ViewCompat.getLayoutDirection(this.f9876a));
            if (drawable.isStateful()) {
                drawable.setState(this.f9876a.getDrawableState());
            }
            m9281d();
        }
        this.f9876a.invalidate();
    }

    /* JADX INFO: renamed from: d */
    private void m9281d() {
        if (this.f9877b != null) {
            if (this.f9880e || this.f9881f) {
                this.f9877b = DrawableCompat.wrap(this.f9877b.mutate());
                if (this.f9880e) {
                    DrawableCompat.setTintList(this.f9877b, this.f9878c);
                }
                if (this.f9881f) {
                    DrawableCompat.setTintMode(this.f9877b, this.f9879d);
                }
                if (this.f9877b.isStateful()) {
                    this.f9877b.setState(this.f9876a.getDrawableState());
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m9284b() {
        if (this.f9877b != null) {
            this.f9877b.jumpToCurrentState();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m9285c() {
        Drawable drawable = this.f9877b;
        if (drawable != null && drawable.isStateful() && drawable.setState(this.f9876a.getDrawableState())) {
            this.f9876a.invalidateDrawable(drawable);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9282a(Canvas canvas) {
        if (this.f9877b != null) {
            int max = this.f9876a.getMax();
            if (max > 1) {
                int intrinsicWidth = this.f9877b.getIntrinsicWidth();
                int intrinsicHeight = this.f9877b.getIntrinsicHeight();
                int i = intrinsicWidth >= 0 ? intrinsicWidth / 2 : 1;
                int i2 = intrinsicHeight >= 0 ? intrinsicHeight / 2 : 1;
                this.f9877b.setBounds(-i, -i2, i, i2);
                float width = ((this.f9876a.getWidth() - this.f9876a.getPaddingLeft()) - this.f9876a.getPaddingRight()) / max;
                int iSave = canvas.save();
                canvas.translate(this.f9876a.getPaddingLeft(), this.f9876a.getHeight() / 2);
                for (int i3 = 0; i3 <= max; i3++) {
                    this.f9877b.draw(canvas);
                    canvas.translate(width, 0.0f);
                }
                canvas.restoreToCount(iSave);
            }
        }
    }
}
