package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.wechat.utils.WXMediaMessage;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.f */
/* JADX INFO: compiled from: ShowMessageFromWechatResp.java */
/* JADX INFO: loaded from: classes.dex */
public class C0908f extends WechatResp {

    /* JADX INFO: renamed from: a */
    public WXMediaMessage f5933a;

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* JADX INFO: renamed from: a */
    public int mo6545a() {
        return 4;
    }

    public C0908f(Bundle bundle) {
        super(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* JADX INFO: renamed from: a */
    public void mo6546a(Bundle bundle) {
        super.mo6546a(bundle);
        this.f5933a = WXMediaMessage.C0901a.m6514a(bundle);
    }

    @Override // cn.sharesdk.wechat.utils.WechatResp
    /* JADX INFO: renamed from: b */
    public void mo6547b(Bundle bundle) {
        super.mo6547b(bundle);
        bundle.putAll(WXMediaMessage.C0901a.m6513a(this.f5933a));
    }
}
