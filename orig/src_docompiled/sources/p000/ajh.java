package p000;

import android.content.Context;
import com.umeng.update.util.DeltaUpdate;

/* JADX INFO: compiled from: UpdateClient.java */
/* JADX INFO: loaded from: classes.dex */
public class ajh extends atl {

    /* JADX INFO: renamed from: c */
    private static final String f1270c = "ajh";

    /* JADX INFO: renamed from: a */
    Context f1271a;

    /* JADX INFO: renamed from: b */
    private final String[] f1272b = {"http://au.umeng.com/api/check_app_update", "http://au.umeng.co/api/check_app_update"};

    @Override // p000.atl
    /* JADX INFO: renamed from: a */
    public boolean mo1516a() {
        return false;
    }

    public ajh(Context context) {
        this.f1271a = context;
    }

    /* JADX INFO: renamed from: b */
    public ajg m1517b() {
        atj.m5427c(f1270c, String.format("is .so file ready: %b", Boolean.valueOf(DeltaUpdate.m8791a())));
        ajj ajjVar = new ajj(this.f1271a);
        ajg ajgVar = null;
        for (int i = 0; i < this.f1272b.length; i++) {
            ajjVar.m5443a(this.f1272b[i]);
            ajgVar = (ajg) m5442a(ajjVar, ajg.class);
            if (ajgVar != null) {
                break;
            }
        }
        return ajgVar;
    }
}
