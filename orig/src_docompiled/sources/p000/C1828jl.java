package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import java.util.List;

/* JADX INFO: renamed from: jl */
/* JADX INFO: compiled from: TennisLevelAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1828jl extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private List<String> f10681a;

    /* JADX INFO: renamed from: b */
    private Context f10682b;

    /* JADX INFO: renamed from: c */
    private int f10683c;

    /* JADX INFO: renamed from: d */
    private a f10684d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1828jl(List<String> list, Context context, int i) {
        this.f10683c = -1;
        this.f10681a = list;
        this.f10682b = context;
        this.f10683c = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10681a.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.f10681a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f10682b).inflate(R.layout.item_tennis_level, (ViewGroup) null);
            this.f10684d = new a(view);
            view.setTag(this.f10684d);
        } else {
            this.f10684d = (a) view.getTag();
        }
        this.f10684d.f10685a.setText(this.f10681a.get(i));
        if (this.f10683c == i) {
            this.f10684d.f10686b.setVisibility(0);
        } else {
            this.f10684d.f10686b.setVisibility(8);
        }
        if (i == this.f10681a.size() - 1) {
            this.f10684d.f10687c.setVisibility(8);
        } else {
            this.f10684d.f10687c.setVisibility(0);
        }
        return view;
    }

    /* JADX INFO: renamed from: jl$a */
    /* JADX INFO: compiled from: TennisLevelAdapter.java */
    class a {

        /* JADX INFO: renamed from: a */
        TextView f10685a;

        /* JADX INFO: renamed from: b */
        ImageView f10686b;

        /* JADX INFO: renamed from: c */
        View f10687c;

        public a(View view) {
            this.f10685a = (TextView) view.findViewById(R.id.tv_name);
            this.f10686b = (ImageView) view.findViewById(R.id.img_arrow);
            this.f10687c = view.findViewById(R.id.line);
        }
    }
}
