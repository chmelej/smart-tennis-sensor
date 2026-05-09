package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: UMStoreManager.java */
/* JADX INFO: loaded from: classes.dex */
public class agy {

    /* JADX INFO: renamed from: a */
    private static Context f870a;

    /* JADX INFO: renamed from: b */
    private static String f871b;

    /* JADX INFO: renamed from: c */
    private List<String> f872c;

    /* JADX INFO: renamed from: agy$a */
    /* JADX INFO: compiled from: UMStoreManager.java */
    public enum EnumC0107a {
        AUTOPAGE,
        PAGE,
        BEGIN,
        END,
        NEWSESSION
    }

    /* JADX INFO: renamed from: agy$b */
    /* JADX INFO: compiled from: UMStoreManager.java */
    static class C0108b {

        /* JADX INFO: renamed from: a */
        private static final agy f879a = new agy();
    }

    private agy() {
        this.f872c = new ArrayList();
        if (f870a != null) {
            m994b();
            this.f872c.clear();
        }
    }

    /* JADX INFO: renamed from: a */
    public static final agy m991a(Context context) {
        f870a = context;
        return C0108b.f879a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0084, code lost:
    
        if (r1 == null) goto L25;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m999a(org.json.JSONArray r8) throws java.lang.Throwable {
        /*
            r7 = this;
            r0 = 0
            android.content.Context r1 = p000.agy.f870a     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            agw r1 = p000.agw.m984a(r1)     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            android.database.sqlite.SQLiteDatabase r1 = r1.m986a()     // Catch: java.lang.Throwable -> L80 java.lang.Throwable -> L83 android.database.sqlite.SQLiteDatabaseCorruptException -> L93
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            r2 = 0
        Lf:
            int r3 = r8.length()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            if (r2 >= r3) goto L76
            org.json.JSONObject r3 = r8.getJSONObject(r2)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            android.content.ContentValues r4 = new android.content.ContentValues     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            r4.<init>()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = "__i"
            java.lang.String r5 = r3.optString(r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            if (r6 == 0) goto L38
            android.content.Context r5 = p000.agy.f870a     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = p000.aee.m479g(r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            if (r6 == 0) goto L38
            java.lang.String r5 = ""
        L38:
            java.lang.String r6 = "__i"
            r4.put(r6, r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = "__e"
            java.lang.String r6 = "id"
            java.lang.String r6 = r3.optString(r6)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = "__t"
            java.lang.String r6 = "__t"
            int r6 = r3.optInt(r6)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            r4.put(r5, r6)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = "__i"
            r3.remove(r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = "__t"
            r3.remove(r5)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r5 = "__s"
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r3 = r7.m997a(r3)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            r4.put(r5, r3)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            java.lang.String r3 = "__et"
            r1.insert(r3, r0, r4)     // Catch: java.lang.Exception -> L73 java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
        L73:
            int r2 = r2 + 1
            goto Lf
        L76:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L7c android.database.sqlite.SQLiteDatabaseCorruptException -> L7e java.lang.Throwable -> L84
            if (r1 == 0) goto L89
            goto L86
        L7c:
            r8 = move-exception
            goto L9f
        L7e:
            r0 = r1
            goto L93
        L80:
            r8 = move-exception
            r1 = r0
            goto L9f
        L83:
            r1 = r0
        L84:
            if (r1 == 0) goto L89
        L86:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L89
        L89:
            android.content.Context r8 = p000.agy.f870a
            agw r8 = p000.agw.m984a(r8)
            r8.m987b()
            goto L9e
        L93:
            android.content.Context r8 = p000.agy.f870a     // Catch: java.lang.Throwable -> L80
            p000.agx.m990b(r8)     // Catch: java.lang.Throwable -> L80
            if (r0 == 0) goto L89
            r0.endTransaction()     // Catch: java.lang.Throwable -> L89
            goto L89
        L9e:
            return
        L9f:
            if (r1 == 0) goto La4
            r1.endTransaction()     // Catch: java.lang.Throwable -> La4
        La4:
            android.content.Context r0 = p000.agy.f870a
            agw r0 = p000.agw.m984a(r0)
            r0.m987b()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m999a(org.json.JSONArray):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        if (r1 == null) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0045, code lost:
    
        r1.endTransaction();
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0038, code lost:
    
        if (r1 != null) goto L17;
     */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m1001a(java.lang.String r5, java.lang.String r6, int r7) throws java.lang.Throwable {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = p000.agy.f870a     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            agw r1 = p000.agw.m984a(r1)     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            android.database.sqlite.SQLiteDatabase r1 = r1.m986a()     // Catch: java.lang.Throwable -> L3f java.lang.Throwable -> L42 android.database.sqlite.SQLiteDatabaseCorruptException -> L52
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            android.content.ContentValues r2 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            r2.<init>()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            java.lang.String r3 = "__i"
            r2.put(r3, r5)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            java.lang.String r5 = r4.m997a(r6)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            if (r6 != 0) goto L35
            java.lang.String r6 = "__a"
            r2.put(r6, r5)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            java.lang.String r5 = "__t"
            java.lang.Integer r6 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            r2.put(r5, r6)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            java.lang.String r5 = "__er"
            r1.insert(r5, r0, r2)     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
        L35:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L3b android.database.sqlite.SQLiteDatabaseCorruptException -> L3d java.lang.Throwable -> L43
            if (r1 == 0) goto L48
            goto L45
        L3b:
            r5 = move-exception
            goto L5f
        L3d:
            r0 = r1
            goto L52
        L3f:
            r5 = move-exception
            r1 = r0
            goto L5f
        L42:
            r1 = r0
        L43:
            if (r1 == 0) goto L48
        L45:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L48
        L48:
            android.content.Context r5 = p000.agy.f870a
            agw r5 = p000.agw.m984a(r5)
            r5.m987b()
            goto L5d
        L52:
            android.content.Context r5 = p000.agy.f870a     // Catch: java.lang.Throwable -> L3f
            p000.agx.m990b(r5)     // Catch: java.lang.Throwable -> L3f
            if (r0 == 0) goto L48
            r0.endTransaction()     // Catch: java.lang.Throwable -> L48
            goto L48
        L5d:
            r5 = 0
            return r5
        L5f:
            if (r1 == 0) goto L64
            r1.endTransaction()     // Catch: java.lang.Throwable -> L64
        L64:
            android.content.Context r6 = p000.agy.f870a
            agw r6 = p000.agw.m984a(r6)
            r6.m987b()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m1001a(java.lang.String, java.lang.String, int):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x01b5 A[EXC_TOP_SPLITTER, PHI: r2
      0x01b5: PHI (r2v6 android.database.sqlite.SQLiteDatabase) = 
      (r2v3 android.database.sqlite.SQLiteDatabase)
      (r2v5 android.database.sqlite.SQLiteDatabase)
      (r2v9 android.database.sqlite.SQLiteDatabase)
     binds: [B:61:0x01b3, B:68:0x01cd, B:53:0x01a3] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean m1002a(java.lang.String r7, org.json.JSONObject r8, p000.agy.EnumC0107a r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m1002a(java.lang.String, org.json.JSONObject, agy$a):boolean");
    }

    /* JADX INFO: renamed from: a */
    private void m992a(String str, JSONObject jSONObject, SQLiteDatabase sQLiteDatabase, String str2) throws Throwable {
        Cursor cursorRawQuery;
        String strM1003b = null;
        try {
            cursorRawQuery = sQLiteDatabase.rawQuery("select " + str2 + " from __sd where __ii=\"" + str + "\"", null);
            if (cursorRawQuery != null) {
                while (cursorRawQuery.moveToNext()) {
                    try {
                        strM1003b = m1003b(cursorRawQuery.getString(cursorRawQuery.getColumnIndex(str2)));
                    } catch (Throwable th) {
                        th = th;
                        if (cursorRawQuery != null) {
                            cursorRawQuery.close();
                        }
                        throw th;
                    }
                }
            }
            JSONArray jSONArray = new JSONArray();
            if (!TextUtils.isEmpty(strM1003b)) {
                jSONArray = new JSONArray(strM1003b);
            }
            jSONArray.put(jSONObject);
            String strM997a = m997a(jSONArray.toString());
            if (!TextUtils.isEmpty(strM997a)) {
                sQLiteDatabase.execSQL("update __sd set " + str2 + "=\"" + strM997a + "\" where __ii=\"" + str + "\"");
            }
            if (cursorRawQuery == null) {
                return;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorRawQuery = null;
        }
        cursorRawQuery.close();
    }

    /* JADX INFO: renamed from: a */
    public JSONObject m998a() throws Throwable {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        m996c(jSONObject2);
        m995b(jSONObject2);
        m993a(jSONObject2);
        try {
            if (jSONObject2.length() > 0) {
                jSONObject.put("body", jSONObject2);
            }
        } catch (Throwable unused) {
        }
        return jSONObject;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0144 A[PHI: r0 r1
      0x0144: PHI (r0v6 ??) = (r0v5 ??), (r0v7 ??), (r0v15 ??) binds: [B:71:0x0159, B:65:0x0141, B:56:0x012f] A[DONT_GENERATE, DONT_INLINE]
      0x0144: PHI (r1v7 android.database.sqlite.SQLiteDatabase) = 
      (r1v6 android.database.sqlite.SQLiteDatabase)
      (r1v8 android.database.sqlite.SQLiteDatabase)
      (r1v11 android.database.sqlite.SQLiteDatabase)
     binds: [B:71:0x0159, B:65:0x0141, B:56:0x012f] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r11v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m993a(org.json.JSONObject r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m993a(org.json.JSONObject):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:53:0x006b A[PHI: r0 r1
      0x006b: PHI (r0v6 ??) = (r0v5 ??), (r0v7 ??), (r0v11 ??) binds: [B:36:0x0080, B:30:0x0068, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE]
      0x006b: PHI (r1v7 android.database.sqlite.SQLiteDatabase) = 
      (r1v6 android.database.sqlite.SQLiteDatabase)
      (r1v8 android.database.sqlite.SQLiteDatabase)
      (r1v11 android.database.sqlite.SQLiteDatabase)
     binds: [B:36:0x0080, B:30:0x0068, B:21:0x0056] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v4, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r6v0, types: [org.json.JSONObject] */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m995b(org.json.JSONObject r6) throws java.lang.Throwable {
        /*
            r5 = this;
            r0 = 0
            android.content.Context r1 = p000.agy.f870a     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            agw r1 = p000.agw.m984a(r1)     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            android.database.sqlite.SQLiteDatabase r1 = r1.m986a()     // Catch: java.lang.Throwable -> L5b java.lang.Throwable -> L5f android.database.sqlite.SQLiteDatabaseCorruptException -> L75
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> L84
            java.lang.String r2 = "select *  from __er"
            android.database.Cursor r2 = r1.rawQuery(r2, r0)     // Catch: java.lang.Throwable -> L59 android.database.sqlite.SQLiteDatabaseCorruptException -> L76 java.lang.Throwable -> L84
            if (r2 == 0) goto L4e
            org.json.JSONArray r0 = new org.json.JSONArray     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            r0.<init>()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
        L1b:
            boolean r3 = r2.moveToNext()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            if (r3 == 0) goto L3e
            java.lang.String r3 = "__a"
            int r3 = r2.getColumnIndex(r3)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            java.lang.String r3 = r2.getString(r3)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            boolean r4 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            if (r4 != 0) goto L1b
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            java.lang.String r3 = r5.m1003b(r3)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            r0.put(r4)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            goto L1b
        L3e:
            int r3 = r0.length()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            if (r3 <= 0) goto L4e
            java.lang.String r3 = "error"
            r6.put(r3, r0)     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            goto L4e
        L4a:
            r6 = move-exception
            goto L86
        L4c:
            r0 = r2
            goto L76
        L4e:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L4a android.database.sqlite.SQLiteDatabaseCorruptException -> L4c java.lang.Throwable -> L61
            if (r2 == 0) goto L56
            r2.close()
        L56:
            if (r1 == 0) goto L6b
            goto L68
        L59:
            r2 = r0
            goto L61
        L5b:
            r6 = move-exception
            r1 = r0
            r2 = r1
            goto L86
        L5f:
            r1 = r0
            r2 = r1
        L61:
            if (r2 == 0) goto L66
            r2.close()
        L66:
            if (r1 == 0) goto L6b
        L68:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L6b
        L6b:
            android.content.Context r6 = p000.agy.f870a
            agw r6 = p000.agw.m984a(r6)
            r6.m987b()
            goto L83
        L75:
            r1 = r0
        L76:
            android.content.Context r6 = p000.agy.f870a     // Catch: java.lang.Throwable -> L84
            p000.agx.m990b(r6)     // Catch: java.lang.Throwable -> L84
            if (r0 == 0) goto L80
            r0.close()
        L80:
            if (r1 == 0) goto L6b
            goto L68
        L83:
            return
        L84:
            r6 = move-exception
            r2 = r0
        L86:
            if (r2 == 0) goto L8b
            r2.close()
        L8b:
            if (r1 == 0) goto L90
            r1.endTransaction()     // Catch: java.lang.Throwable -> L90
        L90:
            android.content.Context r0 = p000.agy.f870a
            agw r0 = p000.agw.m984a(r0)
            r0.m987b()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m995b(org.json.JSONObject):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0198 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0174 A[PHI: r2 r3
      0x0174: PHI (r2v10 ??) = (r2v6 ??), (r2v7 ??), (r2v17 ??) binds: [B:70:0x0189, B:64:0x0171, B:53:0x015d] A[DONT_GENERATE, DONT_INLINE]
      0x0174: PHI (r3v13 android.database.sqlite.SQLiteDatabase) = 
      (r3v11 android.database.sqlite.SQLiteDatabase)
      (r3v12 android.database.sqlite.SQLiteDatabase)
      (r3v40 android.database.sqlite.SQLiteDatabase)
     binds: [B:70:0x0189, B:64:0x0171, B:53:0x015d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0171 A[EXC_TOP_SPLITTER, PHI: r2 r3
      0x0171: PHI (r2v7 ??) = (r2v2 ??), (r2v6 ??), (r2v17 ??) binds: [B:63:0x016f, B:70:0x0189, B:53:0x015d] A[DONT_GENERATE, DONT_INLINE]
      0x0171: PHI (r3v12 android.database.sqlite.SQLiteDatabase) = 
      (r3v4 android.database.sqlite.SQLiteDatabase)
      (r3v11 android.database.sqlite.SQLiteDatabase)
      (r3v40 android.database.sqlite.SQLiteDatabase)
     binds: [B:63:0x016f, B:70:0x0189, B:53:0x015d] A[DONT_GENERATE, DONT_INLINE], SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r19v0, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v25 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v20 */
    /* JADX WARN: Type inference failed for: r3v41 */
    /* JADX WARN: Type inference failed for: r3v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m996c(org.json.JSONObject r19) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 421
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m996c(org.json.JSONObject):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005f, code lost:
    
        if (r1 != 0) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x006a, code lost:
    
        if (r1 == 0) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006c, code lost:
    
        r1.endTransaction();
        r0 = r0;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v3, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX WARN: Type inference failed for: r1v7, types: [android.database.sqlite.SQLiteDatabase] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1000a(boolean r3, boolean r4) {
        /*
            r2 = this;
            r0 = 0
            android.content.Context r1 = p000.agy.f870a     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            agw r1 = p000.agw.m984a(r1)     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            android.database.sqlite.SQLiteDatabase r1 = r1.m986a()     // Catch: java.lang.Throwable -> L66 java.lang.Throwable -> L69 android.database.sqlite.SQLiteDatabaseCorruptException -> L79
            r1.beginTransaction()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.String r0 = "delete from __er"
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.String r0 = "delete from __et"
            r1.execSQL(r0)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            if (r4 == 0) goto L22
            if (r3 == 0) goto L5c
            java.lang.String r3 = "delete from __sd"
            r1.execSQL(r3)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            goto L5c
        L22:
            java.util.List<java.lang.String> r3 = r2.f872c     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            if (r3 <= 0) goto L57
            r3 = 0
        L2b:
            java.util.List<java.lang.String> r4 = r2.f872c     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            int r4 = r4.size()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            if (r3 >= r4) goto L57
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            r4.<init>()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.String r0 = "delete from __sd where __ii=\""
            r4.append(r0)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.util.List<java.lang.String> r0 = r2.f872c     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            r4.append(r0)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.String r0 = "\""
            r4.append(r0)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            java.lang.String r4 = r4.toString()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            r1.execSQL(r4)     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            int r3 = r3 + 1
            goto L2b
        L57:
            java.util.List<java.lang.String> r3 = r2.f872c     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            r3.clear()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
        L5c:
            r1.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L62 android.database.sqlite.SQLiteDatabaseCorruptException -> L64 java.lang.Throwable -> L6a
            if (r1 == 0) goto L6f
            goto L6c
        L62:
            r3 = move-exception
            goto L85
        L64:
            r0 = r1
            goto L79
        L66:
            r3 = move-exception
            r1 = r0
            goto L85
        L69:
            r1 = r0
        L6a:
            if (r1 == 0) goto L6f
        L6c:
            r1.endTransaction()     // Catch: java.lang.Throwable -> L6f
        L6f:
            android.content.Context r3 = p000.agy.f870a
            agw r3 = p000.agw.m984a(r3)
            r3.m987b()
            goto L84
        L79:
            android.content.Context r3 = p000.agy.f870a     // Catch: java.lang.Throwable -> L66
            p000.agx.m990b(r3)     // Catch: java.lang.Throwable -> L66
            if (r0 == 0) goto L6f
            r0.endTransaction()     // Catch: java.lang.Throwable -> L6f
            goto L6f
        L84:
            return
        L85:
            if (r1 == 0) goto L8a
            r1.endTransaction()     // Catch: java.lang.Throwable -> L8a
        L8a:
            android.content.Context r4 = p000.agy.f870a
            agw r4 = p000.agw.m984a(r4)
            r4.m987b()
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.agy.m1000a(boolean, boolean):void");
    }

    /* JADX INFO: renamed from: b */
    private void m994b() {
        try {
            if (TextUtils.isEmpty(f871b)) {
                SharedPreferences sharedPreferencesM454a = aeb.m454a(f870a);
                String string = sharedPreferencesM454a.getString("ek__id", null);
                if (TextUtils.isEmpty(string)) {
                    string = aeu.m751w(f870a);
                    if (!TextUtils.isEmpty(string)) {
                        sharedPreferencesM454a.edit().putString("ek__id", string).commit();
                    }
                }
                if (!TextUtils.isEmpty(string)) {
                    String strSubstring = string.substring(1, 9);
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < strSubstring.length(); i++) {
                        char cCharAt = strSubstring.charAt(i);
                        if (Character.isDigit(cCharAt)) {
                            if (Integer.parseInt(Character.toString(cCharAt)) == 0) {
                                sb.append(0);
                            } else {
                                sb.append(10 - Integer.parseInt(Character.toString(cCharAt)));
                            }
                        } else {
                            sb.append(cCharAt);
                        }
                    }
                    f871b = sb.toString();
                }
                if (TextUtils.isEmpty(f871b)) {
                    return;
                }
                f871b += new StringBuilder(f871b).reverse().toString();
                String string2 = sharedPreferencesM454a.getString("ek_key", null);
                if (TextUtils.isEmpty(string2)) {
                    sharedPreferencesM454a.edit().putString("ek_key", m997a("umeng+")).commit();
                } else {
                    if ("umeng+".equals(m1003b(string2))) {
                        return;
                    }
                    m1000a(true, false);
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public String m997a(String str) {
        try {
            return TextUtils.isEmpty(f871b) ? str : Base64.encodeToString(aes.m708a(str.getBytes(), f871b.getBytes()), 0);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public String m1003b(String str) {
        try {
            return TextUtils.isEmpty(f871b) ? str : new String(aes.m711b(Base64.decode(str.getBytes(), 0), f871b.getBytes()));
        } catch (Exception unused) {
            return null;
        }
    }
}
