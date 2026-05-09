package p000;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.coollang.tennis.R;
import com.coollang.tennis.activity.MainActivity;
import com.coollang.tennis.activity.SettingActivity;
import com.coollang.tennis.base.MyApplication;
import com.coollang.tennis.fragment.RankListFragment;
import com.coollang.tennis.p011db.model.MyActionTable;
import com.coollang.tennis.p011db.model.MyDetailTable;
import com.coollang.tennis.p011db.model.MyMainTable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.litepal.crud.DataSupport;
import p000.AbstractC1838jv;

/* JADX INFO: renamed from: jw */
/* JADX INFO: compiled from: BleManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C1839jw implements AbstractC1838jv.a {

    /* JADX INFO: renamed from: a */
    public static C1840jx f10820a;

    /* JADX INFO: renamed from: f */
    private static DialogC2231wz f10821f;

    /* JADX INFO: renamed from: g */
    private static C1839jw f10822g;

    /* JADX INFO: renamed from: d */
    byte[] f10825d;

    /* JADX INFO: renamed from: h */
    private C1875le f10827h;

    /* JADX INFO: renamed from: i */
    private int f10828i;

    /* JADX INFO: renamed from: b */
    public Handler f10823b = new Handler() { // from class: jw.3
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            byte[] bArr = (byte[]) message.obj;
            C1900mc.m10475c("showdata", C1893lw.m10456d(bArr));
            C1839jw.this.m10044b();
            if (bArr != null) {
                if (bArr[0] == -88 && bArr[1] == 1) {
                    C1839jw.f10820a.m10016a();
                    C1839jw.f10820a = null;
                    MyApplication.m7738a().f7401b = false;
                    C1839jw.this.f10827h.mo7930b();
                }
                if (bArr[0] == -88 && bArr[1] == 2) {
                    C1839jw.f10820a.m10016a();
                    C1839jw.f10820a = null;
                    MyApplication.m7738a().f7401b = false;
                    C1839jw.this.f10827h.mo7930b();
                }
                if (bArr[0] == -88 && bArr[1] == 3 && C1893lw.m10442a(bArr)) {
                    MainActivity.f6469c = false;
                    if (SettingActivity.f6644a) {
                        SettingActivity.f6644a = false;
                        C1913ml.m10553a(C1914mm.m10557b(R.string.success_clear_data));
                    }
                    C1900mc.m10473a("清除数据", "data[1]=" + ((int) bArr[1]));
                }
                if (bArr[0] == -88 && bArr[1] == 4 && C1893lw.m10442a(bArr)) {
                    MainActivity.f6469c = false;
                    C1913ml.m10553a(C1914mm.m10557b(R.string.success_reset));
                    C1900mc.m10473a("恢复出厂", "data[1]=" + ((int) bArr[1]));
                }
                if (bArr[0] == -88 && bArr[1] == 17 && C1893lw.m10442a(bArr)) {
                    String strM10534a = C1912mk.m10534a(C1893lw.m10454b(bArr[2], bArr[3], bArr[4], bArr[5]));
                    C1900mc.m10475c("校准的时间", "设备返回的时间=" + C1893lw.m10454b(bArr[2], bArr[3], bArr[4], bArr[5]));
                    C1900mc.m10475c("校准的时间", "设备返回的时间=" + strM10534a);
                    C1839jw.this.f10829j = 0;
                    C1839jw.this.f10835p.clear();
                    C1839jw.this.f10836q.clear();
                    C1839jw.this.m10042a(35);
                }
                if (bArr[0] == -88 && bArr[1] == 18 && C1893lw.m10442a(bArr)) {
                    for (int i = 0; i < C1839jw.this.f10825d.length; i++) {
                        C1839jw.this.f10825d[i] = bArr[i + 2];
                    }
                    C1839jw.f10820a.f10812c = new String(C1839jw.this.f10825d);
                    C1839jw.this.f10827h.mo7931c();
                    C1913ml.m10552a(R.string.set_device_name_success);
                }
                if (bArr[0] == -88 && bArr[1] == 33 && C1893lw.m10442a(bArr)) {
                    String str = (String) C1839jw.this.m10043b(bArr).subSequence(2, 16);
                    Log.d("aaaa", str + "===");
                    C1839jw.this.f10827h.mo7929a(str);
                }
                if (bArr[0] == -88 && bArr[1] == 34 && C1893lw.m10442a(bArr)) {
                    C1839jw.this.f10827h.mo7927a(bArr[2]);
                }
                if (bArr[0] == -88 && bArr[1] == 35 && bArr[2] == 1 && C1893lw.m10442a(bArr)) {
                    C1900mc.m10475c("senddata", "init07DataA");
                    C1839jw.this.m10032c(bArr);
                }
                if (bArr[0] == -88 && bArr[1] == 35 && bArr[2] == 2 && C1893lw.m10442a(bArr)) {
                    C1900mc.m10475c("senddata", "init08Data");
                    C1839jw.this.m10035d(bArr);
                }
                if (bArr[0] == -88 && bArr[1] == 35 && bArr[2] == 3 && C1893lw.m10442a(bArr)) {
                    C1900mc.m10475c("senddata", "0x23finish");
                    C1839jw.this.f10827h.mo7932d();
                    C1839jw.this.f10829j = 0;
                    C1839jw.this.m10038f();
                    C1839jw.this.m10044b();
                    RankListFragment.f7569b = true;
                }
                if (bArr[0] == -88 && bArr[1] == 37 && bArr[2] == 2 && C1893lw.m10442a(bArr)) {
                    C1900mc.m10475c("动作详情结束返回0118", "动作详情结束返回0118=" + C1839jw.this.f10829j + "=" + C1839jw.this.f10835p.size());
                    if (C1839jw.this.f10829j >= C1839jw.this.f10835p.size()) {
                        C1839jw.this.f10827h.mo7933e();
                        C1900mc.m10475c("senddata", "loadFinish");
                        C1842jz.m10050a().m10057d();
                        if (MainActivity.f6469c && MyApplication.m7738a().m7745e() != null) {
                            C1839jw.this.m10042a(3, (byte) Integer.parseInt(MyApplication.m7738a().m7745e().errDesc.Hand.contentEquals("1") ? "0" : "1"));
                        }
                    } else {
                        C1900mc.m10475c("0x25", "0x25调用次数");
                        C1839jw.this.m10038f();
                    }
                    C1839jw.this.m10044b();
                }
            }
        }
    };

    /* JADX INFO: renamed from: c */
    Boolean f10824c = false;

    /* JADX INFO: renamed from: j */
    private int f10829j = 0;

    /* JADX INFO: renamed from: e */
    long f10826e = 0;

    /* JADX INFO: renamed from: k */
    private int f10830k = 0;

    /* JADX INFO: renamed from: l */
    private int f10831l = 0;

    /* JADX INFO: renamed from: m */
    private int f10832m = 0;

    /* JADX INFO: renamed from: n */
    private int f10833n = 0;

    /* JADX INFO: renamed from: o */
    private String f10834o = "2016 1";

    /* JADX INFO: renamed from: p */
    private List<Byte> f10835p = new ArrayList();

    /* JADX INFO: renamed from: q */
    private List<Byte> f10836q = new ArrayList();

    /* JADX INFO: renamed from: a */
    public static C1839jw m10026a() {
        if (f10822g == null) {
            f10822g = new C1839jw();
        }
        return f10822g;
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    public static BluetoothAdapter m10025a(Context context) {
        BluetoothAdapter adapter;
        if (!m10037e() || !context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le") || (adapter = ((BluetoothManager) context.getSystemService("bluetooth")).getAdapter()) == null) {
            return null;
        }
        adapter.enable();
        return adapter;
    }

    /* JADX INFO: renamed from: e */
    private static boolean m10037e() {
        return Build.VERSION.SDK_INT > 17;
    }

    /* JADX INFO: renamed from: a */
    public void m10039a(BluetoothDevice bluetoothDevice, Context context, AbstractC1838jv.a aVar) {
        f10820a = new C1840jx(MyApplication.m7738a(), bluetoothDevice);
        f10820a.m10019a(aVar);
        f10821f = new DialogC2231wz(context, 5).m12196a(C1914mm.m10557b(R.string.load_detail));
        f10821f.setCancelable(true);
        f10821f.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: jw.1
            @Override // android.content.DialogInterface.OnDismissListener
            public void onDismiss(DialogInterface dialogInterface) {
                if (MyApplication.m7738a().f7401b || C1839jw.f10820a == null) {
                    return;
                }
                C1839jw.f10820a.m10016a();
                C1839jw.f10820a = null;
            }
        });
        f10821f.show();
    }

    /* JADX INFO: renamed from: b */
    public void m10044b() {
        if (f10821f == null || !f10821f.isShowing()) {
            return;
        }
        f10821f.m12196a(C1914mm.m10557b(R.string.download_success)).m12203d("OK").m12199a(2);
        MyApplication.m7738a().m7744d().postDelayed(new Runnable() { // from class: jw.2
            @Override // java.lang.Runnable
            public void run() {
                C1839jw.f10821f.dismiss();
            }
        }, 1000L);
    }

    /* JADX INFO: renamed from: a */
    public void m10042a(byte... bArr) {
        if (f10820a != null) {
            f10820a.m10047a(C1853kj.f10922d, C1853kj.f10923e, C1893lw.m10455c(bArr));
        }
    }

    /* JADX INFO: renamed from: c */
    public void m10045c() {
        if (f10820a != null) {
            f10820a.m10019a(this);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m10041a(C1875le c1875le) {
        this.f10827h = c1875le;
    }

    /* JADX INFO: renamed from: a */
    public void m10040a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f10825d = str.getBytes();
            byte[] bArr = new byte[19];
            bArr[0] = -88;
            bArr[1] = 18;
            if (this.f10825d.length <= 17) {
                for (int i = 0; i < 17; i++) {
                    if (i < this.f10825d.length) {
                        bArr[i + 2] = this.f10825d[i];
                    } else {
                        bArr[i + 2] = 32;
                    }
                }
                byte[] bArr2 = new byte[20];
                for (int i2 = 0; i2 < bArr.length; i2++) {
                    bArr2[i2] = bArr[i2];
                }
                bArr2[19] = C1893lw.m10451b(bArr);
                if (f10820a != null) {
                    f10820a.m10047a(C1853kj.f10922d, C1853kj.f10923e, bArr2);
                    return;
                }
                return;
            }
            Toast.makeText(C1914mm.m10554a(), R.string.name_too_long, 0).show();
            return;
        }
        Toast.makeText(C1914mm.m10554a(), R.string.device_name_empty, 0).show();
    }

    @Override // p000.AbstractC1838jv.a
    /* JADX INFO: renamed from: a */
    public void mo7490a(Context context, Intent intent, String str, String str2) {
        String action = intent.getAction();
        if ("com.rfstar.kevin.service.ACTION_GATT_CONNECTED".equals(action)) {
            C1900mc.m10474b("bleService", "ACTION_GATT_CONNECTED");
            String strM10480a = C1902me.m10480a(context);
            String strM10487b = C1902me.m10487b(context, C1902me.f11454e, "-1");
            if (strM10487b.startsWith(strM10480a) && strM10487b.endsWith("1")) {
                return;
            }
            new C1874ld().m10228i();
            C1902me.m10484a(context, C1902me.f11454e, strM10480a + "_1");
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_DISCONNECTED".equals(action)) {
            C1900mc.m10474b("bleService", "ACTION_GATT_DISCONNECTED");
            MyApplication.m7738a().f7401b = false;
            this.f10827h.mo7930b();
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_GATT_SERVICES_DISCOVERED".equals(action)) {
            C1900mc.m10474b("bleService", "ACTION_GATT_SERVICES_DISCOVERED");
            MyApplication.m7738a().f7401b = true;
            if (f10820a != null) {
                f10820a.m10046a(C1853kj.f10919a, C1853kj.f10920b, true);
            }
            this.f10827h.mo7382a();
            return;
        }
        if ("com.rfstar.kevin.service.ACTION_DATA_AVAILABLE".equals(action) && intent.getStringExtra("com.rfstar.kevin.service.characteristic").contains(C1853kj.f10921c)) {
            byte[] byteArrayExtra = intent.getByteArrayExtra("com.rfstar.kevin.service.EXTRA_DATA");
            if (byteArrayExtra.length > 3) {
                Message messageObtain = Message.obtain();
                messageObtain.obj = byteArrayExtra;
                this.f10823b.sendMessage(messageObtain);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m10032c(byte[] bArr) {
        Date date;
        this.f10828i = C1893lw.m10453b(bArr[3], bArr[4]);
        int iM10453b = C1893lw.m10453b(bArr[5], bArr[6]);
        int iM10453b2 = C1893lw.m10453b(bArr[7], bArr[8]);
        int iM10453b3 = C1893lw.m10453b(bArr[9], bArr[10]);
        float fM10441a = C1892lv.m10441a(C1902me.m10486b(C1914mm.m10554a(), "weight", 60), iM10453b);
        this.f10826e = this.f10828i * 86400;
        if (this.f10826e < 1451606400) {
            return;
        }
        String[] strArrSplit = C1912mk.m10540b(this.f10826e - ((long) C1912mk.m10541c())).split("-");
        String str = strArrSplit[0] + strArrSplit[1] + strArrSplit[2];
        C1900mc.m10475c("mainData", str);
        int iCount = DataSupport.where("sign2 = ? And UserID = ?", str, C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1")).count(MyDetailTable.class);
        List listFind = DataSupport.where("date = ? And UserID = ?", String.valueOf(this.f10826e), C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1")).find(MyMainTable.class);
        int totletimes = (listFind == null || listFind.isEmpty()) ? 0 : ((MyMainTable) listFind.get(0)).getTotletimes();
        C1900mc.m10475c("mainData", "database_date=" + iCount + "  totaltimes=" + iM10453b2 + "   dayMainCount=" + totletimes + "   date=" + this.f10828i);
        if ((iM10453b2 > iCount || iM10453b2 > totletimes) && this.f10828i != 16071) {
            this.f10824c = true;
            this.f10830k = iM10453b;
            this.f10831l = iM10453b3;
            this.f10832m = (int) fM10441a;
            this.f10833n = iM10453b2;
            this.f10835p.add(Byte.valueOf(bArr[3]));
            this.f10836q.add(Byte.valueOf(bArr[4]));
            C1900mc.m10475c("mainData", "mainhigh=" + this.f10835p.size());
            String[] strArrSplit2 = C1912mk.m10534a(this.f10826e - ((long) C1912mk.m10541c())).split(" ");
            String[] strArrSplit3 = strArrSplit2[0].split("-");
            try {
                date = new SimpleDateFormat("yyyy-MM-dd").parse(strArrSplit2[0]);
                try {
                    C1900mc.m10474b("myDetailTable", "dateaa == " + date + "date == " + this.f10828i);
                } catch (ParseException e) {
                    e = e;
                    e.printStackTrace();
                }
            } catch (ParseException e2) {
                e = e2;
                date = null;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            this.f10834o = strArrSplit3[0] + " " + Integer.toString(calendar.get(3));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: d */
    public void m10035d(byte[] bArr) {
        if (this.f10824c.booleanValue()) {
            int iM10453b = C1893lw.m10453b(bArr[3], bArr[4]);
            int iM10453b2 = C1893lw.m10453b(bArr[5], bArr[6]);
            int iM10453b3 = C1893lw.m10453b(bArr[7], bArr[8]);
            int iM10453b4 = C1893lw.m10453b(bArr[9], bArr[10]);
            int iM10453b5 = C1893lw.m10453b(bArr[11], bArr[12]);
            int iM10453b6 = C1893lw.m10453b(bArr[13], bArr[14]);
            List listFind = DataSupport.where("date = ? And UserID = ?", Long.toString(this.f10826e), C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1")).find(MyMainTable.class);
            MyActionTable myActionTable = new MyActionTable();
            myActionTable.setDate(this.f10826e);
            myActionTable.setFaqiu(iM10453b);
            myActionTable.setGaoya(iM10453b2);
            myActionTable.setJieji(iM10453b3);
            myActionTable.setXiaoqiu(iM10453b4);
            myActionTable.setXuanqiu(iM10453b5);
            myActionTable.setPingji(iM10453b6);
            myActionTable.setToDefault("sign1");
            myActionTable.setSign2("0");
            myActionTable.setUserID(Integer.parseInt(C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1")));
            if (listFind.isEmpty()) {
                myActionTable.save();
            } else {
                DataSupport.deleteAll((Class<?>) MyActionTable.class, "date = ? And UserID = ?", Long.toString(this.f10826e), C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1"));
                myActionTable.save();
            }
            MyMainTable myMainTable = new MyMainTable();
            myMainTable.setActionTable(myActionTable);
            myMainTable.setDate(this.f10826e);
            myMainTable.setTotletimes(this.f10833n);
            myMainTable.setDuration(this.f10830k);
            myMainTable.setCaroline(this.f10832m);
            myMainTable.setMaxSpeed(this.f10831l);
            myMainTable.setToDefault("sign1");
            myMainTable.setSign2(this.f10834o);
            myMainTable.setSignDate(C1912mk.m10540b(this.f10826e - ((long) C1912mk.m10541c())));
            myMainTable.setUserID(Integer.parseInt(C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1")));
            if (listFind.isEmpty()) {
                myMainTable.save();
            } else if (((MyMainTable) listFind.get(0)).getTotletimes() != this.f10833n) {
                DataSupport.deleteAll((Class<?>) MyMainTable.class, "date = ? And UserID = ?", Long.toString(this.f10826e), C1902me.m10487b(C1914mm.m10554a(), "UserID", "-1"));
                myMainTable.save();
                C1900mc.m10473a("验证------", "主界面总排数=" + this.f10833n);
            }
            C1900mc.m10474b("myDetailTable", "date == " + this.f10826e);
            this.f10824c = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m10038f() {
        C1900mc.m10475c("sendDetailData", "Size=" + this.f10835p.size());
        C1900mc.m10475c("sendDetailData", "lowSize=" + this.f10836q.size());
        if (this.f10835p.size() == 0) {
            C1842jz.m10050a().m10057d();
        }
        boolean z = false;
        if (this.f10835p.size() > 0) {
            int iM10453b = C1893lw.m10453b(this.f10835p.get(this.f10829j).byteValue(), this.f10836q.get(this.f10829j).byteValue()) * 86400;
            String[] strArrSplit = C1912mk.m10534a(iM10453b - C1912mk.m10541c()).split(" ")[0].split("-");
            String str = strArrSplit[0] + strArrSplit[1] + strArrSplit[2];
            String strM10480a = C1902me.m10480a(C1914mm.m10554a());
            if (DataSupport.where("date = ? And UserID = ?", Long.toString(iM10453b), strM10480a).count(MyMainTable.class) > 0) {
                C1900mc.m10475c("sendDetailData", "hit times not equal");
                int iCount = DataSupport.where("sign2 = ? And UserID = ?", str, strM10480a).count(MyDetailTable.class);
                C1900mc.m10475c("hisToltle", "hisToltle=" + iCount);
                byte[] bArrM10449a = C1893lw.m10449a(iCount);
                C1900mc.m10475c("senddata", "=======0x25");
                MyApplication.m7738a().f7406g = C1912mk.m10542c((long) ((C1893lw.m10453b(this.f10835p.get(this.f10829j).byteValue(), this.f10836q.get(this.f10829j).byteValue()) * 86400) - C1912mk.m10541c()));
                m10042a(37, this.f10835p.get(this.f10829j).byteValue(), this.f10836q.get(this.f10829j).byteValue(), bArrM10449a[0], bArrM10449a[1]);
                this.f10827h.mo7928a(C1893lw.m10453b(this.f10835p.get(this.f10829j).byteValue(), this.f10836q.get(this.f10829j).byteValue()) * 86400, iCount);
            } else {
                z = true;
            }
        } else {
            this.f10827h.mo7933e();
        }
        this.f10829j++;
        if (this.f10829j >= this.f10835p.size() || !z) {
            return;
        }
        C1900mc.m10473a("sendDetailData", "0x25调用次数");
        m10038f();
    }

    /* JADX INFO: renamed from: b */
    public String m10043b(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            str = str + ((char) b);
        }
        return str;
    }
}
