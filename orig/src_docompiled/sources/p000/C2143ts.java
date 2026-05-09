package p000;

import android.app.Application;
import android.content.Context;

/* JADX INFO: renamed from: ts */
/* JADX INFO: compiled from: ContextGetter.java */
/* JADX INFO: loaded from: classes.dex */
public final class C2143ts {
    /* JADX INFO: renamed from: a */
    public static Context m11708a() {
        try {
            return m11709b().getApplicationContext();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private static Application m11709b() {
        return (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke(null, (Object[]) null);
    }
}
