package cn.sharesdk.tencent.p007qq;

import android.content.Intent;
import android.os.Bundle;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.FakeActivity;
import com.mob.tools.MobUIShell;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qq.d */
/* JADX INFO: compiled from: ResultReceiver.java */
/* JADX INFO: loaded from: classes.dex */
public class C0878d extends FakeActivity {

    /* JADX INFO: renamed from: a */
    private String f5788a;

    /* JADX INFO: renamed from: b */
    private Platform f5789b;

    /* JADX INFO: renamed from: c */
    private PlatformActionListener f5790c;

    /* JADX INFO: renamed from: a */
    public void m6327a(String str) {
        this.f5788a = str;
    }

    /* JADX INFO: renamed from: a */
    public void m6326a(Platform platform, PlatformActionListener platformActionListener) {
        this.f5789b = platform;
        this.f5790c = platformActionListener;
    }

    @Override // com.mob.tools.FakeActivity
    public void onCreate() {
        try {
            Intent intent = this.activity.getIntent();
            String scheme = intent.getScheme();
            finish();
            if (scheme == null || !scheme.startsWith(this.f5788a)) {
                return;
            }
            Bundle bundleUrlToBundle = ResHelper.urlToBundle(intent.getDataString());
            String strValueOf = String.valueOf(bundleUrlToBundle.get("result"));
            String strValueOf2 = String.valueOf(bundleUrlToBundle.get("action"));
            if ("shareToQQ".equals(strValueOf2) || "shareToQzone".equals(strValueOf2)) {
                if ("complete".equals(strValueOf)) {
                    if (this.f5790c != null) {
                        this.f5790c.onComplete(this.f5789b, 9, new Hashon().fromJson(String.valueOf(bundleUrlToBundle.get("response"))));
                    }
                } else if ("error".equals(strValueOf)) {
                    if (this.f5790c != null) {
                        this.f5790c.onError(this.f5789b, 9, new Throwable(String.valueOf(bundleUrlToBundle.get("response"))));
                    }
                } else if (this.f5790c != null) {
                    this.f5790c.onCancel(this.f5789b, 9);
                }
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setClass(this.activity, MobUIShell.class);
            intent2.setFlags(335544320);
            startActivity(intent2);
        } catch (Throwable th) {
            C0851d.m6195a().m8610d(th);
        }
    }
}
