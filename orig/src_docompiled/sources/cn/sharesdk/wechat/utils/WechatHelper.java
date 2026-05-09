package cn.sharesdk.wechat.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class WechatHelper {

    /* JADX INFO: renamed from: a */
    private static boolean f5909a = false;

    /* JADX INFO: renamed from: b */
    private static WechatHelper f5910b;

    /* JADX INFO: renamed from: c */
    private C0910h f5911c = new C0910h();

    /* JADX INFO: renamed from: d */
    private C0911i f5912d;

    public static class ShareParams extends Platform.ShareParams {

        @Deprecated
        public String extInfo;

        @Deprecated
        public String filePath;

        @Deprecated
        public Bitmap imageData;

        @Deprecated
        public String imageUrl;

        @Deprecated
        public String musicUrl;

        @Deprecated
        protected int scene;

        @Deprecated
        public int shareType;

        @Deprecated
        public String title;

        @Deprecated
        public String url;
    }

    /* JADX INFO: renamed from: a */
    public static WechatHelper m6516a() {
        if (f5910b == null) {
            f5910b = new WechatHelper();
        }
        return f5910b;
    }

    private WechatHelper() {
    }

    /* JADX INFO: renamed from: a */
    public void m6537a(C0911i c0911i) {
        this.f5912d = c0911i;
        C0903a c0903a = new C0903a();
        c0903a.f5923a = "snsapi_userinfo";
        c0903a.f5924b = "sharesdk_wechat_auth";
        this.f5911c.m6567a(c0903a);
    }

    /* JADX INFO: renamed from: b */
    public boolean m6542b() {
        return this.f5911c.m6568a();
    }

    /* JADX INFO: renamed from: a */
    public void m6538a(C0911i c0911i, Platform.ShareParams shareParams, final PlatformActionListener platformActionListener) throws Throwable {
        final Platform platformM6578b = c0911i.m6578b();
        String imagePath = shareParams.getImagePath();
        String imageUrl = shareParams.getImageUrl();
        if (TextUtils.isEmpty(imagePath) || !new File(imagePath).exists()) {
            Bitmap imageData = shareParams.getImageData();
            if (imageData != null && !imageData.isRecycled()) {
                File file = new File(ResHelper.getCachePath(platformM6578b.getContext(), "images"), System.currentTimeMillis() + ".png");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                imageData.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                imagePath = file.getAbsolutePath();
            } else if (!TextUtils.isEmpty(imageUrl)) {
                imagePath = BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl);
            }
        }
        Intent intent = new Intent("android.intent.action.SEND");
        String text = shareParams.getText();
        if (!TextUtils.isEmpty(text)) {
            String shortLintk = platformM6578b.getShortLintk(text, false);
            shareParams.setText(shortLintk);
            intent.putExtra("android.intent.extra.TEXT", shortLintk);
            intent.putExtra("Kdescription", shortLintk);
        }
        if (!TextUtils.isEmpty(imagePath)) {
            File file2 = new File(imagePath);
            if (file2.exists()) {
                if (imagePath.startsWith("/data/")) {
                    File file3 = new File(ResHelper.getCachePath(platformM6578b.getContext(), "images"), System.currentTimeMillis() + file2.getName());
                    String absolutePath = file3.getAbsolutePath();
                    file3.createNewFile();
                    if (ResHelper.copyFile(imagePath, absolutePath)) {
                        file2 = file3;
                    }
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    intent.putExtra("android.intent.extra.STREAM", ResHelper.pathToContentUri(platformM6578b.getContext(), file2.getAbsolutePath()));
                } else {
                    intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file2));
                }
                String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(imagePath);
                if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                    contentTypeFor = "image/*";
                }
                intent.setType(contentTypeFor);
            }
        } else {
            intent.setType("text/plain");
        }
        intent.setClassName("com.tencent.mm", ((Integer) shareParams.get("scene", Integer.class)).intValue() == 1 ? "com.tencent.mm.ui.tools.ShareToTimeLineUI" : "com.tencent.mm.ui.tools.ShareImgUI");
        intent.addFlags(268435456);
        platformM6578b.getContext().startActivity(intent);
        final DeviceHelper deviceHelper = DeviceHelper.getInstance(platformM6578b.getContext());
        final String packageName = platformM6578b.getContext().getPackageName();
        final HashMap<String, Object> map = new HashMap<>();
        map.put("ShareParams", shareParams);
        if (!TextUtils.isEmpty(deviceHelper.getTopTaskPackageName())) {
            UIHandler.sendEmptyMessageDelayed(0, 2000L, new Handler.Callback() { // from class: cn.sharesdk.wechat.utils.WechatHelper.1

                /* JADX INFO: renamed from: a */
                int f5913a = 0;

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (!packageName.equals(deviceHelper.getTopTaskPackageName())) {
                        if (platformActionListener != null) {
                            platformActionListener.onComplete(platformM6578b, 9, map);
                        }
                    } else if (this.f5913a < 5) {
                        this.f5913a++;
                        UIHandler.sendEmptyMessageDelayed(0, 500L, this);
                    }
                    return true;
                }
            });
        } else {
            if (platformActionListener == null || platformActionListener == null) {
                return;
            }
            platformActionListener.onComplete(platformM6578b, 9, map);
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6541b(C0911i c0911i) throws Throwable {
        Platform platformM6578b = c0911i.m6578b();
        Platform.ShareParams shareParamsM6573a = c0911i.m6573a();
        PlatformActionListener platformActionListenerM6579c = c0911i.m6579c();
        int shareType = shareParamsM6573a.getShareType();
        String title = shareParamsM6573a.getTitle();
        String text = shareParamsM6573a.getText();
        int scence = shareParamsM6573a.getScence();
        String imagePath = shareParamsM6573a.getImagePath();
        String imageUrl = shareParamsM6573a.getImageUrl();
        Bitmap imageData = shareParamsM6573a.getImageData();
        String musicUrl = shareParamsM6573a.getMusicUrl();
        String url = shareParamsM6573a.getUrl();
        String filePath = shareParamsM6573a.getFilePath();
        String extInfo = shareParamsM6573a.getExtInfo();
        Context context = platformM6578b.getContext();
        switch (shareType) {
            case 1:
                m6524a(title, text, scence, c0911i);
                return;
            case 2:
                if (imagePath != null && imagePath.length() > 0) {
                    m6518a(context, title, text, imagePath, scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6517a(context, title, text, imageData, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6518a(context, title, text, BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl), scence, c0911i);
                } else {
                    m6518a(context, title, text, "", scence, c0911i);
                }
                break;
            case 3:
            default:
                if (platformActionListenerM6579c != null) {
                    platformActionListenerM6579c.onError(platformM6578b, 9, new IllegalArgumentException("shareType = " + shareType));
                    return;
                }
                return;
            case 4:
                String shortLintk = platformM6578b.getShortLintk(url, false);
                c0911i.m6573a().setUrl(shortLintk);
                if (imagePath != null && imagePath.length() > 0) {
                    m6531b(context, title, text, shortLintk, imagePath, scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6530b(context, title, text, shortLintk, imageData, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6531b(context, title, text, shortLintk, BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl), scence, c0911i);
                } else {
                    m6531b(context, title, text, shortLintk, "", scence, c0911i);
                }
                break;
            case 5:
                String shortLintk2 = platformM6578b.getShortLintk(musicUrl + " " + url, false);
                String str = shortLintk2.split(" ")[0];
                String str2 = shortLintk2.split(" ")[1];
                if (imagePath != null && imagePath.length() > 0) {
                    m6522a(context, title, text, str, str2, imagePath, scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6521a(context, title, text, str, str2, imageData, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6522a(context, title, text, str, str2, BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl), scence, c0911i);
                } else {
                    m6522a(context, title, text, str, str2, "", scence, c0911i);
                }
                break;
            case 6:
                String shortLintk3 = platformM6578b.getShortLintk(url, false);
                c0911i.m6573a().setUrl(shortLintk3);
                if (imagePath != null && imagePath.length() > 0) {
                    m6520a(context, title, text, shortLintk3, imagePath, scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6519a(context, title, text, shortLintk3, imageData, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6520a(context, title, text, shortLintk3, BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl), scence, c0911i);
                } else {
                    m6520a(context, title, text, shortLintk3, "", scence, c0911i);
                }
                break;
            case 7:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SAHRE_APP");
                }
                if (scence == 2) {
                    throw new Throwable("WechatFavorite does not support SAHRE_APP");
                }
                if (imagePath != null && imagePath.length() > 0) {
                    m6533b(context, title, text, filePath, extInfo, imagePath, scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6532b(context, title, text, filePath, extInfo, imageData, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6533b(context, title, text, filePath, extInfo, BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl), scence, c0911i);
                } else {
                    m6533b(context, title, text, filePath, extInfo, "", scence, c0911i);
                }
                break;
            case 8:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_FILE");
                }
                if (imagePath != null && imagePath.length() > 0) {
                    m6536c(context, title, text, filePath, imagePath, scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6535c(context, title, text, filePath, imageData, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6536c(context, title, text, filePath, BitmapHelper.downloadBitmap(platformM6578b.getContext(), imageUrl), scence, c0911i);
                } else {
                    m6536c(context, title, text, filePath, "", scence, c0911i);
                }
                break;
                break;
            case 9:
                if (scence == 1) {
                    throw new Throwable("WechatMoments does not support SHARE_EMOJI");
                }
                if (scence == 2) {
                    throw new Throwable("WechatFavorite does not support SHARE_EMOJI");
                }
                if (imagePath != null && imagePath.length() > 0) {
                    m6529b(context, title, text, imagePath, scence, c0911i);
                } else if (imageUrl != null && imageUrl.length() > 0) {
                    m6529b(context, title, text, new NetworkHelper().downloadCache(platformM6578b.getContext(), imageUrl, "images", true, null), scence, c0911i);
                } else if (imageData != null && !imageData.isRecycled()) {
                    m6528b(context, title, text, imageData, scence, c0911i);
                } else {
                    m6529b(context, title, text, "", scence, c0911i);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6524a(String str, String str2, int i, C0911i c0911i) throws Throwable {
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = str2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = str2;
        m6523a(wXMediaMessage, "text", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private void m6518a(Context context, String str, String str2, String str3, int i, C0911i c0911i) throws Throwable {
        WXImageObject wXImageObject = new WXImageObject();
        if (str3.startsWith("/data/")) {
            wXImageObject.imageData = m6527a(str3);
        } else {
            wXImageObject.imagePath = str3;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m6534b(context, str3);
        m6523a(wXMediaMessage, "img", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private void m6517a(Context context, String str, String str2, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXImageObject wXImageObject = new WXImageObject();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        wXImageObject.imageData = byteArrayOutputStream.toByteArray();
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m6525a(context, bitmap);
        m6523a(wXMediaMessage, "img", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private void m6522a(Context context, String str, String str2, String str3, String str4, String str5, int i, C0911i c0911i) throws Throwable {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = m6534b(context, str5);
        m6523a(wXMediaMessage, "music", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private void m6521a(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXMusicObject wXMusicObject = new WXMusicObject();
        wXMusicObject.musicUrl = str4;
        wXMusicObject.musicDataUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXMusicObject;
        wXMediaMessage.thumbData = m6525a(context, bitmap);
        m6523a(wXMediaMessage, "music", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private void m6520a(Context context, String str, String str2, String str3, String str4, int i, C0911i c0911i) throws Throwable {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = m6534b(context, str4);
        m6523a(wXMediaMessage, "video", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private void m6519a(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXVideoObject;
        wXMediaMessage.thumbData = m6525a(context, bitmap);
        m6523a(wXMediaMessage, "video", i, c0911i);
    }

    /* JADX INFO: renamed from: b */
    private void m6531b(Context context, String str, String str2, String str3, String str4, int i, C0911i c0911i) throws Throwable {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (str4 != null && new File(str4).exists()) {
            wXMediaMessage.thumbData = m6534b(context, str4);
            if (wXMediaMessage.thumbData == null) {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
            if (wXMediaMessage.thumbData.length > 32768) {
                throw new RuntimeException("checkArgs fail, thumbData is too large: " + wXMediaMessage.thumbData.length + " > 32768");
            }
        }
        m6523a(wXMediaMessage, "webpage", i, c0911i);
    }

    /* JADX INFO: renamed from: b */
    private void m6530b(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXWebpageObject;
        if (bitmap != null && !bitmap.isRecycled()) {
            wXMediaMessage.thumbData = m6525a(context, bitmap);
            if (wXMediaMessage.thumbData == null) {
                throw new RuntimeException("checkArgs fail, thumbData is null");
            }
            if (wXMediaMessage.thumbData.length > 32768) {
                throw new RuntimeException("checkArgs fail, thumbData is too large: " + wXMediaMessage.thumbData.length + " > 32768");
            }
        }
        m6523a(wXMediaMessage, "webpage", i, c0911i);
    }

    /* JADX INFO: renamed from: b */
    private void m6533b(Context context, String str, String str2, String str3, String str4, String str5, int i, C0911i c0911i) throws Throwable {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = m6534b(context, str5);
        m6523a(wXMediaMessage, "appdata", i, c0911i);
    }

    /* JADX INFO: renamed from: b */
    private void m6532b(Context context, String str, String str2, String str3, String str4, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXAppExtendObject wXAppExtendObject = new WXAppExtendObject();
        wXAppExtendObject.filePath = str3;
        wXAppExtendObject.extInfo = str4;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXAppExtendObject;
        wXMediaMessage.thumbData = m6525a(context, bitmap);
        m6523a(wXMediaMessage, "appdata", i, c0911i);
    }

    /* JADX INFO: renamed from: c */
    private void m6536c(Context context, String str, String str2, String str3, String str4, int i, C0911i c0911i) throws Throwable {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = m6534b(context, str4);
        m6523a(wXMediaMessage, "filedata", i, c0911i);
    }

    /* JADX INFO: renamed from: c */
    private void m6535c(Context context, String str, String str2, String str3, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXFileObject wXFileObject = new WXFileObject();
        wXFileObject.filePath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.description = str2;
        wXMediaMessage.mediaObject = wXFileObject;
        wXMediaMessage.thumbData = m6525a(context, bitmap);
        m6523a(wXMediaMessage, "filedata", i, c0911i);
    }

    /* JADX INFO: renamed from: b */
    private void m6529b(Context context, String str, String str2, String str3, int i, C0911i c0911i) throws Throwable {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = str3;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = m6534b(context, str3);
        m6523a(wXMediaMessage, "emoji", i, c0911i);
    }

    /* JADX INFO: renamed from: b */
    private void m6528b(Context context, String str, String str2, Bitmap bitmap, int i, C0911i c0911i) throws Throwable {
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        byte[] bArrM6525a = m6525a(context, bitmap);
        wXEmojiObject.emojiData = bArrM6525a;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.title = str;
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.description = str2;
        wXMediaMessage.thumbData = bArrM6525a;
        m6523a(wXMediaMessage, "emoji", i, c0911i);
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6527a(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            for (int i = fileInputStream.read(bArr); i > 0; i = fileInputStream.read(bArr)) {
                byteArrayOutputStream.write(bArr, 0, i);
            }
            byteArrayOutputStream.flush();
            fileInputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private byte[] m6534b(Context context, String str) throws FileNotFoundException {
        if (!new File(str).exists()) {
            throw new FileNotFoundException();
        }
        return m6526a(context, BitmapHelper.getBitmap(str), BitmapHelper.getBmpFormat(str));
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6525a(Context context, Bitmap bitmap) {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        return m6526a(context, bitmap, Bitmap.CompressFormat.PNG);
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6526a(Context context, Bitmap bitmap, Bitmap.CompressFormat compressFormat) throws IOException {
        if (bitmap == null) {
            throw new RuntimeException("checkArgs fail, thumbData is null");
        }
        if (bitmap.isRecycled()) {
            throw new RuntimeException("checkArgs fail, thumbData is recycled");
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(compressFormat, 100, byteArrayOutputStream);
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        int length = byteArray.length;
        while (length > 32768) {
            bitmap = m6515a(bitmap, ((double) length) / 32768.0d);
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            bitmap.compress(compressFormat, 100, byteArrayOutputStream2);
            byteArrayOutputStream2.flush();
            byteArrayOutputStream2.close();
            byteArray = byteArrayOutputStream2.toByteArray();
            length = byteArray.length;
        }
        return byteArray;
    }

    /* JADX INFO: renamed from: a */
    private Bitmap m6515a(Bitmap bitmap, double d) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        double dSqrt = Math.sqrt(d);
        return Bitmap.createScaledBitmap(bitmap, (int) (((double) width) / dSqrt), (int) (((double) height) / dSqrt), true);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6539a(Context context, String str) {
        return this.f5911c.m6569a(context, str);
    }

    /* JADX INFO: renamed from: a */
    public boolean m6540a(WechatHandlerActivity wechatHandlerActivity) {
        return this.f5911c.m6570a(wechatHandlerActivity, this.f5912d);
    }

    /* JADX INFO: renamed from: c */
    public boolean m6543c() {
        return this.f5911c.m6571b();
    }

    /* JADX INFO: renamed from: d */
    public boolean m6544d() {
        return this.f5911c.m6572c();
    }

    /* JADX INFO: renamed from: a */
    private void m6523a(WXMediaMessage wXMediaMessage, String str, int i, C0911i c0911i) throws Throwable {
        Class<?> cls;
        String str2 = DeviceHelper.getInstance(c0911i.m6578b().getContext()).getPackageName() + ".wxapi.WXEntryActivity";
        try {
            cls = Class.forName(str2);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
            cls = null;
        }
        if (cls != null && !WechatHandlerActivity.class.isAssignableFrom(cls)) {
            String str3 = str2 + " does not extend from " + WechatHandlerActivity.class.getName();
            if (f5909a) {
                throw new Throwable(str3);
            }
            new Throwable(str3).printStackTrace();
        }
        C0906d c0906d = new C0906d();
        c0906d.f5951c = str + System.currentTimeMillis();
        c0906d.f5931a = wXMediaMessage;
        c0906d.f5932b = i;
        this.f5912d = c0911i;
        this.f5911c.m6567a(c0906d);
    }
}
