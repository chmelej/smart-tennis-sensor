package org.android.spdy;

/* JADX INFO: loaded from: classes.dex */
public interface SessionCb {
    void spdyPingRecvCallback(SpdySession spdySession, long j, Object obj);

    void spdySessionCloseCallback(SpdySession spdySession, Object obj, SuperviseConnectInfo superviseConnectInfo, int i);

    void spdySessionConnectCB(SpdySession spdySession, SuperviseConnectInfo superviseConnectInfo);

    void spdySessionFailedError(SpdySession spdySession, int i, Object obj);
}
