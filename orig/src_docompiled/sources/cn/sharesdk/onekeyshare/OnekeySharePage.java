package cn.sharesdk.onekeyshare;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import com.mob.tools.FakeActivity;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class OnekeySharePage extends FakeActivity {
    private OnekeyShareThemeImpl impl;

    public OnekeySharePage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        this.impl = onekeyShareThemeImpl;
    }

    protected final boolean isDialogMode() {
        return this.impl.dialogMode;
    }

    protected final HashMap<String, Object> getShareParamsMap() {
        return this.impl.shareParamsMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isSilent() {
        return this.impl.silent;
    }

    protected final ArrayList<CustomerLogo> getCustomerLogos() {
        return this.impl.customerLogos;
    }

    protected final HashMap<String, String> getHiddenPlatforms() {
        return this.impl.hiddenPlatforms;
    }

    protected final PlatformActionListener getCallback() {
        return this.impl.callback;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final ShareContentCustomizeCallback getCustomizeCallback() {
        return this.impl.customizeCallback;
    }

    protected final boolean isDisableSSO() {
        return this.impl.disableSSO;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void shareSilently(Platform platform) {
        this.impl.shareSilently(platform);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final Platform.ShareParams formateShareData(Platform platform) {
        if (this.impl.formateShareData(platform)) {
            return this.impl.shareDataToShareParams(platform);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final boolean isUseClientToShare(Platform platform) {
        return this.impl.isUseClientToShare(platform);
    }
}
