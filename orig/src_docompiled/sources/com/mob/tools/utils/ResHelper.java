package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Point;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.mob.tools.MobLog;
import com.mob.tools.network.KVPair;
import com.umeng.message.MessageStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLDecoder;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: loaded from: classes.dex */
public class ResHelper {
    private static float density;
    private static int deviceWidth;
    private static Uri mediaUri;

    /* JADX INFO: renamed from: rp */
    private static Object f9023rp;

    public static int dipToPx(Context context, int i) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i * density) + 0.5f);
    }

    public static int pxToDip(Context context, int i) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) ((i / density) + 0.5f);
    }

    public static int designToDevice(Context context, int i, int i2) {
        if (deviceWidth == 0) {
            int[] screenSize = getScreenSize(context);
            deviceWidth = screenSize[0] < screenSize[1] ? screenSize[0] : screenSize[1];
        }
        return (int) (((i2 * deviceWidth) / i) + 0.5f);
    }

    public static int designToDevice(Context context, float f, int i) {
        if (density <= 0.0f) {
            density = context.getResources().getDisplayMetrics().density;
        }
        return (int) (((i * density) / f) + 0.5f);
    }

    public static int[] getScreenSize(Context context) {
        WindowManager windowManager;
        try {
            windowManager = (WindowManager) context.getSystemService("window");
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            windowManager = null;
        }
        if (windowManager == null) {
            return new int[]{0, 0};
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 13) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
        }
        try {
            Point point = new Point();
            Method method = defaultDisplay.getClass().getMethod("getRealSize", Point.class);
            method.setAccessible(true);
            method.invoke(defaultDisplay, point);
            return new int[]{point.x, point.y};
        } catch (Throwable th2) {
            MobLog.getInstance().m8622w(th2);
            return new int[]{0, 0};
        }
    }

    public static int getScreenWidth(Context context) {
        return getScreenSize(context)[0];
    }

    public static int getScreenHeight(Context context) {
        return getScreenSize(context)[1];
    }

    public static void setResourceProvider(Object obj) {
        try {
            if (obj.getClass().getMethod("getResId", Context.class, String.class, String.class) != null) {
                f9023rp = obj;
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
    }

    public static int getResId(Context context, String str, String str2) {
        int iIntValue = 0;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return 0;
        }
        if (f9023rp != null) {
            try {
                Method method = f9023rp.getClass().getMethod("getResId", Context.class, String.class, String.class);
                method.setAccessible(true);
                iIntValue = ((Integer) method.invoke(f9023rp, context, str, str2)).intValue();
            } catch (Throwable th) {
                MobLog.getInstance().m8610d(th);
            }
        }
        if (iIntValue <= 0) {
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(packageName)) {
                return iIntValue;
            }
            if (iIntValue <= 0 && (iIntValue = context.getResources().getIdentifier(str2, str, packageName)) <= 0) {
                iIntValue = context.getResources().getIdentifier(str2.toLowerCase(), str, packageName);
            }
            if (iIntValue <= 0) {
                Log.w("MobTools", "failed to parse " + str + " resource \"" + str2 + "\"");
            }
        }
        return iIntValue;
    }

    public static int getBitmapRes(Context context, String str) {
        return getResId(context, "drawable", str);
    }

    public static int getStringRes(Context context, String str) {
        return getResId(context, "string", str);
    }

    public static int getStringArrayRes(Context context, String str) {
        return getResId(context, "array", str);
    }

    public static int getLayoutRes(Context context, String str) {
        return getResId(context, "layout", str);
    }

    public static int getStyleRes(Context context, String str) {
        return getResId(context, "style", str);
    }

    public static int getIdRes(Context context, String str) {
        return getResId(context, "id", str);
    }

    public static int getColorRes(Context context, String str) {
        return getResId(context, "color", str);
    }

    public static int getRawRes(Context context, String str) {
        return getResId(context, "raw", str);
    }

    public static int getPluralsRes(Context context, String str) {
        return getResId(context, "plurals", str);
    }

    public static int getAnimRes(Context context, String str) {
        return getResId(context, "anim", str);
    }

    public static String getCacheRoot(Context context) {
        String str = context.getFilesDir().getAbsolutePath() + "/Mob/";
        DeviceHelper deviceHelper = DeviceHelper.getInstance(context);
        if (deviceHelper.getSdcardState()) {
            str = deviceHelper.getSdcardPath() + "/Mob/";
        }
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str;
    }

    public static String getCachePath(Context context, String str) {
        String str2 = context.getFilesDir().getAbsolutePath() + "/Mob/cache/";
        DeviceHelper deviceHelper = DeviceHelper.getInstance(context);
        try {
            if (deviceHelper.getSdcardState()) {
                str2 = deviceHelper.getSdcardPath() + "/Mob/" + deviceHelper.getPackageName() + "/cache/";
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8610d(th);
        }
        if (!TextUtils.isEmpty(str)) {
            str2 = str2 + str + "/";
        }
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        return str2;
    }

    public static String getImageCachePath(Context context) {
        return getCachePath(context, "images");
    }

    public static void clearCache(Context context) {
        deleteFileAndFolder(new File(getCachePath(context, null)));
    }

    public static void deleteFilesInFolder(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                deleteFilesInFolder(file2);
            } else {
                file2.delete();
            }
        }
    }

    public static void deleteFileAndFolder(File file) {
        if (file == null || !file.exists()) {
            return;
        }
        if (file.isFile()) {
            file.delete();
            return;
        }
        String[] list = file.list();
        if (list == null || list.length <= 0) {
            file.delete();
            return;
        }
        for (String str : list) {
            File file2 = new File(file, str);
            if (file2.isDirectory()) {
                deleteFileAndFolder(file2);
            } else {
                file2.delete();
            }
        }
        file.delete();
    }

    public static String toWordText(String str, int i) {
        char[] charArray = str.toCharArray();
        int i2 = i * 2;
        StringBuilder sb = new StringBuilder();
        int length = charArray.length;
        for (int i3 = 0; i3 < length; i3++) {
            char c = charArray[i3];
            i2 -= c < 256 ? 1 : 2;
            if (i2 < 0) {
                return sb.toString();
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static int getTextLengthInWord(String str) {
        int i = 0;
        for (char c : str == null ? new char[0] : str.toCharArray()) {
            i += c < 256 ? 1 : 2;
        }
        return i;
    }

    public static long strToDate(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str, new ParsePosition(0)).getTime();
    }

    public static long dateStrToLong(String str) {
        return new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0)).getTime();
    }

    public static Date longToDate(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.getTime();
    }

    public static String longToTime(long j, int i) {
        String str = "yyyy-MM-dd kk:mm:ss";
        if (i == 5) {
            str = "yyyy-MM-dd";
        } else if (i == 10) {
            str = "yyyy-MM-dd kk";
        } else if (i != 12) {
            switch (i) {
                case 1:
                    str = "yyyy";
                    break;
                case 2:
                    str = "yyyy-MM";
                    break;
            }
        } else {
            str = "yyyy-MM-dd kk:mm";
        }
        return new SimpleDateFormat(str).format(Long.valueOf(j));
    }

    public static long dateToLong(String str) {
        try {
            Date date = new Date(str);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            return calendar.getTimeInMillis();
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return 0L;
        }
    }

    public static int[] covertTimeInYears(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis() - j;
        if (jCurrentTimeMillis <= 0) {
            return new int[]{0, 0};
        }
        long j2 = jCurrentTimeMillis / 1000;
        if (j2 < 60) {
            return new int[]{(int) j2, 0};
        }
        long j3 = j2 / 60;
        if (j3 < 60) {
            return new int[]{(int) j3, 1};
        }
        long j4 = j3 / 60;
        if (j4 < 24) {
            return new int[]{(int) j4, 2};
        }
        long j5 = j4 / 24;
        if (j5 < 30) {
            return new int[]{(int) j5, 3};
        }
        long j6 = j5 / 30;
        if (j6 < 12) {
            return new int[]{(int) j6, 4};
        }
        return new int[]{(int) (j6 / 12), 5};
    }

    public static Uri pathToContentUri(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, new String[]{MessageStore.f9157Id}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(MessageStore.f9157Id));
            return Uri.withAppendedPath(Uri.parse("content://media/external/images/media"), "" + i);
        }
        if (!new File(str).exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", str);
        return context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String contentUriToPath(android.content.Context r14, android.net.Uri r15) {
        /*
            r0 = 0
            if (r15 != 0) goto L4
            return r0
        L4:
            java.io.File r1 = new java.io.File
            java.lang.String r2 = r15.getPath()
            r1.<init>(r2)
            boolean r1 = r1.exists()
            if (r1 == 0) goto L18
            java.lang.String r14 = r15.getPath()
            return r14
        L18:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: java.lang.Throwable -> Lb0
            r2 = 19
            if (r1 < r2) goto L87
            java.lang.String r1 = "android.provider.DocumentsContract"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = "isDocumentUri"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> Lb0
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> Lb0
            java.lang.Class<android.net.Uri> r5 = android.net.Uri.class
            r7 = 1
            r4[r7] = r5     // Catch: java.lang.Throwable -> Lb0
            java.lang.reflect.Method r2 = r1.getMethod(r2, r4)     // Catch: java.lang.Throwable -> Lb0
            r2.setAccessible(r7)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Boolean r4 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> Lb0
            r3[r6] = r14     // Catch: java.lang.Throwable -> Lb0
            r3[r7] = r15     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r2 = r2.invoke(r0, r3)     // Catch: java.lang.Throwable -> Lb0
            boolean r2 = r4.equals(r2)     // Catch: java.lang.Throwable -> Lb0
            if (r2 == 0) goto L87
            java.lang.String r2 = "getDocumentId"
            java.lang.Class[] r3 = new java.lang.Class[r7]     // Catch: java.lang.Throwable -> Lb0
            java.lang.Class<android.net.Uri> r4 = android.net.Uri.class
            r3[r6] = r4     // Catch: java.lang.Throwable -> Lb0
            java.lang.reflect.Method r1 = r1.getMethod(r2, r3)     // Catch: java.lang.Throwable -> Lb0
            r1.setAccessible(r7)     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object[] r2 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> Lb0
            r2[r6] = r15     // Catch: java.lang.Throwable -> Lb0
            java.lang.Object r1 = r1.invoke(r0, r2)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r1 = java.lang.String.valueOf(r1)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = ":"
            java.lang.String[] r1 = r1.split(r2)     // Catch: java.lang.Throwable -> Lb0
            r1 = r1[r7]     // Catch: java.lang.Throwable -> Lb0
            java.lang.String[] r10 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r2 = "_data"
            r10[r6] = r2     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r11 = "_id=?"
            java.lang.String[] r12 = new java.lang.String[r7]     // Catch: java.lang.Throwable -> Lb0
            r12[r6] = r1     // Catch: java.lang.Throwable -> Lb0
            android.content.ContentResolver r8 = r14.getContentResolver()     // Catch: java.lang.Throwable -> Lb0
            android.net.Uri r9 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI     // Catch: java.lang.Throwable -> Lb0
            r13 = 0
            android.database.Cursor r1 = r8.query(r9, r10, r11, r12, r13)     // Catch: java.lang.Throwable -> Lb0
            goto L88
        L87:
            r1 = r0
        L88:
            if (r1 != 0) goto L97
            android.content.ContentResolver r2 = r14.getContentResolver()     // Catch: java.lang.Throwable -> Lb0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r3 = r15
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> Lb0
        L97:
            if (r1 == 0) goto Lb8
            boolean r14 = r1.moveToFirst()     // Catch: java.lang.Throwable -> Lb0
            if (r14 == 0) goto Laa
            java.lang.String r14 = "_data"
            int r14 = r1.getColumnIndex(r14)     // Catch: java.lang.Throwable -> Lb0
            java.lang.String r14 = r1.getString(r14)     // Catch: java.lang.Throwable -> Lb0
            goto Lab
        Laa:
            r14 = r0
        Lab:
            r1.close()     // Catch: java.lang.Throwable -> Lb0
            r0 = r14
            goto Lb8
        Lb0:
            r14 = move-exception
            com.mob.tools.log.NLog r15 = com.mob.tools.MobLog.getInstance()
            r15.m8622w(r14)
        Lb8:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.tools.utils.ResHelper.contentUriToPath(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static Uri videoPathToContentUri(Context context, String str) {
        Cursor cursorQuery = context.getContentResolver().query(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, new String[]{MessageStore.f9157Id}, "_data=? ", new String[]{str}, null);
        if (cursorQuery != null && cursorQuery.moveToFirst()) {
            int i = cursorQuery.getInt(cursorQuery.getColumnIndex(MessageStore.f9157Id));
            return Uri.withAppendedPath(Uri.parse("content://media/external/video/media"), "" + i);
        }
        if (!new File(str).exists()) {
            return null;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("_data", str);
        return context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
    }

    public static synchronized Uri getMediaUri(Context context, String str, String str2) {
        Uri uri;
        final Object obj = new Object();
        mediaUri = null;
        MediaScannerConnection.scanFile(context, new String[]{str}, new String[]{str2}, new MediaScannerConnection.OnScanCompletedListener() { // from class: com.mob.tools.utils.ResHelper.1
            @Override // android.media.MediaScannerConnection.OnScanCompletedListener
            public void onScanCompleted(String str3, Uri uri2) {
                Uri unused = ResHelper.mediaUri = uri2;
                synchronized (obj) {
                    obj.notifyAll();
                }
            }
        });
        try {
            if (mediaUri == null) {
                synchronized (obj) {
                    obj.wait(10000L);
                }
            }
        } catch (InterruptedException unused) {
        }
        uri = mediaUri;
        mediaUri = null;
        return uri;
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj == null) {
                obj = "";
            }
            if (z) {
                z = false;
            } else {
                sb.append("&");
            }
            sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(String.valueOf(obj)));
        }
        return sb.toString();
    }

    public static String encodeUrl(ArrayList<KVPair<String>> arrayList) {
        if (arrayList == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (KVPair<String> kVPair : arrayList) {
            if (i > 0) {
                sb.append('&');
            }
            String str = kVPair.name;
            String str2 = kVPair.value;
            if (str != null) {
                if (str2 == null) {
                    str2 = "";
                }
                sb.append(Data.urlEncode(str) + "=" + Data.urlEncode(str2));
                i++;
            }
        }
        return sb.toString();
    }

    public static Bundle urlToBundle(String str) {
        String str2;
        int iIndexOf = str.indexOf("://");
        if (iIndexOf >= 0) {
            str2 = "http://" + str.substring(iIndexOf + 1);
        } else {
            str2 = "http://" + str;
        }
        try {
            URL url = new URL(str2);
            Bundle bundleDecodeUrl = decodeUrl(url.getQuery());
            bundleDecodeUrl.putAll(decodeUrl(url.getRef()));
            return bundleDecodeUrl;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return new Bundle();
        }
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String str2 : str.split("&")) {
                String[] strArrSplit = str2.split("=");
                if (strArrSplit.length < 2 || strArrSplit[1] == null) {
                    bundle.putString(URLDecoder.decode(strArrSplit[0]), "");
                } else {
                    bundle.putString(URLDecoder.decode(strArrSplit[0]), URLDecoder.decode(strArrSplit[1]));
                }
            }
        }
        return bundle;
    }

    public static int parseInt(String str) {
        return parseInt(str, 10);
    }

    public static int parseInt(String str, int i) {
        return Integer.parseInt(str, i);
    }

    public static long parseLong(String str) {
        return parseLong(str, 10);
    }

    public static long parseLong(String str, int i) {
        return Long.parseLong(str, i);
    }

    public static String toString(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static <T> T forceCast(Object obj) {
        return (T) forceCast(obj, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static <T> T forceCast(Object obj, T t) {
        if (obj == 0) {
            return t;
        }
        if (obj instanceof Byte) {
            byte bByteValue = ((Byte) obj).byteValue();
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(bByteValue != 0);
            }
            if (t instanceof Short) {
                return (T) Short.valueOf(bByteValue);
            }
            if (t instanceof Character) {
                return (T) Character.valueOf((char) bByteValue);
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf(bByteValue);
            }
            if (t instanceof Float) {
                return (T) Float.valueOf(bByteValue);
            }
            if (t instanceof Long) {
                return (T) Long.valueOf(bByteValue);
            }
            if (t instanceof Double) {
                return (T) Double.valueOf(bByteValue);
            }
        } else if (obj instanceof Character) {
            char cCharValue = ((Character) obj).charValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) cCharValue);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(cCharValue != 0);
            }
            if (t instanceof Short) {
                return (T) Short.valueOf((short) cCharValue);
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf(cCharValue);
            }
            if (t instanceof Float) {
                return (T) Float.valueOf(cCharValue);
            }
            if (t instanceof Long) {
                return (T) Long.valueOf(cCharValue);
            }
            if (t instanceof Double) {
                return (T) Double.valueOf(cCharValue);
            }
        } else if (obj instanceof Short) {
            short sShortValue = ((Short) obj).shortValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) sShortValue);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(sShortValue != 0);
            }
            if (t instanceof Character) {
                return (T) Character.valueOf((char) sShortValue);
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf(sShortValue);
            }
            if (t instanceof Float) {
                return (T) Float.valueOf(sShortValue);
            }
            if (t instanceof Long) {
                return (T) Long.valueOf(sShortValue);
            }
            if (t instanceof Double) {
                return (T) Double.valueOf(sShortValue);
            }
        } else if (obj instanceof Integer) {
            int iIntValue = ((Integer) obj).intValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) iIntValue);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(iIntValue != 0);
            }
            if (t instanceof Character) {
                return (T) Character.valueOf((char) iIntValue);
            }
            if (t instanceof Short) {
                return (T) Short.valueOf((short) iIntValue);
            }
            if (t instanceof Float) {
                return (T) Float.valueOf(iIntValue);
            }
            if (t instanceof Long) {
                return (T) Long.valueOf(iIntValue);
            }
            if (t instanceof Double) {
                return (T) Double.valueOf(iIntValue);
            }
        } else if (obj instanceof Float) {
            float fFloatValue = ((Float) obj).floatValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) fFloatValue);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(fFloatValue != 0.0f);
            }
            if (t instanceof Character) {
                return (T) Character.valueOf((char) fFloatValue);
            }
            if (t instanceof Short) {
                return (T) Short.valueOf((short) fFloatValue);
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf((int) fFloatValue);
            }
            if (t instanceof Long) {
                return (T) Long.valueOf((long) fFloatValue);
            }
            if (t instanceof Double) {
                return (T) Double.valueOf(fFloatValue);
            }
        } else if (obj instanceof Long) {
            long jLongValue = ((Long) obj).longValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) jLongValue);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(jLongValue != 0);
            }
            if (t instanceof Character) {
                return (T) Character.valueOf((char) jLongValue);
            }
            if (t instanceof Short) {
                return (T) Short.valueOf((short) jLongValue);
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf((int) jLongValue);
            }
            if (t instanceof Float) {
                return (T) Float.valueOf(jLongValue);
            }
            if (t instanceof Double) {
                return (T) Double.valueOf(jLongValue);
            }
        } else if (obj instanceof Double) {
            double dDoubleValue = ((Double) obj).doubleValue();
            if (t instanceof Byte) {
                return (T) Byte.valueOf((byte) dDoubleValue);
            }
            if (t instanceof Boolean) {
                return (T) Boolean.valueOf(dDoubleValue != 0.0d);
            }
            if (t instanceof Character) {
                return (T) Character.valueOf((char) dDoubleValue);
            }
            if (t instanceof Short) {
                return (T) Short.valueOf((short) dDoubleValue);
            }
            if (t instanceof Integer) {
                return (T) Integer.valueOf((int) dDoubleValue);
            }
            if (t instanceof Float) {
                return (T) Float.valueOf((float) dDoubleValue);
            }
            if (t instanceof Long) {
                return (T) Long.valueOf((long) dDoubleValue);
            }
        }
        return obj;
    }

    public static boolean copyFile(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || !new File(str).exists()) {
            return false;
        }
        try {
            copyFile(new FileInputStream(str), new FileOutputStream(str2));
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void copyFile(FileInputStream fileInputStream, FileOutputStream fileOutputStream) throws IOException {
        byte[] bArr = new byte[65536];
        int i = fileInputStream.read(bArr);
        while (i > 0) {
            fileOutputStream.write(bArr, 0, i);
            i = fileInputStream.read(bArr);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static long getFileSize(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return getFileSize(new File(str));
    }

    public static long getFileSize(File file) {
        if (!file.exists()) {
            return 0L;
        }
        if (file.isDirectory()) {
            int fileSize = 0;
            for (String str : file.list()) {
                fileSize = (int) (((long) fileSize) + getFileSize(new File(file, str)));
            }
            return fileSize;
        }
        return file.length();
    }

    public static boolean saveObjectToFile(String str, Object obj) {
        File file;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            file = new File(str);
            if (file.exists()) {
                file.delete();
            }
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
        } catch (Throwable th) {
            th.printStackTrace();
            file = null;
        }
        if (file == null) {
            return false;
        }
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(file)));
            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            objectOutputStream.close();
            return true;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return false;
        }
    }

    public static Object readObjectFromFile(String str) {
        File file;
        if (!TextUtils.isEmpty(str)) {
            try {
                file = new File(str);
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!file.exists()) {
                file = null;
            }
            if (file != null) {
                try {
                    ObjectInputStream objectInputStream = new ObjectInputStream(new GZIPInputStream(new FileInputStream(file)));
                    Object object = objectInputStream.readObject();
                    objectInputStream.close();
                    return object;
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
        }
        return null;
    }
}
