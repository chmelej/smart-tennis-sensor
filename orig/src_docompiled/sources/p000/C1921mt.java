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

/* JADX INFO: renamed from: mt */
/* JADX INFO: compiled from: HeadFastUsePopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1921mt {

    /* JADX INFO: renamed from: a */
    public PopupWindow f11576a;

    /* JADX INFO: renamed from: b */
    public Activity f11577b;

    /* JADX INFO: renamed from: c */
    private ViewPager f11578c;

    /* JADX INFO: renamed from: d */
    private LinearLayout f11579d;

    /* JADX INFO: renamed from: e */
    private ImageView f11580e;

    /* JADX INFO: renamed from: f */
    private View f11581f;

    /* JADX INFO: renamed from: g */
    private View f11582g;

    /* JADX INFO: renamed from: h */
    private View f11583h;

    /* JADX INFO: renamed from: i */
    private View f11584i;

    /* JADX INFO: renamed from: j */
    private View f11585j;

    /* JADX INFO: renamed from: k */
    private View f11586k;

    /* JADX INFO: renamed from: l */
    private ImageView[] f11587l;

    /* JADX INFO: renamed from: m */
    private List<View> f11588m;

    public C1921mt(Activity activity) {
        this.f11577b = activity;
        m10609b();
    }

    /* JADX INFO: renamed from: b */
    private void m10609b() {
        View viewInflate = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_fast_use, (ViewGroup) null);
        this.f11578c = (ViewPager) viewInflate.findViewById(R.id.vp_fast_use);
        this.f11579d = (LinearLayout) viewInflate.findViewById(R.id.ll_dots_fast_use);
        this.f11580e = (ImageView) viewInflate.findViewById(R.id.img_close);
        this.f11576a = new PopupWindow(viewInflate, -1, -1);
        this.f11576a.setFocusable(true);
        this.f11576a.setBackgroundDrawable(new BitmapDrawable());
        this.f11576a.setTouchable(true);
        this.f11588m = new ArrayList();
        this.f11580e.setOnClickListener(new View.OnClickListener() { // from class: mt.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1921mt.this.f11576a.isShowing()) {
                    C1921mt.this.f11576a.dismiss();
                }
            }
        });
        m10611c();
    }

    /* JADX INFO: renamed from: c */
    private void m10611c() {
        this.f11581f = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar = new b(this.f11581f);
        bVar.f11593b.setText("开机");
        bVar.f11594c.setText("使用球拍稍用力拍手，或者使用球拍正常击球即可完成开机操作。开机后球拍底部的指示灯将会闪烁。若球拍无法正常开机，请充电后再作尝试。");
        bVar.f11595d.setVisibility(8);
        this.f11582g = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar2 = new b(this.f11582g);
        bVar2.f11592a.setImageResource(R.drawable.fast_use_close);
        bVar2.f11593b.setText("关机");
        bVar2.f11594c.setText("如果超过10分钟未使用，球拍将自动关机。若球拍已与手机连接，可在APP的设备控制选项中选择“关闭设备”实现手动关机。");
        bVar2.f11595d.setVisibility(8);
        this.f11583h = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar3 = new b(this.f11583h);
        bVar3.f11592a.setImageResource(R.drawable.img_fast_use_savedata);
        bVar3.f11593b.setText("记录数据");
        bVar3.f11594c.setText("开机后，球拍将默认选择记忆模式，自动记录您的运动数据并在下次连接手机后将数据传输至手机。如果您需要实时监测数据或进行挥拍训练，则需将球拍与手机连接。");
        bVar3.f11595d.setVisibility(8);
        this.f11584i = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_use_connect, (ViewGroup) null);
        ((TextView) this.f11584i.findViewById(R.id.tv_use_step)).setText("1、下载并登录“智能网球”APP\n2、开启球拍并确保手机蓝牙已打开\n3、点击APP“统计”界面右上角的图标后，在搜索列表中选择您的球拍并点击“连接”即可\n");
        this.f11585j = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar4 = new b(this.f11585j);
        bVar4.f11592a.setImageResource(R.drawable.img_fast_use_charge);
        bVar4.f11593b.setText("充电与指示");
        bVar4.f11594c.setText("海德智能网球拍使用DC-5V标准Micro-USB充电。在为球拍进行充电时，球拍底部的指示灯将快速闪烁，直到充满电后进入常亮状态。");
        bVar4.f11595d.setVisibility(8);
        this.f11586k = LayoutInflater.from(this.f11577b).inflate(R.layout.layout_pop_use_describe, (ViewGroup) null);
        b bVar5 = new b(this.f11586k);
        bVar5.f11592a.setImageResource(R.drawable.fast_use_reset_head);
        bVar5.f11593b.setText("恢复出厂");
        bVar5.f11594c.setText("当您的球拍出现未知故障时，您可以尝试通过恢复出厂设置来进行还原。请在APP的个人-设置菜单中选择“重置设备”将球拍恢复至出厂状态。");
        bVar5.f11595d.setVisibility(8);
        this.f11588m.add(this.f11581f);
        this.f11588m.add(this.f11582g);
        this.f11588m.add(this.f11583h);
        this.f11588m.add(this.f11584i);
        this.f11588m.add(this.f11585j);
        this.f11588m.add(this.f11586k);
        m10613e();
        m10612d();
    }

    /* JADX INFO: renamed from: d */
    private void m10612d() {
        this.f11578c.setAdapter(new a());
        this.f11578c.setOnPageChangeListener(new ViewPager.OnPageChangeListener() { // from class: mt.2
            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrollStateChanged(int i) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageScrolled(int i, float f, int i2) {
            }

            @Override // android.support.v4.view.ViewPager.OnPageChangeListener
            public void onPageSelected(int i) {
                C1921mt.this.m10610b(i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m10610b(int i) {
        for (int i2 = 0; i2 < this.f11587l.length; i2++) {
            if (i2 == i) {
                this.f11587l[i2].setImageResource(R.drawable.fast_use_dot_select);
            } else {
                this.f11587l[i2].setImageResource(R.drawable.fast_use_dot_unselect);
            }
        }
    }

    /* JADX INFO: renamed from: e */
    private void m10613e() {
        this.f11587l = new ImageView[this.f11588m.size()];
        for (int i = 0; i < this.f11588m.size(); i++) {
            ImageView imageView = new ImageView(this.f11577b);
            imageView.setImageResource(R.drawable.fast_use_dot_unselect);
            imageView.setPadding(C1895ly.m10460a(this.f11577b, 4.0f), 0, C1895ly.m10460a(this.f11577b, 4.0f), 0);
            this.f11587l[i] = imageView;
            this.f11579d.addView(imageView);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10615a(int i) {
        if (i < this.f11588m.size()) {
            this.f11578c.setCurrentItem(i);
            m10610b(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10614a() {
        if (this.f11576a.isShowing()) {
            this.f11576a.dismiss();
        }
        this.f11576a.showAtLocation(this.f11577b.getWindow().getDecorView(), 17, 0, 0);
        this.f11578c.startAnimation(AnimationUtils.loadAnimation(this.f11577b, R.anim.show_window_anim));
    }

    /* JADX INFO: renamed from: mt$b */
    /* JADX INFO: compiled from: HeadFastUsePopWindow.java */
    class b {

        /* JADX INFO: renamed from: a */
        ImageView f11592a;

        /* JADX INFO: renamed from: b */
        TextView f11593b;

        /* JADX INFO: renamed from: c */
        TextView f11594c;

        /* JADX INFO: renamed from: d */
        TextView f11595d;

        public b(View view) {
            this.f11592a = (ImageView) view.findViewById(R.id.img_content_fast_use);
            this.f11593b = (TextView) view.findViewById(R.id.tv_title_fast_use_desc);
            this.f11594c = (TextView) view.findViewById(R.id.tv_content_fast_use_desc);
            this.f11595d = (TextView) view.findViewById(R.id.tv_note_fast_use);
        }
    }

    /* JADX INFO: renamed from: mt$a */
    /* JADX INFO: compiled from: HeadFastUsePopWindow.java */
    class a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return C1921mt.this.f11588m.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) C1921mt.this.f11588m.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) C1921mt.this.f11588m.get(i));
            return C1921mt.this.f11588m.get(i);
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }
    }
}
