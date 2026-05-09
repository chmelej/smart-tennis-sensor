package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;

/* JADX INFO: loaded from: classes.dex */
public class WXVideoObject implements WXMediaMessage.IMediaObject {
    public String videoLowBandUrl;
    public String videoUrl;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 4;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxvideoobject_videoUrl", this.videoUrl);
        bundle.putString("_wxvideoobject_videoLowBandUrl", this.videoLowBandUrl);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.videoUrl = bundle.getString("_wxvideoobject_videoUrl");
        this.videoLowBandUrl = bundle.getString("_wxvideoobject_videoLowBandUrl");
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.videoUrl == null || this.videoUrl.length() == 0) && (this.videoLowBandUrl == null || this.videoLowBandUrl.length() == 0)) {
            C0851d.m6195a().m8609d("both arguments are null", new Object[0]);
            return false;
        }
        if (this.videoUrl != null && this.videoUrl.length() > 10240) {
            C0851d.m6195a().m8609d("checkArgs fail, videoUrl is too long", new Object[0]);
            return false;
        }
        if (this.videoLowBandUrl == null || this.videoLowBandUrl.length() <= 10240) {
            return true;
        }
        C0851d.m6195a().m8609d("checkArgs fail, videoLowBandUrl is too long", new Object[0]);
        return false;
    }
}
