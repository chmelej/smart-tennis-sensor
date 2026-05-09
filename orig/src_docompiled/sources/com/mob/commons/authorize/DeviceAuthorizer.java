package com.mob.commons.authorize;

import android.content.Context;
import com.mob.commons.C1541a;
import com.mob.commons.C1548b;

/* JADX INFO: loaded from: classes.dex */
public final class DeviceAuthorizer {
    public static String authorize(Context context, final MobProduct mobProduct) {
        return authorize(context, new com.mob.commons.MobProduct() { // from class: com.mob.commons.authorize.DeviceAuthorizer.1
            @Override // com.mob.commons.MobProduct
            public int getSdkver() {
                return mobProduct.getSdkver();
            }

            @Override // com.mob.commons.MobProduct
            public String getProductTag() {
                return mobProduct.getProductTag();
            }

            @Override // com.mob.commons.MobProduct
            public String getProductAppkey() {
                return mobProduct.getProductAppkey();
            }
        });
    }

    public static synchronized String authorize(Context context, com.mob.commons.MobProduct mobProduct) {
        C1548b.m8511a(context).m8514a(mobProduct);
        C1547a c1547a = new C1547a();
        if (mobProduct != null && C1541a.m8450f(context)) {
            return c1547a.m8510a(context, mobProduct);
        }
        return c1547a.m8509a(context);
    }
}
