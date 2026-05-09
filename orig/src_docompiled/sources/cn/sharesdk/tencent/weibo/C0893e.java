package cn.sharesdk.tencent.weibo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import cn.sharesdk.framework.authorize.AbstractC0825d;
import cn.sharesdk.framework.authorize.C0824c;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: renamed from: cn.sharesdk.tencent.weibo.e */
/* JADX INFO: compiled from: TencentWeiboSSOProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public class C0893e extends AbstractC0825d {

    /* JADX INFO: renamed from: d */
    private C0891c f5878d;

    public C0893e(C0824c c0824c) {
        super(c0824c);
    }

    /* JADX INFO: renamed from: a */
    public void m6452a(C0891c c0891c) {
        this.f5878d = c0891c;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    @Override // cn.sharesdk.framework.authorize.AbstractC0825d
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void mo5905a() {
        /*
            Method dump skipped, instruction units count: 312
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.tencent.weibo.C0893e.mo5905a():void");
    }

    /* JADX INFO: renamed from: a */
    private int m6443a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.tencent.WBlog", 16);
            if (packageInfo == null || packageInfo.versionCode < 44) {
                return -1;
            }
            return packageManager.queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse("TencentAuth://weibo")), 65536).size() > 0 ? 0 : -1;
        } catch (PackageManager.NameNotFoundException unused) {
            return -2;
        }
    }

    /* JADX INFO: renamed from: b */
    private String m6449b(Context context) throws PackageManager.NameNotFoundException {
        X509Certificate x509Certificate = (X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray()));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(x509Certificate.getPublicKey().toString());
        stringBuffer.append(x509Certificate.getSerialNumber().toString());
        return Data.MD5(stringBuffer.toString());
    }

    /* JADX INFO: renamed from: a */
    private byte[] m6448a(long j, long j2) throws Throwable {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.f5878d.f5863a);
        stringBuffer.append(j);
        stringBuffer.append(j2);
        stringBuffer.append(1);
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec(this.f5878d.f5864b.getBytes("UTF-8"), mac.getAlgorithm()));
        byte[] bytes = C0889a.m6419a(mac.doFinal(stringBuffer.toString().getBytes("UTF-8"))).getBytes();
        if (bytes == null) {
            throw new Throwable("Generating signature failed");
        }
        return new C0890b().m6430a(bytes, "&-*)Wb5_U,[^!9'+".getBytes());
    }

    @Override // cn.sharesdk.framework.authorize.AbstractC0825d
    /* JADX INFO: renamed from: a */
    public void mo5906a(int i, int i2, Intent intent) {
        super.mo5906a(i, i2, intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6445a(Bundle bundle) {
        this.f5878d.f5867e = bundle.getString("com.tencent.sso.WEIBO_NICK");
        m6447a(new C0890b().m6431a(bundle.getByteArray("com.tencent.sso.ACCESS_TOKEN"), "&-*)Wb5_U,[^!9'+".getBytes(), 10));
    }

    /* JADX INFO: renamed from: a */
    private void m6447a(byte[] bArr) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
        try {
            try {
                this.f5878d.f5866d = dataInputStream.readUTF();
                this.f5878d.f5870h = dataInputStream.readLong();
                this.f5878d.f5871i = dataInputStream.readUTF();
                this.f5878d.f5868f = dataInputStream.readUTF();
                this.f5878d.f5872j = dataInputStream.readUTF();
                this.f5878d.f5873k = dataInputStream.readUTF();
                if (this.f5554c != null) {
                    this.f5554c.onComplete(null);
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable unused) {
                    }
                }
                if (dataInputStream == null) {
                    return;
                }
            } catch (Throwable th) {
                if (this.f5554c != null) {
                    this.f5554c.onFailed(th);
                }
                if (byteArrayInputStream != null) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable unused2) {
                    }
                }
                if (dataInputStream == null) {
                    return;
                }
            }
            try {
                dataInputStream.close();
            } catch (Throwable unused3) {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m6450b(Bundle bundle) {
        if (this.f5554c != null) {
            HashMap map = new HashMap();
            for (String str : bundle.keySet()) {
                map.put(str, bundle.get(str));
            }
            this.f5554c.onFailed(new Throwable(new Hashon().fromHashMap(map)));
        }
    }

    /* JADX INFO: renamed from: cn.sharesdk.tencent.weibo.e$a */
    /* JADX INFO: compiled from: TencentWeiboSSOProcessor.java */
    static class a extends BroadcastReceiver {

        /* JADX INFO: renamed from: a */
        private C0893e f5879a;

        public a(C0893e c0893e) {
            this.f5879a = c0893e;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            context.unregisterReceiver(this);
            this.f5879a.f5552a.finish();
            Bundle extras = intent.getExtras();
            if (extras.getBoolean("com.tencent.sso.AUTH_RESULT", false)) {
                this.f5879a.m6445a(extras);
            } else {
                this.f5879a.m6450b(extras);
            }
        }
    }
}
