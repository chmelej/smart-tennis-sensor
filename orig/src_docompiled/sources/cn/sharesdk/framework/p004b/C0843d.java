package cn.sharesdk.framework.p004b;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.p004b.p005a.C0833e;
import cn.sharesdk.framework.p004b.p006b.AbstractC0837c;
import cn.sharesdk.framework.p004b.p006b.C0839e;
import cn.sharesdk.framework.p004b.p006b.C0841g;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.commons.SHARESDK;
import com.mob.commons.appcollector.PackageCollector;
import com.mob.commons.appcollector.RuntimeCollector;
import com.mob.commons.deviceinfo.DeviceInfoCollector;
import com.mob.commons.iosbridge.UDPServer;
import com.mob.tools.SSDKHandlerThread;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.FileLocker;
import java.io.File;
import java.util.Calendar;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.d */
/* JADX INFO: compiled from: StatisticsLogger.java */
/* JADX INFO: loaded from: classes.dex */
public class C0843d extends SSDKHandlerThread {

    /* JADX INFO: renamed from: a */
    private static C0843d f5639a;

    /* JADX INFO: renamed from: b */
    private Context f5640b;

    /* JADX INFO: renamed from: c */
    private DeviceHelper f5641c;

    /* JADX INFO: renamed from: d */
    private C0828a f5642d;

    /* JADX INFO: renamed from: e */
    private String f5643e;

    /* JADX INFO: renamed from: f */
    private Handler f5644f;

    /* JADX INFO: renamed from: g */
    private boolean f5645g;

    /* JADX INFO: renamed from: h */
    private int f5646h;

    /* JADX INFO: renamed from: i */
    private boolean f5647i;

    /* JADX INFO: renamed from: j */
    private long f5648j;

    /* JADX INFO: renamed from: k */
    private boolean f5649k;

    /* JADX INFO: renamed from: l */
    private File f5650l;

    /* JADX INFO: renamed from: m */
    private FileLocker f5651m = new FileLocker();

    /* JADX INFO: renamed from: a */
    public static synchronized C0843d m6084a(Context context, String str) {
        if (f5639a == null) {
            if (context == null) {
                return null;
            }
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            f5639a = new C0843d(context.getApplicationContext(), str);
        }
        return f5639a;
    }

    private C0843d(Context context, String str) {
        this.f5640b = context;
        this.f5643e = str;
        this.f5641c = DeviceHelper.getInstance(context);
        this.f5642d = C0828a.m5995a(context, str);
        this.f5650l = new File(context.getFilesDir(), ".statistics");
        if (this.f5650l.exists()) {
            return;
        }
        try {
            this.f5650l.createNewFile();
        } catch (Exception e) {
            C0851d.m6195a().m8610d(e);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6090a(Handler handler) {
        this.f5644f = handler;
    }

    /* JADX INFO: renamed from: a */
    public void m6092a(boolean z) {
        this.f5645g = z;
    }

    /* JADX INFO: renamed from: a */
    public void m6089a(int i) {
        this.f5646h = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onStart(Message message) {
        if (this.f5647i) {
            return;
        }
        this.f5647i = true;
        try {
            this.f5651m.setLockFile(this.f5650l.getAbsolutePath());
            if (this.f5651m.lock(false)) {
                this.f5642d.m6007a();
                this.f5642d.m6012b();
                SHARESDK.setAppKey(this.f5643e);
                new SHARESDK().getDuid(this.f5640b);
                DeviceInfoCollector.startCollector(this.f5640b);
                PackageCollector.startCollector(this.f5640b);
                RuntimeCollector.startCollector(this.f5640b);
                UDPServer.start(this.f5640b);
                this.handler.sendEmptyMessageDelayed(4, 3600000L);
                this.f5642d.m6010a(this.f5645g);
                this.handler.sendEmptyMessage(1);
                this.handler.sendEmptyMessage(2);
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onStop(Message message) {
        if (this.f5647i) {
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f5648j;
            C0839e c0839e = new C0839e();
            c0839e.f5611a = jCurrentTimeMillis;
            m6091a(c0839e);
            this.f5647i = false;
            try {
                this.f5644f.sendEmptyMessage(1);
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
            }
            f5639a = null;
            this.handler.getLooper().quit();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6091a(AbstractC0837c abstractC0837c) {
        if (this.f5647i) {
            m6086b(abstractC0837c);
            if (abstractC0837c.mo6058a(this.f5640b)) {
                Message message = new Message();
                message.what = 3;
                message.obj = abstractC0837c;
                try {
                    this.handler.sendMessage(message);
                    return;
                } catch (Throwable th) {
                    C0851d.m6195a().m8610d(th);
                    return;
                }
            }
            C0851d.m6195a().m8609d("Drop event: " + abstractC0837c.toString(), new Object[0]);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m6086b(AbstractC0837c abstractC0837c) {
        abstractC0837c.f5596f = this.f5641c.getDeviceKey();
        abstractC0837c.f5597g = this.f5643e;
        abstractC0837c.f5598h = this.f5641c.getPackageName();
        abstractC0837c.f5599i = this.f5641c.getAppVersion();
        abstractC0837c.f5600j = String.valueOf(this.f5646h + 60000);
        abstractC0837c.f5601k = this.f5641c.getPlatformCode();
        abstractC0837c.f5602l = this.f5641c.getDetailNetworkTypeForStatic();
        if (TextUtils.isEmpty(this.f5643e)) {
            System.err.println("Your appKey of ShareSDK is null , this will cause its data won't be count!");
        } else if (!"cn.sharesdk.demo".equals(abstractC0837c.f5598h) && ("api20".equals(this.f5643e) || "androidv1101".equals(this.f5643e))) {
            System.err.println("Your app is using the appkey of ShareSDK Demo, this will cause its data won't be count!");
        }
        abstractC0837c.f5603m = this.f5641c.getDeviceData();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.mob.tools.SSDKHandlerThread
    public void onMessage(Message message) {
        switch (message.what) {
            case 1:
                m6085a();
                try {
                    this.handler.sendEmptyMessageDelayed(1, 5000L);
                } catch (Throwable th) {
                    C0851d.m6195a().m8610d(th);
                }
                break;
            case 2:
                try {
                    this.f5642d.m6013c();
                } catch (Throwable th2) {
                    C0851d.m6195a().m8610d(th2);
                    return;
                }
                break;
            case 3:
                if (message.obj != null) {
                    m6088c((AbstractC0837c) message.obj);
                    this.handler.removeMessages(2);
                    this.handler.sendEmptyMessageDelayed(2, 10000L);
                }
                break;
            case 4:
                long jLongValue = C0833e.m6025a(this.f5640b).m6045f().longValue();
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(jLongValue);
                int i = calendar.get(1);
                int i2 = calendar.get(2);
                int i3 = calendar.get(5);
                calendar.setTimeInMillis(System.currentTimeMillis());
                int i4 = calendar.get(1);
                int i5 = calendar.get(2);
                int i6 = calendar.get(5);
                if (i != i4 || i2 != i5 || i3 != i6) {
                    this.f5642d.m6012b();
                }
                this.handler.sendEmptyMessageDelayed(4, 3600000L);
                break;
        }
    }

    /* JADX INFO: renamed from: c */
    private void m6088c(AbstractC0837c abstractC0837c) {
        try {
            this.f5642d.m6008a(abstractC0837c);
            abstractC0837c.mo6059b(this.f5640b);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            C0851d.m6195a().m8609d(abstractC0837c.toString(), new Object[0]);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6085a() {
        boolean zM6087b = m6087b();
        if (zM6087b) {
            if (this.f5649k) {
                return;
            }
            this.f5649k = zM6087b;
            this.f5648j = System.currentTimeMillis();
            m6091a(new C0841g());
            return;
        }
        if (this.f5649k) {
            this.f5649k = zM6087b;
            long jCurrentTimeMillis = System.currentTimeMillis() - this.f5648j;
            C0839e c0839e = new C0839e();
            c0839e.f5611a = jCurrentTimeMillis;
            m6091a(c0839e);
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m6087b() {
        DeviceHelper deviceHelper = DeviceHelper.getInstance(this.f5640b);
        String topTaskPackageName = deviceHelper.getTopTaskPackageName();
        String packageName = deviceHelper.getPackageName();
        return packageName != null && packageName.equals(topTaskPackageName);
    }
}
