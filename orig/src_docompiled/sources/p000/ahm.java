package p000;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;

/* JADX INFO: compiled from: MessageService.java */
/* JADX INFO: loaded from: classes.dex */
public class ahm {

    /* JADX INFO: renamed from: b */
    private static volatile ahm f1050b;

    /* JADX INFO: renamed from: a */
    private volatile SQLiteOpenHelper f1051a;

    /* JADX INFO: renamed from: c */
    private Context f1052c;

    private ahm(Context context) {
        this.f1051a = null;
        this.f1052c = context;
        this.f1051a = new C0112a(context);
    }

    /* JADX INFO: renamed from: a */
    public static synchronized ahm m1167a(Context context) {
        if (f1050b == null) {
            f1050b = new ahm(context);
        }
        return f1050b;
    }

    /* JADX INFO: renamed from: ahm$a */
    /* JADX INFO: compiled from: MessageService.java */
    static class C0112a extends SQLiteOpenHelper {
        /* JADX INFO: renamed from: b */
        private String m1177b() {
            return "CREATE INDEX body_code_index ON message(body_code)";
        }

        /* JADX INFO: renamed from: c */
        private String m1178c() {
            return "CREATE INDEX id_index ON message(id)";
        }

        public C0112a(Context context) {
            super(context, "message_db", (SQLiteDatabase.CursorFactory) null, 1);
        }

        /* JADX INFO: renamed from: a */
        private String m1176a() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("create table message");
            stringBuffer.append("(");
            stringBuffer.append("id text UNIQUE not null,");
            stringBuffer.append("state integer,");
            stringBuffer.append("body_code integer,");
            stringBuffer.append("report long,");
            stringBuffer.append("target_time long,");
            stringBuffer.append("interval integer,");
            stringBuffer.append("type text,");
            stringBuffer.append("message text,");
            stringBuffer.append("notify integer,");
            stringBuffer.append("create_time date");
            stringBuffer.append(");");
            return stringBuffer.toString();
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL(m1176a());
                    sQLiteDatabase.execSQL(m1178c());
                    sQLiteDatabase.execSQL(m1177b());
                } catch (Throwable th) {
                    aiv.m1419c("MessageService", "messagedbhelper create", th);
                }
            }
        }

        @Override // android.database.sqlite.SQLiteOpenHelper
        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            if (sQLiteDatabase != null) {
                try {
                    sQLiteDatabase.execSQL("delete from message where create_time< date('now','-7 day') and state=1");
                } catch (Throwable th) {
                    aiv.m1419c("MessageService", "messagedbhelper create", th);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m1170a(String str, String str2, String str3, int i) throws Throwable {
        m1168a(str, str2, str3, 1, -1L, -1, i);
    }

    /* JADX INFO: renamed from: a */
    private void m1168a(String str, String str2, String str3, int i, long j, int i2, int i3) throws Throwable {
        SQLiteDatabase writableDatabase;
        int iHashCode;
        aiv.m1418c("MessageService", "add sqlite3--->[" + str + "]");
        try {
            if (TextUtils.isEmpty(str2)) {
                str2 = "";
                iHashCode = -1;
            } else {
                iHashCode = str2.hashCode();
            }
            if (TextUtils.isEmpty(str3)) {
                str3 = "";
            }
            writableDatabase = this.f1051a.getWritableDatabase();
        } catch (Throwable th) {
            th = th;
            writableDatabase = null;
        }
        try {
            writableDatabase.execSQL("INSERT INTO message VALUES(?,?,?,?,?,?,?,?,?,date('now'))", new Object[]{str, Integer.valueOf(i), Integer.valueOf(iHashCode), 0, Long.valueOf(j), Integer.valueOf(i2), str3, str2, Integer.valueOf(i3)});
            if (writableDatabase == null) {
                return;
            }
        } catch (Throwable unused) {
            if (writableDatabase == null) {
                return;
            }
        }
        try {
            writableDatabase.close();
        } catch (Throwable unused2) {
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m1172a(String str) throws Throwable {
        SQLiteDatabase writableDatabase;
        Cursor cursor = null;
        boolean z = false;
        try {
            try {
                writableDatabase = this.f1051a.getWritableDatabase();
                try {
                    Cursor cursorRawQuery = writableDatabase.rawQuery("select count(1) from message where id = ?", new String[]{str});
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                if (cursorRawQuery.getInt(0) > 0) {
                                    z = true;
                                }
                            }
                        } catch (Throwable unused) {
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                cursor.close();
                            }
                            if (writableDatabase != null) {
                            }
                            return z;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1173a(String str, int i) throws Throwable {
        SQLiteDatabase writableDatabase;
        Cursor cursor = null;
        boolean z = false;
        try {
            try {
                writableDatabase = this.f1051a.getWritableDatabase();
                try {
                    Cursor cursorRawQuery = writableDatabase.rawQuery("select count(1) from message where id = ? and body_code=? create_time< date('now','-1 day')", new String[]{str, "" + i});
                    if (cursorRawQuery != null) {
                        try {
                            if (cursorRawQuery.moveToFirst()) {
                                if (cursorRawQuery.getInt(0) > 0) {
                                    z = true;
                                }
                            }
                        } catch (Throwable th) {
                            th = th;
                            cursor = cursorRawQuery;
                            if (cursor != null) {
                                try {
                                    cursor.close();
                                } catch (Throwable unused) {
                                    throw th;
                                }
                            }
                            if (writableDatabase != null) {
                                writableDatabase.close();
                            }
                            throw th;
                        }
                    }
                    if (cursorRawQuery != null) {
                        cursorRawQuery.close();
                    }
                } catch (Throwable unused2) {
                }
            } catch (Throwable unused3) {
            }
        } catch (Throwable unused4) {
            writableDatabase = null;
        }
        if (writableDatabase != null) {
            writableDatabase.close();
        }
        return z;
    }

    /* JADX INFO: renamed from: a */
    private long m1166a(long j, int i) {
        return j + ((long) aib.m1294a(i * 60 * 1000));
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void m1171a(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, int r21) throws java.lang.Throwable {
        /*
            r16 = this;
            r9 = r17
            r0 = r20
            java.lang.String r1 = "_"
            java.lang.String[] r1 = r0.split(r1)
            int r2 = r1.length
            r3 = -1
            r4 = -1
            r6 = 2
            if (r2 != r6) goto L40
            r2 = 0
            r2 = r1[r2]     // Catch: java.lang.Throwable -> L22
            long r6 = java.lang.Long.parseLong(r2)     // Catch: java.lang.Throwable -> L22
            r2 = 1
            r1 = r1[r2]     // Catch: java.lang.Throwable -> L23
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.Throwable -> L23
            r12 = r1
            r10 = r6
            goto L42
        L22:
            r6 = r4
        L23:
            java.lang.String r1 = "MessageService"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r8 = "["
            r2.append(r8)
            r2.append(r0)
            java.lang.String r0 = "] to Integer error"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            p000.aiv.m1422e(r1, r0)
            r10 = r6
            goto L41
        L40:
            r10 = r4
        L41:
            r12 = -1
        L42:
            int r0 = (r10 > r4 ? 1 : (r10 == r4 ? 0 : -1))
            if (r0 == 0) goto L5a
            if (r12 == r3) goto L5a
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 >= 0) goto L51
            goto L5a
        L51:
            r13 = r16
            r14 = r18
            r15 = r19
            r8 = r21
            goto L9c
        L5a:
            java.lang.String r0 = "MessageService"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "handleMessageAtTime messageId ["
            r1.append(r2)
            r1.append(r9)
            java.lang.String r2 = "]  targetTime["
            r1.append(r2)
            java.lang.String r2 = p000.ahx.m1279a(r10)
            r1.append(r2)
            java.lang.String r2 = "] <=currentTime["
            r1.append(r2)
            long r2 = java.lang.System.currentTimeMillis()
            java.lang.String r2 = p000.ahx.m1279a(r2)
            r1.append(r2)
            java.lang.String r2 = "]"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            p000.aiv.m1422e(r0, r1)
            r13 = r16
            r14 = r18
            r15 = r19
            r8 = r21
            r13.m1170a(r9, r14, r15, r8)
        L9c:
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto Lb7
            r4 = 0
            r0 = r13
            r1 = r9
            r2 = r14
            r3 = r15
            r5 = r10
            r7 = r12
            r8 = r21
            r0.m1168a(r1, r2, r3, r4, r5, r7, r8)
            r4 = r10
            r6 = r12
            r7 = r21
            r0.m1169a(r1, r2, r3, r4, r6, r7)
        Lb7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ahm.m1171a(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int):void");
    }

    /* JADX INFO: renamed from: a */
    private void m1169a(String str, String str2, String str3, long j, int i, int i2) {
        if (j < System.currentTimeMillis()) {
            aiv.m1418c("MessageService", "sendAtTime messageId[" + str + "] targetTime[" + ahx.m1279a(j) + "] <=currentTime[" + ahx.m1279a(System.currentTimeMillis()) + "]");
            return;
        }
        long jM1166a = m1166a(j, i);
        aiv.m1418c("MessageService", "sendAtTime message---->[" + str + "]serverTime--->[" + ahx.m1279a(j) + "," + i + " min]targetTime---->[" + ahx.m1279a(jM1166a) + "]");
        Bundle bundle = new Bundle();
        bundle.putString("body", str2);
        bundle.putString("id", str);
        bundle.putString("type", str3);
        bundle.putBoolean("local", true);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(i2);
        bundle.putString("notify", sb.toString());
        AlarmManager alarmManager = (AlarmManager) this.f1052c.getSystemService(NotificationCompat.CATEGORY_ALARM);
        Intent intent = new Intent();
        intent.setAction("org.agoo.android.intent.action.RECEIVE");
        intent.setPackage(this.f1052c.getPackageName());
        intent.putExtras(bundle);
        alarmManager.set(1, jM1166a, PendingIntent.getBroadcast(this.f1052c, str.hashCode(), intent, 134217728));
    }

    /* JADX INFO: renamed from: a */
    public boolean m1174a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        return m1175a(str, str2, str3, str4, str5, str6, str7, null);
    }

    /* JADX INFO: renamed from: a */
    public boolean m1175a(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        if (TextUtils.isEmpty(str3)) {
            return false;
        }
        try {
            if (Integer.parseInt(str3) < -1) {
                return false;
            }
            arb arbVar = new arb();
            arbVar.m5232c("mtop.push.msg.report");
            arbVar.m5234d("1.0");
            arbVar.m5225a("messageId", str + "@" + str4);
            arbVar.m5225a("mesgStatus", str7);
            if (!TextUtils.isEmpty(str8)) {
                arbVar.m5225a("del_pack", str8);
            }
            if (!TextUtils.isEmpty(str5)) {
                arbVar.m5225a("trace", str5);
            }
            if (!TextUtils.isEmpty(str6)) {
                arbVar.m5225a("ec", str6);
            }
            if (!TextUtils.isEmpty(str2)) {
                arbVar.m5225a("taskId", str2);
            }
            arbVar.m5224a(apx.getRegistrationId(this.f1052c));
            arf arfVar = new arf();
            arfVar.mo5186a(apu.m4936f(this.f1052c));
            arfVar.mo5188b(apu.m4940j(this.f1052c));
            arfVar.mo5189c(apu.m4920F(this.f1052c));
            arfVar.mo5185a(this.f1052c, arbVar);
            return true;
        } catch (Throwable th) {
            aiv.m1421d("MessageService", "[" + str3 + "] to Integer error", th);
            return false;
        }
    }
}
