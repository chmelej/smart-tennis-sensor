package p000;

import android.content.Context;
import android.support.v4.view.PointerIconCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.beans.ChildResponseListBean;
import com.coollang.tennis.beans.CommentBean;
import com.thinkcool.circletextimageview.CircleTextImageView;
import java.util.List;

/* JADX INFO: renamed from: ix */
/* JADX INFO: compiled from: CommentDetailView.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1813ix implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    C1833jq f10387a;

    /* JADX INFO: renamed from: b */
    private Context f10388b;

    /* JADX INFO: renamed from: c */
    private LayoutInflater f10389c;

    /* JADX INFO: renamed from: d */
    private ImageView f10390d;

    /* JADX INFO: renamed from: e */
    private CircleTextImageView f10391e;

    /* JADX INFO: renamed from: f */
    private TextView f10392f;

    /* JADX INFO: renamed from: g */
    private TextView f10393g;

    /* JADX INFO: renamed from: h */
    private TextView f10394h;

    /* JADX INFO: renamed from: i */
    private TextView f10395i;

    /* JADX INFO: renamed from: j */
    private ImageView f10396j;

    /* JADX INFO: renamed from: k */
    private ListView f10397k;

    /* JADX INFO: renamed from: l */
    private C1874ld f10398l = new C1874ld();

    /* JADX INFO: renamed from: m */
    private String f10399m;

    /* JADX INFO: renamed from: n */
    private int f10400n;

    /* JADX INFO: renamed from: o */
    private ImageView f10401o;

    /* JADX INFO: renamed from: p */
    private List<ChildResponseListBean> f10402p;

    public ViewOnClickListenerC1813ix(Context context) {
        this.f10388b = context;
        this.f10389c = LayoutInflater.from(this.f10388b);
    }

    /* JADX INFO: renamed from: a */
    public View m9832a(ViewGroup viewGroup) {
        View viewInflate = this.f10389c.inflate(R.layout.activity_detail_comment, viewGroup, false);
        this.f10391e = (CircleTextImageView) viewInflate.findViewById(R.id.per_img);
        this.f10393g = (TextView) viewInflate.findViewById(R.id.time_comment);
        this.f10392f = (TextView) viewInflate.findViewById(R.id.textconntent);
        this.f10391e = (CircleTextImageView) viewInflate.findViewById(R.id.per_img);
        this.f10395i = (TextView) viewInflate.findViewById(R.id.usrname);
        this.f10394h = (TextView) viewInflate.findViewById(R.id.comment_like_count);
        this.f10390d = (ImageView) viewInflate.findViewById(R.id.back);
        this.f10396j = (ImageView) viewInflate.findViewById(R.id.isgood_comment);
        this.f10397k = (ListView) viewInflate.findViewById(R.id.Child_listview);
        this.f10401o = (ImageView) viewInflate.findViewById(R.id.Comment_more);
        this.f10396j.setOnClickListener(this);
        this.f10390d.setOnClickListener(this);
        return viewInflate;
    }

    /* JADX INFO: renamed from: a */
    public void m9834a(CommentBean.Cont.C1209D3 c1209d3) {
        if (c1209d3 != null) {
            this.f10395i.setText(c1209d3.UserName);
            if (c1209d3.UserName != null) {
                this.f10395i.setText(c1209d3.UserName);
            }
            if (c1209d3.Content != null) {
                this.f10392f.setText(c1209d3.Content);
            }
            this.f10393g.setText(C1912mk.m10534a(c1209d3.CreateTime != null ? Long.parseLong(c1209d3.CreateTime) : 0L));
            if (c1209d3.Icon != null && !c1209d3.Icon.equals("")) {
                C2253xu.m12305a(this.f10388b).m12312a(c1209d3.Icon).m12348a(this.f10391e);
            }
            int i = 0;
            int i2 = c1209d3.IsLiked != null ? Integer.parseInt(c1209d3.IsLiked) : 0;
            if (c1209d3.LikeCount != null) {
                i = Integer.parseInt(c1209d3.LikeCount);
                this.f10400n = i;
            }
            if (i2 == 1) {
                this.f10396j.setSelected(true);
            }
            if (i != 0) {
                this.f10394h.setText(String.valueOf(i));
            }
            this.f10402p = c1209d3.ChildResponseList;
            this.f10387a = new C1833jq(this.f10388b, c1209d3, true);
            this.f10397k.setAdapter((ListAdapter) this.f10387a);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9833a(ChildResponseListBean childResponseListBean) {
        if (this.f10402p != null) {
            this.f10402p.add(0, childResponseListBean);
            this.f10387a.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.back) {
            akd.m1706a().m1722c(new C1873lc(" ", PointerIconCompat.TYPE_CONTEXT_MENU, 72));
            return;
        }
        if (id != R.id.isgood_comment) {
            return;
        }
        if (this.f10396j.isSelected()) {
            this.f10398l.m10224g(this.f10399m, "0");
            this.f10396j.setSelected(false);
            this.f10400n--;
            if (this.f10400n == 0) {
                this.f10394h.setText("赞");
                return;
            }
            this.f10394h.setText(this.f10400n + "");
            return;
        }
        this.f10400n++;
        this.f10398l.m10224g(this.f10399m, "1");
        this.f10396j.setSelected(true);
        this.f10394h.setText(this.f10400n + "");
    }
}
