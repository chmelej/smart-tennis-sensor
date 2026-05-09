package com.coollang.tennis.activity;

import android.database.Cursor;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.TrainHistoryListBean;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.widget.KCalendar;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.litepal.crud.DataSupport;
import p000.C1830jn;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1887lq;
import p000.C1896lz;
import p000.C1900mc;
import p000.C1902me;
import p000.C1912mk;
import p000.C1929na;
import p000.DialogC1860kq;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class TrainHistoryActivity extends BaseActivity implements View.OnClickListener {

    /* JADX INFO: renamed from: a */
    private NavigateView f7026a;

    /* JADX INFO: renamed from: b */
    private RelativeLayout f7027b;

    /* JADX INFO: renamed from: c */
    private RelativeLayout f7028c;

    /* JADX INFO: renamed from: d */
    private TextView f7029d;

    /* JADX INFO: renamed from: e */
    private KCalendar f7030e;

    /* JADX INFO: renamed from: f */
    private ListView f7031f;

    /* JADX INFO: renamed from: g */
    private C1830jn f7032g;

    /* JADX INFO: renamed from: h */
    private HashMap<String, ArrayList<Integer>> f7033h = new HashMap<>();

    /* JADX INFO: renamed from: i */
    private ArrayList<TrainHistoryListBean> f7034i = new ArrayList<>();

    /* JADX INFO: renamed from: j */
    private String f7035j;

    /* JADX INFO: renamed from: k */
    private C1874ld f7036k;

    /* JADX INFO: renamed from: l */
    private Gson f7037l;

    /* JADX INFO: renamed from: m */
    private C1929na f7038m;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_train_history);
        m7431d();
        m7434e();
    }

    /* JADX INFO: renamed from: d */
    private void m7431d() {
        this.f7026a = (NavigateView) findViewById(R.id.navigateView);
        this.f7027b = (RelativeLayout) findViewById(R.id.popupwindow_calendar_last_month);
        this.f7028c = (RelativeLayout) findViewById(R.id.popupwindow_calendar_next_month);
        this.f7029d = (TextView) findViewById(R.id.popupwindow_calendar_month);
        this.f7030e = (KCalendar) findViewById(R.id.popupwindow_calendar);
        this.f7031f = (ListView) findViewById(R.id.lv_train_history);
        if (MyApplication.m7738a().m7748h()) {
            this.f7026a.setRightButtonTextSize(10);
            this.f7026a.setLeftButtonTextSize(10);
            this.f7026a.setTitleTextSize(12);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m7434e() {
        this.f7026a.setTitle(getString(R.string.train_history_title));
        this.f7026a.setRightButtonText(getString(R.string.the_last_train_day));
        this.f7026a.setRightButtonBackground(android.R.color.transparent);
        this.f7026a.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                TrainHistoryActivity.this.m7733j();
            }
        });
        this.f7026a.setRightButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.2
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                TrainHistoryActivity.this.f7030e.m8166c();
                TrainHistoryActivity.this.m7442c();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7036k = new C1874ld();
        this.f7037l = new Gson();
        akd.m1706a().m1719a(this);
        this.f7035j = String.valueOf(C1902me.m10480a(this));
        this.f7032g = new C1830jn(this.f7034i, this);
        this.f7031f.setAdapter((ListAdapter) this.f7032g);
        m7442c();
        m7436f();
    }

    /* JADX INFO: renamed from: c */
    public void m7442c() {
        Cursor cursorFindBySQL = DataSupport.findBySQL("select * from OnTimeMainTable where userid = ? And endTimeStemp != 0 order by startTimeStemp asc", this.f7035j);
        String string = cursorFindBySQL.moveToLast() ? cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("date")) : "";
        cursorFindBySQL.close();
        if (!"".equals(string)) {
            String[] strArrSplit = string.split("-");
            if (!C1912mk.m10547e(string) || this.f7030e.getCalendarMonth() != Integer.parseInt(strArrSplit[1])) {
                this.f7030e.m8163a(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]));
            }
            m7424a(string);
            m7429b(string);
            this.f7030e.setCalendarDayBgColor(string, R.drawable.shape_calendar_yellow_bg);
            String[] strArrSplit2 = string.split("-");
            this.f7029d.setText(String.format(getString(R.string.train_calendar_month), strArrSplit2[0], strArrSplit2[1]));
            return;
        }
        this.f7029d.setText(String.format(getString(R.string.train_calendar_month), String.valueOf(this.f7030e.getCalendarYear()), String.valueOf(this.f7030e.getCalendarMonth())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7424a(String str) {
        ArrayList<Integer> arrayList;
        String[] strArrSplit = str.split("-");
        this.f7033h.clear();
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * from OnTimeMainTable where userid = ? and endTimeStemp !=0 And date like ?", this.f7035j, strArrSplit[0] + "-" + strArrSplit[1] + "%");
        while (cursorFindBySQL.moveToNext()) {
            if (this.f7033h.get(cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("date"))) == null) {
                arrayList = new ArrayList<>();
            } else {
                arrayList = this.f7033h.get(cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("date")));
            }
            arrayList.add(Integer.valueOf(cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("id"))));
            this.f7033h.put(cursorFindBySQL.getString(cursorFindBySQL.getColumnIndex("date")), arrayList);
        }
        cursorFindBySQL.close();
        ArrayList arrayList2 = new ArrayList();
        Iterator<String> it = this.f7033h.keySet().iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next());
        }
        this.f7030e.m8164a(arrayList2, R.drawable.shape_calendar_green_bg);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m7429b(String str) {
        this.f7034i.clear();
        if (!"".equals(str) && this.f7033h.get(str) != null) {
            ArrayList<Integer> arrayList = this.f7033h.get(str);
            for (int i = 0; i < arrayList.size(); i++) {
                OnTimeMainTable onTimeMainTable = (OnTimeMainTable) DataSupport.find(OnTimeMainTable.class, arrayList.get(i).intValue());
                this.f7034i.add(new TrainHistoryListBean(arrayList.get(i).intValue(), C1912mk.m10546e(onTimeMainTable.getStartTimeStemp() * 1000), onTimeMainTable.getType(), m7418a(onTimeMainTable.getStartTimeStemp(), onTimeMainTable.getEndTimeStemp()), DataSupport.where("trainId = ?", String.valueOf(arrayList.get(i))).count(OnTimeDetailTable.class)));
            }
        }
        this.f7032g.notifyDataSetChanged();
    }

    /* JADX INFO: renamed from: f */
    private void m7436f() {
        this.f7028c.setOnClickListener(this);
        this.f7027b.setOnClickListener(this);
        this.f7031f.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.3
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (C1896lz.m10463a(view.getId())) {
                    return;
                }
                if (TrainHistoryActivity.this.f7032g.getItem(i).trainType == 0) {
                    C1887lq.m10409a(TrainHistoryActivity.this, TrainHistoryActivity.this.f7032g.getItem(i).mainId, TrainHistoryActivity.this.f7032g.getItem(i).duration);
                } else {
                    C1887lq.m10417b(TrainHistoryActivity.this, TrainHistoryActivity.this.f7032g.getItem(i).mainId, TrainHistoryActivity.this.f7032g.getItem(i).duration);
                }
            }
        });
        this.f7031f.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.4
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                TrainHistoryActivity.this.m7421a(TrainHistoryActivity.this.f7032g.getItem(i).mainId, TrainHistoryActivity.this.f7032g.getItem(i).time);
                return true;
            }
        });
        m7438g();
    }

    /* JADX INFO: renamed from: g */
    private void m7438g() {
        this.f7030e.setOnCalendarClickListener(new KCalendar.InterfaceC1339a() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.5
            @Override // com.coollang.tennis.widget.KCalendar.InterfaceC1339a
            /* JADX INFO: renamed from: a */
            public void mo7443a(int i, int i2, String str) {
                int i3 = Integer.parseInt(str.substring(str.indexOf("-") + 1, str.lastIndexOf("-")));
                if (TrainHistoryActivity.this.f7030e.getCalendarMonth() - i3 == 1 || TrainHistoryActivity.this.f7030e.getCalendarMonth() - i3 == -11) {
                    TrainHistoryActivity.this.m7441i();
                    return;
                }
                if (i3 - TrainHistoryActivity.this.f7030e.getCalendarMonth() == 1 || i3 - TrainHistoryActivity.this.f7030e.getCalendarMonth() == -11) {
                    TrainHistoryActivity.this.m7440h();
                } else if (TrainHistoryActivity.this.f7033h.get(str) != null) {
                    TrainHistoryActivity.this.f7030e.m8166c();
                    TrainHistoryActivity.this.f7030e.setCalendarDayBgColor(str, R.drawable.shape_calendar_yellow_bg);
                    TrainHistoryActivity.this.m7429b(str);
                }
            }
        });
        this.f7030e.setOnCalendarDateChangedListener(new KCalendar.InterfaceC1340b() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.6
            @Override // com.coollang.tennis.widget.KCalendar.InterfaceC1340b
            /* JADX INFO: renamed from: a */
            public void mo7444a(int i, int i2) {
                TrainHistoryActivity.this.f7029d.setText(String.format(TrainHistoryActivity.this.getString(R.string.train_calendar_month), String.valueOf(i), String.valueOf(i2)));
            }
        });
        this.f7030e.setOnMonthChangeListener(new KCalendar.InterfaceC1341c() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.7
            @Override // com.coollang.tennis.widget.KCalendar.InterfaceC1341c
            /* JADX INFO: renamed from: a */
            public void mo7445a() {
                TrainHistoryActivity.this.m7424a(String.format("%d-%02d-01", Integer.valueOf(TrainHistoryActivity.this.f7030e.getCalendarYear()), Integer.valueOf(TrainHistoryActivity.this.f7030e.getCalendarMonth())));
            }

            @Override // com.coollang.tennis.widget.KCalendar.InterfaceC1341c
            /* JADX INFO: renamed from: b */
            public void mo7446b() {
                TrainHistoryActivity.this.m7424a(String.format("%d-%02d-01", Integer.valueOf(TrainHistoryActivity.this.f7030e.getCalendarYear()), Integer.valueOf(TrainHistoryActivity.this.f7030e.getCalendarMonth())));
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.popupwindow_calendar_last_month) {
            m7441i();
        } else {
            if (id != R.id.popupwindow_calendar_next_month) {
                return;
            }
            m7440h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m7440h() {
        this.f7030e.m8162a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: i */
    public void m7441i() {
        this.f7030e.m8165b();
    }

    /* JADX INFO: renamed from: a */
    private int m7418a(long j, long j2) {
        return ((int) (j2 - j)) / 60;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7421a(final int i, String str) {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(7, this, new DialogC1860kq.a() { // from class: com.coollang.tennis.activity.TrainHistoryActivity.8
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                OnTimeMainTable onTimeMainTable = (OnTimeMainTable) DataSupport.find(OnTimeMainTable.class, i);
                if (onTimeMainTable != null) {
                    String date = onTimeMainTable.getDate();
                    if (onTimeMainTable.getServerId() == null) {
                        TrainHistoryActivity.this.m7426b(i, date);
                        return;
                    }
                    TrainHistoryActivity.this.f7038m = new C1929na(TrainHistoryActivity.this);
                    TrainHistoryActivity.this.f7038m.m10714a();
                    TrainHistoryActivity.this.f7036k.m10193a(String.valueOf(onTimeMainTable.getType()), onTimeMainTable.getServerId(), i);
                }
            }
        });
        dialogC1860kq.m10129a(String.format(getString(R.string.sure_to_delete_train_record), str));
        dialogC1860kq.m10130b(getString(R.string.dialog_yes_1));
        dialogC1860kq.m10131c(getString(R.string.dialog_no_1));
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.show();
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 30) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    this.f7038m.m10716c();
                    break;
                case 1:
                    C1900mc.m10474b("deleteHis", c1873lc.f11064a);
                    OnTimeMainTable onTimeMainTable = (OnTimeMainTable) DataSupport.find(OnTimeMainTable.class, c1873lc.f11066c);
                    m7426b(c1873lc.f11066c, onTimeMainTable != null ? onTimeMainTable.getDate() : "");
                    this.f7038m.m10715b();
                    break;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        akd.m1706a().m1721b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m7426b(int i, String str) {
        DataSupport.delete(OnTimeMainTable.class, i);
        DataSupport.deleteAll((Class<?>) OnTimeDetailTable.class, "trainid = ?", String.valueOf(i));
        if ("".equals(str)) {
            return;
        }
        m7424a(str);
        m7429b(str);
    }
}
