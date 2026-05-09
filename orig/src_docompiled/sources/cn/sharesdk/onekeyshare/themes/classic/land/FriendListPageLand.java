package cn.sharesdk.onekeyshare.themes.classic.land;

import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.FriendListPage;
import com.mob.tools.utils.C1583R;

/* JADX INFO: loaded from: classes.dex */
public class FriendListPageLand extends FriendListPage {
    private static final int DESIGN_SCREEN_WIDTH = 1280;
    private static final int DESIGN_TITLE_HEIGHT = 70;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.themes.classic.FriendListPage
    public int getDesignTitleHeight() {
        return 70;
    }

    public FriendListPageLand(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.onekeyshare.themes.classic.FriendListPage
    public float getRatio() {
        return C1583R.getScreenWidth(this.activity) / 1280.0f;
    }
}
