package cn.sharesdk.system.email;

import android.content.Context;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.p004b.p006b.C0840f;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public class Email extends Platform {
    public static final String NAME = "Email";

    public static class ShareParams extends Platform.ShareParams {

        @Deprecated
        public String address;

        @Deprecated
        public String title;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public boolean checkAuthorize(int i, Object obj) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> filterFriendshipInfo(int i, HashMap<String, Object> map) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getBilaterals(int i, int i2, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowers(int i, int i2, String str) {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public HashMap<String, Object> getFollowings(int i, int i2, String str) {
        return null;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getPlatformId() {
        return 18;
    }

    @Override // cn.sharesdk.framework.Platform
    public int getVersion() {
        return 1;
    }

    @Override // cn.sharesdk.framework.Platform
    public boolean hasShareCallback() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void initDevInfo(String str) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void setNetworkDevinfo() {
    }

    public Email(Context context) {
        super(context);
    }

    @Override // cn.sharesdk.framework.Platform
    public String getName() {
        return NAME;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doAuthorize(String[] strArr) {
        afterRegister(1, null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0050  */
    @Override // cn.sharesdk.framework.Platform
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void doShare(final cn.sharesdk.framework.Platform.ShareParams r8) {
        /*
            r7 = this;
            android.content.Context r0 = r7.context     // Catch: java.lang.Throwable -> L5c
            cn.sharesdk.system.email.a r1 = cn.sharesdk.system.email.C0873a.m6289a(r0)     // Catch: java.lang.Throwable -> L5c
            cn.sharesdk.system.email.Email$1 r6 = new cn.sharesdk.system.email.Email$1     // Catch: java.lang.Throwable -> L5c
            r6.<init>()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r8.getText()     // Catch: java.lang.Throwable -> L5c
            r2 = 1
            java.lang.String r0 = r7.getShortLintk(r0, r2)     // Catch: java.lang.Throwable -> L5c
            r8.setText(r0)     // Catch: java.lang.Throwable -> L5c
            android.text.Spanned r4 = android.text.Html.fromHtml(r0)     // Catch: java.lang.Throwable -> L5c
            java.lang.String r0 = r8.getAddress()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r3 = r8.getTitle()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r2 = r8.getImagePath()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = r8.getImageUrl()     // Catch: java.lang.Throwable -> L5c
            boolean r5 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L5c
            if (r5 == 0) goto L50
            boolean r5 = android.text.TextUtils.isEmpty(r8)     // Catch: java.lang.Throwable -> L5c
            if (r5 != 0) goto L50
            android.content.Context r5 = r7.getContext()     // Catch: java.lang.Throwable -> L5c
            java.lang.String r8 = com.mob.tools.utils.BitmapHelper.downloadBitmap(r5, r8)     // Catch: java.lang.Throwable -> L5c
            java.io.File r5 = new java.io.File     // Catch: java.lang.Throwable -> L5c
            r5.<init>(r8)     // Catch: java.lang.Throwable -> L5c
            boolean r8 = r5.exists()     // Catch: java.lang.Throwable -> L5c
            if (r8 == 0) goto L50
            java.lang.String r8 = r5.getAbsolutePath()     // Catch: java.lang.Throwable -> L5c
            r5 = r8
            goto L51
        L50:
            r5 = r2
        L51:
            if (r0 != 0) goto L57
            java.lang.String r8 = ""
            r2 = r8
            goto L58
        L57:
            r2 = r0
        L58:
            r1.m6290a(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L5c
            goto L68
        L5c:
            r8 = move-exception
            cn.sharesdk.framework.PlatformActionListener r0 = r7.listener
            if (r0 == 0) goto L68
            cn.sharesdk.framework.PlatformActionListener r0 = r7.listener
            r1 = 9
            r0.onError(r7, r1, r8)
        L68:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.system.email.Email.doShare(cn.sharesdk.framework.Platform$ShareParams):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void follow(String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 6);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void timeline(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 7);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void userInfor(String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void getFriendList(int i, int i2, String str) {
        if (this.listener != null) {
            this.listener.onCancel(this, 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public void doCustomerProtocol(String str, String str2, int i, HashMap<String, Object> map, HashMap<String, String> map2) {
        if (this.listener != null) {
            this.listener.onCancel(this, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.framework.Platform
    public C0840f.a filterShareContent(Platform.ShareParams shareParams, HashMap<String, Object> map) {
        C0840f.a aVar = new C0840f.a();
        String text = shareParams.getText();
        aVar.f5621b = text;
        String imagePath = shareParams.getImagePath();
        if (imagePath != null) {
            aVar.f5624e.add(imagePath);
        }
        HashMap<String, Object> map2 = new HashMap<>();
        map2.put("subject", shareParams.getTitle());
        map2.put("content", text);
        aVar.f5626g = map2;
        return aVar;
    }
}
