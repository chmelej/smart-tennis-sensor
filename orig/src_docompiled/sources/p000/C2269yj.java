package p000;

import android.content.Context;
import android.telephony.TelephonyManager;
import java.util.Random;

/* JADX INFO: renamed from: yj */
/* JADX INFO: compiled from: PhoneInfoUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C2269yj {
    /* JADX INFO: renamed from: a */
    public static final String m12423a() {
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNanoTime = (int) System.nanoTime();
        int iNextInt = new Random().nextInt();
        int iNextInt2 = new Random().nextInt();
        byte[] bArrM12422a = C2268yi.m12422a(iCurrentTimeMillis);
        byte[] bArrM12422a2 = C2268yi.m12422a(iNanoTime);
        byte[] bArrM12422a3 = C2268yi.m12422a(iNextInt);
        byte[] bArrM12422a4 = C2268yi.m12422a(iNextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bArrM12422a, 0, bArr, 0, 4);
        System.arraycopy(bArrM12422a2, 0, bArr, 4, 4);
        System.arraycopy(bArrM12422a3, 0, bArr, 8, 4);
        System.arraycopy(bArrM12422a4, 0, bArr, 12, 4);
        return C2267yh.m12417b(bArr, 2);
    }

    /* JADX INFO: renamed from: a */
    public static String m12424a(Context context) {
        String deviceId = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    deviceId = telephonyManager.getDeviceId();
                }
            } catch (Exception unused) {
            }
        }
        return C2270yk.m12426a(deviceId) ? m12423a() : deviceId;
    }

    /* JADX INFO: renamed from: b */
    public static String m12425b(Context context) {
        String subscriberId = null;
        if (context != null) {
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    subscriberId = telephonyManager.getSubscriberId();
                }
            } catch (Exception unused) {
            }
        }
        return C2270yk.m12426a(subscriberId) ? m12423a() : subscriberId;
    }
}
