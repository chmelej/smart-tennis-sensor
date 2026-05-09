package p000;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public final class aag {

    /* JADX INFO: renamed from: a */
    public String f21a;

    /* JADX INFO: renamed from: b */
    public JSONArray f22b;

    /* JADX INFO: renamed from: c */
    public JSONObject f23c;

    public aag() {
        this.f23c = null;
    }

    public aag(String str) {
        this.f23c = null;
        this.f21a = str;
        this.f23c = new JSONObject();
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof aag) {
            return toString().equals(((aag) obj).toString());
        }
        return false;
    }

    public final int hashCode() {
        return toString().hashCode();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f21a);
        sb.append(",");
        if (this.f22b != null) {
            sb.append(this.f22b.toString());
        }
        if (this.f23c != null) {
            sb.append(this.f23c.toString());
        }
        return sb.toString();
    }
}
