package p000;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.TrainOnTimeActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.widget.ControlRippleView;
import com.coollang.tennis.widget.CountView;
import com.coollang.tennis.widget.DialChartView;
import com.coollang.tennis.widget.ScatterChartView;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import org.litepal.crud.DataSupport;
import p000.C1924mw;

/* JADX INFO: renamed from: ln */
/* JADX INFO: compiled from: OnTimeSendTrainManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1884ln implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private PopupWindow f11312A;

    /* JADX INFO: renamed from: C */
    private long f11314C;

    /* JADX INFO: renamed from: D */
    private int f11315D;

    /* JADX INFO: renamed from: E */
    private int f11316E;

    /* JADX INFO: renamed from: F */
    private OnTimeDetailTable f11317F;

    /* JADX INFO: renamed from: G */
    private int f11318G;

    /* JADX INFO: renamed from: H */
    private int f11319H;

    /* JADX INFO: renamed from: I */
    private int f11320I;

    /* JADX INFO: renamed from: J */
    private int f11321J;

    /* JADX INFO: renamed from: K */
    private List<Integer> f11322K;

    /* JADX INFO: renamed from: L */
    private C1924mw f11323L;

    /* JADX INFO: renamed from: M */
    private a f11324M;

    /* JADX INFO: renamed from: a */
    public Activity f11326a;

    /* JADX INFO: renamed from: b */
    public View f11327b;

    /* JADX INFO: renamed from: g */
    private DialChartView f11332g;

    /* JADX INFO: renamed from: h */
    private CountView f11333h;

    /* JADX INFO: renamed from: i */
    private CountView f11334i;

    /* JADX INFO: renamed from: j */
    private ScatterChartView f11335j;

    /* JADX INFO: renamed from: k */
    private CountView f11336k;

    /* JADX INFO: renamed from: l */
    private TextView f11337l;

    /* JADX INFO: renamed from: m */
    private TextView f11338m;

    /* JADX INFO: renamed from: n */
    private TextView f11339n;

    /* JADX INFO: renamed from: o */
    private TextView f11340o;

    /* JADX INFO: renamed from: p */
    private TextView f11341p;

    /* JADX INFO: renamed from: q */
    private TextView f11342q;

    /* JADX INFO: renamed from: r */
    private ControlRippleView f11343r;

    /* JADX INFO: renamed from: s */
    private ImageView f11344s;

    /* JADX INFO: renamed from: t */
    private ImageView f11345t;

    /* JADX INFO: renamed from: u */
    private ImageView f11346u;

    /* JADX INFO: renamed from: v */
    private Timer f11347v;

    /* JADX INFO: renamed from: w */
    private TimerTask f11348w;

    /* JADX INFO: renamed from: z */
    private int f11351z;

    /* JADX INFO: renamed from: c */
    private final int f11328c = 1005;

    /* JADX INFO: renamed from: d */
    private final int f11329d = PointerIconCompat.TYPE_CELL;

    /* JADX INFO: renamed from: e */
    private final int f11330e = PointerIconCompat.TYPE_CROSSHAIR;

    /* JADX INFO: renamed from: f */
    private final String f11331f = "sendtarget";

    /* JADX INFO: renamed from: x */
    private boolean f11349x = false;

    /* JADX INFO: renamed from: y */
    private boolean f11350y = false;

    /* JADX INFO: renamed from: B */
    private int f11313B = 100;

    /* JADX INFO: renamed from: N */
    private Handler f11325N = new Handler() { // from class: ln.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 1005:
                    ViewOnClickListenerC1884ln.m10332a(ViewOnClickListenerC1884ln.this);
                    ViewOnClickListenerC1884ln.this.f11338m.setText(ViewOnClickListenerC1884ln.this.m10360o());
                    break;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    if (ViewOnClickListenerC1884ln.this.f11312A != null && ViewOnClickListenerC1884ln.this.f11312A.isShowing()) {
                        ViewOnClickListenerC1884ln.this.f11312A.dismiss();
                        break;
                    }
                    break;
                case PointerIconCompat.TYPE_CROSSHAIR /* 1007 */:
                    ViewOnClickListenerC1884ln.this.m10373d();
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: ln$a */
    /* JADX INFO: compiled from: OnTimeSendTrainManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7496a(int i);
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ int m10332a(ViewOnClickListenerC1884ln viewOnClickListenerC1884ln) {
        int i = viewOnClickListenerC1884ln.f11351z;
        viewOnClickListenerC1884ln.f11351z = i + 1;
        return i;
    }

    public ViewOnClickListenerC1884ln(Activity activity, View view) {
        this.f11326a = activity;
        this.f11327b = view;
        m10336a(view);
        m10341e();
        m10367a();
    }

    /* JADX INFO: renamed from: a */
    private void m10336a(View view) {
        this.f11332g = (DialChartView) view.findViewById(R.id.dial_chart_view);
        this.f11333h = (CountView) view.findViewById(R.id.tv_speed_hand);
        this.f11334i = (CountView) view.findViewById(R.id.tv_racket_radian);
        this.f11336k = (CountView) view.findViewById(R.id.tv_forecase_speed);
        this.f11337l = (TextView) view.findViewById(R.id.tv_avg_speed_ontime_hand);
        this.f11338m = (TextView) view.findViewById(R.id.tv_timer_count);
        this.f11339n = (TextView) view.findViewById(R.id.tv_rate_hit_ontime);
        this.f11340o = (TextView) view.findViewById(R.id.tv_train_history);
        this.f11341p = (TextView) view.findViewById(R.id.tv_control_btn);
        this.f11342q = (TextView) view.findViewById(R.id.tv_set_target);
        this.f11343r = (ControlRippleView) view.findViewById(R.id.mRippleView);
        this.f11344s = (ImageView) view.findViewById(R.id.img_has_history);
        this.f11335j = (ScatterChartView) view.findViewById(R.id.scatter_chart_view);
        this.f11345t = (ImageView) view.findViewById(R.id.img_sound_ontime);
        this.f11346u = (ImageView) view.findViewById(R.id.img_how_to_use_train);
        TextView textView = (TextView) view.findViewById(R.id.tv_forecase_ball_speed);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_swing_speed);
        TextView textView3 = (TextView) view.findViewById(R.id.tv_hit_radian);
        if (MyApplication.m7738a().m7748h()) {
            textView.setTextSize(9.0f);
            textView2.setTextSize(6.0f);
            textView3.setTextSize(6.0f);
            this.f11341p.setTextSize(10.0f);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m10341e() {
        this.f11337l.setText(C1910mi.m10524a("0", String.format(this.f11326a.getString(R.string.ontime_train_send_avg), "0"), 12, this.f11326a.getResources().getColor(R.color.yellow_re_start_ble)));
        this.f11339n.setText("0/0");
        m10344f();
        m10346g();
    }

    /* JADX INFO: renamed from: f */
    private void m10344f() {
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.f11326a.getAssets(), "fonts/S.ttf");
        this.f11336k.setTypeface(typefaceCreateFromAsset);
        this.f11333h.setTypeface(typefaceCreateFromAsset);
        this.f11334i.setTypeface(typefaceCreateFromAsset);
        this.f11338m.setTypeface(typefaceCreateFromAsset);
    }

    /* JADX INFO: renamed from: a */
    public void m10367a() {
        this.f11315D = Integer.parseInt(C1902me.m10480a(this.f11326a));
        this.f11322K = new ArrayList();
        this.f11313B = C1902me.m10486b(this.f11326a, m10334a("sendtarget"), 100);
        this.f11335j.setLimitData(this.f11313B);
        this.f11335j.setShowMaxDataValue(true);
        m10350i();
    }

    /* JADX INFO: renamed from: g */
    private void m10346g() {
        if (C1902me.m10489b((Context) this.f11326a, "trainHis", false)) {
            this.f11344s.setVisibility(0);
        } else {
            this.f11344s.setVisibility(8);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m10371b() {
        m10346g();
    }

    /* JADX INFO: renamed from: a */
    public void m10370a(byte[] bArr) {
        int i = Integer.parseInt(String.format("%02X", Byte.valueOf(bArr[3])), 16);
        if (i == 0 || i == 1) {
            this.f11318G = C1893lw.m10453b(bArr[4], bArr[5]);
            this.f11333h.m8106a(this.f11318G);
            this.f11334i.m8106a(C1893lw.m10453b(bArr[8], bArr[9]));
            this.f11319H = m10337b(this.f11318G);
            C1900mc.m10474b("onTimeForecase", " == " + this.f11319H);
            this.f11336k.m8106a(this.f11319H);
            this.f11332g.setProgress((float) this.f11319H);
            if (!this.f11350y && this.f11324M != null) {
                this.f11324M.mo7496a(this.f11319H);
            }
            if (this.f11349x) {
                m10335a(this.f11319H);
                m10368a(i, C1893lw.m10452b(bArr[12]), this.f11319H, C1893lw.m10452b(bArr[11]));
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10335a(int i) {
        this.f11335j.m8251a(i);
        this.f11320I = ((this.f11320I * this.f11322K.size()) + i) / (this.f11322K.size() + 1);
        this.f11337l.setText(C1910mi.m10524a(String.valueOf(this.f11320I), String.format(this.f11326a.getString(R.string.ontime_train_send_avg), String.valueOf(this.f11320I)), 12, this.f11326a.getResources().getColor(R.color.yellow_re_start_ble)));
        this.f11322K.add(Integer.valueOf(i));
        if (i >= this.f11313B) {
            this.f11321J++;
        }
        TextView textView = this.f11339n;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f11321J);
        stringBuffer.append("/");
        stringBuffer.append(this.f11322K.size());
        textView.setText(stringBuffer);
    }

    /* JADX INFO: renamed from: b */
    private int m10337b(int i) {
        if (i < 110) {
            return (int) (i * m10331a(116, 125));
        }
        if (i < 125) {
            return (int) (i * m10331a(121, 129));
        }
        return (int) (i * m10331a(116, 125));
    }

    /* JADX INFO: renamed from: a */
    private float m10331a(int i, int i2) {
        return (new Random().nextInt(Math.abs(i2 - i) + 1) + Math.min(i, i2)) / 100.0f;
    }

    /* JADX INFO: renamed from: a */
    public void m10368a(int i, int i2, int i3, int i4) {
        this.f11317F = new OnTimeDetailTable(i, i2, System.currentTimeMillis() / 1000, i3, this.f11316E, i4);
        this.f11317F.save();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m10348h() {
        this.f11321J = 0;
        for (int i = 0; i < this.f11322K.size(); i++) {
            if (this.f11322K.get(i).intValue() >= this.f11313B) {
                this.f11321J++;
            }
        }
        TextView textView = this.f11339n;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f11321J);
        stringBuffer.append("/");
        stringBuffer.append(this.f11322K.size());
        textView.setText(stringBuffer);
    }

    /* JADX INFO: renamed from: i */
    private void m10350i() {
        this.f11340o.setOnClickListener(this);
        this.f11342q.setOnClickListener(this);
        this.f11341p.setOnClickListener(this);
        this.f11345t.setOnClickListener(this);
        this.f11346u.setOnClickListener(this);
        this.f11341p.setOnTouchListener(new View.OnTouchListener() { // from class: ln.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!ViewOnClickListenerC1884ln.this.f11349x) {
                    return false;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        ViewOnClickListenerC1884ln.this.f11343r.m8102a();
                        ViewOnClickListenerC1884ln.this.f11325N.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CROSSHAIR, 1000L);
                        return true;
                    case 1:
                        C1900mc.m10474b("stopTrain", "isInTraining = " + ViewOnClickListenerC1884ln.this.f11349x);
                        if (!ViewOnClickListenerC1884ln.this.f11349x) {
                            return true;
                        }
                        C1900mc.m10474b("stopTrain", "fail");
                        ViewOnClickListenerC1884ln.this.f11325N.removeMessages(PointerIconCompat.TYPE_CROSSHAIR);
                        ViewOnClickListenerC1884ln.this.f11343r.m8103b();
                        return true;
                    default:
                        return true;
                }
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
        }
        switch (view.getId()) {
            case R.id.img_how_to_use_train /* 2131296656 */:
                C1887lq.m10424d(this.f11326a);
                break;
            case R.id.img_sound_ontime /* 2131296668 */:
                m10352j();
                break;
            case R.id.tv_control_btn /* 2131297218 */:
                if (!this.f11349x) {
                    if (!MyApplication.m7738a().f7401b) {
                        m10365t();
                    } else {
                        m10353k();
                    }
                }
                break;
            case R.id.tv_set_target /* 2131297323 */:
                m10364s();
                break;
            case R.id.tv_train_history /* 2131297379 */:
                if (this.f11349x) {
                    ((TrainOnTimeActivity) this.f11326a).m7489a(6);
                } else {
                    this.f11344s.setVisibility(8);
                    C1902me.m10485a((Context) this.f11326a, "trainHis", false);
                    C1887lq.m10407a(this.f11326a);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: j */
    private void m10352j() {
        if (this.f11350y) {
            this.f11350y = false;
            this.f11345t.setImageResource(R.drawable.img_sound_ontime_on);
        } else {
            this.f11350y = true;
            this.f11345t.setImageResource(R.drawable.img_sound_ontime_close);
        }
    }

    /* JADX INFO: renamed from: k */
    private void m10353k() {
        m10355l();
        this.f11349x = true;
        this.f11314C = System.currentTimeMillis() / 1000;
        m10358m();
        m10359n();
        m10362q();
        this.f11341p.setText(R.string.long_press_to_stop);
    }

    /* JADX INFO: renamed from: l */
    private void m10355l() {
        this.f11351z = 0;
        this.f11314C = 0L;
        this.f11322K.clear();
        this.f11321J = 0;
        this.f11320I = 0;
        this.f11319H = 0;
        this.f11318G = 0;
        this.f11337l.setText(C1910mi.m10524a("0", String.format(this.f11326a.getString(R.string.ontime_train_send_avg), "0"), 12, this.f11326a.getResources().getColor(R.color.yellow_re_start_ble)));
        this.f11339n.setText("0/0");
    }

    /* JADX INFO: renamed from: m */
    private void m10358m() {
        this.f11347v = new Timer();
        this.f11351z = 0;
        this.f11348w = new TimerTask() { // from class: ln.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ViewOnClickListenerC1884ln.this.f11325N.sendEmptyMessage(1005);
            }
        };
        this.f11347v.schedule(this.f11348w, 0L, 1000L);
    }

    /* JADX INFO: renamed from: n */
    private void m10359n() {
        OnTimeMainTable onTimeMainTable = new OnTimeMainTable(this.f11314C, 0L, 1, this.f11315D, C1912mk.m10539b(), this.f11313B, this.f11313B, 0);
        onTimeMainTable.save();
        this.f11316E = onTimeMainTable.getId();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public String m10360o() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.f11351z / 60;
        int i2 = this.f11351z % 60;
        if (i / 10 == 0) {
            stringBuffer.append("0");
            stringBuffer.append(i);
            stringBuffer.append(":");
        } else {
            stringBuffer.append(i);
            stringBuffer.append(":");
        }
        if (i2 / 10 == 0) {
            stringBuffer.append("0");
            stringBuffer.append(i2);
        } else {
            stringBuffer.append(i2);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: p */
    private void m10361p() {
        this.f11347v.cancel();
        this.f11335j.m8250a();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        ContentValues contentValues = new ContentValues();
        contentValues.put("endTimeStemp", Long.valueOf(jCurrentTimeMillis));
        DataSupport.update(OnTimeMainTable.class, contentValues, this.f11316E);
    }

    /* JADX INFO: renamed from: q */
    private void m10362q() {
        this.f11343r.setBackgroundColor(this.f11326a.getResources().getColor(R.color.white));
        this.f11340o.setTextColor(this.f11326a.getResources().getColor(R.color.text_menu_checked));
        this.f11342q.setTextColor(this.f11326a.getResources().getColor(R.color.text_menu_checked));
        this.f11341p.setBackgroundResource(R.drawable.ontime_finish_train_bg);
        this.f11341p.setTextColor(this.f11326a.getResources().getColor(R.color.selector_green_white_color));
    }

    /* JADX INFO: renamed from: r */
    private void m10363r() {
        this.f11343r.m8104c();
        this.f11343r.setBackgroundColor(this.f11326a.getResources().getColor(R.color.text_menu_checked));
        this.f11340o.setTextColor(this.f11326a.getResources().getColor(R.color.white));
        this.f11342q.setTextColor(this.f11326a.getResources().getColor(R.color.white));
        this.f11341p.setBackgroundResource(R.drawable.ontime_start_train_bg);
        this.f11341p.setTextColor(this.f11326a.getResources().getColor(R.color.selector_white_green_color));
    }

    /* JADX INFO: renamed from: s */
    private void m10364s() {
        this.f11323L = new C1924mw(this.f11326a);
        this.f11323L.m10657a(new C1924mw.a() { // from class: ln.4
            @Override // p000.C1924mw.a
            /* JADX INFO: renamed from: a */
            public void mo10374a(int i) {
                ViewOnClickListenerC1884ln.this.f11313B = i;
                ViewOnClickListenerC1884ln.this.f11335j.setLimitData(ViewOnClickListenerC1884ln.this.f11313B);
                ContentValues contentValues = new ContentValues();
                contentValues.put("foreTargetSpeed", Integer.valueOf(ViewOnClickListenerC1884ln.this.f11313B));
                contentValues.put("backTargetSpeed", Integer.valueOf(ViewOnClickListenerC1884ln.this.f11313B));
                DataSupport.update(OnTimeMainTable.class, contentValues, ViewOnClickListenerC1884ln.this.f11316E);
                ViewOnClickListenerC1884ln.this.m10348h();
                ViewOnClickListenerC1884ln.this.m10366u();
            }
        });
        this.f11323L.m10655a();
        MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: ln.5
            @Override // java.lang.Runnable
            public void run() {
                ViewOnClickListenerC1884ln.this.f11323L.m10656a(ViewOnClickListenerC1884ln.this.f11313B);
            }
        }, 300L);
    }

    /* JADX INFO: renamed from: c */
    public boolean m10372c() {
        return this.f11349x;
    }

    /* JADX INFO: renamed from: t */
    private void m10365t() {
        ((TrainOnTimeActivity) this.f11326a).m7492d();
    }

    /* JADX INFO: renamed from: d */
    public void m10373d() {
        this.f11349x = false;
        m10363r();
        this.f11341p.setText(R.string.start_train_ontime);
        m10361p();
        if (((TrainOnTimeActivity) this.f11326a).m7494f()) {
            ((TrainOnTimeActivity) this.f11326a).m7491c();
        }
        C1902me.m10485a((Context) this.f11326a, "trainHis", true);
        m10346g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: u */
    public void m10366u() {
        C1902me.m10483a(C1914mm.m10554a(), m10334a("sendtarget"), this.f11313B != 0 ? this.f11313B : 100);
    }

    /* JADX INFO: renamed from: a */
    private String m10334a(String str) {
        return str + this.f11315D;
    }

    /* JADX INFO: renamed from: a */
    public void m10369a(a aVar) {
        this.f11324M = aVar;
    }
}
