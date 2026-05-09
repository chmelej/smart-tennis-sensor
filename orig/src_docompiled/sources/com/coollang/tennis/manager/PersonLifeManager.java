package com.coollang.tennis.manager;

import android.app.Activity;
import android.content.DialogInterface;
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
import com.coollang.tennis.beans.MyCareerListBean;
import com.coollang.tennis.beans.MyDataBean;
import com.coollang.tennis.beans.PersonCareerYearBean;
import com.coollang.tennis.beans.SettingHistoryItemBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import p000.C1914mm;
import p000.DialogC1862ks;

/* JADX INFO: loaded from: classes.dex */
public class PersonLifeManager implements ViewPager.OnPageChangeListener, View.OnClickListener {

    /* JADX INFO: renamed from: b */
    private Activity f7906b;

    /* JADX INFO: renamed from: c */
    private View f7907c;

    /* JADX INFO: renamed from: d */
    private ViewPager f7908d;

    /* JADX INFO: renamed from: e */
    private LinearLayout f7909e;

    /* JADX INFO: renamed from: f */
    private ImageView f7910f;

    /* JADX INFO: renamed from: g */
    private ImageView f7911g;

    /* JADX INFO: renamed from: h */
    private ImageView f7912h;

    /* JADX INFO: renamed from: i */
    private View f7913i;

    /* JADX INFO: renamed from: j */
    private C1304b f7914j;

    /* JADX INFO: renamed from: k */
    private DialogC1862ks f7915k;

    /* JADX INFO: renamed from: p */
    private Typeface f7920p;

    /* JADX INFO: renamed from: r */
    private InterfaceC1303a f7922r;

    /* JADX INFO: renamed from: m */
    private List<Integer> f7917m = new ArrayList();

    /* JADX INFO: renamed from: n */
    private List<Integer> f7918n = new ArrayList();

    /* JADX INFO: renamed from: q */
    private boolean f7921q = true;

    /* JADX INFO: renamed from: s */
    private int[] f7923s = {R.drawable.ic_model_1, R.drawable.ic_model_3, R.drawable.ic_model_2, R.drawable.ic_model_5, R.drawable.ic_model_4, R.drawable.ic_model_6, R.drawable.ic_person_medal, R.drawable.ic_person_medal, R.drawable.ic_person_medal};

    /* JADX INFO: renamed from: t */
    private int[] f7924t = {R.drawable.ic_model_select_1, R.drawable.ic_model_select_3, R.drawable.ic_model_select_2, R.drawable.ic_model_select_5, R.drawable.ic_model_select_4, R.drawable.ic_model_select_6, R.drawable.ic_model_select_7, R.drawable.ic_model_select_8, R.drawable.ic_model_select_9};

    /* JADX INFO: renamed from: a */
    Comparator f7905a = new Comparator<SettingHistoryItemBean>() { // from class: com.coollang.tennis.manager.PersonLifeManager.4
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(SettingHistoryItemBean settingHistoryItemBean, SettingHistoryItemBean settingHistoryItemBean2) {
            return settingHistoryItemBean.Year.compareTo(settingHistoryItemBean2.Year);
        }
    };

    /* JADX INFO: renamed from: l */
    private ArrayList<Integer> f7916l = new ArrayList<>();

    /* JADX INFO: renamed from: o */
    private HashMap<Integer, Boolean> f7919o = new HashMap<>();

    /* JADX INFO: renamed from: com.coollang.tennis.manager.PersonLifeManager$a */
    public interface InterfaceC1303a {
        /* JADX INFO: renamed from: a */
        void mo7828a(int i);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    public PersonLifeManager(Activity activity, View view, InterfaceC1303a interfaceC1303a) {
        this.f7906b = activity;
        this.f7907c = view;
        this.f7922r = interfaceC1303a;
        m7998a();
        m8004b();
    }

    /* JADX INFO: renamed from: a */
    private void m7998a() {
        this.f7908d = (ViewPager) this.f7907c.findViewById(R.id.fragment_person_viewpager);
        this.f7909e = (LinearLayout) this.f7907c.findViewById(R.id.ll_life_history);
        this.f7910f = (ImageView) this.f7907c.findViewById(R.id.fragment_person_iv_1);
        this.f7911g = (ImageView) this.f7907c.findViewById(R.id.fragment_person_iv_2);
        this.f7912h = (ImageView) this.f7907c.findViewById(R.id.fragment_person_iv_3);
        this.f7913i = LayoutInflater.from(this.f7906b).inflate(R.layout.empty_layout_person, (ViewGroup) null);
    }

    /* JADX INFO: renamed from: b */
    private void m8004b() {
        m8007d();
        m8006c();
        this.f7909e.addView(this.f7913i);
        this.f7920p = Typeface.createFromAsset(this.f7906b.getAssets(), "fonts/arial.ttf");
    }

    /* JADX INFO: renamed from: c */
    private void m8006c() {
        this.f7914j = new C1304b();
        this.f7908d.setAdapter(this.f7914j);
        this.f7908d.setOnPageChangeListener(this);
        this.f7908d.setCurrentItem(0, false);
    }

    /* JADX INFO: renamed from: d */
    private void m8007d() {
        this.f7917m.clear();
        for (int i = 0; i < 9; i++) {
            this.f7918n.add(Integer.valueOf(i));
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8011a(List<MyDataBean.ErrorBean.Medal> list) {
        this.f7916l.clear();
        this.f7917m.clear();
        this.f7918n.clear();
        if (list != null && !list.isEmpty()) {
            for (MyDataBean.ErrorBean.Medal medal : list) {
                this.f7919o.put(Integer.valueOf(medal.Medal), true);
                this.f7917m.add(Integer.valueOf(medal.Medal));
                if (medal.State.equals("0")) {
                    this.f7916l.add(Integer.valueOf(medal.Medal));
                }
            }
        }
        for (int i = 0; i < 9; i++) {
            if (!this.f7917m.contains(Integer.valueOf(i))) {
                this.f7918n.add(Integer.valueOf(i));
            }
        }
        this.f7914j.notifyDataSetChanged();
        m8009e();
    }

    /* JADX INFO: renamed from: a */
    public void m8010a(MyCareerListBean myCareerListBean) {
        List<SettingHistoryItemBean> list = myCareerListBean.errDesc;
        this.f7909e.removeAllViews();
        if (list != null && !list.isEmpty()) {
            Collections.sort(list, this.f7905a);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                if (i == 0 || !list.get(i).Year.equals(list.get(i - 1).Year)) {
                    PersonCareerYearBean personCareerYearBean = new PersonCareerYearBean();
                    personCareerYearBean.Year = list.get(i).Year;
                    personCareerYearBean.contents = new ArrayList();
                    personCareerYearBean.contents.add(list.get(i).Career);
                    arrayList.add(personCareerYearBean);
                } else {
                    ((PersonCareerYearBean) arrayList.get(arrayList.size() - 1)).contents.add(list.get(i).Career);
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                View viewInflate = LayoutInflater.from(this.f7906b).inflate(R.layout.layout_person_history_item, (ViewGroup) null);
                TextView textView = (TextView) viewInflate.findViewById(R.id.tv_date_best_person);
                View viewFindViewById = viewInflate.findViewById(R.id.top_line);
                View viewFindViewById2 = viewInflate.findViewById(R.id.bottom_line);
                View viewFindViewById3 = viewInflate.findViewById(R.id.bottom_graint_line);
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.ll_person_history_item);
                textView.setTypeface(this.f7920p);
                textView.setText(((PersonCareerYearBean) arrayList.get(i2)).Year);
                if (i2 == 0) {
                    viewFindViewById.setVisibility(4);
                }
                if (i2 == arrayList.size() - 1) {
                    viewFindViewById2.setVisibility(8);
                    viewFindViewById3.setVisibility(0);
                }
                List<String> list2 = ((PersonCareerYearBean) arrayList.get(i2)).contents;
                for (int i3 = 0; i3 < list2.size(); i3++) {
                    View viewInflate2 = LayoutInflater.from(this.f7906b).inflate(R.layout.layout_person_history_content_item, (ViewGroup) null);
                    ((TextView) viewInflate2.findViewById(R.id.tv_content_person_history)).setText(list2.get(i3));
                    linearLayout.addView(viewInflate2);
                }
                this.f7909e.addView(viewInflate);
            }
            return;
        }
        this.f7909e.addView(this.f7913i);
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        if (i == 0) {
            this.f7910f.setImageResource(R.drawable.shap_person_circle_select);
            this.f7911g.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7912h.setImageResource(R.drawable.shap_person_circle_nor);
        } else if (i == 1) {
            this.f7910f.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7911g.setImageResource(R.drawable.shap_person_circle_select);
            this.f7912h.setImageResource(R.drawable.shap_person_circle_nor);
        } else if (i == 2) {
            this.f7910f.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7911g.setImageResource(R.drawable.shap_person_circle_nor);
            this.f7912h.setImageResource(R.drawable.shap_person_circle_select);
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.manager.PersonLifeManager$b */
    class C1304b extends PagerAdapter {
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

        C1304b() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            View viewM10555a = C1914mm.m10555a(R.layout.item_person);
            ImageView[] imageViewArr = {(ImageView) viewM10555a.findViewById(R.id.item_person_iv_model_1), (ImageView) viewM10555a.findViewById(R.id.item_person_iv_model_2), (ImageView) viewM10555a.findViewById(R.id.item_person_iv_model_3)};
            int iMin = Math.min(PersonLifeManager.this.f7917m.size(), 3);
            int iMax = Math.max(Math.min(PersonLifeManager.this.f7917m.size(), 6), 3);
            int iMax2 = Math.max(PersonLifeManager.this.f7917m.size(), 6);
            if (i == 0) {
                for (int i2 = 0; i2 < iMin; i2++) {
                    PersonLifeManager.this.m8000a(imageViewArr[i2], ((Integer) PersonLifeManager.this.f7917m.get(i2)).intValue(), true);
                }
                for (int i3 = 0; i3 < 3 - iMin; i3++) {
                    PersonLifeManager.this.m8000a(imageViewArr[i3 + iMin], ((Integer) PersonLifeManager.this.f7918n.get(i3)).intValue(), false);
                }
            } else if (i == 1) {
                for (int i4 = 0; i4 < iMax - 3; i4++) {
                    PersonLifeManager.this.m8000a(imageViewArr[i4], ((Integer) PersonLifeManager.this.f7917m.get(i4 + 3)).intValue(), true);
                }
                for (int i5 = 0; i5 < 6 - iMax; i5++) {
                    PersonLifeManager.this.m8000a(imageViewArr[(i5 + iMax) - 3], ((Integer) PersonLifeManager.this.f7918n.get((i5 + 3) - iMin)).intValue(), false);
                }
            } else {
                for (int i6 = 0; i6 < iMax2 - 6; i6++) {
                    PersonLifeManager.this.m8000a(imageViewArr[i6], ((Integer) PersonLifeManager.this.f7917m.get(i6 + 6)).intValue(), true);
                }
                for (int i7 = 0; i7 < 9 - iMax2; i7++) {
                    PersonLifeManager.this.m8000a(imageViewArr[(i7 + iMax2) - 6], ((Integer) PersonLifeManager.this.f7918n.get((((i7 + 6) - iMax) + 3) - iMin)).intValue(), false);
                }
            }
            viewGroup.addView(viewM10555a);
            return viewM10555a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8000a(ImageView imageView, final int i, boolean z) {
        if (z) {
            imageView.setImageResource(this.f7924t[i]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.manager.PersonLifeManager.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    PersonLifeManager.this.m7999a(i);
                }
            });
        } else {
            imageView.setImageResource(this.f7923s[i]);
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.manager.PersonLifeManager.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m8009e() {
        if (this.f7916l.isEmpty() || this.f7921q) {
            return;
        }
        if (this.f7915k == null || !this.f7915k.isShowing()) {
            if (this.f7922r != null) {
                this.f7922r.mo7828a(this.f7916l.get(0).intValue());
            }
            this.f7915k = new DialogC1862ks(this.f7906b, this.f7916l.get(0).intValue());
            this.f7915k.m10133a(new DialogInterface.OnDismissListener() { // from class: com.coollang.tennis.manager.PersonLifeManager.3
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    PersonLifeManager.this.f7916l.remove(0);
                    PersonLifeManager.this.m8009e();
                }
            });
            this.f7915k.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7999a(int i) {
        new DialogC1862ks(this.f7906b, i).show();
    }
}
