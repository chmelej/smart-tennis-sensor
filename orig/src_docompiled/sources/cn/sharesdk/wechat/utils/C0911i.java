package cn.sharesdk.wechat.utils;

import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import com.mob.tools.utils.Hashon;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.wechat.utils.i */
/* JADX INFO: compiled from: WechatHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class C0911i {

    /* JADX INFO: renamed from: a */
    private Platform f5946a;

    /* JADX INFO: renamed from: b */
    private Platform.ShareParams f5947b;

    /* JADX INFO: renamed from: c */
    private PlatformActionListener f5948c;

    /* JADX INFO: renamed from: d */
    private AuthorizeListener f5949d;

    /* JADX INFO: renamed from: e */
    private C0909g f5950e;

    public C0911i(Platform platform) {
        this.f5946a = platform;
    }

    /* JADX INFO: renamed from: a */
    public void m6575a(AuthorizeListener authorizeListener) {
        this.f5949d = authorizeListener;
    }

    /* JADX INFO: renamed from: a */
    public void m6574a(Platform.ShareParams shareParams, PlatformActionListener platformActionListener) {
        this.f5947b = shareParams;
        this.f5948c = platformActionListener;
    }

    /* JADX INFO: renamed from: a */
    public void m6577a(C0909g c0909g) {
        this.f5950e = c0909g;
    }

    /* JADX INFO: renamed from: a */
    public void m6576a(WechatResp wechatResp) {
        int i = wechatResp.f5920f;
        if (i == 0) {
            switch (wechatResp.mo6545a()) {
                case 1:
                    if (this.f5949d != null) {
                        Bundle bundle = new Bundle();
                        wechatResp.mo6547b(bundle);
                        this.f5950e.m6558a(bundle, this.f5949d);
                    }
                    break;
                case 2:
                    if (this.f5948c != null) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put("ShareParams", this.f5947b);
                        this.f5948c.onComplete(this.f5946a, 9, map);
                    }
                    break;
            }
        }
        switch (i) {
            case -4:
                HashMap map2 = new HashMap();
                map2.put("errCode", Integer.valueOf(wechatResp.f5920f));
                map2.put("errStr", wechatResp.f5921g);
                map2.put("transaction", wechatResp.f5922h);
                Throwable th = new Throwable(new Hashon().fromHashMap(map2));
                if (wechatResp.mo6545a() == 1 && this.f5949d != null) {
                    this.f5949d.onError(th);
                }
                break;
            case -3:
                HashMap map3 = new HashMap();
                map3.put("errCode", Integer.valueOf(wechatResp.f5920f));
                map3.put("errStr", wechatResp.f5921g);
                map3.put("transaction", wechatResp.f5922h);
                Throwable th2 = new Throwable(new Hashon().fromHashMap(map3));
                switch (wechatResp.mo6545a()) {
                    case 1:
                        if (this.f5949d != null) {
                            this.f5949d.onError(th2);
                        }
                        break;
                    case 2:
                        if (this.f5948c != null) {
                            this.f5948c.onError(this.f5946a, 9, th2);
                        }
                        break;
                }
                break;
            case -2:
                switch (wechatResp.mo6545a()) {
                    case 1:
                        if (this.f5949d != null) {
                            this.f5949d.onCancel();
                        }
                        break;
                    case 2:
                        if (this.f5948c != null) {
                            this.f5948c.onCancel(this.f5946a, 9);
                        }
                        break;
                }
                break;
            default:
                HashMap map4 = new HashMap();
                map4.put("req", wechatResp.getClass().getSimpleName());
                map4.put("errCode", Integer.valueOf(wechatResp.f5920f));
                map4.put("errStr", wechatResp.f5921g);
                map4.put("transaction", wechatResp.f5922h);
                new Throwable(new Hashon().fromHashMap(map4)).printStackTrace();
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public Platform.ShareParams m6573a() {
        return this.f5947b;
    }

    /* JADX INFO: renamed from: b */
    public Platform m6578b() {
        return this.f5946a;
    }

    /* JADX INFO: renamed from: c */
    public PlatformActionListener m6579c() {
        return this.f5948c;
    }
}
