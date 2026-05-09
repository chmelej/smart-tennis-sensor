package p000;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.ChildResponseListBean;
import com.coollang.tennis.beans.CommentBean;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: jq */
/* JADX INFO: compiled from: detail_listview_adapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1833jq extends BaseAdapter {

    /* JADX INFO: renamed from: a */
    List<ChildResponseListBean> f10786a;

    /* JADX INFO: renamed from: b */
    Context f10787b;

    /* JADX INFO: renamed from: e */
    public boolean f10790e;

    /* JADX INFO: renamed from: f */
    private CommentBean.Cont.C1209D3 f10791f;

    /* JADX INFO: renamed from: c */
    List<ChildResponseListBean> f10788c = new ArrayList();

    /* JADX INFO: renamed from: d */
    List<ChildResponseListBean> f10789d = new ArrayList();

    /* JADX INFO: renamed from: g */
    private String f10792g = "detail_listview_adapter";

    /* JADX INFO: renamed from: h */
    private C1874ld f10793h = new C1874ld();

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1833jq(Context context, CommentBean.Cont.C1209D3 c1209d3, boolean z) {
        this.f10790e = true;
        this.f10787b = context;
        this.f10791f = c1209d3;
        this.f10786a = m10008a(c1209d3);
        this.f10790e = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f10790e) {
            return this.f10786a.size();
        }
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return this.f10786a.get(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewInflate = LayoutInflater.from(this.f10787b).inflate(R.layout.item_child_listview, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(R.id.tv_comment_content);
        final ChildResponseListBean childResponseListBean = this.f10791f.ChildResponseList.get(i);
        String string = this.f10787b.getString(R.string.reply);
        final String str = childResponseListBean.UserName;
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (childResponseListBean.Quote != null && !TextUtils.isEmpty(childResponseListBean.Quote.UserName)) {
            str2 = childResponseListBean.Quote.UserName;
            sb.append(" ");
            sb.append(string);
            sb.append(" ");
            sb.append(str2);
        }
        sb.append(":");
        sb.append(childResponseListBean.Content);
        SpannableString spannableString = new SpannableString(sb.toString());
        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), 0, childResponseListBean.UserName.length(), 17);
        if (!TextUtils.isEmpty(str2)) {
            spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#999999")), str.length() + string.length() + 2, str.length() + string.length() + str2.length() + 2, 17);
        }
        textView.setText(spannableString);
        textView.setOnClickListener(new View.OnClickListener() { // from class: jq.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                akd.m1706a().m1722c(new C1873lc(str, 1, 999));
                akd.m1706a().m1722c(new C1873lc(childResponseListBean.ParentID, 1, 998));
            }
        });
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public List<ChildResponseListBean> m10008a(CommentBean.Cont.C1209D3 c1209d3) {
        List<ChildResponseListBean> list = c1209d3.ChildResponseList;
        if (list != null && !list.isEmpty()) {
            for (int i = 0; i < list.size(); i++) {
                ChildResponseListBean childResponseListBean = list.get(i);
                if (childResponseListBean != null) {
                    this.f10788c.add(childResponseListBean);
                }
            }
        }
        return this.f10788c;
    }

    /* JADX INFO: renamed from: a */
    public void m10009a(ChildResponseListBean childResponseListBean) {
        this.f10791f.ChildResponseList.add(childResponseListBean);
        notifyDataSetChanged();
    }
}
