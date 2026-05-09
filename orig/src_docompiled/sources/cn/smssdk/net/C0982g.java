package cn.smssdk.net;

import android.content.Context;
import android.text.TextUtils;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import org.litepal.util.Const;

/* JADX INFO: renamed from: cn.smssdk.net.g */
/* JADX INFO: compiled from: ServiceApi.java */
/* JADX INFO: loaded from: classes.dex */
public class C0982g extends AbstractC0976a {

    /* JADX INFO: renamed from: i */
    private long f6142i;

    /* JADX INFO: renamed from: j */
    private int f6143j;

    /* JADX INFO: renamed from: k */
    private int f6144k;

    /* JADX INFO: renamed from: l */
    private long f6145l;

    /* JADX INFO: renamed from: m */
    private ArrayList<String> f6146m;

    /* JADX INFO: renamed from: n */
    private String f6147n;

    /* JADX INFO: renamed from: o */
    private SPHelper f6148o;

    public C0982g(Context context) {
        this.f6148o = SPHelper.getInstance(context);
    }

    /* JADX INFO: renamed from: a */
    public void m6826a(HashMap<String, Object> map) {
        this.f6075b = (String) map.get(Const.TableSchema.COLUMN_NAME);
        if (TextUtils.isEmpty(this.f6075b)) {
            throw new Throwable("GET API NAME ERROR");
        }
        if (this.f6075b.equals("getZoneList")) {
            this.f6074a = 2;
        } else if (this.f6075b.equals("getToken")) {
            this.f6074a = 3;
        } else if (this.f6075b.equals("submitUser")) {
            this.f6074a = 4;
        } else if (this.f6075b.equals("uploadContacts")) {
            this.f6074a = 5;
        } else if (this.f6075b.equals("getFriend")) {
            this.f6074a = 6;
        } else if (this.f6075b.equals("logCollect")) {
            this.f6074a = 7;
        } else if (this.f6075b.equals("logInstall")) {
            this.f6074a = 8;
        } else if (this.f6075b.equals("sendTextSMS")) {
            this.f6074a = 9;
        } else if (this.f6075b.equals("sendVoiceSMS")) {
            this.f6074a = 10;
        } else if (this.f6075b.equals("verifyCode")) {
            this.f6074a = 11;
        } else if (this.f6075b.equals("uploadCollectData")) {
            this.f6074a = 12;
        } else {
            this.f6074a = 0;
        }
        this.f6076c = (String) map.get("url");
        this.f6146m = (ArrayList) map.get("params");
        this.f6147n = (String) map.get("params_chunk");
        if (this.f6146m == null && TextUtils.isEmpty(this.f6147n)) {
            throw new Throwable("GET API PARAMS ERROR");
        }
        String str = (String) map.get("encode");
        if (!TextUtils.isEmpty(str)) {
            if (str.equals("RSA")) {
                this.f6077d = 2;
            } else if (str.equals("AES")) {
                this.f6077d = 1;
            }
        }
        Integer num = (Integer) map.get("zip");
        if (num != null && num.intValue() == 1) {
            this.f6078e = true;
        } else {
            this.f6078e = false;
        }
        Integer num2 = (Integer) map.get("request");
        if (num2 != null && num2.intValue() == 1) {
            this.f6079f = true;
        } else {
            this.f6079f = false;
        }
        try {
            m6823a((String) map.get("frequency"));
        } catch (Throwable unused) {
            this.f6080g = false;
        }
        m6825e();
    }

    /* JADX INFO: renamed from: a */
    private void m6823a(String str) throws Throwable {
        if (str == null || str.length() < 5) {
            this.f6080g = false;
            return;
        }
        int length = str.length();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (str.charAt(i3) != ':') {
                if (i3 == length - 1 && i < 2) {
                    throw new Throwable("parse frequency string ERROR");
                }
            } else if (i == 0) {
                String strSubstring = str.substring(i2, i3);
                if (TextUtils.isDigitsOnly(strSubstring)) {
                    this.f6143j = ResHelper.parseInt(strSubstring);
                    i2 = i3 + 1;
                    i++;
                } else {
                    throw new Throwable("parse frequency string ERROR");
                }
            } else {
                if (i == 1) {
                    if (TextUtils.isDigitsOnly(str.substring(i2, i3))) {
                        this.f6142i = ResHelper.parseInt(r3);
                        i2 = i3 + 1;
                        i++;
                        char cCharAt = str.charAt(i2);
                        if (cCharAt == 's') {
                            this.f6142i *= 1000;
                        } else if (cCharAt == 'm') {
                            this.f6142i *= 60000;
                        } else if (cCharAt == 'h') {
                            this.f6142i *= 3600000;
                        } else if (cCharAt == 'd') {
                            this.f6142i *= 86400000;
                        } else if (cCharAt == 'w') {
                            this.f6142i *= 604800000;
                        } else if (cCharAt == 'M') {
                            this.f6142i *= 2592000000L;
                        } else if (cCharAt == 'y') {
                            this.f6142i = (long) (this.f6142i * 3.1536E10d);
                        } else {
                            throw new Throwable("parse frequency string ERROR");
                        }
                    } else {
                        throw new Throwable("parse frequency string ERROR");
                    }
                }
                if (i3 == length - 1) {
                    continue;
                }
            }
        }
        this.f6080g = true;
    }

    /* JADX INFO: renamed from: c */
    public void m6827c() {
        if (this.f6080g) {
            if (this.f6080g) {
                this.f6144k++;
            }
            m6824d();
        }
    }

    @Override // cn.smssdk.net.AbstractC0976a
    /* JADX INFO: renamed from: b */
    public boolean mo6739b() {
        if (!this.f6079f) {
            return true;
        }
        if (this.f6080g) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.f6145l <= jCurrentTimeMillis) {
                this.f6144k = 0;
                this.f6145l = jCurrentTimeMillis + this.f6142i;
                if (this.f6074a == 9 || this.f6074a == 10) {
                    long j = this.f6145l / this.f6142i;
                    if (this.f6145l % this.f6142i > 0) {
                        this.f6145l = j * this.f6142i;
                    }
                }
            } else if (this.f6144k >= this.f6143j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: d */
    private void m6824d() {
        this.f6148o.setLimit(this.f6075b, this.f6144k + "|" + this.f6145l);
    }

    /* JADX INFO: renamed from: e */
    private void m6825e() {
        if (this.f6080g) {
            String limit = this.f6148o.getLimit(this.f6075b);
            if (TextUtils.isEmpty(limit)) {
                return;
            }
            String[] strArrSplit = limit.split("\\|");
            try {
                this.f6144k = ResHelper.parseInt(strArrSplit[0]);
            } catch (Throwable th) {
                SMSLog.getInstance().m8610d(th);
            }
            this.f6145l = Long.parseLong(strArrSplit[1]);
        }
    }

    @Override // cn.smssdk.net.AbstractC0976a
    /* JADX INFO: renamed from: a */
    protected HashMap<String, Object> mo6736a(String str, String str2, HashMap<String, Object> map) {
        if (this.f6146m != null && this.f6146m.size() > 0) {
            return C0980e.m6795a().m6811a(this.f6146m, str, str2, map);
        }
        return C0980e.m6795a().m6810a(this.f6147n, str, str2, map);
    }
}
