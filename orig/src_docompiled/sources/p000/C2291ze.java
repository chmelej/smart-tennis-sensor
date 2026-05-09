package p000;

import android.util.Base64;
import javax.crypto.Cipher;

/* JADX INFO: renamed from: ze */
/* JADX INFO: loaded from: classes.dex */
public final class C2291ze {

    /* JADX INFO: renamed from: a */
    private Cipher f13780a;

    /* JADX INFO: renamed from: a */
    public final String m12542a(String str) {
        try {
            return new String(this.f13780a.doFinal(Base64.decode(str, 0)), "UTF8");
        } catch (Exception e) {
            return "[des]" + str + "|" + e.toString();
        }
    }
}
