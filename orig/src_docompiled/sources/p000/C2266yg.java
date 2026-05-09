package p000;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: yg */
/* JADX INFO: compiled from: AESUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2266yg {
    /* JADX INFO: renamed from: a */
    public static String m12406a(String str, String str2) {
        byte[] bArrM12410a;
        try {
            bArrM12410a = m12410a(m12412b(str.getBytes()), str2.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            bArrM12410a = null;
        }
        if (bArrM12410a != null) {
            return m12407a(bArrM12410a);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static String m12411b(String str, String str2) {
        try {
            return new String(m12413b(m12412b(str.getBytes()), m12409a(str2)));
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m12412b(byte[] bArr) throws NoSuchAlgorithmException, NoSuchProviderException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG", "Crypto");
        secureRandom.setSeed(bArr);
        keyGenerator.init(128, secureRandom);
        return keyGenerator.generateKey().getEncoded();
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m12410a(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m12413b(byte[] bArr, byte[] bArr2) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr, "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(new byte[cipher.getBlockSize()]));
        return cipher.doFinal(bArr2);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m12409a(String str) {
        int length = str.length() / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            bArr[i] = Integer.valueOf(str.substring(i2, i2 + 2), 16).byteValue();
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    public static String m12407a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b : bArr) {
            m12408a(stringBuffer, b);
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    private static void m12408a(StringBuffer stringBuffer, byte b) {
        stringBuffer.append("0123456789ABCDEF".charAt((b >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b & 15));
    }
}
