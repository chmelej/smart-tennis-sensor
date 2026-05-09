package cn.smssdk.contact.p010a;

import cn.smssdk.utils.SMSLog;
import com.mob.tools.utils.Hashon;
import java.io.Serializable;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.smssdk.contact.a.b */
/* JADX INFO: compiled from: ContactObject.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0920b implements Serializable {

    /* JADX INFO: renamed from: a */
    private static final HashMap<String, Class<? extends AbstractC0920b>> f6037a = new HashMap<>();

    /* JADX INFO: renamed from: b */
    private HashMap<String, Object> f6038b;

    static {
        f6037a.put("vnd.android.cursor.item/name", C0926h.class);
        f6037a.put("vnd.android.cursor.item/nickname", C0927i.class);
        f6037a.put("vnd.android.cursor.item/group_membership", C0923e.class);
        f6037a.put("vnd.android.cursor.item/organization", C0929k.class);
        f6037a.put("vnd.android.cursor.item/contact_event", C0922d.class);
        f6037a.put("vnd.android.cursor.item/photo", C0931m.class);
        f6037a.put("vnd.android.cursor.item/note", C0928j.class);
        f6037a.put("vnd.android.cursor.item/website", C0935q.class);
        f6037a.put("vnd.android.cursor.item/im", C0925g.class);
        f6037a.put("vnd.android.cursor.item/email_v2", C0921c.class);
        f6037a.put("vnd.android.cursor.item/phone_v2", C0930l.class);
        f6037a.put("vnd.android.cursor.item/postal-address_v2", C0932n.class);
        f6037a.put("vnd.android.cursor.item/relation", C0933o.class);
        f6037a.put("vnd.android.cursor.item/sip_address", C0934p.class);
        f6037a.put("vnd.android.cursor.item/identity", C0924f.class);
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0920b m6659a(HashMap<String, Object> map) {
        Class<? extends AbstractC0920b> cls = f6037a.get((String) map.get("mimetype"));
        if (cls == null) {
            return null;
        }
        try {
            AbstractC0920b abstractC0920bNewInstance = cls.newInstance();
            abstractC0920bNewInstance.m6664b(map);
            return abstractC0920bNewInstance;
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            return null;
        }
    }

    /* JADX INFO: renamed from: b */
    protected void m6664b(HashMap<String, Object> map) {
        this.f6038b = map;
    }

    /* JADX INFO: renamed from: a */
    protected byte[] m6662a(String str) {
        return (byte[]) this.f6038b.get(str);
    }

    /* JADX INFO: renamed from: b */
    protected String m6663b(String str) {
        return (String) this.f6038b.get(str);
    }

    /* JADX INFO: renamed from: a */
    protected int m6660a(String str, int i) {
        Object obj = this.f6038b.get(str);
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            return i;
        }
    }

    public String toString() {
        return this.f6038b == null ? "" : new Hashon().fromHashMap(this.f6038b);
    }

    /* JADX INFO: renamed from: a */
    protected HashMap<String, Object> m6661a() {
        return this.f6038b;
    }
}
