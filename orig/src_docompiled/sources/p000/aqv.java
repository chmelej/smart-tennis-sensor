package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: HttpURLChunkedChannel.java */
/* JADX INFO: loaded from: classes.dex */
public class aqv extends aqw {

    /* JADX INFO: renamed from: g */
    private volatile HttpURLConnection f4759g = null;

    /* JADX INFO: renamed from: a */
    private final void m5132a(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor editorEdit = context.getSharedPreferences("AppStore", 4).edit();
            editorEdit.putString("agoo_push_errorid", str);
            editorEdit.putString("agoo_push_path", str2);
            editorEdit.putString("agoo_connect_type", "httpchunk");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    @Override // p000.aqw
    /* JADX INFO: renamed from: a */
    protected final void mo5134a(String str, Map<String, String> map) {
        try {
            SharedPreferences.Editor editorEdit = this.f4766f.getSharedPreferences("AppStore", 4).edit();
            editorEdit.putString("agoo_connect_type", "httpchunk");
            editorEdit.commit();
        } catch (Throwable unused) {
        }
        try {
            aiv.m1418c("HttpURLChunked", "http chunked connectId:[" + m5149j() + "]==>" + str);
            URL url = new URL(str);
            if (m5157r()) {
                aiv.m1418c("HttpURLChunked", "http chunked setPoxy:[" + super.m5155p() + "][" + super.m5156q() + "]");
                this.f4759g = (HttpURLConnection) url.openConnection(new Proxy(Proxy.Type.HTTP, new InetSocketAddress(InetAddress.getByName(super.m5155p()), super.m5156q())));
            } else {
                this.f4759g = (HttpURLConnection) url.openConnection();
            }
            this.f4759g.setRequestProperty("User-agent", String.format("Agoo-sdk-%s", Double.valueOf(2.0d)));
            if (map != null) {
                for (String str2 : map.keySet()) {
                    this.f4759g.setRequestProperty(str2, map.get(str2));
                }
            }
            this.f4759g.setReadTimeout(Integer.MAX_VALUE);
            this.f4759g.setChunkedStreamingMode(Integer.MAX_VALUE);
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.f4759g.connect();
            long jCurrentTimeMillis2 = System.currentTimeMillis() - jCurrentTimeMillis;
            int responseCode = this.f4759g.getResponseCode();
            Map<String, String> mapM5131a = m5131a(this.f4759g);
            if (200 == responseCode) {
                this.f4765e = System.currentTimeMillis();
                m5133b(this.f4759g);
                m5141a(jCurrentTimeMillis2, mapM5131a);
                m5151l();
                return;
            }
            aiv.m1420d("HttpURLChunked", "http chunked connectId:[" + m5149j() + "]==>[" + responseCode + "]");
            if (!aie.m1309a(Integer.toString(responseCode))) {
                m5132a(this.f4766f, Integer.toString(responseCode), str);
            }
            m5143a(aql.m5026b(responseCode), mapM5131a, new Throwable("http httpStatusCode==" + responseCode));
            m5152m();
        } catch (Throwable th) {
            if (m5147h()) {
                return;
            }
            m5145a(true);
            aiv.m1419c("HttpURLChunked", "http chunked connectId:[" + m5149j() + "]==>[Throwable]", th);
            m5142a(aql.HTTP_GATEWAY_TIMEOUT, th);
        }
    }

    /* JADX INFO: renamed from: a */
    private final Map<String, String> m5131a(HttpURLConnection httpURLConnection) {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<String>> entry : httpURLConnection.getHeaderFields().entrySet()) {
            String key = entry.getKey();
            if (!TextUtils.isEmpty(key)) {
                String strM5130a = m5130a(entry.getValue());
                if (!TextUtils.isEmpty(strM5130a)) {
                    map.put(key.toLowerCase(), strM5130a);
                }
            }
        }
        return map;
    }

    /* JADX INFO: renamed from: a */
    private final String m5130a(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i));
            if (i < size - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: b */
    private final void m5133b(HttpURLConnection httpURLConnection) throws IOException {
        if (httpURLConnection == null) {
            throw new IOException();
        }
        this.f4762b = httpURLConnection.getInputStream();
    }

    @Override // p000.aqw
    /* JADX INFO: renamed from: f */
    protected final void mo5135f() {
        if (this.f4759g != null) {
            this.f4759g.disconnect();
            this.f4759g = null;
        }
    }

    @Override // p000.aqw
    /* JADX INFO: renamed from: g */
    protected final void mo5136g() {
        if (this.f4759g != null) {
            this.f4759g.disconnect();
            this.f4759g = null;
        }
    }
}
