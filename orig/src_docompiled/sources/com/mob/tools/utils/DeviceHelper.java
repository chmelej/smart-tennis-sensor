package com.mob.tools.utils;

import android.app.UiModeManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Environment;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.Process;
import android.os.SystemClock;
import android.provider.Settings;
import android.support.v4.os.EnvironmentCompat;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.mob.tools.MobLog;
import com.umeng.message.MsgConstant;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class DeviceHelper {
    private static DeviceHelper deviceHelper;
    private Context context;

    public int getPlatformCode() {
        return 1;
    }

    public boolean isRooted() {
        return false;
    }

    public static synchronized DeviceHelper getInstance(Context context) {
        if (deviceHelper == null && context != null) {
            deviceHelper = new DeviceHelper(context);
        }
        return deviceHelper;
    }

    private DeviceHelper(Context context) {
        this.context = context.getApplicationContext();
    }

    public String getSSID() {
        Object systemService;
        try {
            if (!checkPermission(MsgConstant.PERMISSION_ACCESS_WIFI_STATE) || (systemService = getSystemService("wifi")) == null) {
                return null;
            }
            Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getConnectionInfo", new Object[0]);
            if (objInvokeInstanceMethod != null) {
                String str = (String) ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod, "getSSID", new Object[0]);
                if (str == null) {
                    return null;
                }
                return str.replace("\"", "");
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
        return null;
    }

    public String getBssid() {
        Object systemService;
        try {
            if (!checkPermission(MsgConstant.PERMISSION_ACCESS_WIFI_STATE) || (systemService = getSystemService("wifi")) == null) {
                return null;
            }
            Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getConnectionInfo", new Object[0]);
            if (objInvokeInstanceMethod != null) {
                String str = (String) ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod, "getBSSID", new Object[0]);
                if (str == null) {
                    return null;
                }
                return str;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
        return null;
    }

    public String getMacAddress() {
        String currentNetworkHardwareAddress;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                currentNetworkHardwareAddress = getHardwareAddressFromShell("wlan0");
            } catch (Throwable th) {
                MobLog.getInstance().m8610d(th);
                currentNetworkHardwareAddress = null;
            }
            if (currentNetworkHardwareAddress == null) {
                try {
                    currentNetworkHardwareAddress = getCurrentNetworkHardwareAddress();
                } catch (Throwable th2) {
                    MobLog.getInstance().m8610d(th2);
                    currentNetworkHardwareAddress = null;
                }
            }
            if (currentNetworkHardwareAddress == null) {
                try {
                    String[] strArrListNetworkHardwareAddress = listNetworkHardwareAddress();
                    if (strArrListNetworkHardwareAddress.length > 0) {
                        currentNetworkHardwareAddress = strArrListNetworkHardwareAddress[0];
                    }
                } catch (Throwable th3) {
                    MobLog.getInstance().m8610d(th3);
                    currentNetworkHardwareAddress = null;
                }
            }
            if (currentNetworkHardwareAddress != null) {
                return currentNetworkHardwareAddress;
            }
        }
        try {
            Object systemService = getSystemService("wifi");
            if (systemService == null) {
                return null;
            }
            Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getConnectionInfo", new Object[0]);
            if (objInvokeInstanceMethod != null) {
                String str = (String) ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod, "getMacAddress", new Object[0]);
                if (str == null) {
                    return null;
                }
                return str;
            }
        } catch (Throwable th4) {
            MobLog.getInstance().m8622w(th4);
        }
        return null;
    }

    private String getCurrentNetworkHardwareAddress() throws SocketException {
        byte[] hardwareAddress;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        for (NetworkInterface networkInterface : Collections.list(networkInterfaces)) {
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            if (inetAddresses != null) {
                for (InetAddress inetAddress : Collections.list(inetAddresses)) {
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address) && (hardwareAddress = networkInterface.getHardwareAddress()) != null) {
                        StringBuilder sb = new StringBuilder();
                        for (byte b : hardwareAddress) {
                            sb.append(String.format("%02x:", Byte.valueOf(b)));
                        }
                        if (sb.length() > 0) {
                            sb.deleteCharAt(sb.length() - 1);
                        }
                        return sb.toString();
                    }
                }
            }
        }
        return null;
    }

    private String[] listNetworkHardwareAddress() throws SocketException {
        int i;
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        if (networkInterfaces == null) {
            return null;
        }
        ArrayList list = Collections.list(networkInterfaces);
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            NetworkInterface networkInterface = (NetworkInterface) it.next();
            byte[] hardwareAddress = networkInterface.getHardwareAddress();
            if (hardwareAddress != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b : hardwareAddress) {
                    sb.append(String.format("%02x:", Byte.valueOf(b)));
                }
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
                map.put(networkInterface.getName(), sb.toString());
            }
        }
        ArrayList arrayList = new ArrayList(map.keySet());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        ArrayList arrayList5 = new ArrayList();
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        ArrayList arrayList8 = new ArrayList();
        while (arrayList.size() > 0) {
            String str = (String) arrayList.remove(0);
            if (str.startsWith("wlan")) {
                arrayList2.add(str);
            } else if (str.startsWith("eth")) {
                arrayList3.add(str);
            } else if (str.startsWith("rev_rmnet")) {
                arrayList4.add(str);
            } else if (str.startsWith("dummy")) {
                arrayList5.add(str);
            } else if (str.startsWith("usbnet")) {
                arrayList6.add(str);
            } else if (str.startsWith("rmnet_usb")) {
                arrayList7.add(str);
            } else {
                arrayList8.add(str);
            }
        }
        Collections.sort(arrayList2);
        Collections.sort(arrayList3);
        Collections.sort(arrayList4);
        Collections.sort(arrayList5);
        Collections.sort(arrayList6);
        Collections.sort(arrayList7);
        Collections.sort(arrayList8);
        arrayList.addAll(arrayList2);
        arrayList.addAll(arrayList3);
        arrayList.addAll(arrayList4);
        arrayList.addAll(arrayList5);
        arrayList.addAll(arrayList6);
        arrayList.addAll(arrayList7);
        arrayList.addAll(arrayList8);
        String[] strArr = new String[arrayList.size()];
        for (i = 0; i < strArr.length; i++) {
            strArr[i] = (String) map.get(arrayList.get(i));
        }
        return strArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getHardwareAddressFromShell(java.lang.String r5) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            r1.<init>()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "ca"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "t "
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "/s"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "ys"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "/c"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "la"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "ss"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "/n"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "et"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r2 = "/"
            r1.append(r2)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            r1.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r5 = "/a"
            r1.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r5 = "dd"
            r1.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r5 = "re"
            r1.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r5 = "ss"
            r1.append(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.Runtime r5 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.Process r5 = r5.exec(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.io.InputStream r5 = r5.getInputStream()     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            r1.<init>(r5)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.io.BufferedReader r5 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            r5.<init>(r1)     // Catch: java.lang.Throwable -> L75 java.lang.Throwable -> L77
            java.lang.String r1 = r5.readLine()     // Catch: java.lang.Throwable -> L73 java.lang.Throwable -> L8f
            if (r5 == 0) goto L86
            r5.close()     // Catch: java.lang.Throwable -> L86
            goto L86
        L73:
            r1 = move-exception
            goto L79
        L75:
            r5 = move-exception
            goto L93
        L77:
            r1 = move-exception
            r5 = r0
        L79:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L8f
            r2.m8610d(r1)     // Catch: java.lang.Throwable -> L8f
            if (r5 == 0) goto L85
            r5.close()     // Catch: java.lang.Throwable -> L85
        L85:
            r1 = r0
        L86:
            boolean r5 = android.text.TextUtils.isEmpty(r1)
            if (r5 == 0) goto L8d
            goto L8e
        L8d:
            r0 = r1
        L8e:
            return r0
        L8f:
            r0 = move-exception
            r3 = r0
            r0 = r5
            r5 = r3
        L93:
            if (r0 == 0) goto L98
            r0.close()     // Catch: java.lang.Throwable -> L98
        L98:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.getHardwareAddressFromShell(java.lang.String):java.lang.String");
    }

    public String getModel() {
        return Build.MODEL;
    }

    public String getManufacturer() {
        return Build.MANUFACTURER;
    }

    public String getDeviceId() {
        String imei = getIMEI();
        return (!TextUtils.isEmpty(imei) || Build.VERSION.SDK_INT < 9) ? imei : getSerialno();
    }

    public String getMime() {
        return getIMEI();
    }

    public String getIMEI() {
        String str;
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        if (checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
            str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getDeviceId", new Object[0]);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public String getSerialno() {
        if (Build.VERSION.SDK_INT < 9) {
            return null;
        }
        try {
            ReflectHelper.importClass("android.os.SystemProperties");
            return (String) ReflectHelper.invokeStaticMethod("SystemProperties", "get", "ro.serialno", EnvironmentCompat.MEDIA_UNKNOWN);
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return null;
        }
    }

    public String getDeviceData() {
        return Base64AES(getModel() + "|" + getOSVersionInt() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize(), getDeviceKey().substring(0, 16));
    }

    public String getDeviceDataNotAES() {
        return getModel() + "|" + getOSVersion() + "|" + getManufacturer() + "|" + getCarrier() + "|" + getScreenSize();
    }

    public String Base64AES(String str, String str2) {
        String strEncodeToString;
        try {
            strEncodeToString = Base64.encodeToString(Data.AES128Encode(str2, str), 0);
            try {
                return strEncodeToString.contains("\n") ? strEncodeToString.replace("\n", "") : strEncodeToString;
            } catch (Throwable th) {
                th = th;
                MobLog.getInstance().m8622w(th);
                return strEncodeToString;
            }
        } catch (Throwable th2) {
            th = th2;
            strEncodeToString = null;
        }
    }

    public String getOSVersion() {
        return String.valueOf(getOSVersionInt());
    }

    public int getOSVersionInt() {
        return Build.VERSION.SDK_INT;
    }

    public String getOSVersionName() {
        return Build.VERSION.RELEASE;
    }

    public String getOSLanguage() {
        return Locale.getDefault().getLanguage();
    }

    public String getAppLanguage() {
        return this.context.getResources().getConfiguration().locale.getLanguage();
    }

    public String getOSCountry() {
        return Locale.getDefault().getCountry();
    }

    public String getScreenSize() {
        int[] screenSize = ResHelper.getScreenSize(this.context);
        if (this.context.getResources().getConfiguration().orientation == 1) {
            return screenSize[0] + "x" + screenSize[1];
        }
        return screenSize[1] + "x" + screenSize[0];
    }

    public String getCarrier() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            String str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getSimOperator", new Object[0]);
            return TextUtils.isEmpty(str) ? "-1" : str;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "-1";
        }
    }

    public String getCarrierName() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
            if (checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                String str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getSimOperatorName", new Object[0]);
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                return str;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        return null;
    }

    public String getMCC() {
        String imsi = getIMSI();
        if (imsi == null || imsi.length() < 3) {
            return null;
        }
        return imsi.substring(0, 3);
    }

    public String getMNC() {
        String imsi = getIMSI();
        if (imsi == null || imsi.length() < 5) {
            return null;
        }
        return imsi.substring(3, 5);
    }

    public String getSimSerialNumber() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            return (String) ReflectHelper.invokeInstanceMethod(systemService, "getSimSerialNumber", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "-1";
        }
    }

    public String getLine1Number() {
        try {
            Object systemService = getSystemService("phone");
            if (systemService == null) {
                return "-1";
            }
            return (String) ReflectHelper.invokeInstanceMethod(systemService, "getLine1Number", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "-1";
        }
    }

    public String getBluetoothName() {
        try {
            ReflectHelper.importClass("android.bluetooth.BluetoothAdapter");
            if (!checkPermission("android.permission.BLUETOOTH")) {
                return null;
            }
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("BluetoothAdapter", "getDefaultAdapter", new Object[0]);
            if (objInvokeStaticMethod == null) {
                return null;
            }
            return (String) ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getName", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return null;
        }
    }

    public String getSignMD5() {
        try {
            return Data.MD5(this.context.getPackageManager().getPackageInfo(getPackageName(), 64).signatures[0].toByteArray());
        } catch (Exception e) {
            MobLog.getInstance().m8622w(e);
            return null;
        }
    }

    private Object getSystemService(String str) {
        try {
            return this.context.getSystemService(str);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1067)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1092)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    public java.lang.String getNetworkType() {
        /*
            r2 = this;
            java.lang.String r0 = "connectivity"
            java.lang.Object r0 = r2.getSystemService(r0)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 != 0) goto Ld
            java.lang.String r0 = "none"
            return r0
        Ld:
            java.lang.String r1 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r1 = r2.checkPermission(r1)     // Catch: java.lang.Throwable -> L5b
            if (r1 != 0) goto L18
            java.lang.String r0 = "none"
            return r0
        L18:
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L58
            boolean r1 = r0.isAvailable()
            if (r1 != 0) goto L25
            goto L58
        L25:
            int r0 = r0.getType()
            switch(r0) {
                case 0: goto L43;
                case 1: goto L40;
                default: goto L2c;
            }
        L2c:
            switch(r0) {
                case 6: goto L3d;
                case 7: goto L3a;
                case 8: goto L37;
                case 9: goto L34;
                default: goto L2f;
            }
        L2f:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            return r0
        L34:
            java.lang.String r0 = "ethernet"
            return r0
        L37:
            java.lang.String r0 = "dummy"
            return r0
        L3a:
            java.lang.String r0 = "bluetooth"
            return r0
        L3d:
            java.lang.String r0 = "wimax"
            return r0
        L40:
            java.lang.String r0 = "wifi"
            return r0
        L43:
            boolean r0 = r2.is4GMobileNetwork()
            if (r0 == 0) goto L4c
            java.lang.String r0 = "4G"
            return r0
        L4c:
            boolean r0 = r2.isFastMobileNetwork()
            if (r0 == 0) goto L55
            java.lang.String r0 = "3G"
            goto L57
        L55:
            java.lang.String r0 = "2G"
        L57:
            return r0
        L58:
            java.lang.String r0 = "none"
            return r0
        L5b:
            r0 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.m8622w(r0)
            java.lang.String r0 = "none"
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.getNetworkType():java.lang.String");
    }

    public String getNetworkTypeForStatic() {
        String lowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || "none".equals(lowerCase)) ? "none" : (lowerCase.startsWith("4g") || lowerCase.startsWith("3g") || lowerCase.startsWith("2g")) ? "cell" : lowerCase.startsWith("wifi") ? "wifi" : "other";
    }

    public String getDetailNetworkTypeForStatic() {
        String lowerCase = getNetworkType().toLowerCase();
        return (TextUtils.isEmpty(lowerCase) || "none".equals(lowerCase)) ? "none" : lowerCase.startsWith("wifi") ? "wifi" : lowerCase.startsWith("4g") ? "4g" : lowerCase.startsWith("3g") ? "3g" : lowerCase.startsWith("2g") ? "2g" : lowerCase.startsWith("bluetooth") ? "bluetooth" : lowerCase;
    }

    private boolean is4GMobileNetwork() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return false;
        }
        try {
            StringBuilder sb = new StringBuilder();
            sb.append("ge");
            sb.append("tN");
            sb.append("et");
            sb.append("wo");
            sb.append("rk");
            sb.append("Ty");
            sb.append("pe");
            return ((Integer) ReflectHelper.invokeInstanceMethod(systemService, sb.toString(), new Object[0])).intValue() == 13;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return false;
        }
    }

    private boolean isFastMobileNetwork() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return false;
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        switch (((Integer) ReflectHelper.invokeInstanceMethod(systemService, "getNetworkType", new Object[0])).intValue()) {
            case 0:
                return false;
            case 1:
                return false;
            case 2:
                return false;
            case 3:
                return true;
            case 4:
                return false;
            case 5:
                return true;
            case 6:
                return true;
            case 7:
                return false;
            case 8:
                return true;
            case 9:
                return true;
            case 10:
                return true;
            case 11:
                return false;
            case 12:
                return true;
            case 13:
                return true;
            case 14:
                return true;
            case 15:
                return true;
            default:
                return false;
        }
    }

    public JSONArray getRunningApp() {
        JSONArray jSONArray = new JSONArray();
        Object systemService = getSystemService("activity");
        if (systemService == null) {
            return jSONArray;
        }
        try {
            List list = (List) ReflectHelper.invokeInstanceMethod(systemService, "getRunningAppProcesses", new Object[0]);
            if (list == null) {
                return jSONArray;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                jSONArray.put(ReflectHelper.getInstanceField(it.next(), "processName"));
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        return jSONArray;
    }

    public String getRunningAppStr() {
        JSONArray runningApp = getRunningApp();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < runningApp.length(); i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(String.valueOf(runningApp.get(i)));
        }
        return sb.toString();
    }

    public String getDeviceKey() throws ClassNotFoundException, IOException {
        String strGenDeviceKey;
        String charAndNumr = null;
        try {
            strGenDeviceKey = getDeviceKeyWithDuid("comm/dbs/.duid");
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            strGenDeviceKey = null;
        }
        if (TextUtils.isEmpty(strGenDeviceKey) || strGenDeviceKey.length() < 40) {
            strGenDeviceKey = genDeviceKey();
        }
        if (!TextUtils.isEmpty(strGenDeviceKey) && strGenDeviceKey.length() >= 40) {
            return strGenDeviceKey;
        }
        try {
            charAndNumr = getLocalDeviceKey();
        } catch (Throwable th2) {
            MobLog.getInstance().m8622w(th2);
        }
        if (!TextUtils.isEmpty(charAndNumr) && charAndNumr.length() >= 40) {
            return charAndNumr;
        }
        if (TextUtils.isEmpty(charAndNumr) || charAndNumr.length() < 40) {
            charAndNumr = getCharAndNumr(40);
        }
        if (charAndNumr != null) {
            try {
                saveLocalDeviceKey(charAndNumr);
            } catch (Throwable th3) {
                MobLog.getInstance().m8622w(th3);
            }
        }
        return charAndNumr;
    }

    private String genDeviceKey() {
        try {
            return Data.byteToHex(Data.SHA1(getMacAddress() + ":" + getDeviceId() + ":" + getModel()));
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return null;
        }
    }

    public String getCharAndNumr(int i) {
        long jCurrentTimeMillis = System.currentTimeMillis() ^ SystemClock.elapsedRealtime();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(jCurrentTimeMillis);
        Random random = new Random();
        for (int i2 = 0; i2 < i; i2++) {
            if ("char".equalsIgnoreCase(random.nextInt(2) % 2 == 0 ? "char" : "num")) {
                stringBuffer.insert(i2 + 1, (char) (random.nextInt(26) + 97));
            } else {
                stringBuffer.insert(stringBuffer.length(), random.nextInt(10));
            }
        }
        return stringBuffer.toString().substring(0, 40);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0051  */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.io.File] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String getDeviceKeyWithDuid(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch: java.lang.Throwable -> L49
            android.content.Context r2 = r5.context     // Catch: java.lang.Throwable -> L49
            java.lang.String r2 = com.mob.tools.utils.ResHelper.getCacheRoot(r2)     // Catch: java.lang.Throwable -> L49
            r1.<init>(r2, r6)     // Catch: java.lang.Throwable -> L49
            boolean r6 = r1.exists()     // Catch: java.lang.Throwable -> L49
            if (r6 == 0) goto L51
            boolean r6 = r1.isFile()     // Catch: java.lang.Throwable -> L49
            if (r6 == 0) goto L51
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L33
            r6.<init>(r1)     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L33
            java.io.ObjectInputStream r1 = new java.io.ObjectInputStream     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L33
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L30 java.lang.Throwable -> L33
            java.lang.Object r6 = r1.readObject()     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L42
            java.util.HashMap r6 = (java.util.HashMap) r6     // Catch: java.lang.Throwable -> L2e java.lang.Throwable -> L42
            if (r1 == 0) goto L52
            r1.close()     // Catch: java.lang.Throwable -> L52
            goto L52
        L2e:
            r6 = move-exception
            goto L35
        L30:
            r6 = move-exception
            r1 = r0
            goto L43
        L33:
            r6 = move-exception
            r1 = r0
        L35:
            com.mob.tools.log.NLog r2 = com.mob.tools.MobLog.getInstance()     // Catch: java.lang.Throwable -> L42
            r2.m8622w(r6)     // Catch: java.lang.Throwable -> L42
            if (r1 == 0) goto L51
            r1.close()     // Catch: java.lang.Throwable -> L51
            goto L51
        L42:
            r6 = move-exception
        L43:
            if (r1 == 0) goto L48
            r1.close()     // Catch: java.lang.Throwable -> L48
        L48:
            throw r6     // Catch: java.lang.Throwable -> L49
        L49:
            r6 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.m8622w(r6)
        L51:
            r6 = r0
        L52:
            if (r6 != 0) goto L55
            return r0
        L55:
            java.lang.String r1 = "deviceInfo"
            java.lang.Object r6 = r6.get(r1)
            java.util.HashMap r6 = (java.util.HashMap) r6
            if (r6 != 0) goto L60
            return r0
        L60:
            java.lang.String r1 = "mac"
            java.lang.Object r1 = r6.get(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = (java.lang.String) r1     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = "imei"
            java.lang.Object r2 = r6.get(r2)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lb1
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> Lb1
            if (r3 == 0) goto L84
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb1
            r4 = 9
            if (r3 < r4) goto L84
            java.lang.String r2 = "serialno"
            java.lang.Object r2 = r6.get(r2)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lb1
        L84:
            java.lang.String r3 = "model"
            java.lang.Object r6 = r6.get(r3)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = (java.lang.String) r6     // Catch: java.lang.Throwable -> Lb1
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb1
            r3.<init>()     // Catch: java.lang.Throwable -> Lb1
            r3.append(r1)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = ":"
            r3.append(r1)     // Catch: java.lang.Throwable -> Lb1
            r3.append(r2)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r1 = ":"
            r3.append(r1)     // Catch: java.lang.Throwable -> Lb1
            r3.append(r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = r3.toString()     // Catch: java.lang.Throwable -> Lb1
            byte[] r6 = com.mob.tools.utils.Data.SHA1(r6)     // Catch: java.lang.Throwable -> Lb1
            java.lang.String r6 = com.mob.tools.utils.Data.byteToHex(r6)     // Catch: java.lang.Throwable -> Lb1
            goto Lba
        Lb1:
            r6 = move-exception
            com.mob.tools.log.NLog r1 = com.mob.tools.MobLog.getInstance()
            r1.m8610d(r6)
            r6 = r0
        Lba:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.DeviceHelper.getDeviceKeyWithDuid(java.lang.String):java.lang.String");
    }

    private String getLocalDeviceKey() throws ClassNotFoundException, IOException {
        String strValueOf = null;
        if (!getSdcardState()) {
            return null;
        }
        File file = new File(getSdcardPath(), "ShareSDK");
        if (file.exists()) {
            File file2 = new File(file, ".dk");
            if (file2.exists() && file2.renameTo(new File(ResHelper.getCacheRoot(this.context), ".dk"))) {
                file2.delete();
            }
        }
        File file3 = new File(ResHelper.getCacheRoot(this.context), ".dk");
        if (!file3.exists()) {
            return null;
        }
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file3));
        Object object = objectInputStream.readObject();
        if (object != null && (object instanceof char[])) {
            strValueOf = String.valueOf((char[]) object);
        }
        objectInputStream.close();
        return strValueOf;
    }

    private void saveLocalDeviceKey(String str) throws IOException {
        if (getSdcardState()) {
            File file = new File(ResHelper.getCacheRoot(this.context), ".dk");
            if (file.exists()) {
                file.delete();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(str.toCharArray());
            objectOutputStream.flush();
            objectOutputStream.close();
        }
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public String getAppName() {
        String str = this.context.getApplicationInfo().name;
        if (str != null) {
            if (Build.VERSION.SDK_INT < 25 || str.endsWith(".*")) {
                return str;
            }
            try {
                ReflectHelper.importClass(str);
            } catch (Throwable unused) {
            }
        }
        int i = this.context.getApplicationInfo().labelRes;
        if (i > 0) {
            return this.context.getString(i);
        }
        return String.valueOf(this.context.getApplicationInfo().nonLocalizedLabel);
    }

    public int getAppVersion() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionCode;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return 0;
        }
    }

    public String getAppVersionName() {
        try {
            return this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return "1.0";
        }
    }

    public ArrayList<HashMap<String, String>> getInstalledApp(boolean z) {
        PackageInfo packageInfo;
        CharSequence text;
        try {
            ArrayList arrayList = new ArrayList();
            try {
                Process processExec = Runtime.getRuntime().exec("pm list packages");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream(), "utf-8"));
                for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                    String strTrim = line.toLowerCase().trim();
                    if (strTrim.startsWith("package:")) {
                        arrayList.add(strTrim.substring("package:".length()).trim());
                    }
                }
                bufferedReader.close();
                processExec.destroy();
            } catch (Throwable th) {
                MobLog.getInstance().m8622w(th);
            }
            ArrayList<HashMap<String, String>> arrayList2 = new ArrayList<>();
            PackageManager packageManager = this.context.getPackageManager();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                try {
                    packageInfo = packageManager.getPackageInfo((String) it.next(), 0);
                } catch (Throwable th2) {
                    MobLog.getInstance().m8610d(th2);
                    packageInfo = null;
                }
                if (packageInfo != null && (z || !isSystemApp(packageInfo))) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("pkg", packageInfo.packageName);
                    String strValueOf = packageInfo.applicationInfo.name;
                    if (strValueOf == null) {
                        int i = packageInfo.applicationInfo.labelRes;
                        if (i > 0 && (text = packageManager.getText(packageInfo.packageName, i, packageInfo.applicationInfo)) != null) {
                            strValueOf = text.toString().trim();
                        }
                        if (strValueOf == null) {
                            strValueOf = String.valueOf(packageInfo.applicationInfo.nonLocalizedLabel);
                        }
                    }
                    map.put(Const.TableSchema.COLUMN_NAME, strValueOf);
                    map.put("version", packageInfo.versionName);
                    arrayList2.add(map);
                }
            }
            return arrayList2;
        } catch (Throwable th3) {
            MobLog.getInstance().m8622w(th3);
            return new ArrayList<>();
        }
    }

    private boolean isSystemApp(PackageInfo packageInfo) {
        return ((packageInfo.applicationInfo.flags & 1) == 1) || ((packageInfo.applicationInfo.flags & 128) == 1);
    }

    public String getNetworkOperator() {
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
            return (String) ReflectHelper.invokeInstanceMethod(systemService, "getNetworkOperator", new Object[0]);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public boolean checkPermission(String str) {
        int iIntValue = -1;
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                ReflectHelper.importClass("android.content.Context");
                StringBuilder sb = new StringBuilder();
                sb.append("ch");
                sb.append("ec");
                sb.append("kS");
                sb.append("el");
                sb.append("fP");
                sb.append("er");
                sb.append("mi");
                sb.append("ss");
                sb.append("io");
                sb.append("n");
                Integer num = (Integer) ReflectHelper.invokeInstanceMethod(this.context, sb.toString(), str);
                if (num != null) {
                    iIntValue = num.intValue();
                }
            } catch (Throwable th) {
                MobLog.getInstance().m8610d(th);
            }
        } else {
            this.context.checkPermission(str, Process.myPid(), Process.myUid());
            iIntValue = this.context.getPackageManager().checkPermission(str, getPackageName());
        }
        return iIntValue == 0;
    }

    public String getTopTaskPackageName() {
        boolean zCheckPermission;
        try {
            zCheckPermission = checkPermission(MsgConstant.PERMISSION_GET_TASKS);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            zCheckPermission = false;
        }
        if (zCheckPermission) {
            try {
                Object systemService = getSystemService("activity");
                if (systemService == null) {
                    return null;
                }
                if (Build.VERSION.SDK_INT <= 20) {
                    List list = (List) ReflectHelper.invokeInstanceMethod(systemService, "getRunningTasks", 1);
                    StringBuilder sb = new StringBuilder();
                    sb.append("to");
                    sb.append("pA");
                    sb.append("ct");
                    sb.append("iv");
                    sb.append("it");
                    sb.append("y");
                    return (String) ReflectHelper.invokeInstanceMethod(ReflectHelper.getInstanceField(list.get(0), sb.toString()), "getPackageName", new Object[0]);
                }
                return ((String) ReflectHelper.getInstanceField(((List) ReflectHelper.invokeInstanceMethod(systemService, "getRunningAppProcesses", new Object[0])).get(0), "processName")).split(":")[0];
            } catch (Throwable th2) {
                MobLog.getInstance().m8610d(th2);
            }
        }
        return null;
    }

    public boolean getSdcardState() {
        try {
            if (checkPermission(MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE)) {
                return "mounted".equals(Environment.getExternalStorageState());
            }
            return false;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return false;
        }
    }

    public String getSdcardPath() {
        return Environment.getExternalStorageDirectory().getAbsolutePath();
    }

    public String getAndroidID() {
        String string = Settings.Secure.getString(this.context.getContentResolver(), "android_id");
        MobLog.getInstance().m8615i("getAndroidID === " + string, new Object[0]);
        return string;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String getAdvertisingID() throws Throwable {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            throw new Throwable("Do not call this function from the main thread !");
        }
        Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
        intent.setPackage("com.google.android.gms");
        String str = null;
        GSConnection gSConnection = new GSConnection();
        try {
            try {
                this.context.bindService(intent, gSConnection, 1);
                IBinder iBinderTakeBinder = gSConnection.takeBinder();
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                parcelObtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                iBinderTakeBinder.transact(1, parcelObtain, parcelObtain2, 0);
                parcelObtain2.readException();
                String string = parcelObtain2.readString();
                try {
                    parcelObtain2.recycle();
                    parcelObtain.recycle();
                    return string;
                } catch (Throwable th) {
                    str = string;
                    th = th;
                    MobLog.getInstance().m8610d(th);
                    return str;
                }
            } finally {
                this.context.unbindService(gSConnection);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void hideSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService == null) {
            return;
        }
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void showSoftInput(View view) {
        Object systemService = getSystemService("input_method");
        if (systemService == null) {
            return;
        }
        ((InputMethodManager) systemService).toggleSoftInputFromWindow(view.getWindowToken(), 2, 0);
    }

    public boolean isMainProcess(int i) {
        try {
            List list = (List) ReflectHelper.invokeInstanceMethod(getSystemService("activity"), "getRunningAppProcesses", new Object[0]);
            if (list == null) {
                return i <= 0;
            }
            String str = null;
            if (i <= 0) {
                i = Process.myPid();
            }
            Iterator it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (((Integer) ReflectHelper.getInstanceField(next, "pid")).intValue() == i) {
                    str = (String) ReflectHelper.getInstanceField(next, "processName");
                    break;
                }
            }
            return getPackageName().equals(str);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return false;
        }
    }

    public String getIMSI() {
        String str;
        Object systemService = getSystemService("phone");
        if (systemService == null) {
            return null;
        }
        try {
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        if (checkPermission(MsgConstant.PERMISSION_READ_PHONE_STATE)) {
            str = (String) ReflectHelper.invokeInstanceMethod(systemService, "getSubscriberId", new Object[0]);
        } else {
            str = null;
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str;
    }

    public String getIPAddress() {
        try {
            if (!checkPermission(MsgConstant.PERMISSION_INTERNET)) {
                return "0.0.0.0";
            }
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddressNextElement = inetAddresses.nextElement();
                    if (!inetAddressNextElement.isLoopbackAddress() && (inetAddressNextElement instanceof Inet4Address)) {
                        return inetAddressNextElement.getHostAddress();
                    }
                }
            }
            return "0.0.0.0";
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "0.0.0.0";
        }
    }

    public float[] getLocation(int i, int i2) {
        Location location = getLocation(i, i2, true);
        if (location != null) {
            return new float[]{(float) location.getLatitude(), (float) location.getLongitude()};
        }
        return null;
    }

    public Location getLocation(int i, int i2, boolean z) {
        try {
            if (checkPermission("android.permission.ACCESS_FINE_LOCATION")) {
                return new LocationHelper().getLocation(this.context, i, i2, z);
            }
            return null;
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
            return null;
        }
    }

    public HashMap<String, String> ping(String str, int i, int i2) {
        float f;
        float f2;
        ArrayList arrayList = new ArrayList();
        try {
            int i3 = i2 + 8;
            Process processExec = Runtime.getRuntime().exec("ping -c " + i + " -s " + i2 + " " + str);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()));
            String line = bufferedReader.readLine();
            while (line != null) {
                if (line.startsWith(i3 + " bytes from")) {
                    if (line.endsWith("ms")) {
                        line = line.substring(0, line.length() - 2).trim();
                    } else if (line.endsWith("s")) {
                        line = line.substring(0, line.length() - 1).trim() + "000";
                    }
                    int iIndexOf = line.indexOf("time=");
                    if (iIndexOf > 0) {
                        try {
                            arrayList.add(Float.valueOf(Float.parseFloat(line.substring(iIndexOf + 5).trim())));
                        } catch (Throwable th) {
                            MobLog.getInstance().m8622w(th);
                        }
                    }
                }
                line = bufferedReader.readLine();
            }
            processExec.waitFor();
        } catch (Throwable th2) {
            MobLog.getInstance().m8610d(th2);
        }
        int size = arrayList.size();
        int size2 = i - arrayList.size();
        float f3 = 0.0f;
        if (size > 0) {
            f3 = Float.MAX_VALUE;
            float f4 = 0.0f;
            f2 = 0.0f;
            for (int i4 = 0; i4 < size; i4++) {
                float fFloatValue = ((Float) arrayList.get(i4)).floatValue();
                if (fFloatValue < f3) {
                    f3 = fFloatValue;
                }
                if (fFloatValue > f2) {
                    f2 = fFloatValue;
                }
                f4 += fFloatValue;
            }
            f = f4 / size;
        } else {
            f = 0.0f;
            f2 = 0.0f;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("address", str);
        map.put("transmitted", String.valueOf(i));
        map.put("received", String.valueOf(size));
        map.put("loss", String.valueOf(size2));
        map.put("min", String.valueOf(f3));
        map.put("max", String.valueOf(f2));
        map.put("avg", String.valueOf(f));
        return map;
    }

    public int getCellId() {
        Object systemService;
        try {
            if (checkPermission("android.permission.ACCESS_COARSE_LOCATION") && (systemService = getSystemService("phone")) != null) {
                Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getCellLocation", new Object[0]);
                if (objInvokeInstanceMethod != null) {
                    return ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod, "getCid", new Object[0]), -1)).intValue();
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
        return -1;
    }

    public int getCellLac() {
        Object systemService;
        try {
            if (checkPermission("android.permission.ACCESS_COARSE_LOCATION") && (systemService = getSystemService("phone")) != null) {
                Object objInvokeInstanceMethod = ReflectHelper.invokeInstanceMethod(systemService, "getCellLocation", new Object[0]);
                if (objInvokeInstanceMethod != null) {
                    return ((Integer) ResHelper.forceCast(ReflectHelper.invokeInstanceMethod(objInvokeInstanceMethod, "getLac", new Object[0]), -1)).intValue();
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
        return -1;
    }

    public String getDeviceType() {
        UiModeManager uiModeManager = (UiModeManager) getSystemService("uimode");
        if (uiModeManager == null) {
            return "UNDEFINED";
        }
        switch (uiModeManager.getCurrentModeType()) {
            case 1:
                return "NO_UI";
            case 2:
                return "DESK";
            case 3:
                return "CAR";
            case 4:
                return "TELEVISION";
            case 5:
                return "APPLIANCE";
            case 6:
                return "WATCH";
            default:
                return "UNDEFINED";
        }
    }

    class GSConnection implements ServiceConnection {
        boolean got;
        private final BlockingQueue<IBinder> iBinders;

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }

        private GSConnection() {
            this.got = false;
            this.iBinders = new LinkedBlockingQueue();
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                this.iBinders.put(iBinder);
            } catch (Throwable th) {
                MobLog.getInstance().m8622w(th);
            }
        }

        public IBinder takeBinder() {
            if (this.got) {
                throw new IllegalStateException();
            }
            this.got = true;
            return this.iBinders.poll(1500L, TimeUnit.MILLISECONDS);
        }
    }
}
