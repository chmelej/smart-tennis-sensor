package p000;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.widget.CountView;

/* JADX INFO: renamed from: iz */
/* JADX INFO: compiled from: HistoryGridviewAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1815iz extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private Context f10406a;

    /* JADX INFO: renamed from: b */
    private String[] f10407b = {"Cal", "times", "hours", "km/h"};

    /* JADX INFO: renamed from: c */
    private String[] f10408c = {"0", "0", "0", "0", "0", "0"};

    /* JADX INFO: renamed from: d */
    private String[] f10409d = {C1914mm.m10557b(R.string.check_history_title01), C1914mm.m10557b(R.string.check_history_title02), C1914mm.m10557b(R.string.check_history_title03), C1914mm.m10557b(R.string.check_history_title04), C1914mm.m10557b(R.string.check_history_title05), C1914mm.m10557b(R.string.check_history_title06)};

    @Override // android.widget.Adapter
    public int getCount() {
        return 6;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1815iz(Context context) {
        this.f10406a = context;
    }

    /* JADX INFO: renamed from: a */
    public void m9835a(Context context, String[] strArr) {
        this.f10406a = context;
        this.f10408c = strArr;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.f10406a, R.layout.item_gridview_history, null);
            aVar = new a();
            aVar.f10410a = (TextView) view.findViewById(R.id.type);
            aVar.f10411b = (CountView) view.findViewById(R.id.number);
            aVar.f10412c = (TextView) view.findViewById(R.id.unit);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        switch (i) {
            case 0:
                aVar.f10410a.setText(this.f10409d[i]);
                aVar.f10411b.m8106a(Integer.parseInt(this.f10408c[i]));
                aVar.f10412c.setText(this.f10407b[0]);
                return view;
            case 1:
                aVar.f10410a.setText(this.f10409d[i]);
                aVar.f10411b.m8106a(Integer.parseInt(this.f10408c[i]));
                aVar.f10412c.setText(this.f10407b[1]);
                return view;
            case 2:
                aVar.f10410a.setText(this.f10409d[i]);
                aVar.f10411b.m8105a(Float.valueOf(C1908mg.m10519a(this.f10408c[i])).floatValue());
                aVar.f10412c.setText(this.f10407b[2]);
                return view;
            case 3:
                aVar.f10410a.setText(this.f10409d[i]);
                aVar.f10411b.m8106a(Integer.parseInt(this.f10408c[i]));
                aVar.f10412c.setText(this.f10407b[0]);
                return view;
            case 4:
                aVar.f10410a.setText(this.f10409d[i]);
                aVar.f10411b.m8106a(Integer.parseInt(this.f10408c[i]));
                aVar.f10412c.setText(this.f10407b[1]);
                return view;
            case 5:
                aVar.f10410a.setText(this.f10409d[i]);
                aVar.f10411b.m8106a(Integer.parseInt(this.f10408c[i]));
                aVar.f10412c.setText(this.f10407b[3]);
                return view;
            default:
                return view;
        }
    }

    /* JADX INFO: renamed from: iz$a */
    /* JADX INFO: compiled from: HistoryGridviewAdapter.java */
    class a {

        /* JADX INFO: renamed from: a */
        TextView f10410a;

        /* JADX INFO: renamed from: b */
        CountView f10411b;

        /* JADX INFO: renamed from: c */
        TextView f10412c;

        a() {
        }
    }
}
