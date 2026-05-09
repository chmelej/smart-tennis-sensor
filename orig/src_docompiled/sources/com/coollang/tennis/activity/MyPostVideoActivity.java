package com.coollang.tennis.activity;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.beans.MyvideoBean;
import com.google.gson.Gson;
import java.io.Serializable;
import java.util.List;
import p000.C1819jc;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class MyPostVideoActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public LayoutInflater f6480a;

    /* JADX INFO: renamed from: c */
    List<MyvideoBean.C1210d2> f6482c;

    /* JADX INFO: renamed from: d */
    C1819jc f6483d;

    /* JADX INFO: renamed from: e */
    private C1874ld f6484e;

    /* JADX INFO: renamed from: f */
    private ImageView f6485f;

    /* JADX INFO: renamed from: g */
    private ListView f6486g;

    /* JADX INFO: renamed from: h */
    private int f6487h = 1;

    /* JADX INFO: renamed from: b */
    public boolean f6481b = false;

    /* JADX INFO: renamed from: i */
    private String f6488i = "MyPostVideoActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_my_post_video);
        akd.m1706a().m1719a(this);
        this.f6484e = new C1874ld();
        this.f6485f = (ImageView) findViewById(R.id.back);
        this.f6486g = (ListView) findViewById(R.id.listview);
        this.f6480a = LayoutInflater.from(this);
        this.f6484e.m10240n("1");
        this.f6486g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.MyPostVideoActivity.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                Intent intent = new Intent();
                intent.putExtra("bean_index", 2);
                intent.putExtra("bean", (Serializable) MyPostVideoActivity.this.f6483d.getItem(i));
                intent.setClass(MyPostVideoActivity.this, Video_detail_Activity.class);
                MyPostVideoActivity.this.startActivity(intent);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6485f.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.back) {
            return;
        }
        finish();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 79) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "获取我的视频服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "获取我的视频失败");
                    break;
                case 1:
                    C1900mc.m10475c(this.f6488i, "获取我的视频成功:");
                    MyvideoBean myvideoBean = (MyvideoBean) new Gson().fromJson(c1873lc.f11064a, MyvideoBean.class);
                    Log.e(this.f6488i, "MyvideoBean: " + myvideoBean.errDesc);
                    this.f6482c = myvideoBean.errDesc;
                    if (this.f6487h == 1) {
                        Log.e(this.f6488i, "更新我的视频: ");
                        this.f6483d = new C1819jc(this, this.f6482c);
                        this.f6486g.setAdapter((ListAdapter) this.f6483d);
                    } else {
                        this.f6483d.m9860a(this.f6482c);
                    }
                    this.f6483d.notifyDataSetChanged();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }
}
