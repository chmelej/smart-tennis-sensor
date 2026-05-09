package cn.sharesdk.framework.authorize;

import android.app.Activity;
import android.view.KeyEvent;
import android.webkit.WebView;
import android.widget.RelativeLayout;
import cn.sharesdk.framework.TitleLayout;

/* JADX INFO: loaded from: classes.dex */
public class AuthorizeAdapter {
    private Activity activity;
    private boolean noTitle;
    private String platform;
    private boolean popUpAnimationDisable;
    private RelativeLayout rlBody;
    private TitleLayout title;
    private WebView webview;

    public void onCreate() {
    }

    public void onDestroy() {
    }

    public boolean onFinish() {
        return false;
    }

    public boolean onKeyEvent(int i, KeyEvent keyEvent) {
        return false;
    }

    public void onPause() {
    }

    public void onResize(int i, int i2, int i3, int i4) {
    }

    public void onRestart() {
    }

    public void onResume() {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return this.activity;
    }

    void setTitleView(TitleLayout titleLayout) {
        this.title = titleLayout;
    }

    public TitleLayout getTitleLayout() {
        return this.title;
    }

    void setWebView(WebView webView) {
        this.webview = webView;
    }

    public WebView getWebBody() {
        return this.webview;
    }

    void setNotitle(boolean z) {
        this.noTitle = z;
    }

    boolean isNotitle() {
        return this.noTitle;
    }

    void setPlatformName(String str) {
        this.platform = str;
    }

    public String getPlatformName() {
        return this.platform;
    }

    void setBodyView(RelativeLayout relativeLayout) {
        this.rlBody = relativeLayout;
    }

    public RelativeLayout getBodyView() {
        return this.rlBody;
    }

    protected void disablePopUpAnimation() {
        this.popUpAnimationDisable = true;
    }

    boolean isPopUpAnimationDisable() {
        return this.popUpAnimationDisable;
    }

    public void hideShareSDKLogo() {
        getTitleLayout().getChildAt(getTitleLayout().getChildCount() - 1).setVisibility(8);
    }
}
