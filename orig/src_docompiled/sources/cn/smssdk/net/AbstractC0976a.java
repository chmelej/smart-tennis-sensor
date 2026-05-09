package cn.smssdk.net;

import android.text.TextUtils;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.network.ByteArrayPart;
import com.mob.tools.network.KVPair;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.Data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: cn.smssdk.net.a */
/* JADX INFO: compiled from: BaseApi.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0976a {

    /* JADX INFO: renamed from: i */
    private static NetworkHelper f6072i;

    /* JADX INFO: renamed from: j */
    private static NetworkHelper.NetworkTimeOut f6073j;

    /* JADX INFO: renamed from: a */
    protected int f6074a;

    /* JADX INFO: renamed from: b */
    protected String f6075b;

    /* JADX INFO: renamed from: c */
    protected String f6076c;

    /* JADX INFO: renamed from: d */
    protected int f6077d;

    /* JADX INFO: renamed from: e */
    protected boolean f6078e;

    /* JADX INFO: renamed from: f */
    protected boolean f6079f;

    /* JADX INFO: renamed from: g */
    protected boolean f6080g = false;

    /* JADX INFO: renamed from: h */
    protected ReentrantReadWriteLock f6081h;

    /* JADX INFO: renamed from: a */
    protected abstract HashMap<String, Object> mo6736a(String str, String str2, HashMap<String, Object> map);

    /* JADX INFO: renamed from: b */
    public abstract boolean mo6739b();

    /* JADX INFO: renamed from: a */
    public int m6735a() {
        return this.f6074a;
    }

    /* JADX INFO: renamed from: a */
    public void m6737a(ReentrantReadWriteLock reentrantReadWriteLock) {
        this.f6081h = reentrantReadWriteLock;
    }

    /* JADX INFO: renamed from: b */
    public String m6738b(String str, String str2, HashMap<String, Object> map) throws Throwable {
        if (mo6739b()) {
            throw new Throwable("{\"status\":464}");
        }
        try {
            if (this.f6081h != null) {
                this.f6081h.readLock().lock();
            }
            return m6732a(this.f6076c, m6734a(mo6736a(str, str2, map), this.f6078e, this.f6077d), str2, this.f6077d, 0);
        } finally {
            if (this.f6081h != null) {
                this.f6081h.readLock().unlock();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m6732a(String str, byte[] bArr, String str2, int i, int i2) throws Throwable {
        String strM6733a;
        if (i2 > 3) {
            throw new Throwable("{'detail':'CRC Error,Network is poor'}");
        }
        if (f6072i == null || f6073j == null) {
            f6073j = new NetworkHelper.NetworkTimeOut();
            f6073j.connectionTimeout = 180000;
            f6073j.readTimout = 180000;
            f6072i = new NetworkHelper();
        }
        ArrayList<KVPair<String>> arrayListM6809a = C0980e.m6795a().m6809a(bArr, str2);
        ByteArrayPart byteArrayPart = new ByteArrayPart();
        byteArrayPart.append(bArr);
        HashMap map = new HashMap();
        f6072i.rawPost(str, arrayListM6809a, byteArrayPart, new HttpResponseCallbackImp(map), f6073j);
        if (map == null || map.size() <= 0) {
            throw new Throwable("[map]Response is empty");
        }
        byte[] bArr2 = (byte[]) map.get("bResp");
        if (bArr2 == null || bArr2.length <= 0) {
            throw new Throwable("[resp]Response is empty");
        }
        String str3 = (String) map.get("hash");
        if (!TextUtils.isEmpty(str3) && !Data.CRC32(bArr2).equals(str3)) {
            return m6732a(str, bArr, str2, i, i2 + 1);
        }
        Object obj = map.get("httpStatus");
        if ((obj != null ? ((Integer) obj).intValue() : 0) == 600) {
            strM6733a = new String(bArr2, "utf-8");
        } else {
            strM6733a = m6733a(bArr2, i);
        }
        SMSLog.getInstance().m8609d("resp: " + strM6733a, new Object[0]);
        return strM6733a;
    }

    /* JADX INFO: renamed from: a */
    private static byte[] m6734a(HashMap<String, Object> map, boolean z, int i) {
        return C0978c.m6786a(map, z, i);
    }

    /* JADX INFO: renamed from: a */
    private static String m6733a(byte[] bArr, int i) {
        return C0978c.m6782a(bArr, i);
    }
}
