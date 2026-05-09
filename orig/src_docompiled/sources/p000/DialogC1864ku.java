package p000;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.RankDetial;
import com.coollang.tennis.widget.CircleImageView;
import com.google.gson.Gson;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: ku */
/* JADX INFO: compiled from: PersonalRankDataDialog.java */
/* JADX INFO: loaded from: classes.dex */
public class DialogC1864ku extends Dialog {

    /* JADX INFO: renamed from: a */
    String f10952a;

    /* JADX INFO: renamed from: b */
    String f10953b;

    /* JADX INFO: renamed from: c */
    Activity f10954c;

    /* JADX INFO: renamed from: d */
    C1874ld f10955d;

    /* JADX INFO: renamed from: e */
    private final CheckBox f10956e;

    /* JADX INFO: renamed from: f */
    private CircleImageView f10957f;

    /* JADX INFO: renamed from: g */
    private TextView f10958g;

    /* JADX INFO: renamed from: h */
    private TextView f10959h;

    /* JADX INFO: renamed from: i */
    private CheckBox f10960i;

    /* JADX INFO: renamed from: j */
    private TextView f10961j;

    /* JADX INFO: renamed from: k */
    private TextView f10962k;

    /* JADX INFO: renamed from: l */
    private TextView f10963l;

    /* JADX INFO: renamed from: m */
    private TextView f10964m;

    /* JADX INFO: renamed from: n */
    private TextView f10965n;

    /* JADX INFO: renamed from: o */
    private TextView f10966o;

    /* JADX INFO: renamed from: p */
    private ImageView f10967p;

    /* JADX INFO: renamed from: q */
    private ImageView f10968q;

    /* JADX INFO: renamed from: r */
    private ImageView f10969r;

    /* JADX INFO: renamed from: s */
    private List<ImageView> f10970s;

    /* JADX INFO: renamed from: t */
    private int[] f10971t;

    public DialogC1864ku(Context context, String str, CheckBox checkBox, String str2) {
        super(context);
        this.f10952a = "";
        this.f10953b = "";
        this.f10970s = new ArrayList();
        this.f10971t = new int[]{R.drawable.ic_model_select_1, R.drawable.ic_model_select_3, R.drawable.ic_model_select_2, R.drawable.ic_model_select_5, R.drawable.ic_model_select_4, R.drawable.ic_model_select_6, R.drawable.ic_model_select_7, R.drawable.ic_model_select_8, R.drawable.ic_model_select_9};
        this.f10954c = (Activity) context;
        this.f10952a = str;
        this.f10953b = str2;
        this.f10956e = checkBox;
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.personal_rank_data_dialog);
        akd.m1706a().m1719a(this);
        m10135a();
        this.f10955d = new C1874ld();
        this.f10955d.m10229i(this.f10952a);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        akd.m1706a().m1721b(this);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 61) {
            switch (c1873lc.f11065b) {
                case 1:
                    m10136a((RankDetial) new Gson().fromJson(c1873lc.f11064a, RankDetial.class));
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10135a() {
        this.f10957f = (CircleImageView) findViewById(R.id.civ_avartar);
        this.f10957f.setOnClickListener(new View.OnClickListener() { // from class: ku.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC1864ku.this.m10137a(DialogC1864ku.this.f10953b, view);
            }
        });
        this.f10958g = (TextView) findViewById(R.id.tv_name);
        this.f10959h = (TextView) findViewById(R.id.tv_place);
        this.f10960i = (CheckBox) findViewById(R.id.cb_like);
        this.f10961j = (TextView) findViewById(R.id.tv_sporttime_data);
        this.f10962k = (TextView) findViewById(R.id.tv_swing_amount);
        this.f10963l = (TextView) findViewById(R.id.tv_weelyranking);
        this.f10964m = (TextView) findViewById(R.id.tv_monthly_ranking);
        this.f10965n = (TextView) findViewById(R.id.tv_weely_scoreranking);
        this.f10966o = (TextView) findViewById(R.id.tv_monthly_scoreranking);
        this.f10967p = (ImageView) findViewById(R.id.medal1);
        this.f10968q = (ImageView) findViewById(R.id.medal2);
        this.f10969r = (ImageView) findViewById(R.id.medal3);
        this.f10970s.add(this.f10967p);
        this.f10970s.add(this.f10968q);
        this.f10970s.add(this.f10969r);
    }

    /* JADX INFO: renamed from: a */
    private void m10136a(RankDetial rankDetial) {
        C2068qy.m11356a().m11360a(rankDetial.errDesc.UserInfo.Icon, this.f10957f);
        this.f10958g.setText(rankDetial.errDesc.UserInfo.Name);
        this.f10959h.setText(rankDetial.errDesc.UserInfo.Address);
        if (rankDetial.errDesc.IsLiked.contentEquals("1")) {
            this.f10960i.setChecked(true);
        }
        this.f10960i.setText(rankDetial.errDesc.Likes);
        this.f10960i.setOnCheckedChangeListener(new a(this.f10952a));
        this.f10961j.setText(rankDetial.errDesc.TotalDuration);
        this.f10962k.setText(rankDetial.errDesc.TotalSwings);
        this.f10963l.setText(rankDetial.errDesc.SwingWeekRank);
        this.f10964m.setText(rankDetial.errDesc.SwingMonthRank);
        this.f10965n.setText(rankDetial.errDesc.ScoreWeekRank);
        this.f10966o.setText(rankDetial.errDesc.ScoreMonthRank);
        for (int i = 0; i < rankDetial.errDesc.Medals.size() && i < 3; i++) {
            this.f10970s.get(i).setVisibility(0);
            this.f10970s.get(i).setImageResource(this.f10971t[i]);
        }
    }

    /* JADX INFO: renamed from: ku$a */
    /* JADX INFO: compiled from: PersonalRankDataDialog.java */
    class a implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a */
        String f10973a;

        public a(String str) {
            this.f10973a = str;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, final boolean z) {
            final CheckBox checkBox = (CheckBox) compoundButton;
            if (!C1901md.m10477a()) {
                checkBox.setChecked(!z);
                return;
            }
            String str = (String) checkBox.getText();
            final int i = Integer.parseInt(str);
            final int i2 = Integer.parseInt(str);
            RequestParams requestParams = new RequestParams();
            requestParams.addBodyParameter("userID", this.f10973a);
            DialogC1864ku.this.f10955d.getClass();
            String str2 = "http://tennis.coollang.com/TennisSportController/addRankLike";
            if (!z) {
                DialogC1864ku.this.f10955d.getClass();
                str2 = "http://tennis.coollang.com/TennisSportController/delRankLike";
            }
            String str3 = str2;
            C1874ld c1874ld = DialogC1864ku.this.f10955d;
            C1874ld.f11073an.send(HttpRequest.HttpMethod.POST, str3, requestParams, new RequestCallBack<String>() { // from class: ku.a.1
                @Override // com.lidroid.xutils.http.callback.RequestCallBack
                public void onFailure(HttpException httpException, String str4) {
                }

                @Override // com.lidroid.xutils.http.callback.RequestCallBack
                public void onSuccess(ResponseInfo<String> responseInfo) {
                    C1808is.m9827c(responseInfo);
                    if (z) {
                        DialogC1864ku.this.f10956e.setChecked(true);
                        DialogC1864ku.this.f10956e.setText("" + (i2 + 1));
                        checkBox.setText("" + (i + 1));
                        return;
                    }
                    DialogC1864ku.this.f10956e.setChecked(false);
                    DialogC1864ku.this.f10956e.setText("" + (i2 - 1));
                    checkBox.setText("" + (i - 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10137a(String str, View view) {
        C1927mz c1927mz = new C1927mz(this.f10954c, str);
        c1927mz.m10711a(view);
        c1927mz.m10710a();
    }
}
