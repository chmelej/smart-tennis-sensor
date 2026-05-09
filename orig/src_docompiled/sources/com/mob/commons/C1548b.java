package com.mob.commons;

import android.content.Context;
import cn.sharesdk.framework.ShareSDK;
import com.mob.tools.MobLog;
import com.mob.tools.network.NetworkHelper;
import com.mob.tools.utils.ReflectHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* JADX INFO: renamed from: com.mob.commons.b */
/* JADX INFO: compiled from: CommonNetworkHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1548b extends NetworkHelper {

    /* JADX INFO: renamed from: a */
    private static final String[] f8973a = {ShareSDK.SDK_TAG, "SMSSDK", "SHAREREC", "MOBAPI", "MOBLINK"};

    /* JADX INFO: renamed from: b */
    private static C1548b f8974b;

    /* JADX INFO: renamed from: c */
    private Context f8975c;

    /* JADX INFO: renamed from: d */
    private HashMap<String, MobProduct> f8976d = new HashMap<>();

    private C1548b(Context context) {
        this.f8975c = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public static C1548b m8511a(Context context) {
        if (f8974b == null) {
            f8974b = new C1548b(context);
        }
        return f8974b;
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<MobProduct> m8513a() {
        try {
            ReflectHelper.importClass("com.mob.commons.*");
            for (String str : f8973a) {
                try {
                    MobProduct mobProduct = (MobProduct) ReflectHelper.newInstance(str, new Object[0]);
                    if (mobProduct != null) {
                        this.f8976d.put(mobProduct.getProductTag(), mobProduct);
                    }
                } catch (Throwable unused) {
                }
            }
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
        }
        ArrayList<MobProduct> arrayList = new ArrayList<>();
        Iterator<Map.Entry<String, MobProduct>> it = this.f8976d.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public String m8512a(ArrayList<MobProduct> arrayList) {
        try {
            Object objInvokeStaticMethod = ReflectHelper.invokeStaticMethod("DeviceHelper", "getInstance", this.f8975c);
            String str = ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getPackageName", new Object[0]) + "/" + ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getAppVersionName", new Object[0]);
            int size = arrayList.size();
            String str2 = "";
            for (int i = 0; i < size; i++) {
                try {
                    if (str2.length() > 0) {
                        str2 = str2 + " ";
                    }
                    MobProduct mobProduct = arrayList.get(i);
                    str2 = str2 + mobProduct.getProductTag() + "/" + mobProduct.getSdkver();
                } catch (Throwable unused) {
                }
            }
            String str3 = "Android/" + ReflectHelper.invokeInstanceMethod(objInvokeStaticMethod, "getOSVersionInt", new Object[0]);
            String id = TimeZone.getDefault().getID();
            String str4 = "Lang/" + Locale.getDefault().toString().replace("-r", "-");
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(" ");
            sb.append(str2);
            sb.append(str2.length() > 0 ? " " : "");
            sb.append(str3);
            sb.append(" ");
            sb.append(id);
            sb.append(" ");
            sb.append(str4);
            return sb.toString();
        } catch (Throwable th) {
            MobLog.getInstance().m8622w(th);
            return "";
        }
    }

    /* JADX INFO: renamed from: a */
    public void m8514a(MobProduct mobProduct) {
        if (mobProduct == null || this.f8976d.containsKey(mobProduct.getProductTag())) {
            return;
        }
        this.f8976d.put(mobProduct.getProductTag(), mobProduct);
    }
}
