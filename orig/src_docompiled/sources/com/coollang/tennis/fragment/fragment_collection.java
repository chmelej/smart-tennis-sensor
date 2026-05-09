package com.coollang.tennis.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.jzvd.JZVideoPlayer;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.MyPostVideoActivity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.beans.MyvideoBean;
import com.coollang.tennis.beans.Video_msg_Bean;
import com.coollang.tennis.widget.CircleImageView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1914mm;
import p000.C2253xu;
import p000.ViewOnClickListenerC1824jh;
import p000.ViewOnClickListenerC1832jp;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class fragment_collection extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    /* JADX INFO: renamed from: a */
    ViewOnClickListenerC1832jp f7775a;

    /* JADX INFO: renamed from: b */
    ViewOnClickListenerC1824jh f7776b;

    /* JADX INFO: renamed from: c */
    View f7777c;

    /* JADX INFO: renamed from: d */
    View f7778d;

    /* JADX INFO: renamed from: f */
    List<MyvideoBean.C1210d2> f7780f;

    /* JADX INFO: renamed from: g */
    List<Video_msg_Bean.C1216d2> f7781g;

    /* JADX INFO: renamed from: h */
    public LayoutInflater f7782h;

    /* JADX INFO: renamed from: i */
    View f7783i;

    /* JADX INFO: renamed from: j */
    public int f7784j;

    /* JADX INFO: renamed from: k */
    public int f7785k;

    /* JADX INFO: renamed from: m */
    private C1874ld f7787m;

    /* JADX INFO: renamed from: q */
    private RecyclerView f7791q;

    /* JADX INFO: renamed from: r */
    private RelativeLayout f7792r;

    /* JADX INFO: renamed from: s */
    private SwipeRefreshLayout f7793s;

    /* JADX INFO: renamed from: t */
    private ListView f7794t;

    /* JADX INFO: renamed from: v */
    private CircleImageView f7796v;

    /* JADX INFO: renamed from: w */
    private TextView f7797w;

    /* JADX INFO: renamed from: x */
    private TextView f7798x;

    /* JADX INFO: renamed from: n */
    private int f7788n = 1;

    /* JADX INFO: renamed from: o */
    private String f7789o = "fragment_collection";

    /* JADX INFO: renamed from: p */
    private String f7790p = "GP";

    /* JADX INFO: renamed from: e */
    public boolean f7779e = false;

    /* JADX INFO: renamed from: u */
    private int f7795u = 1;

    /* JADX INFO: renamed from: l */
    Handler f7786l = new Handler() { // from class: com.coollang.tennis.fragment.fragment_collection.6
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return C1914mm.m10555a(R.layout.fragment_video_concent1);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7787m = new C1874ld();
        this.f7787m.m10232j(String.valueOf(this.f7795u));
        this.f7794t = (ListView) view.findViewById(R.id.listview);
        this.f7781g = new ArrayList();
        this.f7780f = new ArrayList();
        this.f7787m.m10240n("1");
        this.f7777c = getActivity().getLayoutInflater().inflate(R.layout.layout_recyleview, (ViewGroup) null);
        this.f7778d = getActivity().getLayoutInflater().inflate(R.layout.recylerview_footview, (ViewGroup) null);
        this.f7791q = (RecyclerView) this.f7777c.findViewById(R.id.recyclerview);
        this.f7792r = (RelativeLayout) view.findViewById(R.id.layout_image);
        m7971e();
        this.f7794t.addHeaderView(this.f7777c);
        this.f7796v = (CircleImageView) this.f7778d.findViewById(R.id.User_img);
        this.f7797w = (TextView) this.f7778d.findViewById(R.id.userName);
        this.f7798x = (TextView) this.f7778d.findViewById(R.id.more);
        this.f7793s = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        this.f7793s.setOnRefreshListener(this);
        this.f7782h = LayoutInflater.from(getActivity());
        this.f7783i = this.f7782h.inflate(R.layout.layout_footview, (ViewGroup) null);
        this.f7794t.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coollang.tennis.fragment.fragment_collection.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (fragment_collection.this.f7784j == fragment_collection.this.f7785k && i == 0 && !fragment_collection.this.f7779e) {
                    fragment_collection.this.f7779e = true;
                    fragment_collection.this.f7783i.setVisibility(0);
                    fragment_collection.this.m7975d();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                fragment_collection.this.f7784j = i + i2;
                fragment_collection.this.f7785k = i3;
                fragment_collection.this.f7785k = i3;
            }
        });
    }

    /* JADX INFO: renamed from: e */
    private void m7971e() {
        this.f7791q.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) { // from class: com.coollang.tennis.fragment.fragment_collection.2
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
            /* JADX INFO: renamed from: a */
            public RecyclerView.LayoutParams mo3542a() {
                return new RecyclerView.LayoutParams(-2, -2);
            }
        };
        linearLayoutManager.m3632b(0);
        this.f7791q.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: renamed from: f */
    private void m7972f() {
        this.f7791q.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity()) { // from class: com.coollang.tennis.fragment.fragment_collection.3
            @Override // android.support.v7.widget.LinearLayoutManager, android.support.v7.widget.RecyclerView.AbstractC0611i
            /* JADX INFO: renamed from: a */
            public RecyclerView.LayoutParams mo3542a() {
                return new RecyclerView.LayoutParams(-1, -2);
            }
        };
        linearLayoutManager.m3632b(0);
        this.f7791q.setLayoutManager(linearLayoutManager);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 71) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取我的收藏视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取我的收藏视频失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "获取我的收藏视频成功:");
                    Video_msg_Bean video_msg_Bean = (Video_msg_Bean) new Gson().fromJson(c1873lc.f11064a, Video_msg_Bean.class);
                    C1900mc.m10475c(this.f7789o, "更新收藏:" + this.f7795u);
                    this.f7781g = video_msg_Bean.errDesc;
                    if (this.f7795u == 1) {
                        this.f7775a = new ViewOnClickListenerC1832jp(getActivity(), video_msg_Bean.errDesc);
                        Log.e(this.f7789o, "更新收藏: ");
                        this.f7794t.setAdapter((ListAdapter) this.f7775a);
                        if (this.f7780f.isEmpty() && this.f7781g.isEmpty()) {
                            this.f7792r.setVisibility(0);
                        } else {
                            this.f7792r.setVisibility(8);
                        }
                    } else {
                        this.f7775a.m10006a(video_msg_Bean.errDesc);
                    }
                    m7973b();
                    this.f7775a.notifyDataSetChanged();
                    break;
            }
        }
        if (c1873lc.f11072i == 79) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取我的视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取我的视频失败");
                    break;
                case 1:
                    C1900mc.m10475c(this.f7789o, "获取我的视频成功:");
                    this.f7780f = ((MyvideoBean) new Gson().fromJson(c1873lc.f11064a, MyvideoBean.class)).errDesc;
                    Log.d(this.f7789o, "onEventMainThread: " + this.f7780f.size() + "=====");
                    if (this.f7788n == 1) {
                        if (!this.f7780f.isEmpty() && this.f7780f.size() >= 2) {
                            this.f7778d.setVisibility(0);
                            String str = this.f7780f.get(0).UserName;
                            String str2 = this.f7780f.get(0).Icon;
                            this.f7797w.setText(str);
                            if (!str2.equals("")) {
                                C2253xu.m12305a((Context) getActivity()).m12312a(str2).m12348a(this.f7796v);
                            }
                            if (this.f7794t.getHeaderViewsCount() == 1) {
                                this.f7794t.addHeaderView(this.f7778d);
                            }
                            this.f7778d.setVisibility(0);
                        } else {
                            this.f7794t.removeHeaderView(this.f7778d);
                            this.f7778d.setVisibility(8);
                        }
                    }
                    if (this.f7788n == 1) {
                        Log.e(this.f7789o, "更新我的视频: ");
                        if (!this.f7780f.isEmpty() && this.f7780f.size() == 1) {
                            m7972f();
                            this.f7776b = new ViewOnClickListenerC1824jh(getActivity(), R.layout.item_recycler_view_onlyone, this.f7780f.size(), this.f7780f);
                        } else if (this.f7780f.size() > 1) {
                            m7971e();
                            this.f7776b = new ViewOnClickListenerC1824jh(getActivity(), R.layout.item_recycler_view, this.f7780f.size(), this.f7780f);
                        }
                        this.f7791q.setAdapter(this.f7776b);
                        if (this.f7780f.isEmpty() && this.f7781g.isEmpty()) {
                            this.f7792r.setVisibility(0);
                        } else {
                            this.f7792r.setVisibility(8);
                        }
                    } else {
                        this.f7776b.m9914a(this.f7780f);
                    }
                    this.f7776b.m3880f();
                    break;
            }
        }
        if (c1873lc.f11072i == 84) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取我的视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取我的视频失败");
                    break;
                case 1:
                    C1900mc.m10475c(this.f7789o, "删除视频成功:");
                    this.f7788n = 1;
                    this.f7787m.m10240n(String.valueOf(this.f7788n));
                    break;
            }
        }
        if (c1873lc.f11072i == 87) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "服务器上传失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "上传失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "上传发布成功！！！！");
                    this.f7788n = 1;
                    this.f7787m.m10240n(String.valueOf(this.f7788n));
                    break;
            }
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        this.f7798x.setOnClickListener(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        Log.e("TAG", "onPause: ");
        JZVideoPlayer.m5818d();
        JZVideoPlayer.m5813a();
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        akd.m1706a().m1719a(this);
    }

    /* JADX INFO: renamed from: b */
    public void m7973b() {
        Log.e("TAG", "loadComplete: ");
        this.f7779e = false;
        this.f7793s.setRefreshing(false);
        this.f7783i.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    public void m7974c() {
        Log.e(this.f7789o, "onRfresh:load mypages:" + this.f7788n + "pages:" + this.f7795u);
        this.f7795u = 1;
        this.f7788n = 1;
        this.f7779e = true;
        this.f7787m.m10232j(String.valueOf(this.f7795u));
        this.f7787m.m10240n(String.valueOf(this.f7788n));
        this.f7786l.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_collection.4
            @Override // java.lang.Runnable
            public void run() {
                fragment_collection.this.m7973b();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: d */
    public void m7975d() {
        Log.e("TAG", "onload: ");
        this.f7795u++;
        this.f7788n++;
        this.f7779e = true;
        this.f7787m.m10232j(String.valueOf(this.f7795u));
        this.f7787m.m10240n(String.valueOf(this.f7788n));
        this.f7786l.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.fragment_collection.5
            @Override // java.lang.Runnable
            public void run() {
                fragment_collection.this.m7973b();
            }
        }, 3000L);
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        if (this.f7779e) {
            return;
        }
        m7974c();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.more) {
            return;
        }
        Intent intent = new Intent();
        intent.setClass(getActivity(), MyPostVideoActivity.class);
        startActivity(intent);
    }
}
