package p000;

import android.content.Context;
import java.io.ByteArrayInputStream;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: MtopRequestHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class arc {
    /* JADX INFO: renamed from: a */
    public static final void m5250a(arb arbVar, String str, String str2) {
        try {
            if (!aie.m1309a(str) && aie.m1309a(arbVar.m5244k())) {
                arbVar.m5238f(str);
            }
            if (aie.m1309a(str2) || !aie.m1309a(arbVar.m5245l())) {
                return;
            }
            arbVar.m5240g(str2);
        } catch (Throwable th) {
            aiv.m1419c("MtopRequestHelper", "checkAppKeyAndAppSecret", th);
        }
    }

    /* JADX INFO: renamed from: a */
    public static final aqf m5247a(Context context, arb arbVar) {
        String str;
        String strM1300b;
        if (arbVar == null) {
            return null;
        }
        try {
            aqf aqfVar = new aqf();
            try {
                aqfVar.m5012a("api", arbVar.m5237f());
                aqfVar.m5012a("v", arbVar.m5239g());
                long jM5228b = arbVar.m5228b();
                if (jM5228b <= 0) {
                    jM5228b = m5246a();
                }
                long j = jM5228b;
                aqfVar.m5012a("t", "" + j);
                if (context != null) {
                    String strM1298a = aic.m1298a(context);
                    strM1300b = aic.m1300b(context);
                    str = strM1298a;
                } else {
                    str = null;
                    strM1300b = null;
                }
                aqfVar.m5012a("imei", str);
                aqfVar.m5012a("imsi", strM1300b);
                aqfVar.m5012a("ttid", arbVar.m5235e());
                aqfVar.m5012a("appKey", arbVar.m5244k());
                if (!aie.m1309a(arbVar.m5231c())) {
                    aqfVar.m5012a("deviceId", arbVar.m5231c());
                }
                Map<String, String> mapM5233d = arbVar.m5233d();
                if (mapM5233d != null && (r14 = mapM5233d.entrySet().iterator()) != null) {
                    for (Map.Entry<String, String> entry : mapM5233d.entrySet()) {
                        if (entry != null && !aie.m1309a(entry.getKey()) && !aie.m1309a(entry.getValue())) {
                            aqfVar.m5012a(entry.getKey(), entry.getValue());
                        }
                    }
                }
                String strM5249a = m5249a(arbVar.m5243j());
                if (aie.m1309a(strM5249a)) {
                    aiv.m1420d("MtopRequestHelper", "data==null");
                }
                String strM5244k = arbVar.m5244k();
                if (aie.m1309a(strM5244k)) {
                    aiv.m1420d("MtopRequestHelper", "appkey==null");
                }
                String strM5245l = arbVar.m5245l();
                if (arbVar.m5227a()) {
                    String strM5248a = m5248a(strM5244k, strM5245l, arbVar.m5237f(), arbVar.m5239g(), str, strM1300b, j, strM5249a, arbVar.m5242i());
                    if (!aie.m1309a(strM5249a)) {
                        aqfVar.m5012a("sign", strM5248a);
                    } else {
                        aiv.m1420d("MtopRequestHelper", "sign==null");
                    }
                }
                if (!aie.m1309a(strM5249a)) {
                    aqfVar.m5012a("data", strM5249a);
                } else {
                    aiv.m1420d("MtopRequestHelper", "data==null");
                }
                if (aie.m1309a(arbVar.m5241h())) {
                    return aqfVar;
                }
                aqfVar.m5012a("sid", arbVar.m5241h());
                return aqfVar;
            } catch (Throwable unused) {
                return aqfVar;
            }
        } catch (Throwable unused2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static final long m5246a() {
        try {
            return System.currentTimeMillis() / 1000;
        } catch (Throwable th) {
            aiv.m1419c("MtopRequestHelper", "getTime", th);
            return 0L;
        }
    }

    /* JADX INFO: renamed from: a */
    private static final String m5248a(String str, String str2, String str3, String str4, String str5, String str6, long j, String str7, String str8) {
        try {
            String strM1280a = ahy.m1280a(new ByteArrayInputStream(str.getBytes("UTF-8")));
            StringBuffer stringBuffer = new StringBuffer();
            if (str8 != null && !"".equals(str8)) {
                stringBuffer.append(str8);
                stringBuffer.append("&");
            }
            stringBuffer.append(str2);
            stringBuffer.append("&");
            stringBuffer.append(strM1280a);
            stringBuffer.append("&");
            stringBuffer.append(str3);
            stringBuffer.append("&");
            stringBuffer.append(str4);
            stringBuffer.append("&");
            stringBuffer.append(str5);
            stringBuffer.append("&");
            stringBuffer.append(str6);
            stringBuffer.append("&");
            stringBuffer.append(ahy.m1280a(new ByteArrayInputStream(str7.getBytes("UTF-8"))));
            stringBuffer.append("&");
            stringBuffer.append(j);
            return ahy.m1280a(new ByteArrayInputStream(stringBuffer.toString().getBytes("UTF-8")));
        } catch (Throwable th) {
            aiv.m1419c("MtopRequestHelper", "toV3Sign", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static final String m5249a(Map<String, Object> map) {
        try {
            return new JSONObject(map).toString();
        } catch (Throwable th) {
            aiv.m1419c("MtopRequestHelper", "param2String", th);
            return null;
        }
    }
}
