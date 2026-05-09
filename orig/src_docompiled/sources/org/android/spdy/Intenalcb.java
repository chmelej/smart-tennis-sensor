package org.android.spdy;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public interface Intenalcb {
    void spdyDataChunkRecvCB(SpdySession spdySession, boolean z, long j, byte[] bArr, int i, int i2);

    void spdyDataRecvCallback(SpdySession spdySession, boolean z, long j, int i, int i2);

    void spdyDataSendCallback(SpdySession spdySession, boolean z, long j, int i, int i2);

    void spdyOnStreamResponse(SpdySession spdySession, long j, Map<String, List<String>> map, int i);

    void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj);

    void spdyRequestRecvCallback(SpdySession spdySession, long j, int i);

    void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i);

    void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo);

    void spdySessionFailedError(SpdySession spdySession, int i, Object obj);

    void spdyStreamCloseCallback(SpdySession spdySession, long j, int i, int i2, SuperviseData superviseData);
}
