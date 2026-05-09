package cn.smssdk.net;

import android.content.Context;
import android.text.TextUtils;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.BuildConfig;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.umeng.message.MsgConstant;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.net.e */
/* JADX INFO: compiled from: ParamsBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class C0980e {

    /* JADX INFO: renamed from: a */
    private static String f6126a;

    /* JADX INFO: renamed from: b */
    private static boolean f6127b;

    /* JADX INFO: renamed from: c */
    private static DeviceHelper f6128c;

    /* JADX INFO: renamed from: d */
    private static HashMap<String, Object> f6129d;

    /* JADX INFO: renamed from: e */
    private static C0977b f6130e;

    /* JADX INFO: renamed from: h */
    private static boolean f6131h;

    /* JADX INFO: renamed from: i */
    private static boolean f6132i;

    /* JADX INFO: renamed from: j */
    private static C0980e f6133j;

    /* JADX INFO: renamed from: f */
    private Hashon f6134f = new Hashon();

    /* JADX INFO: renamed from: g */
    private HashMap<String, String> f6135g;

    /* JADX INFO: renamed from: a */
    public static C0980e m6795a() {
        if (f6133j == null) {
            synchronized (C0980e.class) {
                f6133j = new C0980e();
            }
        }
        return f6133j;
    }

    private C0980e() {
    }

    /* JADX INFO: renamed from: a */
    public static void m6799a(Context context, String str) {
        String simSerialNumber;
        f6126a = str;
        f6128c = DeviceHelper.getInstance(context);
        f6130e = C0977b.m6741a(context);
        f6129d = new HashMap<>();
        f6129d.put("plat", Integer.valueOf(f6128c.getPlatformCode()));
        f6129d.put("sdkver", BuildConfig.VERSION_NAME);
        String line1Number = null;
        try {
            f6131h = f6128c.checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE);
            f6132i = f6128c.checkPermission("android.permission.READ_SMS");
            simSerialNumber = f6131h ? f6128c.getSimSerialNumber() : null;
            try {
                if (f6131h && f6132i) {
                    line1Number = f6128c.getLine1Number();
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            simSerialNumber = null;
        }
        String carrier = f6128c.getCarrier();
        if (carrier != null && !carrier.equals("-1")) {
            f6129d.put("operator", carrier);
        }
        if (simSerialNumber != null && !simSerialNumber.equals("-1")) {
            f6129d.put("simserial", simSerialNumber);
        }
        if (line1Number != null && !line1Number.equals("-1")) {
            f6129d.put("my_phone", line1Number);
        }
        f6127b = true;
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6810a(String str, String str2, String str3, HashMap<String, Object> map) throws Throwable {
        if (!f6127b) {
            throw new Throwable("ParamsBuilder need prepare before use");
        }
        if (str.equals("user_info_001")) {
            return m6797a(str2, map);
        }
        if (str.equals("device_001")) {
            return m6804c();
        }
        if (str.equals("install_002")) {
            return m6803b(str2, map);
        }
        if (str.equals("collect_001")) {
            return m6798a(map);
        }
        if (str.equals("contacts_001")) {
            return m6805c(str2, map);
        }
        if (str.equals("contacts_002")) {
            return m6807d(str2, map);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6811a(ArrayList<String> arrayList, String str, String str2, HashMap<String, Object> map) throws Throwable {
        if (!f6127b) {
            throw new Throwable("ParamsBuilder need prepare before use");
        }
        HashMap<String, Object> map2 = new HashMap<>();
        for (String str3 : arrayList) {
            if (str3.equals("appkey")) {
                map2.put("appkey", f6126a);
            } else if (str3.equals("token")) {
                map2.put("token", str2);
            } else if (str3.equals("duid")) {
                map2.put("duid", str);
            } else if (str3.equals("contactphones")) {
                map2.put("contactphones", m6796a((String[]) map.get("contactphones")));
            } else {
                Object obj = f6129d.get(str3);
                if (obj == null) {
                    obj = map.get(str3);
                }
                map2.put(str3, obj);
            }
        }
        return map2;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<KVPair<String>> m6809a(byte[] bArr, String str) {
        ArrayList<KVPair<String>> arrayList = new ArrayList<>();
        arrayList.add(new KVPair<>("appkey", f6126a));
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        arrayList.add(new KVPair<>("token", str));
        arrayList.add(new KVPair<>("hash", Data.CRC32(bArr)));
        arrayList.add(new KVPair<>("User-Agent", m6801b()));
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    private String m6801b() {
        return "SMSSDK/" + BuildConfig.VERSION_NAME + " (Android; " + Data.urlEncode(f6128c.getOSVersionName()) + '/' + f6128c.getOSVersionInt() + ") " + Data.urlEncode(f6128c.getManufacturer()) + '/' + Data.urlEncode(f6128c.getModel()) + ' ' + Data.urlEncode(f6128c.getAppName()) + '/' + f6128c.getPackageName() + '/' + Data.urlEncode(f6128c.getAppVersionName());
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> m6797a(String str, HashMap<String, Object> map) {
        String str2 = (String) map.get("uid");
        String str3 = (String) map.get("nickname");
        String str4 = (String) map.get("avatar");
        String str5 = (String) map.get("zone");
        String str6 = (String) map.get("phone");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("avatar", str4);
        map2.put("uid", str2);
        map2.put("nickname", str3);
        map2.put("appkey", f6126a);
        map2.put("phone", str6);
        map2.put("zone", str5);
        map2.put("duid", str);
        return map2;
    }

    /* JADX INFO: renamed from: c */
    private HashMap<String, Object> m6804c() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("appkey", f6126a);
        map.put("apppkg", f6128c.getPackageName());
        map.put("appver", f6128c.getAppVersionName());
        map.put("plat", Integer.valueOf(f6128c.getPlatformCode()));
        map.put("network", f6128c.getNetworkTypeForStatic());
        map.put("deviceinfo", m6806d());
        return map;
    }

    /* JADX INFO: renamed from: b */
    private HashMap<String, Object> m6803b(String str, HashMap<String, Object> map) {
        String str2 = (String) map.get("type");
        Object obj = map.get("list");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("type", str2);
        map2.put("plat", Integer.valueOf(f6128c.getPlatformCode()));
        map2.put("device", str);
        map2.put("list", obj);
        return map2;
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> m6798a(HashMap<String, Object> map) {
        Object obj = map.get("logs");
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("logs", obj);
        map2.put("deviceinfo", m6806d());
        return map2;
    }

    /* JADX INFO: renamed from: c */
    private HashMap<String, Object> m6805c(String str, HashMap<String, Object> map) {
        String simSerialNumber = f6131h ? f6128c.getSimSerialNumber() : null;
        ArrayList<HashMap<String, Object>> arrayList = (ArrayList) map.get("contacts");
        m6800a(arrayList);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("appkey", f6126a);
        map2.put("duid", str);
        map2.put("simserial", simSerialNumber);
        map2.put("contacts", m6802b(arrayList));
        return map2;
    }

    /* JADX INFO: renamed from: d */
    private HashMap<String, Object> m6807d(String str, HashMap<String, Object> map) {
        String line1Number = null;
        String simSerialNumber = f6131h ? f6128c.getSimSerialNumber() : null;
        String str2 = (String) map.get("zone");
        String[] countryByMCC = SMSSDK.getCountryByMCC(f6128c.getMCC());
        if (countryByMCC != null) {
            str2 = countryByMCC[1];
        }
        if (f6131h && f6132i) {
            line1Number = f6128c.getLine1Number();
        }
        ArrayList<HashMap<String, Object>> arrayList = (ArrayList) map.get("contacts");
        m6800a(arrayList);
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("appkey", f6126a);
        map2.put("duid", str);
        map2.put("my_phone", line1Number);
        map2.put("zone", str2);
        map2.put("simserial", simSerialNumber);
        String carrier = f6128c.getCarrier();
        if (carrier != null && !carrier.equals("-1")) {
            map2.put("operator", carrier);
        }
        map2.put("contacts", m6802b(arrayList));
        return map2;
    }

    /* JADX INFO: renamed from: d */
    private HashMap<String, Object> m6806d() {
        String advertisingID;
        HashMap<String, Object> map = new HashMap<>();
        String imei = f6128c.getIMEI();
        try {
            advertisingID = f6128c.getAdvertisingID();
        } catch (Throwable th) {
            SMSLog.getInstance().m8610d(th);
            advertisingID = null;
        }
        map.put("adsid", advertisingID);
        if (imei == null) {
            imei = "";
        }
        map.put("imei", imei);
        String serialno = f6128c.getSerialno();
        if (serialno == null) {
            serialno = "";
        }
        map.put("serialno", serialno);
        String macAddress = f6128c.getMacAddress();
        if (macAddress == null) {
            macAddress = "";
        }
        map.put("mac", macAddress);
        String model = f6128c.getModel();
        if (model == null) {
            model = "";
        }
        map.put("model", model);
        String manufacturer = f6128c.getManufacturer();
        if (manufacturer == null) {
            manufacturer = "";
        }
        map.put("factory", manufacturer);
        String carrier = f6128c.getCarrier();
        if (carrier == null) {
            carrier = "";
        }
        map.put("carrier", carrier);
        String screenSize = f6128c.getScreenSize();
        if (screenSize == null) {
            screenSize = "";
        }
        map.put("screensize", screenSize);
        String oSVersionName = f6128c.getOSVersionName();
        if (oSVersionName == null) {
            oSVersionName = "";
        }
        map.put("sysver", oSVersionName);
        map.put("androidid", f6128c.getAndroidID());
        return map;
    }

    /* JADX INFO: renamed from: a */
    private void m6800a(ArrayList<HashMap<String, Object>> arrayList) {
        Object obj;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        for (HashMap<String, Object> map : arrayList) {
            if (map != null && (obj = map.get("phones")) != null) {
                for (HashMap map2 : (ArrayList) obj) {
                    Object obj2 = map2.get("phone");
                    if (obj2 != null) {
                        map2.put("phone", f6130e.m6770b((String) obj2));
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    private String m6802b(ArrayList<HashMap<String, Object>> arrayList) {
        HashMap map = new HashMap();
        map.put("list", arrayList);
        return this.f6134f.fromHashMap(map).substring(8, r3.length() - 1);
    }

    /* JADX INFO: renamed from: a */
    private String m6796a(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        if (this.f6135g == null) {
            this.f6135g = new HashMap<>();
        }
        for (String str : strArr) {
            this.f6135g.put(f6130e.m6770b(str), str);
        }
        if (this.f6135g == null || this.f6135g.size() <= 0) {
            return null;
        }
        return TextUtils.join(",", this.f6135g.keySet());
    }

    /* JADX INFO: renamed from: a */
    public String m6808a(String str) {
        if (this.f6135g == null || this.f6135g.size() == 0) {
            return null;
        }
        return this.f6135g.get(str);
    }
}
