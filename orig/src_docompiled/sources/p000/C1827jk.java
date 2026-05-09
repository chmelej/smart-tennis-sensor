package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.SportDetailActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.MainMonthTable;
import com.coollang.tennis.beans.SportMainDetailBean;
import com.coollang.tennis.fragment.RankListFragment;
import com.coollang.tennis.p011db.model.MyActionTable;
import com.coollang.tennis.p011db.model.MyDetailTable;
import com.coollang.tennis.p011db.model.MyMainTable;
import com.coollang.tennis.widget.SportLoadingProgress;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.DialogC1860kq;

/* JADX INFO: renamed from: jk */
/* JADX INFO: compiled from: SportMainAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class C1827jk extends BaseExpandableListAdapter {

    /* JADX INFO: renamed from: c */
    private Context f10638c;

    /* JADX INFO: renamed from: d */
    private LayoutInflater f10639d;

    /* JADX INFO: renamed from: e */
    private a f10640e;

    /* JADX INFO: renamed from: f */
    private d f10641f;

    /* JADX INFO: renamed from: g */
    private String f10642g;

    /* JADX INFO: renamed from: i */
    private Handler f10644i;

    /* JADX INFO: renamed from: j */
    private boolean f10645j = false;

    /* JADX INFO: renamed from: l */
    private View.OnLongClickListener f10647l = new View.OnLongClickListener() { // from class: jk.2
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (C1827jk.this.f10645j) {
                return true;
            }
            C1827jk.this.m9932b((String) view.getTag(R.id.sport_date), ((Integer) view.getTag(R.id.sport_group_position)).intValue(), ((Integer) view.getTag(R.id.sport_child_position)).intValue());
            return true;
        }
    };

    /* JADX INFO: renamed from: m */
    private View.OnClickListener f10648m = new View.OnClickListener() { // from class: jk.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (C1896lz.m10463a(view.getId()) || C1827jk.this.f10645j) {
                return;
            }
            int iIntValue = ((Integer) view.getTag(R.id.sport_group_position)).intValue();
            int iIntValue2 = ((Integer) view.getTag(R.id.sport_child_position)).intValue();
            if (C1827jk.this.getChild(iIntValue, iIntValue2).isUpToServer == 0) {
                return;
            }
            SportDetailActivity.m7313a(C1827jk.this.f10638c, C1827jk.this.getChild(iIntValue, iIntValue2).date);
        }
    };

    /* JADX INFO: renamed from: h */
    private C1874ld f10643h = new C1874ld();

    /* JADX INFO: renamed from: k */
    private c f10646k = new c() { // from class: jk.1
        @Override // p000.C1827jk.c
        /* JADX INFO: renamed from: a */
        public void mo7935a() {
        }
    };

    /* JADX INFO: renamed from: a */
    private List<MainMonthTable> f10636a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private HashMap<String, ArrayList<SportMainDetailBean>> f10637b = new HashMap<>();

    /* JADX INFO: renamed from: jk$c */
    /* JADX INFO: compiled from: SportMainAdapter.java */
    public interface c {
        /* JADX INFO: renamed from: a */
        void mo7935a();
    }

    /* JADX INFO: renamed from: jk$d */
    /* JADX INFO: compiled from: SportMainAdapter.java */
    public interface d {
        /* JADX INFO: renamed from: a */
        void mo7934a();
    }

    /* JADX INFO: renamed from: a */
    public int m9937a(int i, boolean z) {
        if (i == 0) {
            return 0;
        }
        return z ? 1 : 2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getChildId(int i, int i2) {
        return i2;
    }

    @Override // android.widget.ExpandableListAdapter
    public long getGroupId(int i) {
        return i;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean hasStableIds() {
        return true;
    }

    @Override // android.widget.ExpandableListAdapter
    public boolean isChildSelectable(int i, int i2) {
        return true;
    }

    public C1827jk(Context context, Handler handler) {
        this.f10642g = "";
        this.f10639d = LayoutInflater.from(context);
        this.f10642g = C1902me.m10480a(context);
        this.f10644i = handler;
        this.f10638c = context;
        m9934c();
    }

    /* JADX INFO: renamed from: a */
    public void m9946a(d dVar) {
        this.f10641f = dVar;
    }

    @Override // android.widget.ExpandableListAdapter
    public int getGroupCount() {
        return this.f10636a.size();
    }

    @Override // android.widget.ExpandableListAdapter
    public int getChildrenCount(int i) {
        return this.f10637b.get(this.f10636a.get(i).getMonth()).size();
    }

    @Override // android.widget.ExpandableListAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MainMonthTable getGroup(int i) {
        return this.f10636a.get(i);
    }

    @Override // android.widget.ExpandableListAdapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public SportMainDetailBean getChild(int i, int i2) {
        return this.f10637b.get(this.f10636a.get(i).getMonth()).get(i2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.widget.ExpandableListAdapter
    public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
        b bVar;
        if (view == null) {
            view = this.f10639d.inflate(R.layout.item_group_col_sport_main, (ViewGroup) null);
            bVar = new b();
            bVar.f10673b = (CardView) view.findViewById(R.id.cardview_sport_group);
            bVar.f10674c = (TextView) view.findViewById(R.id.tv_month_group_item);
            bVar.f10675d = (TextView) view.findViewById(R.id.tv_year_group_item);
            bVar.f10676e = (TextView) view.findViewById(R.id.tv_time_month);
            bVar.f10677f = (TextView) view.findViewById(R.id.tv_hit_month);
            bVar.f10678g = (ImageView) view.findViewById(R.id.img_colapse_bottom);
            bVar.f10679h = view.findViewById(R.id.bottom_line_sport_group);
            bVar.f10680i = (LinearLayout) view.findViewById(R.id.ll_container);
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
        }
        switch (m9937a(i, z)) {
            case 0:
                bVar.f10673b.setVisibility(8);
                bVar.f10680i.setVisibility(8);
                bVar.f10678g.setVisibility(8);
                bVar.f10679h.setVisibility(8);
                return view;
            case 1:
                bVar.f10673b.setVisibility(0);
                bVar.f10680i.setVisibility(0);
                bVar.f10678g.setVisibility(8);
                bVar.f10679h.setVisibility(0);
                m9925a(bVar, i);
                return view;
            case 2:
                bVar.f10673b.setVisibility(0);
                bVar.f10680i.setVisibility(0);
                bVar.f10678g.setVisibility(0);
                bVar.f10679h.setVisibility(8);
                m9925a(bVar, i);
                return view;
            default:
                return view;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m9925a(b bVar, int i) {
        String[] strArrSplit = this.f10636a.get(i).getMonth().split("-");
        bVar.f10674c.setText(strArrSplit[1]);
        bVar.f10675d.setText(strArrSplit[0]);
        bVar.f10676e.setText(m9930b(this.f10636a.get(i).getMonthTotalTime()));
        bVar.f10677f.setText(String.valueOf(this.f10636a.get(i).getMonthTotalHit()));
    }

    /* JADX INFO: renamed from: b */
    private String m9930b(int i) {
        return i < 60 ? String.format("%.01f", Float.valueOf(i / 60.0f)) : String.valueOf(Math.round(i / 60.0f));
    }

    @Override // android.widget.ExpandableListAdapter
    public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f10638c).inflate(R.layout.item_child_sport_main, viewGroup, false);
            this.f10640e = new a(view);
            view.setTag(this.f10640e);
        } else {
            this.f10640e = (a) view.getTag();
        }
        if (i != 0 || i2 != 0) {
            this.f10640e.f10659d.setBackgroundColor(this.f10638c.getResources().getColor(R.color.text_menu_checked));
        } else {
            this.f10640e.f10659d.setBackgroundColor(this.f10638c.getResources().getColor(android.R.color.transparent));
        }
        SportMainDetailBean sportMainDetailBean = this.f10637b.get(this.f10636a.get(i).getMonth()).get(i2);
        String strValueOf = String.valueOf(m9928b(i, i2));
        this.f10640e.f10660e.setText(C1910mi.m10523a(strValueOf, String.format(this.f10638c.getString(R.string.sport_day_order), strValueOf), 20));
        String[] strArrSplit = sportMainDetailBean.date.split("-");
        this.f10640e.f10661f.setText(String.format(this.f10638c.getString(R.string.sport_order_date), strArrSplit[1], strArrSplit[2]));
        this.f10640e.f10662g.setText(sportMainDetailBean.sportTime);
        this.f10640e.f10663h.setText(sportMainDetailBean.hitCount);
        if (sportMainDetailBean.bestHit.equals("0")) {
            this.f10640e.f10664i.setText("--");
            this.f10640e.f10670o.setText("");
        } else {
            this.f10640e.f10664i.setText(sportMainDetailBean.bestHit);
            this.f10640e.f10670o.setText("km/h");
        }
        if (getChildrenCount(i) == i2 + 1) {
            this.f10640e.f10665j.setBackgroundColor(this.f10638c.getResources().getColor(android.R.color.transparent));
        } else {
            this.f10640e.f10665j.setBackgroundColor(this.f10638c.getResources().getColor(R.color.text_menu_checked));
        }
        this.f10640e.f10669n.setTag(R.id.sport_group_position, Integer.valueOf(i));
        this.f10640e.f10669n.setTag(R.id.sport_child_position, Integer.valueOf(i2));
        this.f10640e.f10669n.setTag(R.id.sport_date, sportMainDetailBean.date);
        this.f10640e.f10669n.setOnClickListener(this.f10648m);
        this.f10640e.f10669n.setOnLongClickListener(this.f10647l);
        this.f10640e.f10666k.setTag(i + "-" + i2);
        if (!this.f10645j || sportMainDetailBean.isUpToServer != 0) {
            if (sportMainDetailBean.isUpToServer == 0) {
                this.f10640e.f10666k.setVisibility(0);
                this.f10640e.f10667l.setText(R.string.uploading_main_data);
                this.f10640e.f10668m.setProgress(100);
            } else {
                this.f10640e.f10666k.setVisibility(8);
            }
        } else {
            this.f10640e.f10666k.setVisibility(0);
            this.f10640e.f10667l.setText(R.string.loading_details);
        }
        if (MyApplication.m7738a().m7748h()) {
            this.f10640e.f10658c.setTextSize(9.0f);
            this.f10640e.f10657b.setTextSize(9.0f);
            this.f10640e.f10671p.setTextSize(9.0f);
        }
        return view;
    }

    /* JADX INFO: renamed from: a */
    public void m9943a(String str) {
        String strM10540b = C1912mk.m10540b(Long.parseLong(str));
        String[] strArrSplit = strM10540b.split("-");
        HashMap<String, ArrayList<SportMainDetailBean>> map = this.f10637b;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        sb.append(strArrSplit[0]);
        sb.append("-");
        sb.append(strArrSplit[1]);
        ArrayList<SportMainDetailBean> arrayList = map.get(sb.toString());
        while (true) {
            if (i >= arrayList.size()) {
                break;
            }
            if (arrayList.get(i).date.equals(strM10540b)) {
                arrayList.get(i).isUpToServer = 1;
                break;
            }
            i++;
        }
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: b */
    private int m9928b(int i, int i2) {
        int childrenCount = 0;
        for (int i3 = i + 1; i3 < getGroupCount(); i3++) {
            childrenCount += getChildrenCount(i3);
        }
        return childrenCount + (getChildrenCount(i) - i2);
    }

    /* JADX INFO: renamed from: jk$b */
    /* JADX INFO: compiled from: SportMainAdapter.java */
    class b {

        /* JADX INFO: renamed from: b */
        private CardView f10673b;

        /* JADX INFO: renamed from: c */
        private TextView f10674c;

        /* JADX INFO: renamed from: d */
        private TextView f10675d;

        /* JADX INFO: renamed from: e */
        private TextView f10676e;

        /* JADX INFO: renamed from: f */
        private TextView f10677f;

        /* JADX INFO: renamed from: g */
        private ImageView f10678g;

        /* JADX INFO: renamed from: h */
        private View f10679h;

        /* JADX INFO: renamed from: i */
        private LinearLayout f10680i;

        private b() {
        }
    }

    /* JADX INFO: renamed from: jk$a */
    /* JADX INFO: compiled from: SportMainAdapter.java */
    class a {

        /* JADX INFO: renamed from: b */
        private TextView f10657b;

        /* JADX INFO: renamed from: c */
        private TextView f10658c;

        /* JADX INFO: renamed from: d */
        private View f10659d;

        /* JADX INFO: renamed from: e */
        private TextView f10660e;

        /* JADX INFO: renamed from: f */
        private TextView f10661f;

        /* JADX INFO: renamed from: g */
        private TextView f10662g;

        /* JADX INFO: renamed from: h */
        private TextView f10663h;

        /* JADX INFO: renamed from: i */
        private TextView f10664i;

        /* JADX INFO: renamed from: j */
        private View f10665j;

        /* JADX INFO: renamed from: k */
        private LinearLayout f10666k;

        /* JADX INFO: renamed from: l */
        private TextView f10667l;

        /* JADX INFO: renamed from: m */
        private SportLoadingProgress f10668m;

        /* JADX INFO: renamed from: n */
        private CardView f10669n;

        /* JADX INFO: renamed from: o */
        private TextView f10670o;

        /* JADX INFO: renamed from: p */
        private TextView f10671p;

        public a(View view) {
            this.f10671p = (TextView) view.findViewById(R.id.tv_completed);
            this.f10657b = (TextView) view.findViewById(R.id.tv_exercise_for);
            this.f10659d = view.findViewById(R.id.line_view);
            this.f10660e = (TextView) view.findViewById(R.id.tv_order_child);
            this.f10661f = (TextView) view.findViewById(R.id.tv_cur_date_sport);
            this.f10662g = (TextView) view.findViewById(R.id.tv_sport_time_child);
            this.f10663h = (TextView) view.findViewById(R.id.tv_sport_hit_child);
            this.f10664i = (TextView) view.findViewById(R.id.tv_sport_best_child);
            this.f10666k = (LinearLayout) view.findViewById(R.id.ll_loading_child);
            this.f10667l = (TextView) view.findViewById(R.id.tv_cur_status_child);
            this.f10668m = (SportLoadingProgress) view.findViewById(R.id.progress_sport_child);
            this.f10665j = view.findViewById(R.id.bottom_line_sport_child);
            this.f10669n = (CardView) view.findViewById(R.id.cardview_sport_child);
            this.f10670o = (TextView) view.findViewById(R.id.tv_sport_best_unit);
            this.f10658c = (TextView) view.findViewById(R.id.tv_best_server);
            Typeface typeface = MyApplication.m7738a().f7404e;
            this.f10662g.setTypeface(typeface);
            this.f10663h.setTypeface(typeface);
            this.f10664i.setTypeface(typeface);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9941a() {
        this.f10636a.clear();
        this.f10637b.clear();
        m9934c();
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: a */
    public int m9938a(long j) {
        String strM10548f = C1912mk.m10548f(j * 1000);
        for (int i = 0; i < this.f10636a.size(); i++) {
            if (this.f10636a.get(i).getMonth().equals(strM10548f)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public int m9948b(long j) {
        String strM10548f = C1912mk.m10548f(1000 * j);
        String strM10540b = C1912mk.m10540b(j);
        ArrayList<SportMainDetailBean> arrayList = this.f10637b.get(strM10548f);
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i).date.equals(strM10540b)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: c */
    private void m9934c() {
        MainMonthTable mainMonthTable;
        this.f10637b.clear();
        this.f10636a.clear();
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * from mymaintable where userid = ? And isdeleted = 0 And date > 1451606400 order by date desc", this.f10642g);
        if (cursorFindBySQL.getCount() != 0) {
            int count = cursorFindBySQL.getCount();
            while (cursorFindBySQL.moveToNext()) {
                String strM9931b = m9931b(cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("signdate")));
                if (!this.f10636a.isEmpty() && this.f10636a.get(this.f10636a.size() - 1).getMonth().equals(strM9931b)) {
                    mainMonthTable = this.f10636a.get(this.f10636a.size() - 1);
                } else {
                    mainMonthTable = new MainMonthTable(strM9931b, 0, 0);
                    this.f10636a.add(mainMonthTable);
                }
                mainMonthTable.setMonthTotalTime(mainMonthTable.getMonthTotalTime() + cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("duration")));
                mainMonthTable.setMonthTotalHit(mainMonthTable.getMonthTotalHit() + cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("totletimes")));
                ArrayList<SportMainDetailBean> arrayList = this.f10637b.get(strM9931b);
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(new SportMainDetailBean(String.valueOf(count - cursorFindBySQL.getPosition()), cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("signdate")), String.valueOf(cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("duration"))), String.valueOf(cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("totletimes"))), String.valueOf((int) (cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("maxspeed")) * 1.23f)), cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("sign1"))));
                this.f10637b.put(strM9931b, arrayList);
            }
            cursorFindBySQL.close();
        }
    }

    /* JADX INFO: renamed from: b */
    private String m9931b(String str) {
        if (str == null || str.isEmpty()) {
            return "2016-01";
        }
        String[] strArrSplit = str.split("-");
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArrSplit[0]);
        stringBuffer.append("-");
        stringBuffer.append(strArrSplit[1]);
        return stringBuffer.toString();
    }

    @Override // android.widget.BaseExpandableListAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        this.f10646k.mo7935a();
    }

    /* JADX INFO: renamed from: a */
    public void m9947a(boolean z) {
        this.f10645j = z;
    }

    /* JADX INFO: renamed from: b */
    public boolean m9949b() {
        return this.f10645j;
    }

    /* JADX INFO: renamed from: a */
    public void m9945a(c cVar) {
        this.f10646k = cVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m9932b(final String str, final int i, final int i2) {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(7, this.f10638c, new DialogC1860kq.a() { // from class: jk.4
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                C1827jk.this.f10643h.m10190a(str, i, i2);
                C1827jk.this.f10641f.mo7934a();
            }
        });
        if (C1912mk.m10543c(str)) {
            dialogC1860kq.m10129a(C1914mm.m10557b(R.string.delete_today_sport));
        } else {
            dialogC1860kq.m10129a(String.format(this.f10638c.getString(R.string.delete_other_day_sport), str));
        }
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
        dialogC1860kq.show();
    }

    /* JADX INFO: renamed from: a */
    public void m9944a(String str, int i, int i2) {
        C1900mc.m10474b("TimeZone", C1912mk.m10541c() + "");
        String strValueOf = String.valueOf(C1912mk.m10538b(str + " 00:00:00"));
        if (C1912mk.m10543c(str)) {
            C1900mc.m10474b("isToday", "today == " + str);
            String[] strArrSplit = str.split("-");
            String str2 = strArrSplit[0] + strArrSplit[1] + strArrSplit[2];
            DataSupport.deleteAll((Class<?>) MyMainTable.class, "UserID = ? And date = ?", this.f10642g, strValueOf);
            DataSupport.deleteAll((Class<?>) MyActionTable.class, "UserID = ? And date = ?", this.f10642g, strValueOf);
            DataSupport.deleteAll((Class<?>) MyDetailTable.class, "UserID = ? And sign2 = ?", this.f10642g, str2);
            if (MyApplication.m7738a().f7401b && C1839jw.f10820a != null) {
                C1839jw.m10026a().m10042a(3);
            }
        } else {
            ContentValues contentValues = new ContentValues();
            contentValues.put("isDeleted", (Integer) 1);
            DataSupport.updateAll((Class<?>) MyMainTable.class, contentValues, "UserID = ? And date = ?", this.f10642g, strValueOf);
        }
        RankListFragment.f7569b = true;
        m9935c(str);
        this.f10646k.mo7935a();
        notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: c */
    private void m9935c(String str) {
        String strM9931b = m9931b(str);
        ArrayList<SportMainDetailBean> arrayList = this.f10637b.get(strM9931b);
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (arrayList.get(i2).date.equals(str)) {
                if (arrayList.size() == 1) {
                    this.f10637b.remove(strM9931b);
                    while (i < this.f10636a.size()) {
                        if (this.f10636a.get(i).getMonth().equals(strM9931b)) {
                            this.f10636a.remove(i);
                        }
                        i++;
                    }
                } else {
                    while (i < this.f10636a.size()) {
                        if (this.f10636a.get(i).getMonth().equals(strM9931b)) {
                            MainMonthTable mainMonthTable = this.f10636a.get(i);
                            mainMonthTable.setMonthTotalHit(mainMonthTable.getMonthTotalHit() - Integer.parseInt(arrayList.get(i2).hitCount));
                            mainMonthTable.setMonthTotalTime(mainMonthTable.getMonthTotalTime() - Integer.parseInt(arrayList.get(i2).sportTime));
                        }
                        i++;
                    }
                }
                arrayList.remove(i2);
                return;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m9942a(long j, int i) {
        Message message = new Message();
        message.what = PointerIconCompat.TYPE_CELL;
        message.arg1 = i;
        message.obj = Long.valueOf(j);
        this.f10644i.sendMessageDelayed(message, 800L);
    }
}
