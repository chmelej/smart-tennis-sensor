package p000;

import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: compiled from: IService.java */
/* JADX INFO: loaded from: classes.dex */
public interface aps {
    IBinder bind(Intent intent);

    void create(Context context, apw apwVar);

    void destroy(Context context);

    int startCommand(Intent intent, int i, int i2);

    boolean unbind(Intent intent);
}
