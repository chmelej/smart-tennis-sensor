package p000;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.Video_detail_Activity;
import com.coollang.tennis.beans.MymsgListBean;
import java.util.List;

/* JADX INFO: renamed from: jd */
/* JADX INFO: compiled from: Mymsg_Adapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1820jd extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    List<MymsgListBean.My_video_msgBean> f10496a;

    /* JADX INFO: renamed from: b */
    Context f10497b;

    /* JADX INFO: renamed from: c */
    private int f10498c;

    /* JADX INFO: renamed from: d */
    private String f10499d = "Mymsg_Adapter";

    /* JADX INFO: renamed from: e */
    private C1874ld f10500e = new C1874ld();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1820jd(Context context, List<MymsgListBean.My_video_msgBean> list) {
        this.f10497b = context;
        this.f10496a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10496a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10496a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f10497b);
        if (view == null) {
            view = layoutInflaterFrom.inflate(R.layout.mymsg_iteam_layout, (ViewGroup) null);
            aVar = new a();
            aVar.f10508e = (LinearLayout) view.findViewById(R.id.layout_paly);
            aVar.f10504a = (TextView) view.findViewById(R.id.person_name);
            aVar.f10511h = (ImageView) view.findViewById(R.id.User_img);
            aVar.f10509f = (ImageView) view.findViewById(R.id.video_img);
            aVar.f10505b = (TextView) view.findViewById(R.id.type_text);
            aVar.f10506c = (TextView) view.findViewById(R.id.msg_time);
            aVar.f10510g = (ImageView) view.findViewById(R.id.type_img);
            aVar.f10507d = (TextView) view.findViewById(R.id.Duration);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final MymsgListBean.My_video_msgBean my_video_msgBean = this.f10496a.get(i);
        aVar.f10508e.setOnClickListener(new View.OnClickListener() { // from class: jd.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                intent.putExtra("bean_index", 1);
                intent.putExtra("bean", my_video_msgBean);
                intent.setClass(C1820jd.this.f10497b, Video_detail_Activity.class);
                C1820jd.this.f10497b.startActivity(intent);
                C1820jd.this.f10498c = i;
            }
        });
        aVar.f10504a.setText(my_video_msgBean.UserName);
        switch (my_video_msgBean.Type) {
            case "0":
                aVar.f10505b.setText("赞了你的视频");
                aVar.f10510g.setImageResource(R.drawable.shouye_good_flase);
                break;
            case "1":
                aVar.f10505b.setText("评论了你的视频");
                aVar.f10510g.setImageResource(R.drawable.comment);
                break;
            case "2":
                aVar.f10505b.setText("评论了你的回复");
                aVar.f10510g.setImageResource(R.drawable.comment);
                break;
            case "3":
                aVar.f10505b.setText("赞了你的评论");
                aVar.f10510g.setImageResource(R.drawable.shouye_good_flase);
                break;
        }
        String strM10534a = C1912mk.m10534a(Long.parseLong(my_video_msgBean.CreateTime));
        String strM10544d = C1912mk.m10544d(Long.parseLong(my_video_msgBean.Duration));
        aVar.f10506c.setText(strM10534a);
        aVar.f10507d.setText(strM10544d);
        String str = my_video_msgBean.Icon;
        if (!str.equals("")) {
            C2253xu.m12305a(this.f10497b).m12312a(str).m12348a(aVar.f10511h);
        }
        C2253xu.m12305a(this.f10497b).m12312a(my_video_msgBean.Thumb).m12348a(aVar.f10509f);
        return view;
    }

    /* JADX INFO: renamed from: a */
    public void m9862a() {
        this.f10496a.clear();
    }

    /* JADX INFO: renamed from: jd$a */
    /* JADX INFO: compiled from: Mymsg_Adapter.java */
    static class a {

        /* JADX INFO: renamed from: a */
        TextView f10504a;

        /* JADX INFO: renamed from: b */
        TextView f10505b;

        /* JADX INFO: renamed from: c */
        TextView f10506c;

        /* JADX INFO: renamed from: d */
        TextView f10507d;

        /* JADX INFO: renamed from: e */
        LinearLayout f10508e;

        /* JADX INFO: renamed from: f */
        ImageView f10509f;

        /* JADX INFO: renamed from: g */
        ImageView f10510g;

        /* JADX INFO: renamed from: h */
        ImageView f10511h;

        a() {
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9863a(List<MymsgListBean.My_video_msgBean> list) {
        list.addAll(list);
    }

    /* JADX INFO: renamed from: b */
    public boolean m9864b() {
        return this.f10496a.isEmpty();
    }
}
