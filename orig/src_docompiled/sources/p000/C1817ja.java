package p000;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.Custom.CommentTextLayout;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.Video_detail_Activity;
import com.coollang.tennis.beans.CommentBean;
import com.thinkcool.circletextimageview.CircleTextImageView;
import java.util.List;

/* JADX INFO: renamed from: ja */
/* JADX INFO: compiled from: MyAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1817ja extends RecyclerView.AbstractC0603a<RecyclerView.AbstractC0624v> {

    /* JADX INFO: renamed from: f */
    private static int f10414f;

    /* JADX INFO: renamed from: a */
    PopupWindow f10415a;

    /* JADX INFO: renamed from: b */
    PopupWindow f10416b;

    /* JADX INFO: renamed from: c */
    private String f10417c;

    /* JADX INFO: renamed from: d */
    private Context f10418d;

    /* JADX INFO: renamed from: e */
    private List<CommentBean.Cont.C1209D3> f10419e;

    /* JADX INFO: renamed from: g */
    private int f10420g;

    /* JADX INFO: renamed from: h */
    private InterfaceC1881lk f10421h;

    /* JADX INFO: renamed from: i */
    private C1874ld f10422i = new C1874ld();

    /* JADX INFO: renamed from: a */
    public void m9844a(InterfaceC1881lk interfaceC1881lk) {
        this.f10421h = interfaceC1881lk;
    }

    public C1817ja(Context context, List<CommentBean.Cont.C1209D3> list, String str) {
        this.f10419e = list;
        this.f10418d = context;
        this.f10417c = str;
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: b */
    public RecyclerView.AbstractC0624v mo3871b(ViewGroup viewGroup, int i) {
        if (i == 100 || i == 101) {
            return new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_forlistview_footview, viewGroup, false));
        }
        return new b(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_comment, viewGroup, false));
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public void mo3867a(RecyclerView.AbstractC0624v abstractC0624v, final int i) {
        if (abstractC0624v instanceof a) {
            a aVar = (a) abstractC0624v;
            if (mo3863a() <= 1) {
                aVar.f10462q.setText(R.string.ssdk_laiwang_client_inavailable);
                return;
            }
            aVar.f10462q.setText(R.string.add_archieve);
        }
        if (abstractC0624v instanceof b) {
            final CommentBean.Cont.C1209D3 c1209d3 = this.f10419e.get(i);
            final b bVar = (b) abstractC0624v;
            if (c1209d3.UserName != null) {
                if (c1209d3.UserName != null) {
                    bVar.f10465q.setText(c1209d3.UserName);
                }
                if (c1209d3.Content != null) {
                    c1209d3.Content.length();
                    bVar.f10468t.setCommentText(c1209d3.Content);
                    bVar.f10468t.getmTextExtend().setOnClickListener(new View.OnClickListener() { // from class: ja.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            bVar.f10468t.set_Allshow();
                        }
                    });
                }
                bVar.f10466r.setText(C1912mk.m10534a(Long.parseLong(c1209d3.CreateTime)));
                if (c1209d3.Icon != null && !c1209d3.Icon.equals("")) {
                    C2253xu.m12305a(this.f10418d).m12312a(c1209d3.Icon).m12348a(bVar.f10469u);
                }
                int i2 = c1209d3.IsLiked != null ? Integer.parseInt(c1209d3.IsLiked) : 0;
                int i3 = c1209d3.LikeCount != null ? Integer.parseInt(c1209d3.LikeCount) : 0;
                if (i2 == 1) {
                    bVar.f10472x.setSelected(true);
                }
                if (i3 != 0) {
                    bVar.f10467s.setText(String.valueOf(i3));
                }
                bVar.f10468t.setOnClickListener(new View.OnClickListener() { // from class: ja.9
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        String str = "回复  " + ((CommentBean.Cont.C1209D3) C1817ja.this.f10419e.get(i)).UserName;
                        String str2 = ((CommentBean.Cont.C1209D3) C1817ja.this.f10419e.get(i)).ResponseID;
                        akd.m1706a().m1722c(new C1873lc(str, 1, 999));
                        akd.m1706a().m1722c(new C1873lc(str2, 1, 998));
                        C1817ja.this.f10420g = i;
                        Log.e("TAG", "onClick: " + i);
                    }
                });
                bVar.f10470v.setOnClickListener(new AnonymousClass10(c1209d3, bVar));
                bVar.f10471w.setOnClickListener(new View.OnClickListener() { // from class: ja.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        int unused = C1817ja.f10414f = i;
                        C1817ja.this.m9843a(C1817ja.this.f10417c, c1209d3.ResponseID);
                    }
                });
                if (c1209d3.ChildResponseList == null || c1209d3.ChildResponseList.isEmpty()) {
                    bVar.f10473y.setVisibility(8);
                    return;
                }
                int size = c1209d3.ChildResponseList.size();
                bVar.f10473y.setAdapter(new C1812iw(c1209d3, this.f10417c, 2));
                if (size > 2) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(size);
                    bVar.f10463A.setText(sb.toString());
                    bVar.f10463A.setVisibility(0);
                    bVar.f10463A.setOnClickListener(new View.OnClickListener() { // from class: ja.12
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (C1817ja.this.f10421h == null || c1209d3 == null) {
                                return;
                            }
                            C1817ja.this.f10421h.mo7666a(c1209d3);
                        }
                    });
                }
            }
        }
    }

    /* JADX INFO: renamed from: ja$10, reason: invalid class name */
    /* JADX INFO: compiled from: MyAdapter.java */
    class AnonymousClass10 implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        int f10425a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ CommentBean.Cont.C1209D3 f10426b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ b f10427c;

        AnonymousClass10(CommentBean.Cont.C1209D3 c1209d3, b bVar) {
            this.f10426b = c1209d3;
            this.f10427c = bVar;
            this.f10425a = Integer.parseInt(this.f10426b.LikeCount);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (this.f10427c.f10472x.isSelected()) {
                C1817ja.this.f10422i.m10200a(this.f10426b.ResponseID, "0", new InterfaceC1878lh() { // from class: ja.10.1
                    @Override // p000.InterfaceC1878lh
                    /* JADX INFO: renamed from: b */
                    public void mo9848b() {
                    }

                    @Override // p000.InterfaceC1878lh
                    /* JADX INFO: renamed from: a */
                    public void mo9847a() {
                        AnonymousClass10 anonymousClass10 = AnonymousClass10.this;
                        anonymousClass10.f10425a--;
                        if (AnonymousClass10.this.f10425a == 0) {
                            AnonymousClass10.this.f10427c.f10467s.setText("赞");
                            return;
                        }
                        AnonymousClass10.this.f10427c.f10467s.setText(AnonymousClass10.this.f10425a + "");
                    }
                });
                this.f10427c.f10472x.setSelected(false);
            } else {
                C1817ja.this.f10422i.m10200a(this.f10426b.ResponseID, "1", new InterfaceC1878lh() { // from class: ja.10.2
                    @Override // p000.InterfaceC1878lh
                    /* JADX INFO: renamed from: b */
                    public void mo9848b() {
                    }

                    @Override // p000.InterfaceC1878lh
                    /* JADX INFO: renamed from: a */
                    public void mo9847a() {
                        AnonymousClass10.this.f10425a++;
                        AnonymousClass10.this.f10427c.f10467s.setText(AnonymousClass10.this.f10425a + "");
                        AnonymousClass10.this.f10427c.f10472x.setSelected(true);
                    }
                });
            }
        }
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: b */
    public int mo3870b(int i) {
        if (this.f10419e == null || this.f10419e.size() <= 0) {
            return 100;
        }
        if (i == mo3863a() - 1) {
            return 101;
        }
        return super.mo3870b(i);
    }

    /* JADX INFO: renamed from: a */
    public void m9843a(final String str, final String str2) {
        View viewInflate;
        this.f10416b = new PopupWindow(this.f10418d);
        if (Video_detail_Activity.f7247k == 1) {
            viewInflate = LayoutInflater.from(this.f10418d).inflate(R.layout.pop_to_report_myself, (ViewGroup) null);
        } else {
            viewInflate = LayoutInflater.from(this.f10418d).inflate(R.layout.pop_to_report, (ViewGroup) null);
        }
        TextView textView = (TextView) viewInflate.findViewById(R.id.delete_comment);
        if (textView != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: ja.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C1817ja.this.f10422i.m10248r(str2);
                    C1817ja.this.m9845b();
                    C1817ja.this.m3880f();
                    C1817ja.this.f10416b.dismiss();
                }
            });
        }
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: ja.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10416b.dismiss();
            }
        });
        this.f10416b.setWidth(-1);
        this.f10416b.setHeight(-2);
        this.f10416b.setBackgroundDrawable(new BitmapDrawable());
        this.f10416b.setFocusable(false);
        this.f10416b.setOutsideTouchable(true);
        this.f10416b.setTouchable(true);
        this.f10416b.setContentView(viewInflate);
        this.f10416b.showAtLocation(viewInflate, 80, 0, 0);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.cancel);
        ((TextView) viewInflate.findViewById(R.id.report)).setOnClickListener(new View.OnClickListener() { // from class: ja.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10416b.dismiss();
                C1817ja.this.m9846b(str, str2);
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ja.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10416b.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m9846b(final String str, final String str2) {
        this.f10415a = new PopupWindow(this.f10418d);
        View viewInflate = LayoutInflater.from(this.f10418d).inflate(R.layout.layout_pop_report, (ViewGroup) null);
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: ja.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10415a.dismiss();
            }
        });
        this.f10415a.setWidth(-1);
        this.f10415a.setHeight(-2);
        this.f10415a.setBackgroundDrawable(new BitmapDrawable());
        this.f10415a.setFocusable(false);
        this.f10415a.setOutsideTouchable(true);
        this.f10415a.setTouchable(true);
        this.f10415a.setContentView(viewInflate);
        this.f10415a.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.report1);
        TextView textView2 = (TextView) viewInflate.findViewById(R.id.report2);
        TextView textView3 = (TextView) viewInflate.findViewById(R.id.report3);
        TextView textView4 = (TextView) viewInflate.findViewById(R.id.report4);
        TextView textView5 = (TextView) viewInflate.findViewById(R.id.report5);
        TextView textView6 = (TextView) viewInflate.findViewById(R.id.cancel);
        textView.setOnClickListener(new View.OnClickListener() { // from class: ja.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10422i.m10195a("1", str, str2, "1");
                Toast.makeText(C1817ja.this.f10418d, "举报成功", 0).show();
                C1817ja.this.f10415a.dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() { // from class: ja.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10422i.m10195a("2", str, str2, "2");
                Toast.makeText(C1817ja.this.f10418d, "举报成功", 0).show();
                C1817ja.this.f10415a.dismiss();
            }
        });
        textView3.setOnClickListener(new View.OnClickListener() { // from class: ja.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10422i.m10195a("3", str, str2, "3");
                Toast.makeText(C1817ja.this.f10418d, "举报成功", 0).show();
                C1817ja.this.f10415a.dismiss();
            }
        });
        textView4.setOnClickListener(new View.OnClickListener() { // from class: ja.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10422i.m10195a("4", str, str2, "4");
                Toast.makeText(C1817ja.this.f10418d, "举报成功", 0).show();
                C1817ja.this.f10415a.dismiss();
            }
        });
        textView5.setOnClickListener(new View.OnClickListener() { // from class: ja.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10422i.m10195a("5", str, str2, "5");
                Toast.makeText(C1817ja.this.f10418d, "举报成功", 0).show();
                C1817ja.this.f10415a.dismiss();
            }
        });
        textView6.setOnClickListener(new View.OnClickListener() { // from class: ja.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1817ja.this.f10415a.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: b */
    public void m9845b() {
        this.f10419e.remove(f10414f);
    }

    @Override // android.support.v7.widget.RecyclerView.AbstractC0603a
    /* JADX INFO: renamed from: a */
    public int mo3863a() {
        if (this.f10419e == null || this.f10419e.size() <= 0) {
            return 1;
        }
        return this.f10419e.size() + 1;
    }

    /* JADX INFO: renamed from: ja$a */
    /* JADX INFO: compiled from: MyAdapter.java */
    public static class a extends RecyclerView.AbstractC0624v {

        /* JADX INFO: renamed from: q */
        TextView f10462q;

        public a(View view) {
            super(view);
            this.f10462q = (TextView) view.findViewById(R.id.text_content);
        }
    }

    /* JADX INFO: renamed from: ja$b */
    /* JADX INFO: compiled from: MyAdapter.java */
    public static class b extends RecyclerView.AbstractC0624v {

        /* JADX INFO: renamed from: A */
        TextView f10463A;

        /* JADX INFO: renamed from: B */
        boolean f10464B;

        /* JADX INFO: renamed from: q */
        TextView f10465q;

        /* JADX INFO: renamed from: r */
        TextView f10466r;

        /* JADX INFO: renamed from: s */
        TextView f10467s;

        /* JADX INFO: renamed from: t */
        CommentTextLayout f10468t;

        /* JADX INFO: renamed from: u */
        CircleTextImageView f10469u;

        /* JADX INFO: renamed from: v */
        LinearLayout f10470v;

        /* JADX INFO: renamed from: w */
        ImageView f10471w;

        /* JADX INFO: renamed from: x */
        ImageView f10472x;

        /* JADX INFO: renamed from: y */
        RecyclerView f10473y;

        /* JADX INFO: renamed from: z */
        LinearLayout f10474z;

        public b(View view) {
            super(view);
            this.f10465q = (TextView) view.findViewById(R.id.usrname);
            this.f10468t = (CommentTextLayout) view.findViewById(R.id.textconntent);
            this.f10466r = (TextView) view.findViewById(R.id.time_comment);
            this.f10470v = (LinearLayout) view.findViewById(R.id.commnet_layout_isgood);
            this.f10469u = (CircleTextImageView) view.findViewById(R.id.per_img);
            this.f10471w = (ImageView) view.findViewById(R.id.Comment_more);
            this.f10472x = (ImageView) view.findViewById(R.id.isgood_comment);
            this.f10467s = (TextView) view.findViewById(R.id.comment_like_count);
            this.f10473y = (RecyclerView) view.findViewById(R.id.recyclerviewitam);
            this.f10463A = (TextView) view.findViewById(R.id.tv_all_response);
            this.f10474z = (LinearLayout) view.findViewById(R.id.parent);
            this.f10473y.setLayoutManager(new LinearLayoutManager(view.getContext()));
            this.f10473y.setHasFixedSize(true);
            this.f10464B = false;
        }
    }
}
