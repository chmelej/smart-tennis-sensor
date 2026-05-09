package p000;

import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: HttpHeaders.java */
/* JADX INFO: loaded from: classes.dex */
public final class aoe {

    /* JADX INFO: renamed from: a */
    private static final Pattern f4328a = Pattern.compile(" +([^ \"=]*)=(:?\"([^\"]*)\"|([^ \"=]*)) *(:?,|$)");

    /* JADX INFO: renamed from: a */
    public static long m4621a(ang angVar) {
        return m4620a(angVar.m4454e());
    }

    /* JADX INFO: renamed from: a */
    public static long m4620a(amx amxVar) {
        return m4622a(amxVar.m2054a("Content-Length"));
    }

    /* JADX INFO: renamed from: a */
    private static long m4622a(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m4623a(amr amrVar, amy amyVar, amx amxVar) {
        if (amrVar == amr.f1906a) {
            return;
        }
        List<amq> listM2006a = amq.m2006a(amyVar, amxVar);
        if (listM2006a.isEmpty()) {
            return;
        }
        amrVar.mo2013a(amyVar, listM2006a);
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4625b(ang angVar) {
        if (angVar.m4448a().m4422b().equals("HEAD")) {
            return false;
        }
        int iM4451b = angVar.m4451b();
        return (((iM4451b >= 100 && iM4451b < 200) || iM4451b == 204 || iM4451b == 304) && m4621a(angVar) == -1 && !"chunked".equalsIgnoreCase(angVar.m4449a("Transfer-Encoding"))) ? false : true;
    }

    /* JADX INFO: renamed from: a */
    public static int m4619a(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public static int m4618a(String str, int i) {
        char cCharAt;
        while (i < str.length() && ((cCharAt = str.charAt(i)) == ' ' || cCharAt == '\t')) {
            i++;
        }
        return i;
    }

    /* JADX INFO: renamed from: b */
    public static int m4624b(String str, int i) {
        try {
            long j = Long.parseLong(str);
            if (j > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (j < 0) {
                return 0;
            }
            return (int) j;
        } catch (NumberFormatException unused) {
            return i;
        }
    }
}
