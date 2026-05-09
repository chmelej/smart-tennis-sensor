package cn.smssdk.p008a;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import cn.smssdk.contact.C0936b;
import cn.smssdk.net.C0981f;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: renamed from: cn.smssdk.a.a */
/* JADX INFO: compiled from: SocialHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class C0915a {

    /* JADX INFO: renamed from: a */
    private static C0915a f5980a;

    /* JADX INFO: renamed from: b */
    private C0981f f5981b;

    /* JADX INFO: renamed from: c */
    private SPHelper f5982c;

    /* JADX INFO: renamed from: d */
    private C0916b f5983d;

    /* JADX INFO: renamed from: e */
    private C0936b f5984e;

    /* JADX INFO: renamed from: a */
    public static C0915a m6608a(Context context) {
        if (f5980a == null) {
            f5980a = new C0915a(context);
        }
        return f5980a;
    }

    private C0915a(Context context) {
        this.f5981b = C0981f.m6812a(context);
        this.f5982c = SPHelper.getInstance(context);
        this.f5983d = new C0916b(context, this);
        this.f5984e = C0936b.m6707a(context);
    }

    /* JADX INFO: renamed from: a */
    public void m6617a(String str, String str2, String str3, String str4, String str5) throws Throwable {
        this.f5981b.m6816a(str, str2, str3, str4, str5);
    }

    /* JADX INFO: renamed from: a */
    public void m6616a(final Handler.Callback callback) {
        if (m6610a()) {
            m6613c(new Handler.Callback() { // from class: cn.smssdk.a.a.1
                @Override // android.os.Handler.Callback
                public boolean handleMessage(Message message) {
                    Message message2 = new Message();
                    try {
                        ArrayList<HashMap<String, Object>> arrayListM6614a = C0915a.this.m6614a(C0915a.this.f5981b.m6813a((String[]) message.obj));
                        try {
                            C0915a.this.f5982c.setBufferedNewFriends(arrayListM6614a);
                            C0915a.this.f5982c.setRequestNewFriendsTime();
                        } catch (Throwable th) {
                            SMSLog.getInstance().m8622w(th);
                        }
                        message2.what = 1;
                        message2.obj = Integer.valueOf(arrayListM6614a.size());
                    } catch (Throwable th2) {
                        message2.what = 0;
                        message2.obj = th2;
                    }
                    callback.handleMessage(message2);
                    return false;
                }
            });
            return;
        }
        Message message = new Message();
        message.what = 1;
        try {
            message.obj = Integer.valueOf(this.f5982c.getBufferedNewFriends().size());
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            message.obj = 0;
        }
        callback.handleMessage(message);
    }

    /* JADX INFO: renamed from: a */
    private boolean m6610a() {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int i = calendar.get(1);
        int i2 = calendar.get(2);
        int i3 = calendar.get(5);
        calendar.setTimeInMillis(this.f5982c.getLastRequestNewFriendsTime());
        return (i == calendar.get(1) && i2 == calendar.get(2) && i3 == calendar.get(5)) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: renamed from: a */
    protected ArrayList<HashMap<String, Object>> m6614a(ArrayList<HashMap<String, Object>> arrayList) {
        ArrayList<HashMap<String, Object>> arrayList2;
        ArrayList<HashMap<String, Object>> arrayList3;
        try {
            arrayList2 = this.f5982c.getBufferedFriends();
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            arrayList2 = new ArrayList<>();
        }
        HashMap map = new HashMap();
        for (HashMap<String, Object> map2 : arrayList) {
            Object obj = map2.get("phone");
            if (obj != null) {
                boolean z = true;
                Iterator<HashMap<String, Object>> it = arrayList2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (obj.equals(it.next().get("phone"))) {
                        z = false;
                        break;
                    }
                }
                if (z) {
                    map.put(obj, map2);
                }
            }
        }
        try {
            arrayList3 = this.f5982c.getBufferedNewFriends();
        } catch (Throwable th2) {
            SMSLog.getInstance().m8622w(th2);
            arrayList3 = new ArrayList<>();
        }
        for (HashMap<String, Object> map3 : arrayList3) {
            Object obj2 = map3.get("phone");
            if (obj2 != null) {
                map.put(obj2, map3);
            }
        }
        ArrayList<HashMap<String, Object>> arrayList4 = new ArrayList<>();
        Iterator it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            arrayList4.add(((Map.Entry) it2.next()).getValue());
        }
        return arrayList4;
    }

    /* JADX INFO: renamed from: b */
    public void m6618b(final Handler.Callback callback) {
        m6613c(new Handler.Callback() { // from class: cn.smssdk.a.a.2
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                Message message2 = new Message();
                try {
                    ArrayList<HashMap<String, Object>> arrayListM6813a = C0915a.this.f5981b.m6813a((String[]) message.obj);
                    ArrayList<HashMap<String, Object>> arrayListM6614a = C0915a.this.m6614a(arrayListM6813a);
                    try {
                        C0915a.this.f5982c.setBufferedFriends(arrayListM6813a);
                        C0915a.this.f5982c.setBufferedNewFriends(new ArrayList<>());
                    } catch (Throwable th) {
                        SMSLog.getInstance().m8622w(th);
                    }
                    Iterator<HashMap<String, Object>> it = arrayListM6614a.iterator();
                    while (it.hasNext()) {
                        Object obj = it.next().get("phone");
                        if (obj != null) {
                            Iterator<HashMap<String, Object>> it2 = arrayListM6813a.iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    HashMap<String, Object> next = it2.next();
                                    if (obj.equals(next.get("phone"))) {
                                        next.put("isnew", true);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    message2.what = 1;
                    message2.obj = arrayListM6813a;
                } catch (Throwable th2) {
                    message2.what = 0;
                    message2.obj = th2;
                }
                callback.handleMessage(message2);
                return false;
            }
        });
    }

    /* JADX INFO: renamed from: a */
    public void m6615a(int i, Handler.Callback callback) {
        this.f5983d.m6622a(i, callback);
    }

    /* JADX INFO: renamed from: c */
    private void m6613c(final Handler.Callback callback) {
        String[] bufferedContactPhones;
        final Message message = new Message();
        try {
            bufferedContactPhones = this.f5982c.getBufferedContactPhones();
        } catch (Throwable th) {
            SMSLog.getInstance().m8622w(th);
            bufferedContactPhones = null;
        }
        if (bufferedContactPhones == null || bufferedContactPhones.length <= 0) {
            this.f5984e.m6719a(new Runnable() { // from class: cn.smssdk.a.a.3
                /* JADX WARN: Type inference failed for: r0v0, types: [cn.smssdk.a.a$3$1] */
                @Override // java.lang.Runnable
                public void run() {
                    new Thread() { // from class: cn.smssdk.a.a.3.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            String[] strArrM6721b = C0915a.this.f5984e.m6721b();
                            try {
                                C0915a.this.f5982c.setBufferedContactPhones(strArrM6721b);
                            } catch (Throwable th2) {
                                SMSLog.getInstance().m8622w(th2);
                            }
                            message.obj = strArrM6721b;
                            callback.handleMessage(message);
                        }
                    }.start();
                }
            }, new Runnable() { // from class: cn.smssdk.a.a.4
                /* JADX WARN: Type inference failed for: r0v0, types: [cn.smssdk.a.a$4$1] */
                @Override // java.lang.Runnable
                public void run() {
                    new Thread() { // from class: cn.smssdk.a.a.4.1
                        @Override // java.lang.Thread, java.lang.Runnable
                        public void run() {
                            callback.handleMessage(message);
                        }
                    }.start();
                }
            });
        } else {
            message.obj = bufferedContactPhones;
            callback.handleMessage(message);
        }
    }
}
