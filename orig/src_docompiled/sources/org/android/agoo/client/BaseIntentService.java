package org.android.agoo.client;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import org.json.JSONObject;
import p000.apo;
import p000.app;
import p000.apq;
import p000.apt;
import p000.apv;
import p000.apx;
import p000.apz;
import p000.aqb;
import p000.arh;
import p000.arj;

/* JADX INFO: loaded from: classes.dex */
public abstract class BaseIntentService extends IntentService implements apv {
    /* JADX INFO: renamed from: a */
    public Class<?> mo8734a() {
        return null;
    }

    /* JADX INFO: renamed from: a */
    protected void m10926a(Context context, int i) {
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo8735a(Context context, Intent intent);

    /* JADX INFO: renamed from: a */
    public abstract void mo8736a(Context context, String str);

    /* JADX INFO: renamed from: b */
    public abstract void mo8737b(Context context, String str);

    /* JADX INFO: renamed from: b */
    protected boolean m10927b(Context context, Intent intent) {
        return true;
    }

    /* JADX INFO: renamed from: c */
    protected void m10928c(Context context, Intent intent) {
    }

    /* JADX INFO: renamed from: c */
    public abstract void mo8738c(Context context, String str);

    @Override // p000.apv
    public boolean callRecoverableError(Context context, String str) {
        return true;
    }

    /* JADX INFO: renamed from: d */
    protected void m10929d(Context context, Intent intent) {
    }

    protected BaseIntentService() {
        super("AgooIntentService");
    }

    @Override // android.app.IntentService
    public final void onHandleIntent(Intent intent) throws Throwable {
        Context applicationContext;
        boolean zM4903p;
        Context context = null;
        boolean z = false;
        try {
            try {
                applicationContext = getApplicationContext();
                try {
                    zM4903p = apo.m4903p(applicationContext);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (Throwable th3) {
            th = th3;
            applicationContext = context;
        }
        try {
            app appVar = (app) arh.m5265a(applicationContext, "org.android.agoo.impl.ControlService");
            if (appVar != null) {
                appVar.onHandleIntent(applicationContext, intent, this);
            }
            if (zM4903p) {
                m10925d(applicationContext, "0");
            }
        } catch (Throwable th4) {
            th = th4;
            z = zM4903p;
            if (z) {
                m10925d(applicationContext, "0");
            }
            throw th;
        }
    }

    /* JADX INFO: renamed from: d */
    private void m10925d(Context context, String str) {
        boolean zM4882b;
        String[] strArrSplit;
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && (zM4882b = apo.m4882b(context, System.currentTimeMillis())) && apx.isRegistered(context)) {
                    m10923a(context);
                    if (apo.m4901n(context) && zM4882b && apx.isRegistered(context)) {
                        Log.w("BaseIntentService", "auto update [download]");
                        apt aptVar = (apt) arh.m5265a(context, "org.android.agoo.impl.UpdateService");
                        if (!TextUtils.isEmpty(str) && str.contains(".") && (strArrSplit = str.split("\\.")) != null && strArrSplit.length > 0) {
                            str = strArrSplit[strArrSplit.length - 1];
                        }
                        aptVar.m4914a(context, "push", str);
                    }
                }
            } catch (Throwable th) {
                Log.w("BaseIntentService", " onHandleIntent---isNeedAutoUpdate", th);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    static final void m10924a(Context context, Intent intent, String str) {
        try {
            Log.d("BaseIntentService", "runIntent to receive one message" + intent + "|" + str);
            intent.setClassName(context, str);
            context.startService(intent);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "runIntentInService", th);
        }
    }

    @Override // p000.apv
    public Class<?> callAgooService() {
        try {
            return mo8734a();
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callAgooService", th);
            return null;
        }
    }

    @Override // p000.apv
    public final boolean callShouldProcessMessage(Context context, Intent intent) {
        try {
            return m10927b(context, intent);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callShouldProcessMessage", th);
            return false;
        }
    }

    @Override // p000.apv
    public final void callUserCommand(Context context, Intent intent) {
        try {
            m10928c(context, intent);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callUserCommand", th);
        }
    }

    public final void callUserHandleIntent(Context context, Intent intent) {
        try {
            m10929d(context, intent);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callUserHandleIntent", th);
        }
    }

    @Override // p000.apv
    public final void callMessage(Context context, Intent intent) {
        try {
            mo8735a(context, intent);
        } catch (Throwable unused) {
        }
    }

    @Override // p000.apv
    public final void callError(Context context, String str) {
        try {
            Log.w("BaseIntentService", "callError[" + str + "]");
            mo8736a(context, str);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callError", th);
        }
    }

    @Override // p000.apv
    public final void callRegistered(Context context, String str) {
        try {
            mo8737b(context, str);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callRegistered", th);
        }
    }

    @Override // p000.apv
    public final void callUnregistered(Context context, String str) {
        try {
            mo8738c(context, str);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callUnregistered", th);
        }
    }

    public final void callDeletedMessages(Context context, int i) {
        try {
            m10926a(context, i);
        } catch (Throwable th) {
            Log.w("BaseIntentService", "callDeletedMessages", th);
        }
    }

    /* JADX INFO: renamed from: a */
    private final void m10923a(Context context) {
        if (context != null) {
            try {
                Log.v("BaseIntentService", "auto update [updateSwitchConfig]");
                apq apqVar = (apq) arh.m5265a(context, "org.android.agoo.impl.MtopService");
                apz apzVar = new apz();
                apzVar.m4967a("mtop.wswitch.syncconfiggroup");
                apzVar.m4970b("1.0");
                apzVar.m4968a("configName", "client_sdk_switch");
                aqb v3 = apqVar.getV3(context, apzVar);
                if (v3.m4984a()) {
                    String strM4985b = v3.m4985b();
                    try {
                        JSONObject jSONObject = new JSONObject(strM4985b);
                        String str = (String) jSONObject.get("autoUpdate");
                        String str2 = (String) jSONObject.get("multiplex");
                        String str3 = (String) jSONObject.get("spdy");
                        long j = Long.parseLong((String) jSONObject.get("updateCycle"));
                        String str4 = (String) jSONObject.get("postData");
                        boolean zEquals = "true".equals(str);
                        boolean zEquals2 = "true".equals(str2);
                        boolean zEquals3 = "true".equals(str3);
                        boolean zEquals4 = "true".equals(str4);
                        if (j == 0) {
                            j = 86400;
                        }
                        apo.m4877a(context, zEquals, zEquals2, zEquals3, j, zEquals4);
                    } catch (Throwable unused) {
                        arj.m5272a().m5274a(context, "updateConfig", "ERROR_EVENT_UPDATECONFIG_ERROR", "content=" + strM4985b);
                    }
                } else {
                    arj.m5272a().m5274a(context, "updateConfig", "ERROR_EVENT_UPDATECONFIG_ERROR", "result=" + v3.toString());
                }
                apo.m4872a(context, System.currentTimeMillis());
            } catch (Throwable unused2) {
            }
        }
    }
}
