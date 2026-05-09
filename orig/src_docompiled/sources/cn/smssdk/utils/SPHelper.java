package cn.smssdk.utils;

import android.content.Context;
import android.text.TextUtils;
import cn.smssdk.net.C0978c;
import com.mob.tools.utils.SharePrefrenceHelper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class SPHelper {

    /* JADX INFO: renamed from: a */
    private static SPHelper f6152a;

    /* JADX INFO: renamed from: b */
    private SharePrefrenceHelper f6153b;

    /* JADX INFO: renamed from: c */
    private SharePrefrenceHelper f6154c;

    public static SPHelper getInstance(Context context) {
        if (f6152a == null) {
            f6152a = new SPHelper(context);
        }
        return f6152a;
    }

    private SPHelper(Context context) {
        this.f6153b = new SharePrefrenceHelper(context);
        this.f6153b.open("SMSSDK", 2);
        this.f6154c = new SharePrefrenceHelper(context);
        this.f6154c.open("SMSSDK_VCODE", 1);
    }

    public String getConfig() {
        String strM6793d;
        String string = this.f6153b.getString("config");
        if (TextUtils.isEmpty(string) || (strM6793d = C0978c.m6793d(string)) == null) {
            return null;
        }
        return strM6793d;
    }

    public void setConfig(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6153b.putString("config", C0978c.m6791c(str));
    }

    public String getAeskey() {
        String strM6793d;
        String string = this.f6153b.getString("aeskey");
        if (TextUtils.isEmpty(string) || (strM6793d = C0978c.m6793d(string)) == null) {
            return null;
        }
        return strM6793d;
    }

    public void setAeskey(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6153b.putString("aeskey", C0978c.m6791c(str));
    }

    public String getLimit(String str) {
        return this.f6153b.getString(str);
    }

    public void setLimit(String str, String str2) {
        this.f6153b.putString(str, str2);
    }

    public boolean isAllowReadContact() {
        return this.f6153b.getBoolean("read_contact");
    }

    public void setAllowReadContact() {
        this.f6153b.putBoolean("read_contact", true);
    }

    public boolean isWarnWhenReadContact() {
        return this.f6153b.getBoolean("read_contact_warn");
    }

    public void setWarnWhenReadContact(boolean z) {
        this.f6153b.putBoolean("read_contact_warn", Boolean.valueOf(z));
    }

    public String getVerifyCountry() {
        String string = this.f6153b.getString("verify_country");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (String) C0978c.m6780a(getAppKey(), string);
    }

    public void setVerifyCountry(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6153b.putString("verify_country", C0978c.m6781a(getAppKey(), (Object) str));
    }

    public String getVerifyPhone() {
        String string = this.f6153b.getString("verify_phone");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        return (String) C0978c.m6780a(getAppKey(), string);
    }

    public void setVerifyPhone(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6153b.putString("verify_phone", C0978c.m6781a(getAppKey(), (Object) str));
    }

    public void clearBuffer() {
        this.f6153b.remove("bufferedNewFriends");
        this.f6153b.remove("bufferedFriends");
        this.f6153b.remove("lastRequestNewFriendsTime");
        this.f6153b.remove("bufferedContactPhones");
    }

    public String getBufferedCountrylist() {
        return this.f6153b.getString("bufferedCountryList");
    }

    public void setBufferedCountrylist(String str) {
        this.f6153b.putString("bufferedCountryList", str);
    }

    public long getLastCountryListTime() {
        return this.f6153b.getLong("lastCountryListTime");
    }

    public void setLastCountryListTime() {
        this.f6153b.putLong("lastCountryListTime", Long.valueOf(System.currentTimeMillis()));
    }

    public String getBufferedContactsSignature() {
        return this.f6153b.getString("bufferedContactsSignature");
    }

    public void setBufferedContactsSignature(String str) {
        this.f6153b.putString("bufferedContactsSignature", str);
    }

    public ArrayList<HashMap<String, Object>> getBufferedContacts() {
        Object obj = this.f6153b.get("bufferedContacts");
        if (obj != null) {
            return (ArrayList) obj;
        }
        return new ArrayList<>();
    }

    public void setBufferedContacts(ArrayList<HashMap<String, Object>> arrayList) {
        this.f6153b.put("bufferedContacts", arrayList);
    }

    public ArrayList<HashMap<String, Object>> getBufferedFriends() {
        synchronized ("bufferedFriends") {
            Object obj = this.f6153b.get("bufferedFriends");
            if (obj != null) {
                return (ArrayList) obj;
            }
            return new ArrayList<>();
        }
    }

    public void setBufferedFriends(ArrayList<HashMap<String, Object>> arrayList) {
        synchronized ("bufferedFriends") {
            this.f6153b.put("bufferedFriends", arrayList);
        }
    }

    public ArrayList<HashMap<String, Object>> getBufferedNewFriends() {
        Object obj = this.f6153b.get("bufferedNewFriends");
        if (obj != null) {
            return (ArrayList) obj;
        }
        return new ArrayList<>();
    }

    public void setBufferedNewFriends(ArrayList<HashMap<String, Object>> arrayList) {
        this.f6153b.put("bufferedNewFriends", arrayList);
    }

    public long getLastRequestNewFriendsTime() {
        return this.f6153b.getLong("lastRequestNewFriendsTime");
    }

    public void setRequestNewFriendsTime() {
        this.f6153b.putLong("lastRequestNewFriendsTime", Long.valueOf(System.currentTimeMillis()));
    }

    public void setBufferedContactPhones(String[] strArr) {
        this.f6153b.put("bufferedContactPhones", strArr);
    }

    public String[] getBufferedContactPhones() {
        Object obj = this.f6153b.get("bufferedContactPhones");
        if (obj != null) {
            return (String[]) obj;
        }
        return new String[0];
    }

    public String getVCodeHash() {
        return this.f6154c.getString("KEY_VCODE_HASH");
    }

    public void setVCodeHash(String str) {
        this.f6154c.putString("KEY_VCODE_HASH", str);
    }

    public String getSMSID() {
        return this.f6154c.getString("KEY_SMSID");
    }

    public void setSMSID(String str) {
        this.f6154c.putString("KEY_SMSID", str);
    }

    public String getAppKey() {
        return this.f6154c.getString("KEY_APPKEY");
    }

    public void setAppKey(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        this.f6154c.putString("KEY_APPKEY", str);
    }

    public void setLog(String str) {
        synchronized ("KEY_LOG") {
            String log = getLog();
            if (!TextUtils.isEmpty(log)) {
                str = log + "\r\n" + str;
            }
            this.f6154c.putString("KEY_LOG", str);
        }
    }

    public String getLog() {
        return this.f6154c.getString("KEY_LOG");
    }

    public void clearLog() {
        synchronized ("KEY_LOG") {
            this.f6154c.remove("KEY_LOG");
        }
    }

    public String getToken() {
        return this.f6153b.getString("token");
    }

    public void setToken(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f6153b.putString("token", str);
    }
}
