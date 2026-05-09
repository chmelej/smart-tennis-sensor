package cn.smssdk.contact;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.smssdk.net.C0981f;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.ResHelper;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.contact.d */
/* JADX INFO: compiled from: Synchronizer.java */
/* JADX INFO: loaded from: classes.dex */
public class C0938d implements Handler.Callback {

    /* JADX INFO: renamed from: a */
    private Handler f6058a = new Handler(this);

    /* JADX INFO: renamed from: b */
    private C0936b f6059b;

    /* JADX INFO: renamed from: c */
    private SPHelper f6060c;

    /* JADX INFO: renamed from: d */
    private C0981f f6061d;

    /* JADX INFO: renamed from: e */
    private String f6062e;

    public C0938d(Context context, C0936b c0936b) {
        this.f6059b = c0936b;
        this.f6060c = SPHelper.getInstance(context);
        this.f6061d = C0981f.m6812a(context);
        this.f6062e = ResHelper.getCacheRoot(context) + ".slock";
    }

    /* JADX INFO: renamed from: a */
    public void m6731a() {
        if (m6727b()) {
            return;
        }
        this.f6058a.removeMessages(1);
        this.f6058a.sendEmptyMessageDelayed(1, 180000L);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [cn.smssdk.contact.d$1] */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        new Thread() { // from class: cn.smssdk.contact.d.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                String verifyPhone;
                String str = null;
                try {
                    try {
                        String verifyCountry = C0938d.this.f6060c.getVerifyCountry();
                        verifyPhone = C0938d.this.f6060c.getVerifyPhone();
                        str = verifyCountry;
                    } catch (Throwable th) {
                        SMSLog.getInstance().m8622w(th);
                        verifyPhone = null;
                    }
                    ArrayList<HashMap<String, Object>> arrayListM6716a = C0938d.this.f6059b.m6716a(false);
                    String strM6725a = C0938d.this.m6725a(arrayListM6716a);
                    String bufferedContactsSignature = C0938d.this.f6060c.getBufferedContactsSignature();
                    if (arrayListM6716a != null && !arrayListM6716a.isEmpty() && strM6725a != null && !strM6725a.equals(bufferedContactsSignature)) {
                        C0938d.this.f6061d.m6817a(str, verifyPhone, arrayListM6716a);
                    }
                    C0938d.this.f6060c.setBufferedContactsSignature(strM6725a);
                } catch (Throwable th2) {
                    SMSLog.getInstance().m8622w(th2);
                }
                C0938d.this.m6729c();
            }
        }.start();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public String m6725a(Object obj) throws IOException {
        if (obj == null) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.flush();
        objectOutputStream.close();
        return Data.CRC32(byteArrayOutputStream.toByteArray());
    }

    /* JADX INFO: renamed from: b */
    private boolean m6727b() {
        File file;
        try {
            file = new File(this.f6062e);
        } catch (Exception e) {
            SMSLog.getInstance().m8622w(e);
        }
        if (file.exists()) {
            if (System.currentTimeMillis() - file.lastModified() < 86400000) {
                return true;
            }
            file.delete();
            file.createNewFile();
            return false;
        }
        file.createNewFile();
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: c */
    public void m6729c() {
        try {
            File file = new File(this.f6062e);
            if (file.exists()) {
                Thread.sleep(5000L);
                file.delete();
            }
        } catch (Exception e) {
            SMSLog.getInstance().m8622w(e);
        }
    }
}
