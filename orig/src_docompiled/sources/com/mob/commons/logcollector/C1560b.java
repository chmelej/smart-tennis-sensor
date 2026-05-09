package com.mob.commons.logcollector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.mob.tools.MobLog;

/* JADX INFO: renamed from: com.mob.commons.logcollector.b */
/* JADX INFO: compiled from: DBProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class C1560b {

    /* JADX INFO: renamed from: c */
    private static C1560b f9004c;

    /* JADX INFO: renamed from: a */
    private Context f9005a;

    /* JADX INFO: renamed from: b */
    private C1559a f9006b;

    private C1560b(Context context) {
        this.f9005a = context.getApplicationContext();
        this.f9006b = new C1559a(this.f9005a);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C1560b m8572a(Context context) {
        if (f9004c == null) {
            f9004c = new C1560b(context);
        }
        return f9004c;
    }

    /* JADX INFO: renamed from: a */
    public long m8575a(String str, ContentValues contentValues) {
        try {
            return this.f9006b.getWritableDatabase().replace(str, null, contentValues);
        } catch (Exception e) {
            MobLog.getInstance().m8623w(e, "when insert database occur error table:%s,", str);
            return -1L;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m8574a(String str, String str2, String[] strArr) {
        int iDelete;
        try {
            iDelete = this.f9006b.getWritableDatabase().delete(str, str2, strArr);
        } catch (Exception e) {
            e = e;
            iDelete = 0;
        }
        try {
            MobLog.getInstance().m8609d("Deleted %d rows from table: %s", Integer.valueOf(iDelete), str);
        } catch (Exception e2) {
            e = e2;
            MobLog.getInstance().m8623w(e, "when delete database occur error table:%s,", str);
        }
        return iDelete;
    }

    /* JADX INFO: renamed from: a */
    public int m8573a(String str) throws Throwable {
        Cursor cursorRawQuery;
        Cursor cursor = null;
        try {
            try {
                cursorRawQuery = this.f9006b.getWritableDatabase().rawQuery("select count(*) from " + str, null);
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
            MobLog.getInstance().m8622w(e);
            cursor.close();
        } catch (Throwable th2) {
            th = th2;
            cursor = cursorRawQuery;
            cursor.close();
            throw th;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public Cursor m8576a(String str, String[] strArr) {
        try {
            return this.f9006b.getWritableDatabase().rawQuery(str, strArr);
        } catch (Exception e) {
            MobLog.getInstance().m8622w(e);
            return null;
        }
    }
}
