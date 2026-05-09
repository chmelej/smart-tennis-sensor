package p000;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import android.widget.Toast;
import com.umeng.message.ElectionReceiver;
import com.umeng.message.MsgConstant;
import com.umeng.message.PushAgent;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes.dex */
public class ail {

    /* JADX INFO: renamed from: a */
    public static final String f1153a = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a */
    public static String m1340a(String str) {
        if (str == null) {
            return null;
        }
        try {
            byte[] bytes = str.getBytes();
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bytes);
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(String.format("%02X", Byte.valueOf(b)));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return str.replaceAll("[^[a-z][A-Z][0-9][.][_]]", "");
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1349b(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m1345a(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 != i) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m1347b(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1342a(Context context) {
        String packageName = ((ActivityManager) context.getSystemService("activity")).getRunningTasks(1).get(0).topActivity.getPackageName();
        return packageName != null && packageName.equals(context.getPackageName());
    }

    /* JADX INFO: renamed from: b */
    public static boolean m1348b(Context context) {
        return context.getPackageManager().checkPermission(MsgConstant.PERMISSION_GET_TASKS, context.getPackageName()) == 0;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1344a(Context context, String str) {
        List<ActivityManager.RunningServiceInfo> runningServices = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        if (runningServices == null || runningServices.isEmpty()) {
            return false;
        }
        for (int i = 0; i < runningServices.size(); i++) {
            if (runningServices.get(i).service.getClassName().equals(str) && TextUtils.equals(runningServices.get(i).service.getPackageName(), context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static String m1338a(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return "";
    }

    /* JADX INFO: renamed from: a */
    public static void m1341a(Context context, Class<?> cls) {
        ComponentName componentName;
        int componentEnabledSetting;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && packageManager.getApplicationEnabledSetting(context.getPackageName()) > -1 && (componentEnabledSetting = packageManager.getComponentEnabledSetting((componentName = new ComponentName(context, cls)))) != 1 && componentEnabledSetting != 0) {
                packageManager.setComponentEnabledSetting(componentName, 1, 1);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1346b(Context context, Class<?> cls) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (cls == null) {
                    return;
                }
                ComponentName componentName = new ComponentName(context, cls);
                if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                    ahb.m1043c("helper", "rebootReceiver[" + componentName.toString() + "]--->[ENABLED]");
                    packageManager.setComponentEnabledSetting(componentName, 1, 1);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static Object m1350c(String str) {
        try {
            try {
                return new ObjectInputStream(new ByteArrayInputStream(aij.m1323c(str.getBytes()))).readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                return null;
            }
        } catch (StreamCorruptedException e2) {
            e2.printStackTrace();
            return null;
        } catch (IOException e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m1339a(Object obj) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            new ObjectOutputStream(byteArrayOutputStream).writeObject(obj);
            return new String(aij.m1318a(byteArrayOutputStream.toByteArray()));
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m1337a() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m1343a(final Context context, Handler handler) {
        boolean z;
        String str;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        boolean z9;
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z20;
        boolean z21;
        boolean z22;
        boolean z23;
        boolean z24;
        boolean z25;
        boolean z26;
        boolean z27;
        boolean z28;
        boolean z29;
        boolean z30;
        boolean z31;
        boolean z32;
        if (!PushAgent.getInstance(context).isPushCheck()) {
            return true;
        }
        try {
            if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageAppkey())) {
                handler.post(new Runnable() { // from class: ail.1
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please set umeng appkey!", 1).show();
                    }
                });
                return false;
            }
            if (TextUtils.isEmpty(PushAgent.getInstance(context).getMessageSecret())) {
                handler.post(new Runnable() { // from class: ail.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please set umeng appsecret!", 1).show();
                    }
                });
                return false;
            }
            String str2 = "";
            Intent intent = new Intent();
            intent.setClassName(context.getPackageName(), "com.umeng.message.NotificationProxyBroadcastReceiver");
            Iterator<ResolveInfo> it = context.getPackageManager().queryBroadcastReceivers(intent, 65536).iterator();
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                ResolveInfo next = it.next();
                if (next.activityInfo.name.equals("com.umeng.message.NotificationProxyBroadcastReceiver") && TextUtils.equals(next.activityInfo.processName, context.getPackageName()) && !next.activityInfo.exported) {
                    z = true;
                    break;
                }
            }
            if (!z) {
                handler.post(new Runnable() { // from class: ail.10
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct NotificationProxyBroadcastReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent2 = new Intent();
            intent2.setPackage(context.getPackageName());
            intent2.setAction("android.intent.action.BOOT_COMPLETED");
            Iterator<ResolveInfo> it2 = context.getPackageManager().queryBroadcastReceivers(intent2, 64).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    str = str2;
                    z2 = false;
                    break;
                }
                ResolveInfo next2 = it2.next();
                if (next2.activityInfo.name.equals("com.umeng.message.SystemReceiver")) {
                    str2 = next2.activityInfo.processName;
                    if (!TextUtils.isEmpty(str2) && !TextUtils.equals(str2, context.getPackageName())) {
                        str = str2;
                        z2 = true;
                        break;
                    }
                }
            }
            if (!z2) {
                handler.post(new Runnable() { // from class: ail.11
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct SystemReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent3 = new Intent();
            intent3.setPackage(context.getPackageName());
            intent3.setAction("android.net.conn.CONNECTIVITY_CHANGE");
            Iterator<ResolveInfo> it3 = context.getPackageManager().queryBroadcastReceivers(intent3, 64).iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z3 = false;
                    break;
                }
                ResolveInfo next3 = it3.next();
                if (next3.activityInfo.name.equals("com.umeng.message.SystemReceiver") && TextUtils.equals(str, next3.activityInfo.processName)) {
                    z3 = true;
                    break;
                }
            }
            if (!z3) {
                handler.post(new Runnable() { // from class: ail.13
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct SystemReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent4 = new Intent();
            intent4.setPackage(context.getPackageName());
            intent4.setAction("android.intent.action.PACKAGE_REMOVED");
            intent4.setData(Uri.parse("package:"));
            Iterator<ResolveInfo> it4 = context.getPackageManager().queryBroadcastReceivers(intent4, 64).iterator();
            while (true) {
                if (!it4.hasNext()) {
                    z4 = false;
                    break;
                }
                if (it4.next().activityInfo.name.equals("com.umeng.message.SystemReceiver")) {
                    z4 = true;
                    break;
                }
            }
            if (!z4) {
                handler.post(new Runnable() { // from class: ail.14
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct SystemReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent5 = new Intent();
            intent5.setPackage(context.getPackageName());
            intent5.setAction("org.agoo.android.intent.action.RECEIVE");
            Iterator<ResolveInfo> it5 = context.getPackageManager().queryBroadcastReceivers(intent5, 64).iterator();
            while (true) {
                if (!it5.hasNext()) {
                    z5 = false;
                    break;
                }
                ResolveInfo next4 = it5.next();
                if (next4.activityInfo.name.equals("com.umeng.message.MessageReceiver") && TextUtils.equals(str, next4.activityInfo.processName)) {
                    z5 = true;
                    break;
                }
            }
            if (!z5) {
                handler.post(new Runnable() { // from class: ail.15
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct MessageReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            m1346b(context, ElectionReceiver.class);
            Intent intent6 = new Intent();
            intent6.setPackage(context.getPackageName());
            intent6.setAction("org.agoo.android.intent.action.ELECTION_RESULT_V4");
            intent6.addCategory("umeng");
            Iterator<ResolveInfo> it6 = context.getPackageManager().queryBroadcastReceivers(intent6, 64).iterator();
            while (true) {
                if (!it6.hasNext()) {
                    z6 = false;
                    break;
                }
                ResolveInfo next5 = it6.next();
                if (next5.activityInfo.name.equals("com.umeng.message.ElectionReceiver") && TextUtils.equals(str, next5.activityInfo.processName)) {
                    z6 = true;
                    break;
                }
            }
            if (!z6) {
                handler.post(new Runnable() { // from class: ail.16
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct ElectionReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent7 = new Intent();
            intent7.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it7 = context.getPackageManager().queryBroadcastReceivers(intent7, 64).iterator();
            while (true) {
                if (!it7.hasNext()) {
                    z7 = false;
                    break;
                }
                ResolveInfo next6 = it7.next();
                if (next6.activityInfo.name.equals("com.umeng.message.RegistrationReceiver") && !next6.activityInfo.exported) {
                    z7 = true;
                    break;
                }
            }
            if (!z7) {
                handler.post(new Runnable() { // from class: ail.17
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct RegistrationReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent8 = new Intent();
            intent8.setPackage(context.getPackageName());
            intent8.setAction(context.getPackageName() + ".intent.action.COMMAND");
            Iterator<ResolveInfo> it8 = context.getPackageManager().queryBroadcastReceivers(intent8, 64).iterator();
            while (true) {
                if (!it8.hasNext()) {
                    z8 = false;
                    break;
                }
                ResolveInfo next7 = it8.next();
                if (next7.activityInfo.name.equals("com.umeng.message.RegistrationReceiver") && !next7.activityInfo.exported) {
                    z8 = true;
                    break;
                }
            }
            if (!z8) {
                handler.post(new Runnable() { // from class: ail.12
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please replace '【应用包名】.intent.action.COMMAND' with application's packageName for RegistrationReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent9 = new Intent();
            intent9.setPackage(context.getPackageName());
            intent9.setAction("android.intent.action.BOOT_COMPLETED");
            Iterator<ResolveInfo> it9 = context.getPackageManager().queryBroadcastReceivers(intent9, 64).iterator();
            while (true) {
                if (!it9.hasNext()) {
                    z9 = false;
                    break;
                }
                if (it9.next().activityInfo.name.equals("com.umeng.message.UmengMessageBootReceiver")) {
                    z9 = true;
                    break;
                }
            }
            if (!z9) {
                handler.post(new Runnable() { // from class: ail.18
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct BootBroadcastReceiver in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent10 = new Intent();
            intent10.setPackage(context.getPackageName());
            Iterator<ResolveInfo> it10 = context.getPackageManager().queryIntentServices(intent10, 64).iterator();
            while (true) {
                if (!it10.hasNext()) {
                    z10 = false;
                    break;
                }
                ResolveInfo next8 = it10.next();
                if (next8.serviceInfo.name.equals("com.umeng.message.UmengService") && TextUtils.equals(str, next8.serviceInfo.processName) && next8.serviceInfo.exported) {
                    z10 = true;
                    break;
                }
            }
            if (!z10) {
                handler.post(new Runnable() { // from class: ail.19
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent11 = new Intent();
            intent11.setPackage(context.getPackageName());
            intent11.setAction(context.getPackageName() + ".intent.action.START");
            Iterator<ResolveInfo> it11 = context.getPackageManager().queryIntentServices(intent11, 64).iterator();
            while (true) {
                if (!it11.hasNext()) {
                    z11 = false;
                    break;
                }
                ResolveInfo next9 = it11.next();
                if (next9.serviceInfo.name.equals("com.umeng.message.UmengService") && TextUtils.equals(str, next9.serviceInfo.processName) && next9.serviceInfo.exported) {
                    z11 = true;
                    break;
                }
            }
            if (!z11) {
                handler.post(new Runnable() { // from class: ail.20
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please replace '【应用包名】.intent.action.START' with application's packageName for UmengService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent12 = new Intent();
            intent12.setPackage(context.getPackageName());
            intent12.setAction(context.getPackageName() + ".intent.action.COCKROACH");
            Iterator<ResolveInfo> it12 = context.getPackageManager().queryIntentServices(intent12, 64).iterator();
            while (true) {
                if (!it12.hasNext()) {
                    z12 = false;
                    break;
                }
                ResolveInfo next10 = it12.next();
                if (next10.serviceInfo.name.equals("com.umeng.message.UmengService") && TextUtils.equals(str, next10.serviceInfo.processName) && next10.serviceInfo.exported) {
                    z12 = true;
                    break;
                }
            }
            if (!z12) {
                handler.post(new Runnable() { // from class: ail.21
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please replace '【应用包名】.intent.action.COCKROACH' with application's packageName for UmengService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent13 = new Intent();
            intent13.addCategory("umeng");
            intent13.setPackage(context.getPackageName());
            intent13.setAction("org.agoo.android.intent.action.PING_V4");
            Iterator<ResolveInfo> it13 = context.getPackageManager().queryIntentServices(intent13, 64).iterator();
            while (true) {
                if (!it13.hasNext()) {
                    z13 = false;
                    break;
                }
                if (it13.next().serviceInfo.name.equals("com.umeng.message.UmengService")) {
                    z13 = true;
                    break;
                }
            }
            if (!z13) {
                handler.post(new Runnable() { // from class: ail.22
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent14 = new Intent();
            intent14.setClassName(context.getPackageName(), "com.umeng.message.UmengIntentService");
            Iterator<ResolveInfo> it14 = context.getPackageManager().queryIntentServices(intent14, 65536).iterator();
            while (true) {
                if (!it14.hasNext()) {
                    z14 = false;
                    break;
                }
                ResolveInfo next11 = it14.next();
                if (next11.serviceInfo.name.equals("com.umeng.message.UmengIntentService") && TextUtils.equals(str, next11.serviceInfo.processName)) {
                    z14 = true;
                    break;
                }
            }
            if (!z14) {
                handler.post(new Runnable() { // from class: ail.23
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengIntentService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent15 = new Intent();
            intent15.setPackage(context.getPackageName());
            intent15.setAction("org.android.agoo.client.MessageReceiverService");
            Iterator<ResolveInfo> it15 = context.getPackageManager().queryIntentServices(intent15, 64).iterator();
            while (true) {
                if (!it15.hasNext()) {
                    z15 = false;
                    break;
                }
                ResolveInfo next12 = it15.next();
                if (next12.serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService") && TextUtils.equals(str, next12.serviceInfo.processName) && next12.serviceInfo.exported) {
                    z15 = true;
                    break;
                }
            }
            if (!z15) {
                handler.post(new Runnable() { // from class: ail.24
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengMessageIntentReceiverService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent16 = new Intent();
            intent16.setPackage(context.getPackageName());
            intent16.setAction("org.android.agoo.client.ElectionReceiverService");
            Iterator<ResolveInfo> it16 = context.getPackageManager().queryIntentServices(intent16, 64).iterator();
            while (true) {
                if (!it16.hasNext()) {
                    z16 = false;
                    break;
                }
                if (it16.next().serviceInfo.name.equals("com.umeng.message.UmengMessageIntentReceiverService")) {
                    z16 = true;
                    break;
                }
            }
            if (!z16) {
                handler.post(new Runnable() { // from class: ail.2
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengMessageIntentReceiverService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent17 = new Intent();
            intent17.setPackage(context.getPackageName());
            intent17.setAction(MsgConstant.MESSAGE_REGISTER_CALLBACK_ACTION);
            Iterator<ResolveInfo> it17 = context.getPackageManager().queryIntentServices(intent17, 64).iterator();
            while (true) {
                if (!it17.hasNext()) {
                    z17 = false;
                    break;
                }
                ResolveInfo next13 = it17.next();
                if (next13.serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService") && TextUtils.equals(context.getPackageName(), next13.serviceInfo.processName) && !next13.serviceInfo.exported) {
                    z17 = true;
                    break;
                }
            }
            if (!z17) {
                handler.post(new Runnable() { // from class: ail.3
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent18 = new Intent();
            intent18.setPackage(context.getPackageName());
            intent18.setAction(MsgConstant.MESSAGE_UNREGISTER_CALLBACK_ACTION);
            Iterator<ResolveInfo> it18 = context.getPackageManager().queryIntentServices(intent18, 64).iterator();
            while (true) {
                if (!it18.hasNext()) {
                    z18 = false;
                    break;
                }
                if (it18.next().serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                    z18 = true;
                    break;
                }
            }
            if (!z18) {
                handler.post(new Runnable() { // from class: ail.5
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent19 = new Intent();
            intent19.setPackage(context.getPackageName());
            intent19.setAction(MsgConstant.MESSAGE_MESSAGE_HANDLER_ACTION);
            Iterator<ResolveInfo> it19 = context.getPackageManager().queryIntentServices(intent19, 64).iterator();
            while (true) {
                if (!it19.hasNext()) {
                    z19 = false;
                    break;
                }
                if (it19.next().serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                    z19 = true;
                    break;
                }
            }
            if (!z19) {
                handler.post(new Runnable() { // from class: ail.6
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent20 = new Intent();
            intent20.setPackage(context.getPackageName());
            intent20.setAction(MsgConstant.MESSAGE_AUTOUPDATE_HANDLER_ACTION);
            Iterator<ResolveInfo> it20 = context.getPackageManager().queryIntentServices(intent20, 64).iterator();
            while (true) {
                if (!it20.hasNext()) {
                    z20 = false;
                    break;
                }
                if (it20.next().serviceInfo.name.equals("com.umeng.message.UmengMessageCallbackHandlerService")) {
                    z20 = true;
                    break;
                }
            }
            if (!z20) {
                handler.post(new Runnable() { // from class: ail.7
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengMessageCallbackHandlerService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            Intent intent21 = new Intent();
            intent21.setClassName(context.getPackageName(), "com.umeng.message.UmengDownloadResourceService");
            Iterator<ResolveInfo> it21 = context.getPackageManager().queryIntentServices(intent21, 65536).iterator();
            while (true) {
                if (!it21.hasNext()) {
                    z21 = false;
                    break;
                }
                if (it21.next().serviceInfo.name.equals("com.umeng.message.UmengDownloadResourceService")) {
                    z21 = true;
                    break;
                }
            }
            if (!z21) {
                handler.post(new Runnable() { // from class: ail.8
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(context, "Please add or correct UmengDownloadResourceService in AndroidManifest!", 1).show();
                    }
                });
                return false;
            }
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
            if (packageInfo.requestedPermissions != null) {
                z22 = false;
                z23 = false;
                z24 = false;
                z25 = false;
                z26 = false;
                z27 = false;
                z28 = false;
                z29 = false;
                z30 = false;
                z31 = false;
                z32 = false;
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if (MsgConstant.PERMISSION_WRITE_SETTINGS.equals(packageInfo.requestedPermissions[i])) {
                        z22 = true;
                    } else if (MsgConstant.PERMISSION_INTERNET.equals(packageInfo.requestedPermissions[i])) {
                        z23 = true;
                    } else if (MsgConstant.PERMISSION_ACCESS_WIFI_STATE.equals(packageInfo.requestedPermissions[i])) {
                        z24 = true;
                    } else if (MsgConstant.PERMISSION_ACCESS_NETWORK_STATE.equals(packageInfo.requestedPermissions[i])) {
                        z25 = true;
                    } else if (MsgConstant.PERMISSION_WRITE_EXTERNAL_STORAGE.equals(packageInfo.requestedPermissions[i])) {
                        z26 = true;
                    } else if (MsgConstant.PERMISSION_WAKE_LOCK.equals(packageInfo.requestedPermissions[i])) {
                        z27 = true;
                    } else if (MsgConstant.PERMISSION_READ_PHONE_STATE.equals(packageInfo.requestedPermissions[i])) {
                        z28 = true;
                    } else if (MsgConstant.PERMISSION_CHANGE_NETWORK_STATE.equals(packageInfo.requestedPermissions[i])) {
                        z29 = true;
                    } else if (MsgConstant.PERMISSION_CHANGE_WIFI_STATE.equals(packageInfo.requestedPermissions[i])) {
                        z30 = true;
                    } else if (MsgConstant.PERMISSION_GET_TASKS.equals(packageInfo.requestedPermissions[i])) {
                        z31 = true;
                    } else if (MsgConstant.PERMISSION_RECEIVE_BOOT_COMPLETED.equals(packageInfo.requestedPermissions[i])) {
                        z32 = true;
                    }
                }
            } else {
                z22 = false;
                z23 = false;
                z24 = false;
                z25 = false;
                z26 = false;
                z27 = false;
                z28 = false;
                z29 = false;
                z30 = false;
                z31 = false;
                z32 = false;
            }
            if (z22 && z23 && z24 && z25 && z26 && z27 && z28 && z29 && z30 && z31 && z32) {
                return true;
            }
            handler.post(new Runnable() { // from class: ail.9
                @Override // java.lang.Runnable
                public void run() {
                    Toast.makeText(context, "Please add required Permission in AndroidManifest!", 1).show();
                }
            });
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
