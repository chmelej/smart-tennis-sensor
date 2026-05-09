package com.jmolsmobile.landscapevideocapture.configuration;

import android.os.Parcel;
import android.os.Parcelable;
import p000.C2039pw;

/* JADX INFO: loaded from: classes.dex */
public class CaptureConfiguration implements Parcelable {
    public static final Parcelable.Creator<CaptureConfiguration> CREATOR = new Parcelable.Creator<CaptureConfiguration>() { // from class: com.jmolsmobile.landscapevideocapture.configuration.CaptureConfiguration.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CaptureConfiguration createFromParcel(Parcel parcel) {
            return new CaptureConfiguration(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public CaptureConfiguration[] newArray(int i) {
            return new CaptureConfiguration[i];
        }
    };

    /* JADX INFO: renamed from: a */
    private int f8929a;

    /* JADX INFO: renamed from: b */
    private int f8930b;

    /* JADX INFO: renamed from: c */
    private int f8931c;

    /* JADX INFO: renamed from: d */
    private int f8932d;

    /* JADX INFO: renamed from: e */
    private int f8933e;

    /* JADX INFO: renamed from: f */
    private int f8934f;

    /* JADX INFO: renamed from: g */
    private int f8935g;

    /* JADX INFO: renamed from: h */
    private int f8936h;

    /* JADX INFO: renamed from: i */
    private int f8937i;

    /* JADX INFO: renamed from: j */
    private int f8938j;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CaptureConfiguration() {
        this.f8929a = 1280;
        this.f8930b = 720;
        this.f8931c = 5000000;
        this.f8932d = -1;
        this.f8933e = -1;
        this.f8934f = 2;
        this.f8935g = 0;
        this.f8936h = 3;
        this.f8937i = 1;
        this.f8938j = 2;
    }

    public CaptureConfiguration(C2039pw.b bVar, C2039pw.a aVar) {
        this.f8929a = 1280;
        this.f8930b = 720;
        this.f8931c = 5000000;
        this.f8932d = -1;
        this.f8933e = -1;
        this.f8934f = 2;
        this.f8935g = 0;
        this.f8936h = 3;
        this.f8937i = 1;
        this.f8938j = 2;
        this.f8929a = bVar.f12246g;
        this.f8930b = bVar.f12247h;
        this.f8931c = bVar.m11146a(aVar);
    }

    public CaptureConfiguration(C2039pw.b bVar, C2039pw.a aVar, int i, int i2) {
        this(bVar, aVar);
        this.f8932d = i * 1000;
        this.f8933e = i2 * 1048576;
    }

    /* JADX INFO: renamed from: a */
    public int m8397a() {
        return this.f8929a;
    }

    /* JADX INFO: renamed from: b */
    public int m8398b() {
        return this.f8930b;
    }

    /* JADX INFO: renamed from: c */
    public int m8399c() {
        return this.f8931c;
    }

    /* JADX INFO: renamed from: d */
    public int m8400d() {
        return this.f8932d;
    }

    /* JADX INFO: renamed from: e */
    public int m8401e() {
        return this.f8933e;
    }

    /* JADX INFO: renamed from: f */
    public int m8402f() {
        return this.f8934f;
    }

    /* JADX INFO: renamed from: g */
    public int m8403g() {
        return this.f8935g;
    }

    /* JADX INFO: renamed from: h */
    public int m8404h() {
        return this.f8936h;
    }

    /* JADX INFO: renamed from: i */
    public int m8405i() {
        return this.f8937i;
    }

    /* JADX INFO: renamed from: j */
    public int m8406j() {
        return this.f8938j;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f8929a);
        parcel.writeInt(this.f8930b);
        parcel.writeInt(this.f8931c);
        parcel.writeInt(this.f8932d);
        parcel.writeInt(this.f8933e);
        parcel.writeInt(this.f8934f);
        parcel.writeInt(this.f8935g);
        parcel.writeInt(this.f8936h);
        parcel.writeInt(this.f8937i);
        parcel.writeInt(this.f8938j);
    }

    private CaptureConfiguration(Parcel parcel) {
        this.f8929a = 1280;
        this.f8930b = 720;
        this.f8931c = 5000000;
        this.f8932d = -1;
        this.f8933e = -1;
        this.f8934f = 2;
        this.f8935g = 0;
        this.f8936h = 3;
        this.f8937i = 1;
        this.f8938j = 2;
        this.f8929a = parcel.readInt();
        this.f8930b = parcel.readInt();
        this.f8931c = parcel.readInt();
        this.f8932d = parcel.readInt();
        this.f8933e = parcel.readInt();
        this.f8934f = parcel.readInt();
        this.f8935g = parcel.readInt();
        this.f8936h = parcel.readInt();
        this.f8937i = parcel.readInt();
        this.f8938j = parcel.readInt();
    }
}
