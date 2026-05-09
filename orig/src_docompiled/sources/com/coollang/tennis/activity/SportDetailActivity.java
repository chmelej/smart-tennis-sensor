package com.coollang.tennis.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.facebook.Facebook;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.p007qq.C0874QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.SportDetailBean;
import com.coollang.tennis.beans.UserInfoBean;
import com.coollang.tennis.fragment.SportReportFragment;
import com.coollang.tennis.fragment.StrokeAnalysisFragment;
import com.coollang.tennis.widget.CircleImageView;
import com.coollang.tennis.widget.RippleView;
import com.github.mikephil.charting.charts.CombinedChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.CombinedData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ValueFormatter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.umeng.message.PushAgent;
import java.util.ArrayList;
import org.litepal.crud.DataSupport;
import p000.C1808is;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1895ly;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1910mi;
import p000.C1914mm;
import p000.C2068qy;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class SportDetailActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: F */
    private CombinedChart f6901F;

    /* JADX INFO: renamed from: G */
    private String[] f6902G;

    /* JADX INFO: renamed from: H */
    private SportDetailBean f6903H;

    /* JADX INFO: renamed from: I */
    private int f6904I;

    /* JADX INFO: renamed from: a */
    public String f6906a;

    /* JADX INFO: renamed from: b */
    CircleImageView f6907b;

    /* JADX INFO: renamed from: d */
    private RippleView f6909d;

    /* JADX INFO: renamed from: e */
    private RippleView f6910e;

    /* JADX INFO: renamed from: f */
    private RadioGroup f6911f;

    /* JADX INFO: renamed from: g */
    private ViewPager f6912g;

    /* JADX INFO: renamed from: i */
    private RelativeLayout f6914i;

    /* JADX INFO: renamed from: j */
    private LinearLayout f6915j;

    /* JADX INFO: renamed from: k */
    private Button f6916k;

    /* JADX INFO: renamed from: l */
    private RadioGroup f6917l;

    /* JADX INFO: renamed from: m */
    private RadioGroup f6918m;

    /* JADX INFO: renamed from: n */
    private SportReportFragment f6919n;

    /* JADX INFO: renamed from: o */
    private StrokeAnalysisFragment f6920o;

    /* JADX INFO: renamed from: p */
    private ImageView f6921p;

    /* JADX INFO: renamed from: q */
    private TextView f6922q;

    /* JADX INFO: renamed from: r */
    private TextView f6923r;

    /* JADX INFO: renamed from: s */
    private TextView f6924s;

    /* JADX INFO: renamed from: t */
    private TextView f6925t;

    /* JADX INFO: renamed from: u */
    private LinearLayout f6926u;

    /* JADX INFO: renamed from: v */
    private TextView f6927v;

    /* JADX INFO: renamed from: w */
    private TextView f6928w;

    /* JADX INFO: renamed from: x */
    private Bitmap f6929x;

    /* JADX INFO: renamed from: y */
    private Bitmap f6930y;

    /* JADX INFO: renamed from: h */
    private int f6913h = 0;

    /* JADX INFO: renamed from: z */
    private boolean f6931z = true;

    /* JADX INFO: renamed from: A */
    private ArrayList<Integer> f6896A = new ArrayList<>();

    /* JADX INFO: renamed from: B */
    private ArrayList<Integer> f6897B = new ArrayList<>();

    /* JADX INFO: renamed from: C */
    private ArrayList<String> f6898C = new ArrayList<>();

    /* JADX INFO: renamed from: D */
    private ArrayList<Entry> f6899D = new ArrayList<>();

    /* JADX INFO: renamed from: E */
    private ArrayList<Entry> f6900E = new ArrayList<>();

    /* JADX INFO: renamed from: c */
    Handler f6908c = new Handler() { // from class: com.coollang.tennis.activity.SportDetailActivity.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    SportDetailActivity.this.m7321b(Wechat.NAME);
                    break;
                case 1:
                    SportDetailActivity.this.m7321b(WechatMoments.NAME);
                    break;
                case 2:
                    SportDetailActivity.this.m7321b(C0874QQ.NAME);
                    break;
                case 3:
                    SportDetailActivity.this.m7316a(QZone.NAME);
                    break;
                case 4:
                    SportDetailActivity.this.f6915j.setVisibility(0);
                    TranslateAnimation translateAnimation = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);
                    translateAnimation.setDuration(300L);
                    SportDetailActivity.this.f6915j.startAnimation(translateAnimation);
                    break;
                case 5:
                    SportDetailActivity.this.m7321b(Facebook.NAME);
                    break;
                case 6:
                    SportDetailActivity.this.m7331h();
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: J */
    private ValueFormatter f6905J = new ValueFormatter() { // from class: com.coollang.tennis.activity.SportDetailActivity.4
        @Override // com.github.mikephil.charting.utils.ValueFormatter
        public String getFormattedValue(float f) {
            return String.valueOf((int) f);
        }
    };

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_sport_detail);
        PushAgent.getInstance(this).onAppStart();
        m7323c();
        m7325d();
        m7326e();
    }

    /* JADX INFO: renamed from: c */
    private void m7323c() {
        this.f6909d = (RippleView) findViewById(R.id.leftBtn);
        this.f6910e = (RippleView) findViewById(R.id.rightBtn);
        this.f6911f = (RadioGroup) findViewById(R.id.rg_sport_detail);
        this.f6912g = (ViewPager) findViewById(R.id.activity_sport_detail_viewpager);
        this.f6914i = (RelativeLayout) findViewById(R.id.activity_sport_detail_rl_share);
        this.f6917l = (RadioGroup) findViewById(R.id.activity_sport_detail_rg);
        this.f6916k = (Button) findViewById(R.id.activity_sport_detail_btn_cancle);
        this.f6915j = (LinearLayout) findViewById(R.id.rl_sport_detail_share);
        this.f6918m = (RadioGroup) findViewById(R.id.rg_en_share_sport_detail);
        this.f6921p = (ImageView) findViewById(R.id.activity_share_sport_iv_chart);
        this.f6922q = (TextView) findViewById(R.id.activity_share_sport_tv_sport_time);
        this.f6923r = (TextView) findViewById(R.id.activity_share_sport_tv_expend_calori);
        this.f6924s = (TextView) findViewById(R.id.activity_share_sport_tv_most_rate);
        this.f6925t = (TextView) findViewById(R.id.activity_share_sport_tv_every_minute);
        this.f6926u = (LinearLayout) findViewById(R.id.ll_root);
        this.f6927v = (TextView) findViewById(R.id.activity_share_sport_tv_name);
        this.f6928w = (TextView) findViewById(R.id.activity_share_sport_tv_time);
        this.f6907b = (CircleImageView) findViewById(R.id.civ_head);
        this.f6901F = (CombinedChart) findViewById(R.id.combined_chart);
    }

    /* JADX INFO: renamed from: d */
    private void m7325d() {
        this.f6914i.setVisibility(8);
        this.f6912g.setAdapter(new C1097a(getSupportFragmentManager()));
        this.f6912g.setOnPageChangeListener(this);
        this.f6912g.setCurrentItem(0, false);
        this.f6910e.setVisibility(0);
    }

    /* JADX INFO: renamed from: e */
    private void m7326e() {
        this.f6914i.setOnClickListener(this);
        this.f6917l.setOnCheckedChangeListener(this);
        this.f6918m.setOnCheckedChangeListener(this);
        this.f6916k.setOnClickListener(this);
        this.f6910e.setOnClickListener(this);
        this.f6909d.setOnClickListener(this);
        this.f6911f.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.activity.SportDetailActivity.1
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_sport_detail_analysis /* 2131296988 */:
                        if (SportDetailActivity.this.f6912g.getCurrentItem() != 0) {
                            SportDetailActivity.this.f6912g.setCurrentItem(0);
                        }
                        break;
                    case R.id.rb_sport_detail_report /* 2131296989 */:
                        if (SportDetailActivity.this.f6912g.getCurrentItem() != 1) {
                            SportDetailActivity.this.f6912g.setCurrentItem(1);
                        }
                        break;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6906a = getIntent().getStringExtra("date");
        if (MyApplication.m7738a().m7747g()) {
            m7318a(C1902me.m10489b((Context) this, C1852ki.f10918e + this.f6906a, false), C1902me.m10487b(this, this.f6906a, "0"));
        } else if (MyApplication.m7738a().m7748h()) {
            boolean zM10489b = C1902me.m10489b((Context) this, "france" + C1852ki.f10918e + this.f6906a, false);
            StringBuilder sb = new StringBuilder();
            sb.append("france");
            sb.append(this.f6906a);
            m7318a(zM10489b, C1902me.m10487b(this, sb.toString(), "0"));
        } else {
            boolean zM10489b2 = C1902me.m10489b((Context) this, "english" + C1852ki.f10918e + this.f6906a, false);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("english");
            sb2.append(this.f6906a);
            m7318a(zM10489b2, C1902me.m10487b(this, sb2.toString(), "0"));
        }
        UserInfoBean userInfoBeanM7745e = MyApplication.m7738a().m7745e();
        if (userInfoBeanM7745e != null) {
            this.f6927v.setText(userInfoBeanM7745e.errDesc.UserName);
            if (!TextUtils.isEmpty(userInfoBeanM7745e.errDesc.Address)) {
                this.f6928w.setText(userInfoBeanM7745e.errDesc.Address);
            } else {
                this.f6928w.setVisibility(8);
            }
            this.f6930y = C2068qy.m11356a().m11358a(userInfoBeanM7745e.errDesc.Icon);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7318a(boolean z, final String str) {
        if (z && !str.equals("0")) {
            new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.SportDetailActivity.2
                @Override // java.lang.Runnable
                public void run() {
                    akd.m1706a().m1722c(new C1873lc(str, 1, 9, SportDetailActivity.this.f6906a));
                    Gson gsonCreate = new GsonBuilder().registerTypeAdapter(SportDetailBean.class, new SportDetailBean.DetailDeserilizer()).create();
                    SportDetailActivity.this.f6903H = (SportDetailBean) gsonCreate.fromJson(str, SportDetailBean.class);
                }
            }, 500L);
        } else {
            C1808is.m9825a("run-enTennisHttp");
            new C1874ld().m10189a(this.f6906a);
        }
    }

    /* JADX INFO: renamed from: com.coollang.tennis.activity.SportDetailActivity$a */
    class C1097a extends FragmentPagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return 2;
        }

        public C1097a(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // android.support.v4.app.FragmentPagerAdapter
        public Fragment getItem(int i) {
            if (i == 0) {
                if (SportDetailActivity.this.f6919n == null) {
                    SportDetailActivity.this.f6919n = new SportReportFragment();
                }
                return SportDetailActivity.this.f6919n;
            }
            if (SportDetailActivity.this.f6920o == null) {
                SportDetailActivity.this.f6920o = new StrokeAnalysisFragment();
            }
            return SportDetailActivity.this.f6920o;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        this.f6913h = i;
        if (i == 0) {
            ((RadioButton) this.f6911f.findViewById(R.id.rb_sport_detail_analysis)).setChecked(true);
        } else {
            ((RadioButton) this.f6911f.findViewById(R.id.rb_sport_detail_report)).setChecked(true);
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m7313a(Context context, String str) {
        Intent intent = new Intent(context, (Class<?>) SportDetailActivity.class);
        intent.putExtra("date", str);
        context.startActivity(intent);
        ((Activity) context).overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
            return;
        }
        int id = view.getId();
        if (id == R.id.activity_sport_detail_btn_cancle || id == R.id.activity_sport_detail_rl_share) {
            this.f6914i.setVisibility(8);
            this.f6915j.clearAnimation();
            this.f6915j.setVisibility(8);
            return;
        }
        if (id == R.id.leftBtn) {
            m7733j();
            return;
        }
        if (id != R.id.rightBtn) {
            return;
        }
        this.f6914i.setVisibility(0);
        m7332i();
        if (MyApplication.m7738a().m7747g()) {
            this.f6917l.setVisibility(0);
            this.f6918m.setVisibility(8);
            this.f6908c.sendEmptyMessage(4);
        } else {
            this.f6917l.setVisibility(8);
            this.f6918m.setVisibility(0);
            this.f6908c.sendEmptyMessage(4);
        }
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        if (i != R.id.rb_share_fb) {
            switch (i) {
                case R.id.activity_sport_detail_rb_friend /* 2131296346 */:
                    m7328f();
                    this.f6908c.sendEmptyMessageDelayed(1, 100L);
                    break;
                case R.id.activity_sport_detail_rb_qq /* 2131296347 */:
                    m7328f();
                    this.f6908c.sendEmptyMessageDelayed(2, 100L);
                    break;
                case R.id.activity_sport_detail_rb_weixin /* 2131296348 */:
                    m7328f();
                    this.f6908c.sendEmptyMessageDelayed(0, 100L);
                    break;
                case R.id.activity_sport_detail_rb_zone /* 2131296349 */:
                    m7328f();
                    this.f6908c.sendEmptyMessageDelayed(3, 100L);
                    break;
            }
        } else {
            m7328f();
            this.f6908c.sendEmptyMessageDelayed(5, 100L);
        }
        if (i != R.id.rb_share_fb) {
            ((RadioButton) this.f6917l.findViewById(i)).setChecked(false);
        } else {
            ((RadioButton) this.f6918m.findViewById(i)).setChecked(false);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m7328f() {
        this.f6914i.setVisibility(8);
        if (this.f6912g.getCurrentItem() == 0) {
            findViewById(R.id.ll_data).setVisibility(0);
            findViewById(R.id.chart_title).setVisibility(0);
            this.f6901F.setVisibility(0);
            this.f6929x = m7307a(this.f6919n.f7687f);
            if (this.f6929x != null) {
                if (this.f6914i.getHeight() > 1750) {
                    ViewGroup.LayoutParams layoutParams = this.f6921p.getLayoutParams();
                    layoutParams.height = C1895ly.m10460a(this, 280.0f);
                    this.f6921p.setLayoutParams(layoutParams);
                }
                C1900mc.m10475c("SportDetailActivity", "bitmap=" + this.f6929x);
                this.f6921p.setImageBitmap(this.f6929x);
            }
            String strM10557b = C1914mm.m10557b(R.string.minute);
            String string = this.f6919n.f7683b.getText().toString();
            this.f6922q.setText(C1910mi.m10524a(string.split(strM10557b)[0], string, 16, C1914mm.m10559d(R.color.text_menu_checked)));
            String strM10557b2 = C1914mm.m10557b(R.string.cal);
            String string2 = this.f6919n.f7685d.getText().toString();
            this.f6923r.setText(C1910mi.m10524a(string2.split(strM10557b2)[0], string2, 16, C1914mm.m10559d(R.color.text_menu_checked)));
            String strM10557b3 = C1914mm.m10557b(R.string.kilo_unit);
            String string3 = this.f6919n.f7686e.getText().toString();
            this.f6924s.setText(C1910mi.m10524a(string3.split(strM10557b3)[0], string3, 16, C1914mm.m10559d(R.color.text_menu_checked)));
            String strM10557b4 = C1914mm.m10557b(R.string.times);
            String string4 = this.f6919n.f7684c.getText().toString();
            this.f6925t.setText(C1910mi.m10524a(string4.split(strM10557b4)[0], string4, 16, C1914mm.m10559d(R.color.text_menu_checked)));
            Typeface typeface = MyApplication.m7738a().f7404e;
            this.f6922q.setTypeface(typeface);
            this.f6923r.setTypeface(typeface);
            this.f6924s.setTypeface(typeface);
            this.f6925t.setTypeface(typeface);
        } else {
            findViewById(R.id.chart_title).setVisibility(8);
            findViewById(R.id.ll_data).setVisibility(8);
            this.f6901F.setVisibility(8);
            this.f6921p.setVisibility(0);
            this.f6929x = m7307a(this.f6920o.f7726a);
            if (this.f6929x != null) {
                if (this.f6914i.getHeight() > 1750) {
                    ViewGroup.LayoutParams layoutParams2 = this.f6921p.getLayoutParams();
                    layoutParams2.height = C1895ly.m10460a(this, 350.0f);
                    this.f6921p.setLayoutParams(layoutParams2);
                }
                C1900mc.m10475c("SportDetailActivity", "bitmap=" + this.f6929x);
                this.f6921p.setImageBitmap(this.f6929x);
            }
        }
        if (this.f6930y != null) {
            this.f6907b.setImageBitmap(this.f6930y);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7316a(String str) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setViewToShare(this.f6926u);
        onekeyShare.setText(getString(R.string.app_name));
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m7321b(String str) {
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setViewToShare(this.f6926u);
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f6929x != null && !this.f6929x.isRecycled()) {
            this.f6929x.recycle();
            this.f6929x = null;
        }
        if (this.f6930y != null && !this.f6930y.isRecycled()) {
            this.f6930y.recycle();
            this.f6930y = null;
        }
        super.onDestroy();
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m7307a(View view) {
        view.clearFocus();
        view.setPressed(false);
        boolean zWillNotCacheDrawing = view.willNotCacheDrawing();
        view.setWillNotCacheDrawing(false);
        int drawingCacheBackgroundColor = view.getDrawingCacheBackgroundColor();
        view.setDrawingCacheBackgroundColor(0);
        if (drawingCacheBackgroundColor != 0) {
            view.destroyDrawingCache();
        }
        view.buildDrawingCache();
        Bitmap drawingCache = view.getDrawingCache();
        if (drawingCache == null) {
            return null;
        }
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(drawingCache);
        view.destroyDrawingCache();
        view.setWillNotCacheDrawing(zWillNotCacheDrawing);
        view.setDrawingCacheBackgroundColor(drawingCacheBackgroundColor);
        return bitmapCreateBitmap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m7330g() {
        String strReplace = this.f6906a.replace("-", "");
        String strM10487b = C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1");
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * From mydetailtable Where sign2 = ? And UserID = ? order by timestamp asc", strReplace, strM10487b);
        if (cursorFindBySQL.getCount() != 0) {
            while (cursorFindBySQL.moveToNext()) {
                this.f6897B.add(Integer.valueOf(cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("speed"))));
            }
        }
        C1808is.m9827c(this.f6897B);
        cursorFindBySQL.close();
        Cursor cursorFindBySQL2 = DataSupport.findBySQL("Select * From mydetailtable Where sign2 = ? And UserID = ? And handtype = ? order by timestamp asc", strReplace, strM10487b, "0");
        if (cursorFindBySQL2.getCount() != 0) {
            while (cursorFindBySQL2.moveToNext()) {
                this.f6896A.add(Integer.valueOf(cursorFindBySQL2.getInt(cursorFindBySQL.getColumnIndex("speed"))));
            }
        }
        C1808is.m9827c(this.f6896A);
        cursorFindBySQL2.close();
        this.f6908c.sendEmptyMessage(6);
    }

    /* JADX INFO: renamed from: a */
    private void m7317a(ArrayList<Integer> arrayList, ArrayList<Entry> arrayList2) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int size = arrayList.size() / 10;
        int iIntValue = 0;
        for (int i9 = 0; i9 < size; i9++) {
            iIntValue += arrayList.get(i9).intValue();
        }
        int i10 = size;
        int iIntValue2 = 0;
        while (true) {
            i = size * 2;
            if (i10 >= i) {
                break;
            }
            iIntValue2 += arrayList.get(i10).intValue();
            i10++;
        }
        int iIntValue3 = 0;
        while (true) {
            i2 = size * 3;
            if (i >= i2) {
                break;
            }
            iIntValue3 += arrayList.get(i).intValue();
            i++;
        }
        int iIntValue4 = 0;
        while (true) {
            i3 = size * 4;
            if (i2 >= i3) {
                break;
            }
            iIntValue4 += arrayList.get(i2).intValue();
            i2++;
        }
        int iIntValue5 = 0;
        while (true) {
            i4 = size * 5;
            if (i3 >= i4) {
                break;
            }
            iIntValue5 += arrayList.get(i3).intValue();
            i3++;
        }
        int iIntValue6 = 0;
        while (true) {
            i5 = size * 6;
            if (i4 >= i5) {
                break;
            }
            iIntValue6 += arrayList.get(i4).intValue();
            i4++;
        }
        int iIntValue7 = 0;
        while (true) {
            i6 = size * 7;
            if (i5 >= i6) {
                break;
            }
            iIntValue7 += arrayList.get(i5).intValue();
            i5++;
        }
        int iIntValue8 = 0;
        while (true) {
            i7 = size * 8;
            if (i6 >= i7) {
                break;
            }
            iIntValue8 += arrayList.get(i6).intValue();
            i6++;
        }
        int iIntValue9 = 0;
        while (true) {
            i8 = size * 9;
            if (i7 >= i8) {
                break;
            }
            iIntValue9 += arrayList.get(i7).intValue();
            i7++;
        }
        int iIntValue10 = 0;
        while (i8 < size * 10) {
            iIntValue10 += arrayList.get(i8).intValue();
            i8++;
        }
        double d = size;
        float f = (float) ((((double) iIntValue) * 1.0d) / d);
        float f2 = (float) ((((double) iIntValue2) * 1.0d) / d);
        float f3 = (float) ((((double) iIntValue4) * 1.0d) / d);
        float f4 = (float) ((((double) iIntValue5) * 1.0d) / d);
        arrayList2.add(new Entry(f, 0));
        arrayList2.add(new Entry(f, 1));
        arrayList2.add(new Entry(f2, 2));
        arrayList2.add(new Entry((float) ((((double) iIntValue3) * 1.0d) / d), 3));
        arrayList2.add(new Entry(f3, 4));
        arrayList2.add(new Entry(f4, 5));
        arrayList2.add(new Entry((float) ((((double) iIntValue6) * 1.0d) / d), 6));
        arrayList2.add(new Entry((float) ((((double) iIntValue7) * 1.0d) / d), 7));
        arrayList2.add(new Entry((float) ((((double) iIntValue8) * 1.0d) / d), 8));
        arrayList2.add(new Entry((float) ((((double) iIntValue9) * 1.0d) / d), 9));
        arrayList2.add(new Entry((float) ((((double) iIntValue10) * 1.0d) / d), 10));
    }

    /* JADX INFO: renamed from: a */
    private LineData m7312a(ArrayList<Entry> arrayList) {
        this.f6898C = new ArrayList<>();
        for (int i = 0; i < this.f6902G.length; i++) {
            this.f6898C.add(i + "");
        }
        if (arrayList.size() != 0) {
            arrayList.clear();
        }
        C1808is.m9827c("sportDuration====" + this.f6904I);
        if (this.f6904I >= 10) {
            m7317a(this.f6897B, arrayList);
        } else {
            arrayList.add(new Entry(0.0f, 0));
            arrayList.add(new Entry(40.0f, 1));
            arrayList.add(new Entry(40.0f, 2));
            arrayList.add(new Entry(80.0f, 3));
            arrayList.add(new Entry(80.0f, 4));
            arrayList.add(new Entry(120.0f, 5));
            arrayList.add(new Entry(120.0f, 6));
            arrayList.add(new Entry(160.0f, 7));
            arrayList.add(new Entry(160.0f, 8));
            arrayList.add(new Entry(200.0f, 9));
            arrayList.add(new Entry(200.0f, 10));
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList, "");
        lineDataSet.setAxisDependency(YAxis.AxisDependency.LEFT);
        lineDataSet.setColor(Color.parseColor("#25c9ad"));
        lineDataSet.setLineWidth(2.0f);
        lineDataSet.setCircleSize(0.0f);
        lineDataSet.setFillAlpha(30);
        lineDataSet.setFillColor(Color.parseColor("#25c9ad"));
        lineDataSet.setHighlightEnabled(false);
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setDrawFilled(true);
        lineDataSet.setDrawCubic(true);
        lineDataSet.setDrawValues(false);
        if (this.f6904I >= 10) {
            lineDataSet.setVisible(true);
        } else {
            lineDataSet.setVisible(false);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(lineDataSet);
        LineData lineData = new LineData(this.f6898C, arrayList2);
        lineData.setValueTextColor(Color.parseColor("#dededf"));
        lineData.setValueTextSize(10.0f);
        return lineData;
    }

    /* JADX INFO: renamed from: a */
    private void m7315a(CombinedChart combinedChart, String str) {
        int i = Integer.parseInt(str) / 10;
        this.f6902G = new String[11];
        for (int i2 = 0; i2 <= 10; i2++) {
            this.f6902G[i2] = String.valueOf(i * i2);
        }
        this.f6904I = Integer.parseInt(str);
        combinedChart.setDescription("");
        combinedChart.setNoDataTextDescription(C1914mm.m10557b(R.string.no_data));
        combinedChart.setHighlightEnabled(true);
        combinedChart.setTouchEnabled(true);
        combinedChart.setDragDecelerationFrictionCoef(0.9f);
        combinedChart.setDragEnabled(true);
        combinedChart.setScaleEnabled(false);
        combinedChart.setDrawGridBackground(false);
        combinedChart.setHighlightPerDragEnabled(true);
        combinedChart.setPinchZoom(true);
        combinedChart.setBackgroundColor(Color.parseColor("#f7f7f7"));
        Legend legend = combinedChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(10.0f);
        legend.setTextColor(Color.parseColor("#dededf"));
        legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);
        legend.setXEntrySpace(30.0f);
        legend.setYEntrySpace(20.0f);
        legend.setYOffset(180.0f);
        XAxis xAxis = combinedChart.getXAxis();
        xAxis.setTextSize(10.0f);
        xAxis.setTextColor(Color.parseColor("#dededf"));
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(true);
        xAxis.setAxisLineColor(Color.parseColor("#dededf"));
        xAxis.setSpaceBetweenLabels(1);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        if (this.f6904I >= 10) {
            xAxis.setDrawLabels(true);
        } else {
            xAxis.setDrawLabels(false);
        }
        CombinedData combinedData = new CombinedData(this.f6902G);
        combinedData.setValueTextColor(Color.parseColor("#dededf"));
        YAxis axisLeft = combinedChart.getAxisLeft();
        YAxis axisRight = combinedChart.getAxisRight();
        axisRight.setXOffset(5.0f);
        axisRight.setTextColor(Color.parseColor("#dededf"));
        axisRight.setGridColor(Color.parseColor("#dededf"));
        axisRight.setAxisLineWidth(0.0f);
        axisRight.setAxisMaxValue(200.0f);
        axisRight.setLabelCount(5);
        axisRight.setAxisMinValue(0.0f);
        axisRight.resetAxisMinValue();
        axisRight.setDrawGridLines(true);
        axisRight.setDrawAxisLine(false);
        axisRight.setDrawLabels(false);
        axisLeft.setTextColor(Color.parseColor("#dededf"));
        axisLeft.setAxisLineColor(0);
        axisLeft.setAxisMaxValue(200.0f);
        axisLeft.setLabelCount(5);
        axisLeft.setAxisMinValue(0.1f);
        axisLeft.setDrawLabels(true);
        axisLeft.setStartAtZero(false);
        axisLeft.setDrawGridLines(true);
        axisLeft.setGridColor(Color.parseColor("#dededf"));
        axisLeft.setAxisLineWidth(0.0f);
        axisLeft.setXOffset(5.0f);
        axisLeft.setValueFormatter(this.f6905J);
        combinedData.setData(m7312a(this.f6900E));
        combinedChart.setData(combinedData);
        C1900mc.m10475c("Tagg", ">>>>>>>>>");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7331h() {
        if (this.f6903H != null) {
            String str = this.f6903H.errDesc.Duration;
            if (str == null || "".equals(str)) {
                str = "0";
            }
            C1808is.m9827c(this.f6903H);
            m7315a(this.f6901F, str);
        }
    }

    /* JADX INFO: renamed from: i */
    private void m7332i() {
        new Thread(new Runnable() { // from class: com.coollang.tennis.activity.SportDetailActivity.5
            @Override // java.lang.Runnable
            public void run() {
                SportDetailActivity.this.m7330g();
            }
        }).start();
    }
}
