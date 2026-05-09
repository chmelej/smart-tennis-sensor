package com.mob.commons;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.MobHandlerThread;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.SQLiteHelper;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: com.mob.commons.c */
/* JADX INFO: compiled from: DataHeap.java */
/* JADX INFO: loaded from: classes.dex */
public class C1549c implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    private static C1549c f8977a;

    /* JADX INFO: renamed from: b */
    private Context f8978b;

    /* JADX INFO: renamed from: c */
    private Handler f8979c;

    /* JADX INFO: renamed from: d */
    private SQLiteHelper.SingleTableDB f8980d;

    /* JADX INFO: renamed from: e */
    private Hashon f8981e = new Hashon();

    /* JADX INFO: renamed from: f */
    private Random f8982f = new Random();

    /* JADX INFO: renamed from: a */
    public static synchronized C1549c m8516a(Context context) {
        if (f8977a == null) {
            f8977a = new C1549c(context);
        }
        return f8977a;
    }

    private C1549c(Context context) {
        this.f8978b = context.getApplicationContext();
        MobHandlerThread mobHandlerThread = new MobHandlerThread();
        mobHandlerThread.start();
        this.f8979c = new Handler(mobHandlerThread.getLooper(), this);
        File file = new File(ResHelper.getCacheRoot(context), "comm/dbs/.dh");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        this.f8980d = SQLiteHelper.getDatabase(file.getAbsolutePath(), "DataHeap_1");
        this.f8980d.addField("time", "text", true);
        this.f8980d.addField("data", "text", true);
        this.f8979c.sendEmptyMessage(1);
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m8529a(long j, HashMap<String, Object> map) {
        Message message = new Message();
        message.what = 2;
        message.obj = new Object[]{Long.valueOf(j), map};
        this.f8979c.sendMessage(message);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                m8518a();
                this.f8979c.sendEmptyMessageDelayed(1, 10000L);
                return false;
            case 2:
                Object[] objArr = (Object[]) message.obj;
                long jLongValue = ((Long) ResHelper.forceCast(objArr[0], -1L)).longValue();
                if (jLongValue > 0) {
                    m8524b(jLongValue, (HashMap<String, Object>) objArr[1]);
                }
                return false;
            default:
                return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m8524b(final long j, final HashMap<String, Object> map) {
        C1553e.m8547a(new File(ResHelper.getCacheRoot(this.f8978b), "comm/locks/.dhlock"), true, new Runnable() { // from class: com.mob.commons.c.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("time", String.valueOf(j));
                    contentValues.put("data", Base64.encodeToString(Data.AES128Encode(Data.rawMD5(String.valueOf(ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", C1549c.this.f8978b), "getManufacturer", new Object[0]))), C1549c.this.f8981e.fromHashMap(map).getBytes("utf-8")), 2));
                    SQLiteHelper.insert(C1549c.this.f8980d, contentValues);
                } catch (Throwable th) {
                    MobLog.getInstance().m8622w(th);
                }
            }
        });
    }

    /* JADX INFO: renamed from: a */
    private void m8518a() {
        String str;
        try {
            str = (String) ReflectHelper.invokeInstanceMethod(ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8978b), "getNetworkType", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            str = null;
        }
        if (str == null || "none".equals(str)) {
            return;
        }
        C1553e.m8547a(new File(ResHelper.getCacheRoot(this.f8978b), "comm/locks/.dhlock"), true, new Runnable() { // from class: com.mob.commons.c.2
            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayListM8523b = C1549c.this.m8523b();
                if (arrayListM8523b.size() <= 0 || !C1549c.this.m8520a((ArrayList<String[]>) arrayListM8523b)) {
                    return;
                }
                C1549c.this.m8526b((ArrayList<String[]>) arrayListM8523b);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public ArrayList<String[]> m8523b() {
        ArrayList<String[]> arrayList = new ArrayList<>();
        try {
            Cursor cursorQuery = SQLiteHelper.query(this.f8980d, new String[]{"time", "data"}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    long jM8440a = C1541a.m8440a(this.f8978b);
                    do {
                        String[] strArr = {cursorQuery.getString(0), cursorQuery.getString(1)};
                        long j = -1;
                        try {
                            j = Long.parseLong(strArr[0]);
                        } catch (Throwable unused) {
                        }
                        if (j <= jM8440a) {
                            arrayList.add(strArr);
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public boolean m8520a(ArrayList<String[]> arrayList) {
        try {
            C1548b c1548bM8511a = C1548b.m8511a(this.f8978b);
            ArrayList<MobProduct> arrayListM8513a = c1548bM8511a.m8513a();
            if (arrayListM8513a.isEmpty()) {
                return false;
            }
            HashMap map = new HashMap();
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8978b);
            map.put("plat", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPlatformCode", new Object[0]));
            map.put("device", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDeviceKey", new Object[0]));
            map.put("mac", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getMacAddress", new Object[0]));
            map.put("model", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getModel", new Object[0]));
            map.put("duid", DeviceAuthorizer.authorize(this.f8978b, (MobProduct) null));
            map.put("imei", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getIMEI", new Object[0]));
            map.put("serialno", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSerialno", new Object[0]));
            map.put("networktype", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]));
            ArrayList arrayList2 = new ArrayList();
            byte[] bArrRawMD5 = Data.rawMD5(String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getManufacturer", new Object[0])));
            Iterator<String[]> it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    arrayList2.add(this.f8981e.fromJson(new String(Data.AES128Decode(bArrRawMD5, Base64.decode(it.next()[1], 2)), "utf-8").trim()));
                } catch (Throwable th) {
                    MobLog.getInstance().m8622w(th);
                }
            }
            map.put("datas", arrayList2);
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(new KVPair<>("appkey", arrayListM8513a.get(0).getProductAppkey()));
            arrayList3.add(new KVPair<>("m", m8517a(this.f8981e.fromHashMap(map))));
            ArrayList<KVPair<String>> arrayList4 = new ArrayList<>();
            arrayList4.add(new KVPair<>("User-Identity", c1548bM8511a.m8512a(arrayListM8513a)));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            boolean zEquals = "200".equals(String.valueOf(this.f8981e.fromJson(c1548bM8511a.httpPost(m8522b(this.f8978b), arrayList3, null, arrayList4, networkTimeOut)).get(NotificationCompat.CATEGORY_STATUS)));
            if (!zEquals) {
                C1558f.m8566e(this.f8978b, null);
            }
            return zEquals;
        } catch (Throwable th2) {
            C1558f.m8566e(this.f8978b, null);
            MobLog.getInstance().m8622w(th2);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m8517a(String str) throws Throwable {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        dataOutputStream.writeLong(this.f8982f.nextLong());
        dataOutputStream.writeLong(this.f8982f.nextLong());
        dataOutputStream.flush();
        dataOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream2);
        gZIPOutputStream.write(str.getBytes("utf-8"));
        gZIPOutputStream.flush();
        gZIPOutputStream.close();
        byte[] bArrAES128Encode = Data.AES128Encode(byteArray, byteArrayOutputStream2.toByteArray());
        byte[] bArrEncode = new MobRSA(1024).encode(byteArray, new BigInteger("ceeef5035212dfe7c6a0acdc0ef35ce5b118aab916477037d7381f85c6b6176fcf57b1d1c3296af0bb1c483fe5e1eb0ce9eb2953b44e494ca60777a1b033cc07", 16), new BigInteger("191737288d17e660c4b61440d5d14228a0bf9854499f9d68d8274db55d6d954489371ecf314f26bec236e58fac7fffa9b27bcf923e1229c4080d49f7758739e5bd6014383ed2a75ce1be9b0ab22f283c5c5e11216c5658ba444212b6270d629f2d615b8dfdec8545fb7d4f935b0cc10b6948ab4fc1cb1dd496a8f94b51e888dd", 16));
        ByteArrayOutputStream byteArrayOutputStream3 = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream3);
        dataOutputStream2.writeInt(bArrEncode.length);
        dataOutputStream2.write(bArrEncode);
        dataOutputStream2.writeInt(bArrAES128Encode.length);
        dataOutputStream2.write(bArrAES128Encode);
        dataOutputStream2.flush();
        dataOutputStream2.close();
        return Base64.encodeToString(byteArrayOutputStream3.toByteArray(), 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m8526b(ArrayList<String[]> arrayList) {
        try {
            StringBuilder sb = new StringBuilder();
            for (String[] strArr : arrayList) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                sb.append('\'');
                sb.append(strArr[0]);
                sb.append('\'');
            }
            SQLiteHelper.delete(this.f8980d, "time in (" + sb.toString() + ")", null);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    /* JADX INFO: renamed from: b */
    private static String m8522b(Context context) {
        String strM8567f;
        try {
            strM8567f = C1558f.m8567f(context);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            strM8567f = null;
        }
        return TextUtils.isEmpty(strM8567f) ? "http://c.data.mob.com/v2/cdata" : strM8567f;
    }
}
