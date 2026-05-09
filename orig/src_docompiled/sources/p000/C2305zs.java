package p000;

import android.os.Bundle;

/* JADX INFO: renamed from: zs */
/* JADX INFO: loaded from: classes.dex */
public final class C2305zs {

    /* JADX INFO: renamed from: zs$a */
    public static class a extends AbstractC2301zo {

        /* JADX INFO: renamed from: e */
        public String f13820e;

        /* JADX INFO: renamed from: f */
        public String f13821f;

        /* JADX INFO: renamed from: g */
        public String f13822g;

        /* JADX INFO: renamed from: h */
        public String f13823h;

        /* JADX INFO: renamed from: i */
        public String f13824i;

        public a() {
        }

        public a(Bundle bundle) {
            mo12565a(bundle);
        }

        @Override // p000.AbstractC2301zo
        /* JADX INFO: renamed from: a */
        public void mo12565a(Bundle bundle) {
            super.mo12565a(bundle);
            this.f13820e = bundle.getString("_wxapi_sendauth_resp_token");
            this.f13821f = bundle.getString("_wxapi_sendauth_resp_state");
            this.f13822g = bundle.getString("_wxapi_sendauth_resp_url");
            this.f13823h = bundle.getString("_wxapi_sendauth_resp_lang");
            this.f13824i = bundle.getString("_wxapi_sendauth_resp_country");
        }
    }
}
