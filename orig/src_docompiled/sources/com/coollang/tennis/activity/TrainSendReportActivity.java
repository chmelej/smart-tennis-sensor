package com.coollang.tennis.activity;

import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.coollang.tennis.widget.ScatterChartView;
import com.coollang.tennis.widget.TrainBarChartView;
import java.util.ArrayList;
import org.litepal.crud.DataSupport;
import p000.C1910mi;

/* JADX INFO: loaded from: classes.dex */
public class TrainSendReportActivity extends BaseActivity {

    /* JADX INFO: renamed from: a */
    private NavigateView f7100a;

    /* JADX INFO: renamed from: b */
    private TextView f7101b;

    /* JADX INFO: renamed from: c */
    private TextView f7102c;

    /* JADX INFO: renamed from: d */
    private TrainBarChartView f7103d;

    /* JADX INFO: renamed from: e */
    private TextView f7104e;

    /* JADX INFO: renamed from: f */
    private TextView f7105f;

    /* JADX INFO: renamed from: g */
    private ScatterChartView f7106g;

    /* JADX INFO: renamed from: h */
    private int f7107h;

    /* JADX INFO: renamed from: i */
    private int f7108i;

    /* JADX INFO: renamed from: j */
    private OnTimeMainTable f7109j;

    /* JADX INFO: renamed from: k */
    private String[] f7110k = {"<100", "100-110", "110-120", "120-130", "130-140", "≥140"};

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_train_send_report);
        m7512c();
        m7513d();
        m7514e();
        m7515f();
        this.f7106g.setShowMaxDataValue(true);
    }

    /* JADX INFO: renamed from: c */
    private void m7512c() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7107h = extras.getInt("mainid");
            this.f7108i = extras.getInt("trainTime");
        }
    }

    /* JADX INFO: renamed from: d */
    private void m7513d() {
        this.f7100a = (NavigateView) findViewById(R.id.navigateView);
        this.f7101b = (TextView) findViewById(R.id.tv_train_time);
        this.f7102c = (TextView) findViewById(R.id.tv_train_level);
        this.f7104e = (TextView) findViewById(R.id.tv_train_finish_status);
        this.f7105f = (TextView) findViewById(R.id.tv_avg_speed_ontime_hand);
        this.f7106g = (ScatterChartView) findViewById(R.id.scatter_chart_view);
        this.f7103d = (TrainBarChartView) findViewById(R.id.bar_chart_view);
    }

    /* JADX INFO: renamed from: e */
    private void m7514e() {
        this.f7100a.setTitle(getString(R.string.train_send_report));
        this.f7100a.setRightHideBtn(true);
        this.f7100a.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.TrainSendReportActivity.1
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                TrainSendReportActivity.this.m7733j();
            }
        });
        if (MyApplication.m7738a().m7748h()) {
            this.f7100a.setRightButtonTextSize(10);
            this.f7100a.setLeftButtonTextSize(10);
            this.f7100a.setTitleTextSize(12);
        }
    }

    /* JADX INFO: renamed from: f */
    private void m7515f() {
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(getAssets(), "fonts/S.ttf");
        this.f7101b.setTypeface(typefaceCreateFromAsset);
        this.f7102c.setTypeface(typefaceCreateFromAsset);
        this.f7104e.setTypeface(typefaceCreateFromAsset);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7109j = (OnTimeMainTable) DataSupport.find(OnTimeMainTable.class, this.f7107h);
        int foreTargetSpeed = this.f7109j.getForeTargetSpeed();
        Cursor cursorFindBySQL = DataSupport.findBySQL("Select * from OnTimeDetailTable where trainid = ? ", String.valueOf(this.f7107h));
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (cursorFindBySQL.moveToNext()) {
            int i9 = cursorFindBySQL.getInt(cursorFindBySQL.getColumnIndex("hitspeed"));
            if (i9 < 100) {
                i++;
            } else if (i9 < 110) {
                i2++;
            } else if (i9 < 120) {
                i3++;
            } else if (i9 < 130) {
                i4++;
            } else if (i9 < 140) {
                i5++;
            } else {
                i6++;
            }
            arrayList.add(Integer.valueOf(i9));
            if (i9 >= foreTargetSpeed) {
                i7++;
            }
            i8 += i9;
        }
        int[] iArr = {i, i2, i3, i4, i5, i6};
        this.f7101b.setText(String.valueOf(this.f7108i));
        this.f7104e.setText(String.valueOf(i7));
        this.f7102c.setText(String.valueOf(cursorFindBySQL.getCount()));
        int count = i8 / (cursorFindBySQL.getCount() <= 0 ? 1 : cursorFindBySQL.getCount());
        this.f7105f.setText(C1910mi.m10524a(String.valueOf(count), String.format(getString(R.string.ontime_train_send_avg), String.valueOf(count)), 12, getResources().getColor(R.color.yellow_re_start_ble)));
        this.f7106g.setLimitData(foreTargetSpeed);
        this.f7106g.setSpeedList(arrayList);
        this.f7103d.setData(iArr);
        cursorFindBySQL.close();
    }
}
