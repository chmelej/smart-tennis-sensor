package p000;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.ChildResponseListBean;
import com.coollang.tennis.beans.CommentBean;

/* JADX INFO: renamed from: iw */
/* JADX INFO: compiled from: CommemtAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1812iw extends RecyclerView.AbstractC0603a<a> {

    /* JADX INFO: renamed from: b */
    private static final String f10379b = "iw";

    /* JADX INFO: renamed from: a */
    CommentBean.Cont.C1209D3 f10380a;

    /* JADX INFO: renamed from: c */
    private String f10381c;

    /* JADX INFO: renamed from: d */
    private int f10382d;

    public C1812iw(CommentBean.Cont.C1209D3 c1209d3, String str, int i) {
        this.f10380a = c1209d3;
        this.f10381c = str;
        this.f10382d = i;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public a mo3871b(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_child_listview, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void mo3867a(a aVar, int i) {
        final ChildResponseListBean childResponseListBean = this.f10380a.ChildResponseList.get(i);
        String string = aVar.f3823a.getContext().getString(R.string.reply);
        final String str = childResponseListBean.UserName;
        String str2 = "";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        Log.d(f10379b, "onBindViewHolder: UserID" + childResponseListBean.UserID + "===" + childResponseListBean.Quote.UserID);
        if (childResponseListBean.Quote != null && !TextUtils.isEmpty(childResponseListBean.Quote.UserName) && childResponseListBean.UserID != childResponseListBean.Quote.UserID) {
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
        aVar.f10386q.setText(spannableString);
        aVar.f3823a.setOnClickListener(new View.OnClickListener() { // from class: iw.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                akd.m1706a().m1722c(new C1873lc(str, 1, 999));
                akd.m1706a().m1722c(new C1873lc(childResponseListBean.ParentID, 1, 998));
            }
        });
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public int mo3863a() {
        if (this.f10382d == 0) {
            return this.f10380a.ChildResponseList.size();
        }
        if (this.f10380a.ChildResponseList.size() >= 2) {
            return 2;
        }
        return this.f10380a.ChildResponseList.size();
    }

    /* JADX INFO: renamed from: iw$a */
    /* JADX INFO: compiled from: CommemtAdapter.java */
    static class a extends RecyclerView.AbstractC0624v {

        /* JADX INFO: renamed from: q */
        TextView f10386q;

        public a(View view) {
            super(view);
            this.f10386q = (TextView) view.findViewById(R.id.tv_comment_content);
        }
    }
}
