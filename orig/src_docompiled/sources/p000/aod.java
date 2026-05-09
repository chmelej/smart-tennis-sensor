package p000;

import java.text.DateFormat;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: HttpDate.java */
/* JADX INFO: loaded from: classes.dex */
public final class aod {

    /* JADX INFO: renamed from: a */
    private static final ThreadLocal<DateFormat> f4325a = new ThreadLocal<DateFormat>() { // from class: aod.1
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DateFormat initialValue() {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss 'GMT'", Locale.US);
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(anm.f4213g);
            return simpleDateFormat;
        }
    };

    /* JADX INFO: renamed from: b */
    private static final String[] f4326b = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEEE, dd-MMM-yy HH:mm:ss zzz", "EEE MMM d HH:mm:ss yyyy", "EEE, dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MMM-yyyy HH-mm-ss z", "EEE, dd MMM yy HH:mm:ss z", "EEE dd-MMM-yyyy HH:mm:ss z", "EEE dd MMM yyyy HH:mm:ss z", "EEE dd-MMM-yyyy HH-mm-ss z", "EEE dd-MMM-yy HH:mm:ss z", "EEE dd MMM yy HH:mm:ss z", "EEE,dd-MMM-yy HH:mm:ss z", "EEE,dd-MMM-yyyy HH:mm:ss z", "EEE, dd-MM-yyyy HH:mm:ss z", "EEE MMM d yyyy HH:mm:ss z"};

    /* JADX INFO: renamed from: c */
    private static final DateFormat[] f4327c = new DateFormat[f4326b.length];

    /* JADX INFO: renamed from: a */
    public static Date m4616a(String str) {
        if (str.length() == 0) {
            return null;
        }
        ParsePosition parsePosition = new ParsePosition(0);
        Date date = f4325a.get().parse(str, parsePosition);
        if (parsePosition.getIndex() == str.length()) {
            return date;
        }
        synchronized (f4326b) {
            int length = f4326b.length;
            for (int i = 0; i < length; i++) {
                DateFormat simpleDateFormat = f4327c[i];
                if (simpleDateFormat == null) {
                    simpleDateFormat = new SimpleDateFormat(f4326b[i], Locale.US);
                    simpleDateFormat.setTimeZone(anm.f4213g);
                    f4327c[i] = simpleDateFormat;
                }
                parsePosition.setIndex(0);
                Date date2 = simpleDateFormat.parse(str, parsePosition);
                if (parsePosition.getIndex() != 0) {
                    return date2;
                }
            }
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static String m4615a(Date date) {
        return f4325a.get().format(date);
    }
}
