package com.coollang.tennis.activity;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.p007qq.C0874QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.ChildResponseListBean;
import com.coollang.tennis.beans.CommentBean;
import com.coollang.tennis.beans.MymsgListBean;
import com.coollang.tennis.beans.MyvideoBean;
import com.coollang.tennis.beans.Video_msg_Bean;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import p000.C1817ja;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1890lt;
import p000.C1900mc;
import p000.C1902me;
import p000.C2253xu;
import p000.InterfaceC1805ip;
import p000.InterfaceC1881lk;
import p000.ProgressDialogC1809it;
import p000.ViewOnClickListenerC1813ix;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class Video_detail_Activity extends BaseActivity implements View.OnClickListener, InterfaceC1881lk {

    /* JADX INFO: renamed from: e */
    public static String f7245e;

    /* JADX INFO: renamed from: j */
    public static String f7246j;

    /* JADX INFO: renamed from: k */
    public static int f7247k;

    /* JADX INFO: renamed from: A */
    private RelativeLayout f7248A;

    /* JADX INFO: renamed from: B */
    private RelativeLayout f7249B;

    /* JADX INFO: renamed from: C */
    private C1874ld f7250C;

    /* JADX INFO: renamed from: D */
    private TextView f7251D;

    /* JADX INFO: renamed from: E */
    private PopupWindow f7252E;

    /* JADX INFO: renamed from: F */
    private ProgressDialogC1809it f7253F;

    /* JADX INFO: renamed from: G */
    private RelativeLayout f7254G;

    /* JADX INFO: renamed from: H */
    private RelativeLayout f7255H;

    /* JADX INFO: renamed from: I */
    private RelativeLayout f7256I;

    /* JADX INFO: renamed from: J */
    private LinearLayout f7257J;

    /* JADX INFO: renamed from: K */
    private LinearLayout f7258K;

    /* JADX INFO: renamed from: L */
    private LinearLayout f7259L;

    /* JADX INFO: renamed from: M */
    private LinearLayout f7260M;

    /* JADX INFO: renamed from: N */
    private ImageView f7261N;

    /* JADX INFO: renamed from: O */
    private ImageView f7262O;

    /* JADX INFO: renamed from: P */
    private ImageView f7263P;

    /* JADX INFO: renamed from: Q */
    private ImageView f7264Q;

    /* JADX INFO: renamed from: R */
    private String f7265R;

    /* JADX INFO: renamed from: S */
    private String f7266S;

    /* JADX INFO: renamed from: T */
    private String f7267T;

    /* JADX INFO: renamed from: U */
    private String f7268U;

    /* JADX INFO: renamed from: V */
    private String f7269V;

    /* JADX INFO: renamed from: W */
    private LinearLayout f7270W;

    /* JADX INFO: renamed from: Y */
    private RecyclerView f7272Y;

    /* JADX INFO: renamed from: Z */
    private C1817ja f7273Z;

    /* JADX INFO: renamed from: a */
    PopupWindow f7274a;

    /* JADX INFO: renamed from: aa */
    private FrameLayout f7275aa;

    /* JADX INFO: renamed from: ab */
    private ViewOnClickListenerC1813ix f7276ab;

    /* JADX INFO: renamed from: b */
    PopupWindow f7277b;

    /* JADX INFO: renamed from: c */
    PopupWindow f7278c;

    /* JADX INFO: renamed from: d */
    CommentBean f7279d;

    /* JADX INFO: renamed from: f */
    List<CommentBean.Cont.C1209D3> f7280f;

    /* JADX INFO: renamed from: g */
    String f7281g;

    /* JADX INFO: renamed from: h */
    View f7282h;

    /* JADX INFO: renamed from: i */
    EditText f7283i;

    /* JADX INFO: renamed from: l */
    NestedScrollView f7284l;

    /* JADX INFO: renamed from: m */
    TextView f7285m;

    /* JADX INFO: renamed from: n */
    LinearLayout f7286n;

    /* JADX INFO: renamed from: o */
    private JZVideoPlayerStandard f7287o;

    /* JADX INFO: renamed from: q */
    private ImageView f7289q;

    /* JADX INFO: renamed from: r */
    private ImageView f7290r;

    /* JADX INFO: renamed from: s */
    private ImageView f7291s;

    /* JADX INFO: renamed from: t */
    private ImageView f7292t;

    /* JADX INFO: renamed from: u */
    private ImageView f7293u;

    /* JADX INFO: renamed from: v */
    private TextView f7294v;

    /* JADX INFO: renamed from: w */
    private TextView f7295w;

    /* JADX INFO: renamed from: x */
    private TextView f7296x;

    /* JADX INFO: renamed from: y */
    private TextView f7297y;

    /* JADX INFO: renamed from: z */
    private RelativeLayout f7298z;

    /* JADX INFO: renamed from: p */
    private final String f7288p = "Video_detail_Activity";

    /* JADX INFO: renamed from: X */
    private int f7271X = 0;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.video_detail1);
        this.f7257J = (LinearLayout) findViewById(R.id.weixin);
        this.f7258K = (LinearLayout) findViewById(R.id.friends);
        this.f7259L = (LinearLayout) findViewById(R.id.qq);
        this.f7260M = (LinearLayout) findViewById(R.id.qqkj);
        m7669d();
        akd.m1706a().m1719a(this);
        this.f7286n = (LinearLayout) findViewById(R.id.layout_bottom);
        this.f7270W = (LinearLayout) findViewById(R.id.layout_replay);
        this.f7264Q = (ImageView) findViewById(R.id.detail_more);
        this.f7256I = (RelativeLayout) findViewById(R.id.layout_palyvideo);
        this.f7253F = new ProgressDialogC1809it(this, false);
        this.f7261N = (ImageView) findViewById(R.id.bottom_comment);
        this.f7262O = (ImageView) findViewById(R.id.bottom_contion);
        this.f7263P = (ImageView) findViewById(R.id.bottom_share);
        this.f7293u = (ImageView) findViewById(R.id.img_AD);
        this.f7254G = (RelativeLayout) findViewById(R.id.layout_AD);
        this.f7255H = (RelativeLayout) findViewById(R.id.layout_end_share);
        this.f7297y = (TextView) findViewById(R.id.like_count);
        this.f7284l = (NestedScrollView) findViewById(R.id.mScroll);
        this.f7284l.smoothScrollTo(0, 0);
        this.f7248A = (RelativeLayout) findViewById(R.id.layout_isgood);
        this.f7298z = (RelativeLayout) findViewById(R.id.layout_contion);
        this.f7249B = (RelativeLayout) findViewById(R.id.layout_share);
        this.f7292t = (ImageView) findViewById(R.id.isgood_detail);
        this.f7287o = (JZVideoPlayerStandard) findViewById(R.id.videoplayer_detail);
        this.f7289q = (ImageView) findViewById(R.id.back_video);
        this.f7294v = (TextView) findViewById(R.id.look_count);
        this.f7290r = (ImageView) findViewById(R.id.person_img);
        this.f7295w = (TextView) findViewById(R.id.userName_detail);
        this.f7291s = (ImageView) findViewById(R.id.iscontion);
        this.f7296x = (TextView) findViewById(R.id.title_detail);
        this.f7251D = (TextView) findViewById(R.id.edtext);
        this.f7250C = new C1874ld();
        int i = getIntent().getExtras().getInt("bean_index");
        if (i == 0) {
            this.f7265R = ((Video_msg_Bean.C1216d2) getIntent().getSerializableExtra("bean")).f7437ID;
        } else if (i == 1) {
            this.f7265R = ((MymsgListBean.My_video_msgBean) getIntent().getSerializableExtra("bean")).VideoID;
        } else if (i == 2) {
            this.f7265R = ((MyvideoBean.C1210d2) getIntent().getSerializableExtra("bean")).f7417ID;
        }
        this.f7271X = getWindow().getDecorView().getHeight();
        getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                Rect rect = new Rect();
                Video_detail_Activity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                if (i5 == 0 || i9 == 0 || i5 - rect.bottom > 0 || !Video_detail_Activity.this.f7252E.isShowing()) {
                    return;
                }
                Video_detail_Activity.this.f7252E.dismiss();
            }
        });
        this.f7276ab = new ViewOnClickListenerC1813ix(this);
        this.f7275aa = (FrameLayout) findViewById(R.id.fl_content_detail);
        this.f7275aa.addView(this.f7276ab.m9832a(this.f7275aa));
        this.f7275aa.setVisibility(8);
    }

    /* JADX INFO: renamed from: c */
    public void m7668c() {
        this.f7253F.show();
    }

    /* JADX INFO: renamed from: d */
    public void m7669d() {
        this.f7272Y = (RecyclerView) findViewById(R.id.mrecycler);
        this.f7272Y.setLayoutManager(new LinearLayoutManager(this));
        this.f7272Y.setNestedScrollingEnabled(false);
        this.f7272Y.setHasFixedSize(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() throws Throwable {
        super.onResume();
        this.f7250C.m10236l(this.f7265R);
    }

    /* JADX INFO: renamed from: l */
    private void m7665l() {
        this.f7252E = new PopupWindow();
        this.f7282h = getLayoutInflater().inflate(R.layout.popwinds_input, (ViewGroup) null);
        this.f7252E.setWidth(-1);
        this.f7252E.setHeight(-2);
        this.f7252E.setBackgroundDrawable(new BitmapDrawable());
        this.f7252E.setFocusable(true);
        this.f7252E.setOutsideTouchable(true);
        this.f7252E.setContentView(this.f7282h);
        this.f7283i = (EditText) this.f7282h.findViewById(R.id.edtext_pop);
        this.f7285m = (TextView) this.f7282h.findViewById(R.id.post);
        this.f7285m.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.m7668c();
                Video_detail_Activity.this.f7281g = Video_detail_Activity.this.f7283i.getText().toString();
                Video_detail_Activity.this.f7250C.m10215d(Video_detail_Activity.this.f7265R, Video_detail_Activity.f7245e, Video_detail_Activity.this.f7281g);
                Video_detail_Activity.this.f7252E.dismiss();
                Video_detail_Activity.f7245e = null;
                Video_detail_Activity.f7246j = null;
            }
        });
        this.f7283i.setFocusable(true);
        this.f7283i.setFocusableInTouchMode(true);
        this.f7252E.setSoftInputMode(16);
        final InputMethodManager inputMethodManager = (InputMethodManager) this.f7282h.getContext().getSystemService("input_method");
        inputMethodManager.toggleSoftInput(0, 2);
        this.f7252E.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.14
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                if (inputMethodManager.isActive()) {
                    inputMethodManager.toggleSoftInput(1, 2);
                }
            }
        });
        this.f7252E.setContentView(this.f7282h);
        this.f7252E.showAtLocation(this.f7282h, 80, 0, 0);
        if (TextUtils.isEmpty(f7246j)) {
            return;
        }
        if (f7246j.contains(getString(R.string.reply))) {
            this.f7283i.setHint(f7246j);
            return;
        }
        this.f7283i.setHint(getString(R.string.reply) + " " + f7246j);
    }

    /* JADX INFO: renamed from: e */
    public void m7670e() {
        this.f7253F.dismiss();
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 72) {
            int i = c1873lc.f11065b;
            switch (i) {
                case -1:
                    C1900mc.m10475c("TAG", "视频帖子详情服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "视频帖子详情失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "视频帖子详情:");
                    this.f7279d = (CommentBean) new Gson().fromJson(c1873lc.f11064a, CommentBean.class);
                    this.f7268U = this.f7279d.errDesc.VideoInfo.Title;
                    this.f7269V = this.f7279d.errDesc.VideoInfo.Thumb;
                    this.f7297y.setText(this.f7279d.errDesc.VideoInfo.LikeCount);
                    this.f7266S = this.f7279d.errDesc.VideoInfo.UserID;
                    this.f7267T = C1902me.m10480a(this);
                    Log.e("Video_detail_Activity", "MyID: " + this.f7267T);
                    Log.e("Video_detail_Activity", "UserID: " + this.f7266S);
                    if (this.f7267T.equals(this.f7266S)) {
                        f7247k = 1;
                        Log.e("Video_detail_Activity", "UserID: 此视频是自己发布");
                    } else {
                        Log.e("Video_detail_Activity", "UserID: 不是自己发布");
                        f7247k = 0;
                    }
                    this.f7295w.setText(this.f7279d.errDesc.VideoInfo.UserName);
                    this.f7294v.setText(this.f7279d.errDesc.VideoInfo.Views);
                    this.f7296x.setText(this.f7279d.errDesc.VideoInfo.Title);
                    C2253xu.m12305a((Context) this).m12312a(this.f7279d.errDesc.VideoInfo.Thumb).m12348a(this.f7287o.f5445ac);
                    this.f7287o.setUp(this.f7279d.errDesc.VideoInfo.Url, 0, "");
                    this.f7287o.m5835e();
                    if ((this.f7279d.errDesc.VideoInfo.IsCollection != null ? Integer.parseInt(this.f7279d.errDesc.VideoInfo.IsCollection) : 0) == 1) {
                        this.f7291s.setSelected(true);
                        this.f7262O.setSelected(true);
                    }
                    if (this.f7279d.errDesc.VideoInfo.Thumb != null) {
                        C2253xu.m12305a((Context) this).m12312a(this.f7279d.errDesc.VideoInfo.Icon).m12348a(this.f7290r);
                    }
                    if (this.f7279d.errDesc.VideoInfo.IsCollection.equals("1")) {
                        this.f7291s.setSelected(true);
                        this.f7262O.setSelected(true);
                    }
                    if (this.f7279d.errDesc.VideoInfo.IsLiked.equals("1")) {
                        this.f7292t.setSelected(true);
                    }
                    Log.e("TAG", "详情: " + this.f7279d.errDesc.VideoInfo.LikeCount);
                    if (this.f7279d.errDesc.f7413AD != null) {
                        this.f7254G.setVisibility(0);
                        C2253xu.m12305a((Context) this).m12312a(this.f7279d.errDesc.f7413AD.Banner).m12348a(this.f7293u);
                    }
                    m7671f();
                    m7670e();
                    break;
                default:
                    switch (i) {
                        case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                            m7667a(false);
                            break;
                        case PointerIconCompat.TYPE_HAND /* 1002 */:
                            m7674i();
                            break;
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 74) {
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("TAG", "回复服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("TAG", "回复失败");
                    break;
                case 1:
                    C1900mc.m10475c("TAG", "回复成功");
                    this.f7250C.m10236l(this.f7265R);
                    if (this.f7275aa.getVisibility() == 0 && this.f7276ab != null) {
                        ChildResponseListBean childResponseListBean = new ChildResponseListBean();
                        childResponseListBean.UserName = MyApplication.m7738a().m7745e().errDesc.UserName;
                        childResponseListBean.Content = this.f7281g;
                        ChildResponseListBean childResponseListBean2 = new ChildResponseListBean();
                        childResponseListBean2.UserName = f7246j;
                        childResponseListBean.Quote = childResponseListBean2;
                        this.f7276ab.m9833a(childResponseListBean);
                        break;
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 999) {
            if (c1873lc.f11065b != 1) {
                return;
            }
            f7246j = c1873lc.f11064a;
            if (f7246j.contains(getString(R.string.reply))) {
                this.f7251D.setHint(f7246j);
                return;
            }
            this.f7251D.setHint(getString(R.string.reply) + " " + f7246j);
            return;
        }
        if (c1873lc.f11072i == 998) {
            if (c1873lc.f11065b != 1) {
                return;
            }
            f7245e = c1873lc.f11064a;
        } else if (c1873lc.f11072i == 997) {
            int i2 = c1873lc.f11065b;
        } else if (c1873lc.f11072i == 85) {
            switch (c1873lc.f11065b) {
                case 1:
                    Log.e("Video_detail_Activity", "DELETE_COMMENT: 删除成功 ");
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m7667a(boolean z) {
        if (z) {
            this.f7275aa.setAnimation(AnimationUtils.loadAnimation(this, R.anim.down_to_up));
            this.f7275aa.setVisibility(0);
        } else {
            this.f7275aa.setAnimation(AnimationUtils.loadAnimation(this, R.anim.up_to_down));
            this.f7275aa.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: f */
    public void m7671f() {
        CommentBean.Cont cont = this.f7279d.errDesc;
        this.f7280f = new ArrayList();
        for (int i = 0; i < cont.ResponseList.size(); i++) {
            CommentBean.Cont.C1209D3 c1209d3 = cont.ResponseList.get(i);
            if (c1209d3 != null && c1209d3.UserName != null && c1209d3.UserID != null) {
                this.f7280f.add(c1209d3);
            }
        }
        Log.e("TAG", "lz_list: " + this.f7280f.size());
        this.f7273Z = new C1817ja(this, this.f7280f, this.f7265R);
        this.f7273Z.m9844a(this);
        this.f7272Y.setAdapter(this.f7273Z);
        this.f7272Y.m3757a(0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7257J.setOnClickListener(this);
        this.f7258K.setOnClickListener(this);
        this.f7259L.setOnClickListener(this);
        this.f7260M.setOnClickListener(this);
        this.f7270W.setOnClickListener(this);
        this.f7262O.setOnClickListener(this);
        this.f7254G.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.15
            /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
            /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
            @Override // android.view.View.OnClickListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void onClick(android.view.View r4) {
                /*
                    r3 = this;
                    com.coollang.tennis.activity.Video_detail_Activity r4 = com.coollang.tennis.activity.Video_detail_Activity.this
                    com.coollang.tennis.beans.CommentBean r4 = r4.f7279d
                    com.coollang.tennis.beans.CommentBean$Cont r4 = r4.errDesc
                    com.coollang.tennis.beans.CommentBean$Cont$D1 r4 = r4.f7413AD
                    java.lang.String r4 = r4.Type
                    com.coollang.tennis.activity.Video_detail_Activity r0 = com.coollang.tennis.activity.Video_detail_Activity.this
                    com.coollang.tennis.beans.CommentBean r0 = r0.f7279d
                    com.coollang.tennis.beans.CommentBean$Cont r0 = r0.errDesc
                    com.coollang.tennis.beans.CommentBean$Cont$D1 r0 = r0.f7413AD
                    java.lang.String r0 = r0.Url
                    int r1 = r4.hashCode()
                    switch(r1) {
                        case 48: goto L30;
                        case 49: goto L26;
                        case 50: goto L1c;
                        default: goto L1b;
                    }
                L1b:
                    goto L3a
                L1c:
                    java.lang.String r1 = "2"
                    boolean r4 = r4.equals(r1)
                    if (r4 == 0) goto L3a
                    r4 = 2
                    goto L3b
                L26:
                    java.lang.String r1 = "1"
                    boolean r4 = r4.equals(r1)
                    if (r4 == 0) goto L3a
                    r4 = 1
                    goto L3b
                L30:
                    java.lang.String r1 = "0"
                    boolean r4 = r4.equals(r1)
                    if (r4 == 0) goto L3a
                    r4 = 0
                    goto L3b
                L3a:
                    r4 = -1
                L3b:
                    switch(r4) {
                        case 0: goto L3f;
                        case 1: goto L55;
                        case 2: goto L55;
                        default: goto L3e;
                    }
                L3e:
                    goto L55
                L3f:
                    android.content.Intent r4 = new android.content.Intent
                    r4.<init>()
                    com.coollang.tennis.activity.Video_detail_Activity r1 = com.coollang.tennis.activity.Video_detail_Activity.this
                    java.lang.Class<com.coollang.tennis.activity.WebviewActivity> r2 = com.coollang.tennis.activity.WebviewActivity.class
                    r4.setClass(r1, r2)
                    java.lang.String r1 = "url"
                    r4.putExtra(r1, r0)
                    com.coollang.tennis.activity.Video_detail_Activity r0 = com.coollang.tennis.activity.Video_detail_Activity.this
                    r0.startActivity(r4)
                L55:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.coollang.tennis.activity.Video_detail_Activity.ViewOnClickListenerC117715.onClick(android.view.View):void");
            }
        });
        this.f7264Q.setOnClickListener(this);
        this.f7263P.setOnClickListener(this);
        this.f7261N.setOnClickListener(this);
        this.f7298z.setOnClickListener(this);
        this.f7249B.setOnClickListener(this);
        this.f7289q.setOnClickListener(this);
        this.f7248A.setOnClickListener(this);
        this.f7251D.setOnClickListener(this);
        this.f7287o.setJZpalyinglistenr(new InterfaceC1805ip() { // from class: com.coollang.tennis.activity.Video_detail_Activity.16
            @Override // p000.InterfaceC1805ip
            /* JADX INFO: renamed from: a */
            public void mo7675a() {
                Log.e("Video_detail_Activity", "start: 开始播放");
                Video_detail_Activity.this.f7255H.setVisibility(8);
                Video_detail_Activity.this.f7287o.setAlpha(1.0f);
            }

            @Override // p000.InterfaceC1805ip
            /* JADX INFO: renamed from: b */
            public void mo7676b() {
                Log.e("Video_detail_Activity", "pause: 暂停播放");
            }

            @Override // p000.InterfaceC1805ip
            /* JADX INFO: renamed from: c */
            public void mo7677c() {
                Log.e("Video_detail_Activity", "compelted: 播放完成");
                Video_detail_Activity.this.f7255H.setVisibility(0);
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_video /* 2131296378 */:
                JZVideoPlayer.m5818d();
                JZVideoPlayer.m5813a();
                finish();
                break;
            case R.id.bottom_comment /* 2131296434 */:
                this.f7284l.smoothScrollTo(0, 0);
                break;
            case R.id.bottom_contion /* 2131296435 */:
                if (this.f7262O.isSelected()) {
                    this.f7262O.setSelected(false);
                    this.f7291s.setSelected(false);
                    this.f7250C.m10244p(this.f7265R);
                } else {
                    this.f7250C.m10238m(this.f7265R);
                    this.f7262O.setSelected(true);
                    this.f7291s.setSelected(true);
                }
                break;
            case R.id.bottom_share /* 2131296444 */:
                m7672g();
                break;
            case R.id.detail_more /* 2131296525 */:
                m7673h();
                break;
            case R.id.edtext /* 2131296547 */:
                this.f7281g = null;
                f7245e = null;
                m7665l();
                break;
            case R.id.friends /* 2131296607 */:
                m7657a(WechatMoments.NAME, this.f7268U, this.f7265R);
                break;
            case R.id.layout_contion /* 2131296761 */:
                if (this.f7291s.isSelected()) {
                    this.f7250C.m10244p(this.f7265R);
                    this.f7291s.setSelected(false);
                    this.f7262O.setSelected(false);
                    Log.e("TAG", "取消收藏: ");
                } else {
                    Log.e("TAG", "收藏: ");
                    this.f7250C.m10238m(this.f7265R);
                    this.f7291s.setSelected(true);
                    this.f7262O.setSelected(true);
                }
                break;
            case R.id.layout_isgood /* 2131296764 */:
                if (this.f7292t.isSelected()) {
                    Log.e("TAG", "onClick: " + this.f7265R);
                    this.f7292t.setSelected(false);
                    this.f7250C.m10221f(this.f7265R, "0");
                    this.f7297y.setText(String.valueOf(Integer.parseInt(String.valueOf(this.f7297y.getText())) - 1));
                } else {
                    this.f7292t.setSelected(true);
                    this.f7250C.m10221f(this.f7265R, "1");
                    this.f7297y.setText(String.valueOf(Integer.parseInt(String.valueOf(this.f7297y.getText())) + 1));
                }
                break;
            case R.id.layout_replay /* 2131296772 */:
                Log.e("Video_detail_Activity", "重播: ");
                this.f7287o.m5859I();
                break;
            case R.id.layout_share /* 2131296773 */:
                m7672g();
                break;
            case R.id.qq /* 2131296966 */:
                m7657a(C0874QQ.NAME, this.f7268U, this.f7265R);
                break;
            case R.id.qqkj /* 2131296967 */:
                m7657a(QZone.NAME, this.f7268U, this.f7265R);
                break;
            case R.id.weixin /* 2131297495 */:
                m7657a(Wechat.NAME, this.f7268U, this.f7265R);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m7657a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        C1874ld c1874ld = this.f7250C;
        sb.append("http://tennis.coollang.com/");
        sb.append(getString(R.string.share_video_url));
        sb.append(str3);
        String string = sb.toString();
        Log.e("Video_detail_Activity", "showShareDialog: " + string);
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(getString(R.string.app_name));
        onekeyShare.setText(str2);
        onekeyShare.setTitleUrl(string);
        onekeyShare.setUrl(string);
        onekeyShare.setSiteUrl(string);
        onekeyShare.setImagePath(C1890lt.m10438a("logo", ((BitmapDrawable) getResources().getDrawable(R.drawable.ic_logo)).getBitmap()));
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this);
    }

    /* JADX INFO: renamed from: g */
    public void m7672g() {
        this.f7274a = new PopupWindow(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_share_popwindow_one, (ViewGroup) null);
        RelativeLayout relativeLayout = (RelativeLayout) viewInflate.findViewById(R.id.parent);
        RelativeLayout relativeLayout2 = (RelativeLayout) viewInflate.findViewById(R.id.layout_cancel);
        relativeLayout.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7274a.dismiss();
            }
        });
        this.f7274a.setWidth(-1);
        this.f7274a.setHeight(-2);
        this.f7274a.setBackgroundDrawable(new BitmapDrawable());
        this.f7274a.setFocusable(false);
        this.f7274a.setOutsideTouchable(true);
        this.f7274a.setTouchable(true);
        this.f7274a.setContentView(viewInflate);
        this.f7274a.showAtLocation(viewInflate, 17, 0, 0);
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(R.id.friends);
        RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(R.id.weixin);
        RadioButton radioButton3 = (RadioButton) viewInflate.findViewById(R.id.qq);
        ((RadioButton) viewInflate.findViewById(R.id.qqkj)).setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        radioButton.setOnClickListener(this);
        relativeLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.18
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7274a.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: h */
    public void m7673h() {
        View viewInflate;
        this.f7277b = new PopupWindow(this);
        if (f7247k == 1) {
            viewInflate = getLayoutInflater().inflate(R.layout.layout_share_popwindow_two_myself, (ViewGroup) null);
        } else {
            viewInflate = getLayoutInflater().inflate(R.layout.layout_share_popwindow_two, (ViewGroup) null);
        }
        RadioButton radioButton = (RadioButton) viewInflate.findViewById(R.id.delete);
        if (radioButton != null) {
            radioButton.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.19
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Video_detail_Activity.this.f7250C.m10246q(Video_detail_Activity.this.f7265R);
                    Video_detail_Activity.this.finish();
                }
            });
        }
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.20
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7277b.dismiss();
            }
        });
        this.f7277b.setWidth(-1);
        this.f7277b.setHeight(-2);
        this.f7277b.setBackgroundDrawable(new BitmapDrawable());
        this.f7277b.setFocusable(false);
        this.f7277b.setOutsideTouchable(true);
        this.f7277b.setTouchable(true);
        this.f7277b.setContentView(viewInflate);
        this.f7277b.showAtLocation(viewInflate, 17, 0, 0);
        final RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(R.id.contion);
        RadioButton radioButton3 = (RadioButton) viewInflate.findViewById(R.id.weixin);
        RadioButton radioButton4 = (RadioButton) viewInflate.findViewById(R.id.friends);
        RadioButton radioButton5 = (RadioButton) viewInflate.findViewById(R.id.qq);
        RadioButton radioButton6 = (RadioButton) viewInflate.findViewById(R.id.qqkj);
        radioButton3.setOnClickListener(this);
        radioButton4.setOnClickListener(this);
        radioButton5.setOnClickListener(this);
        radioButton6.setOnClickListener(this);
        if (this.f7291s.isSelected()) {
            radioButton2.setSelected(true);
        } else {
            radioButton2.setSelected(false);
        }
        radioButton2.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!radioButton2.isSelected()) {
                    Video_detail_Activity.this.f7250C.m10238m(Video_detail_Activity.this.f7265R);
                    radioButton2.setSelected(true);
                    Video_detail_Activity.this.f7291s.setSelected(true);
                } else {
                    radioButton2.setSelected(false);
                    Video_detail_Activity.this.f7291s.setSelected(false);
                    Video_detail_Activity.this.f7250C.m10244p(Video_detail_Activity.this.f7265R);
                }
            }
        });
        final RadioButton radioButton7 = (RadioButton) viewInflate.findViewById(R.id.good);
        if (this.f7292t.isSelected()) {
            radioButton7.setSelected(true);
        } else {
            radioButton7.setSelected(false);
        }
        radioButton7.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!radioButton7.isSelected()) {
                    Video_detail_Activity.this.f7292t.setSelected(true);
                    Video_detail_Activity.this.f7250C.m10221f(Video_detail_Activity.this.f7265R, "1");
                    radioButton7.setSelected(true);
                    Video_detail_Activity.this.f7297y.setText(String.valueOf(Integer.parseInt(String.valueOf(Video_detail_Activity.this.f7297y.getText())) + 1));
                    return;
                }
                radioButton7.setSelected(false);
                Video_detail_Activity.this.f7292t.setSelected(false);
                Video_detail_Activity.this.f7250C.m10221f(Video_detail_Activity.this.f7265R, "0");
                Video_detail_Activity.this.f7297y.setText(String.valueOf(Integer.parseInt(String.valueOf(Video_detail_Activity.this.f7297y.getText())) - 1));
            }
        });
        ((RadioButton) viewInflate.findViewById(R.id.report)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7277b.dismiss();
                Video_detail_Activity.this.m7674i();
            }
        });
        ((RelativeLayout) viewInflate.findViewById(R.id.layout_cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7277b.dismiss();
            }
        });
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onBackPressed() {
        if (JZVideoPlayer.m5816b()) {
            Log.e("TAG", "onBackPressed: ");
        } else {
            super.onBackPressed();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        akd.m1706a().m1721b(this);
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        JZVideoPlayer.m5818d();
        JZVideoPlayer.m5813a();
    }

    /* JADX INFO: renamed from: i */
    public void m7674i() {
        this.f7278c = new PopupWindow(this);
        View viewInflate = getLayoutInflater().inflate(R.layout.layout_pop_report, (ViewGroup) null);
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
        this.f7278c.setWidth(-1);
        this.f7278c.setHeight(-2);
        this.f7278c.setBackgroundDrawable(new BitmapDrawable());
        this.f7278c.setFocusable(false);
        this.f7278c.setOutsideTouchable(true);
        this.f7278c.setTouchable(true);
        this.f7278c.setContentView(viewInflate);
        this.f7278c.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.report1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.report2);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.report3);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.report4);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.report5);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.cancel);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7250C.m10227h("1", Video_detail_Activity.this.f7265R);
                Toast.makeText(Video_detail_Activity.this, "举报成功", 0).show();
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7250C.m10227h("2", Video_detail_Activity.this.f7265R);
                Toast.makeText(Video_detail_Activity.this, "举报成功", 0).show();
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7250C.m10227h("3", Video_detail_Activity.this.f7265R);
                Toast.makeText(Video_detail_Activity.this, "举报成功", 0).show();
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7250C.m10227h("4", Video_detail_Activity.this.f7265R);
                Toast.makeText(Video_detail_Activity.this, "举报成功", 0).show();
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7250C.m10227h("5", Video_detail_Activity.this.f7265R);
                Toast.makeText(Video_detail_Activity.this, "举报成功", 0).show();
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.Video_detail_Activity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                Video_detail_Activity.this.f7278c.dismiss();
            }
        });
    }

    @Override // p000.InterfaceC1881lk
    /* JADX INFO: renamed from: a */
    public void mo7666a(CommentBean.Cont.C1209D3 c1209d3) {
        m7667a(true);
        this.f7276ab.m9834a(c1209d3);
    }
}
