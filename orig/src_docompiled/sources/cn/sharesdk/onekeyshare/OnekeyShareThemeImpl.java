package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import cn.sharesdk.framework.CustomPlatform;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.utils.C1583R;
import com.mob.tools.utils.UIHandler;
import com.umeng.message.ALIAS_TYPE;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class OnekeyShareThemeImpl implements Handler.Callback, PlatformActionListener {
    protected PlatformActionListener callback = this;
    protected Context context;
    protected ArrayList<CustomerLogo> customerLogos;
    protected ShareContentCustomizeCallback customizeCallback;
    protected boolean dialogMode;
    protected boolean disableSSO;
    protected HashMap<String, String> hiddenPlatforms;
    protected HashMap<String, Object> shareParamsMap;
    protected boolean silent;

    public abstract void showEditPage(Context context, Platform platform, Platform.ShareParams shareParams);

    public abstract void showPlatformPage(Context context);

    public final void setDialogMode(boolean z) {
        this.dialogMode = z;
    }

    public final void setShareParamsMap(HashMap<String, Object> map) {
        this.shareParamsMap = map;
    }

    public final void setSilent(boolean z) {
        this.silent = z;
    }

    public final void setCustomerLogos(ArrayList<CustomerLogo> arrayList) {
        this.customerLogos = arrayList;
    }

    public final void setHiddenPlatforms(HashMap<String, String> map) {
        this.hiddenPlatforms = map;
    }

    public final void setPlatformActionListener(PlatformActionListener platformActionListener) {
        if (platformActionListener == null) {
            platformActionListener = this;
        }
        this.callback = platformActionListener;
    }

    public final void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.customizeCallback = shareContentCustomizeCallback;
    }

    public final void disableSSO() {
        this.disableSSO = true;
    }

    public final void show(Context context) {
        this.context = context;
        if (this.shareParamsMap.containsKey("platform")) {
            Platform platform = ShareSDK.getPlatform(String.valueOf(this.shareParamsMap.get("platform")));
            boolean z = platform instanceof CustomPlatform;
            boolean zIsUseClientToShare = isUseClientToShare(platform);
            if (this.silent || z || zIsUseClientToShare) {
                shareSilently(platform);
                return;
            } else {
                prepareForEditPage(platform);
                return;
            }
        }
        showPlatformPage(context);
    }

    final boolean isUseClientToShare(Platform platform) {
        String name = platform.getName();
        if ("Wechat".equals(name) || "WechatMoments".equals(name) || "WechatFavorite".equals(name) || "ShortMessage".equals(name) || "Email".equals(name) || "Qzone".equals(name) || ALIAS_TYPE.f9145QQ.equals(name) || "Pinterest".equals(name) || "Instagram".equals(name) || "Yixin".equals(name) || "YixinMoments".equals(name) || "QZone".equals(name) || "Mingdao".equals(name) || "Line".equals(name) || "KakaoStory".equals(name) || "KakaoTalk".equals(name) || "Bluetooth".equals(name) || "WhatsApp".equals(name) || "BaiduTieba".equals(name) || "Laiwang".equals(name) || "LaiwangMoments".equals(name) || "Alipay".equals(name) || "AlipayMoments".equals(name) || "FacebookMessenger".equals(name) || "GooglePlus".equals(name)) {
            return true;
        }
        if ("Evernote".equals(name)) {
            if ("true".equals(platform.getDevinfo("ShareByAppClient"))) {
                return true;
            }
        } else if ("SinaWeibo".equals(name) && "true".equals(platform.getDevinfo("ShareByAppClient"))) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setPackage("com.sina.weibo");
            intent.setType("image/*");
            ResolveInfo resolveInfoResolveActivity = platform.getContext().getPackageManager().resolveActivity(intent, 0);
            if (resolveInfoResolveActivity == null) {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setPackage("com.sina.weibog3");
                intent2.setType("image/*");
                resolveInfoResolveActivity = platform.getContext().getPackageManager().resolveActivity(intent2, 0);
            }
            return resolveInfoResolveActivity != null;
        }
        return false;
    }

    final void shareSilently(Platform platform) {
        Platform.ShareParams shareParamsShareDataToShareParams;
        if (!formateShareData(platform) || (shareParamsShareDataToShareParams = shareDataToShareParams(platform)) == null) {
            return;
        }
        toast("ssdk_oks_sharing");
        if (this.customizeCallback != null) {
            this.customizeCallback.onShare(platform, shareParamsShareDataToShareParams);
        }
        if (this.disableSSO) {
            platform.SSOSetting(this.disableSSO);
        }
        platform.setPlatformActionListener(this.callback);
        platform.share(shareParamsShareDataToShareParams);
    }

    private void prepareForEditPage(Platform platform) {
        Platform.ShareParams shareParamsShareDataToShareParams;
        if (!formateShareData(platform) || (shareParamsShareDataToShareParams = shareDataToShareParams(platform)) == null) {
            return;
        }
        ShareSDK.logDemoEvent(3, null);
        if (this.customizeCallback != null) {
            this.customizeCallback.onShare(platform, shareParamsShareDataToShareParams);
        }
        showEditPage(this.context, platform, shareParamsShareDataToShareParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x01a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    final boolean formateShareData(cn.sharesdk.framework.Platform r8) {
        /*
            Method dump skipped, instruction units count: 613
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.formateShareData(cn.sharesdk.framework.Platform):boolean");
    }

    final Platform.ShareParams shareDataToShareParams(Platform platform) {
        if (platform == null || this.shareParamsMap == null) {
            toast("ssdk_oks_share_failed");
            return null;
        }
        try {
            String str = (String) C1583R.forceCast(this.shareParamsMap.get("imagePath"));
            Bitmap bitmap = (Bitmap) C1583R.forceCast(this.shareParamsMap.get("viewToShare"));
            if (TextUtils.isEmpty(str) && bitmap != null && !bitmap.isRecycled()) {
                File file = new File(C1583R.getCachePath(platform.getContext(), "screenshot"), String.valueOf(System.currentTimeMillis()) + ".jpg");
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                this.shareParamsMap.put("imagePath", file.getAbsolutePath());
            }
            return new Platform.ShareParams(this.shareParamsMap);
        } catch (Throwable th) {
            th.printStackTrace();
            toast("ssdk_oks_share_failed");
            return null;
        }
    }

    private void toast(final String str) {
        UIHandler.sendEmptyMessage(0, new Handler.Callback() { // from class: cn.sharesdk.onekeyshare.OnekeyShareThemeImpl.1
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                int stringRes = C1583R.getStringRes(OnekeyShareThemeImpl.this.context, str);
                if (stringRes > 0) {
                    Toast.makeText(OnekeyShareThemeImpl.this.context, stringRes, 0).show();
                } else {
                    Toast.makeText(OnekeyShareThemeImpl.this.context, str, 0).show();
                }
                return false;
            }
        });
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onComplete(Platform platform, int i, HashMap<String, Object> map) {
        Message message = new Message();
        message.arg1 = 1;
        message.arg2 = i;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onError(Platform platform, int i, Throwable th) {
        th.printStackTrace();
        Message message = new Message();
        message.arg1 = 2;
        message.arg2 = i;
        message.obj = th;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(4, platform);
    }

    @Override // cn.sharesdk.framework.PlatformActionListener
    public final void onCancel(Platform platform, int i) {
        Message message = new Message();
        message.arg1 = 3;
        message.arg2 = i;
        message.obj = platform;
        UIHandler.sendMessage(message, this);
        ShareSDK.logDemoEvent(5, platform);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        switch (message.arg1) {
            case 1:
                int stringRes = C1583R.getStringRes(this.context, "ssdk_oks_share_completed");
                if (stringRes > 0) {
                    toast(this.context.getString(stringRes));
                }
                break;
            case 2:
                String simpleName = message.obj.getClass().getSimpleName();
                if ("WechatClientNotExistException".equals(simpleName) || "WechatTimelineNotSupportedException".equals(simpleName) || "WechatFavoriteNotSupportedException".equals(simpleName)) {
                    toast("ssdk_wechat_client_inavailable");
                } else if ("GooglePlusClientNotExistException".equals(simpleName)) {
                    toast("ssdk_google_plus_client_inavailable");
                } else if ("QQClientNotExistException".equals(simpleName)) {
                    toast("ssdk_qq_client_inavailable");
                } else if ("YixinClientNotExistException".equals(simpleName) || "YixinTimelineNotSupportedException".equals(simpleName)) {
                    toast("ssdk_yixin_client_inavailable");
                } else if ("KakaoTalkClientNotExistException".equals(simpleName)) {
                    toast("ssdk_kakaotalk_client_inavailable");
                } else if ("KakaoStoryClientNotExistException".equals(simpleName)) {
                    toast("ssdk_kakaostory_client_inavailable");
                } else if ("WhatsAppClientNotExistException".equals(simpleName)) {
                    toast("ssdk_whatsapp_client_inavailable");
                } else if ("FacebookMessengerClientNotExistException".equals(simpleName)) {
                    toast("ssdk_facebookmessenger_client_inavailable");
                } else {
                    toast("ssdk_oks_share_failed");
                }
                break;
            case 3:
                toast("ssdk_oks_share_canceled");
                break;
        }
        return false;
    }
}
