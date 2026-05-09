package p000;

import android.content.Context;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMCCStorageManager.java */
/* JADX INFO: loaded from: classes.dex */
public class agr {

    /* JADX INFO: renamed from: a */
    private static Context f858a;

    /* JADX INFO: renamed from: agr$a */
    /* JADX INFO: compiled from: UMCCStorageManager.java */
    static final class C0103a {

        /* JADX INFO: renamed from: a */
        private static final agr f859a = new agr();
    }

    private agr() {
        Context context = f858a;
    }

    /* JADX INFO: renamed from: a */
    public static agr m960a(Context context) {
        f858a = context;
        return C0103a.f859a;
    }

    /* JADX INFO: renamed from: a */
    public void m965a(agl aglVar, Map<List<String>, agn> map) {
        try {
            try {
                ade.m326a(aec.m455a(f858a).m458b(), map.values());
                aglVar.mo819a("success", false);
            } catch (Exception unused) {
                aex.m776c("save agg data error");
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m961a() {
        try {
            try {
                return ade.m319a(aec.m455a(f858a).m457a());
            } catch (Exception unused) {
                aex.m776c("upload agg date error");
                aec.m455a(f858a).m459c();
                return null;
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m962a(agl aglVar) {
        try {
            try {
                return ade.m318a(aglVar, aec.m455a(f858a).m457a());
            } catch (Exception e) {
                e.printStackTrace();
                aec.m455a(f858a).m459c();
                return null;
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m966a(agl aglVar, boolean z) {
        try {
            try {
                ade.m323a(aec.m455a(f858a).m458b(), z, aglVar);
            } catch (Exception unused) {
                aex.m776c("notifyUploadSuccess error");
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m963a(agl aglVar, String str, long j, long j2) {
        try {
            try {
                ade.m321a(aec.m455a(f858a).m458b(), str, j, j2);
                aglVar.mo819a("success", false);
            } catch (Exception unused) {
                aex.m776c("package size to big or envelopeOverflowPackageCount exception");
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: a */
    public void m964a(agl aglVar, List<String> list) {
        try {
            try {
                ade.m320a(aglVar, aec.m455a(f858a).m458b(), list);
            } catch (Exception unused) {
                aex.m776c("saveToLimitCKTable exception");
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: b */
    public void m967b(agl aglVar, Map<String, ago> map) {
        try {
            try {
                ade.m322a(aec.m455a(f858a).m458b(), map, aglVar);
            } catch (Exception unused) {
                aex.m776c("arrgetated system buffer exception");
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }

    /* JADX INFO: renamed from: c */
    public void m968c(agl aglVar, Map<List<String>, agn> map) {
        try {
            try {
                ade.m324a(aglVar, aec.m455a(f858a).m458b(), map.values());
            } catch (Exception unused) {
                aex.m776c("cacheToData error");
            }
        } finally {
            aec.m455a(f858a).m459c();
        }
    }
}
