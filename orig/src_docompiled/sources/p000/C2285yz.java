package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/* JADX INFO: renamed from: yz */
/* JADX INFO: loaded from: classes.dex */
final class C2285yz extends AbstractC2288zb {
    public C2285yz(Context context) {
        super(context);
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: a */
    protected final void mo12519a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to sharedPreferences");
            SharedPreferences.Editor editorEdit = PreferenceManager.getDefaultSharedPreferences(this.f13775a).edit();
            editorEdit.putString(C2290zd.m12540c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
            editorEdit.commit();
        }
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: a */
    protected final boolean mo12520a() {
        return true;
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: b */
    protected final String mo12521b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from sharedPreferences");
            string = PreferenceManager.getDefaultSharedPreferences(this.f13775a).getString(C2290zd.m12540c("4kU71lN96TJUomD1vOU9lgj9Tw=="), null);
        }
        return string;
    }
}
