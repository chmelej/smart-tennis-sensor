package p000;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;
import com.umeng.message.MsgConstant;

/* JADX INFO: renamed from: za */
/* JADX INFO: loaded from: classes.dex */
public final class C2287za extends AbstractC2288zb {
    public C2287za(Context context) {
        super(context);
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: a */
    protected final void mo12519a(String str) {
        synchronized (this) {
            Log.i("MID", "write mid to Settings.System");
            Settings.System.putString(this.f13775a.getContentResolver(), C2290zd.m12540c("4kU71lN96TJUomD1vOU9lgj9Tw=="), str);
        }
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: a */
    protected final boolean mo12520a() {
        return C2290zd.m12536a(this.f13775a, MsgConstant.PERMISSION_WRITE_SETTINGS);
    }

    @Override // p000.AbstractC2288zb
    /* JADX INFO: renamed from: b */
    protected final String mo12521b() {
        String string;
        synchronized (this) {
            Log.i("MID", "read mid from Settings.System");
            string = Settings.System.getString(this.f13775a.getContentResolver(), C2290zd.m12540c("4kU71lN96TJUomD1vOU9lgj9Tw=="));
        }
        return string;
    }
}
