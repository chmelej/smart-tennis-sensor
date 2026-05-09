package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.appcompat.R;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RatingBar;
import p000.C1729fu;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatRatingBar extends RatingBar {

    /* JADX INFO: renamed from: a */
    private final C1729fu f3469a;

    public AppCompatRatingBar(Context context) {
        this(context, null);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.ratingBarStyle);
    }

    public AppCompatRatingBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3469a = new C1729fu(this);
        this.f3469a.mo9280a(attributeSet, i);
    }

    @Override // android.widget.RatingBar, android.widget.AbsSeekBar, android.widget.ProgressBar, android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap bitmapM9279a = this.f3469a.m9279a();
        if (bitmapM9279a != null) {
            setMeasuredDimension(View.resolveSizeAndState(bitmapM9279a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
