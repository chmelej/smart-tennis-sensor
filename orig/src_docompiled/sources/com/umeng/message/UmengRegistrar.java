package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import java.util.Iterator;
import java.util.Map;
import p000.ahb;
import p000.aiq;
import p000.apq;
import p000.apu;
import p000.apx;

/* JADX INFO: loaded from: classes.dex */
public class UmengRegistrar extends apx {

    /* JADX INFO: renamed from: a */
    private static final String f9251a = "com.umeng.message.UmengRegistrar";

    public static final void checkManifest(Context context) {
    }

    public static apq getIMtopService(Context context) {
        return apx.m4962a(context);
    }

    public static void register(Context context, String str, String str2) {
        if (Build.VERSION.SDK_INT < 8) {
            ahb.m1041b(f9251a, "Push SDK does not work for Android Verion < 8");
            return;
        }
        if (TextUtils.isEmpty(str)) {
            throw new NullPointerException("appKey==null");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new NullPointerException("appSecret==null");
        }
        aiq.m1370a(context, (Class<?>[]) new Class[]{SystemReceiver.class, RegistrationReceiver.class, MessageReceiver.class});
        apu.m4933c(context, "umeng");
        m4963a(context, "umeng:" + str, str2, "android@umeng");
    }

    /* JADX INFO: renamed from: a */
    static void m8754a(Context context, boolean z) {
        if (context == null) {
            ahb.m1041b(f9251a, "setRegisteredToUmeng: null context");
            return;
        }
        String registrationId = getRegistrationId(context);
        if (TextUtils.isEmpty(registrationId)) {
            ahb.m1041b(f9251a, "setRegisteredToUmeng: empty registration id");
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, Build.VERSION.SDK_INT > 11 ? 4 : 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        Map<String, ?> all = sharedPreferences.getAll();
        if (all != null && all.size() > 0) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.startsWith(MsgConstant.KEY_REGISTERED_TO_UMENG)) {
                    editorEdit.remove(key);
                }
            }
        }
        editorEdit.putBoolean(MsgConstant.KEY_REGISTERED_TO_UMENG + registrationId, z).commit();
    }

    public static boolean isRegisteredToUmeng(Context context) {
        if (context == null) {
            ahb.m1041b(f9251a, "isRegisteredToUmeng: null context");
            return false;
        }
        String registrationId = getRegistrationId(context);
        if (TextUtils.isEmpty(registrationId)) {
            ahb.m1041b(f9251a, "isRegisteredToUmeng: empty registration id");
            return false;
        }
        return MessageSharedPrefs.getInstance(context).m8690a(registrationId);
    }

    public static void registerToUmeng(Context context) {
        UTrack.getInstance(context).trackRegister();
    }

    public static void checkRegisteredToUmeng(Context context) {
        if (isRegisteredToUmeng(context)) {
            return;
        }
        registerToUmeng(context);
    }
}
