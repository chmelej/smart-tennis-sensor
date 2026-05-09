package androidx.versionedparcelable;

import android.os.Parcel;
import android.os.Parcelable;
import p000.C1790ia;
import p000.InterfaceC1791ib;

/* JADX INFO: loaded from: classes.dex */
public class ParcelImpl implements Parcelable {
    public static final Parcelable.Creator<ParcelImpl> CREATOR = new Parcelable.Creator<ParcelImpl>() { // from class: androidx.versionedparcelable.ParcelImpl.1
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl createFromParcel(Parcel parcel) {
            return new ParcelImpl(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public ParcelImpl[] newArray(int i) {
            return new ParcelImpl[i];
        }
    };

    /* JADX INFO: renamed from: a */
    private final InterfaceC1791ib f4149a;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    protected ParcelImpl(Parcel parcel) {
        this.f4149a = new C1790ia(parcel).m9766h();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        new C1790ia(parcel).m9745a(this.f4149a);
    }
}
