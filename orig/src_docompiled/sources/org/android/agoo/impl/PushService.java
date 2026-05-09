package org.android.agoo.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.android.agoo.service.IMessageService;
import org.android.agoo.service.SendMessage;
import p000.aho;
import p000.ahr;
import p000.ahu;
import p000.ahx;
import p000.aif;
import p000.aiq;
import p000.ais;
import p000.aiv;
import p000.aiz;
import p000.apo;
import p000.apr;
import p000.apu;
import p000.apw;
import p000.aqc;
import p000.aqj;

/* JADX INFO: loaded from: classes.dex */
public class PushService implements aiz, Handler.Callback, apr {

    /* JADX INFO: renamed from: o */
    private static ahr f11987o;

    /* JADX INFO: renamed from: a */
    private Context f11988a;

    /* JADX INFO: renamed from: g */
    private aho f11994g;

    /* JADX INFO: renamed from: h */
    private long f11995h;

    /* JADX INFO: renamed from: b */
    private HandlerThread f11989b = null;

    /* JADX INFO: renamed from: c */
    private Handler f11990c = null;

    /* JADX INFO: renamed from: d */
    private boolean f11991d = false;

    /* JADX INFO: renamed from: e */
    private PendingIntent f11992e = null;

    /* JADX INFO: renamed from: f */
    private boolean f11993f = false;

    /* JADX INFO: renamed from: i */
    private AlarmManager f11996i = null;

    /* JADX INFO: renamed from: j */
    private String f11997j = null;

    /* JADX INFO: renamed from: k */
    private String f11998k = null;

    /* JADX INFO: renamed from: l */
    private String f11999l = null;

    /* JADX INFO: renamed from: m */
    private String f12000m = null;

    /* JADX INFO: renamed from: n */
    private final AtomicBoolean f12001n = new AtomicBoolean(false);

    /* JADX INFO: renamed from: p */
    private volatile apw f12002p = null;

    /* JADX INFO: renamed from: q */
    private final BroadcastReceiver f12003q = new BroadcastReceiver() { // from class: org.android.agoo.impl.PushService.2
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                if (TextUtils.equals("agoo_action_re_election", intent.getAction())) {
                    PushService.this.f11990c.sendEmptyMessage(5);
                }
            } catch (Throwable th) {
                aiv.m1421d("PushService", "onReceive", th);
            }
        }
    };

    /* JADX INFO: renamed from: r */
    private final IMessageService.Stub f12004r = new IMessageService.Stub() { // from class: org.android.agoo.impl.PushService.3
        @Override // org.android.agoo.service.IMessageService
        public boolean ping() {
            return true;
        }

        @Override // org.android.agoo.service.IMessageService
        public void probe() {
            aiv.m1418c("PushService", "messageServiceBinder [probe]");
            aif.m1311a(new Runnable() { // from class: org.android.agoo.impl.PushService.3.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (apu.m4943m(PushService.this.f11988a)) {
                            String strM10992a = C2000a.m10992a(PushService.this.f11988a);
                            if (!TextUtils.isEmpty(strM10992a) || TextUtils.equals(PushService.this.f11988a.getPackageName(), strM10992a)) {
                                if (PushService.this.f11994g != null && PushService.this.f11994g.m1226b()) {
                                    aiv.m1418c("PushService", "messageServiceBinder [probe][successfully]");
                                    return;
                                }
                                PushService.this.onHandleCommand("command_restart_sudo");
                                aiv.m1418c("PushService", "messageServiceBinder [probe][restart_sudo]");
                                return;
                            }
                            PushService.this.onHandleError("ERROR_NEED_ELECTION");
                            aiv.m1418c("PushService", "messageServiceBinder [probe][need_election]");
                            return;
                        }
                        aiv.m1418c("PushService", "messageServiceBinder [probe][deviceToken==null]");
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    };

    /* JADX INFO: renamed from: a */
    private static final int m10967a(int i, int i2) {
        return (i & 255) | ((i2 & 65535) << 16) | 0;
    }

    @Override // p000.aps
    public boolean unbind(Intent intent) {
        return false;
    }

    @Override // p000.aps
    public IBinder bind(Intent intent) {
        String action = intent.getAction();
        Set<String> categories = intent.getCategories();
        StringBuilder sb = new StringBuilder();
        sb.append("onBind:[");
        sb.append(action);
        sb.append("],intent categries[");
        sb.append((categories == null || categories.isEmpty()) ? null : categories.toString());
        sb.append("]");
        aiv.m1418c("PushService", sb.toString());
        if (TextUtils.isEmpty(action) || !TextUtils.equals(action, "org.agoo.android.intent.action.PING_V4") || categories == null || categories.isEmpty() || !categories.contains(apo.m4898k(this.f11988a))) {
            return null;
        }
        return this.f12004r;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x008c  */
    @Override // p000.aps
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void destroy(android.content.Context r6) {
        /*
            Method dump skipped, instruction units count: 206
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.impl.PushService.destroy(android.content.Context):void");
    }

    @Override // p000.aps
    public int startCommand(Intent intent, int i, int i2) {
        if (intent == null) {
            this.f11990c.sendEmptyMessage(4);
            return 1;
        }
        Message messageObtain = Message.obtain();
        messageObtain.arg1 = i;
        messageObtain.arg2 = i2;
        messageObtain.obj = intent;
        if (hasComeFromCock(intent)) {
            messageObtain.what = 3;
            this.f11990c.sendMessage(messageObtain);
            return 1;
        }
        messageObtain.what = 2;
        this.f11990c.sendMessage(messageObtain);
        if (aiq.m1371a(this.f11988a)) {
            String stringExtra = intent.getStringExtra("eventId");
            Log.d("PushService", "pushService startCommand,eventId=" + stringExtra + "_Success");
            if (!TextUtils.isEmpty(stringExtra)) {
                new aqj(this.f11988a, stringExtra + "_Success").m5023a(apo.m4909v(this.f11988a));
            }
        }
        return 1;
    }

    /* JADX INFO: renamed from: a */
    private void m10970a(Intent intent, int i, int i2) {
        try {
            String action = intent.getAction();
            String strM4991c = aqc.m4991c(this.f11988a);
            aiv.m1418c("PushService", "action [" + action + "]");
            if (TextUtils.equals(action, strM4991c)) {
                String stringExtra = intent.getStringExtra("method");
                if (!TextUtils.isEmpty(stringExtra) && TextUtils.equals(stringExtra, "stop")) {
                    m10983c();
                    return;
                }
                if (TextUtils.isEmpty(stringExtra) || !TextUtils.equals(stringExtra, "start")) {
                    return;
                }
                if (m10978e()) {
                    m10974b((String) null);
                } else {
                    m10983c();
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aps
    public void create(Context context, apw apwVar) {
        try {
            Log.w("PushService", ">>> agoo system is creating >>>");
            ahu.m1268a(context, "agoo.pid");
            f11987o = ahr.m1246a(context, 600, false);
            this.f11988a = context;
            aiv.m1411a(this.f11988a);
            ais.m1377a(this.f11988a);
            this.f11991d = true;
            this.f11989b = new HandlerThread("se-service");
            this.f11989b.start();
            this.f11990c = new Handler(this.f11989b.getLooper(), this);
            String packageName = context.getPackageName();
            Log.w("PushService", "create currentPack=" + packageName);
            Log.w("PushService", "getCurrentSudo(context)" + C2000a.m10992a(context));
            boolean zEquals = packageName.equals(C2000a.m10992a(context));
            Log.w("PushService", packageName + ",  " + zEquals);
            if (zEquals) {
                f11987o.m1261a();
            }
            this.f12002p = apwVar;
            this.f11996i = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (!this.f12001n.get()) {
                this.f12001n.set(true);
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("agoo_action_re_election");
                this.f11988a.registerReceiver(this.f12003q, intentFilter);
            }
            m10977d();
        } catch (Throwable th) {
            aiv.m1419c("PushService", "create", th);
        }
    }

    /* JADX INFO: renamed from: d */
    private void m10977d() {
        try {
            this.f11995h = System.currentTimeMillis();
            this.f11994g = new aho(this.f11988a, this);
        } catch (Throwable th) {
            aiv.m1419c("PushService", "initMessage", th);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        try {
            switch (message.what) {
                case 0:
                    m10969a(this.f11988a);
                    break;
                case 1:
                    m10973b(this.f11988a);
                    this.f12002p.stop();
                    break;
                case 2:
                    m10969a(this.f11988a);
                    m10970a((Intent) message.obj, message.arg1, message.arg2);
                    break;
                case 3:
                    ahr.m1252b(this.f11988a);
                    m10969a(this.f11988a);
                    m10982b();
                    break;
                case 4:
                    m10969a(this.f11988a);
                    m10981a();
                    break;
                case 5:
                    onHandleError("ERROR_NEED_ELECTION");
                    this.f11993f = false;
                    break;
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: e */
    private boolean m10978e() {
        try {
            if (this.f11988a == null) {
                aiv.m1418c("PushService", "mContext == null");
                return false;
            }
            this.f11997j = apu.m4936f(this.f11988a);
            if (TextUtils.isEmpty(this.f11997j)) {
                onHandleError("ERROR_APPKEY_NULL");
                return false;
            }
            this.f11999l = apu.m4938h(this.f11988a);
            if (TextUtils.isEmpty(this.f11999l)) {
                onHandleError("ERROR_TTID_NULL");
                return false;
            }
            this.f11998k = apu.m4940j(this.f11988a);
            this.f12000m = apu.m4944n(this.f11988a);
            if (TextUtils.isEmpty(this.f12000m)) {
                onHandleError("ERROR_DEVICETOKEN_NULL");
                return false;
            }
            if (this.f11994g == null) {
                m10977d();
            }
            this.f11994g.m1450c(this.f11997j);
            this.f11994g.m1447b(this.f11998k);
            this.f11994g.m1451d(this.f11999l);
            this.f11994g.m1452e(this.f12000m);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    protected void m10981a() {
        try {
            ais.m1391d(this.f11988a);
            String strM10992a = C2000a.m10992a(this.f11988a);
            new aqj(this.f11988a, "androidSystem").m5023a(apo.m4909v(this.f11988a));
            ais.m1387b(this.f11988a, strM10992a, "androidSystem");
            if (m10979f()) {
                onHandleError("ERROR_NEED_ELECTION");
                m10983c();
            } else if (!m10978e()) {
                m10983c();
            } else {
                m10974b("androidSystemSuccess");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m10982b() {
        try {
            String strM10992a = C2000a.m10992a(this.f11988a);
            ais.m1391d(this.f11988a);
            aqj aqjVar = new aqj(this.f11988a, "hasComeFromCock");
            LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11988a);
            linkedHashMapM4909v.put("currentSudoPack", strM10992a);
            aqjVar.m5023a(linkedHashMapM4909v);
            ais.m1387b(this.f11988a, strM10992a, "hasComeFromCock");
            if (m10979f()) {
                onHandleError("ERROR_NEED_ELECTION");
                m10983c();
            } else if (!m10978e()) {
                m10983c();
            } else {
                m10974b("hasComeFromCock");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: f */
    private boolean m10979f() {
        try {
            if (!apu.m4943m(this.f11988a)) {
                return true;
            }
            String strM10992a = C2000a.m10992a(this.f11988a);
            if (TextUtils.isEmpty(strM10992a)) {
                aiv.m1418c("PushService", "[currentSudoPack==null]");
                return true;
            }
            if (TextUtils.equals(this.f11988a.getPackageName(), strM10992a)) {
                return false;
            }
            aiv.m1418c("PushService", "[currentSudoPack(" + strM10992a + ")!=appPackage(" + this.f11988a.getPackageName() + ")]");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m10971a(String str) {
        try {
            if (this.f11993f) {
                return;
            }
            this.f11993f = true;
            Intent intent = new Intent("agoo_action_re_election");
            intent.setPackage(this.f11988a.getPackageName());
            intent.putExtra("eventId", str);
            long jCurrentTimeMillis = System.currentTimeMillis() + (((long) (new Random().nextInt(120) + 1320)) * 60 * 1000);
            long jM4947q = apu.m4947q(this.f11988a);
            if (jM4947q > System.currentTimeMillis() + 1800000) {
                jCurrentTimeMillis = jM4947q;
            }
            this.f11996i = (AlarmManager) this.f11988a.getSystemService(NotificationCompat.CATEGORY_ALARM);
            if (this.f11992e != null) {
                this.f11992e.cancel();
                this.f11996i.cancel(this.f11992e);
            }
            this.f11992e = PendingIntent.getBroadcast(this.f11988a, 45613913, intent, 134217728);
            aiv.m1418c("PushService", "election next time[current-thread-name:" + Thread.currentThread().getName() + "][" + ahx.m1279a(jCurrentTimeMillis) + "][timeout:" + jM4947q + "] ");
            this.f11996i.set(1, jCurrentTimeMillis, this.f11992e);
        } catch (Throwable th) {
            aiv.m1421d("PushService", "ReElection start", th);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m10974b(String str) {
        try {
            if (this.f11994g != null) {
                this.f11994g.m1221a();
            }
            m10971a(str);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: g */
    private final void m10980g() {
        try {
            if (this.f11988a != null) {
                long jCurrentTimeMillis = System.currentTimeMillis() + 60000;
                String strM4991c = aqc.m4991c(this.f11988a);
                if (TextUtils.isEmpty(strM4991c)) {
                    aiv.m1412a("PushService", "action==null");
                    return;
                }
                aiv.m1412a("PushService", "handleDestroyService [" + ahx.m1279a(jCurrentTimeMillis) + "][" + strM4991c + ":restart]");
                AlarmManager alarmManager = (AlarmManager) this.f11988a.getSystemService(NotificationCompat.CATEGORY_ALARM);
                Intent intent = new Intent();
                intent.setAction(strM4991c);
                intent.setPackage(this.f11988a.getPackageName());
                intent.putExtra("method", "start");
                intent.putExtra("eventId", "handleDestroyService");
                intent.addFlags(32);
                intent.addFlags(268435456);
                alarmManager.set(1, jCurrentTimeMillis, PendingIntent.getService(this.f11988a, 0, intent, 134217728));
            }
        } catch (Throwable th) {
            aiv.m1421d("PushService", "handleDestroyService", th);
        }
    }

    public boolean hasComeFromCock(Intent intent) {
        try {
            if (!this.f11988a.getPackageName().equals(C2000a.m10992a(this.f11988a))) {
                m10983c();
            }
            if (intent == null) {
                aiv.m1418c("PushService", "hasComeFromCock[intent==null]");
                return false;
            }
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("cockroach");
            if (!TextUtils.isEmpty(stringExtra) && TextUtils.equals(stringExtra, "cockroach-PPreotect")) {
                String stringExtra2 = intent.getStringExtra("pack");
                if (!TextUtils.isEmpty(stringExtra2) && TextUtils.equals(stringExtra2, this.f11988a.getPackageName())) {
                    aiv.m1418c("PushService", "hasComeFromCock[" + action + "] [" + stringExtra2 + "==" + this.f11988a.getPackageName() + "]");
                    return true;
                }
                aiv.m1418c("PushService", "hasComeFromCock[pack==null] or [" + stringExtra2 + "!=" + this.f11988a.getPackageName() + "]");
                return false;
            }
            aiv.m1418c("PushService", "hasComeFromCock[cockroach==null]or[cockroach!=" + stringExtra + "]");
            return false;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: c */
    protected final void m10983c() {
        try {
            this.f11991d = false;
            if (this.f11990c != null) {
                this.f11990c.sendEmptyMessage(1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private static final void m10969a(Context context) {
        try {
            if (!apo.m4906s(context) || context == null) {
                return;
            }
            context.getPackageName();
            context.getClass().getName();
            m10967a(2, 60);
            aiv.m1418c("PushService", "registerNotKill--->[current-thread-name:" + Thread.currentThread().getName() + "][action:" + aqc.m4992d(context) + "]");
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private static final void m10973b(Context context) {
        try {
            if (apo.m4906s(context)) {
                f11987o.m1263b();
                aiv.m1418c("PushService", "unregisterNotKill--->[current-thread-name:" + Thread.currentThread().getName() + "]");
            }
        } catch (Throwable unused) {
        }
    }

    public void onHandleCommand(String str) {
        try {
            Intent intentM4988a = aqc.m4988a(this.f11988a, str);
            intentM4988a.setPackage(this.f11988a.getPackageName());
            this.f11988a.sendBroadcast(intentM4988a);
        } catch (Throwable th) {
            aiv.m1419c("PushService", "handleError", th);
        }
    }

    @Override // p000.aiz
    public void onHandleError(String str) {
        try {
            Intent intentM4988a = aqc.m4988a(this.f11988a, "error");
            intentM4988a.setPackage(this.f11988a.getPackageName());
            intentM4988a.putExtra("error", str);
            this.f11988a.sendBroadcast(intentM4988a);
        } catch (Throwable th) {
            aiv.m1419c("PushService", "handleError", th);
        }
    }

    @Override // p000.aiz
    public void onHandleMessage(String str, Bundle bundle) {
        try {
            aiv.m1418c("PushService", "onHandleMessage current tid:" + Thread.currentThread().getId());
            this.f11990c.post(new RunnableC1999b(str, bundle, this.f11994g));
        } catch (Throwable th) {
            aiv.m1421d("PushService", "handleMessage error >>", th);
        }
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.PushService$a */
    class ServiceConnectionC1998a implements ServiceConnection {

        /* JADX INFO: renamed from: b */
        private Intent f12010b;

        /* JADX INFO: renamed from: c */
        private aho f12011c;

        /* JADX INFO: renamed from: d */
        private String f12012d;

        /* JADX INFO: renamed from: e */
        private SendMessage f12013e;

        /* JADX INFO: renamed from: f */
        private ServiceConnection f12014f = this;

        public ServiceConnectionC1998a(String str, Intent intent, aho ahoVar) {
            this.f12012d = str;
            this.f12010b = intent;
            this.f12011c = ahoVar;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            aiv.m1418c("PushService", "MessageConnection disConnected");
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            aiv.m1418c("PushService", "MessageConnection conneted:" + componentName);
            this.f12013e = SendMessage.Stub.asInterface(iBinder);
            aiv.m1418c("PushService", "onConnected current tid:" + Thread.currentThread().getId());
            aiv.m1418c("PushService", "MessageConnection sent:" + this.f12010b);
            if (this.f12013e != null) {
                PushService.this.f11990c.post(new Runnable() { // from class: org.android.agoo.impl.PushService.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            try {
                                aiv.m1418c("PushService", "onConnected running tid:" + Thread.currentThread().getId());
                                ServiceConnectionC1998a.this.f12013e.doSend(ServiceConnectionC1998a.this.f12010b);
                            } catch (RemoteException e) {
                                aiv.m1421d("PushService", "send error", e);
                                aho ahoVar = ServiceConnectionC1998a.this.f12011c;
                                String str = ServiceConnectionC1998a.this.f12012d;
                                aho unused = ServiceConnectionC1998a.this.f12011c;
                                ahoVar.m1224a(str, (String) null, "14");
                            }
                        } finally {
                            aiv.m1418c("PushService", "send finish. close this connection");
                            ServiceConnectionC1998a.this.f12013e = null;
                            PushService.this.f11988a.unbindService(ServiceConnectionC1998a.this.f12014f);
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: renamed from: org.android.agoo.impl.PushService$b */
    class RunnableC1999b implements Runnable {

        /* JADX INFO: renamed from: b */
        private String f12017b;

        /* JADX INFO: renamed from: c */
        private Bundle f12018c;

        /* JADX INFO: renamed from: d */
        private aho f12019d;

        public RunnableC1999b(String str, Bundle bundle, aho ahoVar) {
            this.f12017b = str;
            this.f12018c = bundle;
            this.f12019d = ahoVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            aiv.m1418c("PushService", "running tid:" + Thread.currentThread().getId());
            Intent intent = new Intent();
            intent.setAction("org.agoo.android.intent.action.RECEIVE");
            intent.setPackage(this.f12017b);
            intent.putExtras(this.f12018c);
            intent.putExtra("type", "common-push");
            intent.putExtra("message_source", "apoll");
            intent.addFlags(32);
            aiv.m1418c("PushService", "cast intent:" + this.f12018c);
            PushService.this.f11988a.sendBroadcast(intent);
            Intent intent2 = new Intent("org.android.agoo.client.MessageReceiverService");
            intent2.setPackage(this.f12017b);
            aiv.m1418c("PushService", "this message pack:" + this.f12017b);
            aiv.m1418c("PushService", "start to service...");
            try {
                boolean zBindService = PushService.this.f11988a.bindService(intent2, PushService.this.new ServiceConnectionC1998a(this.f12018c.getString("i"), intent, this.f12019d), 17);
                aiv.m1418c("PushService", "start service ret:" + zBindService);
                if (zBindService) {
                    return;
                }
                aho ahoVar = this.f12019d;
                String string = this.f12018c.getString("id");
                aho ahoVar2 = this.f12019d;
                ahoVar.m1224a(string, (String) null, "14");
            } catch (Throwable th) {
                aiv.m1418c("PushService", "bindService error...e=" + th);
            }
        }
    }
}
