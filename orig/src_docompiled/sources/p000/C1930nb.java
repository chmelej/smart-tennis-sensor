package p000;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: nb */
/* JADX INFO: compiled from: SportDetailWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1930nb {

    /* JADX INFO: renamed from: a */
    private PopupWindow f11705a;

    /* JADX INFO: renamed from: b */
    private Activity f11706b;

    /* JADX INFO: renamed from: c */
    private RelativeLayout f11707c;

    /* JADX INFO: renamed from: d */
    private ImageView f11708d;

    /* JADX INFO: renamed from: e */
    private TextView f11709e;

    /* JADX INFO: renamed from: f */
    private ViewPager f11710f;

    /* JADX INFO: renamed from: g */
    private TextView f11711g;

    /* JADX INFO: renamed from: h */
    private LinearLayout f11712h;

    /* JADX INFO: renamed from: i */
    private ImageView f11713i;

    /* JADX INFO: renamed from: j */
    private ImageView f11714j;

    /* JADX INFO: renamed from: k */
    private ImageView f11715k;

    /* JADX INFO: renamed from: l */
    private List<View> f11716l;

    /* JADX INFO: renamed from: m */
    private int f11717m;

    public C1930nb(Activity activity, int i) {
        this.f11706b = activity;
        this.f11717m = i;
        m10723c();
    }

    /* JADX INFO: renamed from: c */
    private void m10723c() {
        View viewInflate = LayoutInflater.from(this.f11706b).inflate(R.layout.layout_pop_sport_detail_window, (ViewGroup) new LinearLayout(this.f11706b), false);
        this.f11705a = new PopupWindow(viewInflate, -1, -1);
        this.f11705a.setOutsideTouchable(true);
        this.f11705a.setFocusable(true);
        this.f11705a.setBackgroundDrawable(new BitmapDrawable());
        this.f11707c = (RelativeLayout) viewInflate.findViewById(R.id.rl_root);
        this.f11708d = (ImageView) viewInflate.findViewById(R.id.img_close);
        this.f11709e = (TextView) viewInflate.findViewById(R.id.tv_title_sport_detail_pop);
        this.f11710f = (ViewPager) viewInflate.findViewById(R.id.vp_sport_detail_content);
        this.f11711g = (TextView) viewInflate.findViewById(R.id.tv_content_sport_detail);
        this.f11712h = (LinearLayout) viewInflate.findViewById(R.id.ll_bottom_dots);
        this.f11713i = (ImageView) viewInflate.findViewById(R.id.dot_01);
        this.f11714j = (ImageView) viewInflate.findViewById(R.id.dot_02);
        this.f11715k = (ImageView) viewInflate.findViewById(R.id.dot_03);
        viewInflate.setOnClickListener(new View.OnClickListener() { // from class: nb.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1930nb.this.m10727b();
            }
        });
        this.f11707c.setOnClickListener(new View.OnClickListener() { // from class: nb.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.f11708d.setOnClickListener(new View.OnClickListener() { // from class: nb.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1930nb.this.f11705a.isShowing()) {
                    C1930nb.this.f11705a.dismiss();
                }
            }
        });
        m10724d();
    }

    /* JADX INFO: renamed from: d */
    private void m10724d() {
        if (this.f11717m < 3) {
            m10721b(0);
            m10718a(0);
            this.f11710f.setVisibility(0);
            this.f11712h.setVisibility(0);
            this.f11711g.setVisibility(8);
            this.f11716l = new ArrayList();
            m10725e();
            this.f11710f.setCurrentItem(this.f11717m);
            return;
        }
        this.f11710f.setVisibility(8);
        this.f11712h.setVisibility(8);
        this.f11711g.setVisibility(0);
        if (this.f11717m == 3) {
            this.f11709e.setText(R.string.speed_line);
            this.f11711g.setText(R.string.sport_line_desc);
        } else if (this.f11717m == 4) {
            this.f11709e.setText(R.string.hand_proportion);
            this.f11711g.setText(R.string.hand_type_desc);
        } else if (this.f11717m == 5) {
            this.f11709e.setText(R.string.hit_speed);
            this.f11711g.setText(R.string.send_ball_speed);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m10725e() {
        int i = 0;
        String[] strArr = {this.f11706b.getString(R.string.power_desc), this.f11706b.getString(R.string.keep_desc), this.f11706b.getString(R.string.deep_desc)};
        while (true) {
            if (i < 3) {
                View viewInflate = LayoutInflater.from(this.f11706b).inflate(R.layout.layout_sport_detail_window_text, (ViewGroup) null);
                ((TextView) viewInflate.findViewById(R.id.tv_content)).setText(strArr[i]);
                this.f11716l.add(viewInflate);
                i++;
            } else {
                this.f11710f.setAdapter(new a());
                this.f11710f.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: nb.4
                    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                    public void onPageScrollStateChanged(int i2) {
                    }

                    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                    public void onPageScrolled(int i2, float f, int i3) {
                    }

                    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
                    public void onPageSelected(int i2) {
                        C1930nb.this.m10721b(i2);
                        C1930nb.this.m10718a(i2);
                    }
                });
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10726a() {
        if (this.f11705a.isShowing()) {
            this.f11705a.dismiss();
        }
        this.f11705a.showAtLocation(this.f11706b.getWindow().getDecorView(), 17, 0, 0);
        this.f11707c.startAnimation(AnimationUtils.loadAnimation(this.f11706b, R.anim.show_window_anim));
    }

    /* JADX INFO: renamed from: b */
    public void m10727b() {
        if (this.f11705a.isShowing()) {
            this.f11705a.dismiss();
        }
    }

    /* JADX INFO: renamed from: nb$a */
    /* JADX INFO: compiled from: SportDetailWindow.java */
    class a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return C1930nb.this.f11716l.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) C1930nb.this.f11716l.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) C1930nb.this.f11716l.get(i));
            return C1930nb.this.f11716l.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10718a(int i) {
        switch (i) {
            case 0:
                this.f11709e.setText(C1914mm.m10557b(R.string.sport_resport_15));
                break;
            case 1:
                this.f11709e.setText(C1914mm.m10557b(R.string.sport_resport_10));
                break;
            case 2:
                this.f11709e.setText(C1914mm.m10557b(R.string.sport_resport_11));
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10721b(int i) {
        this.f11713i.setSelected(false);
        this.f11714j.setSelected(false);
        this.f11715k.setSelected(false);
        switch (i) {
            case 0:
                this.f11713i.setSelected(true);
                break;
            case 1:
                this.f11714j.setSelected(true);
                break;
            case 2:
                this.f11715k.setSelected(true);
                break;
        }
    }
}
