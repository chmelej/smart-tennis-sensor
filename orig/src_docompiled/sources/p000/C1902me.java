package p000;

import android.content.Context;
import android.content.SharedPreferences;

/* JADX INFO: renamed from: me */
/* JADX INFO: compiled from: PreferencesUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1902me {

    /* JADX INFO: renamed from: a */
    public static String f11450a = "zhinenglunhua";

    /* JADX INFO: renamed from: b */
    public static String f11451b = "refreshCookieDate";

    /* JADX INFO: renamed from: c */
    public static String f11452c = "token";

    /* JADX INFO: renamed from: d */
    public static String f11453d = "isFirstLink";

    /* JADX INFO: renamed from: e */
    public static String f11454e = "firstLinkData";

    /* JADX INFO: renamed from: a */
    public static boolean m10484a(Context context, String str, String str2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f11450a, 0).edit();
        editorEdit.putString(str, str2);
        return editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public static String m10487b(Context context, String str, String str2) {
        return context.getSharedPreferences(f11450a, 0).getString(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m10483a(Context context, String str, int i) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f11450a, 0).edit();
        editorEdit.putInt(str, i);
        return editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public static int m10486b(Context context, String str, int i) {
        return context.getSharedPreferences(f11450a, 0).getInt(str, i);
    }

    /* JADX INFO: renamed from: a */
    public static boolean m10485a(Context context, String str, boolean z) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences(f11450a, 0).edit();
        editorEdit.putBoolean(str, z);
        return editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10489b(Context context, String str, boolean z) {
        return context.getSharedPreferences(f11450a, 0).getBoolean(str, z);
    }

    /* JADX INFO: renamed from: a */
    public static void m10482a(Context context, String str) {
        m10484a(context, "UserID", str);
    }

    /* JADX INFO: renamed from: a */
    public static String m10480a(Context context) {
        return m10487b(context, "UserID", "-1");
    }

    /* JADX INFO: renamed from: a */
    public static String m10479a() {
        return m10487b(C1914mm.m10554a(), "devicetype", "TS");
    }

    /* JADX INFO: renamed from: b */
    public static boolean m10488b() {
        return m10487b(C1914mm.m10554a(), "devicetype", "TS").equalsIgnoreCase("T1");
    }

    /* JADX INFO: renamed from: a */
    public static void m10481a(int i) {
        m10483a(C1914mm.m10554a(), "hand", i);
    }

    /* JADX INFO: renamed from: c */
    public static int m10490c() {
        return m10486b(C1914mm.m10554a(), "hand", 1);
    }
}
