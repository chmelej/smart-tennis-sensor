package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.MyvideoBean;
import java.util.List;

/* JADX INFO: renamed from: jc */
/* JADX INFO: compiled from: MyVideoAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1819jc extends BaseAdapter {

    /* JADX INFO: renamed from: d */
    public static int f10486d = -1;

    /* JADX INFO: renamed from: a */
    List<MyvideoBean.C1210d2> f10487a;

    /* JADX INFO: renamed from: b */
    Context f10488b;

    /* JADX INFO: renamed from: c */
    public LayoutInflater f10489c;

    /* JADX INFO: renamed from: e */
    C1874ld f10490e = new C1874ld();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1819jc(Context context, List<MyvideoBean.C1210d2> list) {
        this.f10487a = list;
        this.f10488b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10487a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10487a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        this.f10489c = LayoutInflater.from(this.f10488b);
        if (view == null) {
            view = this.f10489c.inflate(R.layout.item_my_video, viewGroup, false);
            aVar = new a(view);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        MyvideoBean.C1210d2 c1210d2 = this.f10487a.get(i);
        C2253xu.m12305a(this.f10488b).m12312a(c1210d2.Thumb).m12348a(aVar.f10494d);
        aVar.f10492b.setText(C1912mk.m10544d(Long.parseLong(c1210d2.Duration)));
        aVar.f10491a.setText(C1912mk.m10534a(Long.parseLong(c1210d2.CreateTime)));
        aVar.f10493c.setText(c1210d2.Title);
        return view;
    }

    /* JADX INFO: renamed from: a */
    public void m9860a(List<MyvideoBean.C1210d2> list) {
        this.f10487a.addAll(list);
    }

    /* JADX INFO: renamed from: jc$a */
    /* JADX INFO: compiled from: MyVideoAdapter.java */
    static class a {

        /* JADX INFO: renamed from: a */
        TextView f10491a;

        /* JADX INFO: renamed from: b */
        TextView f10492b;

        /* JADX INFO: renamed from: c */
        TextView f10493c;

        /* JADX INFO: renamed from: d */
        ImageView f10494d;

        /* JADX INFO: renamed from: e */
        TextView f10495e;

        public a(View view) {
            this.f10491a = (TextView) view.findViewById(R.id.tv_create_time);
            this.f10492b = (TextView) view.findViewById(R.id.Duration);
            this.f10493c = (TextView) view.findViewById(R.id.tv_title);
            this.f10494d = (ImageView) view.findViewById(R.id.image_cover);
            this.f10495e = (TextView) view.findViewById(R.id.tv_look_count);
        }
    }
}
