package p000;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

/* JADX INFO: compiled from: UMDBUtils.java */
/* JADX INFO: loaded from: classes.dex */
class agx {
    /* JADX INFO: renamed from: a */
    public static boolean m989a(String str, SQLiteDatabase sQLiteDatabase) throws Throwable {
        boolean z = false;
        if (str == null) {
            return false;
        }
        Cursor cursor = null;
        try {
            Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type ='table' and name ='" + str.trim() + "' ", null);
            try {
                if (cursorRawQuery.moveToNext()) {
                    if (cursorRawQuery.getInt(0) > 0) {
                        z = true;
                    }
                }
                if (cursorRawQuery != null) {
                    cursorRawQuery.close();
                }
            } catch (Exception unused) {
                cursor = cursorRawQuery;
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                th = th;
                cursor = cursorRawQuery;
                if (cursor != null) {
                    cursor.close();
                }
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public static String m988a(Context context) {
        return "/data/data/" + context.getPackageName() + "/databases/";
    }

    /* JADX INFO: renamed from: b */
    public static void m990b(Context context) {
        if (context == null) {
            return;
        }
        try {
            File file = new File("/data/data/" + context.getPackageName() + "/databases/ua.db");
            if (file != null && file.exists()) {
                file.delete();
            }
            agv.m977a(context).m982a();
        } catch (Throwable th) {
            throw th;
        }
    }
}
