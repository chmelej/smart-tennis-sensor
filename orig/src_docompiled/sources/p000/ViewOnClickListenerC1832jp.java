package p000;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.onekeyshare.OnekeyShare;
import cn.sharesdk.tencent.p007qq.C0874QQ;
import cn.sharesdk.tencent.qzone.QZone;
import cn.sharesdk.wechat.friends.Wechat;
import cn.sharesdk.wechat.moments.WechatMoments;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.Video_detail_Activity;
import com.coollang.tennis.beans.Video_msg_Bean;
import com.thinkcool.circletextimageview.CircleTextImageView;
import java.util.List;

/* JADX INFO: renamed from: jp */
/* JADX INFO: compiled from: Video_Msg_Adapter.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1832jp extends BaseAdapter implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    public static int f10726a = -1;

    /* JADX INFO: renamed from: c */
    LayoutInflater f10728c;

    /* JADX INFO: renamed from: e */
    private List<Video_msg_Bean.C1216d2> f10730e;

    /* JADX INFO: renamed from: f */
    private String f10731f;

    /* JADX INFO: renamed from: g */
    private String f10732g;

    /* JADX INFO: renamed from: h */
    private String f10733h;

    /* JADX INFO: renamed from: i */
    private Context f10734i;

    /* JADX INFO: renamed from: j */
    private PopupWindow f10735j;

    /* JADX INFO: renamed from: k */
    private PopupWindow f10736k;

    /* JADX INFO: renamed from: b */
    int f10727b = 6;

    /* JADX INFO: renamed from: l */
    private final String f10737l = "Video_Msg_Adapter";

    /* JADX INFO: renamed from: d */
    C1874ld f10729d = new C1874ld();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public ViewOnClickListenerC1832jp(Context context, List<Video_msg_Bean.C1216d2> list) {
        this.f10730e = list;
        this.f10734i = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10730e.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10730e.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final a aVar;
        this.f10728c = LayoutInflater.from(this.f10734i);
        if (view == null) {
            view = this.f10728c.inflate(R.layout.fragment_video_iteam, (ViewGroup) null);
            aVar = new a();
            aVar.f10782i = (RelativeLayout) view.findViewById(R.id.layout_end_share);
            aVar.f10774a = (TextView) view.findViewById(R.id.UserName);
            aVar.f10780g = (CircleTextImageView) view.findViewById(R.id.User_img);
            aVar.f10781h = (ImageView) view.findViewById(R.id.videoplayer);
            aVar.f10775b = (TextView) view.findViewById(R.id.titles);
            aVar.f10777d = (ImageView) view.findViewById(R.id.looking_msg);
            aVar.f10776c = (TextView) view.findViewById(R.id.look_count);
            aVar.f10778e = (ImageView) view.findViewById(R.id.Collection_false);
            aVar.f10779f = (ImageView) view.findViewById(R.id.m_more);
            aVar.f10785l = (ImageView) view.findViewById(R.id.videoplayer_ditu);
            aVar.f10783j = (RelativeLayout) view.findViewById(R.id.layout_video);
            aVar.f10784k = (RelativeLayout) view.findViewById(R.id.layout_main);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        DisplayMetrics displayMetrics = C1914mm.m10556b().getDisplayMetrics();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) aVar.f10781h.getLayoutParams();
        layoutParams.height = (displayMetrics.widthPixels * 1080) / 1920;
        aVar.f10781h.setLayoutParams(layoutParams);
        aVar.f10785l.setLayoutParams(layoutParams);
        aVar.f10784k.setOnClickListener(this);
        final Video_msg_Bean.C1216d2 c1216d2 = this.f10730e.get(i);
        aVar.f10776c.setText(c1216d2.Views);
        if ((c1216d2.IsCollection != null ? Integer.parseInt(c1216d2.IsCollection) : 0) == 1) {
            aVar.f10778e.setSelected(true);
        } else {
            aVar.f10778e.setSelected(false);
        }
        String str = c1216d2.Title;
        aVar.f10774a.setText(c1216d2.UserName);
        aVar.f10784k.setOnClickListener(new View.OnClickListener() { // from class: jp.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                intent.putExtra("bean_index", 0);
                intent.putExtra("bean", c1216d2);
                intent.setClass(ViewOnClickListenerC1832jp.this.f10734i, Video_detail_Activity.class);
                ViewOnClickListenerC1832jp.this.f10734i.startActivity(intent);
            }
        });
        aVar.f10774a.setOnClickListener(new View.OnClickListener() { // from class: jp.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                String str2 = c1216d2.Url;
                Intent intent = new Intent();
                intent.putExtra("bean_index", 0);
                intent.putExtra("bean", c1216d2);
                intent.setClass(ViewOnClickListenerC1832jp.this.f10734i, Video_detail_Activity.class);
                ViewOnClickListenerC1832jp.this.f10734i.startActivity(intent);
            }
        });
        if (!c1216d2.Icon.equals("")) {
            C2253xu.m12305a(this.f10734i).m12312a(c1216d2.Icon).m12348a(aVar.f10780g);
        }
        C2253xu.m12305a(this.f10734i).m12312a(c1216d2.Thumb).m12348a(aVar.f10781h);
        C2253xu.m12305a(this.f10734i).m12312a(c1216d2.Thumb).m12347a(new C1891lu(this.f10734i)).m12348a(aVar.f10785l);
        aVar.f10779f.setOnClickListener(new View.OnClickListener() { // from class: jp.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                ViewOnClickListenerC1832jp.this.f10733h = c1216d2.f7437ID;
                ViewOnClickListenerC1832jp.this.f10731f = c1216d2.Title;
                ViewOnClickListenerC1832jp.this.f10732g = c1216d2.Thumb;
                ViewOnClickListenerC1832jp.this.m10005a(i, aVar.f10778e, c1216d2.f7437ID, c1216d2.UserID);
            }
        });
        aVar.f10775b.setText(str);
        aVar.f10778e.setOnClickListener(new View.OnClickListener() { // from class: jp.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (aVar.f10778e.isSelected()) {
                    ViewOnClickListenerC1832jp.this.f10729d.m10244p(c1216d2.f7437ID);
                    aVar.f10778e.setSelected(false);
                    Log.e("TAG", "取消收藏: ");
                } else {
                    ViewOnClickListenerC1832jp.this.f10729d.m10238m(c1216d2.f7437ID);
                    aVar.f10778e.setSelected(true);
                }
            }
        });
        return view;
    }

    /* JADX INFO: renamed from: a */
    public void m10006a(List<Video_msg_Bean.C1216d2> list) {
        this.f10730e.addAll(list);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.friends /* 2131296607 */:
                m9998a(WechatMoments.NAME, this.f10731f, this.f10733h);
                break;
            case R.id.qq /* 2131296966 */:
                m9998a(C0874QQ.NAME, this.f10731f, this.f10733h);
                break;
            case R.id.qqkj /* 2131296967 */:
                m9998a(QZone.NAME, this.f10731f, this.f10733h);
                break;
            case R.id.weixin /* 2131297495 */:
                m9998a(Wechat.NAME, this.f10731f, this.f10733h);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9998a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder();
        C1874ld c1874ld = this.f10729d;
        sb.append("http://tennis.coollang.com/");
        sb.append(this.f10734i.getString(R.string.share_video_url));
        sb.append(str3);
        String string = sb.toString();
        Log.e("Video_Msg_Adapter", "showShareDialog: " + string);
        OnekeyShare onekeyShare = new OnekeyShare();
        onekeyShare.disableSSOWhenAuthorize();
        onekeyShare.setTitle(this.f10734i.getString(R.string.app_name));
        onekeyShare.setText(str2);
        onekeyShare.setTitleUrl(string);
        onekeyShare.setUrl(string);
        onekeyShare.setSiteUrl(string);
        onekeyShare.setImagePath(C1890lt.m10438a("logo", ((BitmapDrawable) this.f10734i.getResources().getDrawable(R.drawable.ic_logo)).getBitmap()));
        onekeyShare.setSilent(false);
        onekeyShare.setDialogMode();
        onekeyShare.setPlatform(str);
        onekeyShare.show(this.f10734i);
    }

    /* JADX INFO: renamed from: jp$a */
    /* JADX INFO: compiled from: Video_Msg_Adapter.java */
    static class a {

        /* JADX INFO: renamed from: a */
        TextView f10774a;

        /* JADX INFO: renamed from: b */
        TextView f10775b;

        /* JADX INFO: renamed from: c */
        TextView f10776c;

        /* JADX INFO: renamed from: d */
        ImageView f10777d;

        /* JADX INFO: renamed from: e */
        ImageView f10778e;

        /* JADX INFO: renamed from: f */
        ImageView f10779f;

        /* JADX INFO: renamed from: g */
        CircleTextImageView f10780g;

        /* JADX INFO: renamed from: h */
        ImageView f10781h;

        /* JADX INFO: renamed from: i */
        RelativeLayout f10782i;

        /* JADX INFO: renamed from: j */
        RelativeLayout f10783j;

        /* JADX INFO: renamed from: k */
        RelativeLayout f10784k;

        /* JADX INFO: renamed from: l */
        ImageView f10785l;

        a() {
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10005a(final int i, final ImageView imageView, final String str, String str2) {
        View viewInflate;
        this.f10735j = new PopupWindow(this.f10734i);
        String strM10480a = C1902me.m10480a(this.f10734i);
        Log.e("Video_Msg_Adapter", "ID: " + strM10480a);
        if (strM10480a.equals(str2)) {
            viewInflate = this.f10728c.inflate(R.layout.layout_share_popwindow_two_myself, (ViewGroup) null);
        } else {
            viewInflate = this.f10728c.inflate(R.layout.layout_share_popwindow_two, (ViewGroup) null);
        }
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: jp.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10735j.dismiss();
            }
        });
        this.f10735j.setWidth(-1);
        this.f10735j.setHeight(-2);
        this.f10735j.setBackgroundDrawable(new BitmapDrawable());
        this.f10735j.setFocusable(false);
        this.f10735j.setOutsideTouchable(true);
        this.f10735j.setTouchable(true);
        this.f10735j.setContentView(viewInflate);
        this.f10735j.showAtLocation(viewInflate, 17, 0, 0);
        final RadioButton radioButton = (RadioButton) viewInflate.findViewById(R.id.contion);
        RadioButton radioButton2 = (RadioButton) viewInflate.findViewById(R.id.weixin);
        RadioButton radioButton3 = (RadioButton) viewInflate.findViewById(R.id.qq);
        RadioButton radioButton4 = (RadioButton) viewInflate.findViewById(R.id.qqkj);
        ((RadioButton) viewInflate.findViewById(R.id.friends)).setOnClickListener(this);
        radioButton4.setOnClickListener(this);
        radioButton3.setOnClickListener(this);
        radioButton2.setOnClickListener(this);
        RadioButton radioButton5 = (RadioButton) viewInflate.findViewById(R.id.delete);
        if (radioButton5 != null) {
            radioButton5.setOnClickListener(new View.OnClickListener() { // from class: jp.14
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    ViewOnClickListenerC1832jp.this.f10729d.m10246q(str);
                    ViewOnClickListenerC1832jp.this.m10007b(i);
                    ViewOnClickListenerC1832jp.this.notifyDataSetChanged();
                    ViewOnClickListenerC1832jp.this.f10735j.dismiss();
                }
            });
        }
        if (imageView.isSelected()) {
            radioButton.setSelected(true);
        } else {
            radioButton.setSelected(false);
        }
        radioButton.setOnClickListener(new View.OnClickListener() { // from class: jp.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (radioButton.isSelected()) {
                    radioButton.setSelected(false);
                    ViewOnClickListenerC1832jp.this.f10729d.m10244p(str);
                    imageView.setSelected(false);
                } else {
                    ViewOnClickListenerC1832jp.this.f10729d.m10238m(str);
                    radioButton.setSelected(true);
                    imageView.setSelected(true);
                }
            }
        });
        final RadioButton radioButton6 = (RadioButton) viewInflate.findViewById(R.id.good);
        radioButton6.setOnClickListener(new View.OnClickListener() { // from class: jp.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (radioButton6.isSelected()) {
                    radioButton6.setSelected(false);
                } else {
                    radioButton6.setSelected(true);
                }
            }
        });
        ((RadioButton) viewInflate.findViewById(R.id.report)).setOnClickListener(new View.OnClickListener() { // from class: jp.17
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10735j.dismiss();
                ViewOnClickListenerC1832jp.this.m10004a(i);
            }
        });
        ((RelativeLayout) viewInflate.findViewById(R.id.layout_cancel)).setOnClickListener(new View.OnClickListener() { // from class: jp.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10735j.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10004a(final int i) {
        this.f10736k = new PopupWindow(this.f10734i);
        View viewInflate = this.f10728c.inflate(R.layout.layout_pop_report, (ViewGroup) null);
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: jp.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
        this.f10736k.setWidth(-1);
        this.f10736k.setHeight(-2);
        this.f10736k.setBackgroundDrawable(new BitmapDrawable());
        this.f10736k.setFocusable(false);
        this.f10736k.setOutsideTouchable(true);
        this.f10736k.setTouchable(true);
        this.f10736k.setContentView(viewInflate);
        this.f10736k.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.report1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.report2);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.report3);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.report4);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.report5);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.cancel);
        Log.e("Video_Msg_Adapter", "setpopwinds_report: " + this.f10730e.get(i).f7437ID);
        textView.setOnClickListener(new View.OnClickListener() { // from class: jp.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10729d.m10227h("1", ((Video_msg_Bean.C1216d2) ViewOnClickListenerC1832jp.this.f10730e.get(i)).f7437ID);
                Toast.makeText(ViewOnClickListenerC1832jp.this.f10734i, "举报成功", 0).show();
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: jp.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10729d.m10227h("2", ((Video_msg_Bean.C1216d2) ViewOnClickListenerC1832jp.this.f10730e.get(i)).f7437ID);
                Toast.makeText(ViewOnClickListenerC1832jp.this.f10734i, "举报成功", 0).show();
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: jp.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10729d.m10227h("3", ((Video_msg_Bean.C1216d2) ViewOnClickListenerC1832jp.this.f10730e.get(i)).f7437ID);
                Toast.makeText(ViewOnClickListenerC1832jp.this.f10734i, "举报成功", 0).show();
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: jp.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10729d.m10227h("4", ((Video_msg_Bean.C1216d2) ViewOnClickListenerC1832jp.this.f10730e.get(i)).f7437ID);
                Toast.makeText(ViewOnClickListenerC1832jp.this.f10734i, "举报成功", 0).show();
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: jp.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10729d.m10227h("5", ((Video_msg_Bean.C1216d2) ViewOnClickListenerC1832jp.this.f10730e.get(i)).f7437ID);
                Toast.makeText(ViewOnClickListenerC1832jp.this.f10734i, "举报成功", 0).show();
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() { // from class: jp.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ViewOnClickListenerC1832jp.this.f10736k.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m10007b(int i) {
        Log.e("Video_Msg_Adapter", "delete_item: ");
        this.f10730e.remove(i);
    }
}
