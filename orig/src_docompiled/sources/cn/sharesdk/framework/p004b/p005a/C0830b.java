package cn.sharesdk.framework.p004b.p005a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import cn.sharesdk.framework.utils.C0851d;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.a.b */
/* JADX INFO: compiled from: DBProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class C0830b {

    /* JADX INFO: renamed from: c */
    private static C0830b f5571c;

    /* JADX INFO: renamed from: a */
    private Context f5572a;

    /* JADX INFO: renamed from: b */
    private C0829a f5573b;

    private C0830b(Context context) {
        this.f5572a = context.getApplicationContext();
        this.f5573b = new C0829a(this.f5572a);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0830b m6016a(Context context) {
        if (f5571c == null) {
            f5571c = new C0830b(context);
        }
        return f5571c;
    }

    /* JADX INFO: renamed from: a */
    public Cursor m6020a(String str, String[] strArr, String str2, String[] strArr2, String str3) {
        SQLiteDatabase writableDatabase = this.f5573b.getWritableDatabase();
        C0851d.m6195a().m8609d("Query table: %s", str);
        try {
            return writableDatabase.query(str, strArr, str2, strArr2, null, null, str3);
        } catch (Exception e) {
            C0851d.m6195a().m8623w(e, "when query database occur error table:%s,", str);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public long m6019a(String str, ContentValues contentValues) {
        try {
            return this.f5573b.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e) {
            C0851d.m6195a().m8623w(e, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m6018a(String str, String str2, String[] strArr) {
        int iDelete;
        try {
            iDelete = this.f5573b.getWritableDatabase().delete(str, str2, strArr);
        } catch (Exception e) {
            e = e;
            iDelete = 0;
        }
        try {
            C0851d.m6195a().m8609d("Deleted %d rows from table: %s", Integer.valueOf(iDelete), str);
        } catch (Exception e2) {
            e = e2;
            C0851d.m6195a().m8623w(e, "when delete database occur error table:%s,", str);
        }
        return iDelete;
    }

    /* JADX INFO: renamed from: a */
    public int m6017a(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = this.f5573b.getWritableDatabase().rawQuery("select count(*) from " + str, null);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
        }
        try {
            i = cursorRawQuery.moveToNext() ? cursorRawQuery.getInt(0) : 0;
            cursorRawQuery.close();
        } catch (Exception e2) {
            e = e2;
            cursor = cursorRawQuery;
            C0851d.m6195a().m8622w(e);
            cursor.close();
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            cursor.close();
            throw th;
        }
        return i;
    }
}
