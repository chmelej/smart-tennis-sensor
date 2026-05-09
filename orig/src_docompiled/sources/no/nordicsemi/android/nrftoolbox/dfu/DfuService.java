package no.nordicsemi.android.nrftoolbox.dfu;

import android.app.Activity;
import no.nordicsemi.android.dfu.DfuBaseService;

/* JADX INFO: loaded from: classes.dex */
public class DfuService extends DfuBaseService {
    @Override // no.nordicsemi.android.dfu.DfuBaseService
    /* JADX INFO: renamed from: c */
    protected Class<? extends Activity> mo10790c() {
        return NotificationActivity.class;
    }
}
