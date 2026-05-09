package cn.sharesdk.onekeyshare.themes.classic.port;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPage;
import cn.sharesdk.onekeyshare.themes.classic.PlatformPageAdapter;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class PlatformPagePort extends PlatformPage {
    public PlatformPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPage, com.mob.tools.FakeActivity
    public void onCreate() {
        requestPortraitOrientation();
        super.onCreate();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.themes.classic.PlatformPage
    public PlatformPageAdapter newAdapter(ArrayList<Object> arrayList) {
        return new PlatformPageAdapterPort(this, arrayList);
    }
}
