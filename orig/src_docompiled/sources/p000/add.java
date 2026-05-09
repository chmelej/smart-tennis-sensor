package p000;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: InternalConfig.java */
/* JADX INFO: loaded from: classes.dex */
public class add {

    /* JADX INFO: renamed from: a */
    private static String[] f387a = new String[2];

    /* JADX INFO: renamed from: a */
    public static String[] m316a(Context context) {
        String[] strArrM812a;
        if (!TextUtils.isEmpty(f387a[0]) && !TextUtils.isEmpty(f387a[1])) {
            return f387a;
        }
        if (context == null || (strArrM812a = afc.m806a(context).m812a()) == null) {
            return null;
        }
        f387a[0] = strArrM812a[0];
        f387a[1] = strArrM812a[1];
        return f387a;
    }
}
