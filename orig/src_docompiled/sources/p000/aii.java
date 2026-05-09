package p000;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: compiled from: AesHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class aii {

    /* JADX INFO: renamed from: a */
    private static byte[] f1130a = "uLi4/f4+Pb39.T19".getBytes();

    /* JADX INFO: renamed from: b */
    private static byte[] f1131b = "nmeug.f9/Om+L823".getBytes();

    /* JADX INFO: renamed from: a */
    public static String m1317a(String... strArr) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        String str2;
        String str3 = null;
        if (strArr.length == 2) {
            str2 = strArr[0];
            str = strArr[1];
        } else if (strArr.length == 3) {
            String str4 = strArr[0];
            String str5 = strArr[1];
            str3 = strArr[2];
            str = str5;
            str2 = str4;
        } else {
            str = null;
            str2 = null;
        }
        if (str3 != null && str3.length() == 16) {
            f1130a = str3.getBytes();
        }
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(f1130a, "AES"), new IvParameterSpec(f1131b));
        return aij.m1322b(cipher.doFinal(str2.getBytes(str)));
    }
}
