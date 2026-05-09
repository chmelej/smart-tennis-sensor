package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class Platform {
    public static final int ACTION_AUTHORIZING = 1;
    protected static final int ACTION_CUSTOMER = 655360;
    public static final int ACTION_FOLLOWING_USER = 6;
    protected static final int ACTION_GETTING_BILATERAL_LIST = 10;
    protected static final int ACTION_GETTING_FOLLOWER_LIST = 11;
    public static final int ACTION_GETTING_FRIEND_LIST = 2;
    public static final int ACTION_SENDING_DIRECT_MESSAGE = 5;
    public static final int ACTION_SHARE = 9;
    public static final int ACTION_TIMELINE = 7;
    public static final int ACTION_USER_INFOR = 8;
    public static final int CUSTOMER_ACTION_MASK = 65535;
    public static final int SHARE_APPS = 7;
    public static final int SHARE_EMOJI = 9;
    public static final int SHARE_FILE = 8;
    public static final int SHARE_IMAGE = 2;
    public static final int SHARE_MUSIC = 5;
    public static final int SHARE_TEXT = 1;
    public static final int SHARE_VIDEO = 6;
    public static final int SHARE_WEBPAGE = 4;

    /* JADX INFO: renamed from: a */
    private C0844c f5512a;
    protected final Context context;

    /* JADX INFO: renamed from: db */
    protected final PlatformDb f5513db;
    protected PlatformActionListener listener;

    public abstract boolean checkAuthorize(int i, Object obj);

    public abstract void doAuthorize(String[] strArr);

    public abstract void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> map, HashMap<String, String> map2);

    public abstract void doShare(ShareParams shareParams);

    public abstract HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map);

    public abstract C0840f.a filterShareContent(ShareParams shareParams, HashMap<String, Object> map);

    public abstract void follow(String str);

    public abstract HashMap<String, Object> getBilaterals(int i, int i2, String str);

    public abstract HashMap<String, Object> getFollowers(int i, int i2, String str);

    public abstract HashMap<String, Object> getFollowings(int i, int i2, String str);

    public abstract void getFriendList(int i, int i2, String str);

    public abstract String getName();

    public abstract int getPlatformId();

    public abstract int getVersion();

    public abstract boolean hasShareCallback();

    public abstract void initDevInfo(String str);

    public boolean isClientValid() {
        return false;
    }

    public abstract void setNetworkDevinfo();

    public abstract void timeline(int i, int i2, String str);

    public abstract void userInfor(String str);

    public Platform(Context context) {
        this.context = context;
        this.f5512a = new C0844c(this, context);
        this.f5513db = this.f5512a.m6120g();
        this.listener = this.f5512a.m6122i();
    }

    /* JADX INFO: renamed from: a */
    void m5932a() {
        this.f5512a.m6108a(false);
        this.f5512a.m6105a(getName());
    }

    protected void copyDevinfo(String str, String str2) {
        ShareSDK.m5942a(str, str2);
    }

    protected void copyNetworkDevinfo(int i, int i2) {
        ShareSDK.m5941a(i, i2);
    }

    public String getDevinfo(String str) {
        return getDevinfo(getName(), str);
    }

    public String getDevinfo(String str, String str2) {
        return ShareSDK.m5945b(str, str2);
    }

    protected String getNetworkDevinfo(String str, String str2) {
        return getNetworkDevinfo(getPlatformId(), str, str2);
    }

    protected String getNetworkDevinfo(int i, String str, String str2) {
        return this.f5512a.m6098a(i, str, str2);
    }

    public Context getContext() {
        return this.context;
    }

    public int getId() {
        return this.f5512a.m6097a();
    }

    public int getSortId() {
        return this.f5512a.m6110b();
    }

    public void setPlatformActionListener(PlatformActionListener platformActionListener) {
        this.f5512a.m6104a(platformActionListener);
    }

    public PlatformActionListener getPlatformActionListener() {
        return this.f5512a.m6113c();
    }

    public boolean isAuthValid() {
        return this.f5512a.m6117d();
    }

    @Deprecated
    public boolean isValid() {
        return this.f5512a.m6117d();
    }

    public void SSOSetting(boolean z) {
        this.f5512a.m6108a(z);
    }

    public boolean isSSODisable() {
        return this.f5512a.m6118e();
    }

    /* JADX INFO: renamed from: b */
    boolean m5933b() {
        return this.f5512a.m6119f();
    }

    public void authorize() {
        authorize(null);
    }

    public void authorize(String[] strArr) {
        this.f5512a.m6109a(strArr);
    }

    protected void innerAuthorize(int i, Object obj) {
        this.f5512a.m6102a(i, obj);
    }

    public void share(ShareParams shareParams) {
        this.f5512a.m6103a(shareParams);
    }

    public void followFriend(String str) {
        this.f5512a.m6112b(str);
    }

    public void getTimeLine(String str, int i, int i2) {
        this.f5512a.m6106a(str, i, i2);
    }

    public void showUser(String str) {
        this.f5512a.m6115c(str);
    }

    public void listFriend(int i, int i2, String str) {
        this.f5512a.m6101a(i, i2, str);
    }

    public void customerProtocol(String str, String str2, short s, HashMap<String, Object> map, HashMap<String, String> map2) {
        this.f5512a.m6107a(str, str2, s, map, map2);
    }

    protected void afterRegister(int i, Object obj) {
        this.f5512a.m6111b(i, obj);
    }

    public PlatformDb getDb() {
        return this.f5513db;
    }

    @Deprecated
    public void removeAccount() {
        this.f5512a.m6121h();
    }

    public void removeAccount(boolean z) {
        this.f5512a.m6121h();
        ShareSDK.removeCookieOnAuthorize(z);
    }

    public String getShortLintk(String str, boolean z) {
        return this.f5512a.m6100a(str, z);
    }

    public String uploadImageToFileServer(String str) {
        return this.f5512a.m6116d(str);
    }

    protected String uploadImageToFileServer(Bitmap bitmap) {
        return this.f5512a.m6099a(bitmap);
    }

    public static class ShareParams extends InnerShareParams {

        @Deprecated
        public String imagePath;

        @Deprecated
        public String text;

        public ShareParams() {
        }

        public ShareParams(HashMap<String, Object> map) {
            super(map);
        }

        public ShareParams(String str) {
            super(str);
        }
    }
}
