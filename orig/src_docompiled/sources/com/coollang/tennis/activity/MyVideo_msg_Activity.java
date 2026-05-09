package com.coollang.tennis.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.beans.MymsgListBean;
import com.google.gson.Gson;
import p000.C1820jd;
import p000.C1873lc;
import p000.C1874ld;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class MyVideo_msg_Activity extends BaseActivity implements SwipeRefreshLayout.OnRefreshListener, View.OnClickListener {

    /* JADX INFO: renamed from: a */
    C1874ld f6490a;

    /* JADX INFO: renamed from: b */
    TextView f6491b;

    /* JADX INFO: renamed from: c */
    C1820jd f6492c;

    /* JADX INFO: renamed from: e */
    public LayoutInflater f6494e;

    /* JADX INFO: renamed from: f */
    View f6495f;

    /* JADX INFO: renamed from: g */
    public int f6496g;

    /* JADX INFO: renamed from: h */
    public int f6497h;

    /* JADX INFO: renamed from: j */
    private ImageView f6499j;

    /* JADX INFO: renamed from: l */
    private RelativeLayout f6501l;

    /* JADX INFO: renamed from: m */
    private SwipeRefreshLayout f6502m;

    /* JADX INFO: renamed from: n */
    private ListView f6503n;

    /* JADX INFO: renamed from: k */
    private final String f6500k = "MYMSG";

    /* JADX INFO: renamed from: d */
    public boolean f6493d = false;

    /* JADX INFO: renamed from: o */
    private int f6504o = 1;

    /* JADX INFO: renamed from: i */
    Handler f6498i = new Handler() { // from class: com.coollang.tennis.activity.MyVideo_msg_Activity.4
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_my_video_nsg_);
        this.f6499j = (ImageView) findViewById(R.id.back);
        this.f6502m = (SwipeRefreshLayout) findViewById(R.id.swipeRefreshLayout);
        this.f6502m.setOnRefreshListener(this);
        this.f6503n = (ListView) findViewById(R.id.listview);
        this.f6494e = LayoutInflater.from(this);
        this.f6495f = this.f6494e.inflate(R.layout.layout_footview, (ViewGroup) null);
        akd.m1706a().m1719a(this);
        this.f6490a = new C1874ld();
        this.f6490a.m10242o(String.valueOf(this.f6504o));
        this.f6491b = (TextView) findViewById(R.id.clear);
        this.f6501l = (RelativeLayout) findViewById(R.id.layout_nomsg);
        this.f6503n.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.coollang.tennis.activity.MyVideo_msg_Activity.1
            @Override // android.widget.AbsListView.OnScrollListener
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (MyVideo_msg_Activity.this.f6496g == MyVideo_msg_Activity.this.f6497h && i == 0 && !MyVideo_msg_Activity.this.f6493d) {
                    MyVideo_msg_Activity.this.f6493d = true;
                    MyVideo_msg_Activity.this.f6495f.setVisibility(0);
                    MyVideo_msg_Activity.this.m6996f();
                }
            }

            @Override // android.widget.AbsListView.OnScrollListener
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
                MyVideo_msg_Activity.this.f6496g = i + i2;
                MyVideo_msg_Activity.this.f6497h = i3;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6499j.setOnClickListener(this);
        this.f6491b.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: c */
    public void m6993c() {
        this.f6490a.m10247r();
        this.f6492c.m9862a();
        this.f6492c.notifyDataSetChanged();
        if (this.f6492c.m9864b()) {
            this.f6503n.setVisibility(8);
            this.f6501l.setVisibility(0);
        } else {
            this.f6503n.setVisibility(0);
            this.f6501l.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            finish();
        } else {
            if (id != R.id.clear) {
                return;
            }
            m6993c();
        }
    }

    @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
    public void onRefresh() {
        if (this.f6493d) {
            return;
        }
        m6995e();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 80) {
            switch (c1873lc.f11065b) {
                case -1:
                    Log.e("MYMSG", "MYMSG: 失败");
                    break;
                case 0:
                    Log.e("MYMSG", "MYMSG: 失败");
                    break;
                case 1:
                    Log.e("MYMSG", "MYMSG: 成功");
                    MymsgListBean mymsgListBean = (MymsgListBean) new Gson().fromJson(c1873lc.f11064a, MymsgListBean.class);
                    if (this.f6504o == 1) {
                        this.f6492c = new C1820jd(this, mymsgListBean.errDesc);
                        this.f6503n.setAdapter((ListAdapter) this.f6492c);
                    } else {
                        this.f6492c.m9863a(mymsgListBean.errDesc);
                    }
                    this.f6492c.notifyDataSetChanged();
                    m6994d();
                    if (this.f6492c.m9864b()) {
                        this.f6503n.setVisibility(8);
                        this.f6501l.setVisibility(0);
                    } else {
                        this.f6503n.setVisibility(0);
                        this.f6501l.setVisibility(8);
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 81) {
            switch (c1873lc.f11065b) {
                case -1:
                    Log.e("MYMSG", "Clear_ALL_MSG: 失败");
                    break;
                case 0:
                    Log.e("MYMSG", "Clear_ALL_MSG: 失败");
                    break;
                case 1:
                    Log.e("MYMSG", "Clear_ALL_MSG: 成功");
                    Log.e("TAG", "onEventMainThread: " + c1873lc.f11064a);
                    break;
            }
        }
        if (c1873lc.f11072i == 86) {
            switch (c1873lc.f11065b) {
                case -1:
                    Log.e("MYMSG", "DELETE_MSG: 失败");
                    break;
                case 0:
                    Log.e("MYMSG", "DELETE_MSG: 失败");
                    break;
                case 1:
                    Log.e("MYMSG", "DELETE_MSG: 成功");
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m6994d() {
        Log.e("TAG", "loadComplete: ");
        this.f6493d = false;
        this.f6502m.setRefreshing(false);
        this.f6495f.setVisibility(8);
    }

    /* JADX INFO: renamed from: e */
    public void m6995e() {
        this.f6504o = 1;
        this.f6493d = true;
        this.f6490a.m10242o(String.valueOf(this.f6504o));
        this.f6498i.postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.MyVideo_msg_Activity.2
            @Override // java.lang.Runnable
            public void run() {
                MyVideo_msg_Activity.this.m6994d();
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: f */
    public void m6996f() {
        Log.e("TAG", "onload: ");
        this.f6504o++;
        this.f6493d = true;
        this.f6490a.m10242o(String.valueOf(this.f6504o));
        this.f6498i.postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.MyVideo_msg_Activity.3
            @Override // java.lang.Runnable
            public void run() {
                MyVideo_msg_Activity.this.m6994d();
            }
        }, 3000L);
    }
}
