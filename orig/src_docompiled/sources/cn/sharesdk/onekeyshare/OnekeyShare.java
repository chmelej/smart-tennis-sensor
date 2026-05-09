package cn.sharesdk.onekeyshare;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.utils.BitmapHelper;
import com.mob.tools.utils.C1583R;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class OnekeyShare {
    private HashMap<String, Object> params = new HashMap<>();

    public OnekeyShare() {
        this.params.put("customers", new ArrayList());
        this.params.put("hiddenPlatforms", new HashMap());
    }

    public void setAddress(String str) {
        this.params.put("address", str);
    }

    public void setTitle(String str) {
        this.params.put("title", str);
    }

    public void setTitleUrl(String str) {
        this.params.put("titleUrl", str);
    }

    public void setText(String str) {
        this.params.put("text", str);
    }

    public String getText() {
        if (this.params.containsKey("text")) {
            return String.valueOf(this.params.get("text"));
        }
        return null;
    }

    public void setImagePath(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.params.put("imagePath", str);
    }

    public void setImageUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.params.put("imageUrl", str);
    }

    public void setUrl(String str) {
        this.params.put("url", str);
    }

    public void setFilePath(String str) {
        this.params.put("filePath", str);
    }

    public void setComment(String str) {
        this.params.put("comment", str);
    }

    public void setSite(String str) {
        this.params.put("site", str);
    }

    public void setSiteUrl(String str) {
        this.params.put("siteUrl", str);
    }

    public void setVenueName(String str) {
        this.params.put("venueName", str);
    }

    public void setVenueDescription(String str) {
        this.params.put("venueDescription", str);
    }

    public void setLatitude(float f) {
        this.params.put("latitude", Float.valueOf(f));
    }

    public void setLongitude(float f) {
        this.params.put("longitude", Float.valueOf(f));
    }

    public void setSilent(boolean z) {
        this.params.put("silent", Boolean.valueOf(z));
    }

    public void setPlatform(String str) {
        this.params.put("platform", str);
    }

    public void setInstallUrl(String str) {
        this.params.put("installurl", str);
    }

    public void setExecuteUrl(String str) {
        this.params.put("executeurl", str);
    }

    public void setMusicUrl(String str) {
        this.params.put("musicUrl", str);
    }

    public void setCallback(PlatformActionListener platformActionListener) {
        this.params.put("callback", platformActionListener);
    }

    public PlatformActionListener getCallback() {
        return (PlatformActionListener) C1583R.forceCast(this.params.get("callback"));
    }

    public void setShareContentCustomizeCallback(ShareContentCustomizeCallback shareContentCustomizeCallback) {
        this.params.put("customizeCallback", shareContentCustomizeCallback);
    }

    public ShareContentCustomizeCallback getShareContentCustomizeCallback() {
        return (ShareContentCustomizeCallback) C1583R.forceCast(this.params.get("customizeCallback"));
    }

    public void setCustomerLogo(Bitmap bitmap, String str, View.OnClickListener onClickListener) {
        CustomerLogo customerLogo = new CustomerLogo();
        customerLogo.logo = bitmap;
        customerLogo.label = str;
        customerLogo.listener = onClickListener;
        ((ArrayList) C1583R.forceCast(this.params.get("customers"))).add(customerLogo);
    }

    public void disableSSOWhenAuthorize() {
        this.params.put("disableSSO", true);
    }

    public void setVideoUrl(String str) {
        this.params.put("url", str);
        this.params.put("shareType", 6);
    }

    @Deprecated
    public void setDialogMode() {
        this.params.put("dialogMode", true);
    }

    public void addHiddenPlatform(String str) {
        ((HashMap) C1583R.forceCast(this.params.get("hiddenPlatforms"))).put(str, str);
    }

    public void setViewToShare(View view) {
        try {
            this.params.put("viewToShare", BitmapHelper.captureView(view, view.getWidth(), view.getHeight()));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void setImageArray(String[] strArr) {
        this.params.put("imageArray", strArr);
    }

    public void setShareToTencentWeiboWhenPerformingQQOrQZoneSharing() {
        this.params.put("isShareTencentWeibo", true);
    }

    public void setTheme(OnekeyShareTheme onekeyShareTheme) {
        this.params.put("theme", Integer.valueOf(onekeyShareTheme.getValue()));
    }

    public void show(Context context) {
        int i;
        HashMap<String, Object> map = new HashMap<>();
        map.putAll(this.params);
        ShareSDK.initSDK(context.getApplicationContext());
        ShareSDK.logDemoEvent(1, null);
        try {
            i = C1583R.parseInt(String.valueOf(map.remove("theme")));
        } catch (Throwable unused) {
            i = 0;
        }
        OnekeyShareThemeImpl impl = OnekeyShareTheme.fromValue(i).getImpl();
        impl.setShareParamsMap(map);
        impl.setDialogMode(map.containsKey("dialogMode") ? ((Boolean) map.remove("dialogMode")).booleanValue() : false);
        impl.setSilent(map.containsKey("silent") ? ((Boolean) map.remove("silent")).booleanValue() : false);
        impl.setCustomerLogos((ArrayList) map.remove("customers"));
        impl.setHiddenPlatforms((HashMap) map.remove("hiddenPlatforms"));
        impl.setPlatformActionListener((PlatformActionListener) map.remove("callback"));
        impl.setShareContentCustomizeCallback((ShareContentCustomizeCallback) map.remove("customizeCallback"));
        if (map.containsKey("disableSSO") && ((Boolean) map.remove("disableSSO")).booleanValue()) {
            impl.disableSSO();
        }
        impl.show(context.getApplicationContext());
    }
}
