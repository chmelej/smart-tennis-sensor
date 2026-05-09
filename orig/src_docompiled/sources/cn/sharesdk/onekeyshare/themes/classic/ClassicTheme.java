package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.land.EditPageLand;
import cn.sharesdk.onekeyshare.themes.classic.land.PlatformPageLand;
import cn.sharesdk.onekeyshare.themes.classic.port.EditPagePort;
import cn.sharesdk.onekeyshare.themes.classic.port.PlatformPagePort;
import com.mob.tools.FakeActivity;

/* JADX INFO: loaded from: classes.dex */
public class ClassicTheme extends OnekeyShareThemeImpl {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.OnekeyShareThemeImpl
    public void showPlatformPage(Context context) {
        FakeActivity platformPageLand;
        if (context.getResources().getConfiguration().orientation == 1) {
            platformPageLand = new PlatformPagePort(this);
        } else {
            platformPageLand = new PlatformPageLand(this);
        }
        platformPageLand.show(context, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.OnekeyShareThemeImpl
    public void showEditPage(Context context, Platform platform, Platform.ShareParams shareParams) {
        EditPage editPageLand;
        if (context.getResources().getConfiguration().orientation == 1) {
            editPageLand = new EditPagePort(this);
        } else {
            editPageLand = new EditPageLand(this);
        }
        editPageLand.setPlatform(platform);
        editPageLand.setShareParams(shareParams);
        editPageLand.show(context, null);
    }
}
