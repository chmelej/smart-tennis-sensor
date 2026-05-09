package p000;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagFlowLayout;

/* JADX INFO: renamed from: iy */
/* JADX INFO: compiled from: FlowLayout_Adapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1814iy extends aka {

    /* JADX INFO: renamed from: a */
    private String[] f10403a;

    /* JADX INFO: renamed from: b */
    private LayoutInflater f10404b;

    /* JADX INFO: renamed from: c */
    private TagFlowLayout f10405c;

    public C1814iy(Context context, Object[] objArr, TagFlowLayout tagFlowLayout) {
        super(objArr);
        this.f10403a = (String[]) objArr;
        this.f10404b = LayoutInflater.from(context);
        this.f10405c = tagFlowLayout;
    }

    @Override // p000.aka
    /* JADX INFO: renamed from: a */
    public View mo1696a(FlowLayout flowLayout, int i, Object obj) {
        TextView textView = (TextView) this.f10404b.inflate(R.layout.textview_view, (ViewGroup) this.f10405c, false);
        textView.setText(this.f10403a[i]);
        return textView;
    }
}
