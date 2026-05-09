package cn.smssdk.contact.p010a;

import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;
import cn.smssdk.contact.C0937c;
import cn.smssdk.utils.SMSLog;
import com.mob.tools.utils.Hashon;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.litepal.util.Const;

/* JADX INFO: renamed from: cn.smssdk.contact.a.a */
/* JADX INFO: compiled from: Contact.java */
/* JADX INFO: loaded from: classes.dex */
public class C0919a implements Serializable {

    /* JADX INFO: renamed from: a */
    private String f6021a;

    /* JADX INFO: renamed from: b */
    private C0926h f6022b;

    /* JADX INFO: renamed from: c */
    private C0927i f6023c;

    /* JADX INFO: renamed from: d */
    private C0923e f6024d;

    /* JADX INFO: renamed from: e */
    private C0929k f6025e;

    /* JADX INFO: renamed from: f */
    private ArrayList<C0922d> f6026f;

    /* JADX INFO: renamed from: g */
    private C0931m f6027g;

    /* JADX INFO: renamed from: h */
    private C0928j f6028h;

    /* JADX INFO: renamed from: i */
    private ArrayList<C0935q> f6029i;

    /* JADX INFO: renamed from: j */
    private ArrayList<C0925g> f6030j;

    /* JADX INFO: renamed from: k */
    private ArrayList<C0921c> f6031k;

    /* JADX INFO: renamed from: l */
    private ArrayList<C0930l> f6032l;

    /* JADX INFO: renamed from: m */
    private ArrayList<C0932n> f6033m;

    /* JADX INFO: renamed from: n */
    private ArrayList<C0934p> f6034n;

    /* JADX INFO: renamed from: o */
    private ArrayList<C0933o> f6035o;

    /* JADX INFO: renamed from: p */
    private C0924f f6036p;

    public C0919a(String str) {
        try {
            HashMap mapFromJson = new Hashon().fromJson(str);
            if (mapFromJson == null) {
                return;
            }
            HashMap map = (HashMap) mapFromJson.get(Const.TableSchema.COLUMN_NAME);
            if (map != null) {
                this.f6022b = (C0926h) AbstractC0920b.m6659a((HashMap<String, Object>) map);
            }
            HashMap map2 = (HashMap) mapFromJson.get("nickname");
            if (map2 != null) {
                this.f6023c = (C0927i) AbstractC0920b.m6659a((HashMap<String, Object>) map2);
            }
            HashMap map3 = (HashMap) mapFromJson.get("group");
            if (map3 != null) {
                this.f6024d = (C0923e) AbstractC0920b.m6659a((HashMap<String, Object>) map3);
            }
            HashMap map4 = (HashMap) mapFromJson.get("organization");
            if (map4 != null) {
                this.f6025e = (C0929k) AbstractC0920b.m6659a((HashMap<String, Object>) map4);
            }
            ArrayList arrayList = (ArrayList) mapFromJson.get(NotificationCompat.CATEGORY_EVENT);
            if (arrayList != null) {
                if (this.f6026f == null) {
                    this.f6026f = new ArrayList<>();
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    this.f6026f.add((C0922d) AbstractC0920b.m6659a((HashMap<String, Object>) it.next()));
                }
            }
            HashMap map5 = (HashMap) mapFromJson.get("photo");
            if (map5 != null) {
                this.f6027g = (C0931m) AbstractC0920b.m6659a((HashMap<String, Object>) map5);
            }
            HashMap map6 = (HashMap) mapFromJson.get("note");
            if (map6 != null) {
                this.f6028h = (C0928j) AbstractC0920b.m6659a((HashMap<String, Object>) map6);
            }
            ArrayList arrayList2 = (ArrayList) mapFromJson.get("websites");
            if (arrayList2 != null) {
                if (this.f6029i == null) {
                    this.f6029i = new ArrayList<>();
                }
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    this.f6029i.add((C0935q) AbstractC0920b.m6659a((HashMap<String, Object>) it2.next()));
                }
            }
            ArrayList arrayList3 = (ArrayList) mapFromJson.get("ims");
            if (arrayList3 != null) {
                if (this.f6030j == null) {
                    this.f6030j = new ArrayList<>();
                }
                Iterator it3 = arrayList3.iterator();
                while (it3.hasNext()) {
                    this.f6030j.add((C0925g) AbstractC0920b.m6659a((HashMap<String, Object>) it3.next()));
                }
            }
            ArrayList arrayList4 = (ArrayList) mapFromJson.get("emails");
            if (arrayList4 != null) {
                if (this.f6031k == null) {
                    this.f6031k = new ArrayList<>();
                }
                Iterator it4 = arrayList4.iterator();
                while (it4.hasNext()) {
                    this.f6031k.add((C0921c) AbstractC0920b.m6659a((HashMap<String, Object>) it4.next()));
                }
            }
            ArrayList arrayList5 = (ArrayList) mapFromJson.get("phones");
            if (arrayList5 != null) {
                if (this.f6032l == null) {
                    this.f6032l = new ArrayList<>();
                }
                Iterator it5 = arrayList5.iterator();
                while (it5.hasNext()) {
                    this.f6032l.add((C0930l) AbstractC0920b.m6659a((HashMap<String, Object>) it5.next()));
                }
            }
            ArrayList arrayList6 = (ArrayList) mapFromJson.get("postals");
            if (arrayList6 != null) {
                if (this.f6033m == null) {
                    this.f6033m = new ArrayList<>();
                }
                Iterator it6 = arrayList6.iterator();
                while (it6.hasNext()) {
                    this.f6033m.add((C0932n) AbstractC0920b.m6659a((HashMap<String, Object>) it6.next()));
                }
            }
            ArrayList arrayList7 = (ArrayList) mapFromJson.get("sipAddresses");
            if (arrayList7 != null) {
                if (this.f6034n == null) {
                    this.f6034n = new ArrayList<>();
                }
                Iterator it7 = arrayList7.iterator();
                while (it7.hasNext()) {
                    this.f6034n.add((C0934p) AbstractC0920b.m6659a((HashMap<String, Object>) it7.next()));
                }
            }
            ArrayList arrayList8 = (ArrayList) mapFromJson.get("relations");
            if (arrayList8 != null) {
                if (this.f6035o == null) {
                    this.f6035o = new ArrayList<>();
                }
                Iterator it8 = arrayList8.iterator();
                while (it8.hasNext()) {
                    this.f6035o.add((C0933o) AbstractC0920b.m6659a((HashMap<String, Object>) it8.next()));
                }
            }
            HashMap map7 = (HashMap) mapFromJson.get("identity");
            if (map7 != null) {
                this.f6036p = (C0924f) AbstractC0920b.m6659a((HashMap<String, Object>) map7);
            }
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
        }
    }

    public C0919a(C0937c c0937c, String str) {
        this.f6021a = str;
        m6644a(c0937c);
    }

    /* JADX INFO: renamed from: a */
    private void m6644a(C0937c c0937c) {
        if (this.f6021a == null) {
            return;
        }
        ArrayList<HashMap<String, Object>> arrayListM6722a = c0937c.m6722a(ContactsContract.Data.CONTENT_URI, null, "raw_contact_id=" + this.f6021a, null, null);
        if (arrayListM6722a == null) {
            return;
        }
        for (HashMap<String, Object> map : arrayListM6722a) {
            AbstractC0920b abstractC0920bM6659a = AbstractC0920b.m6659a(map);
            if (abstractC0920bM6659a != null) {
                if (abstractC0920bM6659a instanceof C0926h) {
                    this.f6022b = (C0926h) abstractC0920bM6659a;
                } else if (abstractC0920bM6659a instanceof C0927i) {
                    this.f6023c = (C0927i) abstractC0920bM6659a;
                } else if (abstractC0920bM6659a instanceof C0923e) {
                    ArrayList<HashMap<String, Object>> arrayListM6722a2 = c0937c.m6722a(ContactsContract.Groups.CONTENT_URI, null, "_id=" + map.get("data1"), null, null);
                    if (arrayListM6722a2 != null && arrayListM6722a2.size() > 0) {
                        HashMap<String, Object> map2 = arrayListM6722a2.get(0);
                        map2.put("mimetype", "vnd.android.cursor.item/group_membership");
                        this.f6024d = (C0923e) AbstractC0920b.m6659a(map2);
                    }
                } else if (abstractC0920bM6659a instanceof C0929k) {
                    this.f6025e = (C0929k) abstractC0920bM6659a;
                } else if (abstractC0920bM6659a instanceof C0922d) {
                    if (this.f6026f == null) {
                        this.f6026f = new ArrayList<>();
                    }
                    this.f6026f.add((C0922d) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0931m) {
                    this.f6027g = (C0931m) abstractC0920bM6659a;
                } else if (abstractC0920bM6659a instanceof C0928j) {
                    this.f6028h = (C0928j) abstractC0920bM6659a;
                } else if (abstractC0920bM6659a instanceof C0935q) {
                    if (this.f6029i == null) {
                        this.f6029i = new ArrayList<>();
                    }
                    this.f6029i.add((C0935q) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0925g) {
                    if (this.f6030j == null) {
                        this.f6030j = new ArrayList<>();
                    }
                    this.f6030j.add((C0925g) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0921c) {
                    if (this.f6031k == null) {
                        this.f6031k = new ArrayList<>();
                    }
                    this.f6031k.add((C0921c) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0930l) {
                    if (this.f6032l == null) {
                        this.f6032l = new ArrayList<>();
                    }
                    this.f6032l.add((C0930l) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0932n) {
                    if (this.f6033m == null) {
                        this.f6033m = new ArrayList<>();
                    }
                    this.f6033m.add((C0932n) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0933o) {
                    if (this.f6033m == null) {
                        this.f6035o = new ArrayList<>();
                    }
                    this.f6035o.add((C0933o) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0934p) {
                    if (this.f6034n == null) {
                        this.f6034n = new ArrayList<>();
                    }
                    this.f6034n.add((C0934p) abstractC0920bM6659a);
                } else if (abstractC0920bM6659a instanceof C0924f) {
                    this.f6036p = (C0924f) abstractC0920bM6659a;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public C0926h m6645a() {
        return this.f6022b;
    }

    /* JADX INFO: renamed from: b */
    public C0927i m6646b() {
        return this.f6023c;
    }

    /* JADX INFO: renamed from: c */
    public C0923e m6647c() {
        return this.f6024d;
    }

    /* JADX INFO: renamed from: d */
    public C0929k m6648d() {
        return this.f6025e;
    }

    /* JADX INFO: renamed from: e */
    public C0931m m6649e() {
        return this.f6027g;
    }

    /* JADX INFO: renamed from: f */
    public C0928j m6650f() {
        return this.f6028h;
    }

    /* JADX INFO: renamed from: g */
    public ArrayList<C0935q> m6651g() {
        return this.f6029i;
    }

    /* JADX INFO: renamed from: h */
    public ArrayList<C0925g> m6652h() {
        return this.f6030j;
    }

    /* JADX INFO: renamed from: i */
    public ArrayList<C0921c> m6653i() {
        return this.f6031k;
    }

    /* JADX INFO: renamed from: j */
    public ArrayList<C0930l> m6654j() {
        return this.f6032l;
    }

    /* JADX INFO: renamed from: k */
    public ArrayList<C0932n> m6655k() {
        return this.f6033m;
    }

    /* JADX INFO: renamed from: l */
    public ArrayList<C0922d> m6656l() {
        return this.f6026f;
    }

    /* JADX INFO: renamed from: m */
    public ArrayList<C0933o> m6657m() {
        return this.f6035o;
    }

    public String toString() {
        return new Hashon().fromHashMap(m6658n());
    }

    /* JADX INFO: renamed from: n */
    public HashMap<String, Object> m6658n() {
        HashMap<String, Object> map = new HashMap<>();
        if (this.f6022b != null) {
            map.put(Const.TableSchema.COLUMN_NAME, this.f6022b.m6661a());
        }
        if (this.f6023c != null) {
            map.put("nickname", this.f6023c.m6661a());
        }
        if (this.f6024d != null) {
            map.put("group", this.f6024d.m6661a());
        }
        if (this.f6025e != null) {
            map.put("organization", this.f6025e.m6661a());
        }
        if (this.f6026f != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<C0922d> it = this.f6026f.iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().m6661a());
            }
            map.put("events", arrayList);
        }
        if (this.f6027g != null) {
            map.put("photo", this.f6027g.m6661a());
        }
        if (this.f6028h != null) {
            map.put("note", this.f6028h.m6661a());
        }
        if (this.f6029i != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<C0935q> it2 = this.f6029i.iterator();
            while (it2.hasNext()) {
                arrayList2.add(it2.next().m6661a());
            }
            map.put("websites", arrayList2);
        }
        if (this.f6030j != null) {
            ArrayList arrayList3 = new ArrayList();
            Iterator<C0925g> it3 = this.f6030j.iterator();
            while (it3.hasNext()) {
                arrayList3.add(it3.next().m6661a());
            }
            map.put("ims", arrayList3);
        }
        if (this.f6031k != null) {
            ArrayList arrayList4 = new ArrayList();
            Iterator<C0921c> it4 = this.f6031k.iterator();
            while (it4.hasNext()) {
                arrayList4.add(it4.next().m6661a());
            }
            map.put("emails", arrayList4);
        }
        if (this.f6032l != null) {
            ArrayList arrayList5 = new ArrayList();
            Iterator<C0930l> it5 = this.f6032l.iterator();
            while (it5.hasNext()) {
                arrayList5.add(it5.next().m6661a());
            }
            map.put("phones", arrayList5);
        }
        if (this.f6033m != null) {
            ArrayList arrayList6 = new ArrayList();
            Iterator<C0932n> it6 = this.f6033m.iterator();
            while (it6.hasNext()) {
                arrayList6.add(it6.next().m6661a());
            }
            map.put("postals", arrayList6);
        }
        if (this.f6034n != null) {
            ArrayList arrayList7 = new ArrayList();
            Iterator<C0934p> it7 = this.f6034n.iterator();
            while (it7.hasNext()) {
                arrayList7.add(it7.next().m6661a());
            }
            map.put("sipAddresses", arrayList7);
        }
        if (this.f6035o != null) {
            ArrayList arrayList8 = new ArrayList();
            Iterator<C0933o> it8 = this.f6035o.iterator();
            while (it8.hasNext()) {
                arrayList8.add(it8.next().m6661a());
            }
            map.put("relations", arrayList8);
        }
        if (this.f6036p != null) {
            map.put("identity", this.f6036p.m6661a());
        }
        return map;
    }
}
