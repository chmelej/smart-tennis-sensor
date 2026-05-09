package com.mob.tools.network;

import android.content.Context;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import com.lidroid.xutils.http.client.multipart.MIME;
import com.lidroid.xutils.http.client.util.URLEncodedUtils;
import com.mob.tools.MobLog;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ReflectHelper;
import com.mob.tools.utils.ResHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;

/* JADX INFO: loaded from: classes.dex */
public class NetworkHelper {
    public static int connectionTimeout;
    public static int readTimout;

    public static class NetworkTimeOut {
        public int connectionTimeout;
        public int readTimout;
    }

    public String httpGet(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpGet: " + str, new Object[0]);
        if (arrayList != null) {
            String strKvPairsToUrl = kvPairsToUrl(arrayList);
            if (strKvPairsToUrl.length() > 0) {
                str = str + "?" + strKvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList2 != null) {
            for (KVPair<String> kVPair : arrayList2) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(line);
            }
            bufferedReader.close();
            connection.disconnect();
            String string = sb.toString();
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return string;
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
            if (sb2.length() > 0) {
                sb2.append('\n');
            }
            sb2.append(line2);
        }
        bufferedReader2.close();
        connection.disconnect();
        HashMap map = new HashMap();
        map.put("error", sb2.toString());
        map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(map));
    }

    public String downloadCache(Context context, String str, String str2, boolean z, NetworkTimeOut networkTimeOut) throws Throwable {
        String string;
        String strMD5;
        List<String> list;
        int iLastIndexOf;
        List<String> list2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("downloading: " + str, new Object[0]);
        if (z) {
            File file = new File(ResHelper.getCachePath(context, str2), Data.MD5(str));
            if (z && file.exists()) {
                MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                return file.getAbsolutePath();
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            Map<String, List<String>> headerFields = connection.getHeaderFields();
            if (headerFields == null || (list2 = headerFields.get(MIME.CONTENT_DISPOSITION)) == null || list2.size() <= 0) {
                string = null;
            } else {
                string = null;
                for (String str3 : list2.get(0).split(";")) {
                    if (str3.trim().startsWith("filename")) {
                        String str4 = str3.split("=")[1];
                        string = (str4.startsWith("\"") && str4.endsWith("\"")) ? str4.substring(1, str4.length() - 1) : str4;
                    }
                }
            }
            if (string == null) {
                strMD5 = Data.MD5(str);
                if (headerFields != null && (list = headerFields.get(MIME.CONTENT_TYPE)) != null && list.size() > 0) {
                    String str5 = list.get(0);
                    String strTrim = str5 == null ? "" : str5.trim();
                    if (strTrim.startsWith("image/")) {
                        String strSubstring = strTrim.substring("image/".length());
                        StringBuilder sb = new StringBuilder();
                        sb.append(strMD5);
                        sb.append(".");
                        if ("jpeg".equals(strSubstring)) {
                            strSubstring = "jpg";
                        }
                        sb.append(strSubstring);
                        string = sb.toString();
                    } else {
                        int iLastIndexOf2 = str.lastIndexOf(47);
                        String strSubstring2 = iLastIndexOf2 > 0 ? str.substring(iLastIndexOf2 + 1) : null;
                        if (strSubstring2 != null && strSubstring2.length() > 0 && (iLastIndexOf = strSubstring2.lastIndexOf(46)) > 0 && strSubstring2.length() - iLastIndexOf < 10) {
                            string = strMD5 + strSubstring2.substring(iLastIndexOf);
                        }
                    }
                    strMD5 = string;
                }
            } else {
                strMD5 = string;
            }
            File file2 = new File(ResHelper.getCachePath(context, str2), strMD5);
            if (z && file2.exists()) {
                connection.disconnect();
                MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                return file2.getAbsolutePath();
            }
            if (!file2.getParentFile().exists()) {
                file2.getParentFile().mkdirs();
            }
            if (file2.exists()) {
                file2.delete();
            }
            try {
                InputStream inputStream = connection.getInputStream();
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                byte[] bArr = new byte[1024];
                for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
                    fileOutputStream.write(bArr, 0, i);
                }
                fileOutputStream.flush();
                inputStream.close();
                fileOutputStream.close();
                connection.disconnect();
                MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
                return file2.getAbsolutePath();
            } finally {
            }
        } else {
            StringBuilder sb2 = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if (sb2.length() > 0) {
                    sb2.append('\n');
                }
                sb2.append(line);
            }
            bufferedReader.close();
            connection.disconnect();
            HashMap map = new HashMap();
            map.put("error", sb2.toString());
            map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
            throw new Throwable(new Hashon().fromHashMap(map));
        }
    }

    public void rawGet(String str, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, (ArrayList<KVPair<String>>) null, rawNetworkCallback, networkTimeOut);
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            for (KVPair<String> kVPair : arrayList) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        connection.connect();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                rawNetworkCallback.onResponse(connection.getInputStream());
            }
            connection.disconnect();
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(line);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap map = new HashMap();
        map.put("error", sb.toString());
        map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(map));
    }

    public void rawGet(String str, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        rawGet(str, (ArrayList<KVPair<String>>) null, httpResponseCallback, networkTimeOut);
    }

    public void rawGet(String str, ArrayList<KVPair<String>> arrayList, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("rawGet: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        if (arrayList != null) {
            for (KVPair<String> kVPair : arrayList) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        connection.connect();
        try {
            if (httpResponseCallback != null) {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            }
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        } finally {
            connection.disconnect();
        }
    }

    public String jsonPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("jsonPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestProperty("content-type", "application/json");
        if (arrayList2 != null) {
            for (KVPair<String> kVPair : arrayList2) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            HashMap map = new HashMap();
            for (KVPair<String> kVPair2 : arrayList) {
                map.put(kVPair2.name, kVPair2.value);
            }
            stringPart.append(new Hashon().fromHashMap(map));
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = stringPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200 || responseCode == 201) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(line);
            }
            bufferedReader.close();
            connection.disconnect();
            String string = sb.toString();
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return string;
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
            if (sb2.length() > 0) {
                sb2.append('\n');
            }
            sb2.append(line2);
        }
        bufferedReader2.close();
        connection.disconnect();
        HashMap map2 = new HashMap();
        map2.put("error", sb2.toString());
        map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(map2));
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) {
        return httpPost(str, arrayList, kVPair, arrayList2, 0, networkTimeOut);
    }

    public String httpPost(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, int i, NetworkTimeOut networkTimeOut) {
        ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
        if (kVPair != null && kVPair.value != null && new File(kVPair.value).exists()) {
            arrayList3.add(kVPair);
        }
        return httpPostFiles(str, arrayList, arrayList3, arrayList2, i, networkTimeOut);
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, NetworkTimeOut networkTimeOut) {
        return httpPostFiles(str, arrayList, arrayList2, arrayList3, 0, networkTimeOut);
    }

    public String httpPostFiles(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, NetworkTimeOut networkTimeOut) throws Throwable {
        final HashMap map = new HashMap();
        httpPost(str, arrayList, arrayList2, arrayList3, i, new HttpResponseCallback() { // from class: com.mob.tools.network.NetworkHelper.1
            @Override // com.mob.tools.network.HttpResponseCallback
            public void onResponse(HttpConnection httpConnection) throws Throwable {
                int responseCode = httpConnection.getResponseCode();
                if (responseCode == 200 || responseCode == 201) {
                    StringBuilder sb = new StringBuilder();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConnection.getInputStream(), Charset.forName("utf-8")));
                    for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                        if (sb.length() > 0) {
                            sb.append('\n');
                        }
                        sb.append(line);
                    }
                    bufferedReader.close();
                    map.put("resp", sb.toString());
                    return;
                }
                StringBuilder sb2 = new StringBuilder();
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(httpConnection.getErrorStream(), Charset.forName("utf-8")));
                for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
                    if (sb2.length() > 0) {
                        sb2.append('\n');
                    }
                    sb2.append(line2);
                }
                bufferedReader2.close();
                HashMap map2 = new HashMap();
                map2.put("error", sb2.toString());
                map2.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
                throw new Throwable(new Hashon().fromHashMap(map2));
            }
        }, networkTimeOut);
        return (String) map.get("resp");
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        httpPost(str, arrayList, arrayList2, arrayList3, 0, httpResponseCallback, networkTimeOut);
    }

    public void httpPost(String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2, ArrayList<KVPair<String>> arrayList3, int i, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        if (arrayList2 != null && arrayList2.size() > 0) {
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList2);
            if (i >= 0) {
                connection.setChunkedStreamingMode(i);
            }
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
            connection.setFixedLengthStreamingMode((int) textPostHTTPPart.length());
        }
        if (arrayList3 != null) {
            for (KVPair<String> kVPair : arrayList3) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = textPostHTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i2 = inputStream.read(bArr); i2 > 0; i2 = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i2);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        try {
            if (httpResponseCallback != null) {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            }
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        } finally {
            connection.disconnect();
        }
    }

    private HTTPPart getFilePostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList, ArrayList<KVPair<String>> arrayList2) throws IOException {
        String string = UUID.randomUUID().toString();
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, "multipart/form-data; boundary=" + string);
        MultiPart multiPart = new MultiPart();
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            for (KVPair<String> kVPair : arrayList) {
                stringPart.append("--").append(string).append("\r\n");
                stringPart.append("Content-Disposition: form-data; name=\"").append(kVPair.name).append("\"\r\n\r\n");
                stringPart.append(kVPair.value).append("\r\n");
            }
        }
        multiPart.append(stringPart);
        for (KVPair<String> kVPair2 : arrayList2) {
            StringPart stringPart2 = new StringPart();
            File file = new File(kVPair2.value);
            stringPart2.append("--").append(string).append("\r\n");
            stringPart2.append("Content-Disposition: form-data; name=\"").append(kVPair2.name).append("\"; filename=\"").append(file.getName()).append("\"\r\n");
            String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(kVPair2.value);
            if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                if (kVPair2.value.toLowerCase().endsWith("jpg") || kVPair2.value.toLowerCase().endsWith("jpeg")) {
                    contentTypeFor = "image/jpeg";
                } else if (kVPair2.value.toLowerCase().endsWith("png")) {
                    contentTypeFor = "image/png";
                } else if (kVPair2.value.toLowerCase().endsWith("gif")) {
                    contentTypeFor = "image/gif";
                } else {
                    FileInputStream fileInputStream = new FileInputStream(kVPair2.value);
                    String strGuessContentTypeFromStream = URLConnection.guessContentTypeFromStream(fileInputStream);
                    fileInputStream.close();
                    contentTypeFor = (strGuessContentTypeFromStream == null || strGuessContentTypeFromStream.length() <= 0) ? "application/octet-stream" : strGuessContentTypeFromStream;
                }
            }
            stringPart2.append("Content-Type: ").append(contentTypeFor).append("\r\n\r\n");
            multiPart.append(stringPart2);
            FilePart filePart = new FilePart();
            filePart.setFile(kVPair2.value);
            multiPart.append(filePart);
            StringPart stringPart3 = new StringPart();
            stringPart3.append("\r\n");
            multiPart.append(stringPart3);
        }
        StringPart stringPart4 = new StringPart();
        stringPart4.append("--").append(string).append("--\r\n");
        multiPart.append(stringPart4);
        return multiPart;
    }

    private HTTPPart getTextPostHTTPPart(HttpURLConnection httpURLConnection, String str, ArrayList<KVPair<String>> arrayList) {
        httpURLConnection.setRequestProperty(MIME.CONTENT_TYPE, URLEncodedUtils.CONTENT_TYPE);
        StringPart stringPart = new StringPart();
        if (arrayList != null) {
            stringPart.append(kvPairsToUrl(arrayList));
        }
        return stringPart;
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, RawNetworkCallback rawNetworkCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("rawpost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            for (KVPair<String> kVPair : arrayList) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = hTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200) {
            if (rawNetworkCallback != null) {
                InputStream inputStream2 = connection.getInputStream();
                try {
                    rawNetworkCallback.onResponse(inputStream2);
                } finally {
                    if (inputStream2 != null) {
                        try {
                            inputStream2.close();
                        } catch (Throwable unused) {
                        }
                    }
                    connection.disconnect();
                }
            } else {
                connection.disconnect();
            }
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return;
        }
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
            if (sb.length() > 0) {
                sb.append('\n');
            }
            sb.append(line);
        }
        bufferedReader.close();
        connection.disconnect();
        HashMap map = new HashMap();
        map.put("error", sb.toString());
        map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(map));
    }

    public void rawPost(String str, ArrayList<KVPair<String>> arrayList, HTTPPart hTTPPart, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("rawpost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (arrayList != null) {
            for (KVPair<String> kVPair : arrayList) {
                connection.setRequestProperty(kVPair.name, kVPair.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = hTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
                connection.disconnect();
            }
        }
        MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
    }

    public void getHttpPostResponse(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        HTTPPart textPostHTTPPart;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpPost: " + str, new Object[0]);
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        if (kVPair != null && kVPair.value != null && new File(kVPair.value).exists()) {
            ArrayList<KVPair<String>> arrayList3 = new ArrayList<>();
            arrayList3.add(kVPair);
            textPostHTTPPart = getFilePostHTTPPart(connection, str, arrayList, arrayList3);
        } else {
            textPostHTTPPart = getTextPostHTTPPart(connection, str, arrayList);
        }
        if (arrayList2 != null) {
            for (KVPair<String> kVPair2 : arrayList2) {
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        InputStream inputStream = textPostHTTPPart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        try {
            if (httpResponseCallback != null) {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            }
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        } finally {
            connection.disconnect();
        }
    }

    public String httpPut(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpPut: " + str, new Object[0]);
        if (arrayList != null) {
            String strKvPairsToUrl = kvPairsToUrl(arrayList);
            if (strKvPairsToUrl.length() > 0) {
                str = str + "?" + strKvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod("PUT");
        connection.setRequestProperty(MIME.CONTENT_TYPE, "application/octet-stream");
        if (arrayList2 != null) {
            for (KVPair<String> kVPair2 : arrayList2) {
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        filePart.setFile(kVPair.value);
        InputStream inputStream = filePart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        int responseCode = connection.getResponseCode();
        if (responseCode == 200 || responseCode == 201) {
            StringBuilder sb = new StringBuilder();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream(), Charset.forName("utf-8")));
            for (String line = bufferedReader.readLine(); line != null; line = bufferedReader.readLine()) {
                if (sb.length() > 0) {
                    sb.append('\n');
                }
                sb.append(line);
            }
            bufferedReader.close();
            connection.disconnect();
            String string = sb.toString();
            MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return string;
        }
        StringBuilder sb2 = new StringBuilder();
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(connection.getErrorStream(), Charset.forName("utf-8")));
        for (String line2 = bufferedReader2.readLine(); line2 != null; line2 = bufferedReader2.readLine()) {
            if (sb2.length() > 0) {
                sb2.append('\n');
            }
            sb2.append(line2);
        }
        bufferedReader2.close();
        HashMap map = new HashMap();
        map.put("error", sb2.toString());
        map.put(NotificationCompat.CATEGORY_STATUS, Integer.valueOf(responseCode));
        throw new Throwable(new Hashon().fromHashMap(map));
    }

    public ArrayList<KVPair<String[]>> httpHead(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, ArrayList<KVPair<String>> arrayList2, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpHead: " + str, new Object[0]);
        if (arrayList != null) {
            String strKvPairsToUrl = kvPairsToUrl(arrayList);
            if (strKvPairsToUrl.length() > 0) {
                str = str + "?" + strKvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setRequestMethod("HEAD");
        if (arrayList2 != null) {
            for (KVPair<String> kVPair2 : arrayList2) {
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.connect();
        Map<String, List<String>> headerFields = connection.getHeaderFields();
        ArrayList<KVPair<String[]>> arrayList3 = new ArrayList<>();
        if (headerFields != null) {
            for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
                List<String> value = entry.getValue();
                if (value == null) {
                    arrayList3.add(new KVPair<>(entry.getKey(), new String[0]));
                } else {
                    String[] strArr = new String[value.size()];
                    for (int i = 0; i < strArr.length; i++) {
                        strArr[i] = value.get(i);
                    }
                    arrayList3.add(new KVPair<>(entry.getKey(), strArr));
                }
            }
        }
        connection.disconnect();
        MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        return arrayList3;
    }

    public void httpPatch(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        if (Build.VERSION.SDK_INT >= 23) {
            httpPatchImpl23(str, arrayList, kVPair, j, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        } else {
            httpPatchImpl(str, arrayList, kVPair, j, arrayList2, onReadListener, httpResponseCallback, networkTimeOut);
        }
    }

    private void httpPatchImpl(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws NoSuchAlgorithmException, IOException, KeyStoreException, CertificateException {
        DefaultHttpClient defaultHttpClient;
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpPatch: " + str, new Object[0]);
        if (arrayList != null) {
            String strKvPairsToUrl = kvPairsToUrl(arrayList);
            if (strKvPairsToUrl.length() > 0) {
                str = str + "?" + strKvPairsToUrl;
            }
        }
        HttpPatch httpPatch = new HttpPatch(str);
        if (arrayList2 != null) {
            for (KVPair<String> kVPair2 : arrayList2) {
                httpPatch.setHeader(kVPair2.name, kVPair2.value);
            }
        }
        FilePart filePart = new FilePart();
        filePart.setOnReadListener(onReadListener);
        filePart.setFile(kVPair.value);
        filePart.setOffset(j);
        InputStreamEntity inputStreamEntity = new InputStreamEntity(filePart.toInputStream(), filePart.length() - j);
        inputStreamEntity.setContentEncoding("application/offset+octet-stream");
        httpPatch.setEntity(inputStreamEntity);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        int i = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i > 0) {
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, i);
        }
        int i2 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i2 > 0) {
            HttpConnectionParams.setSoTimeout(basicHttpParams, i2);
        }
        httpPatch.setParams(basicHttpParams);
        if (str.startsWith("https://")) {
            KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
            keyStore.load(null, null);
            SSLSocketFactoryEx sSLSocketFactoryEx = new SSLSocketFactoryEx(keyStore);
            sSLSocketFactoryEx.setHostnameVerifier(SSLSocketFactory.STRICT_HOSTNAME_VERIFIER);
            BasicHttpParams basicHttpParams2 = new BasicHttpParams();
            HttpProtocolParams.setVersion(basicHttpParams2, HttpVersion.HTTP_1_1);
            HttpProtocolParams.setContentCharset(basicHttpParams2, "UTF-8");
            SchemeRegistry schemeRegistry = new SchemeRegistry();
            schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
            schemeRegistry.register(new Scheme("https", sSLSocketFactoryEx, 443));
            defaultHttpClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basicHttpParams2, schemeRegistry), basicHttpParams2);
        } else {
            defaultHttpClient = new DefaultHttpClient();
        }
        HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPatch);
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl(httpResponseExecute));
                defaultHttpClient.getConnectionManager().shutdown();
            } finally {
                defaultHttpClient.getConnectionManager().shutdown();
            }
        }
        MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
    }

    public void httpPatchImpl23(String str, ArrayList<KVPair<String>> arrayList, KVPair<String> kVPair, long j, ArrayList<KVPair<String>> arrayList2, OnReadListener onReadListener, HttpResponseCallback httpResponseCallback, NetworkTimeOut networkTimeOut) throws Throwable {
        long jCurrentTimeMillis = System.currentTimeMillis();
        MobLog.getInstance().m8615i("httpPatch: " + str, new Object[0]);
        if (arrayList != null) {
            String strKvPairsToUrl = kvPairsToUrl(arrayList);
            if (strKvPairsToUrl.length() > 0) {
                str = str + "?" + strKvPairsToUrl;
            }
        }
        HttpURLConnection connection = getConnection(str, networkTimeOut);
        connection.setDoOutput(true);
        connection.setChunkedStreamingMode(0);
        connection.setRequestMethod(HttpPatch.METHOD_NAME);
        connection.setRequestProperty(MIME.CONTENT_TYPE, "application/offset+octet-stream");
        if (arrayList2 != null) {
            for (KVPair<String> kVPair2 : arrayList2) {
                connection.setRequestProperty(kVPair2.name, kVPair2.value);
            }
        }
        connection.connect();
        OutputStream outputStream = connection.getOutputStream();
        FilePart filePart = new FilePart();
        filePart.setOnReadListener(onReadListener);
        filePart.setFile(kVPair.value);
        filePart.setOffset(j);
        InputStream inputStream = filePart.toInputStream();
        byte[] bArr = new byte[65536];
        for (int i = inputStream.read(bArr); i > 0; i = inputStream.read(bArr)) {
            outputStream.write(bArr, 0, i);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();
        if (httpResponseCallback != null) {
            try {
                httpResponseCallback.onResponse(new HttpConnectionImpl23(connection));
                connection.disconnect();
            } finally {
                connection.disconnect();
            }
        }
        MobLog.getInstance().m8615i("use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
    }

    private String kvPairsToUrl(ArrayList<KVPair<String>> arrayList) throws UnsupportedEncodingException {
        StringBuilder sb = new StringBuilder();
        for (KVPair<String> kVPair : arrayList) {
            String strUrlEncode = Data.urlEncode(kVPair.name, "utf-8");
            String strUrlEncode2 = kVPair.value != null ? Data.urlEncode(kVPair.value, "utf-8") : "";
            if (sb.length() > 0) {
                sb.append('&');
            }
            sb.append(strUrlEncode);
            sb.append('=');
            sb.append(strUrlEncode2);
        }
        return sb.toString();
    }

    private HttpURLConnection getConnection(String str, NetworkTimeOut networkTimeOut) throws Throwable {
        Object staticField;
        String str2;
        boolean z;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            staticField = ReflectHelper.getInstanceField(httpURLConnection, "methodTokens");
        } catch (Throwable unused) {
            staticField = null;
        }
        if (staticField == null) {
            try {
                staticField = ReflectHelper.getStaticField("HttpURLConnection", "PERMITTED_USER_METHODS");
            } catch (Throwable unused2) {
            }
            str2 = "PERMITTED_USER_METHODS";
            z = true;
        } else {
            str2 = "methodTokens";
            z = false;
        }
        if (staticField != null) {
            String[] strArr = (String[]) staticField;
            String[] strArr2 = new String[strArr.length + 1];
            System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
            strArr2[strArr.length] = HttpPatch.METHOD_NAME;
            if (z) {
                ReflectHelper.setStaticField("HttpURLConnection", str2, strArr2);
            } else {
                ReflectHelper.setInstanceField(httpURLConnection, str2, strArr2);
            }
        }
        if (Build.VERSION.SDK_INT < 8) {
            System.setProperty("http.keepAlive", "false");
        }
        if (httpURLConnection instanceof HttpsURLConnection) {
            X509HostnameVerifier x509HostnameVerifier = SSLSocketFactory.STRICT_HOSTNAME_VERIFIER;
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            SSLContext sSLContext = SSLContext.getInstance("TLS");
            sSLContext.init(null, new TrustManager[]{new SimpleX509TrustManager(null)}, new SecureRandom());
            httpsURLConnection.setSSLSocketFactory(sSLContext.getSocketFactory());
            httpsURLConnection.setHostnameVerifier(x509HostnameVerifier);
        }
        int i = networkTimeOut == null ? connectionTimeout : networkTimeOut.connectionTimeout;
        if (i > 0) {
            httpURLConnection.setConnectTimeout(i);
        }
        int i2 = networkTimeOut == null ? readTimout : networkTimeOut.readTimout;
        if (i2 > 0) {
            httpURLConnection.setReadTimeout(i2);
        }
        return httpURLConnection;
    }

    public static final class SimpleX509TrustManager implements X509TrustManager {
        private X509TrustManager standardTrustManager;

        @Override // javax.net.ssl.X509TrustManager
        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public SimpleX509TrustManager(KeyStore keyStore) {
            try {
                TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
                trustManagerFactory.init(keyStore);
                TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
                if (trustManagers != null && trustManagers.length != 0) {
                    this.standardTrustManager = (X509TrustManager) trustManagers[0];
                    return;
                }
                throw new NoSuchAlgorithmException("no trust manager found.");
            } catch (Exception e) {
                MobLog.getInstance().m8609d("failed to initialize the standard trust manager: " + e.getMessage(), new Object[0]);
                this.standardTrustManager = null;
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
            if (x509CertificateArr == null) {
                throw new IllegalArgumentException("there were no certificates.");
            }
            if (x509CertificateArr.length == 1) {
                x509CertificateArr[0].checkValidity();
            } else {
                if (this.standardTrustManager != null) {
                    this.standardTrustManager.checkServerTrusted(x509CertificateArr, str);
                    return;
                }
                throw new CertificateException("there were one more certificates but no trust manager found.");
            }
        }

        @Override // javax.net.ssl.X509TrustManager
        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }
}
