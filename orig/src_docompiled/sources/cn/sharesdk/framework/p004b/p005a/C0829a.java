package cn.sharesdk.framework.p004b.p005a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.a.a */
/* JADX INFO: compiled from: DBHelp.java */
/* JADX INFO: loaded from: classes.dex */
public class C0829a extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public C0829a(Context context) {
        super(context.getApplicationContext(), "sharesdk.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" create table  message(_id integer primary key autoincrement,post_time timestamp not null, message_data text not null);");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        super.onOpen(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper, java.lang.AutoCloseable
    public synchronized void close() {
        super.close();
    }
}
