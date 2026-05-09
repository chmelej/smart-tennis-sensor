package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
final class aaq extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a */
    private String f65a;

    /* JADX INFO: renamed from: b */
    private Context f66b;

    public aaq(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 3);
        this.f65a = "";
        this.f66b = null;
        this.f65a = str;
        this.f66b = context.getApplicationContext();
        if (acb.m166b()) {
            acs.f305h.m51a("SQLiteOpenHelper " + this.f65a);
        }
    }

    /* JADX INFO: renamed from: a */
    private static void m31a(SQLiteDatabase sQLiteDatabase) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        String string = null;
        cursor = null;
        try {
            try {
                cursorQuery = sQLiteDatabase.query("user", null, null, null, null, null, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            cursorQuery = cursor;
        }
        try {
            ContentValues contentValues = new ContentValues();
            if (cursorQuery.moveToNext()) {
                string = cursorQuery.getString(0);
                cursorQuery.getInt(1);
                cursorQuery.getString(2);
                cursorQuery.getLong(3);
                contentValues.put("uid", abz.m137b(string));
            }
            if (string != null) {
                sQLiteDatabase.update("user", contentValues, "uid=?", new String[]{string});
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        } catch (Throwable th3) {
            th = th3;
            cursor = cursorQuery;
            acs.f305h.m54b(th);
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r1v4, types: [android.database.Cursor] */
    /* JADX INFO: renamed from: b */
    private static void m32b(SQLiteDatabase sQLiteDatabase) throws Throwable {
        ?? Query;
        ?? it = 0;
        it = 0;
        try {
            try {
                Query = sQLiteDatabase.query("events", null, null, null, null, null, null);
            } catch (Throwable th) {
                th = th;
                Query = it;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            ArrayList arrayList = new ArrayList();
            while (Query.moveToNext()) {
                arrayList.add(new aar(Query.getLong(0), Query.getString(1), Query.getInt(2), Query.getInt(3)));
            }
            ContentValues contentValues = new ContentValues();
            it = arrayList.iterator();
            while (it.hasNext()) {
                aar aarVar = (aar) it.next();
                contentValues.put("content", abz.m137b(aarVar.f68b));
                sQLiteDatabase.update("events", contentValues, "event_id=?", new String[]{Long.toString(aarVar.f67a)});
            }
            if (Query != 0) {
                Query.close();
            }
        } catch (Throwable th3) {
            th = th3;
            if (Query != 0) {
                Query.close();
            }
            throw th;
        }
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public final synchronized void close() {
        super.close();
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("create table if not exists events(event_id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, content TEXT, status INTEGER, send_count INTEGER, timestamp LONG)");
        sQLiteDatabase.execSQL("create table if not exists user(uid TEXT PRIMARY KEY, user_type INTEGER, app_ver TEXT, ts INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists config(type INTEGER PRIMARY KEY NOT NULL, content TEXT, md5sum TEXT, version INTEGER)");
        sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
        sQLiteDatabase.execSQL("CREATE INDEX if not exists status_idx ON events(status)");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) throws Throwable {
        acs.f305h.m58f("upgrade DB from oldVersion " + i + " to newVersion " + i2);
        if (i == 1) {
            sQLiteDatabase.execSQL("create table if not exists keyvalues(key TEXT PRIMARY KEY NOT NULL, value TEXT)");
            m31a(sQLiteDatabase);
            m32b(sQLiteDatabase);
        }
        if (i == 2) {
            m31a(sQLiteDatabase);
            m32b(sQLiteDatabase);
        }
    }
}
