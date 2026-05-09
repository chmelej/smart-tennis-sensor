package cn.smssdk.p009b;

import android.content.Context;
import android.os.Looper;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import cn.smssdk.SMSSDK;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.commons.authorize.DeviceAuthorizer;
import com.mob.tools.utils.Data;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.b.a */
/* JADX INFO: compiled from: VerifyCodeReader.java */
/* JADX INFO: loaded from: classes.dex */
public class C0917a {

    /* JADX INFO: renamed from: e */
    private static C0917a f6005e;

    /* JADX INFO: renamed from: g */
    private static final String f6006g = new String(new char[]{30340, 39564, 35777, 30721, 65306});

    /* JADX INFO: renamed from: a */
    private Context f6007a;

    /* JADX INFO: renamed from: b */
    private String f6008b;

    /* JADX INFO: renamed from: c */
    private SPHelper f6009c;

    /* JADX INFO: renamed from: d */
    private HashMap<String, String> f6010d = new HashMap<>();

    /* JADX INFO: renamed from: f */
    private SMSSDK.VerifyCodeReadListener f6011f;

    private C0917a(Context context, String str) {
        this.f6007a = context;
        this.f6008b = str;
        this.f6009c = SPHelper.getInstance(context);
    }

    /* JADX INFO: renamed from: a */
    public static C0917a m6623a(Context context, String str) {
        if (f6005e == null) {
            f6005e = new C0917a(context, str);
        }
        return f6005e;
    }

    /* JADX INFO: renamed from: a */
    private void m6627a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        this.f6010d.put(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public void m6630a(SMSSDK.VerifyCodeReadListener verifyCodeReadListener) {
        this.f6011f = verifyCodeReadListener;
    }

    /* JADX INFO: renamed from: a */
    public boolean m6631a(SmsMessage smsMessage) {
        try {
            return m6629b(smsMessage);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    private boolean m6629b(SmsMessage smsMessage) throws Throwable {
        if (smsMessage == null) {
            return false;
        }
        String messageBody = smsMessage.getMessageBody();
        m6627a("originatingAddress", smsMessage.getOriginatingAddress());
        m6627a("timestampMillis", Long.toString(smsMessage.getTimestampMillis()));
        m6627a("messageBody", messageBody);
        int iM6628b = m6628b(messageBody);
        if (iM6628b > -1) {
            String strCRC32 = Data.CRC32(m6624a(messageBody).getBytes());
            if (!TextUtils.isEmpty(strCRC32) && strCRC32.equals(this.f6009c.getVCodeHash())) {
                String strSubstring = messageBody.substring(iM6628b, iM6628b + 4);
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    throw new Throwable("operation not in UI Thread");
                }
                if (this.f6011f == null) {
                    throw new Throwable("listener can not be null");
                }
                this.f6011f.onReadVerifyCode(strSubstring);
                new Thread(new Runnable() { // from class: cn.smssdk.b.a.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C0917a.this.m6625a();
                        } catch (Throwable th) {
                            SMSLog.getInstance().m8610d(th);
                        }
                    }
                }).start();
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6625a() {
        String strAuthorize = DeviceAuthorizer.authorize(this.f6007a, new com.mob.commons.SMSSDK());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[RMS]:");
        stringBuffer.append(Data.urlEncode(this.f6010d.get("originatingAddress")));
        stringBuffer.append("|");
        stringBuffer.append("");
        stringBuffer.append("|");
        stringBuffer.append(this.f6009c.getAppKey());
        stringBuffer.append("|");
        stringBuffer.append(strAuthorize);
        stringBuffer.append("|");
        stringBuffer.append(Data.urlEncode(this.f6009c.getSMSID()));
        stringBuffer.append("|");
        stringBuffer.append(this.f6010d.get("timestampMillis"));
        this.f6009c.setLog(stringBuffer.toString());
    }

    /* JADX INFO: renamed from: a */
    private String m6624a(String str) {
        if (str.startsWith(new String(new char[]{12304}))) {
            return str.substring(str.indexOf(new String(new char[]{12305})) + 1);
        }
        return str.endsWith(new String(new char[]{12305})) ? str.substring(0, str.lastIndexOf(new String(new char[]{12304}))) : str;
    }

    /* JADX INFO: renamed from: b */
    private int m6628b(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        int iIndexOf = str.indexOf(f6006g);
        if (iIndexOf > -1) {
            return iIndexOf + f6006g.length();
        }
        int iIndexOf2 = str.indexOf("Your pin is ");
        return iIndexOf2 > -1 ? iIndexOf2 + f6006g.length() : iIndexOf2;
    }
}
