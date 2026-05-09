package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Base64;
import com.mob.tools.MobLog;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: com.mob.commons.logcollector.f */
/* JADX INFO: compiled from: MessageUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1564f {
    /* JADX INFO: renamed from: a */
    public static synchronized long m8605a(Context context, long j, String str, int i, String str2) {
        if (TextUtils.isEmpty(str)) {
            return -1L;
        }
        C1560b c1560bM8572a = C1560b.m8572a(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put("exception_time", Long.valueOf(j));
        contentValues.put("exception_msg", str.toString());
        contentValues.put("exception_level", Integer.valueOf(i));
        contentValues.put("exception_md5", str2);
        return c1560bM8572a.m8575a("table_exception", contentValues);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized long m8606a(Context context, ArrayList<String> arrayList) {
        if (arrayList == null) {
            return 0L;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrayList.size(); i++) {
            sb.append("'");
            sb.append(arrayList.get(i));
            sb.append("'");
            sb.append(",");
        }
        String strSubstring = sb.toString().substring(0, sb.length() - 1);
        int iM8574a = C1560b.m8572a(context).m8574a("table_exception", "exception_md5 in ( " + strSubstring + " )", null);
        MobLog.getInstance().m8615i("delete COUNT == %s", Integer.valueOf(iM8574a));
        return iM8574a;
    }

    /* JADX INFO: renamed from: a */
    private static synchronized ArrayList<C1563e> m8607a(Context context, String str, String[] strArr) {
        ArrayList<C1563e> arrayList;
        arrayList = new ArrayList<>();
        C1563e c1563e = new C1563e();
        C1560b c1560bM8572a = C1560b.m8572a(context);
        String str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception group by exception_md5 having max(_id)";
        if (!TextUtils.isEmpty(str) && strArr != null && strArr.length > 0) {
            str2 = " select exception_md5, exception_level, exception_time, exception_msg, sum(exception_counts) from table_exception where " + str + " group by exception_md5 having max(_id)";
        }
        Cursor cursorM8576a = c1560bM8572a.m8576a(str2, strArr);
        while (true) {
            if (cursorM8576a == null || !cursorM8576a.moveToNext()) {
                break;
            }
            c1563e.f9018b.add(cursorM8576a.getString(0));
            HashMap<String, Object> map = new HashMap<>();
            map.put("type", Integer.valueOf(cursorM8576a.getInt(1)));
            map.put("errat", Long.valueOf(cursorM8576a.getLong(2)));
            map.put(NotificationCompat.CATEGORY_MESSAGE, Base64.encodeToString(cursorM8576a.getString(3).getBytes(), 2));
            map.put("times", Integer.valueOf(cursorM8576a.getInt(4)));
            c1563e.f9017a.add(map);
            if (c1563e.f9018b.size() == 50) {
                arrayList.add(c1563e);
                c1563e = new C1563e();
                break;
            }
        }
        cursorM8576a.close();
        if (c1563e.f9018b.size() != 0) {
            arrayList.add(c1563e);
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x000b  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static synchronized java.util.ArrayList<com.mob.commons.logcollector.C1563e> m8608a(android.content.Context r4, java.lang.String[] r5) {
        /*
            java.lang.Class<com.mob.commons.logcollector.f> r0 = com.mob.commons.logcollector.C1564f.class
            monitor-enter(r0)
            java.lang.String r1 = "exception_level = ?"
            r2 = 0
            if (r5 == 0) goto Lb
            int r3 = r5.length     // Catch: java.lang.Throwable -> L26
            if (r3 > 0) goto Ld
        Lb:
            r5 = r2
            r1 = r5
        Ld:
            com.mob.commons.logcollector.b r2 = com.mob.commons.logcollector.C1560b.m8572a(r4)     // Catch: java.lang.Throwable -> L26
            java.lang.String r3 = "table_exception"
            int r2 = r2.m8573a(r3)     // Catch: java.lang.Throwable -> L26
            if (r2 <= 0) goto L1f
            java.util.ArrayList r4 = m8607a(r4, r1, r5)     // Catch: java.lang.Throwable -> L26
            monitor-exit(r0)
            return r4
        L1f:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch: java.lang.Throwable -> L26
            r4.<init>()     // Catch: java.lang.Throwable -> L26
            monitor-exit(r0)
            return r4
        L26:
            r4 = move-exception
            monitor-exit(r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.logcollector.C1564f.m8608a(android.content.Context, java.lang.String[]):java.util.ArrayList");
    }
}
