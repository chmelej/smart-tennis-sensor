package cn.smssdk;

import android.content.Context;
import android.telephony.SmsMessage;
import cn.smssdk.gui.BuildConfig;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SMSSDK {
    public static final int EVENT_GET_CONTACTS = 4;
    public static final int EVENT_GET_FRIENDS_IN_APP = 6;
    public static final int EVENT_GET_NEW_FRIENDS_COUNT = 7;
    public static final int EVENT_GET_SUPPORTED_COUNTRIES = 1;
    public static final int EVENT_GET_VERIFICATION_CODE = 2;
    public static final int EVENT_GET_VOICE_VERIFICATION_CODE = 8;
    public static final int EVENT_SUBMIT_USER_INFO = 5;
    public static final int EVENT_SUBMIT_VERIFICATION_CODE = 3;
    public static final int RESULT_COMPLETE = -1;
    public static final int RESULT_ERROR = 0;

    /* JADX INFO: renamed from: a */
    private static C0914a f5960a;

    public interface VerifyCodeReadListener {
        void onReadVerifyCode(String str);
    }

    public static String getVersion() {
        return BuildConfig.VERSION_NAME;
    }

    public static void initSDK(Context context, String str, String str2) {
        initSDK(context, str, str2, false);
    }

    public static void initSDK(Context context, String str, String str2, boolean z) {
        if (f5960a == null) {
            f5960a = new C0914a(context, str, str2);
            if (z) {
                f5960a.m6607d();
            }
            f5960a.m6598a();
        }
    }

    public static void registerEventHandler(EventHandler eventHandler) {
        m6580a();
        f5960a.m6601a(eventHandler);
    }

    public static void unregisterEventHandler(EventHandler eventHandler) {
        m6580a();
        f5960a.m6604b(eventHandler);
    }

    public static void unregisterAllEventHandler() {
        m6580a();
        f5960a.m6603b();
    }

    /* JADX INFO: renamed from: a */
    private static void m6580a() {
        if (f5960a == null) {
            throw new NullPointerException("Please call SMSSDK.initSDK(Context, String, String) before any action.");
        }
    }

    public static void getSupportedCountries() {
        m6580a();
        f5960a.m6599a(1, (Object) null);
    }

    public static void getVerificationCode(String str, String str2) {
        getVerificationCode(str, str2, null);
    }

    public static void getVerificationCode(String str, String str2, OnSendMessageHandler onSendMessageHandler) {
        getVerificationCode(str, str2, null, onSendMessageHandler);
    }

    public static void getVerificationCode(String str, String str2, String str3, OnSendMessageHandler onSendMessageHandler) {
        getVerificationCode(str, str2, null, str3, onSendMessageHandler);
    }

    public static void getVerificationCode(String str, String str2, String str3, String str4, OnSendMessageHandler onSendMessageHandler) {
        m6580a();
        f5960a.m6599a(2, new Object[]{str, str2, str3, str4, onSendMessageHandler});
    }

    public static void submitVerificationCode(String str, String str2, String str3) {
        m6580a();
        f5960a.m6599a(3, new String[]{str, str2, str3});
    }

    public static void getContacts(boolean z) {
        m6580a();
        f5960a.m6599a(4, Boolean.valueOf(z));
    }

    public static void submitUserInfo(String str, String str2, String str3, String str4, String str5) {
        m6580a();
        f5960a.m6599a(5, new String[]{str, str2, str3, str4, str5});
    }

    public static void getFriendsInApp() {
        m6580a();
        f5960a.m6599a(6, (Object) null);
    }

    public static void getNewFriendsCount() {
        m6580a();
        f5960a.m6599a(7, (Object) null);
    }

    public static HashMap<Character, ArrayList<String[]>> getGroupedCountryList() {
        m6580a();
        return f5960a.m6606c();
    }

    public static String[] getCountry(String str) {
        m6580a();
        return f5960a.m6602a(str);
    }

    public static String[] getCountryByMCC(String str) {
        m6580a();
        return f5960a.m6605b(str);
    }

    public static void readVerificationCode(SmsMessage smsMessage, VerifyCodeReadListener verifyCodeReadListener) {
        m6580a();
        f5960a.m6600a(smsMessage, verifyCodeReadListener);
    }

    public static void getVoiceVerifyCode(String str, String str2) {
        getVoiceVerifyCode(str, str2, null);
    }

    public static void getVoiceVerifyCode(String str, String str2, String str3) {
        m6580a();
        f5960a.m6599a(8, new String[]{str2, str, str3});
    }
}
