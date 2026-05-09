package com.umeng.message;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.local.UmengLocalNotificationService;
import java.util.List;
import java.util.Random;
import p000.ahb;
import p000.ahc;
import p000.ahh;
import p000.ahj;
import p000.ail;
import p000.aja;
import p000.apu;
import p000.apy;

/* JADX INFO: loaded from: classes.dex */
public class PushAgent {
    public static boolean DEBUG = false;

    /* JADX INFO: renamed from: a */
    private static PushAgent f9179a = null;

    /* JADX INFO: renamed from: d */
    private static boolean f9180d = false;

    /* JADX INFO: renamed from: e */
    private static final String f9181e = "com.umeng.message.PushAgent";

    /* JADX INFO: renamed from: b */
    private aja f9182b;

    /* JADX INFO: renamed from: c */
    private Context f9183c;

    /* JADX INFO: renamed from: f */
    private UHandler f9184f;

    /* JADX INFO: renamed from: g */
    private UHandler f9185g;

    /* JADX INFO: renamed from: h */
    private boolean f9186h = false;

    /* JADX INFO: renamed from: i */
    private boolean f9187i = true;

    /* JADX INFO: renamed from: j */
    private Handler f9188j;

    /* JADX INFO: renamed from: k */
    private IUmengRegisterCallback f9189k;

    /* JADX INFO: renamed from: l */
    private IUmengUnregisterCallback f9190l;

    private PushAgent(Context context) {
        try {
            this.f9183c = context;
            this.f9182b = aja.m1466a(context);
            this.f9184f = new UmengMessageHandler();
            this.f9185g = new UmengNotificationClickHandler();
        } catch (Exception e) {
            ahb.m1041b(f9181e, e.getMessage());
        }
        this.f9188j = new Handler(context.getMainLooper()) { // from class: com.umeng.message.PushAgent.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                super.handleMessage(message);
            }
        };
    }

    public static synchronized PushAgent getInstance(Context context) {
        if (f9179a == null) {
            f9179a = new PushAgent(context.getApplicationContext());
        }
        return f9179a;
    }

    public void enable() {
        try {
            if (!ail.m1344a(this.f9183c, UmengLocalNotificationService.class.getName())) {
                ahj.m1134a(this.f9183c).m1142c();
            }
            String strM1338a = ail.m1338a(this.f9183c, Process.myPid());
            ahb.m1043c(f9181e, "processName=" + strM1338a);
            if (this.f9183c.getPackageName().equals(strM1338a)) {
                if (Build.VERSION.SDK_INT < 8) {
                    ahb.m1041b(f9181e, "Push SDK does not work for Android Verion < 8");
                    return;
                }
                if (!ail.m1343a(this.f9183c, this.f9188j)) {
                    ahb.m1041b(f9181e, "Need to correct AndroidManifest config according to instruction from http://dev.umeng.com/push/android/integration");
                    return;
                }
                ahb.m1043c(f9181e, "The AndroidManifest config is right");
                ail.m1341a(this.f9183c, (Class<?>) UmengMessageCallbackHandlerService.class);
                UmengRegistrar.setAgooMode(this.f9183c, apy.TAOBAO);
                UmengRegistrar.register(this.f9183c, getMessageAppkey(), getMessageSecret());
            }
        } catch (Exception e) {
            ahb.m1041b(f9181e, e.getMessage());
        }
    }

    public void enable(IUmengRegisterCallback iUmengRegisterCallback) {
        setRegisterCallback(iUmengRegisterCallback);
        enable();
    }

    public void disable() {
        try {
            String strM1338a = ail.m1338a(this.f9183c, Process.myPid());
            ahb.m1043c(f9181e, "processName=" + strM1338a);
            if (this.f9183c.getPackageName().equals(strM1338a) && UmengRegistrar.isRegistered(this.f9183c)) {
                UmengRegistrar.unregister(this.f9183c);
            }
        } catch (Exception e) {
            ahb.m1041b(f9181e, e.getMessage());
        }
    }

    public void disable(IUmengUnregisterCallback iUmengUnregisterCallback) {
        setUnregisterCallback(iUmengUnregisterCallback);
        disable();
    }

    public boolean isEnabled() {
        try {
            return MessageSharedPrefs.getInstance(this.f9183c).m8700g();
        } catch (Exception e) {
            ahb.m1041b(f9181e, e.getMessage());
            return false;
        }
    }

    public void setMessageHandler(UHandler uHandler) {
        this.f9184f = uHandler;
    }

    public UHandler getMessageHandler() {
        return this.f9184f;
    }

    public void setNotificationClickHandler(UHandler uHandler) {
        this.f9185g = uHandler;
    }

    public UHandler getNotificationClickHandler() {
        return this.f9185g;
    }

    public aja getTagManager() {
        return this.f9182b;
    }

    @Deprecated
    public boolean addAlias(String str, String str2) {
        return UTrack.getInstance(this.f9183c).addAlias(str, str2, true);
    }

    public void setAlias(String str, String str2) {
        UTrack.getInstance(this.f9183c).setAlias(str, str2);
    }

    public void setExclusiveAlias(String str, String str2) {
        UTrack.getInstance(this.f9183c).setExclusiveAlias(str, str2);
    }

    @Deprecated
    public boolean addExclusiveAlias(String str, String str2) {
        return UTrack.getInstance(this.f9183c).addExclusiveAlias(str, str2, true);
    }

    public boolean removeAlias(String str, String str2) {
        return UTrack.getInstance(this.f9183c).removeAlias(str, str2);
    }

    public String getMessageSecret() {
        String messageAppSecret = MessageSharedPrefs.getInstance(this.f9183c).getMessageAppSecret();
        return TextUtils.isEmpty(messageAppSecret) ? ahc.m1051b(this.f9183c, "UMENG_MESSAGE_SECRET") : messageAppSecret;
    }

    public String getMessageAppkey() {
        String messageAppKey = MessageSharedPrefs.getInstance(this.f9183c).getMessageAppKey();
        return TextUtils.isEmpty(messageAppKey) ? ahc.m1057h(this.f9183c) : messageAppKey;
    }

    public String getMessageChannel() {
        String messageChannel = MessageSharedPrefs.getInstance(this.f9183c).getMessageChannel();
        return TextUtils.isEmpty(messageChannel) ? ahc.m1061l(this.f9183c) : messageChannel;
    }

    public void onAppStart() {
        new Thread(new Runnable() { // from class: com.umeng.message.PushAgent.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    UTrack.getInstance(PushAgent.this.f9183c).startCacheAlias(MessageSharedPrefs.EnumC1608a.FAIL, 0);
                    UTrack.getInstance(PushAgent.this.f9183c).startCacheAlias(MessageSharedPrefs.EnumC1608a.FAIL, 1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        UmengRegistrar.checkRegisteredToUmeng(this.f9183c);
        if (UmengRegistrar.isRegistered(this.f9183c)) {
            if (MessageSharedPrefs.getInstance(this.f9183c).getAppLaunchLogSendPolicy() == 1) {
                ahb.m1043c(f9181e, "launch_policy=1, skip sending app launch info.");
            } else if (!MessageSharedPrefs.getInstance(this.f9183c).hasAppLaunchLogSentToday()) {
                UTrack.getInstance(this.f9183c).trackAppLaunch(10000L);
            }
            UTrack.getInstance(this.f9183c).sendCachedMsgLog(isAppLaunchByMessage() ? Math.abs(new Random().nextLong() % MsgConstant.f9162a) : 0L);
        }
    }

    public <U extends UmengBaseIntentService> void setPushIntentServiceClass(Class<U> cls) {
        MessageSharedPrefs.getInstance(this.f9183c).setPushIntentServiceClass(cls);
    }

    public String getPushIntentServiceClass() {
        return MessageSharedPrefs.getInstance(this.f9183c).getPushIntentServiceClass();
    }

    public void setDebugMode(boolean z) {
        ahb.f909a = z;
        apu.m4928a(this.f9183c, z, false);
    }

    public void setNoDisturbMode(int i, int i2, int i3, int i4) {
        MessageSharedPrefs.getInstance(this.f9183c).m8688a(i, i2, i3, i4);
    }

    public int getNoDisturbStartHour() {
        return MessageSharedPrefs.getInstance(this.f9183c).m8686a();
    }

    public int getNoDisturbStartMinute() {
        return MessageSharedPrefs.getInstance(this.f9183c).m8691b();
    }

    public int getNoDisturbEndHour() {
        return MessageSharedPrefs.getInstance(this.f9183c).m8693c();
    }

    public int getNoDisturbEndMinute() {
        return MessageSharedPrefs.getInstance(this.f9183c).m8695d();
    }

    public static void setAppLaunchByMessage() {
        f9180d = true;
    }

    public static boolean isAppLaunchByMessage() {
        return f9180d;
    }

    public boolean isRegistered() {
        return UmengRegistrar.isRegistered(this.f9183c);
    }

    public String getRegistrationId() {
        return UmengRegistrar.getRegistrationId(this.f9183c);
    }

    public boolean getMergeNotificaiton() {
        return MessageSharedPrefs.getInstance(this.f9183c).getMergeNotificaiton();
    }

    public void setMergeNotificaiton(boolean z) {
        MessageSharedPrefs.getInstance(this.f9183c).setMergeNotificaiton(z);
    }

    public void setAppkeyAndSecret(String str, String str2) {
        String messageAppKey = MessageSharedPrefs.getInstance(this.f9183c).getMessageAppKey();
        String messageAppSecret = MessageSharedPrefs.getInstance(this.f9183c).getMessageAppSecret();
        if (!messageAppKey.equals(str) && !messageAppSecret.equals(str2)) {
            MessageSharedPrefs.getInstance(this.f9183c).clearSharedPrefs();
        }
        MessageSharedPrefs.getInstance(this.f9183c).setMessageAppKey(str);
        MessageSharedPrefs.getInstance(this.f9183c).setMessageAppSecret(str2);
        UTrack.getInstance(this.f9183c).updateHeader();
    }

    public void setMessageChannel(String str) {
        MessageSharedPrefs.getInstance(this.f9183c).setMessageChannel(str);
        UTrack.getInstance(this.f9183c).updateHeader();
    }

    public void setRegisterCallback(IUmengRegisterCallback iUmengRegisterCallback) {
        this.f9189k = iUmengRegisterCallback;
    }

    public IUmengRegisterCallback getRegisterCallback() {
        return this.f9189k;
    }

    public void setUnregisterCallback(IUmengUnregisterCallback iUmengUnregisterCallback) {
        this.f9190l = iUmengUnregisterCallback;
    }

    public IUmengUnregisterCallback getUnregisterCallback() {
        return this.f9190l;
    }

    public void setMuteDurationSeconds(int i) {
        MessageSharedPrefs.getInstance(this.f9183c).m8687a(i);
    }

    public int getMuteDurationSeconds() {
        return MessageSharedPrefs.getInstance(this.f9183c).m8704k();
    }

    public boolean isIncludesUmengUpdateSDK() {
        Class<?> cls;
        try {
            cls = Class.forName("ajd");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            cls = null;
        }
        return cls != null;
    }

    public boolean getNotificationOnForeground() {
        return MessageSharedPrefs.getInstance(this.f9183c).getNotificaitonOnForeground();
    }

    public void setNotificaitonOnForeground(boolean z) {
        MessageSharedPrefs.getInstance(this.f9183c).setNotificaitonOnForeground(z);
    }

    public String getResourcePackageName() {
        return MessageSharedPrefs.getInstance(this.f9183c).getResourcePackageName();
    }

    public void setResourcePackageName(String str) {
        MessageSharedPrefs.getInstance(this.f9183c).setResourcePackageName(str);
    }

    public boolean isPushCheck() {
        return this.f9186h;
    }

    public void setPushCheck(boolean z) {
        this.f9186h = z;
    }

    public int getNotificationPlayVibrate() {
        return MessageSharedPrefs.getInstance(this.f9183c).getNotificationPlayVibrate();
    }

    public void setNotificationPlayVibrate(int i) {
        MessageSharedPrefs.getInstance(this.f9183c).setNotificationPlayVibrate(i);
    }

    public int getNotificationPlayLights() {
        return MessageSharedPrefs.getInstance(this.f9183c).getNotificationPlayLights();
    }

    public void setNotificationPlayLights(int i) {
        MessageSharedPrefs.getInstance(this.f9183c).setNotificationPlayLights(i);
    }

    public int getNotificationPlaySound() {
        return MessageSharedPrefs.getInstance(this.f9183c).getNotificationPlaySound();
    }

    public void setNotificationPlaySound(int i) {
        MessageSharedPrefs.getInstance(this.f9183c).setNotificationPlaySound(i);
    }

    public boolean addLocalNotification(ahh ahhVar) {
        return ahj.m1134a(this.f9183c).m1138a(ahhVar);
    }

    public boolean updateLocalNotification(ahh ahhVar) {
        return ahj.m1134a(this.f9183c).m1141b(ahhVar);
    }

    public boolean deleteLocalNotification(String str) {
        return ahj.m1134a(this.f9183c).m1143c(str);
    }

    public boolean clearLocalNotifications() {
        return ahj.m1134a(this.f9183c).m1140b();
    }

    public ahh findLocalNotification(String str) {
        return ahj.m1134a(this.f9183c).m1136a(str);
    }

    public List<ahh> findLocalNotifications(String str) {
        return ahj.m1134a(this.f9183c).m1139b(str);
    }

    public List<ahh> findAllLocalNotifications() {
        return ahj.m1134a(this.f9183c).m1137a();
    }

    public boolean getLocalNotificationIntervalLimit() {
        return MessageSharedPrefs.getInstance(this.f9183c).m8705l();
    }

    public void setLocalNotificationIntervalLimit(boolean z) {
        MessageSharedPrefs.getInstance(this.f9183c).m8689a(z);
    }
}
