package cn.sharesdk.framework.p004b.p005a;

import android.content.Context;
import android.text.TextUtils;
import com.mob.tools.utils.SharePrefrenceHelper;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.a.e */
/* JADX INFO: compiled from: SharePrefrenceUtil.java */
/* JADX INFO: loaded from: classes.dex */
public class C0833e {

    /* JADX INFO: renamed from: c */
    private static C0833e f5579c;

    /* JADX INFO: renamed from: a */
    private Context f5580a;

    /* JADX INFO: renamed from: b */
    private SharePrefrenceHelper f5581b;

    private C0833e(Context context) {
        this.f5580a = context.getApplicationContext();
        this.f5581b = new SharePrefrenceHelper(this.f5580a);
        this.f5581b.open("share_sdk", 1);
    }

    /* JADX INFO: renamed from: a */
    public static C0833e m6025a(Context context) {
        if (f5579c == null) {
            f5579c = new C0833e(context.getApplicationContext());
        }
        return f5579c;
    }

    /* JADX INFO: renamed from: a */
    public long m6026a() {
        return this.f5581b.getLong("service_time");
    }

    /* JADX INFO: renamed from: b */
    public boolean m6037b() {
        String string = this.f5581b.getString("upload_device_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    /* JADX INFO: renamed from: c */
    public boolean m6039c() {
        String string = this.f5581b.getString("upload_user_info");
        if (TextUtils.isEmpty(string)) {
            return true;
        }
        return Boolean.parseBoolean(string);
    }

    /* JADX INFO: renamed from: d */
    public boolean m6041d() {
        String string = this.f5581b.getString("trans_short_link");
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        return Boolean.parseBoolean(string);
    }

    /* JADX INFO: renamed from: e */
    public int m6042e() {
        String string = this.f5581b.getString("upload_share_content");
        if ("true".equals(string)) {
            return 1;
        }
        return "false".equals(string) ? -1 : 0;
    }

    /* JADX INFO: renamed from: a */
    public void m6028a(String str) {
        this.f5581b.putString("trans_short_link", str);
    }

    /* JADX INFO: renamed from: b */
    public void m6035b(String str) {
        this.f5581b.putString("upload_device_info", str);
    }

    /* JADX INFO: renamed from: c */
    public void m6038c(String str) {
        this.f5581b.putString("upload_user_info", str);
    }

    /* JADX INFO: renamed from: d */
    public void m6040d(String str) {
        this.f5581b.putString("upload_share_content", str);
    }

    /* JADX INFO: renamed from: a */
    public void m6032a(String str, String str2) {
        this.f5581b.putString("buffered_snsconf_" + str, str2);
    }

    /* JADX INFO: renamed from: e */
    public String m6043e(String str) {
        return this.f5581b.getString("buffered_snsconf_" + str);
    }

    /* JADX INFO: renamed from: a */
    public void m6027a(long j) {
        this.f5581b.putLong("device_time", Long.valueOf(j));
    }

    /* JADX INFO: renamed from: f */
    public Long m6045f() {
        return Long.valueOf(this.f5581b.getLong("device_time"));
    }

    /* JADX INFO: renamed from: a */
    public void m6033a(boolean z) {
        this.f5581b.putBoolean("connect_server", Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: g */
    public boolean m6047g() {
        return this.f5581b.getBoolean("connect_server");
    }

    /* JADX INFO: renamed from: b */
    public void m6034b(long j) {
        this.f5581b.putLong("connect_server_time", Long.valueOf(j));
    }

    /* JADX INFO: renamed from: h */
    public Long m6048h() {
        return Long.valueOf(this.f5581b.getLong("connect_server_time"));
    }

    /* JADX INFO: renamed from: b */
    public void m6036b(boolean z) {
        this.f5581b.putBoolean("sns_info_buffered", Boolean.valueOf(z));
    }

    /* JADX INFO: renamed from: i */
    public boolean m6050i() {
        return this.f5581b.getBoolean("sns_info_buffered");
    }

    /* JADX INFO: renamed from: a */
    public void m6030a(String str, Long l) {
        this.f5581b.putLong(str, l);
    }

    /* JADX INFO: renamed from: f */
    public long m6044f(String str) {
        return this.f5581b.getLong(str);
    }

    /* JADX INFO: renamed from: a */
    public void m6029a(String str, int i) {
        this.f5581b.putInt(str, Integer.valueOf(i));
    }

    /* JADX INFO: renamed from: g */
    public int m6046g(String str) {
        return this.f5581b.getInt(str);
    }

    /* JADX INFO: renamed from: a */
    public void m6031a(String str, Object obj) {
        this.f5581b.put(str, obj);
    }

    /* JADX INFO: renamed from: h */
    public Object m6049h(String str) {
        return this.f5581b.get(str);
    }
}
