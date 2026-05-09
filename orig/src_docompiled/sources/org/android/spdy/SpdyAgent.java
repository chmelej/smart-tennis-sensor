package org.android.spdy;

import android.content.Context;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes.dex */
public final class SpdyAgent {
    private static final boolean HAVE_CLOSE = false;
    private static final int KB32 = 32768;
    private static final int KB8 = 8192;
    private static final int MAX_SPDY_SESSION_COUNT = 50;
    private static final int MB5 = 5242880;
    static final int MODE_QUIC = 256;
    static final int SPDY_CUSTOM_CONTROL_FRAME_RECV = 4106;
    static final int SPDY_DATA_CHUNK_RECV = 4097;
    static final int SPDY_DATA_RECV = 4098;
    static final int SPDY_DATA_SEND = 4099;
    static final int SPDY_PING_RECV = 4101;
    private static final int SPDY_PROTOCAL = 2;
    static final int SPDY_REQUEST_RECV = 4102;
    static final int SPDY_SESSION_CLOSE = 4103;
    static final int SPDY_SESSION_CREATE = 4096;
    static final int SPDY_SESSION_FAILED_ERROR = 4105;
    static final int SPDY_STREAM_CLOSE = 4100;
    static final int SPDY_STREAM_RESPONSE_RECV = 4104;
    public static volatile boolean enableDebug = false;
    public static volatile boolean enableTimeGaurd = false;
    private static SpdyAgent gSingleInstance;
    private long agentNativePtr;
    private static final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();

    /* JADX INFO: renamed from: r */
    private static final Lock f12046r = rwLock.readLock();

    /* JADX INFO: renamed from: w */
    private static final Lock f12047w = rwLock.writeLock();
    private static Object lock = new Object();
    private HashMap<String, SpdySession> sessionMgr = new HashMap<>(5);
    private LinkedList<SpdySession> sessionQueue = new LinkedList<>();
    private AtomicBoolean closed = new AtomicBoolean();
    private String proxyUsername = null;
    private String proxyPassword = null;

    private native int closeSessionN(long j);

    private static void crashReporter(int i) {
    }

    private native long createSession(long j, SpdySession spdySession, byte[] bArr, char c, byte[] bArr2, char c2, byte[] bArr3, byte[] bArr4, Object obj, int i, int i2);

    private native int freeAgent(long j);

    private native long getSession(long j, byte[] bArr, char c);

    private native long initAgent(int i, int i2, int i3);

    private native int setConTimeout(long j, int i);

    private native int setSessionKind(long j, int i);

    private native long submitRequest(long j, SpdySession spdySession, byte[] bArr, char c, byte[] bArr2, char c2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte b, String[] strArr, byte[] bArr6, boolean z, Object obj, int i, int i2, int i3, int i4, int i5);

    public void close() {
    }

    void clearSpdySession(String str) {
        if (str != null) {
            f12047w.lock();
            if (str != null) {
                try {
                    try {
                        this.sessionMgr.remove(str);
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                } finally {
                    f12047w.unlock();
                }
            }
        }
    }

    public static SpdyAgent getInstance(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) {
        if (gSingleInstance == null) {
            synchronized (lock) {
                if (gSingleInstance == null) {
                    gSingleInstance = new SpdyAgent(context, spdyVersion, spdySessionKind);
                }
            }
        }
        return gSingleInstance;
    }

    private SpdyAgent(Context context, SpdyVersion spdyVersion, SpdySessionKind spdySessionKind) {
        try {
            SoInstallMgrSdk.init(context);
            SoInstallMgrSdk.initSo("tnet-2.1.20.1-agoo", 1);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        try {
            this.agentNativePtr = initAgent(spdyVersion.getInt(), spdySessionKind.getint(), 0);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
        this.closed.set(false);
    }

    public SpdySession getSession(SpdyRequest spdyRequest) {
        if (spdyRequest == null) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        agentIsOpen();
        f12046r.lock();
        try {
            return this.sessionMgr.get(spdyRequest.getAuthority());
        } finally {
            f12046r.unlock();
        }
    }

    public void setProxyUsernamePassword(String str, String str2) {
        this.proxyUsername = str;
        this.proxyPassword = str2;
    }

    static void securityCheck(int i, int i2) {
        if (i >= 32768) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        if (i2 >= 8192) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:value=" + i2, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    static void tableListJudge(int i) {
        if (i >= MB5) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + i, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
    }

    static void InvlidCharJudge(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < bArr.length; i++) {
            if ((bArr[i] & 255) < 32 || (bArr[i] & 255) > 126) {
                bArr[i] = 63;
            }
        }
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            if ((bArr2[i2] & 255) < 32 || (bArr2[i2] & 255) > 126) {
                bArr2[i2] = 63;
            }
        }
    }

    static void headJudge(Map<String, String> map) {
        if (map != null) {
            int length = 0;
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                InvlidCharJudge(key.getBytes(), value.getBytes());
                length += key.length() + 1 + value.length();
                securityCheck(length, value.length());
            }
        }
    }

    static String mapBodyToString(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map == null) {
            return null;
        }
        int length = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            sb.append(key);
            sb.append('=');
            sb.append(value);
            sb.append('&');
            length += key.length() + 1 + value.length();
            tableListJudge(length);
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    static byte[] dataproviderToByteArray(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider) {
        byte[] bytes;
        headJudge(spdyRequest.getHeaders());
        if (spdyDataProvider == null) {
            return null;
        }
        String strMapBodyToString = mapBodyToString(spdyDataProvider.postBody);
        if (strMapBodyToString != null) {
            bytes = strMapBodyToString.getBytes();
        } else {
            bytes = spdyDataProvider.data;
        }
        if (bytes == null || bytes.length < MB5) {
            return bytes;
        }
        throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM:total=" + bytes.length, TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
    }

    public SpdySession createSession(String str, Object obj, SessionCb sessionCb) {
        String str2;
        byte[] bArr;
        char c;
        SpdySession spdySession;
        SpdySession spdySession2;
        String str3;
        char c2;
        long jCreateSession;
        int i;
        if (str == null) {
            throw new SpdyErrorException("SPDY_JNI_ERR_INVALID_PARAM", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        String[] strArrSplit = str.split("/");
        String[] strArrSplit2 = strArrSplit[0].split(":");
        byte[] bytes = "0.0.0.0".getBytes();
        if (strArrSplit.length != 1) {
            String[] strArrSplit3 = strArrSplit[1].split(":");
            byte[] bytes2 = strArrSplit3[0].getBytes();
            c = (char) Integer.parseInt(strArrSplit3[1]);
            bArr = bytes2;
            str2 = str;
        } else {
            str2 = str + "/0.0.0.0:0";
            bArr = bytes;
            c = 0;
        }
        agentIsOpen();
        f12046r.lock();
        try {
            SpdySession spdySession3 = this.sessionMgr.get(str2);
            if (this.sessionMgr.size() >= 50) {
                throw new SpdyErrorException("SPDY_SESSION_EXCEED_MAXED: session count exceed max", TnetStatusCode.TNET_SESSION_EXCEED_MAXED);
            }
            if (spdySession3 != null) {
                return spdySession3;
            }
            f12047w.lock();
            SpdySession spdySession4 = null;
            try {
                spdySession = this.sessionMgr.get(str2);
            } catch (Throwable unused) {
                spdySession = null;
            }
            if (spdySession != null) {
                return spdySession;
            }
            try {
                SpdySession spdySession5 = new SpdySession(0L, this, str2, sessionCb, obj);
                if (this.proxyUsername != null && this.proxyPassword != null) {
                    spdySession2 = spdySession5;
                    str3 = str2;
                    c2 = 1;
                    jCreateSession = createSession(this.agentNativePtr, spdySession5, strArrSplit2[0].getBytes(), (char) Integer.parseInt(strArrSplit2[1]), bArr, c, this.proxyUsername.getBytes(), this.proxyPassword.getBytes(), obj, 2, -1);
                } else {
                    spdySession2 = spdySession5;
                    str3 = str2;
                    c2 = 1;
                    jCreateSession = createSession(this.agentNativePtr, spdySession2, strArrSplit2[0].getBytes(), (char) Integer.parseInt(strArrSplit2[1]), bArr, c, null, null, obj, 2, -1);
                }
                spduLog.Logi("tnet-jni", " create new session: " + str);
                if ((jCreateSession & 1) == 1) {
                    i = (int) (jCreateSession >> c2);
                    jCreateSession = 0;
                } else {
                    i = 0;
                }
                if (jCreateSession != 0) {
                    SpdySession spdySession6 = spdySession2;
                    spdySession6.setSessionNativePtr(jCreateSession);
                    this.sessionMgr.put(str3, spdySession6);
                    this.sessionQueue.add(spdySession6);
                    spdySession4 = spdySession6;
                } else if (i != 0) {
                    throw new SpdyErrorException("create session error: " + i, i);
                }
                return spdySession4;
            } finally {
                f12047w.unlock();
            }
        } finally {
            f12046r.unlock();
        }
    }

    public int closeSession(String str) {
        SpdySession spdySession;
        String[] strArrSplit = str.split("/");
        "0.0.0.0".getBytes();
        if (strArrSplit.length != 1) {
            String[] strArrSplit2 = strArrSplit[1].split(":");
            strArrSplit2[0].getBytes();
            Integer.parseInt(strArrSplit2[1]);
        } else {
            str = str + "/0.0.0.0:0";
        }
        agentIsOpen();
        f12047w.lock();
        try {
            spdySession = this.sessionMgr.get(str);
        } catch (Throwable unused) {
            spdySession = null;
        }
        if (spdySession == null) {
            f12047w.unlock();
            return -1;
        }
        try {
            return spdySession.closeSession();
        } finally {
            f12047w.unlock();
        }
    }

    public SpdySession submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Object obj2, Spdycb spdycb, SessionCb sessionCb, int i) {
        SpdySession spdySessionCreateSession = createSession(spdyRequest.getAuthority(), obj, sessionCb);
        spdySessionCreateSession.submitRequest(spdyRequest, spdyDataProvider, obj2, spdycb);
        return spdySessionCreateSession;
    }

    private void agentIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("SPDY_JNI_ERR_ASYNC_CLOSE", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    void removeSession(SpdySession spdySession) {
        f12047w.lock();
        try {
            this.sessionQueue.remove(spdySession);
        } finally {
            f12047w.unlock();
        }
    }

    int closeSession(long j) {
        return closeSessionN(j);
    }

    static String[] mapToByteArray(Map<String, String> map) {
        if (map == null || map.size() <= 0) {
            return null;
        }
        String[] strArr = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            strArr[i] = entry.getKey();
            strArr[i + 1] = entry.getValue();
            i += 2;
        }
        return strArr;
    }

    static Map<String, List<String>> stringArrayToMap(String[] strArr) {
        if (strArr == null) {
            return null;
        }
        HashMap map = new HashMap(5);
        int i = 0;
        while (true) {
            int i2 = i + 2;
            if (i2 > strArr.length) {
                return map;
            }
            if (strArr[i] == null) {
                break;
            }
            int i3 = i + 1;
            if (strArr[i3] == null) {
                break;
            }
            List arrayList = (List) map.get(strArr[i]);
            if (arrayList == null) {
                arrayList = new ArrayList(1);
                map.put(strArr[i], arrayList);
            }
            arrayList.add(strArr[i3]);
            i = i2;
        }
        return null;
    }

    public int setSessionKind(SpdySessionKind spdySessionKind) {
        agentIsOpen();
        try {
            return setSessionKind(this.agentNativePtr, spdySessionKind.getint());
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return -1;
        }
    }

    public int setConnectTimeOut(int i) {
        agentIsOpen();
        try {
            return setConTimeout(this.agentNativePtr, i);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return 0;
        }
    }

    private void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdySessionConnectCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdySessionConnectCB(spdySession, superviseConnectInfo);
        }
    }

    private void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, int i, byte[] bArr, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataChunkRecvCB] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataChunkRecvCB(spdySession, z, j, bArr, i2, i3);
        }
    }

    private void spdyDataRecvCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataRecvCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyDataSendCallback(SpdySession spdySession, boolean z, int i, int i2, int i3) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyDataSendCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyDataSendCallback(spdySession, z, j, i2, i3);
        }
    }

    private void spdyStreamCloseCallback(SpdySession spdySession, int i, int i2, int i3, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamCloseCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyStreamCloseCallback(spdySession, j, i2, i3, superviseData);
        }
    }

    private void spdyPingRecvCallback(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - ");
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyPingRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyPingRecvCallback(spdySession, j, obj);
        }
    }

    private void spdyRequestRecvCallback(SpdySession spdySession, int i, int i2) {
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyRequestRecvCallback] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyRequestRecvCallback(spdySession, j, i2);
        }
    }

    private void spdyStreamResponseRecv(SpdySession spdySession, int i, String[] strArr, int i2) {
        spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - ");
        Map<String, List<String>> mapStringArrayToMap = stringArrayToMap(strArr);
        long j = ((long) i) & 4294967295L;
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session is null");
        } else if (spdySession.intenalcb == null) {
            spduLog.Logi("tnet-jni", "[spdyStreamResponseRecv] - session.intenalcb is null");
        } else {
            spdySession.intenalcb.spdyOnStreamResponse(spdySession, j, mapStringArrayToMap, i2);
        }
    }

    private void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - errorCode = " + i);
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionCloseCallback] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
            }
        } finally {
            spdySession.cleanUp();
        }
    }

    private void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[spdySessionFailedError] - ");
        if (spdySession == null) {
            spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session is null");
            return;
        }
        try {
            if (spdySession.intenalcb == null) {
                spduLog.Logi("tnet-jni", "[spdySessionFailedError] - session.intenalcb is null");
            } else {
                spdySession.intenalcb.spdySessionFailedError(spdySession, i, obj);
            }
        } finally {
            spdySession.cleanUp();
        }
    }
}
