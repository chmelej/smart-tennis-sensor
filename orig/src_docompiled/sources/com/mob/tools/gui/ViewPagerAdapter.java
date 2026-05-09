package com.mob.tools.gui;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class ViewPagerAdapter {
    private MobViewPager parent;

    public abstract int getCount();

    public abstract View getView(int i, View view, ViewGroup viewGroup);

    public void onScreenChange(int i, int i2) {
    }

    final void setMobViewPager(MobViewPager mobViewPager) {
        this.parent = mobViewPager;
    }

    public void invalidate() {
        if (this.parent != null) {
            this.parent.setAdapter(this);
        }
    }
}
