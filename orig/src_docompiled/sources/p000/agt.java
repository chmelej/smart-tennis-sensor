package p000;

import android.support.v4.view.PointerIconCompat;
import java.util.Calendar;

/* JADX INFO: compiled from: UMCCTimeRange.java */
/* JADX INFO: loaded from: classes.dex */
public class agt {
    /* JADX INFO: renamed from: a */
    public static long m972a(long j) {
        return m973a(j, PointerIconCompat.TYPE_CONTEXT_MENU);
    }

    /* JADX INFO: renamed from: b */
    public static long m975b(long j) {
        return m973a(j, PointerIconCompat.TYPE_HAND);
    }

    /* JADX INFO: renamed from: a */
    private static long m973a(long j, int i) {
        int i2;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        int i3 = (10 * calendar.get(11)) + (calendar.get(12) / 6) + 1;
        int i4 = calendar.get(13);
        if (i == 1002) {
            i2 = 360 - (((calendar.get(12) % 6) * 60) + i4);
        } else if (i == 1001) {
            i2 = 60 - (i4 % 60);
            if (i3 % 6 == 0) {
                i2 += 60;
            }
        } else {
            i2 = 0;
        }
        return i2 * 1000;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m974a(long j, long j2) {
        return m976c(j) == m976c(j2);
    }

    /* JADX INFO: renamed from: c */
    private static int m976c(long j) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return calendar.get(5);
    }
}
