package com.coollang.tennis.activity;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.coollang.tennis.widget.ScatterChartView;
import java.util.ArrayList;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.C1910mi;

/* JADX INFO: loaded from: classes.dex */
public class TrainHandReportActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6999a;

    /* JADX INFO: renamed from: b */
    private TextView f7000b;

    /* JADX INFO: renamed from: c */
    private TextView f7001c;

    /* JADX INFO: renamed from: d */
    private TextView f7002d;

    /* JADX INFO: renamed from: e */
    private RadioGroup f7003e;

    /* JADX INFO: renamed from: f */
    private ViewPager f7004f;

    /* JADX INFO: renamed from: g */
    private int f7005g;

    /* JADX INFO: renamed from: h */
    private int f7006h;

    /* JADX INFO: renamed from: i */
    private OnTimeMainTable f7007i;

    /* JADX INFO: renamed from: j */
    private C1120b f7008j;

    /* JADX INFO: renamed from: k */
    private C1120b f7009k;

    /* JADX INFO: renamed from: l */
    private List<View> f7010l;

    /* JADX INFO: renamed from: m */
    private Typeface f7011m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_train_hand);
        m7400c();
        m7401d();
        m7402e();
    }

    /* JADX INFO: renamed from: c */
    private void m7400c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7005g = extras.getInt("mainid");
            this.f7006h = extras.getInt("trainTime");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7401d() {
        this.f6999a = (NavigateView) findViewById(R.id.navigateView);
        this.f7000b = (TextView) findViewById(R.id.tv_train_time);
        this.f7001c = (TextView) findViewById(R.id.tv_train_level);
        this.f7002d = (TextView) findViewById(R.id.tv_train_finish_status);
        this.f7003e = (RadioGroup) findViewById(R.id.rg_target);
        this.f7004f = (ViewPager) findViewById(R.id.vp_train_sport);
    }

    /* JADX INFO: renamed from: e */
    private void m7402e() {
        this.f6999a.setTitle(getString(R.string.hand_train_report));
        this.f6999a.setRightHideBtn(true);
        this.f6999a.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrainHandReportActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                TrainHandReportActivity.this.m7733j();
            }
        });
        this.f7011m = Typeface.createFromAsset(getAssets(), "fonts/S.ttf");
        m7404g();
        m7403f();
        this.f7004f.setAdapter(new C1119a());
    }

    /* JADX INFO: renamed from: f */
    private void m7403f() {
        this.f7000b.setTypeface(this.f7011m);
        this.f7001c.setTypeface(this.f7011m);
        this.f7002d.setTypeface(this.f7011m);
    }

    /* JADX INFO: renamed from: g */
    private void m7404g() {
        this.f7010l = new ArrayList();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.item_vp_train_sport, (ViewGroup) null);
        this.f7008j = new C1120b(viewInflate);
        this.f7010l.add(viewInflate);
        View viewInflate2 = LayoutInflater.from(this).inflate(R.layout.item_vp_train_sport, (ViewGroup) null);
        this.f7009k = new C1120b(viewInflate2);
        this.f7010l.add(viewInflate2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7007i = (OnTimeMainTable) DataSupport.find(OnTimeMainTable.class, this.f7005g);
        m7405h();
        m7396a(this.f7008j, "0");
        m7396a(this.f7009k, "1");
        m7406i();
    }

    /* JADX INFO: renamed from: a */
    private void m7396a(C1120b c1120b, String str) {
        int iCount = DataSupport.where("actionType = 4 AND handType = ? AND trainId = ? ", str, String.valueOf(this.f7005g)).count(OnTimeDetailTable.class);
        int iCount2 = DataSupport.where("actionType = 4 AND handType = ? AND trainId = ? AND hitSpeed >= ?", str, String.valueOf(this.f7005g), String.valueOf(this.f7007i.getForeTargetSpeed())).count(OnTimeDetailTable.class);
        int iCount3 = DataSupport.where("actionType = 5 AND handType = ? AND trainId = ? ", str, String.valueOf(this.f7005g)).count(OnTimeDetailTable.class);
        int iCount4 = DataSupport.where("actionType = 5 AND handType = ? AND trainId = ? AND hitSpeed >= ?", str, String.valueOf(this.f7005g), String.valueOf(this.f7007i.getForeTargetSpeed())).count(OnTimeDetailTable.class);
        int iCount5 = DataSupport.where("actionType = 3 AND handType = ? AND trainId = ? ", str, String.valueOf(this.f7005g)).count(OnTimeDetailTable.class);
        int iCount6 = DataSupport.where("actionType = 3 AND handType = ? AND trainId = ? AND hitSpeed >= ?", str, String.valueOf(this.f7005g), String.valueOf(this.f7007i.getForeTargetSpeed())).count(OnTimeDetailTable.class);
        c1120b.f7020e.setText(m7395a(iCount2, iCount));
        c1120b.f7021f.setText(m7395a(iCount4, iCount3));
        c1120b.f7022g.setText(m7395a(iCount6, iCount5));
        int i = iCount + iCount3 + iCount5;
        c1120b.f7017b.setText(String.valueOf(i));
        int i2 = iCount2 + iCount4 + iCount6;
        c1120b.f7018c.setText(String.valueOf(i2));
        c1120b.f7019d.setText(m7398b(i2, i));
        c1120b.f7024i.setLimitData(this.f7007i.getForeTargetSpeed());
        c1120b.f7024i.setLimitDescribt(getString(R.string.target_speed));
        c1120b.f7025j.setText(R.string.hand_scatter_y);
        c1120b.f7017b.setTypeface(this.f7011m);
        c1120b.f7018c.setTypeface(this.f7011m);
        c1120b.f7019d.setTypeface(this.f7011m);
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * from OnTimeDetailTable where trainId = ? AND handType = ?", String.valueOf(this.f7005g), str);
        ArrayList arrayList = new ArrayList();
        int i3 = 0;
        while (cursorFindBySQL.moveToNext()) {
            arrayList.add(Integer.valueOf(cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("hitspeed"))));
            i3 += cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("hitspeed"));
        }
        c1120b.f7024i.setLeftMax(140, 20);
        c1120b.f7024i.setSpeedList(arrayList);
        int count = i3 / (cursorFindBySQL.getCount() <= 0 ? 1 : cursorFindBySQL.getCount());
        c1120b.f7023h.setText(C1910mi.m10524a(String.valueOf(count), String.format(getString(R.string.ontime_train_send_avg), String.valueOf(count)), 12, getResources().getColor(R.color.yellow_re_start_ble)));
        cursorFindBySQL.close();
    }

    /* JADX INFO: renamed from: a */
    private String m7395a(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i);
        stringBuffer.append("/");
        stringBuffer.append(i2);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    private String m7398b(int i, int i2) {
        if (i2 <= 0) {
            i2 = 1;
        }
        int i3 = (i * 100) / i2;
        if (i3 > 100) {
            i3 = 100;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(i3);
        stringBuffer.append("%");
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: h */
    private void m7405h() {
        this.f7000b.setText(String.valueOf(this.f7006h));
        this.f7001c.setText(m7407a(this.f7007i.getHitRate()));
        this.f7002d.setText(m7408b(this.f7007i.getMaxProgress()));
    }

    /* JADX INFO: renamed from: i */
    private void m7406i() {
        this.f7003e.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.activity.TrainHandReportActivity.2
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_back_hand_target /* 2131296971 */:
                        if (TrainHandReportActivity.this.f7004f.getCurrentItem() != 1) {
                            TrainHandReportActivity.this.f7004f.setCurrentItem(1);
                        }
                        break;
                    case R.id.rb_fore_hand_target /* 2131296972 */:
                        if (TrainHandReportActivity.this.f7004f.getCurrentItem() != 0) {
                            TrainHandReportActivity.this.f7004f.setCurrentItem(0);
                        }
                        break;
                }
            }
        });
        this.f7004f.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.coollang.tennis.activity.TrainHandReportActivity.3
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                if (i == 0) {
                    ((RadioButton) TrainHandReportActivity.this.f7003e.findViewById(R.id.rb_fore_hand_target)).setChecked(true);
                } else {
                    ((RadioButton) TrainHandReportActivity.this.f7003e.findViewById(R.id.rb_back_hand_target)).setChecked(true);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public String m7407a(int i) {
        if (i < 8) {
            return getString(R.string.train_deep_level_low);
        }
        if (i < 16) {
            return getString(R.string.train_deep_level_middle);
        }
        return getString(R.string.train_deep_level_high);
    }

    /* JADX INFO: renamed from: b */
    public String m7408b(int i) {
        if (i < 60) {
            return getString(R.string.train_finish_level_bad);
        }
        if (i < 80) {
            return getString(R.string.train_finish_level_ok);
        }
        if (i < 90) {
            return getString(R.string.train_finish_level_good);
        }
        return getString(R.string.train_finish_level_excellent);
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.TrainHandReportActivity$a */
    class C1119a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private C1119a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return TrainHandReportActivity.this.f7010l.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) TrainHandReportActivity.this.f7010l.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) TrainHandReportActivity.this.f7010l.get(i));
            return TrainHandReportActivity.this.f7010l.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.TrainHandReportActivity$b */
    class C1120b {

        /* JADX INFO: renamed from: b */
        private TextView f7017b;

        /* JADX INFO: renamed from: c */
        private TextView f7018c;

        /* JADX INFO: renamed from: d */
        private TextView f7019d;

        /* JADX INFO: renamed from: e */
        private TextView f7020e;

        /* JADX INFO: renamed from: f */
        private TextView f7021f;

        /* JADX INFO: renamed from: g */
        private TextView f7022g;

        /* JADX INFO: renamed from: h */
        private TextView f7023h;

        /* JADX INFO: renamed from: i */
        private ScatterChartView f7024i;

        /* JADX INFO: renamed from: j */
        private TextView f7025j;

        public C1120b(View view) {
            this.f7017b = (TextView) view.findViewById(R.id.tv_train_hit_total);
            this.f7018c = (TextView) view.findViewById(R.id.tv_train_hit_target);
            this.f7019d = (TextView) view.findViewById(R.id.tv_train_hit_pass);
            this.f7020e = (TextView) view.findViewById(R.id.tv_train_report_xuan);
            this.f7021f = (TextView) view.findViewById(R.id.tv_train_report_ping);
            this.f7022g = (TextView) view.findViewById(R.id.tv_train_report_xiao);
            this.f7023h = (TextView) view.findViewById(R.id.tv_avg_speed_ontime_hand);
            this.f7024i = (ScatterChartView) view.findViewById(R.id.scatter_chart_view);
            this.f7025j = (TextView) view.findViewById(R.id.tv_scatter_y_des);
        }
    }
}
