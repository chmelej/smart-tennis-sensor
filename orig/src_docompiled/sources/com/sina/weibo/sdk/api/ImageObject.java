package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class ImageObject implements Parcelable {
    public static final Parcelable.Creator<ImageObject> CREATOR = new Parcelable.Creator<ImageObject>() { // from class: com.sina.weibo.sdk.api.ImageObject.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageObject createFromParcel(Parcel parcel) {
            return new ImageObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ImageObject[] newArray(int i) {
            return new ImageObject[i];
        }
    };

    /* JADX INFO: renamed from: c */
    private static final int f9107c = 2097152;

    /* JADX INFO: renamed from: a */
    public byte[] f9108a;

    /* JADX INFO: renamed from: b */
    public String f9109b;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ImageObject() {
    }

    public ImageObject(Parcel parcel) {
        this.f9108a = parcel.createByteArray();
        this.f9109b = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.f9108a);
        parcel.writeString(this.f9109b);
    }

    /* JADX INFO: renamed from: a */
    public boolean m8671a() {
        if (this.f9108a == null && this.f9109b == null) {
            new Throwable("imageData and imagePath are null").printStackTrace();
            return false;
        }
        if (this.f9108a != null && this.f9108a.length > f9107c) {
            new Throwable("imageData is too large").printStackTrace();
            return false;
        }
        if (this.f9109b != null && this.f9109b.length() > 512) {
            new Throwable("imagePath is too length").printStackTrace();
            return false;
        }
        if (this.f9109b == null) {
            return true;
        }
        try {
            File file = new File(this.f9109b);
            if (file.exists() && file.length() != 0 && file.length() <= 10485760) {
                return true;
            }
            new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
            return false;
        } catch (Throwable unused) {
            new Throwable("checkArgs fail, image content is too large or not exists").printStackTrace();
            return false;
        }
    }
}
