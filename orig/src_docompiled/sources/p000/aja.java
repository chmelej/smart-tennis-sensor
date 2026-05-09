package p000;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.UTrack;
import com.umeng.message.protobuffer.PushResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: TagManager.java */
/* JADX INFO: loaded from: classes.dex */
public class aja {

    /* JADX INFO: renamed from: a */
    private static final String f1226a = "aja";

    /* JADX INFO: renamed from: b */
    private static aja f1227b;

    /* JADX INFO: renamed from: c */
    private Context f1228c;

    private aja(Context context) {
        this.f1228c = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized aja m1466a(Context context) {
        if (f1227b == null) {
            f1227b = new aja(context.getApplicationContext());
        }
        return f1227b;
    }

    /* JADX INFO: renamed from: a */
    public C0150a m1472a(String... strArr) throws Exception {
        if (m1470c()) {
            throw new Exception("Tag API is disabled by the server.");
        }
        if (!m1469b()) {
            throw new Exception("No utdid or device_token");
        }
        if (strArr == null || strArr.length == 0) {
            throw new Exception("No tags");
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (!MessageSharedPrefs.getInstance(this.f1228c).isTagSet(str) && !arrayList.contains(str)) {
                arrayList.add(str);
            }
        }
        if (arrayList.size() == 0) {
            return m1471d();
        }
        JSONObject jSONObjectM1468a = m1468a();
        jSONObjectM1468a.put(MsgConstant.KEY_TAGS, m1467a(arrayList));
        aio aioVar = new aio(this.f1228c);
        PushResponse pushResponseM1363a = aioVar.m1363a(aioVar.m1364a(jSONObjectM1468a), MsgConstant.TAG_ENDPOINT + "/add");
        C0150a c0150a = new C0150a(pushResponseM1363a);
        if (pushResponseM1363a != null) {
            ahb.m1043c(f1226a, "addTags: " + pushResponseM1363a.code + ", " + pushResponseM1363a.description);
        }
        if (pushResponseM1363a != null && pushResponseM1363a.code.equals(PushResponse.responseCode.SUCCESS)) {
            MessageSharedPrefs.getInstance(this.f1228c).addTags(strArr);
            MessageSharedPrefs.getInstance(this.f1228c).setTagRemain(c0150a.f1230b);
        }
        return c0150a;
    }

    /* JADX INFO: renamed from: a */
    private static String m1467a(List<String> list) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            sb.append(",");
        }
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ',') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: a */
    private JSONObject m1468a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MsgConstant.KEY_HEADER, UTrack.getInstance(this.f1228c).getHeader());
        jSONObject.put(MsgConstant.KEY_UTDID, ahc.m1064o(this.f1228c));
        jSONObject.put(MsgConstant.KEY_DEVICE_TOKEN, MessageSharedPrefs.getInstance(this.f1228c).getDeviceToken());
        jSONObject.put(MsgConstant.KEY_TS, System.currentTimeMillis());
        return jSONObject;
    }

    /* JADX INFO: renamed from: aja$a */
    /* JADX INFO: compiled from: TagManager.java */
    public static class C0150a {

        /* JADX INFO: renamed from: a */
        public String f1229a;

        /* JADX INFO: renamed from: b */
        public int f1230b;

        /* JADX INFO: renamed from: c */
        public String f1231c;

        /* JADX INFO: renamed from: d */
        public String f1232d;

        public C0150a(JSONObject jSONObject) {
            this.f1229a = jSONObject.optString("success", "fail");
            this.f1230b = jSONObject.optInt("remain", 0);
            this.f1231c = jSONObject.optString("errors");
            this.f1232d = jSONObject.toString();
        }

        public C0150a(PushResponse pushResponse) {
            if (pushResponse.code.equals(PushResponse.responseCode.SUCCESS)) {
                this.f1229a = "success";
            } else if (pushResponse.code.equals(PushResponse.responseCode.INVALID_REQUEST)) {
                this.f1229a = "invalid_request";
            } else if (pushResponse.code.equals(PushResponse.responseCode.SERVER_EXCEPTION)) {
                this.f1229a = "server_exception";
            }
            if (pushResponse.info != null) {
                this.f1230b = pushResponse.info.tagRemainCount.intValue();
            }
            this.f1231c = pushResponse.description;
            this.f1232d = "status:" + this.f1229a + ", remain:" + this.f1230b + ",description:" + this.f1231c;
        }

        public String toString() {
            return this.f1232d;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m1469b() {
        if (TextUtils.isEmpty(ahc.m1064o(this.f1228c))) {
            ahb.m1041b(f1226a, "UTDID is empty");
            return false;
        }
        if (!TextUtils.isEmpty(MessageSharedPrefs.getInstance(this.f1228c).getDeviceToken())) {
            return true;
        }
        ahb.m1041b(f1226a, "RegistrationId is empty");
        return false;
    }

    /* JADX INFO: renamed from: c */
    private boolean m1470c() {
        boolean z = MessageSharedPrefs.getInstance(this.f1228c).getTagSendPolicy() == 1;
        if (z) {
            ahb.m1043c(f1226a, "tag is disabled by the server");
        }
        return z;
    }

    /* JADX INFO: renamed from: d */
    private C0150a m1471d() {
        C0150a c0150a = new C0150a(new JSONObject());
        c0150a.f1230b = MessageSharedPrefs.getInstance(this.f1228c).getTagRemain();
        c0150a.f1229a = "ok";
        c0150a.f1232d = "status:" + c0150a.f1229a + ", remain:" + c0150a.f1230b + ",description:" + c0150a.f1229a;
        return c0150a;
    }
}
