package com.sina.weibo.sdk.api;

import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: loaded from: classes.dex */
public class TextObject implements Parcelable {
    public static final Parcelable.Creator<TextObject> CREATOR = new Parcelable.Creator<TextObject>() { // from class: com.sina.weibo.sdk.api.TextObject.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextObject createFromParcel(Parcel parcel) {
            return new TextObject(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public TextObject[] newArray(int i) {
            return new TextObject[i];
        }
    };

    /* JADX INFO: renamed from: a */
    public String f9110a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public TextObject() {
    }

    public TextObject(Parcel parcel) {
        this.f9110a = parcel.readString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f9110a);
    }
}
