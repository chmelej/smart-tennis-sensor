package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.coollang.tennis.R;

/* JADX INFO: renamed from: jf */
/* JADX INFO: compiled from: RacketListAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1822jf extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    private String[] f10520a;

    /* JADX INFO: renamed from: b */
    private Context f10521b;

    /* JADX INFO: renamed from: c */
    private a f10522c;

    /* JADX INFO: renamed from: d */
    private int f10523d;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1822jf(Context context, String[] strArr, int i) {
        this.f10521b = context;
        if (strArr != null) {
            this.f10520a = strArr;
        } else {
            this.f10520a = new String[0];
        }
        this.f10523d = i;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f10520a.length;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public String getItem(int i) {
        return this.f10520a[i];
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f10521b).inflate(R.layout.item_racket_name, (ViewGroup) null);
            if (this.f10523d == 1 || this.f10523d == 3) {
                this.f10522c = new a(view, 14);
            } else {
                this.f10522c = new a(view, 16);
            }
            view.setTag(this.f10522c);
        } else {
            this.f10522c = (a) view.getTag();
        }
        this.f10522c.f10524a.setText(this.f10520a[i]);
        if (this.f10523d == 0) {
            if (i == 0) {
                this.f10522c.f10525b.setVisibility(8);
            } else {
                this.f10522c.f10525b.setVisibility(0);
            }
        } else if (this.f10523d == 1) {
            this.f10522c.f10525b.setVisibility(8);
        } else if (this.f10523d == 2) {
            this.f10522c.f10525b.setVisibility(0);
        }
        if (i == this.f10520a.length - 1) {
            this.f10522c.f10526c.setVisibility(8);
        } else {
            this.f10522c.f10526c.setVisibility(0);
        }
        return view;
    }

    /* JADX INFO: renamed from: jf$a */
    /* JADX INFO: compiled from: RacketListAdapter.java */
    class a {

        /* JADX INFO: renamed from: a */
        TextView f10524a;

        /* JADX INFO: renamed from: b */
        ImageView f10525b;

        /* JADX INFO: renamed from: c */
        View f10526c;

        public a(View view, int i) {
            this.f10524a = (TextView) view.findViewById(R.id.tv_name);
            this.f10525b = (ImageView) view.findViewById(R.id.img_arrow);
            this.f10526c = view.findViewById(R.id.line);
            this.f10524a.setTextSize(i);
        }
    }
}
