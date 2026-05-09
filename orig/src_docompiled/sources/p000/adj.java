package p000;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.umeng.message.MsgConstant;

/* JADX INFO: compiled from: ImeiTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adj extends agz {

    /* JADX INFO: renamed from: a */
    private Context f414a;

    public adj(Context context) {
        super("imei");
        this.f414a = context;
    }

    @Override // p000.agz
    /* JADX INFO: renamed from: a */
    public String mo342a() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f414a.getSystemService("phone");
        try {
            if (aeu.m723a(this.f414a, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                return telephonyManager.getDeviceId();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
