package cn.sharesdk.framework;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.lang.reflect.Field;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.framework.c */
/* JADX INFO: compiled from: PlatformImpl.java */
/* JADX INFO: loaded from: classes.dex */
public class C0844c {

    /* JADX INFO: renamed from: a */
    private Platform f5652a;

    /* JADX INFO: renamed from: b */
    private Context f5653b;

    /* JADX INFO: renamed from: c */
    private PlatformDb f5654c;

    /* JADX INFO: renamed from: d */
    private C0818a f5655d;

    /* JADX INFO: renamed from: e */
    private int f5656e;

    /* JADX INFO: renamed from: f */
    private int f5657f;

    /* JADX INFO: renamed from: g */
    private boolean f5658g;

    /* JADX INFO: renamed from: h */
    private boolean f5659h = true;

    /* JADX INFO: renamed from: i */
    private boolean f5660i;

    public C0844c(Platform platform, Context context) {
        this.f5652a = platform;
        this.f5653b = context;
        String name = platform.getName();
        this.f5654c = new PlatformDb(context, name, platform.getVersion());
        m6105a(name);
        this.f5655d = new C0818a();
    }

    /* JADX INFO: renamed from: a */
    public void m6105a(String str) {
        try {
            this.f5656e = ResHelper.parseInt(String.valueOf(ShareSDK.m5945b(str, "Id")).trim());
        } catch (Throwable unused) {
            if (!(this.f5652a instanceof CustomPlatform)) {
                C0851d.m6195a().m8609d(this.f5652a.getName() + " failed to parse Id, this will cause method getId() always returens 0", new Object[0]);
            }
        }
        try {
            this.f5657f = ResHelper.parseInt(String.valueOf(ShareSDK.m5945b(str, "SortId")).trim());
        } catch (Throwable unused2) {
            if (!(this.f5652a instanceof CustomPlatform)) {
                C0851d.m6195a().m8609d(this.f5652a.getName() + " failed to parse SortId, this won't cause any problem, don't worry", new Object[0]);
            }
        }
        String strM5945b = ShareSDK.m5945b(str, "Enable");
        if (strM5945b == null) {
            this.f5660i = true;
            if (!(this.f5652a instanceof CustomPlatform)) {
                C0851d.m6195a().m8609d(this.f5652a.getName() + " failed to parse Enable, this will cause platform always be enable", new Object[0]);
            }
        } else {
            this.f5660i = "true".equals(strM5945b.trim());
        }
        this.f5652a.initDevInfo(str);
    }

    /* JADX INFO: renamed from: a */
    public int m6097a() {
        return this.f5656e;
    }

    /* JADX INFO: renamed from: b */
    public int m6110b() {
        return this.f5657f;
    }

    /* JADX INFO: renamed from: a */
    public void m6104a(PlatformActionListener platformActionListener) {
        this.f5655d.m5961a(platformActionListener);
    }

    /* JADX INFO: renamed from: c */
    public PlatformActionListener m6113c() {
        return this.f5655d.m5958a();
    }

    /* JADX INFO: renamed from: d */
    public boolean m6117d() {
        return this.f5654c.isValid();
    }

    /* JADX INFO: renamed from: a */
    public void m6108a(boolean z) {
        this.f5658g = z;
    }

    /* JADX INFO: renamed from: e */
    public boolean m6118e() {
        return this.f5658g;
    }

    /* JADX INFO: renamed from: f */
    public boolean m6119f() {
        return this.f5660i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: j */
    public boolean m6095j() {
        if (ShareSDK.m5943a()) {
            String strM6098a = m6098a(this.f5652a.getPlatformId(), "covert_url", (String) null);
            if (strM6098a != null) {
                strM6098a.trim();
            }
            this.f5659h = !"false".equals(strM6098a);
            this.f5652a.setNetworkDevinfo();
            return true;
        }
        try {
            HashMap map = new HashMap();
            if (!ShareSDK.m5944a((HashMap<String, Object>) map)) {
                return false;
            }
            if (!ShareSDK.m5947b(map)) {
                String strFromHashMap = new Hashon().fromHashMap(map);
                C0851d.m6195a().m8615i("Failed to parse network dev-info: " + strFromHashMap, new Object[0]);
                return false;
            }
            String strM6098a2 = m6098a(this.f5652a.getPlatformId(), "covert_url", (String) null);
            if (strM6098a2 != null) {
                strM6098a2.trim();
            }
            this.f5659h = !"false".equals(strM6098a2);
            this.f5652a.setNetworkDevinfo();
            return true;
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public String m6098a(int i, String str, String str2) {
        String strM5937a = ShareSDK.m5937a(i, str);
        return (TextUtils.isEmpty(strM5937a) || "null".equals(strM5937a)) ? this.f5652a.getDevinfo(this.f5652a.getName(), str2) : strM5937a;
    }

    /* JADX INFO: renamed from: a */
    public void m6102a(int i, Object obj) {
        this.f5655d.m5959a(this.f5652a, i, obj);
    }

    /* JADX INFO: renamed from: b */
    protected void m6111b(int i, Object obj) {
        Object obj2;
        switch (i) {
            case 1:
                if (this.f5655d != null) {
                    this.f5655d.onComplete(this.f5652a, 1, null);
                }
                break;
            case 2:
                Object[] objArr = (Object[]) obj;
                this.f5652a.getFriendList(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue(), (String) objArr[2]);
                break;
            case 3:
            case 4:
            case 5:
            default:
                Object[] objArr2 = (Object[]) obj;
                this.f5652a.doCustomerProtocol(String.valueOf(objArr2[0]), String.valueOf(objArr2[1]), i, (HashMap) objArr2[2], (HashMap) objArr2[3]);
                break;
            case 6:
                this.f5652a.follow((String) obj);
                break;
            case 7:
                Object[] objArr3 = (Object[]) obj;
                this.f5652a.timeline(((Integer) objArr3[0]).intValue(), ((Integer) objArr3[1]).intValue(), (String) objArr3[2]);
                break;
            case 8:
                this.f5652a.userInfor(obj != null ? (String) obj : null);
                break;
            case 9:
                Platform.ShareParams shareParams = (Platform.ShareParams) obj;
                HashMap<String, Object> map = shareParams.toMap();
                for (Field field : shareParams.getClass().getFields()) {
                    if (map.get(field.getName()) == null) {
                        field.setAccessible(true);
                        try {
                            obj2 = field.get(shareParams);
                        } catch (Throwable th) {
                            C0851d.m6195a().m8622w(th);
                            obj2 = null;
                        }
                        if (obj2 != null) {
                            map.put(field.getName(), obj2);
                        }
                        break;
                    }
                }
                if (this.f5655d instanceof C0818a) {
                    this.f5655d.m5960a(this.f5652a, shareParams);
                }
                this.f5652a.doShare(shareParams);
                break;
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.c$1] */
    /* JADX INFO: renamed from: c */
    protected void m6114c(final int i, final Object obj) {
        new Thread() { // from class: cn.sharesdk.framework.c.1
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    C0844c.this.m6095j();
                    if (C0844c.this.f5652a.checkAuthorize(i, obj)) {
                        C0844c.this.m6111b(i, obj);
                    }
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                }
            }
        }.start();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [cn.sharesdk.framework.c$2] */
    /* JADX INFO: renamed from: a */
    public void m6109a(final String[] strArr) {
        new Thread() { // from class: cn.sharesdk.framework.c.2
            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    C0844c.this.m6095j();
                    C0844c.this.f5652a.doAuthorize(strArr);
                } catch (Throwable th) {
                    C0851d.m6195a().m8622w(th);
                }
            }
        }.start();
    }

    /* JADX INFO: renamed from: a */
    public void m6103a(Platform.ShareParams shareParams) {
        if (shareParams == null) {
            if (this.f5655d != null) {
                this.f5655d.onError(this.f5652a, 9, new NullPointerException());
                return;
            }
            return;
        }
        m6114c(9, shareParams);
    }

    /* JADX INFO: renamed from: b */
    public void m6112b(String str) {
        m6114c(6, str);
    }

    /* JADX INFO: renamed from: a */
    public void m6106a(String str, int i, int i2) {
        m6114c(7, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    /* JADX INFO: renamed from: c */
    public void m6115c(String str) {
        m6114c(8, str);
    }

    /* JADX INFO: renamed from: a */
    public void m6101a(int i, int i2, String str) {
        m6114c(2, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
    }

    /* JADX INFO: renamed from: a */
    public void m6107a(String str, String str2, short s, HashMap<String, Object> map, HashMap<String, String> map2) {
        m6114c(s | 655360, new Object[]{str, str2, map, map2});
    }

    /* JADX INFO: renamed from: g */
    public PlatformDb m6120g() {
        return this.f5654c;
    }

    /* JADX INFO: renamed from: h */
    public void m6121h() {
        this.f5654c.removeAccount();
    }

    /* JADX INFO: renamed from: a */
    public String m6100a(String str, boolean z) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!this.f5659h) {
            C0851d.m6195a().m8615i("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return str;
        }
        if (TextUtils.isEmpty(str)) {
            C0851d.m6195a().m8615i("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
            return str;
        }
        String strM5940a = ShareSDK.m5940a(str, z, this.f5652a.getPlatformId(), m6096k());
        C0851d.m6195a().m8615i("getShortLintk use time: " + (System.currentTimeMillis() - jCurrentTimeMillis), new Object[0]);
        return strM5940a;
    }

    /* JADX INFO: renamed from: k */
    private String m6096k() {
        StringBuilder sb = new StringBuilder();
        try {
            if ("TencentWeibo".equals(this.f5652a.getName())) {
                C0851d.m6195a().m8615i("user id %s ==>>", m6120g().getUserName());
                sb.append(Data.urlEncode(m6120g().getUserName(), "utf-8"));
            } else {
                sb.append(Data.urlEncode(m6120g().getUserId(), "utf-8"));
            }
            sb.append("|");
            sb.append(Data.urlEncode(m6120g().get("secretType"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(m6120g().get("gender"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(m6120g().get("birthday"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(m6120g().get("educationJSONArrayStr"), "utf-8"));
            sb.append("|");
            sb.append(Data.urlEncode(m6120g().get("workJSONArrayStr"), "utf-8"));
        } catch (Throwable th) {
            C0851d.m6195a().m8622w(th);
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: i */
    protected PlatformActionListener m6122i() {
        return this.f5655d;
    }

    /* JADX INFO: renamed from: d */
    public String m6116d(String str) {
        return ShareSDK.m5939a(str);
    }

    /* JADX INFO: renamed from: a */
    public String m6099a(Bitmap bitmap) {
        return ShareSDK.m5938a(bitmap);
    }
}
