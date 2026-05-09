package p000;

import android.os.Bundle;

/* JADX INFO: renamed from: zr */
/* JADX INFO: loaded from: classes.dex */
public class C2304zr {

    /* JADX INFO: renamed from: zr$a */
    public static class a extends AbstractC2300zn {

        /* JADX INFO: renamed from: c */
        public String f13816c;

        /* JADX INFO: renamed from: d */
        public String f13817d;

        /* JADX INFO: renamed from: e */
        public String f13818e;

        /* JADX INFO: renamed from: f */
        public String f13819f;

        public a() {
        }

        public a(Bundle bundle) {
            mo12564a(bundle);
        }

        @Override // p000.AbstractC2300zn
        /* JADX INFO: renamed from: a */
        public void mo12564a(Bundle bundle) {
            super.mo12564a(bundle);
            this.f13816c = bundle.getString("_wxobject_message_action");
            this.f13817d = bundle.getString("_wxobject_message_ext");
            this.f13818e = bundle.getString("_wxapi_launch_req_lang");
            this.f13819f = bundle.getString("_wxapi_launch_req_country");
        }
    }
}
