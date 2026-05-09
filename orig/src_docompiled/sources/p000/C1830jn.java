package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.TrainHistoryListBean;
import java.util.ArrayList;

/* JADX INFO: renamed from: jn */
/* JADX INFO: compiled from: TrainHistoryAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1830jn extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private ArrayList<TrainHistoryListBean> f10710a;

    /* JADX INFO: renamed from: b */
    private Context f10711b;

    /* JADX INFO: renamed from: c */
    private a f10712c;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1830jn(ArrayList<TrainHistoryListBean> arrayList, Context context) {
        this.f10710a = arrayList;
        this.f10711b = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10710a.size();
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public TrainHistoryListBean getItem(int i) {
        return this.f10710a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        Context context;
        int i2;
        if (view == null) {
            view = LayoutInflater.from(this.f10711b).inflate(R.layout.item_train_history, viewGroup, false);
            this.f10712c = new a(view);
            view.setTag(this.f10712c);
        } else {
            this.f10712c = (a) view.getTag();
        }
        this.f10712c.f10714b.setText(this.f10710a.get(i).time);
        TextView textView = this.f10712c.f10715c;
        if (this.f10710a.get(i).trainType == 0) {
            context = this.f10711b;
            i2 = R.string.hand_train_history;
        } else {
            context = this.f10711b;
            i2 = R.string.hand_train_send;
        }
        textView.setText(context.getString(i2));
        this.f10712c.f10716d.setText(String.valueOf(this.f10710a.get(i).duration));
        this.f10712c.f10717e.setText(String.valueOf(this.f10710a.get(i).totalCount));
        return view;
    }

    /* JADX INFO: renamed from: jn$a */
    /* JADX INFO: compiled from: TrainHistoryAdapter.java */
    class a {

        /* JADX INFO: renamed from: b */
        private TextView f10714b;

        /* JADX INFO: renamed from: c */
        private TextView f10715c;

        /* JADX INFO: renamed from: d */
        private TextView f10716d;

        /* JADX INFO: renamed from: e */
        private TextView f10717e;

        public a(View view) {
            this.f10714b = (TextView) view.findViewById(R.id.tv_train_start_time);
            this.f10715c = (TextView) view.findViewById(R.id.tv_train_hand_type);
            this.f10716d = (TextView) view.findViewById(R.id.tv_train_keep_time);
            this.f10717e = (TextView) view.findViewById(R.id.tv_train_total_hit);
        }
    }
}
