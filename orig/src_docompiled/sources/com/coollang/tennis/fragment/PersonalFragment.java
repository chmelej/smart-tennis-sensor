package com.coollang.tennis.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.PersonalSettingActivity;
import com.coollang.tennis.activity.SettingActivity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.PersonnalBean;
import com.coollang.tennis.beans.UserInfoBean;
import com.coollang.tennis.widget.CircleImageView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1910mi;
import p000.C1914mm;
import p000.C2068qy;
import p000.DialogC1862ks;
import p000.ada;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class PersonalFragment extends BaseFragment implements ViewPager.OnPageChangeListener, View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private DialogC1862ks f7486A;

    /* JADX INFO: renamed from: a */
    private View f7487a;

    /* JADX INFO: renamed from: b */
    private ImageButton f7488b;

    /* JADX INFO: renamed from: c */
    private TextView f7489c;

    /* JADX INFO: renamed from: d */
    private TextView f7490d;

    /* JADX INFO: renamed from: e */
    private TextView f7491e;

    /* JADX INFO: renamed from: f */
    private TextView f7492f;

    /* JADX INFO: renamed from: g */
    private TextView f7493g;

    /* JADX INFO: renamed from: h */
    private TextView f7494h;

    /* JADX INFO: renamed from: i */
    private CircleImageView f7495i;

    /* JADX INFO: renamed from: j */
    private ImageView f7496j;

    /* JADX INFO: renamed from: k */
    private TextView f7497k;

    /* JADX INFO: renamed from: l */
    private TextView f7498l;

    /* JADX INFO: renamed from: m */
    private ViewPager f7499m;

    /* JADX INFO: renamed from: n */
    private ImageView f7500n;

    /* JADX INFO: renamed from: o */
    private ImageView f7501o;

    /* JADX INFO: renamed from: p */
    private ImageView f7502p;

    /* JADX INFO: renamed from: q */
    private C1874ld f7503q;

    /* JADX INFO: renamed from: r */
    private PersonnalBean f7504r;

    /* JADX INFO: renamed from: t */
    private HashMap<Integer, Boolean> f7506t;

    /* JADX INFO: renamed from: y */
    private C1224a f7511y;

    /* JADX INFO: renamed from: z */
    private ArrayList<Integer> f7512z;

    /* JADX INFO: renamed from: s */
    private String f7505s = "";

    /* JADX INFO: renamed from: u */
    private List<Integer> f7507u = new ArrayList();

    /* JADX INFO: renamed from: v */
    private List<Integer> f7508v = new ArrayList();

    /* JADX INFO: renamed from: w */
    private int[] f7509w = {R.drawable.ic_model_1, R.drawable.ic_model_3, R.drawable.ic_model_2, R.drawable.ic_model_5, R.drawable.ic_model_4, R.drawable.ic_model_6, R.drawable.ic_person_medal, R.drawable.ic_person_medal, R.drawable.ic_person_medal};

    /* JADX INFO: renamed from: x */
    private int[] f7510x = {R.drawable.ic_model_select_1, R.drawable.ic_model_select_3, R.drawable.ic_model_select_2, R.drawable.ic_model_select_5, R.drawable.ic_model_select_4, R.drawable.ic_model_select_6, R.drawable.ic_model_select_7, R.drawable.ic_model_select_8, R.drawable.ic_model_select_9};

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        this.f7487a = layoutInflater.inflate(R.layout.fragment_person, (ViewGroup) null, false);
        return this.f7487a;
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        this.f7503q = new C1874ld();
        this.f7504r = new PersonnalBean();
        this.f7488b = (ImageButton) view.findViewById(R.id.fragment_person_ib_setting);
        this.f7495i = (CircleImageView) view.findViewById(R.id.item_fragment_ranking_iv_head);
        this.f7496j = (ImageView) view.findViewById(R.id.fragment_person_iv_sex);
        this.f7497k = (TextView) view.findViewById(R.id.fragment_person_tv_name);
        this.f7498l = (TextView) view.findViewById(R.id.fragment_person_tv_address);
        this.f7499m = (ViewPager) view.findViewById(R.id.fragment_person_viewpager);
        this.f7500n = (ImageView) view.findViewById(R.id.fragment_person_iv_1);
        this.f7501o = (ImageView) view.findViewById(R.id.fragment_person_iv_2);
        this.f7502p = (ImageView) view.findViewById(R.id.fragment_person_iv_3);
        m7779b();
        this.f7511y = new C1224a();
        this.f7499m.setAdapter(this.f7511y);
        this.f7499m.setOnPageChangeListener(this);
        this.f7499m.setCurrentItem(0, false);
        this.f7488b.setOnClickListener(this);
        this.f7495i.setOnClickListener(this);
        this.f7489c = (TextView) view.findViewById(R.id.fragment_person_tv_total_bat);
        this.f7490d = (TextView) view.findViewById(R.id.fragment_person_tv_total_rank);
        this.f7491e = (TextView) view.findViewById(R.id.fragment_person_tv_score);
        this.f7492f = (TextView) view.findViewById(R.id.fragment_person_tv_most_rate);
        this.f7493g = (TextView) view.findViewById(R.id.fragment_person_tv_time);
        this.f7494h = (TextView) view.findViewById(R.id.fragment_person_tv_average_time);
        Typeface typeface = MyApplication.m7738a().f7404e;
        this.f7489c.setTypeface(typeface);
        this.f7490d.setTypeface(typeface);
        this.f7491e.setTypeface(typeface);
        this.f7492f.setTypeface(typeface);
        this.f7493g.setTypeface(typeface);
        this.f7494h.setTypeface(typeface);
    }

    /* JADX INFO: renamed from: b */
    private void m7779b() {
        this.f7507u.clear();
        for (int i = 0; i < 9; i++) {
            this.f7508v.add(Integer.valueOf(i));
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        UserInfoBean userInfoBeanM7745e = MyApplication.m7738a().m7745e();
        this.f7512z = new ArrayList<>();
        this.f7506t = new HashMap<>();
        for (int i = 0; i < 9; i++) {
            this.f7506t.put(Integer.valueOf(i), false);
        }
        if (userInfoBeanM7745e != null) {
            C2068qy.m11356a().m11360a(userInfoBeanM7745e.errDesc.Icon, this.f7495i);
            this.f7505s = userInfoBeanM7745e.errDesc.Icon;
            this.f7497k.setText(userInfoBeanM7745e.errDesc.UserName);
            this.f7498l.setText(userInfoBeanM7745e.errDesc.Address);
            if ("1".equals(userInfoBeanM7745e.errDesc.Sex)) {
                this.f7496j.setImageResource(R.drawable.ic_person_male);
            } else {
                this.f7496j.setImageResource(R.drawable.ic_person_female);
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
            return;
        }
        int id = view.getId();
        if (id == R.id.fragment_person_ib_setting) {
            startActivity(new Intent(getActivity(), (Class<?>) SettingActivity.class));
            getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
        } else {
            if (id != R.id.item_fragment_ranking_iv_head) {
                return;
            }
            PersonalSettingActivity.m7032a(getActivity());
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.fragment.PersonalFragment$a */
    class C1224a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 3;
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        C1224a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View viewM10555a = C1914mm.m10555a(R.layout.item_person);
            ImageView[] imageViewArr = {(ImageView) viewM10555a.findViewById(R.id.item_person_iv_model_1), (ImageView) viewM10555a.findViewById(R.id.item_person_iv_model_2), (ImageView) viewM10555a.findViewById(R.id.item_person_iv_model_3)};
            int iMin = Math.min(PersonalFragment.this.f7507u.size(), 3);
            int iMax = Math.max(Math.min(PersonalFragment.this.f7507u.size(), 6), 3);
            int iMax2 = Math.max(PersonalFragment.this.f7507u.size(), 6);
            if (i == 0) {
                for (int i2 = 0; i2 < iMin; i2++) {
                    PersonalFragment.this.m7775a(imageViewArr[i2], ((Integer) PersonalFragment.this.f7507u.get(i2)).intValue(), true);
                }
                for (int i3 = 0; i3 < 3 - iMin; i3++) {
                    PersonalFragment.this.m7775a(imageViewArr[i3 + iMin], ((Integer) PersonalFragment.this.f7508v.get(i3)).intValue(), false);
                }
            } else if (i == 1) {
                for (int i4 = 0; i4 < iMax - 3; i4++) {
                    PersonalFragment.this.m7775a(imageViewArr[i4], ((Integer) PersonalFragment.this.f7507u.get(i4 + 3)).intValue(), true);
                }
                for (int i5 = 0; i5 < 6 - iMax; i5++) {
                    PersonalFragment.this.m7775a(imageViewArr[(i5 + iMax) - 3], ((Integer) PersonalFragment.this.f7508v.get((i5 + 3) - iMin)).intValue(), false);
                }
            } else {
                for (int i6 = 0; i6 < iMax2 - 6; i6++) {
                    PersonalFragment.this.m7775a(imageViewArr[i6], ((Integer) PersonalFragment.this.f7507u.get(i6 + 6)).intValue(), true);
                }
                for (int i7 = 0; i7 < 9 - iMax2; i7++) {
                    PersonalFragment.this.m7775a(imageViewArr[(i7 + iMax2) - 6], ((Integer) PersonalFragment.this.f7508v.get((((i7 + 6) - iMax) + 3) - iMin)).intValue(), false);
                }
            }
            viewGroup.addView(viewM10555a);
            return viewM10555a;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i == 0) {
            this.f7500n.setImageResource(R.drawable.shap_person_circle_select);
            this.f7501o.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7502p.setImageResource(R.drawable.shap_person_circle_nor);
        } else if (i == 1) {
            this.f7500n.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7501o.setImageResource(R.drawable.shap_person_circle_select);
            this.f7502p.setImageResource(R.drawable.shap_person_circle_nor);
        } else if (i == 2) {
            this.f7500n.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7501o.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7502p.setImageResource(R.drawable.shap_person_circle_select);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7775a(ImageView imageView, final int i, boolean z) {
        if (z) {
            imageView.setImageResource(this.f7510x[i]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.PersonalFragment.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonalFragment.this.m7774a(i);
                }
            });
        } else {
            imageView.setImageResource(this.f7509w[i]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.PersonalFragment.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        C1900mc.m10474b("PersonalFragment", "onResume == ");
        super.onResume();
        akd.m1706a().m1719a(this);
        ada.m302b(getActivity());
        this.f7503q.m10209c(C1902me.m10487b(getActivity(), "UserID", "-1"));
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
        ada.m301a(getActivity());
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0030. Please report as an issue. */
    public void onEventMainThread(C1873lc c1873lc) {
        Gson gson = new Gson();
        if (c1873lc.f11072i == 13) {
            switch (c1873lc.f11065b) {
                case 1:
                    C1900mc.m10473a("服务器返回的用户信息event.msg=", c1873lc.f11064a);
                    this.f7504r = (PersonnalBean) gson.fromJson(c1873lc.f11064a, PersonnalBean.class);
                    m7781c();
                    break;
            }
            return;
        }
        if (c1873lc.f11072i == 24) {
            switch (c1873lc.f11065b) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private void m7781c() {
        String str = this.f7504r.errDesc.TotalCount;
        String str2 = str + C1914mm.m10557b(R.string.times);
        if (!MyApplication.m7738a().m7747g()) {
            str2 = str;
        }
        this.f7489c.setText(C1910mi.m10524a(str, str2, 20, Color.parseColor("#ff8560")));
        String str3 = this.f7504r.errDesc.Rank;
        this.f7490d.setText(C1910mi.m10524a(str3, str3 + C1914mm.m10557b(R.string.rank_unit), 20, Color.parseColor("#ff8560")));
        String str4 = this.f7504r.errDesc.MaxScore + " ";
        this.f7491e.setText(C1910mi.m10524a(str4, str4 + C1914mm.m10557b(R.string.score_unit), 18, Color.parseColor("#ff8560")));
        String str5 = this.f7504r.errDesc.MaxSpeed + " ";
        this.f7492f.setText(C1910mi.m10524a(str5, str5 + "km/h", 18, Color.parseColor("#ff8560")));
        String str6 = this.f7504r.errDesc.AvgWeekSport + " ";
        this.f7493g.setText(C1910mi.m10524a(str6, str6 + C1914mm.m10557b(R.string.times), 18, Color.parseColor("#ff8560")));
        String str7 = this.f7504r.errDesc.TotalDuration + " ";
        this.f7494h.setText(C1910mi.m10524a(str7, str7 + "h", 18, Color.parseColor("#ff8560")));
        if (!this.f7505s.equals(this.f7504r.errDesc.HeadIcon) || this.f7495i.getDrawable() == null) {
            this.f7505s = this.f7504r.errDesc.HeadIcon;
            C2068qy.m11356a().m11360a(this.f7504r.errDesc.HeadIcon, this.f7495i);
        }
        this.f7497k.setText(this.f7504r.errDesc.UserName);
        this.f7498l.setText(this.f7504r.errDesc.Address);
        if ("1".equals(this.f7504r.errDesc.Sex)) {
            this.f7496j.setImageResource(R.drawable.ic_person_male);
        } else {
            this.f7496j.setImageResource(R.drawable.ic_person_female);
        }
        m7782d();
    }

    /* JADX INFO: renamed from: d */
    private void m7782d() {
        this.f7512z.clear();
        this.f7507u.clear();
        this.f7508v.clear();
        if (this.f7504r.errDesc.Medals != null && !this.f7504r.errDesc.Medals.isEmpty()) {
            for (PersonnalBean.Medal medal : this.f7504r.errDesc.Medals) {
                this.f7506t.put(Integer.valueOf(medal.Medal), true);
                this.f7507u.add(Integer.valueOf(medal.Medal));
                if (medal.State.equals("0")) {
                    this.f7512z.add(Integer.valueOf(medal.Medal));
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!this.f7507u.contains(Integer.valueOf(i))) {
                this.f7508v.add(Integer.valueOf(i));
            }
        }
        this.f7511y.notifyDataSetChanged();
        m7784e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m7784e() {
        if (this.f7512z.isEmpty() || isHidden()) {
            return;
        }
        if (this.f7486A == null || !this.f7486A.isShowing()) {
            this.f7503q.m10213d(String.valueOf(this.f7512z.get(0)));
            this.f7486A = new DialogC1862ks(getActivity(), this.f7512z.get(0).intValue());
            this.f7486A.m10133a(new DialogInterface.OnDismissListener() { // from class: com.coollang.tennis.fragment.PersonalFragment.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    PersonalFragment.this.f7512z.remove(0);
                    PersonalFragment.this.m7784e();
                }
            });
            this.f7486A.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7774a(int i) {
        new DialogC1862ks(getActivity(), i).show();
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        C1900mc.m10474b("PersonalFragment", "hidden == " + z);
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        this.f7503q.m10209c(C1902me.m10487b(getActivity(), "UserID", "-1"));
    }
}
