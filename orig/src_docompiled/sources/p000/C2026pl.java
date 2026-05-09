package p000;

import java.util.Date;

/* JADX INFO: renamed from: pl */
/* JADX INFO: compiled from: DateHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C2026pl {
    /* JADX INFO: renamed from: a */
    public static Date m11095a(long j) {
        return new Date((j - 2082844800) * 1000);
    }

    /* JADX INFO: renamed from: a */
    public static long m11094a(Date date) {
        return (date.getTime() / 1000) + 2082844800;
    }
}
