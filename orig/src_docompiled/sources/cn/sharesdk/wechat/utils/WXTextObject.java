package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;

/* JADX INFO: loaded from: classes.dex */
public class WXTextObject implements WXMediaMessage.IMediaObject {
    public String text;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 1;
    }

    public WXTextObject() {
        this(null);
    }

    public WXTextObject(String str) {
        this.text = str;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxtextobject_text", this.text);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.text = bundle.getString("_wxtextobject_text");
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if (this.text != null && this.text.length() != 0 && this.text.length() <= 10240) {
            return true;
        }
        C0851d.m6195a().m8609d("checkArgs fail, text is invalid", new Object[0]);
        return false;
    }
}
