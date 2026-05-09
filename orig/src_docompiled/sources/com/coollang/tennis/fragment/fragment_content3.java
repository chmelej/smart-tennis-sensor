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
public class fragment_content3 extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener {

    /* JADX INFO: renamed from: a */
    ViewOnClickListenerC1832jp f7805a;

    /* JADX INFO: renamed from: b */
    Video_msg_Bean f7806b;

    /* JADX INFO: renamed from: d */
    public LayoutInflater f7808d;

    /* JADX INFO: renamed from: e */
    View f7809e;

    /* JADX INFO: renamed from: f */
    public int f7810f;

    /* JADX INFO: renamed from: g */
    public int f7811g;

    /* JADX INFO: renamed from: i */
    private C1874ld f7813i;

    /* JADX INFO: renamed from: j */
    private SwipeRefreshLayout f7814j;

    /* JADX INFO: renamed from: k */
    private ListView f7815k;

    /* JADX INFO: renamed from: c */
    public boolean f7807c = false;

    /* JADX INFO: renamed from: l */
    private int f7816l = 1;

    /* JADX INFO: renamed from: h */
    Handler f7812h = new Handler() { // from class: com.coollang.tennis.fragment.fragment_content3.2
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
        return C1914mm.m10555a(R.layout.fragment_video_concent3);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7814j = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.f7814j.setOnRefreshListener(this);
        this.f7815k = (ListView) view.findViewById(R.id.listview);
        this.f7808d = LayoutInflater.from(getActivity());
        this.f7809e = this.f7808d.inflate(R.layout.layout_footview, (ViewGroup) null);
        this.f7813i = new C1874ld();
        this.f7813i.m10214d("1", VideoFragment.f7761c.get(0).f7435ID);
        Log.e("TAG", "fragment_content3: " + VideoFragment.f7761c.get(0).f7435ID);
        this.f7815k.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coollang.tennis.fragment.fragment_content3.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (fragment_content3.this.f7810f == fragment_content3.this.f7811g && i == 0 && !fragment_content3.this.f7807c) {
                    fragment_content3.this.f7807c = true;
                    fragment_content3.this.f7809e.setVisibility(0);
                    fragment_content3.this.m7978d();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                fragment_content3.this.f7810f = i + i2;
                fragment_content3.this.f7811g = i3;
            }
        });
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 67) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取1视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取1视频失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "获取1视频成功:");
                    this.f7806b = (Video_msg_Bean) new Gson().fromJson(c1873lc.f11064a, Video_msg_Bean.class);
                    if (this.f7816l == 1) {
                        this.f7805a = new ViewOnClickListenerC1832jp(getActivity(), this.f7806b.errDesc);
                        this.f7815k.setAdapter((ListAdapter) this.f7805a);
                    } else {
                        this.f7805a.m10006a(this.f7806b.errDesc);
                    }
                    this.f7805a.notifyDataSetChanged();
                    m7976b();
                    break;
            }
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        akd.m1706a().m1719a(this);
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
        if (this.f7807c) {
            return;
        }
        m7977c();
    }

    /* JADX INFO: renamed from: b */
    public void m7976b() {
        Log.e("TAG", "loadComplete: ");
        this.f7807c = false;
        this.f7814j.setRefreshing(false);
        this.f7809e.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    public void m7977c() {
        this.f7816l = 1;
        this.f7807c = true;
        this.f7813i.m10214d(String.valueOf(this.f7816l), VideoFragment.f7761c.get(0).f7435ID);
        this.f7812h.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_content3.3
            @Override // java.lang.Runnable
            public void run() {
                fragment_content3.this.m7976b();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: d */
    public void m7978d() {
        Log.e("TAG", "onload: ");
        this.f7816l++;
        this.f7807c = true;
        this.f7813i.m10214d(String.valueOf(this.f7816l), VideoFragment.f7761c.get(0).f7435ID);
        this.f7812h.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_content3.4
            @Override // java.lang.Runnable
            public void run() {
                fragment_content3.this.m7976b();
            }
        }, 3000L);
    }
}
