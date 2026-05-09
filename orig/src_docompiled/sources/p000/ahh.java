package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import com.umeng.message.PushAgent;
import java.io.Serializable;
import java.util.Calendar;

/* JADX INFO: compiled from: UmengLocalNotification.java */
/* JADX INFO: loaded from: classes.dex */
public class ahh implements Serializable {

    /* JADX INFO: renamed from: a */
    private static final String f1005a = "ahh";

    /* JADX INFO: renamed from: b */
    private String f1006b;

    /* JADX INFO: renamed from: c */
    private int f1007c;

    /* JADX INFO: renamed from: d */
    private int f1008d;

    /* JADX INFO: renamed from: e */
    private int f1009e;

    /* JADX INFO: renamed from: f */
    private int f1010f;

    /* JADX INFO: renamed from: g */
    private int f1011g;

    /* JADX INFO: renamed from: h */
    private int f1012h;

    /* JADX INFO: renamed from: i */
    private int f1013i;

    /* JADX INFO: renamed from: j */
    private int f1014j;

    /* JADX INFO: renamed from: k */
    private int f1015k;

    /* JADX INFO: renamed from: l */
    private int f1016l;

    /* JADX INFO: renamed from: m */
    private String f1017m;

    /* JADX INFO: renamed from: n */
    private String f1018n;

    /* JADX INFO: renamed from: o */
    private String f1019o;

    /* JADX INFO: renamed from: p */
    private ahl f1020p;

    public ahh() {
        this.f1006b = ail.m1337a();
        Calendar calendar = Calendar.getInstance();
        this.f1007c = calendar.get(1);
        this.f1008d = calendar.get(2) + 1;
        this.f1009e = calendar.get(5) + 1;
        this.f1010f = 12;
        this.f1011g = 0;
        this.f1012h = 0;
        this.f1013i = 1;
        this.f1014j = 3;
        this.f1015k = 1;
        this.f1016l = 0;
        this.f1017m = "test";
        this.f1018n = "test message";
        this.f1019o = "test";
        this.f1020p = new ahl(this.f1006b);
    }

    public ahh(Cursor cursor) {
        if (cursor == null) {
            return;
        }
        this.f1006b = cursor.getString(cursor.getColumnIndex("id"));
        this.f1007c = cursor.getInt(cursor.getColumnIndex("year"));
        this.f1008d = cursor.getInt(cursor.getColumnIndex("month"));
        this.f1009e = cursor.getInt(cursor.getColumnIndex("day"));
        this.f1010f = cursor.getInt(cursor.getColumnIndex("hour"));
        this.f1011g = cursor.getInt(cursor.getColumnIndex("minute"));
        this.f1012h = cursor.getInt(cursor.getColumnIndex("second"));
        this.f1013i = cursor.getInt(cursor.getColumnIndex("repeating_num"));
        this.f1014j = cursor.getInt(cursor.getColumnIndex("repeating_unit"));
        this.f1015k = cursor.getInt(cursor.getColumnIndex("repeating_interval"));
        this.f1016l = cursor.getInt(cursor.getColumnIndex("special_day"));
        this.f1017m = cursor.getString(cursor.getColumnIndex("title"));
        this.f1018n = cursor.getString(cursor.getColumnIndex("content"));
        this.f1019o = cursor.getString(cursor.getColumnIndex("ticker"));
        this.f1020p = new ahl(this.f1006b);
    }

    /* JADX INFO: renamed from: a */
    public String m1102a() {
        return this.f1006b;
    }

    /* JADX INFO: renamed from: b */
    public int m1106b() {
        return this.f1007c;
    }

    /* JADX INFO: renamed from: a */
    public void m1103a(int i) {
        this.f1007c = i;
    }

    /* JADX INFO: renamed from: c */
    public int m1108c() {
        return this.f1008d;
    }

    /* JADX INFO: renamed from: b */
    public void m1107b(int i) {
        this.f1008d = i;
    }

    /* JADX INFO: renamed from: d */
    public int m1110d() {
        return this.f1009e;
    }

    /* JADX INFO: renamed from: c */
    public void m1109c(int i) {
        this.f1009e = i;
    }

    /* JADX INFO: renamed from: e */
    public int m1112e() {
        return this.f1010f;
    }

    /* JADX INFO: renamed from: d */
    public void m1111d(int i) {
        this.f1010f = i;
    }

    /* JADX INFO: renamed from: f */
    public int m1114f() {
        return this.f1011g;
    }

    /* JADX INFO: renamed from: e */
    public void m1113e(int i) {
        this.f1011g = i;
    }

    /* JADX INFO: renamed from: g */
    public int m1116g() {
        return this.f1012h;
    }

    /* JADX INFO: renamed from: f */
    public void m1115f(int i) {
        this.f1012h = i;
    }

    /* JADX INFO: renamed from: h */
    public int m1118h() {
        return this.f1013i;
    }

    /* JADX INFO: renamed from: g */
    public void m1117g(int i) {
        this.f1013i = i;
    }

    /* JADX INFO: renamed from: i */
    public int m1119i() {
        return this.f1014j;
    }

    /* JADX INFO: renamed from: j */
    public int m1120j() {
        return this.f1015k;
    }

    /* JADX INFO: renamed from: k */
    public int m1121k() {
        return this.f1016l;
    }

    /* JADX INFO: renamed from: l */
    public String m1122l() {
        return this.f1017m;
    }

    /* JADX INFO: renamed from: m */
    public String m1123m() {
        return this.f1018n;
    }

    /* JADX INFO: renamed from: n */
    public String m1124n() {
        return this.f1019o;
    }

    /* JADX INFO: renamed from: o */
    public ahl m1125o() {
        return this.f1020p;
    }

    /* JADX INFO: renamed from: a */
    public void m1104a(ahl ahlVar) {
        if (!TextUtils.equals(this.f1006b, ahlVar.m1163b())) {
            Log.e(f1005a, "localNotificationId for notificationBuilder is not equal");
            ahlVar.m1162a(this.f1006b);
        }
        this.f1020p = ahlVar;
    }

    /* JADX INFO: renamed from: p */
    public String m1126p() {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "" + this.f1007c + "-";
        if (this.f1008d < 10) {
            str = str5 + "0" + this.f1008d + "-";
        } else {
            str = str5 + this.f1008d + "-";
        }
        if (this.f1009e < 10) {
            str2 = str + "0" + this.f1009e + " ";
        } else {
            str2 = str + this.f1009e + " ";
        }
        if (this.f1010f < 10) {
            str3 = str2 + "0" + this.f1010f + ":";
        } else {
            str3 = str2 + this.f1010f + ":";
        }
        if (this.f1011g < 10) {
            str4 = str3 + "0" + this.f1011g + ":";
        } else {
            str4 = str3 + this.f1011g + ":";
        }
        if (this.f1012h < 10) {
            return str4 + "0" + this.f1012h;
        }
        return str4 + this.f1012h;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0 */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3 */
    /* JADX INFO: renamed from: q */
    public boolean m1127q() {
        long jM1131a;
        ?? r12;
        long j;
        Object objValueOf;
        Object objValueOf2;
        Object objValueOf3;
        Object objValueOf4;
        Object objValueOf5;
        Object objValueOf6;
        Object objValueOf7;
        Object objValueOf8;
        Object objValueOf9;
        if (this.f1016l < 0 || this.f1016l > 12) {
            Log.d(f1005a, "specialDay is isValid");
            return false;
        }
        if (this.f1007c < Calendar.getInstance().get(1)) {
            Log.d(f1005a, "year is isValid");
            return false;
        }
        if (this.f1008d < 1 || this.f1008d > 12) {
            Log.d(f1005a, "month is isValid");
            return false;
        }
        if (this.f1009e < 1 || this.f1009e > 31) {
            Log.d(f1005a, "day is isValid");
            return false;
        }
        int i = this.f1008d;
        if (i != 2) {
            if ((i == 4 || i == 6 || i == 9 || i == 11) && this.f1009e > 30) {
                Log.d(f1005a, "dateTime: day is invalid");
                return false;
            }
        } else if ((this.f1007c % 4 == 0 && this.f1007c % 100 != 0) || this.f1007c % 400 == 0) {
            if (this.f1009e > 29) {
                Log.d(f1005a, "dateTime: day is invalid");
                return false;
            }
        } else if (this.f1009e > 28) {
            Log.d(f1005a, "dateTime: day is invalid");
            return false;
        }
        if (this.f1010f < 0 || this.f1010f > 23) {
            Log.d(f1005a, "hour is isValid");
            return false;
        }
        if (this.f1011g < 0 || this.f1011g > 59) {
            Log.d(f1005a, "minute is isValid");
            return false;
        }
        if (this.f1012h < 0 || this.f1012h > 59) {
            Log.d(f1005a, "second is isValid");
            return false;
        }
        if (this.f1016l >= 1 && this.f1016l <= 12) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            try {
                r12 = 15;
                try {
                    switch (this.f1016l) {
                        case 1:
                            String str = this.f1007c + "-01-01 ";
                            StringBuilder sb = new StringBuilder();
                            sb.append(str);
                            if (this.f1010f >= 10) {
                                objValueOf = Integer.valueOf(this.f1010f);
                            } else {
                                objValueOf = "0" + this.f1010f;
                            }
                            sb.append(objValueOf);
                            sb.append(":");
                            String string = sb.toString();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(string);
                            if (this.f1011g >= 10) {
                                objValueOf2 = Integer.valueOf(this.f1011g);
                            } else {
                                objValueOf2 = "0" + this.f1011g;
                            }
                            sb2.append(objValueOf2);
                            sb2.append(":");
                            String string2 = sb2.toString();
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append(string2);
                            if (this.f1012h >= 10) {
                                objValueOf3 = Integer.valueOf(this.f1012h);
                            } else {
                                objValueOf3 = "0" + this.f1012h;
                            }
                            sb3.append(objValueOf3);
                            long jM1131a2 = ahi.m1131a(sb3.toString());
                            j = jM1131a2;
                            if (jM1131a2 < jCurrentTimeMillis) {
                                Log.d(f1005a, "元旦的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 2:
                            this.f1008d = 12;
                            this.f1009e = ahg.m1095a(this.f1007c, 12);
                            long jM1131a3 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a3;
                            if (jM1131a3 < jCurrentTimeMillis) {
                                Log.d(f1005a, "除夕的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 3:
                            this.f1008d = 1;
                            this.f1009e = 1;
                            long jM1131a4 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a4;
                            if (jM1131a4 < jCurrentTimeMillis) {
                                Log.d(f1005a, "春节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 4:
                            this.f1008d = 1;
                            this.f1009e = 15;
                            long jM1131a5 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a5;
                            if (jM1131a5 < jCurrentTimeMillis) {
                                Log.d(f1005a, "元宵节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 5:
                            long jM1129a = ahi.m1129a(this.f1007c, this.f1010f, this.f1011g, this.f1012h);
                            j = jM1129a;
                            if (jM1129a < jCurrentTimeMillis) {
                                Log.d(f1005a, "清明的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 6:
                            String str2 = this.f1007c + "-05-01 ";
                            StringBuilder sb4 = new StringBuilder();
                            sb4.append(str2);
                            if (this.f1010f >= 10) {
                                objValueOf4 = Integer.valueOf(this.f1010f);
                            } else {
                                objValueOf4 = "0" + this.f1010f;
                            }
                            sb4.append(objValueOf4);
                            sb4.append(":");
                            String string3 = sb4.toString();
                            StringBuilder sb5 = new StringBuilder();
                            sb5.append(string3);
                            if (this.f1011g >= 10) {
                                objValueOf5 = Integer.valueOf(this.f1011g);
                            } else {
                                objValueOf5 = "0" + this.f1011g;
                            }
                            sb5.append(objValueOf5);
                            sb5.append(":");
                            String string4 = sb5.toString();
                            StringBuilder sb6 = new StringBuilder();
                            sb6.append(string4);
                            if (this.f1012h >= 10) {
                                objValueOf6 = Integer.valueOf(this.f1012h);
                            } else {
                                objValueOf6 = "0" + this.f1012h;
                            }
                            sb6.append(objValueOf6);
                            long jM1131a6 = ahi.m1131a(sb6.toString());
                            j = jM1131a6;
                            if (jM1131a6 < jCurrentTimeMillis) {
                                Log.d(f1005a, "五一劳动节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 7:
                            this.f1008d = 5;
                            this.f1009e = 5;
                            long jM1131a7 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a7;
                            if (jM1131a7 < jCurrentTimeMillis) {
                                Log.d(f1005a, "端午节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 8:
                            this.f1008d = 7;
                            this.f1009e = 7;
                            long jM1131a8 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a8;
                            if (jM1131a8 < jCurrentTimeMillis) {
                                Log.d(f1005a, "七夕节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 9:
                            this.f1008d = 8;
                            this.f1009e = 15;
                            long jM1131a9 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a9;
                            if (jM1131a9 < jCurrentTimeMillis) {
                                Log.d(f1005a, "春节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 10:
                            String str3 = this.f1007c + "-10-01 ";
                            StringBuilder sb7 = new StringBuilder();
                            sb7.append(str3);
                            if (this.f1010f >= 10) {
                                objValueOf7 = Integer.valueOf(this.f1010f);
                            } else {
                                objValueOf7 = "0" + this.f1010f;
                            }
                            sb7.append(objValueOf7);
                            sb7.append(":");
                            String string5 = sb7.toString();
                            StringBuilder sb8 = new StringBuilder();
                            sb8.append(string5);
                            if (this.f1011g >= 10) {
                                objValueOf8 = Integer.valueOf(this.f1011g);
                            } else {
                                objValueOf8 = "0" + this.f1011g;
                            }
                            sb8.append(objValueOf8);
                            sb8.append(":");
                            String string6 = sb8.toString();
                            StringBuilder sb9 = new StringBuilder();
                            sb9.append(string6);
                            if (this.f1012h >= 10) {
                                objValueOf9 = Integer.valueOf(this.f1012h);
                            } else {
                                objValueOf9 = "0" + this.f1012h;
                            }
                            sb9.append(objValueOf9);
                            long jM1131a10 = ahi.m1131a(sb9.toString());
                            j = jM1131a10;
                            if (jM1131a10 < jCurrentTimeMillis) {
                                Log.d(f1005a, "国庆节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 11:
                            this.f1008d = 9;
                            this.f1009e = 9;
                            long jM1131a11 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a11;
                            if (jM1131a11 < jCurrentTimeMillis) {
                                Log.d(f1005a, "清明节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        case 12:
                            this.f1008d = 12;
                            this.f1009e = 8;
                            long jM1131a12 = ahi.m1131a(ahg.m1096a(m1126p()));
                            j = jM1131a12;
                            if (jM1131a12 < jCurrentTimeMillis) {
                                Log.d(f1005a, "腊八节的开始年份小于当前时间，请重新设置");
                                return false;
                            }
                            break;
                        default:
                            j = 0;
                            break;
                    }
                } catch (Exception e) {
                    e = e;
                    e.printStackTrace();
                    j = r12;
                }
            } catch (Exception e2) {
                e = e2;
                r12 = 0;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(j);
            this.f1007c = calendar.get(1);
            this.f1008d = calendar.get(2) + 1;
            this.f1009e = calendar.get(5);
            this.f1010f = calendar.get(11);
            this.f1011g = calendar.get(12);
            this.f1012h = calendar.get(13);
            Log.d(f1005a, "year=" + this.f1007c + ",month=" + this.f1008d + ",day=" + this.f1009e + ",specialDay=" + this.f1016l);
            return true;
        }
        try {
            jM1131a = ahi.m1131a(m1126p());
        } catch (Exception e3) {
            e3.printStackTrace();
            jM1131a = 0;
        }
        if (jM1131a >= System.currentTimeMillis()) {
            return true;
        }
        Log.d(f1005a, "dateTime: date time is invalid");
        return false;
    }

    /* JADX INFO: renamed from: a */
    public boolean m1105a(Context context) {
        if (this.f1013i < -1) {
            Log.d(f1005a, "repeatingNum is isValid");
            return false;
        }
        if (this.f1015k <= 0) {
            Log.d(f1005a, "repeatingInterval is isValid");
            return false;
        }
        if (this.f1014j < 1 || this.f1014j > 6) {
            Log.d(f1005a, "repeatingUnit is isValid");
            return false;
        }
        if (!PushAgent.getInstance(context).getLocalNotificationIntervalLimit() || ((this.f1014j != 6 || this.f1015k >= 600) && (this.f1014j != 5 || this.f1015k >= 10))) {
            return true;
        }
        Log.d(f1005a, "repeatingInterval is less than 10 minutes for limit");
        return false;
    }

    /* JADX INFO: renamed from: r */
    public ContentValues m1128r() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("id", this.f1006b);
        contentValues.put("year", Integer.valueOf(this.f1007c));
        contentValues.put("month", Integer.valueOf(this.f1008d));
        contentValues.put("day", Integer.valueOf(this.f1009e));
        contentValues.put("hour", Integer.valueOf(this.f1010f));
        contentValues.put("minute", Integer.valueOf(this.f1011g));
        contentValues.put("second", Integer.valueOf(this.f1012h));
        contentValues.put("repeating_num", Integer.valueOf(this.f1013i));
        contentValues.put("repeating_unit", Integer.valueOf(this.f1014j));
        contentValues.put("repeating_interval", Integer.valueOf(this.f1015k));
        contentValues.put("special_day", Integer.valueOf(this.f1016l));
        contentValues.put("title", this.f1017m);
        contentValues.put("content", this.f1018n);
        contentValues.put("ticker", this.f1019o);
        return contentValues;
    }
}
