package p000;

import android.content.Context;
import android.content.Intent;
import com.umeng.message.local.UmengLocalNotificationService;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: UmengLocalNotificationManager.java */
/* JADX INFO: loaded from: classes.dex */
public class ahj {

    /* JADX INFO: renamed from: a */
    private static final String f1022a = "ahj";

    /* JADX INFO: renamed from: b */
    private static ahj f1023b;

    /* JADX INFO: renamed from: c */
    private Context f1024c;

    private ahj(Context context) {
        this.f1024c = context;
    }

    /* JADX INFO: renamed from: a */
    public static synchronized ahj m1134a(Context context) {
        if (f1023b == null) {
            f1023b = new ahj(context);
        }
        return f1023b;
    }

    /* JADX INFO: renamed from: a */
    public synchronized ahh m1136a(String str) {
        ahh ahhVarM1145a;
        try {
            ahhVarM1145a = ahk.m1144a(this.f1024c).m1145a(str);
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
            ahhVarM1145a = null;
        }
        return ahhVarM1145a;
    }

    /* JADX INFO: renamed from: b */
    public synchronized List<ahh> m1139b(String str) {
        List<ahh> listM1148b;
        try {
            listM1148b = ahk.m1144a(this.f1024c).m1148b(str);
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
            listM1148b = null;
        }
        return listM1148b;
    }

    /* JADX INFO: renamed from: a */
    public synchronized List<ahh> m1137a() {
        List<ahh> listM1146a;
        listM1146a = null;
        try {
            listM1146a = ahk.m1144a(this.f1024c).m1146a();
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
        }
        return listM1146a;
    }

    /* JADX INFO: renamed from: a */
    public synchronized boolean m1138a(ahh ahhVar) {
        if (ahhVar == null) {
            ahb.m1043c(f1022a, "localNotification is null");
            return false;
        }
        if (!ahhVar.m1127q()) {
            ahb.m1043c(f1022a, "Please reset date time for localNotification");
            return false;
        }
        if (!ahhVar.m1105a(this.f1024c)) {
            ahb.m1043c(f1022a, "Please reset relavent data for localNotification");
            return false;
        }
        try {
            if (m1136a(ahhVar.m1102a()) != null) {
                ahb.m1043c(f1022a, "add local notification has exists");
                return false;
            }
            ahk.m1144a(this.f1024c).m1147a(ahhVar);
            m1135a(ahhVar.m1102a(), "add_local_notification");
            return true;
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m1141b(ahh ahhVar) {
        if (ahhVar == null) {
            ahb.m1043c(f1022a, "localNotification is null");
            return false;
        }
        if (!ahhVar.m1127q()) {
            ahb.m1043c(f1022a, "Please reset date time for localNotification");
            return false;
        }
        if (!ahhVar.m1105a(this.f1024c)) {
            ahb.m1043c(f1022a, "Please reset relavent data for localNotification");
            return false;
        }
        try {
            ahk.m1144a(this.f1024c).m1150b(ahhVar);
            m1135a(ahhVar.m1102a(), "update_local_notification");
            return true;
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public synchronized boolean m1143c(String str) {
        try {
            ahh ahhVarM1136a = m1136a(str);
            if (ahhVarM1136a == null) {
                ahb.m1043c(f1022a, "localNotification is null");
                return false;
            }
            ahk.m1144a(this.f1024c).m1151c(str);
            m1135a(ahhVarM1136a.m1102a(), "delete_local_notification");
            return true;
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: b */
    public synchronized boolean m1140b() {
        try {
            List<ahh> listM1137a = m1137a();
            if (listM1137a != null && listM1137a.size() != 0) {
                ahk.m1144a(this.f1024c).m1149b();
                String str = "";
                Iterator<ahh> it = listM1137a.iterator();
                while (it.hasNext()) {
                    str = str + it.next().m1102a() + ";";
                }
                m1135a(str.substring(0, str.length() - 1), "clear_local_notification");
                return false;
            }
            ahb.m1043c(f1022a, "list is empty");
            return false;
        } catch (Exception e) {
            ahb.m1043c(f1022a, e.toString());
            e.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: renamed from: c */
    public void m1142c() {
        Iterator<ahh> it = m1137a().iterator();
        while (it.hasNext()) {
            m1135a(it.next().m1102a(), "update_local_notification");
        }
    }

    /* JADX INFO: renamed from: a */
    private void m1135a(String str, String str2) {
        Intent intent = new Intent();
        intent.setClass(this.f1024c, UmengLocalNotificationService.class);
        intent.putExtra("local_notification_id", str);
        intent.putExtra("local_notification_type", str2);
        this.f1024c.startService(intent);
    }
}
