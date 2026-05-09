package p000;

import android.support.v4.view.PointerIconCompat;

/* JADX INFO: loaded from: classes.dex */
public enum aaj {
    PAGE_VIEW(1),
    SESSION_ENV(2),
    ERROR(3),
    CUSTOM(1000),
    ADDITION(PointerIconCompat.TYPE_CONTEXT_MENU),
    MONITOR_STAT(PointerIconCompat.TYPE_HAND),
    MTA_GAME_USER(PointerIconCompat.TYPE_HELP),
    NETWORK_MONITOR(PointerIconCompat.TYPE_WAIT),
    NETWORK_DETECTOR(1005);


    /* JADX INFO: renamed from: j */
    private int f50j;

    aaj(int i) {
        this.f50j = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m27a() {
        return this.f50j;
    }
}
