package com.coollang.tennis.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.getSearchKeys_Activity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.beans.Video_msg_Bean;
import com.google.gson.Gson;
import p000.C1825ji;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1914mm;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class fragment_search_2 extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    C1825ji f7889a;

    /* JADX INFO: renamed from: c */
    public LayoutInflater f7891c;

    /* JADX INFO: renamed from: d */
    View f7892d;

    /* JADX INFO: renamed from: e */
    public int f7893e;

    /* JADX INFO: renamed from: f */
    public int f7894f;

    /* JADX INFO: renamed from: h */
    private C1874ld f7896h;

    /* JADX INFO: renamed from: i */
    private SwipeRefreshLayout f7897i;

    /* JADX INFO: renamed from: j */
    private ListView f7898j;

    /* JADX INFO: renamed from: l */
    private RelativeLayout f7900l;

    /* JADX INFO: renamed from: b */
    public boolean f7890b = false;

    /* JADX INFO: renamed from: k */
    private int f7899k = 1;

    /* JADX INFO: renamed from: g */
    Handler f7895g = new Handler() { // from class: com.coollang.tennis.fragment.fragment_search_2.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return C1914mm.m10555a(R.layout.fragment_video_search_2);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        akd.m1706a().m1719a(this);
        if (getActivity().getWindow().getAttributes().softInputMode != 2 && getActivity().getCurrentFocus() != null) {
            ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 2);
        }
        this.f7896h = new C1874ld();
        this.f7900l = (RelativeLayout) view.findViewById(R.id.layout_nomsg);
        this.f7897i = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.f7897i.setOnRefreshListener(this);
        this.f7898j = (ListView) view.findViewById(R.id.listview);
        this.f7891c = LayoutInflater.from(getActivity());
        this.f7892d = this.f7891c.inflate(R.layout.layout_footview, (ViewGroup) null);
        this.f7898j.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coollang.tennis.fragment.fragment_search_2.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (fragment_search_2.this.f7893e == fragment_search_2.this.f7894f && i == 0 && !fragment_search_2.this.f7890b) {
                    fragment_search_2.this.f7890b = true;
                    fragment_search_2.this.f7892d.setVisibility(0);
                    fragment_search_2.this.m7995b();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                fragment_search_2.this.f7893e = i + i2;
                fragment_search_2.this.f7894f = i3;
            }
        });
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 66) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "搜索视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "搜索视频失败");
                    break;
                case 1:
                    Video_msg_Bean video_msg_Bean = (Video_msg_Bean) new Gson().fromJson(c1873lc.f11064a, Video_msg_Bean.class);
                    if (getSearchKeys_Activity.f7381d) {
                        this.f7899k = 1;
                        getSearchKeys_Activity.f7381d = false;
                    }
                    if (this.f7899k == 1) {
                        this.f7889a = new C1825ji(getActivity(), video_msg_Bean.errDesc);
                        this.f7898j.setAdapter((ListAdapter) this.f7889a);
                        if (video_msg_Bean.errDesc.isEmpty()) {
                            this.f7900l.setVisibility(0);
                            this.f7898j.setVisibility(8);
                        } else {
                            this.f7900l.setVisibility(8);
                            this.f7898j.setVisibility(0);
                        }
                    } else {
                        this.f7889a.m9919a(video_msg_Bean.errDesc);
                    }
                    this.f7889a.notifyDataSetChanged();
                    m7996c();
                    C1900mc.m10475c("TAG", "搜索视频成功");
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        Log.e("TAG", "onPause: ");
        JZVideoPlayer.m5818d();
        JZVideoPlayer.m5813a();
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        this.f7899k = 1;
        this.f7890b = true;
        getSearchKeys_Activity getsearchkeys_activity = (getSearchKeys_Activity) getActivity();
        this.f7896h.m10218e(String.valueOf(this.f7899k), getsearchkeys_activity.m7731e());
        Log.e("TAG", "onload: " + getsearchkeys_activity.m7731e());
        this.f7895g.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_search_2.2
            @Override // java.lang.Runnable
            public void run() {
                fragment_search_2.this.m7996c();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: b */
    public void m7995b() {
        this.f7899k++;
        this.f7890b = true;
        getSearchKeys_Activity getsearchkeys_activity = (getSearchKeys_Activity) getActivity();
        this.f7896h.m10218e(String.valueOf(this.f7899k), getsearchkeys_activity.m7731e());
        Log.e("TAG", "onload: " + getsearchkeys_activity.m7731e());
        this.f7895g.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_search_2.3
            @Override // java.lang.Runnable
            public void run() {
                fragment_search_2.this.m7996c();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: c */
    public void m7996c() {
        Log.e("TAG", "loadComplete: ");
        this.f7890b = false;
        this.f7897i.setRefreshing(false);
        this.f7892d.setVisibility(8);
    }
}
