package p000;

import android.os.Bundle;

/* JADX INFO: renamed from: zo */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC2301zo {

    /* JADX INFO: renamed from: a */
    public int f13806a;

    /* JADX INFO: renamed from: b */
    public String f13807b;

    /* JADX INFO: renamed from: c */
    public String f13808c;

    /* JADX INFO: renamed from: d */
    public String f13809d;

    /* JADX INFO: renamed from: a */
    public void mo12565a(Bundle bundle) {
        this.f13806a = bundle.getInt("_wxapi_baseresp_errcode");
        this.f13807b = bundle.getString("_wxapi_baseresp_errstr");
        this.f13808c = bundle.getString("_wxapi_baseresp_transaction");
        this.f13809d = bundle.getString("_wxapi_baseresp_openId");
    }
}
