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
import android.widget.TextView;
import com.coollang.tennis.R;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ms */
/* JADX INFO: compiled from: FastUsePopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1920ms {

    /* JADX INFO: renamed from: a */
    public PopupWindow f11551a;

    /* JADX INFO: renamed from: b */
    public Activity f11552b;

    /* JADX INFO: renamed from: c */
    private ViewPager f11553c;

    /* JADX INFO: renamed from: d */
    private LinearLayout f11554d;

    /* JADX INFO: renamed from: e */
    private ImageView f11555e;

    /* JADX INFO: renamed from: f */
    private View f11556f;

    /* JADX INFO: renamed from: g */
    private View f11557g;

    /* JADX INFO: renamed from: h */
    private View f11558h;

    /* JADX INFO: renamed from: i */
    private View f11559i;

    /* JADX INFO: renamed from: j */
    private View f11560j;

    /* JADX INFO: renamed from: k */
    private View f11561k;

    /* JADX INFO: renamed from: l */
    private View f11562l;

    /* JADX INFO: renamed from: m */
    private View f11563m;

    /* JADX INFO: renamed from: n */
    private View f11564n;

    /* JADX INFO: renamed from: o */
    private View f11565o;

    /* JADX INFO: renamed from: p */
    private ImageView[] f11566p;

    /* JADX INFO: renamed from: q */
    private List<View> f11567q;

    public C1920ms(Activity activity) {
        this.f11552b = activity;
        m10600b();
    }

    /* JADX INFO: renamed from: b */
    private void m10600b() {
        View viewInflate = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_fast_use, (ViewGroup) null);
        this.f11553c = (ViewPager) viewInflate.findViewById(R.id.vp_fast_use);
        this.f11554d = (LinearLayout) viewInflate.findViewById(R.id.ll_dots_fast_use);
        this.f11555e = (ImageView) viewInflate.findViewById(R.id.img_close);
        this.f11551a = new PopupWindow(viewInflate, -1, -1);
        this.f11551a.setFocusable(true);
        this.f11551a.setBackgroundDrawable(new BitmapDrawable());
        this.f11551a.setTouchable(true);
        this.f11567q = new ArrayList();
        this.f11555e.setOnClickListener(new View.OnClickListener() { // from class: ms.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1920ms.this.f11551a.isShowing()) {
                    C1920ms.this.f11551a.dismiss();
                }
            }
        });
        m10602c();
    }

    /* JADX INFO: renamed from: c */
    private void m10602c() {
        this.f11556f = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_fast_install, (ViewGroup) null);
        this.f11557g = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        this.f11558h = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_connect, (ViewGroup) null);
        this.f11559i = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar = new b(this.f11559i);
        bVar.f11571a.setImageResource(R.drawable.fast_use_use);
        bVar.f11572b.setText(C1914mm.m10557b(R.string.use_fast_use));
        bVar.f11573c.setText(R.string.use_desc);
        bVar.f11574d.setVisibility(8);
        this.f11560j = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar2 = new b(this.f11560j);
        bVar2.f11571a.setImageResource(R.drawable.fast_use_close);
        bVar2.f11572b.setText(R.string.power_off);
        bVar2.f11573c.setText(R.string.power_off_desc);
        bVar2.f11574d.setVisibility(8);
        this.f11561k = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar3 = new b(this.f11561k);
        bVar3.f11571a.setImageResource(R.drawable.fast_use_check);
        bVar3.f11572b.setText(R.string.view_data);
        bVar3.f11573c.setText(R.string.view_data_desc);
        bVar3.f11574d.setVisibility(8);
        this.f11562l = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar4 = new b(this.f11562l);
        bVar4.f11571a.setImageResource(R.drawable.fast_use_update);
        bVar4.f11572b.setText(R.string.update_device);
        bVar4.f11573c.setText(R.string.update_desc);
        bVar4.f11574d.setText(R.string.update_note);
        this.f11563m = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_use_reset, (ViewGroup) null);
        this.f11564n = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_status_usual, (ViewGroup) null);
        this.f11565o = LayoutInflater.from(this.f11552b).inflate(R.layout.layout_pop_status_other, (ViewGroup) null);
        this.f11567q.add(this.f11556f);
        this.f11567q.add(this.f11557g);
        this.f11567q.add(this.f11558h);
        this.f11567q.add(this.f11559i);
        this.f11567q.add(this.f11560j);
        this.f11567q.add(this.f11561k);
        this.f11567q.add(this.f11562l);
        this.f11567q.add(this.f11563m);
        this.f11567q.add(this.f11564n);
        this.f11567q.add(this.f11565o);
        m10604e();
        m10603d();
    }

    /* JADX INFO: renamed from: d */
    private void m10603d() {
        this.f11553c.setAdapter(new a());
        this.f11553c.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: ms.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                C1920ms.this.m10601b(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10601b(int i) {
        for (int i2 = 0; i2 < this.f11566p.length; i2++) {
            if (i2 == i) {
                this.f11566p[i2].setImageResource(R.drawable.fast_use_dot_select);
            } else {
                this.f11566p[i2].setImageResource(R.drawable.fast_use_dot_unselect);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m10604e() {
        this.f11566p = new ImageView[this.f11567q.size()];
        for (int i = 0; i < this.f11567q.size(); i++) {
            ImageView imageView = new ImageView(this.f11552b);
            imageView.setImageResource(R.drawable.fast_use_dot_unselect);
            imageView.setPadding(C1895ly.m10460a(this.f11552b, 4.0f), 0, C1895ly.m10460a(this.f11552b, 4.0f), 0);
            this.f11566p[i] = imageView;
            this.f11554d.addView(imageView);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10606a(int i) {
        if (i < this.f11567q.size()) {
            this.f11553c.setCurrentItem(i);
            m10601b(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10605a() {
        if (this.f11551a.isShowing()) {
            this.f11551a.dismiss();
        }
        this.f11551a.showAtLocation(this.f11552b.getWindow().getDecorView(), 17, 0, 0);
        this.f11553c.startAnimation(AnimationUtils.loadAnimation(this.f11552b, R.anim.show_window_anim));
    }

    /* JADX INFO: renamed from: ms$b */
    /* JADX INFO: compiled from: FastUsePopWindow.java */
    class b {

        /* JADX INFO: renamed from: a */
        ImageView f11571a;

        /* JADX INFO: renamed from: b */
        TextView f11572b;

        /* JADX INFO: renamed from: c */
        TextView f11573c;

        /* JADX INFO: renamed from: d */
        TextView f11574d;

        public b(View view) {
            this.f11571a = (ImageView) view.findViewById(R.id.img_content_fast_use);
            this.f11572b = (TextView) view.findViewById(R.id.tv_title_fast_use_desc);
            this.f11573c = (TextView) view.findViewById(R.id.tv_content_fast_use_desc);
            this.f11574d = (TextView) view.findViewById(R.id.tv_note_fast_use);
        }
    }

    /* JADX INFO: renamed from: ms$a */
    /* JADX INFO: compiled from: FastUsePopWindow.java */
    class a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return C1920ms.this.f11567q.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) C1920ms.this.f11567q.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) C1920ms.this.f11567q.get(i));
            return C1920ms.this.f11567q.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }
}
