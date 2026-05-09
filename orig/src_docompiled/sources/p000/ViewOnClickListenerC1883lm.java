package p000;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.PointerIconCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.TrainOnTimeActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.p011db.model.OnTimeDetailTable;
import com.coollang.tennis.p011db.model.OnTimeMainTable;
import com.coollang.tennis.widget.BaseProgressView;
import com.coollang.tennis.widget.CircularSeekDarkBar;
import com.coollang.tennis.widget.ControlRippleView;
import com.coollang.tennis.widget.CountView;
import com.coollang.tennis.widget.ShotLineView;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import org.litepal.crud.DataSupport;
import p000.C1925mx;

/* JADX INFO: renamed from: lm */
/* JADX INFO: compiled from: OnTimeHandTrainManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ViewOnClickListenerC1883lm implements View.OnClickListener {

    /* JADX INFO: renamed from: A */
    private TextView f11221A;

    /* JADX INFO: renamed from: B */
    private TextView f11222B;

    /* JADX INFO: renamed from: C */
    private TextView f11223C;

    /* JADX INFO: renamed from: D */
    private TextView f11224D;

    /* JADX INFO: renamed from: E */
    private BaseProgressView f11225E;

    /* JADX INFO: renamed from: F */
    private BaseProgressView f11226F;

    /* JADX INFO: renamed from: G */
    private BaseProgressView f11227G;

    /* JADX INFO: renamed from: H */
    private TextView f11228H;

    /* JADX INFO: renamed from: I */
    private TextView f11229I;

    /* JADX INFO: renamed from: J */
    private TextView f11230J;

    /* JADX INFO: renamed from: K */
    private TextView f11231K;

    /* JADX INFO: renamed from: L */
    private TextView f11232L;

    /* JADX INFO: renamed from: M */
    private BaseProgressView f11233M;

    /* JADX INFO: renamed from: N */
    private BaseProgressView f11234N;

    /* JADX INFO: renamed from: O */
    private BaseProgressView f11235O;

    /* JADX INFO: renamed from: P */
    private TextView f11236P;

    /* JADX INFO: renamed from: Q */
    private TextView f11237Q;

    /* JADX INFO: renamed from: R */
    private ShotLineView f11238R;

    /* JADX INFO: renamed from: S */
    private ControlRippleView f11239S;

    /* JADX INFO: renamed from: T */
    private TextView f11240T;

    /* JADX INFO: renamed from: U */
    private TextView f11241U;

    /* JADX INFO: renamed from: V */
    private TextView f11242V;

    /* JADX INFO: renamed from: W */
    private ImageView f11243W;

    /* JADX INFO: renamed from: X */
    private String f11244X;

    /* JADX INFO: renamed from: Y */
    private String[] f11245Y;

    /* JADX INFO: renamed from: Z */
    private String f11246Z;

    /* JADX INFO: renamed from: a */
    private Activity f11247a;

    /* JADX INFO: renamed from: aA */
    private int f11248aA;

    /* JADX INFO: renamed from: aB */
    private Timer f11249aB;

    /* JADX INFO: renamed from: aC */
    private TimerTask f11250aC;

    /* JADX INFO: renamed from: aD */
    private int f11251aD;

    /* JADX INFO: renamed from: aF */
    private int f11253aF;

    /* JADX INFO: renamed from: aG */
    private int f11254aG;

    /* JADX INFO: renamed from: aH */
    private int f11255aH;

    /* JADX INFO: renamed from: aa */
    private ArrayList<Integer> f11256aa;

    /* JADX INFO: renamed from: ac */
    private a f11258ac;

    /* JADX INFO: renamed from: ad */
    private C1925mx f11259ad;

    /* JADX INFO: renamed from: af */
    private int f11261af;

    /* JADX INFO: renamed from: ag */
    private int f11262ag;

    /* JADX INFO: renamed from: ah */
    private int f11263ah;

    /* JADX INFO: renamed from: ai */
    private int f11264ai;

    /* JADX INFO: renamed from: aj */
    private int f11265aj;

    /* JADX INFO: renamed from: ak */
    private int f11266ak;

    /* JADX INFO: renamed from: al */
    private int f11267al;

    /* JADX INFO: renamed from: am */
    private int f11268am;

    /* JADX INFO: renamed from: an */
    private int f11269an;

    /* JADX INFO: renamed from: ao */
    private int f11270ao;

    /* JADX INFO: renamed from: ap */
    private int f11271ap;

    /* JADX INFO: renamed from: aq */
    private int f11272aq;

    /* JADX INFO: renamed from: ar */
    private int f11273ar;

    /* JADX INFO: renamed from: as */
    private int f11274as;

    /* JADX INFO: renamed from: at */
    private int f11275at;

    /* JADX INFO: renamed from: au */
    private int f11276au;

    /* JADX INFO: renamed from: av */
    private int f11277av;

    /* JADX INFO: renamed from: aw */
    private int f11278aw;

    /* JADX INFO: renamed from: ax */
    private OnTimeDetailTable f11279ax;

    /* JADX INFO: renamed from: ay */
    private long f11280ay;

    /* JADX INFO: renamed from: az */
    private int f11281az;

    /* JADX INFO: renamed from: b */
    private View f11282b;

    /* JADX INFO: renamed from: p */
    private TextView f11296p;

    /* JADX INFO: renamed from: q */
    private CircularSeekDarkBar f11297q;

    /* JADX INFO: renamed from: r */
    private CountView f11298r;

    /* JADX INFO: renamed from: s */
    private CircularSeekDarkBar f11299s;

    /* JADX INFO: renamed from: t */
    private CountView f11300t;

    /* JADX INFO: renamed from: u */
    private CircularSeekDarkBar f11301u;

    /* JADX INFO: renamed from: v */
    private CountView f11302v;

    /* JADX INFO: renamed from: w */
    private ImageView f11303w;

    /* JADX INFO: renamed from: x */
    private ImageView f11304x;

    /* JADX INFO: renamed from: y */
    private ImageView f11305y;

    /* JADX INFO: renamed from: z */
    private TextView f11306z;

    /* JADX INFO: renamed from: c */
    private final int f11283c = 1005;

    /* JADX INFO: renamed from: d */
    private final int f11284d = PointerIconCompat.TYPE_CROSSHAIR;

    /* JADX INFO: renamed from: e */
    private final float f11285e = 200.0f;

    /* JADX INFO: renamed from: f */
    private final float f11286f = 30.0f;

    /* JADX INFO: renamed from: g */
    private final float f11287g = 360.0f;

    /* JADX INFO: renamed from: h */
    private final String f11288h = "fore_xuan_target";

    /* JADX INFO: renamed from: i */
    private final String f11289i = "fore_xiao_target";

    /* JADX INFO: renamed from: j */
    private final String f11290j = "fore_ping_target";

    /* JADX INFO: renamed from: k */
    private final String f11291k = "fore_speed_target";

    /* JADX INFO: renamed from: l */
    private final String f11292l = "back_xuan_target";

    /* JADX INFO: renamed from: m */
    private final String f11293m = "back_xiao_target";

    /* JADX INFO: renamed from: n */
    private final String f11294n = "back_ping_target";

    /* JADX INFO: renamed from: o */
    private final String f11295o = "back_speed_target";

    /* JADX INFO: renamed from: ab */
    private boolean f11257ab = false;

    /* JADX INFO: renamed from: ae */
    private boolean f11260ae = false;

    /* JADX INFO: renamed from: aE */
    private Handler f11252aE = new Handler() { // from class: lm.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1005) {
                ViewOnClickListenerC1883lm.m10259a(ViewOnClickListenerC1883lm.this);
                ViewOnClickListenerC1883lm.this.f11236P.setText(ViewOnClickListenerC1883lm.this.m10320x());
            } else {
                if (i != 1007) {
                    return;
                }
                ViewOnClickListenerC1883lm.this.m10329d();
            }
        }
    };

    /* JADX INFO: renamed from: lm$a */
    /* JADX INFO: compiled from: OnTimeHandTrainManager.java */
    public interface a {
        /* JADX INFO: renamed from: a */
        void mo7495a(int i);
    }

    /* JADX INFO: renamed from: a */
    private int m10257a(int i) {
        int i2 = (int) ((i * 11) / 30.0f);
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    private int m10258a(int i, float f) {
        int i2 = (int) ((i / f) * 100.0f);
        if (i2 > 100) {
            return 100;
        }
        return i2;
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ int m10259a(ViewOnClickListenerC1883lm viewOnClickListenerC1883lm) {
        int i = viewOnClickListenerC1883lm.f11251aD;
        viewOnClickListenerC1883lm.f11251aD = i + 1;
        return i;
    }

    public ViewOnClickListenerC1883lm(Activity activity, View view) {
        this.f11247a = activity;
        this.f11282b = view;
        m10263a(view);
        m10274e();
        m10324a();
    }

    /* JADX INFO: renamed from: a */
    public void m10324a() {
        this.f11281az = Integer.parseInt(C1902me.m10480a(this.f11247a));
        this.f11270ao = C1902me.m10486b(this.f11247a, m10261a("back_ping_target"), 50);
        this.f11271ap = C1902me.m10486b(this.f11247a, m10261a("back_xiao_target"), 50);
        this.f11269an = C1902me.m10486b(this.f11247a, m10261a("back_xuan_target"), 50);
        this.f11272aq = C1902me.m10486b(this.f11247a, m10261a("fore_xuan_target"), 50);
        this.f11274as = C1902me.m10486b(this.f11247a, m10261a("fore_xiao_target"), 50);
        this.f11273ar = C1902me.m10486b(this.f11247a, m10261a("fore_ping_target"), 50);
        this.f11267al = C1902me.m10486b(this.f11247a, m10261a("fore_speed_target"), 50);
        this.f11268am = C1902me.m10486b(this.f11247a, m10261a("back_speed_target"), 50);
        this.f11238R.setTargetSpeed(this.f11267al, this.f11268am);
    }

    /* JADX INFO: renamed from: a */
    private void m10263a(View view) {
        View viewInflate;
        this.f11296p = (TextView) view.findViewById(R.id.action_type);
        this.f11297q = (CircularSeekDarkBar) view.findViewById(R.id.progress_radian);
        this.f11299s = (CircularSeekDarkBar) view.findViewById(R.id.progress_speed_ontime);
        this.f11304x = (ImageView) view.findViewById(R.id.imgv_ontime_action);
        this.f11301u = (CircularSeekDarkBar) view.findViewById(R.id.progress_strength_ontime);
        this.f11298r = (CountView) view.findViewById(R.id.tv_count_radian);
        this.f11300t = (CountView) view.findViewById(R.id.tv_count_speed);
        this.f11302v = (CountView) view.findViewById(R.id.tv_count_strength);
        this.f11303w = (ImageView) view.findViewById(R.id.img_sound_ontime);
        this.f11236P = (TextView) view.findViewById(R.id.tv_timer_count);
        this.f11237Q = (TextView) view.findViewById(R.id.tv_rate_hit_ontime);
        this.f11238R = (ShotLineView) view.findViewById(R.id.shot_line);
        this.f11239S = (ControlRippleView) view.findViewById(R.id.mRippleView);
        this.f11240T = (TextView) view.findViewById(R.id.tv_train_history);
        this.f11241U = (TextView) view.findViewById(R.id.tv_control_btn);
        this.f11242V = (TextView) view.findViewById(R.id.tv_set_target);
        this.f11243W = (ImageView) view.findViewById(R.id.img_has_history);
        this.f11305y = (ImageView) view.findViewById(R.id.img_how_to_use_train);
        if (C1902me.m10490c() == 1) {
            viewInflate = LayoutInflater.from(this.f11247a).inflate(R.layout.layout_ontime_train_hand_bf, (ViewGroup) null);
        } else {
            viewInflate = LayoutInflater.from(this.f11247a).inflate(R.layout.layout_ontime_train_hand_fb, (ViewGroup) null);
        }
        this.f11221A = (TextView) viewInflate.findViewById(R.id.tv_avg_speed_ontime);
        this.f11222B = (TextView) viewInflate.findViewById(R.id.tv_back_xuan_count);
        this.f11223C = (TextView) viewInflate.findViewById(R.id.tv_back_ping_count);
        this.f11224D = (TextView) viewInflate.findViewById(R.id.tv_back_xiao_count);
        this.f11229I = (TextView) viewInflate.findViewById(R.id.tv_fore_avg_speed_ontime);
        this.f11230J = (TextView) viewInflate.findViewById(R.id.tv_fore_xuan_count);
        this.f11231K = (TextView) viewInflate.findViewById(R.id.tv_fore_ping_count);
        this.f11232L = (TextView) viewInflate.findViewById(R.id.tv_fore_xiao_count);
        this.f11225E = (BaseProgressView) viewInflate.findViewById(R.id.progress_back_xuan);
        this.f11226F = (BaseProgressView) viewInflate.findViewById(R.id.progress_back_ping);
        this.f11227G = (BaseProgressView) viewInflate.findViewById(R.id.progress_back_xiao);
        this.f11233M = (BaseProgressView) viewInflate.findViewById(R.id.progress_fore_xuan);
        this.f11234N = (BaseProgressView) viewInflate.findViewById(R.id.progress_fore_ping);
        this.f11235O = (BaseProgressView) viewInflate.findViewById(R.id.progress_fore_xiao);
        this.f11306z = (TextView) viewInflate.findViewById(R.id.tv_back_hand_title);
        this.f11228H = (TextView) viewInflate.findViewById(R.id.tv_fore_hand_title);
        ((LinearLayout) view.findViewById(R.id.ll_hand_data_ontime)).addView(viewInflate);
        if (MyApplication.m7738a().m7748h()) {
            this.f11241U.setTextSize(10.0f);
        }
    }

    /* JADX INFO: renamed from: e */
    private void m10274e() {
        this.f11237Q.setText(String.format(this.f11247a.getString(R.string.ontime_hit_rate), "0"));
        m10277f();
        m10286i();
        m10289j();
        m10280g();
        this.f11238R.setRecordingType();
        m10255E();
        m10283h();
        m10311s();
    }

    /* JADX INFO: renamed from: f */
    private void m10277f() {
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.f11247a.getAssets(), "fonts/S.ttf");
        this.f11298r.setTypeface(typefaceCreateFromAsset);
        this.f11300t.setTypeface(typefaceCreateFromAsset);
        this.f11302v.setTypeface(typefaceCreateFromAsset);
        this.f11228H.setTypeface(typefaceCreateFromAsset);
        this.f11306z.setTypeface(typefaceCreateFromAsset);
        this.f11236P.setTypeface(typefaceCreateFromAsset);
    }

    /* JADX INFO: renamed from: g */
    private void m10280g() {
        this.f11221A.setText("0");
        this.f11229I.setText("0");
    }

    /* JADX INFO: renamed from: h */
    private void m10283h() {
        this.f11225E.setCurColor(1);
        this.f11226F.setCurColor(1);
        this.f11227G.setCurColor(1);
        this.f11234N.setCurColor(2);
        this.f11235O.setCurColor(2);
        this.f11233M.setCurColor(2);
    }

    /* JADX INFO: renamed from: b */
    public void m10327b() {
        m10255E();
    }

    /* JADX INFO: renamed from: i */
    private void m10286i() {
        this.f11245Y = new String[]{this.f11247a.getString(R.string.Real_type_text1), this.f11247a.getString(R.string.Real_type_text2), this.f11247a.getString(R.string.Real_type_text3), this.f11247a.getString(R.string.Real_type_text4), this.f11247a.getString(R.string.Real_type_text5), this.f11247a.getString(R.string.Real_type_text6), this.f11247a.getString(R.string.Real_new_text111), this.f11247a.getString(R.string.Real_new_text122)};
    }

    /* JADX INFO: renamed from: j */
    private void m10289j() {
        this.f11256aa = new ArrayList<>();
        this.f11256aa.add(Integer.valueOf(R.drawable.f_jieji));
        this.f11256aa.add(Integer.valueOf(R.drawable.f_pingji));
        this.f11256aa.add(Integer.valueOf(R.drawable.f_shangxuan));
        this.f11256aa.add(Integer.valueOf(R.drawable.f_xiaoqiu));
        this.f11256aa.add(Integer.valueOf(R.drawable.faqiu));
        this.f11256aa.add(Integer.valueOf(R.drawable.z_jieji));
        this.f11256aa.add(Integer.valueOf(R.drawable.z_pingji));
        this.f11256aa.add(Integer.valueOf(R.drawable.z_shangxuan));
        this.f11256aa.add(Integer.valueOf(R.drawable.z_xiaoqiu));
        this.f11256aa.add(Integer.valueOf(R.drawable.gaoya));
    }

    /* JADX INFO: renamed from: k */
    private void m10291k() {
        if (this.f11257ab) {
            this.f11257ab = false;
            this.f11303w.setImageResource(R.drawable.img_sound_ontime_on);
        } else {
            this.f11257ab = true;
            this.f11303w.setImageResource(R.drawable.img_sound_ontime_close);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10326a(byte[] bArr) {
        switch (Integer.parseInt(String.format("%02X", Byte.valueOf(bArr[3])), 16)) {
            case 0:
                this.f11244X = this.f11245Y[0];
                break;
            case 1:
                this.f11244X = this.f11245Y[1];
                break;
            case 2:
                this.f11244X = this.f11245Y[2];
                break;
            case 3:
                this.f11244X = this.f11245Y[3];
                m10262a(3, C1893lw.m10452b(bArr[12]), C1893lw.m10453b(bArr[4], bArr[5]), C1893lw.m10452b(bArr[11]));
                break;
            case 4:
                this.f11244X = this.f11245Y[4];
                m10262a(4, C1893lw.m10452b(bArr[12]), C1893lw.m10453b(bArr[4], bArr[5]), C1893lw.m10452b(bArr[11]));
                break;
            case 5:
                this.f11244X = this.f11245Y[5];
                m10262a(5, C1893lw.m10452b(bArr[12]), C1893lw.m10453b(bArr[4], bArr[5]), C1893lw.m10452b(bArr[11]));
                break;
        }
        if (this.f11244X != null) {
            if (bArr[12] == 0) {
                this.f11246Z = this.f11245Y[6];
            } else {
                this.f11246Z = this.f11245Y[7];
            }
            if (this.f11246Z.equals(this.f11245Y[6])) {
                this.f11296p.setTextColor(this.f11247a.getResources().getColor(R.color.yellow_re_start_ble));
            } else {
                this.f11296p.setTextColor(this.f11247a.getResources().getColor(R.color.text_menu_checked));
            }
            if (this.f11244X.equals(this.f11245Y[0]) || this.f11244X.equals(this.f11245Y[1])) {
                this.f11296p.setText(this.f11244X);
            } else {
                this.f11296p.setText(this.f11246Z + this.f11244X);
            }
            if (this.f11244X.equals(this.f11245Y[0])) {
                this.f11304x.setImageResource(this.f11256aa.get(4).intValue());
            } else if (this.f11244X.equals(this.f11245Y[1])) {
                this.f11304x.setImageResource(this.f11256aa.get(9).intValue());
            } else if (this.f11244X.equals(this.f11245Y[2]) && this.f11246Z.equals(this.f11245Y[6])) {
                this.f11304x.setImageResource(this.f11256aa.get(5).intValue());
            } else if (this.f11244X.equals(this.f11245Y[2]) && this.f11246Z.equals(this.f11245Y[7])) {
                this.f11304x.setImageResource(this.f11256aa.get(0).intValue());
            } else if (this.f11244X.equals(this.f11245Y[3]) && this.f11246Z.equals(this.f11245Y[6])) {
                this.f11304x.setImageResource(this.f11256aa.get(8).intValue());
            } else if (this.f11244X.equals(this.f11245Y[3]) && this.f11246Z.equals(this.f11245Y[7])) {
                this.f11304x.setImageResource(this.f11256aa.get(3).intValue());
            } else if (this.f11244X.equals(this.f11245Y[4]) && this.f11246Z.equals(this.f11245Y[6])) {
                this.f11304x.setImageResource(this.f11256aa.get(7).intValue());
            } else if (this.f11244X.equals(this.f11245Y[4]) && this.f11246Z.equals(this.f11245Y[7])) {
                this.f11304x.setImageResource(this.f11256aa.get(2).intValue());
            } else if (this.f11244X.equals(this.f11245Y[5]) && this.f11246Z.equals(this.f11245Y[6])) {
                this.f11304x.setImageResource(this.f11256aa.get(6).intValue());
            } else if (this.f11244X.equals(this.f11245Y[5]) && this.f11246Z.equals(this.f11245Y[7])) {
                this.f11304x.setImageResource(this.f11256aa.get(1).intValue());
            }
            this.f11253aF = C1893lw.m10453b(bArr[4], bArr[5]);
            this.f11254aG = C1893lw.m10453b(bArr[6], bArr[7]);
            this.f11255aH = C1893lw.m10453b(bArr[8], bArr[9]);
            C1900mc.m10475c("data=====", "挥拍速度=" + this.f11253aF + "  力量=" + this.f11254aG + "  角度=" + this.f11255aH);
            if (!this.f11257ab && this.f11258ac != null) {
                this.f11258ac.mo7495a((int) ((((this.f11253aF * 270.0f) / 300.0f) * 300.0f) / 270.0f));
            }
            this.f11299s.setProgress(m10258a(this.f11253aF, 200.0f));
            this.f11301u.setProgress(m10257a(this.f11254aG));
            this.f11297q.setProgress(m10258a(this.f11255aH, 360.0f));
            this.f11298r.m8106a(this.f11255aH);
            this.f11300t.m8106a(this.f11253aF);
            this.f11302v.m8106a(Math.round((this.f11254aG * 0.11f) * 10.0f) / 10);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10262a(int i, int i2, int i3, int i4) {
        if (this.f11260ae) {
            if ((i2 == 0 && i3 >= this.f11267al) || (i2 == 1 && i3 >= this.f11268am)) {
                switch (i) {
                    case 3:
                        if (i2 == 0) {
                            this.f11266ak++;
                            m10297m();
                        } else {
                            this.f11263ah++;
                            m10300n();
                        }
                        break;
                    case 4:
                        if (i2 == 0) {
                            this.f11264ai++;
                            m10302o();
                        } else {
                            this.f11261af++;
                            m10304p();
                        }
                        break;
                    case 5:
                        if (i2 == 0) {
                            this.f11265aj++;
                            m10306q();
                        } else {
                            this.f11262ag++;
                            m10309r();
                        }
                        break;
                }
            }
            this.f11279ax = new OnTimeDetailTable(i, i2, System.currentTimeMillis() / 1000, i3, this.f11248aA, i4);
            this.f11279ax.save();
            if (i2 == 0) {
                m10266b(i3);
            } else {
                m10269c(i3);
            }
            this.f11238R.setShotData(this.f11279ax);
            this.f11237Q.setText(String.format(this.f11247a.getString(R.string.ontime_hit_rate), m10294l()));
        }
    }

    /* JADX INFO: renamed from: l */
    private String m10294l() {
        int i = ((this.f11275at + this.f11276au) * 60) / this.f11251aD;
        if (i == 0 && this.f11275at + this.f11276au >= 1) {
            i = 1;
        }
        return String.valueOf(i);
    }

    /* JADX INFO: renamed from: b */
    private void m10266b(int i) {
        this.f11277av = ((this.f11275at * this.f11277av) + i) / (this.f11275at + 1);
        this.f11275at++;
        this.f11229I.setText(String.valueOf(this.f11277av));
    }

    /* JADX INFO: renamed from: c */
    private void m10269c(int i) {
        this.f11278aw = ((this.f11276au * this.f11278aw) + i) / (this.f11276au + 1);
        this.f11276au++;
        this.f11221A.setText(String.valueOf(this.f11278aw));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public void m10297m() {
        this.f11235O.setFontPercent(m10258a(this.f11266ak, this.f11274as));
        if (this.f11266ak >= this.f11274as) {
            this.f11232L.setText(R.string.train_ontime_finish);
        } else {
            this.f11232L.setText(String.valueOf(this.f11266ak));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: n */
    public void m10300n() {
        this.f11227G.setFontPercent(m10258a(this.f11263ah, this.f11271ap));
        if (this.f11263ah >= this.f11271ap) {
            this.f11224D.setText(R.string.train_ontime_finish);
        } else {
            this.f11224D.setText(String.valueOf(this.f11263ah));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public void m10302o() {
        this.f11233M.setFontPercent(m10258a(this.f11264ai, this.f11272aq));
        if (this.f11264ai >= this.f11272aq) {
            this.f11230J.setText(R.string.train_ontime_finish);
        } else {
            this.f11230J.setText(String.valueOf(this.f11264ai));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: p */
    public void m10304p() {
        this.f11225E.setFontPercent(m10258a(this.f11261af, this.f11269an));
        if (this.f11261af >= this.f11269an) {
            this.f11222B.setText(R.string.train_ontime_finish);
        } else {
            this.f11222B.setText(String.valueOf(this.f11261af));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: q */
    public void m10306q() {
        this.f11234N.setFontPercent(m10258a(this.f11265aj, this.f11273ar));
        if (this.f11265aj >= this.f11273ar) {
            this.f11231K.setText(R.string.train_ontime_finish);
        } else {
            this.f11231K.setText(String.valueOf(this.f11265aj));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m10309r() {
        this.f11226F.setFontPercent(m10258a(this.f11262ag, this.f11270ao));
        if (this.f11262ag >= this.f11270ao) {
            this.f11223C.setText(R.string.train_ontime_finish);
        } else {
            this.f11223C.setText(String.valueOf(this.f11262ag));
        }
    }

    /* JADX INFO: renamed from: s */
    private void m10311s() {
        this.f11303w.setOnClickListener(this);
        this.f11241U.setOnClickListener(this);
        this.f11242V.setOnClickListener(this);
        this.f11240T.setOnClickListener(this);
        this.f11305y.setOnClickListener(this);
        this.f11241U.setOnTouchListener(new View.OnTouchListener() { // from class: lm.2
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (!ViewOnClickListenerC1883lm.this.f11260ae) {
                    return false;
                }
                switch (motionEvent.getAction()) {
                    case 0:
                        ViewOnClickListenerC1883lm.this.f11239S.m8102a();
                        ViewOnClickListenerC1883lm.this.f11252aE.sendEmptyMessageDelayed(PointerIconCompat.TYPE_CROSSHAIR, 1000L);
                        return true;
                    case 1:
                        C1900mc.m10474b("stopTrain", "isInTraining = " + ViewOnClickListenerC1883lm.this.f11260ae);
                        if (!ViewOnClickListenerC1883lm.this.f11260ae) {
                            return true;
                        }
                        C1900mc.m10474b("stopTrain", "fail");
                        ViewOnClickListenerC1883lm.this.f11252aE.removeMessages(PointerIconCompat.TYPE_CROSSHAIR);
                        ViewOnClickListenerC1883lm.this.f11239S.m8103b();
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
                C1887lq.m10421c(this.f11247a);
                break;
            case R.id.img_sound_ontime /* 2131296668 */:
                m10291k();
                break;
            case R.id.tv_control_btn /* 2131297218 */:
                if (!this.f11260ae) {
                    if (!MyApplication.m7738a().f7401b) {
                        m10254D();
                    } else {
                        m10313t();
                    }
                }
                break;
            case R.id.tv_set_target /* 2131297323 */:
                m10253C();
                break;
            case R.id.tv_train_history /* 2131297379 */:
                if (this.f11260ae) {
                    ((TrainOnTimeActivity) this.f11247a).m7489a(5);
                } else {
                    this.f11243W.setVisibility(8);
                    C1902me.m10485a((Context) this.f11247a, "trainHis", false);
                    C1887lq.m10407a(this.f11247a);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: t */
    private void m10313t() {
        m10317v();
        this.f11260ae = true;
        m10322y();
        this.f11241U.setText(R.string.long_press_to_stop);
        this.f11238R.m8262a();
        this.f11280ay = System.currentTimeMillis() / 1000;
        m10315u();
        m10319w();
    }

    /* JADX INFO: renamed from: u */
    private void m10315u() {
        OnTimeMainTable onTimeMainTable = new OnTimeMainTable(this.f11280ay, 0L, 0, this.f11281az, C1912mk.m10539b(), this.f11267al, this.f11268am, 0);
        onTimeMainTable.save();
        this.f11248aA = onTimeMainTable.getId();
    }

    /* JADX INFO: renamed from: v */
    private void m10317v() {
        this.f11266ak = 0;
        this.f11265aj = 0;
        this.f11264ai = 0;
        this.f11263ah = 0;
        this.f11262ag = 0;
        this.f11261af = 0;
        this.f11276au = 0;
        this.f11275at = 0;
        this.f11277av = 0;
        this.f11278aw = 0;
        m10297m();
        m10300n();
        m10302o();
        m10304p();
        m10306q();
        m10309r();
        m10280g();
        this.f11237Q.setText(String.format(this.f11247a.getString(R.string.ontime_hit_rate), "0"));
    }

    /* JADX INFO: renamed from: w */
    private void m10319w() {
        this.f11249aB = new Timer();
        this.f11251aD = 0;
        this.f11250aC = new TimerTask() { // from class: lm.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ViewOnClickListenerC1883lm.this.f11252aE.sendEmptyMessage(1005);
            }
        };
        this.f11249aB.schedule(this.f11250aC, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: x */
    public String m10320x() {
        StringBuffer stringBuffer = new StringBuffer();
        int i = this.f11251aD / 60;
        int i2 = this.f11251aD % 60;
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

    /* JADX INFO: renamed from: y */
    private void m10322y() {
        this.f11239S.setBackgroundColor(this.f11247a.getResources().getColor(R.color.white));
        this.f11240T.setTextColor(this.f11247a.getResources().getColor(R.color.text_menu_checked));
        this.f11242V.setTextColor(this.f11247a.getResources().getColor(R.color.text_menu_checked));
        this.f11241U.setBackgroundResource(R.drawable.ontime_finish_train_bg);
        this.f11241U.setTextColor(this.f11247a.getResources().getColor(R.color.selector_green_white_color));
    }

    /* JADX INFO: renamed from: z */
    private void m10323z() {
        this.f11239S.m8104c();
        this.f11239S.setBackgroundColor(this.f11247a.getResources().getColor(R.color.text_menu_checked));
        this.f11240T.setTextColor(this.f11247a.getResources().getColor(R.color.white));
        this.f11242V.setTextColor(this.f11247a.getResources().getColor(R.color.white));
        this.f11241U.setBackgroundResource(R.drawable.ontime_start_train_bg);
        this.f11241U.setTextColor(this.f11247a.getResources().getColor(R.color.selector_white_green_color));
    }

    /* JADX INFO: renamed from: A */
    private void m10251A() {
        this.f11249aB.cancel();
        long jCurrentTimeMillis = System.currentTimeMillis() / 1000;
        ContentValues contentValues = new ContentValues();
        contentValues.put("endTimeStemp", Long.valueOf(jCurrentTimeMillis));
        contentValues.put("maxProgress", Integer.valueOf(m10252B()));
        contentValues.put("hitRate", Integer.valueOf(Integer.parseInt(m10294l())));
        DataSupport.update(OnTimeMainTable.class, contentValues, this.f11248aA);
        this.f11238R.m8263a(System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: B */
    private int m10252B() {
        return Math.max(Math.max(Math.max(m10258a(this.f11266ak, this.f11274as), m10258a(this.f11263ah, this.f11271ap)), Math.max(m10258a(this.f11264ai, this.f11272aq), m10258a(this.f11261af, this.f11269an))), Math.max(m10258a(this.f11265aj, this.f11273ar), m10258a(this.f11262ag, this.f11270ao)));
    }

    /* JADX INFO: renamed from: C */
    private void m10253C() {
        this.f11259ad = new C1925mx(this.f11247a);
        this.f11259ad.m10692a(new C1925mx.a() { // from class: lm.4
            @Override // p000.C1925mx.a
            /* JADX INFO: renamed from: a */
            public void mo10330a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                ViewOnClickListenerC1883lm.this.f11272aq = i;
                ViewOnClickListenerC1883lm.this.f11273ar = i2;
                ViewOnClickListenerC1883lm.this.f11274as = i3;
                ViewOnClickListenerC1883lm.this.f11271ap = i7;
                ViewOnClickListenerC1883lm.this.f11269an = i5;
                ViewOnClickListenerC1883lm.this.f11270ao = i6;
                ViewOnClickListenerC1883lm.this.f11267al = i4;
                ViewOnClickListenerC1883lm.this.f11268am = i8;
                ViewOnClickListenerC1883lm.this.f11238R.setTargetSpeed(ViewOnClickListenerC1883lm.this.f11267al, ViewOnClickListenerC1883lm.this.f11268am);
                if (ViewOnClickListenerC1883lm.this.f11260ae) {
                    ViewOnClickListenerC1883lm.this.f11265aj = DataSupport.where("trainId = ? And handType = 0 And actionType = 5 And hitSpeed >= ?", String.valueOf(ViewOnClickListenerC1883lm.this.f11248aA), String.valueOf(ViewOnClickListenerC1883lm.this.f11267al)).count(OnTimeDetailTable.class);
                    ViewOnClickListenerC1883lm.this.f11266ak = DataSupport.where("trainId = ? And handType = 0 And actionType = 3 And hitSpeed >= ?", String.valueOf(ViewOnClickListenerC1883lm.this.f11248aA), String.valueOf(ViewOnClickListenerC1883lm.this.f11267al)).count(OnTimeDetailTable.class);
                    ViewOnClickListenerC1883lm.this.f11264ai = DataSupport.where("trainId = ? And handType = 0 And actionType = 4 And hitSpeed >= ?", String.valueOf(ViewOnClickListenerC1883lm.this.f11248aA), String.valueOf(ViewOnClickListenerC1883lm.this.f11267al)).count(OnTimeDetailTable.class);
                    ViewOnClickListenerC1883lm.this.f11262ag = DataSupport.where("trainId = ? And handType = 1 And actionType = 5 And hitSpeed >= ?", String.valueOf(ViewOnClickListenerC1883lm.this.f11248aA), String.valueOf(ViewOnClickListenerC1883lm.this.f11268am)).count(OnTimeDetailTable.class);
                    ViewOnClickListenerC1883lm.this.f11263ah = DataSupport.where("trainId = ? And handType = 1 And actionType = 3 And hitSpeed >= ?", String.valueOf(ViewOnClickListenerC1883lm.this.f11248aA), String.valueOf(ViewOnClickListenerC1883lm.this.f11268am)).count(OnTimeDetailTable.class);
                    ViewOnClickListenerC1883lm.this.f11261af = DataSupport.where("trainId = ? And handType = 1 And actionType = 4 And hitSpeed >= ?", String.valueOf(ViewOnClickListenerC1883lm.this.f11248aA), String.valueOf(ViewOnClickListenerC1883lm.this.f11268am)).count(OnTimeDetailTable.class);
                    ViewOnClickListenerC1883lm.this.m10297m();
                    ViewOnClickListenerC1883lm.this.m10300n();
                    ViewOnClickListenerC1883lm.this.m10302o();
                    ViewOnClickListenerC1883lm.this.m10304p();
                    ViewOnClickListenerC1883lm.this.m10306q();
                    ViewOnClickListenerC1883lm.this.m10309r();
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("foreTargetSpeed", Integer.valueOf(ViewOnClickListenerC1883lm.this.f11267al));
                    contentValues.put("backTargetSpeed", Integer.valueOf(ViewOnClickListenerC1883lm.this.f11268am));
                    DataSupport.update(OnTimeMainTable.class, contentValues, ViewOnClickListenerC1883lm.this.f11248aA);
                }
                ViewOnClickListenerC1883lm.this.m10256F();
            }
        });
        this.f11259ad.m10690a();
        MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: lm.5
            @Override // java.lang.Runnable
            public void run() {
                ViewOnClickListenerC1883lm.this.f11259ad.m10691a(ViewOnClickListenerC1883lm.this.f11273ar, ViewOnClickListenerC1883lm.this.f11274as, ViewOnClickListenerC1883lm.this.f11272aq, ViewOnClickListenerC1883lm.this.f11270ao, ViewOnClickListenerC1883lm.this.f11271ap, ViewOnClickListenerC1883lm.this.f11269an, ViewOnClickListenerC1883lm.this.f11267al, ViewOnClickListenerC1883lm.this.f11268am);
            }
        }, 300L);
    }

    /* JADX INFO: renamed from: c */
    public boolean m10328c() {
        return this.f11260ae;
    }

    /* JADX INFO: renamed from: d */
    public void m10329d() {
        this.f11260ae = false;
        m10323z();
        this.f11241U.setText(R.string.start_train_ontime);
        m10251A();
        if (((TrainOnTimeActivity) this.f11247a).m7493e()) {
            ((TrainOnTimeActivity) this.f11247a).m7491c();
        }
        this.f11243W.setVisibility(0);
        C1902me.m10485a((Context) this.f11247a, "trainHis", true);
    }

    /* JADX INFO: renamed from: D */
    private void m10254D() {
        ((TrainOnTimeActivity) this.f11247a).m7492d();
    }

    /* JADX INFO: renamed from: a */
    public void m10325a(a aVar) {
        this.f11258ac = aVar;
    }

    /* JADX INFO: renamed from: E */
    private void m10255E() {
        if (C1902me.m10489b((Context) this.f11247a, "trainHis", false)) {
            this.f11243W.setVisibility(0);
        } else {
            this.f11243W.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: F */
    public void m10256F() {
        C1902me.m10483a(this.f11247a, m10261a("fore_xuan_target"), this.f11272aq);
        C1902me.m10483a(this.f11247a, m10261a("fore_xiao_target"), this.f11274as);
        C1902me.m10483a(this.f11247a, m10261a("fore_ping_target"), this.f11273ar);
        C1902me.m10483a(this.f11247a, m10261a("fore_speed_target"), this.f11267al);
        C1902me.m10483a(this.f11247a, m10261a("back_xuan_target"), this.f11269an);
        C1902me.m10483a(this.f11247a, m10261a("back_xiao_target"), this.f11271ap);
        C1902me.m10483a(this.f11247a, m10261a("back_ping_target"), this.f11270ao);
        C1902me.m10483a(this.f11247a, m10261a("back_speed_target"), this.f11268am);
    }

    /* JADX INFO: renamed from: a */
    private String m10261a(String str) {
        return str + this.f11281az;
    }
}
