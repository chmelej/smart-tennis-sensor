package p000;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.RankingBean;
import com.coollang.tennis.widget.CircleImageView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import java.util.List;

/* JADX INFO: renamed from: jg */
/* JADX INFO: compiled from: RankAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1823jg extends RecyclerView.AbstractC0603a<RecyclerView.AbstractC0624v> {

    /* JADX INFO: renamed from: b */
    private Activity f10529b;

    /* JADX INFO: renamed from: d */
    private String f10531d;

    /* JADX INFO: renamed from: e */
    private List<RankingBean.errDesc.Rank> f10532e;

    /* JADX INFO: renamed from: f */
    private PopupWindow f10533f;

    /* JADX INFO: renamed from: g */
    private RankingBean f10534g;

    /* JADX INFO: renamed from: c */
    private int f10530c = -1;

    /* JADX INFO: renamed from: a */
    private final C1874ld f10528a = new C1874ld();

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: b */
    public int mo3870b(int i) {
        return i == 0 ? 0 : 1;
    }

    public C1823jg(Activity activity, String str, RankingBean rankingBean) {
        this.f10529b = activity;
        this.f10531d = str;
        this.f10534g = rankingBean;
        this.f10532e = rankingBean.errDesc.RankList;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public int mo3863a() {
        if (this.f10532e == null || this.f10532e.isEmpty()) {
            return 0;
        }
        if (this.f10532e.size() < 4) {
            return 1;
        }
        return this.f10532e.size() - 2;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public void mo3867a(RecyclerView.AbstractC0624v abstractC0624v, int i) {
        if (abstractC0624v instanceof c) {
            final c cVar = (c) abstractC0624v;
            cVar.f10577Q.setVisibility(8);
            cVar.f10578R.setVisibility(8);
            if (this.f10531d.equals("1")) {
                String str = this.f10532e.get(0).TotalCount;
                cVar.f10571K.setText(C1910mi.m10524a(str, str + " " + C1914mm.m10557b(R.string.times), 18, Color.parseColor("#ffffff")));
            } else {
                String str2 = this.f10532e.get(0).Score;
                cVar.f10571K.setText(C1910mi.m10524a(str2, str2 + " " + C1914mm.m10557b(R.string.score), 18, Color.parseColor("#ffffff")));
            }
            C2068qy.m11356a().m11360a(this.f10532e.get(0).Icon, cVar.f10574N);
            cVar.f10568H.setText(this.f10532e.get(0).UserName);
            cVar.f10564D.setText(this.f10532e.get(0).Address);
            cVar.f10561A.setText(this.f10532e.get(0).Likes);
            if (this.f10532e.get(0).IsLiked.contentEquals("1")) {
                cVar.f10561A.setChecked(true);
            }
            cVar.f10561A.setOnCheckedChangeListener(new a(this.f10532e.get(0).UserID));
            cVar.f10567G.setOnClickListener(new View.OnClickListener() { // from class: jg.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DialogC1864ku dialogC1864ku = new DialogC1864ku(C1823jg.this.f10529b, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(0)).UserID, cVar.f10561A, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(0)).Icon);
                    dialogC1864ku.requestWindowFeature(1);
                    dialogC1864ku.show();
                    dialogC1864ku.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                }
            });
            if (this.f10532e.size() >= 2) {
                cVar.f10577Q.setVisibility(0);
                if (this.f10531d.equals("1")) {
                    String str3 = this.f10532e.get(1).TotalCount;
                    cVar.f10572L.setText(C1910mi.m10524a(str3, str3 + " " + C1914mm.m10557b(R.string.times), 18, Color.parseColor("#ffffff")));
                } else {
                    String str4 = this.f10532e.get(1).Score;
                    cVar.f10572L.setText(C1910mi.m10524a(str4, str4 + " " + C1914mm.m10557b(R.string.score), 18, Color.parseColor("#ffffff")));
                }
                C2068qy.m11356a().m11360a(this.f10532e.get(1).Icon, cVar.f10575O);
                cVar.f10569I.setText(this.f10532e.get(1).UserName);
                cVar.f10565E.setText(this.f10532e.get(1).Address);
                cVar.f10562B.setText(this.f10532e.get(1).Likes);
                if (this.f10532e.get(1).IsLiked.contentEquals("1")) {
                    cVar.f10562B.setChecked(true);
                }
                cVar.f10562B.setOnCheckedChangeListener(new a(this.f10532e.get(1).UserID));
                cVar.f10577Q.setOnClickListener(new View.OnClickListener() { // from class: jg.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        DialogC1864ku dialogC1864ku = new DialogC1864ku(C1823jg.this.f10529b, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(1)).UserID, cVar.f10562B, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(1)).Icon);
                        dialogC1864ku.requestWindowFeature(1);
                        dialogC1864ku.show();
                        dialogC1864ku.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                    }
                });
                if (this.f10532e.size() >= 3) {
                    cVar.f10578R.setVisibility(0);
                    if (this.f10531d.equals("1")) {
                        String str5 = this.f10532e.get(2).TotalCount;
                        cVar.f10573M.setText(C1910mi.m10524a(str5, str5 + " " + C1914mm.m10557b(R.string.times), 17, Color.parseColor("#ffffff")));
                    } else {
                        String str6 = this.f10532e.get(2).Score;
                        cVar.f10573M.setText(C1910mi.m10524a(str6, str6 + " " + C1914mm.m10557b(R.string.score), 17, Color.parseColor("#ffffff")));
                    }
                    C2068qy.m11356a().m11360a(this.f10532e.get(2).Icon, cVar.f10576P);
                    cVar.f10570J.setText(this.f10532e.get(2).UserName);
                    cVar.f10566F.setText(this.f10532e.get(2).Address);
                    cVar.f10563C.setText(this.f10532e.get(2).Likes);
                    if (this.f10532e.get(2).IsLiked.contentEquals("1")) {
                        cVar.f10563C.setChecked(true);
                    }
                    cVar.f10563C.setOnCheckedChangeListener(new a(this.f10532e.get(2).UserID));
                    cVar.f10578R.setOnClickListener(new View.OnClickListener() { // from class: jg.3
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            DialogC1864ku dialogC1864ku = new DialogC1864ku(C1823jg.this.f10529b, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(2)).UserID, cVar.f10563C, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(2)).Icon);
                            dialogC1864ku.requestWindowFeature(1);
                            dialogC1864ku.show();
                            dialogC1864ku.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                        }
                    });
                }
            }
            cVar.f10579S.setOnClickListener(new View.OnClickListener() { // from class: jg.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1823jg.this.m9869a(cVar.f10581r);
                }
            });
            m9870a(this.f10534g, cVar, this.f10531d);
            return;
        }
        if (abstractC0624v instanceof b) {
            final b bVar = (b) abstractC0624v;
            final int i2 = i + 2;
            bVar.f10554r.setOnClickListener(new View.OnClickListener() { // from class: jg.5
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DialogC1864ku dialogC1864ku = new DialogC1864ku(C1823jg.this.f10529b, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(i2)).UserID, bVar.f10553q, ((RankingBean.errDesc.Rank) C1823jg.this.f10532e.get(i2)).Icon);
                    dialogC1864ku.requestWindowFeature(1);
                    dialogC1864ku.show();
                    dialogC1864ku.getWindow().getDecorView().setPadding(0, 0, 0, 0);
                }
            });
            bVar.f10555s.setText(String.valueOf(i2 + 1));
            bVar.f10557u.setText(this.f10532e.get(i2).UserName);
            bVar.f10558v.setText(this.f10532e.get(i2).Address);
            if (this.f10531d.equals("1")) {
                String str7 = this.f10532e.get(i2).TotalCount;
                bVar.f10559w.setText(C1910mi.m10523a(str7, str7 + " " + C1914mm.m10557b(R.string.times), 20));
            } else {
                String str8 = this.f10532e.get(i2).Score;
                bVar.f10559w.setText(C1910mi.m10523a(str8, str8 + " " + C1914mm.m10557b(R.string.score), 20));
            }
            C2068qy.m11356a().m11360a(this.f10532e.get(i2).Icon, bVar.f10556t);
            bVar.f10553q.setText(this.f10532e.get(i2).Likes);
            if (this.f10532e.get(i2).IsLiked.contentEquals("1")) {
                bVar.f10553q.setChecked(true);
            }
            bVar.f10553q.setOnCheckedChangeListener(new a(this.f10532e.get(i2).UserID));
            m9874a(bVar.f3823a, i2);
        }
    }

    /* JADX INFO: renamed from: jg$a */
    /* JADX INFO: compiled from: RankAdapter.java */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a */
        String f10547a;

        public a(String str) {
            this.f10547a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
            final CheckBox checkBox = (CheckBox) compoundButton;
            if (!C1901md.m10477a()) {
                checkBox.setChecked(!z);
                return;
            }
            final int i = Integer.parseInt((String) checkBox.getText());
            RequestParams requestParams = new RequestParams();
            requestParams.addBodyParameter("userID", this.f10547a);
            C1823jg.this.f10528a.getClass();
            String str = "http://tennis.coollang.com/TennisSportController/addRankLike";
            if (!z) {
                C1823jg.this.f10528a.getClass();
                str = "http://tennis.coollang.com/TennisSportController/delRankLike";
            }
            C1874ld unused = C1823jg.this.f10528a;
            C1874ld.f11073an.send(HttpRequest.HttpMethod.POST, str, requestParams, new RequestCallBack<String>() { // from class: jg.a.1
                @Override // com.lidroid.xutils.http.callback.RequestCallBack
                public void onFailure(HttpException httpException, String str2) {
                }

                @Override // com.lidroid.xutils.http.callback.RequestCallBack
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    C1808is.m9827c(responseInfo);
                    if (z) {
                        checkBox.setText("" + (i + 1));
                        return;
                    }
                    CheckBox checkBox2 = checkBox;
                    StringBuilder sb = new StringBuilder();
                    sb.append("");
                    sb.append(i - 1);
                    checkBox2.setText(sb.toString());
                }
            });
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m9874a(View view, int i) {
        if (i > this.f10530c) {
            int i2 = i < 6 ? ((i + 1) * 20) + 200 : 300;
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(C1914mm.m10554a(), R.anim.inscale);
            animationLoadAnimation.setDuration(i2);
            view.startAnimation(animationLoadAnimation);
            this.f10530c = i;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: d */
    public void mo3878d(RecyclerView.AbstractC0624v abstractC0624v) {
        super.mo3878d(abstractC0624v);
        abstractC0624v.f3823a.clearAnimation();
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: b */
    public RecyclerView.AbstractC0624v mo3871b(ViewGroup viewGroup, int i) {
        switch (i) {
            case 0:
                return new c(LayoutInflater.from(C1914mm.m10554a()).inflate(R.layout.item_rank_top, viewGroup, false));
            case 1:
                return new b(C1914mm.m10555a(R.layout.item_rank_new));
            default:
                return null;
        }
    }

    /* JADX INFO: renamed from: jg$b */
    /* JADX INFO: compiled from: RankAdapter.java */
    public static class b extends RecyclerView.AbstractC0624v {

        /* JADX INFO: renamed from: q */
        private final CheckBox f10553q;

        /* JADX INFO: renamed from: r */
        private LinearLayout f10554r;

        /* JADX INFO: renamed from: s */
        private TextView f10555s;

        /* JADX INFO: renamed from: t */
        private CircleImageView f10556t;

        /* JADX INFO: renamed from: u */
        private TextView f10557u;

        /* JADX INFO: renamed from: v */
        private TextView f10558v;

        /* JADX INFO: renamed from: w */
        private TextView f10559w;

        /* JADX INFO: renamed from: x */
        private View f10560x;

        public b(View view) {
            super(view);
            this.f10554r = (LinearLayout) view.findViewById(R.id.item_rank_ll);
            this.f10555s = (TextView) view.findViewById(R.id.item_rank_tv_rank);
            this.f10556t = (CircleImageView) view.findViewById(R.id.item_rank_civ_head);
            this.f10557u = (TextView) view.findViewById(R.id.item_rank_tv_name);
            this.f10558v = (TextView) view.findViewById(R.id.item_rank_tv_change);
            this.f10559w = (TextView) view.findViewById(R.id.item_rank_tv_times);
            this.f10560x = view.findViewById(R.id.item_rank_white_line);
            this.f10553q = (CheckBox) view.findViewById(R.id.like);
        }
    }

    /* JADX INFO: renamed from: jg$c */
    /* JADX INFO: compiled from: RankAdapter.java */
    public static class c extends RecyclerView.AbstractC0624v {

        /* JADX INFO: renamed from: A */
        private final CheckBox f10561A;

        /* JADX INFO: renamed from: B */
        private final CheckBox f10562B;

        /* JADX INFO: renamed from: C */
        private final CheckBox f10563C;

        /* JADX INFO: renamed from: D */
        private final TextView f10564D;

        /* JADX INFO: renamed from: E */
        private final TextView f10565E;

        /* JADX INFO: renamed from: F */
        private final TextView f10566F;

        /* JADX INFO: renamed from: G */
        private final RelativeLayout f10567G;

        /* JADX INFO: renamed from: H */
        private TextView f10568H;

        /* JADX INFO: renamed from: I */
        private TextView f10569I;

        /* JADX INFO: renamed from: J */
        private TextView f10570J;

        /* JADX INFO: renamed from: K */
        private TextView f10571K;

        /* JADX INFO: renamed from: L */
        private TextView f10572L;

        /* JADX INFO: renamed from: M */
        private TextView f10573M;

        /* JADX INFO: renamed from: N */
        private CircleImageView f10574N;

        /* JADX INFO: renamed from: O */
        private CircleImageView f10575O;

        /* JADX INFO: renamed from: P */
        private CircleImageView f10576P;

        /* JADX INFO: renamed from: Q */
        private RelativeLayout f10577Q;

        /* JADX INFO: renamed from: R */
        private RelativeLayout f10578R;

        /* JADX INFO: renamed from: S */
        private TextView f10579S;

        /* JADX INFO: renamed from: q */
        private final RelativeLayout f10580q;

        /* JADX INFO: renamed from: r */
        private final RelativeLayout f10581r;

        /* JADX INFO: renamed from: s */
        private final CircleImageView f10582s;

        /* JADX INFO: renamed from: t */
        private final TextView f10583t;

        /* JADX INFO: renamed from: u */
        private final RelativeLayout f10584u;

        /* JADX INFO: renamed from: v */
        private final CircleImageView f10585v;

        /* JADX INFO: renamed from: w */
        private final TextView f10586w;

        /* JADX INFO: renamed from: x */
        private final TextView f10587x;

        /* JADX INFO: renamed from: y */
        private final TextView f10588y;

        /* JADX INFO: renamed from: z */
        private final TextView f10589z;

        public c(View view) {
            super(view);
            this.f10568H = (TextView) view.findViewById(R.id.tv_first_rank_name);
            this.f10569I = (TextView) view.findViewById(R.id.tv_second_rank_name);
            this.f10570J = (TextView) view.findViewById(R.id.tv_third_rank_name);
            this.f10571K = (TextView) view.findViewById(R.id.tv_first_rank_count);
            this.f10572L = (TextView) view.findViewById(R.id.tv_second_rank_count);
            this.f10573M = (TextView) view.findViewById(R.id.tv_third_rank_count);
            this.f10564D = (TextView) view.findViewById(R.id.tv_first_place);
            this.f10565E = (TextView) view.findViewById(R.id.tv_place);
            this.f10566F = (TextView) view.findViewById(R.id.tv_third_place);
            this.f10574N = (CircleImageView) view.findViewById(R.id.civ_first_order_head);
            this.f10575O = (CircleImageView) view.findViewById(R.id.civ_second_order_head);
            this.f10576P = (CircleImageView) view.findViewById(R.id.civ_third_order_head);
            this.f10561A = (CheckBox) view.findViewById(R.id.first_like);
            this.f10562B = (CheckBox) view.findViewById(R.id.second_like);
            this.f10563C = (CheckBox) view.findViewById(R.id.third_like);
            this.f10567G = (RelativeLayout) view.findViewById(R.id.rl_first_layout_rank);
            this.f10577Q = (RelativeLayout) view.findViewById(R.id.rl_second_layout_rank);
            this.f10578R = (RelativeLayout) view.findViewById(R.id.rl_third_layout_rank);
            this.f10581r = (RelativeLayout) view.findViewById(R.id.rlroot);
            this.f10579S = (TextView) view.findViewById(R.id.me_like);
            this.f10580q = (RelativeLayout) view.findViewById(R.id.rl_rank_no_head);
            this.f10582s = (CircleImageView) view.findViewById(R.id.civ_empty_head);
            this.f10583t = (TextView) view.findViewById(R.id.tv_no_head);
            this.f10584u = (RelativeLayout) view.findViewById(R.id.rl_rank_has_head);
            this.f10585v = (CircleImageView) view.findViewById(R.id.civ_head_rank_self);
            this.f10586w = (TextView) view.findViewById(R.id.item_rank_tv_name);
            this.f10587x = (TextView) view.findViewById(R.id.item_rank_tv_change);
            this.f10588y = (TextView) view.findViewById(R.id.item_rank_tv_times);
            this.f10589z = (TextView) view.findViewById(R.id.tv_self_order_rank);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9870a(RankingBean rankingBean, c cVar, String str) {
        if (rankingBean == null) {
            return;
        }
        String str2 = (String) cVar.f10585v.getTag();
        if (str2 == null || !str2.equals(rankingBean.errDesc.MyRankInfo.Icon)) {
            C2068qy.m11356a().m11360a(rankingBean.errDesc.MyRankInfo.Icon, cVar.f10585v);
            cVar.f10585v.setTag(rankingBean.errDesc.MyRankInfo.Icon);
        }
        String string = this.f10529b.getResources().getString(R.string.rank_num);
        cVar.f10586w.setText(rankingBean.errDesc.MyRankInfo.Number + string);
        cVar.f10587x.setText(rankingBean.errDesc.MyRankInfo.Change);
        if (Integer.parseInt(rankingBean.errDesc.MyRankInfo.Change) <= 0) {
            Drawable drawable = this.f10529b.getResources().getDrawable(R.drawable.arrow_down);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            cVar.f10587x.setCompoundDrawables(drawable, null, null, null);
        }
        if ("1".equals(str)) {
            String str3 = rankingBean.errDesc.MyRankInfo.TotalCount;
            cVar.f10588y.setText(C1910mi.m10523a(str3, str3 + C1914mm.m10557b(R.string.times), 20));
        } else if ("2".equals(str)) {
            String str4 = rankingBean.errDesc.MyRankInfo.Score;
            cVar.f10588y.setText(C1910mi.m10523a(str4, str4 + C1914mm.m10557b(R.string.score), 20));
        }
        cVar.f10579S.setText(rankingBean.errDesc.MyRankInfo.Likes);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m9869a(View view) {
        View viewInflate = View.inflate(this.f10529b, R.layout.layout_like_list, null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_likelist);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.tv_likelist_num);
        String str = "";
        for (int i = 0; i < this.f10534g.errDesc.MyRankInfo.LikeUserList.size(); i++) {
            str = i == this.f10534g.errDesc.MyRankInfo.LikeUserList.size() - 1 ? str + this.f10534g.errDesc.MyRankInfo.LikeUserList.get(i) + "..." : str + this.f10534g.errDesc.MyRankInfo.LikeUserList.get(i) + "、";
        }
        textView.setText(str);
        textView2.setText(this.f10534g.errDesc.MyRankInfo.Likes + " " + this.f10529b.getString(R.string.players_like_you));
        this.f10533f = new PopupWindow(viewInflate, -1, -2, true);
        this.f10533f.setFocusable(true);
        this.f10533f.setTouchable(true);
        this.f10533f.setTouchInterceptor(new View.OnTouchListener() { // from class: jg.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view2, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f10533f.setBackgroundDrawable(new BitmapDrawable());
        this.f10533f.showAsDropDown(view, 0, -C1895ly.m10460a(this.f10529b, 6.0f));
    }
}
