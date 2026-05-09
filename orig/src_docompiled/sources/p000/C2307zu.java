package p000;

import android.os.Bundle;
import p000.C2308zv;

/* JADX INFO: renamed from: zu */
/* JADX INFO: loaded from: classes.dex */
public class C2307zu {

    /* JADX INFO: renamed from: zu$a */
    public static class a extends AbstractC2300zn {

        /* JADX INFO: renamed from: c */
        public C2308zv f13825c;

        /* JADX INFO: renamed from: d */
        public String f13826d;

        /* JADX INFO: renamed from: e */
        public String f13827e;

        public a() {
        }

        public a(Bundle bundle) {
            mo12564a(bundle);
        }

        @Override // p000.AbstractC2300zn
        /* JADX INFO: renamed from: a */
        public void mo12564a(Bundle bundle) {
            super.mo12564a(bundle);
            this.f13826d = bundle.getString("_wxapi_showmessage_req_lang");
            this.f13827e = bundle.getString("_wxapi_showmessage_req_country");
            this.f13825c = C2308zv.a.m12567a(bundle);
        }
    }
}
