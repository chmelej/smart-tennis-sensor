package p000;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.TrackModeActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.p011db.model.VideoTable;
import java.util.List;
import p000.DialogC1867kx;

/* JADX INFO: renamed from: jm */
/* JADX INFO: compiled from: TrackModeAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1829jm extends BaseAdapter {

    /* JADX INFO: renamed from: b */
    private int f10690b;

    /* JADX INFO: renamed from: c */
    private List<VideoTable> f10691c;

    /* JADX INFO: renamed from: d */
    private List<String> f10692d;

    /* JADX INFO: renamed from: f */
    private Context f10694f;

    /* JADX INFO: renamed from: g */
    private int f10695g;

    /* JADX INFO: renamed from: e */
    private boolean f10693e = false;

    /* JADX INFO: renamed from: a */
    a f10689a = null;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    public C1829jm(Activity activity, int i, List<VideoTable> list, int i2) {
        this.f10690b = i;
        this.f10691c = list;
        this.f10694f = activity;
        this.f10695g = i2;
    }

    /* JADX INFO: renamed from: a */
    public void m9988a(List<VideoTable> list, List<String> list2, boolean z) {
        this.f10693e = z;
        this.f10691c = list;
        this.f10692d = list2;
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.f10695g == 1001) {
            if (this.f10693e) {
                return this.f10691c.size() + 1;
            }
            return this.f10691c.size() + 2;
        }
        if (this.f10695g != 1002) {
            return 0;
        }
        if (this.f10693e) {
            return this.f10691c.size();
        }
        return this.f10691c.size() + 1;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return Integer.valueOf(i);
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = C1914mm.m10555a(R.layout.item_train_video);
            this.f10689a = new a();
            this.f10689a.f10701a = (TextView) view.findViewById(R.id.item_train_video_tv_time);
            this.f10689a.f10703c = (RelativeLayout) view.findViewById(R.id.item_train_video_rl);
            this.f10689a.f10702b = (TextView) view.findViewById(R.id.item_train_video_tv_name);
            this.f10689a.f10704d = (ImageView) view.findViewById(R.id.item_train_video_iv_pictrue);
            this.f10689a.f10705e = (ImageView) view.findViewById(R.id.item_train_video_iv_play);
            this.f10689a.f10706f = (ImageView) view.findViewById(R.id.item_train_video_iv_update_name);
            this.f10689a.f10707g = (RelativeLayout) view.findViewById(R.id.item_train_video_rl_name);
            this.f10689a.f10708h = (RelativeLayout) view.findViewById(R.id.item_train_video_rl_select);
            view.setTag(this.f10689a);
        } else {
            this.f10689a = (a) view.getTag();
        }
        this.f10689a.f10707g.setEnabled(false);
        this.f10689a.f10707g.setClickable(false);
        int i2 = this.f10695g == 1002 ? i : i - 1;
        C1808is.m9825a(Integer.valueOf(getCount()));
        if (!this.f10693e && i == getCount() - 1) {
            this.f10689a.f10701a.setVisibility(4);
            this.f10689a.f10702b.setVisibility(4);
            this.f10689a.f10704d.setVisibility(4);
            this.f10689a.f10705e.setImageResource(R.drawable.ic_train_add);
        } else if (i == 0 && this.f10695g == 1001) {
            this.f10689a.f10701a.setVisibility(4);
            this.f10689a.f10702b.setVisibility(0);
            this.f10689a.f10704d.setVisibility(0);
            this.f10689a.f10702b.setText(C1914mm.m10557b(R.string.example_video));
            this.f10689a.f10705e.setImageResource(R.drawable.ic_train_play);
            this.f10689a.f10704d.setImageResource(R.drawable.ic_train_1);
        } else {
            this.f10689a.f10701a.setVisibility(0);
            this.f10689a.f10702b.setVisibility(0);
            this.f10689a.f10704d.setVisibility(0);
            this.f10689a.f10705e.setImageResource(R.drawable.ic_train_play);
            if (this.f10691c.size() > 0) {
                String createTime = this.f10691c.get(i2).getCreateTime();
                if (!MyApplication.m7738a().m7747g()) {
                    createTime = createTime.replace("年", ".").replace("月", ".").replace("日", ".");
                }
                this.f10689a.f10701a.setText(createTime);
                this.f10689a.f10702b.setText(this.f10691c.get(i2).getName());
                String picture = this.f10691c.get(i2).getPicture();
                if (!picture.startsWith("file://")) {
                    picture = "file://" + picture;
                }
                C1808is.m9827c(this.f10691c);
                if (!picture.equals(this.f10689a.f10704d.getTag())) {
                    this.f10689a.f10704d.setTag(picture);
                    C2068qy.m11356a().m11360a(picture, this.f10689a.f10704d);
                }
            }
        }
        if (i > 0 || (i == 0 && this.f10695g == 1002)) {
            if (this.f10693e) {
                this.f10689a.f10707g.setEnabled(true);
                this.f10689a.f10707g.setClickable(true);
                this.f10689a.f10706f.setVisibility(0);
                if (this.f10692d.contains(this.f10691c.get(i2).getUrl())) {
                    this.f10689a.f10708h.setVisibility(0);
                } else {
                    this.f10689a.f10708h.setVisibility(8);
                }
            } else {
                this.f10689a.f10707g.setEnabled(false);
                this.f10689a.f10707g.setClickable(false);
                this.f10689a.f10706f.setVisibility(8);
                this.f10689a.f10708h.setVisibility(8);
            }
        } else {
            this.f10689a.f10706f.setVisibility(8);
            this.f10689a.f10708h.setVisibility(8);
        }
        this.f10689a.f10707g.setOnClickListener(new AnonymousClass1(i));
        ViewGroup.LayoutParams layoutParams = this.f10689a.f10703c.getLayoutParams();
        layoutParams.width = this.f10690b;
        layoutParams.height = (int) ((((double) this.f10690b) * 276.0d) / 460.0d);
        return view;
    }

    /* JADX INFO: renamed from: jm$1, reason: invalid class name */
    /* JADX INFO: compiled from: TrackModeAdapter.java */
    class AnonymousClass1 implements View.OnClickListener {

        /* JADX INFO: renamed from: a */
        final /* synthetic */ int f10696a;

        AnonymousClass1(int i) {
            this.f10696a = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            DialogC1867kx dialogC1867kx = new DialogC1867kx(C1829jm.this.f10694f, C1914mm.m10557b(R.string.update_name), "", C1914mm.m10557b(R.string.ok), C1914mm.m10557b(R.string.cancel), new DialogC1867kx.a() { // from class: jm.1.1
                @Override // p000.DialogC1867kx.a
                /* JADX INFO: renamed from: a */
                public void mo7195a() {
                }

                /* JADX WARN: Type inference failed for: r0v0, types: [jm$1$1$1] */
                @Override // p000.DialogC1867kx.a
                /* JADX INFO: renamed from: a */
                public void mo7196a(final String str) {
                    new AsyncTask<Void, Void, Void>() { // from class: jm.1.1.1
                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public Void doInBackground(Void... voidArr) {
                            C1859kp c1859kp = new C1859kp();
                            if (C1829jm.this.f10695g == 1002) {
                                c1859kp.m10124a(((VideoTable) C1829jm.this.f10691c.get(AnonymousClass1.this.f10696a)).getId(), str);
                            } else {
                                c1859kp.m10124a(((VideoTable) C1829jm.this.f10691c.get(AnonymousClass1.this.f10696a - 1)).getId(), str);
                            }
                            C1829jm.this.f10691c = c1859kp.m10123a();
                            return null;
                        }

                        /* JADX INFO: Access modifiers changed from: protected */
                        @Override // android.os.AsyncTask
                        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                        public void onPostExecute(Void r4) {
                            C1829jm.this.m9988a(C1829jm.this.f10691c, C1829jm.this.f10692d, C1829jm.this.f10693e);
                            ((TrackModeActivity) C1829jm.this.f10694f).f6958a = C1829jm.this.f10691c;
                        }
                    }.execute(new Void[0]);
                }
            });
            dialogC1867kx.m10160a(15);
            dialogC1867kx.show();
        }
    }

    /* JADX INFO: renamed from: jm$a */
    /* JADX INFO: compiled from: TrackModeAdapter.java */
    public class a {

        /* JADX INFO: renamed from: a */
        public TextView f10701a;

        /* JADX INFO: renamed from: b */
        public TextView f10702b;

        /* JADX INFO: renamed from: c */
        public RelativeLayout f10703c;

        /* JADX INFO: renamed from: d */
        public ImageView f10704d;

        /* JADX INFO: renamed from: e */
        public ImageView f10705e;

        /* JADX INFO: renamed from: f */
        public ImageView f10706f;

        /* JADX INFO: renamed from: g */
        public RelativeLayout f10707g;

        /* JADX INFO: renamed from: h */
        public RelativeLayout f10708h;

        public a() {
        }
    }
}
