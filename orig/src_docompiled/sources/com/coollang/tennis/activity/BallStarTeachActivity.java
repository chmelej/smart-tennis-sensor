package com.coollang.tennis.activity;

import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.beans.BallStartListBean;
import com.coollang.tennis.widget.NavigateView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p000.C1811iv;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1901md;
import p000.DialogC1860kq;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class BallStarTeachActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6276a;

    /* JADX INFO: renamed from: b */
    private ExpandableListView f6277b;

    /* JADX INFO: renamed from: c */
    private C1874ld f6278c;

    /* JADX INFO: renamed from: d */
    private Gson f6279d;

    /* JADX INFO: renamed from: e */
    private BallStartListBean f6280e;

    /* JADX INFO: renamed from: f */
    private C1811iv f6281f;

    /* JADX INFO: renamed from: g */
    private HashMap<String, List<BallStartListBean.BallStarVideoBean>> f6282g = new HashMap<>();

    /* JADX INFO: renamed from: h */
    private ArrayList<String> f6283h = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_ball_star_teach);
        m6891c();
        m6892d();
    }

    /* JADX INFO: renamed from: c */
    private void m6891c() {
        this.f6276a = (NavigateView) findViewById(R.id.nv_ball_star_teach);
        this.f6277b = (ExpandableListView) findViewById(R.id.expandlv_ball_star_teach);
    }

    /* JADX INFO: renamed from: d */
    private void m6892d() {
        this.f6276a.setTitle(getString(R.string.ball_star_teach));
        this.f6276a.setRightHideBtn(true);
        this.f6281f = new C1811iv(this.f6282g, this.f6283h);
        this.f6277b.setAdapter(this.f6281f);
        this.f6277b.setGroupIndicator(null);
        this.f6277b.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: com.coollang.tennis.activity.BallStarTeachActivity.1
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
                return true;
            }
        });
        this.f6277b.setOnChildClickListener(new ExpandableListView.OnChildClickListener() { // from class: com.coollang.tennis.activity.BallStarTeachActivity.2
            @Override // android.widget.ExpandableListView.OnChildClickListener
            public boolean onChildClick(ExpandableListView expandableListView, View view, final int i, final int i2, long j) {
                if (C1896lz.m10463a((int) j)) {
                    return true;
                }
                if (C1901md.m10477a()) {
                    if (!C1901md.m10478b()) {
                        C1887lq.m10412a(BallStarTeachActivity.this, BallStarTeachActivity.this.f6281f.getChild(i, i2).getUrl());
                    } else {
                        DialogC1860kq dialogC1860kq = new DialogC1860kq(6, BallStarTeachActivity.this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.BallStarTeachActivity.2.1
                            @Override // p000.DialogC1860kq.a
                            /* JADX INFO: renamed from: b */
                            public void mo6889b() {
                            }

                            @Override // p000.DialogC1860kq.a
                            /* JADX INFO: renamed from: a */
                            public void mo6888a() {
                                C1887lq.m10412a(BallStarTeachActivity.this, BallStarTeachActivity.this.f6281f.getChild(i, i2).getUrl());
                            }
                        });
                        dialogC1860kq.requestWindowFeature(1);
                        dialogC1860kq.show();
                        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                    }
                } else {
                    Toast.makeText(BallStarTeachActivity.this, R.string.net_fail, 0).show();
                }
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6278c = new C1874ld();
        this.f6279d = new Gson();
        this.f6278c.m10231j();
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        akd.m1706a().m1719a(this);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 25) {
            switch (c1873lc.f11065b) {
                case 1:
                    C1900mc.m10474b("球星教学", c1873lc.f11064a);
                    this.f6280e = (BallStartListBean) this.f6279d.fromJson(c1873lc.f11064a, BallStartListBean.class);
                    m6893e();
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m6893e() {
        this.f6282g.clear();
        this.f6283h.clear();
        for (int i = 0; i < this.f6280e.getErrDesc().size(); i++) {
            if (this.f6282g.containsKey(this.f6280e.getErrDesc().get(i).getStarName())) {
                this.f6282g.get(this.f6280e.getErrDesc().get(i).getStarName()).add(this.f6280e.getErrDesc().get(i));
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.f6280e.getErrDesc().get(i));
                this.f6282g.put(this.f6280e.getErrDesc().get(i).getStarName(), arrayList);
                this.f6283h.add(this.f6280e.getErrDesc().get(i).getStarName());
            }
        }
        this.f6281f.notifyDataSetChanged();
        int groupCount = this.f6281f.getGroupCount();
        for (int i2 = 0; i2 < groupCount; i2++) {
            this.f6277b.expandGroup(i2);
        }
    }
}
