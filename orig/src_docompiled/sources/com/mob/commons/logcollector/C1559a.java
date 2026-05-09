package com.mob.commons.logcollector;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: renamed from: com.mob.commons.logcollector.a */
/* JADX INFO: compiled from: DBHelp.java */
/* JADX INFO: loaded from: classes.dex */
public class C1559a extends SQLiteOpenHelper {
    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public C1559a(Context context) {
        super(context.getApplicationContext(), "ThrowalbeLog.db", (SQLiteDatabase.CursorFactory) null, 1);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(" create table  table_exception(_id integer primary key autoincrement,exception_level integer not null, exception_msg text not null,exception_time timestamp not null, exception_md5 text not null, exception_counts integer DEFAULT 1, exception_sending bit);");
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
