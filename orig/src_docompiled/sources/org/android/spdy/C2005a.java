package org.android.spdy;

import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: org.android.spdy.a */
/* JADX INFO: compiled from: SpdySessionCallBack.java */
/* JADX INFO: loaded from: classes.dex */
final class C2005a implements Intenalcb {
    C2005a() {
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, byte[] bArr, int i, int i2) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataChunkRecvCB] - " + spdySession);
        long jBegin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && spdyStream.callBack != null) {
            spdyStream.callBack.spdyDataChunkRecvCB(spdySession, z, j, bArr, i, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataChunkRecvCB] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyDataChunkRecvCB", 3, jBegin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, int i2) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataRecvCallback] - " + spdySession);
        long jBegin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && spdyStream.callBack != null) {
            spdyStream.callBack.spdyDataRecvCallback(spdySession, z, j, i, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyDataRecvCallback", 3, jBegin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, int i2) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyDataSendCallback] - ");
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && spdyStream.callBack != null) {
            spdyStream.callBack.spdyDataSendCallback(spdySession, z, j, i, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyDataSendCallback] - no sessionCallBack.");
        }
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, int i2, SuperviseData superviseData) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] - " + spdySession);
        long jBegin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i2);
        if (spdyStream != null && spdyStream.callBack != null) {
            spduLog.Logi("tnet-jni", "index=" + i2 + "    endtime=" + System.currentTimeMillis());
            spdyStream.callBack.spdyStreamCloseCallback(spdySession, j, i, spdyStream.streamContext, superviseData);
            spdySession.removeSpdyStream(i2);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyStreamCloseCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyStreamCloseCallback", 3, jBegin);
        NetTimeGaurd.finish(3);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyRequestRecvCallback(SpdySession spdySession, long j, int i) {
        spduLog.Logd("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - " + spdySession);
        long jBegin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i);
        if (spdyStream != null && spdyStream.callBack != null) {
            spdyStream.callBack.spdyRequestRecvCallback(spdySession, j, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyRequestRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyPingRecvCallback", 3, jBegin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, int i) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - " + spdySession);
        NetTimeGaurd.start(3);
        long jBegin = NetTimeGaurd.begin();
        SpdyStreamContext spdyStream = spdySession.getSpdyStream(i);
        if (spdyStream != null && spdyStream.callBack != null) {
            spdyStream.callBack.spdyOnStreamResponse(spdySession, j, map, spdyStream.streamContext);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyOnStreamResponse] - no sessionCallBack.");
        }
        NetTimeGaurd.end("spdyOnStreamResponse", 3, jBegin);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionConnectCB] - " + spdySession);
        NetTimeGaurd.start(0);
        if (spdySession.sessionCallBack != null) {
            long jBegin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdySessionConnectCB(spdySession, superviseConnectInfo);
            NetTimeGaurd.end("spdySessionConnectCB", 0, jBegin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionConnectCB] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(0);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdyPingRecvCallback] - " + spdySession);
        NetTimeGaurd.start(1);
        if (spdySession.sessionCallBack != null) {
            long jBegin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdyPingRecvCallback(spdySession, j, obj);
            NetTimeGaurd.end("spdyPingRecvCallback", 1, jBegin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdyPingRecvCallback] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(1);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionFailedError(SpdySession spdySession, int i, Object obj) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionFailedError] - " + spdySession);
        NetTimeGaurd.start(2);
        if (spdySession.sessionCallBack != null) {
            long jBegin = NetTimeGaurd.begin();
            spdySession.sessionCallBack.spdySessionFailedError(spdySession, i, obj);
            spdySession.clearAllStreamCb();
            NetTimeGaurd.end("spdySessionFailedError", 2, jBegin);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionFailedError] - no sessionCallBack.");
        }
        NetTimeGaurd.finish(2);
    }

    @Override // org.android.spdy.Intenalcb
    public void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i) {
        spduLog.Logi("tnet-jni", "[SpdySessionCallBack.spdySessionCloseCallback] - " + spdySession);
        if (spdySession.sessionCallBack != null) {
            spdySession.sessionCallBack.spdySessionCloseCallback(spdySession, obj, superviseConnectInfo, i);
        } else {
            spduLog.Loge("tnet-jni", "[SpdySessionCallBack.spdySessionCloseCallback] - no sessionCallBack.");
        }
    }
}
