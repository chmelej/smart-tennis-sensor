package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.coollang.tennis.beans.SyncDataBean;
import com.coollang.tennis.beans.TrainHistoryDetailUpBean;
import com.coollang.tennis.beans.TrainSendResultBean;
import java.util.List;
import org.litepal.tablemanager.Connector;

/* JADX INFO: renamed from: km */
/* JADX INFO: compiled from: LitepalDBHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C1856km {

    /* JADX INFO: renamed from: a */
    private static C1856km f10926a;

    /* JADX INFO: renamed from: a */
    public static C1856km m10109a() {
        if (f10926a == null) {
            f10926a = new C1856km();
        }
        return f10926a;
    }

    /* JADX INFO: renamed from: a */
    public void m10113a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Connector.getDatabase().execSQL("INSERT INTO mydetailTable (userid , timestamp ,actionType ,speed ,radian , force, istarget ,whichnum ,sign1 , sign2 , handtype ) VALUES (?,?,?,?,?,?,?,?,?,?,? );", new String[]{str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11});
    }

    /* JADX INFO: renamed from: a */
    public void m10115a(List<SyncDataBean.Alldata.SyncData.DetailAd> list, String str, String str2) {
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        SQLiteStatement sQLiteStatementCompileStatement = database.compileStatement("INSERT INTO mydetailTable (userid , timestamp ,actionType ,speed ,radian , force, istarget ,whichnum ,sign1 , sign2, handtype ) VALUES (?,?,?,?,?,?,?,?,?,?,?);");
        for (int i = 0; i < list.size(); i++) {
            sQLiteStatementCompileStatement.bindString(1, str2);
            sQLiteStatementCompileStatement.bindString(2, list.get(i).Timestamp);
            sQLiteStatementCompileStatement.bindString(3, list.get(i).Type);
            sQLiteStatementCompileStatement.bindString(4, list.get(i).Speed);
            sQLiteStatementCompileStatement.bindString(5, list.get(i).Radian);
            sQLiteStatementCompileStatement.bindString(6, list.get(i).Force);
            sQLiteStatementCompileStatement.bindString(7, list.get(i).Sweet);
            sQLiteStatementCompileStatement.bindString(8, String.valueOf(i));
            sQLiteStatementCompileStatement.bindString(9, "1");
            sQLiteStatementCompileStatement.bindString(10, str);
            sQLiteStatementCompileStatement.bindString(11, list.get(i).f7420H == null ? "0" : list.get(i).f7420H);
            sQLiteStatementCompileStatement.executeInsert();
            sQLiteStatementCompileStatement.clearBindings();
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /* JADX INFO: renamed from: a */
    public void m10114a(List<TrainHistoryDetailUpBean> list, String str) {
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        SQLiteStatement sQLiteStatementCompileStatement = database.compileStatement("INSERT INTO ontimedetailtable (actionType , handType ,shotTimeStemp ,hitSpeed ,trainId , sweet ) VALUES (?,?,?,?,?,?);");
        for (int i = 0; i < list.size(); i++) {
            sQLiteStatementCompileStatement.bindString(1, String.valueOf(list.get(i).f7425T));
            sQLiteStatementCompileStatement.bindString(2, String.valueOf(list.get(i).f7423F));
            sQLiteStatementCompileStatement.bindString(3, String.valueOf(list.get(i).f7422D));
            sQLiteStatementCompileStatement.bindString(4, String.valueOf(list.get(i).f7424S));
            sQLiteStatementCompileStatement.bindString(5, str);
            sQLiteStatementCompileStatement.bindString(6, "0");
            sQLiteStatementCompileStatement.executeInsert();
            sQLiteStatementCompileStatement.clearBindings();
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /* JADX INFO: renamed from: b */
    public void m10118b(List<TrainSendResultBean.ErrDescBean.DetailBean> list, String str) {
        SQLiteDatabase database = Connector.getDatabase();
        database.beginTransaction();
        SQLiteStatement sQLiteStatementCompileStatement = database.compileStatement("INSERT INTO ontimedetailtable (actionType , handType ,shotTimeStemp ,hitSpeed ,trainId , sweet ) VALUES (?,?,?,?,?,?);");
        for (int i = 0; i < list.size(); i++) {
            sQLiteStatementCompileStatement.bindString(1, String.valueOf(list.get(i).f7429T));
            sQLiteStatementCompileStatement.bindString(2, "0");
            sQLiteStatementCompileStatement.bindString(3, String.valueOf(list.get(i).f7427D));
            sQLiteStatementCompileStatement.bindString(4, String.valueOf(list.get(i).f7428S));
            sQLiteStatementCompileStatement.bindString(5, str);
            sQLiteStatementCompileStatement.bindString(6, "1");
            sQLiteStatementCompileStatement.executeInsert();
            sQLiteStatementCompileStatement.clearBindings();
        }
        database.setTransactionSuccessful();
        database.endTransaction();
    }

    /* JADX INFO: renamed from: a */
    public String m10111a(String str, String str2) {
        SQLiteDatabase database = Connector.getDatabase();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\"DetailData\":[");
        Cursor cursorQuery = database.query("mydetailTable", null, "sign2 = ? And UserID = ?", new String[]{str, str2}, null, null, "timestamp");
        while (cursorQuery.moveToNext()) {
            stringBuffer.append("{\"Force\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("force")));
            stringBuffer.append("\",\"Radian\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("radian")));
            stringBuffer.append("\",\"Speed\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("speed")));
            stringBuffer.append("\",\"Sweet\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("istarget")));
            stringBuffer.append("\",\"Timestamp\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("timestamp")));
            stringBuffer.append("\",\"Type\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("actiontype")));
            stringBuffer.append("\",\"H\":\"");
            stringBuffer.append(cursorQuery.getString(cursorQuery.getColumnIndex("handtype")));
            stringBuffer.append("\"},");
        }
        cursorQuery.close();
        String string = stringBuffer.toString();
        if (string.endsWith(",")) {
            return string.substring(0, string.length() - 1) + "]";
        }
        return string + "]";
    }

    /* JADX INFO: renamed from: a */
    public void m10112a(String str) {
        SQLiteDatabase database = Connector.getDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("handtype", (Integer) 0);
        database.update("mydetailTable", contentValues, "UserId = ? And handtype is null", new String[]{str});
    }

    /* JADX INFO: renamed from: b */
    public void m10117b(String str) {
        SQLiteDatabase database = Connector.getDatabase();
        Cursor cursorQuery = database.query("mymaintable", null, "UserID = ? And signdate is null ", new String[]{str}, null, null, null);
        long jM10541c = C1912mk.m10541c();
        while (cursorQuery.moveToNext()) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("signdate", C1912mk.m10540b(cursorQuery.getLong(cursorQuery.getColumnIndex("date")) - jM10541c));
            database.update("mymaintable", contentValues, "userid = ? And date = ?", new String[]{str, String.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("date")))});
        }
        cursorQuery.close();
    }

    /* JADX INFO: renamed from: a */
    public int m10110a(int i, int i2) {
        Cursor cursorQuery = Connector.getDatabase().query("ontimemaintable", null, "userid = ? And endTimeStemp != 0 And type = 0", new String[]{String.valueOf(i2)}, null, null, null);
        if (cursorQuery.getCount() < i || !cursorQuery.moveToPosition(cursorQuery.getCount() - i)) {
            return -1;
        }
        return cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
    }

    /* JADX INFO: renamed from: b */
    public int m10116b(int i, int i2) {
        Cursor cursorQuery = Connector.getDatabase().query("ontimemaintable", null, "userid = ? And endTimeStemp != 0 And type = 1", new String[]{String.valueOf(i2)}, null, null, null);
        C1900mc.m10474b("cursor", " " + cursorQuery.getCount());
        int i3 = (cursorQuery.getCount() < i || !cursorQuery.moveToPosition(cursorQuery.getCount() - i)) ? -1 : cursorQuery.getInt(cursorQuery.getColumnIndex("id"));
        cursorQuery.close();
        return i3;
    }
}
