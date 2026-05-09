package p000;

import java.net.Proxy;

/* JADX INFO: compiled from: RequestLine.java */
/* JADX INFO: loaded from: classes.dex */
public final class aoi {
    /* JADX INFO: renamed from: a */
    public static String m4637a(ane aneVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(aneVar.m4422b());
        sb.append(' ');
        if (m4638b(aneVar, type)) {
            sb.append(aneVar.m4419a());
        } else {
            sb.append(m4636a(aneVar.m4419a()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    private static boolean m4638b(ane aneVar, Proxy.Type type) {
        return !aneVar.m4428h() && type == Proxy.Type.HTTP;
    }

    /* JADX INFO: renamed from: a */
    public static String m4636a(amy amyVar) {
        String strM2087h = amyVar.m2087h();
        String strM2089j = amyVar.m2089j();
        if (strM2089j == null) {
            return strM2087h;
        }
        return strM2087h + '?' + strM2089j;
    }
}
