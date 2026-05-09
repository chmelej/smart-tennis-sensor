package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: Config.java */
/* JADX INFO: loaded from: classes.dex */
public class apo {
    /* JADX INFO: renamed from: a */
    public static final void m4870a(Context context) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.remove("agoo_xtoken ");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final String m4878b(Context context) {
        try {
            return m4869A(context).getString("agoo_xtoken ", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: A */
    private static SharedPreferences m4869A(Context context) {
        return context.getSharedPreferences("AppStore", 4);
    }

    /* JADX INFO: renamed from: c */
    public static String m4883c(Context context) {
        try {
            return m4869A(context).getString("app_key", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: d */
    public static String m4887d(Context context) {
        try {
            return m4869A(context).getString("app_tt_id", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: e */
    public static String m4890e(Context context) {
        try {
            return m4869A(context).getString("app_sercet", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: f */
    public static String m4892f(Context context) {
        try {
            SharedPreferences sharedPreferencesM4869A = m4869A(context);
            String string = sharedPreferencesM4869A.getString("app_device_token", "");
            try {
                int i = sharedPreferencesM4869A.getInt("app_version", ExploreByTouchHelper.INVALID_ID);
                int iM4900m = m4900m(context);
                if (i != Integer.MIN_VALUE && i != iM4900m) {
                    SharedPreferences.Editor editorEdit = sharedPreferencesM4869A.edit();
                    editorEdit.putInt("app_version", ExploreByTouchHelper.INVALID_ID);
                    editorEdit.remove("app_device_token");
                    editorEdit.commit();
                    return null;
                }
            } catch (Throwable unused) {
            }
            return string;
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: g */
    public static void m4894g(Context context) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putInt("app_version", ExploreByTouchHelper.INVALID_ID);
            editorEdit.remove("app_device_token");
            editorEdit.remove("app_key");
            editorEdit.remove("app_sercet");
            editorEdit.remove("app_tt_id");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: h */
    public static String m4895h(Context context) {
        try {
            return m4869A(context).getString("app_push_user_token", "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4873a(Context context, String str) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putString("app_push_user_token", str);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: i */
    public static final void m4896i(Context context) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.remove("app_push_user_token");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4874a(Context context, String str, String str2, String str3) {
        try {
            SharedPreferences sharedPreferencesM4869A = m4869A(context);
            String string = sharedPreferencesM4869A.getString("app_key", null);
            String string2 = sharedPreferencesM4869A.getString("app_device_token", null);
            SharedPreferences.Editor editorEdit = sharedPreferencesM4869A.edit();
            if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(str) && !TextUtils.equals(str, string)) {
                m4894g(context);
            }
            if (!TextUtils.isEmpty(string2)) {
                editorEdit.putString("old_app_device_token", string2);
            }
            editorEdit.putString("app_key", str);
            editorEdit.putString("app_tt_id", str3);
            editorEdit.putString("app_key_temp", str);
            editorEdit.putString("app_tt_id_temp", str3);
            if (!TextUtils.isEmpty(str2)) {
                editorEdit.putString("app_sercet", str2);
                editorEdit.putString("app_sercet_temp", str2);
            }
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: j */
    public static String m4897j(Context context) {
        try {
            return m4869A(context).getString("logger_class_name", null);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4876a(Context context, boolean z, boolean z2) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("app_debug", z);
            editorEdit.putBoolean("app_log_to_file", z2);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4875a(Context context, boolean z) {
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = m4869A(context).edit();
                editorEdit.putBoolean("agoo_security_mode", z);
                editorEdit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4871a(Context context, int i) {
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = m4869A(context).edit();
                editorEdit.putInt("agoo_mode", i);
                editorEdit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4880b(Context context, String str) {
        if (context != null) {
            try {
                SharedPreferences.Editor editorEdit = m4869A(context).edit();
                editorEdit.putString("agoo_service_mode", str);
                editorEdit.commit();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: k */
    public static String m4898k(Context context) {
        try {
            return m4869A(context).getString("agoo_service_mode", "taobao");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: l */
    public static boolean m4899l(Context context) {
        return m4869A(context).getBoolean("agoo_security_mode", false);
    }

    /* JADX INFO: renamed from: m */
    public static int m4900m(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return (packageInfo.versionName + "." + packageInfo.versionCode).hashCode();
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* JADX INFO: renamed from: n */
    public static boolean m4901n(Context context) {
        try {
            return m4869A(context).getBoolean("agoo_autoupdate", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4877a(Context context, boolean z, boolean z2, boolean z3, long j, boolean z4) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("agoo_autoupdate", z);
            editorEdit.putBoolean("agoo_multiplex", z2);
            editorEdit.putBoolean("agoo_spdy", z2);
            editorEdit.putLong("agoo_updateCycle", j);
            editorEdit.putBoolean("agoo_postData", z4);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4872a(Context context, long j) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putLong("agoo_update_time", j);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4882b(Context context, long j) {
        try {
            SharedPreferences sharedPreferencesM4869A = m4869A(context);
            long j2 = sharedPreferencesM4869A.getLong("agoo_update_time", 0L) + (sharedPreferencesM4869A.getLong("agoo_updateCycle", 86400L) * 1000);
            return (j2 == 0 || j == 0 || j - j2 <= 0) ? false : true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4885c(Context context, long j) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putLong("agoo_release_time", j);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: o */
    public static long m4902o(Context context) {
        try {
            return m4869A(context).getLong("agoo_release_time", 0L);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4881b(Context context, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("agoo_ifNeedAutoUpdate", z);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: p */
    public static boolean m4903p(Context context) {
        try {
            return m4869A(context).getBoolean("agoo_ifNeedAutoUpdate", true);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4886c(Context context, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("agoo_ping_message", z);
            editorEdit.commit();
            arj.m5272a().m5274a(context, "agoo_ping_message", "agoo_ping_message", "ping=" + z);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m4879b(Context context, int i) {
        if (i == -1) {
            try {
                i = m4904q(context) + 1;
            } catch (Throwable unused) {
                return;
            }
        }
        SharedPreferences.Editor editorEdit = m4869A(context).edit();
        editorEdit.putInt("agoo_http_connect", i);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: q */
    public static int m4904q(Context context) {
        try {
            return m4869A(context).getInt("agoo_http_connect", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4884c(Context context, int i) {
        if (i == -1) {
            try {
                i = m4905r(context) + 1;
            } catch (Throwable unused) {
                return;
            }
        }
        SharedPreferences.Editor editorEdit = m4869A(context).edit();
        editorEdit.putInt("agoo_spdy_connect", i);
        editorEdit.commit();
    }

    /* JADX INFO: renamed from: r */
    public static int m4905r(Context context) {
        try {
            return m4869A(context).getInt("agoo_spdy_connect", 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: d */
    public static void m4889d(Context context, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("agoo_service_protect", z);
            editorEdit.commit();
            arj.m5272a().m5274a(context, "setServiceProtect", "setServiceProtect", "protect=" + z);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: s */
    public static boolean m4906s(Context context) {
        try {
            return m4869A(context).getBoolean("agoo_service_protect", true);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: t */
    public static LinkedHashMap<String, String> m4907t(Context context) {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            try {
                SharedPreferences sharedPreferencesM4869A = m4869A(context);
                String string = sharedPreferencesM4869A.getString("agoo_push_errorid", null);
                String string2 = sharedPreferencesM4869A.getString("agoo_push_path", null);
                linkedHashMap.put("errorId", string);
                linkedHashMap.put("url", string2);
                return linkedHashMap;
            } catch (Throwable unused) {
                return linkedHashMap;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: u */
    public static LinkedHashMap<String, String> m4908u(Context context) {
        try {
            LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
            try {
                SharedPreferences sharedPreferencesM4869A = m4869A(context);
                String string = sharedPreferencesM4869A.getString("agoo_dns_errorid", null);
                String string2 = sharedPreferencesM4869A.getString("agoo_dns_path", null);
                String string3 = sharedPreferencesM4869A.getString("agoo_dns_eventid", null);
                linkedHashMap.put("dnsErrorId", string);
                linkedHashMap.put("dnsUrl", string2);
                linkedHashMap.put("dnsEvent", string3);
                return linkedHashMap;
            } catch (Throwable unused) {
                return linkedHashMap;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: v */
    public static LinkedHashMap<String, String> m4909v(Context context) {
        LinkedHashMap<String, String> linkedHashMap;
        String string;
        int i;
        String string2;
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("AGOO_CONNECT", 4);
            string = sharedPreferences.getString("AGOO_CONNECT_HOST", null);
            i = sharedPreferences.getInt("AGOO_CONNECT_PORT", -1);
            string2 = context.getSharedPreferences("AppStore", 4).getString("agoo_connect_type", null);
            linkedHashMap = new LinkedHashMap<>();
        } catch (Throwable th) {
            th = th;
            linkedHashMap = null;
        }
        try {
            linkedHashMap.put("ip", string);
            linkedHashMap.put("port", Integer.toString(i));
            linkedHashMap.put("connectType", string2);
            linkedHashMap.put("appKey", m4883c(context));
            linkedHashMap.put("deviceId", m4892f(context));
            linkedHashMap.put("agooReleaseTime", Long.toString(m4902o(context)));
        } catch (Throwable th2) {
            th = th2;
            Log.d("getConnectHeader", "e=" + th.getMessage());
        }
        return linkedHashMap;
    }

    /* JADX INFO: renamed from: e */
    public static final void m4891e(Context context, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("agoo_notic_election_result", z);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: w */
    public static final boolean m4910w(Context context) {
        try {
            return m4869A(context).getBoolean("agoo_notic_election_result", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: x */
    public static int m4911x(Context context) {
        try {
            return m4869A(context).getInt("agoo_mode", -1);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* JADX INFO: renamed from: f */
    public static final void m4893f(Context context, boolean z) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putBoolean("unregister_flag", z);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: y */
    public static boolean m4912y(Context context) {
        try {
            return m4869A(context).getBoolean("unregister_flag", false);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m4888d(Context context, int i) {
        try {
            SharedPreferences.Editor editorEdit = m4869A(context).edit();
            editorEdit.putInt("agoo_so_mangager_timeout", i);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: z */
    public static int m4913z(Context context) {
        try {
            return m4869A(context).getInt("agoo_so_mangager_timeout", 600);
        } catch (Throwable unused) {
            return 0;
        }
    }
}
