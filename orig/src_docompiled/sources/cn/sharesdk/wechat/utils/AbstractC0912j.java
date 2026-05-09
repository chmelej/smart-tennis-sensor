package cn.sharesdk.wechat.utils;

import android.os.Bundle;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.j */
/* JADX INFO: compiled from: WechatReq.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0912j {

    /* JADX INFO: renamed from: c */
    public String f5951c;

    /* JADX INFO: renamed from: a */
    public abstract int mo6548a();

    /* JADX INFO: renamed from: b */
    public abstract boolean mo6550b();

    /* JADX INFO: renamed from: a */
    public void mo6549a(Bundle bundle) {
        bundle.putInt("_wxapi_command_type", mo6548a());
        bundle.putString("_wxapi_basereq_transaction", this.f5951c);
    }
}
