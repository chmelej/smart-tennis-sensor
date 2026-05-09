package org.android.agoo.impl;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.android.agoo.service.AgooService;
import org.android.agoo.service.IMessageService;
import org.json.JSONException;
import org.json.JSONObject;
import p000.ahp;
import p000.ahx;
import p000.aic;
import p000.aid;
import p000.aig;
import p000.aip;
import p000.aiq;
import p000.air;
import p000.ais;
import p000.aiv;
import p000.apo;
import p000.app;
import p000.apu;
import p000.apv;
import p000.apx;
import p000.aqc;
import p000.aqj;
import p000.aqz;
import p000.arb;
import p000.arf;
import p000.arg;

/* JADX INFO: loaded from: classes.dex */
public final class ControlService implements app {

    /* JADX INFO: renamed from: a */
    private static final Random f11977a = new Random();

    /* JADX INFO: renamed from: c */
    private static final aqz f11978c = new arf();

    /* JADX INFO: renamed from: b */
    private Context f11979b = null;

    /* JADX INFO: renamed from: d */
    private final ServiceConnection f11980d = new ServiceConnection() { // from class: org.android.agoo.impl.ControlService.1
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IMessageService iMessageServiceAsInterface;
            try {
                iMessageServiceAsInterface = IMessageService.Stub.asInterface(iBinder);
            } catch (Throwable unused) {
                iMessageServiceAsInterface = null;
            }
            if (iMessageServiceAsInterface != null) {
                try {
                    aiv.m1420d("ControlService", "messageService.proble");
                    iMessageServiceAsInterface.probe();
                } catch (Throwable th) {
                    aiv.m1419c("ControlService", "messageConnection", th);
                }
            }
            try {
                if (ControlService.this.f11979b != null) {
                    aiv.m1418c("ControlService", "messageConnection [unbind]");
                    ControlService.this.f11979b.unbindService(ControlService.this.f11980d);
                }
            } catch (Throwable th2) {
                aiv.m1419c("ControlService", "messageDisconnected", th2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            aiv.m1418c("ControlService", "messageDisconnectedon ServiceDisconnected");
        }
    };

    /* JADX INFO: renamed from: e */
    private final ServiceConnection f11981e = new ServiceConnection() { // from class: org.android.agoo.impl.ControlService.2
        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                aig aigVarM1313a = aig.AbstractBinderC0117a.m1313a(iBinder);
                long jCurrentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("packageName", ControlService.this.f11979b.getPackageName());
                jSONObject.put("data", "");
                jSONObject.put("from", "agoo");
                aigVarM1313a.mo1312a(jSONObject.toString());
                Log.d("ControlService", "ippConnection target time[" + (System.currentTimeMillis() - jCurrentTimeMillis) + "]");
            } catch (Throwable th) {
                Log.d("ControlService", "ippConnection", th);
            }
            try {
                if (ControlService.this.f11979b != null) {
                    Log.d("ControlService", "ippConnection [unbind]");
                    ControlService.this.f11979b.unbindService(ControlService.this.f11981e);
                }
            } catch (Throwable th2) {
                Log.w("ControlService", "ippConnection", th2);
            }
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName componentName) {
            Log.d("ControlService", "ippConnection onServiceDisconnected  ");
        }
    };

    /* JADX INFO: renamed from: a */
    private final void m10934a(Context context, Intent intent, apv apvVar) throws Throwable {
        if (!m10944a(context, apvVar)) {
            aiv.m1418c("ControlService", "handleWake[" + context.getPackageName() + "]--->[appkey==null,appSecret==null,ttid==null]");
            return;
        }
        if (!apu.m4943m(context)) {
            int iM4951u = apu.m4951u(context);
            StringBuilder sb = new StringBuilder();
            sb.append("handleRetryRegister begin,retryCount = ");
            sb.append(iM4951u);
            sb.append("isRetryRegister=");
            sb.append(iM4951u < 3);
            Log.d("ControlService", sb.toString());
            if (iM4951u < 3) {
                m10933a(context, intent);
                return;
            }
            return;
        }
        if (!ahp.m1237a(context)) {
            aiv.m1418c("ControlService", "connectManager[network connectedOrConnecting failed]");
            return;
        }
        String packageName = context.getPackageName();
        String strM10992a = C2000a.m10992a(context);
        aqj aqjVar = new aqj(this.f11979b, "handleWake");
        LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11979b);
        linkedHashMapM4909v.put("currentSudoPack", strM10992a);
        aqjVar.m5023a(linkedHashMapM4909v);
        ais.m1387b(context, strM10992a, "handleWake");
        if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(strM10992a) && TextUtils.equals(packageName, strM10992a)) {
            m10941a(context, packageName, strM10992a, apvVar, "handleWake");
        } else {
            m10950b(context, "handleWake");
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:(2:145|31)|(1:33)(2:35|(1:37)(2:38|(1:40)(2:41|(1:43)(2:44|(1:46)(10:48|141|49|(9:129|51|52|133|53|(1:55)|139|58|59)(9:62|123|63|64|127|65|(1:67)|70|(1:72)(12:148|73|(2:77|(1:79))|83|125|84|85|121|87|(2:91|92)|93|(2:95|96)(2:97|(2:99|100)(2:101|102))))|105|143|108|(1:110)|111|112)))))|34|141|49|(0)(0)|105|143|108|(0)|111|112) */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x026a, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x026b, code lost:
    
        r4 = r11;
     */
    /* JADX WARN: Removed duplicated region for block: B:110:0x028a A[Catch: Throwable -> 0x028f, TRY_LEAVE, TryCatch #11 {Throwable -> 0x028f, blocks: (B:108:0x0271, B:110:0x028a), top: B:143:0x0271 }] */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0125 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x014d A[Catch: Throwable -> 0x026a, TRY_ENTER, TRY_LEAVE, TryCatch #10 {Throwable -> 0x026a, blocks: (B:49:0x011f, B:62:0x014d), top: B:141:0x011f }] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m10948b(android.content.Context r23, android.content.Intent r24, p000.apv r25) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 683
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.impl.ControlService.m10948b(android.content.Context, android.content.Intent, apv):void");
    }

    /* JADX INFO: renamed from: a */
    private final String m10931a(Context context, long j) {
        String strM1244f;
        String strM1241c = null;
        try {
            ahp ahpVar = new ahp(context);
            strM1244f = ahpVar.m1244f();
            try {
                strM1241c = ahpVar.m1241c();
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strM1244f = null;
        }
        if (TextUtils.isEmpty(strM1244f)) {
            strM1244f = "unknow";
        }
        if (TextUtils.isEmpty(strM1241c)) {
            strM1241c = "unknow";
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(apu.m4936f(context));
        stringBuffer.append("|");
        stringBuffer.append(j);
        stringBuffer.append("|");
        stringBuffer.append(System.currentTimeMillis());
        stringBuffer.append("|");
        stringBuffer.append(strM1244f);
        stringBuffer.append("|");
        stringBuffer.append(strM1241c);
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: c */
    private final void m10953c(Context context, Intent intent, apv apvVar) throws Throwable {
        String stringExtra = intent.getStringExtra("id");
        aqj aqjVar = new aqj(this.f11979b, "appMessageSuccess");
        LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11979b);
        linkedHashMapM4909v.put("messageId", stringExtra);
        aqjVar.m5023a(linkedHashMapM4909v);
        if (apvVar.callShouldProcessMessage(context, intent)) {
            if (apu.m4956z(context)) {
                aiv.m1412a("ControlService", "handleMessage[" + context.getPackageName() + "]--->[disable]");
                new aqj(this.f11979b, "appMessageFailed").m5023a(linkedHashMapM4909v);
                return;
            }
            m10948b(context, intent, apvVar);
        }
    }

    /* JADX INFO: renamed from: d */
    private final void m10955d(Context context, Intent intent, apv apvVar) throws Throwable {
        if (!m10944a(context, apvVar)) {
            aiv.m1418c("ControlService", "handleAddPackage---->[appkey or appSecret ===null]");
            return;
        }
        if (!apu.m4943m(context)) {
            aiv.m1418c("ControlService", "handleAddPackage---->[devicetoken ===null]");
        } else if (apu.m4921G(context) == apu.EnumC0716a.f4599a) {
            air.m1375a(context, null);
        } else {
            m10938a(context, "handleAddPackage");
        }
    }

    /* JADX INFO: renamed from: e */
    private final void m10956e(Context context, Intent intent, apv apvVar) throws Throwable {
        if (intent == null || context == null) {
            return;
        }
        if (!apu.m4943m(context)) {
            aiv.m1418c("ControlService", "handleRemovePackage---->[devicetoken ===null]");
            return;
        }
        Uri data = intent.getData();
        String schemeSpecificPart = data != null ? data.getSchemeSpecificPart() : null;
        if (TextUtils.isEmpty(schemeSpecificPart)) {
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("android.intent.extra.REPLACING", false);
        aiv.m1418c("ControlService", "handleRemovePackage---->[replacing:" + booleanExtra + "]");
        m10935a(context, intent, apvVar, schemeSpecificPart, booleanExtra);
        String strM10992a = C2000a.m10992a(context);
        if (TextUtils.isEmpty(strM10992a)) {
            m10938a(context, "handleRemovePackage");
            return;
        }
        if (TextUtils.equals(schemeSpecificPart, strM10992a)) {
            m10938a(context, "handleRemovePackage");
            return;
        }
        String packageName = context.getPackageName();
        if (TextUtils.equals(strM10992a, packageName)) {
            aqj aqjVar = new aqj(this.f11979b, "handleRemovePackage");
            LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11979b);
            linkedHashMapM4909v.put("currentSudoPack", strM10992a);
            aqjVar.m5023a(linkedHashMapM4909v);
            ais.m1387b(context, strM10992a, "handleRemovePackage");
            m10941a(context, packageName, strM10992a, apvVar, "handleRemovePackage");
        }
    }

    /* JADX INFO: renamed from: f */
    private final void m10957f(Context context, Intent intent, apv apvVar) throws Throwable {
        String stringExtra = intent.getStringExtra("command");
        aiv.m1418c("ControlService", "command --->[" + stringExtra + "]");
        if (stringExtra.equals("registration")) {
            apvVar.callRegistered(context, apu.m4944n(context));
            m10955d(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("unregister")) {
            m10966o(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("error")) {
            m10965n(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("register")) {
            m10964m(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("register_retry")) {
            m10933a(context, intent);
            return;
        }
        if (stringExtra.equals("command_other_channel")) {
            m10958g(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("command_restart_sudo")) {
            String packageName = context.getPackageName();
            String strM10992a = C2000a.m10992a(context);
            if (TextUtils.isEmpty(packageName) || TextUtils.isEmpty(strM10992a) || !TextUtils.equals(packageName, strM10992a)) {
                return;
            }
            m10941a(context, packageName, strM10992a, apvVar, "command_restart_sudo");
            return;
        }
        if (stringExtra.equals("command_bind_user")) {
            m10961j(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("command_unbind_user")) {
            m10962k(context, intent, apvVar);
            return;
        }
        if (stringExtra.equals("agoo_command_restart_sudo_app")) {
            String packageName2 = context.getPackageName();
            String strM10992a2 = C2000a.m10992a(context);
            if (TextUtils.isEmpty(packageName2) || TextUtils.isEmpty(strM10992a2)) {
                return;
            }
            aqj aqjVar = new aqj(this.f11979b, "restartByApp");
            LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11979b);
            linkedHashMapM4909v.put("currentSudoPack", strM10992a2);
            aqjVar.m5023a(linkedHashMapM4909v);
            m10950b(context, "restartByApp");
            ais.m1387b(context, strM10992a2, "restartByApp");
            return;
        }
        if (stringExtra.equals(apx.AGOO_COMMAND_SOMANAGER)) {
            apo.m4888d(context, intent.getIntExtra("soTimeout", 600));
        } else {
            apvVar.callUserCommand(context, intent);
        }
    }

    /* JADX INFO: renamed from: g */
    private final void m10958g(Context context, Intent intent, apv apvVar) {
        String stringExtra = intent.getStringExtra("channel_android_device_token");
        String stringExtra2 = intent.getStringExtra("channel_android_device_type");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2) || !apu.m4943m(context) || !m10944a(context, apvVar)) {
            return;
        }
        String strM4944n = apu.m4944n(context);
        arb arbVar = new arb();
        arbVar.m5232c("mtop.push.device.bind.android");
        arbVar.m5234d("5.0");
        arbVar.m5224a(strM4944n);
        arbVar.m5225a("tb_app_device_token", strM4944n);
        arbVar.m5225a("android_device_token", stringExtra);
        arbVar.m5225a("android_device_type", stringExtra2);
        f11978c.mo5189c(apu.m4920F(context));
        arg argVarMo5185a = f11978c.mo5185a(context, arbVar);
        if (argVarMo5185a.m5259b()) {
            Log.d("ControlService", "register GCM success");
        } else {
            ais.m1395e(context, argVarMo5185a.m5263e());
        }
    }

    /* JADX INFO: renamed from: h */
    private final void m10959h(Context context, Intent intent, apv apvVar) {
        boolean z;
        String packageName = context.getPackageName();
        String stringExtra = intent.getStringExtra("election_result");
        ais.m1399g(context, "handleElectionResult begin");
        Set<String> categories = intent.getCategories();
        if (categories == null || categories.isEmpty() || !categories.contains(apo.m4898k(context))) {
            return;
        }
        try {
            String stringExtra2 = intent.getStringExtra("eventId");
            if (!apu.m4943m(context)) {
                aiv.m1418c("ControlService", "handleElection---->[devicetoken == null]");
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "handleElectionResult";
                }
                m10942a(context, false, categories.toString(), packageName, stringExtra, "isRegistered is failed");
                m10938a(context, stringExtra2);
                return;
            }
            if (apu.m4956z(context)) {
                aiv.m1418c("ControlService", "handleElection--->[app:disable]");
                if (TextUtils.isEmpty(stringExtra2)) {
                    stringExtra2 = "handleElectionResult";
                }
                m10942a(context, false, categories.toString(), packageName, stringExtra, "currentPack hasDisableApp");
                m10938a(context, stringExtra2);
                return;
            }
            String stringExtra3 = intent.getStringExtra("election_source");
            long longExtra = intent.getLongExtra("election_timeout", -1L);
            if (TextUtils.isEmpty(stringExtra)) {
                return;
            }
            if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(stringExtra) && TextUtils.equals(packageName, stringExtra)) {
                if (apo.m4910w(context)) {
                    aiv.m1418c("ControlService", "handleElection---->[noticeResult is true, result has came]");
                    return;
                }
                apo.m4891e(context, true);
                apu.m4926a(context, longExtra, stringExtra3);
                aqj aqjVar = new aqj(this.f11979b, "handleElectionResult");
                LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11979b);
                linkedHashMapM4909v.put("currentSudoPack", stringExtra);
                aqjVar.m5023a(linkedHashMapM4909v);
                ais.m1387b(context, stringExtra, "handleElectionResult");
                String str = TextUtils.isEmpty(stringExtra2) ? "handleElectionResult" : stringExtra2;
                try {
                    m10942a(context, true, categories.toString(), packageName, stringExtra, null);
                    m10941a(context, packageName, stringExtra, apvVar, str);
                    return;
                } catch (Throwable th) {
                    th = th;
                    z = true;
                    m10942a(context, z, categories.toString(), packageName, stringExtra, th.toString());
                    return;
                }
            }
            m10942a(context, false, categories.toString(), packageName, stringExtra, "currentPack != currentSudoPack");
            if (apu.m4921G(context) == apu.EnumC0716a.f4599a) {
                return;
            }
            m10940a(context, packageName, stringExtra, apvVar);
        } catch (Throwable th2) {
            th = th2;
            z = false;
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m10942a(Context context, boolean z, String str, String str2, String str3, String str4) {
        String string;
        String str5 = null;
        try {
            String strM4892f = apo.m4892f(context);
            String str6 = z ? "y" : "n";
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("utdid=" + ais.m1388c(context));
            stringBuffer.append("-->");
            stringBuffer.append("appkey=" + apu.m4936f(context));
            stringBuffer.append("-->");
            stringBuffer.append("startTime=" + ahx.m1279a(System.currentTimeMillis()));
            stringBuffer.append("-->");
            stringBuffer.append("ret=" + str6);
            stringBuffer.append("-->");
            stringBuffer.append("categries=" + str);
            stringBuffer.append("-->");
            stringBuffer.append("currentPack=" + str2);
            stringBuffer.append("-->");
            stringBuffer.append("currentSudoPack=" + str3);
            stringBuffer.append("-->");
            stringBuffer.append("fail_reasons=" + str4);
            stringBuffer.append("-->");
            stringBuffer.append("deviceId=" + strM4892f);
            stringBuffer.append("-->");
            stringBuffer.append("sdkVersion=" + apu.m4922a());
            stringBuffer.append("-->");
            stringBuffer.append("actiontype=getNoticeElectionTrace");
            string = stringBuffer.toString();
        } catch (Throwable unused) {
        }
        try {
            ais.m1399g(context, string);
        } catch (Throwable unused2) {
            str5 = string;
            ais.m1399g(context, str5);
        }
    }

    @Override // p000.app
    public final void onHandleIntent(Context context, Intent intent, apv apvVar) {
        try {
            aiv.m1411a(context);
            aiv.m1418c("ControlService", "onHandleIntent [" + context.getPackageName() + "][" + intent.getAction() + "]");
            ais.m1377a(context);
            this.f11979b = context;
            String action = intent.getAction();
            if (TextUtils.equals(action, aqc.m4990b(context))) {
                m10957f(context, intent, apvVar);
                return;
            }
            if ("android.intent.action.PACKAGE_REMOVED".equals(action)) {
                m10956e(context, intent, apvVar);
                return;
            }
            if (TextUtils.equals(action, "org.agoo.android.intent.action.RECEIVE")) {
                m10953c(context, intent, apvVar);
                return;
            }
            if (TextUtils.equals(action, "org.agoo.android.intent.action.ELECTION_RESULT_V4")) {
                m10959h(context, intent, apvVar);
                return;
            }
            if (!TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE") && !TextUtils.equals(action, "android.intent.action.BOOT_COMPLETED") && !TextUtils.equals(action, "android.intent.action.PACKAGE_ADDED") && !TextUtils.equals(action, "android.intent.action.PACKAGE_REPLACED") && !TextUtils.equals(action, "android.intent.action.USER_PRESENT")) {
                aiv.m1420d("ControlService", "handleWake[sms]");
                return;
            }
            if (TextUtils.equals(action, "android.net.conn.CONNECTIVITY_CHANGE")) {
                apu.m4952v(context);
            }
            m10952c(context);
            m10934a(context, intent, apvVar);
        } catch (Throwable th) {
            aiv.m1419c("ControlService", "onHandleIntent", th);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m10939a(Context context, String str, apv apvVar) {
        try {
            if ("SERVICE_NOT_AVAILABLE".equals(str)) {
                boolean zCallRecoverableError = apvVar.callRecoverableError(context, str);
                int iM4948r = apu.m4948r(context);
                if (zCallRecoverableError && iM4948r < 5) {
                    int i = iM4948r + 1;
                    long jCurrentTimeMillis = System.currentTimeMillis() + ((long) f11977a.nextInt(10000));
                    aiv.m1418c("ControlService", "registerfailed retrying--->[" + i + "][" + ahx.m1279a(jCurrentTimeMillis) + "]ms");
                    apu.m4925a(context, i);
                    Intent intentM4988a = aqc.m4988a(context, "register_retry");
                    intentM4988a.setPackage(context.getPackageName());
                    ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).set(1, jCurrentTimeMillis, PendingIntent.getBroadcast(context, 0, intentM4988a, 1073741824));
                } else {
                    aiv.m1418c("ControlService", "Not retrying failed operation[" + iM4948r + "]");
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m10932a(Context context) {
        try {
            Intent intentM4988a = aqc.m4988a(context, "register_retry");
            intentM4988a.setPackage(context.getPackageName());
            PendingIntent broadcast = PendingIntent.getBroadcast(context, 0, intentM4988a, 1073741824);
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).cancel(broadcast);
            broadcast.cancel();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m10936a(Context context, Intent intent, String str, apv apvVar) {
        try {
            String string = new JSONObject(str).getString("device_id");
            if (TextUtils.isEmpty(string)) {
                m10939a(context, "SERVICE_NOT_AVAILABLE", apvVar);
                return;
            }
            apu.m4927a(context, string);
            apu.m4949s(context);
            apu.m4955y(context);
            C2000a.m10995a(context, apvVar.callAgooElectionReceiver());
            m10947b(context);
            ais.m1396f(context);
            m10961j(context, intent, apvVar);
        } catch (Throwable unused) {
            m10939a(context, "SERVICE_NOT_AVAILABLE", apvVar);
            ais.m1395e(context, "data_parse_error");
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m10944a(Context context, apv apvVar) throws Throwable {
        String strM4936f = apu.m4936f(context);
        String strM4938h = apu.m4938h(context);
        Intent intentM4988a = aqc.m4988a(context, "error");
        intentM4988a.setPackage(context.getPackageName());
        if (TextUtils.isEmpty(strM4936f)) {
            intentM4988a.putExtra("error", "ERROR_APPKEY_NULL");
            m10965n(context, intentM4988a, apvVar);
            return false;
        }
        if (TextUtils.isEmpty(strM4938h)) {
            intentM4988a.putExtra("error", "ERROR_TTID_NULL");
            m10965n(context, intentM4988a, apvVar);
            return false;
        }
        f11978c.mo5186a(strM4936f);
        String strM4940j = apu.m4940j(context);
        if (TextUtils.isEmpty(strM4940j) && !apu.m4918D(context)) {
            intentM4988a.putExtra("error", "ERROR_APPSECRET_NULL");
            return false;
        }
        f11978c.mo5188b(strM4940j);
        f11978c.mo5189c(apu.m4920F(context));
        return true;
    }

    /* JADX INFO: renamed from: b */
    private final void m10947b(Context context) {
        Intent intentM4988a = aqc.m4988a(context, "registration");
        intentM4988a.setPackage(context.getPackageName());
        context.sendBroadcast(intentM4988a);
    }

    /* JADX INFO: renamed from: i */
    private final void m10960i(Context context, Intent intent, apv apvVar) throws Throwable {
        if (apu.m4943m(context) && m10944a(context, apvVar)) {
            String strM4944n = apu.m4944n(context);
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.device.unregister");
            arbVar.m5234d("4.0");
            arbVar.m5229b(apu.m4938h(context));
            arbVar.m5224a(strM4944n);
            arbVar.m5225a("app_version", apu.m4924a(context));
            arbVar.m5225a("sdk_version", Long.valueOf(apu.m4922a()));
            arbVar.m5225a("app_pack", context.getPackageName());
            arg argVarMo5185a = f11978c.mo5185a(context, arbVar);
            aiv.m1418c("ControlService", "unregister--->[server result:" + argVarMo5185a.m5260c() + "],result.isSuccess()=" + argVarMo5185a.m5259b());
            if (argVarMo5185a != null && !argVarMo5185a.m5259b()) {
                apo.m4893f(context, true);
                apvVar.callUnregistered(context, "error");
            } else {
                apvVar.callUnregistered(context, apu.m4944n(context));
            }
            m10943a(context, intent, apvVar, argVarMo5185a);
        }
    }

    /* JADX INFO: renamed from: c */
    private final void m10952c(Context context) {
        boolean zM4912y = apo.m4912y(context);
        Log.d("ControlService", "doUnRegisterTemp,begin,flag=" + zM4912y);
        if (zM4912y) {
            String strM4937g = apu.m4937g(context);
            String strM4941k = apu.m4941k(context);
            String strM4939i = apu.m4939i(context);
            if (TextUtils.isEmpty(strM4937g) || TextUtils.isEmpty(strM4941k)) {
                return;
            }
            f11978c.mo5186a(strM4937g);
            f11978c.mo5188b(strM4941k);
            f11978c.mo5189c(apu.m4920F(context));
            String strM4945o = apu.m4945o(context);
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.device.unregister");
            arbVar.m5234d("4.0");
            arbVar.m5229b(strM4939i);
            arbVar.m5224a(strM4945o);
            arbVar.m5225a("app_version", apu.m4924a(context));
            arbVar.m5225a("sdk_version", Long.valueOf(apu.m4922a()));
            arbVar.m5225a("app_pack", context.getPackageName());
            arg argVarMo5185a = f11978c.mo5185a(context, arbVar);
            aiv.m1418c("ControlService", "unregister--->[server result:" + argVarMo5185a.m5260c() + "]");
            String strM5263e = argVarMo5185a.m5263e();
            if (TextUtils.isEmpty(strM5263e)) {
                Log.d("ControlService", "doUnRegisterTemp,errorId=" + strM5263e);
                apo.m4893f(context, false);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m10935a(Context context, Intent intent, apv apvVar, String str, boolean z) throws Throwable {
        if (apu.m4943m(context) && m10944a(context, apvVar)) {
            String strM4944n = apu.m4944n(context);
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.device.reportKickAss");
            arbVar.m5234d("4.0");
            arbVar.m5229b(apu.m4938h(context));
            arbVar.m5224a(strM4944n);
            arbVar.m5225a("app_version", apu.m4924a(context));
            arbVar.m5225a("sdk_version", Long.valueOf(apu.m4922a()));
            arbVar.m5225a("app_pack", str);
            arbVar.m5225a("app_replace", Boolean.valueOf(z));
            arg argVarMo5185a = f11978c.mo5185a(context, arbVar);
            aiv.m1418c("ControlService", "uninstall--->[result:" + argVarMo5185a.m5260c() + "]");
            m10943a(context, intent, apvVar, argVarMo5185a);
        }
    }

    /* JADX INFO: renamed from: j */
    private final void m10961j(Context context, Intent intent, apv apvVar) throws Throwable {
        if (apu.m4943m(context) && m10944a(context, apvVar)) {
            String strM4934d = apu.m4934d(context);
            if (TextUtils.isEmpty(strM4934d)) {
                return;
            }
            String strM4944n = apu.m4944n(context);
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.device.bindUser");
            arbVar.m5234d("4.0");
            arbVar.m5224a(strM4944n);
            arbVar.m5236e(strM4934d);
            arbVar.m5225a("s_token", strM4934d);
            arbVar.m5225a("push_token", "ajflajdflajflajflajlfajldfjalfdj");
            arg argVarMo5185a = f11978c.mo5185a(context, arbVar);
            StringBuilder sb = new StringBuilder();
            sb.append("doBinderUser--->[server result:");
            sb.append(argVarMo5185a != null ? argVarMo5185a.m5260c() : null);
            sb.append("]");
            aiv.m1418c("ControlService", sb.toString());
            if (argVarMo5185a != null) {
                if (argVarMo5185a.m5259b()) {
                    try {
                        String string = new JSONObject(argVarMo5185a.m5260c()).getString("push_user_token");
                        if (!TextUtils.isEmpty(string)) {
                            apu.m4931b(context, string);
                        }
                    } catch (JSONException unused) {
                    }
                }
                m10943a(context, intent, apvVar, argVarMo5185a);
            }
        }
    }

    /* JADX INFO: renamed from: k */
    private final void m10962k(Context context, Intent intent, apv apvVar) throws Throwable {
        if (apu.m4943m(context) && m10944a(context, apvVar)) {
            String strM4895h = apo.m4895h(context);
            if (TextUtils.isEmpty(strM4895h)) {
                return;
            }
            String strM4944n = apu.m4944n(context);
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.device.unBindUser");
            arbVar.m5234d("4.0");
            arbVar.m5224a(strM4944n);
            arbVar.m5225a("push_user_token", strM4895h);
            arbVar.m5225a("push_token", "ajflajdflajflajflajlfajldfjalfdj");
            arg argVarMo5185a = f11978c.mo5185a(context, arbVar);
            StringBuilder sb = new StringBuilder();
            sb.append("doBinderUser--->[server result:");
            sb.append(argVarMo5185a != null ? argVarMo5185a.m5260c() : null);
            sb.append("]");
            aiv.m1418c("ControlService", sb.toString());
            if (argVarMo5185a != null) {
                if (argVarMo5185a.m5259b()) {
                    apu.m4916B(context);
                    apu.m4932c(context);
                } else {
                    m10943a(context, intent, apvVar, argVarMo5185a);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m10943a(Context context, Intent intent, apv apvVar, arg argVar) throws Throwable {
        String strM5263e = argVar.m5263e();
        if (TextUtils.isEmpty(strM5263e)) {
            return true;
        }
        aiv.m1420d("ControlService", "checkMtopResultFailed---->[" + strM5263e + "]");
        ais.m1395e(context, strM5263e);
        if (!TextUtils.equals(strM5263e, "ERRCODE_AUTH_REJECT")) {
            return true;
        }
        Intent intentM4988a = aqc.m4988a(context, "error");
        intentM4988a.setPackage(context.getPackageName());
        intentM4988a.putExtra("error", strM5263e);
        m10965n(context, intentM4988a, apvVar);
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0021  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m10937a(android.content.Context r7, p000.arg r8, p000.arb r9, java.lang.String r10) {
        /*
            Method dump skipped, instruction units count: 292
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.impl.ControlService.m10937a(android.content.Context, arg, arb, java.lang.String):void");
    }

    /* JADX INFO: renamed from: l */
    private final void m10963l(Context context, Intent intent, apv apvVar) {
        String str;
        arb arbVar = new arb();
        arbVar.m5232c("mtop.push.device.createAndRegister");
        arbVar.m5234d("4.0");
        arbVar.m5229b(apu.m4938h(context));
        arbVar.m5225a("new_device", "true");
        arbVar.m5225a("device_global_id", ais.m1388c(context));
        arbVar.m5225a("c0", Build.BRAND);
        arbVar.m5225a("c1", Build.MODEL);
        arbVar.m5225a("c2", aic.m1302d(context));
        arbVar.m5225a("c3", aic.m1303e(context));
        arbVar.m5225a("c4", aic.m1301c(context));
        arbVar.m5225a("c5", aic.m1297a());
        arbVar.m5225a("c6", aic.m1304f(context));
        arbVar.m5225a("app_version", apu.m4924a(context));
        arbVar.m5225a("sdk_version", Long.valueOf(apu.m4922a()));
        arbVar.m5225a("package_name", context.getPackageName());
        if (apu.m4943m(context)) {
            arbVar.m5225a("old_device_id", apu.m4944n(context));
        }
        Log.d("ControlService", "doRegister app_version=" + apu.m4924a(context));
        Map mapMo5187b = f11978c.mo5187b(context, arbVar);
        arg argVar = null;
        if (mapMo5187b != null) {
            argVar = (arg) mapMo5187b.get("result");
            str = (String) mapMo5187b.get("requestUrl");
        } else {
            str = null;
        }
        if (argVar != null) {
            m10937a(context, argVar, arbVar, str);
            if (!aid.m1307a(argVar.m5253a(), argVar.m5264f())) {
                aiv.m1418c("ControlService", "register--->[failed]");
                return;
            }
            if (argVar.m5259b()) {
                aiv.m1418c("ControlService", "register--->[result:" + argVar.m5260c() + "]");
                apo.m4885c(context, apu.m4922a());
                m10936a(context, intent, argVar.m5260c(), apvVar);
                return;
            }
            if (m10943a(context, intent, apvVar, argVar)) {
                return;
            }
        }
        m10937a(context, argVar, arbVar, str);
        m10939a(context, "SERVICE_NOT_AVAILABLE", apvVar);
    }

    /* JADX INFO: renamed from: m */
    private final void m10964m(Context context, Intent intent, apv apvVar) throws Throwable {
        ais.m1401h(context, "utdid=" + ais.m1388c(context));
        if (!m10944a(context, apvVar)) {
            aiv.m1412a("ControlService", "handleRegister[" + context.getPackageName() + "]--->[appkey==null,appSecret==null,ttid==null]");
            return;
        }
        boolean booleanExtra = intent.getBooleanExtra("HAS_RETTY_REGISTER", false);
        if (!apu.m4943m(context)) {
            aiv.m1412a("ControlService", "handleRegister[" + context.getPackageName() + "]--->[deviceToken==null][retty:" + booleanExtra + "]");
            apu.m4955y(context);
            if (!booleanExtra) {
                apu.m4949s(context);
            }
            aip.m1366a(context);
            m10932a(context);
            m10963l(context, intent, apvVar);
            return;
        }
        if (apu.m4953w(context)) {
            aiv.m1412a("ControlService", "handleRegister[" + context.getPackageName() + "]--->[" + apu.m4944n(context) + "][register timeout][retty:" + booleanExtra + "]");
            if (!booleanExtra) {
                apu.m4949s(context);
            }
            m10932a(context);
            m10963l(context, intent, apvVar);
            return;
        }
        if (apu.m4929a(context, true)) {
            aiv.m1412a("ControlService", "handleRegister[" + context.getPackageName() + "]--->[disable]");
            return;
        }
        if (apu.m4921G(context) == apu.EnumC0716a.f4599a) {
            air.m1375a(context, null);
            return;
        }
        C2000a.m10995a(context, apvVar.callAgooElectionReceiver());
        aiq.m1370a(context, (Class<?>[]) new Class[]{apvVar.callAgooMessageReceiver(), apvVar.callAgooSystemReceiver(), apvVar.callAgooRegistrationReceiver()});
        String strM10992a = C2000a.m10992a(context);
        aqj aqjVar = new aqj(this.f11979b, "handleRegister");
        LinkedHashMap<String, String> linkedHashMapM4909v = apo.m4909v(this.f11979b);
        linkedHashMapM4909v.put("currentSudoPack", strM10992a);
        aqjVar.m5023a(linkedHashMapM4909v);
        ais.m1387b(context, strM10992a, "handleRegister");
        m10950b(context, "handleRegister");
    }

    /* JADX INFO: renamed from: a */
    private final void m10933a(Context context, Intent intent) {
        if (apu.m4943m(context)) {
            return;
        }
        apu.m4950t(context);
        m10954d(context);
    }

    /* JADX INFO: renamed from: b */
    private final void m10949b(Context context, apv apvVar) {
        C2000a.m11005b(context, apvVar.callAgooElectionReceiver());
        apu.m4954x(context);
        aiv.m1412a("ControlService", "handleDisableCurrentPack-->[" + context.getPackageName() + "]");
        air.m1374a(context);
    }

    /* JADX INFO: renamed from: a */
    private final void m10938a(Context context, String str) throws Throwable {
        C2000a.m10996a(context, str);
    }

    /* JADX INFO: renamed from: n */
    private final void m10965n(Context context, Intent intent, apv apvVar) throws Throwable {
        String stringExtra = intent.getStringExtra("error");
        String stringExtra2 = intent.getStringExtra("eventId");
        aiv.m1418c("ControlService", "handleError:" + stringExtra);
        if (TextUtils.equals(stringExtra, "EVENT_CONNECTED")) {
            apvVar.callError(context, stringExtra);
            return;
        }
        if (TextUtils.equals(stringExtra, "EVENT_SPDY_ERROR") || TextUtils.equals(stringExtra, "EVENT_DISCONNECTED")) {
            String packageName = context.getPackageName();
            String strM10992a = C2000a.m10992a(context);
            aiv.m1418c("ControlService", "handleError,currentPack=" + packageName + ",currentSudoPack=" + strM10992a);
            if (!TextUtils.isEmpty(packageName) && !TextUtils.isEmpty(strM10992a) && TextUtils.equals(packageName, strM10992a)) {
                m10941a(context, packageName, strM10992a, apvVar, "command_restart_sudo");
            }
            apvVar.callError(context, stringExtra);
            return;
        }
        if (TextUtils.equals(stringExtra, "ERROR_NEED_ELECTION")) {
            m10938a(context, stringExtra2);
            return;
        }
        if (TextUtils.equals(stringExtra, "ERROR_DEVICETOKEN_NULL")) {
            ais.m1392d(context, "ERROR_DEVICETOKEN_NULL");
            apvVar.callError(context, stringExtra);
            return;
        }
        if (TextUtils.equals(stringExtra, "ERRCODE_AUTH_REJECT")) {
            m10949b(context, apvVar);
            apvVar.callError(context, stringExtra);
        } else if (TextUtils.equals(stringExtra, "ERROR_APPKEY_NULL") || TextUtils.equals(stringExtra, "ERROR_APPSECRET_NULL") || TextUtils.equals(stringExtra, "ERROR_TTID_NULL")) {
            ais.m1392d(context, "APPKEY_OR_SECRET_IS_NULL");
            m10949b(context, apvVar);
            apvVar.callError(context, stringExtra);
        }
    }

    /* JADX INFO: renamed from: o */
    private final void m10966o(Context context, Intent intent, apv apvVar) throws Throwable {
        boolean z;
        if (apu.m4943m(context)) {
            String packageName = context.getPackageName();
            String strM10992a = C2000a.m10992a(context);
            if (TextUtils.isEmpty(strM10992a) || TextUtils.equals(packageName, strM10992a)) {
                aiv.m1418c("ControlService", "handleUnRegister---->[currentPack:" + packageName + "][currentSudoPack:" + strM10992a + "]:[retryElection]");
                if (m10945a(apvVar.callAgooService())) {
                    aiv.m1418c("ControlService", "disableService---->[" + apvVar.callAgooService() + "]");
                    aiq.m1369a(context, apvVar.callAgooService());
                }
                air.m1374a(context);
                z = true;
            } else {
                z = false;
            }
            C2000a.m11005b(context, apvVar.callAgooElectionReceiver());
            if (z) {
                m10938a(context, "handleUnRegister");
            }
            m10960i(context, intent, apvVar);
            apu.m4949s(context);
            apu.m4935e(context);
        }
    }

    /* JADX INFO: renamed from: a */
    private final boolean m10945a(Class<?> cls) {
        return cls != null && TextUtils.equals(cls.getSuperclass().getName(), AgooService.class.getName());
    }

    /* JADX INFO: renamed from: a */
    private final void m10941a(Context context, String str, String str2, apv apvVar, String str3) {
        Class<?> clsCallAgooService = apvVar.callAgooService();
        aiv.m1418c("ControlService", "restart---->[currentSudoPack:" + str2 + "]:[start]");
        if (m10945a(clsCallAgooService)) {
            aiv.m1418c("ControlService", "enabledService---->[" + str + "/" + apvVar.callAgooService() + "]");
            aiq.m1373b(context, apvVar.callAgooService());
        }
        air.m1375a(context, str3);
    }

    /* JADX INFO: renamed from: a */
    private final void m10940a(Context context, String str, String str2, apv apvVar) {
        Class<?> clsCallAgooService = apvVar.callAgooService();
        aiv.m1418c("ControlService", "restart---->[currentSudoPack:" + str2 + "][currentPack:" + str + "]:[stop]");
        if (m10945a(clsCallAgooService)) {
            aiv.m1418c("ControlService", "disableService---->[" + str + "/" + apvVar.callAgooService() + "]");
            aiq.m1369a(context, apvVar.callAgooService());
        }
        air.m1374a(context);
    }

    /* JADX INFO: renamed from: b */
    private final void m10950b(Context context, String str) throws Throwable {
        try {
            Intent intent = new Intent();
            intent.setAction("org.agoo.android.intent.action.PING_V4");
            intent.setClassName("com.taobao.taobao", "com.taobao.accs.ChannelService");
            intent.putExtra("source", context.getPackageName());
            context.startService(intent);
        } catch (Exception e) {
            aiv.m1421d("ControlService", "onPingMessage ping accs error", e);
        }
        String strM10992a = C2000a.m10992a(context);
        if (TextUtils.isEmpty(strM10992a)) {
            aiv.m1418c("ControlService", "onPingMessage:[currentSudoPack==null][retry election]");
            m10938a(context, str);
            return;
        }
        try {
            aiv.m1418c("ControlService", "messageConnection [bind]");
            Intent intent2 = new Intent();
            intent2.setAction("org.agoo.android.intent.action.PING_V4");
            intent2.addCategory(apo.m4898k(context));
            intent2.setPackage(strM10992a);
            context.bindService(intent2, this.f11980d, 1);
        } catch (Throwable th) {
            aiv.m1419c("ControlService", "onPingMessage", th);
        }
    }

    /* JADX INFO: renamed from: d */
    private static final void m10954d(Context context) {
        try {
            Intent intentM4988a = aqc.m4988a(context, "register");
            intentM4988a.setPackage(context.getPackageName());
            intentM4988a.putExtra("HAS_RETTY_REGISTER", true);
            context.sendBroadcast(intentM4988a);
        } catch (Throwable unused) {
        }
    }
}
