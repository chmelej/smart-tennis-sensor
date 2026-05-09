package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSocket;

/* JADX INFO: compiled from: Jdk9Platform.java */
/* JADX INFO: loaded from: classes.dex */
final class ape extends aph {

    /* JADX INFO: renamed from: a */
    final Method f4573a;

    /* JADX INFO: renamed from: b */
    final Method f4574b;

    ape(Method method, Method method2) {
        this.f4573a = method;
        this.f4574b = method2;
    }

    @Override // p000.aph
    /* JADX INFO: renamed from: a */
    public void mo4828a(SSLSocket sSLSocket, String str, List<anc> list) {
        try {
            SSLParameters sSLParameters = sSLSocket.getSSLParameters();
            List<String> listA = m4851a(list);
            this.f4573a.invoke(sSLParameters, listA.toArray(new String[listA.size()]));
            sSLSocket.setSSLParameters(sSLParameters);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw anm.m4495a("unable to set ssl parameters", (Exception) e);
        }
    }

    @Override // p000.aph
    @Nullable
    /* JADX INFO: renamed from: a */
    public String mo4824a(SSLSocket sSLSocket) {
        try {
            String str = (String) this.f4574b.invoke(sSLSocket, new Object[0]);
            if (str == null) {
                return null;
            }
            if (str.equals("")) {
                return null;
            }
            return str;
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw anm.m4495a("unable to get selected protocols", (Exception) e);
        }
    }

    /* JADX INFO: renamed from: a */
    public static ape m4840a() {
        try {
            return new ape(SSLParameters.class.getMethod("setApplicationProtocols", String[].class), SSLSocket.class.getMethod("getApplicationProtocol", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }
}
