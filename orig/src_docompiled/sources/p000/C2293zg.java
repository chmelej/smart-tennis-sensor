package p000;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: renamed from: zg */
/* JADX INFO: loaded from: classes.dex */
public final class C2293zg {

    /* JADX INFO: renamed from: zg$a */
    public static class a {

        /* JADX INFO: renamed from: a */
        public String f13781a;

        /* JADX INFO: renamed from: b */
        public String f13782b;

        /* JADX INFO: renamed from: c */
        public String f13783c;

        /* JADX INFO: renamed from: d */
        public Bundle f13784d;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m12544a(Context context, a aVar) {
        String str;
        String str2;
        if (context == null || aVar == null) {
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, invalid argument";
        } else {
            if (!C2299zm.m12563a(aVar.f13782b)) {
                String str3 = null;
                if (!C2299zm.m12563a(aVar.f13781a)) {
                    str3 = aVar.f13781a + ".permission.MM_MESSAGE";
                }
                Intent intent = new Intent(aVar.f13782b);
                if (aVar.f13784d != null) {
                    intent.putExtras(aVar.f13784d);
                }
                String packageName = context.getPackageName();
                intent.putExtra("_mmessage_sdkVersion", 570490883);
                intent.putExtra("_mmessage_appPackage", packageName);
                intent.putExtra("_mmessage_content", aVar.f13783c);
                intent.putExtra("_mmessage_checksum", C2294zh.m12545a(aVar.f13783c, 570490883, packageName));
                context.sendBroadcast(intent, str3);
                C2295zi.m12552d("MicroMsg.SDK.MMessage", "send mm message, intent=" + intent + ", perm=" + str3);
                return true;
            }
            str = "MicroMsg.SDK.MMessage";
            str2 = "send fail, action is null";
        }
        C2295zi.m12548a(str, str2);
        return false;
    }
}
