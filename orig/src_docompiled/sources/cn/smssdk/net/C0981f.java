package cn.smssdk.net;

import android.content.Context;
import android.text.TextUtils;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.commons.SMSSDK;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: renamed from: cn.smssdk.net.f */
/* JADX INFO: compiled from: Protocols.java */
/* JADX INFO: loaded from: classes.dex */
public class C0981f {

    /* JADX INFO: renamed from: a */
    private static C0981f f6136a;

    /* JADX INFO: renamed from: b */
    private Context f6137b;

    /* JADX INFO: renamed from: c */
    private Hashon f6138c = new Hashon();

    /* JADX INFO: renamed from: d */
    private String f6139d;

    /* JADX INFO: renamed from: e */
    private SPHelper f6140e;

    /* JADX INFO: renamed from: f */
    private C0977b f6141f;

    /* JADX INFO: renamed from: a */
    public static C0981f m6812a(Context context) {
        if (f6136a == null) {
            f6136a = new C0981f(context);
        }
        return f6136a;
    }

    private C0981f(Context context) {
        this.f6137b = context.getApplicationContext();
        this.f6140e = SPHelper.getInstance(context);
        this.f6141f = C0977b.m6741a(context);
    }

    /* JADX INFO: renamed from: a */
    public void m6814a(String str, String str2) {
        this.f6139d = str;
        SMSSDK.setAppKey(str);
        this.f6140e.setAppKey(str);
        C0980e.m6799a(this.f6137b, str);
        this.f6141f.m6767a(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6818a() {
        return this.f6141f.m6768a();
    }

    /* JADX INFO: renamed from: a */
    public void m6815a(String str, String str2, String str3) throws Throwable {
        if (TextUtils.isEmpty(str2)) {
            throw new Throwable("{\"detail\":\"country code cant be empty\"}");
        }
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("{\"detail\":\"phone number cant be empty\"}");
        }
        if (!this.f6141f.m6769a(str2)) {
            throw new Throwable("{\"status\":461}");
        }
        HashMap<String, Object> map = new HashMap<>();
        HashMap map2 = new HashMap();
        if (!TextUtils.isEmpty(str3)) {
            map2.put("extKey", str3);
        }
        map.put("phone", str);
        map.put("zone", str2);
        map.put("attr", map2);
        map.put("tempCode", "Nul2");
        this.f6141f.m6766a(10, map);
    }

    /* JADX INFO: renamed from: a */
    public void m6817a(String str, String str2, ArrayList<HashMap<String, Object>> arrayList) throws Throwable {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("zone", str);
        map.put("phone", str2);
        map.put("contacts", arrayList);
        this.f6141f.m6766a(5, map);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6819a(String str, String str2, String str3, String str4) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("{\"detail\":\"country code cant be empty\"}");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new Throwable("{\"detail\":\"phone number cant be empty\"}");
        }
        if (!this.f6141f.m6769a(str)) {
            throw new Throwable("{\"status\":461}");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", str2);
        map.put("zone", str);
        if (!TextUtils.isEmpty(str3)) {
            HashMap map2 = new HashMap();
            map.put("attr", map2);
            map2.put("extKey", str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            map.put("tempCode", str4);
        }
        HashMap<String, Object> mapM6766a = this.f6141f.m6766a(9, map);
        String str5 = (String) mapM6766a.get("vCode");
        String str6 = (String) mapM6766a.get("smsId");
        Integer num = (Integer) mapM6766a.get("smart");
        this.f6140e.setSMSID(str6);
        this.f6140e.setVCodeHash(str5);
        if (num == null || num.intValue() != 1) {
            return false;
        }
        this.f6140e.clearBuffer();
        try {
            this.f6140e.setVerifyCountry(str);
            this.f6140e.setVerifyPhone(str2);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Object> m6821b(String str, String str2, String str3) throws Throwable {
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("{\"status\":\"466\"}");
        }
        if (TextUtils.isEmpty(str2)) {
            throw new Throwable("{\"detail\":\"country code cant be empty\"}");
        }
        if (TextUtils.isEmpty(str3)) {
            throw new Throwable("{\"detail\":\"phone number cant be empty\"}");
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("phone", str3);
        map.put("code", str);
        map.put("zone", str2);
        this.f6141f.m6766a(11, map);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("country", str2);
        map2.put("phone", str3);
        this.f6140e.clearBuffer();
        try {
            this.f6140e.setVerifyCountry(str2);
            this.f6140e.setVerifyPhone(str3);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
        }
        return map2;
    }

    /* JADX INFO: renamed from: b */
    public ArrayList<HashMap<String, Object>> m6820b() throws Throwable {
        HashMap<String, Object> mapM6766a;
        long lastCountryListTime = this.f6140e.getLastCountryListTime();
        String bufferedCountrylist = this.f6140e.getBufferedCountrylist();
        if (System.currentTimeMillis() - lastCountryListTime <= 86400000 && !TextUtils.isEmpty(bufferedCountrylist) && !m6818a()) {
            mapM6766a = this.f6138c.fromJson(bufferedCountrylist);
        } else {
            mapM6766a = this.f6141f.m6766a(2, (HashMap<String, Object>) null);
            this.f6140e.setBufferedCountrylist(this.f6138c.fromHashMap(mapM6766a));
            this.f6140e.setLastCountryListTime();
            this.f6141f.m6771b();
        }
        return (ArrayList) ((HashMap) mapM6766a.get("result")).get("list");
    }

    /* JADX INFO: renamed from: a */
    public void m6816a(String str, String str2, String str3, String str4, String str5) throws Throwable {
        HashMap<String, Object> map = new HashMap<>();
        map.put("avatar", str3);
        map.put("uid", str);
        map.put("nickname", str2);
        map.put("phone", str5);
        map.put("zone", str4);
        this.f6141f.m6766a(4, map);
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<HashMap<String, Object>> m6813a(String[] strArr) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("contactphones", strArr);
        HashMap map2 = (HashMap) this.f6141f.m6766a(6, map).get("result");
        ArrayList<HashMap<String, Object>> arrayList = map2 != null ? (ArrayList) map2.get("list") : null;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        for (HashMap<String, Object> map3 : arrayList) {
            Object obj = map3.get("phone");
            if (obj != null) {
                map3.put("phone", this.f6141f.m6772c(String.valueOf(obj).toLowerCase(Locale.ENGLISH)));
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: c */
    public void m6822c() {
        this.f6141f.m6773c();
    }
}
