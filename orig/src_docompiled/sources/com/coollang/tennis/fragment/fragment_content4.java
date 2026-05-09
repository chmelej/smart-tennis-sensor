package com.coollang.tennis.fragment;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.beans.Video_msg_Bean;
import com.google.gson.Gson;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1914mm;
import p000.ViewOnClickListenerC1832jp;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class fragment_content4 extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    ViewOnClickListenerC1832jp f7821a;

    /* JADX INFO: renamed from: c */
    public LayoutInflater f7823c;

    /* JADX INFO: renamed from: d */
    View f7824d;

    /* JADX INFO: renamed from: e */
    public int f7825e;

    /* JADX INFO: renamed from: f */
    public int f7826f;

    /* JADX INFO: renamed from: h */
    private C1874ld f7828h;

    /* JADX INFO: renamed from: i */
    private SwipeRefreshLayout f7829i;

    /* JADX INFO: renamed from: j */
    private ListView f7830j;

    /* JADX INFO: renamed from: b */
    public boolean f7822b = false;

    /* JADX INFO: renamed from: k */
    private int f7831k = 1;

    /* JADX INFO: renamed from: g */
    Handler f7827g = new Handler() { // from class: com.coollang.tennis.fragment.fragment_content4.2
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
        return C1914mm.m10555a(R.layout.fragment_video_concent4);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7828h = new C1874ld();
        this.f7828h.m10214d("1", VideoFragment.f7761c.get(1).f7435ID);
        Log.e("TAG", "fragment_content4: ");
        this.f7830j = (ListView) view.findViewById(R.id.listview);
        this.f7823c = LayoutInflater.from(getActivity());
        this.f7824d = this.f7823c.inflate(R.layout.layout_footview, (ViewGroup) null);
        this.f7829i = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.f7829i.setOnRefreshListener(this);
        this.f7830j.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coollang.tennis.fragment.fragment_content4.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (fragment_content4.this.f7825e == fragment_content4.this.f7826f && i == 0 && !fragment_content4.this.f7822b) {
                    fragment_content4.this.f7822b = true;
                    fragment_content4.this.f7824d.setVisibility(0);
                    fragment_content4.this.m7981d();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                fragment_content4.this.f7825e = i + i2;
                fragment_content4.this.f7826f = i3;
            }
        });
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 68) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取2视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取2视频失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "获取2视频成功:");
                    Video_msg_Bean video_msg_Bean = (Video_msg_Bean) new Gson().fromJson(c1873lc.f11064a, Video_msg_Bean.class);
                    if (this.f7831k == 1) {
                        this.f7821a = new ViewOnClickListenerC1832jp(getActivity(), video_msg_Bean.errDesc);
                        this.f7830j.setAdapter((ListAdapter) this.f7821a);
                    } else {
                        this.f7821a.m10006a(video_msg_Bean.errDesc);
                    }
                    this.f7821a.notifyDataSetChanged();
                    m7979b();
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
        if (this.f7822b) {
            return;
        }
        m7980c();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        akd.m1706a().m1719a(this);
    }

    /* JADX INFO: renamed from: b */
    public void m7979b() {
        Log.e("TAG", "loadComplete: ");
        this.f7822b = false;
        this.f7829i.setRefreshing(false);
        this.f7824d.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    public void m7980c() {
        this.f7831k = 1;
        this.f7822b = true;
        this.f7828h.m10214d(String.valueOf(this.f7831k), VideoFragment.f7761c.get(1).f7435ID);
        this.f7827g.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_content4.3
            @Override // java.lang.Runnable
            public void run() {
                fragment_content4.this.m7979b();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: d */
    public void m7981d() {
        Log.e("TAG", "onload: ");
        this.f7831k++;
        this.f7822b = true;
        this.f7828h.m10214d(String.valueOf(this.f7831k), VideoFragment.f7761c.get(1).f7435ID);
        this.f7827g.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_content4.4
            @Override // java.lang.Runnable
            public void run() {
                fragment_content4.this.m7979b();
            }
        }, 3000L);
    }
}
