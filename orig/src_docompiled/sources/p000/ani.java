package p000;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

/* JADX INFO: compiled from: Route.java */
/* JADX INFO: loaded from: classes.dex */
public final class ani {

    /* JADX INFO: renamed from: a */
    final amf f4195a;

    /* JADX INFO: renamed from: b */
    final Proxy f4196b;

    /* JADX INFO: renamed from: c */
    final InetSocketAddress f4197c;

    public ani(amf amfVar, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (amfVar == null) {
            throw new NullPointerException("address == null");
        }
        if (proxy == null) {
            throw new NullPointerException("proxy == null");
        }
        if (inetSocketAddress == null) {
            throw new NullPointerException("inetSocketAddress == null");
        }
        this.f4195a = amfVar;
        this.f4196b = proxy;
        this.f4197c = inetSocketAddress;
    }

    /* JADX INFO: renamed from: a */
    public amf m4483a() {
        return this.f4195a;
    }

    /* JADX INFO: renamed from: b */
    public Proxy m4484b() {
        return this.f4196b;
    }

    /* JADX INFO: renamed from: c */
    public InetSocketAddress m4485c() {
        return this.f4197c;
    }

    /* JADX INFO: renamed from: d */
    public boolean m4486d() {
        return this.f4195a.f1717i != null && this.f4196b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof ani) {
            ani aniVar = (ani) obj;
            if (aniVar.f4195a.equals(this.f4195a) && aniVar.f4196b.equals(this.f4196b) && aniVar.f4197c.equals(this.f4197c)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((527 + this.f4195a.hashCode()) * 31) + this.f4196b.hashCode()) * 31) + this.f4197c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f4197c + "}";
    }
}
