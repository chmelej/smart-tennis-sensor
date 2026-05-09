package com.mob.tools.utils;

import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import com.mob.tools.network.BufferedByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.CRC32;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class Data {
    private static final String CHAT_SET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static byte[] SHA1(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return SHA1(str.getBytes("utf-8"));
    }

    public static byte[] SHA1(byte[] bArr) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        messageDigest.update(bArr);
        return messageDigest.digest();
    }

    public static byte[] SHA1(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            int i = inputStream.read(bArr);
            while (i != -1) {
                messageDigest.update(bArr, 0, i);
                i = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public static byte[] SHA1(File file) {
        FileInputStream fileInputStream;
        byte[] bArrSHA1;
        byte[] bArr = null;
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            fileInputStream = new FileInputStream(file);
            bArrSHA1 = SHA1(fileInputStream);
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileInputStream.close();
            return bArrSHA1;
        } catch (Throwable th2) {
            bArr = bArrSHA1;
            th = th2;
            MobLog.getInstance().m8622w(th);
            return bArr;
        }
    }

    public static byte[] AES128Encode(String str, String str2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, NoSuchProviderException, ShortBufferException {
        if (str == null || str2 == null) {
            return null;
        }
        byte[] bytes = str.getBytes("UTF-8");
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, Math.min(bytes.length, 16));
        byte[] bytes2 = str2.getBytes("UTF-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr2 = new byte[cipher.getOutputSize(bytes2.length)];
        cipher.doFinal(bArr2, cipher.update(bytes2, 0, bytes2.length, bArr2, 0));
        return bArr2;
    }

    public static byte[] AES128Encode(byte[] bArr, String str) {
        if (bArr == null || str == null) {
            return null;
        }
        return AES128Encode(bArr, str.getBytes("UTF-8"));
    }

    public static byte[] AES128Encode(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, ShortBufferException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");
        cipher.init(1, secretKeySpec);
        byte[] bArr3 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr3, cipher.update(bArr2, 0, bArr2.length, bArr3, 0));
        return bArr3;
    }

    public static String AES128Decode(String str, byte[] bArr) {
        if (str == null || bArr == null) {
            return null;
        }
        return new String(AES128Decode(str.getBytes("UTF-8"), bArr), "UTF-8");
    }

    public static byte[] AES128Decode(byte[] bArr, byte[] bArr2) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, ShortBufferException {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/NoPadding", "BC");
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public static String byteToHex(byte[] bArr) {
        return byteToHex(bArr, 0, bArr.length);
    }

    public static String byteToHex(byte[] bArr, int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return stringBuffer.toString();
        }
        while (i < i2) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
            i++;
        }
        return stringBuffer.toString();
    }

    public static String base62(long j) {
        String str = j == 0 ? "0" : "";
        while (j > 0) {
            int i = (int) (j % 62);
            j /= 62;
            str = CHAT_SET.charAt(i) + str;
        }
        return str;
    }

    public static String MD5(String str) {
        byte[] bArrRawMD5;
        if (str == null || (bArrRawMD5 = rawMD5(str)) == null) {
            return null;
        }
        return toHex(bArrRawMD5);
    }

    public static String MD5(byte[] bArr) {
        byte[] bArrRawMD5;
        if (bArr == null || (bArrRawMD5 = rawMD5(bArr)) == null) {
            return null;
        }
        return toHex(bArrRawMD5);
    }

    public static String MD5(File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bArrRawMD5 = rawMD5(fileInputStream);
            fileInputStream.close();
            if (bArrRawMD5 == null) {
                return null;
            }
            return toHex(bArrRawMD5);
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public static byte[] rawMD5(String str) {
        if (str == null) {
            return null;
        }
        try {
            return rawMD5(str.getBytes("utf-8"));
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public static byte[] rawMD5(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            byte[] bArrRawMD5 = rawMD5(byteArrayInputStream);
            byteArrayInputStream.close();
            return bArrRawMD5;
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public static byte[] rawMD5(InputStream inputStream) {
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr = new byte[1024];
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            int i = inputStream.read(bArr);
            while (i != -1) {
                messageDigest.update(bArr, 0, i);
                i = inputStream.read(bArr);
            }
            return messageDigest.digest();
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public static String Base64AES(String str, String str2) {
        String strEncodeToString;
        if (str == null || str2 == null) {
            return null;
        }
        try {
            strEncodeToString = Base64.encodeToString(AES128Encode(str2, str), 0);
        } catch (Throwable th) {
            th = th;
            strEncodeToString = null;
        }
        try {
            return (!TextUtils.isEmpty(strEncodeToString) && strEncodeToString.contains("\n")) ? strEncodeToString.replace("\n", "") : strEncodeToString;
        } catch (Throwable th2) {
            th = th2;
            MobLog.getInstance().m8622w(th);
            return strEncodeToString;
        }
    }

    public static String urlEncode(String str, String str2) throws UnsupportedEncodingException {
        String strEncode = URLEncoder.encode(str, str2);
        return TextUtils.isEmpty(strEncode) ? strEncode : strEncode.replace("+", "%20");
    }

    public static String urlEncode(String str) {
        try {
            return urlEncode(str, "utf-8");
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return null;
        }
    }

    public static String CRC32(byte[] bArr) {
        CRC32 crc32 = new CRC32();
        crc32.update(bArr);
        long value = crc32.getValue();
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 56)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 48)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 40)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 32)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 24)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 16)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) (value >>> 8)) & 255)));
        sb.append(String.format("%02x", Integer.valueOf(((byte) value) & 255)));
        while (sb.charAt(0) == '0') {
            sb = sb.deleteCharAt(0);
        }
        return sb.toString().toLowerCase();
    }

    public static byte[] rawRSAEncode(byte[] bArr, byte[] bArr2, int i) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        int i2 = (i / 8) - 11;
        RSAPublicKey rSAPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(1, rSAPublicKey);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (int i3 = 0; bArr.length - i3 > 0; i3 += i2) {
            byte[] bArrDoFinal = cipher.doFinal(bArr, i3, Math.min(bArr.length - i3, i2));
            byteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] rawRSADecode(byte[] bArr, byte[] bArr2, int i) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, IOException {
        KeyFactory.getInstance("RSA");
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(bArr2));
        Cipher cipher = Cipher.getInstance("RSA/None/PKCS1Padding");
        cipher.init(2, rSAPrivateKey);
        int i2 = i / 8;
        BufferedByteArrayOutputStream bufferedByteArrayOutputStream = new BufferedByteArrayOutputStream();
        for (int i3 = 0; bArr.length - i3 > 0; i3 += i2) {
            byte[] bArrDoFinal = cipher.doFinal(bArr, i3, Math.min(bArr.length - i3, i2));
            bufferedByteArrayOutputStream.write(bArrDoFinal, 0, bArrDoFinal.length);
        }
        bufferedByteArrayOutputStream.close();
        return bufferedByteArrayOutputStream.toByteArray();
    }

    private static String toHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(b)));
        }
        return stringBuffer.toString();
    }
}
