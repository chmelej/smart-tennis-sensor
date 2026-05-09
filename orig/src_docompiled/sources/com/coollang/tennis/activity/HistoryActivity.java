package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.WeekDataBean;
import com.coollang.tennis.p011db.model.MyMainTable;
import com.coollang.tennis.widget.MyBarView;
import com.coollang.tennis.widget.MyHorizentalScrollView;
import com.coollang.tennis.widget.NavigateView;
import com.umeng.message.PushAgent;
import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.C1808is;
import p000.C1815iz;
import p000.C1873lc;
import p000.C1900mc;
import p000.C1902me;
import p000.C1912mk;
import p000.C1914mm;
import p000.InterfaceC1879li;
import p000.ada;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class HistoryActivity extends BaseActivity implements InterfaceC1879li {

    /* JADX INFO: renamed from: b */
    private NavigateView f6420b;

    /* JADX INFO: renamed from: c */
    private MyBarView f6421c;

    /* JADX INFO: renamed from: d */
    private List<WeekDataBean> f6422d;

    /* JADX INFO: renamed from: e */
    private MyHorizentalScrollView f6423e;

    /* JADX INFO: renamed from: f */
    private int f6424f;

    /* JADX INFO: renamed from: h */
    private C1815iz f6426h;

    /* JADX INFO: renamed from: i */
    private RelativeLayout f6427i;

    /* JADX INFO: renamed from: k */
    private TextView f6429k;

    /* JADX INFO: renamed from: g */
    private boolean f6425g = true;

    /* JADX INFO: renamed from: a */
    List<String> f6419a = new ArrayList();

    /* JADX INFO: renamed from: j */
    private String f6428j = "";

    /* JADX INFO: renamed from: l */
    private int f6430l = 5;

    /* JADX INFO: renamed from: m */
    private int f6431m = 10;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.fragment_history);
        akd.m1706a().m1719a(this);
        PushAgent.getInstance(this).onAppStart();
        this.f6428j = C1902me.m10480a(C1914mm.m10554a());
        this.f6427i = (RelativeLayout) findViewById(R.id.layoutIndex);
        this.f6422d = new ArrayList();
        this.f6424f = getResources().getDisplayMetrics().widthPixels;
        this.f6423e = (MyHorizentalScrollView) findViewById(R.id.horizontalScrollView1);
        this.f6421c = (MyBarView) findViewById(R.id.mBarChart);
        this.f6420b = (NavigateView) findViewById(R.id.history_title);
        this.f6429k = (TextView) findViewById(R.id.His_month);
        this.f6420b.setTitle(getString(R.string.history_title));
        this.f6420b.setRightButtonBackground(getResources().getColor(R.color.tranlete));
        this.f6420b.setRightButtonText(getString(R.string.history_list));
        this.f6420b.setRightButtonTextSize(17);
        this.f6420b.setRightHideBtn(true);
        GridView gridView = (GridView) findViewById(R.id.gridview);
        this.f6426h = new C1815iz(this);
        gridView.setAdapter((ListAdapter) this.f6426h);
        this.f6423e.setOnScrollListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6422d.clear();
        m6949d();
        if (this.f6419a.size() > 0) {
            m6948c();
        }
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        ada.m302b(this);
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        ada.m301a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 16 && c1873lc.f11065b == 1) {
            C1900mc.m10474b("history_http", c1873lc.f11064a);
            this.f6422d.clear();
            m6949d();
            if (this.f6419a.size() > 0) {
                m6948c();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m6948c() {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        boolean z = true;
        while (i < this.f6419a.size()) {
            arrayList.clear();
            arrayList.addAll(DataSupport.where("sign2 = ? And UserID = ? And isDeleted < 1 ", this.f6419a.get(i), this.f6428j).find(MyMainTable.class));
            C1808is.m9825a(arrayList);
            int duration = 0;
            int totletimes = 0;
            int caroline = 0;
            int maxSpeed = 0;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                duration += ((MyMainTable) arrayList.get(i2)).getDuration();
                totletimes += ((MyMainTable) arrayList.get(i2)).getTotletimes();
                caroline += ((MyMainTable) arrayList.get(i2)).getCaroline();
                if (((MyMainTable) arrayList.get(i2)).getMaxSpeed() > maxSpeed) {
                    maxSpeed = ((MyMainTable) arrayList.get(i2)).getMaxSpeed();
                }
            }
            if (z) {
                MyApplication.m7738a().f7403d = totletimes;
                z = false;
            }
            WeekDataBean weekDataBean = new WeekDataBean();
            StringBuilder sb = new StringBuilder();
            sb.append("第  ");
            i++;
            sb.append(i);
            sb.append("  周");
            weekDataBean.duration = sb.toString();
            weekDataBean.weekSportTime = duration;
            weekDataBean.totalNum = totletimes;
            weekDataBean.totalCalorie = caroline;
            weekDataBean.weekMaxSpeed = maxSpeed;
            this.f6422d.add(weekDataBean);
            C1808is.m9825a("run-initweeklist");
        }
        C1900mc.m10473a("=====weekDataList====", " " + this.f6422d.size());
        this.f6421c.setData(this.f6422d, 5);
        m6947b(this.f6422d.size() - 1);
        m6950e();
    }

    /* JADX INFO: renamed from: d */
    private void m6949d() {
        this.f6419a.clear();
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(DataSupport.where("UserID = ? And isDeleted < 1", this.f6428j).order("sign2").find(MyMainTable.class));
        for (int i = 0; i < arrayList.size(); i++) {
            if (!m6946a(((MyMainTable) arrayList.get(i)).getSign2(), this.f6419a)) {
                this.f6419a.add(((MyMainTable) arrayList.get(i)).getSign2());
                C1900mc.m10473a("weekList.size=", " " + this.f6419a.size());
            }
        }
        m6950e();
    }

    /* JADX INFO: renamed from: e */
    private void m6950e() {
        new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.HistoryActivity.1
            @Override // java.lang.Runnable
            public void run() {
                HistoryActivity.this.f6423e.fullScroll(66);
            }
        }, 500L);
    }

    /* JADX INFO: renamed from: a */
    private boolean m6946a(String str, List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (str.contentEquals(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    @Override // p000.InterfaceC1879li
    /* JADX INFO: renamed from: a */
    public void mo6951a(int i) {
        if (this.f6422d.size() == 0) {
            return;
        }
        float f = (this.f6424f - ((this.f6430l - 1) * this.f6431m)) / this.f6430l;
        float f2 = i;
        int i2 = (int) (f2 / (this.f6431m + f));
        float f3 = (i2 * (this.f6431m + f)) - f2;
        if (i2 > this.f6422d.size() - 1) {
            this.f6423e.smoothScrollTo((int) ((this.f6422d.size() * (this.f6431m + f)) - f), 0);
            int size = this.f6422d.size() - 1;
            this.f6421c.setMiddleBar(size);
            m6947b(size);
            return;
        }
        if (i2 <= 0) {
            this.f6423e.smoothScrollTo(0, 0);
            this.f6421c.setMiddleBar(i2);
            m6947b(i2);
        } else {
            if (f3 != 0.0f) {
                this.f6423e.smoothScrollBy((int) f3, 0);
                this.f6421c.setMiddleBar(i2);
                m6947b(i2);
                return;
            }
            this.f6423e.m8176b();
        }
    }

    /* JADX INFO: renamed from: b */
    private void m6947b(int i) {
        this.f6426h.m9835a(this, new String[]{Integer.toString(this.f6422d.get(i).totalCalorie / 7), Integer.toString(this.f6422d.get(i).totalNum / 7), String.format("%.02f", Float.valueOf((this.f6422d.get(i).weekSportTime / 7.0f) / 60.0f)), Integer.toString(this.f6422d.get(i).totalCalorie), Integer.toString(this.f6422d.get(i).totalNum), Integer.toString(this.f6422d.get(i).weekMaxSpeed)});
        String strM10545d = C1912mk.m10545d(this.f6419a.get(i));
        if (!MyApplication.m7738a().m7747g()) {
            strM10545d = strM10545d.replace("年", ".").replace("月", "");
        }
        this.f6429k.setText(strM10545d);
    }

    /* JADX INFO: renamed from: a */
    public static void m6945a(Activity activity) {
        activity.startActivity(new Intent(activity, (Class<?>) HistoryActivity.class));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }
}
