package cn.sharesdk.onekeyshare.themes.classic.port;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import com.mob.tools.utils.C1583R;

/* JADX INFO: loaded from: classes.dex */
public class FriendListPagePort extends FriendListPage {
    private static final int DESIGN_SCREEN_WIDTH = 720;
    private static final int DESIGN_TITLE_HEIGHT = 96;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.themes.classic.FriendListPage
    public int getDesignTitleHeight() {
        return 96;
    }

    public FriendListPagePort(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.themes.classic.FriendListPage
    public float getRatio() {
        return C1583R.getScreenWidth(this.activity) / 720.0f;
    }
}
