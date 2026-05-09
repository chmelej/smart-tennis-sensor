package com.umeng.message;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* JADX INFO: loaded from: classes.dex */
public class MessageStore {
    public static final String ActionType = "ActionType";
    public static final String ArrivalTime = "ArrivalTime";

    /* JADX INFO: renamed from: Id */
    public static final String f9157Id = "_id";
    public static final String Json = "Json";
    public static final String MsgId = "MsdId";
    public static final String SdkVersion = "SdkVersion";
    public static MessageStore instance;

    /* JADX INFO: renamed from: a */
    private Context f9158a;

    /* JADX INFO: renamed from: b */
    private SQLiteDatabase f9159b;

    /* JADX INFO: renamed from: c */
    private C1609a f9160c;

    public static MessageStore getInstance(Context context) {
        if (instance == null) {
            instance = new MessageStore(context);
        }
        return instance;
    }

    private MessageStore(Context context) {
        this.f9158a = context.getApplicationContext();
        this.f9160c = new C1609a(context);
        this.f9159b = this.f9160c.getWritableDatabase();
    }

    /* JADX INFO: renamed from: com.umeng.message.MessageStore$a */
    class C1609a extends SQLiteOpenHelper {
        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        }

        public C1609a(Context context) {
            super(context, "MessageStore.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MessageStore(_id Integer  PRIMARY KEY  AUTOINCREMENT  , MsdId Varchar  , Json Varchar  , SdkVersion Varchar  , ArrivalTime Long  , ActionType Integer )");
        }
    }
}
