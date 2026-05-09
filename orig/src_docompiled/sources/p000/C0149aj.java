package p000;

import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.design.R;
import android.support.design.card.MaterialCardView;

/* JADX INFO: renamed from: aj */
/* JADX INFO: compiled from: MaterialCardViewHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0149aj {

    /* JADX INFO: renamed from: a */
    private final MaterialCardView f1223a;

    /* JADX INFO: renamed from: b */
    private int f1224b;

    /* JADX INFO: renamed from: c */
    private int f1225c;

    public C0149aj(MaterialCardView materialCardView) {
        this.f1223a = materialCardView;
    }

    /* JADX INFO: renamed from: a */
    public void m1462a(TypedArray typedArray) {
        this.f1224b = typedArray.getColor(R.styleable.MaterialCardView_strokeColor, -1);
        this.f1225c = typedArray.getDimensionPixelSize(R.styleable.MaterialCardView_strokeWidth, 0);
        m1465c();
        m1459e();
    }

    /* JADX INFO: renamed from: a */
    public void m1461a(int i) {
        this.f1224b = i;
        m1465c();
    }

    /* JADX INFO: renamed from: a */
    public int m1460a() {
        return this.f1224b;
    }

    /* JADX INFO: renamed from: b */
    public void m1464b(int i) {
        this.f1225c = i;
        m1465c();
        m1459e();
    }

    /* JADX INFO: renamed from: b */
    public int m1463b() {
        return this.f1225c;
    }

    /* JADX INFO: renamed from: c */
    public void m1465c() {
        this.f1223a.setForeground(m1458d());
    }

    /* JADX INFO: renamed from: d */
    private Drawable m1458d() {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(this.f1223a.getRadius());
        if (this.f1224b != -1) {
            gradientDrawable.setStroke(this.f1225c, this.f1224b);
        }
        return gradientDrawable;
    }

    /* JADX INFO: renamed from: e */
    private void m1459e() {
        this.f1223a.setContentPadding(this.f1223a.getContentPaddingLeft() + this.f1225c, this.f1223a.getContentPaddingTop() + this.f1225c, this.f1223a.getContentPaddingRight() + this.f1225c, this.f1223a.getContentPaddingBottom() + this.f1225c);
    }
}
