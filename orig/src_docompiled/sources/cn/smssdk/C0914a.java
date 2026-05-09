package cn.smssdk;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.NotificationCompat;
import android.telephony.SmsMessage;
import android.text.TextUtils;
import cn.smssdk.SMSSDK;
import cn.smssdk.contact.C0936b;
import cn.smssdk.contact.OnContactChangeListener;
import cn.smssdk.net.C0981f;
import cn.smssdk.p008a.C0915a;
import cn.smssdk.p009b.C0917a;
import cn.smssdk.utils.SMSLog;
import cn.smssdk.utils.SPHelper;
import com.mob.tools.utils.C1583R;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ResHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* JADX INFO: renamed from: cn.smssdk.a */
/* JADX INFO: compiled from: SMSSDKCore.java */
/* JADX INFO: loaded from: classes.dex */
public class C0914a implements OnContactChangeListener {

    /* JADX INFO: renamed from: a */
    private Context f5961a;

    /* JADX INFO: renamed from: b */
    private HashSet<EventHandler> f5962b = new HashSet<>();

    /* JADX INFO: renamed from: c */
    private C0981f f5963c;

    /* JADX INFO: renamed from: d */
    private C0936b f5964d;

    /* JADX INFO: renamed from: e */
    private C0915a f5965e;

    /* JADX INFO: renamed from: f */
    private C0917a f5966f;

    /* JADX INFO: renamed from: g */
    private String f5967g;

    /* JADX INFO: renamed from: h */
    private HashMap<Character, ArrayList<String[]>> f5968h;

    /* JADX INFO: renamed from: i */
    private HashMap<String, String> f5969i;

    /* JADX INFO: renamed from: j */
    private ArrayList<HashMap<String, Object>> f5970j;

    /* JADX INFO: renamed from: k */
    private String f5971k;

    public C0914a(Context context, String str, String str2) {
        this.f5961a = context.getApplicationContext();
        this.f5971k = str;
        SMSLog.prepare(this.f5961a, 26, str);
        this.f5963c = C0981f.m6812a(this.f5961a);
        this.f5963c.m6814a(str, str2);
        this.f5965e = C0915a.m6608a(this.f5961a);
        this.f5964d = C0936b.m6707a(this.f5961a);
        this.f5966f = C0917a.m6623a(this.f5961a, str);
    }

    /* JADX INFO: renamed from: a */
    public void m6598a() {
        this.f5964d.m6718a(this);
        this.f5964d.m6717a();
        new Thread(new Runnable() { // from class: cn.smssdk.a.1
            @Override // java.lang.Runnable
            public void run() {
                C0914a.this.f5963c.m6822c();
            }
        }).start();
    }

    /* JADX INFO: renamed from: a */
    public void m6601a(EventHandler eventHandler) {
        synchronized (this.f5962b) {
            if (eventHandler != null) {
                try {
                    if (!this.f5962b.contains(eventHandler)) {
                        this.f5962b.add(eventHandler);
                        eventHandler.onRegister();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6604b(EventHandler eventHandler) {
        synchronized (this.f5962b) {
            if (eventHandler != null) {
                try {
                    if (this.f5962b.contains(eventHandler)) {
                        eventHandler.onUnregister();
                        this.f5962b.remove(eventHandler);
                    }
                } finally {
                }
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public void m6603b() {
        synchronized (this.f5962b) {
            Iterator<EventHandler> it = this.f5962b.iterator();
            while (it.hasNext()) {
                it.next().onUnregister();
            }
            this.f5962b.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.smssdk.a$2] */
    /* JADX INFO: renamed from: a */
    public void m6599a(final int i, final Object obj) {
        new Thread() { // from class: cn.smssdk.a.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                synchronized (C0914a.this.f5962b) {
                    Iterator it = C0914a.this.f5962b.iterator();
                    while (it.hasNext()) {
                        ((EventHandler) it.next()).beforeEvent(i, obj);
                    }
                }
                C0914a.this.m6588b(i, obj);
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: b */
    public void m6588b(int i, Object obj) {
        switch (i) {
            case 1:
                m6593e();
                break;
            case 2:
                m6589b(obj);
                break;
            case 3:
                m6591c(obj);
                break;
            case 4:
                m6585a(obj);
                break;
            case 5:
                m6592d(obj);
                break;
            case 6:
                m6596g();
                break;
            case 7:
                m6595f();
                break;
            case 8:
                m6594e(obj);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: a */
    public void m6582a(int i, int i2, Object obj) {
        if (obj != null && (obj instanceof Throwable)) {
            Throwable th = (Throwable) obj;
            String message = th.getMessage();
            if (!TextUtils.isEmpty(message)) {
                try {
                    JSONObject jSONObject = new JSONObject(message);
                    int iOptInt = jSONObject.optInt(NotificationCompat.CATEGORY_STATUS);
                    if (TextUtils.isEmpty(jSONObject.optString("detail")) && ((iOptInt > 400 && iOptInt <= 500) || iOptInt > 600)) {
                        int stringRes = C1583R.getStringRes(this.f5961a, "smssdk_error_desc_" + iOptInt);
                        if (stringRes > 0) {
                            String string = this.f5961a.getResources().getString(stringRes);
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put(NotificationCompat.CATEGORY_STATUS, iOptInt);
                            jSONObject2.put("detail", string);
                            obj = new Throwable(jSONObject2.toString(), th);
                        }
                    }
                } catch (Throwable th2) {
                    SMSLog.getInstance().m8622w(th2);
                }
            }
            SMSLog.getInstance().m8622w(th);
        }
        synchronized (this.f5962b) {
            Iterator<EventHandler> it = this.f5962b.iterator();
            while (it.hasNext()) {
                it.next().afterEvent(i, i2, obj);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    private void m6585a(Object obj) {
        int i;
        try {
            th = this.f5964d.m6716a(((Boolean) obj).booleanValue());
            i = -1;
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        m6582a(4, i, th);
    }

    /* JADX INFO: renamed from: b */
    private void m6589b(Object obj) {
        String strSubstring;
        String str;
        String str2;
        String str3;
        OnSendMessageHandler onSendMessageHandler;
        int i = 0;
        try {
            if (this.f5969i == null || this.f5969i.size() <= 0) {
                m6597h();
            }
            Object[] objArr = (Object[]) obj;
            strSubstring = (String) objArr[0];
            str = (String) objArr[1];
            str2 = (String) objArr[2];
            str3 = (String) objArr[3];
            if (strSubstring.startsWith("+")) {
                strSubstring = strSubstring.substring(1);
            }
            if (!m6586a(str, strSubstring)) {
                SMSLog.getInstance().m8609d("phone num error", new Object[0]);
            }
            onSendMessageHandler = (OnSendMessageHandler) objArr[4];
        } catch (Throwable th) {
            th = th;
        }
        if (onSendMessageHandler != null && onSendMessageHandler.onSendMessage(strSubstring, str)) {
            throw new UserInterruptException();
        }
        th = Boolean.valueOf(this.f5963c.m6819a(strSubstring, str, str2, str3));
        i = -1;
        m6582a(2, i, th);
    }

    /* JADX INFO: renamed from: c */
    private void m6591c(Object obj) {
        String strSubstring;
        String str;
        String str2;
        int i = 0;
        try {
            if (this.f5969i == null || this.f5969i.size() <= 0) {
                m6597h();
            }
            String[] strArr = (String[]) obj;
            strSubstring = strArr[0];
            str = strArr[1];
            str2 = strArr[2];
            if (strSubstring.startsWith("+")) {
                strSubstring = strSubstring.substring(1);
            }
        } catch (Throwable th) {
            th = th;
        }
        if (!m6586a(str, strSubstring)) {
            throw new Throwable("phone num error");
        }
        th = this.f5963c.m6821b(str2, strSubstring, str);
        i = -1;
        m6582a(3, i, th);
    }

    /* JADX INFO: renamed from: e */
    private void m6593e() {
        int i;
        try {
            th = m6597h();
            i = -1;
        } catch (Throwable th) {
            th = th;
            i = 0;
        }
        m6582a(1, i, th);
    }

    /* JADX INFO: renamed from: d */
    private void m6592d(Object obj) {
        int i = 0;
        try {
            String[] strArr = (String[]) obj;
            this.f5965e.m6617a(strArr[0], strArr[1], strArr[2], strArr[3], strArr[4]);
            i = -1;
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        m6582a(5, i, th);
    }

    /* JADX INFO: renamed from: f */
    private void m6595f() {
        this.f5965e.m6616a(new Handler.Callback() { // from class: cn.smssdk.a.3
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                C0914a.this.m6582a(7, message.what == 1 ? -1 : 0, message.obj);
                return false;
            }
        });
    }

    /* JADX INFO: renamed from: g */
    private void m6596g() {
        this.f5965e.m6618b(new Handler.Callback() { // from class: cn.smssdk.a.4
            @Override // android.os.Handler.Callback
            public boolean handleMessage(Message message) {
                C0914a.this.m6582a(6, message.what == 1 ? -1 : 0, message.obj);
                return false;
            }
        });
    }

    @Override // cn.smssdk.contact.OnContactChangeListener
    public void onContactChange(boolean z) {
        this.f5964d.m6720b(new Runnable() { // from class: cn.smssdk.a.5
            @Override // java.lang.Runnable
            public void run() {
                C0914a.this.f5965e.m6615a(0, new Handler.Callback() { // from class: cn.smssdk.a.5.1
                    @Override // android.os.Handler.Callback
                    public boolean handleMessage(Message message) {
                        if (message.arg1 <= 0) {
                            return false;
                        }
                        C0914a.this.m6582a(7, -1, Integer.valueOf(message.arg1));
                        return false;
                    }
                });
            }
        }, null);
    }

    /* JADX INFO: renamed from: c */
    public HashMap<Character, ArrayList<String[]>> m6606c() {
        ArrayList arrayList;
        String appLanguage = DeviceHelper.getInstance(this.f5961a).getAppLanguage();
        SMSLog.getInstance().m8609d("appLanguage:" + appLanguage, new Object[0]);
        if (appLanguage != null && !appLanguage.equals(this.f5967g)) {
            this.f5967g = appLanguage;
            this.f5968h = null;
        }
        if (this.f5968h != null && this.f5968h.size() > 0) {
            return this.f5968h;
        }
        LinkedHashMap linkedHashMap = null;
        for (char c = 'A'; c <= 'Z'; c = (char) (c + 1)) {
            int stringArrayRes = ResHelper.getStringArrayRes(this.f5961a, "smssdk_country_group_" + Character.toLowerCase(c));
            if (stringArrayRes > 0) {
                String[] stringArray = this.f5961a.getResources().getStringArray(stringArrayRes);
                if (stringArray != null) {
                    arrayList = null;
                    for (String str : stringArray) {
                        String[] strArrSplit = str.split(",");
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(strArrSplit);
                    }
                } else {
                    arrayList = null;
                }
                if (arrayList != null) {
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                    linkedHashMap.put(Character.valueOf(c), arrayList);
                }
            }
        }
        this.f5968h = linkedHashMap;
        return this.f5968h;
    }

    /* JADX INFO: renamed from: a */
    public String[] m6602a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Map.Entry<Character, ArrayList<String[]>>> it = m6606c().entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<String[]> value = it.next().getValue();
            int size = value == null ? 0 : value.size();
            for (int i = 0; i < size; i++) {
                String[] strArr = value.get(i);
                if (strArr != null && strArr.length > 2 && str.equals(strArr[2])) {
                    return strArr;
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public String[] m6605b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Iterator<Map.Entry<Character, ArrayList<String[]>>> it = m6606c().entrySet().iterator();
        while (it.hasNext()) {
            ArrayList<String[]> value = it.next().getValue();
            int size = value == null ? 0 : value.size();
            for (int i = 0; i < size; i++) {
                String[] strArr = value.get(i);
                if (strArr.length < 4) {
                    SMSLog.getInstance().m8609d("MCC not found in the country: " + strArr[0], new Object[0]);
                } else {
                    String str2 = strArr[3];
                    if (str2.indexOf("|") < 0) {
                        if (str.equals(str2)) {
                            return strArr;
                        }
                    } else {
                        for (Object obj : str2.split("\\|")) {
                            if (str.equals(obj)) {
                                return strArr;
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public void m6600a(SmsMessage smsMessage, SMSSDK.VerifyCodeReadListener verifyCodeReadListener) {
        this.f5966f.m6630a(verifyCodeReadListener);
        this.f5966f.m6631a(smsMessage);
    }

    /* JADX INFO: renamed from: e */
    private void m6594e(Object obj) {
        Object[] objArr = (Object[]) obj;
        int i = 0;
        String str = (String) objArr[0];
        String strSubstring = (String) objArr[1];
        String str2 = (String) objArr[2];
        if (strSubstring.startsWith("+")) {
            strSubstring = strSubstring.substring(1);
        }
        try {
            if (this.f5969i == null || this.f5969i.size() <= 0) {
                m6597h();
            }
            if (!m6586a(str, strSubstring)) {
                SMSLog.getInstance().m8609d("phone num error", new Object[0]);
            }
            this.f5963c.m6815a(str, strSubstring, str2);
            i = -1;
            th = null;
        } catch (Throwable th) {
            th = th;
        }
        m6582a(8, i, th);
    }

    /* JADX INFO: renamed from: d */
    public void m6607d() {
        SPHelper.getInstance(this.f5961a).setWarnWhenReadContact(true);
    }

    /* JADX INFO: renamed from: a */
    private boolean m6586a(String str, String str2) throws Throwable {
        int stringRes;
        int stringRes2;
        if (TextUtils.isEmpty(str)) {
            int stringRes3 = C1583R.getStringRes(this.f5961a, "smssdk_error_desc_603");
            if (stringRes3 <= 0) {
                return false;
            }
            throw new Throwable("{\"status\":603,\"detail\":\"" + this.f5961a.getResources().getString(stringRes3) + "\"}");
        }
        if (this.f5969i == null || this.f5969i.size() <= 0) {
            if (str2 == "86") {
                if (str.length() != 11 && (stringRes = C1583R.getStringRes(this.f5961a, "smssdk_error_desc_603")) > 0) {
                    throw new Throwable("{\"status\":603,\"detail\":\"" + this.f5961a.getResources().getString(stringRes) + "\"}");
                }
            } else {
                int stringRes4 = C1583R.getStringRes(this.f5961a, "smssdk_error_desc_604");
                if (stringRes4 > 0) {
                    throw new Throwable("{\"status\":604,\"detail\":\"" + this.f5961a.getResources().getString(stringRes4) + "\"}");
                }
            }
            return false;
        }
        String str3 = this.f5969i.get(str2);
        if (TextUtils.isEmpty(str3) && (stringRes2 = C1583R.getStringRes(this.f5961a, "smssdk_error_desc_604")) > 0) {
            throw new Throwable("{\"status\":604,\"detail\":\"" + this.f5961a.getResources().getString(stringRes2) + "\"}");
        }
        if (Pattern.compile(str3).matcher(str).matches()) {
            return true;
        }
        int stringRes5 = C1583R.getStringRes(this.f5961a, "smssdk_error_desc_603");
        if (stringRes5 <= 0) {
            return false;
        }
        throw new Throwable("{\"status\":603,\"detail\":\"" + this.f5961a.getResources().getString(stringRes5) + "\"}");
    }

    /* JADX INFO: renamed from: h */
    private ArrayList<HashMap<String, Object>> m6597h() {
        if (this.f5970j == null || this.f5963c.m6818a()) {
            this.f5970j = this.f5963c.m6820b();
        }
        for (HashMap<String, Object> map : this.f5970j) {
            String str = (String) map.get("zone");
            String str2 = (String) map.get("rule");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                if (this.f5969i == null) {
                    this.f5969i = new HashMap<>();
                }
                this.f5969i.put(str, str2);
            }
        }
        return this.f5970j;
    }
}
