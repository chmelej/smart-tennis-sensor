package org.android.spdy;

/* JADX INFO: loaded from: classes.dex */
public class SpdyStreamContext {
    public Spdycb callBack;
    public Object streamContext;

    SpdyStreamContext(Object obj) {
        this.streamContext = obj;
        this.callBack = null;
    }

    SpdyStreamContext(Object obj, Spdycb spdycb) {
        this.streamContext = obj;
        this.callBack = spdycb;
    }

    static int getContext(Object obj) {
        if (obj == null || !(obj instanceof Integer)) {
            return 0;
        }
        return ((Integer) obj).intValue();
    }
}
