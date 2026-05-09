package p000;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.DialogInterface;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.coollang.tennis.R;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.p011db.model.MyMainTable;
import com.facebook.shimmer.ShimmerFrameLayout;
import java.util.ArrayList;
import org.litepal.crud.DataSupport;
import p000.AbstractC1838jv;

/* JADX INFO: renamed from: mv */
/* JADX INFO: compiled from: SearchDevicePopWindow.java */
/* JADX INFO: loaded from: classes.dex */
public class C1923mv {

    /* JADX INFO: renamed from: a */
    private Activity f11604a;

    /* JADX INFO: renamed from: b */
    private PopupWindow f11605b;

    /* JADX INFO: renamed from: c */
    private View f11606c;

    /* JADX INFO: renamed from: d */
    private View f11607d;

    /* JADX INFO: renamed from: e */
    private TextView f11608e;

    /* JADX INFO: renamed from: f */
    private TextView f11609f;

    /* JADX INFO: renamed from: g */
    private ListView f11610g;

    /* JADX INFO: renamed from: h */
    private TextView f11611h;

    /* JADX INFO: renamed from: i */
    private Button f11612i;

    /* JADX INFO: renamed from: j */
    private String f11613j = "";

    /* JADX INFO: renamed from: k */
    private ArrayList<BluetoothDevice> f11614k = new ArrayList<>();

    /* JADX INFO: renamed from: l */
    private C1818jb f11615l;

    /* JADX INFO: renamed from: m */
    private InterfaceC1876lf f11616m;

    /* JADX INFO: renamed from: n */
    private AbstractC1838jv.a f11617n;

    /* JADX INFO: renamed from: o */
    private ShimmerFrameLayout f11618o;

    public C1923mv(Activity activity) {
        this.f11604a = activity;
        m10629d();
    }

    /* JADX INFO: renamed from: d */
    private void m10629d() {
        this.f11606c = LayoutInflater.from(this.f11604a).inflate(R.layout.popupwindow_linknrefresh, (ViewGroup) null);
        this.f11605b = new PopupWindow(this.f11606c, -1, -1);
        this.f11605b.setFocusable(true);
        this.f11605b.setTouchable(true);
        this.f11605b.setBackgroundDrawable(new BitmapDrawable());
        this.f11607d = this.f11606c.findViewById(R.id.rl_pop);
        this.f11608e = (TextView) this.f11606c.findViewById(R.id.tv_cant_find_device);
        this.f11609f = (TextView) this.f11606c.findViewById(R.id.tv_counter);
        this.f11610g = (ListView) this.f11606c.findViewById(R.id.blelist);
        this.f11611h = (TextView) this.f11606c.findViewById(R.id.textView3);
        this.f11612i = (Button) this.f11606c.findViewById(R.id.bt_link);
        this.f11618o = (ShimmerFrameLayout) this.f11606c.findViewById(R.id.shimmer_start_course_big);
        this.f11618o.m8390b();
        new Handler().postDelayed(new Runnable() { // from class: mv.1
            @Override // java.lang.Runnable
            public void run() {
                C1923mv.this.f11618o.m8391c();
            }
        }, 5000L);
        this.f11608e.getPaint().setFlags(8);
        this.f11608e.getPaint().setAntiAlias(true);
        this.f11614k.clear();
        this.f11615l = new C1818jb(this.f11604a, this.f11614k);
        this.f11617n = C1839jw.m10026a();
        this.f11610g.setAdapter((ListAdapter) this.f11615l);
        this.f11610g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: mv.4
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                if (C1923mv.this.f11615l.m9855c() == i) {
                    C1923mv.this.f11615l.m9854b(-1);
                    C1923mv.this.f11612i.setEnabled(false);
                } else {
                    C1923mv.this.f11615l.m9854b(i);
                    C1923mv.this.f11612i.setEnabled(true);
                }
            }
        });
        this.f11612i.setOnClickListener(new View.OnClickListener() { // from class: mv.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (C1923mv.this.f11615l.m9855c() != -1) {
                    BluetoothDevice bluetoothDeviceM9857e = C1923mv.this.f11615l.m9857e();
                    if (DataSupport.where("UserID = ? ", C1902me.m10480a(C1923mv.this.f11604a)).count(MyMainTable.class) == 0) {
                        C1923mv.this.m10622a(bluetoothDeviceM9857e, C1923mv.this.f11615l.m9856d(), C1923mv.this.f11617n);
                    } else if (bluetoothDeviceM9857e != null) {
                        C1923mv.this.f11613j = C1923mv.this.f11615l.m9856d();
                        C1844ka.m10073a().m10080b(C1923mv.this.f11615l.m9856d());
                        C1839jw.m10026a().m10039a(bluetoothDeviceM9857e, C1923mv.this.f11604a, C1923mv.this.f11617n);
                    } else {
                        C1913ml.m10552a(R.string.ble_connect_fail);
                    }
                    C1923mv.this.m10642b();
                }
            }
        });
        this.f11605b.setOnDismissListener(new PopupWindow.OnDismissListener() { // from class: mv.6
            @Override // android.widget.PopupWindow.OnDismissListener
            public void onDismiss() {
                C1844ka.m10073a().m10081c();
                C1923mv.this.f11615l.m9851a();
                C1923mv.this.f11614k.clear();
            }
        });
        this.f11616m = new InterfaceC1876lf() { // from class: mv.7
            @Override // p000.InterfaceC1876lf
            /* JADX INFO: renamed from: a */
            public void mo10250a(BluetoothDevice bluetoothDevice, int i, String str) {
                C1900mc.m10474b("onDeviceDiscovered", "address: = " + bluetoothDevice.getAddress() + " Rssi = " + i + "pid=" + str);
                if (!C1923mv.this.m10624a(bluetoothDevice)) {
                    C1923mv.this.f11614k.add(bluetoothDevice);
                }
                C1923mv.this.f11615l.m9852a(bluetoothDevice.getAddress(), i, str);
                C1923mv.this.f11615l.m9853b();
            }

            @Override // p000.InterfaceC1876lf
            /* JADX INFO: renamed from: a */
            public void mo10249a() {
                if (C1923mv.this.f11615l.getCount() == 0) {
                    C1923mv.this.f11611h.setText(R.string.search_device_empty);
                }
                C1923mv.this.f11615l.m9858f();
            }
        };
        this.f11606c.setOnClickListener(new View.OnClickListener() { // from class: mv.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1923mv.this.m10642b();
            }
        });
        this.f11607d.setOnClickListener(new View.OnClickListener() { // from class: mv.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
        this.f11608e.setOnClickListener(new View.OnClickListener() { // from class: mv.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                C1923mv.this.m10631e();
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m10641a(AbstractC1838jv.a aVar) {
        this.f11617n = aVar;
    }

    /* JADX INFO: renamed from: a */
    public void m10640a() {
        if (this.f11605b.isShowing()) {
            this.f11605b.dismiss();
        }
        this.f11606c.startAnimation(AnimationUtils.loadAnimation(this.f11604a, R.anim.alpha_in));
        this.f11607d.startAnimation(AnimationUtils.loadAnimation(this.f11604a, R.anim.translate_in));
        this.f11605b.showAtLocation(this.f11604a.getWindow().getDecorView(), 17, 0, 0);
        C1844ka.m10073a().m10077a(this.f11616m);
        C1844ka.m10073a().m10078a(true, 2147483647L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public void m10631e() {
        m10633f();
        this.f11614k.clear();
        this.f11615l.m9854b(-1);
        this.f11615l.notifyDataSetChanged();
        if (MyApplication.m7738a().m7743c() == null) {
            MyApplication.m7738a().m7742b();
        }
        if (MyApplication.m7738a().m7743c() == null) {
            return;
        }
        C1844ka.m10073a().m10081c();
        MyApplication.m7738a().m7743c().disable();
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        new AnonymousClass11(5000L, 1000L, scaleAnimation).start();
    }

    /* JADX INFO: renamed from: mv$11, reason: invalid class name */
    /* JADX INFO: compiled from: SearchDevicePopWindow.java */
    class AnonymousClass11 extends CountDownTimer {

        /* JADX INFO: renamed from: a */
        boolean f11621a;

        /* JADX INFO: renamed from: b */
        boolean f11622b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ ScaleAnimation f11623c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass11(long j, long j2, ScaleAnimation scaleAnimation) {
            super(j, j2);
            this.f11623c = scaleAnimation;
            this.f11621a = true;
            this.f11622b = false;
        }

        @Override // android.os.CountDownTimer
        public void onTick(long j) {
            new Handler().postDelayed(new Runnable() { // from class: mv.11.1
                @Override // java.lang.Runnable
                public void run() {
                    if (BluetoothAdapter.getDefaultAdapter().isEnabled() || !AnonymousClass11.this.f11621a) {
                        return;
                    }
                    AnonymousClass11.this.f11622b = BluetoothAdapter.getDefaultAdapter().enable();
                    AnonymousClass11.this.f11621a = false;
                }
            }, 1000L);
            C1923mv.this.f11609f.setText("" + (j / 1000));
            C1923mv.this.f11609f.startAnimation(this.f11623c);
            C1923mv.this.f11609f.setVisibility(0);
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            this.f11621a = true;
            C1923mv.this.m10635g();
            if (BluetoothAdapter.getDefaultAdapter().isEnabled()) {
                C1844ka.m10073a().m10078a(true, 2147483647L);
                return;
            }
            if (this.f11622b) {
                return;
            }
            C1913ml.m10553a(C1923mv.this.f11604a.getString(R.string.open_ble_fail_check_permission));
            if (C1923mv.this.f11605b == null || !C1923mv.this.f11605b.isShowing()) {
                return;
            }
            C1923mv.this.f11605b.dismiss();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m10624a(BluetoothDevice bluetoothDevice) {
        for (int i = 0; i < this.f11614k.size(); i++) {
            if (this.f11614k.get(i).getAddress().equals(bluetoothDevice.getAddress())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public void m10642b() {
        this.f11606c.startAnimation(AnimationUtils.loadAnimation(this.f11604a, R.anim.alpha_out));
        this.f11607d.startAnimation(AnimationUtils.loadAnimation(this.f11604a, R.anim.translate_out));
        MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: mv.2
            @Override // java.lang.Runnable
            public void run() {
                if (C1923mv.this.f11605b.isShowing()) {
                    C1923mv.this.f11605b.dismiss();
                }
            }
        }, 300L);
    }

    /* JADX INFO: renamed from: f */
    private void m10633f() {
        this.f11611h.setText(R.string.re_start_ble);
        this.f11608e.setVisibility(4);
        this.f11609f.setVisibility(0);
        this.f11612i.setEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: g */
    public void m10635g() {
        this.f11611h.setText(R.string.popuwindow_link_text1);
        this.f11608e.setVisibility(0);
        this.f11609f.setVisibility(8);
        if (this.f11615l.m9855c() != -1) {
            this.f11612i.setEnabled(true);
        } else {
            this.f11612i.setEnabled(false);
        }
    }

    /* JADX INFO: renamed from: c */
    public String m10643c() {
        return this.f11613j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m10622a(final BluetoothDevice bluetoothDevice, final String str, final AbstractC1838jv.a aVar) {
        DialogC1861kr dialogC1861kr = new DialogC1861kr(this.f11604a);
        dialogC1861kr.requestWindowFeature(1);
        dialogC1861kr.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: mv.3
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (bluetoothDevice != null) {
                    C1844ka.m10073a().m10080b(str);
                    C1839jw.m10026a().m10039a(bluetoothDevice, C1923mv.this.f11604a, aVar);
                }
            }
        });
        dialogC1861kr.show();
        dialogC1861kr.getWindow().getDecorView().setPadding(0, 0, 0, 0);
    }
}
