package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v4.app.NotificationCompat;
import java.text.SimpleDateFormat;
import java.util.Date;

/* JADX INFO: compiled from: DownloadTaskList.java */
/* JADX INFO: loaded from: classes.dex */
public class ajl {

    /* JADX INFO: renamed from: a */
    private static final String f1316a = "ajl";

    /* JADX INFO: renamed from: b */
    private static Context f1317b;

    /* JADX INFO: renamed from: c */
    private C0164a f1318c;

    /* JADX INFO: renamed from: ajl$b */
    /* JADX INFO: compiled from: DownloadTaskList.java */
    static class C0165b {

        /* JADX INFO: renamed from: a */
        public static final ajl f1320a = new ajl();
    }

    private ajl() {
        this.f1318c = new C0164a(f1317b);
    }

    /* JADX INFO: renamed from: a */
    public static ajl m1559a(Context context) {
        if (f1317b == null && context == null) {
            throw new NullPointerException();
        }
        if (f1317b == null) {
            f1317b = context;
        }
        return C0165b.f1320a;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1563a(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("cp", str);
        contentValues.put("url", str2);
        boolean z = false;
        contentValues.put(NotificationCompat.CATEGORY_PROGRESS, (Integer) 0);
        contentValues.put("last_modified", ats.m5468a());
        try {
            Cursor cursorQuery = this.f1318c.getReadableDatabase().query("umeng_download_task_list", new String[]{NotificationCompat.CATEGORY_PROGRESS}, "cp=? and url=?", new String[]{str, str2}, null, null, null, "1");
            if (cursorQuery.getCount() > 0) {
                atj.m5427c(f1316a, "insert(" + str + ", " + str2 + "):  already exists in the db. Insert is cancelled.");
            } else {
                long jInsert = this.f1318c.getWritableDatabase().insert("umeng_download_task_list", null, contentValues);
                if (jInsert != -1) {
                    z = true;
                }
                atj.m5427c(f1316a, "insert(" + str + ", " + str2 + "): rowid=" + jInsert);
            }
            cursorQuery.close();
        } catch (Exception e) {
            atj.m5428c(f1316a, "insert(" + str + ", " + str2 + "): " + e.getMessage(), e);
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public void m1562a(String str, String str2, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(NotificationCompat.CATEGORY_PROGRESS, Integer.valueOf(i));
        contentValues.put("last_modified", ats.m5468a());
        this.f1318c.getWritableDatabase().update("umeng_download_task_list", contentValues, "cp=? and url=?", new String[]{str, str2});
        atj.m5427c(f1316a, "updateProgress(" + str + ", " + str2 + ", " + i + ")");
    }

    /* JADX INFO: renamed from: a */
    public void m1561a(int i) {
        try {
            Date date = new Date(new Date().getTime() - ((long) (i * 1000)));
            this.f1318c.getWritableDatabase().execSQL(" DELETE FROM umeng_download_task_list WHERE strftime('yyyy-MM-dd HH:mm:ss', last_modified)<=strftime('yyyy-MM-dd HH:mm:ss', '" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date) + "')");
            atj.m5427c(f1316a, "clearOverdueTasks(" + i + ") remove all tasks before " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date));
        } catch (Exception e) {
            atj.m5425b(f1316a, e.getMessage());
        }
    }

    public void finalize() {
        this.f1318c.close();
    }

    /* JADX INFO: renamed from: ajl$a */
    /* JADX INFO: compiled from: DownloadTaskList.java */
    class C0164a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        C0164a(Context context) {
            super(context, "UMENG_DATA", (SQLiteDatabase.CursorFactory) null, 2);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            atj.m5427c(ajl.f1316a, "CREATE TABLE umeng_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
            sQLiteDatabase.execSQL("CREATE TABLE umeng_download_task_list (cp TEXT, url TEXT, progress INTEGER, extra TEXT, last_modified TEXT, UNIQUE (cp,url) ON CONFLICT ABORT);");
        }
    }
}
