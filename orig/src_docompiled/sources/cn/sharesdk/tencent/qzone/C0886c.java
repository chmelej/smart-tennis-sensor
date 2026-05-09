package cn.sharesdk.tencent.qzone;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import cn.sharesdk.framework.authorize.AbstractC0825d;
import cn.sharesdk.framework.authorize.C0824c;
import org.json.JSONObject;

/* JADX INFO: renamed from: cn.sharesdk.tencent.qzone.c */
/* JADX INFO: compiled from: QZoneSSOProcessor.java */
/* JADX INFO: loaded from: classes.dex */
public class C0886c extends AbstractC0825d {

    /* JADX INFO: renamed from: d */
    private String f5833d;

    /* JADX INFO: renamed from: e */
    private String f5834e;

    public C0886c(C0824c c0824c) {
        super(c0824c);
    }

    /* JADX INFO: renamed from: a */
    public void m6387a(String str, String str2) {
        this.f5833d = str;
        this.f5834e = str2;
    }

    @Override // cn.sharesdk.framework.authorize.AbstractC0825d
    /* JADX INFO: renamed from: a */
    public void mo5905a() {
        try {
            if (this.f5552a.getContext().getPackageManager().getPackageInfo("com.tencent.mobileqq", 0) == null) {
                this.f5552a.finish();
                if (this.f5554c != null) {
                    this.f5554c.onFailed(new TencentSSOClientNotInstalledException());
                    return;
                }
                return;
            }
            Intent intent = new Intent();
            intent.setClassName("com.tencent.mobileqq", "com.tencent.open.agent.AgentActivity");
            if (this.f5552a.getContext().getPackageManager().resolveActivity(intent, 0) == null) {
                this.f5552a.finish();
                if (this.f5554c != null) {
                    this.f5554c.onFailed(new TencentSSOClientNotInstalledException());
                    return;
                }
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("scope", this.f5834e);
            bundle.putString("client_id", this.f5833d);
            bundle.putString("pf", "openmobile_android");
            bundle.putString("need_pay", "1");
            intent.putExtra("key_params", bundle);
            intent.putExtra("key_request_code", this.f5553b);
            intent.putExtra("key_action", "action_login");
            try {
                this.f5552a.startActivityForResult(intent, this.f5553b);
            } catch (Throwable th) {
                this.f5552a.finish();
                if (this.f5554c != null) {
                    this.f5554c.onFailed(th);
                }
            }
        } catch (Throwable unused) {
            this.f5552a.finish();
            if (this.f5554c != null) {
                this.f5554c.onFailed(new TencentSSOClientNotInstalledException());
            }
        }
    }

    @Override // cn.sharesdk.framework.authorize.AbstractC0825d
    /* JADX INFO: renamed from: a */
    public void mo5906a(int i, int i2, Intent intent) {
        this.f5552a.finish();
        if (i2 == 0) {
            if (this.f5554c != null) {
                this.f5554c.onCancel();
                return;
            }
            return;
        }
        if (intent == null) {
            if (this.f5554c != null) {
                this.f5554c.onFailed(new Throwable("response is empty"));
                return;
            }
            return;
        }
        Bundle extras = intent.getExtras();
        if (extras == null) {
            if (this.f5554c != null) {
                this.f5554c.onFailed(new Throwable("response is empty"));
                return;
            }
            return;
        }
        if (!extras.containsKey("key_response")) {
            if (this.f5554c != null) {
                this.f5554c.onFailed(new Throwable("response is empty"));
                return;
            }
            return;
        }
        String string = extras.getString("key_response");
        if (string == null || string.length() <= 0) {
            if (this.f5554c != null) {
                this.f5554c.onFailed(new Throwable("response is empty"));
                return;
            }
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            Bundle bundle = new Bundle();
            bundle.putInt("ret", jSONObject.optInt("ret"));
            bundle.putString("pay_token", jSONObject.optString("pay_token"));
            bundle.putString("pf", jSONObject.optString("pf"));
            bundle.putString("open_id", jSONObject.optString("openid"));
            bundle.putString("expires_in", jSONObject.optString("expires_in"));
            bundle.putString("pfkey", jSONObject.optString("pfkey"));
            bundle.putString(NotificationCompat.CATEGORY_MESSAGE, jSONObject.optString(NotificationCompat.CATEGORY_MESSAGE));
            bundle.putString("access_token", jSONObject.optString("access_token"));
            if (this.f5554c != null) {
                this.f5554c.onComplete(bundle);
            }
        } catch (Throwable th) {
            if (this.f5554c != null) {
                this.f5554c.onFailed(th);
            }
        }
    }
}
