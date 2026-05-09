package com.coollang.tennis.fragment;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.MainActivity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.RankingBean;
import com.google.gson.Gson;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import p000.AlertDialogC1872lb;
import p000.C1823jg;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1913ml;
import p000.ada;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class RankListFragment extends BaseFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public static final String f7568a = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: b */
    public static boolean f7569b = false;

    /* JADX INFO: renamed from: c */
    private RadioGroup f7570c;

    /* JADX INFO: renamed from: d */
    private TextView f7571d;

    /* JADX INFO: renamed from: e */
    private RadioGroup f7572e;

    /* JADX INFO: renamed from: f */
    private ViewPager f7573f;

    /* JADX INFO: renamed from: g */
    private List<View> f7574g;

    /* JADX INFO: renamed from: h */
    private C1874ld f7575h;

    /* JADX INFO: renamed from: i */
    private Gson f7576i;

    /* JADX INFO: renamed from: j */
    private C1237b f7577j;

    /* JADX INFO: renamed from: k */
    private View f7578k;

    /* JADX INFO: renamed from: l */
    private View f7579l;

    /* JADX INFO: renamed from: m */
    private C1236a f7580m;

    /* JADX INFO: renamed from: n */
    private C1236a f7581n;

    /* JADX INFO: renamed from: o */
    private String f7582o = "2";

    /* JADX INFO: renamed from: p */
    private Handler f7583p = new Handler() { // from class: com.coollang.tennis.fragment.RankListFragment.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 0:
                    RankListFragment.this.f7575h.m10210c("1", RankListFragment.this.f7582o);
                    RankListFragment.this.f7583p.sendEmptyMessageDelayed(1, 500L);
                    break;
                case 1:
                    RankListFragment.this.f7575h.m10210c("2", RankListFragment.this.f7582o);
                    break;
            }
        }
    };

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        return layoutInflater.inflate(R.layout.fragment_rank_list, (ViewGroup) null);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7570c = (RadioGroup) view.findViewById(R.id.rg_rank_order_date);
        this.f7571d = (TextView) view.findViewById(R.id.tv_rank_notice);
        this.f7572e = (RadioGroup) view.findViewById(R.id.rg_order_rank);
        this.f7573f = (ViewPager) view.findViewById(R.id.vp_rank_data);
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        this.f7575h = new C1874ld();
        this.f7576i = new Gson();
        if (!MyApplication.m7738a().m7747g()) {
            this.f7571d.setVisibility(8);
        }
        m7837c();
        m7839d();
        this.f7583p.sendEmptyMessage(0);
    }

    /* JADX INFO: renamed from: c */
    private void m7837c() {
        this.f7574g = new ArrayList();
        this.f7578k = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rank_list, (ViewGroup) null);
        this.f7579l = LayoutInflater.from(getActivity()).inflate(R.layout.layout_rank_list, (ViewGroup) null);
        this.f7580m = new C1236a(this.f7578k);
        this.f7581n = new C1236a(this.f7579l);
        this.f7574g.add(this.f7578k);
        this.f7574g.add(this.f7579l);
        this.f7577j = new C1237b();
        this.f7573f.setAdapter(this.f7577j);
        this.f7573f.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.coollang.tennis.fragment.RankListFragment.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 0) {
                    RankListFragment.this.f7581n.f7590b.setRefreshing(false);
                    ((RadioButton) RankListFragment.this.f7572e.findViewById(R.id.rb_rank_order_hit)).setChecked(true);
                } else {
                    RankListFragment.this.f7580m.f7590b.setRefreshing(false);
                    ((RadioButton) RankListFragment.this.f7572e.findViewById(R.id.rb_rank_order_score)).setChecked(true);
                }
            }
        });
    }

    /* JADX INFO: renamed from: d */
    private void m7839d() {
        this.f7570c.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.fragment.RankListFragment.3
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.rb_rank_month) {
                    RankListFragment.this.f7582o = "2";
                } else if (i == R.id.rb_rank_total) {
                    RankListFragment.this.f7582o = "0";
                }
                RankListFragment.this.f7583p.sendEmptyMessage(0);
                RankListFragment.this.f7580m.f7590b.setRefreshing(false);
                RankListFragment.this.f7581n.f7590b.setRefreshing(false);
            }
        });
        this.f7572e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.fragment.RankListFragment.4
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_rank_order_hit /* 2131296982 */:
                        RankListFragment.this.f7573f.setCurrentItem(0);
                        break;
                    case R.id.rb_rank_order_score /* 2131296983 */:
                        RankListFragment.this.f7573f.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.tv_no_head) {
            return;
        }
        m7841e();
    }

    /* JADX INFO: renamed from: e */
    private void m7841e() {
        AlertDialogC1872lb alertDialogC1872lb = new AlertDialogC1872lb(getActivity(), getString(R.string.dialog_set_head_tv_title), new AlertDialogC1872lb.a() { // from class: com.coollang.tennis.fragment.RankListFragment.5
            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: a */
            public void mo7024a() {
                ((MainActivity) RankListFragment.this.getActivity()).m6990b("rankhead");
            }

            @Override // p000.AlertDialogC1872lb.a
            /* JADX INFO: renamed from: b */
            public void mo7025b() {
                ((MainActivity) RankListFragment.this.getActivity()).m6989a("rankhead");
            }
        });
        alertDialogC1872lb.show();
        Window window = alertDialogC1872lb.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.mystyle);
        window.setGravity(80);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        akd.m1706a().m1719a(this);
        ada.m302b(getActivity());
        m7843f();
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        m7843f();
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
        ada.m301a(getActivity());
    }

    /* JADX INFO: renamed from: f */
    private void m7843f() {
        if (f7569b) {
            f7569b = false;
            this.f7583p.sendEmptyMessage(0);
        }
    }

    public void onEventMainThread(C1873lc c1873lc) {
        new Gson();
        if (c1873lc.f11072i == 4) {
            if (c1873lc.f11070g.equals("1")) {
                this.f7580m.f7590b.setRefreshing(false);
            } else {
                this.f7581n.f7590b.setRefreshing(false);
            }
            switch (c1873lc.f11065b) {
                case 1:
                    if (c1873lc.f11071h.equals(this.f7582o) && c1873lc.f11070g.equals("1")) {
                        this.f7580m.m7850a(c1873lc.f11064a, "1");
                        this.f7573f.getCurrentItem();
                        break;
                    } else if (c1873lc.f11071h.equals(this.f7582o) && c1873lc.f11070g.equals("2")) {
                        this.f7581n.m7850a(c1873lc.f11064a, "2");
                        this.f7573f.getCurrentItem();
                        break;
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 6) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    C1913ml.m10553a(getString(R.string.upload_fail));
                    break;
                case 1:
                    this.f7583p.sendEmptyMessage(0);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.fragment.RankListFragment$b */
    class C1237b extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private C1237b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) RankListFragment.this.f7574g.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) RankListFragment.this.f7574g.get(i));
            return RankListFragment.this.f7574g.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.fragment.RankListFragment$a */
    class C1236a {

        /* JADX INFO: renamed from: b */
        private SwipeRefreshLayout f7590b;

        /* JADX INFO: renamed from: c */
        private RecyclerView f7591c;

        /* JADX INFO: renamed from: d */
        private C1823jg f7592d;

        /* JADX INFO: renamed from: e */
        private RankingBean f7593e;

        public C1236a(View view) {
            this.f7590b = (SwipeRefreshLayout) view.findViewById(R.id.activity_main_swipe_refresh_layout);
            this.f7591c = (RecyclerView) view.findViewById(R.id.fragment_rank_recyclerview);
            this.f7591c.setLayoutManager(new LinearLayoutManager(RankListFragment.this.getActivity()));
            this.f7590b.setColorSchemeResources(R.color.white_ban);
            this.f7590b.setProgressBackgroundColor(R.color.text_menu_checked);
            this.f7590b.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.coollang.tennis.fragment.RankListFragment.a.1
                @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
                public void onRefresh() {
                    RankListFragment.this.f7583p.sendEmptyMessage(0);
                }
            });
        }

        /* JADX INFO: renamed from: a */
        public void m7850a(String str, String str2) {
            this.f7593e = (RankingBean) RankListFragment.this.f7576i.fromJson(str, RankingBean.class);
            this.f7592d = new C1823jg(RankListFragment.this.getActivity(), str2, this.f7593e);
            this.f7591c.setAdapter(this.f7592d);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m7848b() {
        File file = new File(f7568a);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        m7847a(MyApplication.m7738a().f7400a, file);
        MyApplication.m7738a().m7746f();
        this.f7575h.m10188a(file);
        this.f7583p.sendEmptyMessage(0);
    }

    /* JADX INFO: renamed from: a */
    public void m7847a(Bitmap bitmap, File file) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 80;
        bitmap.compress(Bitmap.CompressFormat.JPEG, 80, byteArrayOutputStream);
        while (byteArrayOutputStream.toByteArray().length / 1024 > 300) {
            byteArrayOutputStream.reset();
            i -= 10;
            bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        }
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
