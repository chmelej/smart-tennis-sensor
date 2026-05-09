package p000;

import com.mob.tools.network.HttpPatch;
import org.android.spdy.SpdyRequest;

/* JADX INFO: compiled from: HttpMethod.java */
/* JADX INFO: loaded from: classes.dex */
public final class aof {
    /* JADX INFO: renamed from: a */
    public static boolean m4626a(String str) {
        return str.equals(SpdyRequest.POST_METHOD) || str.equals(HttpPatch.METHOD_NAME) || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    /* JADX INFO: renamed from: b */
    public static boolean m4627b(String str) {
        return str.equals(SpdyRequest.POST_METHOD) || str.equals("PUT") || str.equals(HttpPatch.METHOD_NAME) || str.equals("PROPPATCH") || str.equals("REPORT");
    }

    /* JADX INFO: renamed from: c */
    public static boolean m4628c(String str) {
        return (str.equals(SpdyRequest.GET_METHOD) || str.equals("HEAD")) ? false : true;
    }

    /* JADX INFO: renamed from: d */
    public static boolean m4629d(String str) {
        return str.equals("PROPFIND");
    }

    /* JADX INFO: renamed from: e */
    public static boolean m4630e(String str) {
        return !str.equals("PROPFIND");
    }
}
