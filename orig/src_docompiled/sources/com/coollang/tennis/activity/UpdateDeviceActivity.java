package com.coollang.tennis.activity;

import android.app.NotificationManager;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.content.FileProvider;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PointerIconCompat;
import android.view.KeyEvent;
import android.view.View;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.BaseActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.beans.UpdatedeviceBean;
import com.coollang.tennis.widget.CircleProgressView;
import com.coollang.tennis.widget.NavigateView;
import com.coollang.tennis.widget.RippleView;
import com.google.gson.Gson;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import java.io.File;
import no.nordicsemi.android.nrftoolbox.dfu.DfuService;
import p000.AbstractC1838jv;
import p000.C1839jw;
import p000.C1852ki;
import p000.C1853kj;
import p000.C1873lc;
import p000.C1874ld;
import p000.C1900mc;
import p000.C1902me;
import p000.C1910mi;
import p000.C1913ml;
import p000.C1914mm;
import p000.C1926my;
import p000.akd;

/* JADX INFO: loaded from: classes.dex */
public class UpdateDeviceActivity extends BaseActivity implements AbstractC1838jv.a {

    /* JADX INFO: renamed from: a */
    protected Gson f7117a;

    /* JADX INFO: renamed from: e */
    protected File f7121e;

    /* JADX INFO: renamed from: f */
    protected String f7122f;

    /* JADX INFO: renamed from: l */
    private TextView f7128l;

    /* JADX INFO: renamed from: m */
    private TextView f7129m;

    /* JADX INFO: renamed from: n */
    private CircleProgressView f7130n;

    /* JADX INFO: renamed from: o */
    private TextView f7131o;

    /* JADX INFO: renamed from: p */
    private NavigateView f7132p;

    /* JADX INFO: renamed from: r */
    private View f7134r;

    /* JADX INFO: renamed from: s */
    private View f7135s;

    /* JADX INFO: renamed from: t */
    private RippleView f7136t;

    /* JADX INFO: renamed from: x */
    private C1874ld f7140x;

    /* JADX INFO: renamed from: z */
    private int f7142z;

    /* JADX INFO: renamed from: j */
    private final int f7126j = PointerIconCompat.TYPE_CONTEXT_MENU;

    /* JADX INFO: renamed from: k */
    private final int f7127k = PointerIconCompat.TYPE_HAND;

    /* JADX INFO: renamed from: q */
    private String f7133q = "";

    /* JADX INFO: renamed from: b */
    protected String f7118b = "";

    /* JADX INFO: renamed from: c */
    protected String f7119c = "";

    /* JADX INFO: renamed from: d */
    protected String f7120d = "";

    /* JADX INFO: renamed from: u */
    private boolean f7137u = false;

    /* JADX INFO: renamed from: g */
    protected boolean f7123g = false;

    /* JADX INFO: renamed from: v */
    private boolean f7138v = false;

    /* JADX INFO: renamed from: w */
    private boolean f7139w = false;

    /* JADX INFO: renamed from: y */
    private boolean f7141y = false;

    /* JADX INFO: renamed from: A */
    private Handler f7112A = new Handler() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case PointerIconCompat.TYPE_CONTEXT_MENU /* 1001 */:
                    if (!UpdateDeviceActivity.this.f7123g) {
                        if (UpdateDeviceActivity.this.f7131o.getText().toString().equalsIgnoreCase(((String) message.obj) + "%") && !UpdateDeviceActivity.this.f7138v && !((String) message.obj).equalsIgnoreCase("100")) {
                            UpdateDeviceActivity.this.m7540l();
                            UpdateDeviceActivity.this.f7138v = true;
                            break;
                        }
                    }
                    break;
                case PointerIconCompat.TYPE_HAND /* 1002 */:
                    LocalBroadcastManager localBroadcastManager = LocalBroadcastManager.getInstance(UpdateDeviceActivity.this);
                    Intent intent = new Intent("no.nordicsemi.android.dfu.broadcast.BROADCAST_ACTION");
                    intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_ACTION", 2);
                    localBroadcastManager.sendBroadcast(intent);
                    localBroadcastManager.unregisterReceiver(UpdateDeviceActivity.this.f7116E);
                    BluetoothAdapter.getDefaultAdapter().disable();
                    UpdateDeviceActivity.this.f7112A.postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            MyApplication.m7738a().m7744d().removeCallbacks(UpdateDeviceActivity.this.f7124h);
                            ((NotificationManager) UpdateDeviceActivity.this.getSystemService("notification")).cancel(283);
                        }
                    }, 200L);
                    UpdateDeviceActivity.this.f7112A.postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            BluetoothAdapter.getDefaultAdapter().enable();
                            MyApplication.m7738a().f7401b = false;
                            UpdateDeviceActivity.this.finish();
                        }
                    }, 1000L);
                    break;
            }
        }
    };

    /* JADX INFO: renamed from: h */
    Runnable f7124h = new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.7
        @Override // java.lang.Runnable
        public void run() {
            UpdateDeviceActivity.this.m7541c();
            MyApplication.m7738a().m7744d().postDelayed(this, 2000L);
        }
    };

    /* JADX INFO: renamed from: B */
    private Uri f7113B = null;

    /* JADX INFO: renamed from: C */
    private String f7114C = null;

    /* JADX INFO: renamed from: D */
    private Uri f7115D = null;

    /* JADX INFO: renamed from: i */
    public String f7125i = "";

    /* JADX INFO: renamed from: E */
    private final BroadcastReceiver f7116E = new BroadcastReceiver() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.8
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS".equals(action)) {
                UpdateDeviceActivity.this.m7519a(intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0), intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PART_CURRENT", 1), intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_PARTS_TOTAL", 1));
                return;
            }
            if ("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR".equals(action)) {
                int intExtra = intent.getIntExtra("no.nordicsemi.android.dfu.extra.EXTRA_DATA", 0);
                if (intExtra == 133 || intExtra == 129) {
                    UpdateDeviceActivity.this.m7540l();
                    UpdateDeviceActivity.this.f7138v = true;
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: a */
    public void mo6860a() {
        setContentView(R.layout.activity_updatedevice);
        akd.m1706a().m1719a(this);
        m7529d();
        m7531e();
        m7532f();
        m7534g();
    }

    /* JADX INFO: renamed from: d */
    private void m7529d() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f7133q = extras.getString("device_version");
            this.f7142z = extras.getInt("device_type", 0);
        }
        if (this.f7133q == null) {
            this.f7133q = "";
        }
    }

    /* JADX INFO: renamed from: e */
    private void m7531e() {
        this.f7132p = (NavigateView) findViewById(R.id.navigateView);
        this.f7128l = (TextView) findViewById(R.id.tv_device_version);
        this.f7129m = (TextView) findViewById(R.id.tv_current_version);
        this.f7130n = (CircleProgressView) findViewById(R.id.circleView);
        this.f7131o = (TextView) findViewById(R.id.tv_progress);
        this.f7134r = findViewById(R.id.ll2);
        this.f7135s = findViewById(R.id.ll1);
        this.f7136t = (RippleView) findViewById(R.id.mRippleView);
    }

    /* JADX INFO: renamed from: f */
    private void m7532f() {
        this.f7132p.setTitle(getString(R.string.update_device_activity));
        this.f7132p.setRightHideBtn(true);
        this.f7132p.setLeftButtonClicklistner(new RippleView.InterfaceC1365a() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.4
            @Override // com.coollang.tennis.widget.RippleView.InterfaceC1365a
            /* JADX INFO: renamed from: a */
            public void mo7110a(RippleView rippleView) {
                if (UpdateDeviceActivity.this.f7137u) {
                    C1913ml.m10552a(R.string.waitting_upgrate_finish);
                } else {
                    UpdateDeviceActivity.this.m7733j();
                }
            }
        });
        this.f7136t.setClickable(false);
    }

    /* JADX INFO: renamed from: g */
    private void m7534g() {
        this.f7136t.setOnClickListener(new View.OnClickListener() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!UpdateDeviceActivity.this.f7123g) {
                    if (UpdateDeviceActivity.this.f7141y) {
                        UpdateDeviceActivity.this.f7136t.setClickable(false);
                        return;
                    }
                    UpdateDeviceActivity.this.f7136t.setClickable(false);
                    UpdateDeviceActivity.this.f7131o.setTextSize(32.0f);
                    UpdateDeviceActivity.this.f7131o.setText("0%");
                    UpdateDeviceActivity.this.f7130n.setVisibility(0);
                    if ("T0".equalsIgnoreCase(MyApplication.m7738a().f7405f)) {
                        C1839jw.m10026a().m10042a(5, 2, 0);
                    } else if ("T1".equalsIgnoreCase(MyApplication.m7738a().f7405f)) {
                        C1839jw.m10026a().m10042a(5, 2, 1);
                    } else if ("T2".equalsIgnoreCase(MyApplication.m7738a().f7405f)) {
                        C1839jw.m10026a().m10042a(5, 2, 2);
                    } else if ("TS".equalsIgnoreCase(MyApplication.m7738a().f7405f)) {
                        C1839jw.m10026a().m10042a(5, 2, -2);
                    } else if ("T5".equalsIgnoreCase(MyApplication.m7738a().f7405f)) {
                        C1839jw.m10026a().m10042a(5, 2, 5);
                    }
                    UpdateDeviceActivity.this.f7123g = false;
                    UpdateDeviceActivity.this.f7137u = true;
                    UpdateDeviceActivity.this.f7122f = C1839jw.f10820a.f10813d;
                    MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            C1839jw.f10820a.m10016a();
                            C1839jw.f10820a = null;
                        }
                    }, 200L);
                    MyApplication.m7738a().m7744d().postDelayed(UpdateDeviceActivity.this.f7124h, 5000L);
                    UpdateDeviceActivity.this.m7518a(0);
                    return;
                }
                UpdateDeviceActivity.this.m7733j();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity
    /* JADX INFO: renamed from: b */
    public void mo6861b() {
        this.f7140x = new C1874ld();
        this.f7117a = new Gson();
        if (C1839jw.f10820a != null) {
            this.f7140x.m10239n();
        } else {
            this.f7136t.setClickable(false);
            this.f7131o.setTextSize(32.0f);
            this.f7131o.setText("0%");
            this.f7130n.setVisibility(0);
            MyApplication.m7738a().m7744d().postDelayed(this.f7124h, 1000L);
            m7518a(0);
        }
        if (this.f7133q.contains("-")) {
            this.f7128l.setText(this.f7133q.split("-")[0]);
        } else {
            this.f7128l.setText(" " + this.f7133q);
        }
        LocalBroadcastManager.getInstance(this).registerReceiver(this.f7116E, m7536h());
    }

    @Override // p000.AbstractC1838jv.a
    /* JADX INFO: renamed from: a */
    public void mo7490a(Context context, Intent intent, String str, String str2) {
        String action = intent.getAction();
        if ("com.rfstar.kevin.service.ACTION_GATT_CONNECTED".equals(action)) {
            String strM10480a = C1902me.m10480a(this);
            String strM10487b = C1902me.m10487b(context, C1902me.f11454e, "-1");
            if (strM10487b.startsWith(strM10480a) && strM10487b.endsWith("1")) {
                return;
            }
            this.f7140x.m10228i();
            C1902me.m10484a(context, C1902me.f11454e, strM10480a + "_1");
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED".equals(action)) {
            MyApplication.m7738a().f7401b = false;
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
            MyApplication.m7738a().f7401b = true;
            if (C1839jw.f10820a != null) {
                C1839jw.f10820a.m10046a(C1853kj.f10919a, C1853kj.f10920b, true);
            }
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.6
                @Override // java.lang.Runnable
                public void run() {
                    C1839jw.m10026a().m10042a(33);
                }
            }, 1000L);
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE".equals(action)) {
            intent.getStringExtra("com.rfstar.kevin.service.characteristic").contains(C1853kj.f10921c);
        }
    }

    /* JADX INFO: renamed from: c */
    public void m7541c() {
        Intent intent = new Intent(this, (Class<?>) DfuService.class);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_ADDRESS", this.f7122f);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_DEVICE_NAME", "KL_TNS_DFU");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_MIME_TYPE", "application/octet-stream");
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_TYPE", 4);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_PATH", this.f7125i);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_FILE_URI", this.f7113B);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_PATH", this.f7114C);
        intent.putExtra("no.nordicsemi.android.dfu.extra.EXTRA_INIT_FILE_URI", this.f7115D);
        startService(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7519a(int i, int i2, int i3) {
        if (i == -6) {
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.9
                @Override // java.lang.Runnable
                public void run() {
                    ((NotificationManager) UpdateDeviceActivity.this.getSystemService("notification")).cancel(283);
                }
            }, 200L);
            this.f7130n.setVisibility(4);
            this.f7131o.setTextSize(18.0f);
            this.f7131o.setText(R.string.upgrate_success_waitting);
            findViewById(R.id.imgv_ring_upgrate).setVisibility(4);
            this.f7123g = true;
            this.f7137u = false;
            this.f7136t.setClickable(true);
            MyApplication.m7738a().f7401b = false;
            MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.10
                @Override // java.lang.Runnable
                public void run() {
                    UpdateDeviceActivity.this.m7733j();
                }
            }, 3000L);
            return;
        }
        if (i == -2) {
            MyApplication.m7738a().m7744d().removeCallbacks(this.f7124h);
            return;
        }
        if (i > 0) {
            C1900mc.m10474b("upgrate progress", i + "%");
            this.f7131o.setText(Integer.toString(i) + "%");
            this.f7130n.setValue((float) i);
            if (this.f7112A.hasMessages(PointerIconCompat.TYPE_CONTEXT_MENU)) {
                this.f7112A.removeMessages(PointerIconCompat.TYPE_CONTEXT_MENU);
            }
            if (i == 0) {
                m7518a(i);
            } else if (i != 99) {
                m7518a(i);
            } else if (i2 != i3) {
                m7518a(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m7518a(int i) {
        Message messageObtain = Message.obtain();
        messageObtain.obj = Integer.toString(i);
        messageObtain.what = PointerIconCompat.TYPE_CONTEXT_MENU;
        this.f7112A.sendMessageDelayed(messageObtain, 60000L);
    }

    /* JADX INFO: renamed from: h */
    private static IntentFilter m7536h() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_PROGRESS");
        intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_ERROR");
        intentFilter.addAction("no.nordicsemi.android.dfu.broadcast.BROADCAST_LOG");
        return intentFilter;
    }

    /* JADX INFO: renamed from: i */
    private void m7539i() {
        File file = new File(C1852ki.f10916c + this.f7120d);
        C1900mc.m10474b("UpdateDevice", "fileName == " + this.f7120d);
        file.mkdirs();
        if (file.exists()) {
            file.delete();
        }
        new HttpUtils().download(this.f7119c, C1852ki.f10916c + this.f7120d, true, true, new RequestCallBack<File>() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.11
            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onSuccess(ResponseInfo<File> responseInfo) {
                UpdateDeviceActivity.this.f7121e = responseInfo.result;
                UpdateDeviceActivity.this.f7125i = UpdateDeviceActivity.this.f7121e.getAbsolutePath();
                if (Build.VERSION.SDK_INT >= 24) {
                    UpdateDeviceActivity.this.f7113B = FileProvider.getUriForFile(UpdateDeviceActivity.this, "com.coollang.tennis.fileprovider", UpdateDeviceActivity.this.f7121e);
                } else {
                    UpdateDeviceActivity.this.f7125i = UpdateDeviceActivity.this.f7121e.getAbsolutePath();
                }
                UpdateDeviceActivity.this.f7131o.setText(R.string.click_to_update);
                UpdateDeviceActivity.this.f7136t.setClickable(true);
                UpdateDeviceActivity.this.f7141y = false;
            }

            @Override // com.lidroid.xutils.http.callback.RequestCallBack
            public void onFailure(HttpException httpException, String str) {
                UpdateDeviceActivity.this.f7131o.setText(R.string.download_fail);
            }
        });
    }

    public void onEventMainThread(C1873lc c1873lc) {
        if (c1873lc.f11072i == 60) {
            switch (c1873lc.f11065b) {
                case -1:
                case 0:
                    this.f7136t.setClickable(true);
                    this.f7131o.setText(R.string.request_fail);
                    this.f7134r.setVisibility(4);
                    break;
                case 1:
                    UpdatedeviceBean updatedeviceBean = (UpdatedeviceBean) this.f7117a.fromJson(c1873lc.f11064a, UpdatedeviceBean.class);
                    C1900mc.m10474b("upgragetFile", c1873lc.f11064a);
                    if (this.f7142z == 2017) {
                        this.f7118b = this.f7133q;
                    } else {
                        this.f7118b = updatedeviceBean.errDesc.Version;
                    }
                    this.f7119c = updatedeviceBean.errDesc.Path;
                    String[] strArrSplit = this.f7119c.split("/");
                    this.f7120d = strArrSplit[strArrSplit.length - 1];
                    this.f7120d = this.f7120d.replaceAll("-", "_");
                    this.f7134r.setVisibility(0);
                    if (this.f7133q.contains("-")) {
                        this.f7133q = this.f7133q.split("-")[0];
                    }
                    if (!m7523a(this.f7133q, this.f7118b)) {
                        this.f7136t.setClickable(false);
                        if (!MyApplication.m7738a().m7747g()) {
                            this.f7131o.setTextSize(10.0f);
                        }
                        this.f7131o.setText(R.string.islastversion);
                        this.f7134r.setVisibility(4);
                    } else {
                        this.f7129m.setText(C1910mi.m10525b(this.f7118b, C1914mm.m10557b(R.string.updateto) + this.f7118b, C1914mm.m10559d(R.color.sport_rb_Color)));
                        this.f7131o.setText(R.string.downloading);
                        this.f7141y = true;
                        m7539i();
                    }
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m7523a(String str, String str2) {
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

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: l */
    public void m7540l() {
        final C1926my c1926my = new C1926my(this);
        c1926my.m10697a(8);
        c1926my.m10703b(getString(R.string.upgrate_fail_try));
        c1926my.m10696a();
        c1926my.m10698a(new View.OnClickListener() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c1926my.m10706d();
            }
        });
        c1926my.m10699a(new PopupWindow.OnDismissListener() { // from class: com.coollang.tennis.activity.UpdateDeviceActivity.3
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                UpdateDeviceActivity.this.f7112A.sendEmptyMessage(PointerIconCompat.TYPE_HAND);
            }
        });
        c1926my.m10701b();
    }

    @Override // com.coollang.tennis.base.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.f7137u) {
            C1913ml.m10552a(R.string.waitting_upgrate_finish);
            return false;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.coollang.tennis.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.f7116E != null) {
            LocalBroadcastManager.getInstance(this).unregisterReceiver(this.f7116E);
        }
        super.onDestroy();
        akd.m1706a().m1721b(this);
    }
}
