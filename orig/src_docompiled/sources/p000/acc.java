package p000;

/* JADX INFO: loaded from: classes.dex */
public enum acc {
    INSTANT(1),
    ONLY_WIFI(2),
    BATCH(3),
    APP_LAUNCH(4),
    DEVELOPER(5),
    PERIOD(6),
    ONLY_WIFI_NO_CACHE(7);


    /* JADX INFO: renamed from: h */
    int f247h;

    acc(int i) {
        this.f247h = i;
    }

    /* JADX INFO: renamed from: a */
    public static acc m193a(int i) {
        for (acc accVar : values()) {
            if (i == accVar.f247h) {
                return accVar;
            }
        }
        return null;
    }
}
