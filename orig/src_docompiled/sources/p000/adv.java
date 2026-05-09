package p000;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.message.MsgConstant;
import org.json.JSONObject;

/* JADX INFO: compiled from: EventTracker.java */
/* JADX INFO: loaded from: classes.dex */
public class adv {

    /* JADX INFO: renamed from: d */
    private Context f489d;

    /* JADX INFO: renamed from: e */
    private adt f490e;

    /* JADX INFO: renamed from: f */
    private ads f491f;

    /* JADX INFO: renamed from: h */
    private adt f493h;

    /* JADX INFO: renamed from: a */
    private final int f486a = 128;

    /* JADX INFO: renamed from: b */
    private final int f487b = 256;

    /* JADX INFO: renamed from: c */
    private final int f488c = 10;

    /* JADX INFO: renamed from: g */
    private JSONObject f492g = null;

    public adv(Context context) throws Throwable {
        this.f490e = null;
        this.f491f = null;
        if (context == null) {
            try {
                aex.m776c("Context is null, can't track event");
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        this.f493h = adt.m435b(context);
        this.f489d = context;
        this.f490e = adt.m435b(this.f489d);
        this.f491f = this.f490e.m436a(this.f489d);
        if (this.f492g == null) {
            m440a(this.f489d);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m440a(Context context) throws Throwable {
        try {
            String string = aeb.m454a(context).getString("fs_lc_tl", null);
            if (!TextUtils.isEmpty(string)) {
                this.f492g = new JSONObject(string);
            }
            m439a();
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private void m439a() throws Throwable {
        try {
            if (TextUtils.isEmpty(this.f491f.f454a)) {
                return;
            }
            String[] strArrSplit = this.f491f.f454a.split("!");
            JSONObject jSONObject = new JSONObject();
            int i = 0;
            if (this.f492g != null) {
                for (String str : strArrSplit) {
                    String strM758a = aev.m758a(str, 128);
                    if (this.f492g.has(strM758a)) {
                        jSONObject.put(strM758a, this.f492g.get(strM758a));
                    }
                }
            }
            this.f492g = new JSONObject();
            if (strArrSplit.length >= 10) {
                while (i < 10) {
                    m441a(strArrSplit[i], jSONObject);
                    i++;
                }
            } else {
                while (i < strArrSplit.length) {
                    m441a(strArrSplit[i], jSONObject);
                    i++;
                }
            }
            m443b(this.f489d);
            this.f491f.f454a = null;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: a */
    private void m441a(String str, JSONObject jSONObject) throws Throwable {
        String strM758a = aev.m758a(str, 128);
        if (jSONObject.has(strM758a)) {
            m442a(strM758a, ((Boolean) jSONObject.get(strM758a)).booleanValue());
        } else {
            m442a(strM758a, false);
        }
    }

    /* JADX INFO: renamed from: a */
    private void m442a(String str, boolean z) {
        try {
            if ("$st_fl".equals(str) || "dplus_st".equals(str) || "du".equals(str) || "id".equals(str) || MsgConstant.KEY_TS.equals(str) || this.f492g.has(str)) {
                return;
            }
            this.f492g.put(str, z);
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: renamed from: b */
    private void m443b(Context context) {
        try {
            if (this.f492g != null) {
                aeb.m454a(this.f489d).edit().putString("fs_lc_tl", this.f492g.toString()).commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
