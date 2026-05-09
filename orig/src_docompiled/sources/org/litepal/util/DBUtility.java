package org.litepal.util;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.umeng.message.MessageStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.litepal.exceptions.DatabaseGenerateException;
import org.litepal.tablemanager.model.ColumnModel;
import org.litepal.tablemanager.model.TableModel;
import org.litepal.util.Const;

/* JADX INFO: loaded from: classes.dex */
public class DBUtility {
    private DBUtility() {
    }

    public static String getTableNameByClassName(String str) {
        if (TextUtils.isEmpty(str) || '.' == str.charAt(str.length() - 1)) {
            return null;
        }
        return str.substring(str.lastIndexOf(".") + 1);
    }

    public static List<String> getTableNameListByClassNameList(List<String> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(getTableNameByClassName(it.next()));
            }
        }
        return arrayList;
    }

    public static String getTableNameByForeignColumn(String str) {
        if (TextUtils.isEmpty(str) || !str.toLowerCase().endsWith(MessageStore.f9157Id)) {
            return null;
        }
        return str.substring(0, str.length() - MessageStore.f9157Id.length());
    }

    public static String getIntermediateTableName(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        if (str.toLowerCase().compareTo(str2.toLowerCase()) <= 0) {
            return String.valueOf(str) + "_" + str2;
        }
        return String.valueOf(str2) + "_" + str;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003c, code lost:
    
        r0 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x003d, code lost:
    
        if (r10.getInt(r10.getColumnIndexOrThrow("type")) != 1) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003f, code lost:
    
        if (r10 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0041, code lost:
    
        r10.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0044, code lost:
    
        return true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r10v3, types: [android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean isIntermediateTable(java.lang.String r9, android.database.sqlite.SQLiteDatabase r10) throws java.lang.Throwable {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r9)
            if (r0 != 0) goto L69
            java.lang.String r0 = "[0-9a-zA-Z]+_[0-9a-zA-Z]+"
            boolean r0 = r9.matches(r0)
            if (r0 == 0) goto L69
            r0 = 0
            java.lang.String r2 = "table_schema"
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r1 = r10
            android.database.Cursor r10 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L56 java.lang.Exception -> L59
            boolean r0 = r10.moveToFirst()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r0 == 0) goto L4b
        L22:
            java.lang.String r0 = "name"
            int r0 = r10.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            java.lang.String r0 = r10.getString(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            boolean r0 = r9.equalsIgnoreCase(r0)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r0 == 0) goto L45
            java.lang.String r9 = "type"
            int r9 = r10.getColumnIndexOrThrow(r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            int r9 = r10.getInt(r9)     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            r0 = 1
            if (r9 != r0) goto L4b
            if (r10 == 0) goto L44
            r10.close()
        L44:
            return r0
        L45:
            boolean r0 = r10.moveToNext()     // Catch: java.lang.Throwable -> L51 java.lang.Exception -> L53
            if (r0 != 0) goto L22
        L4b:
            if (r10 == 0) goto L69
            r10.close()
            goto L69
        L51:
            r9 = move-exception
            goto L63
        L53:
            r9 = move-exception
            r0 = r10
            goto L5a
        L56:
            r9 = move-exception
            r10 = r0
            goto L63
        L59:
            r9 = move-exception
        L5a:
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L56
            if (r0 == 0) goto L69
            r0.close()
            goto L69
        L63:
            if (r10 == 0) goto L68
            r10.close()
        L68:
            throw r9
        L69:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.isIntermediateTable(java.lang.String, android.database.sqlite.SQLiteDatabase):boolean");
    }

    public static boolean isTableExists(String str, SQLiteDatabase sQLiteDatabase) {
        try {
            return BaseUtility.containsIgnoreCases(findAllTableNames(sQLiteDatabase), str);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isColumnExists(String str, String str2, SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorRawQuery;
        boolean z = false;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("pragma table_info(" + str2 + ")", null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            if (cursorRawQuery.moveToFirst()) {
                while (true) {
                    if (str.equalsIgnoreCase(cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Const.TableSchema.COLUMN_NAME)))) {
                        z = true;
                        break;
                    }
                    if (!cursorRawQuery.moveToNext()) {
                        break;
                    }
                }
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            e.printStackTrace();
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        return z;
    }

    public static List<String> findAllTableNames(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorRawQuery;
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = sQLiteDatabase.rawQuery("select * from sqlite_master where type = ?", new String[]{"table"});
            } catch (Exception e) {
                e = e;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (cursorRawQuery.moveToFirst()) {
                do {
                    String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("tbl_name"));
                    if (!arrayList.contains(string)) {
                        arrayList.add(string);
                    }
                } while (cursorRawQuery.moveToNext());
            }
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            return arrayList;
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            e.printStackTrace();
            throw new DatabaseGenerateException(e.getMessage());
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static TableModel findPragmaTableInfo(String str, SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorRawQuery;
        if (isTableExists(str, sQLiteDatabase)) {
            List<String> listFindUniqueColumns = findUniqueColumns(str, sQLiteDatabase);
            TableModel tableModel = new TableModel();
            tableModel.setTableName(str);
            try {
                try {
                    cursorRawQuery = sQLiteDatabase.rawQuery("pragma table_info(" + str + ")", null);
                } catch (Throwable th) {
                    th = th;
                    cursorRawQuery = null;
                }
            } catch (Exception e) {
                e = e;
            }
            try {
                if (cursorRawQuery.moveToFirst()) {
                    do {
                        ColumnModel columnModel = new ColumnModel();
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow(Const.TableSchema.COLUMN_NAME));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("type"));
                        boolean z = true;
                        if (cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("notnull")) == 1) {
                            z = false;
                        }
                        boolean zContains = listFindUniqueColumns.contains(string);
                        String string3 = cursorRawQuery.getString(cursorRawQuery.getColumnIndexOrThrow("dflt_value"));
                        columnModel.setColumnName(string);
                        columnModel.setColumnType(string2);
                        columnModel.setIsNullable(z);
                        columnModel.setIsUnique(zContains);
                        columnModel.setDefaultValue(string3 != null ? string3.replace("'", "") : "");
                        tableModel.addColumnModel(columnModel);
                    } while (cursorRawQuery.moveToNext());
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                return tableModel;
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                throw new DatabaseGenerateException(e.getMessage());
            } catch (Throwable th2) {
                th = th2;
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
                throw th;
            }
        }
        throw new DatabaseGenerateException(DatabaseGenerateException.TABLE_DOES_NOT_EXIST_WHEN_EXECUTING + str);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00a8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.util.List<java.lang.String> findUniqueColumns(java.lang.String r6, android.database.sqlite.SQLiteDatabase r7) throws java.lang.Throwable {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.String r3 = "pragma index_list("
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            r2.append(r6)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.String r6 = ")"
            r2.append(r6)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            android.database.Cursor r6 = r7.rawQuery(r6, r1)     // Catch: java.lang.Throwable -> L8c java.lang.Exception -> L90
            boolean r2 = r6.moveToFirst()     // Catch: java.lang.Throwable -> L85 java.lang.Exception -> L88
            if (r2 == 0) goto L7a
            r2 = r1
        L24:
            java.lang.String r3 = "unique"
            int r3 = r6.getColumnIndexOrThrow(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            int r3 = r6.getInt(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r4 = 1
            if (r3 != r4) goto L6e
            java.lang.String r3 = "name"
            int r3 = r6.getColumnIndexOrThrow(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r3 = r6.getString(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r5 = "pragma index_info("
            r4.<init>(r5)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            r4.append(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r3 = ")"
            r4.append(r3)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            java.lang.String r3 = r4.toString()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            android.database.Cursor r3 = r7.rawQuery(r3, r1)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            boolean r2 = r3.moveToFirst()     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            if (r2 == 0) goto L65
            java.lang.String r2 = "name"
            int r2 = r3.getColumnIndexOrThrow(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            java.lang.String r2 = r3.getString(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
            r0.add(r2)     // Catch: java.lang.Throwable -> L67 java.lang.Exception -> L6a
        L65:
            r2 = r3
            goto L6e
        L67:
            r7 = move-exception
            r2 = r3
            goto La1
        L6a:
            r7 = move-exception
            r1 = r6
            r2 = r3
            goto L92
        L6e:
            boolean r3 = r6.moveToNext()     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
            if (r3 != 0) goto L24
            r1 = r2
            goto L7a
        L76:
            r7 = move-exception
            goto La1
        L78:
            r7 = move-exception
            goto L8a
        L7a:
            if (r6 == 0) goto L7f
            r6.close()
        L7f:
            if (r1 == 0) goto L84
            r1.close()
        L84:
            return r0
        L85:
            r7 = move-exception
            r2 = r1
            goto La1
        L88:
            r7 = move-exception
            r2 = r1
        L8a:
            r1 = r6
            goto L92
        L8c:
            r7 = move-exception
            r6 = r1
            r2 = r6
            goto La1
        L90:
            r7 = move-exception
            r2 = r1
        L92:
            r7.printStackTrace()     // Catch: java.lang.Throwable -> L9f
            org.litepal.exceptions.DatabaseGenerateException r6 = new org.litepal.exceptions.DatabaseGenerateException     // Catch: java.lang.Throwable -> L9f
            java.lang.String r7 = r7.getMessage()     // Catch: java.lang.Throwable -> L9f
            r6.<init>(r7)     // Catch: java.lang.Throwable -> L9f
            throw r6     // Catch: java.lang.Throwable -> L9f
        L9f:
            r7 = move-exception
            r6 = r1
        La1:
            if (r6 == 0) goto La6
            r6.close()
        La6:
            if (r2 == 0) goto Lab
            r2.close()
        Lab:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.litepal.util.DBUtility.findUniqueColumns(java.lang.String, android.database.sqlite.SQLiteDatabase):java.util.List");
    }
}
