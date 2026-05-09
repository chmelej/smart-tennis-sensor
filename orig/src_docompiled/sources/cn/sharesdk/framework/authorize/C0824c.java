package cn.sharesdk.framework.authorize;

import android.content.Intent;

/* JADX INFO: renamed from: cn.sharesdk.framework.authorize.c */
/* JADX INFO: compiled from: SSOAuthorizeActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0824c extends C0822a {

    /* JADX INFO: renamed from: b */
    protected SSOListener f5550b;

    /* JADX INFO: renamed from: c */
    private AbstractC0825d f5551c;

    /* JADX INFO: renamed from: a */
    public void m5984a(SSOListener sSOListener) {
        this.f5550b = sSOListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        this.f5551c = this.f5546a.getSSOProcessor(this);
        if (this.f5551c == null) {
            finish();
            AuthorizeListener authorizeListener = this.f5546a.getAuthorizeListener();
            if (authorizeListener != null) {
                authorizeListener.onError(new Throwable("Failed to start SSO for " + this.f5546a.getPlatform().getName()));
                return;
            }
            return;
        }
        this.f5551c.m5985a(32973);
        this.f5551c.mo5905a();
    }

    @Override // com.mob.tools.FakeActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        this.f5551c.mo5906a(i, i2, intent);
    }

    @Override // com.mob.tools.FakeActivity
    public void onNewIntent(Intent intent) {
        this.f5551c.m5986a(intent);
    }
}
