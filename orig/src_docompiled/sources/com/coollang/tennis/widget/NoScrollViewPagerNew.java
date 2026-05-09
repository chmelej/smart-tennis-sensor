package com.coollang.tennis.widget;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/* JADX INFO: loaded from: classes.dex */
public class NoScrollViewPagerNew extends ViewPager {

    /* JADX INFO: renamed from: a */
    private boolean f8561a;

    public NoScrollViewPagerNew(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f8561a = true;
    }

    public NoScrollViewPagerNew(Context context) {
        super(context);
        this.f8561a = true;
    }

    public void setNoScroll(boolean z) {
        this.f8561a = z;
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        super.scrollTo(i, i2);
    }

    @Override // android.support.v4.view.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f8561a) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.f8561a) {
            return false;
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.support.v4.view.ViewPager
    public void setCurrentItem(int i, boolean z) {
        super.setCurrentItem(i, z);
    }

    @Override // android.support.v4.view.ViewPager
    public void setCurrentItem(int i) {
        super.setCurrentItem(i);
    }
}
