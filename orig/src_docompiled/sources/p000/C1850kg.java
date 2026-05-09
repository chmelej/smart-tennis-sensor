package p000;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import java.util.List;

/* JADX INFO: renamed from: kg */
/* JADX INFO: compiled from: ImageGridAdapter_new.java */
/* JADX INFO: loaded from: classes.dex */
public class C1850kg extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private Context f10904a;

    /* JADX INFO: renamed from: b */
    private List<C1851kh> f10905b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1850kg(Context context, List<C1851kh> list) {
        this.f10904a = context;
        this.f10905b = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f10905b == null) {
            return 0;
        }
        return this.f10905b.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10905b.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.f10904a, R.layout.item_image_list, null);
            aVar = new a();
            aVar.f10906a = (ImageView) view.findViewById(R.id.image);
            aVar.f10907b = (ImageView) view.findViewById(R.id.selected_tag);
            aVar.f10908c = (TextView) view.findViewById(R.id.image_selected_bg);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        C1851kh c1851kh = this.f10905b.get(i);
        C1848ke.m10084a(this.f10904a).m10089a(aVar.f10906a, c1851kh.f10910b, c1851kh.f10911c);
        aVar.f10907b.setImageDrawable(null);
        aVar.f10907b.setVisibility(8);
        aVar.f10908c.setBackgroundResource(R.color.light_gray);
        return view;
    }

    /* JADX INFO: renamed from: kg$a */
    /* JADX INFO: compiled from: ImageGridAdapter_new.java */
    static class a {

        /* JADX INFO: renamed from: a */
        private ImageView f10906a;

        /* JADX INFO: renamed from: b */
        private ImageView f10907b;

        /* JADX INFO: renamed from: c */
        private TextView f10908c;

        a() {
        }
    }
}
