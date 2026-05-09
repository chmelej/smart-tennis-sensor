package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class WXEmojiObject implements WXMediaMessage.IMediaObject {
    public byte[] emojiData;
    public String emojiPath;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 8;
    }

    public WXEmojiObject() {
    }

    public WXEmojiObject(byte[] bArr) {
        this.emojiData = bArr;
    }

    public WXEmojiObject(String str) {
        this.emojiPath = str;
    }

    public void setEmojiData(byte[] bArr) {
        this.emojiData = bArr;
    }

    public void setEmojiPath(String str) {
        this.emojiPath = str;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wxemojiobject_emojiData", this.emojiData);
        bundle.putString("_wxemojiobject_emojiPath", this.emojiPath);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.emojiData = bundle.getByteArray("_wxemojiobject_emojiData");
        this.emojiPath = bundle.getString("_wxemojiobject_emojiPath");
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.emojiData == null || this.emojiData.length == 0) && TextUtils.isEmpty(this.emojiPath)) {
            C0851d.m6195a().m8609d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, both arguments is null");
            return false;
        }
        if (this.emojiData != null && this.emojiData.length > 10485760) {
            C0851d.m6195a().m8609d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiData is too large");
            return false;
        }
        if (this.emojiPath != null) {
            File file = new File(this.emojiPath);
            if (!file.exists()) {
                C0851d.m6195a().m8609d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiPath not found");
                return false;
            }
            if (file.length() > 10485760) {
                C0851d.m6195a().m8609d("MicroMsg.SDK.WXEmojiObject", "checkArgs fail, emojiSize is too large");
                return false;
            }
        }
        return true;
    }
}
