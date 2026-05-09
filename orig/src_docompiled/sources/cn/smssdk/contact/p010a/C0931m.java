package cn.smssdk.contact.p010a;

import android.util.Base64;

/* JADX INFO: renamed from: cn.smssdk.contact.a.m */
/* JADX INFO: compiled from: Photo.java */
/* JADX INFO: loaded from: classes.dex */
public class C0931m extends AbstractC0920b {
    /* JADX INFO: renamed from: b */
    public String m6694b() {
        byte[] bArrA = m6662a("data15");
        if (bArrA != null) {
            return Base64.encodeToString(bArrA, 2);
        }
        return null;
    }
}
