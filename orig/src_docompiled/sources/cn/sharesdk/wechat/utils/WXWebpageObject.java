package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;

/* JADX INFO: loaded from: classes.dex */
public class WXWebpageObject implements WXMediaMessage.IMediaObject {
    public String webpageUrl;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 5;
    }

    public WXWebpageObject() {
    }

    public WXWebpageObject(String str) {
        this.webpageUrl = str;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxwebpageobject_webpageUrl", this.webpageUrl);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.webpageUrl = bundle.getString("_wxwebpageobject_webpageUrl");
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (this.webpageUrl != null && this.webpageUrl.length() != 0 && this.webpageUrl.length() <= 10240) {
            return true;
        }
        C0851d.m6195a().m8609d("checkArgs fail, webpageUrl is invalid", new Object[0]);
        return false;
    }
}
