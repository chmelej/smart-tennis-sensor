package p000;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.p007qq.C0874QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.Video_detail_Activity;
import com.coollang.tennis.beans.MyvideoBean;
import com.thinkcool.circletextimageview.CircleTextImageView;
import java.util.List;

/* JADX INFO: renamed from: jh */
/* JADX INFO: compiled from: RecyclerViewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1824jh extends AbstractC1835js<a> implements View.OnClickListener {

    /* JADX INFO: renamed from: j */
    private static final int[] f10590j = {R.drawable.shouye_contion_false, R.drawable.shouye_contion_true, R.drawable.shouye_good_flase, R.drawable.shouye_good_ture, R.drawable.shouye_more};

    /* JADX INFO: renamed from: a */
    C1874ld f10591a;

    /* JADX INFO: renamed from: b */
    LayoutInflater f10592b;

    /* JADX INFO: renamed from: f */
    private List<MyvideoBean.C1210d2> f10593f;

    /* JADX INFO: renamed from: g */
    private String f10594g;

    /* JADX INFO: renamed from: h */
    private String f10595h;

    /* JADX INFO: renamed from: i */
    private String f10596i;

    public ViewOnClickListenerC1824jh(Context context, int i, int i2, List<MyvideoBean.C1210d2> list) {
        super(context, i, i2);
        this.f10594g = "RecyclerViewAdapter";
        this.f10591a = new C1874ld();
        this.f10593f = list;
        list.isEmpty();
        this.f10592b = LayoutInflater.from(this.f10799c);
    }

    /* JADX INFO: renamed from: a */
    public void m9914a(List<MyvideoBean.C1210d2> list) {
        this.f10593f.addAll(list);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mo3871b(ViewGroup viewGroup, int i) {
        return new a(View.inflate(this.f10799c, this.f10800d, null));
    }

    @Override // p000.AbstractC1835js, android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3867a(a aVar, int i) {
        super.mo3867a(aVar, i);
        Log.e(this.f10594g, "onBindViewHolder   I: " + i);
        if (this.f10593f.size() != 0) {
            if (this.f10593f.size() != 1) {
                final MyvideoBean.C1210d2 c1210d2 = this.f10593f.get(i);
                String strM10544d = C1912mk.m10544d(Long.parseLong(c1210d2.Duration));
                String str = c1210d2.Thumb;
                if (strM10544d != null) {
                    aVar.f10606D.setText(strM10544d);
                }
                if (!str.equals("")) {
                    C2253xu.m12305a(this.f10799c).m12312a(str).m12348a(aVar.f10605C);
                }
                aVar.f10607E.setOnClickListener(new View.OnClickListener() { // from class: jh.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        Intent intent = new Intent();
                        intent.putExtra("bean_index", 2);
                        intent.putExtra("bean", c1210d2);
                        intent.setClass(ViewOnClickListenerC1824jh.this.f10799c, Video_detail_Activity.class);
                        ViewOnClickListenerC1824jh.this.f10799c.startActivity(intent);
                    }
                });
                return;
            }
            DisplayMetrics displayMetrics = C1914mm.m10556b().getDisplayMetrics();
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f10615x.getLayoutParams();
            layoutParams.height = (displayMetrics.widthPixels * 1080) / 1920;
            aVar.f10615x.setLayoutParams(layoutParams);
            aVar.f10604B.setLayoutParams(layoutParams);
            final MyvideoBean.C1210d2 c1210d22 = this.f10593f.get(i);
            String str2 = c1210d22.Title;
            aVar.f10608q.setText(c1210d22.UserName);
            aVar.f10603A.setOnClickListener(new View.OnClickListener() { // from class: jh.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    Intent intent = new Intent();
                    intent.putExtra("bean_index", 2);
                    intent.putExtra("bean", c1210d22);
                    intent.setClass(ViewOnClickListenerC1824jh.this.f10799c, Video_detail_Activity.class);
                    ViewOnClickListenerC1824jh.this.f10799c.startActivity(intent);
                }
            });
            aVar.f10608q.setOnClickListener(new View.OnClickListener() { // from class: jh.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    String str3 = c1210d22.Url;
                    Intent intent = new Intent();
                    intent.putExtra("bean_index", 2);
                    intent.putExtra("bean", c1210d22);
                    intent.setClass(ViewOnClickListenerC1824jh.this.f10799c, Video_detail_Activity.class);
                    ViewOnClickListenerC1824jh.this.f10799c.startActivity(intent);
                }
            });
            C2253xu.m12305a(this.f10799c).m12312a(c1210d22.Thumb).m12348a(aVar.f10615x);
            C2253xu.m12305a(this.f10799c).m12312a(c1210d22.Thumb).m12347a(new C1891lu(this.f10799c)).m12348a(aVar.f10604B);
            aVar.f10609r.setText(str2);
            if (aVar.f10614w != null) {
                if (!c1210d22.Icon.equals("")) {
                    C2253xu.m12305a(this.f10799c).m12312a(c1210d22.Icon).m12345a(R.drawable.ic_head_select).m12348a(aVar.f10614w);
                } else {
                    aVar.f10614w.setImageResource(R.drawable.ic_head_select);
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.friends /* 2131296607 */:
                m9907a(WechatMoments.NAME, this.f10595h, this.f10596i);
                break;
            case R.id.qq /* 2131296966 */:
                m9907a(C0874QQ.NAME, this.f10595h, this.f10596i);
                break;
            case R.id.qqkj /* 2131296967 */:
                m9907a(QZone.NAME, this.f10595h, this.f10596i);
                break;
            case R.id.weixin /* 2131297495 */:
                m9907a(Wechat.NAME, this.f10595h, this.f10596i);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9907a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        C1874ld c1874ld = this.f10591a;
        sb.append("http://tennis.coollang.com/");
        sb.append(this.f10799c.getString(R.string.share_video_url));
        sb.append(str3);
        String string = sb.toString();
        Log.e(this.f10594g, "showShareDialog: " + string);
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(this.f10799c.getString(R.string.app_name));
        onekeyShare.setText(str2);
        onekeyShare.setTitleUrl(string);
        onekeyShare.setUrl(string);
        onekeyShare.setSiteUrl(string);
        onekeyShare.setImagePath(C1890lt.m10438a("logo", ((BitmapDrawable) this.f10799c.getResources().getDrawable(R.drawable.ic_logo)).getBitmap()));
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this.f10799c);
    }

    /* JADX INFO: renamed from: jh$a */
    /* JADX INFO: compiled from: RecyclerViewAdapter.java */
    public static class a extends RecyclerView.AbstractC0624v {

        /* JADX INFO: renamed from: A */
        RelativeLayout f10603A;

        /* JADX INFO: renamed from: B */
        ImageView f10604B;

        /* JADX INFO: renamed from: C */
        private ImageView f10605C;

        /* JADX INFO: renamed from: D */
        private TextView f10606D;

        /* JADX INFO: renamed from: E */
        private RelativeLayout f10607E;

        /* JADX INFO: renamed from: q */
        TextView f10608q;

        /* JADX INFO: renamed from: r */
        TextView f10609r;

        /* JADX INFO: renamed from: s */
        TextView f10610s;

        /* JADX INFO: renamed from: t */
        ImageView f10611t;

        /* JADX INFO: renamed from: u */
        ImageView f10612u;

        /* JADX INFO: renamed from: v */
        ImageView f10613v;

        /* JADX INFO: renamed from: w */
        CircleTextImageView f10614w;

        /* JADX INFO: renamed from: x */
        ImageView f10615x;

        /* JADX INFO: renamed from: y */
        RelativeLayout f10616y;

        /* JADX INFO: renamed from: z */
        RelativeLayout f10617z;

        public a(View view) {
            super(view);
            this.f10605C = (ImageView) view.findViewById(R.id.video_img);
            this.f10606D = (TextView) view.findViewById(R.id.Duration);
            this.f10607E = (RelativeLayout) view.findViewById(R.id.layout_item);
            this.f10616y = (RelativeLayout) view.findViewById(R.id.layout_end_share);
            this.f10608q = (TextView) view.findViewById(R.id.UserName);
            this.f10614w = (CircleTextImageView) view.findViewById(R.id.User_img);
            this.f10615x = (ImageView) view.findViewById(R.id.videoplayer);
            this.f10609r = (TextView) view.findViewById(R.id.titles);
            this.f10611t = (ImageView) view.findViewById(R.id.looking_msg);
            this.f10610s = (TextView) view.findViewById(R.id.look_count);
            this.f10612u = (ImageView) view.findViewById(R.id.Collection_false);
            this.f10613v = (ImageView) view.findViewById(R.id.m_more);
            this.f10604B = (ImageView) view.findViewById(R.id.videoplayer_ditu);
            this.f10617z = (RelativeLayout) view.findViewById(R.id.layout_video);
            this.f10603A = (RelativeLayout) view.findViewById(R.id.layout_main);
        }
    }
}
