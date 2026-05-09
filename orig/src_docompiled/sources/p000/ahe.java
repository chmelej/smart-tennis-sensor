package p000;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.PushAgent;

/* JADX INFO: compiled from: Res.java */
/* JADX INFO: loaded from: classes.dex */
public class ahe {

    /* JADX INFO: renamed from: a */
    private static final String f964a = "ahe";

    /* JADX INFO: renamed from: b */
    private static ahe f965b;

    /* JADX INFO: renamed from: d */
    private static Class f966d;

    /* JADX INFO: renamed from: e */
    private static Class f967e;

    /* JADX INFO: renamed from: f */
    private static Class f968f;

    /* JADX INFO: renamed from: g */
    private static Class f969g;

    /* JADX INFO: renamed from: h */
    private static Class f970h;

    /* JADX INFO: renamed from: i */
    private static Class f971i;

    /* JADX INFO: renamed from: j */
    private static Class f972j;

    /* JADX INFO: renamed from: k */
    private static Class f973k;

    /* JADX INFO: renamed from: c */
    private Context f974c;

    private ahe(Context context) {
        this.f974c = context.getApplicationContext();
        ahb.m1043c(f964a, "packageName=" + this.f974c.getPackageName());
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb.append(".R$drawable");
            f967e = Class.forName(sb.toString());
        } catch (ClassNotFoundException e) {
            ahb.m1041b(f964a, e.getMessage());
        }
        try {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb2.append(".R$layout");
            f968f = Class.forName(sb2.toString());
        } catch (ClassNotFoundException e2) {
            ahb.m1041b(f964a, e2.getMessage());
        }
        try {
            StringBuilder sb3 = new StringBuilder();
            sb3.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb3.append(".R$id");
            f966d = Class.forName(sb3.toString());
        } catch (ClassNotFoundException e3) {
            ahb.m1041b(f964a, e3.getMessage());
        }
        try {
            StringBuilder sb4 = new StringBuilder();
            sb4.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb4.append(".R$anim");
            f969g = Class.forName(sb4.toString());
        } catch (ClassNotFoundException e4) {
            ahb.m1041b(f964a, e4.getMessage());
        }
        try {
            StringBuilder sb5 = new StringBuilder();
            sb5.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb5.append(".R$style");
            f970h = Class.forName(sb5.toString());
        } catch (ClassNotFoundException e5) {
            ahb.m1041b(f964a, e5.getMessage());
        }
        try {
            StringBuilder sb6 = new StringBuilder();
            sb6.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb6.append(".R$string");
            f971i = Class.forName(sb6.toString());
        } catch (ClassNotFoundException e6) {
            ahb.m1041b(f964a, e6.getMessage());
        }
        try {
            StringBuilder sb7 = new StringBuilder();
            sb7.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb7.append(".R$array");
            f972j = Class.forName(sb7.toString());
        } catch (ClassNotFoundException e7) {
            ahb.m1041b(f964a, e7.getMessage());
        }
        try {
            StringBuilder sb8 = new StringBuilder();
            sb8.append(!TextUtils.isEmpty(PushAgent.getInstance(this.f974c).getResourcePackageName()) ? PushAgent.getInstance(this.f974c).getResourcePackageName() : this.f974c.getPackageName());
            sb8.append(".R$raw");
            f973k = Class.forName(sb8.toString());
        } catch (ClassNotFoundException e8) {
            ahb.m1041b(f964a, e8.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static ahe m1087a(Context context) {
        if (f965b == null) {
            f965b = new ahe(context);
        }
        return f965b;
    }

    /* JADX INFO: renamed from: a */
    public int m1088a(String str) {
        return m1086a(f967e, str);
    }

    /* JADX INFO: renamed from: b */
    public int m1089b(String str) {
        return m1086a(f973k, str);
    }

    /* JADX INFO: renamed from: a */
    private int m1086a(Class<?> cls, String str) {
        if (cls == null) {
            ahb.m1041b(f964a, "getRes(null," + str + ")");
            throw new IllegalArgumentException("ResClass is not initialized. Please make sure you have added neccessary resources. Also make sure you have " + this.f974c.getPackageName() + ".R$* configured in obfuscation. field=" + str);
        }
        try {
            return cls.getField(str).getInt(str);
        } catch (Exception e) {
            ahb.m1041b(f964a, "getRes(" + cls.getName() + ", " + str + ")");
            ahb.m1041b(f964a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
            ahb.m1041b(f964a, e.getMessage());
            return -1;
        }
    }
}
