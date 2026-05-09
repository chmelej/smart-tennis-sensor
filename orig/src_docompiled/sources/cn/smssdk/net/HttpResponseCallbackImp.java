package cn.smssdk.net;

import android.support.v4.app.NotificationCompat;
import com.mob.tools.network.HttpConnection;
import com.mob.tools.network.HttpResponseCallback;
import com.mob.tools.utils.Hashon;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class HttpResponseCallbackImp implements HttpResponseCallback {

    /* JADX INFO: renamed from: a */
    private HashMap<String, Object> f6071a;

    public HttpResponseCallbackImp(HashMap<String, Object> map) {
        this.f6071a = map;
    }

    public void handleInput(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[65536];
        int i = inputStream.read(bArr);
        while (i > 0) {
            byteArrayOutputStream.write(bArr, 0, i);
            i = inputStream.read(bArr);
        }
        byteArrayOutputStream.flush();
        this.f6071a.put("bResp", byteArrayOutputStream.toByteArray());
        byteArrayOutputStream.close();
    }

    @Override // com.mob.tools.network.HttpResponseCallback
    public void onResponse(HttpConnection httpConnection) throws Throwable {
        InputStream inputStream;
        int responseCode = httpConnection.getResponseCode();
        this.f6071a.put("httpStatus", Integer.valueOf(responseCode));
        List<String> list = httpConnection.getHeaderFields().get("hash");
        if (list != null && list.size() > 0) {
            this.f6071a.put("hash", list.get(0));
        }
        if (responseCode == 200 || responseCode == 600) {
            if (responseCode == 600) {
                inputStream = httpConnection.getErrorStream();
            } else {
                inputStream = httpConnection.getInputStream();
            }
            try {
                handleInput(inputStream);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return;
                    } catch (Throwable unused) {
                        return;
                    }
                }
                return;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                throw th;
            }
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(line);
        }
        bufferedReader.close();
        HashMap map = new HashMap();
        map.put("error", sb.toString());
        map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(map));
    }
}
