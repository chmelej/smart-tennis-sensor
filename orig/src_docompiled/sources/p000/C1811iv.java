package p000;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.BallStartListBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: iv */
/* JADX INFO: compiled from: BallStarTeachAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1811iv extends BaseExpandableListAdapter {

    /* JADX INFO: renamed from: a */
    private b f10369a;

    /* JADX INFO: renamed from: b */
    private a f10370b;

    /* JADX INFO: renamed from: c */
    private HashMap<String, List<BallStartListBean.BallStarVideoBean>> f10371c;

    /* JADX INFO: renamed from: d */
    private List<String> f10372d;

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public C1811iv(HashMap<String, List<BallStartListBean.BallStarVideoBean>> map, ArrayList<String> arrayList) {
        this.f10372d = new ArrayList();
        this.f10371c = map;
        this.f10372d = arrayList;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f10372d.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f10371c.get(this.f10372d.get(i)).size();
    }

    @Override // android.widget.ExpandableListAdapter
    public Object getGroup(int i) {
        return this.f10372d.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public BallStartListBean.BallStarVideoBean getChild(int i, int i2) {
        return this.f10371c.get(this.f10372d.get(i)).get(i2);
    }

    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10369a = new b();
            view = C1914mm.m10555a(R.layout.item_ball_start_group_title);
            this.f10369a.f10377a = (TextView) view.findViewById(R.id.tv_title);
            view.setTag(this.f10369a);
        } else {
            this.f10369a = (b) view.getTag();
        }
        this.f10369a.f10377a.setText(this.f10372d.get(i));
        return view;
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            this.f10370b = new a();
            view = C1914mm.m10555a(R.layout.item_ball_start_child);
            this.f10370b.f10373a = (ImageView) view.findViewById(R.id.imgv_ball_star_show);
            this.f10370b.f10374b = (TextView) view.findViewById(R.id.tv_name_ball_star);
            this.f10370b.f10375c = (TextView) view.findViewById(R.id.tv_time_ball_star);
            view.setTag(this.f10370b);
        } else {
            this.f10370b = (a) view.getTag();
        }
        C2068qy.m11356a().m11360a(this.f10371c.get(this.f10372d.get(i)).get(i2).getPicUrl(), this.f10370b.f10373a);
        this.f10370b.f10374b.setText(this.f10371c.get(this.f10372d.get(i)).get(i2).getName());
        this.f10370b.f10375c.setText(this.f10371c.get(this.f10372d.get(i)).get(i2).getTime());
        return view;
    }

    /* JADX INFO: renamed from: iv$b */
    /* JADX INFO: compiled from: BallStarTeachAdapter.java */
    class b {

        /* JADX INFO: renamed from: a */
        TextView f10377a;

        private b() {
        }
    }

    /* JADX INFO: renamed from: iv$a */
    /* JADX INFO: compiled from: BallStarTeachAdapter.java */
    class a {

        /* JADX INFO: renamed from: a */
        ImageView f10373a;

        /* JADX INFO: renamed from: b */
        TextView f10374b;

        /* JADX INFO: renamed from: c */
        TextView f10375c;

        private a() {
        }
    }
}
