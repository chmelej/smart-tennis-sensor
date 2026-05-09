package p000;

import android.content.Context;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: DataHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class aes {

    /* JADX INFO: renamed from: a */
    private static final byte[] f707a = {10, 1, 11, 5, 4, 15, 7, 9, 23, 3, 1, 6, 8, 12, 13, 91};

    /* JADX INFO: renamed from: a */
    public static byte[] m707a(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[length / 2];
        int i = 0;
        while (i < length) {
            int i2 = i + 2;
            bArr[i / 2] = (byte) Integer.valueOf(str.substring(i, i2), 16).intValue();
            i = i2;
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m706a(Context context, byte[] bArr) {
        long length = bArr.length;
        if (length <= adb.f367f) {
            return false;
        }
        afc.m806a(context).m816e();
        agp.m938a(context).m953a(length, System.currentTimeMillis(), "__data_size_of");
        return true;
    }

    /* JADX INFO: renamed from: a */
    public static String m705a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02X", Byte.valueOf(b)));
        }
        return stringBuffer.toString().toLowerCase(Locale.US);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m710b(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.reset();
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m708a(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(1, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f707a));
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m711b(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        cipher.init(2, new SecretKeySpec(bArr2, "AES"), new IvParameterSpec(f707a));
        return cipher.doFinal(bArr);
    }

    /* JADX INFO: renamed from: a */
    public static int m703a(int i, String str) throws Throwable {
        if (new Random().nextFloat() < 0.001d) {
            int i2 = 0;
            if (str == null) {
                aex.m771a("--->", "null signature..");
            }
            try {
                i2 = Integer.parseInt(str.substring(9, 11), 16);
            } catch (Exception unused) {
            }
            return (i2 | 128) * 1000;
        }
        int iNextInt = new Random().nextInt(i);
        if (iNextInt > 255000 || iNextInt < 128000) {
            return iNextInt;
        }
        return 127000;
    }

    /* JADX INFO: renamed from: a */
    public static String m704a(Throwable th) {
        StringWriter stringWriter;
        PrintWriter printWriter;
        String string;
        String str = null;
        if (th == null) {
            return null;
        }
        try {
            stringWriter = new StringWriter();
            printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            for (Throwable cause = th.getCause(); cause != null; cause = cause.getCause()) {
                cause.printStackTrace(printWriter);
            }
            string = stringWriter.toString();
        } catch (Exception e) {
            e = e;
        }
        try {
            printWriter.close();
            stringWriter.close();
            return string;
        } catch (Exception e2) {
            str = string;
            e = e2;
            e.printStackTrace();
            return str;
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m709b(String str) {
        return "http://" + str + ".umeng.com/app_logs";
    }

    /* JADX INFO: renamed from: c */
    public static String m712c(String str) {
        byte[] bytes = str.getBytes();
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            messageDigest.update(bytes);
            return m713c(messageDigest.digest());
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    static String m713c(byte[] bArr) {
        String str = "";
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & 255);
            if (hexString.length() == 1) {
                str = str + "0";
            }
            str = str + hexString;
        }
        return str;
    }
}
