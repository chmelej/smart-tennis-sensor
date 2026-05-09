package com.coollang.tennis.activity;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.Custom.ListViewForScrollView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.ChildResponseListBean;
import com.coollang.tennis.beans.CommentBean;
import com.coollang.tennis.beans.UserInfoBean;
import com.thinkcool.circletextimageview.CircleTextImageView;
import p000.C1833jq;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1912mk;
import p000.C2253xu;
import p000.ProgressDialogC1809it;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class DetailCommentActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: k */
    public static String f6303k;

    /* JADX INFO: renamed from: a */
    C1833jq f6304a;

    /* JADX INFO: renamed from: b */
    TextView f6305b;

    /* JADX INFO: renamed from: c */
    TextView f6306c;

    /* JADX INFO: renamed from: d */
    TextView f6307d;

    /* JADX INFO: renamed from: e */
    TextView f6308e;

    /* JADX INFO: renamed from: f */
    CircleTextImageView f6309f;

    /* JADX INFO: renamed from: g */
    LinearLayout f6310g;

    /* JADX INFO: renamed from: h */
    ImageView f6311h;

    /* JADX INFO: renamed from: i */
    ImageView f6312i;

    /* JADX INFO: renamed from: j */
    ListViewForScrollView f6313j;

    /* JADX INFO: renamed from: l */
    String f6314l;

    /* JADX INFO: renamed from: m */
    String f6315m;

    /* JADX INFO: renamed from: n */
    View f6316n;

    /* JADX INFO: renamed from: o */
    EditText f6317o;

    /* JADX INFO: renamed from: p */
    CommentBean.Cont.C1209D3 f6318p;

    /* JADX INFO: renamed from: q */
    LayoutInflater f6319q;

    /* JADX INFO: renamed from: r */
    private C1874ld f6320r;

    /* JADX INFO: renamed from: s */
    private ImageView f6321s;

    /* JADX INFO: renamed from: t */
    private PopupWindow f6322t;

    /* JADX INFO: renamed from: u */
    private PopupWindow f6323u;

    /* JADX INFO: renamed from: v */
    private PopupWindow f6324v;

    /* JADX INFO: renamed from: w */
    private String f6325w;

    /* JADX INFO: renamed from: x */
    private ProgressDialogC1809it f6326x;

    /* JADX INFO: renamed from: y */
    private int f6327y = 0;

    /* JADX INFO: renamed from: z */
    private String f6328z = "DetailCommentActivity";

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_detail_comment);
        this.f6327y = getWindow().getDecorView().getHeight();
        getWindow().getDecorView().addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.1
            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                Rect rect = new Rect();
                DetailCommentActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                if (i4 == 0 || i8 == 0 || i4 - rect.bottom > 0 || !DetailCommentActivity.this.f6322t.isShowing()) {
                    return;
                }
                DetailCommentActivity.this.f6322t.dismiss();
            }
        });
        this.f6318p = (CommentBean.Cont.C1209D3) getIntent().getSerializableExtra("bean");
        this.f6325w = getIntent().getExtras().getString("Video_ID");
        this.f6320r = new C1874ld();
        akd.m1706a().m1719a(this);
        this.f6320r.m10243p();
        this.f6313j = (ListViewForScrollView) findViewById(R.id.Child_listview);
        this.f6304a = new C1833jq(this, this.f6318p, true);
        this.f6313j.setAdapter((ListAdapter) this.f6304a);
        this.f6305b = (TextView) findViewById(R.id.usrname);
        this.f6306c = (TextView) findViewById(R.id.textconntent);
        this.f6307d = (TextView) findViewById(R.id.time_comment);
        this.f6310g = (LinearLayout) findViewById(R.id.commnet_layout_isgood);
        this.f6309f = (CircleTextImageView) findViewById(R.id.per_img);
        this.f6311h = (ImageView) findViewById(R.id.Comment_more);
        this.f6312i = (ImageView) findViewById(R.id.isgood_comment);
        this.f6308e = (TextView) findViewById(R.id.comment_like_count);
        this.f6326x = new ProgressDialogC1809it(this, false);
        this.f6321s = (ImageView) findViewById(R.id.back);
        if (this.f6318p != null) {
            Log.e("TAG", "ResponseID: " + this.f6318p.ResponseID);
            this.f6305b.setText(this.f6318p.UserName);
            if (this.f6318p.UserName != null) {
                this.f6305b.setText(this.f6318p.UserName);
            }
            if (this.f6318p.Content != null) {
                this.f6306c.setText(this.f6318p.Content);
            }
            this.f6307d.setText(C1912mk.m10534a(this.f6318p.CreateTime != null ? Long.parseLong(this.f6318p.CreateTime) : 0L));
            if (this.f6318p.Icon != null && !this.f6318p.Icon.equals("")) {
                C2253xu.m12305a((Context) this).m12312a(this.f6318p.Icon).m12348a(this.f6309f);
            }
            int i = this.f6318p.IsLiked != null ? Integer.parseInt(this.f6318p.IsLiked) : 0;
            int i2 = this.f6318p.LikeCount != null ? Integer.parseInt(this.f6318p.LikeCount) : 0;
            if (i == 1) {
                this.f6312i.setSelected(true);
            }
            if (i2 != 0) {
                this.f6308e.setText(String.valueOf(i2));
            }
            this.f6322t = new PopupWindow();
            this.f6306c.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.9
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str = "回复  " + DetailCommentActivity.this.f6318p.UserName;
                    String str2 = DetailCommentActivity.this.f6318p.ResponseID;
                    akd.m1706a().m1722c(new C1873lc(str, 1, 999));
                    akd.m1706a().m1722c(new C1873lc(str2, 1, 998));
                }
            });
            this.f6310g.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.10
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (DetailCommentActivity.this.f6312i.isSelected()) {
                        DetailCommentActivity.this.f6320r.m10224g(DetailCommentActivity.this.f6318p.ResponseID, "0");
                        DetailCommentActivity.this.f6312i.setSelected(false);
                    } else {
                        DetailCommentActivity.this.f6320r.m10224g(DetailCommentActivity.this.f6318p.ResponseID, "1");
                        DetailCommentActivity.this.f6312i.setSelected(true);
                    }
                }
            });
            this.f6311h.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DetailCommentActivity.this.m6907a(DetailCommentActivity.this.f6325w, DetailCommentActivity.this.f6318p.ResponseID);
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6907a(final String str, final String str2) {
        View viewInflate;
        this.f6323u = new PopupWindow(this);
        this.f6319q = LayoutInflater.from(this);
        if (Video_detail_Activity.f7247k == 1) {
            viewInflate = this.f6319q.inflate(R.layout.pop_to_report_myself, (ViewGroup) null);
        } else {
            viewInflate = this.f6319q.inflate(R.layout.pop_to_report, (ViewGroup) null);
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.delete_comment);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                }
            });
        }
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6323u.dismiss();
            }
        });
        this.f6323u.setWidth(-1);
        this.f6323u.setHeight(-2);
        this.f6323u.setBackgroundDrawable(new BitmapDrawable());
        this.f6323u.setFocusable(false);
        this.f6323u.setOutsideTouchable(true);
        this.f6323u.setTouchable(true);
        this.f6323u.setContentView(viewInflate);
        this.f6323u.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.cancel);
        ((TextView) viewInflate.findViewById(R.id.report)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6323u.dismiss();
                DetailCommentActivity.this.m6908b(str, str2);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6323u.dismiss();
            }
        });
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 999) {
            if (c1873lc.f11065b == 1) {
                C1900mc.m10475c("TAG", "目标信息");
                f6303k = c1873lc.f11064a;
                C1900mc.m10475c("TAG", "Hinttext" + f6303k);
                if (!this.f6322t.isShowing()) {
                    m6903c();
                }
            }
        } else if (c1873lc.f11072i == 998 && c1873lc.f11065b == 1) {
            C1900mc.m10475c("TAG", "目标信息");
            this.f6315m = c1873lc.f11064a;
            C1900mc.m10475c("TAG", "Tagget_ResponseID" + this.f6315m);
            if (!this.f6322t.isShowing()) {
                m6903c();
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
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6908b(final String str, final String str2) {
        this.f6324v = new PopupWindow(this);
        View viewInflate = this.f6319q.inflate(R.layout.layout_pop_report, (ViewGroup) null);
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
        this.f6324v.setWidth(-1);
        this.f6324v.setHeight(-2);
        this.f6324v.setBackgroundDrawable(new BitmapDrawable());
        this.f6324v.setFocusable(false);
        this.f6324v.setOutsideTouchable(true);
        this.f6324v.setTouchable(true);
        this.f6324v.setContentView(viewInflate);
        this.f6324v.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.report1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.report2);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.report3);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.report4);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.report5);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.cancel);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6320r.m10195a("1", str, str2, "1");
                Toast.makeText(DetailCommentActivity.this, "举报成功", 0).show();
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6320r.m10195a("2", str, str2, "2");
                Toast.makeText(DetailCommentActivity.this, "举报成功", 0).show();
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6320r.m10195a("3", str, str2, "3");
                Toast.makeText(DetailCommentActivity.this, "举报成功", 0).show();
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6320r.m10195a("4", str, str2, "4");
                Toast.makeText(DetailCommentActivity.this, "举报成功", 0).show();
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6320r.m10195a("5", str, str2, "5");
                Toast.makeText(DetailCommentActivity.this, "举报成功", 0).show();
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6324v.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: c */
    private void m6903c() {
        Log.e("TAG", "content: " + this.f6314l);
        Log.e("TAG", "Tagget_ResponseID: " + this.f6315m);
        Log.e("TAG", "Hinttext: " + f6303k);
        this.f6322t = new PopupWindow();
        this.f6322t.setAnimationStyle(R.style.MyPopupWindow_anim_style);
        this.f6316n = getLayoutInflater().inflate(R.layout.popwinds_input, (ViewGroup) null);
        this.f6322t.setWidth(-1);
        this.f6322t.setHeight(-2);
        this.f6322t.setBackgroundDrawable(new BitmapDrawable());
        this.f6322t.setFocusable(true);
        this.f6322t.setOutsideTouchable(true);
        this.f6322t.setContentView(this.f6316n);
        this.f6317o = (EditText) this.f6316n.findViewById(R.id.edtext_pop);
        ((TextView) this.f6316n.findViewById(R.id.post)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.DetailCommentActivity.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DetailCommentActivity.this.f6314l = String.valueOf(DetailCommentActivity.this.f6317o.getText());
                DetailCommentActivity.this.f6320r.m10215d(DetailCommentActivity.this.f6325w, DetailCommentActivity.this.f6315m, DetailCommentActivity.this.f6314l);
                Log.e(DetailCommentActivity.this.f6328z, "Tagget_ResponseID: " + DetailCommentActivity.this.f6315m);
                Log.e(DetailCommentActivity.this.f6328z, "Video_ID: " + DetailCommentActivity.this.f6325w);
                Log.e(DetailCommentActivity.this.f6328z, "content: " + DetailCommentActivity.this.f6314l);
                DetailCommentActivity.this.f6322t.dismiss();
                ChildResponseListBean childResponseListBean = new ChildResponseListBean();
                childResponseListBean.Content = DetailCommentActivity.this.f6314l;
                UserInfoBean userInfoBeanM7745e = MyApplication.m7738a().m7745e();
                String str = userInfoBeanM7745e.errDesc.Icon;
                childResponseListBean.UserName = userInfoBeanM7745e.errDesc.UserName;
                childResponseListBean.Icon = str;
                childResponseListBean.ParentID = DetailCommentActivity.this.f6315m;
                DetailCommentActivity.this.f6304a.m10009a(childResponseListBean);
                DetailCommentActivity.this.f6304a.notifyDataSetChanged();
            }
        });
        this.f6322t.showAtLocation(this.f6316n, 80, 0, 0);
        this.f6317o.setFocusable(true);
        this.f6317o.setFocusableInTouchMode(true);
        this.f6317o.setHint(f6303k);
        this.f6322t.setSoftInputMode(16);
        ((InputMethodManager) this.f6316n.getContext().getSystemService("input_method")).toggleSoftInput(0, 2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f6321s.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() != R.id.back) {
            return;
        }
        finish();
    }
}
