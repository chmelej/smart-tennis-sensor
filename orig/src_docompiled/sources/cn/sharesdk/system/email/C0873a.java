package cn.sharesdk.system.email;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.text.Spanned;
import android.text.TextUtils;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import com.mob.tools.utils.UIHandler;
import java.io.File;
import java.net.URLConnection;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.system.email.a */
/* JADX INFO: compiled from: Helper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0873a {

    /* JADX INFO: renamed from: a */
    private static C0873a f5761a;

    /* JADX INFO: renamed from: b */
    private Context f5762b;

    /* JADX INFO: renamed from: a */
    public static C0873a m6289a(Context context) {
        if (f5761a == null) {
            f5761a = new C0873a();
        }
        f5761a.f5762b = context;
        return f5761a;
    }

    /* JADX INFO: renamed from: a */
    public void m6290a(String str, String str2, Spanned spanned, String str3, final ActionListener actionListener) {
        final boolean z;
        try {
            try {
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setFlags(268435456);
                intent.putExtra("android.intent.extra.SUBJECT", str2);
                intent.putExtra("android.intent.extra.TEXT", spanned);
                if (str3 != null) {
                    File file = new File(str3);
                    if (file.exists()) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            intent.putExtra("android.intent.extra.STREAM", ResHelper.pathToContentUri(this.f5762b, str3));
                        } else {
                            intent.putExtra("android.intent.extra.STREAM", Uri.fromFile(file));
                        }
                    }
                }
                intent.setType("message/rfc822");
                this.f5762b.startActivity(intent);
            } catch (Throwable unused) {
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setFlags(268435456);
                intent2.putExtra("android.intent.extra.EMAIL", str);
                if (str2 != null) {
                    intent2.putExtra("android.intent.extra.SUBJECT", str2);
                }
                if (spanned != null) {
                    intent2.putExtra("android.intent.extra.TEXT", spanned);
                    intent2.setType("text/html");
                }
                if (str3 != null) {
                    String contentTypeFor = URLConnection.getFileNameMap().getContentTypeFor(str3);
                    if (contentTypeFor == null || contentTypeFor.length() <= 0) {
                        contentTypeFor = "*/*";
                    }
                    File file2 = new File(str3);
                    if (file2.exists()) {
                        if (Build.VERSION.SDK_INT >= 24) {
                            intent2.putExtra("android.intent.extra.STREAM", ResHelper.pathToContentUri(this.f5762b, str3));
                        } else {
                            intent2.putExtra("android.intent.extra.STREAM", Uri.fromFile(file2));
                        }
                        intent2.setType(contentTypeFor);
                    }
                }
                this.f5762b.startActivity(intent2);
            }
            z = true;
        } catch (Throwable th) {
            if (actionListener != null) {
                actionListener.onError(th);
            }
            z = false;
        }
        final DeviceHelper deviceHelper = DeviceHelper.getInstance(this.f5762b);
        final String packageName = this.f5762b.getPackageName();
        if (!TextUtils.isEmpty(deviceHelper.getTopTaskPackageName())) {
            UIHandler.sendEmptyMessageDelayed(0, 2000L, new Handler.Callback() { // from class: cn.sharesdk.system.email.a.1

                /* JADX INFO: renamed from: a */
                int f5763a = 0;

                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (!packageName.equals(deviceHelper.getTopTaskPackageName())) {
                        if (z && actionListener != null) {
                            actionListener.onComplete(new HashMap<>());
                        }
                    } else if (this.f5763a < 5) {
                        this.f5763a++;
                        UIHandler.sendEmptyMessageDelayed(0, 500L, this);
                    }
                    return true;
                }
            });
        } else {
            if (!z || actionListener == null) {
                return;
            }
            actionListener.onComplete(new HashMap<>());
        }
    }
}
