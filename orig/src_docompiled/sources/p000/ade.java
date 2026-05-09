package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: CCSQLManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ade {
    /* JADX INFO: renamed from: a */
    public static boolean m325a(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        try {
            if (m327b(sQLiteDatabase, str) < 0) {
                return true;
            }
            sQLiteDatabase.execSQL("delete from " + str);
            return true;
        } catch (SQLException e) {
            aex.m776c("cleanTableData faild!" + e.toString());
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m327b(SQLiteDatabase sQLiteDatabase, String str) throws Throwable {
        int count;
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select * from " + str, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            count = cursorRawQuery.getCount();
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            aex.m776c("count error " + e.toString());
            if (cursor != null) {
                cursor.close();
            }
            count = 0;
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return count;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m326a(SQLiteDatabase sQLiteDatabase, Collection<agn> collection) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (m327b(sQLiteDatabase, "aggregated_cache") > 0) {
                    m325a(sQLiteDatabase, "aggregated_cache");
                }
                Iterator<agn> it = collection.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.insert("aggregated_cache", null, m317a(it.next()));
                }
                sQLiteDatabase.setTransactionSuccessful();
                sQLiteDatabase.endTransaction();
                return true;
            } catch (SQLException unused) {
                aex.m776c("insert to Aggregated cache table faild!");
                sQLiteDatabase.endTransaction();
                return false;
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m324a(agl aglVar, SQLiteDatabase sQLiteDatabase, Collection<agn> collection) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                Iterator<agn> it = collection.iterator();
                while (it.hasNext()) {
                    sQLiteDatabase.insert("aggregated", null, m317a(it.next()));
                }
                sQLiteDatabase.setTransactionSuccessful();
                m325a(sQLiteDatabase, "aggregated_cache");
                aglVar.mo819a("success", false);
                sQLiteDatabase.endTransaction();
                return true;
            } catch (SQLException unused) {
                aex.m776c("insert to Aggregated cache table faild!");
                sQLiteDatabase.endTransaction();
                return false;
            }
        } catch (Throwable th) {
            sQLiteDatabase.endTransaction();
            throw th;
        }
    }

    /* JADX INFO: renamed from: a */
    private static ContentValues m317a(agn agnVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("key", agnVar.m927a());
        contentValues.put("label", agnVar.m928b());
        contentValues.put("count", Long.valueOf(agnVar.m931e()));
        contentValues.put("value", Long.valueOf(agnVar.m930d()));
        contentValues.put("totalTimestamp", Long.valueOf(agnVar.m929c()));
        contentValues.put("timeWindowNum", agnVar.m932f());
        return contentValues;
    }

    /* JADX INFO: renamed from: a */
    public static void m323a(SQLiteDatabase sQLiteDatabase, boolean z, agl aglVar) throws Throwable {
        m325a(sQLiteDatabase, "system");
        m325a(sQLiteDatabase, "aggregated");
        if (z) {
            return;
        }
        m325a(sQLiteDatabase, "limitedck");
        aglVar.mo819a("success", false);
    }

    /* JADX INFO: renamed from: a */
    public static void m321a(SQLiteDatabase sQLiteDatabase, String str, long j, long j2) throws Throwable {
        try {
            int iM327b = m327b(sQLiteDatabase, "system");
            int iM958b = agq.m957a().m958b();
            if (iM327b < iM958b) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("key", str);
                contentValues.put("timeStamp", Long.valueOf(j2));
                contentValues.put("count", Long.valueOf(j));
                sQLiteDatabase.insert("system", null, contentValues);
            } else if (iM327b == iM958b) {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("key", "__meta_ve_of");
                contentValues2.put("timeStamp", Long.valueOf(System.currentTimeMillis()));
                contentValues2.put("count", (Integer) 1);
                sQLiteDatabase.insert("system", null, contentValues2);
            } else {
                m328c(sQLiteDatabase, "__meta_ve_of");
            }
        } catch (SQLException unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    private static void m328c(SQLiteDatabase sQLiteDatabase, String str) {
        try {
            sQLiteDatabase.beginTransaction();
            sQLiteDatabase.execSQL("update system set count=count+1 where key like '" + str + "'");
            sQLiteDatabase.setTransactionSuccessful();
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (SQLException unused) {
            if (sQLiteDatabase == null) {
                return;
            }
        } catch (Throwable th) {
            if (sQLiteDatabase != null) {
                sQLiteDatabase.endTransaction();
            }
            throw th;
        }
        sQLiteDatabase.endTransaction();
    }

    /* JADX INFO: renamed from: a */
    public static void m320a(agl aglVar, SQLiteDatabase sQLiteDatabase, List<String> list) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                if (m327b(sQLiteDatabase, "limitedck") > 0) {
                    m325a(sQLiteDatabase, "limitedck");
                }
                for (String str : list) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("ck", str);
                    sQLiteDatabase.insert("limitedck", null, contentValues);
                }
                sQLiteDatabase.setTransactionSuccessful();
                aglVar.mo819a("success", false);
            } catch (SQLException e) {
                aex.m776c("insertToLimitCKTable error " + e.toString());
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00d9  */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void m322a(android.database.sqlite.SQLiteDatabase r19, java.util.Map<java.lang.String, p000.ago> r20, p000.agl r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ade.m322a(android.database.sqlite.SQLiteDatabase, java.util.Map, agl):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c7  */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v4, types: [android.database.Cursor] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject m319a(android.database.sqlite.SQLiteDatabase r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 203
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ade.m319a(android.database.sqlite.SQLiteDatabase):org.json.JSONObject");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0096  */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v3, types: [android.database.Cursor] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.json.JSONObject m318a(p000.agl r8, android.database.sqlite.SQLiteDatabase r9) throws java.lang.Throwable {
        /*
            r0 = 0
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L6a android.database.SQLException -> L6d
            r1.<init>()     // Catch: java.lang.Throwable -> L6a android.database.SQLException -> L6d
            java.lang.String r2 = "system"
            int r2 = m327b(r9, r2)     // Catch: java.lang.Throwable -> L6a android.database.SQLException -> L6d
            if (r2 <= 0) goto L63
            java.lang.String r2 = "select * from system"
            android.database.Cursor r9 = r9.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L6a android.database.SQLException -> L6d
        L14:
            boolean r2 = r9.moveToNext()     // Catch: android.database.SQLException -> L61 java.lang.Throwable -> L93
            if (r2 == 0) goto L64
            java.lang.String r2 = "key"
            int r2 = r9.getColumnIndex(r2)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            java.lang.String r2 = r9.getString(r2)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            boolean r3 = r1.has(r2)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            if (r3 == 0) goto L32
            org.json.JSONArray r3 = r1.getJSONArray(r2)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r1.remove(r2)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            goto L37
        L32:
            org.json.JSONArray r3 = new org.json.JSONArray     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r3.<init>()     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
        L37:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r4.<init>()     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            java.lang.String r5 = "value"
            java.lang.String r6 = "count"
            int r6 = r9.getColumnIndex(r6)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            int r6 = r9.getInt(r6)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            java.lang.String r5 = "ts"
            java.lang.String r6 = "timeStamp"
            int r6 = r9.getColumnIndex(r6)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            long r6 = r9.getLong(r6)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r3.put(r4)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            r1.put(r2, r3)     // Catch: java.lang.Exception -> L14 android.database.SQLException -> L61 java.lang.Throwable -> L93
            goto L14
        L61:
            r1 = move-exception
            goto L6f
        L63:
            r9 = r0
        L64:
            if (r9 == 0) goto L69
            r9.close()
        L69:
            return r1
        L6a:
            r8 = move-exception
            r9 = r0
            goto L94
        L6d:
            r1 = move-exception
            r9 = r0
        L6f:
            java.lang.String r2 = "faild"
            r3 = 0
            r8.mo819a(r2, r3)     // Catch: java.lang.Throwable -> L93
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L93
            r8.<init>()     // Catch: java.lang.Throwable -> L93
            java.lang.String r2 = "readAllSystemDataForUpload error "
            r8.append(r2)     // Catch: java.lang.Throwable -> L93
            java.lang.String r1 = r1.toString()     // Catch: java.lang.Throwable -> L93
            r8.append(r1)     // Catch: java.lang.Throwable -> L93
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Throwable -> L93
            p000.aex.m776c(r8)     // Catch: java.lang.Throwable -> L93
            if (r9 == 0) goto L92
            r9.close()
        L92:
            return r0
        L93:
            r8 = move-exception
        L94:
            if (r9 == 0) goto L99
            r9.close()
        L99:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ade.m318a(agl, android.database.sqlite.SQLiteDatabase):org.json.JSONObject");
    }
}
