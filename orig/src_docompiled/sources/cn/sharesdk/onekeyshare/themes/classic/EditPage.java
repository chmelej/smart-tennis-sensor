package cn.sharesdk.onekeyshare.themes.classic;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeySharePage;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.onekeyshare.themes.classic.land.FriendListPageLand;
import cn.sharesdk.onekeyshare.themes.classic.port.FriendListPagePort;
import com.mob.tools.gui.AsyncImageView;
import com.mob.tools.utils.C1583R;
import com.mob.tools.utils.DeviceHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class EditPage extends OnekeySharePage implements TextWatcher, View.OnClickListener, Runnable {
    protected AsyncImageView aivThumb;
    protected EditText etContent;
    private OnekeyShareThemeImpl impl;
    protected LinearLayout llBottom;
    protected LinearLayout llPage;
    protected int maxBodyHeight;
    protected Platform platform;
    protected RelativeLayout rlThumb;
    protected RelativeLayout rlTitle;

    /* JADX INFO: renamed from: sp */
    protected Platform.ShareParams f5720sp;
    protected ScrollView svContent;
    protected Bitmap thumb;
    protected TextView tvAt;
    protected TextView tvCancel;
    protected TextView tvShare;
    protected TextView tvTextCouter;
    protected XView xvRemove;

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public EditPage(OnekeyShareThemeImpl onekeyShareThemeImpl) {
        super(onekeyShareThemeImpl);
        this.impl = onekeyShareThemeImpl;
    }

    public void setPlatform(Platform platform) {
        this.platform = platform;
    }

    public void setShareParams(Platform.ShareParams shareParams) {
        this.f5720sp = shareParams;
    }

    @Override // com.mob.tools.FakeActivity
    public void setActivity(Activity activity) {
        super.setActivity(activity);
        if (isDialogMode()) {
            System.err.println("Theme classic does not support dialog mode!");
        }
        activity.getWindow().setSoftInputMode(37);
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.activity.getWindow().setBackgroundDrawable(new ColorDrawable(-789517));
    }

    private void cancelAndFinish() {
        ShareSDK.logDemoEvent(5, this.platform);
        finish();
    }

    private void shareAndFinish() {
        int stringRes = C1583R.getStringRes(this.activity, "ssdk_oks_sharing");
        if (stringRes > 0) {
            Toast.makeText(this.activity, stringRes, 0).show();
        }
        if (isDisableSSO()) {
            this.platform.SSOSetting(true);
        }
        this.platform.setPlatformActionListener(getCallback());
        this.platform.share(this.f5720sp);
        finish();
    }

    private void showThumb(Bitmap bitmap) {
        PicViewerPage picViewerPage = new PicViewerPage(this.impl);
        picViewerPage.setImageBitmap(bitmap);
        picViewerPage.show(this.activity, null);
    }

    private void removeThumb() {
        this.f5720sp.setImageArray(null);
        this.f5720sp.setImageData(null);
        this.f5720sp.setImagePath(null);
        this.f5720sp.setImageUrl(null);
    }

    private void showFriendList() {
        FriendListPage friendListPageLand;
        if (this.activity.getResources().getConfiguration().orientation == 1) {
            friendListPageLand = new FriendListPagePort(this.impl);
        } else {
            friendListPageLand = new FriendListPageLand(this.impl);
        }
        friendListPageLand.setPlatform(this.platform);
        friendListPageLand.showForResult(this.platform.getContext(), null, this);
    }

    @Override // com.mob.tools.FakeActivity
    public void onResult(HashMap<String, Object> map) {
        String joinSelectedUser = getJoinSelectedUser(map);
        if (TextUtils.isEmpty(joinSelectedUser)) {
            return;
        }
        this.etContent.append(joinSelectedUser);
    }

    private String getJoinSelectedUser(HashMap<String, Object> map) {
        if (map == null || !map.containsKey("selected")) {
            return null;
        }
        ArrayList<String> arrayList = (ArrayList) map.get("selected");
        if ("FacebookMessenger".equals(((Platform) map.get("platform")).getName())) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (String str : arrayList) {
            sb.append('@');
            sb.append(str);
            sb.append(' ');
        }
        return sb.toString();
    }

    protected boolean isShowAtUserLayout(String str) {
        return "SinaWeibo".equals(str) || "TencentWeibo".equals(str) || "Facebook".equals(str) || "Twitter".equals(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.equals(this.tvCancel)) {
            cancelAndFinish();
            return;
        }
        if (view.equals(this.tvShare)) {
            this.f5720sp.setText(this.etContent.getText().toString().trim());
            shareAndFinish();
            return;
        }
        if (view.equals(this.aivThumb)) {
            showThumb(this.thumb);
            return;
        }
        if (view.equals(this.xvRemove)) {
            this.maxBodyHeight = 0;
            this.rlThumb.setVisibility(8);
            this.llPage.measure(0, 0);
            onTextChanged(this.etContent.getText(), 0, 0, 0);
            removeThumb();
            return;
        }
        if (view.equals(this.tvAt)) {
            showFriendList();
        }
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.tvTextCouter.setText(String.valueOf(charSequence.length()));
        if (this.maxBodyHeight == 0) {
            this.maxBodyHeight = (this.llPage.getHeight() - this.rlTitle.getHeight()) - this.llBottom.getHeight();
        }
        if (this.maxBodyHeight > 0) {
            this.svContent.post(this);
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        int height = this.svContent.getChildAt(0).getHeight();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) C1583R.forceCast(this.svContent.getLayoutParams());
        if (height > this.maxBodyHeight && layoutParams.height != this.maxBodyHeight) {
            layoutParams.height = this.maxBodyHeight;
            this.svContent.setLayoutParams(layoutParams);
        } else {
            if (height >= this.maxBodyHeight || layoutParams.height != this.maxBodyHeight) {
                return;
            }
            layoutParams.height = -2;
            this.svContent.setLayoutParams(layoutParams);
        }
    }

    @Override // com.mob.tools.FakeActivity
    public void onPause() {
        DeviceHelper.getInstance(this.activity).hideSoftInput(getContentView());
        super.onPause();
    }
}
