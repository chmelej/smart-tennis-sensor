package p000;

import android.app.Activity;
import android.app.Application;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import p000.C2293zg;
import p000.C2302zp;
import p000.C2303zq;
import p000.C2304zr;
import p000.C2305zs;
import p000.C2306zt;
import p000.C2307zu;

/* JADX INFO: loaded from: classes.dex */
final class aab implements InterfaceC2310zx {

    /* JADX INFO: renamed from: a */
    private static C0003a f6a;

    /* JADX INFO: renamed from: f */
    private static String f7f;

    /* JADX INFO: renamed from: b */
    private Context f8b;

    /* JADX INFO: renamed from: c */
    private String f9c;

    /* JADX INFO: renamed from: d */
    private boolean f10d;

    /* JADX INFO: renamed from: e */
    private boolean f11e = false;

    /* JADX INFO: renamed from: aab$a */
    static final class C0003a implements Application.ActivityLifecycleCallbacks {

        /* JADX INFO: renamed from: a */
        private boolean f12a;

        /* JADX INFO: renamed from: b */
        private Handler f13b;

        /* JADX INFO: renamed from: c */
        private Context f14c;

        /* JADX INFO: renamed from: d */
        private Runnable f15d;

        /* JADX INFO: renamed from: e */
        private Runnable f16e;

        private C0003a(Context context) {
            this.f12a = false;
            this.f13b = new Handler(Looper.getMainLooper());
            this.f15d = new aac(this);
            this.f16e = new aad(this);
            this.f14c = context;
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityPaused(Activity activity) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", activity.getComponentName().getClassName() + "  onActivityPaused");
            this.f13b.removeCallbacks(this.f16e);
            this.f13b.postDelayed(this.f15d, 800L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityResumed(Activity activity) {
            Log.v("MicroMsg.SDK.WXApiImplV10.ActivityLifecycleCb", activity.getComponentName().getClassName() + "  onActivityResumed");
            this.f13b.removeCallbacks(this.f15d);
            this.f13b.postDelayed(this.f16e, 800L);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public final void onActivityStopped(Activity activity) {
        }
    }

    aab(Context context, String str, boolean z) {
        this.f10d = false;
        C2295zi.m12552d("MicroMsg.SDK.WXApiImplV10", "<init>, appId = " + str + ", checkSignature = " + z);
        this.f8b = context;
        this.f9c = str;
        this.f10d = z;
    }

    /* JADX INFO: renamed from: a */
    private void m10a(Context context, String str) {
        String str2 = "AWXOP" + str;
        acb.m158a(context, str2);
        acb.m183n();
        acb.m155a(acc.PERIOD);
        acb.m180k();
        acb.m164b(context, "Wechat_Sdk");
        try {
            acd.m204a(context, str2, "2.0.3");
        } catch (aae e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: a */
    private boolean m11a(byte[] bArr, byte[] bArr2) {
        String str;
        String str2;
        if (bArr == null || bArr.length == 0 || bArr2 == null || bArr2.length == 0) {
            str = "MicroMsg.SDK.WXApiImplV10";
            str2 = "checkSumConsistent fail, invalid arguments";
        } else {
            if (bArr.length == bArr2.length) {
                for (int i = 0; i < bArr.length; i++) {
                    if (bArr[i] != bArr2[i]) {
                        return false;
                    }
                }
                return true;
            }
            str = "MicroMsg.SDK.WXApiImplV10";
            str2 = "checkSumConsistent fail, length is different";
        }
        C2295zi.m12548a(str, str2);
        return false;
    }

    @Override // p000.InterfaceC2310zx
    /* JADX INFO: renamed from: a */
    public final boolean mo12a(Intent intent, InterfaceC2311zy interfaceC2311zy) {
        if (!aaa.m8a(intent, "com.tencent.mm.openapi.token")) {
            C2295zi.m12551c("MicroMsg.SDK.WXApiImplV10", "handleIntent fail, intent not from weixin msg");
            return false;
        }
        if (this.f11e) {
            throw new IllegalStateException("handleIntent fail, WXMsgImpl has been detached");
        }
        String stringExtra = intent.getStringExtra("_mmessage_content");
        int intExtra = intent.getIntExtra("_mmessage_sdkVersion", 0);
        String stringExtra2 = intent.getStringExtra("_mmessage_appPackage");
        if (stringExtra2 == null || stringExtra2.length() == 0) {
            C2295zi.m12548a("MicroMsg.SDK.WXApiImplV10", "invalid argument");
            return false;
        }
        if (!m11a(intent.getByteArrayExtra("_mmessage_checksum"), C2294zh.m12545a(stringExtra, intExtra, stringExtra2))) {
            C2295zi.m12548a("MicroMsg.SDK.WXApiImplV10", "checksum fail");
            return false;
        }
        int intExtra2 = intent.getIntExtra("_wxapi_command_type", 0);
        if (intExtra2 == 9) {
            interfaceC2311zy.mo8371a(new C2302zp.a(intent.getExtras()));
            return true;
        }
        switch (intExtra2) {
            case 1:
                interfaceC2311zy.mo8371a(new C2305zs.a(intent.getExtras()));
                return true;
            case 2:
                interfaceC2311zy.mo8371a(new C2306zt.a(intent.getExtras()));
                return true;
            case 3:
                interfaceC2311zy.mo8370a(new C2303zq.a(intent.getExtras()));
                return true;
            case 4:
                interfaceC2311zy.mo8370a(new C2307zu.a(intent.getExtras()));
                return true;
            case 5:
                interfaceC2311zy.mo8371a(new C2309zw(intent.getExtras()));
                return true;
            case 6:
                interfaceC2311zy.mo8370a(new C2304zr.a(intent.getExtras()));
                return true;
            default:
                C2295zi.m12548a("MicroMsg.SDK.WXApiImplV10", "unknown cmd = " + intExtra2);
                return false;
        }
    }

    @Override // p000.InterfaceC2310zx
    /* JADX INFO: renamed from: a */
    public final boolean mo13a(String str) {
        Application application;
        if (this.f11e) {
            throw new IllegalStateException("registerApp fail, WXMsgImpl has been detached");
        }
        if (!aaa.m6a(this.f8b, "com.tencent.mm", this.f10d)) {
            C2295zi.m12548a("MicroMsg.SDK.WXApiImplV10", "register app failed for wechat app signature check failed");
            return false;
        }
        if (f6a == null && Build.VERSION.SDK_INT >= 14) {
            if (this.f8b instanceof Activity) {
                m10a(this.f8b, str);
                f6a = new C0003a(this.f8b);
                application = ((Activity) this.f8b).getApplication();
            } else if (this.f8b instanceof Service) {
                m10a(this.f8b, str);
                f6a = new C0003a(this.f8b);
                application = ((Service) this.f8b).getApplication();
            } else {
                C2295zi.m12550b("MicroMsg.SDK.WXApiImplV10", "context is not instanceof Activity or Service, disable WXStat");
            }
            application.registerActivityLifecycleCallbacks(f6a);
        }
        C2295zi.m12552d("MicroMsg.SDK.WXApiImplV10", "registerApp, appId = " + str);
        if (str != null) {
            this.f9c = str;
        }
        C2295zi.m12552d("MicroMsg.SDK.WXApiImplV10", "register app " + this.f8b.getPackageName());
        C2293zg.a aVar = new C2293zg.a();
        aVar.f13781a = "com.tencent.mm";
        aVar.f13782b = "com.tencent.mm.plugin.openapi.Intent.ACTION_HANDLE_APP_REGISTER";
        aVar.f13783c = "weixin://registerapp?appid=" + this.f9c;
        return C2293zg.m12544a(this.f8b, aVar);
    }
}
