package cn.sharesdk.framework.p004b.p006b;

import android.text.TextUtils;
import android.util.Base64;
import cn.sharesdk.framework.utils.C0851d;
import com.mob.tools.utils.Data;

/* JADX INFO: renamed from: cn.sharesdk.framework.b.b.b */
/* JADX INFO: compiled from: AuthEvent.java */
/* JADX INFO: loaded from: classes.dex */
public class C0836b extends AbstractC0837c {

    /* JADX INFO: renamed from: n */
    private static int f5589n;

    /* JADX INFO: renamed from: o */
    private static long f5590o;

    /* JADX INFO: renamed from: a */
    public int f5591a;

    /* JADX INFO: renamed from: b */
    public String f5592b;

    /* JADX INFO: renamed from: c */
    public String f5593c;

    /* JADX INFO: renamed from: d */
    public String f5594d;

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected String mo6051a() {
        return "[AUT]";
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: b */
    protected int mo6053b() {
        return 5000;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: c */
    protected int mo6054c() {
        return 5;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append('|');
        sb.append(this.f5591a);
        sb.append('|');
        sb.append(this.f5592b);
        sb.append('|');
        if (!TextUtils.isEmpty(this.f5594d)) {
            try {
                String strEncodeToString = Base64.encodeToString(Data.AES128Encode(this.f5596f.substring(0, 16), this.f5594d), 0);
                if (!TextUtils.isEmpty(strEncodeToString) && strEncodeToString.contains("\n")) {
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
        if (!TextUtils.isEmpty(this.f5593c)) {
            sb.append(this.f5593c);
        }
        return sb.toString();
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: d */
    protected long mo6055d() {
        return f5589n;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: e */
    protected long mo6056e() {
        return f5590o;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: f */
    protected void mo6057f() {
        f5589n++;
    }

    @Override // cn.sharesdk.framework.p004b.p006b.AbstractC0837c
    /* JADX INFO: renamed from: a */
    protected void mo6052a(long j) {
        f5590o = j;
    }
}
