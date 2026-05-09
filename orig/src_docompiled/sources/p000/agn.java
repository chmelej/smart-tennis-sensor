package p000;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: UMCCAggregatedObject.java */
/* JADX INFO: loaded from: classes.dex */
public class agn implements Serializable {

    /* JADX INFO: renamed from: a */
    private List<String> f825a = new ArrayList();

    /* JADX INFO: renamed from: b */
    private List<String> f826b = new ArrayList();

    /* JADX INFO: renamed from: c */
    private long f827c = 0;

    /* JADX INFO: renamed from: d */
    private long f828d = 0;

    /* JADX INFO: renamed from: e */
    private long f829e = 0;

    /* JADX INFO: renamed from: f */
    private String f830f = null;

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[key: ");
        stringBuffer.append(this.f825a);
        stringBuffer.append("] [label: ");
        stringBuffer.append(this.f826b);
        stringBuffer.append("][ totalTimeStamp");
        stringBuffer.append(this.f830f);
        stringBuffer.append("][ value");
        stringBuffer.append(this.f828d);
        stringBuffer.append("][ count");
        stringBuffer.append(this.f829e);
        stringBuffer.append("][ timeWindowNum");
        stringBuffer.append(this.f830f);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    /* JADX INFO: renamed from: a */
    public String m927a() {
        return aft.m905a(this.f825a);
    }

    /* JADX INFO: renamed from: b */
    public String m928b() {
        return aft.m905a(this.f826b);
    }

    /* JADX INFO: renamed from: c */
    public long m929c() {
        return this.f827c;
    }

    /* JADX INFO: renamed from: d */
    public long m930d() {
        return this.f828d;
    }

    /* JADX INFO: renamed from: e */
    public long m931e() {
        return this.f829e;
    }

    /* JADX INFO: renamed from: f */
    public String m932f() {
        return this.f830f;
    }
}
