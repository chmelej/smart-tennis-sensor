package p000;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aak extends aai {

    /* JADX INFO: renamed from: a */
    public static final ace f51a;

    static {
        ace aceVar = new ace();
        f51a = aceVar;
        aceVar.m227a("A9VH9B8L4GX4");
    }

    public aak(Context context) {
        super(context, 0, f51a);
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: a */
    public final boolean mo18a(JSONObject jSONObject) {
        abz.m134a(jSONObject, "actky", acb.m152a(this.f39l));
        return true;
    }

    @Override // p000.aai
    /* JADX INFO: renamed from: b */
    public final aaj mo19b() {
        return aaj.NETWORK_DETECTOR;
    }
}
