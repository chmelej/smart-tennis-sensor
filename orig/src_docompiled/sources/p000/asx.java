package p000;

import android.support.v4.app.Fragment;
import java.util.Arrays;
import pub.devrel.easypermissions.R;

/* JADX INFO: compiled from: PermissionRequest.java */
/* JADX INFO: loaded from: classes.dex */
public final class asx {

    /* JADX INFO: renamed from: a */
    private final atg f5009a;

    /* JADX INFO: renamed from: b */
    private final String[] f5010b;

    /* JADX INFO: renamed from: c */
    private final int f5011c;

    /* JADX INFO: renamed from: d */
    private final String f5012d;

    /* JADX INFO: renamed from: e */
    private final String f5013e;

    /* JADX INFO: renamed from: f */
    private final String f5014f;

    /* JADX INFO: renamed from: g */
    private final int f5015g;

    private asx(atg atgVar, String[] strArr, int i, String str, String str2, String str3, int i2) {
        this.f5009a = atgVar;
        this.f5010b = (String[]) strArr.clone();
        this.f5011c = i;
        this.f5012d = str;
        this.f5013e = str2;
        this.f5014f = str3;
        this.f5015g = i2;
    }

    /* JADX INFO: renamed from: a */
    public atg m5377a() {
        return this.f5009a;
    }

    /* JADX INFO: renamed from: b */
    public String[] m5378b() {
        return (String[]) this.f5010b.clone();
    }

    /* JADX INFO: renamed from: c */
    public int m5379c() {
        return this.f5011c;
    }

    /* JADX INFO: renamed from: d */
    public String m5380d() {
        return this.f5012d;
    }

    /* JADX INFO: renamed from: e */
    public String m5381e() {
        return this.f5013e;
    }

    /* JADX INFO: renamed from: f */
    public String m5382f() {
        return this.f5014f;
    }

    /* JADX INFO: renamed from: g */
    public int m5383g() {
        return this.f5015g;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        asx asxVar = (asx) obj;
        return Arrays.equals(this.f5010b, asxVar.f5010b) && this.f5011c == asxVar.f5011c;
    }

    public int hashCode() {
        return (Arrays.hashCode(this.f5010b) * 31) + this.f5011c;
    }

    public String toString() {
        return "PermissionRequest{mHelper=" + this.f5009a + ", mPerms=" + Arrays.toString(this.f5010b) + ", mRequestCode=" + this.f5011c + ", mRationale='" + this.f5012d + "', mPositiveButtonText='" + this.f5013e + "', mNegativeButtonText='" + this.f5014f + "', mTheme=" + this.f5015g + '}';
    }

    /* JADX INFO: renamed from: asx$a */
    /* JADX INFO: compiled from: PermissionRequest.java */
    public static final class C0750a {

        /* JADX INFO: renamed from: a */
        private final atg f5016a;

        /* JADX INFO: renamed from: b */
        private final int f5017b;

        /* JADX INFO: renamed from: c */
        private final String[] f5018c;

        /* JADX INFO: renamed from: d */
        private String f5019d;

        /* JADX INFO: renamed from: e */
        private String f5020e;

        /* JADX INFO: renamed from: f */
        private String f5021f;

        /* JADX INFO: renamed from: g */
        private int f5022g = -1;

        public C0750a(Fragment fragment, int i, String... strArr) {
            this.f5016a = atg.m5407a(fragment);
            this.f5017b = i;
            this.f5018c = strArr;
        }

        /* JADX INFO: renamed from: a */
        public C0750a m5384a(String str) {
            this.f5019d = str;
            return this;
        }

        /* JADX INFO: renamed from: a */
        public asx m5385a() {
            if (this.f5019d == null) {
                this.f5019d = this.f5016a.mo5402b().getString(R.string.rationale_ask);
            }
            if (this.f5020e == null) {
                this.f5020e = this.f5016a.mo5402b().getString(android.R.string.ok);
            }
            if (this.f5021f == null) {
                this.f5021f = this.f5016a.mo5402b().getString(android.R.string.cancel);
            }
            return new asx(this.f5016a, this.f5018c, this.f5017b, this.f5019d, this.f5020e, this.f5021f, this.f5022g);
        }
    }
}
