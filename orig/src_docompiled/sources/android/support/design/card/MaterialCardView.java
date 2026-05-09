package android.support.design.card;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.R;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import p000.C0149aj;
import p000.C0751at;

/* JADX INFO: loaded from: classes.dex */
public class MaterialCardView extends CardView {

    /* JADX INFO: renamed from: e */
    private final C0149aj f2073e;

    public MaterialCardView(Context context) {
        this(context, null);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialCardViewStyle);
    }

    public MaterialCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayM5390a = C0751at.m5390a(context, attributeSet, R.styleable.MaterialCardView, i, R.style.Widget_MaterialComponents_CardView, new int[0]);
        this.f2073e = new C0149aj(this);
        this.f2073e.m1462a(typedArrayM5390a);
        typedArrayM5390a.recycle();
    }

    public void setStrokeColor(int i) {
        this.f2073e.m1461a(i);
    }

    public int getStrokeColor() {
        return this.f2073e.m1460a();
    }

    public void setStrokeWidth(int i) {
        this.f2073e.m1464b(i);
    }

    public int getStrokeWidth() {
        return this.f2073e.m1463b();
    }

    @Override // android.support.v7.widget.CardView
    public void setRadius(float f) {
        super.setRadius(f);
        this.f2073e.m1465c();
    }
}
