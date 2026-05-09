package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.lidroid.xutils.http.client.multipart.MIME;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import org.android.spdy.SpdyRequest;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: renamed from: ve */
/* JADX INFO: compiled from: QosManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C2183ve {

    /* JADX INFO: renamed from: a */
    private static boolean f13038a = false;

    /* JADX INFO: renamed from: b */
    private static boolean f13039b = true;

    /* JADX INFO: renamed from: d */
    private static C2183ve f13040d;

    /* JADX INFO: renamed from: c */
    private JSONObject f13041c;

    /* JADX INFO: renamed from: e */
    private volatile boolean f13042e = false;

    /* JADX INFO: renamed from: f */
    private Context f13043f;

    /* JADX INFO: renamed from: a */
    public static synchronized C2183ve m11912a(Context context) {
        if (f13040d == null) {
            f13040d = new C2183ve(context.getApplicationContext());
        }
        return f13040d;
    }

    private C2183ve(Context context) {
        this.f13043f = context.getApplicationContext();
        String[] strArr = C2182vd.f13037a;
        int length = strArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if (C2204vz.m12082j(context).contains(strArr[i])) {
                f13039b = false;
                break;
            }
            i++;
        }
        if (m11917c()) {
            this.f13041c = m11919e();
        } else {
            this.f13041c = m11921g();
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11924a(String str) {
        try {
        } catch (JSONException unused) {
            m11916b("Error on recording function");
        }
        if (this.f13041c.optInt(str) != 1) {
            this.f13041c.put(str, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11923a(int i) {
        String str;
        try {
            str = "error_code_" + Integer.toString(i);
        } catch (JSONException unused) {
            m11916b("Error on recording error");
        }
        if (this.f13041c.optInt(str) != 1) {
            this.f13041c.put(str, 1);
        }
    }

    /* JADX INFO: renamed from: a */
    public synchronized void m11922a() {
        m11915b();
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f13043f.openFileOutput("status.json", 0));
            outputStreamWriter.write(this.f13041c.toString());
            outputStreamWriter.close();
        } catch (IOException unused) {
            m11916b("Error on saving json data");
        }
    }

    /* JADX INFO: renamed from: b */
    private synchronized void m11915b() {
        if (f13039b && !this.f13042e) {
            if (m11918d()) {
                this.f13042e = true;
                new Thread(new Runnable() { // from class: ve.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C2183ve.this.m11920f();
                        C2183ve.this.f13042e = false;
                    }
                }).start();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    private boolean m11917c() {
        return new File(this.f13043f.getFilesDir().getPath() + "/status.json").exists();
    }

    /* JADX INFO: renamed from: d */
    private boolean m11918d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            if (this.f13041c.has("createTime")) {
                if (jCurrentTimeMillis - this.f13041c.getLong("createTime") < 86400000) {
                    return false;
                }
            }
            return true;
        } catch (JSONException unused) {
            m11916b("Error on detect file expiration");
            return false;
        }
    }

    /* JADX INFO: renamed from: e */
    private JSONObject m11919e() {
        File file = new File(this.f13043f.getFilesDir().getPath() + "/status.json");
        try {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                String line = bufferedReader.readLine();
                if (line != null) {
                    sb.append(line);
                    sb.append("\n");
                } else {
                    bufferedReader.close();
                    return new JSONObject(sb.toString());
                }
            }
        } catch (IOException | JSONException unused) {
            m11916b("Error on reading json file");
            return m11921g();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: f */
    public void m11920f() {
        try {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL("https://shortvideo.qiniuapi.com/v1/status/a").openConnection();
            httpsURLConnection.setRequestMethod(SpdyRequest.POST_METHOD);
            httpsURLConnection.addRequestProperty(MIME.CONTENT_TYPE, "application/json");
            httpsURLConnection.getOutputStream().write(this.f13041c.toString().getBytes());
            if (httpsURLConnection.getResponseCode() != 200) {
                m11916b("Error on sending status data");
                return;
            }
            if (m11917c()) {
                new File(this.f13043f.getFilesDir().getPath() + "/status.json").delete();
            }
            this.f13041c = m11921g();
        } catch (IOException unused) {
            m11916b("Error on sending status data");
        }
    }

    /* JADX INFO: renamed from: g */
    private JSONObject m11921g() {
        SharedPreferences sharedPreferences = this.f13043f.getSharedPreferences("ShortVideo", 0);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (sharedPreferences.getString("SDK_ID", null) == null) {
            editorEdit.putString("SDK_ID", C2204vz.m12075c());
            editorEdit.apply();
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("createTime", System.currentTimeMillis());
            jSONObject.put("app_bundle_id", C2204vz.m12079g(this.f13043f));
            jSONObject.put("app_name", C2204vz.m12081i(this.f13043f));
            jSONObject.put("app_version", C2204vz.m12080h(this.f13043f));
            jSONObject.put("device_model", C2204vz.m12073b());
            jSONObject.put("os_platform", "android");
            jSONObject.put("os_version", Build.VERSION.RELEASE);
            jSONObject.put("sdk_version", "1.9.0");
            jSONObject.put("sdk_id", sharedPreferences.getString("SDK_ID", ""));
        } catch (JSONException unused) {
            m11916b("Error on creating json data");
        }
        return jSONObject;
    }

    /* JADX INFO: renamed from: b */
    private void m11916b(String str) {
        if (f13038a) {
            C2201vw.f13223l.m12055e("QosManager", str);
        }
    }
}
