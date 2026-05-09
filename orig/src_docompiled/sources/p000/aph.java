package p000;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okio.Buffer;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes.dex */
public class aph {

    /* JADX INFO: renamed from: a */
    private static final aph f4586a = m4850a();

    /* JADX INFO: renamed from: b */
    private static final Logger f4587b = Logger.getLogger(anb.class.getName());

    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo4824a(SSLSocket sSLSocket) {
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo4828a(SSLSocket sSLSocket, String str, List<anc> list) {
    }

    /* JADX INFO: renamed from: a */
    public void mo4839a(SSLSocketFactory sSLSocketFactory) {
    }

    /* JADX INFO: renamed from: b */
    public void mo4842b(SSLSocket sSLSocket) {
    }

    /* JADX INFO: renamed from: b */
    public boolean mo4831b(String str) {
        return true;
    }

    /* JADX INFO: renamed from: c */
    public static aph m4853c() {
        return f4586a;
    }

    /* JADX INFO: renamed from: a */
    public void mo4827a(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        socket.connect(inetSocketAddress, i);
    }

    /* JADX INFO: renamed from: a */
    public void mo4825a(int i, String str, Throwable th) {
        f4587b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    /* JADX INFO: renamed from: a */
    public Object mo4823a(String str) {
        if (f4587b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void mo4826a(String str, Object obj) {
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        mo4825a(5, str, (Throwable) obj);
    }

    /* JADX INFO: renamed from: a */
    public static List<String> m4851a(List<anc> list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            anc ancVar = list.get(i);
            if (ancVar != anc.HTTP_1_0) {
                arrayList.add(ancVar.toString());
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: a */
    public apl mo4822a(X509TrustManager x509TrustManager) {
        return new apj(mo4829b(x509TrustManager));
    }

    /* JADX INFO: renamed from: d */
    public static boolean m4854d() {
        if ("conscrypt".equals(System.getProperty("okhttp.platform"))) {
            return true;
        }
        return "Conscrypt".equals(Security.getProviders()[0].getName());
    }

    /* JADX INFO: renamed from: a */
    private static aph m4850a() {
        aph aphVarM4837a;
        aph aphVarM4818a = apc.m4818a();
        if (aphVarM4818a != null) {
            return aphVarM4818a;
        }
        if (m4854d() && (aphVarM4837a = apd.m4837a()) != null) {
            return aphVarM4837a;
        }
        ape apeVarM4840a = ape.m4840a();
        if (apeVarM4840a != null) {
            return apeVarM4840a;
        }
        aph aphVarM4841a = apf.m4841a();
        return aphVarM4841a != null ? aphVarM4841a : new aph();
    }

    /* JADX INFO: renamed from: b */
    static byte[] m4852b(List<anc> list) {
        Buffer buffer = new Buffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            anc ancVar = list.get(i);
            if (ancVar != anc.HTTP_1_0) {
                buffer.writeByte(ancVar.toString().length());
                buffer.writeUtf8(ancVar.toString());
            }
        }
        return buffer.readByteArray();
    }

    /* JADX INFO: renamed from: b */
    public SSLContext mo4830b() {
        if ("1.7".equals(System.getProperty("java.specification.version"))) {
            try {
                return SSLContext.getInstance("TLSv1.2");
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        try {
            return SSLContext.getInstance("TLS");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("No TLS provider", e);
        }
    }

    /* JADX INFO: renamed from: b */
    public apn mo4829b(X509TrustManager x509TrustManager) {
        return new apk(x509TrustManager.getAcceptedIssuers());
    }
}
