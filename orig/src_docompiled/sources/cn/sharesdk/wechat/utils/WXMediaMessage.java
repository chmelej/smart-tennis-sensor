package cn.sharesdk.wechat.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;
import java.io.ByteArrayOutputStream;

/* JADX INFO: loaded from: classes.dex */
public final class WXMediaMessage {
    public static final String ACTION_WXAPPMESSAGE = "com.tencent.mm.sdk.openapi.Intent.ACTION_WXAPPMESSAGE";
    public String description;
    public IMediaObject mediaObject;
    public int sdkVer;
    public byte[] thumbData;
    public String title;

    public interface IMediaObject {
        public static final int TYPE_APPDATA = 7;
        public static final int TYPE_EMOJI = 8;
        public static final int TYPE_FILE = 6;
        public static final int TYPE_IMAGE = 2;
        public static final int TYPE_MUSIC = 3;
        public static final int TYPE_TEXT = 1;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_URL = 5;
        public static final int TYPE_VIDEO = 4;

        boolean checkArgs();

        void serialize(Bundle bundle);

        int type();

        void unserialize(Bundle bundle);
    }

    public WXMediaMessage() {
        this(null);
    }

    public WXMediaMessage(IMediaObject iMediaObject) {
        this.mediaObject = iMediaObject;
    }

    public final int getType() {
        if (this.mediaObject == null) {
            return 0;
        }
        return this.mediaObject.type();
    }

    public final void setThumbImage(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.thumbData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e) {
            C0851d.m6195a().m8610d(e);
            C0851d.m6195a().m8609d("put thumb failed", new Object[0]);
        }
    }

    /* JADX INFO: renamed from: cn.sharesdk.wechat.utils.WXMediaMessage$a */
    public static class C0901a {
        /* JADX INFO: renamed from: a */
        public static Bundle m6513a(WXMediaMessage wXMediaMessage) {
            Bundle bundle = new Bundle();
            bundle.putInt("_wxobject_sdkVer", wXMediaMessage.sdkVer);
            bundle.putString("_wxobject_title", wXMediaMessage.title);
            bundle.putString("_wxobject_description", wXMediaMessage.description);
            bundle.putByteArray("_wxobject_thumbdata", wXMediaMessage.thumbData);
            if (wXMediaMessage.mediaObject != null) {
                bundle.putString("_wxobject_identifier_", "com.tencent.mm.sdk.openapi." + wXMediaMessage.mediaObject.getClass().getSimpleName());
                wXMediaMessage.mediaObject.serialize(bundle);
            }
            return bundle;
        }

        /* JADX INFO: renamed from: a */
        public static WXMediaMessage m6514a(Bundle bundle) {
            String strReplace;
            WXMediaMessage wXMediaMessage = new WXMediaMessage();
            wXMediaMessage.sdkVer = bundle.getInt("_wxobject_sdkVer");
            wXMediaMessage.title = bundle.getString("_wxobject_title");
            wXMediaMessage.description = bundle.getString("_wxobject_description");
            wXMediaMessage.thumbData = bundle.getByteArray("_wxobject_thumbdata");
            String string = bundle.getString("_wxobject_identifier_");
            if (string == null || string.length() <= 0) {
                return wXMediaMessage;
            }
            try {
                strReplace = string.replace("com.tencent.mm.sdk.openapi", "cn.sharesdk.wechat.utils");
            } catch (Exception e) {
                e = e;
                strReplace = string;
            }
            try {
                wXMediaMessage.mediaObject = (IMediaObject) Class.forName(strReplace).newInstance();
                wXMediaMessage.mediaObject.unserialize(bundle);
                return wXMediaMessage;
            } catch (Exception e2) {
                e = e2;
                C0851d.m6195a().m8610d(e);
                C0851d.m6195a().m8609d("get media object from bundle failed: unknown ident " + strReplace, new Object[0]);
                return wXMediaMessage;
            }
        }
    }
}
