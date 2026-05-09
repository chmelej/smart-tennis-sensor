package cn.smssdk.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.widget.Toast;
import cn.smssdk.contact.p010a.C0919a;
import cn.smssdk.contact.p010a.C0921c;
import cn.smssdk.contact.p010a.C0922d;
import cn.smssdk.contact.p010a.C0923e;
import cn.smssdk.contact.p010a.C0925g;
import cn.smssdk.contact.p010a.C0926h;
import cn.smssdk.contact.p010a.C0927i;
import cn.smssdk.contact.p010a.C0928j;
import cn.smssdk.contact.p010a.C0929k;
import cn.smssdk.contact.p010a.C0930l;
import cn.smssdk.contact.p010a.C0931m;
import cn.smssdk.contact.p010a.C0932n;
import cn.smssdk.contact.p010a.C0933o;
import cn.smssdk.contact.p010a.C0935q;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.tools.FakeActivity;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.UIHandler;
import com.umeng.message.MessageStore;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: renamed from: cn.smssdk.contact.b */
/* JADX INFO: compiled from: ContactHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0936b {

    /* JADX INFO: renamed from: a */
    private static C0936b f6039a;

    /* JADX INFO: renamed from: b */
    private static ContentObserver f6040b;

    /* JADX INFO: renamed from: c */
    private Context f6041c;

    /* JADX INFO: renamed from: d */
    private ContentResolver f6042d;

    /* JADX INFO: renamed from: e */
    private C0937c f6043e;

    /* JADX INFO: renamed from: f */
    private OnContactChangeListener f6044f;

    /* JADX INFO: renamed from: g */
    private C0938d f6045g;

    /* JADX INFO: renamed from: h */
    private String f6046h;

    /* JADX INFO: renamed from: a */
    public static C0936b m6707a(Context context) {
        if (f6039a == null) {
            f6039a = new C0936b(context);
        }
        return f6039a;
    }

    private C0936b(Context context) {
        this.f6041c = context.getApplicationContext();
        this.f6042d = context.getContentResolver();
        this.f6043e = new C0937c(context, this.f6042d);
        m6713c();
        this.f6045g = new C0938d(context, this);
        this.f6046h = new File(context.getFilesDir(), ".cb").getAbsolutePath();
    }

    /* JADX INFO: renamed from: c */
    private void m6713c() {
        if (f6040b == null) {
            f6040b = new ContentObserver(new Handler()) { // from class: cn.smssdk.contact.b.1
                @Override // android.database.ContentObserver
                public void onChange(boolean z) {
                    C0936b.this.f6045g.m6731a();
                    if (C0936b.this.f6044f != null) {
                        C0936b.this.f6044f.onContactChange(z);
                    }
                }
            };
        }
        try {
            this.f6042d.unregisterContentObserver(f6040b);
            this.f6042d.registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, f6040b);
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m6717a() {
        m6719a(new Runnable() { // from class: cn.smssdk.contact.b.2
            @Override // java.lang.Runnable
            public void run() {
                C0936b.this.f6045g.m6731a();
            }
        }, (Runnable) null);
    }

    /* JADX INFO: renamed from: a */
    public void m6719a(Runnable runnable, Runnable runnable2) {
        try {
            if (!DeviceHelper.getInstance(this.f6041c).checkPermission("android.permission.READ_CONTACTS")) {
                m6715e();
                if (runnable2 != null) {
                    runnable2.run();
                    return;
                }
                return;
            }
            if (SPHelper.getInstance(this.f6041c).isWarnWhenReadContact()) {
                if (SPHelper.getInstance(this.f6041c).isAllowReadContact()) {
                    if (runnable != null) {
                        runnable.run();
                        return;
                    }
                    return;
                } else {
                    if (ViewOnClickListenerC0918a.m6634a()) {
                        ViewOnClickListenerC0918a.m6633a(runnable, runnable2);
                        return;
                    }
                    ViewOnClickListenerC0918a viewOnClickListenerC0918a = new ViewOnClickListenerC0918a();
                    ViewOnClickListenerC0918a.m6633a(runnable, runnable2);
                    viewOnClickListenerC0918a.showForResult(this.f6041c, null, new FakeActivity() { // from class: cn.smssdk.contact.b.3
                        @Override // com.mob.tools.FakeActivity
                        public void onResult(HashMap<String, Object> map) {
                            if ("true".equals(String.valueOf(map.get("res")))) {
                                SPHelper.getInstance(C0936b.this.f6041c).setAllowReadContact();
                                for (Runnable runnable3 : (ArrayList) map.get("okActions")) {
                                    if (runnable3 != null) {
                                        runnable3.run();
                                    }
                                }
                                return;
                            }
                            for (Runnable runnable4 : (ArrayList) map.get("cancelActions")) {
                                if (runnable4 != null) {
                                    runnable4.run();
                                }
                            }
                        }
                    });
                    return;
                }
            }
            SPHelper.getInstance(this.f6041c).setAllowReadContact();
            if (runnable != null) {
                runnable.run();
            }
        } catch (Throwable th) {
            m6715e();
            SMSLog.getInstance().m8622w(th);
            if (runnable2 != null) {
                runnable2.run();
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6720b(final Runnable runnable, final Runnable runnable2) {
        m6719a(new Runnable() { // from class: cn.smssdk.contact.b.4
            /* JADX WARN: Type inference failed for: r0v0, types: [cn.smssdk.contact.b$4$1] */
            @Override // java.lang.Runnable
            public void run() {
                new Thread() { // from class: cn.smssdk.contact.b.4.1
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        try {
                            C0936b.this.m6711b(true);
                            if (runnable != null) {
                                runnable.run();
                            }
                        } catch (Throwable th) {
                            SMSLog.getInstance().m8622w(th);
                        }
                    }
                }.start();
            }
        }, new Runnable() { // from class: cn.smssdk.contact.b.5
            @Override // java.lang.Runnable
            public void run() {
                if (runnable2 != null) {
                    runnable2.run();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public synchronized void m6711b(boolean z) {
        SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.onRebuild", new Object[0]);
        if (!z && new File(this.f6046h).exists()) {
            SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.onRebuild.quickfinish", new Object[0]);
            return;
        }
        SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.onRebuild.start", new Object[0]);
        ArrayList arrayList = new ArrayList();
        String str = Build.VERSION.SDK_INT <= 10 ? MessageStore.f9157Id : "name_raw_contact_id";
        Uri uri = Build.VERSION.SDK_INT <= 9 ? ContactsContract.RawContacts.CONTENT_URI : ContactsContract.Contacts.CONTENT_URI;
        SMSLog.getInstance().m8609d(">>>>>>>>> query: " + uri, new Object[0]);
        ArrayList<HashMap<String, Object>> arrayListM6722a = this.f6043e.m6722a(uri, new String[]{str}, null, null, "sort_key asc");
        if (arrayListM6722a != null) {
            SMSLog.getInstance().m8609d(">>>>>>>>> found: " + arrayListM6722a.size() + " ids", new Object[0]);
            Iterator<HashMap<String, Object>> it = arrayListM6722a.iterator();
            while (it.hasNext()) {
                String str2 = (String) it.next().get(str);
                if (str2 != null) {
                    arrayList.add(new C0919a(this.f6043e, str2));
                }
            }
        }
        SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.onRebuild.buffercontacts", new Object[0]);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new GZIPOutputStream(new FileOutputStream(this.f6046h)));
        objectOutputStream.writeInt(arrayList.size());
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            byte[] bytes = ((C0919a) it2.next()).toString().getBytes("utf-8");
            objectOutputStream.writeInt(bytes.length);
            objectOutputStream.write(bytes);
        }
        objectOutputStream.flush();
        objectOutputStream.close();
        SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.onRebuild.buffercontacts.finish", new Object[0]);
    }

    /* JADX INFO: renamed from: d */
    private ArrayList<C0919a> m6714d() {
        SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.getContacts", new Object[0]);
        if (this.f6046h == null) {
            return new ArrayList<>();
        }
        File file = new File(this.f6046h);
        try {
            if (!file.exists()) {
                m6711b(false);
            } else if (file.length() <= 28) {
                m6711b(true);
            }
            ObjectInputStream objectInputStream = new ObjectInputStream(new GZIPInputStream(new FileInputStream(this.f6046h)));
            int i = objectInputStream.readInt();
            SMSLog.getInstance().m8609d(">>>>>>>>> found: " + i + " contacts", new Object[0]);
            ArrayList<C0919a> arrayList = new ArrayList<>(i);
            for (int i2 = 0; i2 < i; i2++) {
                byte[] bArr = new byte[objectInputStream.readInt()];
                objectInputStream.readFully(bArr);
                arrayList.add(new C0919a(new String(bArr, "utf-8")));
            }
            objectInputStream.close();
            SMSLog.getInstance().m8609d(">>>>>>>>> ContactHelper.getContacts.finish", new Object[0]);
            return arrayList;
        } catch (Throwable th) {
            if (file.exists()) {
                file.delete();
            }
            SMSLog.getInstance().m8622w(th);
            return new ArrayList<>();
        }
    }

    /* JADX INFO: renamed from: a */
    public ArrayList<HashMap<String, Object>> m6716a(boolean z) {
        ArrayList<C0919a> arrayListM6714d;
        ArrayList arrayList;
        C0931m c0931mM6649e;
        ArrayList arrayList2;
        if (!DeviceHelper.getInstance(this.f6041c).checkPermission("android.permission.READ_CONTACTS") || (arrayListM6714d = m6714d()) == null) {
            return null;
        }
        ArrayList<HashMap<String, Object>> arrayList3 = new ArrayList<>();
        for (C0919a c0919a : arrayListM6714d) {
            HashMap<String, Object> map = new HashMap<>();
            C0926h c0926hM6645a = c0919a.m6645a();
            if (c0926hM6645a != null) {
                String strM6678b = c0926hM6645a.m6678b();
                if (!TextUtils.isEmpty(strM6678b)) {
                    map.put("prefixname", strM6678b);
                }
                String strM6679c = c0926hM6645a.m6679c();
                if (!TextUtils.isEmpty(strM6679c)) {
                    map.put("suffixname", strM6679c);
                }
                String strM6680d = c0926hM6645a.m6680d();
                if (!TextUtils.isEmpty(strM6680d)) {
                    map.put("lastname", strM6680d);
                }
                String strM6681e = c0926hM6645a.m6681e();
                if (!TextUtils.isEmpty(strM6681e)) {
                    map.put("firstname", strM6681e);
                }
                String strM6682f = c0926hM6645a.m6682f();
                if (!TextUtils.isEmpty(strM6682f)) {
                    map.put("displayname", strM6682f);
                }
                String strM6685i = c0926hM6645a.m6685i();
                if (TextUtils.isEmpty(strM6685i)) {
                    arrayList2 = null;
                } else {
                    HashMap map2 = new HashMap();
                    map2.put("key", "phonetic");
                    ArrayList arrayList4 = new ArrayList();
                    arrayList4.add(strM6685i);
                    map2.put("vals", arrayList4);
                    arrayList2 = new ArrayList();
                    map.put("others", arrayList2);
                    arrayList2.add(map2);
                }
                String strM6683g = c0926hM6645a.m6683g();
                if (!TextUtils.isEmpty(strM6683g)) {
                    HashMap map3 = new HashMap();
                    map3.put("key", "phoneticfirstname");
                    ArrayList arrayList5 = new ArrayList();
                    arrayList5.add(strM6683g);
                    map3.put("vals", arrayList5);
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        map.put("others", arrayList2);
                    }
                    arrayList2.add(map3);
                }
                String strM6684h = c0926hM6645a.m6684h();
                if (TextUtils.isEmpty(strM6684h)) {
                    arrayList = arrayList2;
                } else {
                    HashMap map4 = new HashMap();
                    map4.put("key", "phoneticlastname");
                    ArrayList arrayList6 = new ArrayList();
                    arrayList6.add(strM6684h);
                    map4.put("vals", arrayList6);
                    if (arrayList2 == null) {
                        arrayList = new ArrayList();
                        map.put("others", arrayList);
                    } else {
                        arrayList = arrayList2;
                    }
                    arrayList.add(map4);
                }
            } else {
                arrayList = null;
            }
            C0927i c0927iM6646b = c0919a.m6646b();
            if (c0927iM6646b != null) {
                String strM6686b = c0927iM6646b.m6686b();
                if (!TextUtils.isEmpty(strM6686b)) {
                    map.put("nickname", strM6686b);
                }
            }
            C0929k c0929kM6648d = c0919a.m6648d();
            if (c0929kM6648d != null) {
                String strM6688b = c0929kM6648d.m6688b();
                if (!TextUtils.isEmpty(strM6688b)) {
                    map.put("company", strM6688b);
                }
                String strM6689c = c0929kM6648d.m6689c();
                if (!TextUtils.isEmpty(strM6689c)) {
                    map.put("position", strM6689c);
                }
            }
            ArrayList<C0930l> arrayListM6654j = c0919a.m6654j();
            if (arrayListM6654j != null) {
                ArrayList arrayList7 = null;
                for (C0930l c0930l : arrayListM6654j) {
                    String strM6691b = c0930l.m6691b();
                    if (!TextUtils.isEmpty(strM6691b)) {
                        if (arrayList7 == null) {
                            arrayList7 = new ArrayList();
                            map.put("phones", arrayList7);
                        }
                        HashMap map5 = new HashMap();
                        map5.put("phone", strM6691b);
                        map5.put("type", Integer.valueOf(c0930l.m6692c()));
                        map5.put("desc", c0930l.m6693d());
                        arrayList7.add(map5);
                    }
                }
            }
            ArrayList<C0921c> arrayListM6653i = c0919a.m6653i();
            if (arrayListM6653i != null) {
                ArrayList arrayList8 = null;
                for (C0921c c0921c : arrayListM6653i) {
                    String strM6666b = c0921c.m6666b();
                    if (!TextUtils.isEmpty(strM6666b)) {
                        if (arrayList8 == null) {
                            arrayList8 = new ArrayList();
                            map.put("mails", arrayList8);
                        }
                        HashMap map6 = new HashMap();
                        map6.put(NotificationCompat.CATEGORY_EMAIL, strM6666b);
                        map6.put("type", Integer.valueOf(c0921c.m6667c()));
                        map6.put("desc", c0921c.m6668d());
                        arrayList8.add(map6);
                    }
                }
            }
            ArrayList<C0932n> arrayListM6655k = c0919a.m6655k();
            if (arrayListM6655k != null) {
                ArrayList arrayList9 = null;
                for (C0932n c0932n : arrayListM6655k) {
                    String strM6696b = c0932n.m6696b();
                    if (!TextUtils.isEmpty(strM6696b)) {
                        if (arrayList9 == null) {
                            arrayList9 = new ArrayList();
                            map.put("addresses", arrayList9);
                        }
                        HashMap map7 = new HashMap();
                        map7.put("address", strM6696b);
                        map7.put("type", Integer.valueOf(c0932n.m6697c()));
                        map7.put("desc", c0932n.m6698d());
                        arrayList9.add(map7);
                    }
                }
            }
            ArrayList<C0922d> arrayListM6656l = c0919a.m6656l();
            if (arrayListM6656l != null) {
                ArrayList arrayList10 = null;
                for (C0922d c0922d : arrayListM6656l) {
                    String strM6670b = c0922d.m6670b();
                    if (!TextUtils.isEmpty(strM6670b)) {
                        if (arrayList10 == null) {
                            arrayList10 = new ArrayList();
                            map.put("specialdate", arrayList10);
                        }
                        HashMap map8 = new HashMap();
                        map8.put("date", strM6670b);
                        map8.put("type", Integer.valueOf(c0922d.m6671c()));
                        map8.put("desc", c0922d.m6672d());
                        arrayList10.add(map8);
                    }
                }
            }
            ArrayList<C0925g> arrayListM6652h = c0919a.m6652h();
            if (arrayListM6652h != null) {
                ArrayList arrayList11 = null;
                for (C0925g c0925g : arrayListM6652h) {
                    String strM6675b = c0925g.m6675b();
                    if (!TextUtils.isEmpty(strM6675b)) {
                        if (arrayList11 == null) {
                            arrayList11 = new ArrayList();
                            map.put("ims", arrayList11);
                        }
                        HashMap map9 = new HashMap();
                        map9.put("val", strM6675b);
                        map9.put("type", Integer.valueOf(c0925g.m6676c()));
                        map9.put("desc", c0925g.m6677d());
                        arrayList11.add(map9);
                    }
                }
            }
            C0923e c0923eM6647c = c0919a.m6647c();
            if (c0923eM6647c != null) {
                String strM6673b = c0923eM6647c.m6673b();
                if (!TextUtils.isEmpty(strM6673b)) {
                    map.put("group", strM6673b);
                }
            }
            C0928j c0928jM6650f = c0919a.m6650f();
            if (c0928jM6650f != null) {
                String strM6687b = c0928jM6650f.m6687b();
                if (!TextUtils.isEmpty(strM6687b)) {
                    map.put("remarks", strM6687b);
                }
            }
            ArrayList<C0935q> arrayListM6651g = c0919a.m6651g();
            if (arrayListM6651g != null) {
                ArrayList arrayList12 = null;
                for (C0935q c0935q : arrayListM6651g) {
                    String strM6704b = c0935q.m6704b();
                    if (!TextUtils.isEmpty(strM6704b)) {
                        if (arrayList12 == null) {
                            arrayList12 = new ArrayList();
                            map.put("websites", arrayList12);
                        }
                        HashMap map10 = new HashMap();
                        map10.put("val", strM6704b);
                        map10.put("type", Integer.valueOf(c0935q.m6705c()));
                        map10.put("desc", c0935q.m6706d());
                        arrayList12.add(map10);
                    }
                }
            }
            ArrayList<C0933o> arrayListM6657m = c0919a.m6657m();
            if (arrayListM6657m != null) {
                ArrayList arrayList13 = null;
                for (C0933o c0933o : arrayListM6657m) {
                    String strM6700b = c0933o.m6700b();
                    if (!TextUtils.isEmpty(strM6700b)) {
                        if (arrayList13 == null) {
                            arrayList13 = new ArrayList();
                            map.put("relations", arrayList13);
                        }
                        HashMap map11 = new HashMap();
                        map11.put("val", strM6700b);
                        map11.put("type", Integer.valueOf(c0933o.m6701c()));
                        map11.put("desc", c0933o.m6702d());
                        arrayList13.add(map11);
                    }
                }
            }
            if (z && (c0931mM6649e = c0919a.m6649e()) != null) {
                String strM6694b = c0931mM6649e.m6694b();
                if (!TextUtils.isEmpty(strM6694b)) {
                    HashMap map12 = new HashMap();
                    map12.put("key", "avatar");
                    ArrayList arrayList14 = new ArrayList();
                    arrayList14.add(strM6694b);
                    map12.put("vals", arrayList14);
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                        map.put("others", arrayList);
                    }
                    arrayList.add(map12);
                }
            }
            arrayList3.add(map);
        }
        return arrayList3;
    }

    /* JADX INFO: renamed from: b */
    public String[] m6721b() {
        ArrayList<C0919a> arrayListM6714d = m6714d();
        if (arrayListM6714d == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Iterator<C0919a> it = arrayListM6714d.iterator();
        while (it.hasNext()) {
            ArrayList<C0930l> arrayListM6654j = it.next().m6654j();
            if (arrayListM6654j != null) {
                Iterator<C0930l> it2 = arrayListM6654j.iterator();
                while (it2.hasNext()) {
                    String strM6691b = it2.next().m6691b();
                    if (!TextUtils.isEmpty(strM6691b)) {
                        hashSet.add(strM6691b);
                    }
                }
            }
        }
        String[] strArr = new String[hashSet.size()];
        int i = 0;
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            strArr[i] = (String) it3.next();
            i++;
        }
        if (strArr.length > 0) {
            return strArr;
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m6718a(OnContactChangeListener onContactChangeListener) {
        this.f6044f = onContactChangeListener;
    }

    /* JADX INFO: renamed from: e */
    private void m6715e() {
        if (SPHelper.getInstance(this.f6041c).isWarnWhenReadContact()) {
            UIHandler.sendEmptyMessage(1, new Handler.Callback() { // from class: cn.smssdk.contact.b.6
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    if (message.what == 1) {
                        Toast.makeText(C0936b.this.f6041c, "zh".equals(DeviceHelper.getInstance(C0936b.this.f6041c).getOSLanguage()) ? String.valueOf(new char[]{24212, 29992, 26080, 26435, 38480, 35835, 21462, 36890, 35759, 24405}) : "no permission to read contacts", 0).show();
                    }
                    return false;
                }
            });
        }
    }
}
