package cn.smssdk.net;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import cn.smssdk.gui.BuildConfig;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.commons.SMSSDK;
import com.mob.commons.appcollector.PackageCollector;
import com.mob.commons.appcollector.RuntimeCollector;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.commons.deviceinfo.DeviceInfoCollector;
import com.mob.commons.eventrecoder.EventRecorder;
import com.mob.commons.iosbridge.UDPServer;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: cn.smssdk.net.b */
/* JADX INFO: compiled from: Config.java */
/* JADX INFO: loaded from: classes.dex */
public class C0977b {

    /* JADX INFO: renamed from: D */
    private static C0977b f6082D;

    /* JADX INFO: renamed from: a */
    private static final ArrayList<String> f6083a = new ArrayList<>(3);

    /* JADX INFO: renamed from: A */
    private String f6084A;

    /* JADX INFO: renamed from: B */
    private String f6085B;

    /* JADX INFO: renamed from: C */
    private String f6086C;

    /* JADX INFO: renamed from: b */
    private String f6087b;

    /* JADX INFO: renamed from: c */
    private String f6088c;

    /* JADX INFO: renamed from: d */
    private Context f6089d;

    /* JADX INFO: renamed from: e */
    private SPHelper f6090e;

    /* JADX INFO: renamed from: g */
    private SparseArray<C0982g> f6092g;

    /* JADX INFO: renamed from: i */
    private ReentrantLock f6094i;

    /* JADX INFO: renamed from: j */
    private ReentrantReadWriteLock f6095j;

    /* JADX INFO: renamed from: k */
    private Condition f6096k;

    /* JADX INFO: renamed from: l */
    private a f6097l;

    /* JADX INFO: renamed from: m */
    private boolean f6098m;

    /* JADX INFO: renamed from: o */
    private boolean f6100o;

    /* JADX INFO: renamed from: p */
    private int f6101p;

    /* JADX INFO: renamed from: q */
    private long f6102q;

    /* JADX INFO: renamed from: s */
    private int f6104s;

    /* JADX INFO: renamed from: x */
    private String f6109x;

    /* JADX INFO: renamed from: y */
    private String f6110y;

    /* JADX INFO: renamed from: z */
    private int f6111z;

    /* JADX INFO: renamed from: r */
    private int f6103r = 1;

    /* JADX INFO: renamed from: t */
    private int f6105t = 1;

    /* JADX INFO: renamed from: u */
    private int f6106u = 1;

    /* JADX INFO: renamed from: v */
    private int f6107v = 1;

    /* JADX INFO: renamed from: w */
    private int f6108w = 1;

    /* JADX INFO: renamed from: h */
    private final C0979d f6093h = new C0979d();

    /* JADX INFO: renamed from: n */
    private boolean f6099n = false;

    /* JADX INFO: renamed from: f */
    private Hashon f6091f = new Hashon();

    /* JADX INFO: renamed from: a */
    public static C0977b m6741a(Context context) {
        if (f6082D == null) {
            synchronized (C0977b.class) {
                f6082D = new C0977b(context);
            }
        }
        return f6082D;
    }

    private C0977b(Context context) {
        this.f6089d = context;
        this.f6090e = SPHelper.getInstance(context);
        f6083a.add("852");
        f6083a.add("853");
        f6083a.add("886");
        this.f6094i = new ReentrantLock();
        this.f6095j = new ReentrantReadWriteLock();
        this.f6096k = this.f6095j.writeLock().newCondition();
    }

    /* JADX INFO: renamed from: a */
    public void m6767a(String str, String str2) {
        this.f6087b = str;
        this.f6088c = str2;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6769a(String str) {
        m6759d();
        if (this.f6105t == 0) {
            return false;
        }
        if (this.f6106u == 0 && str.equals("86")) {
            return false;
        }
        if (this.f6107v == 0 && f6083a.contains(str)) {
            return false;
        }
        return this.f6108w != 0 || f6083a.contains(str) || str.equals("86");
    }

    /* JADX INFO: renamed from: a */
    public boolean m6768a() {
        return this.f6100o;
    }

    /* JADX INFO: renamed from: b */
    public void m6771b() {
        this.f6100o = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6749a(HashMap<String, Object> map) {
        long jLongValue = ((Long) map.get("update")).longValue();
        if (jLongValue == this.f6102q) {
            return;
        }
        this.f6102q = jLongValue;
        this.f6101p = ((Integer) map.get("expire_at")).intValue();
        if (this.f6101p > 0) {
            this.f6097l.m6775a();
        }
        int iIntValue = ((Integer) map.get("zonelist_update")).intValue();
        if (iIntValue > this.f6104s) {
            this.f6104s = iIntValue;
            this.f6100o = true;
        }
        this.f6103r = ((Integer) map.get("request")).intValue();
        Integer num = (Integer) map.get("sms_toggle");
        this.f6105t = num != null ? num.intValue() : 1;
        Integer num2 = (Integer) map.get("sms_home");
        this.f6106u = num2 != null ? num2.intValue() : 1;
        Integer num3 = (Integer) map.get("sms_sp_region");
        this.f6107v = num3 != null ? num3.intValue() : 1;
        Integer num4 = (Integer) map.get("sms_foreign");
        this.f6108w = num4 != null ? num4.intValue() : 1;
        this.f6109x = (String) map.get("public_key");
        this.f6110y = (String) map.get("modulus");
        Integer num5 = (Integer) map.get("size");
        this.f6111z = num5 != null ? num5.intValue() : 0;
        if (!TextUtils.isEmpty(this.f6109x) && !TextUtils.isEmpty(this.f6110y) && this.f6111z > 0) {
            C0978c.m6784a(this.f6109x, this.f6110y, this.f6111z);
        }
        ArrayList<HashMap<String, Object>> arrayList = (ArrayList) ((HashMap) map.get("result")).get("urls");
        if (this.f6092g == null) {
            this.f6092g = new SparseArray<>();
        } else if (this.f6092g != null && this.f6092g.size() > 0) {
            this.f6092g.clear();
        }
        for (HashMap<String, Object> map2 : arrayList) {
            C0982g c0982g = new C0982g(this.f6089d);
            c0982g.m6826a(map2);
            c0982g.m6737a(this.f6095j);
            this.f6092g.put(c0982g.m6735a(), c0982g);
        }
    }

    /* JADX INFO: renamed from: a */
    private C0982g m6742a(int i) throws Throwable {
        if (this.f6087b != null && this.f6087b.equalsIgnoreCase("f3fc6baa9ac4")) {
            Log.e("SMSSDK WARNING", "zh".equals(DeviceHelper.getInstance(this.f6089d).getOSLanguage()) ? String.valueOf(new char[]{25152, 22635, 20889, 'A', 'P', 'P', 'K', 'E', 'Y', 20165, 20379, 27979, 35797, 20351, 29992, 65292, 19988, 19981, 23450, 26399, 22833, 25928, 65292, 35831, 21040, 'm', 'o', 'b', '.', 'c', 'o', 'm', 21518, 21488, 30003, 35831, 27491, 24335, 'A', 'P', 'P', 'K', 'E', 'Y'}) : "This appkey only for demo!Please request a new one for your own App");
        }
        m6759d();
        if (this.f6103r == 0) {
            throw new Throwable("{\"status\":604,\"detail\":\"" + this.f6089d.getResources().getString(ResHelper.getStringRes(this.f6089d, "smssdk_error_desc_604")) + "\"}");
        }
        return this.f6092g.get(i);
    }

    /* JADX INFO: renamed from: d */
    private void m6759d() {
        try {
            this.f6095j.writeLock().lock();
            if (this.f6099n) {
                return;
            }
            EventRecorder.prepare(this.f6089d);
            String strCheckRecord = EventRecorder.checkRecord("SMSSDK");
            if (strCheckRecord != null) {
                EventRecorder.clear();
            }
            String config = this.f6090e.getConfig();
            this.f6097l = new a();
            EventRecorder.addBegin("SMSSDK", "parseConfig");
            if (!TextUtils.isEmpty(strCheckRecord) || TextUtils.isEmpty(config)) {
                m6749a(this.f6091f.fromJson("{\"status\":200,\"expire_at\":86400,\"update\":1466077916207,\"zonelist_update\":20151129,\"request\":1,\"sms_toggle\":1,\"sms_home\":1,\"sms_sp_region\":1,\"sms_foreign\":1,\"result\":{\"urls\":[{\"name\":\"uploadCollectData\",\"url\":\"http://upc1299.uz.local:8082/relat/seda\",\"params\":[\"appKey\",\"duid\",\"sdkver\",\"my_phone\",\"collectTime\",\"data\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"sendTextSMS\",\"url\":\"http://code.sms.mob.com/verify/code\",\"params\":[\"appkey\",\"duid\",\"zone\",\"phone\",\"simserial\",\"my_phone\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"submitUser\",\"url\":\"http://sdkapi.sms.mob.com/app/submituserinfo\",\"params\":[],\"params_chunk\":\"user_info_001\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"logCollect\",\"url\":\"http://log.sms.mob.com/log/collect\",\"params\":[],\"params_chunk\":\"collect_001\",\"encode\":\"AES\",\"zip\":1,\"request\":1,\"frequency\":\"1:2:m\"},{\"name\":\"verifyCode\",\"url\":\"http://code.sms.mob.com/client/verification\",\"params\":[\"zone\",\"phone\",\"code\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"sendVoiceSMS\",\"url\":\"http://code.sms.mob.com/voice/verify/code\",\"params\":[\"zone\",\"phone\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"getFriend\",\"url\":\"http://addrlist.sms.mob.com/relat/fm\",\"params\":[\"appkey\",\"duid\",\"contactphones\",\"plat\",\"sdkver\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"uploadContacts\",\"url\":\"http://addrlist.sms.mob.com/relat/apply\",\"params\":[],\"params_chunk\":\"contacts_002\",\"encode\":\"RSA\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"getZoneList\",\"url\":\"http://sdkapi.sms.mob.com/utils/zonelist\",\"params\":[\"plat\",\"sdkver\",\"token\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"logInstall\",\"url\":\"http://log.sms.mob.com/log/install\",\"params\":[],\"params_chunk\":\"install_002\",\"encode\":\"AES\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"getToken\",\"url\":\"http://sdkapi.sms.mob.com/token/get\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"aesKey\",\"sign\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"}]}}"));
            } else {
                try {
                    m6749a(this.f6091f.fromJson(config));
                } catch (Throwable unused) {
                    this.f6090e.setConfig("");
                    m6749a(this.f6091f.fromJson("{\"status\":200,\"expire_at\":86400,\"update\":1466077916207,\"zonelist_update\":20151129,\"request\":1,\"sms_toggle\":1,\"sms_home\":1,\"sms_sp_region\":1,\"sms_foreign\":1,\"result\":{\"urls\":[{\"name\":\"uploadCollectData\",\"url\":\"http://upc1299.uz.local:8082/relat/seda\",\"params\":[\"appKey\",\"duid\",\"sdkver\",\"my_phone\",\"collectTime\",\"data\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"sendTextSMS\",\"url\":\"http://code.sms.mob.com/verify/code\",\"params\":[\"appkey\",\"duid\",\"zone\",\"phone\",\"simserial\",\"my_phone\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"submitUser\",\"url\":\"http://sdkapi.sms.mob.com/app/submituserinfo\",\"params\":[],\"params_chunk\":\"user_info_001\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"logCollect\",\"url\":\"http://log.sms.mob.com/log/collect\",\"params\":[],\"params_chunk\":\"collect_001\",\"encode\":\"AES\",\"zip\":1,\"request\":1,\"frequency\":\"1:2:m\"},{\"name\":\"verifyCode\",\"url\":\"http://code.sms.mob.com/client/verification\",\"params\":[\"zone\",\"phone\",\"code\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"sendVoiceSMS\",\"url\":\"http://code.sms.mob.com/voice/verify/code\",\"params\":[\"zone\",\"phone\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"getFriend\",\"url\":\"http://addrlist.sms.mob.com/relat/fm\",\"params\":[\"appkey\",\"duid\",\"contactphones\",\"plat\",\"sdkver\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"uploadContacts\",\"url\":\"http://addrlist.sms.mob.com/relat/apply\",\"params\":[],\"params_chunk\":\"contacts_002\",\"encode\":\"RSA\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"getZoneList\",\"url\":\"http://sdkapi.sms.mob.com/utils/zonelist\",\"params\":[\"plat\",\"sdkver\",\"token\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"logInstall\",\"url\":\"http://log.sms.mob.com/log/install\",\"params\":[],\"params_chunk\":\"install_002\",\"encode\":\"AES\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"getToken\",\"url\":\"http://sdkapi.sms.mob.com/token/get\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"aesKey\",\"sign\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"}]}}"));
                }
            }
            String aeskey = this.f6090e.getAeskey();
            if (!TextUtils.isEmpty(aeskey)) {
                C0978c.m6783a(aeskey);
            }
            this.f6099n = true;
            this.f6097l.start();
            EventRecorder.addEnd("SMSSDK", "parseConfig");
        } finally {
            this.f6095j.writeLock().unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public String m6743a(boolean z) {
        if (z || TextUtils.isEmpty(this.f6084A)) {
            try {
                this.f6094i.lock();
                if (!TextUtils.isEmpty(this.f6084A)) {
                    return this.f6084A;
                }
                this.f6084A = DeviceAuthorizer.authorize(this.f6089d, new SMSSDK());
            } finally {
                this.f6094i.unlock();
            }
        }
        return this.f6084A;
    }

    /* JADX INFO: renamed from: b */
    private synchronized String m6754b(boolean z) {
        this.f6085B = this.f6090e.getToken();
        if (!z && !TextUtils.isEmpty(this.f6085B) && C0978c.m6785a()) {
            return this.f6085B;
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("aesKey", m6757d(m6743a(false)));
        map.put("sign", m6760e());
        this.f6085B = (String) ((HashMap) m6766a(3, map).get("result")).get("token");
        if (TextUtils.isEmpty(this.f6085B)) {
            throw new Throwable("get token error!");
        }
        this.f6090e.setToken(this.f6085B);
        return this.f6085B;
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6766a(int i, HashMap<String, Object> map) throws Throwable {
        C0982g c0982gM6742a = m6742a(i);
        HashMap<String, Object> mapM6745a = m6745a(c0982gM6742a, map, false, false, 1);
        if (c0982gM6742a.m6735a() != 9 || mapM6745a == null) {
            if (mapM6745a != null) {
                c0982gM6742a.m6827c();
            }
        } else if (((Integer) mapM6745a.get("smart")) == null) {
            c0982gM6742a.m6827c();
        }
        return mapM6745a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public HashMap<String, Object> m6745a(AbstractC0976a abstractC0976a, HashMap<String, Object> map, boolean z, boolean z2, int i) throws Throwable {
        HashMap<String, Object> mapFromJson;
        if (i > 5) {
            int stringRes = ResHelper.getStringRes(this.f6089d, "smssdk_error_desc_server_busy");
            String string = stringRes > 0 ? this.f6089d.getString(stringRes) : "Server is busy!";
            HashMap map2 = new HashMap();
            map2.put("description", string);
            throw new Throwable(this.f6091f.fromHashMap(map2));
        }
        try {
            String strM6738b = abstractC0976a.m6738b(m6743a(z), (!(abstractC0976a instanceof C0982g) || abstractC0976a.m6735a() == 3) ? null : m6754b(z2), map);
            try {
                mapFromJson = this.f6091f.fromJson(strM6738b);
            } catch (Throwable th) {
                SMSLog.getInstance().m8613e(th);
                mapFromJson = null;
            }
            if (mapFromJson == null || mapFromJson.size() <= 0) {
                throw new Throwable("[hashon]Response is empty");
            }
            Object obj = mapFromJson.get(NotificationCompat.CATEGORY_STATUS);
            if (obj == null || !(obj instanceof Integer)) {
                throw new Throwable(strM6738b);
            }
            int iIntValue = ((Integer) obj).intValue();
            return iIntValue != 200 ? m6744a(iIntValue, abstractC0976a, map, i) : mapFromJson;
        } catch (Throwable th2) {
            return m6747a(th2, abstractC0976a, map, i);
        }
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> m6747a(Throwable th, AbstractC0976a abstractC0976a, HashMap<String, Object> map, int i) throws Throwable {
        HashMap mapFromJson = this.f6091f.fromJson(th.getMessage());
        Integer num = (Integer) mapFromJson.get(NotificationCompat.CATEGORY_STATUS);
        if (num == null || num.intValue() == 0) {
            throw th;
        }
        HashMap<String, Object> mapM6744a = m6744a(num.intValue(), abstractC0976a, map, i);
        if (mapM6744a != null) {
            return mapM6744a;
        }
        mapFromJson.put("description", m6752b(num.intValue()));
        mapFromJson.put("detail", m6755c(num.intValue()));
        throw new Throwable(this.f6091f.fromHashMap(mapFromJson));
    }

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> m6744a(int i, AbstractC0976a abstractC0976a, HashMap<String, Object> map, int i2) throws Throwable {
        int i3 = i2 + 1;
        if (i != 453) {
            if (i == 419 || i == 420) {
                this.f6090e.setToken("");
                return m6745a(abstractC0976a, map, true, true, i3);
            }
            if (i == 401 || i == 402) {
                this.f6090e.setToken("");
                return m6745a(abstractC0976a, map, false, true, i3);
            }
            if (i == 403 || i == 404 || i == 454) {
                return m6745a(abstractC0976a, map, false, false, i3);
            }
            if (i == 480) {
                map.put("aesKey", m6757d(m6743a(false)));
                return m6745a(abstractC0976a, map, false, true, i3);
            }
            throw new Throwable("{status:'" + i + "'}");
        }
        if (abstractC0976a instanceof C0982g) {
            int iM6735a = abstractC0976a.m6735a();
            try {
                this.f6095j.writeLock().lock();
                this.f6097l.m6777b(true);
                this.f6097l.m6776a(true);
                this.f6098m = true;
                while (this.f6098m) {
                    this.f6096k.await();
                }
                this.f6095j.writeLock().unlock();
                if (this.f6097l.m6778b()) {
                    this.f6097l.m6776a(false);
                    C0978c.m6788b();
                    this.f6097l.m6779c();
                    return m6745a(abstractC0976a, map, false, false, i3);
                }
                if (iM6735a > 0) {
                    abstractC0976a = m6742a(iM6735a);
                }
            } catch (Throwable unused) {
                this.f6097l.m6776a(false);
                C0978c.m6788b();
                return m6745a(abstractC0976a, map, false, false, i3);
            }
        } else {
            C0978c.m6788b();
        }
        return m6745a(abstractC0976a, map, false, false, i3);
    }

    /* JADX INFO: renamed from: b */
    private String m6752b(int i) {
        try {
            int stringRes = ResHelper.getStringRes(this.f6089d, "smssdk_error_desc_" + i);
            if (stringRes > 0) {
                return this.f6089d.getString(stringRes);
            }
            return null;
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    private String m6755c(int i) {
        try {
            int stringRes = ResHelper.getStringRes(this.f6089d, "smssdk_error_detail_" + i);
            if (stringRes > 0) {
                return this.f6089d.getString(stringRes);
            }
            return null;
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: d */
    private String m6757d(String str) {
        String strMD5 = Data.MD5(str + System.currentTimeMillis());
        C0978c.m6783a(strMD5);
        this.f6090e.setAeskey(strMD5);
        return strMD5;
    }

    /* JADX INFO: renamed from: e */
    private String m6760e() {
        if (!TextUtils.isEmpty(this.f6086C)) {
            return this.f6086C;
        }
        try {
            this.f6086C = Data.MD5(this.f6089d.getPackageManager().getPackageInfo(this.f6089d.getPackageName(), 64).signatures[0].toByteArray());
            return this.f6086C;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m6770b(String str) {
        if (!C0978c.m6785a()) {
            try {
                m6754b(true);
            } catch (Throwable unused) {
                return null;
            }
        }
        return Data.byteToHex(C0978c.m6789b(str));
    }

    /* JADX INFO: renamed from: c */
    public String m6772c(String str) {
        String strM6808a = C0980e.m6795a().m6808a(str);
        if (!TextUtils.isEmpty(strM6808a)) {
            return strM6808a;
        }
        if (!C0978c.m6785a()) {
            try {
                m6754b(true);
            } catch (Throwable unused) {
                return null;
            }
        }
        return new String(C0978c.m6787a(C0978c.m6794e(str))).trim();
    }

    /* JADX INFO: renamed from: c */
    public void m6773c() {
        m6743a(false);
        new Thread(new Runnable() { // from class: cn.smssdk.net.b.1
            @Override // java.lang.Runnable
            public void run() {
                DeviceInfoCollector.startCollector(C0977b.this.f6089d);
                PackageCollector.startCollector(C0977b.this.f6089d);
                RuntimeCollector.startCollector(C0977b.this.f6089d);
                UDPServer.start(C0977b.this.f6089d);
            }
        }).start();
        new Thread(new Runnable() { // from class: cn.smssdk.net.b.2
            @Override // java.lang.Runnable
            public void run() {
                RuntimeCollector.startCollector(C0977b.this.f6089d);
            }
        }).start();
        new Thread(new Runnable() { // from class: cn.smssdk.net.b.3
            @Override // java.lang.Runnable
            public void run() {
                UDPServer.start(C0977b.this.f6089d);
            }
        }).start();
        new Thread(new Runnable() { // from class: cn.smssdk.net.b.4
            @Override // java.lang.Runnable
            public void run() {
                DeviceInfoCollector.startCollector(C0977b.this.f6089d);
            }
        }).start();
    }

    /* JADX INFO: renamed from: cn.smssdk.net.b$a */
    /* JADX INFO: compiled from: Config.java */
    class a extends Thread {

        /* JADX INFO: renamed from: b */
        private boolean f6117b = false;

        /* JADX INFO: renamed from: c */
        private boolean f6118c = true;

        /* JADX INFO: renamed from: d */
        private boolean f6119d = true;

        /* JADX INFO: renamed from: e */
        private long f6120e;

        a() {
        }

        /* JADX INFO: renamed from: a */
        public void m6775a() {
            this.f6120e = C0977b.this.f6101p * 1000;
        }

        /* JADX INFO: renamed from: a */
        public void m6776a(boolean z) {
            this.f6117b = z;
        }

        /* JADX INFO: renamed from: b */
        public boolean m6778b() {
            return this.f6119d;
        }

        /* JADX INFO: renamed from: c */
        public void m6779c() {
            this.f6119d = false;
        }

        /* JADX INFO: renamed from: b */
        public void m6777b(boolean z) {
            this.f6118c = z;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            while (true) {
                if (this.f6118c || this.f6120e <= 0) {
                    try {
                        m6774d();
                    } catch (Throwable unused) {
                        this.f6119d = true;
                        if (C0977b.this.f6095j.writeLock().tryLock()) {
                            this.f6118c = false;
                            C0977b.this.f6098m = false;
                            C0977b.this.f6096k.signalAll();
                            C0977b.this.f6095j.writeLock().unlock();
                        }
                    }
                }
                try {
                    sleep(100L);
                    this.f6120e -= 100;
                } catch (InterruptedException unused2) {
                }
            }
        }

        /* JADX INFO: renamed from: d */
        private void m6774d() throws Throwable {
            EventRecorder.addBegin("SMSSDK", "getConfig");
            String strM6743a = C0977b.this.m6743a(false);
            if (TextUtils.isEmpty(strM6743a)) {
                throw new Throwable("duid is empty!");
            }
            if (this.f6117b) {
                C0978c.m6788b();
            }
            HashMap map = new HashMap();
            map.put("appkey", C0977b.this.f6087b);
            map.put("appsecret", C0977b.this.f6088c);
            map.put("duid", strM6743a);
            map.put("sdkver", BuildConfig.VERSION_NAME);
            map.put("plat", 1);
            HashMap mapM6745a = C0977b.this.m6745a(C0977b.this.f6093h, map, false, false, 1);
            if (mapM6745a != null) {
                try {
                    C0977b.this.f6095j.writeLock().lock();
                    try {
                        C0977b.this.m6749a((HashMap<String, Object>) mapM6745a);
                        this.f6119d = false;
                    } catch (Throwable unused) {
                        this.f6119d = true;
                        C0977b.this.f6090e.setConfig("");
                        C0977b.this.m6749a((HashMap<String, Object>) C0977b.this.f6091f.fromJson("{\"status\":200,\"expire_at\":86400,\"update\":1466077916207,\"zonelist_update\":20151129,\"request\":1,\"sms_toggle\":1,\"sms_home\":1,\"sms_sp_region\":1,\"sms_foreign\":1,\"result\":{\"urls\":[{\"name\":\"uploadCollectData\",\"url\":\"http://upc1299.uz.local:8082/relat/seda\",\"params\":[\"appKey\",\"duid\",\"sdkver\",\"my_phone\",\"collectTime\",\"data\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"sendTextSMS\",\"url\":\"http://code.sms.mob.com/verify/code\",\"params\":[\"appkey\",\"duid\",\"zone\",\"phone\",\"simserial\",\"my_phone\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"submitUser\",\"url\":\"http://sdkapi.sms.mob.com/app/submituserinfo\",\"params\":[],\"params_chunk\":\"user_info_001\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"logCollect\",\"url\":\"http://log.sms.mob.com/log/collect\",\"params\":[],\"params_chunk\":\"collect_001\",\"encode\":\"AES\",\"zip\":1,\"request\":1,\"frequency\":\"1:2:m\"},{\"name\":\"verifyCode\",\"url\":\"http://code.sms.mob.com/client/verification\",\"params\":[\"zone\",\"phone\",\"code\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"sendVoiceSMS\",\"url\":\"http://code.sms.mob.com/voice/verify/code\",\"params\":[\"zone\",\"phone\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"getFriend\",\"url\":\"http://addrlist.sms.mob.com/relat/fm\",\"params\":[\"appkey\",\"duid\",\"contactphones\",\"plat\",\"sdkver\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"uploadContacts\",\"url\":\"http://addrlist.sms.mob.com/relat/apply\",\"params\":[],\"params_chunk\":\"contacts_002\",\"encode\":\"RSA\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"getZoneList\",\"url\":\"http://sdkapi.sms.mob.com/utils/zonelist\",\"params\":[\"plat\",\"sdkver\",\"token\",\"appkey\",\"duid\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"},{\"name\":\"logInstall\",\"url\":\"http://log.sms.mob.com/log/install\",\"params\":[],\"params_chunk\":\"install_002\",\"encode\":\"AES\",\"zip\":1,\"request\":1,\"frequency\":\"\"},{\"name\":\"getToken\",\"url\":\"http://sdkapi.sms.mob.com/token/get\",\"params\":[\"appkey\",\"duid\",\"sdkver\",\"plat\",\"aesKey\",\"sign\"],\"params_chunk\":\"\",\"encode\":\"RSA\",\"zip\":0,\"request\":1,\"frequency\":\"\"}]}}"));
                    }
                    if (!this.f6119d) {
                        C0977b.this.f6090e.setConfig(C0977b.this.f6091f.fromHashMap(mapM6745a));
                    }
                    this.f6118c = false;
                    C0977b.this.f6098m = false;
                    if (this.f6117b) {
                        this.f6117b = false;
                        C0977b.this.f6096k.signalAll();
                    }
                    C0977b.this.f6095j.writeLock().unlock();
                    EventRecorder.addEnd("SMSSDK", "getConfig");
                    return;
                } catch (Throwable th) {
                    C0977b.this.f6095j.writeLock().unlock();
                    throw th;
                }
            }
            throw new Throwable("response is empty");
        }
    }
}
