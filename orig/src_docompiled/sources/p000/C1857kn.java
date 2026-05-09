package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: kn */
/* JADX INFO: compiled from: Search_UTils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1857kn {

    /* JADX INFO: renamed from: a */
    Context f10927a;

    public C1857kn(Context context) {
        this.f10927a = context;
    }

    /* JADX INFO: renamed from: a */
    public List<String> m10119a() {
        SQLiteDatabase readableDatabase = new C1858ko(this.f10927a).getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = readableDatabase.query("Search_hty", new String[]{"searchcontent"}, null, null, null, null, null);
        Log.d("TAG", "Cursor: " + cursorQuery.toString());
        if (cursorQuery.moveToFirst()) {
            do {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("searchcontent"));
                Log.e("TAG", "query_data: " + string);
                if (string != null || !string.equals("")) {
                    arrayList.add(string);
                }
            } while (cursorQuery.moveToNext());
        }
        cursorQuery.close();
        readableDatabase.close();
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public void m10120a(String str) {
        C1858ko c1858ko = new C1858ko(this.f10927a);
        ContentValues contentValues = new ContentValues();
        contentValues.put("searchcontent", str);
        SQLiteDatabase writableDatabase = c1858ko.getWritableDatabase();
        writableDatabase.insert("Search_hty", null, contentValues);
        writableDatabase.close();
    }

    /* JADX INFO: renamed from: b */
    public void m10121b(String str) {
        SQLiteDatabase writableDatabase = new C1858ko(this.f10927a).getWritableDatabase();
        writableDatabase.delete("Search_hty", "searchcontent=?", new String[]{str});
        writableDatabase.close();
    }

    /* JADX INFO: renamed from: c */
    public List<String> m10122c(String str) {
        SQLiteDatabase readableDatabase = new C1858ko(this.f10927a).getReadableDatabase();
        ArrayList arrayList = new ArrayList();
        new String[1][0] = "searchcontent=?";
        Cursor cursorQuery = readableDatabase.query("Search_hty", null, "searchcontent=?", new String[]{str}, null, null, null);
        Log.d("TAG", "Select_data: " + cursorQuery.toString());
        if (cursorQuery.moveToFirst()) {
            do {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("searchcontent"));
                Log.e("TAG", "Select_data: " + string);
                if (string != null || !string.equals("")) {
                    arrayList.add(string);
                }
            } while (cursorQuery.moveToNext());
        }
        cursorQuery.close();
        readableDatabase.close();
        return arrayList;
    }
}
