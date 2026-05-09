package android.support.multidex;

import android.app.Application;
import android.content.Context;
import p000.C0788cc;

/* JADX INFO: loaded from: classes.dex */
public class MultiDexApplication extends Application {
    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        C0788cc.m5746a(this);
    }
}
