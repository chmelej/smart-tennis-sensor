package p000;

import org.json.JSONObject;

/* JADX INFO: compiled from: URequest.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class atm {

    /* JADX INFO: renamed from: a */
    protected static String f5051a = "POST";

    /* JADX INFO: renamed from: b */
    protected static String f5052b = "GET";

    /* JADX INFO: renamed from: c */
    protected String f5053c;

    /* JADX INFO: renamed from: a */
    public abstract JSONObject mo1534a();

    /* JADX INFO: renamed from: b */
    public abstract String mo1535b();

    /* JADX INFO: renamed from: c */
    protected String m5444c() {
        return f5051a;
    }

    public atm(String str) {
        this.f5053c = str;
    }

    /* JADX INFO: renamed from: a */
    public void m5443a(String str) {
        this.f5053c = str;
    }
}
