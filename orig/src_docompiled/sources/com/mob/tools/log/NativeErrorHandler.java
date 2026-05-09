package com.mob.tools.log;

import android.content.Context;
import com.mob.tools.MobLog;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class NativeErrorHandler {
    private static final boolean ENABLE;
    private static final int MAX_LOG_SIZE = 100;

    private static native void nativePrepare(String str);

    static {
        boolean z;
        try {
            System.loadLibrary("neh");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        ENABLE = z;
    }

    public static boolean prepare(Context context) {
        if (ENABLE) {
            String cachePath = getCachePath(context);
            uploadCreashLog(cachePath);
            nativePrepare(cachePath);
        }
        return ENABLE;
    }

    private static String getCachePath(Context context) {
        File file = new File(ResHelper.getCacheRoot(context), "NativeCrashLogs");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    private static void uploadCreashLog(String str) {
        try {
            Iterator<NativeCrashInfo> it = parseIndex(str).iterator();
            while (it.hasNext()) {
                MobLog.getInstance().nativeCrashLog(parseLog(str, it.next()));
            }
            ResHelper.deleteFileAndFolder(new File(str));
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
    }

    private static ArrayList<NativeCrashInfo> parseIndex(String str) throws IOException {
        File file = new File(str, ".ncl");
        if (!file.exists()) {
            return new ArrayList<>();
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        ArrayList<NativeCrashInfo> arrayList = new ArrayList<>();
        String line = bufferedReader.readLine();
        while (line != null) {
            String[] strArrSplit = line.split(",");
            if (strArrSplit.length >= 2) {
                NativeCrashInfo nativeCrashInfo = new NativeCrashInfo();
                nativeCrashInfo.time = ResHelper.parseLong(strArrSplit[0]);
                nativeCrashInfo.signal = ResHelper.parseInt(strArrSplit[1]);
                arrayList.add(nativeCrashInfo);
                line = bufferedReader.readLine();
            }
        }
        bufferedReader.close();
        return arrayList;
    }

    private static String parseLog(String str, NativeCrashInfo nativeCrashInfo) throws IOException {
        File file = new File(str, "." + nativeCrashInfo.time);
        if (!file.exists()) {
            return "";
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        LinkedList linkedList = new LinkedList();
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            linkedList.add(line);
            if (linkedList.size() > 100) {
                linkedList.remove(0);
            }
        }
        bufferedReader.close();
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            stringBuffer.append((String) it.next());
            stringBuffer.append('\n');
        }
        return stringBuffer.length() > 0 ? stringBuffer.substring(0, stringBuffer.length() - 1) : "";
    }

    static class NativeCrashInfo {
        public int signal;
        public long time;

        private NativeCrashInfo() {
        }
    }
}
