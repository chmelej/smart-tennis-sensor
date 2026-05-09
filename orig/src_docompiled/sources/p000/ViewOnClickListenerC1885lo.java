package p000;

import android.app.Activity;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.MyDataBean;
import com.coollang.tennis.widget.PersonYearBarChartView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: lo */
/* JADX INFO: compiled from: PersonDataManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1885lo implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private View f11357a;

    /* JADX INFO: renamed from: b */
    private Activity f11358b;

    /* JADX INFO: renamed from: c */
    private TextView f11359c;

    /* JADX INFO: renamed from: d */
    private TextView f11360d;

    /* JADX INFO: renamed from: e */
    private ImageView f11361e;

    /* JADX INFO: renamed from: f */
    private ImageView f11362f;

    /* JADX INFO: renamed from: g */
    private TextView f11363g;

    /* JADX INFO: renamed from: h */
    private ViewPager f11364h;

    /* JADX INFO: renamed from: i */
    private LinearLayout f11365i;

    /* JADX INFO: renamed from: j */
    private View f11366j;

    /* JADX INFO: renamed from: k */
    private View f11367k;

    /* JADX INFO: renamed from: l */
    private View f11368l;

    /* JADX INFO: renamed from: m */
    private View f11369m;

    /* JADX INFO: renamed from: n */
    private View f11370n;

    /* JADX INFO: renamed from: o */
    private View f11371o;

    /* JADX INFO: renamed from: p */
    private View f11372p;

    /* JADX INFO: renamed from: q */
    private b f11373q;

    /* JADX INFO: renamed from: r */
    private b f11374r;

    /* JADX INFO: renamed from: s */
    private b f11375s;

    /* JADX INFO: renamed from: t */
    private b f11376t;

    /* JADX INFO: renamed from: u */
    private b f11377u;

    /* JADX INFO: renamed from: v */
    private b f11378v;

    /* JADX INFO: renamed from: w */
    private List<View> f11379w;

    /* JADX INFO: renamed from: x */
    private a f11380x;

    /* JADX INFO: renamed from: y */
    private Typeface f11381y;

    /* JADX INFO: renamed from: z */
    private ViewPager.OnPageChangeListener f11382z = new ViewPager.OnPageChangeListener() { // from class: lo.1
        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f, int i2) {
        }

        @Override // android.support.v4.view.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            ViewOnClickListenerC1885lo.this.f11363g.setText(String.format(ViewOnClickListenerC1885lo.this.f11358b.getString(R.string.person_year_data), String.valueOf((String) ((View) ViewOnClickListenerC1885lo.this.f11379w.get(i)).getTag())));
            if (i > 0) {
                ViewOnClickListenerC1885lo.this.f11361e.setImageResource(R.drawable.arrow_person_left_has);
            } else {
                ViewOnClickListenerC1885lo.this.f11361e.setImageResource(R.drawable.arrow_person_left_no);
            }
            if (i < ViewOnClickListenerC1885lo.this.f11379w.size() - 1) {
                ViewOnClickListenerC1885lo.this.f11362f.setImageResource(R.drawable.arrow_person_right_has);
            } else {
                ViewOnClickListenerC1885lo.this.f11362f.setImageResource(R.drawable.arrow_person_right_no);
            }
        }
    };

    public ViewOnClickListenerC1885lo(View view, Activity activity) {
        this.f11357a = view;
        this.f11358b = activity;
        m10376a();
        m10380b();
        m10383c();
    }

    /* JADX INFO: renamed from: a */
    private void m10376a() {
        this.f11359c = (TextView) this.f11357a.findViewById(R.id.tv_use_time);
        this.f11360d = (TextView) this.f11357a.findViewById(R.id.tv_hit_count);
        this.f11365i = (LinearLayout) this.f11357a.findViewById(R.id.ll_person_best_data);
        this.f11364h = (ViewPager) this.f11357a.findViewById(R.id.vp_chart_year_data);
        this.f11366j = this.f11357a.findViewById(R.id.fore_speed_data);
        this.f11367k = this.f11357a.findViewById(R.id.back_speed_data);
        this.f11368l = this.f11357a.findViewById(R.id.send_speed_data);
        this.f11369m = this.f11357a.findViewById(R.id.sport_score_data);
        this.f11370n = this.f11357a.findViewById(R.id.sport_time_data);
        this.f11371o = this.f11357a.findViewById(R.id.sport_count_data);
        this.f11361e = (ImageView) this.f11357a.findViewById(R.id.img_person_year_left);
        this.f11362f = (ImageView) this.f11357a.findViewById(R.id.img_person_year_right);
        this.f11363g = (TextView) this.f11357a.findViewById(R.id.tv_year_show_person);
        this.f11372p = LayoutInflater.from(this.f11358b).inflate(R.layout.empty_layout_person, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: b */
    private void m10380b() {
        m10385d();
        ((TextView) this.f11372p.findViewById(R.id.tv_no_history)).setText(R.string.no_person_best_data);
        this.f11365i.addView(this.f11372p);
        this.f11379w = new ArrayList();
        this.f11380x = new a();
        this.f11364h.setAdapter(this.f11380x);
        this.f11381y = Typeface.createFromAsset(this.f11358b.getAssets(), "fonts/arial.ttf");
        this.f11359c.setTypeface(this.f11381y);
        this.f11360d.setTypeface(this.f11381y);
    }

    /* JADX INFO: renamed from: c */
    private void m10383c() {
        this.f11364h.setOnPageChangeListener(this.f11382z);
        this.f11361e.setOnClickListener(this);
        this.f11362f.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: d */
    private void m10385d() {
        this.f11373q = new b(this.f11366j, "km/h", C1914mm.m10557b(R.string.front_hand_speed));
        this.f11374r = new b(this.f11367k, "km/h", C1914mm.m10557b(R.string.back_hand_speed));
        this.f11375s = new b(this.f11368l, "km/h", C1914mm.m10557b(R.string.person_send_ball_speed));
        this.f11376t = new b(this.f11369m, C1914mm.m10557b(R.string.score_unit), C1914mm.m10557b(R.string.moto_score));
        this.f11377u = new b(this.f11370n, this.f11358b.getString(R.string.active_time_unit), C1914mm.m10557b(R.string.person_data_active_time));
        this.f11378v = new b(this.f11371o, this.f11358b.getString(R.string.sport_times_unit), C1914mm.m10557b(R.string.sport_times));
    }

    /* JADX INFO: renamed from: a */
    public void m10387a(MyDataBean myDataBean) {
        this.f11359c.setText(myDataBean.errDesc.TotalDuration);
        this.f11360d.setText(myDataBean.errDesc.TotalCount);
        m10377a(myDataBean.errDesc.YearMonthList);
        m10381b(myDataBean.errDesc.BestList);
        this.f11373q.f11386a.setText(myDataBean.errDesc.AvgList.ForceSpeed);
        this.f11374r.f11386a.setText(myDataBean.errDesc.AvgList.BackSpeed);
        this.f11375s.f11386a.setText(myDataBean.errDesc.AvgList.ServeSpeed);
        this.f11376t.f11386a.setText(myDataBean.errDesc.AvgList.Score);
        this.f11377u.f11386a.setText(myDataBean.errDesc.AvgList.Duration);
        if (myDataBean.errDesc.AvgList.WeekSport == null || myDataBean.errDesc.AvgList.WeekSport.isEmpty()) {
            this.f11378v.f11386a.setText("0");
        } else {
            this.f11378v.f11386a.setText(myDataBean.errDesc.AvgList.WeekSport);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10377a(HashMap<String, HashMap<String, String>> map) {
        this.f11379w.clear();
        ArrayList<Map.Entry> arrayList = new ArrayList(map.entrySet());
        Collections.sort(arrayList, new Comparator<Map.Entry<String, HashMap<String, String>>>() { // from class: lo.2
            @Override // java.util.Comparator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(Map.Entry<String, HashMap<String, String>> entry, Map.Entry<String, HashMap<String, String>> entry2) {
                return Integer.parseInt(entry.getKey()) - Integer.parseInt(entry2.getKey());
            }
        });
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : arrayList) {
            linkedHashMap.put(entry.getKey(), entry.getValue());
        }
        Iterator it = linkedHashMap.keySet().iterator();
        boolean zIsEmpty = map.isEmpty();
        int i = 13;
        int i2 = 12;
        int i3 = R.id.bar_chart_person;
        if (zIsEmpty) {
            String strValueOf = String.valueOf(Calendar.getInstance().get(1));
            View viewInflate = LayoutInflater.from(this.f11358b).inflate(R.layout.layout_person_data_chart, (ViewGroup) null);
            PersonYearBarChartView personYearBarChartView = (PersonYearBarChartView) viewInflate.findViewById(R.id.bar_chart_person);
            int[] iArr = new int[12];
            for (int i4 = 1; i4 < 13; i4++) {
                iArr[i4 - 1] = 0;
            }
            personYearBarChartView.setData(iArr);
            viewInflate.setTag(strValueOf);
            this.f11363g.setText(String.format(this.f11358b.getString(R.string.person_year_data), strValueOf));
            this.f11379w.add(viewInflate);
        } else {
            while (it.hasNext()) {
                String str = (String) it.next();
                View viewInflate2 = LayoutInflater.from(this.f11358b).inflate(R.layout.layout_person_data_chart, (ViewGroup) null);
                PersonYearBarChartView personYearBarChartView2 = (PersonYearBarChartView) viewInflate2.findViewById(i3);
                int[] iArr2 = new int[i2];
                int i5 = 1;
                while (i5 < i) {
                    String str2 = i5 < 10 ? (String) ((HashMap) linkedHashMap.get(str)).get(String.format("0%d", Integer.valueOf(i5))) : (String) ((HashMap) linkedHashMap.get(str)).get(String.valueOf(i5));
                    if (m10378a(str2)) {
                        iArr2[i5 - 1] = Integer.parseInt(str2);
                    } else {
                        iArr2[i5 - 1] = 0;
                    }
                    i5++;
                    i = 13;
                }
                personYearBarChartView2.setData(iArr2);
                viewInflate2.setTag(str);
                if (!it.hasNext()) {
                    this.f11363g.setText(String.format(this.f11358b.getString(R.string.person_year_data), str));
                }
                this.f11379w.add(viewInflate2);
                i = 13;
                i2 = 12;
                i3 = R.id.bar_chart_person;
            }
        }
        this.f11380x.notifyDataSetChanged();
        this.f11364h.setCurrentItem(this.f11379w.size() - 1);
    }

    /* JADX INFO: renamed from: b */
    private void m10381b(HashMap<String, List<MyDataBean.ErrorBean.BestBean>> map) {
        this.f11365i.removeAllViews();
        if (map.isEmpty()) {
            this.f11365i.addView(this.f11372p);
            return;
        }
        Object[] array = map.keySet().toArray();
        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            String str = (String) array[i];
            List<MyDataBean.ErrorBean.BestBean> list = map.get(str);
            View viewInflate = LayoutInflater.from(this.f11358b).inflate(R.layout.layout_person_best_data, (ViewGroup) null);
            TextView textView = (TextView) viewInflate.findViewById(R.id.tv_date_best_person);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_best_data);
            textView.setTypeface(this.f11381y);
            textView.setText(str);
            if (i == 0) {
                viewInflate.findViewById(R.id.top_line).setVisibility(4);
            }
            if (i == array.length - 1) {
                viewInflate.findViewById(R.id.bottom_line).setVisibility(8);
                viewInflate.findViewById(R.id.bottom_graint_line).setVisibility(0);
                viewInflate.findViewById(R.id.bottom_hor_line).setVisibility(8);
            }
            for (int i2 = 0; i2 < list.size(); i2++) {
                View viewInflate2 = LayoutInflater.from(this.f11358b).inflate(R.layout.layout_person_best_data_detail, (ViewGroup) null);
                TextView textView2 = (TextView) viewInflate2.findViewById(R.id.tv_type_best_data);
                TextView textView3 = (TextView) viewInflate2.findViewById(R.id.tv_data_best);
                TextView textView4 = (TextView) viewInflate2.findViewById(R.id.tv_unit_best_data);
                if (MyApplication.m7738a().m7748h()) {
                    textView2.setTextSize(11.0f);
                }
                if (m10378a(list.get(i2).Duration)) {
                    textView2.setText(R.string.person_data_active_time);
                    textView3.setText(list.get(i2).Duration);
                    textView4.setText(R.string.sport_now_unit);
                } else if (m10378a(list.get(i2).MaxServeSpeed)) {
                    textView2.setText(R.string.serve_speed);
                    textView3.setText(list.get(i2).MaxServeSpeed);
                    textView4.setText("km/h");
                } else if (m10378a(list.get(i2).TotalCount)) {
                    textView2.setText(R.string.bat_times);
                    textView3.setText(list.get(i2).TotalCount);
                    textView4.setText(R.string.person_shot_unit);
                } else if (m10378a(list.get(i2).TotalScore)) {
                    textView2.setText(R.string.moto_score);
                    textView3.setText(list.get(i2).TotalScore);
                    textView4.setText(R.string.score_unit);
                }
                linearLayout.addView(viewInflate2);
            }
            this.f11365i.addView(viewInflate);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.img_person_year_left /* 2131296661 */:
                if (this.f11364h.getCurrentItem() != 0) {
                    this.f11364h.setCurrentItem(this.f11364h.getCurrentItem() - 1);
                }
                break;
            case R.id.img_person_year_right /* 2131296662 */:
                if (this.f11364h.getCurrentItem() != this.f11379w.size() - 1) {
                    this.f11364h.setCurrentItem(this.f11364h.getCurrentItem() + 1);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: lo$a */
    /* JADX INFO: compiled from: PersonDataManager.java */
    class a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return ViewOnClickListenerC1885lo.this.f11379w.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) ViewOnClickListenerC1885lo.this.f11379w.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) ViewOnClickListenerC1885lo.this.f11379w.get(i));
            return ViewOnClickListenerC1885lo.this.f11379w.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m10378a(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: lo$b */
    /* JADX INFO: compiled from: PersonDataManager.java */
    class b {

        /* JADX INFO: renamed from: a */
        TextView f11386a;

        /* JADX INFO: renamed from: b */
        TextView f11387b;

        /* JADX INFO: renamed from: c */
        TextView f11388c;

        public b(View view, String str, String str2) {
            this.f11386a = (TextView) view.findViewById(R.id.tv_count_data);
            this.f11387b = (TextView) view.findViewById(R.id.tv_count_unit);
            this.f11388c = (TextView) view.findViewById(R.id.tv_count_desc);
            this.f11387b.setText(str);
            this.f11388c.setText(str2);
        }
    }
}
