package cn.sharesdk.framework.authorize;

import android.content.Context;
import android.content.Intent;
import com.mob.tools.FakeActivity;

/* JADX INFO: renamed from: cn.sharesdk.framework.authorize.a */
/* JADX INFO: compiled from: AbstractAuthorizeActivity.java */
/* JADX INFO: loaded from: classes.dex */
public class C0822a extends FakeActivity {

    /* JADX INFO: renamed from: a */
    protected AuthorizeHelper f5546a;

    /* JADX INFO: renamed from: a */
    public void m5983a(AuthorizeHelper authorizeHelper) {
        this.f5546a = authorizeHelper;
        super.show(authorizeHelper.getPlatform().getContext(), null);
    }

    @Override // com.mob.tools.FakeActivity
    public void show(Context context, Intent intent) {
        throw new RuntimeException("This method is deprecated, use show(AuthorizeHelper, Intent) instead");
    }

    /* JADX INFO: renamed from: a */
    public AuthorizeHelper m5982a() {
        return this.f5546a;
    }
}
