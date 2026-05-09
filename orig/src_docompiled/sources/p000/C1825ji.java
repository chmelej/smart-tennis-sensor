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
import com.coollang.tennis.beans.Video_msg_Bean;
import java.util.List;

/* JADX INFO: renamed from: ji */
/* JADX INFO: compiled from: Search_listview_adapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1825ji extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    Context f10618a;

    /* JADX INFO: renamed from: b */
    private List<Video_msg_Bean.C1216d2> f10619b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1825ji(Context context, List<Video_msg_Bean.C1216d2> list) {
        this.f10618a = context;
        this.f10619b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10619b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10619b.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f10618a);
        if (view == null) {
            view = layoutInflaterFrom.inflate(R.layout.search_video_iteam, (ViewGroup) null);
            aVar = new a();
            aVar.f10622a = (TextView) view.findViewById(R.id.text_title);
            aVar.f10623b = (TextView) view.findViewById(R.id.CreateTime);
            aVar.f10624c = (TextView) view.findViewById(R.id.Duration);
            aVar.f10627f = (LinearLayout) view.findViewById(R.id.layout_paly);
            aVar.f10626e = (ImageView) view.findViewById(R.id.video_img);
            aVar.f10625d = (TextView) view.findViewById(R.id.lk_count);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        final Video_msg_Bean.C1216d2 c1216d2 = this.f10619b.get(i);
        String strM10534a = C1912mk.m10534a(Long.parseLong(c1216d2.CreateTime));
        String strM10544d = C1912mk.m10544d(Long.parseLong(c1216d2.Duration));
        aVar.f10622a.setText(c1216d2.Title);
        aVar.f10623b.setText(strM10534a);
        C2253xu.m12305a(this.f10618a).m12312a(c1216d2.Thumb).m12348a(aVar.f10626e);
        aVar.f10624c.setText(strM10544d);
        aVar.f10625d.setText(c1216d2.Views);
        aVar.f10627f.setOnClickListener(new View.OnClickListener() { // from class: ji.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Intent intent = new Intent();
                intent.putExtra("bean", c1216d2);
                intent.setClass(C1825ji.this.f10618a, Video_detail_Activity.class);
                C1825ji.this.f10618a.startActivity(intent);
            }
        });
        return view;
    }

    /* JADX INFO: renamed from: ji$a */
    /* JADX INFO: compiled from: Search_listview_adapter.java */
    static class a {

        /* JADX INFO: renamed from: a */
        TextView f10622a;

        /* JADX INFO: renamed from: b */
        TextView f10623b;

        /* JADX INFO: renamed from: c */
        TextView f10624c;

        /* JADX INFO: renamed from: d */
        TextView f10625d;

        /* JADX INFO: renamed from: e */
        ImageView f10626e;

        /* JADX INFO: renamed from: f */
        LinearLayout f10627f;

        a() {
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9919a(List<Video_msg_Bean.C1216d2> list) {
        this.f10619b.addAll(list);
    }
}
