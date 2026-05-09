package p000;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

/* JADX INFO: compiled from: BaseRegistrar.java */
/* JADX INFO: loaded from: classes.dex */
public class apx {
    public static final String AGOO_COMMAND_SOMANAGER = "so_manager";

    @Deprecated
    public static final void checkDevice(Context context) {
    }

    /* JADX INFO: renamed from: a */
    protected static final apq m4962a(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return (apq) arh.m5265a(context, "org.android.agoo.impl.MtopService");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    protected static final void m4963a(Context context, String str, String str2, String str3) {
        m4964a(context, str, str2, str3, true);
    }

    /* JADX INFO: renamed from: a */
    protected static final void m4964a(Context context, String str, String str2, String str3, boolean z) {
        if (context != null) {
            try {
                if (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
                    return;
                }
                if (TextUtils.isEmpty(str2)) {
                    apo.m4875a(context, true);
                }
                apo.m4874a(context, str, str2, str3);
                Intent intentM4988a = aqc.m4988a(context, "register");
                if (intentM4988a != null) {
                    context.sendBroadcast(intentM4988a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void unregister(Context context) {
        if (context != null) {
            try {
                Intent intentM4988a = aqc.m4988a(context, "unregister");
                if (intentM4988a != null) {
                    context.sendBroadcast(intentM4988a);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static final String getRegistrationId(Context context) {
        if (context == null) {
            return null;
        }
        try {
            return apo.m4892f(context);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static final boolean isRegistered(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return !TextUtils.isEmpty(apo.m4892f(context));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static final void setDebug(Context context, boolean z, boolean z2) {
        if (context != null) {
            try {
                apo.m4876a(context, z, z2);
            } catch (Throwable unused) {
            }
        }
    }

    public static final void setAgooMode(Context context, apy apyVar) {
        if (context != null) {
            try {
                apo.m4871a(context, apyVar.m4965a());
            } catch (Throwable unused) {
            }
        }
    }

    public static final void sendAsynMtop(Context context, apz apzVar, aqa aqaVar) {
        if (context != null) {
            try {
                apq apqVarM4962a = m4962a(context);
                if (apqVarM4962a != null) {
                    apqVarM4962a.sendMtop(context, apzVar, aqaVar);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static final void sendAsynMtop(Context context, apz apzVar) {
        try {
            apq apqVarM4962a = m4962a(context);
            if (apqVarM4962a != null) {
                apqVarM4962a.sendMtop(context, apzVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static final void sendSynMtop(Context context, apz apzVar) {
        try {
            apq apqVarM4962a = m4962a(context);
            if (apqVarM4962a != null) {
                apqVarM4962a.getV3(context, apzVar);
            }
        } catch (Throwable unused) {
        }
    }

    public static final void setAutoUpdate(Context context, boolean z) {
        if (context != null) {
            try {
                apo.m4881b(context, z);
            } catch (Throwable unused) {
            }
        }
    }

    public static final void pingMessage(Context context, boolean z) {
        if (context != null) {
            try {
                apo.m4886c(context, z);
            } catch (Throwable unused) {
            }
        }
    }

    public static final void setServiceProtect(Context context, boolean z) {
        if (context != null) {
            try {
                apo.m4889d(context, z);
            } catch (Throwable unused) {
            }
        }
    }

    public static final void sendSoTimeout(Context context, int i) {
        if (context != null) {
            try {
                Intent intentM4988a = aqc.m4988a(context, AGOO_COMMAND_SOMANAGER);
                if (intentM4988a != null) {
                    intentM4988a.putExtra("soTimeout", i);
                    context.sendBroadcast(intentM4988a);
                }
            } catch (Throwable unused) {
            }
        }
    }
}
