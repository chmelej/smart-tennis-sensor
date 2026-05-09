package cn.smssdk.net;

import android.text.TextUtils;
import android.util.Base64;
import cn.smssdk.utils.C0984a;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.MobRSA;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.HashMap;
import java.util.zip.GZIPOutputStream;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.ShortBufferException;

/* JADX INFO: renamed from: cn.smssdk.net.c */
/* JADX INFO: compiled from: Crypto.java */
/* JADX INFO: loaded from: classes.dex */
public class C0978c {

    /* JADX INFO: renamed from: a */
    private static Hashon f6121a = new Hashon();

    /* JADX INFO: renamed from: b */
    private static String f6122b = null;

    /* JADX INFO: renamed from: c */
    private static String f6123c = "c0639567f182bd26b1ef4bc13bba7a4d12cbb891302e2bf5da59da50e9b418621f45c6f528972f6b7410ea38f8eb3369f39c7fc35246b8dddd595b5698155b53";

    /* JADX INFO: renamed from: d */
    private static String f6124d = "35b2181b4f1eca4e19542e86e2439f5cdd1c9253fc4b760c372ba4fabdf750c3a04ec9dfada98428d75a9ed9e3078652e5d07b10467bd9328f3a66be21064621";

    /* JADX INFO: renamed from: e */
    private static int f6125e = 128;

    /* JADX INFO: renamed from: a */
    public static void m6784a(String str, String str2, int i) {
        f6123c = str;
        f6124d = str2;
        f6125e = i;
    }

    /* JADX INFO: renamed from: a */
    public static void m6783a(String str) {
        f6122b = str;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6785a() {
        return !TextUtils.isEmpty(f6122b);
    }

    /* JADX INFO: renamed from: b */
    public static byte[] m6789b(String str) {
        try {
            return Data.AES128Encode(Data.rawMD5(f6122b.getBytes()), str);
        } catch (Throwable th) {
            SMSLog.getInstance().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m6787a(byte[] bArr) {
        try {
            return Data.AES128Decode(Data.rawMD5(f6122b.getBytes()), bArr);
        } catch (Throwable th) {
            SMSLog.getInstance().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m6786a(HashMap<String, Object> map, boolean z, int i) {
        byte[] bArrM6790b;
        String strFromHashMap = f6121a.fromHashMap(map);
        SMSLog.getInstance().m8609d("data before encode: " + strFromHashMap, new Object[0]);
        byte[] bytes = strFromHashMap.getBytes();
        if (z) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            bytes = byteArrayOutputStream.toByteArray();
        }
        if (i == 1) {
            if (TextUtils.isEmpty(f6122b)) {
                return null;
            }
            bArrM6790b = C0984a.m6832a(bytes, Data.rawMD5(f6122b.getBytes()));
        } else {
            bArrM6790b = m6790b(bytes);
        }
        SMSLog.getInstance().m8615i("after encode data size = " + bArrM6790b.length, new Object[0]);
        return bArrM6790b;
    }

    /* JADX INFO: renamed from: a */
    public static String m6782a(byte[] bArr, int i) throws Throwable {
        byte[] bArrM6792c;
        if (i == 1) {
            if (TextUtils.isEmpty(f6122b)) {
                return null;
            }
            bArrM6792c = C0984a.m6837b(bArr, Data.rawMD5(f6122b.getBytes()));
        } else {
            bArrM6792c = m6792c(bArr);
        }
        String str = new String(bArrM6792c, "utf-8");
        if (TextUtils.isEmpty(str)) {
            throw new Throwable("[decode]Response is empty");
        }
        return str.trim();
    }

    /* JADX INFO: renamed from: a */
    public static String m6781a(String str, Object obj) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        return Base64.encodeToString(Data.AES128Encode(Data.rawMD5(str.getBytes()), Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2).getBytes()), 2);
    }

    /* JADX INFO: renamed from: a */
    public static Object m6780a(String str, String str2) throws IOException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(Base64.decode(new String(Data.AES128Decode(Data.rawMD5(str.getBytes()), Base64.decode(str2, 2)), "UTF-8").trim(), 2)));
        String str3 = (String) objectInputStream.readObject();
        objectInputStream.close();
        return str3;
    }

    /* JADX INFO: renamed from: c */
    public static String m6791c(String str) {
        return Data.byteToHex(Data.AES128Encode(Data.rawMD5("sms.mob.com.sdk.2.0.0".getBytes()), str.getBytes()));
    }

    /* JADX INFO: renamed from: d */
    public static String m6793d(String str) throws BadPaddingException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, ShortBufferException {
        byte[] bArrAES128Decode = Data.AES128Decode(Data.rawMD5("sms.mob.com.sdk.2.0.0".getBytes()), m6794e(str));
        if (bArrAES128Decode == null) {
            return null;
        }
        return new String(bArrAES128Decode, "utf-8").trim();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m6788b() {
        f6123c = "c0639567f182bd26b1ef4bc13bba7a4d12cbb891302e2bf5da59da50e9b418621f45c6f528972f6b7410ea38f8eb3369f39c7fc35246b8dddd595b5698155b53";
        f6124d = "35b2181b4f1eca4e19542e86e2439f5cdd1c9253fc4b760c372ba4fabdf750c3a04ec9dfada98428d75a9ed9e3078652e5d07b10467bd9328f3a66be21064621";
        f6125e = 128;
        return true;
    }

    /* JADX INFO: renamed from: e */
    public static byte[] m6794e(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        if (length % 2 == 1) {
            return null;
        }
        int i = length / 2;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 2;
            try {
                bArr[i2] = (byte) Integer.parseInt(str.substring(i3, i3 + 2), 16);
            } catch (Throwable unused) {
                return null;
            }
        }
        return bArr;
    }

    /* JADX INFO: renamed from: b */
    private static byte[] m6790b(byte[] bArr) {
        return new MobRSA(f6125e).encode(bArr, new BigInteger(f6123c, 16), new BigInteger(f6124d, 16));
    }

    /* JADX INFO: renamed from: c */
    private static byte[] m6792c(byte[] bArr) {
        return new MobRSA(f6125e).decode(bArr, new BigInteger(f6123c, 16), new BigInteger(f6124d, 16));
    }
}
