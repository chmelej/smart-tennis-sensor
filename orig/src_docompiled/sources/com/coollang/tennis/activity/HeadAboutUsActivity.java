package com.coollang.tennis.activity;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.widget.NavigateView;
import java.util.ArrayList;
import java.util.List;
import p000.C1895ly;

/* JADX INFO: loaded from: classes.dex */
public class HeadAboutUsActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f6401a;

    /* JADX INFO: renamed from: b */
    private ViewPager f6402b;

    /* JADX INFO: renamed from: c */
    private LinearLayout f6403c;

    /* JADX INFO: renamed from: d */
    private ImageView[] f6404d;

    /* JADX INFO: renamed from: e */
    private List<View> f6405e;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.acitivty_about_us_head);
        m6936c();
        m6937d();
        m6938e();
    }

    /* JADX INFO: renamed from: c */
    private void m6936c() {
        this.f6401a = (NavigateView) findViewById(R.id.history_title);
        this.f6402b = (ViewPager) findViewById(R.id.vp_about_us);
        this.f6403c = (LinearLayout) findViewById(R.id.ll_dots_about_us);
    }

    /* JADX INFO: renamed from: d */
    private void m6937d() {
        this.f6401a.setTitle(getString(R.string.setting_about_us));
        this.f6401a.setRightButtonBackground(getResources().getColor(R.color.tranlete));
        this.f6401a.setRightButtonText(getString(R.string.history_list));
        this.f6401a.setRightButtonTextSize(17);
        this.f6401a.setRightHideBtn(true);
    }

    /* JADX INFO: renamed from: e */
    private void m6938e() {
        this.f6405e = new ArrayList();
        View viewInflate = LayoutInflater.from(this).inflate(R.layout.layout_about_us_head, (ViewGroup) null);
        C1024b c1024b = new C1024b(viewInflate);
        c1024b.f6408a.setText("官方公众号");
        c1024b.f6409b.setImageResource(R.drawable.dq_public_head);
        View viewInflate2 = LayoutInflater.from(this).inflate(R.layout.layout_about_us_head, (ViewGroup) null);
        C1024b c1024b2 = new C1024b(viewInflate2);
        c1024b2.f6408a.setText("官方微信号");
        c1024b2.f6409b.setImageResource(R.drawable.dq_wechat_head);
        this.f6405e.add(viewInflate);
        this.f6405e.add(viewInflate2);
        m6939f();
        m6934a(0);
        this.f6402b.setAdapter(new C1023a());
        this.f6402b.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: com.coollang.tennis.activity.HeadAboutUsActivity.1
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                HeadAboutUsActivity.this.m6934a(i);
            }
        });
    }

    /* JADX INFO: renamed from: f */
    private void m6939f() {
        this.f6404d = new ImageView[this.f6405e.size()];
        for (int i = 0; i < this.f6405e.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.fast_use_dot_unselect);
            imageView.setPadding(C1895ly.m10460a(this, 4.0f), 0, C1895ly.m10460a(this, 4.0f), 0);
            this.f6404d[i] = imageView;
            this.f6403c.addView(imageView);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6934a(int i) {
        for (int i2 = 0; i2 < this.f6404d.length; i2++) {
            if (i2 == i) {
                this.f6404d[i2].setImageResource(R.drawable.fast_use_dot_select);
            } else {
                this.f6404d[i2].setImageResource(R.drawable.img_dot_grey);
            }
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.HeadAboutUsActivity$a */
    class C1023a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private C1023a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return HeadAboutUsActivity.this.f6405e.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) HeadAboutUsActivity.this.f6405e.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) HeadAboutUsActivity.this.f6405e.get(i));
            return HeadAboutUsActivity.this.f6405e.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.HeadAboutUsActivity$b */
    class C1024b {

        /* JADX INFO: renamed from: a */
        TextView f6408a;

        /* JADX INFO: renamed from: b */
        ImageView f6409b;

        public C1024b(View view) {
            this.f6408a = (TextView) view.findViewById(R.id.tv_name);
            this.f6409b = (ImageView) view.findViewById(R.id.imgv_about_us);
        }
    }
}
