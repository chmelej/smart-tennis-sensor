package p000;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/* JADX INFO: renamed from: ko */
/* JADX INFO: compiled from: Search_db.java */
/* JADX INFO: loaded from: classes.dex */
public class C1858ko extends SQLiteOpenHelper {

    /* JADX INFO: renamed from: a */
    private Context f10928a;

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
    }

    public C1858ko(Context context) {
        super(context, "History.db", (SQLiteDatabase.CursorFactory) null, 1);
        this.f10928a = context;
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Log.d("TAG", "onCreate------------: 建表");
        sQLiteDatabase.execSQL("create table Search_hty(searchcontent String)");
    }
}
