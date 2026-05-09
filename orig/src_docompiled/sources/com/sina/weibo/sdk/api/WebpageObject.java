package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class WebpageObject implements Parcelable {
    public static final Parcelable.Creator<WebpageObject> CREATOR = new Parcelable.Creator<WebpageObject>() { // from class: com.sina.weibo.sdk.api.WebpageObject.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebpageObject createFromParcel(Parcel parcel) {
            return new WebpageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public WebpageObject[] newArray(int i) {
            return new WebpageObject[i];
        }
    };

    /* JADX INFO: renamed from: a */
    public static final String f9111a = "extra_key_defaulttext";

    /* JADX INFO: renamed from: b */
    public String f9112b;

    /* JADX INFO: renamed from: c */
    public String f9113c;

    /* JADX INFO: renamed from: d */
    public String f9114d;

    /* JADX INFO: renamed from: e */
    public String f9115e;

    /* JADX INFO: renamed from: f */
    public String f9116f;

    /* JADX INFO: renamed from: g */
    public byte[] f9117g;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WebpageObject() {
    }

    public WebpageObject(Parcel parcel) {
        this.f9112b = parcel.readString();
        this.f9113c = parcel.readString();
        this.f9114d = parcel.readString();
        this.f9115e = parcel.readString();
        this.f9116f = parcel.readString();
        this.f9117g = parcel.createByteArray();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9112b);
        parcel.writeString(this.f9113c);
        parcel.writeString(this.f9114d);
        parcel.writeString(this.f9115e);
        parcel.writeString(this.f9116f);
        parcel.writeByteArray(this.f9117g);
    }
}
