package p000;

import android.os.Bundle;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

/* JADX INFO: renamed from: zp */
/* JADX INFO: loaded from: classes.dex */
public class C2302zp {

    /* JADX INFO: renamed from: zp$a */
    public static class a extends AbstractC2301zo {

        /* JADX INFO: renamed from: e */
        public List<b> f13810e;

        public a() {
        }

        public a(Bundle bundle) {
            mo12565a(bundle);
        }

        @Override // p000.AbstractC2301zo
        /* JADX INFO: renamed from: a */
        public void mo12565a(Bundle bundle) {
            super.mo12565a(bundle);
            if (this.f13810e == null) {
                this.f13810e = new LinkedList();
            }
            String string = bundle.getString("_wxapi_add_card_to_wx_card_list");
            if (string == null || string.length() <= 0) {
                return;
            }
            try {
                JSONArray jSONArray = ((JSONObject) new JSONTokener(string).nextValue()).getJSONArray("card_list");
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    b bVar = new b();
                    bVar.f13811a = jSONObject.optString("card_id");
                    bVar.f13812b = jSONObject.optString("card_ext");
                    bVar.f13813c = jSONObject.optInt("is_succ");
                    this.f13810e.add(bVar);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: renamed from: zp$b */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public String f13811a;

        /* JADX INFO: renamed from: b */
        public String f13812b;

        /* JADX INFO: renamed from: c */
        public int f13813c;
    }
}
