package p000;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.text.TextUtils;
import android.util.Log;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: AbsMessage.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class aiy {

    /* JADX INFO: renamed from: f */
    private static final Lock f1207f = new ReentrantLock();

    /* JADX INFO: renamed from: a */
    protected volatile aiz f1208a;

    /* JADX INFO: renamed from: b */
    protected volatile Context f1209b;

    /* JADX INFO: renamed from: c */
    protected volatile String f1210c;

    /* JADX INFO: renamed from: d */
    protected volatile String f1211d;

    /* JADX INFO: renamed from: e */
    protected volatile String f1212e;

    /* JADX INFO: renamed from: g */
    private volatile String f1213g;

    /* JADX INFO: renamed from: h */
    private volatile HandlerC0148a f1214h;

    /* JADX INFO: renamed from: j */
    private volatile AlarmManager f1216j;

    /* JADX INFO: renamed from: i */
    private volatile IntentFilter f1215i = null;

    /* JADX INFO: renamed from: k */
    private final BroadcastReceiver f1217k = new BroadcastReceiver() { // from class: aiy.1
        @Override // android.content.BroadcastReceiver
        public final void onReceive(Context context, Intent intent) {
            Bundle resultExtras;
            try {
                final Intent intent2 = new Intent();
                if (isOrderedBroadcast() && (resultExtras = getResultExtras(true)) != null) {
                    intent2.putExtras(resultExtras);
                    setResultExtras(null);
                }
                if (intent.getExtras() != null) {
                    intent2.putExtras(intent.getExtras());
                }
                String str = intent.getPackage();
                if (!TextUtils.isEmpty(str)) {
                    intent2.setPackage(str);
                }
                if (!TextUtils.isEmpty(intent.getAction())) {
                    intent2.setAction(intent.getAction());
                }
                aif.m1311a(new Runnable() { // from class: aiy.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Message messageObtainMessage;
                        if (aiy.this.f1214h == null || (messageObtainMessage = aiy.this.f1214h.obtainMessage()) == null || aiy.this.f1214h == null) {
                            return;
                        }
                        messageObtainMessage.obj = intent2;
                        aiy.this.f1214h.sendMessage(messageObtainMessage);
                    }
                });
            } catch (Throwable th) {
                Log.d("AbsMessage", "taskBroadcastReceiver onReceive error=" + th);
            }
        }
    };

    /* JADX INFO: renamed from: l */
    private volatile boolean f1218l = false;

    /* JADX INFO: renamed from: a */
    public abstract void mo1222a(Context context, Intent intent);

    protected aiy(Context context, aiz aizVar) {
        this.f1214h = null;
        this.f1216j = null;
        try {
            this.f1209b = context;
            this.f1208a = aizVar;
            this.f1216j = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            HandlerThread handlerThread = new HandlerThread("IntentService[timeThread]");
            handlerThread.start();
            this.f1214h = new HandlerC0148a(handlerThread.getLooper());
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public void m1447b(String str) {
        this.f1211d = str;
    }

    /* JADX INFO: renamed from: g */
    protected String m1454g() {
        return this.f1211d;
    }

    /* JADX INFO: renamed from: c */
    public void m1450c(String str) {
        this.f1210c = str;
    }

    /* JADX INFO: renamed from: h */
    protected String m1455h() {
        return this.f1210c;
    }

    /* JADX INFO: renamed from: d */
    public void m1451d(String str) {
        this.f1212e = str;
    }

    /* JADX INFO: renamed from: e */
    public void m1452e(String str) {
        this.f1213g = str;
    }

    /* JADX INFO: renamed from: i */
    public String m1456i() {
        return this.f1213g;
    }

    /* JADX INFO: renamed from: a */
    protected void m1444a(String str, Bundle bundle) {
        this.f1208a.onHandleMessage(str, bundle);
    }

    /* JADX INFO: renamed from: a */
    public void m1443a(String str, long j) {
        m1445a(str, null, j);
    }

    /* JADX INFO: renamed from: a */
    public void m1445a(String str, Bundle bundle, long j) {
        try {
            f1207f.lock();
            if (!TextUtils.isEmpty(str)) {
                Intent intent = new Intent(str);
                if (bundle != null) {
                    String string = bundle.getString("CONNECT_STATE");
                    if (!TextUtils.isEmpty(string)) {
                        aiv.m1418c("AbsMessage", "startTaskAtDelayed[" + str + "][" + string + "]");
                    }
                    intent.putExtras(bundle);
                } else {
                    aiv.m1418c("AbsMessage", "startTaskAtDelayed[" + str + "]");
                }
                intent.setPackage(this.f1209b.getPackageName());
                this.f1216j.set(1, System.currentTimeMillis() + j, PendingIntent.getBroadcast(this.f1209b, str.hashCode(), intent, 268435456));
            }
        } catch (Throwable th) {
            f1207f.unlock();
            throw th;
        }
        f1207f.unlock();
    }

    /* JADX INFO: renamed from: b */
    public void m1448b(String str, long j) {
        m1449b(str, null, j);
    }

    /* JADX INFO: renamed from: b */
    public void m1449b(String str, Bundle bundle, long j) {
        try {
            try {
                f1207f.lock();
                if (!TextUtils.isEmpty(str)) {
                    aiv.m1418c("AbsMessage", "startTaskRepeating[" + str + "]");
                    Intent intent = new Intent(str);
                    if (bundle != null) {
                        intent.putExtras(bundle);
                    }
                    intent.setPackage(this.f1209b.getPackageName());
                    this.f1216j.setRepeating(1, System.currentTimeMillis() + j, j, PendingIntent.getBroadcast(this.f1209b, str.hashCode(), intent, 268435456));
                }
            } catch (Throwable th) {
                aiv.m1419c("AbsMessage", "onStartRepeating", th);
            }
        } finally {
            f1207f.unlock();
        }
    }

    /* JADX INFO: renamed from: f */
    public void m1453f(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            Intent intent = new Intent(str);
            intent.setPackage(this.f1209b.getPackageName());
            String stringExtra = intent.getStringExtra("CONNECT_STATE");
            if (TextUtils.isEmpty(stringExtra)) {
                aiv.m1412a("AbsMessage", "stopTask action[" + str + "]");
            } else {
                aiv.m1412a("AbsMessage", "stopTask action[" + str + "][" + stringExtra + "]");
            }
            PendingIntent broadcast = PendingIntent.getBroadcast(this.f1209b, str.hashCode(), intent, 268435456);
            this.f1216j.cancel(broadcast);
            broadcast.cancel();
        } catch (Throwable th) {
            aiv.m1419c("AbsMessage", "stopTask", th);
        }
    }

    /* JADX INFO: renamed from: aiy$a */
    /* JADX INFO: compiled from: AbsMessage.java */
    final class HandlerC0148a extends Handler {
        public HandlerC0148a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            try {
                aiy.f1207f.lock();
                aiy.this.mo1222a(aiy.this.f1209b, (Intent) message.obj);
            } catch (Throwable th) {
                aiy.f1207f.unlock();
                throw th;
            }
            aiy.f1207f.unlock();
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m1446a(String... strArr) {
        if (this.f1209b == null || this.f1218l) {
            return;
        }
        try {
            this.f1215i = new IntentFilter();
            this.f1215i.setPriority(NotificationManagerCompat.IMPORTANCE_UNSPECIFIED);
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    this.f1215i.addAction(str);
                }
            }
            this.f1209b.registerReceiver(this.f1217k, this.f1215i);
            this.f1218l = true;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: j */
    protected void m1457j() {
        try {
            if (this.f1209b != null && this.f1218l) {
                this.f1209b.unregisterReceiver(this.f1217k);
            }
            if (this.f1214h != null) {
                this.f1214h = null;
            }
            this.f1218l = false;
        } catch (Throwable unused) {
        }
    }
}
