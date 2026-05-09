package p000;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: compiled from: UMDBCreater.java */
/* JADX INFO: loaded from: classes.dex */
class agv extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: b */
    private static Context f862b;

    /* JADX INFO: renamed from: a */
    private String f863a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    /* JADX INFO: renamed from: agv$a */
    /* JADX INFO: compiled from: UMDBCreater.java */
    static class C0105a {

        /* JADX INFO: renamed from: a */
        private static final agv f864a = new agv(agv.f862b, agx.m988a(agv.f862b), "ua.db", null, 1);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized agv m977a(Context context) {
        f862b = context;
        return C0105a.f864a;
    }

    private agv(Context context, String str, String str2, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        this(new agu(context, str), str2, cursorFactory, i);
    }

    private agv(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i) {
        super(context, (str == null || str.equals("")) ? "ua.db" : str, cursorFactory, i);
        this.f863a = null;
        m982a();
    }

    /* JADX INFO: renamed from: a */
    public void m982a() {
        try {
            SQLiteDatabase writableDatabase = getWritableDatabase();
            if (!agx.m989a("__sd", writableDatabase)) {
                m981c(writableDatabase);
            }
            if (!agx.m989a("__et", writableDatabase)) {
                m980b(writableDatabase);
            }
            if (agx.m989a("__er", writableDatabase)) {
                return;
            }
            m978a(writableDatabase);
        } catch (Exception unused) {
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        try {
            try {
                sQLiteDatabase.beginTransaction();
                m981c(sQLiteDatabase);
                m980b(sQLiteDatabase);
                m978a(sQLiteDatabase);
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (SQLiteDatabaseCorruptException unused2) {
            agx.m990b(f862b);
            if (sQLiteDatabase != null) {
            }
        } catch (Throwable unused3) {
            if (sQLiteDatabase == null) {
                return;
            }
        }
        if (sQLiteDatabase != null) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Throwable unused4) {
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m978a(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f863a = "create table if not exists __er(id INTEGER primary key autoincrement, __i TEXT, __a TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.f863a);
        } catch (SQLException unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private void m980b(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f863a = "create table if not exists __et(id INTEGER primary key autoincrement, __i TEXT, __e TEXT, __s TEXT, __t INTEGER)";
            sQLiteDatabase.execSQL(this.f863a);
        } catch (SQLException unused) {
        }
    }

    /* JADX INFO: renamed from: c */
    private void m981c(SQLiteDatabase sQLiteDatabase) {
        try {
            this.f863a = "create table if not exists __sd(id INTEGER primary key autoincrement, __ii TEXT unique, __a TEXT, __b TEXT, __c TEXT, __d TEXT, __e TEXT, __f TEXT, __g TEXT)";
            sQLiteDatabase.execSQL(this.f863a);
        } catch (SQLException unused) {
        }
    }
}
