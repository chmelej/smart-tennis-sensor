package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes.dex */
public class acs {

    /* JADX INFO: renamed from: h */
    private static abj f305h = abt.m89c();

    /* JADX INFO: renamed from: i */
    private static Context f306i;

    /* JADX INFO: renamed from: j */
    private static acs f307j;

    /* JADX INFO: renamed from: c */
    private aaq f310c;

    /* JADX INFO: renamed from: d */
    private aaq f311d;

    /* JADX INFO: renamed from: e */
    private abn f312e;

    /* JADX INFO: renamed from: f */
    private String f313f;

    /* JADX INFO: renamed from: g */
    private String f314g;

    /* JADX INFO: renamed from: l */
    private ConcurrentHashMap<aai, String> f316l;

    /* JADX INFO: renamed from: a */
    volatile int f308a = 0;

    /* JADX INFO: renamed from: b */
    abk f309b = null;

    /* JADX INFO: renamed from: k */
    private int f315k = 0;

    /* JADX INFO: renamed from: m */
    private boolean f317m = false;

    /* JADX INFO: renamed from: n */
    private HashMap<String, String> f318n = new HashMap<>();

    private acs(Context context) {
        this.f310c = null;
        this.f311d = null;
        this.f312e = null;
        this.f313f = "";
        this.f314g = "";
        this.f316l = null;
        try {
            this.f312e = new abn();
            f306i = context.getApplicationContext();
            this.f316l = new ConcurrentHashMap<>();
            this.f313f = abt.m111p(context);
            this.f314g = "pri_" + abt.m111p(context);
            this.f310c = new aaq(f306i, this.f313f);
            this.f311d = new aaq(f306i, this.f314g);
            m265a(true);
            m265a(false);
            m273e();
            m284b(f306i);
            m277i();
            m278j();
        } catch (Throwable th) {
            f305h.m54b(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public static acs m255a(Context context) {
        if (f307j == null) {
            synchronized (acs.class) {
                if (f307j == null) {
                    f307j = new acs(context);
                }
            }
        }
        return f307j;
    }

    /* JADX INFO: renamed from: a */
    private static String m256a(List<aar> list) {
        StringBuilder sb = new StringBuilder(list.size() * 3);
        sb.append("event_id in (");
        int size = list.size();
        Iterator<aar> it = list.iterator();
        int i = 0;
        while (it.hasNext()) {
            sb.append(it.next().f67a);
            if (i != size - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append(")");
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private synchronized void m257a(int i, boolean z) {
        try {
            if (this.f308a > 0 && i > 0 && !acd.m203a()) {
                if (acb.m166b()) {
                    f305h.m51a("Load " + this.f308a + " unsent events");
                }
                ArrayList arrayList = new ArrayList(i);
                m270b(arrayList, i, z);
                if (arrayList.size() > 0) {
                    if (acb.m166b()) {
                        f305h.m51a("Peek " + arrayList.size() + " unsent events.");
                    }
                    m264a(arrayList, 2, z);
                    aay.m38b(f306i).m41b(arrayList, new aao(this, arrayList, z));
                }
            }
        } catch (Throwable th) {
            f305h.m54b(th);
        }
    }

    /* JADX INFO: renamed from: a */
    static /* synthetic */ void m259a(acs acsVar, int i, boolean z) {
        if (i == -1) {
            i = !z ? acsVar.m274f() : acsVar.m275g();
        }
        if (i > 0) {
            int iM181l = acb.m181l() * 60 * acb.m177h();
            if (i > iM181l && iM181l > 0) {
                i = iM181l;
            }
            int iM178i = acb.m178i();
            int i2 = i / iM178i;
            int i3 = i % iM178i;
            if (acb.m166b()) {
                f305h.m51a("sentStoreEventsByDb sendNumbers=" + i + ",important=" + z + ",maxSendNumPerFor1Period=" + iM181l + ",maxCount=" + i2 + ",restNumbers=" + i3);
            }
            for (int i4 = 0; i4 < i2; i4++) {
                acsVar.m257a(iM178i, z);
            }
            if (i3 > 0) {
                acsVar.m257a(i3, z);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public synchronized void m264a(List<aar> list, int i, boolean z) {
        SQLiteDatabase sQLiteDatabaseM267b;
        String str;
        if (list.size() == 0) {
            return;
        }
        int iM176g = !z ? acb.m176g() : acb.m173e();
        SQLiteDatabase sQLiteDatabase = null;
        str = null;
        String str2 = null;
        sQLiteDatabase = null;
        try {
            try {
                sQLiteDatabaseM267b = m267b(z);
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
            sQLiteDatabaseM267b = sQLiteDatabase;
        }
        try {
            if (i == 2) {
                str = "update events set status=" + i + ", send_count=send_count+1  where " + m256a(list);
            } else {
                str = "update events set status=" + i + " where " + m256a(list);
                if (this.f315k % 3 == 0) {
                    str2 = "delete from events where send_count>" + iM176g;
                }
                this.f315k++;
            }
            if (acb.m166b()) {
                f305h.m51a("update sql:" + str);
            }
            sQLiteDatabaseM267b.beginTransaction();
            sQLiteDatabaseM267b.execSQL(str);
            if (str2 != null) {
                f305h.m51a("update for delete sql:" + str2);
                sQLiteDatabaseM267b.execSQL(str2);
                m273e();
            }
            sQLiteDatabaseM267b.setTransactionSuccessful();
            if (sQLiteDatabaseM267b != null) {
                try {
                    sQLiteDatabaseM267b.endTransaction();
                } catch (Throwable th3) {
                    f305h.m54b(th3);
                }
            }
        } catch (Throwable th4) {
            th = th4;
            if (sQLiteDatabaseM267b != null) {
                try {
                    sQLiteDatabaseM267b.endTransaction();
                } catch (Throwable th5) {
                    f305h.m54b(th5);
                }
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0072 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m265a(boolean r9) throws java.lang.Throwable {
        /*
            r8 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r9 = r8.m267b(r9)     // Catch: java.lang.Throwable -> L5c java.lang.Throwable -> L61
            r9.beginTransaction()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            android.content.ContentValues r0 = new android.content.ContentValues     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            r0.<init>()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            java.lang.String r1 = "status"
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            r0.put(r1, r3)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            java.lang.String r1 = "events"
            java.lang.String r3 = "status=?"
            java.lang.String[] r2 = new java.lang.String[r2]     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            r4 = 0
            r5 = 2
            java.lang.String r5 = java.lang.Long.toString(r5)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            r2[r4] = r5     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            int r0 = r9.update(r1, r0, r3, r2)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            boolean r1 = p000.acb.m166b()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            if (r1 == 0) goto L48
            abj r1 = p000.acs.f305h     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            java.lang.String r3 = "update "
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            r2.append(r0)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            java.lang.String r0 = " unsent events."
            r2.append(r0)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            r1.m51a(r0)     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
        L48:
            r9.setTransactionSuccessful()     // Catch: java.lang.Throwable -> L58 java.lang.Throwable -> L5a
            if (r9 == 0) goto L57
            r9.endTransaction()     // Catch: java.lang.Throwable -> L51
            return
        L51:
            r9 = move-exception
            abj r0 = p000.acs.f305h
            r0.m54b(r9)
        L57:
            return
        L58:
            r0 = move-exception
            goto L70
        L5a:
            r0 = move-exception
            goto L65
        L5c:
            r9 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
            goto L70
        L61:
            r9 = move-exception
            r7 = r0
            r0 = r9
            r9 = r7
        L65:
            abj r1 = p000.acs.f305h     // Catch: java.lang.Throwable -> L58
            r1.m54b(r0)     // Catch: java.lang.Throwable -> L58
            if (r9 == 0) goto L6f
            r9.endTransaction()     // Catch: java.lang.Throwable -> L51
        L6f:
            return
        L70:
            if (r9 == 0) goto L7c
            r9.endTransaction()     // Catch: java.lang.Throwable -> L76
            goto L7c
        L76:
            r9 = move-exception
            abj r1 = p000.acs.f305h
            r1.m54b(r9)
        L7c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.acs.m265a(boolean):void");
    }

    /* JADX INFO: renamed from: b */
    public static acs m266b() {
        return f307j;
    }

    /* JADX INFO: renamed from: b */
    private SQLiteDatabase m267b(boolean z) {
        return (!z ? this.f310c : this.f311d).getWritableDatabase();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public synchronized void m268b(aai aaiVar, aax aaxVar, boolean z, boolean z2) {
        SQLiteDatabase sQLiteDatabaseM267b;
        long jInsert;
        abj abjVar;
        if (acb.m179j() > 0) {
            if (acb.f226n > 0 && !z && !z2) {
                if (acb.f226n > 0) {
                    if (acb.m166b()) {
                        f305h.m51a("cacheEventsInMemory.size():" + this.f316l.size() + ",numEventsCachedInMemory:" + acb.f226n + ",numStoredEvents:" + this.f308a);
                        abj abjVar2 = f305h;
                        StringBuilder sb = new StringBuilder("cache event:");
                        sb.append(aaiVar.m26g());
                        abjVar2.m51a(sb.toString());
                    }
                    this.f316l.put(aaiVar, "");
                    if (this.f316l.size() >= acb.f226n) {
                        m276h();
                    }
                    if (aaxVar != null) {
                        if (this.f316l.size() > 0) {
                            m276h();
                        }
                        aaxVar.mo29a();
                    }
                }
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    sQLiteDatabaseM267b = m267b(z);
                } catch (Throwable th) {
                    th = th;
                    sQLiteDatabaseM267b = sQLiteDatabase;
                }
            } catch (Throwable th2) {
                th = th2;
            }
            try {
                sQLiteDatabaseM267b.beginTransaction();
                if (!z && this.f308a > acb.m179j()) {
                    f305h.m53b("Too many events stored in db.");
                    this.f308a -= this.f310c.getWritableDatabase().delete("events", "event_id in (select event_id from events where timestamp in (select min(timestamp) from events) limit 1)", null);
                }
                ContentValues contentValues = new ContentValues();
                String strM26g = aaiVar.m26g();
                if (acb.m166b()) {
                    f305h.m51a("insert 1 event, content:" + strM26g);
                }
                contentValues.put("content", abz.m137b(strM26g));
                contentValues.put("send_count", "0");
                contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.toString(1));
                contentValues.put("timestamp", Long.valueOf(aaiVar.m22c()));
                jInsert = sQLiteDatabaseM267b.insert("events", null, contentValues);
                sQLiteDatabaseM267b.setTransactionSuccessful();
                if (sQLiteDatabaseM267b != null) {
                    try {
                        sQLiteDatabaseM267b.endTransaction();
                    } catch (Throwable th3) {
                        th = th3;
                        abjVar = f305h;
                        abjVar.m54b(th);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                if (sQLiteDatabaseM267b != null) {
                    try {
                        sQLiteDatabaseM267b.endTransaction();
                    } catch (Throwable th5) {
                        f305h.m54b(th5);
                    }
                }
                throw th;
            }
            if (jInsert > 0) {
                this.f308a++;
                if (acb.m166b()) {
                    f305h.m59g("directStoreEvent insert event to db, event:" + aaiVar.m26g());
                }
                if (aaxVar != null) {
                    aaxVar.mo29a();
                }
            } else {
                f305h.m56d("Failed to store event:" + aaiVar.m26g());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public synchronized void m269b(aav aavVar) {
        Cursor cursorQuery;
        boolean z;
        long jInsert;
        Cursor cursor = null;
        try {
            try {
                String string = aavVar.f77b.toString();
                String strM81a = abt.m81a(string);
                ContentValues contentValues = new ContentValues();
                contentValues.put("content", aavVar.f77b.toString());
                contentValues.put("md5sum", strM81a);
                aavVar.f78c = strM81a;
                contentValues.put("version", Integer.valueOf(aavVar.f79d));
                cursorQuery = this.f310c.getReadableDatabase().query("config", null, null, null, null, null, null);
                while (true) {
                    try {
                        if (!cursorQuery.moveToNext()) {
                            z = false;
                            break;
                        } else if (cursorQuery.getInt(0) == aavVar.f76a) {
                            z = true;
                            break;
                        }
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        f305h.m54b(th);
                        if (cursor != null) {
                            cursor.close();
                        }
                        try {
                            this.f310c.getWritableDatabase().endTransaction();
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                }
                this.f310c.getWritableDatabase().beginTransaction();
                if (true == z) {
                    jInsert = this.f310c.getWritableDatabase().update("config", contentValues, "type=?", new String[]{Integer.toString(aavVar.f76a)});
                } else {
                    contentValues.put("type", Integer.valueOf(aavVar.f76a));
                    jInsert = this.f310c.getWritableDatabase().insert("config", null, contentValues);
                }
                if (jInsert == -1) {
                    f305h.m57e("Failed to store cfg:" + string);
                } else {
                    f305h.m59g("Sucessed to store cfg:" + string);
                }
                this.f310c.getWritableDatabase().setTransactionSuccessful();
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                try {
                    this.f310c.getWritableDatabase().endTransaction();
                } catch (Exception unused2) {
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = cursor;
        }
    }

    /* JADX INFO: renamed from: b */
    private void m270b(List<aar> list, int i, boolean z) throws Throwable {
        Cursor cursorQuery;
        Cursor cursor = null;
        try {
            try {
                cursorQuery = (!z ? this.f310c : this.f311d).getReadableDatabase().query("events", null, "status=?", new String[]{Integer.toString(1)}, null, null, null, Integer.toString(i));
                while (cursorQuery.moveToNext()) {
                    try {
                        long j = cursorQuery.getLong(0);
                        String string = cursorQuery.getString(1);
                        if (!acb.f219g) {
                            string = abz.m133a(string);
                        }
                        String str = string;
                        int i2 = cursorQuery.getInt(2);
                        int i3 = cursorQuery.getInt(3);
                        aar aarVar = new aar(j, str, i2, i3);
                        if (acb.m166b()) {
                            f305h.m51a("peek event, id=" + j + ",send_count=" + i3 + ",timestamp=" + cursorQuery.getLong(4));
                        }
                        list.add(aarVar);
                    } catch (Throwable th) {
                        th = th;
                        cursor = cursorQuery;
                        f305h.m54b(th);
                        if (cursor != null) {
                            cursor.close();
                            return;
                        }
                        return;
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            cursorQuery = cursor;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00e7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void m271c(java.util.List<p000.aar> r7, boolean r8) {
        /*
            Method dump skipped, instruction units count: 245
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.acs.m271c(java.util.List, boolean):void");
    }

    /* JADX INFO: renamed from: e */
    private void m273e() {
        this.f308a = m274f() + m275g();
    }

    /* JADX INFO: renamed from: f */
    private int m274f() {
        return (int) DatabaseUtils.queryNumEntries(this.f310c.getReadableDatabase(), "events");
    }

    /* JADX INFO: renamed from: g */
    private int m275g() {
        return (int) DatabaseUtils.queryNumEntries(this.f311d.getReadableDatabase(), "events");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: h */
    public void m276h() {
        SQLiteDatabase writableDatabase;
        abj abjVar;
        if (this.f317m) {
            return;
        }
        synchronized (this.f316l) {
            if (this.f316l.size() == 0) {
                return;
            }
            this.f317m = true;
            if (acb.m166b()) {
                f305h.m51a("insert " + this.f316l.size() + " events ,numEventsCachedInMemory:" + acb.f226n + ",numStoredEvents:" + this.f308a);
            }
            SQLiteDatabase sQLiteDatabase = null;
            try {
                try {
                    writableDatabase = this.f310c.getWritableDatabase();
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
                writableDatabase = sQLiteDatabase;
            }
            try {
                writableDatabase.beginTransaction();
                Iterator<Map.Entry<aai, String>> it = this.f316l.entrySet().iterator();
                while (it.hasNext()) {
                    aai key = it.next().getKey();
                    ContentValues contentValues = new ContentValues();
                    String strM26g = key.m26g();
                    if (acb.m166b()) {
                        f305h.m51a("insert content:" + strM26g);
                    }
                    contentValues.put("content", abz.m137b(strM26g));
                    contentValues.put("send_count", "0");
                    contentValues.put(NotificationCompat.CATEGORY_STATUS, Integer.toString(1));
                    contentValues.put("timestamp", Long.valueOf(key.m22c()));
                    writableDatabase.insert("events", null, contentValues);
                    it.remove();
                }
                writableDatabase.setTransactionSuccessful();
                if (writableDatabase != null) {
                    try {
                        writableDatabase.endTransaction();
                        m273e();
                    } catch (Throwable th3) {
                        th = th3;
                        abjVar = f305h;
                        abjVar.m54b(th);
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                sQLiteDatabase = writableDatabase;
                f305h.m54b(th);
                if (sQLiteDatabase != null) {
                    try {
                        sQLiteDatabase.endTransaction();
                        m273e();
                    } catch (Throwable th5) {
                        th = th5;
                        abjVar = f305h;
                        abjVar.m54b(th);
                    }
                }
            }
            this.f317m = false;
            if (acb.m166b()) {
                f305h.m51a("after insert, cacheEventsInMemory.size():" + this.f316l.size() + ",numEventsCachedInMemory:" + acb.f226n + ",numStoredEvents:" + this.f308a);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
    /* JADX INFO: renamed from: i */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m277i() throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = 0
            aaq r1 = r11.f310c     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L52
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L52
            java.lang.String r3 = "config"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L4d java.lang.Throwable -> L52
        L13:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            if (r0 == 0) goto L45
            r0 = 0
            int r0 = r1.getInt(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r2 = 1
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r3 = 2
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r4 = 3
            int r4 = r1.getInt(r4)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            aav r5 = new aav     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r5.<init>(r0)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r5.f76a = r0     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            org.json.JSONObject r0 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r0.<init>(r2)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r5.f77b = r0     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r5.f78c = r3     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            r5.f79d = r4     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            android.content.Context r0 = p000.acs.f306i     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            p000.acb.m156a(r0, r5)     // Catch: java.lang.Throwable -> L4b java.lang.Throwable -> L61
            goto L13
        L45:
            if (r1 == 0) goto L60
            r1.close()
            return
        L4b:
            r0 = move-exception
            goto L56
        L4d:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L62
        L52:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L56:
            abj r2 = p000.acs.f305h     // Catch: java.lang.Throwable -> L61
            r2.m54b(r0)     // Catch: java.lang.Throwable -> L61
            if (r1 == 0) goto L60
            r1.close()
        L60:
            return
        L61:
            r0 = move-exception
        L62:
            if (r1 == 0) goto L67
            r1.close()
        L67:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.acs.m277i():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0048  */
    /* JADX INFO: renamed from: j */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void m278j() throws java.lang.Throwable {
        /*
            r11 = this;
            r0 = 0
            aaq r1 = r11.f310c     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L36
            android.database.sqlite.SQLiteDatabase r2 = r1.getReadableDatabase()     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L36
            java.lang.String r3 = "keyvalues"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L31 java.lang.Throwable -> L36
        L13:
            boolean r0 = r1.moveToNext()     // Catch: java.lang.Throwable -> L2f java.lang.Throwable -> L45
            if (r0 == 0) goto L29
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r11.f318n     // Catch: java.lang.Throwable -> L2f java.lang.Throwable -> L45
            r2 = 0
            java.lang.String r2 = r1.getString(r2)     // Catch: java.lang.Throwable -> L2f java.lang.Throwable -> L45
            r3 = 1
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Throwable -> L2f java.lang.Throwable -> L45
            r0.put(r2, r3)     // Catch: java.lang.Throwable -> L2f java.lang.Throwable -> L45
            goto L13
        L29:
            if (r1 == 0) goto L44
            r1.close()
            return
        L2f:
            r0 = move-exception
            goto L3a
        L31:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
            goto L46
        L36:
            r1 = move-exception
            r10 = r1
            r1 = r0
            r0 = r10
        L3a:
            abj r2 = p000.acs.f305h     // Catch: java.lang.Throwable -> L45
            r2.m54b(r0)     // Catch: java.lang.Throwable -> L45
            if (r1 == 0) goto L44
            r1.close()
        L44:
            return
        L45:
            r0 = move-exception
        L46:
            if (r1 == 0) goto L4b
            r1.close()
        L4b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.acs.m278j():void");
    }

    /* JADX INFO: renamed from: a */
    public final int m279a() {
        return this.f308a;
    }

    /* JADX INFO: renamed from: a */
    final void m280a(int i) {
        this.f312e.m68a(new aap(this, i));
    }

    /* JADX INFO: renamed from: a */
    final void m281a(aai aaiVar, aax aaxVar, boolean z, boolean z2) {
        if (this.f312e != null) {
            this.f312e.m68a(new acw(this, aaiVar, aaxVar, z, z2));
        }
    }

    /* JADX INFO: renamed from: a */
    final void m282a(aav aavVar) {
        if (aavVar == null) {
            return;
        }
        this.f312e.m68a(new acx(this, aavVar));
    }

    /* JADX INFO: renamed from: a */
    final void m283a(List<aar> list, boolean z) {
        if (this.f312e != null) {
            this.f312e.m68a(new act(this, list, z));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:126:0x0233 A[Catch: Throwable -> 0x0230, all -> 0x0243, TRY_LEAVE, TryCatch #13 {Throwable -> 0x0230, blocks: (B:123:0x022c, B:126:0x0233), top: B:139:0x022c, outer: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x022c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0049 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00d6 A[Catch: all -> 0x01c8, Throwable -> 0x01ca, TryCatch #14 {all -> 0x01c8, Throwable -> 0x01ca, blocks: (B:23:0x0065, B:25:0x0069, B:29:0x007e, B:31:0x0088, B:32:0x008a, B:34:0x0092, B:36:0x0095, B:38:0x0099, B:50:0x00bc, B:52:0x00bf, B:58:0x00f7, B:60:0x0129, B:62:0x013c, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0184, B:53:0x00d6, B:55:0x00dc, B:57:0x00e2, B:42:0x00a4, B:44:0x00aa, B:47:0x00b4), top: B:149:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0129 A[Catch: all -> 0x01c8, Throwable -> 0x01ca, TryCatch #14 {all -> 0x01c8, Throwable -> 0x01ca, blocks: (B:23:0x0065, B:25:0x0069, B:29:0x007e, B:31:0x0088, B:32:0x008a, B:34:0x0092, B:36:0x0095, B:38:0x0099, B:50:0x00bc, B:52:0x00bf, B:58:0x00f7, B:60:0x0129, B:62:0x013c, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0184, B:53:0x00d6, B:55:0x00dc, B:57:0x00e2, B:42:0x00a4, B:44:0x00aa, B:47:0x00b4), top: B:149:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c A[Catch: all -> 0x01c8, Throwable -> 0x01ca, TryCatch #14 {all -> 0x01c8, Throwable -> 0x01ca, blocks: (B:23:0x0065, B:25:0x0069, B:29:0x007e, B:31:0x0088, B:32:0x008a, B:34:0x0092, B:36:0x0095, B:38:0x0099, B:50:0x00bc, B:52:0x00bf, B:58:0x00f7, B:60:0x0129, B:62:0x013c, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0184, B:53:0x00d6, B:55:0x00dc, B:57:0x00e2, B:42:0x00a4, B:44:0x00aa, B:47:0x00b4), top: B:149:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015e A[Catch: all -> 0x01c8, Throwable -> 0x01ca, TryCatch #14 {all -> 0x01c8, Throwable -> 0x01ca, blocks: (B:23:0x0065, B:25:0x0069, B:29:0x007e, B:31:0x0088, B:32:0x008a, B:34:0x0092, B:36:0x0095, B:38:0x0099, B:50:0x00bc, B:52:0x00bf, B:58:0x00f7, B:60:0x0129, B:62:0x013c, B:71:0x015e, B:73:0x0168, B:75:0x016e, B:77:0x0184, B:53:0x00d6, B:55:0x00dc, B:57:0x00e2, B:42:0x00a4, B:44:0x00aa, B:47:0x00b4), top: B:149:0x0065 }] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01d7  */
    /* JADX INFO: renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final synchronized p000.abk m284b(android.content.Context r20) {
        /*
            Method dump skipped, instruction units count: 583
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.acs.m284b(android.content.Context):abk");
    }

    /* JADX INFO: renamed from: b */
    final void m285b(List<aar> list, boolean z) {
        if (this.f312e != null) {
            this.f312e.m68a(new acu(this, list, z));
        }
    }

    /* JADX INFO: renamed from: c */
    final void m286c() {
        if (acb.m169c()) {
            try {
                this.f312e.m68a(new acv(this));
            } catch (Throwable th) {
                f305h.m54b(th);
            }
        }
    }
}
