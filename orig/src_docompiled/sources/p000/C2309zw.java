package p000;

import android.os.Bundle;

/* JADX INFO: renamed from: zw */
/* JADX INFO: loaded from: classes.dex */
public class C2309zw extends AbstractC2301zo {

    /* JADX INFO: renamed from: e */
    public String f13836e;

    /* JADX INFO: renamed from: f */
    public String f13837f;

    /* JADX INFO: renamed from: g */
    public String f13838g;

    public C2309zw() {
    }

    public C2309zw(Bundle bundle) {
        mo12565a(bundle);
    }

    @Override // p000.AbstractC2301zo
    /* JADX INFO: renamed from: a */
    public void mo12565a(Bundle bundle) {
        super.mo12565a(bundle);
        this.f13836e = bundle.getString("_wxapi_payresp_prepayid");
        this.f13837f = bundle.getString("_wxapi_payresp_returnkey");
        this.f13838g = bundle.getString("_wxapi_payresp_extdata");
    }
}
