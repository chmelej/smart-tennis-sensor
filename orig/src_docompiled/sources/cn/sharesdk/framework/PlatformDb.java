package cn.sharesdk.framework;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class PlatformDb {
    private static final String DB_NAME = "cn_sharesdk_weibodb";

    /* JADX INFO: renamed from: db */
    private SharedPreferences f5514db;
    private String platformNname;
    private int platformVersion;

    public PlatformDb(Context context, String str, int i) {
        this.f5514db = context.getSharedPreferences("cn_sharesdk_weibodb_" + str + "_" + i, 0);
        this.platformNname = str;
        this.platformVersion = i;
    }

    public void put(String str, String str2) {
        SharedPreferences.Editor editorEdit = this.f5514db.edit();
        editorEdit.putString(str, str2);
        editorEdit.commit();
    }

    public String get(String str) {
        return this.f5514db.getString(str, "");
    }

    public String getToken() {
        return this.f5514db.getString("token", "");
    }

    public void putToken(String str) {
        SharedPreferences.Editor editorEdit = this.f5514db.edit();
        editorEdit.putString("token", str);
        editorEdit.commit();
    }

    public String getTokenSecret() {
        return this.f5514db.getString("secret", "");
    }

    public void putTokenSecret(String str) {
        SharedPreferences.Editor editorEdit = this.f5514db.edit();
        editorEdit.putString("secret", str);
        editorEdit.commit();
    }

    public long getExpiresIn() {
        try {
            try {
                return this.f5514db.getLong("expiresIn", 0L);
            } catch (Throwable unused) {
                return this.f5514db.getInt("expiresIn", 0);
            }
        } catch (Throwable unused2) {
            return 0L;
        }
    }

    public void putExpiresIn(long j) {
        SharedPreferences.Editor editorEdit = this.f5514db.edit();
        editorEdit.putLong("expiresIn", j);
        editorEdit.putLong("expiresTime", System.currentTimeMillis());
        editorEdit.commit();
    }

    public long getExpiresTime() {
        return this.f5514db.getLong("expiresTime", 0L) + (getExpiresIn() * 1000);
    }

    public int getPlatformVersion() {
        return this.platformVersion;
    }

    public String getPlatformNname() {
        return this.platformNname;
    }

    public void putUserId(String str) {
        SharedPreferences.Editor editorEdit = this.f5514db.edit();
        editorEdit.putString("userID", str);
        editorEdit.commit();
    }

    public String getUserId() {
        String string = this.f5514db.getString("userID", "");
        return TextUtils.isEmpty(string) ? this.f5514db.getString("weibo", "") : string;
    }

    public String getUserName() {
        return this.f5514db.getString("nickname", "");
    }

    public String getUserIcon() {
        return this.f5514db.getString("icon", "");
    }

    public void removeAccount() {
        ArrayList arrayList = new ArrayList();
        Iterator<Map.Entry<String, ?>> it = this.f5514db.getAll().entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getKey());
        }
        SharedPreferences.Editor editorEdit = this.f5514db.edit();
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            editorEdit.remove((String) it2.next());
        }
        editorEdit.commit();
    }

    public String exportData() {
        try {
            HashMap map = new HashMap();
            map.putAll(this.f5514db.getAll());
            return new Hashon().fromHashMap(map);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    public void importData(String str) {
        try {
            HashMap mapFromJson = new Hashon().fromJson(str);
            if (mapFromJson != null) {
                SharedPreferences.Editor editorEdit = this.f5514db.edit();
                for (Map.Entry entry : mapFromJson.entrySet()) {
                    Object value = entry.getValue();
                    if (value instanceof Boolean) {
                        editorEdit.putBoolean((String) entry.getKey(), ((Boolean) value).booleanValue());
                    } else if (value instanceof Float) {
                        editorEdit.putFloat((String) entry.getKey(), ((Float) value).floatValue());
                    } else if (value instanceof Integer) {
                        editorEdit.putInt((String) entry.getKey(), ((Integer) value).intValue());
                    } else if (value instanceof Long) {
                        editorEdit.putLong((String) entry.getKey(), ((Long) value).longValue());
                    } else {
                        editorEdit.putString((String) entry.getKey(), String.valueOf(value));
                    }
                }
                editorEdit.commit();
            }
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }

    public boolean isValid() {
        String token = getToken();
        if (token == null || token.length() <= 0) {
            return false;
        }
        return getExpiresIn() == 0 || getExpiresTime() > System.currentTimeMillis();
    }

    public String getUserGender() {
        String string = this.f5514db.getString("gender", "2");
        if ("0".equals(string)) {
            return "m";
        }
        if ("1".equals(string)) {
            return "f";
        }
        return null;
    }
}
