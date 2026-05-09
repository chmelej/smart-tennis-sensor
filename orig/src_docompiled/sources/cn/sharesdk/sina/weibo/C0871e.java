package cn.sharesdk.sina.weibo;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.text.TextUtils;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Data;
import java.util.List;

/* JADX INFO: renamed from: cn.sharesdk.sina.weibo.e */
/* JADX INFO: compiled from: WeiboAppManager.java */
/* JADX INFO: loaded from: classes.dex */
public class C0871e {

    /* JADX INFO: renamed from: a */
    private static final Uri f5753a = Uri.parse("content://com.sina.weibo.sdkProvider/query/package");

    /* JADX INFO: renamed from: b */
    private static C0871e f5754b;

    /* JADX INFO: renamed from: c */
    private static a f5755c;

    /* JADX INFO: renamed from: d */
    private Context f5756d;

    /* JADX INFO: renamed from: cn.sharesdk.sina.weibo.e$a */
    /* JADX INFO: compiled from: WeiboAppManager.java */
    public static class a {

        /* JADX INFO: renamed from: a */
        private String f5757a;

        /* JADX INFO: renamed from: b */
        private int f5758b;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m6280a(String str) {
            this.f5757a = str;
        }

        /* JADX INFO: renamed from: a */
        public String m6281a() {
            return this.f5757a;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: a */
        public void m6277a(int i) {
            this.f5758b = i;
        }

        /* JADX INFO: renamed from: b */
        public int m6282b() {
            return this.f5758b;
        }

        public String toString() {
            return "WeiboInfo: PackageName = " + this.f5757a + ", supportApi = " + this.f5758b;
        }
    }

    private C0871e(Context context) {
        this.f5756d = context.getApplicationContext();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized C0871e m6269a(Context context) {
        if (f5754b == null) {
            f5754b = new C0871e(context);
        }
        return f5754b;
    }

    /* JADX INFO: renamed from: a */
    public synchronized String m6276a() {
        if (f5755c == null) {
            f5755c = m6272b(this.f5756d);
        }
        return f5755c.m6281a();
    }

    /* JADX INFO: renamed from: b */
    private a m6272b(Context context) throws Throwable {
        a aVarM6273c = m6273c(context);
        a aVarM6274d = m6274d(context);
        boolean z = aVarM6273c != null;
        boolean z2 = aVarM6274d != null;
        if (z && z2) {
            return aVarM6273c.m6282b() >= aVarM6274d.m6282b() ? aVarM6273c : aVarM6274d;
        }
        if (z) {
            return aVarM6273c;
        }
        if (z2) {
            return aVarM6274d;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0077 A[PHI: r0
      0x0077: PHI (r0v6 android.database.Cursor) = (r0v5 android.database.Cursor), (r0v7 android.database.Cursor) binds: [B:32:0x0075, B:23:0x005d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX INFO: renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private cn.sharesdk.sina.weibo.C0871e.a m6273c(android.content.Context r8) throws java.lang.Throwable {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r8.getContentResolver()
            r6 = 0
            android.net.Uri r1 = cn.sharesdk.sina.weibo.C0871e.f5753a     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L62 java.lang.Exception -> L65
            if (r0 != 0) goto L17
            if (r0 == 0) goto L16
            r0.close()
        L16:
            return r6
        L17:
            java.lang.String r1 = "support_api"
            int r1 = r0.getColumnIndex(r1)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            java.lang.String r2 = "package"
            int r2 = r0.getColumnIndex(r2)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            boolean r3 = r0.moveToFirst()     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            if (r3 == 0) goto L5d
            r3 = -1
            java.lang.String r1 = r0.getString(r1)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: java.lang.NumberFormatException -> L33 java.lang.Exception -> L60 java.lang.Throwable -> L7b
            goto L3c
        L33:
            r1 = move-exception
            com.mob.tools.log.NLog r4 = cn.sharesdk.framework.utils.C0851d.m6195a()     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            r4.m8610d(r1)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            r1 = -1
        L3c:
            java.lang.String r2 = r0.getString(r2)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            if (r3 != 0) goto L5d
            boolean r8 = m6270a(r8, r2)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            if (r8 == 0) goto L5d
            cn.sharesdk.sina.weibo.e$a r8 = new cn.sharesdk.sina.weibo.e$a     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            r8.<init>()     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            cn.sharesdk.sina.weibo.C0871e.a.m6279a(r8, r2)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            cn.sharesdk.sina.weibo.C0871e.a.m6278a(r8, r1)     // Catch: java.lang.Exception -> L60 java.lang.Throwable -> L7b
            if (r0 == 0) goto L5c
            r0.close()
        L5c:
            return r8
        L5d:
            if (r0 == 0) goto L7a
            goto L77
        L60:
            r8 = move-exception
            goto L67
        L62:
            r8 = move-exception
            r0 = r6
            goto L7c
        L65:
            r8 = move-exception
            r0 = r6
        L67:
            com.mob.tools.log.NLog r1 = cn.sharesdk.framework.utils.C0851d.m6195a()     // Catch: java.lang.Throwable -> L7b
            java.lang.String r8 = r8.getMessage()     // Catch: java.lang.Throwable -> L7b
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Throwable -> L7b
            r1.m8612e(r8, r2)     // Catch: java.lang.Throwable -> L7b
            if (r0 == 0) goto L7a
        L77:
            r0.close()
        L7a:
            return r6
        L7b:
            r8 = move-exception
        L7c:
            if (r0 == 0) goto L81
            r0.close()
        L81:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.sina.weibo.C0871e.m6273c(android.content.Context):cn.sharesdk.sina.weibo.e$a");
    }

    /* JADX INFO: renamed from: d */
    private a m6274d(Context context) {
        a aVarM6275a;
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        List<ResolveInfo> listQueryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        a aVar = null;
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            return null;
        }
        for (ResolveInfo resolveInfo : listQueryIntentServices) {
            if (resolveInfo.serviceInfo != null && resolveInfo.serviceInfo.applicationInfo != null && !TextUtils.isEmpty(resolveInfo.serviceInfo.applicationInfo.packageName) && (aVarM6275a = m6275a(resolveInfo.serviceInfo.applicationInfo.packageName)) != null && (aVar == null || aVar.m6282b() < aVarM6275a.m6282b())) {
                aVar = aVarM6275a;
            }
        }
        return aVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX INFO: renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public cn.sharesdk.sina.weibo.C0871e.a m6275a(java.lang.String r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 224
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.sina.weibo.C0871e.m6275a(java.lang.String):cn.sharesdk.sina.weibo.e$a");
    }

    /* JADX INFO: renamed from: a */
    public static boolean m6270a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return m6271a(context.getPackageManager().getPackageInfo(str, 64).signatures, "18da2bf10352443a00a5e046d9fca6bd");
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    private static boolean m6271a(Signature[] signatureArr, String str) {
        if (signatureArr == null || str == null) {
            return false;
        }
        for (Signature signature : signatureArr) {
            if (str.equals(Data.MD5(signature.toByteArray()))) {
                C0851d.m6195a().m8609d("check pass", new Object[0]);
                return true;
            }
        }
        return false;
    }
}
