package p000;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: NotificationRuntimeCache.java */
/* JADX INFO: loaded from: classes.dex */
public class ajo {

    /* JADX INFO: renamed from: a */
    private static final String f1341a = "ajo";

    /* JADX INFO: renamed from: b */
    private final Context f1342b;

    public ajo(Context context) {
        this.f1342b = context;
    }

    /* JADX INFO: renamed from: a */
    public void m1592a(int i) {
        try {
            SharedPreferences sharedPreferences = this.f1342b.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
            SharedPreferences.Editor editorEdit = sharedPreferences.edit();
            synchronized (sharedPreferences) {
                editorEdit.putString("" + i, "");
                editorEdit.commit();
            }
            atj.m5423a(f1341a, "add nid [" + i + "] to runtime cache.");
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    public List<Integer> m1591a() {
        ArrayList arrayList = new ArrayList();
        try {
            SharedPreferences sharedPreferences = this.f1342b.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
            Iterator<String> it = sharedPreferences.getAll().keySet().iterator();
            while (it.hasNext()) {
                try {
                    int i = Integer.parseInt(it.next());
                    arrayList.add(Integer.valueOf(i));
                    atj.m5423a(f1341a, "get nid [" + i + "]");
                } catch (NumberFormatException unused) {
                }
            }
            sharedPreferences.edit().clear().commit();
        } catch (Exception unused2) {
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: b */
    public boolean m1594b() {
        return this.f1342b.getSharedPreferences("UMENG_RUNTIME_CACHE", 0).getAll().size() > 0;
    }

    /* JADX INFO: renamed from: b */
    public void m1593b(int i) {
        try {
            SharedPreferences sharedPreferences = this.f1342b.getSharedPreferences("UMENG_RUNTIME_CACHE", 0);
            if (sharedPreferences.contains("" + i)) {
                SharedPreferences.Editor editorEdit = sharedPreferences.edit();
                editorEdit.remove("" + i);
                editorEdit.commit();
            }
            atj.m5423a(f1341a, "remove nid [" + i + "] to runtime cache.");
        } catch (Exception unused) {
        }
    }
}
