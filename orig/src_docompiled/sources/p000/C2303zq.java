package p000;

import android.os.Bundle;

/* JADX INFO: renamed from: zq */
/* JADX INFO: loaded from: classes.dex */
public final class C2303zq {

    /* JADX INFO: renamed from: zq$a */
    public static class a extends AbstractC2300zn {

        /* JADX INFO: renamed from: c */
        public String f13814c;

        /* JADX INFO: renamed from: d */
        public String f13815d;

        public a() {
        }

        public a(Bundle bundle) {
            mo12564a(bundle);
        }

        @Override // p000.AbstractC2300zn
        /* JADX INFO: renamed from: a */
        public void mo12564a(Bundle bundle) {
            super.mo12564a(bundle);
            this.f13814c = bundle.getString("_wxapi_getmessage_req_lang");
            this.f13815d = bundle.getString("_wxapi_getmessage_req_country");
        }
    }
}
