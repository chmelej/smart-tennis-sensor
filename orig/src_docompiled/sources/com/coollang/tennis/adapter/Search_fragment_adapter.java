package com.coollang.tennis.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Search_fragment_adapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a */
    private List<Fragment> f7394a;

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.f7394a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f7394a.size();
    }
}
