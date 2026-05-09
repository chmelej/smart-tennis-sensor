package com.coollang.tennis.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.coollang.tennis.beans.Video_LIST_Bean;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class Video_fragment_adapter extends FragmentPagerAdapter {

    /* JADX INFO: renamed from: a */
    private List<Fragment> f7395a;

    /* JADX INFO: renamed from: b */
    private List<Video_LIST_Bean.C1214d2> f7396b;

    public Video_fragment_adapter(FragmentManager fragmentManager, List<Fragment> list, List<Video_LIST_Bean.C1214d2> list2) {
        super(fragmentManager);
        this.f7395a = list;
        this.f7396b = list2;
    }

    @Override // android.support.v4.app.FragmentPagerAdapter
    public Fragment getItem(int i) {
        return this.f7395a.get(i);
    }

    @Override // android.support.v4.view.PagerAdapter
    public int getCount() {
        return this.f7395a.size();
    }

    @Override // android.support.v4.view.PagerAdapter
    public CharSequence getPageTitle(int i) {
        return (CharSequence) this.f7396b.get(i);
    }
}
