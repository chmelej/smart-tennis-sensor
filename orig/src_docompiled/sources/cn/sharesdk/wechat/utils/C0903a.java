package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.a */
/* JADX INFO: compiled from: AuthReq.java */
/* JADX INFO: loaded from: classes.dex */
public class C0903a extends AbstractC0912j {

    /* JADX INFO: renamed from: a */
    public String f5923a;

    /* JADX INFO: renamed from: b */
    public String f5924b;

    @Override // cn.sharesdk.wechat.utils.AbstractC0912j
    /* JADX INFO: renamed from: a */
    public int mo6548a() {
        return 1;
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0912j
    /* JADX INFO: renamed from: a */
    public void mo6549a(Bundle bundle) {
        super.mo6549a(bundle);
        bundle.putString("_wxapi_sendauth_req_scope", this.f5923a);
        bundle.putString("_wxapi_sendauth_req_state", this.f5924b);
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0912j
    /* JADX INFO: renamed from: b */
    public boolean mo6550b() {
        if (this.f5923a == null || this.f5923a.length() == 0 || this.f5923a.length() > 1024) {
            C0851d.m6195a().m8609d("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, scope is invalid");
            return false;
        }
        if (this.f5924b == null || this.f5924b.length() <= 1024) {
            return true;
        }
        C0851d.m6195a().m8609d("MicroMsg.SDK.SendAuth.Req", "checkArgs fail, state is invalid");
        return false;
    }
}
