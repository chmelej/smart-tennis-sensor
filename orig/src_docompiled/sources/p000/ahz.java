package p000;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: EncryptUtil.java */
/* JADX INFO: loaded from: classes.dex */
public final class ahz {

    /* JADX INFO: renamed from: a */
    private static byte[] f1123a = {82, 22, 50, 44, -16, 124, -40, -114, -87, -40, 37, 23, -56, 23, -33, 75};

    /* JADX INFO: renamed from: b */
    private static ThreadLocal<Cipher> f1124b = new ThreadLocal<>();

    /* JADX INFO: renamed from: c */
    private static final AlgorithmParameterSpec f1125c = new IvParameterSpec(f1123a);

    /* JADX INFO: renamed from: d */
    private static final SecureRandom f1126d = new SecureRandom();

    /* JADX INFO: renamed from: a */
    public static final String m1282a(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(secretKeySpec);
            return ahw.m1271a(mac.doFinal(str2.getBytes()));
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final String m1283a(String str, String str2, int i) {
        try {
            return ahw.m1272a(m1288a(str2.getBytes("utf-8"), m1286a(str.getBytes(), i)), 8);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static final String m1289b(String str, String str2, int i) {
        try {
            return new String(m1291b(ahw.m1275a(str2, 8), m1286a(str.getBytes(), i)), "utf-8");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static final byte[] m1288a(byte[] bArr, SecretKeySpec secretKeySpec) {
        try {
            return m1285a(secretKeySpec, 1).doFinal(bArr);
        } catch (BadPaddingException e) {
            throw new IllegalArgumentException("AES decrypt error:" + e.getMessage(), e);
        } catch (IllegalBlockSizeException e2) {
            throw new IllegalArgumentException("AES decrypt error:" + e2.getMessage(), e2);
        }
    }

    /* JADX INFO: renamed from: b */
    private static final byte[] m1291b(byte[] bArr, SecretKeySpec secretKeySpec) {
        try {
            return m1285a(secretKeySpec, 2).doFinal(bArr);
        } catch (BadPaddingException e) {
            throw new IllegalArgumentException("AES decrypt error:" + e.getMessage(), e);
        } catch (IllegalBlockSizeException e2) {
            throw new IllegalArgumentException("AES decrypt error:" + e2.getMessage(), e2);
        }
    }

    /* JADX INFO: renamed from: a */
    private static final Cipher m1285a(SecretKeySpec secretKeySpec, int i) {
        Cipher cipherM1284a = m1284a();
        try {
            cipherM1284a.init(i, secretKeySpec, f1125c, f1126d);
            return cipherM1284a;
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("init Chipher error:" + e.getMessage(), e);
        } catch (InvalidAlgorithmParameterException e2) {
            throw new RuntimeException("init Chipher error:" + e2.getMessage(), e2);
        } catch (InvalidKeyException e3) {
            throw new RuntimeException("init Chipher error:" + e3.getMessage(), e3);
        }
    }

    /* JADX INFO: renamed from: a */
    private static final Cipher m1284a() {
        Cipher cipher = f1124b.get();
        if (cipher == null) {
            try {
                cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                f1124b.set(cipher);
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("get Chipher error:" + e.getMessage(), e);
            } catch (NoSuchPaddingException e2) {
                throw new RuntimeException("get Chipher error:" + e2.getMessage(), e2);
            }
        }
        return cipher;
    }

    /* JADX INFO: renamed from: a */
    private static final SecretKeySpec m1286a(byte[] bArr, int i) {
        if (bArr == null) {
            throw new IllegalArgumentException("secret key can not be null");
        }
        byte[] bArrM1287a = new byte[16];
        switch (i) {
            case 0:
                if (128 != bArr.length * 8) {
                    System.arraycopy(bArr, 0, bArrM1287a, 0, 16);
                }
                break;
            case 1:
                System.arraycopy(m1290b(bArr), 0, bArrM1287a, 0, 16);
                break;
            case 2:
                bArrM1287a = m1287a(bArr);
                break;
        }
        return new SecretKeySpec(bArrM1287a, "AES");
    }

    /* JADX INFO: renamed from: a */
    private static final byte[] m1287a(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (Throwable th) {
            throw new RuntimeException("md5 value Throwable", th);
        }
    }

    /* JADX INFO: renamed from: b */
    private static final byte[] m1290b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            bArr2[i] = bArr[(bArr.length - 1) - i];
        }
        return bArr2;
    }
}
