package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.support.v4.view.PointerIconCompat;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.d */
/* JADX INFO: compiled from: SendMessageReq.java */
/* JADX INFO: loaded from: classes.dex */
public class C0906d extends AbstractC0912j {

    /* JADX INFO: renamed from: a */
    public WXMediaMessage f5931a;

    /* JADX INFO: renamed from: b */
    public int f5932b;

    @Override // cn.sharesdk.wechat.utils.AbstractC0912j
    /* JADX INFO: renamed from: a */
    public int mo6548a() {
        return 2;
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0912j
    /* JADX INFO: renamed from: a */
    public void mo6549a(Bundle bundle) {
        super.mo6549a(bundle);
        bundle.putAll(WXMediaMessage.C0901a.m6513a(this.f5931a));
        bundle.putInt("_wxapi_sendmessagetowx_req_scene", this.f5932b);
    }

    @Override // cn.sharesdk.wechat.utils.AbstractC0912j
    /* JADX INFO: renamed from: b */
    public boolean mo6550b() {
        if (this.f5931a.getType() == 8 && (this.f5931a.thumbData == null || this.f5931a.thumbData.length <= 0)) {
            C0851d.m6195a().m8609d("checkArgs fail, thumbData should not be null when send emoji", new Object[0]);
            return false;
        }
        if (this.f5931a.thumbData != null && this.f5931a.thumbData.length > 32768) {
            C0851d.m6195a().m8609d("checkArgs fail, thumbData is invalid", new Object[0]);
            return false;
        }
        if (this.f5931a.title != null && this.f5931a.title.length() > 512) {
            C0851d.m6195a().m8609d("checkArgs fail, title is invalid", new Object[0]);
            return false;
        }
        if (this.f5931a.description != null && this.f5931a.description.length() > 1024) {
            this.f5931a.description = this.f5931a.description.substring(0, PointerIconCompat.TYPE_GRABBING) + "...";
        }
        if (this.f5931a.mediaObject == null) {
            C0851d.m6195a().m8609d("checkArgs fail, mediaObject is null", new Object[0]);
            return false;
        }
        return this.f5931a.mediaObject.checkArgs();
    }
}
