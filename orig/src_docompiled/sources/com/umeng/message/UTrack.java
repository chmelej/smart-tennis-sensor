package com.umeng.message;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgLogStore;
import com.umeng.message.protobuffer.PushResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import p000.ahb;
import p000.ahc;
import p000.ahd;
import p000.ahf;
import p000.ail;
import p000.ain;
import p000.aio;
import p000.apq;
import p000.apz;

/* JADX INFO: loaded from: classes.dex */
public class UTrack {

    /* JADX INFO: renamed from: a */
    private static final String f9195a = "com.umeng.message.UTrack";

    /* JADX INFO: renamed from: d */
    private static UTrack f9196d = null;

    /* JADX INFO: renamed from: h */
    private static boolean f9197h = false;

    /* JADX INFO: renamed from: i */
    private static boolean f9198i = false;

    /* JADX INFO: renamed from: j */
    private static boolean f9199j = false;

    /* JADX INFO: renamed from: k */
    private static boolean f9200k = false;

    /* JADX INFO: renamed from: b */
    private JSONObject f9201b;

    /* JADX INFO: renamed from: c */
    private JSONObject f9202c;

    /* JADX INFO: renamed from: e */
    private ScheduledThreadPoolExecutor f9203e;

    /* JADX INFO: renamed from: f */
    private Context f9204f;

    /* JADX INFO: renamed from: g */
    private boolean f9205g;

    public void setClearPrevMessage(boolean z) {
        this.f9205g = z;
    }

    private UTrack(Context context) {
        this.f9204f = context.getApplicationContext();
        m8722b();
        this.f9203e = new ScheduledThreadPoolExecutor(Runtime.getRuntime().availableProcessors() * 4);
    }

    public static synchronized UTrack getInstance(Context context) {
        if (f9196d == null) {
            f9196d = new UTrack(context);
        }
        return f9196d;
    }

    /* JADX INFO: renamed from: a */
    void m8733a(ahf ahfVar) {
        if (ahfVar == null || ahfVar.f975a == null) {
            return;
        }
        m8718a(ahfVar.f975a, 0, ahfVar.f997w * 60000);
    }

    public void trackMsgClick(ahf ahfVar) {
        if (ahfVar != null && ahfVar.f975a != null) {
            m8718a(ahfVar.f975a, 1, ahfVar.f997w * 60000);
        }
        if (ahfVar != null && ahfVar.f976b != null) {
            m8719a(ahfVar.f976b, ahfVar.f977c, MsgConstant.MESSAGE_NOTIFY_CLICK);
        }
        if (this.f9205g) {
            ((UmengMessageHandler) PushAgent.getInstance(this.f9204f).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgDismissed(ahf ahfVar) {
        if (ahfVar != null && ahfVar.f975a != null) {
            m8718a(ahfVar.f975a, 2, ahfVar.f997w * 60000);
        }
        if (ahfVar != null && ahfVar.f976b != null) {
            m8719a(ahfVar.f976b, ahfVar.f977c, MsgConstant.MESSAGE_NOTIFY_DISMISS);
        }
        if (this.f9205g) {
            ((UmengMessageHandler) PushAgent.getInstance(this.f9204f).getMessageHandler()).setPrevMessage(null);
        }
    }

    public void trackMsgDisplay(ahf ahfVar) {
        if (ahfVar == null || ahfVar.f975a == null) {
            return;
        }
        m8718a(ahfVar.f975a, 3, ahfVar.f997w * 60000);
    }

    /* JADX INFO: renamed from: a */
    private void m8718a(final String str, final int i, long j) {
        if (m8727c()) {
            if (TextUtils.isEmpty(str)) {
                ahb.m1041b(f9195a, "trackMsgLog: empty msgId");
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                MsgLogStore.getInstance(this.f9204f).addLog(str, i, jCurrentTimeMillis);
            } catch (Exception e) {
                e.printStackTrace();
                ahb.m1043c(f9195a, "trackMsgLog: " + e.toString());
            }
            Runnable runnable = new Runnable() { // from class: com.umeng.message.UTrack.1
                @Override // java.lang.Runnable
                public void run() {
                    UTrack.this.m8724b(str, i, jCurrentTimeMillis);
                }
            };
            long jAbs = 0;
            if (j > 0 && i != 1) {
                jAbs = Math.abs(new Random().nextLong() % j);
            }
            ahb.m1043c(f9195a, String.format("trackMsgLog(msgId=%s, actionType=%d, random=%d, delay=%d)", str, Integer.valueOf(i), Long.valueOf(j), Long.valueOf(jAbs)));
            this.f9203e.schedule(runnable, jAbs, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m8719a(final String str, final String str2, final String str3) {
        if (m8727c()) {
            if (TextUtils.isEmpty(str)) {
                ahb.m1041b(f9195a, "trackMsgLogForAgoo: empty msgId");
                return;
            }
            final long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                MsgLogStore.getInstance(this.f9204f).addLogForAgoo(str, str2, str3, jCurrentTimeMillis);
            } catch (Exception e) {
                e.printStackTrace();
                ahb.m1043c(f9195a, "trackMsgLog: " + e.toString());
            }
            this.f9203e.submit(new Runnable() { // from class: com.umeng.message.UTrack.2
                @Override // java.lang.Runnable
                public void run() {
                    UTrack.this.sendMsgLogForAgoo(str, str2, str3, jCurrentTimeMillis);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0066 A[DONT_GENERATE] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m8724b(java.lang.String r3, int r4, long r5) {
        /*
            r2 = this;
            monitor-enter(r2)
            org.json.JSONObject r0 = r2.m8732f()     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            java.lang.String r1 = "msg_id"
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            java.lang.String r1 = "action_type"
            r0.put(r1, r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            java.lang.String r1 = "ts"
            r0.put(r1, r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            aio r5 = new aio     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            android.content.Context r6 = r2.f9204f     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            r5.<init>(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            byte[] r6 = r5.m1364a(r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            java.lang.String r0 = com.umeng.message.MsgConstant.LOG_ENDPOINT     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            com.umeng.message.protobuffer.PushResponse r5 = r5.m1363a(r6, r0)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            if (r5 == 0) goto L66
            com.umeng.message.protobuffer.PushResponse$responseCode r5 = r5.code     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            com.umeng.message.protobuffer.PushResponse$responseCode r6 = com.umeng.message.protobuffer.PushResponse.responseCode.SUCCESS     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            boolean r5 = r5.equals(r6)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            if (r5 == 0) goto L66
            android.content.Context r5 = r2.f9204f     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            com.umeng.message.MsgLogStore r5 = com.umeng.message.MsgLogStore.getInstance(r5)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            r5.removeLog(r3, r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            if (r4 == 0) goto L66
            r5 = 3
            if (r4 == r5) goto L66
            android.content.Context r4 = r2.f9204f     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            com.umeng.message.MsgLogStore r4 = com.umeng.message.MsgLogStore.getInstance(r4)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            r4.removeLogIdType(r3)     // Catch: java.lang.Throwable -> L49 java.lang.Exception -> L4b org.json.JSONException -> L59
            goto L66
        L49:
            r3 = move-exception
            goto L68
        L4b:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = com.umeng.message.UTrack.f9195a     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L49
            p000.ahb.m1043c(r4, r3)     // Catch: java.lang.Throwable -> L49
            goto L66
        L59:
            r3 = move-exception
            r3.printStackTrace()     // Catch: java.lang.Throwable -> L49
            java.lang.String r4 = com.umeng.message.UTrack.f9195a     // Catch: java.lang.Throwable -> L49
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Throwable -> L49
            p000.ahb.m1043c(r4, r3)     // Catch: java.lang.Throwable -> L49
        L66:
            monitor-exit(r2)
            return
        L68:
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.UTrack.m8724b(java.lang.String, int, long):void");
    }

    public synchronized void sendMsgLogForAgoo(String str, String str2, String str3, long j) {
        ahb.m1043c(f9195a, "sendMsgLogForAgoo:msgId=" + str + ",taskId=" + str2 + ",msgStatus=" + str3 + ",time=" + j);
        try {
            apz apzVar = new apz();
            apzVar.m4967a("mtop.push.msg.report");
            apzVar.m4970b("1.0");
            if (!TextUtils.isEmpty(str2)) {
                apzVar.m4968a("task_id", str2);
            }
            apzVar.m4968a("messageId", str);
            apzVar.m4968a("mesgStatus", str3);
            apq iMtopService = UmengRegistrar.getIMtopService(this.f9204f);
            if (iMtopService != null && iMtopService.getV3(this.f9204f, apzVar).m4984a()) {
                MsgLogStore.getInstance(this.f9204f).removeLogForAgoo(str, str3);
                if (!str3.equals(MsgConstant.MESSAGE_NOTIFY_ARRIVAL)) {
                    MsgLogStore.getInstance(this.f9204f).removeLogIdTypeForAgoo(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            ahb.m1043c(f9195a, e.toString());
        }
    }

    public void sendCachedMsgLog(long j) {
        if (m8727c()) {
            if (f9197h || f9198i) {
                ahb.m1043c(f9195a, "sendCachedMsgLog already in queue, abort this request.");
                return;
            }
            ahb.m1043c(f9195a, "sendCachedMsgLog start, set cacheLogSending flag");
            f9197h = true;
            f9198i = true;
            Runnable runnable = new Runnable() { // from class: com.umeng.message.UTrack.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            ArrayList<MsgLogStore.MsgLog> msgLogs = MsgLogStore.getInstance(UTrack.this.f9204f).getMsgLogs();
                            for (int i = 0; i < msgLogs.size(); i++) {
                                MsgLogStore.MsgLog msgLog = msgLogs.get(i);
                                UTrack.this.m8724b(msgLog.msgId, msgLog.actionType, msgLog.time);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            ahb.m1043c(UTrack.f9195a, th.toString());
                        }
                    } finally {
                        ahb.m1043c(UTrack.f9195a, "sendCachedMsgLog finished, clear cacheLogSending flag");
                        boolean unused = UTrack.f9197h = false;
                    }
                }
            };
            ahb.m1043c(f9195a, String.format("sendCachedMsgLog(delay=%d)", Long.valueOf(j)));
            this.f9203e.schedule(runnable, j, TimeUnit.MILLISECONDS);
            this.f9203e.submit(new Runnable() { // from class: com.umeng.message.UTrack.4
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            ArrayList<MsgLogStore.MsgLogForAgoo> msgLogsForAgoo = MsgLogStore.getInstance(UTrack.this.f9204f).getMsgLogsForAgoo();
                            for (int i = 0; i < msgLogsForAgoo.size(); i++) {
                                MsgLogStore.MsgLogForAgoo msgLogForAgoo = msgLogsForAgoo.get(i);
                                UTrack.this.sendMsgLogForAgoo(msgLogForAgoo.msgId, msgLogForAgoo.taskId, msgLogForAgoo.msgStatus, msgLogForAgoo.time);
                            }
                        } catch (Throwable th) {
                            th.printStackTrace();
                            ahb.m1043c(UTrack.f9195a, th.toString());
                        }
                    } finally {
                        boolean unused = UTrack.f9198i = false;
                    }
                }
            });
        }
    }

    public void trackAppLaunch(long j) {
        if (m8727c()) {
            if (f9199j) {
                ahb.m1043c(f9195a, "trackAppLaunch already in queue, abort this request.");
                return;
            }
            ahb.m1043c(f9195a, "trackAppLaunch start, set appLaunchSending flag");
            f9199j = true;
            Runnable runnable = new Runnable() { // from class: com.umeng.message.UTrack.5
                @Override // java.lang.Runnable
                public void run() {
                    int iIntValue;
                    try {
                        if (UmengRegistrar.isRegistered(UTrack.this.f9204f)) {
                            JSONObject jSONObjectM8731e = UTrack.this.m8731e();
                            aio aioVar = new aio(UTrack.this.f9204f);
                            PushResponse pushResponseM1363a = aioVar.m1363a(aioVar.m1364a(jSONObjectM8731e), MsgConstant.LAUNCH_ENDPOINT);
                            if (pushResponseM1363a != null && pushResponseM1363a.code.equals(PushResponse.responseCode.SUCCESS)) {
                                MsgLogStore.getInstance(UTrack.this.f9204f).setMsgConfigInfo_AppLaunchAt(System.currentTimeMillis());
                                int iIntValue2 = -1;
                                if (pushResponseM1363a.info != null) {
                                    iIntValue = pushResponseM1363a.info.launchPolicy.intValue();
                                    ahb.m1043c(UTrack.f9195a, "launch_policy:" + iIntValue);
                                } else {
                                    iIntValue = -1;
                                }
                                if (pushResponseM1363a.info != null) {
                                    iIntValue2 = pushResponseM1363a.info.tagPolicy.intValue();
                                    ahb.m1043c(UTrack.f9195a, "tag_policy:" + iIntValue2);
                                }
                                if (iIntValue > 0) {
                                    MessageSharedPrefs.getInstance(UTrack.this.f9204f).setAppLaunchLogSendPolicy(iIntValue);
                                }
                                if (iIntValue2 > 0) {
                                    MessageSharedPrefs.getInstance(UTrack.this.f9204f).setTagSendPolicy(iIntValue2);
                                }
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        ahb.m1043c(UTrack.f9195a, e.toString());
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                        ahb.m1043c(UTrack.f9195a, e2.toString());
                    } finally {
                        boolean unused = UTrack.f9199j = false;
                    }
                }
            };
            ahb.m1043c(f9195a, String.format("trackAppLaunch(delay=%d)", Long.valueOf(j)));
            this.f9203e.schedule(runnable, j, TimeUnit.MILLISECONDS);
        }
    }

    public void trackRegister() {
        if (m8727c()) {
            if (f9200k) {
                ahb.m1043c(f9195a, "sendRegisterLog already in queue, abort this request.");
                return;
            }
            ahb.m1043c(f9195a, "trackRegisterLog start, set registerSending flag");
            f9200k = true;
            Runnable runnable = new Runnable() { // from class: com.umeng.message.UTrack.6
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        try {
                            JSONObject jSONObjectM8731e = UTrack.this.m8731e();
                            String strM8729d = UTrack.this.m8729d();
                            if (!ail.m1349b(strM8729d)) {
                                ahb.m1043c(UTrack.f9195a, "TestDevice sign =" + strM8729d);
                                jSONObjectM8731e.put("TD", strM8729d);
                            }
                            aio aioVar = new aio(UTrack.this.f9204f);
                            PushResponse pushResponseM1363a = aioVar.m1363a(aioVar.m1364a(jSONObjectM8731e), MsgConstant.REGISTER_ENDPOINT);
                            if (pushResponseM1363a != null && pushResponseM1363a.code.equals(PushResponse.responseCode.SUCCESS)) {
                                UmengRegistrar.m8754a(UTrack.this.f9204f, true);
                            }
                        } catch (ain.C0143b e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } finally {
                        boolean unused = UTrack.f9200k = false;
                    }
                }
            };
            ahb.m1043c(f9195a, String.format("trackRegister(delay=%d)", 0));
            this.f9203e.schedule(runnable, 0L, TimeUnit.MILLISECONDS);
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8722b() {
        if (this.f9201b == null) {
            ahd ahdVar = new ahd();
            ahdVar.m1080b(this.f9204f, new String[0]);
            ahdVar.m1077a(this.f9204f, PushAgent.getInstance(this.f9204f).getMessageAppkey(), PushAgent.getInstance(this.f9204f).getMessageChannel());
            this.f9201b = new JSONObject();
            try {
                ahdVar.m1078a(this.f9201b);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f9202c == null) {
            ahd ahdVar2 = new ahd();
            ahdVar2.m1083c(this.f9204f, new String[0]);
            ahdVar2.m1077a(this.f9204f, PushAgent.getInstance(this.f9204f).getMessageAppkey(), PushAgent.getInstance(this.f9204f).getMessageChannel());
            this.f9202c = new JSONObject();
            try {
                ahdVar2.m1081b(this.f9202c);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public JSONObject getHeader() {
        return this.f9201b;
    }

    public void setAlias(final String str, final String str2) {
        new Thread(new Runnable() { // from class: com.umeng.message.UTrack.7
            @Override // java.lang.Runnable
            public void run() {
                UTrack.this.addAlias(str, str2, true);
            }
        }).start();
    }

    public void setExclusiveAlias(final String str, final String str2) {
        new Thread(new Runnable() { // from class: com.umeng.message.UTrack.8
            @Override // java.lang.Runnable
            public void run() {
                UTrack.this.addExclusiveAlias(str, str2, true);
            }
        }).start();
    }

    public boolean addAlias(String str, String str2, boolean z) {
        PushResponse pushResponseM1363a;
        if (TextUtils.isEmpty(str2)) {
            ahb.m1041b(f9195a, "addAlias: empty type");
            return false;
        }
        if (!m8727c()) {
            return false;
        }
        boolean z2 = true;
        if (z && MessageSharedPrefs.getInstance(this.f9204f).isAliasSet(MessageSharedPrefs.EnumC1608a.SUCCESS, 2, str, str2)) {
            ahb.m1043c(f9195a, String.format("addAlias: <%s, %s> has been synced to the server before. Ingore this request.", str, str2));
            return true;
        }
        try {
            JSONObject jSONObjectM8731e = m8731e();
            jSONObjectM8731e.put(MsgConstant.KEY_ALIAS, str);
            jSONObjectM8731e.put("type", str2);
            jSONObjectM8731e.put(MsgConstant.KEY_LAST_ALIAS, MessageSharedPrefs.getInstance(this.f9204f).getLastAlias(str2));
            jSONObjectM8731e.put(MsgConstant.KEY_TS, System.currentTimeMillis());
            aio aioVar = new aio(this.f9204f);
            pushResponseM1363a = aioVar.m1363a(aioVar.m1364a(jSONObjectM8731e), MsgConstant.ALIAS_ENDPOINT);
            if (pushResponseM1363a != null) {
                ahb.m1043c(f9195a, "addAlias: " + pushResponseM1363a.code + ", " + pushResponseM1363a.description);
            }
        } catch (Exception e) {
            e.printStackTrace();
            m8716a(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 0);
        }
        if (pushResponseM1363a != null && pushResponseM1363a.code.equals(PushResponse.responseCode.SUCCESS)) {
            m8716a(MessageSharedPrefs.EnumC1608a.SUCCESS, str, str2, 2);
            m8723b(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 0);
            return true;
        }
        if (pushResponseM1363a != null && pushResponseM1363a.description != null) {
            if (!(pushResponseM1363a.description.contains("Alias in process, try later!") || pushResponseM1363a.description.contains("Request time out!")) && !pushResponseM1363a.description.contains("Server exception!")) {
                z2 = false;
            }
            if (z2) {
                m8716a(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 0);
            } else {
                m8723b(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 0);
            }
        }
        if (pushResponseM1363a == null) {
            m8716a(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 0);
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    private void m8716a(MessageSharedPrefs.EnumC1608a enumC1608a, String str, String str2, int i) {
        MessageSharedPrefs.getInstance(this.f9204f).addAliasTypeSingle(enumC1608a, str, str2, i);
        MessageSharedPrefs.getInstance(this.f9204f).addAlias(enumC1608a, str, str2, i);
    }

    /* JADX INFO: renamed from: b */
    private void m8723b(MessageSharedPrefs.EnumC1608a enumC1608a, String str, String str2, int i) {
        if (MessageSharedPrefs.getInstance(this.f9204f).isAliasType(enumC1608a, str2, i)) {
            MessageSharedPrefs.getInstance(this.f9204f).removeAliasTypeSingle(enumC1608a, str2, i);
            MessageSharedPrefs.getInstance(this.f9204f).removeAlias(enumC1608a, str, str2, i);
        }
    }

    public boolean addExclusiveAlias(String str, String str2, boolean z) {
        PushResponse pushResponseM1363a;
        if (TextUtils.isEmpty(str2)) {
            ahb.m1041b(f9195a, "addExclusiveAlias: empty type");
            return false;
        }
        if (!m8727c()) {
            return false;
        }
        if (z && MessageSharedPrefs.getInstance(this.f9204f).isAliasSet(MessageSharedPrefs.EnumC1608a.SUCCESS, 3, str, str2)) {
            ahb.m1043c(f9195a, String.format("addExclusiveAlias: <%s, %s> has been synced to the server before. Ingore this request.", str, str2));
            return true;
        }
        try {
            JSONObject jSONObjectM8731e = m8731e();
            jSONObjectM8731e.put(MsgConstant.KEY_ALIAS, str);
            jSONObjectM8731e.put("type", str2);
            jSONObjectM8731e.put(MsgConstant.KEY_LAST_ALIAS, MessageSharedPrefs.getInstance(this.f9204f).getLastAlias(str2));
            jSONObjectM8731e.put(MsgConstant.KEY_TS, System.currentTimeMillis());
            aio aioVar = new aio(this.f9204f);
            pushResponseM1363a = aioVar.m1363a(aioVar.m1364a(jSONObjectM8731e), MsgConstant.ALIAS_EXCLUSIVE_ENDPOINT);
            if (pushResponseM1363a != null) {
                ahb.m1043c(f9195a, "addExclusiveAlias: " + pushResponseM1363a.code + ", " + pushResponseM1363a.description);
            }
        } catch (Exception e) {
            if (e != null) {
                e.printStackTrace();
            }
            m8716a(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 1);
        }
        if (pushResponseM1363a != null && pushResponseM1363a.code.equals(PushResponse.responseCode.SUCCESS)) {
            m8716a(MessageSharedPrefs.EnumC1608a.SUCCESS, str, str2, 3);
            m8723b(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 1);
            return true;
        }
        if (pushResponseM1363a != null && pushResponseM1363a.description != null) {
            if ((pushResponseM1363a.description.contains("Alias in process, try later!") || pushResponseM1363a.description.contains("Request time out!")) || pushResponseM1363a.description.contains("Server exception!")) {
                m8716a(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 1);
            } else {
                m8723b(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 1);
            }
        }
        if (pushResponseM1363a == null) {
            m8716a(MessageSharedPrefs.EnumC1608a.FAIL, str, str2, 1);
        }
        return false;
    }

    public void startCacheAlias(MessageSharedPrefs.EnumC1608a enumC1608a, int i) {
        String[] strArrSplit;
        String aliasType = MessageSharedPrefs.getInstance(this.f9204f).getAliasType(enumC1608a, i);
        if (aliasType.equals("") || (strArrSplit = aliasType.split(";")) == null || strArrSplit.length <= 0) {
            return;
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            String alias = MessageSharedPrefs.getInstance(this.f9204f).getAlias(enumC1608a, strArrSplit[i2], i);
            ahb.m1039a(f9195a, "alias:" + alias + ",type:" + strArrSplit[i2] + ",aliasFlag:" + enumC1608a);
            if (alias != null && !alias.equals("")) {
                switch (i) {
                    case 0:
                        addAlias(alias, strArrSplit[i2], true);
                        break;
                    case 1:
                        addExclusiveAlias(alias, strArrSplit[i2], true);
                        break;
                    case 2:
                        addAlias(alias, strArrSplit[i2], false);
                        break;
                    case 3:
                        addExclusiveAlias(alias, strArrSplit[i2], false);
                        break;
                }
            }
        }
    }

    public boolean removeAlias(String str, String str2) throws JSONException {
        if (TextUtils.isEmpty(str2)) {
            ahb.m1041b(f9195a, "removeAlias: empty type");
            return false;
        }
        if (!m8727c()) {
            return false;
        }
        JSONObject jSONObjectM8731e = m8731e();
        jSONObjectM8731e.put(MsgConstant.KEY_ALIAS, str);
        jSONObjectM8731e.put("type", str2);
        jSONObjectM8731e.put(MsgConstant.KEY_TS, System.currentTimeMillis());
        aio aioVar = new aio(this.f9204f);
        PushResponse pushResponseM1363a = aioVar.m1363a(aioVar.m1364a(jSONObjectM8731e), MsgConstant.DELETE_ALIAS_ENDPOINT);
        if (pushResponseM1363a != null) {
            ahb.m1043c(f9195a, "removeAlias: " + pushResponseM1363a.code + ", " + pushResponseM1363a.description);
        }
        if (pushResponseM1363a == null || !pushResponseM1363a.code.equals(PushResponse.responseCode.SUCCESS)) {
            return false;
        }
        m8723b(MessageSharedPrefs.EnumC1608a.SUCCESS, str, str2, 2);
        m8723b(MessageSharedPrefs.EnumC1608a.SUCCESS, str, str2, 3);
        return true;
    }

    /* JADX INFO: renamed from: c */
    private boolean m8727c() {
        if (TextUtils.isEmpty(ahc.m1064o(this.f9204f))) {
            ahb.m1041b(f9195a, "UTDID is empty");
            return false;
        }
        if (!TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f9204f).getDeviceToken())) {
            return true;
        }
        ahb.m1041b(f9195a, "RegistrationId is empty");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v5, types: [boolean] */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v8 */
    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: d */
    public String m8729d() throws Throwable {
        BufferedReader bufferedReader;
        String line;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (!Environment.getExternalStorageState().equals("mounted")) {
            return null;
        }
        String str = Environment.getExternalStorageDirectory().getPath() + "/data/" + this.f9204f.getPackageName() + "/";
        ahb.m1043c(f9195a, "path=" + str);
        File file = new File(str, "umeng-message.config");
        ?? Exists = file.exists();
        try {
            if (Exists == 0) {
                return null;
            }
            try {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e2) {
                e = e2;
                bufferedReader = null;
            } catch (IOException e3) {
                e = e3;
                bufferedReader = null;
            } catch (Throwable th) {
                th = th;
                Exists = 0;
                if (Exists != 0) {
                    try {
                        Exists.close();
                    } catch (IOException e4) {
                        e4.printStackTrace();
                    }
                }
                throw th;
            }
            do {
                try {
                    line = bufferedReader.readLine();
                    if (line == null) {
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e5) {
                                e = e5;
                                e.printStackTrace();
                            }
                        }
                    }
                } catch (FileNotFoundException e6) {
                    e = e6;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            e = e7;
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e8) {
                    e = e8;
                    e.printStackTrace();
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            e = e9;
                            e.printStackTrace();
                        }
                    }
                }
                return null;
            } while (!line.startsWith("sign="));
            String strSubstring = line.substring("sign=".length());
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
            return strSubstring;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e */
    public JSONObject m8731e() throws JSONException {
        String deviceToken = MessageSharedPrefs.getInstance(this.f9204f).getDeviceToken();
        String strM1064o = ahc.m1064o(this.f9204f);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MsgConstant.KEY_HEADER, this.f9201b);
        jSONObject.put(MsgConstant.KEY_UTDID, strM1064o);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    /* JADX INFO: renamed from: f */
    private JSONObject m8732f() throws JSONException {
        String deviceToken = MessageSharedPrefs.getInstance(this.f9204f).getDeviceToken();
        String strM1064o = ahc.m1064o(this.f9204f);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MsgConstant.KEY_HEADER, this.f9202c);
        jSONObject.put(MsgConstant.KEY_UTDID, strM1064o);
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, deviceToken);
        return jSONObject;
    }

    public void updateHeader() {
        ahd ahdVar = new ahd();
        ahdVar.m1080b(this.f9204f, new String[0]);
        ahdVar.m1077a(this.f9204f, PushAgent.getInstance(this.f9204f).getMessageAppkey(), PushAgent.getInstance(this.f9204f).getMessageChannel());
        this.f9201b = new JSONObject();
        try {
            ahdVar.m1078a(this.f9201b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        ahd ahdVar2 = new ahd();
        ahdVar2.m1083c(this.f9204f, new String[0]);
        ahdVar2.m1077a(this.f9204f, PushAgent.getInstance(this.f9204f).getMessageAppkey(), PushAgent.getInstance(this.f9204f).getMessageChannel());
        this.f9202c = new JSONObject();
        try {
            ahdVar2.m1081b(this.f9202c);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
