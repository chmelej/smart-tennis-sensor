package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: je */
/* JADX INFO: compiled from: OperateListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1821je extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    String[] f10512a;

    /* JADX INFO: renamed from: b */
    int[] f10513b;

    /* JADX INFO: renamed from: c */
    Context f10514c;

    /* JADX INFO: renamed from: d */
    private int f10515d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1821je(Context context, int i) {
        this.f10514c = context;
        this.f10515d = i;
        Log.d("2015-12-24", "当前电量adapter=" + i);
        this.f10512a = context.getResources().getStringArray(R.array.operatelist);
        this.f10513b = new int[]{R.drawable.noconnect, R.drawable.modify, R.drawable.power, R.drawable.restart, R.drawable.turnoff, R.drawable.updata};
    }

    /* JADX INFO: renamed from: a */
    public void m9866a(int i) {
        this.f10515d = i;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10512a.length;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate;
        a aVar;
        if (view == null) {
            aVar = new a();
            viewInflate = View.inflate(this.f10514c, R.layout.operatelist_item, null);
            aVar.f10517b = (ImageView) viewInflate.findViewById(R.id.iv_mark);
            aVar.f10518c = (TextView) viewInflate.findViewById(R.id.operatename);
            aVar.f10516a = (TextView) viewInflate.findViewById(R.id.iv_battery);
            viewInflate.setTag(aVar);
        } else {
            viewInflate = view;
            aVar = (a) view.getTag();
        }
        if (this.f10515d > 100) {
            Drawable drawable = ContextCompat.getDrawable(this.f10514c, R.drawable.ic_shan_dian);
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            aVar.f10516a.setCompoundDrawables(drawable, null, null, null);
            aVar.f10516a.setText("");
        } else {
            aVar.f10516a.setText(this.f10515d + "");
        }
        if (i == 2) {
            aVar.f10516a.setVisibility(0);
            aVar.f10516a.setBackgroundResource(R.drawable.power_num);
        } else {
            aVar.f10516a.setVisibility(8);
        }
        aVar.f10517b.setImageResource(this.f10513b[i]);
        aVar.f10518c.setText(this.f10512a[i]);
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public int m9865a() {
        return this.f10515d;
    }

    /* JADX INFO: renamed from: je$a */
    /* JADX INFO: compiled from: OperateListAdapter.java */
    class a {

        /* JADX INFO: renamed from: a */
        public TextView f10516a;

        /* JADX INFO: renamed from: b */
        ImageView f10517b;

        /* JADX INFO: renamed from: c */
        TextView f10518c;

        a() {
        }
    }
}
