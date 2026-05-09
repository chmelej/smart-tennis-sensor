package p000;

import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* JADX INFO: compiled from: OkHostnameVerifier.java */
/* JADX INFO: loaded from: classes.dex */
public final class apm implements HostnameVerifier {

    /* JADX INFO: renamed from: a */
    public static final apm f4598a = new apm();

    private apm() {
    }

    @Override // javax.net.ssl.HostnameVerifier
    public boolean verify(String str, SSLSession sSLSession) {
        try {
            return m4868a(str, (X509Certificate) sSLSession.getPeerCertificates()[0]);
        } catch (SSLException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4868a(String str, X509Certificate x509Certificate) {
        if (anm.m4520c(str)) {
            return m4865b(str, x509Certificate);
        }
        return m4866c(str, x509Certificate);
    }

    /* JADX INFO: renamed from: b */
    private boolean m4865b(String str, X509Certificate x509Certificate) {
        List<String> listM4864a = m4864a(x509Certificate, 7);
        int size = listM4864a.size();
        for (int i = 0; i < size; i++) {
            if (str.equalsIgnoreCase(listM4864a.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: c */
    private boolean m4866c(String str, X509Certificate x509Certificate) {
        String lowerCase = str.toLowerCase(Locale.US);
        Iterator<String> it = m4864a(x509Certificate, 2).iterator();
        while (it.hasNext()) {
            if (m4867a(lowerCase, it.next())) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: a */
    public static List<String> m4863a(X509Certificate x509Certificate) {
        List<String> listM4864a = m4864a(x509Certificate, 7);
        List<String> listM4864a2 = m4864a(x509Certificate, 2);
        ArrayList arrayList = new ArrayList(listM4864a.size() + listM4864a2.size());
        arrayList.addAll(listM4864a);
        arrayList.addAll(listM4864a2);
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    private static List<String> m4864a(X509Certificate x509Certificate, int i) {
        Integer num;
        String str;
        ArrayList arrayList = new ArrayList();
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return Collections.emptyList();
            }
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && (num = (Integer) list.get(0)) != null && num.intValue() == i && (str = (String) list.get(1)) != null) {
                    arrayList.add(str);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return Collections.emptyList();
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m4867a(String str, String str2) {
        if (str == null || str.length() == 0 || str.startsWith(".") || str.endsWith("..") || str2 == null || str2.length() == 0 || str2.startsWith(".") || str2.endsWith("..")) {
            return false;
        }
        if (!str.endsWith(".")) {
            str = str + '.';
        }
        if (!str2.endsWith(".")) {
            str2 = str2 + '.';
        }
        String lowerCase = str2.toLowerCase(Locale.US);
        if (!lowerCase.contains("*")) {
            return str.equals(lowerCase);
        }
        if (!lowerCase.startsWith("*.") || lowerCase.indexOf(42, 1) != -1 || str.length() < lowerCase.length() || "*.".equals(lowerCase)) {
            return false;
        }
        String strSubstring = lowerCase.substring(1);
        if (!str.endsWith(strSubstring)) {
            return false;
        }
        int length = str.length() - strSubstring.length();
        return length <= 0 || str.lastIndexOf(46, length - 1) == -1;
    }
}
