package p000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import java.net.URLEncoder;

/* JADX INFO: compiled from: NetworkHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class ady {

    /* JADX INFO: renamed from: a */
    private String f494a;

    /* JADX INFO: renamed from: b */
    private String f495b = "10.0.0.172";

    /* JADX INFO: renamed from: c */
    private int f496c = 80;

    /* JADX INFO: renamed from: d */
    private Context f497d;

    /* JADX INFO: renamed from: e */
    private adx f498e;

    public ady(Context context) {
        this.f497d = context;
        this.f494a = m448a(context);
    }

    /* JADX INFO: renamed from: a */
    public void m452a(adx adxVar) {
        this.f498e = adxVar;
    }

    /* JADX INFO: renamed from: a */
    private void m449a() {
        String strM382c = adk.m357a(this.f497d).m366b().m382c("");
        String strM379b = adk.m357a(this.f497d).m366b().m379b("");
        if (!TextUtils.isEmpty(strM382c)) {
            adb.f364c = aes.m709b(strM382c);
        }
        if (!TextUtils.isEmpty(strM379b)) {
            adb.f365d = aes.m709b(strM379b);
        }
        adb.f366e = new String[]{adb.f364c, adb.f365d};
        int iM506b = aeh.m499a(this.f497d).m506b();
        if (iM506b != -1) {
            if (iM506b == 0) {
                adb.f366e = new String[]{adb.f364c, adb.f365d};
            } else if (iM506b == 1) {
                adb.f366e = new String[]{adb.f365d, adb.f364c};
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public byte[] m453a(byte[] bArr) {
        m449a();
        byte[] bArrM450a = null;
        int i = 0;
        while (true) {
            if (i >= adb.f366e.length) {
                break;
            }
            bArrM450a = m450a(bArr, adb.f366e[i]);
            if (bArrM450a != null) {
                if (this.f498e != null) {
                    this.f498e.mo446c();
                }
            } else {
                if (this.f498e != null) {
                    this.f498e.mo447d();
                }
                i++;
            }
        }
        return bArrM450a;
    }

    /* JADX INFO: renamed from: b */
    private boolean m451b() {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (this.f497d.getPackageManager().checkPermission(MsgConstant.PERMISSION_ACCESS_NETWORK_STATE, this.f497d.getPackageName()) != 0) {
            return false;
        }
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.f497d.getSystemService("connectivity");
            if (aeu.m723a(this.f497d, MsgConstant.PERMISSION_ACCESS_NETWORK_STATE) && (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) != null && activeNetworkInfo.getType() != 1 && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap")) {
                    if (extraInfo.equals("uniwap")) {
                    }
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00fb  */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private byte[] m450a(byte[] r7, java.lang.String r8) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 255
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ady.m450a(byte[], java.lang.String):byte[]");
    }

    /* JADX INFO: renamed from: a */
    private String m448a(Context context) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Android");
        stringBuffer.append("/");
        stringBuffer.append("6.1.4");
        stringBuffer.append(" ");
        try {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append(aeu.m747s(context));
            stringBuffer2.append("/");
            stringBuffer2.append(aeu.m725b(context));
            stringBuffer2.append(" ");
            stringBuffer2.append(Build.MODEL);
            stringBuffer2.append("/");
            stringBuffer2.append(Build.VERSION.RELEASE);
            stringBuffer2.append(" ");
            stringBuffer2.append(aev.m757a(acz.m287a(context)));
            stringBuffer.append(URLEncoder.encode(stringBuffer2.toString(), "UTF-8"));
        } catch (Throwable unused) {
        }
        return stringBuffer.toString();
    }
}
