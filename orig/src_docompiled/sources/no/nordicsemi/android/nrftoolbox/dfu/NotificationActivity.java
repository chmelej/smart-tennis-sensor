package no.nordicsemi.android.nrftoolbox.dfu;

import android.app.Activity;
import android.os.Bundle;

/* JADX INFO: loaded from: classes.dex */
public class NotificationActivity extends Activity {
    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        isTaskRoot();
        finish();
    }
}
