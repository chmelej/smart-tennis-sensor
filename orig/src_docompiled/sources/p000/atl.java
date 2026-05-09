package p000;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Map;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import java.util.zip.InflaterInputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: UClient.java */
/* JADX INFO: loaded from: classes.dex */
public class atl {

    /* JADX INFO: renamed from: a */
    private static final String f5049a = "atl";

    /* JADX INFO: renamed from: b */
    private Map<String, String> f5050b;

    /* JADX INFO: renamed from: a */
    public boolean mo1516a() {
        return false;
    }

    /* JADX INFO: renamed from: a */
    public <T extends atn> T m5442a(atm atmVar, Class<T> cls) {
        JSONObject jSONObjectM5439a;
        String strTrim = atmVar.m5444c().trim();
        m5441b(strTrim);
        if (atm.f5052b.equals(strTrim)) {
            jSONObjectM5439a = m5438a(atmVar.mo1535b());
        } else {
            jSONObjectM5439a = atm.f5051a.equals(strTrim) ? m5439a(atmVar.f5053c, atmVar.mo1534a()) : null;
        }
        if (jSONObjectM5439a == null) {
            return null;
        }
        try {
            return cls.getConstructor(JSONObject.class).newInstance(jSONObjectM5439a);
        } catch (IllegalAccessException e) {
            atj.m5426b(f5049a, "IllegalAccessException", e);
            return null;
        } catch (IllegalArgumentException e2) {
            atj.m5426b(f5049a, "IllegalArgumentException", e2);
            return null;
        } catch (InstantiationException e3) {
            atj.m5426b(f5049a, "InstantiationException", e3);
            return null;
        } catch (NoSuchMethodException e4) {
            atj.m5426b(f5049a, "NoSuchMethodException", e4);
            return null;
        } catch (SecurityException e5) {
            atj.m5426b(f5049a, "SecurityException", e5);
            return null;
        } catch (InvocationTargetException e6) {
            atj.m5426b(f5049a, "InvocationTargetException", e6);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private JSONObject m5439a(String str, JSONObject jSONObject) {
        String string = jSONObject.toString();
        int iNextInt = new Random().nextInt(1000);
        atj.m5427c(f5049a, String.valueOf(iNextInt) + ":\trequest: " + str + ats.f5055a + string);
        HttpPost httpPost = new HttpPost(str);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(m5440b());
        try {
            if (mo1516a()) {
                byte[] bArrM5466a = atr.m5466a("content=" + string, Charset.defaultCharset().toString());
                httpPost.addHeader("Content-Encoding", "deflate");
                httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(bArrM5466a), (long) bArrM5466a.length));
            } else {
                ArrayList arrayList = new ArrayList(1);
                arrayList.add(new BasicNameValuePair("content", string));
                httpPost.setEntity(new UrlEncodedFormEntity(arrayList, "UTF-8"));
            }
            HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPost);
            if (httpResponseExecute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = httpResponseExecute.getEntity();
                if (entity == null) {
                    return null;
                }
                InputStream content = entity.getContent();
                Header firstHeader = httpResponseExecute.getFirstHeader("Content-Encoding");
                String strM5437a = m5437a((firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) ? content : new InflaterInputStream(content));
                atj.m5423a(f5049a, String.valueOf(iNextInt) + ":\tresponse: " + ats.f5055a + strM5437a);
                if (strM5437a == null) {
                    return null;
                }
                return new JSONObject(strM5437a);
            }
            atj.m5427c(f5049a, String.valueOf(iNextInt) + ":\tFailed to send message. StatusCode = " + httpResponseExecute.getStatusLine().getStatusCode() + ats.f5055a + str);
            return null;
        } catch (ClientProtocolException e) {
            atj.m5428c(f5049a, String.valueOf(iNextInt) + ":\tClientProtocolException,Failed to send message." + str, e);
            return null;
        } catch (IOException e2) {
            atj.m5428c(f5049a, String.valueOf(iNextInt) + ":\tIOException,Failed to send message." + str, e2);
            return null;
        } catch (JSONException e3) {
            atj.m5428c(f5049a, String.valueOf(iNextInt) + ":\tIOException,Failed to send message." + str, e3);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private static String m5437a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 8192);
        StringBuilder sb = new StringBuilder();
        while (true) {
            try {
                try {
                    try {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(String.valueOf(line) + "\n");
                        } else {
                            return sb.toString();
                        }
                    } catch (IOException e) {
                        atj.m5426b(f5049a, "Caught IOException in convertStreamToString()", e);
                        return null;
                    }
                } finally {
                    inputStream.close();
                }
            } catch (IOException e2) {
                atj.m5426b(f5049a, "Caught IOException in convertStreamToString()", e2);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private JSONObject m5438a(String str) {
        InputStream inflaterInputStream;
        int iNextInt = new Random().nextInt(1000);
        try {
            String property = System.getProperty("line.separator");
            if (str.length() <= 1) {
                atj.m5425b(f5049a, String.valueOf(iNextInt) + ":\tInvalid baseUrl.");
                return null;
            }
            atj.m5423a(f5049a, String.valueOf(iNextInt) + ":\tget: " + str);
            HttpGet httpGet = new HttpGet(str);
            if (this.f5050b != null && this.f5050b.size() > 0) {
                for (String str2 : this.f5050b.keySet()) {
                    httpGet.addHeader(str2, this.f5050b.get(str2));
                }
            }
            HttpResponse httpResponseExecute = new DefaultHttpClient(m5440b()).execute(httpGet);
            if (httpResponseExecute.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = httpResponseExecute.getEntity();
                if (entity != null) {
                    InputStream content = entity.getContent();
                    Header firstHeader = httpResponseExecute.getFirstHeader("Content-Encoding");
                    if (firstHeader != null && firstHeader.getValue().equalsIgnoreCase("gzip")) {
                        atj.m5423a(f5049a, String.valueOf(iNextInt) + "  Use GZIPInputStream get data....");
                        inflaterInputStream = new GZIPInputStream(content);
                    } else if (firstHeader == null || !firstHeader.getValue().equalsIgnoreCase("deflate")) {
                        inflaterInputStream = content;
                    } else {
                        atj.m5423a(f5049a, String.valueOf(iNextInt) + "  Use InflaterInputStream get data....");
                        inflaterInputStream = new InflaterInputStream(content);
                    }
                    String strM5437a = m5437a(inflaterInputStream);
                    atj.m5423a(f5049a, String.valueOf(iNextInt) + ":\tresponse: " + property + strM5437a);
                    if (strM5437a == null) {
                        return null;
                    }
                    return new JSONObject(strM5437a);
                }
            } else {
                atj.m5427c(f5049a, String.valueOf(iNextInt) + ":\tFailed to send message. StatusCode = " + httpResponseExecute.getStatusLine().getStatusCode() + ats.f5055a + str);
            }
            return null;
        } catch (ClientProtocolException e) {
            atj.m5428c(f5049a, String.valueOf(iNextInt) + ":\tClientProtocolException,Failed to send message." + str, e);
            return null;
        } catch (Exception e2) {
            atj.m5428c(f5049a, String.valueOf(iNextInt) + ":\tIOException,Failed to send message." + str, e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    private HttpParams m5440b() {
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 20000);
        HttpProtocolParams.setUserAgent(basicHttpParams, System.getProperty("http.agent"));
        return basicHttpParams;
    }

    /* JADX INFO: renamed from: b */
    private void m5441b(String str) {
        if (ats.m5474d(str) || !(atm.f5052b.equals(str.trim()) ^ atm.f5051a.equals(str.trim()))) {
            throw new RuntimeException("验证请求方式失败[" + str + "]");
        }
    }
}
