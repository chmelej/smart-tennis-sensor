package p000;

import okio.ByteString;

/* JADX INFO: compiled from: Header.java */
/* JADX INFO: loaded from: classes.dex */
public final class aop {

    /* JADX INFO: renamed from: a */
    public static final ByteString f4390a = ByteString.encodeUtf8(":");

    /* JADX INFO: renamed from: b */
    public static final ByteString f4391b = ByteString.encodeUtf8(":status");

    /* JADX INFO: renamed from: c */
    public static final ByteString f4392c = ByteString.encodeUtf8(":method");

    /* JADX INFO: renamed from: d */
    public static final ByteString f4393d = ByteString.encodeUtf8(":path");

    /* JADX INFO: renamed from: e */
    public static final ByteString f4394e = ByteString.encodeUtf8(":scheme");

    /* JADX INFO: renamed from: f */
    public static final ByteString f4395f = ByteString.encodeUtf8(":authority");

    /* JADX INFO: renamed from: g */
    public final ByteString f4396g;

    /* JADX INFO: renamed from: h */
    public final ByteString f4397h;

    /* JADX INFO: renamed from: i */
    final int f4398i;

    public aop(String str, String str2) {
        this(ByteString.encodeUtf8(str), ByteString.encodeUtf8(str2));
    }

    public aop(ByteString byteString, String str) {
        this(byteString, ByteString.encodeUtf8(str));
    }

    public aop(ByteString byteString, ByteString byteString2) {
        this.f4396g = byteString;
        this.f4397h = byteString2;
        this.f4398i = byteString.size() + 32 + byteString2.size();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof aop)) {
            return false;
        }
        aop aopVar = (aop) obj;
        return this.f4396g.equals(aopVar.f4396g) && this.f4397h.equals(aopVar.f4397h);
    }

    public int hashCode() {
        return ((527 + this.f4396g.hashCode()) * 31) + this.f4397h.hashCode();
    }

    public String toString() {
        return anm.m4498a("%s: %s", this.f4396g.utf8(), this.f4397h.utf8());
    }
}
