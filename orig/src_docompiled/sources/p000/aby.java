package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/* JADX INFO: loaded from: classes.dex */
public final class aby {

    /* JADX INFO: renamed from: a */
    private static SharedPreferences f190a;

    /* JADX INFO: renamed from: a */
    public static int m125a(Context context, String str, int i) {
        return m127a(context).getInt(abt.m80a(context, "wxop_" + str), i);
    }

    /* JADX INFO: renamed from: a */
    public static long m126a(Context context, String str) {
        return m127a(context).getLong(abt.m80a(context, "wxop_" + str), 0L);
    }

    /* JADX INFO: renamed from: a */
    private static synchronized SharedPreferences m127a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(".mta-wxop", 0);
        f190a = sharedPreferences;
        if (sharedPreferences == null) {
            f190a = PreferenceManager.getDefaultSharedPreferences(context);
        }
        return f190a;
    }

    /* JADX INFO: renamed from: a */
    public static String m128a(Context context, String str, String str2) {
        return m127a(context).getString(abt.m80a(context, "wxop_" + str), str2);
    }

    /* JADX INFO: renamed from: a */
    public static void m129a(Context context, String str, long j) {
        String strM80a = abt.m80a(context, "wxop_" + str);
        SharedPreferences.Editor editorEdit = m127a(context).edit();
        editorEdit.putLong(strM80a, j);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public static void m130b(Context context, String str, int i) {
        String strM80a = abt.m80a(context, "wxop_" + str);
        SharedPreferences.Editor editorEdit = m127a(context).edit();
        editorEdit.putInt(strM80a, i);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: b */
    public static void m131b(Context context, String str, String str2) {
        String strM80a = abt.m80a(context, "wxop_" + str);
        SharedPreferences.Editor editorEdit = m127a(context).edit();
        editorEdit.putString(strM80a, str2);
        editorEdit.commit();
    }
}
