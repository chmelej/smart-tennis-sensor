package p000;

import android.content.Context;
import android.text.TextUtils;

/* JADX INFO: compiled from: UTFactroy.java */
/* JADX INFO: loaded from: classes.dex */
public class arj {

    /* JADX INFO: renamed from: a */
    private static final arj f4858a = new arj();

    /* JADX INFO: renamed from: b */
    private volatile ari f4859b = null;

    private arj() {
    }

    /* JADX INFO: renamed from: a */
    public static arj m5272a() {
        return f4858a;
    }

    /* JADX INFO: renamed from: a */
    public final ari m5273a(Context context) {
        if (this.f4859b == null) {
            String strM4897j = apo.m4897j(context);
            if (!TextUtils.isEmpty(strM4897j)) {
                this.f4859b = (ari) Class.forName(strM4897j).newInstance();
                String strM4883c = apo.m4883c(context);
                String strM4887d = apo.m4887d(context);
                if (!TextUtils.isEmpty(strM4883c) && !TextUtils.isEmpty(strM4887d)) {
                    this.f4859b.m5271a(context, strM4883c, apo.m4890e(context), strM4887d);
                } else {
                    this.f4859b = null;
                }
            }
        }
        return this.f4859b;
    }

    /* JADX INFO: renamed from: a */
    public final void m5274a(Context context, Object obj, String... strArr) {
        try {
            if (this.f4859b != null) {
                m5273a(context).m5269a(273791437, "agoo_android_module", apo.m4892f(context), obj, strArr);
            }
        } catch (Throwable unused) {
        }
    }
}
