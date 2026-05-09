package com.umeng.message;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONObject;
import p000.ail;

/* JADX INFO: loaded from: classes.dex */
public class MsgLogStore {
    public static final String ActionType = "ActionType";
    public static final String AppLaunchAt = "AppLaunchAt";
    public static final String MsgId = "MsgId";
    public static final String MsgStatus = "MsgStatus";
    public static final String MsgType = "MsgType";
    public static final String SerialNo = "SerialNo";
    public static final String TaskId = "TaskId";
    public static final String Time = "Time";
    public static final String UpdateResponse = "UpdateResponse";

    /* JADX INFO: renamed from: a */
    private static final String f9166a = "com.umeng.message.MsgLogStore";

    /* JADX INFO: renamed from: b */
    private static MsgLogStore f9167b;

    /* JADX INFO: renamed from: c */
    private SQLiteDatabase f9168c;

    /* JADX INFO: renamed from: d */
    private C1611a f9169d;

    /* JADX INFO: renamed from: e */
    private Context f9170e;

    public static MsgLogStore getInstance(Context context) {
        if (f9167b == null) {
            f9167b = new MsgLogStore(context);
            f9167b.m8710b();
        }
        return f9167b;
    }

    private MsgLogStore(Context context) {
        this.f9170e = context.getApplicationContext();
        this.f9169d = new C1611a(context);
        this.f9168c = this.f9169d.getWritableDatabase();
    }

    /* JADX INFO: renamed from: b */
    private void m8710b() {
        if (MessageSharedPrefs.getInstance(this.f9170e).m8701h()) {
            return;
        }
        File[] fileArrListFiles = this.f9170e.getCacheDir().listFiles(new FilenameFilter() { // from class: com.umeng.message.MsgLogStore.1
            @Override // java.io.FilenameFilter
            public boolean accept(File file, String str) {
                return !TextUtils.isEmpty(str) && str.startsWith(MsgConstant.CACHE_LOG_FILE_PREFIX);
            }
        });
        if (fileArrListFiles != null) {
            for (File file : fileArrListFiles) {
                m8708a(file);
                file.delete();
            }
        }
        MessageSharedPrefs.getInstance(this.f9170e).m8702i();
    }

    /* JADX INFO: renamed from: a */
    private void m8708a(File file) {
        try {
            JSONObject jSONObject = new JSONObject(m8709b(file));
            addLog(jSONObject.optString(MsgConstant.KEY_MSG_ID), jSONObject.optInt(MsgConstant.KEY_ACTION_TYPE), jSONObject.optLong(MsgConstant.KEY_TS));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private String m8709b(File file) throws Throwable {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                }
                String string = sb.toString();
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return string;
            } catch (Throwable th) {
                th = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            bufferedReader = null;
        }
    }

    public boolean addLog(String str, int i, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9168c.insert("MsgLogStore", null, new MsgLog(str, i, j).getContentValues()) != -1;
    }

    public boolean removeLog(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append("");
        return this.f9168c.delete("MsgLogStore", "MsgId=? And ActionType=?", new String[]{str, sb.toString()}) == 1;
    }

    public MsgLog getMsgLog(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorQuery = this.f9168c.query("MsgLogStore", null, "MsgId=?", new String[]{str}, null, null, null, null);
        MsgLog msgLog = cursorQuery.moveToFirst() ? new MsgLog(cursorQuery) : null;
        cursorQuery.close();
        return msgLog;
    }

    public ArrayList<MsgLog> getMsgLogs(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<MsgLog> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogStore", null, null, null, null, null, "Time Asc ", i + "");
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLog(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public ArrayList<MsgLog> getMsgLogs() {
        ArrayList<MsgLog> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogStore", null, null, null, null, null, "Time Asc ", null);
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLog(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public boolean addLogIdType(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9168c.insert("MsgLogIdTypeStore", null, new MsgLogIdType(str, str2).getContentValues()) != -1;
    }

    public boolean removeLogIdType(String str) {
        return !TextUtils.isEmpty(str) && this.f9168c.delete("MsgLogIdTypeStore", "MsgId=?", new String[]{str}) == 1;
    }

    public ArrayList<MsgLogIdType> getMsgLogIdTypes(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<MsgLogIdType> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", i + "");
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLogIdType(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public ArrayList<MsgLogIdType> getMsgLogIdTypes() {
        ArrayList<MsgLogIdType> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogIdTypeStore", null, null, null, null, null, "MsgId Asc ", null);
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLogIdType(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public boolean addLogForAgoo(String str, String str2, String str3, long j) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9168c.insert("MsgLogStoreForAgoo", null, new MsgLogForAgoo(str, str2, str3, j).getContentValues()) != -1;
    }

    public boolean removeLogForAgoo(String str, String str2) {
        return !TextUtils.isEmpty(str) && this.f9168c.delete("MsgLogStoreForAgoo", "MsgId=? And MsgStatus=?", new String[]{str, str2}) == 1;
    }

    public MsgLogForAgoo getMsgLogForAgoo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorQuery = this.f9168c.query("MsgLogStoreForAgoo", null, "MsgId=?", new String[]{str}, null, null, null, null);
        MsgLogForAgoo msgLogForAgoo = cursorQuery.moveToFirst() ? new MsgLogForAgoo(cursorQuery) : null;
        cursorQuery.close();
        return msgLogForAgoo;
    }

    public ArrayList<MsgLogForAgoo> getMsgLogsForAgoo(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<MsgLogForAgoo> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogStoreForAgoo", null, null, null, null, null, "Time Asc ", i + "");
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLogForAgoo(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public ArrayList<MsgLogForAgoo> getMsgLogsForAgoo() {
        ArrayList<MsgLogForAgoo> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogStoreForAgoo", null, null, null, null, null, "Time Asc ", null);
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLogForAgoo(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public boolean addLogIdTypeForAgoo(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.f9168c.insert("MsgLogIdTypeStoreForAgoo", null, new MsgLogIdTypeForAgoo(str, str2, str3).getContentValues()) != -1;
    }

    public boolean removeLogIdTypeForAgoo(String str) {
        return !TextUtils.isEmpty(str) && this.f9168c.delete("MsgLogIdTypeStoreForAgoo", "MsgId=?", new String[]{str}) == 1;
    }

    public ArrayList<MsgLogIdTypeForAgoo> getMsgLogIdTypesForAgoo(int i) {
        if (i < 1) {
            return null;
        }
        ArrayList<MsgLogIdTypeForAgoo> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogIdTypeStoreForAgoo", null, null, null, null, null, "MsgId Asc ", i + "");
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLogIdTypeForAgoo(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public ArrayList<MsgLogIdTypeForAgoo> getMsgLogIdTypesForAgoo() {
        ArrayList<MsgLogIdTypeForAgoo> arrayList = new ArrayList<>();
        Cursor cursorQuery = this.f9168c.query("MsgLogIdTypeStoreForAgoo", null, null, null, null, null, "MsgId Asc ", null);
        for (boolean zMoveToFirst = cursorQuery.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery.moveToNext()) {
            arrayList.add(new MsgLogIdTypeForAgoo(cursorQuery));
        }
        cursorQuery.close();
        return arrayList;
    }

    public int getMsgConfigInfo_SerialNo() {
        Cursor cursorQuery = this.f9168c.query("MsgConfigInfo", new String[]{SerialNo}, null, null, null, null, null, null);
        int i = cursorQuery.moveToFirst() ? cursorQuery.getInt(cursorQuery.getColumnIndex(SerialNo)) : 0;
        cursorQuery.close();
        return i;
    }

    public void setMsgConfigInfo_SerialNo(int i) {
        this.f9168c.execSQL("update MsgConfigInfo set SerialNo = " + i);
    }

    public long getMsgConfigInfo_AppLaunchAt() {
        Cursor cursorQuery = this.f9168c.query("MsgConfigInfo", new String[]{AppLaunchAt}, null, null, null, null, null, null);
        long j = cursorQuery.moveToFirst() ? cursorQuery.getLong(cursorQuery.getColumnIndex(AppLaunchAt)) : 0L;
        cursorQuery.close();
        Log.d(f9166a, "appLaunchAt=" + j);
        return j;
    }

    public void setMsgConfigInfo_AppLaunchAt(long j) {
        this.f9168c.execSQL("update MsgConfigInfo set AppLaunchAt = " + j);
    }

    public Object getMsgConfigInfo_UpdateResponse() {
        Cursor cursorQuery = this.f9168c.query("MsgConfigInfo", new String[]{UpdateResponse}, null, null, null, null, null, null);
        String string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndex(UpdateResponse)) : null;
        cursorQuery.close();
        Log.d(f9166a, "updateResponse=" + string);
        return ail.m1350c(string);
    }

    public void setMsgConfigInfo_UpdateResponse(Object obj) {
        this.f9168c.execSQL("update MsgConfigInfo set UpdateResponse =  '" + ail.m1339a(obj) + "'");
    }

    /* JADX INFO: renamed from: com.umeng.message.MsgLogStore$a */
    class C1611a extends SQLiteOpenHelper {
        public C1611a(Context context) {
            super(context, "MsgLogStore.db", (SQLiteDatabase.CursorFactory) null, 4);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists MsgLogStore (MsgId varchar, ActionType Integer, Time long, PRIMARY KEY(MsgId, ActionType))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStore (MsgId varchar, MsgType varchar, PRIMARY KEY(MsgId))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, Time long, PRIMARY KEY(MsgId, MsgStatus))");
            sQLiteDatabase.execSQL("create table if not exists MsgLogIdTypeStoreForAgoo (MsgId varchar, TaskId varchar, MsgStatus varchar, PRIMARY KEY(MsgId))");
            boolean zM8711a = m8711a(sQLiteDatabase, "MsgConfigInfo");
            sQLiteDatabase.execSQL("create table if not exists MsgConfigInfo (SerialNo integer default 1, AppLaunchAt long default 0, UpdateResponse varchar default NULL)");
            if (!zM8711a) {
                sQLiteDatabase.execSQL("insert into MsgConfigInfo(SerialNo, AppLaunchAt) values (?, ?)", new Object[]{Integer.valueOf(MessageSharedPrefs.getInstance(MsgLogStore.this.f9170e).getSerialNo()), Long.valueOf(MessageSharedPrefs.getInstance(MsgLogStore.this.f9170e).getAppLaunchLogSentAt())});
            } else {
                sQLiteDatabase.execSQL("alter table MsgConfigInfo add column UpdateResponse varchar");
            }
            Log.d(MsgLogStore.f9166a, "onCreate");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onCreate(sQLiteDatabase);
            Log.d(MsgLogStore.f9166a, "onUpgrade");
        }

        /* JADX INFO: renamed from: a */
        private boolean m8711a(SQLiteDatabase sQLiteDatabase, String str) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            try {
                Cursor cursorRawQuery = sQLiteDatabase.rawQuery("select count(*) as c from sqlite_master where type = 'table' and name = '" + str.trim() + "'", null);
                if (cursorRawQuery.moveToNext()) {
                    return cursorRawQuery.getInt(0) > 0;
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    public class MsgLog {
        public int actionType;
        public String msgId;
        public long time;

        public MsgLog(String str, int i, long j) {
            this.msgId = str;
            this.actionType = i;
            this.time = j;
        }

        public MsgLog(Cursor cursor) {
            this.msgId = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgId));
            this.time = cursor.getLong(cursor.getColumnIndex(MsgLogStore.Time));
            this.actionType = cursor.getInt(cursor.getColumnIndex("ActionType"));
        }

        public ContentValues getContentValues() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MsgLogStore.MsgId, this.msgId);
            contentValues.put(MsgLogStore.Time, Long.valueOf(this.time));
            contentValues.put("ActionType", Integer.valueOf(this.actionType));
            return contentValues;
        }
    }

    public class MsgLogIdType {
        public String msgId;
        public String msgType;

        public MsgLogIdType(String str, String str2) {
            this.msgId = str;
            this.msgType = str2;
        }

        public MsgLogIdType(Cursor cursor) {
            this.msgId = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgId));
            this.msgType = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgType));
        }

        public ContentValues getContentValues() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MsgLogStore.MsgId, this.msgId);
            contentValues.put(MsgLogStore.MsgType, this.msgType);
            return contentValues;
        }
    }

    public class MsgLogForAgoo {
        public String msgId;
        public String msgStatus;
        public String taskId;
        public long time;

        public MsgLogForAgoo(String str, String str2, String str3, long j) {
            this.msgId = str;
            this.taskId = str2;
            this.msgStatus = str3;
            this.time = j;
        }

        public MsgLogForAgoo(Cursor cursor) {
            this.msgId = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgId));
            this.taskId = cursor.getString(cursor.getColumnIndex(MsgLogStore.TaskId));
            this.msgStatus = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgStatus));
            this.time = cursor.getLong(cursor.getColumnIndex(MsgLogStore.Time));
        }

        public ContentValues getContentValues() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MsgLogStore.MsgId, this.msgId);
            contentValues.put(MsgLogStore.TaskId, this.taskId);
            contentValues.put(MsgLogStore.MsgStatus, this.msgStatus);
            contentValues.put(MsgLogStore.Time, Long.valueOf(this.time));
            return contentValues;
        }
    }

    public class MsgLogIdTypeForAgoo {
        public String msgId;
        public String msgStatus;
        public String taskId;

        public MsgLogIdTypeForAgoo(String str, String str2, String str3) {
            this.msgId = str;
            this.taskId = str2;
            this.msgStatus = str3;
        }

        public MsgLogIdTypeForAgoo(Cursor cursor) {
            this.msgId = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgId));
            this.taskId = cursor.getString(cursor.getColumnIndex(MsgLogStore.TaskId));
            this.msgStatus = cursor.getString(cursor.getColumnIndex(MsgLogStore.MsgStatus));
        }

        public ContentValues getContentValues() {
            ContentValues contentValues = new ContentValues();
            contentValues.put(MsgLogStore.MsgId, this.msgId);
            contentValues.put(MsgLogStore.TaskId, this.taskId);
            contentValues.put(MsgLogStore.MsgStatus, this.msgStatus);
            return contentValues;
        }
    }
}
