package p000;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: UmengLocalNotificationStore.java */
/* JADX INFO: loaded from: classes.dex */
public class ahk {

    /* JADX INFO: renamed from: a */
    private static final String f1025a = "ahk";

    /* JADX INFO: renamed from: b */
    private static ahk f1026b;

    /* JADX INFO: renamed from: c */
    private SQLiteDatabase f1027c;

    /* JADX INFO: renamed from: d */
    private C0110a f1028d;

    /* JADX INFO: renamed from: e */
    private Context f1029e;

    /* JADX INFO: renamed from: a */
    public static synchronized ahk m1144a(Context context) {
        if (f1026b == null) {
            f1026b = new ahk(context);
        }
        return f1026b;
    }

    private ahk(Context context) {
        this.f1029e = context.getApplicationContext();
        this.f1028d = new C0110a(context);
        this.f1027c = this.f1028d.getWritableDatabase();
    }

    /* JADX INFO: renamed from: a */
    public ahh m1145a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Cursor cursorQuery = this.f1027c.query("UmengLocalNotification", null, "id=?", new String[]{str}, null, null, null, null);
        boolean zMoveToFirst = cursorQuery.moveToFirst();
        ahh ahhVar = zMoveToFirst ? new ahh(cursorQuery) : null;
        cursorQuery.close();
        Cursor cursorQuery2 = this.f1027c.query("UmengNotificationBuilder", null, "localnotification_id=?", new String[]{str}, null, null, null, null);
        boolean zMoveToFirst2 = cursorQuery2.moveToFirst();
        if (zMoveToFirst && zMoveToFirst2) {
            ahhVar.m1104a(new ahl(cursorQuery2));
        }
        return ahhVar;
    }

    /* JADX INFO: renamed from: b */
    public List<ahh> m1148b(String str) {
        Cursor cursor = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        Cursor cursorQuery = this.f1027c.query("UmengLocalNotification", null, "title LIKE '%" + str + "%' OR content LIKE '%" + str + "%'", null, null, null, null, null);
        boolean zMoveToFirst = cursorQuery.moveToFirst();
        while (zMoveToFirst) {
            ahh ahhVar = new ahh(cursorQuery);
            Cursor cursorQuery2 = this.f1027c.query("UmengNotificationBuilder", null, "localnotification_id=?", new String[]{ahhVar.m1102a()}, null, null, null, null);
            if (cursorQuery2.moveToFirst()) {
                ahhVar.m1104a(new ahl(cursorQuery2));
            }
            arrayList.add(ahhVar);
            zMoveToFirst = cursorQuery.moveToNext();
            cursor = cursorQuery2;
        }
        cursorQuery.close();
        if (cursor != null) {
            cursor.close();
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public List<ahh> m1146a() {
        Cursor cursorQuery = null;
        Cursor cursorQuery2 = this.f1027c.query("UmengLocalNotification", null, null, null, null, null, null, null);
        ArrayList arrayList = new ArrayList();
        for (boolean zMoveToFirst = cursorQuery2.moveToFirst(); zMoveToFirst; zMoveToFirst = cursorQuery2.moveToNext()) {
            ahh ahhVar = new ahh(cursorQuery2);
            cursorQuery = this.f1027c.query("UmengNotificationBuilder", null, "localnotification_id=?", new String[]{ahhVar.m1102a()}, null, null, null, null);
            if (cursorQuery.moveToFirst()) {
                ahhVar.m1104a(new ahl(cursorQuery));
            }
            arrayList.add(ahhVar);
        }
        cursorQuery2.close();
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1147a(ahh ahhVar) {
        if (TextUtils.isEmpty(ahhVar.m1102a()) || TextUtils.isEmpty(ahhVar.m1125o().m1160a())) {
            return false;
        }
        return (this.f1027c.insert("UmengLocalNotification", null, ahhVar.m1128r()) == -1 || this.f1027c.insert("UmengNotificationBuilder", null, ahhVar.m1125o().m1164c()) == -1) ? false : true;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1150b(ahh ahhVar) {
        if (TextUtils.isEmpty(ahhVar.m1102a()) || TextUtils.isEmpty(ahhVar.m1125o().m1160a())) {
            return false;
        }
        return (((long) this.f1027c.update("UmengLocalNotification", ahhVar.m1128r(), "id=?", new String[]{ahhVar.m1102a()})) == -1 || ((long) this.f1027c.update("UmengNotificationBuilder", ahhVar.m1125o().m1164c(), "id=?", new String[]{ahhVar.m1125o().m1160a()})) == -1) ? false : true;
    }

    /* JADX INFO: renamed from: c */
    public boolean m1151c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String[] strArr = {str};
        return this.f1027c.delete("UmengLocalNotification", "id=?", strArr) == 1 && this.f1027c.delete("UmengNotificationBuilder", "localnotification_id=?", strArr) == 1;
    }

    /* JADX INFO: renamed from: b */
    public void m1149b() {
        Iterator<ahh> it = m1146a().iterator();
        while (it.hasNext()) {
            String[] strArr = {it.next().m1102a()};
            this.f1027c.delete("UmengLocalNotification", "id=?", strArr);
            this.f1027c.delete("UmengNotificationBuilder", "localnotification_id=?", strArr);
        }
    }

    /* JADX INFO: renamed from: ahk$a */
    /* JADX INFO: compiled from: UmengLocalNotificationStore.java */
    class C0110a extends SQLiteOpenHelper {
        public C0110a(Context context) {
            super(context, "UmengLocalNotificationStore.db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.execSQL("create table if not exists UmengLocalNotification (id varchar, year integer, month integer, day integer, hour integer, minute integer, second integer, repeating_num integer, repeating_unit integer, repeating_interval integer, special_day integer, title varchar, content varchar, ticker varchar, PRIMARY KEY(id))");
            sQLiteDatabase.execSQL("create table if not exists UmengNotificationBuilder (id varchar, localnotification_id varchar, flags integer, defaults integer, smallicon_drawable varchar, largeicon_drawable varchar, sound_drawable varchar, play_vibrate integer, play_lights integer, play_sound integer, screen_on integer, layout_id integer, layout_title_id integer, layout_content_id integer, layout_icon_id integer, layout_icon_drawable_id, FOREIGN KEY(localnotification_id) REFERENCES UmengLocalNotification(id), PRIMARY KEY(id))");
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            onCreate(sQLiteDatabase);
        }
    }
}
