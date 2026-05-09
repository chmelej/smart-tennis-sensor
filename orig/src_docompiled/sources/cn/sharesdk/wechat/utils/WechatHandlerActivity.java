package cn.sharesdk.wechat.utils;

import android.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.utils.C0851d;

/* JADX INFO: loaded from: classes.dex */
public class WechatHandlerActivity extends Activity {
    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }

    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(R.style.Theme.Translucent);
        super.onCreate(bundle);
        try {
            WechatHelper.m6516a().m6540a(this);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        finish();
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        try {
            WechatHelper.m6516a().m6540a(this);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
        finish();
    }
}
