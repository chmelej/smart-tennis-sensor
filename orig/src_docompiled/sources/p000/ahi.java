package p000;

import android.content.Context;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* JADX INFO: compiled from: UmengLocalNotificationHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ahi {

    /* JADX INFO: renamed from: a */
    private static final String f1021a = "ahi";

    /* JADX INFO: renamed from: a */
    public static long m1130a(Context context, ahh ahhVar) {
        long j;
        int i;
        int i2;
        long timeInMillis;
        long j2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Exception exc;
        Object objValueOf;
        Object objValueOf2;
        long jM1131a;
        long jCurrentTimeMillis = System.currentTimeMillis();
        int iM1106b = ahhVar.m1106b();
        int iM1108c = ahhVar.m1108c();
        int iM1110d = ahhVar.m1110d();
        int iM1112e = ahhVar.m1112e();
        int iM1114f = ahhVar.m1114f();
        int iM1116g = ahhVar.m1116g();
        int iM1118h = ahhVar.m1118h();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1, iM1106b);
        calendar.set(2, iM1108c - 1);
        calendar.set(5, iM1110d);
        calendar.set(11, iM1112e);
        calendar.set(12, iM1114f);
        calendar.set(13, iM1116g);
        long timeInMillis2 = calendar.getTimeInMillis();
        int iM1121k = ahhVar.m1121k();
        int i8 = iM1114f;
        int i9 = iM1116g;
        int i10 = iM1110d;
        int i11 = iM1112e;
        int iM1120j = iM1106b;
        int i12 = iM1108c;
        long jM1131a2 = timeInMillis2;
        while (jM1131a2 < jCurrentTimeMillis + 50 && iM1118h > 0) {
            if (iM1121k != 0) {
                iM1120j += ahhVar.m1120j();
                switch (iM1121k) {
                    case 1:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        StringBuilder sb = new StringBuilder();
                        sb.append(iM1120j + "-01-01 ");
                        sb.append(i11 >= 10 ? Integer.valueOf(i11) : "0" + i11);
                        sb.append(":");
                        String string = sb.toString();
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(string);
                        sb2.append(i >= 10 ? Integer.valueOf(i) : "0" + i);
                        sb2.append(":");
                        String string2 = sb2.toString();
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(string2);
                        sb3.append(i2 >= 10 ? Integer.valueOf(i2) : "0" + i2);
                        timeInMillis = m1131a(sb3.toString());
                        jM1131a2 = timeInMillis;
                        break;
                    case 2:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        int iM1095a = ahg.m1095a(iM1120j, 12);
                        try {
                            i10 = iM1095a;
                            jM1131a2 = m1131a(ahg.m1096a(m1132a(iM1120j, 12, iM1095a, i11, i, i2)));
                        } catch (Exception e) {
                            exc = e;
                            i10 = iM1095a;
                            exc.printStackTrace();
                            Log.d(f1021a, exc.toString());
                        }
                        break;
                    case 3:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        timeInMillis = m1131a(ahg.m1096a(m1132a(iM1120j, 1, 1, i11, i, i2)));
                        jM1131a2 = timeInMillis;
                        break;
                    case 4:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        timeInMillis = m1131a(ahg.m1096a(m1132a(iM1120j, 1, 15, i11, i, i2)));
                        jM1131a2 = timeInMillis;
                        break;
                    case 5:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        timeInMillis = m1129a(iM1120j, i11, i, i2);
                        jM1131a2 = timeInMillis;
                        break;
                    case 6:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        StringBuilder sb4 = new StringBuilder();
                        sb4.append(iM1120j + "-05-01 ");
                        sb4.append(i11 >= 10 ? Integer.valueOf(i11) : "0" + i11);
                        sb4.append(":");
                        String string3 = sb4.toString();
                        StringBuilder sb5 = new StringBuilder();
                        sb5.append(string3);
                        sb5.append(i >= 10 ? Integer.valueOf(i) : "0" + i);
                        sb5.append(":");
                        String string4 = sb5.toString();
                        StringBuilder sb6 = new StringBuilder();
                        sb6.append(string4);
                        sb6.append(i2 >= 10 ? Integer.valueOf(i2) : "0" + i2);
                        timeInMillis = m1131a(sb6.toString());
                        jM1131a2 = timeInMillis;
                        break;
                    case 7:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        timeInMillis = m1131a(ahg.m1096a(m1132a(iM1120j, 5, 5, i11, i, i2)));
                        jM1131a2 = timeInMillis;
                        break;
                    case 8:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        timeInMillis = m1131a(ahg.m1096a(m1132a(iM1120j, 7, 7, i11, i, i2)));
                        jM1131a2 = timeInMillis;
                        break;
                    case 9:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        timeInMillis = m1131a(ahg.m1096a(m1132a(iM1120j, 8, 15, i11, i, i2)));
                        jM1131a2 = timeInMillis;
                        break;
                    case 10:
                        StringBuilder sb7 = new StringBuilder();
                        sb7.append(iM1120j + "-10-01 ");
                        sb7.append(i11 >= 10 ? Integer.valueOf(i11) : "0" + i11);
                        sb7.append(":");
                        String string5 = sb7.toString();
                        StringBuilder sb8 = new StringBuilder();
                        sb8.append(string5);
                        i = i8;
                        if (i >= 10) {
                            try {
                                objValueOf = Integer.valueOf(i);
                            } catch (Exception e2) {
                                e = e2;
                                j = jCurrentTimeMillis;
                                i2 = i9;
                                exc = e;
                                exc.printStackTrace();
                                Log.d(f1021a, exc.toString());
                                i8 = i;
                                i9 = i2;
                                iM1118h--;
                                jCurrentTimeMillis = j;
                            }
                        } else {
                            objValueOf = "0" + i;
                        }
                        sb8.append(objValueOf);
                        sb8.append(":");
                        String string6 = sb8.toString();
                        StringBuilder sb9 = new StringBuilder();
                        sb9.append(string6);
                        i2 = i9;
                        if (i2 >= 10) {
                            try {
                                objValueOf2 = Integer.valueOf(i2);
                                j = jCurrentTimeMillis;
                            } catch (Exception e3) {
                                e = e3;
                                j = jCurrentTimeMillis;
                                exc = e;
                                exc.printStackTrace();
                                Log.d(f1021a, exc.toString());
                            }
                            break;
                        } else {
                            StringBuilder sb10 = new StringBuilder();
                            j = jCurrentTimeMillis;
                            try {
                                sb10.append("0");
                                sb10.append(i2);
                                objValueOf2 = sb10.toString();
                            } catch (Exception e4) {
                                e = e4;
                                exc = e;
                                exc.printStackTrace();
                                Log.d(f1021a, exc.toString());
                            }
                        }
                        sb9.append(objValueOf2);
                        timeInMillis = m1131a(sb9.toString());
                        jM1131a2 = timeInMillis;
                        break;
                    case 11:
                        jM1131a = m1131a(ahg.m1096a(m1132a(iM1120j, 9, 9, i11, i8, i9)));
                        j = jCurrentTimeMillis;
                        jM1131a2 = jM1131a;
                        i = i8;
                        i2 = i9;
                        break;
                    case 12:
                        try {
                            jM1131a = m1131a(ahg.m1096a(m1132a(iM1120j, 12, 8, i11, i8, i9)));
                            j = jCurrentTimeMillis;
                            jM1131a2 = jM1131a;
                            i = i8;
                            i2 = i9;
                        } catch (Exception e5) {
                            e = e5;
                            j = jCurrentTimeMillis;
                            i = i8;
                            i2 = i9;
                            exc = e;
                            exc.printStackTrace();
                            Log.d(f1021a, exc.toString());
                        }
                        break;
                    default:
                        j = jCurrentTimeMillis;
                        i = i8;
                        i2 = i9;
                        break;
                }
                i8 = i;
                i9 = i2;
            } else {
                j = jCurrentTimeMillis;
                i = i8;
                i2 = i9;
                int iM1119i = ahhVar.m1119i();
                int iM1120j2 = ahhVar.m1120j();
                switch (iM1119i) {
                    case 1:
                        iM1120j += iM1120j2;
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.set(1, iM1120j);
                        calendar2.set(2, i12 - 1);
                        calendar2.set(5, i10);
                        calendar2.set(11, i11);
                        calendar2.set(12, i);
                        calendar2.set(13, i2);
                        timeInMillis = calendar2.getTimeInMillis();
                        jM1131a2 = timeInMillis;
                        i8 = i;
                        i9 = i2;
                        break;
                    case 2:
                        i12 += iM1120j2;
                        if (i12 > 12) {
                            iM1120j += i12 / 12;
                            i12 %= 12;
                        }
                        Calendar calendar3 = Calendar.getInstance();
                        calendar3.set(1, iM1120j);
                        calendar3.set(2, i12 - 1);
                        calendar3.set(5, i10);
                        calendar3.set(11, i11);
                        calendar3.set(12, i);
                        calendar3.set(13, i2);
                        timeInMillis = calendar3.getTimeInMillis();
                        jM1131a2 = timeInMillis;
                        i8 = i;
                        i9 = i2;
                        break;
                    case 3:
                        j2 = jM1131a2 + ((long) (iM1120j2 * 24 * 60 * 60 * 1000));
                        Calendar calendar4 = Calendar.getInstance();
                        calendar4.setTimeInMillis(j2);
                        i3 = calendar4.get(1);
                        i4 = calendar4.get(2) + 1;
                        i5 = calendar4.get(5);
                        i11 = calendar4.get(11);
                        int i13 = calendar4.get(12);
                        i9 = calendar4.get(13);
                        i8 = i13;
                        long j3 = j2;
                        iM1120j = i3;
                        i12 = i4;
                        i10 = i5;
                        jM1131a2 = j3;
                        break;
                    case 4:
                        j2 = jM1131a2 + ((long) (iM1120j2 * 60 * 60 * 1000));
                        Calendar calendar5 = Calendar.getInstance();
                        calendar5.setTimeInMillis(j2);
                        i3 = calendar5.get(1);
                        i4 = calendar5.get(2) + 1;
                        i5 = calendar5.get(5);
                        i11 = calendar5.get(11);
                        i6 = calendar5.get(12);
                        i7 = calendar5.get(13);
                        i9 = i7;
                        i8 = i6;
                        long j32 = j2;
                        iM1120j = i3;
                        i12 = i4;
                        i10 = i5;
                        jM1131a2 = j32;
                        break;
                    case 5:
                        j2 = jM1131a2 + ((long) (iM1120j2 * 60 * 1000));
                        Calendar calendar6 = Calendar.getInstance();
                        calendar6.setTimeInMillis(j2);
                        i3 = calendar6.get(1);
                        i4 = calendar6.get(2) + 1;
                        i5 = calendar6.get(5);
                        i11 = calendar6.get(11);
                        i6 = calendar6.get(12);
                        i7 = calendar6.get(13);
                        i9 = i7;
                        i8 = i6;
                        long j322 = j2;
                        iM1120j = i3;
                        i12 = i4;
                        i10 = i5;
                        jM1131a2 = j322;
                        break;
                    case 6:
                        j2 = jM1131a2 + ((long) (iM1120j2 * 1000));
                        Calendar calendar7 = Calendar.getInstance();
                        calendar7.setTimeInMillis(j2);
                        i3 = calendar7.get(1);
                        i4 = calendar7.get(2) + 1;
                        i5 = calendar7.get(5);
                        i11 = calendar7.get(11);
                        i6 = calendar7.get(12);
                        i7 = calendar7.get(13);
                        i9 = i7;
                        i8 = i6;
                        long j3222 = j2;
                        iM1120j = i3;
                        i12 = i4;
                        i10 = i5;
                        jM1131a2 = j3222;
                        break;
                    default:
                        i8 = i;
                        i9 = i2;
                        break;
                }
            }
            iM1118h--;
            jCurrentTimeMillis = j;
        }
        Calendar calendar8 = Calendar.getInstance();
        calendar8.setTimeInMillis(jM1131a2);
        int i14 = calendar8.get(1);
        int i15 = calendar8.get(2) + 1;
        int i16 = calendar8.get(5);
        int i17 = calendar8.get(11);
        int i18 = calendar8.get(12);
        int i19 = calendar8.get(13);
        ahhVar.m1103a(i14);
        ahhVar.m1107b(i15);
        ahhVar.m1109c(i16);
        ahhVar.m1111d(i17);
        ahhVar.m1113e(i18);
        ahhVar.m1115f(i19);
        ahhVar.m1117g(iM1118h);
        try {
            ahk.m1144a(context).m1150b(ahhVar);
        } catch (Exception e6) {
            Log.d(f1021a, e6.toString());
            e6.printStackTrace();
        }
        return jM1131a2;
    }

    /* JADX INFO: renamed from: a */
    public static long m1131a(String str) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str).getTime();
    }

    /* JADX INFO: renamed from: a */
    public static String m1133a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
    }

    /* JADX INFO: renamed from: a */
    public static long m1129a(int i, int i2, int i3, int i4) {
        Object objValueOf;
        Object objValueOf2;
        Object objValueOf3;
        String strValueOf = String.valueOf(i);
        int i5 = Integer.parseInt(strValueOf.substring(strValueOf.length() - 2, strValueOf.length()));
        String str = i + "-04-0" + (((int) ((((double) i5) * 0.2422d) + 4.81d)) - (i5 / 4)) + " ";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        if (i2 >= 10) {
            objValueOf = Integer.valueOf(i2);
        } else {
            objValueOf = "0" + i2;
        }
        sb.append(objValueOf);
        sb.append(":");
        String string = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(string);
        if (i3 >= 10) {
            objValueOf2 = Integer.valueOf(i3);
        } else {
            objValueOf2 = "0" + i3;
        }
        sb2.append(objValueOf2);
        sb2.append(":");
        String string2 = sb2.toString();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(string2);
        if (i4 >= 10) {
            objValueOf3 = Integer.valueOf(i4);
        } else {
            objValueOf3 = "0" + i4;
        }
        sb3.append(objValueOf3);
        return m1131a(sb3.toString());
    }

    /* JADX INFO: renamed from: a */
    public static String m1132a(int i, int i2, int i3, int i4, int i5, int i6) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5 = "" + i + "-";
        if (i2 < 10) {
            str = str5 + "0" + i2 + "-";
        } else {
            str = str5 + i2 + "-";
        }
        if (i3 < 10) {
            str2 = str + "0" + i3 + " ";
        } else {
            str2 = str + i3 + " ";
        }
        if (i4 < 10) {
            str3 = str2 + "0" + i4 + ":";
        } else {
            str3 = str2 + i4 + ":";
        }
        if (i5 < 10) {
            str4 = str3 + "0" + i5 + ":";
        } else {
            str4 = str3 + i5 + ":";
        }
        if (i6 < 10) {
            return str4 + "0" + i6;
        }
        return str4 + i6;
    }
}
