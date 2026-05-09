package p000;

import android.support.v4.media.session.PlaybackStateCompat;
import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: mg */
/* JADX INFO: compiled from: StringUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1908mg {

    /* JADX INFO: renamed from: a */
    private static final byte[] f11491a = "0123456789ABCDEF".getBytes();

    /* JADX INFO: renamed from: b */
    private static final Pattern f11492b = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");

    /* JADX INFO: renamed from: c */
    private static final Pattern f11493c = Pattern.compile("^(http|https|www|ftp|)?(://)?(\\w+(-\\w+)*)(\\.(\\w+(-\\w+)*))*((:\\d+)?)(/(\\w+(-\\w+)*))*(\\.?(\\w)*)(\\?)?(((\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*(\\w*%)*(\\w*\\?)*(\\w*:)*(\\w*\\+)*(\\w*\\.)*(\\w*&)*(\\w*-)*(\\w*=)*)*(\\w*)*)$", 2);

    /* JADX INFO: renamed from: a */
    public static String m10518a(long j) {
        boolean z = j < 0;
        long jAbs = Math.abs(j) / 1000;
        int i = (int) (jAbs % 60);
        long j2 = jAbs / 60;
        int i2 = (int) (j2 % 60);
        long j3 = j2 / 60;
        int i3 = (int) j3;
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("00");
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "-" : "");
            sb.append(i3);
            sb.append(":");
            sb.append(decimalFormat.format(i2));
            sb.append(":");
            sb.append(decimalFormat.format(i));
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "-" : "");
        sb2.append(i2);
        sb2.append(":");
        sb2.append(decimalFormat.format(i));
        return sb2.toString();
    }

    /* JADX INFO: renamed from: a */
    public static String m10519a(String str) {
        return str.contains(",") ? str.replace(",", ".") : str;
    }

    /* JADX INFO: renamed from: a */
    public static long m10517a(File file) throws IOException {
        if (file.exists()) {
            return new FileInputStream(file).available();
        }
        file.createNewFile();
        Log.e("获取文件大小", "文件不存在!");
        return 0L;
    }

    /* JADX INFO: renamed from: b */
    public static String m10520b(long j) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        if (j == 0) {
            return "0B";
        }
        if (j < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
            return decimalFormat.format(j) + "B";
        }
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return decimalFormat.format(j / 1024.0d) + "KB";
        }
        if (j < 1073741824) {
            return decimalFormat.format(j / 1048576.0d) + "MB";
        }
        return decimalFormat.format(j / 1.073741824E9d) + "GB";
    }
}
