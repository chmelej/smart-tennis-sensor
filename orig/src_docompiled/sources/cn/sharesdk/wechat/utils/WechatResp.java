package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public abstract class WechatResp {

    /* JADX INFO: renamed from: f */
    public int f5920f;

    /* JADX INFO: renamed from: g */
    public String f5921g;

    /* JADX INFO: renamed from: h */
    public String f5922h;

    public interface ErrCode {
        public static final int ERR_AUTH_DENIED = -4;
        public static final int ERR_COMM = -1;
        public static final int ERR_OK = 0;
        public static final int ERR_SENT_FAILED = -3;
        public static final int ERR_UNSUPPORT = -5;
        public static final int ERR_USER_CANCEL = -2;
    }

    /* JADX INFO: renamed from: a */
    public abstract int mo6545a();

    public WechatResp(Bundle bundle) {
        mo6546a(bundle);
    }

    /* JADX INFO: renamed from: b */
    public void mo6547b(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", mo6545a());
        bundle.putInt("_wxapi_baseresp_errcode", this.f5920f);
        bundle.putString("_wxapi_baseresp_errstr", this.f5921g);
        bundle.putString("_wxapi_baseresp_transaction", this.f5922h);
    }

    /* JADX INFO: renamed from: a */
    public void mo6546a(Bundle bundle) {
        this.f5920f = bundle.getInt("_wxapi_baseresp_errcode");
        this.f5921g = bundle.getString("_wxapi_baseresp_errstr");
        this.f5922h = bundle.getString("_wxapi_baseresp_transaction");
    }
}
