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
public class fragment_recommend extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    ViewOnClickListenerC1832jp f7866a;

    /* JADX INFO: renamed from: b */
    public int f7867b;

    /* JADX INFO: renamed from: c */
    public int f7868c;

    /* JADX INFO: renamed from: d */
    public View f7869d;

    /* JADX INFO: renamed from: f */
    public LayoutInflater f7871f;

    /* JADX INFO: renamed from: h */
    private ListView f7873h;

    /* JADX INFO: renamed from: i */
    private C1874ld f7874i;

    /* JADX INFO: renamed from: k */
    private SwipeRefreshLayout f7876k;

    /* JADX INFO: renamed from: j */
    private int f7875j = 1;

    /* JADX INFO: renamed from: e */
    public boolean f7870e = false;

    /* JADX INFO: renamed from: g */
    Handler f7872g = new Handler() { // from class: com.coollang.tennis.fragment.fragment_recommend.4
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
        return C1914mm.m10555a(R.layout.fragment_video_concent2);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7874i = new C1874ld();
        this.f7874i.m10234k("1");
        this.f7876k = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.f7876k.setOnRefreshListener(this);
        Log.e("TAG", "fragment_recommend: ");
        this.f7873h = (ListView) view.findViewById(R.id.listview);
        this.f7871f = LayoutInflater.from(getActivity());
        this.f7869d = this.f7871f.inflate(R.layout.layout_footview, (ViewGroup) null);
        this.f7873h.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coollang.tennis.fragment.fragment_recommend.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (fragment_recommend.this.f7867b == fragment_recommend.this.f7868c && i == 0 && !fragment_recommend.this.f7870e) {
                    fragment_recommend.this.f7870e = true;
                    fragment_recommend.this.f7869d.setVisibility(0);
                    fragment_recommend.this.m7990d();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                fragment_recommend.this.f7867b = i + i2;
                fragment_recommend.this.f7868c = i3;
            }
        });
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        akd.m1706a().m1719a(this);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 63) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取推荐视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取推荐视频失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "获取推荐视频成功:");
                    Video_msg_Bean video_msg_Bean = (Video_msg_Bean) new Gson().fromJson(c1873lc.f11064a, Video_msg_Bean.class);
                    if (this.f7875j == 1) {
                        this.f7866a = new ViewOnClickListenerC1832jp(getActivity(), video_msg_Bean.errDesc);
                        this.f7873h.setAdapter((ListAdapter) this.f7866a);
                    } else {
                        this.f7866a.m10006a(video_msg_Bean.errDesc);
                    }
                    m7988b();
                    this.f7866a.notifyDataSetChanged();
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

    /* JADX INFO: renamed from: b */
    public void m7988b() {
        Log.e("TAG", "loadComplete: ");
        this.f7870e = false;
        this.f7876k.setRefreshing(false);
        this.f7869d.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    public void m7989c() {
        this.f7875j = 1;
        this.f7870e = true;
        this.f7874i.m10234k(String.valueOf(this.f7875j));
        this.f7872g.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_recommend.2
            @Override // java.lang.Runnable
            public void run() {
                fragment_recommend.this.m7988b();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: d */
    public void m7990d() {
        Log.e("TAG", "onload: ");
        this.f7875j++;
        this.f7870e = true;
        this.f7874i.m10234k(String.valueOf(this.f7875j));
        this.f7872g.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_recommend.3
            @Override // java.lang.Runnable
            public void run() {
                fragment_recommend.this.m7988b();
            }
        }, 3000L);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        if (this.f7870e) {
            return;
        }
        m7989c();
    }
}
