package cn.sharesdk.framework;

import cn.sharesdk.framework.authorize.AbstractC0825d;
import cn.sharesdk.framework.authorize.AuthorizeHelper;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.C0824c;
import cn.sharesdk.framework.authorize.C0826e;
import cn.sharesdk.framework.authorize.SSOListener;

/* JADX INFO: renamed from: cn.sharesdk.framework.b */
/* JADX INFO: compiled from: PlatformHelper.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0827b implements AuthorizeHelper {

    /* JADX INFO: renamed from: a */
    protected Platform f5563a;

    /* JADX INFO: renamed from: b */
    private AuthorizeListener f5564b;

    /* JADX INFO: renamed from: c */
    private SSOListener f5565c;

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AbstractC0825d getSSOProcessor(C0824c c0824c) {
        return null;
    }

    public AbstractC0827b(Platform platform) {
        this.f5563a = platform;
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public Platform getPlatform() {
        return this.f5563a;
    }

    /* JADX INFO: renamed from: c */
    public int m5994c() {
        return this.f5563a.getPlatformId();
    }

    /* JADX INFO: renamed from: b */
    protected void m5993b(AuthorizeListener authorizeListener) {
        this.f5564b = authorizeListener;
        C0826e c0826e = new C0826e();
        c0826e.m5990a(this.f5564b);
        c0826e.m5983a(this);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public AuthorizeListener getAuthorizeListener() {
        return this.f5564b;
    }

    /* JADX INFO: renamed from: a */
    protected void m5992a(SSOListener sSOListener) {
        this.f5565c = sSOListener;
        C0824c c0824c = new C0824c();
        c0824c.m5984a(sSOListener);
        c0824c.m5983a(this);
    }

    @Override // cn.sharesdk.framework.authorize.AuthorizeHelper
    public SSOListener getSSOListener() {
        return this.f5565c;
    }
}
