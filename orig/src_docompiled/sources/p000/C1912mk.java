package p000;

import android.text.format.DateUtils;
import android.text.format.Time;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

/* JADX INFO: renamed from: mk */
/* JADX INFO: compiled from: TimeUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1912mk {

    /* JADX INFO: renamed from: a */
    static SimpleDateFormat f11504a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /* JADX INFO: renamed from: a */
    public static String m10534a(long j) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j * 1000));
    }

    /* JADX INFO: renamed from: a */
    public static String m10535a(long j, SimpleDateFormat simpleDateFormat) {
        return simpleDateFormat.format(new Date(j * 1000));
    }

    /* JADX INFO: renamed from: b */
    public static String m10540b(long j) {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(j * 1000));
    }

    /* JADX INFO: renamed from: a */
    public static long m10532a() {
        return System.currentTimeMillis() / 1000;
    }

    /* JADX INFO: renamed from: a */
    public static String m10537a(SimpleDateFormat simpleDateFormat) {
        return m10535a(m10532a(), simpleDateFormat);
    }

    /* JADX INFO: renamed from: a */
    public static long m10533a(String str) {
        try {
            return f11504a.parse(str).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: renamed from: b */
    public static long m10538b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.SIMPLIFIED_CHINESE);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        try {
            return simpleDateFormat.parse(str).getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    /* JADX INFO: renamed from: c */
    public static String m10542c(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j * 1000));
    }

    /* JADX INFO: renamed from: d */
    public static String m10544d(long j) {
        int i = (int) (j / 3600);
        if (i >= 24) {
            i %= 24;
        }
        String strValueOf = String.valueOf(i);
        String strValueOf2 = String.valueOf((j % 3600) / 60);
        String strValueOf3 = String.valueOf(j % 60);
        if (strValueOf.length() == 1) {
            String str = "0" + strValueOf;
        }
        if (strValueOf2.length() == 1) {
            strValueOf2 = "0" + strValueOf2;
        }
        if (strValueOf3.length() == 1) {
            strValueOf3 = "0" + strValueOf3;
        }
        return strValueOf2 + ":" + strValueOf3;
    }

    /* JADX INFO: renamed from: a */
    public static String m10536a(long j, boolean z) {
        String str = new DecimalFormat("#.#").format(j / 3600.0f);
        return (!z || Float.parseFloat(str) >= 0.1f || Float.parseFloat(str) <= 0.0f) ? str : "0.1";
    }

    /* JADX INFO: renamed from: c */
    public static boolean m10543c(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        return DateUtils.isToday(date.getTime());
    }

    /* JADX INFO: renamed from: b */
    public static String m10539b() {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date(System.currentTimeMillis()));
    }

    /* JADX INFO: renamed from: d */
    public static String m10545d(String str) {
        String string;
        C1900mc.m10473a("str=", str);
        String[] strArrSplit = str.split(" ");
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.set(Integer.parseInt(strArrSplit[0]), 0, 1);
        gregorianCalendar.get(3);
        while (gregorianCalendar.get(3) < Integer.parseInt(strArrSplit[1])) {
            gregorianCalendar.add(5, 1);
        }
        if (str.contentEquals("2016 1")) {
            return "12/28-01/03";
        }
        String string2 = Integer.toString(gregorianCalendar.get(1));
        String string3 = Integer.toString(gregorianCalendar.get(2) + 1);
        String string4 = Integer.toString(gregorianCalendar.get(5) + 1);
        C1900mc.m10473a("2016-01-02属于那一年的那一周？=", "" + gregorianCalendar.get(3));
        int i = Integer.parseInt(string3);
        int i2 = Integer.parseInt(string2);
        String string5 = Integer.toString(Integer.parseInt(string4) + 6);
        int i3 = 30;
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
            i3 = 31;
        } else if (i == 2) {
            i3 = ((i2 % 4 != 0 || i2 % 100 == 0) && i2 % 400 != 0) ? 28 : 29;
        }
        if (Integer.parseInt(string5) > i3) {
            string5 = Integer.toString(Integer.parseInt(string5) - 31);
            string = Integer.toString(Integer.parseInt(string3) + 1);
        } else {
            string = string3;
        }
        if (Integer.parseInt(string) > 12) {
            string = "1";
        }
        if (Integer.parseInt(string3) < 10) {
            string3 = "0" + string3;
        }
        if (Integer.parseInt(string4) < 10) {
            string4 = "0" + string4;
        }
        if (Integer.parseInt(string) < 10) {
            string = "0" + string;
        }
        if (Integer.parseInt(string5) < 10) {
            string5 = "0" + string5;
        }
        String str2 = string3 + "/" + string4 + "-" + string + "/" + string5;
        return string2 + "年" + string3 + "月";
    }

    /* JADX INFO: renamed from: c */
    public static int m10541c() {
        return TimeZone.getDefault().getOffset(0L) / 1000;
    }

    /* JADX INFO: renamed from: e */
    public static boolean m10547e(String str) {
        Date date;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date2 = new Date();
        try {
            date = simpleDateFormat.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            date = date2;
        }
        Time time = new Time();
        time.set(date.getTime());
        int i = time.year;
        int i2 = time.month;
        time.set(System.currentTimeMillis());
        return i == time.year && i2 == time.month;
    }

    /* JADX INFO: renamed from: e */
    public static String m10546e(long j) {
        return new SimpleDateFormat("HH:mm").format(new Date(j));
    }

    /* JADX INFO: renamed from: f */
    public static String m10548f(long j) {
        return new SimpleDateFormat("yyyy-MM").format(new Date(j));
    }

    /* JADX INFO: renamed from: f */
    public static String m10549f(String str) {
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM-dd").parse(str, new ParsePosition(0)).toString().split(" ");
        return strArrSplit[1] + " " + strArrSplit[2] + " " + strArrSplit[5];
    }

    /* JADX INFO: renamed from: g */
    public static String m10550g(String str) {
        String[] strArrSplit = new SimpleDateFormat("yyyy-MM").parse(str, new ParsePosition(0)).toString().split(" ");
        return strArrSplit[1] + " " + strArrSplit[5];
    }

    /* JADX INFO: renamed from: h */
    public static String m10551h(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return new SimpleDateFormat("yyyy年MM月dd日").format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return "";
        }
    }
}
