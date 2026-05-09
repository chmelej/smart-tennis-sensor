package p000;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Dns.java */
/* JADX INFO: loaded from: classes.dex */
public interface amu {

    /* JADX INFO: renamed from: c */
    public static final amu f1914c = new amu() { // from class: amu.1
        @Override // p000.amu
        /* JADX INFO: renamed from: a */
        public List<InetAddress> mo2025a(String str) throws UnknownHostException {
            if (str == null) {
                throw new UnknownHostException("hostname == null");
            }
            try {
                return Arrays.asList(InetAddress.getAllByName(str));
            } catch (NullPointerException e) {
                UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of " + str);
                unknownHostException.initCause(e);
                throw unknownHostException;
            }
        }
    };

    /* JADX INFO: renamed from: a */
    List<InetAddress> mo2025a(String str);
}
