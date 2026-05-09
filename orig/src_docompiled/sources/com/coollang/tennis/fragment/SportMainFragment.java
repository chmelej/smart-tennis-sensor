package com.coollang.tennis.fragment;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.PointerIconCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.HistoryActivity;
import com.coollang.tennis.activity.LoginActivity;
import com.coollang.tennis.activity.SportTargetActivity;
import com.coollang.tennis.base.BaseFragment;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.DeleteDateBean;
import com.coollang.tennis.beans.GetUserUpdataTimeBean;
import com.coollang.tennis.beans.SportTargetBean;
import com.coollang.tennis.beans.SyncDataBean;
import com.coollang.tennis.beans.UpdatedeviceBean;
import com.coollang.tennis.p011db.model.MyActionTable;
import com.coollang.tennis.p011db.model.MyDetailTable;
import com.coollang.tennis.p011db.model.MyMainTable;
import com.coollang.tennis.p011db.model.TimeSignTable;
import com.coollang.tennis.widget.MySeekbar;
import com.coollang.tennis.widget.SportChart2;
import com.coollang.tennis.widget.SportLoadingProgress;
import com.google.gson.Gson;
import com.lidroid.xutils.util.PreferencesCookieStore;
import com.umeng.message.MsgConstant;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.C1808is;
import p000.C1821je;
import p000.C1827jk;
import p000.C1834jr;
import p000.C1839jw;
import p000.C1852ki;
import p000.C1856km;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1875le;
import p000.C1887lq;
import p000.C1893lw;
import p000.C1895ly;
import p000.C1896lz;
import p000.C1898ma;
import p000.C1900mc;
import p000.C1902me;
import p000.C1910mi;
import p000.C1912mk;
import p000.C1913ml;
import p000.C1914mm;
import p000.C1923mv;
import p000.C1926my;
import p000.C1929na;
import p000.DialogC1860kq;
import p000.DialogC1863kt;
import p000.DialogC2231wz;
import p000.ada;
import p000.ajd;
import p000.akd;
import p000.asw;
import pub.devrel.easypermissions.EasyPermissions;

/* JADX INFO: loaded from: classes.dex */
public class SportMainFragment extends BaseFragment implements View.OnClickListener, EasyPermissions.PermissionCallbacks {

    /* JADX INFO: renamed from: a */
    public static boolean f7597a = false;

    /* JADX INFO: renamed from: b */
    public static boolean f7598b = false;

    /* JADX INFO: renamed from: B */
    private float f7600B;

    /* JADX INFO: renamed from: C */
    private float f7601C;

    /* JADX INFO: renamed from: D */
    private float f7602D;

    /* JADX INFO: renamed from: H */
    private int f7606H;

    /* JADX INFO: renamed from: I */
    private int f7607I;

    /* JADX INFO: renamed from: K */
    private SwipeRefreshLayout f7609K;

    /* JADX INFO: renamed from: L */
    private Gson f7610L;

    /* JADX INFO: renamed from: M */
    private C1874ld f7611M;

    /* JADX INFO: renamed from: N */
    private MyMainTable f7612N;

    /* JADX INFO: renamed from: O */
    private MyActionTable f7613O;

    /* JADX INFO: renamed from: Q */
    private SportTargetBean f7615Q;

    /* JADX INFO: renamed from: T */
    private PopupWindow f7618T;

    /* JADX INFO: renamed from: X */
    private View f7622X;

    /* JADX INFO: renamed from: Y */
    private View f7623Y;

    /* JADX INFO: renamed from: ab */
    private C1929na f7626ab;

    /* JADX INFO: renamed from: ac */
    private DialogC2231wz f7627ac;

    /* JADX INFO: renamed from: ad */
    private C1926my f7628ad;

    /* JADX INFO: renamed from: ae */
    private List<String> f7629ae;

    /* JADX INFO: renamed from: c */
    C1923mv f7632c;

    /* JADX INFO: renamed from: g */
    private ImageView f7636g;

    /* JADX INFO: renamed from: h */
    private TextView f7637h;

    /* JADX INFO: renamed from: i */
    private AnimationDrawable f7638i;

    /* JADX INFO: renamed from: j */
    private MySeekbar f7639j;

    /* JADX INFO: renamed from: k */
    private PopupWindow f7640k;

    /* JADX INFO: renamed from: l */
    private TextView f7641l;

    /* JADX INFO: renamed from: m */
    private TextView f7642m;

    /* JADX INFO: renamed from: n */
    private CardView f7643n;

    /* JADX INFO: renamed from: o */
    private TextView f7644o;

    /* JADX INFO: renamed from: p */
    private ListView f7645p;

    /* JADX INFO: renamed from: q */
    private ExpandableListView f7646q;

    /* JADX INFO: renamed from: r */
    private C1827jk f7647r;

    /* JADX INFO: renamed from: s */
    private View f7648s;

    /* JADX INFO: renamed from: t */
    private SportChart2 f7649t;

    /* JADX INFO: renamed from: u */
    private TextView f7650u;

    /* JADX INFO: renamed from: v */
    private LinearLayout f7651v;

    /* JADX INFO: renamed from: z */
    private C1821je f7655z;

    /* JADX INFO: renamed from: w */
    private int f7652w = 0;

    /* JADX INFO: renamed from: x */
    private List<Integer> f7653x = new ArrayList();

    /* JADX INFO: renamed from: y */
    private List<MyActionTable> f7654y = new ArrayList();

    /* JADX INFO: renamed from: A */
    private final int f7599A = 1;

    /* JADX INFO: renamed from: E */
    private int f7603E = 0;

    /* JADX INFO: renamed from: F */
    private int f7604F = 40;

    /* JADX INFO: renamed from: G */
    private int f7605G = 1000;

    /* JADX INFO: renamed from: J */
    private int f7608J = 37;

    /* JADX INFO: renamed from: P */
    private boolean f7614P = true;

    /* JADX INFO: renamed from: R */
    private int f7616R = 0;

    /* JADX INFO: renamed from: S */
    private String f7617S = "-1";

    /* JADX INFO: renamed from: U */
    private int f7619U = 0;

    /* JADX INFO: renamed from: V */
    private int f7620V = 0;

    /* JADX INFO: renamed from: W */
    private int f7621W = 0;

    /* JADX INFO: renamed from: Z */
    private String f7624Z = "";

    /* JADX INFO: renamed from: aa */
    private boolean f7625aa = false;

    /* JADX INFO: renamed from: af */
    private int f7630af = 0;

    /* JADX INFO: renamed from: d */
    Handler f7633d = new Handler() { // from class: com.coollang.tennis.fragment.SportMainFragment.20
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    SportMainFragment.this.m7863a(SportMainFragment.this.f7603E);
                    SportMainFragment.this.f7633d.postDelayed(SportMainFragment.this.f7634e, 20L);
                    break;
                case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                    SportMainFragment.this.f7647r.m9941a();
                    break;
                case PointerIconCompat.TYPE_HELP /* 1003 */:
                    if (SportMainFragment.this.f7627ac != null && SportMainFragment.this.f7627ac.isShowing()) {
                        SportMainFragment.this.f7627ac.m12196a(SportMainFragment.this.getString(R.string.download_success)).m12203d("OK").m12199a(2);
                        MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.20.1
                            @Override // java.lang.Runnable
                            public void run() {
                                SportMainFragment.this.f7627ac.dismiss();
                            }
                        }, 1000L);
                    }
                    SportMainFragment.this.f7647r.m9941a();
                    break;
                case 1005:
                    if (SportMainFragment.this.f7647r != null && SportMainFragment.this.f7647r.m9949b()) {
                        long jLongValue = ((Long) message.obj).longValue();
                        int iM9938a = SportMainFragment.this.f7647r.m9938a(jLongValue);
                        int iM9948b = SportMainFragment.this.f7647r.m9948b(jLongValue);
                        if (iM9938a != -1 && iM9948b != -1) {
                            LinearLayout linearLayout = (LinearLayout) SportMainFragment.this.f7646q.findViewWithTag(iM9938a + "-" + iM9948b);
                            int iCount = DataSupport.where("sign2 = ? And UserID = ?", C1912mk.m10542c(jLongValue - ((long) C1912mk.m10541c())), SportMainFragment.this.f7617S).count(MyDetailTable.class) - message.arg1;
                            int totletimes = ((MyMainTable) DataSupport.where("date = ? And UserID = ?", String.valueOf(jLongValue), SportMainFragment.this.f7617S).find(MyMainTable.class).get(0)).getTotletimes() - message.arg1;
                            if (totletimes > 0 && iCount > 0) {
                                int i = (iCount * 100) / totletimes;
                                if (i > 100) {
                                    i = 100;
                                }
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
                                    TextView textView = (TextView) linearLayout.findViewById(R.id.tv_cur_status_child);
                                    SportLoadingProgress sportLoadingProgress = (SportLoadingProgress) linearLayout.findViewById(R.id.progress_sport_child);
                                    if (i < 100) {
                                        textView.setText(SportMainFragment.this.getString(R.string.loading_details) + i + "%");
                                        sportLoadingProgress.setProgress(i);
                                    } else {
                                        textView.setText(SportMainFragment.this.getString(R.string.uploading_main_data));
                                        sportLoadingProgress.setProgress(i);
                                    }
                                }
                                if (i < 100) {
                                    Message messageObtainMessage = SportMainFragment.this.f7633d.obtainMessage();
                                    messageObtainMessage.obj = Long.valueOf(jLongValue);
                                    messageObtainMessage.arg1 = message.arg1;
                                    messageObtainMessage.what = 1005;
                                    int i2 = (totletimes / 100) * 4;
                                    if (i2 < 100) {
                                        i2 = 100;
                                    }
                                    if (i2 > 500) {
                                        i2 = 500;
                                    }
                                    SportMainFragment.this.f7633d.sendMessageDelayed(messageObtainMessage, i2);
                                }
                                break;
                            }
                        }
                    }
                    break;
                case PointerIconCompat.TYPE_CELL /* 1006 */:
                    SportMainFragment.this.f7633d.removeMessages(1005);
                    Message message2 = new Message();
                    message2.what = 1005;
                    message2.arg1 = message.arg1;
                    message2.obj = message.obj;
                    SportMainFragment.this.f7633d.sendMessage(message2);
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: e */
    Runnable f7634e = new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.21
        @Override // java.lang.Runnable
        public void run() {
            if (SportMainFragment.this.f7600B == 0.0f && SportMainFragment.this.f7601C == 0.0f) {
                SportMainFragment.this.f7600B = SportMainFragment.this.f7639j.getWidth();
            }
            if (SportMainFragment.this.f7601C == 0.0f) {
                SportMainFragment.this.f7601C = SportMainFragment.this.f7642m.getWidth();
            }
            if (SportMainFragment.this.f7600B <= 0.0f || SportMainFragment.this.f7601C <= 0.0f) {
                return;
            }
            if (SportMainFragment.this.f7603E < SportMainFragment.this.f7604F) {
                C1900mc.m10474b("move2Target", "currentProgress == " + SportMainFragment.this.f7603E + " progress == " + SportMainFragment.this.f7604F);
                if (SportMainFragment.this.f7604F - SportMainFragment.this.f7603E < 10) {
                    SportMainFragment.this.f7603E = SportMainFragment.this.f7604F;
                } else {
                    SportMainFragment.this.f7603E += 10;
                }
                SportMainFragment.this.f7633d.sendEmptyMessage(1);
                return;
            }
            SportMainFragment.this.f7633d.removeCallbacks(this);
            SportMainFragment.this.f7603E = 0;
        }
    };

    /* JADX INFO: renamed from: f */
    AdapterView.OnItemClickListener f7635f = new AdapterView.OnItemClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.7
        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (i) {
                case 0:
                    SportMainFragment.this.f7640k.dismiss();
                    C1839jw.f10820a.m10016a();
                    C1839jw.f10820a = null;
                    MyApplication.m7738a().f7401b = false;
                    SportMainFragment.this.m7896l();
                    break;
                case 1:
                    SportMainFragment.this.f7640k.dismiss();
                    SportMainFragment.this.m7908r();
                    break;
                case 2:
                    SportMainFragment.this.f7640k.dismiss();
                    break;
                case 3:
                    SportMainFragment.this.f7640k.dismiss();
                    SportMainFragment.this.m7910s();
                    break;
                case 4:
                    SportMainFragment.this.f7640k.dismiss();
                    SportMainFragment.this.m7912t();
                    break;
                case 5:
                    SportMainFragment.this.f7640k.dismiss();
                    if (SportMainFragment.this.f7655z.m9865a() >= 50 || (C1839jw.f10820a != null && C1839jw.f10820a.f10812c.equals("KL_DFU"))) {
                        C1887lq.m10420b(SportMainFragment.this.getActivity(), SportMainFragment.this.f7624Z, SportMainFragment.this.f7630af);
                    } else {
                        C1913ml.m10553a(SportMainFragment.this.getString(R.string.no_power_to_upgrate));
                    }
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: ag */
    private C1875le f7631ag = new C1875le() { // from class: com.coollang.tennis.fragment.SportMainFragment.14
        @Override // p000.C1875le
        /* JADX INFO: renamed from: a */
        public void mo7382a() {
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.14.1
                @Override // java.lang.Runnable
                public void run() {
                    if (C1839jw.f10820a == null || !C1839jw.f10820a.f10812c.equals("KL_DFU")) {
                        SportMainFragment.this.m7902o();
                    } else {
                        C1839jw.m10026a().m10044b();
                    }
                }
            }, 1000L);
            SportMainFragment.this.m7894k();
            C1839jw.m10026a().m10045c();
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: b */
        public void mo7930b() {
            SportMainFragment.this.m7896l();
            if (SportMainFragment.this.f7609K.isRefreshing()) {
                SportMainFragment.this.f7609K.setRefreshing(false);
            }
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: c */
        public void mo7931c() {
            if (C1839jw.f10820a != null) {
                SportMainFragment.this.f7637h.setText(C1839jw.f10820a.m10023e());
            }
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: a */
        public void mo7927a(int i) {
            SportMainFragment.this.f7608J = i;
            C1900mc.m10474b("电量", " == " + i);
            SportMainFragment.this.f7655z.m9866a(SportMainFragment.this.f7608J);
            if (!SportMainFragment.this.f7625aa || SportMainFragment.this.f7608J < 50) {
                SportMainFragment.this.f7625aa = false;
            } else {
                C1839jw.m10026a().m10042a(33);
            }
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: d */
        public void mo7932d() {
            List listFind = DataSupport.where("UserID = ? And isDeleted < 1", SportMainFragment.this.f7617S).order("date desc").find(MyMainTable.class);
            SportMainFragment.this.f7647r.m9941a();
            if (!listFind.isEmpty() && ((MyMainTable) listFind.get(0)).getSign1() == 0) {
                SportMainFragment.this.f7647r.m9947a(true);
                C1900mc.m10474b("MyMainTable=0x23=", "true");
            }
            C1900mc.m10475c("MyMainTable=0x23=", SportMainFragment.this.f7610L.toJson(DataSupport.where("UserID = ? And isDeleted < 1", SportMainFragment.this.f7617S).order("date desc").find(MyMainTable.class)));
            C1900mc.m10475c("MyActionTable=0x23=", SportMainFragment.this.f7610L.toJson(DataSupport.where("UserID = ?", SportMainFragment.this.f7617S).order("date desc").find(MyActionTable.class)));
            SportMainFragment.this.f7609K.setRefreshing(false);
            if (!SportMainFragment.f7598b) {
                Toast.makeText(SportMainFragment.this.getActivity(), C1914mm.m10557b(R.string.load_success), 0).show();
            } else {
                SportMainFragment.f7598b = false;
            }
            SportMainFragment.this.m7898m();
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: e */
        public void mo7933e() {
            C1900mc.m10475c("MyMainTable=0x25=", SportMainFragment.this.f7610L.toJson(DataSupport.where("UserID = ? And isDeleted < 1", SportMainFragment.this.f7617S).order("date desc").find(MyMainTable.class)));
            C1900mc.m10475c("MyActionTable=0x25=", SportMainFragment.this.f7610L.toJson(DataSupport.where("UserID = ?", SportMainFragment.this.f7617S).order("date desc").find(MyActionTable.class)));
            SportMainFragment.this.f7609K.setRefreshing(false);
            SportMainFragment.this.f7647r.m9947a(false);
            SportMainFragment.this.m7915v();
            if (SportMainFragment.this.f7625aa) {
                MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.14.2
                    @Override // java.lang.Runnable
                    public void run() {
                        C1839jw.m10026a().m10042a(34);
                    }
                }, 1000L);
            }
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: a */
        public void mo7929a(String str) {
            SportMainFragment.this.f7624Z = str;
            Log.d("aaaa", "deviceVersion==" + SportMainFragment.this.f7624Z);
            SportMainFragment.this.f7611M.m10222g();
        }

        @Override // p000.C1875le
        /* JADX INFO: renamed from: a */
        public void mo7928a(long j, int i) {
            SportMainFragment.this.f7647r.m9942a(j, i);
        }
    };

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    /* JADX INFO: renamed from: a */
    public void mo7922a(int i, List<String> list) {
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    /* JADX INFO: renamed from: b */
    public void mo7924b(int i, List<String> list) {
    }

    @Override // com.coollang.tennis.base.BaseFragment, android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // android.support.v4.app.Fragment
    public boolean shouldShowRequestPermissionRationale(String str) {
        return false;
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public View mo7735a(LayoutInflater layoutInflater) {
        this.f7622X = layoutInflater.inflate(R.layout.fragment_sport_main, (ViewGroup) null, false);
        return this.f7622X;
    }

    @Override // com.coollang.tennis.base.BaseFragment
    @SuppressLint({"CutPasteId", "ResourceAsColor"})
    /* JADX INFO: renamed from: a */
    public void mo7737a(View view) {
        m7923b();
        this.f7611M = new C1874ld();
        this.f7610L = new Gson();
        m7925c();
        akd.m1706a().m1719a(this);
        ajd.m1480a(getActivity());
        this.f7617S = C1902me.m10480a(getActivity());
        this.f7655z = new C1821je(getActivity(), this.f7608J);
        m7892j();
        m7875b(view);
        m7881e();
        m7890i();
        m7896l();
        this.f7607I = MyApplication.m7738a().f7403d;
        this.f7604F = this.f7607I;
        this.f7644o.setTypeface(MyApplication.m7738a().f7404e);
        if (MyApplication.m7738a().f7401b) {
            m7894k();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m7923b() {
        if (ContextCompat.checkSelfPermission(getActivity(), MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE) != 0) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE}, 1);
        }
    }

    @Override // com.coollang.tennis.base.BaseFragment
    /* JADX INFO: renamed from: a */
    public void mo7736a() {
        C1900mc.m10475c("mainfragment", "initData");
        this.f7611M.m10216e();
        this.f7629ae = new ArrayList();
        m7915v();
    }

    /* JADX INFO: renamed from: c */
    public void m7925c() {
        new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.1
            @Override // java.lang.Runnable
            public void run() {
                if (SportMainFragment.this.f7614P) {
                    Log.e("SportMainFragment", "setpopwinds_firstlogin:第一次登录 ");
                    SportMainFragment.this.m7926d();
                }
            }
        }, 3000L);
    }

    /* JADX INFO: renamed from: d */
    public void m7926d() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getActivity());
        this.f7618T = new PopupWindow(getActivity());
        View viewInflate = layoutInflaterFrom.inflate(R.layout.firstlogin_popwindow, (ViewGroup) null);
        ((RelativeLayout) viewInflate.findViewById(R.id.parent)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SportMainFragment.this.f7618T.dismiss();
            }
        });
        this.f7618T.setWidth(-1);
        this.f7618T.setHeight(-1);
        this.f7618T.setBackgroundDrawable(new BitmapDrawable());
        this.f7618T.setFocusable(false);
        this.f7618T.setOutsideTouchable(true);
        this.f7618T.setTouchable(true);
        this.f7618T.setContentView(viewInflate);
        this.f7618T.showAtLocation(viewInflate, 17, 0, 0);
        TextView textView = (TextView) viewInflate.findViewById(R.id.content_device);
        ((TextView) viewInflate.findViewById(R.id.cancel)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SportMainFragment.this.f7618T.dismiss();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.16
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SportMainFragment.this.f7618T.dismiss();
            }
        });
    }

    /* JADX INFO: renamed from: b */
    private void m7875b(View view) {
        this.f7641l = (TextView) this.f7622X.findViewById(R.id.tv_history_realtime);
        this.f7637h = (TextView) this.f7622X.findViewById(R.id.tv_title_realtime);
        this.f7636g = (ImageView) this.f7622X.findViewById(R.id.imgv_device_right);
        this.f7623Y = this.f7622X.findViewById(R.id.title_view);
        this.f7639j = (MySeekbar) this.f7622X.findViewById(R.id.fragment_sprot_seekbar);
        this.f7644o = (TextView) this.f7622X.findViewById(R.id.fragment_sport_tv_week_times);
        this.f7609K = (SwipeRefreshLayout) this.f7622X.findViewById(R.id.activity_main_swipe_refresh_layout);
        this.f7646q = (ExpandableListView) this.f7622X.findViewById(R.id.explv_sport_main);
        this.f7642m = (TextView) this.f7622X.findViewById(R.id.tv_progress);
        this.f7643n = (CardView) this.f7622X.findViewById(R.id.cardview_target_sport);
        this.f7648s = LayoutInflater.from(getActivity()).inflate(R.layout.layout_sport_main_header, (ViewGroup) null);
        this.f7649t = (SportChart2) this.f7648s.findViewById(R.id.fragment_sport_chart);
        this.f7650u = (TextView) this.f7648s.findViewById(R.id.fragment_sport_tv_bat);
        this.f7651v = (LinearLayout) this.f7648s.findViewById(R.id.ll_introduce_sport);
        this.f7636g.setVisibility(0);
    }

    @SuppressLint({"ResourceAsColor"})
    /* JADX INFO: renamed from: e */
    private void m7881e() {
        this.f7646q.addHeaderView(this.f7648s);
        this.f7647r = new C1827jk(getActivity(), this.f7633d);
        this.f7647r.m9946a(new C1827jk.d() { // from class: com.coollang.tennis.fragment.SportMainFragment.17
            @Override // p000.C1827jk.d
            /* JADX INFO: renamed from: a */
            public void mo7934a() {
                SportMainFragment.this.f7626ab = new C1929na(SportMainFragment.this.getActivity());
                SportMainFragment.this.f7626ab.m10714a();
            }
        });
        this.f7647r.m9945a(new C1827jk.c() { // from class: com.coollang.tennis.fragment.SportMainFragment.18
            @Override // p000.C1827jk.c
            /* JADX INFO: renamed from: a */
            public void mo7935a() {
                C1900mc.m10474b("Tag", "onFirstDataChanged");
                SportMainFragment.this.m7884f();
            }
        });
        this.f7646q.setAdapter(this.f7647r);
        m7884f();
        this.f7609K.setColorSchemeResources(R.color.white_ban);
        this.f7609K.setProgressBackgroundColor(R.color.text_menu_checked);
        this.f7609K.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.19
            @Override // android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener
            public void onRefresh() {
                if (SportMainFragment.this.f7647r.m9949b()) {
                    SportMainFragment.this.f7609K.setRefreshing(false);
                } else if (MyApplication.m7738a().f7401b) {
                    SportMainFragment.this.m7902o();
                } else {
                    SportMainFragment.this.f7633d.postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.19.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SportMainFragment.this.m7898m();
                            C1913ml.m10553a(C1914mm.m10557b(R.string.toast_device_unconnectioned));
                            SportMainFragment.this.f7609K.setRefreshing(false);
                        }
                    }, 2000L);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m7884f() {
        if (this.f7647r.getGroupCount() != 0) {
            this.f7646q.expandGroup(0);
            this.f7651v.setVisibility(8);
        } else {
            this.f7651v.setVisibility(0);
        }
        m7886g();
        this.f7650u.setText(C1910mi.m10524a(String.valueOf(this.f7652w), String.format(getString(R.string.sport_main_times), Integer.valueOf(this.f7652w)), 40, Color.parseColor("#25c9ad")));
        this.f7649t.setData(this.f7653x);
    }

    /* JADX INFO: renamed from: g */
    private void m7886g() {
        if (DataSupport.where("UserID = ? And isDeleted = 0", this.f7617S).count(MyMainTable.class) > 0) {
            this.f7654y.clear();
            this.f7654y.addAll(DataSupport.where("UserID = ? And date = ?", this.f7617S, String.valueOf(((MyMainTable) DataSupport.where("UserID = ? And isDeleted = 0", this.f7617S).order("date desc").find(MyMainTable.class).get(0)).getDate())).find(MyActionTable.class));
            if (this.f7654y.size() > 0) {
                this.f7653x.clear();
                this.f7653x.add(Integer.valueOf(this.f7654y.get(0).getFaqiu()));
                this.f7653x.add(Integer.valueOf(this.f7654y.get(0).getGaoya()));
                this.f7653x.add(Integer.valueOf(this.f7654y.get(0).getJieji()));
                this.f7653x.add(Integer.valueOf(this.f7654y.get(0).getXiaoqiu()));
                this.f7653x.add(Integer.valueOf(this.f7654y.get(0).getXuanqiu()));
                this.f7653x.add(Integer.valueOf(this.f7654y.get(0).getPingji()));
                this.f7652w = this.f7654y.get(0).getFaqiu() + this.f7654y.get(0).getGaoya() + this.f7654y.get(0).getJieji() + this.f7654y.get(0).getXiaoqiu() + this.f7654y.get(0).getXuanqiu() + this.f7654y.get(0).getPingji();
                return;
            }
            return;
        }
        m7887h();
    }

    /* JADX INFO: renamed from: h */
    private void m7887h() {
        this.f7653x.clear();
        this.f7653x.add(0);
        this.f7653x.add(0);
        this.f7653x.add(0);
        this.f7653x.add(0);
        this.f7653x.add(0);
        this.f7653x.add(0);
        this.f7652w = 0;
    }

    /* JADX INFO: renamed from: i */
    private void m7890i() {
        this.f7641l.setOnClickListener(this);
        this.f7636g.setOnClickListener(this);
        this.f7643n.setOnClickListener(this);
    }

    /* JADX INFO: renamed from: j */
    private void m7892j() {
        if (DataSupport.where("UserID = ? And signdate is null", this.f7617S).count(MyMainTable.class) > 0) {
            C1856km.m10109a().m10117b(this.f7617S);
        }
        if (DataSupport.where("UserId = ? And handtype is null", this.f7617S).count(MyDetailTable.class) > 0) {
            C1856km.m10109a().m10112a(this.f7617S);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7863a(int i) {
        if (i > this.f7606H) {
            i = this.f7606H;
        }
        double d = ((double) i) * 1.0d;
        this.f7602D = (float) (d / (((double) this.f7606H) * 1.0d));
        if (this.f7602D > 1.0d) {
            this.f7602D = 1.0f;
        }
        C1900mc.m10474b("move2Target", "progress = " + i + "  max = " + this.f7606H);
        this.f7639j.setProgress(i);
        float f = (float) (d / (((double) this.f7605G) * 1.0d));
        this.f7642m.setText(C1898ma.m10471a((double) (f * 100.0f)) + "%");
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        if (this.f7601C == 0.0f) {
            this.f7601C = this.f7642m.getWidth();
        }
        layoutParams.setMargins((int) (((this.f7602D * this.f7639j.getWidth()) - (this.f7601C / 2.0f)) + C1895ly.m10460a(C1914mm.m10554a(), 15.0f)), 0, 0, 0);
        this.f7642m.setLayoutParams(layoutParams);
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() throws Throwable {
        super.onResume();
        C1839jw.m10026a().m10045c();
        C1839jw.m10026a().m10041a(this.f7631ag);
        this.f7611M.m10219f();
        m7898m();
        ada.m302b(getActivity());
        if (MyApplication.m7738a().f7401b) {
            m7894k();
            return;
        }
        m7896l();
        if (this.f7628ad == null || !this.f7628ad.m10705c()) {
            return;
        }
        this.f7628ad.m10706d();
    }

    @Override // android.support.v4.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (!z && MyApplication.m7738a().f7401b && f7597a) {
            f7598b = true;
            this.f7609K.setRefreshing(true);
            m7902o();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: k */
    public void m7894k() {
        if (C1839jw.f10820a != null) {
            this.f7637h.setText(C1839jw.f10820a.m10023e());
        }
        this.f7636g.setImageResource(R.drawable.devoice_checked);
        if (this.f7638i != null) {
            this.f7638i.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m7896l() {
        this.f7637h.setText(R.string.title);
        this.f7636g.setImageResource(R.drawable.device_unconnect_anim);
        this.f7638i = (AnimationDrawable) this.f7636g.getDrawable();
        this.f7638i.start();
        if (this.f7640k == null || !this.f7640k.isShowing()) {
            return;
        }
        this.f7640k.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: m */
    public void m7898m() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(DataSupport.where("sign2 = ? AND UserID = ? And isDeleted < 1", m7900n(), this.f7617S).find(MyMainTable.class));
        for (int i = 0; i < arrayList.size(); i++) {
            this.f7616R += ((MyMainTable) arrayList.get(i)).getTotletimes();
        }
        this.f7604F = this.f7616R;
        if (this.f7614P) {
            this.f7633d.postDelayed(this.f7634e, 10L);
            this.f7614P = false;
        } else {
            m7863a(this.f7604F);
        }
        String str = " " + String.valueOf(this.f7616R) + " ";
        this.f7644o.setText(C1910mi.m10524a(str, C1914mm.m10557b(R.string.sport_text1) + str + C1914mm.m10557b(R.string.times), 27, Color.parseColor("#ff8560")));
        this.f7616R = 0;
    }

    /* JADX INFO: renamed from: n */
    private String m7900n() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + " " + calendar.get(3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (C1896lz.m10463a(view.getId())) {
            return;
        }
        int id = view.getId();
        if (id == R.id.cardview_target_sport) {
            SportTargetActivity.m7336a(getActivity(), this.f7619U, this.f7620V, this.f7621W);
            return;
        }
        if (id == R.id.fragment_sport_ll_target) {
            SportTargetActivity.m7336a(getActivity(), this.f7619U, this.f7620V, this.f7621W);
            return;
        }
        if (id != R.id.imgv_device_right) {
            if (id != R.id.tv_history_realtime) {
                return;
            }
            HistoryActivity.m6945a(getActivity());
        } else {
            if (BluetoothAdapter.getDefaultAdapter() == null) {
                Toast.makeText(getActivity(), R.string.no_bluetooth, 1).show();
                return;
            }
            if (!MyApplication.m7738a().f7401b) {
                ShowScanPop();
            } else if (this.f7647r.m9949b()) {
                C1913ml.m10553a(getString(R.string.pls_wait_loading_detail));
            } else {
                m7906q();
            }
        }
    }

    @asw(m5376a = 101)
    private void ShowScanPop() {
        if (EasyPermissions.m11138a(getContext(), "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION")) {
            if (Build.VERSION.SDK_INT >= 28) {
                if (!((LocationManager) getActivity().getSystemService("location")).isProviderEnabled("gps")) {
                    Toast.makeText(getActivity(), R.string.no_loaction_service, 0).show();
                    Intent intent = new Intent();
                    intent.setAction("android.settings.LOCATION_SOURCE_SETTINGS");
                    startActivityForResult(intent, 1315);
                    return;
                }
                this.f7632c = new C1923mv(getActivity());
                this.f7632c.m10640a();
                this.f7625aa = true;
                return;
            }
            this.f7632c = new C1923mv(getActivity());
            this.f7632c.m10640a();
            this.f7625aa = true;
            return;
        }
        EasyPermissions.m11134a(this, " ", 101, "android.permission.ACCESS_COARSE_LOCATION", "android.permission.ACCESS_FINE_LOCATION");
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1) {
            if (i2 != 0) {
                ShowScanPop();
            }
        } else if (i == 101 && i2 == 101) {
            if (MyApplication.m7738a().f7401b) {
                this.f7622X.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.2
                    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
                    public void onGlobalLayout() {
                        SportMainFragment.this.f7622X.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                        SportMainFragment.this.f7609K.setRefreshing(true);
                        SportMainFragment.this.m7902o();
                    }
                });
            } else {
                new Handler().postDelayed(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.3
                    @Override // java.lang.Runnable
                    public void run() {
                        SportMainFragment.this.m7898m();
                        SportMainFragment.this.f7609K.setRefreshing(false);
                    }
                }, 3000L);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: o */
    public void m7902o() {
        long jM10532a = C1912mk.m10532a() - C1912mk.m10533a("1970-01-01 00:00:00");
        C1900mc.m10474b("time", C1912mk.m10532a() + "");
        C1900mc.m10474b("changeTime", C1912mk.m10533a("1970-01-01 00:00:00") + "");
        String strM10534a = C1912mk.m10534a(jM10532a);
        C1900mc.m10473a("校准的时间", "发送给设备的时间=" + jM10532a);
        C1900mc.m10473a("校准的时间", "发送给设备的时间=" + strM10534a);
        byte[] bArrM10450a = C1893lw.m10450a(jM10532a);
        C1839jw.m10026a().m10042a(17, bArrM10450a[0], bArrM10450a[1], bArrM10450a[2], bArrM10450a[3]);
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11064a.contains("\"ret\":\"-10003\"")) {
            C1913ml.m10553a(getString(R.string.re_login));
            m7904p();
        }
        if (c1873lc.f11072i == 2) {
            C1900mc.m10473a("getUserUpdataTime", "event.msg=" + c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    m7867a(c1873lc.f11064a);
                    break;
                case 1:
                    new GetUserUpdataTimeBean();
                    String str = ((GetUserUpdataTimeBean) this.f7610L.fromJson(c1873lc.f11064a, GetUserUpdataTimeBean.class)).errDesc.LastUploadTime;
                    if (MyApplication.m7738a().f7401b) {
                        if (str.contentEquals("")) {
                            ContentValues contentValues = new ContentValues();
                            contentValues.put("sign1", (Integer) 0);
                            DataSupport.updateAll((Class<?>) MyMainTable.class, contentValues, "UserID = ?", this.f7617S);
                        }
                        m7915v();
                    } else {
                        long timesign = DataSupport.where("UserID = ?", this.f7617S).find(TimeSignTable.class).size() > 0 ? ((TimeSignTable) DataSupport.findFirst(TimeSignTable.class)).getTimesign() : 0L;
                        if (!TextUtils.isEmpty(str) && timesign < Long.parseLong(str)) {
                            this.f7611M.m10187a(timesign);
                            C1900mc.m10474b("Data_Async", "startLoad ==== " + System.currentTimeMillis());
                            if (this.f7627ac != null) {
                                this.f7627ac.m12196a(getString(R.string.updateing)).m12199a(5);
                            } else {
                                this.f7627ac = new DialogC2231wz(getActivity(), 5).m12196a(getString(R.string.updateing));
                            }
                            this.f7627ac.show();
                            this.f7627ac.setCancelable(false);
                        } else {
                            this.f7611M.m10225h();
                        }
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 22) {
            C1900mc.m10474b("UPDATE_BY_DATE", c1873lc.f11064a + " date ==  " + c1873lc.f11067d);
            switch (c1873lc.f11065b) {
                case 0:
                    C1913ml.m10553a(c1873lc.f11064a);
                case -1:
                    if (!this.f7629ae.contains(c1873lc.f11067d)) {
                        this.f7629ae.add(c1873lc.f11067d);
                    }
                    m7879c(c1873lc.f11067d);
                    break;
                case 1:
                    GetUserUpdataTimeBean getUserUpdataTimeBean = (GetUserUpdataTimeBean) this.f7610L.fromJson(c1873lc.f11064a, GetUserUpdataTimeBean.class);
                    if (getUserUpdataTimeBean != null) {
                        String str2 = getUserUpdataTimeBean.errDesc.LastUploadTime;
                        if (str2.isEmpty()) {
                            str2 = "0";
                        }
                        C1900mc.m10473a("UPDATE_BY_DATE", "servtime=" + str2);
                        ContentValues contentValues2 = new ContentValues();
                        contentValues2.put("sign1", (Integer) 1);
                        DataSupport.updateAll((Class<?>) MyMainTable.class, contentValues2, "UserID = ? And date = ?", this.f7617S, c1873lc.f11067d);
                        DataSupport.updateAll((Class<?>) MyActionTable.class, contentValues2, "UserID = ? And date = ?", this.f7617S, c1873lc.f11067d);
                        ContentValues contentValues3 = new ContentValues();
                        contentValues3.put("timesign", Long.valueOf(Long.parseLong(str2)));
                        DataSupport.updateAll((Class<?>) TimeSignTable.class, contentValues3, "UserID = ?", this.f7617S);
                    }
                    this.f7611M.m10189a(C1912mk.m10540b(Long.parseLong(c1873lc.f11067d)));
                    m7879c(c1873lc.f11067d);
                    this.f7647r.m9943a(c1873lc.f11067d);
                    break;
            }
        }
        if (c1873lc.f11072i == 9) {
            C1900mc.m10473a("event.what", "event.what=" + c1873lc.f11065b);
            switch (c1873lc.f11065b) {
                case -1:
                    C1900mc.m10475c("SportMainFragment", "获取运动详情服务器失败");
                    break;
                case 0:
                    C1900mc.m10475c("SportMainFragment", "获取运动详情失败");
                    break;
                case 1:
                    C1900mc.m10475c("SportMainFragment", "获取运动详情成功  msg == " + c1873lc.f11064a);
                    if (MyApplication.m7738a().m7747g()) {
                        C1902me.m10484a(getActivity(), c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), C1852ki.f10918e + c1873lc.f11067d, true);
                    } else if (MyApplication.m7738a().m7748h()) {
                        C1902me.m10484a(getActivity(), "france" + c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), "france" + C1852ki.f10918e + c1873lc.f11067d, true);
                    } else {
                        C1902me.m10484a(getActivity(), "english" + c1873lc.f11067d, c1873lc.f11064a);
                        C1902me.m10485a((Context) getActivity(), "english" + C1852ki.f10918e + c1873lc.f11067d, true);
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 8) {
            C1900mc.m10474b("Data_Async", c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    if (this.f7627ac != null && this.f7627ac.isShowing()) {
                        this.f7627ac.dismiss();
                    }
                    m7867a(c1873lc.f11064a);
                    break;
                case 1:
                    C1900mc.m10474b("Data_Async", "start===================" + System.currentTimeMillis());
                    m7876b(c1873lc.f11064a);
                    this.f7609K.setRefreshing(false);
                    break;
            }
        }
        if (c1873lc.f11072i == 12) {
            C1900mc.m10474b("GETTARGET", c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case 0:
                    C1900mc.m10475c("SportMainFragment", "获取运动目标失败");
                case -1:
                    m7867a(c1873lc.f11064a);
                    C1900mc.m10475c("SportMainFragment", "获取运动目标连接服务器失败");
                    this.f7619U = C1902me.m10486b(getActivity(), "target", 0);
                    this.f7605G = this.f7619U;
                    this.f7620V = C1902me.m10486b(getActivity(), "average", 0);
                    this.f7621W = C1902me.m10486b(getActivity(), "recommend", 0);
                    this.f7606H = (int) (((double) this.f7605G) + (((double) this.f7605G) * 0.2d));
                    this.f7639j.setMax(this.f7606H);
                    if (this.f7604F > this.f7606H) {
                        this.f7604F = this.f7606H;
                    }
                    if (this.f7606H == 0) {
                        this.f7606H = 1;
                    }
                    if (this.f7614P) {
                        this.f7633d.postDelayed(this.f7634e, 10L);
                        this.f7614P = false;
                    } else {
                        m7863a(this.f7604F);
                    }
                    break;
                case 1:
                    this.f7615Q = (SportTargetBean) this.f7610L.fromJson(c1873lc.f11064a, SportTargetBean.class);
                    this.f7605G = Integer.parseInt(this.f7615Q.errDesc.Count);
                    this.f7606H = (int) (((double) this.f7605G) + (((double) this.f7605G) * 0.2d));
                    this.f7639j.setMax(this.f7606H);
                    if (this.f7604F > this.f7606H) {
                        this.f7604F = this.f7606H;
                    }
                    if (this.f7614P) {
                        this.f7633d.postDelayed(this.f7634e, 10L);
                        this.f7614P = false;
                    } else {
                        m7863a(this.f7604F);
                    }
                    this.f7619U = Integer.parseInt(this.f7615Q.errDesc.Count);
                    this.f7620V = Integer.parseInt(this.f7615Q.errDesc.Avg);
                    this.f7621W = Integer.parseInt(this.f7615Q.errDesc.Recommend);
                    C1902me.m10483a(getActivity(), "target", this.f7605G);
                    C1902me.m10483a(getActivity(), "average", this.f7620V);
                    C1902me.m10483a(getActivity(), "recommend", this.f7621W);
                    break;
            }
        }
        if (c1873lc.f11072i == 20) {
            C1900mc.m10474b("DELETE_DAIRY_SPORT_DATA", c1873lc.f11064a);
            this.f7611M.m10186a();
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    this.f7626ab.m10716c();
                    break;
                case 1:
                    if (c1873lc.f11064a.contains("成功")) {
                        if (this.f7626ab != null) {
                            this.f7626ab.m10715b();
                        }
                        this.f7647r.m9944a(c1873lc.f11067d, c1873lc.f11068e, c1873lc.f11069f);
                        m7898m();
                    }
                    break;
            }
        }
        if (c1873lc.f11072i == 21) {
            C1900mc.m10474b("deletedata", c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    m7867a(c1873lc.f11064a);
                    break;
                case 1:
                    DeleteDateBean deleteDateBean = (DeleteDateBean) this.f7610L.fromJson(c1873lc.f11064a, DeleteDateBean.class);
                    if (deleteDateBean != null && deleteDateBean.errDesc != null && !deleteDateBean.errDesc.isEmpty()) {
                        ContentValues contentValues4 = new ContentValues();
                        contentValues4.put("isdeleted", (Integer) 1);
                        for (int i = 0; i < deleteDateBean.errDesc.size(); i++) {
                            DataSupport.updateAll((Class<?>) MyMainTable.class, contentValues4, "date = ? And UserID = ?", deleteDateBean.errDesc.get(i).DateTimestamp, this.f7617S);
                        }
                    }
                    if (this.f7647r != null) {
                        this.f7647r.m9941a();
                    }
                    m7898m();
                    break;
            }
        }
        if (c1873lc.f11072i == 14) {
            C1900mc.m10474b("GET_UPDATEVERSION_URL", c1873lc.f11064a);
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    m7867a(c1873lc.f11064a);
                    break;
                case 1:
                    if (this.f7625aa) {
                        this.f7625aa = false;
                        String str3 = ((UpdatedeviceBean) this.f7610L.fromJson(c1873lc.f11064a, UpdatedeviceBean.class)).errDesc.Version;
                        if (this.f7624Z != null && this.f7624Z.contains("-")) {
                            StringBuffer stringBuffer = new StringBuffer(this.f7624Z);
                            int iIndexOf = stringBuffer.indexOf("-");
                            String strSubstring = stringBuffer.substring(iIndexOf + 1, iIndexOf + 5);
                            this.f7624Z = this.f7624Z.split("-")[0];
                            if (strSubstring.equals("2017") && this.f7632c != null && this.f7632c.m10643c().equals("T5")) {
                                this.f7630af = 2017;
                            }
                        }
                        if (m7871a(this.f7624Z, str3) && C1839jw.f10820a != null) {
                            m7914u();
                            break;
                        }
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m7871a(String str, String str2) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        String lowerCase = str.toLowerCase();
        String lowerCase2 = str2.toLowerCase();
        if (lowerCase.startsWith("v")) {
            lowerCase = lowerCase.substring(1);
        }
        if (lowerCase2.startsWith("v")) {
            lowerCase2 = lowerCase2.substring(1);
        }
        String[] strArrSplit = lowerCase.split("\\.");
        String[] strArrSplit2 = lowerCase2.split("\\.");
        Integer[] numArr = new Integer[strArrSplit.length];
        for (int i = 0; i < strArrSplit.length; i++) {
            numArr[i] = Integer.valueOf(Integer.parseInt(strArrSplit[i]));
        }
        Integer[] numArr2 = new Integer[strArrSplit2.length];
        for (int i2 = 0; i2 < strArrSplit2.length; i2++) {
            numArr2[i2] = Integer.valueOf(Integer.parseInt(strArrSplit2[i2]));
        }
        int iMin = Math.min(strArrSplit.length, strArrSplit2.length);
        for (int i3 = 0; i3 < iMin; i3++) {
            if (numArr[i3].intValue() < numArr2[i3].intValue()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: p */
    private void m7904p() {
        new PreferencesCookieStore(getActivity()).clear();
        C1834jr.m10010a();
        Intent intent = new Intent(getActivity(), (Class<?>) LoginActivity.class);
        intent.addFlags(268435456);
        startActivity(intent);
        Process.killProcess(Process.myPid());
    }

    /* JADX INFO: renamed from: a */
    private void m7867a(String str) {
        C1913ml.m10552a(R.string.request_server_error);
        this.f7609K.setRefreshing(false);
    }

    /* JADX INFO: renamed from: b */
    private void m7876b(final String str) {
        new Thread(new Runnable() { // from class: com.coollang.tennis.fragment.SportMainFragment.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C1900mc.m10474b("updateTime", "start == " + System.currentTimeMillis());
                    SportMainFragment.this.m7864a((SyncDataBean) SportMainFragment.this.f7610L.fromJson(str, SyncDataBean.class));
                    if (SportMainFragment.this.f7611M != null) {
                        SportMainFragment.this.f7611M.m10225h();
                    }
                    C1900mc.m10474b("updateTime", "end == " + System.currentTimeMillis());
                    akd.m1706a().m1722c(new C1873lc("1", 1, 16));
                } catch (Exception unused) {
                } catch (Throwable th) {
                    SportMainFragment.this.f7633d.sendEmptyMessage(PointerIconCompat.TYPE_HELP);
                    throw th;
                }
                SportMainFragment.this.f7633d.sendEmptyMessage(PointerIconCompat.TYPE_HELP);
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7864a(SyncDataBean syncDataBean) {
        Date date;
        char c = 0;
        List<MyMainTable> listFind = DataSupport.where("UserID = ?", this.f7617S).find(MyMainTable.class);
        long jM10541c = C1912mk.m10541c();
        int i = 0;
        while (i < syncDataBean.errDesc.Data.size()) {
            long j = Long.parseLong(syncDataBean.errDesc.Data.get(i).DateTimestamp);
            int i2 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).Duration);
            int i3 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).MaxSpeed);
            int i4 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).Caroline);
            int i5 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TotalCount);
            String[] strArrSplit = C1912mk.m10534a(j).split(" ");
            String[] strArrSplit2 = strArrSplit[c].split("-");
            List<MyMainTable> list = listFind;
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(strArrSplit[0]);
            } catch (ParseException e) {
                e.printStackTrace();
                date = null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int i6 = calendar.get(3);
            int i7 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TypeCount.FaQiu);
            int i8 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TypeCount.GaoYa);
            long j2 = jM10541c;
            int i9 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TypeCount.JieJi);
            int i10 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TypeCount.XueQiu);
            int i11 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TypeCount.XuanQiu);
            int i12 = Integer.parseInt(syncDataBean.errDesc.Data.get(i).TypeCount.PingJi);
            int i13 = i;
            this.f7613O = new MyActionTable();
            this.f7613O.setDate(j);
            this.f7613O.setFaqiu(i7);
            this.f7613O.setGaoya(i8);
            this.f7613O.setJieji(i9);
            this.f7613O.setXiaoqiu(i10);
            this.f7613O.setXuanqiu(i11);
            this.f7613O.setPingji(i12);
            this.f7613O.setSign1(1);
            this.f7613O.setSign2("0");
            this.f7613O.setUserID(Integer.parseInt(this.f7617S));
            this.f7612N = new MyMainTable();
            this.f7612N.setActionTable(this.f7613O);
            this.f7612N.setDate(j);
            this.f7612N.setTotletimes(i5);
            this.f7612N.setDuration(i2);
            this.f7612N.setCaroline(i4);
            this.f7612N.setMaxSpeed(i3);
            this.f7612N.setSign1(1);
            this.f7612N.setSign2(strArrSplit2[0] + " " + Integer.toString(i6));
            this.f7612N.setIsDeleted(syncDataBean.errDesc.Data.get(i13).State);
            this.f7612N.setUserID(Integer.parseInt(this.f7617S));
            this.f7612N.setSignDate(C1912mk.m10540b(j - j2));
            if (!m7868a(j, list)) {
                this.f7612N.save();
                this.f7613O.save();
            } else {
                List listFind2 = DataSupport.where("date = ? And UserID = ?", Long.toString(j), this.f7617S).find(MyMainTable.class);
                if (listFind2.size() > 0 && i5 > ((MyMainTable) listFind2.get(0)).getTotletimes()) {
                    DataSupport.deleteAll((Class<?>) MyMainTable.class, "UserID = ? And date = ?", this.f7617S, Long.toString(j));
                    DataSupport.deleteAll((Class<?>) MyActionTable.class, "UserID = ? And date = ?", this.f7617S, Long.toString(j));
                    this.f7612N.save();
                    this.f7613O.save();
                }
            }
            String[] strArrSplit3 = C1912mk.m10534a(j - ((long) C1912mk.m10541c())).split(" ")[0].split("-");
            String str = strArrSplit3[0] + strArrSplit3[1] + strArrSplit3[2];
            if (syncDataBean.errDesc.Data.get(i13).DetailData.size() != DataSupport.where("sign2 = ? And UserID = ?", str, this.f7617S).find(MyDetailTable.class).size()) {
                DataSupport.deleteAll((Class<?>) MyDetailTable.class, "sign2 = ? And UserID = ?", str, this.f7617S);
                C1856km.m10109a().m10115a(syncDataBean.errDesc.Data.get(i13).DetailData, str, String.valueOf(this.f7617S));
            }
            i = i13 + 1;
            listFind = list;
            jM10541c = j2;
            c = 0;
        }
        if (DataSupport.where("UserID = ?", this.f7617S).find(TimeSignTable.class).size() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("timesign", Long.valueOf(Long.parseLong(syncDataBean.errDesc.LastUploadTime)));
            DataSupport.updateAll((Class<?>) TimeSignTable.class, contentValues, new String[0]);
        } else {
            TimeSignTable timeSignTable = new TimeSignTable();
            timeSignTable.setTimesign(Long.parseLong(syncDataBean.errDesc.LastUploadTime));
            timeSignTable.setUserID(Integer.parseInt(this.f7617S));
            timeSignTable.save();
        }
        this.f7633d.sendEmptyMessage(PointerIconCompat.TYPE_CONTEXT_MENU);
    }

    /* JADX INFO: renamed from: a */
    private boolean m7868a(long j, List<MyMainTable> list) {
        for (int i = 0; i < list.size(); i++) {
            if (j == list.get(i).getDate()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: q */
    private void m7906q() {
        View viewInflate = View.inflate(getActivity(), R.layout.popupwindow_toltle, null);
        this.f7645p = (ListView) viewInflate.findViewById(R.id.opratelist);
        ((LinearLayout) viewInflate.findViewById(R.id.pop_ll_root)).setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (SportMainFragment.this.f7640k != null) {
                    SportMainFragment.this.f7640k.dismiss();
                }
            }
        });
        this.f7645p.setOnItemClickListener(this.f7635f);
        this.f7645p.setAdapter((ListAdapter) this.f7655z);
        this.f7640k = new PopupWindow(viewInflate, -1, -1, true);
        this.f7640k.setFocusable(true);
        this.f7640k.setTouchable(true);
        this.f7640k.setTouchInterceptor(new View.OnTouchListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.6
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });
        this.f7640k.setBackgroundDrawable(new BitmapDrawable());
        new DecimalFormat("00");
        this.f7640k.showAsDropDown(this.f7623Y, 0, 0);
        C1839jw.m10026a().m10042a(34);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: r */
    public void m7908r() {
        DialogC1863kt dialogC1863kt = new DialogC1863kt(getActivity(), new DialogC1863kt.a() { // from class: com.coollang.tennis.fragment.SportMainFragment.8
            @Override // p000.DialogC1863kt.a
            /* JADX INFO: renamed from: a */
            public void mo7936a(String str) {
                if (str.trim().length() == 0) {
                    Toast.makeText(SportMainFragment.this.getActivity(), R.string.cant_empty_data, 0).show();
                } else {
                    C1839jw.m10026a().m10040a(str);
                }
            }
        });
        dialogC1863kt.requestWindowFeature(1);
        dialogC1863kt.show();
        Window window = dialogC1863kt.getWindow();
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -2;
        attributes.height = -2;
        window.setAttributes(attributes);
        window.setWindowAnimations(R.style.mystyle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: s */
    public void m7910s() {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(2, getActivity(), new DialogC1860kq.a() { // from class: com.coollang.tennis.fragment.SportMainFragment.9
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                C1839jw.m10026a().m10042a(2);
                SportMainFragment.this.f7640k.dismiss();
            }
        });
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.show();
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: t */
    public void m7912t() {
        DialogC1860kq dialogC1860kq = new DialogC1860kq(3, getActivity(), new DialogC1860kq.a() { // from class: com.coollang.tennis.fragment.SportMainFragment.10
            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: a */
            public void mo6888a() {
            }

            @Override // p000.DialogC1860kq.a
            /* JADX INFO: renamed from: b */
            public void mo6889b() {
                C1839jw.m10026a().m10042a(1);
                SportMainFragment.this.f7640k.dismiss();
            }
        });
        dialogC1860kq.requestWindowFeature(1);
        dialogC1860kq.show();
        dialogC1860kq.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }

    /* JADX INFO: renamed from: u */
    private void m7914u() {
        this.f7628ad = new C1926my(getActivity());
        this.f7628ad.m10700a(getString(R.string.device_can_upgrate));
        this.f7628ad.m10703b(getString(R.string.device_check_upgrate_info));
        this.f7628ad.m10704c(getString(R.string.device_upgrate_now));
        this.f7628ad.m10707d(getString(R.string.device_upgrate_next));
        this.f7628ad.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SportMainFragment.this.jumpUpate();
            }
        });
        this.f7628ad.m10702b(new View.OnClickListener() { // from class: com.coollang.tennis.fragment.SportMainFragment.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SportMainFragment.this.f7628ad.m10706d();
            }
        });
        this.f7628ad.m10701b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @asw(m5376a = 100)
    public void jumpUpate() {
        String[] strArr = {MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE, MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE};
        if (EasyPermissions.m11138a(getContext(), strArr)) {
            C1887lq.m10420b(getActivity(), this.f7624Z, this.f7630af);
            this.f7628ad.m10706d();
        } else {
            EasyPermissions.m11134a(this, "", 100, strArr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: v */
    public void m7915v() {
        this.f7629ae.clear();
        List listFind = DataSupport.where("sign1 = 0 AND UserID = ? And isDeleted < 1", this.f7617S).find(MyMainTable.class);
        if (listFind.size() > 0) {
            this.f7611M.m10191a(this.f7617S, ((MyMainTable) listFind.get(0)).getDate());
            C1808is.m9825a("run-updateNoSignToServer");
        }
    }

    /* JADX INFO: renamed from: c */
    private void m7879c(String str) {
        boolean z = false;
        List listFind = DataSupport.where("sign1 = 0 AND UserID = ? And isDeleted < 1 ", this.f7617S).find(MyMainTable.class);
        if (listFind.isEmpty()) {
            m7917w();
            return;
        }
        int i = 0;
        while (true) {
            if (i >= listFind.size()) {
                break;
            }
            if (!this.f7629ae.contains(String.valueOf(((MyMainTable) listFind.get(i)).getDate()))) {
                C1808is.m9825a("run-onUpdateByDateFinish");
                this.f7611M.m10191a(this.f7617S, ((MyMainTable) listFind.get(i)).getDate());
                z = true;
                break;
            }
            i++;
        }
        if (z) {
            return;
        }
        m7917w();
    }

    /* JADX INFO: renamed from: w */
    private void m7917w() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("sign1", (Integer) 1);
        DataSupport.updateAll((Class<?>) MyDetailTable.class, contentValues, "UserID = ?", this.f7617S);
        m7898m();
        this.f7647r.m9941a();
        this.f7609K.setRefreshing(false);
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        ada.m301a(getActivity());
        if (this.f7638i != null) {
            this.f7638i.stop();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroy() {
        akd.m1706a().m1721b(this);
        super.onDestroy();
    }

    @Override // android.support.v4.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override // android.support.v4.app.Fragment, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.m11133a(i, strArr, iArr, this);
    }
}
