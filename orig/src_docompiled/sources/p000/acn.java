package p000;

import android.content.Context;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes.dex */
final class acn implements Runnable {

    /* JADX INFO: renamed from: a */
    private Context f293a;

    /* JADX INFO: renamed from: b */
    private Map<String, Integer> f294b = null;

    /* JADX INFO: renamed from: c */
    private ace f295c;

    public acn(Context context) {
        this.f293a = null;
        this.f295c = null;
        this.f293a = context;
        this.f295c = null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX INFO: renamed from: a */
    private static abh m247a(String str, int i) {
        ?? r1;
        int i2;
        abh abhVar = new abh();
        Socket socket = new Socket();
        try {
            try {
                abhVar.m46a(str);
                abhVar.m47b(i);
                long jCurrentTimeMillis = System.currentTimeMillis();
                InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i);
                socket.connect(inetSocketAddress, 30000);
                abhVar.m45a(System.currentTimeMillis() - jCurrentTimeMillis);
                abhVar.m48b(inetSocketAddress.getAddress().getHostAddress());
                socket.close();
                try {
                    socket.close();
                } catch (Throwable th) {
                    acd.f264q.m54b(th);
                }
                i2 = 0;
                socket = socket;
            } catch (IOException e) {
                acd.f264q.m54b((Throwable) e);
                i2 = -1;
                socket = r1;
            }
            abhVar.m44a(i2);
            return abhVar;
        } finally {
            try {
                socket.close();
            } catch (Throwable th2) {
                acd.f264q.m54b(th2);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private static Map<String, Integer> m248a() {
        String str;
        HashMap map = new HashMap();
        String strM153a = acb.m153a("__MTA_TEST_SPEED__");
        if (strM153a == null || strM153a.trim().length() == 0) {
            return map;
        }
        for (String str2 : strM153a.split(";")) {
            String[] strArrSplit = str2.split(",");
            if (strArrSplit != null && strArrSplit.length == 2 && (str = strArrSplit[0]) != null && str.trim().length() != 0) {
                try {
                    map.put(str, Integer.valueOf(Integer.valueOf(strArrSplit[1]).intValue()));
                } catch (NumberFormatException e) {
                    acd.f264q.m54b((Throwable) e);
                }
            }
        }
        return map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        abj abjVar;
        String str;
        try {
            if (this.f294b == null) {
                this.f294b = m248a();
            }
            if (this.f294b != null && this.f294b.size() != 0) {
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, Integer> entry : this.f294b.entrySet()) {
                    String key = entry.getKey();
                    if (key == null || key.length() == 0) {
                        abjVar = acd.f264q;
                        str = "empty domain name.";
                    } else if (entry.getValue() == null) {
                        abjVar = acd.f264q;
                        str = "port is null for " + key;
                    } else {
                        jSONArray.put(m247a(entry.getKey(), entry.getValue().intValue()).m43a());
                    }
                    abjVar.m55c(str);
                }
                if (jSONArray.length() == 0) {
                    return;
                }
                aal aalVar = new aal(this.f293a, acd.m194a(this.f293a, false, this.f295c), this.f295c);
                aalVar.m28a(jSONArray.toString());
                new aco(aalVar).m254a();
                return;
            }
            acd.f264q.m51a("empty domain list.");
        } catch (Throwable th) {
            acd.f264q.m54b(th);
        }
    }
}
