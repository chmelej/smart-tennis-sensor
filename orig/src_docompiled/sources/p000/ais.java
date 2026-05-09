package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Log;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: UTHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class ais {

    /* JADX INFO: renamed from: a */
    private static volatile boolean f1197a = false;

    /* JADX INFO: renamed from: b */
    private static volatile ari f1198b;

    /* JADX INFO: renamed from: a */
    public static final void m1377a(Context context) {
        try {
            if (f1197a) {
                return;
            }
            f1198b = arj.m5272a().m5273a(context);
            if (f1198b != null) {
                f1197a = true;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1385b(Context context) {
        try {
            if (f1197a) {
                f1197a = false;
                if (f1198b != null) {
                    f1198b.m5270a(context);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public static final String m1388c(Context context) {
        String strM12499a;
        String str = "utdid_error";
        try {
            m1377a(context);
            strM12499a = C2278ys.m12499a(context);
        } catch (Throwable unused) {
        }
        try {
            if (!TextUtils.isEmpty(strM12499a)) {
                return strM12499a;
            }
            str = "utdid_null";
            return str;
        } catch (Throwable unused2) {
            return strM12499a;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1378a(Context context, long j) {
        try {
            String strM4944n = apu.m4944n(context);
            long jCurrentTimeMillis = System.currentTimeMillis() - j;
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(273791437, "agoo_service", "" + j, "" + jCurrentTimeMillis, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m1391d(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5267a(273791437, "agoo_ervice_sec_error_start", strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1382a(Context context, String str) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_message", str, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1386b(Context context, String str) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_message_parse_error", str, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m1389c(Context context, String str) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_message_body_null", str, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1383a(Context context, String str, String str2) {
        String strM4944n = apu.m4944n(context);
        m1377a(context);
        if (f1198b != null) {
            f1198b.m5269a(273791437, "agoo_message_decrypted_error", str, str2, strM4944n);
        }
    }

    /* JADX INFO: renamed from: e */
    public static final void m1394e(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            if (f1198b != null) {
                f1198b.m5267a(273791437, "agoo_election_times", strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m1392d(Context context, String str) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_sysfile_error", str, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: e */
    public static final void m1395e(Context context, String str) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_register_error", str, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1379a(Context context, long j, long j2) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(273791437, "agoo_connect_timeout", "" + j, "" + j2, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1380a(Context context, long j, String str) {
        m1381a(context, j, str, null);
    }

    /* JADX INFO: renamed from: a */
    public static final void m1381a(Context context, long j, String str, String str2) {
        long jCurrentTimeMillis = 0;
        if (j != -1) {
            try {
                jCurrentTimeMillis = System.currentTimeMillis() - j;
            } catch (Throwable unused) {
                return;
            }
        }
        String strM4944n = apu.m4944n(context);
        m1377a(context);
        if (f1198b != null) {
            f1198b.m5269a(273791437, "agoo_connect", "" + jCurrentTimeMillis, "" + j, strM4944n, str, str2);
        }
    }

    /* JADX INFO: renamed from: f */
    public static final void m1396f(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5267a(273791437, "agoo_register", strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: f */
    public static final void m1397f(Context context, String str) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5267a(273791437, str, strM4944n);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m1384a(Context context, Throwable th) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_spyd_force_chunked", strM4944n, th);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: g */
    public static final void m1398g(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            String packageName = context.getPackageName();
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5268a(273791437, "agoo_checkpackage_stop", strM4944n, packageName);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    public static final void m1387b(Context context, String str, String str2) {
        try {
            String strM4944n = apu.m4944n(context);
            String packageName = context.getPackageName();
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(273791437, "agoo_start_method", strM4944n, str, str2, packageName);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: h */
    public static final void m1400h(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("AGOO_CONNECT", 4);
            String string = sharedPreferences.getString("AGOO_CONNECT_HOST", null);
            int i = sharedPreferences.getInt("AGOO_CONNECT_PORT", -1);
            String string2 = context.getSharedPreferences("AppStore", 4).getString("agoo_connect_type", null);
            String strM1241c = new ahp(context).m1241c();
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(273791437, "agoo_pushService_connect_success", strM4944n, string2, "ip=" + string + "&port=" + Integer.toString(i) + "&netType" + strM1241c + "&sdkVersion=" + apu.m4922a());
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: i */
    public static final void m1402i(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            SharedPreferences sharedPreferences = context.getSharedPreferences("AGOO_CONNECT", 4);
            String string = sharedPreferences.getString("AGOO_CONNECT_HOST", null);
            int i = sharedPreferences.getInt("AGOO_CONNECT_PORT", -1);
            String string2 = context.getSharedPreferences("AppStore", 4).getString("agoo_connect_type", null);
            String strM1241c = new ahp(context).m1241c();
            LinkedHashMap<String, String> linkedHashMapM4907t = apo.m4907t(context);
            m1377a(context);
            if (linkedHashMapM4907t != null && linkedHashMapM4907t.size() > 0 && f1198b != null) {
                f1198b.m5269a(273791437, "agoo_pushservice_connect_error", strM4944n, string2, "ip=" + string + "&port=" + Integer.toString(i) + "&netType=" + strM1241c + "&sdkVersion=" + apu.m4922a() + "&errorId=" + linkedHashMapM4907t.get("errorId") + "&url=" + linkedHashMapM4907t.get("url"));
            }
            LinkedHashMap<String, String> linkedHashMapM4908u = apo.m4908u(context);
            if (linkedHashMapM4908u == null || linkedHashMapM4908u.size() <= 0 || f1198b == null) {
                return;
            }
            f1198b.m5269a(273791437, "agoo_pushservice_connect_error", strM4944n, string2, "ip=" + string + "&port=" + Integer.toString(i) + "&netType=" + strM1241c + "&sdkVersion=" + apu.m4922a() + "&dnsErrorId=" + linkedHashMapM4908u.get("dnsErrorId") + "&dnsUrl=" + linkedHashMapM4908u.get("dnsUrl"));
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: j */
    public static final void m1403j(Context context) {
        try {
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5267a(273791437, "agoo_somanager_start", "");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m1390c(Context context, String str, String str2) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(66002, "agoo_event_register_log", strM4944n, str, str2);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: d */
    public static final void m1393d(Context context, String str, String str2) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(66002, "agoo_event_election_log", strM4944n, str, str2);
            }
        } catch (Throwable th) {
            Log.d("UTHelper", "doElectionLog error,exception=" + th);
        }
    }

    /* JADX INFO: renamed from: k */
    public static final void m1404k(Context context) {
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            ahp ahpVar = new ahp(context);
            String strM1241c = ahpVar.m1241c();
            if (f1198b != null) {
                f1198b.m5268a(66002, "agoo_event_force_http", strM4944n, "netType=" + strM1241c + "&isWapNetwork=" + ahpVar.m1239a() + "&sdkVersion=" + apu.m4922a());
            }
        } catch (Throwable th) {
            Log.d("UTHelper", "doElectionLog error,exception=" + th);
        }
    }

    /* JADX INFO: renamed from: g */
    public static final void m1399g(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(66002, "agoo_event_election_result_log", strM4944n, null, str);
            }
        } catch (Throwable th) {
            Log.d("UTHelper", "doConnectLog error,exception=" + th);
        }
    }

    /* JADX INFO: renamed from: h */
    public static final void m1401h(Context context, String str) {
        if (str == null) {
            return;
        }
        try {
            String strM4944n = apu.m4944n(context);
            m1377a(context);
            if (f1198b != null) {
                f1198b.m5269a(66002, "agoo_event_register_begin_log", strM4944n, null, str);
            }
        } catch (Throwable th) {
            Log.d("UTHelper", "doConnectLog error,exception=" + th);
        }
    }
}
