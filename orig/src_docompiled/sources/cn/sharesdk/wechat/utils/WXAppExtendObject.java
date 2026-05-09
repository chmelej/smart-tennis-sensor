package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class WXAppExtendObject implements WXMediaMessage.IMediaObject {
    public String extInfo;
    public byte[] fileData;
    public String filePath;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 7;
    }

    public WXAppExtendObject() {
    }

    public WXAppExtendObject(String str, byte[] bArr) {
        this.extInfo = str;
        this.fileData = bArr;
    }

    public WXAppExtendObject(String str, String str2) {
        this.extInfo = str;
        this.filePath = str2;
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putString("_wxappextendobject_extInfo", this.extInfo);
        bundle.putByteArray("_wxappextendobject_fileData", this.fileData);
        bundle.putString("_wxappextendobject_filePath", this.filePath);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.extInfo = bundle.getString("_wxappextendobject_extInfo");
        this.fileData = bundle.getByteArray("_wxappextendobject_fileData");
        this.filePath = bundle.getString("_wxappextendobject_filePath");
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.extInfo == null || this.extInfo.length() == 0) && ((this.filePath == null || this.filePath.length() == 0) && (this.fileData == null || this.fileData.length == 0))) {
            C0851d.m6195a().m8609d("checkArgs fail, all arguments is null", new Object[0]);
            return false;
        }
        if (this.extInfo != null && this.extInfo.length() > 2048) {
            C0851d.m6195a().m8609d("checkArgs fail, extInfo is invalid", new Object[0]);
            return false;
        }
        if (this.filePath != null && this.filePath.length() > 10240) {
            C0851d.m6195a().m8609d("checkArgs fail, filePath is invalid", new Object[0]);
            return false;
        }
        if (this.filePath != null && new File(this.filePath).length() > 10485760) {
            C0851d.m6195a().m8609d("checkArgs fail, fileSize is too large", new Object[0]);
            return false;
        }
        if (this.fileData == null || this.fileData.length <= 10485760) {
            return true;
        }
        C0851d.m6195a().m8609d("checkArgs fail, fileData is too large", new Object[0]);
        return false;
    }
}
