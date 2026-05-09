package p000;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: UMCCDBHelper.java */
/* JADX INFO: loaded from: classes.dex */
class afb extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b */
    private static Context f738b;

    /* JADX INFO: renamed from: a */
    private String f739a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX INFO: renamed from: afb$a */
    /* JADX INFO: compiled from: UMCCDBHelper.java */
    static class C0081a {

        /* JADX INFO: renamed from: a */
        private static final afb f740a = new afb(afb.f738b, aft.m904a(afb.f738b), "cc.db", null, 1);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized afb m798a(Context context) {
        f738b = context;
        return C0081a.f740a;
    }

    private afb(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new agk(context, str), str2, cursorFactory, i);
    }

    private afb(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, (str == null || str.equals("")) ? "cc.db" : str, cursorFactory, i);
        m801b();
    }

    /* JADX INFO: renamed from: b */
    private void m801b() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!m804a("aggregated", writableDatabase) || !m804a("aggregated_cache", writableDatabase)) {
                m803c(writableDatabase);
            }
            if (!m804a("system", writableDatabase)) {
                m802b(writableDatabase);
            }
            if (m804a("limitedck", writableDatabase)) {
                return;
            }
            m800a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m804a(String str, SQLiteDatabase sQLiteDatabase) throws Throwable {
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

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                m803c(sQLiteDatabase);
                m802b(sQLiteDatabase);
                m800a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            sQLiteDatabase.endTransaction();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m800a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        try {
            this.f739a = "create table if not exists limitedck(Id INTEGER primary key autoincrement, ck TEXT unique)";
            sQLiteDatabase.execSQL(this.f739a);
            return true;
        } catch (SQLException unused) {
            aex.m776c("create reference table error!");
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m802b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        try {
            this.f739a = "create table if not exists system(Id INTEGER primary key autoincrement, key TEXT, timeStamp INTEGER, count INTEGER)";
            sQLiteDatabase.execSQL(this.f739a);
            return true;
        } catch (SQLException unused) {
            aex.m776c("create system table error!");
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m803c(SQLiteDatabase sQLiteDatabase) throws Throwable {
        try {
            this.f739a = "create table if not exists aggregated_cache(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f739a);
            this.f739a = "create table if not exists aggregated(Id INTEGER primary key autoincrement, key TEXT, totalTimestamp TEXT, value INTEGER, count INTEGER, label TEXT, timeWindowNum TEXT)";
            sQLiteDatabase.execSQL(this.f739a);
            return true;
        } catch (SQLException unused) {
            aex.m776c("create aggregated table error!");
            return false;
        }
    }
}
