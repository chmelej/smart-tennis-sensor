package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.b */
/* JADX INFO: compiled from: AuthResp.java */
/* JADX INFO: loaded from: classes.dex */
public class C0904b extends WechatResp {

    /* JADX INFO: renamed from: a */
    public String f5925a;

    /* JADX INFO: renamed from: b */
    public String f5926b;

    /* JADX INFO: renamed from: c */
    public int f5927c;

    /* JADX INFO: renamed from: d */
    public String f5928d;

    /* JADX INFO: renamed from: e */
    public String f5929e;

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* JADX INFO: renamed from: a */
    public int mo6545a() {
        return 1;
    }

    public C0904b(Bundle bundle) {
        super(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* JADX INFO: renamed from: a */
    public void mo6546a(Bundle bundle) {
        super.mo6546a(bundle);
        this.f5925a = bundle.getString("_wxapi_sendauth_resp_userName");
        this.f5926b = bundle.getString("_wxapi_sendauth_resp_token");
        this.f5927c = bundle.getInt("_wxapi_sendauth_resp_expireDate", 0);
        this.f5928d = bundle.getString("_wxapi_sendauth_resp_state");
        this.f5929e = bundle.getString("_wxapi_sendauth_resp_url");
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* JADX INFO: renamed from: b */
    public void mo6547b(Bundle bundle) {
        super.mo6547b(bundle);
        bundle.putString("_wxapi_sendauth_resp_userName", this.f5925a);
        bundle.putString("_wxapi_sendauth_resp_token", this.f5926b);
        bundle.putInt("_wxapi_sendauth_resp_expireDate", this.f5927c);
        bundle.putString("_wxapi_sendauth_resp_state", this.f5928d);
        bundle.putString("_wxapi_sendauth_resp_url", this.f5929e);
    }
}
