package com.umeng.message;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Map;
import p000.ahc;

/* JADX INFO: loaded from: classes.dex */
public class MessageSharedPrefs {

    /* JADX INFO: renamed from: a */
    private static final String f9148a = "com.umeng.message.MessageSharedPrefs";

    /* JADX INFO: renamed from: d */
    private static MessageSharedPrefs f9149d;

    /* JADX INFO: renamed from: b */
    private Context f9150b;

    /* JADX INFO: renamed from: c */
    private SharedPreferences f9151c;

    /* JADX INFO: renamed from: e */
    private int f9152e = 0;

    /* JADX INFO: renamed from: com.umeng.message.MessageSharedPrefs$a */
    enum EnumC1608a {
        SUCCESS("SUCCESS_"),
        FAIL("FAIL_");


        /* JADX INFO: renamed from: c */
        private String f9156c;

        EnumC1608a(String str) {
            this.f9156c = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.f9156c;
        }
    }

    private MessageSharedPrefs(Context context) {
        this.f9150b = context;
        if (Build.VERSION.SDK_INT > 11) {
            this.f9152e |= 4;
        }
        this.f9151c = context.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, this.f9152e);
        Log.d(f9148a, "Constructor()");
    }

    public static synchronized MessageSharedPrefs getInstance(Context context) {
        if (f9149d == null) {
            f9149d = new MessageSharedPrefs(context);
        }
        return f9149d;
    }

    public void setAppLaunchLogSentAt(long j) {
        this.f9151c.edit().putLong(MsgConstant.KEY_LAUNCH_LOG_SENT_MARK, Calendar.getInstance().getTimeInMillis()).commit();
    }

    public long getAppLaunchLogSentAt() {
        return this.f9151c.getLong(MsgConstant.KEY_LAUNCH_LOG_SENT_MARK, 0L);
    }

    public boolean hasAppLaunchLogSentToday() {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTimeInMillis(MsgLogStore.getInstance(this.f9150b).getMsgConfigInfo_AppLaunchAt());
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(f9148a, e.toString());
        }
        Calendar calendar2 = Calendar.getInstance();
        return calendar.get(6) == calendar2.get(6) && calendar.get(1) == calendar2.get(1);
    }

    public <U extends UmengBaseIntentService> void setPushIntentServiceClass(Class<U> cls) {
        if (cls == null) {
            this.f9151c.edit().remove(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME).remove(MsgConstant.KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE).commit();
            return;
        }
        String name = cls.getName();
        this.f9151c.edit().putString(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, name).putString(MsgConstant.KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE, ahc.m1048a(this.f9150b)).commit();
    }

    public String getPushIntentServiceClass() {
        String string = this.f9151c.getString(MsgConstant.KEY_PUSH_INTENT_SERVICE_CLASSNAME, MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME);
        String string2 = this.f9151c.getString(MsgConstant.KEY_SET_PUSH_INTENT_SERVICE_VERSION_CODE, null);
        String strM1048a = ahc.m1048a(this.f9150b);
        try {
            Class.forName(string);
            return (!TextUtils.equals(string2, strM1048a) || TextUtils.equals(strM1048a, "Unknown")) ? MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME : string;
        } catch (ClassNotFoundException unused) {
            return MsgConstant.DEFAULT_INTENT_SERVICE_CLASS_NAME;
        }
    }

    public void setMergeNotificaiton(boolean z) {
        this.f9151c.edit().putBoolean(MsgConstant.KEY_MERGE_NOTIFICATION, z).commit();
    }

    public boolean getMergeNotificaiton() {
        return this.f9151c.getBoolean(MsgConstant.KEY_MERGE_NOTIFICATION, true);
    }

    public void setMessageAppKey(String str) {
        this.f9151c.edit().putString(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY, str).commit();
    }

    public String getMessageAppKey() {
        return this.f9151c.getString(MsgConstant.KEY_UMENG_MESSAGE_APP_KEY, "");
    }

    public void setMessageAppSecret(String str) {
        this.f9151c.edit().putString(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, str).commit();
    }

    public String getMessageAppSecret() {
        return this.f9151c.getString(MsgConstant.KEY_UMENG_MESSAGE_APP_SECRET, "");
    }

    public void setMessageChannel(String str) {
        this.f9151c.edit().putString(MsgConstant.KEY_UMENG_MESSAGE_APP_CHANNEL, str).commit();
    }

    public String getMessageChannel() {
        return this.f9151c.getString(MsgConstant.KEY_UMENG_MESSAGE_APP_CHANNEL, "");
    }

    public void setAppLaunchLogSendPolicy(int i) {
        this.f9151c.edit().putInt(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, i).commit();
    }

    public void setTagSendPolicy(int i) {
        this.f9151c.edit().putInt(MsgConstant.KEY_TAG_SEND_POLICY, i).commit();
    }

    public int getAppLaunchLogSendPolicy() {
        return this.f9151c.getInt(MsgConstant.KEY_APP_LAUNCH_LOG_SEND_POLICY, -1);
    }

    public int getTagSendPolicy() {
        return this.f9151c.getInt(MsgConstant.KEY_TAG_SEND_POLICY, -1);
    }

    public String getAliasType(EnumC1608a enumC1608a, int i) {
        return this.f9151c.getString("ALIAS" + enumC1608a.toString() + i, "");
    }

    public void saveAliasType(EnumC1608a enumC1608a, String str, int i) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        editorEdit.putString("ALIAS" + enumC1608a.toString() + i, str);
        editorEdit.commit();
    }

    public void clearSharedPrefs() {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public boolean isAliasType(EnumC1608a enumC1608a, String str, int i) {
        String[] strArrSplit;
        String aliasType = getInstance(this.f9150b).getAliasType(enumC1608a, i);
        if (aliasType.equals("")) {
            strArrSplit = new String[0];
        } else {
            strArrSplit = aliasType.split(";");
        }
        for (String str2 : strArrSplit) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public void removeAliasTypeSingle(EnumC1608a enumC1608a, String str, int i) {
        String[] strArrSplit;
        String aliasType = getInstance(this.f9150b).getAliasType(enumC1608a, i);
        String str2 = "";
        if (aliasType.equals("")) {
            strArrSplit = new String[0];
        } else {
            strArrSplit = aliasType.split(";");
        }
        for (int i2 = 0; i2 < strArrSplit.length; i2++) {
            if (!str.equals(strArrSplit[i2])) {
                str2 = str2.equals("") ? str2 + strArrSplit[i2] : str2 + ";" + strArrSplit[i2];
            }
        }
        if (str2.equals("")) {
            getInstance(this.f9150b).removeAliasType(enumC1608a, i);
        } else {
            getInstance(this.f9150b).saveAliasType(enumC1608a, str2, i);
        }
    }

    public void addAliasTypeSingle(EnumC1608a enumC1608a, String str, String str2, int i) {
        String aliasType = getInstance(this.f9150b).getAliasType(enumC1608a, i);
        if (!getInstance(this.f9150b).isAliasType(enumC1608a, str2, i)) {
            if (aliasType.equals("")) {
                aliasType = aliasType + str2;
            } else {
                aliasType = aliasType + ";" + str2;
            }
        }
        if (aliasType.equals("")) {
            return;
        }
        getInstance(this.f9150b).saveAliasType(enumC1608a, aliasType, i);
    }

    public void removeAliasType(EnumC1608a enumC1608a, int i) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        editorEdit.remove("ALIAS" + enumC1608a.toString() + i);
        editorEdit.commit();
    }

    public void addAlias(EnumC1608a enumC1608a, String str, String str2, int i) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        editorEdit.putString("ALIAS" + enumC1608a.toString() + i + "_" + str2, str);
        editorEdit.commit();
    }

    public String getAlias(EnumC1608a enumC1608a, String str, int i) {
        return this.f9151c.getString("ALIAS" + enumC1608a.toString() + i + "_" + str, "");
    }

    public void removeAlias(EnumC1608a enumC1608a, String str, String str2, int i) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        editorEdit.remove("ALIAS" + enumC1608a.toString() + i + "_" + str2);
        editorEdit.commit();
    }

    public String getLastAlias(String str) {
        return this.f9151c.getString(String.format("ALIAS_%s", str), "");
    }

    public boolean isAliasSet(EnumC1608a enumC1608a, int i, String str, String str2) {
        return str != null && str.equals(this.f9151c.getString(String.format("ALIAS%s%d_%s", enumC1608a.toString(), Integer.valueOf(i), str2), null));
    }

    public boolean isAliaseTypeSet(EnumC1608a enumC1608a, int i, String str) {
        return this.f9151c.contains(String.format("ALIAS%s%d_%s", enumC1608a.toString(), Integer.valueOf(i), str));
    }

    public int getAliasCount(EnumC1608a enumC1608a, int i) {
        String[] strArrSplit;
        String aliasType = getInstance(this.f9150b).getAliasType(enumC1608a, i);
        if (aliasType.equals("")) {
            strArrSplit = new String[0];
        } else {
            strArrSplit = aliasType.split(";");
        }
        return strArrSplit.length;
    }

    public void addTags(String... strArr) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        for (String str : strArr) {
            String str2 = String.format("UMENG_TAG_%s", str);
            if (!this.f9151c.getBoolean(str2, false)) {
                editorEdit.putBoolean(str2, true);
                editorEdit.putInt("UMENG_TAG_COUNT", getTagCount() + 1);
            }
        }
        editorEdit.commit();
    }

    public void removeTags(String... strArr) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        for (String str : strArr) {
            String str2 = String.format("UMENG_TAG_%s", str);
            if (this.f9151c.getBoolean(str2, false)) {
                editorEdit.remove(str2);
                editorEdit.putInt("UMENG_TAG_COUNT", getTagCount() - 1);
            }
        }
        editorEdit.commit();
    }

    public boolean isTagSet(String str) {
        return this.f9151c.getBoolean(String.format("UMENG_TAG_%s", str), false);
    }

    public int getTagCount() {
        return this.f9151c.getInt("UMENG_TAG_COUNT", 0);
    }

    public void setTagRemain(int i) {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        editorEdit.putInt("UMENG_TAG_REMAIN", i);
        editorEdit.commit();
    }

    public int getTagRemain() {
        return this.f9151c.getInt("UMENG_TAG_REMAIN", 64);
    }

    public void resetTags() {
        SharedPreferences.Editor editorEdit = this.f9151c.edit();
        Map<String, ?> all = this.f9151c.getAll();
        if (all != null && all.size() > 0) {
            Iterator<Map.Entry<String, ?>> it = all.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (key.startsWith("UMENG_TAG_")) {
                    editorEdit.remove(key);
                }
            }
        }
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: a */
    void m8688a(int i, int i2, int i3, int i4) {
        this.f9151c.edit().putInt(MsgConstant.KEY_NO_DISTURB_START_HOUR, i).putInt(MsgConstant.KEY_NO_DISTURB_START_MINUTE, i2).putInt(MsgConstant.KEY_NO_DISTURB_END_HOUR, i3).putInt(MsgConstant.KEY_NO_DISTURB_END_MINUTE, i4).commit();
    }

    /* JADX INFO: renamed from: a */
    int m8686a() {
        return this.f9151c.getInt(MsgConstant.KEY_NO_DISTURB_START_HOUR, 23);
    }

    /* JADX INFO: renamed from: b */
    int m8691b() {
        return this.f9151c.getInt(MsgConstant.KEY_NO_DISTURB_START_MINUTE, 0);
    }

    /* JADX INFO: renamed from: c */
    int m8693c() {
        return this.f9151c.getInt(MsgConstant.KEY_NO_DISTURB_END_HOUR, 7);
    }

    /* JADX INFO: renamed from: d */
    int m8695d() {
        return this.f9151c.getInt(MsgConstant.KEY_NO_DISTURB_END_MINUTE, 0);
    }

    /* JADX INFO: renamed from: e */
    void m8697e() {
        this.f9151c.edit().putBoolean(MsgConstant.KEY_ENEABLED, true).commit();
    }

    /* JADX INFO: renamed from: f */
    void m8699f() {
        this.f9151c.edit().putBoolean(MsgConstant.KEY_ENEABLED, false).commit();
    }

    /* JADX INFO: renamed from: g */
    boolean m8700g() {
        return this.f9151c.getBoolean(MsgConstant.KEY_ENEABLED, false);
    }

    /* JADX INFO: renamed from: a */
    boolean m8690a(String str) {
        return this.f9150b.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, this.f9152e).getBoolean(MsgConstant.KEY_REGISTERED_TO_UMENG + str, false);
    }

    /* JADX INFO: renamed from: h */
    boolean m8701h() {
        return this.f9151c.getBoolean(MsgConstant.KEY_CACHE_FILE_TRANSFER_TO_SQL, false);
    }

    /* JADX INFO: renamed from: i */
    boolean m8702i() {
        return this.f9151c.edit().putBoolean(MsgConstant.KEY_CACHE_FILE_TRANSFER_TO_SQL, true).commit();
    }

    /* JADX INFO: renamed from: b */
    boolean m8692b(String str) {
        return this.f9151c.getBoolean(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str, false);
    }

    /* JADX INFO: renamed from: c */
    void m8694c(String str) {
        this.f9151c.edit().putBoolean(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str, true).commit();
    }

    /* JADX INFO: renamed from: d */
    void m8696d(String str) {
        this.f9151c.edit().remove(MsgConstant.KEY_MSG_RESOURCE_DOWNLOAD_PREFIX + str).commit();
    }

    /* JADX INFO: renamed from: e */
    void m8698e(String str) {
        this.f9151c.edit().putString(MsgConstant.KEY_LAST_MSG_ID, str).commit();
    }

    /* JADX INFO: renamed from: j */
    String m8703j() {
        return this.f9151c.getString(MsgConstant.KEY_LAST_MSG_ID, "");
    }

    /* JADX INFO: renamed from: a */
    void m8687a(int i) {
        this.f9151c.edit().putInt(MsgConstant.KEY_MUTE_DURATION, i).commit();
    }

    /* JADX INFO: renamed from: k */
    int m8704k() {
        return this.f9151c.getInt(MsgConstant.KEY_MUTE_DURATION, 60);
    }

    public void setSerialNo(int i) {
        this.f9150b.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, this.f9152e).edit().putInt(MsgConstant.KEY_SERIA_NO, i).commit();
    }

    public int getSerialNo() {
        return this.f9150b.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, this.f9152e).getInt(MsgConstant.KEY_SERIA_NO, 1);
    }

    public boolean getNotificaitonOnForeground() {
        return this.f9151c.getBoolean(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, true);
    }

    public void setNotificaitonOnForeground(boolean z) {
        this.f9151c.edit().putBoolean(MsgConstant.KEY_SET_NOTIFICATION_ON_FOREGROUND, z).commit();
    }

    public String getResourcePackageName() {
        return this.f9151c.getString(MsgConstant.KEY_SET_RESOURCE_PACKAGENAME, "");
    }

    public void setResourcePackageName(String str) {
        this.f9151c.edit().putString(MsgConstant.KEY_SET_RESOURCE_PACKAGENAME, str).commit();
    }

    public int getNotificationPlayVibrate() {
        return this.f9151c.getInt(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, 0);
    }

    public void setNotificationPlayVibrate(int i) {
        this.f9151c.edit().putInt(MsgConstant.KEY_SET_NOTIFICATION_PLAY_VIBRATE, i).commit();
    }

    public int getNotificationPlayLights() {
        return this.f9151c.getInt(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, 0);
    }

    public void setNotificationPlayLights(int i) {
        this.f9151c.edit().putInt(MsgConstant.KEY_SET_NOTIFICATION_PLAY_LIGHTS, i).commit();
    }

    public int getNotificationPlaySound() {
        return this.f9151c.getInt(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, 0);
    }

    public void setNotificationPlaySound(int i) {
        this.f9151c.edit().putInt(MsgConstant.KEY_SET_NOTIFICATION_PLAY_SOUND, i).commit();
    }

    /* JADX INFO: renamed from: l */
    boolean m8705l() {
        return this.f9151c.getBoolean(MsgConstant.KEY_SET_LOCALNOTIFICATION_INTERVAL_LIMIT, true);
    }

    /* JADX INFO: renamed from: a */
    void m8689a(boolean z) {
        this.f9150b.getSharedPreferences(MsgConstant.PUSH_SHARED_PREFERENCES_FILE_NAME, this.f9152e).edit().putBoolean(MsgConstant.KEY_SET_LOCALNOTIFICATION_INTERVAL_LIMIT, z).commit();
    }

    public void setDeviceToken(String str) {
        this.f9151c.edit().putString(MsgConstant.KEY_DEVICE_TOKEN, str).commit();
    }

    public String getDeviceToken() {
        return this.f9151c.getString(MsgConstant.KEY_DEVICE_TOKEN, "");
    }
}
