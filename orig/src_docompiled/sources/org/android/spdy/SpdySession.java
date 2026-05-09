package org.android.spdy;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes.dex */
public final class SpdySession {
    private static volatile int count;
    private SpdyAgent agent;
    private String authority;
    private Handler handler;
    SessionCb sessionCallBack;
    private volatile long sessionNativePtr;
    private NetSparseArray<SpdyStreamContext> spdyStream;
    private HandlerThread thread;
    private Object userData;
    private AtomicBoolean closed = new AtomicBoolean();
    private boolean sessionClearedFromSessionMgr = false;
    private Object lock = new Object();
    private int streamcount = 1;
    Intenalcb intenalcb = new C2005a();

    private native int sendHeadersN(long j, int i, String[] strArr, boolean z);

    private native int setOptionN(long j, int i, int i2);

    private native int streamCloseN(long j, int i, int i2);

    private native int streamSendDataN(long j, int i, byte[] bArr, int i2, int i3, boolean z);

    private native int submitPingN(long j);

    private native int submitRequestN(long j, String str, byte b, String[] strArr, byte[] bArr, boolean z, int i, int i2);

    SpdySession(long j, SpdyAgent spdyAgent, String str, SessionCb sessionCb, Object obj) {
        this.spdyStream = null;
        this.sessionCallBack = null;
        this.userData = null;
        this.sessionNativePtr = j;
        this.agent = spdyAgent;
        this.authority = str;
        this.spdyStream = new NetSparseArray<>(5);
        this.sessionCallBack = sessionCb;
        this.userData = obj;
        this.closed.set(false);
    }

    public String getAuthority() {
        return this.authority;
    }

    public Object getUserData() {
        return this.userData;
    }

    int putSpdyStreamCtx(SpdyStreamContext spdyStreamContext) {
        int i;
        synchronized (this.lock) {
            i = this.streamcount;
            this.streamcount = i + 1;
            this.spdyStream.put(i, spdyStreamContext);
        }
        return i;
    }

    SpdyStreamContext getSpdyStream(int i) {
        SpdyStreamContext spdyStreamContext;
        if (i <= 0) {
            return null;
        }
        synchronized (this.lock) {
            spdyStreamContext = this.spdyStream.get(i);
        }
        return spdyStreamContext;
    }

    void removeSpdyStream(int i) {
        if (i > 0) {
            synchronized (this.lock) {
                this.spdyStream.remove(i);
            }
        }
    }

    public SpdyStreamContext[] getAllStreamCb() {
        SpdyStreamContext[] spdyStreamContextArr;
        synchronized (this.lock) {
            int size = this.spdyStream.size();
            if (size > 0) {
                spdyStreamContextArr = new SpdyStreamContext[size];
                this.spdyStream.toArray(spdyStreamContextArr);
            } else {
                spdyStreamContextArr = null;
            }
        }
        return spdyStreamContextArr;
    }

    public void clearAllStreamCb() {
        spduLog.Logd("tnet-jni", "[SpdySession.clearAllStreamCb] - ");
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
    }

    SpdyAgent getSpdyAgent() {
        return this.agent;
    }

    Handler getMsgHandler() {
        return this.handler;
    }

    long getSessionNativePtr() {
        return this.sessionNativePtr;
    }

    void setSessionNativePtr(long j) {
        this.sessionNativePtr = j;
    }

    public int setOption(int i, int i2) {
        sessionIsOpen();
        int optionN = setOptionN(this.sessionNativePtr, i, i2);
        if (optionN == 0) {
            return optionN;
        }
        throw new SpdyErrorException("setOption error: " + optionN, optionN);
    }

    public int submitPing() {
        sessionIsOpen();
        int iSubmitPingN = submitPingN(this.sessionNativePtr);
        if (iSubmitPingN == 0) {
            return iSubmitPingN;
        }
        throw new SpdyErrorException("submitPing error: " + iSubmitPingN, iSubmitPingN);
    }

    public int streamReset(long j, int i) {
        sessionIsOpen();
        spduLog.Logd("tnet-jni", "[SpdySession.streamReset] - ");
        int iStreamCloseN = streamCloseN(this.sessionNativePtr, (int) j, i);
        if (iStreamCloseN == 0) {
            return iStreamCloseN;
        }
        throw new SpdyErrorException("streamReset error: " + iStreamCloseN, iStreamCloseN);
    }

    public int submitRequest(SpdyRequest spdyRequest, SpdyDataProvider spdyDataProvider, Object obj, Spdycb spdycb) {
        if (spdyRequest == null || obj == null || spdyRequest.getAuthority() == null) {
            throw new SpdyErrorException("submitRequest error: -1102", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        sessionIsOpen();
        byte[] bArrDataproviderToByteArray = SpdyAgent.dataproviderToByteArray(spdyRequest, spdyDataProvider);
        if (bArrDataproviderToByteArray != null && bArrDataproviderToByteArray.length <= 0) {
            bArrDataproviderToByteArray = null;
        }
        byte[] bArr = bArrDataproviderToByteArray;
        boolean z = spdyDataProvider != null ? spdyDataProvider.finished : true;
        if (!spdyRequest.getAuthority().equals(this.authority)) {
            throw new SpdyErrorException("submitPing error: -1102", TnetStatusCode.TNET_JNI_ERR_INVLID_PARAM);
        }
        int iPutSpdyStreamCtx = putSpdyStreamCtx(new SpdyStreamContext(obj, spdycb));
        String[] strArrMapToByteArray = SpdyAgent.mapToByteArray(spdyRequest.getHeaders());
        spduLog.Logi("tnet-jni", "index=" + iPutSpdyStreamCtx + "  starttime=" + System.currentTimeMillis());
        int iSubmitRequestN = submitRequestN(this.sessionNativePtr, spdyRequest.getUrlPath(), (byte) spdyRequest.getPriority(), strArrMapToByteArray, bArr, z, iPutSpdyStreamCtx, spdyRequest.getRequestTimeoutMs());
        spduLog.Logi("tnet-jni", "index=" + iPutSpdyStreamCtx + "   calltime=" + System.currentTimeMillis());
        if (iSubmitRequestN < 0) {
            removeSpdyStream(iPutSpdyStreamCtx);
        }
        if (iSubmitRequestN == 0) {
            return iSubmitRequestN;
        }
        throw new SpdyErrorException("submitRequest error: " + iSubmitRequestN, iSubmitRequestN);
    }

    void sessionIsOpen() {
        if (this.closed.get()) {
            throw new SpdyErrorException("session is already closed: -1104", TnetStatusCode.TNET_JNI_ERR_ASYNC_CLOSE);
        }
    }

    public int cleanUp() {
        spduLog.Logd("tnet-jni", "[SpdySession.cleanUp] - ");
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        this.agent.removeSession(this);
        return closeprivate();
    }

    int closeInternal() {
        if (this.closed.getAndSet(true)) {
            return 0;
        }
        return closeprivate();
    }

    public int closeSession() {
        int iCloseSession;
        spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - ");
        synchronized (this.lock) {
            if (this.sessionClearedFromSessionMgr) {
                iCloseSession = 0;
            } else {
                spduLog.Logd("tnet-jni", "[SpdySession.closeSession] - " + this.authority);
                this.agent.clearSpdySession(this.authority);
                this.sessionClearedFromSessionMgr = true;
                try {
                    iCloseSession = this.agent.closeSession(this.sessionNativePtr);
                } catch (UnsatisfiedLinkError e) {
                    e.printStackTrace();
                    iCloseSession = 0;
                }
            }
        }
        return iCloseSession;
    }

    private int closeprivate() {
        synchronized (this.lock) {
            if (!this.sessionClearedFromSessionMgr) {
                this.agent.clearSpdySession(this.authority);
                this.sessionClearedFromSessionMgr = true;
            }
        }
        this.sessionNativePtr = 0L;
        synchronized (this.lock) {
            this.spdyStream.clear();
        }
        return 0;
    }
}
