package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class SQLiteHelper {
    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context.getDatabasePath(str).getPath(), str);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str, str2);
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) {
        singleTableDB.open();
        return singleTableDB.f9024db.replace(singleTableDB.getName(), null, contentValues);
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.f9024db.delete(singleTableDB.getName(), str, strArr);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.f9024db.update(singleTableDB.getName(), contentValues, str, strArr);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) {
        singleTableDB.open();
        return singleTableDB.f9024db.query(singleTableDB.getName(), strArr, str, strArr2, null, null, str2);
    }

    public static void execSQL(SingleTableDB singleTableDB, String str) {
        singleTableDB.open();
        singleTableDB.f9024db.beginTransaction();
        try {
            singleTableDB.f9024db.execSQL(str);
            singleTableDB.f9024db.setTransactionSuccessful();
        } finally {
            singleTableDB.f9024db.endTransaction();
        }
    }

    public static Cursor rawQuery(SingleTableDB singleTableDB, String str, String[] strArr) {
        singleTableDB.open();
        return singleTableDB.f9024db.rawQuery(str, strArr);
    }

    public static int getSize(SingleTableDB singleTableDB) throws Throwable {
        Cursor cursorRawQuery;
        singleTableDB.open();
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = singleTableDB.f9024db.rawQuery("select count(*) from " + singleTableDB.getName(), null);
            } catch (Throwable th) {
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            int i = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0;
            cursorRawQuery.close();
            return i;
        } catch (Throwable th3) {
            throw th3;
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.close();
    }

    public static class SingleTableDB {

        /* JADX INFO: renamed from: db */
        private SQLiteDatabase f9024db;
        private HashMap<String, Boolean> fieldLimits;
        private LinkedHashMap<String, String> fieldTypes;
        private String name;
        private String path;
        private String primary;
        private boolean primaryAutoincrement;

        private SingleTableDB(String str, String str2) {
            this.path = str;
            this.name = str2;
            this.fieldTypes = new LinkedHashMap<>();
            this.fieldLimits = new HashMap<>();
        }

        public void addField(String str, String str2, boolean z) {
            if (this.f9024db == null) {
                this.fieldTypes.put(str, str2);
                this.fieldLimits.put(str, Boolean.valueOf(z));
            }
        }

        public void setPrimary(String str, boolean z) {
            this.primary = str;
            this.primaryAutoincrement = z;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void open() {
            boolean z;
            if (this.f9024db == null) {
                this.f9024db = SQLiteDatabase.openOrCreateDatabase(new File(this.path), (SQLiteDatabase.CursorFactory) null);
                Cursor cursorRawQuery = this.f9024db.rawQuery("select count(*) from sqlite_master where type ='table' and name ='" + this.name + "' ", null);
                if (cursorRawQuery != null) {
                    z = !cursorRawQuery.moveToNext() || cursorRawQuery.getInt(0) <= 0;
                    cursorRawQuery.close();
                } else {
                    z = true;
                }
                if (z) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("create table  ");
                    sb.append(this.name);
                    sb.append("(");
                    for (Map.Entry<String, String> entry : this.fieldTypes.entrySet()) {
                        String key = entry.getKey();
                        String value = entry.getValue();
                        boolean zBooleanValue = this.fieldLimits.get(key).booleanValue();
                        boolean zEquals = key.equals(this.primary);
                        boolean z2 = zEquals ? this.primaryAutoincrement : false;
                        sb.append(key);
                        sb.append(" ");
                        sb.append(value);
                        sb.append(zBooleanValue ? " not null" : "");
                        sb.append(zEquals ? " primary key" : "");
                        sb.append(z2 ? " autoincrement," : ",");
                    }
                    sb.replace(sb.length() - 1, sb.length(), ");");
                    this.f9024db.execSQL(sb.toString());
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void close() {
            if (this.f9024db != null) {
                this.f9024db.close();
                this.f9024db = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getName() {
            return this.name;
        }
    }
}
