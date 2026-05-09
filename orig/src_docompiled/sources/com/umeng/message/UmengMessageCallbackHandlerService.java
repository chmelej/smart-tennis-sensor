package com.umeng.message;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Process;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.umeng.message.MessageSharedPrefs;
import java.lang.reflect.Method;
import org.json.JSONObject;
import p000.ahf;
import p000.ail;

/* JADX INFO: loaded from: classes.dex */
public class UmengMessageCallbackHandlerService extends Service {
    public static final String TAG = "com.umeng.message.UmengMessageCallbackHandlerService";

    /* JADX INFO: renamed from: a */
    private Context f9241a = this;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    public UmengMessageCallbackHandlerService() {
    }

    public UmengMessageCallbackHandlerService(String str) {
    }

    @Override // android.app.Service
    @SuppressLint({"NewApi"})
    public int onStartCommand(Intent intent, int i, int i2) {
        String strM1338a = ail.m1338a(this.f9241a, Process.myPid());
        Log.d(TAG, "processName=" + strM1338a);
        if (intent.getAction().equals(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION)) {
            try {
                MessageSharedPrefs.getInstance(this.f9241a).m8697e();
                String stringExtra = intent.getStringExtra(MsgConstant.KEY_REGISTRATION_ID);
                Log.d(TAG, "enable(): register-->:" + stringExtra);
                IUmengRegisterCallback registerCallback = PushAgent.getInstance(this.f9241a).getRegisterCallback();
                if (registerCallback != null) {
                    registerCallback.onRegistered(stringExtra);
                }
                if (!stringExtra.equals(MessageSharedPrefs.getInstance(this).getDeviceToken())) {
                    MessageSharedPrefs.getInstance(this).setDeviceToken(stringExtra);
                    new Thread(new Runnable() { // from class: com.umeng.message.UmengMessageCallbackHandlerService.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                UTrack.getInstance(UmengMessageCallbackHandlerService.this).startCacheAlias(MessageSharedPrefs.EnumC1608a.SUCCESS, 2);
                                UTrack.getInstance(UmengMessageCallbackHandlerService.this).startCacheAlias(MessageSharedPrefs.EnumC1608a.SUCCESS, 3);
                                UTrack.getInstance(UmengMessageCallbackHandlerService.this).startCacheAlias(MessageSharedPrefs.EnumC1608a.FAIL, 0);
                                UTrack.getInstance(UmengMessageCallbackHandlerService.this).startCacheAlias(MessageSharedPrefs.EnumC1608a.FAIL, 1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }).start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (intent.getAction().equals(MsgConstant.MESSAGE_UNREGISTER_CALLBACK_ACTION)) {
            try {
                MessageSharedPrefs.getInstance(this.f9241a).m8699f();
                Log.d(TAG, "disable(): unregister");
                IUmengUnregisterCallback unregisterCallback = PushAgent.getInstance(this.f9241a).getUnregisterCallback();
                if (unregisterCallback != null) {
                    unregisterCallback.onUnregistered(intent.getStringExtra(MsgConstant.KEY_REGISTRATION_ID));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else if (intent.getAction().equals(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION)) {
            try {
                UHandler messageHandler = PushAgent.getInstance(this.f9241a).getMessageHandler();
                Log.d(TAG, "messageHandler=" + messageHandler);
                if (messageHandler != null) {
                    ahf ahfVar = new ahf(new JSONObject(intent.getStringExtra("body")));
                    ahfVar.f976b = intent.getStringExtra("id");
                    ahfVar.f977c = intent.getStringExtra("task_id");
                    messageHandler.handleMessage(this.f9241a, ahfVar);
                }
            } catch (Exception e3) {
                Log.d(TAG, e3.toString());
            }
        } else if (intent.getAction().equals(MsgConstant.MESSAGE_AUTOUPDATE_HANDLER_ACTION)) {
            try {
                ahf ahfVar2 = new ahf(new JSONObject(intent.getStringExtra("body")));
                ahfVar2.f976b = intent.getStringExtra("id");
                ahfVar2.f977c = intent.getStringExtra("task_id");
                m8748a(this.f9241a, ahfVar2);
            } catch (Exception e4) {
                Log.d(TAG, e4.toString());
            }
        }
        stopSelf();
        return super.onStartCommand(intent, i, i2);
    }

    /* JADX INFO: renamed from: a */
    private void m8748a(Context context, ahf ahfVar) {
        if (PushAgent.getInstance(context).isIncludesUmengUpdateSDK() && (!ail.m1348b(context) || !ail.m1342a(context) || PushAgent.getInstance(context).getNotificationOnForeground())) {
            LocalBroadcastManager.getInstance(context).registerReceiver(new UpdateActionReceiver(ahfVar), new IntentFilter("com.umeng.message.action.autoupdate"));
            try {
                Class<?> cls = Class.forName("ajd");
                Method method = cls.getMethod("setUpdateAutoPopup", Boolean.TYPE);
                Method method2 = cls.getMethod("update", Context.class);
                Method method3 = cls.getMethod("setUpdateFromPushMessage", Boolean.TYPE);
                method.invoke(cls, false);
                method3.invoke(cls, true);
                method2.invoke(cls, context);
                Log.d(TAG, "autoUpdate");
                return;
            } catch (Exception e) {
                e.printStackTrace();
                Log.d(TAG, e.toString());
                return;
            }
        }
        UTrack.getInstance(context).setClearPrevMessage(false);
        UTrack.getInstance(context).trackMsgDismissed(ahfVar);
    }
}
