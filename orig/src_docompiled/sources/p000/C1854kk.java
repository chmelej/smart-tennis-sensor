package p000;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: renamed from: kk */
/* JADX INFO: compiled from: CityDBDao.java */
/* JADX INFO: loaded from: classes.dex */
public class C1854kk {

    /* JADX INFO: renamed from: a */
    private C1855kl f10924a;

    public C1854kk(Context context) {
        this.f10924a = new C1855kl(context);
    }

    /* JADX INFO: renamed from: a */
    public List<String> m10104a(String str) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = this.f10924a.getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery("select Name from city where ProvinceID = ?", new String[]{str});
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(cursorRawQuery.getString(0));
        }
        cursorRawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public List<String> m10106b(String str) {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = this.f10924a.getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery("select Name from city_en where ProvinceID = ?", new String[]{str});
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(cursorRawQuery.getString(0));
        }
        cursorRawQuery.close();
        writableDatabase.close();
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public HashMap<String, Integer> m10103a() {
        HashMap<String, Integer> map = new HashMap<>();
        SQLiteDatabase writableDatabase = this.f10924a.getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("province", new String[]{"Name", "ID"}, "CountryID=?", new String[]{"0"}, null, null, null);
        while (cursorQuery.moveToNext()) {
            map.put(cursorQuery.getString(0), Integer.valueOf(Integer.parseInt(cursorQuery.getString(1))));
        }
        cursorQuery.close();
        writableDatabase.close();
        return map;
    }

    /* JADX INFO: renamed from: b */
    public HashMap<String, Integer> m10105b() {
        HashMap<String, Integer> map = new HashMap<>();
        SQLiteDatabase writableDatabase = this.f10924a.getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("province_en", new String[]{"Name", "ID"}, "CountryID=?", new String[]{"0"}, null, null, null);
        while (cursorQuery.moveToNext()) {
            map.put(cursorQuery.getString(0), Integer.valueOf(Integer.parseInt(cursorQuery.getString(1))));
        }
        cursorQuery.close();
        writableDatabase.close();
        return map;
    }

    /* JADX INFO: renamed from: c */
    public List<String> m10107c() {
        ArrayList arrayList = new ArrayList();
        SQLiteDatabase writableDatabase = this.f10924a.getWritableDatabase();
        Cursor cursorRawQuery = writableDatabase.rawQuery("select Name from country_en", null);
        while (cursorRawQuery.moveToNext()) {
            arrayList.add(cursorRawQuery.getString(0));
        }
        cursorRawQuery.close();
        writableDatabase.close();
        return arrayList;
    }
}
