package p000;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: compiled from: Res.java */
/* JADX INFO: loaded from: classes.dex */
public class atk {

    /* JADX INFO: renamed from: a */
    private static final String f5038a = "atk";

    /* JADX INFO: renamed from: b */
    private static atk f5039b;

    /* JADX INFO: renamed from: c */
    private Resources f5040c;

    /* JADX INFO: renamed from: d */
    private final String f5041d;

    /* JADX INFO: renamed from: e */
    private final String f5042e = "drawable";

    /* JADX INFO: renamed from: f */
    private final String f5043f = "id";

    /* JADX INFO: renamed from: g */
    private final String f5044g = "layout";

    /* JADX INFO: renamed from: h */
    private final String f5045h = "anim";

    /* JADX INFO: renamed from: i */
    private final String f5046i = "style";

    /* JADX INFO: renamed from: j */
    private final String f5047j = "string";

    /* JADX INFO: renamed from: k */
    private final String f5048k = "array";

    private atk(Context context) {
        this.f5040c = context.getResources();
        this.f5041d = context.getPackageName();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized atk m5432a(Context context) {
        if (f5039b == null) {
            f5039b = new atk(context.getApplicationContext());
        }
        return f5039b;
    }

    /* JADX INFO: renamed from: a */
    public int m5433a(String str) {
        return m5431a(str, "id");
    }

    /* JADX INFO: renamed from: b */
    public int m5434b(String str) {
        return m5431a(str, "drawable");
    }

    /* JADX INFO: renamed from: c */
    public int m5435c(String str) {
        return m5431a(str, "layout");
    }

    /* JADX INFO: renamed from: d */
    public int m5436d(String str) {
        return m5431a(str, "string");
    }

    /* JADX INFO: renamed from: a */
    private int m5431a(String str, String str2) {
        int identifier = this.f5040c.getIdentifier(str, str2, this.f5041d);
        if (identifier != 0) {
            return identifier;
        }
        atj.m5425b(f5038a, "getRes(" + str2 + "/ " + str + ")");
        atj.m5425b(f5038a, "Error getting resource. Make sure you have copied all resources (res/) from SDK to your project. ");
        return 0;
    }
}
