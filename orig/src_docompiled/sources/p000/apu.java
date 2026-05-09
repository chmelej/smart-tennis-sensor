package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.v4.widget.ExploreByTouchHelper;
import android.text.TextUtils;
import android.util.Log;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/* JADX INFO: compiled from: AgooSettings.java */
/* JADX INFO: loaded from: classes.dex */
public final class apu {
    /* JADX INFO: renamed from: a */
    public static final long m4922a() {
        return 20151208L;
    }

    /* JADX INFO: renamed from: a */
    public static final String m4924a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    public static final SharedPreferences m4930b(Context context) {
        try {
            return context.getSharedPreferences("AppStore", 4);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: c */
    public static final void m4932c(Context context) {
        apo.m4870a(context);
    }

    /* JADX INFO: renamed from: d */
    public static final String m4934d(Context context) {
        return apo.m4878b(context);
    }

    /* JADX INFO: renamed from: e */
    public static final void m4935e(Context context) {
        apo.m4894g(context);
    }

    /* JADX INFO: renamed from: f */
    public static final String m4936f(Context context) {
        return apo.m4883c(context);
    }

    /* JADX INFO: renamed from: g */
    public static final String m4937g(Context context) {
        try {
            return m4930b(context).getString("app_key_temp", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: h */
    public static final String m4938h(Context context) {
        return apo.m4887d(context);
    }

    /* JADX INFO: renamed from: i */
    public static final String m4939i(Context context) {
        try {
            return m4930b(context).getString("app_tt_id_temp", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: j */
    public static final String m4940j(Context context) {
        return apo.m4890e(context);
    }

    /* JADX INFO: renamed from: k */
    public static final String m4941k(Context context) {
        try {
            return m4930b(context).getString("app_sercet_temp", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX INFO: renamed from: l */
    public static final String m4942l(Context context) {
        return m4944n(context);
    }

    /* JADX INFO: renamed from: m */
    public static final boolean m4943m(Context context) {
        return !TextUtils.isEmpty(m4944n(context));
    }

    /* JADX INFO: renamed from: n */
    public static final String m4944n(Context context) {
        return apo.m4892f(context);
    }

    /* JADX INFO: renamed from: o */
    public static String m4945o(Context context) {
        try {
            return m4930b(context).getString("app_device_token_temp", "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m4926a(Context context, long j, String str) {
        try {
            SharedPreferences.Editor editorEdit = m4930b(context).edit();
            editorEdit.putLong("app_sudo_pack_timeout", j);
            editorEdit.putString("app_election_source", str);
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: p */
    public static final String m4946p(Context context) {
        try {
            return m4930b(context).getString("app_election_source", "local");
        } catch (Throwable unused) {
            return "local";
        }
    }

    /* JADX INFO: renamed from: q */
    public static final long m4947q(Context context) {
        try {
            return m4930b(context).getLong("app_sudo_pack_timeout", -1L);
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX INFO: renamed from: r */
    public static final int m4948r(Context context) {
        try {
            return m4930b(context).getInt("backoff_count", 0);
        } catch (Throwable th) {
            Log.w("Settings", "getBackoffCount", th);
            return 0;
        }
    }

    /* JADX INFO: renamed from: s */
    public static final void m4949s(Context context) {
        m4925a(context, 0);
    }

    /* JADX INFO: renamed from: a */
    public static final void m4925a(Context context, int i) {
        try {
            SharedPreferences.Editor editorEdit = m4930b(context).edit();
            editorEdit.putInt("backoff_count", i);
            editorEdit.commit();
        } catch (Throwable th) {
            Log.w("Settings", "setBackOffCount", th);
        }
    }

    /* JADX INFO: renamed from: t */
    public static final void m4950t(Context context) {
        try {
            SharedPreferences sharedPreferencesM4930b = m4930b(context);
            int i = sharedPreferencesM4930b.getInt("app_retry_register", 0) + 1;
            SharedPreferences.Editor editorEdit = sharedPreferencesM4930b.edit();
            editorEdit.putInt("app_retry_register", i);
            editorEdit.commit();
        } catch (Throwable th) {
            Log.w("Settings", "setRetryRegisterCount", th);
        }
    }

    /* JADX INFO: renamed from: u */
    public static final int m4951u(Context context) {
        try {
            return m4930b(context).getInt("app_retry_register", 0);
        } catch (Throwable th) {
            Log.w("Settings", "getRetryRegisterCount", th);
            return 0;
        }
    }

    /* JADX INFO: renamed from: v */
    public static final void m4952v(Context context) {
        try {
            SharedPreferences.Editor editorEdit = m4930b(context).edit();
            editorEdit.putInt("app_retry_register", 0);
            editorEdit.commit();
        } catch (Throwable th) {
            Log.w("Settings", "RestRetryRegisterCount", th);
        }
    }

    /* JADX INFO: renamed from: a */
    private static final String m4923a(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(j));
        } catch (Throwable unused) {
            return "none";
        }
    }

    /* JADX INFO: renamed from: w */
    public static final boolean m4953w(Context context) {
        try {
            long j = m4930b(context).getLong("app_last_register_time ", -1L);
            String strM4923a = j != -1 ? m4923a(j) : "";
            String strM4923a2 = m4923a(System.currentTimeMillis());
            if (j != -1) {
                return !strM4923a2.equals(strM4923a);
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    /* JADX INFO: renamed from: a */
    public static final void m4927a(Context context, String str) {
        try {
            SharedPreferences sharedPreferencesM4930b = m4930b(context);
            int iM4900m = apo.m4900m(context);
            SharedPreferences.Editor editorEdit = sharedPreferencesM4930b.edit();
            editorEdit.putString("app_device_token", str);
            editorEdit.putString("app_device_token_temp", str);
            editorEdit.putInt("app_version", iM4900m);
            editorEdit.putLong("app_last_register_time ", System.currentTimeMillis());
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: x */
    public static final void m4954x(Context context) {
        try {
            SharedPreferences.Editor editorEdit = m4930b(context).edit();
            editorEdit.putBoolean("app_disable", true);
            editorEdit.putInt("app_disable_version", apo.m4900m(context));
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: y */
    public static final void m4955y(Context context) {
        try {
            SharedPreferences.Editor editorEdit = m4930b(context).edit();
            editorEdit.putBoolean("app_disable", false);
            editorEdit.putInt("app_disable_version", apo.m4900m(context));
            editorEdit.commit();
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: renamed from: z */
    public static final boolean m4956z(Context context) {
        return m4929a(context, false);
    }

    /* JADX INFO: renamed from: a */
    public static final boolean m4929a(Context context, boolean z) {
        try {
            SharedPreferences sharedPreferencesM4930b = m4930b(context);
            boolean z2 = sharedPreferencesM4930b.getBoolean("app_disable", false);
            if (!z) {
                return z2;
            }
            try {
                int i = sharedPreferencesM4930b.getInt("app_disable_version", ExploreByTouchHelper.INVALID_ID);
                int iM4900m = apo.m4900m(context);
                if (i == Integer.MIN_VALUE || i == iM4900m) {
                    return z2;
                }
                m4955y(context);
                m4935e(context);
                return false;
            } catch (Throwable unused) {
                return z2;
            }
        } catch (Throwable unused2) {
            return false;
        }
    }

    /* JADX INFO: renamed from: A */
    public static final String m4915A(Context context) {
        return apo.m4895h(context);
    }

    /* JADX INFO: renamed from: b */
    public static void m4931b(Context context, String str) {
        apo.m4873a(context, str);
    }

    /* JADX INFO: renamed from: B */
    public static final void m4916B(Context context) {
        apo.m4896i(context);
    }

    /* JADX INFO: renamed from: C */
    public static final long m4917C(Context context) {
        try {
            SharedPreferences sharedPreferencesM4930b = m4930b(context);
            int i = sharedPreferencesM4930b.getInt("agoo_start_time", -1);
            int i2 = sharedPreferencesM4930b.getInt("agoo_end_time", -1);
            if (i == -1 || i2 == -1) {
                return -1L;
            }
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i3 = (calendar.get(11) * 60 * 60) + (calendar.get(12) * 60) + calendar.get(13);
            if (i3 < i) {
                calendar.add(13, i - i3);
            } else {
                if (i3 <= i2) {
                    return -1L;
                }
                calendar.add(13, (i - i3) + 86400);
            }
            return calendar.getTimeInMillis();
        } catch (Throwable unused) {
            return -1L;
        }
    }

    /* JADX INFO: renamed from: D */
    public static final boolean m4918D(Context context) {
        return apo.m4899l(context);
    }

    /* JADX INFO: renamed from: E */
    public static final boolean m4919E(Context context) {
        try {
            int i = m4930b(context).getInt("agoo_mode", EnumC0716a.f4602d.m4957a());
            if (i != EnumC0716a.f4602d.m4957a()) {
                return i != EnumC0716a.f4603e.m4957a();
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: F */
    public static final String m4920F(Context context) {
        return m4921G(context).mo4961e();
    }

    /* JADX INFO: renamed from: a */
    public static final void m4928a(Context context, boolean z, boolean z2) {
        if (context != null) {
            try {
                apo.m4876a(context, z, z2);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public static void m4933c(Context context, String str) {
        if (context != null) {
            try {
                apo.m4880b(context, str);
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: renamed from: G */
    public static final EnumC0716a m4921G(Context context) {
        try {
            int i = m4930b(context).getInt("agoo_mode", EnumC0716a.f4603e.m4957a());
            if (i != 2) {
                switch (i) {
                    case -2:
                        return EnumC0716a.f4599a;
                    case -1:
                        return EnumC0716a.f4600b;
                    case 0:
                        return EnumC0716a.f4601c;
                    default:
                        return EnumC0716a.f4603e;
                }
            }
            return EnumC0716a.f4602d;
        } catch (Throwable unused) {
            return EnumC0716a.f4603e;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'a' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: renamed from: apu$a */
    /* JADX INFO: compiled from: AgooSettings.java */
    public static abstract class EnumC0716a {

        /* JADX INFO: renamed from: a */
        @Deprecated
        public static final EnumC0716a f4599a;

        /* JADX INFO: renamed from: b */
        @Deprecated
        public static final EnumC0716a f4600b;

        /* JADX INFO: renamed from: c */
        @Deprecated
        public static final EnumC0716a f4601c;

        /* JADX INFO: renamed from: d */
        public static final EnumC0716a f4602d;

        /* JADX INFO: renamed from: e */
        public static final EnumC0716a f4603e;

        /* JADX INFO: renamed from: g */
        private static final /* synthetic */ EnumC0716a[] f4604g;

        /* JADX INFO: renamed from: f */
        private int f4605f;

        /* JADX INFO: renamed from: b */
        public abstract int mo4958b();

        /* JADX INFO: renamed from: c */
        public abstract String mo4959c();

        /* JADX INFO: renamed from: d */
        public abstract String mo4960d();

        /* JADX INFO: renamed from: e */
        public abstract String mo4961e();

        public static EnumC0716a valueOf(String str) {
            return (EnumC0716a) Enum.valueOf(EnumC0716a.class, str);
        }

        public static EnumC0716a[] values() {
            return (EnumC0716a[]) f4604g.clone();
        }

        static {
            int i = 0;
            f4599a = new EnumC0716a("TEST_SINGLE", i, -2) { // from class: apu.a.1
                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: b */
                public final int mo4958b() {
                    return 80;
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: c */
                public final String mo4959c() {
                    return "http://apoll.m.taobao.com";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: d */
                public final String mo4960d() {
                    return "100.67.1.238";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: e */
                public final String mo4961e() {
                    return "http://api.waptest.taobao.com/rest/api3.do";
                }
            };
            int i2 = 1;
            f4600b = new EnumC0716a("TEST", i2, -1) { // from class: apu.a.2
                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: b */
                public final int mo4958b() {
                    return 80;
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: c */
                public final String mo4959c() {
                    return "http://apoll.m.taobao.com";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: d */
                public final String mo4960d() {
                    return "100.67.1.238";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: e */
                public final String mo4961e() {
                    return "http://api.waptest.taobao.com/rest/api3.do";
                }
            };
            int i3 = 2;
            f4601c = new EnumC0716a("PREVIEW", i3, i) { // from class: apu.a.3
                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: b */
                public final int mo4958b() {
                    return 80;
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: c */
                public final String mo4959c() {
                    return "http://apoll.m.taobao.com";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: d */
                public final String mo4960d() {
                    return "42.120.80.36";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: e */
                public final String mo4961e() {
                    return "http://api.wapa.taobao.com/rest/api3.do";
                }
            };
            f4602d = new EnumC0716a("TAOBAO", 3, i3) { // from class: apu.a.4
                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: b */
                public final int mo4958b() {
                    return 80;
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: c */
                public final String mo4959c() {
                    return "http://apoll.m.taobao.com";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: d */
                public final String mo4960d() {
                    return "42.120.111.1";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: e */
                public final String mo4961e() {
                    return "http://api.m.taobao.com/rest/api3.do";
                }
            };
            f4603e = new EnumC0716a("RELEASE", 4, i2) { // from class: apu.a.5
                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: b */
                public final int mo4958b() {
                    return 80;
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: c */
                public final String mo4959c() {
                    return "http://upoll.umengcloud.com";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: d */
                public final String mo4960d() {
                    return "42.120.111.1";
                }

                @Override // p000.apu.EnumC0716a
                /* JADX INFO: renamed from: e */
                public final String mo4961e() {
                    return "https://utop.umengcloud.com/rest/api3.do";
                }
            };
            f4604g = new EnumC0716a[]{f4599a, f4600b, f4601c, f4602d, f4603e};
        }

        private EnumC0716a(String str, int i, int i2) {
            this.f4605f = i2;
        }

        /* JADX INFO: renamed from: a */
        public final int m4957a() {
            return this.f4605f;
        }
    }
}
