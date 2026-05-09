package com.coollang.tennis.fragment;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.OverScroller;
import android.widget.RadioGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.MyCareerListBean;
import com.coollang.tennis.beans.MyDataBean;
import com.coollang.tennis.beans.MyEquipBean;
import com.coollang.tennis.beans.ScrollState;
import com.coollang.tennis.manager.PersonLifeManager;
import com.coollang.tennis.widget.CircleImageView;
import com.coollang.tennis.widget.NoScrollViewPagerNew;
import com.coollang.tennis.widget.ObservableScrollView;
import com.coollang.tennis.widget.TouchInterceptionFrameLayout;
import com.google.gson.Gson;
import eightbitlab.com.blurview.BlurView;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import p000.C1852ki;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1895ly;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1907mf;
import p000.C2049qf;
import p000.C2068qy;
import p000.InterfaceC1877lg;
import p000.InterfaceC1882ll;
import p000.ViewOnClickListenerC1885lo;
import p000.ViewOnClickListenerC1886lp;
import p000.akd;
import p000.akw;

/* JADX INFO: loaded from: classes.dex */
public class PersonalMainFramgent extends BaseFragment implements View.OnClickListener, InterfaceC1877lg {

    /* JADX INFO: renamed from: a */
    public static final String f7518a = C1852ki.f10915b + "MyImgcache.jpg";

    /* JADX INFO: renamed from: b */
    public static boolean f7519b = false;

    /* JADX INFO: renamed from: c */
    public static boolean f7520c = false;

    /* JADX INFO: renamed from: A */
    private float f7521A;

    /* JADX INFO: renamed from: B */
    private int f7522B;

    /* JADX INFO: renamed from: D */
    private int f7524D;

    /* JADX INFO: renamed from: E */
    private int f7525E;

    /* JADX INFO: renamed from: G */
    private int f7527G;

    /* JADX INFO: renamed from: H */
    private int f7528H;

    /* JADX INFO: renamed from: I */
    private boolean f7529I;

    /* JADX INFO: renamed from: J */
    private TouchInterceptionFrameLayout f7530J;

    /* JADX INFO: renamed from: K */
    private C1874ld f7531K;

    /* JADX INFO: renamed from: L */
    private Gson f7532L;

    /* JADX INFO: renamed from: N */
    private MyDataBean f7534N;

    /* JADX INFO: renamed from: O */
    private MyEquipBean f7535O;

    /* JADX INFO: renamed from: P */
    private MyCareerListBean f7536P;

    /* JADX INFO: renamed from: d */
    private View f7538d;

    /* JADX INFO: renamed from: e */
    private ImageView f7539e;

    /* JADX INFO: renamed from: f */
    private TextView f7540f;

    /* JADX INFO: renamed from: g */
    private TextView f7541g;

    /* JADX INFO: renamed from: h */
    private FrameLayout f7542h;

    /* JADX INFO: renamed from: i */
    private CircleImageView f7543i;

    /* JADX INFO: renamed from: j */
    private BlurView f7544j;

    /* JADX INFO: renamed from: k */
    private ImageView f7545k;

    /* JADX INFO: renamed from: l */
    private RadioGroup f7546l;

    /* JADX INFO: renamed from: m */
    private NoScrollViewPagerNew f7547m;

    /* JADX INFO: renamed from: n */
    private C1230a f7548n;

    /* JADX INFO: renamed from: o */
    private View f7549o;

    /* JADX INFO: renamed from: p */
    private ObservableScrollView f7550p;

    /* JADX INFO: renamed from: q */
    private ViewOnClickListenerC1885lo f7551q;

    /* JADX INFO: renamed from: r */
    private View f7552r;

    /* JADX INFO: renamed from: s */
    private ObservableScrollView f7553s;

    /* JADX INFO: renamed from: t */
    private PersonLifeManager f7554t;

    /* JADX INFO: renamed from: u */
    private View f7555u;

    /* JADX INFO: renamed from: v */
    private ObservableScrollView f7556v;

    /* JADX INFO: renamed from: w */
    private ViewOnClickListenerC1886lp f7557w;

    /* JADX INFO: renamed from: x */
    private List<View> f7558x;

    /* JADX INFO: renamed from: y */
    private VelocityTracker f7559y;

    /* JADX INFO: renamed from: z */
    private OverScroller f7560z;

    /* JADX INFO: renamed from: C */
    private int f7523C = -1;

    /* JADX INFO: renamed from: F */
    private int f7526F = 100;

    /* JADX INFO: renamed from: M */
    private String f7533M = "";

    /* JADX INFO: renamed from: Q */
    private TouchInterceptionFrameLayout.InterfaceC1383a f7537Q = new TouchInterceptionFrameLayout.InterfaceC1383a() { // from class: com.coollang.tennis.fragment.PersonalMainFramgent.3
        @Override // com.coollang.tennis.widget.TouchInterceptionFrameLayout.InterfaceC1383a
        /* JADX INFO: renamed from: a */
        public boolean mo7831a(MotionEvent motionEvent, boolean z, float f, float f2) {
            if (!PersonalMainFramgent.this.f7529I && PersonalMainFramgent.this.f7524D < Math.abs(f) && Math.abs(f2) < Math.abs(f)) {
                return false;
            }
            if (PersonalMainFramgent.this.m7814m() == null) {
                PersonalMainFramgent.this.f7529I = false;
                return false;
            }
            int i = PersonalMainFramgent.this.f7525E - PersonalMainFramgent.this.f7528H;
            int iM11182a = (int) C2049qf.m11182a(PersonalMainFramgent.this.f7530J);
            boolean z2 = 0.0f < f2;
            boolean z3 = f2 < 0.0f;
            if (z2) {
                if (iM11182a < 0) {
                    PersonalMainFramgent.this.f7529I = true;
                    return true;
                }
            } else if (z3 && (-i) < iM11182a) {
                PersonalMainFramgent.this.f7529I = true;
                return true;
            }
            PersonalMainFramgent.this.f7529I = false;
            return false;
        }

        @Override // com.coollang.tennis.widget.TouchInterceptionFrameLayout.InterfaceC1383a
        /* JADX INFO: renamed from: a */
        public void mo7829a(MotionEvent motionEvent) {
            PersonalMainFramgent.this.f7523C = motionEvent.getPointerId(0);
            PersonalMainFramgent.this.f7560z.forceFinished(true);
            if (PersonalMainFramgent.this.f7559y != null) {
                PersonalMainFramgent.this.f7559y.clear();
            } else {
                PersonalMainFramgent.this.f7559y = VelocityTracker.obtain();
            }
            PersonalMainFramgent.this.f7521A = C2049qf.m11182a(PersonalMainFramgent.this.f7530J);
            PersonalMainFramgent.this.f7559y.addMovement(motionEvent);
        }

        @Override // com.coollang.tennis.widget.TouchInterceptionFrameLayout.InterfaceC1383a
        /* JADX INFO: renamed from: a */
        public void mo7830a(MotionEvent motionEvent, float f, float f2) {
            float fM10515a = C1907mf.m10515a(C2049qf.m11182a(PersonalMainFramgent.this.f7530J) + f2, -(PersonalMainFramgent.this.f7525E - PersonalMainFramgent.this.f7528H), 0.0f);
            MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            motionEventObtainNoHistory.offsetLocation(0.0f, fM10515a - PersonalMainFramgent.this.f7521A);
            PersonalMainFramgent.this.f7559y.addMovement(motionEventObtainNoHistory);
            PersonalMainFramgent.this.m7789a(fM10515a);
        }

        @Override // com.coollang.tennis.widget.TouchInterceptionFrameLayout.InterfaceC1383a
        /* JADX INFO: renamed from: b */
        public void mo7832b(MotionEvent motionEvent) {
            PersonalMainFramgent.this.f7529I = false;
            if (PersonalMainFramgent.this.f7559y == null) {
                PersonalMainFramgent.this.f7559y = VelocityTracker.obtain();
                PersonalMainFramgent.this.f7559y.addMovement(motionEvent);
            }
            PersonalMainFramgent.this.f7559y.computeCurrentVelocity(1000, PersonalMainFramgent.this.f7522B);
            int yVelocity = (int) PersonalMainFramgent.this.f7559y.getYVelocity(PersonalMainFramgent.this.f7523C);
            PersonalMainFramgent.this.f7523C = -1;
            PersonalMainFramgent.this.f7560z.forceFinished(true);
            PersonalMainFramgent.this.f7560z.fling(0, (int) C2049qf.m11182a(PersonalMainFramgent.this.f7530J), 0, yVelocity, 0, 0, -(PersonalMainFramgent.this.f7525E - PersonalMainFramgent.this.f7528H), 0);
            new Handler().post(new Runnable() { // from class: com.coollang.tennis.fragment.PersonalMainFramgent.3.1
                @Override // java.lang.Runnable
                public void run() {
                    PersonalMainFramgent.this.m7810k();
                }
            });
        }
    };

    @TargetApi(17)
    /* JADX INFO: renamed from: n */
    private void m7815n() {
    }

    @Override // p000.InterfaceC1877lg
    /* JADX INFO: renamed from: a */
    public void mo7821a(int i, boolean z, boolean z2) {
    }

    @Override // p000.InterfaceC1877lg
    /* JADX INFO: renamed from: a */
    public void mo7823a(ScrollState scrollState) {
    }

    @Override // p000.InterfaceC1877lg
    /* JADX INFO: renamed from: c */
    public void mo7825c() {
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        this.f7538d = layoutInflater.inflate(R.layout.fragment_person_main, (ViewGroup) null);
        return this.f7538d;
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        m7793b(view);
        m7800f();
        m7818o();
    }

    /* JADX INFO: renamed from: b */
    private void m7793b(View view) {
        this.f7547m = (NoScrollViewPagerNew) view.findViewById(R.id.pager);
        this.f7530J = (TouchInterceptionFrameLayout) view.findViewById(R.id.container);
        this.f7539e = (ImageView) view.findViewById(R.id.imgv_setting);
        this.f7540f = (TextView) view.findViewById(R.id.tv_name);
        this.f7541g = (TextView) view.findViewById(R.id.tv_address_person);
        this.f7543i = (CircleImageView) view.findViewById(R.id.item_fragment_ranking_iv_head);
        this.f7542h = (FrameLayout) view.findViewById(R.id.fl_head);
        this.f7544j = (BlurView) view.findViewById(R.id.blurView);
        this.f7545k = (ImageView) view.findViewById(R.id.img_bg_blur);
        this.f7549o = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_person_data, (ViewGroup) null);
        this.f7552r = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_person_life, (ViewGroup) null);
        this.f7555u = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_person_equip, (ViewGroup) null);
        this.f7550p = (ObservableScrollView) this.f7549o.findViewById(R.id.scroll);
        this.f7553s = (ObservableScrollView) this.f7552r.findViewById(R.id.scroll);
        this.f7556v = (ObservableScrollView) this.f7555u.findViewById(R.id.scroll);
        this.f7546l = (RadioGroup) view.findViewById(R.id.rg_person_person);
    }

    /* JADX INFO: renamed from: f */
    private void m7800f() {
        this.f7551q = new ViewOnClickListenerC1885lo(this.f7549o, getActivity());
        this.f7554t = new PersonLifeManager(getActivity(), this.f7552r, new PersonLifeManager.InterfaceC1303a() { // from class: com.coollang.tennis.fragment.PersonalMainFramgent.1
            @Override // com.coollang.tennis.manager.PersonLifeManager.InterfaceC1303a
            /* JADX INFO: renamed from: a */
            public void mo7828a(int i) {
                PersonalMainFramgent.this.f7531K.m10213d(String.valueOf(i));
            }
        });
        this.f7557w = new ViewOnClickListenerC1886lp(this.f7555u, getActivity());
        m7802g();
        m7804h();
        m7806i();
        this.f7547m.setOffscreenPageLimit(3);
        this.f7548n = new C1230a();
        this.f7547m.setAdapter(this.f7548n);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getActivity());
        this.f7524D = viewConfiguration.getScaledTouchSlop();
        this.f7522B = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f7530J.setScrollInterceptionListener(this.f7537Q);
        this.f7560z = new OverScroller(getActivity().getApplicationContext());
        C1907mf.m10516a(this.f7530J, new Runnable() { // from class: com.coollang.tennis.fragment.PersonalMainFramgent.2
            @Override // java.lang.Runnable
            public void run() {
                ((FrameLayout.LayoutParams) PersonalMainFramgent.this.f7530J.getLayoutParams()).height = PersonalMainFramgent.this.m7824b() + PersonalMainFramgent.this.f7525E;
                PersonalMainFramgent.this.f7530J.requestLayout();
                PersonalMainFramgent.this.m7812l();
            }
        });
    }

    /* JADX INFO: renamed from: g */
    private void m7802g() {
        this.f7558x = new ArrayList();
        this.f7558x.add(this.f7549o);
        this.f7558x.add(this.f7552r);
        this.f7558x.add(this.f7555u);
        this.f7550p.setTouchInterceptionViewGroup(this.f7530J);
        this.f7553s.setTouchInterceptionViewGroup(this.f7530J);
        this.f7556v.setTouchInterceptionViewGroup(this.f7530J);
    }

    /* JADX INFO: renamed from: h */
    private void m7804h() {
        this.f7528H = C1895ly.m10460a(getActivity(), 130.0f);
        this.f7525E = C1895ly.m10460a(getActivity(), 234.0f);
        this.f7527G = C1895ly.m10460a(getActivity(), 40.0f);
    }

    /* JADX INFO: renamed from: i */
    private void m7806i() {
        try {
            this.f7544j.m9048a(this.f7545k).m9053a(this.f7545k.getDrawable()).m9052a(new akw(getActivity(), true)).m9051a(3.0f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        this.f7531K = new C1874ld();
        this.f7532L = new Gson();
        this.f7531K.m10235l();
        this.f7531K.m10233k();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        akd.m1706a().m1719a(this);
        C1900mc.m10474b("http", "onResume + GET_USER_ANALYSIS_DATA");
        this.f7531K.m10237m();
        C1900mc.m10474b("http", "careerNeedRefresh = " + f7520c + " equipNeedRefresh =  " + f7519b);
        if (f7520c) {
            this.f7531K.m10235l();
            f7520c = false;
        }
        if (f7519b) {
            this.f7531K.m10233k();
            f7519b = false;
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:11:0x0046. Please report as an issue. */
    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 58) {
            switch (c1873lc.f11065b) {
                case 1:
                    C1900mc.m10473a("GET_USER_ANALYSIS_DATA", "服务器返回的用户数据event.msg=" + c1873lc.f11064a);
                    this.f7534N = (MyDataBean) this.f7532L.fromJson(c1873lc.f11064a, MyDataBean.class);
                    m7808j();
                    this.f7551q.m10387a(this.f7534N);
                    break;
            }
        }
        if (c1873lc.f11072i == 24) {
            switch (c1873lc.f11065b) {
            }
            return;
        }
        if (c1873lc.f11072i == 52) {
            C1900mc.m10474b("GET_EQUIP_DATA", "获取我的装备" + c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case 1:
                    this.f7535O = (MyEquipBean) this.f7532L.fromJson(c1873lc.f11064a, MyEquipBean.class);
                    this.f7557w.m10399a(this.f7535O);
                    break;
            }
        }
        if (c1873lc.f11072i == 53) {
            switch (c1873lc.f11065b) {
                case 1:
                    C1900mc.m10474b("履历列表", c1873lc.f11064a);
                    this.f7536P = (MyCareerListBean) this.f7532L.fromJson(c1873lc.f11064a, MyCareerListBean.class);
                    this.f7554t.m8010a(this.f7536P);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: j */
    private void m7808j() {
        if (!this.f7533M.equals(this.f7534N.errDesc.UserInfo.Icon) || this.f7543i.getDrawable() == null) {
            this.f7533M = this.f7534N.errDesc.UserInfo.Icon;
            C2068qy.m11356a().m11360a(this.f7534N.errDesc.UserInfo.Icon, this.f7543i);
            C2068qy.m11356a().m11360a(this.f7534N.errDesc.UserInfo.Icon, this.f7545k);
        }
        this.f7540f.setText(this.f7534N.errDesc.UserInfo.UserName);
        if (this.f7534N.errDesc.UserInfo.Address == null || this.f7534N.errDesc.UserInfo.Address.isEmpty()) {
            this.f7541g.setVisibility(8);
        } else {
            this.f7541g.setText(this.f7534N.errDesc.UserInfo.Address);
        }
        if (this.f7554t != null) {
            this.f7554t.m8011a(this.f7534N.errDesc.Medals);
        }
    }

    /* JADX INFO: renamed from: b */
    protected int m7824b() {
        return this.f7538d.findViewById(R.id.container).getHeight();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: k */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m7810k() {
        /*
            r6 = this;
            android.widget.OverScroller r0 = r6.f7560z
            boolean r0 = r0.computeScrollOffset()
            r1 = 1
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L2e
            android.widget.OverScroller r0 = r6.f7560z
            int r0 = r0.getCurrY()
            float r0 = (float) r0
            int r4 = r6.f7525E
            int r5 = r6.f7528H
            int r4 = r4 - r5
            int r4 = -r4
            float r4 = (float) r4
            int r5 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r5 > 0) goto L22
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 > 0) goto L22
            goto L30
        L22:
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 >= 0) goto L28
            r0 = r4
            goto L30
        L28:
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 >= 0) goto L2f
            r0 = 0
            goto L30
        L2e:
            r0 = 0
        L2f:
            r1 = 0
        L30:
            if (r1 == 0) goto L42
            r6.m7789a(r0)
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            com.coollang.tennis.fragment.PersonalMainFramgent$4 r1 = new com.coollang.tennis.fragment.PersonalMainFramgent$4
            r1.<init>()
            r0.post(r1)
        L42:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.fragment.PersonalMainFramgent.m7810k():void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m7812l() {
        m7789a(C2049qf.m11182a(this.f7530J));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7789a(float f) {
        C2049qf.m11186d(this.f7530J, f);
        C2049qf.m11186d(this.f7539e, 0.0f - f);
        C2049qf.m11183a(this.f7540f, (this.f7526F + f) / this.f7526F);
        C2049qf.m11183a(this.f7541g, (this.f7526F + f) / this.f7526F);
        C2049qf.m11186d(this.f7542h, m7791b(f));
        C2049qf.m11184b(this.f7542h, m7795c(f));
        C2049qf.m11185c(this.f7542h, m7795c(f));
        float f2 = this.f7525E - 120;
        C1907mf.m10515a(((f + f2) - this.f7528H) / f2, 0.0f, 0.3f);
        m7815n();
    }

    /* JADX INFO: renamed from: b */
    private float m7791b(float f) {
        return (0.0f - f) + ((f / (this.f7525E - this.f7528H)) * this.f7527G);
    }

    /* JADX INFO: renamed from: c */
    private float m7795c(float f) {
        float f2 = this.f7525E - this.f7528H;
        return ((f + f2) / (f2 * 2.0f)) + 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public InterfaceC1882ll m7814m() {
        switch (this.f7547m.getCurrentItem()) {
            case 0:
                return this.f7550p;
            case 1:
                return this.f7553s;
            default:
                return this.f7556v;
        }
    }

    /* JADX INFO: renamed from: o */
    private void m7818o() {
        this.f7543i.setOnClickListener(this);
        this.f7539e.setOnClickListener(this);
        this.f7546l.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() { // from class: com.coollang.tennis.fragment.PersonalMainFramgent.5
            @Override // android.widget.RadioGroup.OnCheckedChangeListener
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rb_person_data /* 2131296977 */:
                        PersonalMainFramgent.this.f7547m.setCurrentItem(0);
                        break;
                    case R.id.rb_person_equip /* 2131296978 */:
                        PersonalMainFramgent.this.f7547m.setCurrentItem(2);
                        break;
                    case R.id.rb_person_life /* 2131296979 */:
                        PersonalMainFramgent.this.f7547m.setCurrentItem(1);
                        break;
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
            return;
        }
        int id = view.getId();
        if (id == R.id.imgv_setting) {
            C1887lq.m10427e(getActivity());
            return;
        }
        if (id != R.id.item_fragment_ranking_iv_head || this.f7534N == null || this.f7534N.errDesc == null || this.f7534N.errDesc.UserInfo == null || this.f7534N.errDesc.UserInfo.Icon == null || this.f7534N.errDesc.UserInfo.Icon.isEmpty()) {
            return;
        }
        C1887lq.m10426d(getActivity(), this.f7534N.errDesc.UserInfo.Icon);
    }

    /* JADX INFO: renamed from: d */
    public void m7826d() {
        m7820p();
        this.f7557w.m10398a();
        MyApplication.m7738a().m7746f();
    }

    /* JADX INFO: renamed from: e */
    public void m7827e() {
        m7820p();
        this.f7557w.m10400b();
        MyApplication.m7738a().m7746f();
    }

    /* JADX INFO: renamed from: p */
    private void m7820p() {
        File file = new File(f7518a);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        m7822a(MyApplication.m7738a().f7400a, file);
    }

    /* JADX INFO: renamed from: a */
    public void m7822a(Bitmap bitmap, File file) {
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

    /* JADX INFO: renamed from: com.coollang.tennis.fragment.PersonalMainFramgent$a */
    class C1230a extends PagerAdapter {
        @Override // android.support.v4.view.PagerAdapter
        public boolean isViewFromObject(View view, Object obj) {
            return view == obj;
        }

        private C1230a() {
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getCount() {
            return PersonalMainFramgent.this.f7558x.size();
        }

        @Override // android.support.v4.view.PagerAdapter
        public int getItemPosition(Object obj) {
            return super.getItemPosition(obj);
        }

        @Override // android.support.v4.view.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) PersonalMainFramgent.this.f7558x.get(i));
        }

        @Override // android.support.v4.view.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            viewGroup.addView((View) PersonalMainFramgent.this.f7558x.get(i));
            return PersonalMainFramgent.this.f7558x.get(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (z) {
            return;
        }
        C1900mc.m10474b("http", "onHiddenChanged + GET_USER_ANALYSIS_DATA");
        this.f7531K.m10237m();
    }
}
