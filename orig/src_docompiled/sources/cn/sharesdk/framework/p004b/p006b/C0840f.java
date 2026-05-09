package cn.sharesdk.framework.p004b.p006b;

import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Data;
import com.mob.tools.utils.Hashon;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.f */
/* JADX INFO: compiled from: ShareEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C0840f extends AbstractC0837c {

    /* JADX INFO: renamed from: p */
    private static int f5612p;

    /* JADX INFO: renamed from: q */
    private static long f5613q;

    /* JADX INFO: renamed from: a */
    public int f5614a;

    /* JADX INFO: renamed from: b */
    public String f5615b;

    /* JADX INFO: renamed from: c */
    public String f5616c;

    /* JADX INFO: renamed from: d */
    public a f5617d = new a();

    /* JADX INFO: renamed from: n */
    public String f5618n;

    /* JADX INFO: renamed from: o */
    public String[] f5619o;

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected String mo6051a() {
        return "[SHR]";
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    protected int mo6053b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: c */
    protected int mo6054c() {
        return 30;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.f5614a);
        sb.append('|');
        sb.append(this.f5615b);
        sb.append('|');
        sb.append(TextUtils.isEmpty(this.f5616c) ? "" : this.f5616c);
        String str = "";
        if (this.f5619o != null && this.f5619o.length > 0) {
            str = "[\"" + TextUtils.join("\",\"", this.f5619o) + "\"]";
        }
        sb.append('|');
        sb.append(str);
        sb.append('|');
        if (this.f5617d != null) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(this.f5596f.substring(0, 16), this.f5617d.toString()), 0);
                if (strEncodeToString.contains("\n")) {
                    strEncodeToString = strEncodeToString.replace("\n", "");
                }
                sb.append(strEncodeToString);
            } catch (Throwable th) {
                C0851d.m6195a().m8610d(th);
            }
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f5603m)) {
            sb.append(this.f5603m);
        }
        sb.append('|');
        if (!TextUtils.isEmpty(this.f5618n)) {
            try {
                String strEncodeToString2 = Base64.encodeToString(Data.AES128Encode(this.f5596f.substring(0, 16), this.f5618n), 0);
                if (!TextUtils.isEmpty(strEncodeToString2) && strEncodeToString2.contains("\n")) {
                    strEncodeToString2 = strEncodeToString2.replace("\n", "");
                }
                sb.append(strEncodeToString2);
            } catch (Throwable th2) {
                C0851d.m6195a().m8622w(th2);
            }
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: d */
    protected long mo6055d() {
        return f5612p;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: e */
    protected long mo6056e() {
        return f5613q;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: f */
    protected void mo6057f() {
        f5612p++;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected void mo6052a(long j) {
        f5613q = j;
    }

    /* JADX INFO: renamed from: cn.sharesdk.framework.b.b.f$a */
    /* JADX INFO: compiled from: ShareEvent.java */
    public static class a {

        /* JADX INFO: renamed from: b */
        public String f5621b;

        /* JADX INFO: renamed from: g */
        public HashMap<String, Object> f5626g;

        /* JADX INFO: renamed from: a */
        public String f5620a = "";

        /* JADX INFO: renamed from: c */
        public ArrayList<String> f5622c = new ArrayList<>();

        /* JADX INFO: renamed from: d */
        public ArrayList<String> f5623d = new ArrayList<>();

        /* JADX INFO: renamed from: e */
        public ArrayList<String> f5624e = new ArrayList<>();

        /* JADX INFO: renamed from: f */
        public ArrayList<Bitmap> f5625f = new ArrayList<>();

        public String toString() {
            HashMap map = new HashMap();
            if (!TextUtils.isEmpty(this.f5621b)) {
                this.f5621b = this.f5621b.trim().replaceAll("\r", "");
                this.f5621b = this.f5621b.trim().replaceAll("\n", "");
                this.f5621b = this.f5621b.trim().replaceAll("\r\n", "");
            }
            map.put("text", this.f5621b);
            map.put("url", this.f5622c);
            if (this.f5623d != null && this.f5623d.size() > 0) {
                map.put("imgs", this.f5623d);
            }
            if (this.f5626g != null) {
                map.put("attch", new Hashon().fromHashMap(this.f5626g));
            }
            return new Hashon().fromHashMap(map);
        }
    }
}
