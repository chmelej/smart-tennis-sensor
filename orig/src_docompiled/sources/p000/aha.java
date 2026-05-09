package p000;

import android.content.Context;
import android.provider.Settings;

/* JADX INFO: compiled from: AndroidIdTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class aha extends agz {

    /* JADX INFO: renamed from: a */
    private Context f908a;

    public aha(Context context) {
        super("android_id");
        this.f908a = context;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        try {
            return Settings.Secure.getString(this.f908a.getContentResolver(), "android_id");
        } catch (Exception unused) {
            return null;
        }
    }
}
