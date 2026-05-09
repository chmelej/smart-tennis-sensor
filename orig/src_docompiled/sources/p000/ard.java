package p000;

import java.util.Map;

/* JADX INFO: compiled from: MtopResponseHandler.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ard extends aqe {

    /* JADX INFO: renamed from: g */
    public static final String f4846g = "SUCCESS";

    /* JADX INFO: renamed from: h */
    public static final String f4847h = "FAIL";

    /* JADX INFO: renamed from: i */
    public static final String f4848i = "ERROR_SERVICE_NOT_AVAILABLE";

    public void onFailure(String str, String str2) {
    }

    @Override // p000.aqe
    /* JADX INFO: renamed from: a */
    protected void mo5003a(Map<String, String> map, String str) {
        try {
            arg argVarM5251a = are.m5251a(str);
            if (argVarM5251a.m5259b()) {
                onSuccess(map, argVarM5251a.m5260c());
            } else {
                onFailure(argVarM5251a.m5263e(), argVarM5251a.m5262d());
            }
        } catch (Throwable th) {
            aiv.m1421d("MtopResponseHandler", "handleSuccessMessage:" + str, th);
            onFailure(th, map, str);
        }
    }

    @Override // p000.aqe
    public void onFailure(Throwable th, String str) {
        onFailure(f4848i, str);
    }
}
