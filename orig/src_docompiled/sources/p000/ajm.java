package p000;

import android.R;
import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import android.widget.Toast;
import com.umeng.message.MsgConstant;
import com.umeng.update.net.DownloadingService;
import com.umeng.update.net.DownloadingService.C1635b;
import com.umeng.update.util.DeltaUpdate;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import p000.ajk;

/* JADX INFO: compiled from: DownloadTool.java */
/* JADX INFO: loaded from: classes.dex */
public class ajm {

    /* JADX INFO: renamed from: a */
    private static final String f1321a = "ajm";

    /* JADX INFO: renamed from: b */
    private SparseArray<C0168b> f1322b;

    /* JADX INFO: renamed from: c */
    private Map<ajk.C0161a, Messenger> f1323c;

    /* JADX INFO: renamed from: d */
    private ajo f1324d;

    public ajm(SparseArray<C0168b> sparseArray, Map<ajk.C0161a, Messenger> map, ajo ajoVar) {
        this.f1322b = sparseArray;
        this.f1323c = map;
        this.f1324d = ajoVar;
    }

    /* JADX INFO: renamed from: ajm$b */
    /* JADX INFO: compiled from: DownloadTool.java */
    public static class C0168b {

        /* JADX INFO: renamed from: a */
        public DownloadingService.C1635b f1329a;

        /* JADX INFO: renamed from: b */
        public C0167a f1330b;

        /* JADX INFO: renamed from: c */
        int f1331c;

        /* JADX INFO: renamed from: d */
        int f1332d;

        /* JADX INFO: renamed from: e */
        public ajk.C0161a f1333e;

        /* JADX INFO: renamed from: f */
        public long[] f1334f = new long[3];

        public C0168b(ajk.C0161a c0161a, int i) {
            this.f1331c = i;
            this.f1333e = c0161a;
        }

        /* JADX INFO: renamed from: a */
        public void m1587a(SparseArray<C0168b> sparseArray) {
            sparseArray.put(this.f1331c, this);
        }

        /* JADX INFO: renamed from: b */
        public void m1588b(SparseArray<C0168b> sparseArray) {
            if (sparseArray.indexOfKey(this.f1331c) >= 0) {
                sparseArray.remove(this.f1331c);
            }
        }
    }

    /* JADX INFO: renamed from: ajm$a */
    /* JADX INFO: compiled from: DownloadTool.java */
    public static class C0167a extends ajr {
        public C0167a(Context context) {
            super(context);
        }

        /* JADX INFO: renamed from: a */
        public C0167a m1580a(RemoteViews remoteViews) {
            this.f1350c.contentView = remoteViews;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0167a m1581a(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f1351d.setContentText(charSequence);
            }
            this.f1350c.contentView.setTextViewText(ato.m5445a(this.f1349b), charSequence);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0167a m1584b(CharSequence charSequence) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f1351d.setContentTitle(charSequence);
            }
            this.f1350c.contentView.setTextViewText(ato.m5448d(this.f1349b), charSequence);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0167a m1578a(int i, int i2, boolean z) {
            if (Build.VERSION.SDK_INT >= 14) {
                this.f1351d.setProgress(i, i2, z);
            }
            this.f1350c.contentView.setProgressBar(ato.m5447c(this.f1349b), 100, i2, false);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0167a m1577a() {
            this.f1350c.contentView.setViewVisibility(ato.m5449e(this.f1349b), 8);
            this.f1350c.contentView.setViewVisibility(ato.m5450f(this.f1349b), 8);
            return this;
        }

        /* JADX INFO: renamed from: a */
        public C0167a m1579a(PendingIntent pendingIntent, PendingIntent pendingIntent2) {
            this.f1350c.contentView.setOnClickPendingIntent(ato.m5449e(this.f1349b), pendingIntent);
            this.f1350c.contentView.setViewVisibility(ato.m5449e(this.f1349b), 0);
            this.f1350c.contentView.setViewVisibility(ato.m5450f(this.f1349b), 0);
            this.f1350c.contentView.setOnClickPendingIntent(ato.m5450f(this.f1349b), pendingIntent2);
            return this;
        }

        /* JADX INFO: renamed from: b */
        public C0167a m1583b() {
            int iM5449e = ato.m5449e(this.f1349b);
            this.f1350c.contentView.setTextViewText(iM5449e, this.f1349b.getResources().getString(atq.m5456e(this.f1349b.getApplicationContext())));
            this.f1350c.contentView.setInt(iM5449e, "setBackgroundResource", atk.m5432a(this.f1349b).m5434b("umeng_common_gradient_green"));
            return this;
        }

        /* JADX INFO: renamed from: c */
        public C0167a m1585c() {
            int iM5449e = ato.m5449e(this.f1349b);
            this.f1350c.contentView.setTextViewText(iM5449e, this.f1349b.getResources().getString(atq.m5455d(this.f1349b.getApplicationContext())));
            this.f1350c.contentView.setInt(iM5449e, "setBackgroundResource", atk.m5432a(this.f1349b).m5434b("umeng_common_gradient_orange"));
            return this;
        }

        /* JADX INFO: renamed from: d */
        public Notification m1586d() {
            if (Build.VERSION.SDK_INT >= 16) {
                return this.f1351d.build();
            }
            if (Build.VERSION.SDK_INT >= 14) {
                return this.f1351d.getNotification();
            }
            return this.f1350c;
        }

        /* JADX INFO: renamed from: a */
        public void m1582a(int i, String str, PendingIntent pendingIntent) {
            if (Build.VERSION.SDK_INT >= 16) {
                this.f1351d.addAction(i, str, pendingIntent);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m1566a(ajk.C0161a c0161a) {
        return Math.abs((int) (((long) ((c0161a.f1307b.hashCode() >> 2) + (c0161a.f1308c.hashCode() >> 3))) + System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: a */
    public C0167a m1567a(Context context, ajk.C0161a c0161a, int i, int i2) {
        Context applicationContext = context.getApplicationContext();
        C0167a c0167a = new C0167a(applicationContext);
        c0167a.m1611d(applicationContext.getString(atq.m5461j(applicationContext))).m1605a(R.drawable.stat_sys_download).m1607a(PendingIntent.getActivity(applicationContext, 0, new Intent(), 134217728)).m1606a(System.currentTimeMillis());
        RemoteViews remoteViews = new RemoteViews(applicationContext.getPackageName(), atp.m5451a(applicationContext));
        if (Build.VERSION.SDK_INT >= 14) {
            int dimensionPixelSize = applicationContext.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_width);
            int dimensionPixelSize2 = applicationContext.getResources().getDimensionPixelSize(R.dimen.notification_large_icon_height);
            remoteViews.setInt(ato.m5446b(applicationContext), "setWidth", dimensionPixelSize);
            remoteViews.setInt(ato.m5446b(applicationContext), "setHeight", dimensionPixelSize2);
            try {
                Field declaredField = Class.forName("com.android.internal.R$drawable").getDeclaredField("notify_panel_notification_icon_bg_tile");
                declaredField.setAccessible(true);
                remoteViews.setInt(ato.m5446b(applicationContext), "setBackgroundResource", declaredField.getInt(null));
            } catch (Exception e) {
                atj.m5424a(f1321a, "No notification icon background found:", e);
            }
        } else {
            try {
                try {
                    Field declaredField2 = Class.forName("com.android.internal.R$drawable").getDeclaredField("status_bar_notification_icon_bg");
                    declaredField2.setAccessible(true);
                    remoteViews.setInt(ato.m5446b(applicationContext), "setBackgroundResource", declaredField2.getInt(null));
                } catch (Exception e2) {
                    atj.m5424a(f1321a, "No notification size found:", e2);
                }
            } catch (Exception unused) {
                Class<?> cls = Class.forName("com.android.internal.R$dimen");
                Field declaredField3 = cls.getDeclaredField("status_bar_edge_ignore");
                declaredField3.setAccessible(true);
                int dimensionPixelSize3 = applicationContext.getResources().getDimensionPixelSize(declaredField3.getInt(null)) + 0;
                Field declaredField4 = cls.getDeclaredField("status_bar_height");
                declaredField4.setAccessible(true);
                int i3 = declaredField4.getInt(null);
                remoteViews.setInt(ato.m5446b(applicationContext), "setWidth", dimensionPixelSize3 + applicationContext.getResources().getDimensionPixelSize(i3) + applicationContext.getResources().getDimensionPixelSize(i3));
            }
        }
        c0167a.m1580a(remoteViews);
        c0167a.m1584b(applicationContext.getResources().getString(atq.m5458g(applicationContext)) + c0161a.f1307b).m1581a(i2 + "%").m1578a(100, i2, false);
        if (c0161a.f1312g) {
            c0167a.m1609b(remoteViews);
            c0167a.m1612e();
            PendingIntent pendingIntentM1595a = ajp.m1595a(applicationContext, ajp.m1596a(i, "continue"));
            PendingIntent pendingIntentM1595a2 = ajp.m1595a(applicationContext, ajp.m1596a(i, "cancel"));
            m1570a(applicationContext, c0167a, i, 2);
            c0167a.m1579a(pendingIntentM1595a, pendingIntentM1595a2).m1585c().m1608a(true).m1610b(false);
        } else {
            c0167a.m1577a().m1608a(true).m1610b(false);
        }
        return c0167a;
    }

    /* JADX INFO: renamed from: a */
    void m1570a(Context context, C0167a c0167a, int i, int i2) {
        if (Build.VERSION.SDK_INT >= 16) {
            PendingIntent pendingIntentM1595a = ajp.m1595a(context, ajp.m1596a(i, "continue"));
            PendingIntent pendingIntentM1595a2 = ajp.m1595a(context, ajp.m1596a(i, "cancel"));
            switch (i2) {
                case 1:
                    c0167a.m1582a(R.drawable.ic_media_play, context.getResources().getString(atq.m5456e(context)), pendingIntentM1595a);
                    break;
                case 2:
                    c0167a.m1582a(R.drawable.ic_media_pause, context.getResources().getString(atq.m5455d(context)), pendingIntentM1595a);
                    break;
            }
            c0167a.m1582a(R.drawable.ic_menu_close_clear_cancel, context.getResources().getString(atq.m5457f(context)), pendingIntentM1595a2);
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1573a(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        String packageName = context.getPackageName();
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.equals(packageName)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1572a(ajk.C0161a c0161a, boolean z, Messenger messenger) {
        if (z) {
            int iNextInt = new Random().nextInt(1000);
            if (this.f1323c != null) {
                for (ajk.C0161a c0161a2 : this.f1323c.keySet()) {
                    atj.m5427c(f1321a, "_" + iNextInt + " downling  " + c0161a2.f1307b + "   " + c0161a2.f1308c);
                }
            } else {
                atj.m5427c(f1321a, "_" + iNextInt + "downling  null");
            }
        }
        if (this.f1323c == null) {
            return false;
        }
        for (ajk.C0161a c0161a3 : this.f1323c.keySet()) {
            if (c0161a.f1310e != null && c0161a.f1310e.equals(c0161a3.f1310e)) {
                this.f1323c.put(c0161a3, messenger);
                return true;
            }
            if (c0161a3.f1308c.equals(c0161a.f1308c)) {
                this.f1323c.put(c0161a3, messenger);
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: b */
    public int m1575b(ajk.C0161a c0161a) {
        for (int i = 0; i < this.f1322b.size(); i++) {
            int iKeyAt = this.f1322b.keyAt(i);
            if (c0161a.f1310e != null && c0161a.f1310e.equals(this.f1322b.get(iKeyAt).f1333e.f1310e)) {
                return this.f1322b.get(iKeyAt).f1331c;
            }
            if (this.f1322b.get(iKeyAt).f1333e.f1308c.equals(c0161a.f1308c)) {
                return this.f1322b.get(iKeyAt).f1331c;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    void m1569a(Context context, int i) {
        Context applicationContext = context.getApplicationContext();
        NotificationManager notificationManager = (NotificationManager) applicationContext.getSystemService("notification");
        C0168b c0168b = this.f1322b.get(i);
        c0168b.f1330b.m1612e();
        m1570a(applicationContext, c0168b.f1330b, i, 1);
        c0168b.f1330b.m1584b(applicationContext.getResources().getString(atq.m5459h(applicationContext)) + c0168b.f1333e.f1307b).m1583b().m1608a(false).m1610b(true);
        notificationManager.notify(i, c0168b.f1330b.m1586d());
    }

    /* JADX INFO: renamed from: b */
    public void m1576b(Context context, int i) {
        NotificationManager notificationManager = (NotificationManager) context.getApplicationContext().getSystemService("notification");
        C0168b c0168b = this.f1322b.get(i);
        if (c0168b != null) {
            atj.m5427c(f1321a, "download service clear cache " + c0168b.f1333e.f1307b);
            if (c0168b.f1329a != null) {
                c0168b.f1329a.m8788a(2);
            }
            notificationManager.cancel(c0168b.f1331c);
            if (this.f1323c.containsKey(c0168b.f1333e)) {
                this.f1323c.remove(c0168b.f1333e);
            }
            c0168b.m1588b(this.f1322b);
            this.f1324d.m1593b(i);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1568a(ajk.C0161a c0161a, long j, long j2, long j3) {
        if (c0161a.f1311f != null) {
            HashMap map = new HashMap();
            map.put("dsize", String.valueOf(j));
            map.put("dtime", ats.m5468a().split(" ")[1]);
            map.put("dpcent", String.valueOf((int) ((j2 > 0 ? j / j2 : 0.0f) * 100.0f)));
            map.put("ptimes", String.valueOf(j3));
            m1571a((Map<String, String>) map, false, c0161a.f1311f);
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m1571a(final Map<String, String> map, final boolean z, final String[] strArr) {
        new Thread(new Runnable() { // from class: ajm.1
            @Override // java.lang.Runnable
            public void run() {
                HttpResponse httpResponseExecute;
                int iNextInt = new Random().nextInt(1000);
                if (strArr == null) {
                    atj.m5423a(ajm.f1321a, iNextInt + "service report: urls is null");
                    return;
                }
                for (String str : strArr) {
                    String strM5468a = ats.m5468a();
                    String str2 = strM5468a.split(" ")[0];
                    String str3 = strM5468a.split(" ")[1];
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    StringBuilder sb = new StringBuilder(str);
                    sb.append("&data=");
                    sb.append(str2);
                    sb.append("&time=");
                    sb.append(str3);
                    sb.append("&ts=");
                    sb.append(jCurrentTimeMillis);
                    if (z) {
                        sb.append("&action_type=");
                        sb.append(1);
                    } else {
                        sb.append("&action_type=");
                        sb.append(-2);
                    }
                    if (map != null) {
                        for (String str4 : map.keySet()) {
                            sb.append("&");
                            sb.append(str4);
                            sb.append("=");
                            sb.append((String) map.get(str4));
                        }
                    }
                    try {
                        atj.m5423a(ajm.f1321a, iNextInt + ": service report:\tget: " + sb.toString());
                        HttpGet httpGet = new HttpGet(sb.toString());
                        BasicHttpParams basicHttpParams = new BasicHttpParams();
                        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
                        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
                        httpResponseExecute = new DefaultHttpClient(basicHttpParams).execute(httpGet);
                        atj.m5423a(ajm.f1321a, iNextInt + ": service report:status code:  " + httpResponseExecute.getStatusLine().getStatusCode());
                    } catch (ClientProtocolException e) {
                        atj.m5428c(ajm.f1321a, iNextInt + ": service report:\tClientProtocolException,Failed to send message." + str, e);
                    } catch (IOException e2) {
                        atj.m5428c(ajm.f1321a, iNextInt + ": service report:\tIOException,Failed to send message." + str, e2);
                    }
                    if (httpResponseExecute.getStatusLine().getStatusCode() == 200) {
                        return;
                    }
                }
            }
        }).start();
    }

    /* JADX INFO: renamed from: a */
    public boolean m1574a(DownloadingService downloadingService, Intent intent) {
        Context applicationContext;
        int i;
        String strTrim;
        try {
            applicationContext = downloadingService.getApplicationContext();
            String[] strArrSplit = intent.getExtras().getString("com.umeng.broadcast.download.msg").split(":");
            i = Integer.parseInt(strArrSplit[0]);
            strTrim = strArrSplit[1].trim();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (i != 0 && !TextUtils.isEmpty(strTrim) && this.f1322b.indexOfKey(i) >= 0) {
            C0168b c0168b = this.f1322b.get(i);
            DownloadingService.C1635b c1635b = c0168b.f1329a;
            if ("continue".equals(strTrim)) {
                if (c1635b == null) {
                    atj.m5427c(f1321a, "Receive action do play click.");
                    if (ati.m5413a(applicationContext, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) && !ati.m5417e(applicationContext)) {
                        Toast.makeText(applicationContext, applicationContext.getResources().getString(atq.m5452a(applicationContext.getApplicationContext())), 1).show();
                        return false;
                    }
                    downloadingService.getClass();
                    DownloadingService.C1635b c1635b2 = downloadingService.new C1635b(applicationContext, c0168b.f1333e, i, c0168b.f1332d, downloadingService.f9273a);
                    c0168b.f1329a = c1635b2;
                    c1635b2.start();
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 2;
                    messageObtain.arg1 = 7;
                    messageObtain.arg2 = i;
                    try {
                        if (this.f1323c.get(c0168b.f1333e) != null) {
                            this.f1323c.get(c0168b.f1333e).send(messageObtain);
                        }
                    } catch (RemoteException e2) {
                        atj.m5426b(f1321a, "", e2);
                    }
                    return true;
                }
                atj.m5427c(f1321a, "Receive action do play click.");
                c1635b.m8788a(1);
                c0168b.f1329a = null;
                m1569a(applicationContext, i);
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 2;
                messageObtain2.arg1 = 6;
                messageObtain2.arg2 = i;
                try {
                    if (this.f1323c.get(c0168b.f1333e) != null) {
                        this.f1323c.get(c0168b.f1333e).send(messageObtain2);
                    }
                } catch (RemoteException e3) {
                    atj.m5426b(f1321a, "", e3);
                }
                return true;
            }
            if ("cancel".equals(strTrim)) {
                atj.m5427c(f1321a, "Receive action do stop click.");
                try {
                    try {
                        try {
                            if (c1635b != null) {
                                c1635b.m8788a(2);
                            } else {
                                m1568a(c0168b.f1333e, c0168b.f1334f[0], c0168b.f1334f[1], c0168b.f1334f[2]);
                            }
                            Message messageObtain3 = Message.obtain();
                            messageObtain3.what = 5;
                            messageObtain3.arg1 = 5;
                            messageObtain3.arg2 = i;
                            if (this.f1323c.get(c0168b.f1333e) != null) {
                                this.f1323c.get(c0168b.f1333e).send(messageObtain3);
                            }
                            m1576b(applicationContext, i);
                        } catch (RemoteException unused) {
                            m1576b(applicationContext, i);
                        }
                    } catch (Exception unused2) {
                        Message messageObtain4 = Message.obtain();
                        messageObtain4.what = 5;
                        messageObtain4.arg1 = 5;
                        messageObtain4.arg2 = i;
                        if (this.f1323c.get(c0168b.f1333e) != null) {
                            this.f1323c.get(c0168b.f1333e).send(messageObtain4);
                        }
                        m1576b(applicationContext, i);
                    }
                    return true;
                } finally {
                }
            }
            e.printStackTrace();
        }
        return false;
    }

    /* JADX INFO: renamed from: ajm$c */
    /* JADX INFO: compiled from: DownloadTool.java */
    public class AsyncTaskC0169c extends AsyncTask<String, Void, Integer> {

        /* JADX INFO: renamed from: a */
        public int f1335a;

        /* JADX INFO: renamed from: b */
        public String f1336b;

        /* JADX INFO: renamed from: d */
        private ajk.C0161a f1338d;

        /* JADX INFO: renamed from: e */
        private Context f1339e;

        /* JADX INFO: renamed from: f */
        private NotificationManager f1340f;

        public AsyncTaskC0169c(Context context, int i, ajk.C0161a c0161a, String str) {
            this.f1339e = context.getApplicationContext();
            this.f1340f = (NotificationManager) this.f1339e.getSystemService("notification");
            this.f1335a = i;
            this.f1338d = c0161a;
            this.f1336b = str;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            super.onPreExecute();
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Integer doInBackground(String... strArr) {
            int iM8789a = DeltaUpdate.m8789a(strArr[0], strArr[1], strArr[2]) + 1;
            new File(strArr[2]).delete();
            if (iM8789a != 1) {
                atj.m5423a(ajm.f1321a, "file patch error");
            } else {
                if (!ats.m5469a(new File(strArr[1])).equalsIgnoreCase(this.f1338d.f1310e)) {
                    atj.m5423a(ajm.f1321a, "file patch error");
                    return 0;
                }
                atj.m5423a(ajm.f1321a, "file patch success");
            }
            return Integer.valueOf(iM8789a);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // android.os.AsyncTask
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onPostExecute(Integer num) {
            if (num.intValue() == 1) {
                ajq.m1603a(this.f1336b, 39, -1, -1);
                Notification notification = new Notification(R.drawable.stat_sys_download_done, this.f1339e.getString(atq.m5463l(this.f1339e)), System.currentTimeMillis());
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(268435456);
                intent.setDataAndType(Uri.fromFile(new File(this.f1336b)), "application/vnd.android.package-archive");
                notification.setLatestEventInfo(this.f1339e, ati.m5422j(this.f1339e), this.f1339e.getString(atq.m5463l(this.f1339e)), PendingIntent.getActivity(this.f1339e, 0, intent, 134217728));
                notification.flags = 16;
                this.f1340f.notify(this.f1335a + 1, notification);
                if (ajm.this.m1573a(this.f1339e) && !this.f1338d.f1313h) {
                    this.f1340f.cancel(this.f1335a + 1);
                    this.f1339e.startActivity(intent);
                }
                Bundle bundle = new Bundle();
                bundle.putString("filename", this.f1336b);
                Message messageObtain = Message.obtain();
                messageObtain.what = 5;
                messageObtain.arg1 = 1;
                messageObtain.arg2 = this.f1335a;
                messageObtain.setData(bundle);
                try {
                    if (ajm.this.f1323c.get(this.f1338d) != null) {
                        ((Messenger) ajm.this.f1323c.get(this.f1338d)).send(messageObtain);
                    }
                    ajm.this.m1576b(this.f1339e, this.f1335a);
                    return;
                } catch (RemoteException unused) {
                    ajm.this.m1576b(this.f1339e, this.f1335a);
                    return;
                }
            }
            this.f1340f.cancel(this.f1335a + 1);
            Bundle bundle2 = new Bundle();
            bundle2.putString("filename", this.f1336b);
            Message messageObtain2 = Message.obtain();
            messageObtain2.what = 5;
            messageObtain2.arg1 = 3;
            messageObtain2.arg2 = this.f1335a;
            messageObtain2.setData(bundle2);
            try {
                if (ajm.this.f1323c.get(this.f1338d) != null) {
                    ((Messenger) ajm.this.f1323c.get(this.f1338d)).send(messageObtain2);
                }
                ajm.this.m1576b(this.f1339e, this.f1335a);
            } catch (RemoteException unused2) {
                ajm.this.m1576b(this.f1339e, this.f1335a);
            }
        }
    }
}
