package p000;

import android.content.Context;
import android.os.Build;
import com.squareup.wire.Wire;
import com.umeng.message.MsgConstant;
import com.umeng.message.MsgLogStore;
import com.umeng.message.PushAgent;
import com.umeng.message.protobuffer.PushRequest;
import com.umeng.message.protobuffer.PushResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import okio.ByteString;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class aio {

    /* JADX INFO: renamed from: f */
    private static final String f1187f = "aio";

    /* JADX INFO: renamed from: b */
    private String f1189b;

    /* JADX INFO: renamed from: e */
    private Context f1192e;

    /* JADX INFO: renamed from: a */
    private final int f1188a = 1;

    /* JADX INFO: renamed from: c */
    private String f1190c = "10.0.0.172";

    /* JADX INFO: renamed from: d */
    private int f1191d = 80;

    public aio(Context context) {
        this.f1192e = context;
        this.f1189b = m1361a(context);
    }

    /* JADX INFO: renamed from: a */
    public PushResponse m1363a(byte[] bArr, String str) {
        byte[] bArrM1362b = m1362b(bArr, str);
        if (bArrM1362b == null) {
            return null;
        }
        return m1360a(bArrM1362b);
    }

    /* JADX INFO: renamed from: b */
    private byte[] m1362b(byte[] bArr, String str) {
        HttpPost httpPost = new HttpPost(str);
        BasicHttpParams basicHttpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(basicHttpParams, 10000);
        HttpConnectionParams.setSoTimeout(basicHttpParams, 30000);
        DefaultHttpClient defaultHttpClient = new DefaultHttpClient(basicHttpParams);
        httpPost.addHeader("Msg-Type", "envelope");
        try {
            httpPost.setEntity(new InputStreamEntity(new ByteArrayInputStream(bArr), bArr.length));
            HttpResponse httpResponseExecute = defaultHttpClient.execute(httpPost);
            int statusCode = httpResponseExecute.getStatusLine().getStatusCode();
            ahb.m1039a(f1187f, "status code : " + statusCode);
            ahb.m1039a(f1187f, "Sent message to " + str);
            HttpEntity entity = httpResponseExecute.getEntity();
            if (entity == null) {
                return null;
            }
            InputStream content = entity.getContent();
            try {
                return ail.m1345a(content);
            } finally {
                ail.m1347b(content);
            }
        } catch (ClientProtocolException e) {
            ahb.m1042b(f1187f, "ClientProtocolException,Failed to send message.", e);
            return null;
        } catch (IOException e2) {
            ahb.m1042b(f1187f, "IOException,Failed to send message.", e2);
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    private String m1361a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MsgConstant.SDK_VERSION);
        stringBuffer.append("/");
        stringBuffer.append(MsgConstant.SDK_VERSION);
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(ahc.m1063n(context));
            stringBuffer2.append("/");
            stringBuffer2.append(ahc.m1050b(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(Build.VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(ail.m1340a(PushAgent.getInstance(context).getMessageAppkey()));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    private PushResponse m1360a(byte[] bArr) {
        PushResponse pushResponse;
        try {
            pushResponse = (PushResponse) new Wire((Class<?>[]) new Class[0]).parseFrom(bArr, PushResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
            pushResponse = null;
        }
        if (pushResponse != null) {
            ahb.m1039a(f1187f, "NetWork Response code:" + pushResponse.code + ",msg:" + pushResponse.description + ",info:" + pushResponse.info);
        }
        return pushResponse;
    }

    /* JADX INFO: renamed from: a */
    public byte[] m1364a(JSONObject jSONObject) {
        int msgConfigInfo_SerialNo;
        String strM1317a;
        try {
            msgConfigInfo_SerialNo = MsgLogStore.getInstance(this.f1192e).getMsgConfigInfo_SerialNo();
        } catch (Exception e) {
            e.printStackTrace();
            ahb.m1043c(f1187f, e.toString());
            msgConfigInfo_SerialNo = 1;
        }
        String messageAppkey = PushAgent.getInstance(this.f1192e).getMessageAppkey();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        ByteString byteStringM10879of = null;
        try {
            strM1317a = aii.m1317a(jSONObject.toString(), "utf-8", messageAppkey.substring(0, 16));
        } catch (JSONException e2) {
            e = e2;
            strM1317a = null;
        } catch (Exception e3) {
            e = e3;
            strM1317a = null;
        }
        try {
            byteStringM10879of = ByteString.m10879of(strM1317a.getBytes(), 0, strM1317a.getBytes().length);
        } catch (JSONException e4) {
            e = e4;
            e.printStackTrace();
        } catch (Exception e5) {
            e = e5;
            e.printStackTrace();
        }
        String strM1340a = ail.m1340a(strM1317a);
        String strM1340a2 = ail.m1340a(messageAppkey + iCurrentTimeMillis + ail.m1340a(strM1317a));
        ahb.m1043c(f1187f, "request = " + jSONObject + "\n mTimestamp = " + iCurrentTimeMillis + ",checkSum = " + strM1340a + ", salt = " + strM1340a2 + ",serialNo = " + msgConfigInfo_SerialNo);
        try {
            MsgLogStore.getInstance(this.f1192e).setMsgConfigInfo_SerialNo(msgConfigInfo_SerialNo + 1);
        } catch (Exception e6) {
            e6.printStackTrace();
            ahb.m1043c(f1187f, e6.toString());
        }
        return new PushRequest.Builder().version("1.0").serialNo(Integer.valueOf(msgConfigInfo_SerialNo)).signature(messageAppkey).timestamp(Integer.valueOf(iCurrentTimeMillis)).encryption(PushRequest.entityEncodingFormat.JSON_AES).entity(byteStringM10879of).checksum(strM1340a).salt(strM1340a2).build().toByteArray();
    }
}
