package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.SettingHistoryItemBean;
import java.util.List;

/* JADX INFO: renamed from: jj */
/* JADX INFO: compiled from: SettingHistoryAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1826jj extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private List<SettingHistoryItemBean> f10628a;

    /* JADX INFO: renamed from: b */
    private Context f10629b;

    /* JADX INFO: renamed from: c */
    private int f10630c = 1200;

    /* JADX INFO: renamed from: d */
    private a f10631d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1826jj(List<SettingHistoryItemBean> list, Context context) {
        this.f10628a = list;
        this.f10629b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10628a.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SettingHistoryItemBean getItem(int i) {
        return this.f10628a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f10629b).inflate(R.layout.item_setting_person_his, (ViewGroup) null);
            this.f10631d = new a(view);
            view.setTag(this.f10631d);
        } else {
            this.f10631d = (a) view.getTag();
        }
        this.f10631d.f10633b.setText(String.format(this.f10629b.getString(R.string.person_history_format), this.f10628a.get(i).Year));
        this.f10631d.f10634c.setText(this.f10628a.get(i).Career);
        this.f10631d.f10635d.setTag(Integer.valueOf(i));
        if (this.f10630c == 1201) {
            this.f10631d.f10635d.setVisibility(0);
            if (this.f10628a.get(i).isChecked) {
                this.f10631d.f10635d.setImageResource(R.drawable.img_ck_archieve);
            } else {
                this.f10631d.f10635d.setImageResource(R.drawable.img_no_ck_archieve);
            }
        } else {
            this.f10631d.f10635d.setVisibility(8);
        }
        return view;
    }

    /* JADX INFO: renamed from: b */
    public void m9921b(int i) {
        this.f10630c = i;
        if (i == 1200) {
            for (int i2 = 0; i2 < this.f10628a.size(); i2++) {
                this.f10628a.get(i2).isChecked = false;
            }
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: jj$a */
    /* JADX INFO: compiled from: SettingHistoryAdapter.java */
    class a {

        /* JADX INFO: renamed from: b */
        private TextView f10633b;

        /* JADX INFO: renamed from: c */
        private TextView f10634c;

        /* JADX INFO: renamed from: d */
        private ImageView f10635d;

        public a(View view) {
            this.f10633b = (TextView) view.findViewById(R.id.tv_year_setting_his);
            this.f10634c = (TextView) view.findViewById(R.id.tv_desc_setting_his);
            this.f10635d = (ImageView) view.findViewById(R.id.img_ck_setting_history);
        }
    }
}
