package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class WXImageObject implements WXMediaMessage.IMediaObject {
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public int type() {
        return 2;
    }

    public WXImageObject() {
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            C0851d.m6195a().m8610d(e);
        }
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        bundle.putString("_wximageobject_imageUrl", this.imageUrl);
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        this.imageUrl = bundle.getString("_wximageobject_imageUrl");
    }

    @Override // cn.sharesdk.wechat.utils.WXMediaMessage.IMediaObject
    public boolean checkArgs() {
        if ((this.imageData == null || this.imageData.length == 0) && ((this.imagePath == null || this.imagePath.length() == 0) && (this.imageUrl == null || this.imageUrl.length() == 0))) {
            C0851d.m6195a().m8609d("checkArgs fail, all arguments are null", new Object[0]);
            return false;
        }
        if (this.imageData != null && this.imageData.length > 10485760) {
            C0851d.m6195a().m8609d("checkArgs fail, content is too large", new Object[0]);
            return false;
        }
        if (this.imagePath != null && this.imagePath.length() > 10240) {
            C0851d.m6195a().m8609d("checkArgs fail, path is invalid", new Object[0]);
            return false;
        }
        if (this.imagePath != null && new File(this.imagePath).length() > 10485760) {
            C0851d.m6195a().m8609d("checkArgs fail, image content is too large", new Object[0]);
            return false;
        }
        if (this.imageUrl == null || this.imageUrl.length() <= 10240) {
            return true;
        }
        C0851d.m6195a().m8609d("checkArgs fail, url is invalid", new Object[0]);
        return false;
    }
}
