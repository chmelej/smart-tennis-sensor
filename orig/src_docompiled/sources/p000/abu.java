package p000;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
final class abu {
    /* JADX INFO: renamed from: a */
    static int m120a() {
        try {
            return new File("/sys/devices/system/cpu/").listFiles(new abv()).length;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* JADX INFO: renamed from: b */
    static int m121b() {
        int iIntValue = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String strTrim = str.trim();
            if (strTrim.length() > 0) {
                iIntValue = Integer.valueOf(strTrim).intValue();
            }
        } catch (Exception e) {
            abt.f175k.m54b((Throwable) e);
        }
        return iIntValue * 1000;
    }

    /* JADX INFO: renamed from: c */
    static int m122c() {
        int iIntValue = 0;
        try {
            String str = "";
            InputStream inputStream = new ProcessBuilder("/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq").start().getInputStream();
            byte[] bArr = new byte[24];
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
            String strTrim = str.trim();
            if (strTrim.length() > 0) {
                iIntValue = Integer.valueOf(strTrim).intValue();
            }
        } catch (Throwable th) {
            abt.f175k.m54b(th);
        }
        return iIntValue * 1000;
    }

    /* JADX INFO: renamed from: d */
    static String m123d() {
        String[] strArr = {"", ""};
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/cpuinfo"), 8192);
            String[] strArrSplit = bufferedReader.readLine().split("\\s+");
            for (int i = 2; i < strArrSplit.length; i++) {
                strArr[0] = strArr[0] + strArrSplit[i] + " ";
            }
            bufferedReader.close();
        } catch (IOException unused) {
        }
        return strArr[0];
    }
}
