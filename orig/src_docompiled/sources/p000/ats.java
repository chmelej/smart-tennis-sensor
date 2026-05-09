package p000;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.File;
import java.io.FileInputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes.dex */
public class ats {

    /* JADX INFO: renamed from: a */
    public static final String f5055a = System.getProperty("line.separator");

    /* JADX INFO: renamed from: a */
    public static String m5470a(String str) {
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
    public static String m5472b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] bArrDigest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : bArrDigest) {
                stringBuffer.append(Integer.toHexString(b & 255));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            atj.m5424a("helper", "getMD5 error", e);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m5469a(File file) {
        byte[] bArr = new byte[1024];
        try {
            if (!file.isFile()) {
                return "";
            }
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            FileInputStream fileInputStream = new FileInputStream(file);
            while (true) {
                int i = fileInputStream.read(bArr, 0, 1024);
                if (i != -1) {
                    messageDigest.update(bArr, 0, i);
                } else {
                    fileInputStream.close();
                    return String.format("%1$032x", new BigInteger(1, messageDigest.digest()));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m5473c(String str) {
        try {
            long jLongValue = Long.valueOf(str).longValue();
            if (jLongValue < PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID) {
                return String.valueOf((int) jLongValue) + "B";
            }
            if (jLongValue < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                return String.valueOf(new DecimalFormat("#0.00").format(jLongValue / 1024.0d)) + "K";
            }
            if (jLongValue < 1073741824) {
                return String.valueOf(new DecimalFormat("#0.00").format(jLongValue / 1048576.0d)) + "M";
            }
            return String.valueOf(new DecimalFormat("#0.00").format(jLongValue / 1.073741824E9d)) + "G";
        } catch (NumberFormatException unused) {
            return str;
        }
    }

    /* JADX INFO: renamed from: d */
    public static boolean m5474d(String str) {
        return str == null || str.length() == 0;
    }

    /* JADX INFO: renamed from: a */
    public static String m5468a() {
        return m5471a(new Date());
    }

    /* JADX INFO: renamed from: a */
    public static String m5471a(Date date) {
        return date == null ? "" : new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }
}
