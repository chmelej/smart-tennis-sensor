package p000;

import org.android.spdy.TnetStatusCode;

/* JADX INFO: compiled from: ChannelError.java */
/* JADX INFO: loaded from: classes.dex */
public enum aql {
    SPDY_CONNECT_THROWABLE(-1200),
    SPDY_STREAM_RESPONSE_THROWABLE(-1201),
    SPDY_DATACHUNK_THROWABLE(1202),
    SPDY_SESSION_ERROR(-1204),
    SPDY_PING_THROWABLE(-1205),
    SPDY_INIT_THROWABLE(1206, EnumC0725a.FORCE_CHUNKED),
    SPDY_INIT_NOT_FOUND_SO(1207, EnumC0725a.FORCE_CHUNKED),
    SPDY_SEND_THROWABLE(-1208),
    SPDY_DEFAULT_ERROR(-2000, EnumC0725a.RECONNECT_REFRESH_HOST),
    SPDY_CONNECT_ERROR(TnetStatusCode.EASY_REASON_CONN_NOT_EXISTS, EnumC0725a.RECONNECT_REFRESH_HOST),
    SPDY_DISCONNECT(TnetStatusCode.EASY_REASON_DISCONNECT, EnumC0725a.RECONNECT_REFRESH_HOST),
    SPDY_IO_ERROR(TnetStatusCode.EASY_REASON_IO_STOPED, EnumC0725a.SPDY_RELOAD),
    SPDY_NO_MEM(TnetStatusCode.EASY_REASON_NO_MEM, EnumC0725a.SPDY_RELOAD),
    CHUNKED_INIT_THROWABLE(1209, EnumC0725a.FORCE_CHUNKED),
    HTTP_MOVED_TEMP(302, EnumC0725a.PAUSE),
    HTTP_TEMPORARY_REDIRECT(307, EnumC0725a.RECONNECT_REFRESH_HOST),
    HTTP_NOT_FOUND(404, EnumC0725a.RECONNECT_REFRESH_HOST),
    HTTP_CONNECT_TIMEOUT(408, EnumC0725a.RECONNECT_REFRESH_HOST),
    HTTP_GATEWAY_TIMEOUT(504, EnumC0725a.RECONNECT_REFRESH_HOST),
    X_TOKEN_ERROR(400, EnumC0725a.RECONNECT_CLEAR_X_TOKEN),
    REQUEST_URL_TOO_LONG(402, EnumC0725a.UNNECESSARY),
    SIGN_FAILED(403, EnumC0725a.DISABLE),
    SPDY_STREAM_UNNECESSARY(405, EnumC0725a.UNNECESSARY),
    DNS_REQUEST_FAILED(5040, EnumC0725a.RECONNECT_REFRESH_HOST),
    DNS_PARSE_FAILED(5041, EnumC0725a.RECONNECT_REFRESH_HOST),
    DNS_NOT_FOUND(5042, EnumC0725a.RECONNECT_REFRESH_HOST);


    /* JADX INFO: renamed from: A */
    private int f4684A;

    /* JADX INFO: renamed from: B */
    private EnumC0725a f4685B;

    /* JADX INFO: renamed from: aql$a */
    /* JADX INFO: compiled from: ChannelError.java */
    public enum EnumC0725a {
        UNNECESSARY,
        RECONNECT,
        RECONNECT_CLEAR_X_TOKEN,
        RECONNECT_REFRESH_HOST,
        SPDY_RELOAD,
        FORCE_CHUNKED,
        PAUSE,
        DISABLE
    }

    aql(int i, EnumC0725a enumC0725a) {
        this.f4684A = i;
        this.f4685B = enumC0725a;
    }

    aql(int i) {
        this(i, EnumC0725a.RECONNECT);
    }

    /* JADX INFO: renamed from: a */
    public EnumC0725a m5027a() {
        return this.f4685B;
    }

    /* JADX INFO: renamed from: b */
    public int m5028b() {
        return this.f4684A;
    }

    /* JADX INFO: renamed from: a */
    public static aql m5025a(int i) {
        if (i == -2500) {
            return SPDY_CONNECT_ERROR;
        }
        if (i != -2002) {
            switch (i) {
                case TnetStatusCode.EASY_REASON_NO_MEM /* -2031 */:
                    return SPDY_NO_MEM;
                case TnetStatusCode.EASY_REASON_IO_STOPED /* -2030 */:
                    return SPDY_IO_ERROR;
                default:
                    return SPDY_DEFAULT_ERROR;
            }
        }
        return SPDY_DISCONNECT;
    }

    /* JADX INFO: renamed from: b */
    public static aql m5026b(int i) {
        if (i == 307) {
            return HTTP_TEMPORARY_REDIRECT;
        }
        if (i == 400) {
            return X_TOKEN_ERROR;
        }
        if (i != 408) {
            switch (i) {
                case 403:
                    return SIGN_FAILED;
                case 404:
                    return HTTP_NOT_FOUND;
                case 405:
                    return SPDY_STREAM_UNNECESSARY;
                default:
                    return HTTP_GATEWAY_TIMEOUT;
            }
        }
        return HTTP_CONNECT_TIMEOUT;
    }
}
