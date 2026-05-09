package com.umeng.update.net;

import android.R;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat;
import android.util.SparseArray;
import android.widget.Toast;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.android.spdy.SpdyRequest;
import p000.ajk;
import p000.ajl;
import p000.ajm;
import p000.ajm.AsyncTaskC0169c;
import p000.ajo;
import p000.ajp;
import p000.ajq;
import p000.ati;
import p000.atj;
import p000.atq;
import p000.ats;

/* JADX INFO: loaded from: classes.dex */
public class DownloadingService extends Service {

    /* JADX INFO: renamed from: b */
    public static boolean f9268b = false;

    /* JADX INFO: renamed from: d */
    private static final String f9269d = "com.umeng.update.net.DownloadingService";

    /* JADX INFO: renamed from: i */
    private static Map<ajk.C0161a, Messenger> f9270i = new HashMap();

    /* JADX INFO: renamed from: j */
    private static SparseArray<ajm.C0168b> f9271j = new SparseArray<>();

    /* JADX INFO: renamed from: m */
    private static Boolean f9272m = false;

    /* JADX INFO: renamed from: a */
    public InterfaceC1634a f9273a;

    /* JADX INFO: renamed from: e */
    private NotificationManager f9275e;

    /* JADX INFO: renamed from: f */
    private ajm f9276f;

    /* JADX INFO: renamed from: g */
    private Context f9277g;

    /* JADX INFO: renamed from: h */
    private Handler f9278h;

    /* JADX INFO: renamed from: k */
    private ajo f9279k;

    /* JADX INFO: renamed from: c */
    final Messenger f9274c = new Messenger(new HandlerC1636c());

    /* JADX INFO: renamed from: l */
    private boolean f9280l = true;

    /* JADX INFO: renamed from: com.umeng.update.net.DownloadingService$a */
    public interface InterfaceC1634a {
        /* JADX INFO: renamed from: a */
        void mo8775a(int i);

        /* JADX INFO: renamed from: a */
        void mo8776a(int i, int i2);

        /* JADX INFO: renamed from: a */
        void mo8777a(int i, Exception exc);

        /* JADX INFO: renamed from: a */
        void mo8778a(int i, String str);
    }

    /* JADX INFO: renamed from: com.umeng.update.net.DownloadingService$c */
    class HandlerC1636c extends Handler {
        HandlerC1636c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            atj.m5427c(DownloadingService.f9269d, "IncomingHandler(msg.what:" + message.what + " msg.arg1:" + message.arg1 + " msg.arg2:" + message.arg2 + " msg.replyTo:" + message.replyTo);
            if (message.what == 4) {
                Bundle data = message.getData();
                atj.m5427c(DownloadingService.f9269d, "IncomingHandler(msg.getData():" + data);
                ajk.C0161a c0161aM1557a = ajk.C0161a.m1557a(data);
                if (DownloadingService.this.f9276f.m1572a(c0161aM1557a, DownloadingService.f9268b, message.replyTo)) {
                    atj.m5423a(DownloadingService.f9269d, c0161aM1557a.f1307b + " is already in downloading list. ");
                    int iM1575b = DownloadingService.this.f9276f.m1575b(c0161aM1557a);
                    if (iM1575b != -1 && ((ajm.C0168b) DownloadingService.f9271j.get(iM1575b)).f1329a == null) {
                        String strM1596a = ajp.m1596a(iM1575b, "continue");
                        Intent intent = new Intent(DownloadingService.this.f9277g, (Class<?>) DownloadingService.class);
                        intent.putExtra("com.umeng.broadcast.download.msg", strM1596a);
                        DownloadingService.this.f9276f.m1574a(DownloadingService.this, intent);
                        return;
                    }
                    Toast.makeText(DownloadingService.this.f9277g, atq.m5453b(DownloadingService.this.f9277g), 0).show();
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    messageObtain.arg1 = 2;
                    messageObtain.arg2 = 0;
                    try {
                        message.replyTo.send(messageObtain);
                        return;
                    } catch (RemoteException e) {
                        e.printStackTrace();
                        return;
                    }
                }
                if (ati.m5417e(DownloadingService.this.getApplicationContext())) {
                    DownloadingService.f9270i.put(c0161aM1557a, message.replyTo);
                    Message messageObtain2 = Message.obtain();
                    messageObtain2.what = 1;
                    messageObtain2.arg1 = 1;
                    messageObtain2.arg2 = 0;
                    try {
                        message.replyTo.send(messageObtain2);
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                    }
                    DownloadingService.this.m8764a(c0161aM1557a);
                    return;
                }
                Toast.makeText(DownloadingService.this.f9277g, atq.m5452a(DownloadingService.this.f9277g), 0).show();
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 2;
                messageObtain3.arg1 = 4;
                messageObtain3.arg2 = 0;
                try {
                    message.replyTo.send(messageObtain3);
                    return;
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                    return;
                }
            }
            super.handleMessage(message);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        atj.m5427c(f9269d, "onBind ");
        return this.f9274c.getBinder();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null && intent.getExtras() != null && intent.getExtras().containsKey("com.umeng.broadcast.download.msg")) {
            this.f9276f.m1574a(this, intent);
        }
        if (Build.VERSION.SDK_INT >= 19 && (this.f9279k.m1594b() || this.f9280l)) {
            try {
                Intent intent2 = new Intent(getApplicationContext(), getClass());
                intent2.setPackage(getPackageName());
                ((AlarmManager) getApplicationContext().getSystemService(NotificationCompat.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + 5000, PendingIntent.getService(getApplicationContext(), 1, intent2, 1073741824));
            } catch (Exception unused) {
            }
        }
        if (this.f9280l) {
            m8773d();
            this.f9280l = false;
        }
        return 1;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (f9268b) {
            atj.f5037a = true;
            Debug.waitForDebugger();
        }
        atj.m5427c(f9269d, "onCreate ");
        this.f9275e = (NotificationManager) getSystemService("notification");
        this.f9277g = this;
        this.f9279k = new ajo(this.f9277g);
        this.f9276f = new ajm(f9271j, f9270i, this.f9279k);
        this.f9278h = new Handler() { // from class: com.umeng.update.net.DownloadingService.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                Notification notification;
                switch (message.what) {
                    case 5:
                        ajk.C0161a c0161a = (ajk.C0161a) message.obj;
                        int i = message.arg2;
                        try {
                            String string = message.getData().getString("filename");
                            ajq.m1603a(string, 39, -1, -1);
                            atj.m5427c(DownloadingService.f9269d, "Cancel old notification....");
                            Intent intent = new Intent("android.intent.action.VIEW");
                            intent.addFlags(268435456);
                            intent.setDataAndType(Uri.fromFile(new File(string)), "application/vnd.android.package-archive");
                            PendingIntent activity = PendingIntent.getActivity(DownloadingService.this.f9277g, 0, intent, 134217728);
                            if (c0161a.f1313h) {
                                notification = new Notification(R.drawable.stat_sys_download_done, DownloadingService.this.f9277g.getString(atq.m5464m(DownloadingService.this.f9277g)), System.currentTimeMillis());
                                notification.setLatestEventInfo(DownloadingService.this.f9277g, c0161a.f1307b, DownloadingService.this.f9277g.getString(atq.m5464m(DownloadingService.this.f9277g)), activity);
                            } else {
                                notification = new Notification(R.drawable.stat_sys_download_done, DownloadingService.this.f9277g.getString(atq.m5462k(DownloadingService.this.f9277g)), System.currentTimeMillis());
                                notification.setLatestEventInfo(DownloadingService.this.f9277g, c0161a.f1307b, DownloadingService.this.f9277g.getString(atq.m5462k(DownloadingService.this.f9277g)), activity);
                            }
                            notification.flags = 16;
                            DownloadingService.this.f9275e = (NotificationManager) DownloadingService.this.getSystemService("notification");
                            int i2 = i + 1;
                            DownloadingService.this.f9275e.notify(i2, notification);
                            atj.m5427c(DownloadingService.f9269d, "Show new  notification....");
                            boolean zM1573a = DownloadingService.this.f9276f.m1573a(DownloadingService.this.f9277g);
                            atj.m5427c(DownloadingService.f9269d, String.format("isAppOnForeground = %1$B", Boolean.valueOf(zM1573a)));
                            if (zM1573a && !c0161a.f1313h) {
                                DownloadingService.this.f9275e.cancel(i2);
                                DownloadingService.this.f9277g.startActivity(intent);
                            }
                            atj.m5423a(DownloadingService.f9269d, String.format("%1$10s downloaded. Saved to: %2$s", c0161a.f1307b, string));
                        } catch (Exception e) {
                            atj.m5425b(DownloadingService.f9269d, "can not install. " + e.getMessage());
                            DownloadingService.this.f9275e.cancel(i + 1);
                        }
                        break;
                    case 6:
                        ajk.C0161a c0161a2 = (ajk.C0161a) message.obj;
                        int i3 = message.arg2;
                        String string2 = message.getData().getString("filename");
                        DownloadingService.this.f9275e.cancel(i3);
                        Notification notification2 = new Notification(R.drawable.stat_sys_download, DownloadingService.this.f9277g.getString(atq.m5465n(DownloadingService.this.f9277g)), System.currentTimeMillis());
                        notification2.setLatestEventInfo(DownloadingService.this.f9277g, ati.m5422j(DownloadingService.this.f9277g), DownloadingService.this.f9277g.getString(atq.m5465n(DownloadingService.this.f9277g)), PendingIntent.getActivity(DownloadingService.this.f9277g, 0, new Intent(), 134217728));
                        DownloadingService.this.f9275e.notify(i3 + 1, notification2);
                        String strReplace = string2.replace(".patch", ".apk");
                        String strM8790a = DeltaUpdate.m8790a(DownloadingService.this);
                        ajm ajmVar = DownloadingService.this.f9276f;
                        ajmVar.getClass();
                        ajmVar.new AsyncTaskC0169c(DownloadingService.this.f9277g, i3, c0161a2, strReplace).execute(strM8790a, strReplace, string2);
                        break;
                }
            }
        };
        this.f9273a = new InterfaceC1634a() { // from class: com.umeng.update.net.DownloadingService.2

            /* JADX INFO: renamed from: a */
            SparseArray<Long> f9282a = new SparseArray<>();

            @Override // com.umeng.update.net.DownloadingService.InterfaceC1634a
            /* JADX INFO: renamed from: a */
            public void mo8775a(int i) {
                if (DownloadingService.f9271j.indexOfKey(i) >= 0) {
                    ajm.C0168b c0168b = (ajm.C0168b) DownloadingService.f9271j.get(i);
                    long[] jArr = c0168b.f1334f;
                    int i2 = 0;
                    if (jArr != null && jArr[1] > 0 && (i2 = (int) ((jArr[0] / jArr[1]) * 100.0f)) > 100) {
                        i2 = 99;
                    }
                    if (c0168b.f1333e.f1313h) {
                        return;
                    }
                    this.f9282a.put(i, -1L);
                    ajm.C0167a c0167aM1567a = DownloadingService.this.f9276f.m1567a(DownloadingService.this, c0168b.f1333e, i, i2);
                    c0168b.f1330b = c0167aM1567a;
                    DownloadingService.this.f9275e.notify(i, c0167aM1567a.m1586d());
                }
            }

            @Override // com.umeng.update.net.DownloadingService.InterfaceC1634a
            /* JADX INFO: renamed from: a */
            public void mo8776a(int i, int i2) {
                if (DownloadingService.f9271j.indexOfKey(i) >= 0) {
                    ajm.C0168b c0168b = (ajm.C0168b) DownloadingService.f9271j.get(i);
                    ajk.C0161a c0161a = c0168b.f1333e;
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    if (!c0161a.f1313h && jCurrentTimeMillis - this.f9282a.get(i).longValue() > 500) {
                        this.f9282a.put(i, Long.valueOf(jCurrentTimeMillis));
                        ajm.C0167a c0167a = c0168b.f1330b;
                        c0167a.m1578a(100, i2, false).m1581a(String.valueOf(i2) + "%");
                        DownloadingService.this.f9275e.notify(i, c0167a.m1586d());
                    }
                    atj.m5427c(DownloadingService.f9269d, String.format("%3$10s Notification: mNotificationId = %1$15s\t|\tprogress = %2$15s", Integer.valueOf(i), Integer.valueOf(i2), c0161a.f1307b));
                }
            }

            @Override // com.umeng.update.net.DownloadingService.InterfaceC1634a
            /* JADX INFO: renamed from: a */
            public void mo8778a(int i, String str) {
                ajm.C0168b c0168b;
                if (DownloadingService.f9271j.indexOfKey(i) < 0 || (c0168b = (ajm.C0168b) DownloadingService.f9271j.get(i)) == null) {
                    return;
                }
                ajk.C0161a c0161a = c0168b.f1333e;
                ajl.m1559a(DownloadingService.this.f9277g).m1562a(c0161a.f1306a, c0161a.f1308c, 100);
                Bundle bundle = new Bundle();
                bundle.putString("filename", str);
                if (c0161a.f1306a.equalsIgnoreCase("delta_update")) {
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 6;
                    messageObtain.arg1 = 1;
                    messageObtain.obj = c0161a;
                    messageObtain.arg2 = i;
                    messageObtain.setData(bundle);
                    DownloadingService.this.f9278h.sendMessage(messageObtain);
                    return;
                }
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 5;
                messageObtain2.arg1 = 1;
                messageObtain2.obj = c0161a;
                messageObtain2.arg2 = i;
                messageObtain2.setData(bundle);
                DownloadingService.this.f9278h.sendMessage(messageObtain2);
                Message messageObtain3 = Message.obtain();
                messageObtain3.what = 5;
                messageObtain3.arg1 = 1;
                messageObtain3.arg2 = i;
                messageObtain3.setData(bundle);
                try {
                    if (DownloadingService.f9270i.get(c0161a) != null) {
                        ((Messenger) DownloadingService.f9270i.get(c0161a)).send(messageObtain3);
                    }
                    DownloadingService.this.f9276f.m1576b(DownloadingService.this.f9277g, i);
                } catch (RemoteException unused) {
                    DownloadingService.this.f9276f.m1576b(DownloadingService.this.f9277g, i);
                }
            }

            @Override // com.umeng.update.net.DownloadingService.InterfaceC1634a
            /* JADX INFO: renamed from: a */
            public void mo8777a(int i, Exception exc) {
                if (DownloadingService.f9271j.indexOfKey(i) >= 0) {
                    DownloadingService.this.f9276f.m1576b(DownloadingService.this.f9277g, i);
                }
            }
        };
    }

    /* JADX INFO: renamed from: d */
    private void m8773d() {
        Iterator<Integer> it = this.f9279k.m1591a().iterator();
        while (it.hasNext()) {
            this.f9275e.cancel(it.next().intValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8764a(ajk.C0161a c0161a) {
        atj.m5427c(f9269d, "startDownload([mComponentName:" + c0161a.f1306a + " mTitle:" + c0161a.f1307b + " mUrl:" + c0161a.f1308c + "])");
        int iM1566a = this.f9276f.m1566a(c0161a);
        C1635b c1635b = new C1635b(getApplicationContext(), c0161a, iM1566a, 0, this.f9273a);
        ajm.C0168b c0168b = new ajm.C0168b(c0161a, iM1566a);
        this.f9279k.m1592a(iM1566a);
        c0168b.m1587a(f9271j);
        c0168b.f1329a = c1635b;
        c1635b.start();
        m8774e();
        if (f9268b) {
            for (int i = 0; i < f9271j.size(); i++) {
                ajm.C0168b c0168bValueAt = f9271j.valueAt(i);
                atj.m5427c(f9269d, "Running task " + c0168bValueAt.f1333e.f1307b);
            }
        }
    }

    /* JADX INFO: renamed from: com.umeng.update.net.DownloadingService$b */
    public class C1635b extends Thread {

        /* JADX INFO: renamed from: b */
        private Context f9288b;

        /* JADX INFO: renamed from: c */
        private boolean f9289c;

        /* JADX INFO: renamed from: d */
        private File f9290d;

        /* JADX INFO: renamed from: e */
        private int f9291e;

        /* JADX INFO: renamed from: f */
        private long f9292f;

        /* JADX INFO: renamed from: g */
        private long f9293g;

        /* JADX INFO: renamed from: h */
        private int f9294h = -1;

        /* JADX INFO: renamed from: i */
        private int f9295i;

        /* JADX INFO: renamed from: j */
        private InterfaceC1634a f9296j;

        /* JADX INFO: renamed from: k */
        private ajk.C0161a f9297k;

        public C1635b(Context context, ajk.C0161a c0161a, int i, int i2, InterfaceC1634a interfaceC1634a) {
            long[] jArr;
            this.f9291e = 0;
            this.f9292f = -1L;
            this.f9293g = -1L;
            try {
                this.f9288b = context;
                this.f9297k = c0161a;
                this.f9291e = i2;
                if (DownloadingService.f9271j.indexOfKey(i) >= 0 && (jArr = ((ajm.C0168b) DownloadingService.f9271j.get(i)).f1334f) != null && jArr.length > 1) {
                    this.f9292f = jArr[0];
                    this.f9293g = jArr[1];
                }
                this.f9296j = interfaceC1634a;
                this.f9295i = i;
                boolean[] zArr = new boolean[1];
                this.f9290d = ajq.m1598a("/apk", context, zArr);
                this.f9289c = zArr[0];
                ajq.m1601a(this.f9290d, this.f9289c ? 104857600L : 10485760L, 259200000L);
                this.f9290d = new File(this.f9290d, m8780a(this.f9297k));
            } catch (Exception e) {
                atj.m5428c(DownloadingService.f9269d, e.getMessage(), e);
                this.f9296j.mo8777a(this.f9295i, e);
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() throws Throwable {
            this.f9291e = 0;
            try {
                if (this.f9296j != null) {
                    this.f9296j.mo8775a(this.f9295i);
                }
                m8785a(this.f9292f > 0);
                if (DownloadingService.f9270i.size() <= 0) {
                    DownloadingService.this.stopSelf();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /* JADX INFO: renamed from: a */
        public void m8788a(int i) {
            this.f9294h = i;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:101:0x0247 A[Catch: IOException -> 0x024b, TRY_ENTER, TRY_LEAVE, TryCatch #30 {IOException -> 0x024b, blocks: (B:101:0x0247, B:92:0x0236), top: B:259:0x0227 }] */
        /* JADX WARN: Removed duplicated region for block: B:165:0x0340 A[Catch: IOException -> 0x02f4, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x02f4, blocks: (B:165:0x0340, B:156:0x032e, B:203:0x0406, B:194:0x03f5, B:130:0x02ef, B:121:0x02dd, B:187:0x03e8, B:114:0x02d0), top: B:239:0x000b, inners: #9, #23 }] */
        /* JADX WARN: Removed duplicated region for block: B:171:0x035d A[Catch: all -> 0x040a, TRY_LEAVE, TryCatch #28 {all -> 0x040a, blocks: (B:147:0x030f, B:169:0x0349, B:171:0x035d, B:174:0x0381, B:175:0x039c, B:183:0x03c4, B:184:0x03e2, B:182:0x03a8, B:185:0x03e3, B:173:0x0363, B:181:0x03a5), top: B:257:0x000b, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:185:0x03e3 A[Catch: all -> 0x040a, TRY_LEAVE, TryCatch #28 {all -> 0x040a, blocks: (B:147:0x030f, B:169:0x0349, B:171:0x035d, B:174:0x0381, B:175:0x039c, B:183:0x03c4, B:184:0x03e2, B:182:0x03a8, B:185:0x03e3, B:173:0x0363, B:181:0x03a5), top: B:257:0x000b, inners: #0 }] */
        /* JADX WARN: Removed duplicated region for block: B:203:0x0406 A[Catch: IOException -> 0x02f4, TRY_ENTER, TRY_LEAVE, TryCatch #7 {IOException -> 0x02f4, blocks: (B:165:0x0340, B:156:0x032e, B:203:0x0406, B:194:0x03f5, B:130:0x02ef, B:121:0x02dd, B:187:0x03e8, B:114:0x02d0), top: B:239:0x000b, inners: #9, #23 }] */
        /* JADX WARN: Removed duplicated region for block: B:224:0x042d A[Catch: IOException -> 0x0431, TRY_ENTER, TRY_LEAVE, TryCatch #8 {IOException -> 0x0431, blocks: (B:224:0x042d, B:215:0x041c, B:208:0x040f), top: B:240:0x040d, inners: #26 }] */
        /* JADX WARN: Removed duplicated region for block: B:241:0x03e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:255:0x040f A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:263:0x0321 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:292:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:303:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:305:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:314:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:76:0x01fb A[Catch: IOException -> 0x01ff, TRY_ENTER, TRY_LEAVE, TryCatch #19 {IOException -> 0x01ff, blocks: (B:76:0x01fb, B:67:0x01ea), top: B:233:0x01db }] */
        /* JADX WARN: Type inference failed for: r19v0, types: [com.umeng.update.net.DownloadingService$b] */
        /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Exception] */
        /* JADX WARN: Type inference failed for: r2v16, types: [android.os.Handler] */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v70 */
        /* JADX WARN: Type inference failed for: r2v71 */
        /* JADX WARN: Type inference failed for: r2v72 */
        /* JADX WARN: Type inference failed for: r2v9, types: [java.io.IOException, java.lang.Exception] */
        /* JADX INFO: renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private void m8785a(boolean r20) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 1078
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.update.net.DownloadingService.C1635b.m8785a(boolean):void");
        }

        /* JADX INFO: renamed from: a */
        private void m8782a() throws Throwable {
            atj.m5427c(DownloadingService.f9269d, "wait for repeating Test network repeat count=" + this.f9291e);
            try {
                if (this.f9297k.f1312g) {
                    ajm.C0168b c0168b = (ajm.C0168b) DownloadingService.f9271j.get(this.f9295i);
                    c0168b.f1334f[0] = this.f9292f;
                    c0168b.f1334f[1] = this.f9293g;
                    c0168b.f1334f[2] = this.f9291e;
                    String strM1596a = ajp.m1596a(this.f9295i, "continue");
                    Intent intent = new Intent(this.f9288b, (Class<?>) DownloadingService.class);
                    intent.putExtra("com.umeng.broadcast.download.msg", strM1596a);
                    DownloadingService.this.f9276f.m1574a(DownloadingService.this, intent);
                    DownloadingService.this.m8767a(this.f9288b.getString(atq.m5454c(this.f9288b)));
                    atj.m5427c(DownloadingService.f9269d, "changed play state button on op-notification.");
                } else {
                    Thread.sleep(8000L);
                    if (this.f9293g < 1) {
                        m8785a(false);
                    } else {
                        m8785a(true);
                    }
                }
            } catch (InterruptedException e) {
                m8784a(e);
                DownloadingService.this.f9276f.m1576b(this.f9288b, this.f9295i);
            }
        }

        /* JADX INFO: renamed from: b */
        private void m8787b(int i) throws RemoteException {
            try {
                if (DownloadingService.f9270i.get(this.f9297k) != null) {
                    ((Messenger) DownloadingService.f9270i.get(this.f9297k)).send(Message.obtain(null, 3, i, 0));
                }
            } catch (DeadObjectException unused) {
                atj.m5425b(DownloadingService.f9269d, String.format("Service Client for downloading %1$15s is dead. Removing messenger from the service", this.f9297k.f1307b));
                DownloadingService.f9270i.put(this.f9297k, null);
            }
        }

        /* JADX INFO: renamed from: a */
        private HttpURLConnection m8781a(URL url, File file) throws ProtocolException {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod(SpdyRequest.GET_METHOD);
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.addRequestProperty("Connection", "keep-alive");
            httpURLConnection.setConnectTimeout(5000);
            httpURLConnection.setReadTimeout(10000);
            if (file.exists() && file.length() > 0) {
                atj.m5427c(DownloadingService.f9269d, String.format(this.f9297k.f1307b + " getFileLength: %1$15s", Long.valueOf(file.length())));
                httpURLConnection.setRequestProperty("Range", "bytes=" + file.length() + "-");
            }
            return httpURLConnection;
        }

        /* JADX INFO: renamed from: a */
        private String m8780a(ajk.C0161a c0161a) {
            String str;
            if (this.f9297k.f1310e != null) {
                str = this.f9297k.f1310e + ".apk.tmp";
            } else {
                str = ats.m5470a(this.f9297k.f1308c) + ".apk.tmp";
            }
            return this.f9297k.f1306a.equalsIgnoreCase("delta_update") ? str.replace(".apk", ".patch") : str;
        }

        /* JADX INFO: renamed from: b */
        private void m8786b() {
            if (this.f9297k.f1311f != null) {
                HashMap map = new HashMap();
                map.put("dsize", String.valueOf(this.f9293g));
                map.put("dtime", ats.m5468a().split(" ")[1]);
                map.put("ptimes", String.valueOf(this.f9291e));
                DownloadingService.this.f9276f.m1571a((Map<String, String>) map, true, this.f9297k.f1311f);
            }
        }

        /* JADX INFO: renamed from: a */
        private void m8783a(File file, String str) throws RemoteException {
            atj.m5427c(DownloadingService.f9269d, "itemMd5 " + this.f9297k.f1309d);
            atj.m5427c(DownloadingService.f9269d, "fileMd5 " + ats.m5469a(file));
            if (this.f9297k.f1309d == null || this.f9297k.f1309d.equalsIgnoreCase(ats.m5469a(file))) {
                return;
            }
            if (this.f9297k.f1306a.equalsIgnoreCase("delta_update")) {
                DownloadingService.this.f9275e.cancel(this.f9295i);
                Bundle bundle = new Bundle();
                bundle.putString("filename", str);
                Message messageObtain = Message.obtain();
                messageObtain.what = 5;
                messageObtain.arg1 = 3;
                messageObtain.arg2 = this.f9295i;
                messageObtain.setData(bundle);
                try {
                    if (DownloadingService.f9270i.get(this.f9297k) != null) {
                        ((Messenger) DownloadingService.f9270i.get(this.f9297k)).send(messageObtain);
                    }
                    DownloadingService.this.f9276f.m1576b(this.f9288b, this.f9295i);
                    return;
                } catch (RemoteException unused) {
                    DownloadingService.this.f9276f.m1576b(this.f9288b, this.f9295i);
                    return;
                }
            }
            ((Messenger) DownloadingService.f9270i.get(this.f9297k)).send(Message.obtain(null, 5, 0, 0));
            if (this.f9297k.f1313h) {
                return;
            }
            DownloadingService.this.f9276f.m1576b(this.f9288b, this.f9295i);
            Notification notification = new Notification(R.drawable.stat_sys_download_done, this.f9288b.getString(atq.m5460i(this.f9288b)), System.currentTimeMillis());
            PendingIntent activity = PendingIntent.getActivity(this.f9288b, 0, new Intent(), 0);
            notification.setLatestEventInfo(this.f9288b, ati.m5422j(this.f9288b), this.f9297k.f1307b + this.f9288b.getString(atq.m5460i(this.f9288b)), activity);
            notification.flags = notification.flags | 16;
            DownloadingService.this.f9275e.notify(this.f9295i, notification);
        }

        /* JADX INFO: renamed from: a */
        private void m8784a(Exception exc) {
            atj.m5425b(DownloadingService.f9269d, "can not install. " + exc.getMessage());
            if (this.f9296j != null) {
                this.f9296j.mo8777a(this.f9295i, exc);
            }
            DownloadingService.this.f9276f.m1568a(this.f9297k, this.f9292f, this.f9293g, this.f9291e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m8767a(final String str) {
        synchronized (f9272m) {
            if (!f9272m.booleanValue()) {
                atj.m5427c(f9269d, "show single toast.[" + str + "]");
                f9272m = true;
                this.f9278h.post(new Runnable() { // from class: com.umeng.update.net.DownloadingService.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(DownloadingService.this.f9277g, str, 0).show();
                    }
                });
                this.f9278h.postDelayed(new Runnable() { // from class: com.umeng.update.net.DownloadingService.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Boolean unused = DownloadingService.f9272m = false;
                    }
                }, 1200L);
            }
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        try {
            ajl.m1559a(getApplicationContext()).m1561a(259200);
            ajl.m1559a(getApplicationContext()).finalize();
        } catch (Exception e) {
            atj.m5425b(f9269d, e.getMessage());
        }
        super.onDestroy();
    }

    /* JADX INFO: renamed from: e */
    private void m8774e() {
        if (f9268b) {
            int size = f9270i.size();
            int size2 = f9271j.size();
            atj.m5423a(f9269d, "Client size =" + size + "   cacheSize = " + size2);
            if (size != size2) {
                throw new RuntimeException("Client size =" + size + "   cacheSize = " + size2);
            }
        }
    }
}
