package com.mob.commons.authorize;

import android.content.Context;
import android.support.v4.app.NotificationCompat;
import com.mob.commons.C1553e;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: com.mob.commons.authorize.a */
/* JADX INFO: compiled from: Authorizer.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1547a {
    /* JADX INFO: renamed from: a */
    public final String m8510a(final Context context, final com.mob.commons.MobProduct mobProduct) {
        final String[] strArr = new String[1];
        C1553e.m8547a(new File(ResHelper.getCacheRoot(context), "comm/locks/.globalLock"), true, new Runnable() { // from class: com.mob.commons.authorize.a.1
            @Override // java.lang.Runnable
            public void run() {
                strArr[0] = C1547a.this.m8505b(context, mobProduct);
            }
        });
        return strArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public final File m8504b(Context context) {
        File file = new File(ResHelper.getCacheRoot(context), "comm/dbs/.duid");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        return file;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004a  */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.File] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String m8505b(android.content.Context r9, com.mob.commons.MobProduct r10) {
        /*
            Method dump skipped, instruction units count: 222
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.C1547a.m8505b(android.content.Context, com.mob.commons.MobProduct):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    private final boolean m8503a(Context context, HashMap<String, String> map) {
        Object objInvokeStaticMethod;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        if (map == null) {
            return true;
        }
        try {
            objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            objInvokeStaticMethod = null;
        }
        String str9 = map.get("adsid");
        if (objInvokeStaticMethod != null) {
            try {
                str = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAdvertisingID", new Object[0]);
            } catch (Throwable th2) {
                MobLog.getInstance().m8622w(th2);
                str = null;
            }
        } else {
            str = null;
        }
        if (str != null && ((str9 == null && str != null) || (str9 != null && !str9.equals(str)))) {
            return true;
        }
        String str10 = map.get("imei");
        if (objInvokeStaticMethod != null) {
            try {
                str2 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getIMEI", new Object[0]);
            } catch (Throwable th3) {
                MobLog.getInstance().m8622w(th3);
                str2 = null;
            }
        } else {
            str2 = null;
        }
        if (str10 == null || !str10.equals(str2)) {
            return true;
        }
        String str11 = map.get("serialno");
        if (objInvokeStaticMethod != null) {
            try {
                str3 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSerialno", new Object[0]);
            } catch (Throwable th4) {
                MobLog.getInstance().m8622w(th4);
                str3 = null;
            }
        } else {
            str3 = null;
        }
        if (str11 == null || !str11.equals(str3)) {
            return true;
        }
        String str12 = map.get("mac");
        if (objInvokeStaticMethod != null) {
            try {
                str4 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getMacAddress", new Object[0]);
            } catch (Throwable th5) {
                MobLog.getInstance().m8622w(th5);
                str4 = null;
            }
        } else {
            str4 = null;
        }
        if (str12 == null || !str12.equals(str4)) {
            return true;
        }
        String str13 = map.get("model");
        if (objInvokeStaticMethod != null) {
            try {
                str5 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getModel", new Object[0]);
            } catch (Throwable th6) {
                MobLog.getInstance().m8622w(th6);
                str5 = null;
            }
        } else {
            str5 = null;
        }
        if (str13 == null || !str13.equals(str5)) {
            return true;
        }
        String str14 = map.get("factory");
        if (objInvokeStaticMethod != null) {
            try {
                str6 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getManufacturer", new Object[0]);
            } catch (Throwable th7) {
                MobLog.getInstance().m8622w(th7);
                str6 = null;
            }
        } else {
            str6 = null;
        }
        if (str14 == null || !str14.equals(str6)) {
            return true;
        }
        String str15 = map.get("androidid");
        if (objInvokeStaticMethod != null) {
            try {
                str7 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAndroidID", new Object[0]);
            } catch (Throwable th8) {
                MobLog.getInstance().m8622w(th8);
                str7 = null;
            }
        } else {
            str7 = null;
        }
        if (str15 == null || !str15.equals(str7)) {
            return true;
        }
        String str16 = map.get("sysver");
        if (objInvokeStaticMethod != null) {
            try {
                str8 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getOSVersionName", new Object[0]);
            } catch (Throwable th9) {
                MobLog.getInstance().m8622w(th9);
                str8 = null;
            }
        } else {
            str8 = null;
        }
        return str16 == null || !str16.equals(str8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0129 A[EXC_TOP_SPLITTER, PHI: r11
      0x0129: PHI (r11v7 java.io.ObjectOutputStream) = (r11v14 java.io.ObjectOutputStream), (r11v15 java.io.ObjectOutputStream) binds: [B:28:0x013e, B:18:0x0127] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r11v11 */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v8 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.util.HashMap<java.lang.String, java.lang.Object> m8508c(android.content.Context r11, com.mob.commons.MobProduct r12) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.C1547a.m8508c(android.content.Context, com.mob.commons.MobProduct):java.util.HashMap");
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x0141 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0126 A[EXC_TOP_SPLITTER, PHI: r11
      0x0126: PHI (r11v7 java.io.ObjectOutputStream) = (r11v6 java.io.ObjectOutputStream), (r11v9 java.io.ObjectOutputStream) binds: [B:29:0x013b, B:19:0x0124] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String m8500a(android.content.Context r11, com.mob.commons.MobProduct r12, java.util.HashMap<java.lang.String, java.lang.Object> r13, boolean r14) {
        /*
            Method dump skipped, instruction units count: 339
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.C1547a.m8500a(android.content.Context, com.mob.commons.MobProduct, java.util.HashMap, boolean):java.lang.String");
    }

    /* JADX INFO: renamed from: a */
    private final void m8502a(Context context, com.mob.commons.MobProduct mobProduct, HashMap<String, Object> map) {
        ObjectOutputStream objectOutputStream;
        try {
            String str = (String) map.get("duid");
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
            ArrayList<KVPair<String>> arrayList = new ArrayList<>();
            arrayList.add(new KVPair<>("product", mobProduct.getProductTag()));
            arrayList.add(new KVPair<>("appkey", mobProduct.getProductAppkey()));
            arrayList.add(new KVPair<>("duid", str));
            arrayList.add(new KVPair<>("apppkg", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPackageName", new Object[0]))));
            arrayList.add(new KVPair<>("appver", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAppVersion", new Object[0]))));
            arrayList.add(new KVPair<>("sdkver", String.valueOf(mobProduct.getSdkver())));
            arrayList.add(new KVPair<>("network", String.valueOf(ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getDetailNetworkTypeForStatic", new Object[0]))));
            NetworkHelper.NetworkTimeOut networkTimeOut = new NetworkHelper.NetworkTimeOut();
            networkTimeOut.readTimout = 30000;
            networkTimeOut.connectionTimeout = 30000;
            HashMap mapFromJson = new Hashon().fromJson(new NetworkHelper().httpPost("http://devs.data.mob.com:80/dsign", arrayList, null, null, networkTimeOut));
            if ("true".equals(String.valueOf(mapFromJson.get("reup")))) {
                m8500a(context, mobProduct, map, false);
            }
            if ("200".equals(String.valueOf(mapFromJson.get(NotificationCompat.CATEGORY_STATUS)))) {
                ((HashMap) ((HashMap) map.get("appInfo")).get((String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPackageName", new Object[0]))).put(mobProduct.getProductTag(), mobProduct.getProductAppkey());
                ObjectOutputStream objectOutputStream2 = null;
                try {
                    try {
                        try {
                            objectOutputStream = new ObjectOutputStream(new FileOutputStream(m8504b(context)));
                        } catch (Throwable unused) {
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
                try {
                    objectOutputStream.writeObject(map);
                } catch (Throwable th3) {
                    objectOutputStream2 = objectOutputStream;
                    th = th3;
                    if (objectOutputStream2 != null) {
                        try {
                            objectOutputStream2.flush();
                            objectOutputStream2.close();
                        } catch (Throwable unused2) {
                        }
                    }
                    throw th;
                }
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
            }
        } catch (Throwable th4) {
            MobLog.getInstance().m8622w(th4);
        }
    }

    /* JADX INFO: renamed from: a */
    public final String m8509a(final Context context) {
        final String[] strArr = new String[1];
        C1553e.m8547a(new File(ResHelper.getCacheRoot(context), "comm/locks/.globalLock"), true, new Runnable() { // from class: com.mob.commons.authorize.a.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Removed duplicated region for block: B:29:0x0051  */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v12 */
            /* JADX WARN: Type inference failed for: r1v13 */
            /* JADX WARN: Type inference failed for: r1v14 */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void run() throws java.lang.Throwable {
                /*
                    r4 = this;
                    r0 = 0
                    com.mob.commons.authorize.a r1 = com.mob.commons.authorize.C1547a.this     // Catch: java.lang.Throwable -> L47
                    android.content.Context r2 = r2     // Catch: java.lang.Throwable -> L47
                    java.io.File r1 = com.mob.commons.authorize.C1547a.m8499a(r1, r2)     // Catch: java.lang.Throwable -> L47
                    boolean r2 = r1.exists()     // Catch: java.lang.Throwable -> L47
                    if (r2 == 0) goto L4f
                    boolean r2 = r1.isFile()     // Catch: java.lang.Throwable -> L47
                    if (r2 == 0) goto L4f
                    java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L31
                    r2.<init>(r1)     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L31
                    java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L31
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L31
                    java.lang.Object r2 = r1.readObject()     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                    java.util.HashMap r2 = (java.util.HashMap) r2     // Catch: java.lang.Throwable -> L2c java.lang.Throwable -> L40
                    if (r1 == 0) goto L2a
                    r1.close()     // Catch: java.lang.Throwable -> L2a
                L2a:
                    r0 = r2
                    goto L4f
                L2c:
                    r2 = move-exception
                    goto L33
                L2e:
                    r2 = move-exception
                    r1 = r0
                    goto L41
                L31:
                    r2 = move-exception
                    r1 = r0
                L33:
                    com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L40
                    r3.m8622w(r2)     // Catch: java.lang.Throwable -> L40
                    if (r1 == 0) goto L4f
                    r1.close()     // Catch: java.lang.Throwable -> L4f
                    goto L4f
                L40:
                    r2 = move-exception
                L41:
                    if (r1 == 0) goto L46
                    r1.close()     // Catch: java.lang.Throwable -> L46
                L46:
                    throw r2     // Catch: java.lang.Throwable -> L47
                L47:
                    r1 = move-exception
                    com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()
                    r2.m8622w(r1)
                L4f:
                    if (r0 != 0) goto L59
                    com.mob.commons.authorize.a r0 = com.mob.commons.authorize.C1547a.this
                    android.content.Context r1 = r2
                    java.util.HashMap r0 = com.mob.commons.authorize.C1547a.m8506b(r0, r1)
                L59:
                    java.lang.String[] r1 = r3
                    r2 = 0
                    java.lang.String r3 = "duid"
                    java.lang.Object r0 = r0.get(r3)
                    java.lang.String r0 = (java.lang.String) r0
                    r1[r2] = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.authorize.C1547a.AnonymousClass2.run():void");
            }
        });
        return strArr[0];
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public HashMap<String, Object> m8507c(Context context) throws Throwable {
        ObjectOutputStream objectOutputStream;
        HashMap<String, Object> map = new HashMap<>();
        ObjectOutputStream objectOutputStream2 = null;
        try {
            try {
                try {
                    Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", context);
                    String str = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getModel", new Object[0]);
                    if (str == null) {
                        str = "";
                    }
                    String str2 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getIMEI", new Object[0]);
                    if (str2 == null) {
                        str2 = "";
                    }
                    String str3 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getMacAddress", new Object[0]);
                    if (str3 == null) {
                        str3 = "";
                    }
                    String str4 = (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSerialno", new Object[0]);
                    if (str4 == null) {
                        str4 = "";
                    }
                    map.put("duid", Data.byteToHex(Data.SHA1(str + ":" + str2 + ":" + str3 + ":" + str4)));
                    HashMap map2 = new HashMap();
                    map2.put("adsid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAdvertisingID", new Object[0]));
                    map2.put("imei", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getIMEI", new Object[0]));
                    map2.put("serialno", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getSerialno", new Object[0]));
                    map2.put("androidid", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAndroidID", new Object[0]));
                    map2.put("mac", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getMacAddress", new Object[0]));
                    map2.put("model", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getModel", new Object[0]));
                    map2.put("factory", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getManufacturer", new Object[0]));
                    map2.put("carrier", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getCarrier", new Object[0]));
                    map2.put("screensize", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getScreenSize", new Object[0]));
                    map2.put("sysver", ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getOSVersionName", new Object[0]));
                    map2.put("plat", 1);
                    map.put("deviceInfo", map2);
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(m8504b(context)));
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                objectOutputStream.writeObject(map);
                if (objectOutputStream != null) {
                    objectOutputStream.flush();
                    objectOutputStream.close();
                }
            } catch (Throwable th3) {
                objectOutputStream2 = objectOutputStream;
                th = th3;
                if (objectOutputStream2 != null) {
                    try {
                        objectOutputStream2.flush();
                        objectOutputStream2.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (Throwable unused2) {
        }
        return map;
    }
}
