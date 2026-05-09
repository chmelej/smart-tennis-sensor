package cn.smssdk.p008a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.smssdk.contact.C0936b;
import cn.smssdk.net.C0981f;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.a.b */
/* JADX INFO: compiled from: Synchronizer.java */
/* JADX INFO: loaded from: classes.dex */
public class C0916b implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    private Handler f5997a = new Handler(this);

    /* JADX INFO: renamed from: b */
    private C0936b f5998b;

    /* JADX INFO: renamed from: c */
    private SPHelper f5999c;

    /* JADX INFO: renamed from: d */
    private C0981f f6000d;

    /* JADX INFO: renamed from: e */
    private C0915a f6001e;

    /* JADX INFO: renamed from: f */
    private int f6002f;

    /* JADX INFO: renamed from: g */
    private Handler.Callback f6003g;

    public C0916b(Context context, C0915a c0915a) {
        this.f5998b = C0936b.m6707a(context);
        this.f5999c = SPHelper.getInstance(context);
        this.f6000d = C0981f.m6812a(context);
        this.f6001e = c0915a;
    }

    /* JADX INFO: renamed from: a */
    public void m6622a(int i, Handler.Callback callback) {
        this.f5997a.removeMessages(1);
        this.f6002f = i;
        this.f6003g = callback;
        this.f5997a.sendEmptyMessageDelayed(1, 5000L);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [cn.smssdk.a.b$1] */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        new Thread() { // from class: cn.smssdk.a.b.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    int iM6621a = C0916b.this.m6621a();
                    if (C0916b.this.f6003g != null) {
                        Message message2 = new Message();
                        message2.what = C0916b.this.f6002f;
                        message2.arg1 = iM6621a;
                        C0916b.this.f6003g.handleMessage(message2);
                    }
                } catch (Throwable th) {
                    SMSLog.getInstance().m8622w(th);
                }
            }
        }.start();
        return false;
    }

    /* JADX INFO: renamed from: a */
    public int m6621a() {
        String[] bufferedContactPhones;
        boolean z;
        String[] strArrM6721b = this.f5998b.m6721b();
        try {
            bufferedContactPhones = this.f5999c.getBufferedContactPhones();
            this.f5999c.setBufferedContactPhones(strArrM6721b);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            bufferedContactPhones = new String[0];
        }
        ArrayList arrayList = new ArrayList();
        for (String str : strArrM6721b) {
            if (str != null) {
                int length = bufferedContactPhones.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        z = true;
                        break;
                    }
                    if (str.equals(bufferedContactPhones[i])) {
                        z = false;
                        break;
                    }
                    i++;
                }
                if (z) {
                    arrayList.add(str);
                }
            }
        }
        if (arrayList.size() <= 0) {
            return 0;
        }
        String[] strArr = new String[arrayList.size()];
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = (String) arrayList.get(i2);
        }
        ArrayList<HashMap<String, Object>> arrayListM6614a = this.f6001e.m6614a(this.f6000d.m6813a(strArr));
        try {
            this.f5999c.setBufferedNewFriends(arrayListM6614a);
            this.f5999c.setRequestNewFriendsTime();
        } catch (Throwable th2) {
            SMSLog.getInstance().m8622w(th2);
        }
        return arrayListM6614a.size();
    }
}
