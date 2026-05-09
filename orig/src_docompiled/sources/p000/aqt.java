package p000;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.net.URI;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: SignHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class aqt {

    /* JADX INFO: renamed from: a */
    public static final Uri f4754a = Uri.parse("content://telephony/carriers/preferapn");

    /* JADX INFO: renamed from: a */
    private static final String m5121a() {
        return m5122a(System.currentTimeMillis());
    }

    /* JADX INFO: renamed from: a */
    private static final String m5122a(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, 1, 1, 0, 0, 0);
        return String.format("%010d", Long.valueOf((j - calendar.getTimeInMillis()) / 1000));
    }

    /* JADX INFO: renamed from: a */
    public static final String m5124a(Context context, int i, short s, long j, long j2, int i2, int i3) {
        StringBuilder sb = new StringBuilder();
        sb.append(m5123a(context));
        sb.append("|");
        sb.append("" + i);
        sb.append("|");
        sb.append("" + ((int) s));
        sb.append("|");
        sb.append("" + m5122a(j));
        sb.append("|");
        sb.append("" + m5122a(j2));
        sb.append("|");
        sb.append("" + i2);
        sb.append("|");
        sb.append("" + i3);
        return ahw.m1271a(sb.toString().getBytes());
    }

    /* JADX WARN: Can't wrap try/catch for region: R(18:0|2|107|3|4|(3:111|5|6)|(2:12|(2:13|(1:119)(8:15|(2:121|21)(1:118)|86|87|109|88|91|92)))(0)|22|116|23|(7:25|(3:33|100|34)(4:27|(1:29)(2:30|(1:32)(0))|100|34)|87|109|88|91|92)(1:36)|37|(3:98|39|(7:66|105|67|103|(1:69)(2:(4:71|114|72|(2:74|(1:76))(2:77|(2:79|(1:81))))|83)|102|113)(8:41|(1:43)(2:44|(1:46)(2:47|(1:49)(2:50|(1:52)(2:53|(1:55)(2:56|(1:58)(2:59|(1:61)(2:62|(0))))))))|105|67|103|(0)(0)|102|113))(0)|87|109|88|91|92) */
    /* JADX WARN: Can't wrap try/catch for region: R(20:0|2|107|3|4|111|5|6|(2:12|(2:13|(1:119)(8:15|(2:121|21)(1:118)|86|87|109|88|91|92)))(0)|22|116|23|(7:25|(3:33|100|34)(4:27|(1:29)(2:30|(1:32)(0))|100|34)|87|109|88|91|92)(1:36)|37|(3:98|39|(7:66|105|67|103|(1:69)(2:(4:71|114|72|(2:74|(1:76))(2:77|(2:79|(1:81))))|83)|102|113)(8:41|(1:43)(2:44|(1:46)(2:47|(1:49)(2:50|(1:52)(2:53|(1:55)(2:56|(1:58)(2:59|(1:61)(2:62|(0))))))))|105|67|103|(0)(0)|102|113))(0)|87|109|88|91|92) */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        r5 = r4[r6];
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01c5, code lost:
    
        r1.append(new java.lang.String((byte[]) r0));
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e9 A[Catch: Throwable -> 0x015f, TRY_ENTER, TryCatch #2 {Throwable -> 0x015f, blocks: (B:69:0x00e9, B:71:0x0100), top: B:103:0x00e7 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00fe  */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v3, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.String m5123a(android.content.Context r13) {
        /*
            Method dump skipped, instruction units count: 492
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.aqt.m5123a(android.content.Context):java.lang.String");
    }

    /* JADX INFO: renamed from: b */
    private static final int m5128b(Context context) {
        String str = aic.m1305g(context).get("netType");
        if (!TextUtils.isEmpty(str)) {
            if ("wifi".equals(str)) {
                return 1;
            }
            if ("2g".equals(str)) {
                return 2;
            }
            if ("3g".equals(str)) {
                return 0;
            }
            if ("4g".equals(str)) {
                return 3;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    private static final byte[] m5127a(String str) {
        byte[] bArr = new byte[6];
        if (str == null || str.length() != 17) {
            return bArr;
        }
        String[] strArrSplit = str.split(":");
        for (int i = 0; i < strArrSplit.length; i++) {
            bArr[i] = (byte) Integer.parseInt(strArrSplit[i], 16);
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    public static final String m5125a(Context context, String str, Map<String, String> map, String str2, String str3) {
        try {
            URI uri = new URI(str);
            String strM5121a = m5121a();
            StringBuilder sb = new StringBuilder();
            sb.append(strM5121a);
            sb.append(uri.getPath());
            String strM5126a = m5126a(uri.getQuery(), map);
            if (!TextUtils.isEmpty(strM5126a)) {
                sb.append(strM5126a);
            }
            return ahw.m1271a((strM5121a + (!TextUtils.isEmpty(str3) ? ahz.m1282a(str3, sb.toString()) : null)).getBytes());
        } catch (Throwable th) {
            aiv.m1419c("SignHelper", "generatorSign[" + str + "]", th);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static final String m5126a(String str, Map<String, String> map) {
        String[] strArrSplit;
        try {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str) && (strArrSplit = str.split("&")) != null) {
                for (String str2 : strArrSplit) {
                    String[] strArrSplit2 = str2.split("=");
                    if (strArrSplit2 != null && strArrSplit2.length == 2) {
                        arrayList.add(strArrSplit2[0] + strArrSplit2[1]);
                    }
                }
            }
            if (map != null && map.size() > 0) {
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue();
                    if (!TextUtils.isEmpty(key) && !TextUtils.isEmpty(value)) {
                        arrayList.add(key + value);
                    }
                }
            }
            if (arrayList == null || arrayList.size() <= 0) {
                return null;
            }
            Collections.sort(arrayList);
            StringBuilder sb = new StringBuilder();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                sb.append((String) it.next());
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
