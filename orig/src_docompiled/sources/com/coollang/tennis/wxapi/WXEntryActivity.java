package com.coollang.tennis.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import cn.sharesdk.wechat.utils.WXAppExtendObject;
import cn.sharesdk.wechat.utils.WXMediaMessage;
import cn.sharesdk.wechat.utils.WechatHandlerActivity;
import com.coollang.tennis.R;
import p000.AbstractC2300zn;
import p000.AbstractC2301zo;
import p000.C2312zz;
import p000.InterfaceC2310zx;
import p000.InterfaceC2311zy;

/* JADX INFO: loaded from: classes.dex */
public class WXEntryActivity extends WechatHandlerActivity implements InterfaceC2311zy {

    /* JADX INFO: renamed from: a */
    private InterfaceC2310zx f8873a;

    @Override // p000.InterfaceC2311zy
    /* JADX INFO: renamed from: a */
    public void mo8370a(AbstractC2300zn abstractC2300zn) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f8873a = C2312zz.m12569a(this, "wxfef357e50e890305", false);
        this.f8873a.mo13a("wxfef357e50e890305");
    }

    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity
    public void onGetMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        startActivity(getPackageManager().getLaunchIntentForPackage(getPackageName()));
    }

    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity
    public void onShowMessageFromWXReq(WXMediaMessage wXMediaMessage) {
        if (wXMediaMessage == null || wXMediaMessage.mediaObject == null || !(wXMediaMessage.mediaObject instanceof WXAppExtendObject)) {
            return;
        }
        Toast.makeText(this, ((WXAppExtendObject) wXMediaMessage.mediaObject).extInfo, 0).show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.sharesdk.wechat.utils.WechatHandlerActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        this.f8873a.mo12a(intent, this);
    }

    @Override // p000.InterfaceC2311zy
    /* JADX INFO: renamed from: a */
    public void mo8371a(AbstractC2301zo abstractC2301zo) {
        int i = abstractC2301zo.f13806a;
        Toast.makeText(this, i != -4 ? i != -2 ? i != 0 ? R.string.errcode_unknown : R.string.errcode_success : R.string.errcode_cancel : R.string.errcode_deny, 1).show();
    }
}
