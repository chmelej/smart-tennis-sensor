package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import java.util.List;

/* JADX INFO: renamed from: jo */
/* JADX INFO: compiled from: VideoBaseadapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1831jo extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    List<String> f10718a;

    /* JADX INFO: renamed from: b */
    Context f10719b;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1831jo(Context context, List<String> list) {
        this.f10719b = context;
        this.f10718a = list;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10718a.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10718a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.f10719b);
        if (view == null) {
            view = layoutInflaterFrom.inflate(R.layout.his_layout, (ViewGroup) null);
            aVar = new a();
            aVar.f10724a = (TextView) view.findViewById(R.id.text_data);
            aVar.f10725b = (ImageView) view.findViewById(R.id.delete);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        aVar.f10724a.setText(this.f10718a.get(i));
        aVar.f10724a.setOnClickListener(new View.OnClickListener() { // from class: jo.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                akd.m1706a().m1722c(new C1873lc(C1831jo.this.f10718a.get(i), 1, 123));
            }
        });
        aVar.f10725b.setOnClickListener(new View.OnClickListener() { // from class: jo.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                Toast.makeText(C1831jo.this.f10719b, "删除", 0).show();
                new C1857kn(C1831jo.this.f10719b).m10121b(C1831jo.this.f10718a.get(i));
                C1831jo.this.f10718a.remove(C1831jo.this.f10718a.get(i));
                C1831jo.this.notifyDataSetChanged();
            }
        });
        return view;
    }

    /* JADX INFO: renamed from: jo$a */
    /* JADX INFO: compiled from: VideoBaseadapter.java */
    static class a {

        /* JADX INFO: renamed from: a */
        TextView f10724a;

        /* JADX INFO: renamed from: b */
        ImageView f10725b;

        a() {
        }
    }
}
